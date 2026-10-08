"""Almacenamiento de dosis en un archivo JSON.

Este módulo no depende de Kivy, así se puede probar en un ordenador normal.
"""

import json
import os
import time
import uuid

BACKUP_VERSION = 1


class DoseStore:
    def __init__(self, path):
        self.path = path
        self.doses = []
        self.load()

    def load(self):
        if not os.path.exists(self.path):
            self.doses = []
            return
        with open(self.path, "r", encoding="utf-8") as f:
            data = json.load(f)
        self.doses = _validate_doses(data.get("doses", []))

    def save(self):
        os.makedirs(os.path.dirname(self.path) or ".", exist_ok=True)
        tmp = self.path + ".tmp"
        with open(tmp, "w", encoding="utf-8") as f:
            json.dump(self._to_json(), f, ensure_ascii=False, indent=2)
        os.replace(tmp, self.path)

    def add(self, substance, amount, unit, timestamp=None, note=""):
        substance = substance.strip()
        if not substance:
            raise ValueError("Falta el nombre de la sustancia.")
        amount = float(str(amount).replace(",", "."))
        if amount <= 0:
            raise ValueError("La cantidad debe ser mayor que 0.")
        dose = {
            "id": uuid.uuid4().hex,
            "substance": substance,
            "amount": amount,
            "unit": unit.strip() or "mg",
            "timestamp": float(timestamp if timestamp is not None else time.time()),
            "note": note.strip(),
        }
        self.doses.append(dose)
        self.save()
        return dose

    def delete(self, dose_id):
        before = len(self.doses)
        self.doses = [d for d in self.doses if d["id"] != dose_id]
        if len(self.doses) != before:
            self.save()
            return True
        return False

    def sorted_doses(self):
        return sorted(self.doses, key=lambda d: d["timestamp"], reverse=True)

    def summary(self, now=None, window_hours=24):
        """Por sustancia: última dosis y total en las últimas `window_hours` horas."""
        now = time.time() if now is None else now
        since = now - window_hours * 3600
        result = {}
        for d in self.doses:
            s = result.setdefault(
                d["substance"],
                {"last": 0.0, "total_window": 0.0, "unit": d["unit"]},
            )
            if d["timestamp"] > s["last"]:
                s["last"] = d["timestamp"]
                s["unit"] = d["unit"]
            if d["timestamp"] >= since and d["unit"] == s["unit"]:
                s["total_window"] += d["amount"]
        return result

    def export_backup(self, path):
        os.makedirs(os.path.dirname(path) or ".", exist_ok=True)
        with open(path, "w", encoding="utf-8") as f:
            json.dump(self._to_json(), f, ensure_ascii=False, indent=2)
        return path

    def import_backup(self, path):
        """Añade las dosis del archivo. Las dosis con el mismo id no se duplican."""
        with open(path, "r", encoding="utf-8") as f:
            data = json.load(f)
        incoming = _validate_doses(data.get("doses", []))
        known = {d["id"] for d in self.doses}
        added = [d for d in incoming if d["id"] not in known]
        self.doses.extend(added)
        self.save()
        return len(added)

    def _to_json(self):
        return {"version": BACKUP_VERSION, "doses": self.doses}


def _validate_doses(raw):
    doses = []
    for d in raw:
        try:
            doses.append(
                {
                    "id": str(d.get("id") or uuid.uuid4().hex),
                    "substance": str(d["substance"]),
                    "amount": float(d["amount"]),
                    "unit": str(d.get("unit", "mg")),
                    "timestamp": float(d["timestamp"]),
                    "note": str(d.get("note", "")),
                }
            )
        except (KeyError, TypeError, ValueError):
            continue
    return doses


def format_elapsed(seconds):
    seconds = max(0, int(seconds))
    hours, rest = divmod(seconds, 3600)
    minutes = rest // 60
    if hours >= 24:
        days, hours = divmod(hours, 24)
        return f"{days} d {hours} h"
    if hours:
        return f"{hours} h {minutes} min"
    return f"{minutes} min"


def format_amount(value):
    return f"{value:g}"

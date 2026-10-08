"""Dose en Python.

Versión en Python de la app Java original (sources/io/doseapp/android).
La app original era una ventana web (WebView) que mostraba
file:///android_asset/app/index.html y hablaba con Java mediante
WebAppInterface. Aquí la ventana web la pone python-for-android
(bootstrap "webview") y este programa en Python es el servidor local
que entrega la página y guarda los datos.

Correspondencia con el código Java:
- Constants.WEBAPP_HOST / WEBAPP_URL -> HOST, PORT y web/index.html
- MainActivity.saveBackup / alterDocument -> POST /api/export
- WebAppInterface.logEvent / share / getFCM -> POST /api/log, /api/share, GET /api/fcm
  (sin telemetría, igual que en la versión Java actual)
"""

import glob
import json
import mimetypes
import os
import re
import sys
import time
from datetime import datetime
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer

from dose_store import DoseStore, format_amount, format_elapsed

HOST = "127.0.0.1"
PORT = 5000  # Debe coincidir con p4a.port en buildozer.spec.
WEB_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)), "web")
MAX_BODY = 1024 * 1024


def is_android():
    return "ANDROID_ARGUMENT" in os.environ or hasattr(sys, "getandroidapilevel")


def data_dir():
    if os.environ.get("DOSE_DATA_DIR"):
        return os.environ["DOSE_DATA_DIR"]
    if is_android():
        try:
            from android.storage import app_storage_path

            return app_storage_path()
        except Exception:
            return os.environ.get("ANDROID_PRIVATE", os.getcwd())
    return os.path.join(os.path.expanduser("~"), ".dose")


def backup_dir():
    """Carpeta Download en Android; carpeta de datos en otros sistemas."""
    if os.environ.get("DOSE_BACKUP_DIR"):
        return os.environ["DOSE_BACKUP_DIR"]
    if is_android():
        try:
            from android.storage import primary_external_storage_path

            path = os.path.join(primary_external_storage_path(), "Download")
            os.makedirs(path, exist_ok=True)
            return path
        except Exception:
            pass
    return data_dir()


def request_android_permissions():
    if not is_android():
        return
    try:
        from android.permissions import Permission, request_permissions

        request_permissions([Permission.WRITE_EXTERNAL_STORAGE,
                             Permission.READ_EXTERNAL_STORAGE])
    except Exception:
        pass


def state_json(store, now=None):
    now = time.time() if now is None else now
    summary = []
    for substance, info in sorted(store.summary(now=now).items(), key=lambda kv: -kv[1]["last"]):
        summary.append({
            "substance": substance,
            "total": format_amount(info["total_window"]),
            "unit": info["unit"],
            "since": format_elapsed(now - info["last"]),
        })
    doses = []
    for d in store.sorted_doses():
        doses.append(dict(d,
                          when=datetime.fromtimestamp(d["timestamp"]).strftime("%d/%m/%Y %H:%M"),
                          amount_text=format_amount(d["amount"])))
    return {"summary": summary, "doses": doses}


def make_handler(store, backups):
    class Handler(BaseHTTPRequestHandler):
        def log_message(self, fmt, *args):
            print("[dose] " + fmt % args)

        def send_json(self, status, payload):
            body = json.dumps(payload, ensure_ascii=False).encode("utf-8")
            self.send_response(status)
            self.send_header("Content-Type", "application/json; charset=utf-8")
            self.send_header("Content-Length", str(len(body)))
            self.send_header("Cache-Control", "no-store")
            self.end_headers()
            self.wfile.write(body)

        def read_json(self):
            length = int(self.headers.get("Content-Length") or 0)
            if length > MAX_BODY:
                raise ValueError("Petición demasiado grande.")
            raw = self.rfile.read(length) if length else b"{}"
            data = json.loads(raw.decode("utf-8") or "{}")
            if not isinstance(data, dict):
                raise ValueError("Formato no válido.")
            return data

        def do_GET(self):
            path = self.path.split("?", 1)[0]
            if path == "/api/doses":
                return self.send_json(200, state_json(store))
            if path == "/api/fcm":
                return self.send_json(200, {"token": ""})
            self.serve_static(path)

        def do_POST(self):
            path = self.path.split("?", 1)[0]
            try:
                data = self.read_json()
            except ValueError as e:
                return self.send_json(400, {"error": str(e)})
            if path == "/api/doses":
                try:
                    store.add(str(data.get("substance", "")), data.get("amount", "0"),
                              str(data.get("unit", "mg")), note=str(data.get("note", "")))
                except ValueError as e:
                    return self.send_json(400, {"error": str(e)})
                return self.send_json(200, state_json(store))
            if path == "/api/export":
                name = f"dose-backup-{datetime.now().strftime('%Y%m%d-%H%M%S')}.json"
                try:
                    saved = store.export_backup(os.path.join(backups(), name))
                except OSError as e:
                    return self.send_json(500, {"error": str(e)})
                return self.send_json(200, {"path": saved})
            if path == "/api/import":
                folder = backups()
                files = sorted(glob.glob(os.path.join(folder, "dose-backup-*.json")))
                if not files:
                    return self.send_json(404, {
                        "error": f"No hay ningún archivo dose-backup-*.json en: {folder}"})
                try:
                    added = store.import_backup(files[-1])
                except (OSError, ValueError) as e:
                    return self.send_json(400, {"error": str(e)})
                result = state_json(store)
                result.update(added=added, file=os.path.basename(files[-1]))
                return self.send_json(200, result)
            if path in ("/api/log", "/api/share"):
                # Telemetría desactivada, como en WebAppInterface.java.
                return self.send_json(200, {"ok": True})
            self.send_json(404, {"error": "No encontrado."})

        def do_DELETE(self):
            match = re.fullmatch(r"/api/doses/([0-9a-zA-Z_-]+)", self.path.split("?", 1)[0])
            if not match:
                return self.send_json(404, {"error": "No encontrado."})
            if not store.delete(match.group(1)):
                return self.send_json(404, {"error": "Esa dosis no existe."})
            self.send_json(200, state_json(store))

        def serve_static(self, path):
            if path in ("", "/"):
                path = "/index.html"
            full = os.path.realpath(os.path.join(WEB_DIR, path.lstrip("/")))
            if not full.startswith(os.path.realpath(WEB_DIR) + os.sep) or not os.path.isfile(full):
                return self.send_json(404, {"error": "No encontrado."})
            with open(full, "rb") as f:
                body = f.read()
            ctype = mimetypes.guess_type(full)[0] or "application/octet-stream"
            if ctype.startswith("text/"):
                ctype += "; charset=utf-8"
            self.send_response(200)
            self.send_header("Content-Type", ctype)
            self.send_header("Content-Length", str(len(body)))
            self.end_headers()
            self.wfile.write(body)

    return Handler


def make_server(host=HOST, port=PORT, store=None, backups=backup_dir):
    store = store or DoseStore(os.path.join(data_dir(), "doses.json"))
    return ThreadingHTTPServer((host, port), make_handler(store, backups))


def main():
    request_android_permissions()
    server = make_server()
    print(f"[dose] Servidor en http://{HOST}:{PORT}/")
    server.serve_forever()


if __name__ == "__main__":
    main()

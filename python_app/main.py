"""Dose: registro de dosis, escrito en Python con Kivy."""

import glob
import os
import time
from datetime import datetime

from kivy.app import App
from kivy.clock import Clock
from kivy.core.window import Window
from kivy.metrics import dp
from kivy.uix.boxlayout import BoxLayout
from kivy.uix.button import Button
from kivy.uix.label import Label
from kivy.uix.popup import Popup
from kivy.uix.scrollview import ScrollView
from kivy.uix.textinput import TextInput
from kivy.utils import platform

from dose_store import DoseStore, format_amount, format_elapsed

BG = (0.06, 0.09, 0.16, 1)
CARD = (0.12, 0.16, 0.23, 1)
ACCENT = (0.13, 0.55, 0.38, 1)
DANGER = (0.6, 0.18, 0.18, 1)


def backup_dir(app):
    """Carpeta Download en Android; carpeta de datos de la app en otros sistemas."""
    if platform == "android":
        try:
            from android.storage import primary_external_storage_path

            path = os.path.join(primary_external_storage_path(), "Download")
            os.makedirs(path, exist_ok=True)
            return path
        except Exception:
            pass
    return app.user_data_dir


def wrapped_label(text, **kwargs):
    label = Label(text=text, halign="left", valign="middle", size_hint_y=None, **kwargs)
    label.bind(width=lambda lbl, w: setattr(lbl, "text_size", (w, None)))
    label.bind(texture_size=lambda lbl, ts: setattr(lbl, "height", max(dp(28), ts[1] + dp(8))))
    return label


class DoseLayout(BoxLayout):
    def __init__(self, app, **kwargs):
        super().__init__(orientation="vertical", padding=dp(12), spacing=dp(8), **kwargs)
        self.app = app
        self.store = app.store

        self.add_widget(Label(text="[b]Dose[/b]", markup=True, font_size="22sp",
                              size_hint_y=None, height=dp(40)))

        form = BoxLayout(size_hint_y=None, height=dp(48), spacing=dp(6))
        self.substance = TextInput(hint_text="Sustancia", multiline=False, size_hint_x=0.45)
        self.amount = TextInput(hint_text="Cantidad", multiline=False, input_filter="float",
                                size_hint_x=0.25)
        self.unit = TextInput(text="mg", multiline=False, size_hint_x=0.15)
        add = Button(text="Añadir", size_hint_x=0.15, background_color=ACCENT)
        add.bind(on_release=lambda *_: self.add_dose())
        for w in (self.substance, self.amount, self.unit, add):
            form.add_widget(w)
        self.add_widget(form)

        self.note = TextInput(hint_text="Nota (opcional)", multiline=False,
                              size_hint_y=None, height=dp(44))
        self.add_widget(self.note)

        self.add_widget(Label(text="Resumen (últimas 24 h)", size_hint_y=None, height=dp(28),
                              bold=True))
        self.summary_box = BoxLayout(orientation="vertical", size_hint_y=None, spacing=dp(2))
        self.summary_box.bind(minimum_height=self.summary_box.setter("height"))
        self.add_widget(self.summary_box)

        self.add_widget(Label(text="Historial", size_hint_y=None, height=dp(28), bold=True))
        scroll = ScrollView()
        self.list_box = BoxLayout(orientation="vertical", size_hint_y=None, spacing=dp(4))
        self.list_box.bind(minimum_height=self.list_box.setter("height"))
        scroll.add_widget(self.list_box)
        self.add_widget(scroll)

        actions = BoxLayout(size_hint_y=None, height=dp(48), spacing=dp(6))
        export_btn = Button(text="Exportar copia")
        export_btn.bind(on_release=lambda *_: self.export_backup())
        import_btn = Button(text="Importar copia")
        import_btn.bind(on_release=lambda *_: self.import_backup())
        actions.add_widget(export_btn)
        actions.add_widget(import_btn)
        self.add_widget(actions)

        self.refresh()
        # Actualiza el tiempo transcurrido cada minuto.
        Clock.schedule_interval(lambda *_: self.refresh(), 60)

    def add_dose(self):
        try:
            self.store.add(self.substance.text, self.amount.text or "0", self.unit.text,
                           note=self.note.text)
        except ValueError as e:
            self.show_message("No se pudo guardar", str(e))
            return
        self.amount.text = ""
        self.note.text = ""
        self.refresh()

    def refresh(self):
        now = time.time()
        self.summary_box.clear_widgets()
        summary = self.store.summary(now=now)
        if not summary:
            self.summary_box.add_widget(wrapped_label("Todavía no hay dosis."))
        for substance, info in sorted(summary.items(), key=lambda kv: -kv[1]["last"]):
            text = (f"{substance}: {format_amount(info['total_window'])} {info['unit']} "
                    f"· última hace {format_elapsed(now - info['last'])}")
            self.summary_box.add_widget(wrapped_label(text))

        self.list_box.clear_widgets()
        for dose in self.store.sorted_doses():
            self.list_box.add_widget(self.dose_row(dose))

    def dose_row(self, dose):
        row = BoxLayout(size_hint_y=None, height=dp(52), spacing=dp(6))
        when = datetime.fromtimestamp(dose["timestamp"]).strftime("%d/%m/%Y %H:%M")
        text = f"{when}  {dose['substance']} {format_amount(dose['amount'])} {dose['unit']}"
        if dose["note"]:
            text += f"\n{dose['note']}"
        label = Label(text=text, halign="left", valign="middle")
        label.bind(size=lambda lbl, s: setattr(lbl, "text_size", s))
        delete = Button(text="Borrar", size_hint_x=None, width=dp(80), background_color=DANGER)
        delete.bind(on_release=lambda *_: self.confirm_delete(dose))
        row.add_widget(label)
        row.add_widget(delete)
        return row

    def confirm_delete(self, dose):
        box = BoxLayout(orientation="vertical", spacing=dp(8), padding=dp(8))
        box.add_widget(wrapped_label(f"¿Borrar la dosis de {dose['substance']}?"))
        buttons = BoxLayout(size_hint_y=None, height=dp(44), spacing=dp(6))
        yes = Button(text="Sí, borrar", background_color=DANGER)
        no = Button(text="No")
        buttons.add_widget(yes)
        buttons.add_widget(no)
        box.add_widget(buttons)
        popup = Popup(title="Confirmar", content=box, size_hint=(0.85, None), height=dp(200))

        def do_delete(*_):
            self.store.delete(dose["id"])
            popup.dismiss()
            self.refresh()

        yes.bind(on_release=do_delete)
        no.bind(on_release=popup.dismiss)
        popup.open()

    def export_backup(self):
        name = f"dose-backup-{datetime.now().strftime('%Y%m%d-%H%M%S')}.json"
        try:
            path = self.store.export_backup(os.path.join(backup_dir(self.app), name))
        except OSError as e:
            self.show_message("Error al exportar", str(e))
            return
        self.show_message("Copia exportada", f"Archivo guardado en:\n{path}")

    def import_backup(self):
        folder = backup_dir(self.app)
        files = sorted(glob.glob(os.path.join(folder, "dose-backup-*.json")))
        if not files:
            self.show_message("Importar copia",
                              f"No hay ningún archivo dose-backup-*.json en:\n{folder}")
            return
        path = files[-1]
        try:
            added = self.store.import_backup(path)
        except (OSError, ValueError) as e:
            self.show_message("Error al importar", str(e))
            return
        self.refresh()
        self.show_message("Copia importada",
                          f"Archivo: {os.path.basename(path)}\nDosis nuevas añadidas: {added}")

    def show_message(self, title, text):
        box = BoxLayout(orientation="vertical", spacing=dp(8), padding=dp(8))
        box.add_widget(wrapped_label(text))
        ok = Button(text="Aceptar", size_hint_y=None, height=dp(44))
        box.add_widget(ok)
        popup = Popup(title=title, content=box, size_hint=(0.9, None), height=dp(260))
        ok.bind(on_release=popup.dismiss)
        popup.open()


class DoseApp(App):
    title = "Dose"

    def build(self):
        Window.clearcolor = BG
        if platform == "android":
            try:
                from android.permissions import Permission, request_permissions

                request_permissions([Permission.WRITE_EXTERNAL_STORAGE,
                                     Permission.READ_EXTERNAL_STORAGE])
            except Exception:
                pass
        self.store = DoseStore(os.path.join(self.user_data_dir, "doses.json"))
        return DoseLayout(self)


if __name__ == "__main__":
    DoseApp().run()

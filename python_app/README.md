# Dose en Python (Kivy)

App nueva escrita en Python con [Kivy](https://kivy.org). Sustituye a la app Java descompilada
que está en `sources/` y `resources/`.

## Qué hace

- Registrar una dosis: sustancia, cantidad, unidad y nota opcional. La fecha y hora se guardan solas.
- Resumen por sustancia: total de las últimas 24 horas y tiempo desde la última dosis.
- Historial con botón para borrar (pide confirmación).
- Exportar copia: crea `dose-backup-AAAAMMDD-HHMMSS.json` en la carpeta Download del teléfono.
- Importar copia: lee el archivo `dose-backup-*.json` más reciente de la carpeta Download.
  Las dosis repetidas no se duplican.

Todo funciona sin Internet. Los datos se guardan en el teléfono.

## Conseguir el APK

GitHub compila el APK automáticamente (archivo `.github/workflows/build-python-apk.yml`):

1. Abre la pestaña **Actions** del repositorio.
2. Abre la ejecución más reciente de **Compilar APK (Python / Kivy)**.
3. Descarga el archivo **dose-python-apk** (está al final de la página). Es un `.zip` con el `.apk` dentro.

## Compilar en tu ordenador (Linux)

```bash
pip install buildozer cython
cd python_app
buildozer android debug     # el APK queda en python_app/bin/
```

## Probar en el ordenador

```bash
pip install kivy
cd python_app
python main.py                          # abre la app en una ventana
python -m unittest discover -s tests    # pruebas
```

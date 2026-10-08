# Dose en Python

Versión en Python de la app Java que está en `sources/` y `resources/`.

## Qué se ha pasado a Python

El repositorio tiene 2218 archivos Java. Solo 8 son de la app Dose (`sources/io/doseapp/android/`).
Los demás son librerías de Google, Firebase y AndroidX. Esas librerías no se pasan a Python:
Android ya trae la ventana web, y la telemetría de Firebase ya estaba desactivada.

| Java original | Python |
|---|---|
| `MainActivity` (ventana web que carga la página local) | bootstrap `webview` de python-for-android + `main.py` |
| `Constants.WEBAPP_HOST`, `WEBAPP_URL` | `HOST`, `PORT` en `main.py`, página `web/index.html` |
| `MainActivity.saveBackup` / `alterDocument` | `POST /api/export` (guarda el archivo en Download) |
| `WebAppInterface.logEvent`, `share`, `getFCM` | `/api/log`, `/api/share`, `/api/fcm` (sin telemetría) |
| `resources/assets/app/index.html` | `web/index.html` |
| `UIManager` (pantalla sin conexión, barra de carga) | no hace falta: todo es local |
| `RateThisApp`, Firebase, Google Play Services | quitado |

Además, la página ya hace algo útil (antes estaba casi vacía):

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
2. Abre la ejecución más reciente de **Compilar APK (Python)**.
3. Descarga el archivo **dose-python-apk** (está al final de la página). Es un `.zip` con el `.apk` dentro.

## Compilar en tu ordenador (Linux)

```bash
pip install buildozer cython
cd python_app
buildozer android debug     # el APK queda en python_app/bin/
```

## Probar en el ordenador

```bash
cd python_app
python main.py                          # abre http://127.0.0.1:5000/ en el navegador
python -m unittest discover -s tests    # pruebas
```

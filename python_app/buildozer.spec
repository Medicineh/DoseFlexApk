[app]
title = Dose
package.name = dosepy
package.domain = io.doseapp
source.dir = .
source.include_exts = py,html,css,js,png,json
source.exclude_dirs = tests,bin,.buildozer
version = 1.0.0
requirements = python3
orientation = portrait
fullscreen = 0
android.permissions = INTERNET,WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE
android.api = 34
android.minapi = 24
android.archs = arm64-v8a, armeabi-v7a
android.accept_sdk_license = True
android.allow_backup = True
# Igual que la app Java: una ventana web que muestra la página local.
# El servidor local es main.py y escucha en este puerto.
p4a.bootstrap = webview
p4a.port = 5000

[buildozer]
log_level = 2
warn_on_root = 0

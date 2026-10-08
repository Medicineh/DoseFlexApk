[app]
title = Dose
package.name = dosepy
package.domain = io.doseapp
source.dir = .
source.include_exts = py,png,jpg,kv,json
source.exclude_dirs = tests,bin,.buildozer
version = 1.0.0
requirements = python3,kivy==2.3.1
orientation = portrait
fullscreen = 0
android.permissions = WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE
android.api = 34
android.minapi = 24
android.archs = arm64-v8a, armeabi-v7a
android.accept_sdk_license = True
android.allow_backup = True

[buildozer]
log_level = 2
warn_on_root = 0

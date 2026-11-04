#!/usr/bin/env bash
# Compare the installed helper of the reconstruction with the original one.
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
S=123.57.254.92:51213

echo "=== the installed base.apk of both helpers"
adb -s $S shell "ls -l /data/app/com.wrw*/base.apk /data/app/com.utnciuwv*/base.apk" 2>&1 | tr -d '\r'
echo "=== their sha256"
adb -s $S shell "sha256sum /data/app/com.wrw*/base.apk /data/app/com.utnciuwv*/base.apk" 2>&1 | tr -d '\r'
echo "=== our dex in the installed helper"
adb -s $S shell "unzip -p /data/app/com.wrw*/base.apk classes.dex | md5sum" 2>&1 | tr -d '\r'
echo "=== the dex of the local release apk"
md5sum "$ROOT/build/relcheck/classes.dex"
echo "=== the preferences of the original helper"
adb -s $S shell "su -c 'cat /data/user/0/com.utnciuwv.ldcsra/shared_prefs/com.utnciuwv.ldcsra_preferences.xml'" 2>&1 | tr -d '\r' | head -40
echo "=== the preferences of our helper"
adb -s $S shell "su -c 'cat /data/user/0/com.wrw/shared_prefs/com.wrw_preferences.xml'" 2>&1 | tr -d '\r' | head -40
echo "=== done"

#!/usr/bin/env bash
# Capture the value search dialog of the given package.
#
#   tools/capture_search_dialog.sh <package> <out.png>
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}
OUT=${2:-$ROOT/build/dlg_$PKG.png}

adb shell am force-stop com.fqqvbgr >/dev/null 2>&1
adb shell am force-stop com.utnciuwv.ldcsra >/dev/null 2>&1
sleep 2
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
adb shell input tap 668 1232 >/dev/null 2>&1
sleep 7
adb shell input tap 48 104 >/dev/null 2>&1
sleep 4
adb shell input tap 495 254 >/dev/null 2>&1
sleep 4
adb shell screencap -p /sdcard/dlg_now.png >/dev/null 2>&1
adb pull /sdcard/dlg_now.png "$OUT" >/dev/null 2>&1
adb shell uiautomator dump /sdcard/dlg_now.xml >/dev/null 2>&1
adb pull /sdcard/dlg_now.xml "$ROOT/build/dlg_$PKG.xml" >/dev/null 2>&1
echo "screenshot: $OUT"
python3 "$ROOT/tools/uix.py" "$ROOT/build/dlg_$PKG.xml" | head -12
exit 0

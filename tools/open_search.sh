#!/usr/bin/env bash
# Open the number search dialog of the given GameGuardian package and store
# a screenshot of it.
#
#   tools/open_search.sh <package> <out.png>
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}
OUT=${2:-$ROOT/build/search_$PKG.png}

adb shell am force-stop "$PKG" >/dev/null 2>&1
sleep 2
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
adb shell input tap 668 1232 >/dev/null 2>&1
sleep 7
adb shell input tap 48 104 >/dev/null 2>&1
sleep 4

# the value search dialog is opened from the "known (exact) search" entry of
# the "more" menu of the floating panel
adb shell input tap 675 254 >/dev/null 2>&1
sleep 3
adb shell input tap 360 248 >/dev/null 2>&1
sleep 4

adb shell screencap -p /sdcard/search_now.png >/dev/null 2>&1
adb pull /sdcard/search_now.png "$OUT" >/dev/null 2>&1
adb shell uiautomator dump /sdcard/ui_now.xml >/dev/null 2>&1
adb pull /sdcard/ui_now.xml "$ROOT/build/ui_search_$PKG.xml" >/dev/null 2>&1
echo "screenshot: $OUT"
python3 "$ROOT/tools/uix.py" "$ROOT/build/ui_search_$PKG.xml" | head -14
exit 0

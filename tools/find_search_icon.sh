#!/usr/bin/env bash
# Find the toolbar icon that opens the number search dialog of the running
# GameGuardian by tapping every icon of the search toolbar and looking for
# an EditText in the view hierarchy.
#
#   tools/find_search_icon.sh [package]
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}

adb shell am force-stop "$PKG" >/dev/null 2>&1
sleep 2
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
adb shell input tap 668 1232 >/dev/null 2>&1
sleep 7
adb shell input tap 48 104 >/dev/null 2>&1
sleep 4

for x in 45 135 225 315 405 495 585; do
    adb shell input tap "$x" 254 >/dev/null 2>&1
    sleep 3
    adb shell uiautomator dump /sdcard/probe.xml >/dev/null 2>&1
    adb pull /sdcard/probe.xml "$ROOT/build/probe.xml" >/dev/null 2>&1
    n=$(grep -ac 'EditText' "$ROOT/build/probe.xml")
    echo "    icon x=$x -> EditText nodes: $n"
    if [ "$n" != "0" ]; then
        adb shell screencap -p /sdcard/search_now.png >/dev/null 2>&1
        adb pull /sdcard/search_now.png "$ROOT/build/search_$PKG.png" >/dev/null 2>&1
        python3 "$ROOT/tools/uix.py" "$ROOT/build/probe.xml" | head -16
        echo "    (screenshot: build/search_$PKG.png)"
        break
    fi
    adb shell input keyevent KEYCODE_BACK >/dev/null 2>&1
    sleep 2
done
exit 0

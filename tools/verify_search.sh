#!/usr/bin/env bash
# End to end check of the value search on a real device:
#
#   1. open the floating panel and the "search known value" dialog through
#      the panel button (no debug hook, this is the shipped code path)
#   2. enter a value, pick a type and start the search
#   3. print the daemon log lines of the run
#
#   tools/verify_search.sh [value] [type text]
#
# The panel is a column of round buttons in the top left corner of the
# screen; the first one is the magnifier of the "search known value"
# action (the same position the original 101.4 uses).
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
VALUE="${1:-777}"
TYPE="${2:-D: Dword}"

tap_text() { bash "$ROOT/tools/tap_text.sh" "$1" 3 >/dev/null 2>&1; }

echo "==> open the panel and the value search dialog"
adb shell input keyevent KEYCODE_HOME >/dev/null 2>&1
sleep 3
adb shell input tap 67 57 >/dev/null 2>&1      # panel: search known value
sleep 5
adb shell uiautomator dump /sdcard/verify.xml >/dev/null 2>&1
adb pull /sdcard/verify.xml "$ROOT/build/verify.xml" >/dev/null 2>&1
python3 "$ROOT/tools/uix.py" "$ROOT/build/verify.xml" | head -6

echo "==> enter $VALUE"
adb shell input tap 385 241 >/dev/null 2>&1
sleep 2
adb shell input keyevent KEYCODE_MOVE_END >/dev/null 2>&1
for _ in $(seq 1 16); do adb shell input keyevent KEYCODE_DEL >/dev/null 2>&1; done
adb shell input text "$VALUE" >/dev/null 2>&1
sleep 2

echo "==> pick the type $TYPE"
adb shell input tap 402 338 >/dev/null 2>&1
sleep 3
for _ in 1 2 3; do
    tap_text "$TYPE" && break
    adb shell input swipe 360 300 360 700 300 >/dev/null 2>&1
    sleep 2
done
sleep 2

echo "==> run the search"
adb logcat -c >/dev/null 2>&1
tap_text "新搜索"
sleep 10
adb logcat -d -v time 2>/dev/null | grep -a -E 'sendSearchNumber|searchNumber|searchDone' | tail -4

#!/usr/bin/env bash
# Drive the floating panel to the value-search dialog, take a screenshot of
# every step and dump the view hierarchy, so the reconstruction can be
# compared with the original APK screen by screen.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
OUT="${1:-$ROOT/build/probe}"
mkdir -p "$OUT"
VALUE="${GG_VALUE:-12345}"

dump() {
    local name="$1"
    adb shell uiautomator dump /sdcard/probe.xml >/dev/null 2>&1
    adb pull /sdcard/probe.xml "$OUT/$name.xml" >/dev/null 2>&1
    adb shell screencap -p "/sdcard/$name.png" >/dev/null 2>&1
    adb pull "/sdcard/$name.png" "$OUT/$name.png" >/dev/null 2>&1
    echo "--- $name"
    python3 "$ROOT/tools/uix.py" "$OUT/$name.xml" | head -20
}

echo "==> open the floating window"
adb shell input tap 48 104
sleep 3
dump panel

echo "==> open the value search dialog"
adb shell input tap 495 254
sleep 3
dump dialog

echo "==> type the value"
adb shell input tap 385 241
sleep 1
adb shell input text "$VALUE"
sleep 1
dump value

echo "==> start the search (opens the type request when the type is unknown)"
adb shell input tap 598 1173
sleep 3
dump typerq

echo "==> pick 'A: Auto'"
adb shell input tap 360 316
sleep 2
dump auto

echo "==> wait for the search to finish"
sleep 10
adb shell input tap 472 1173
sleep 3
dump results

echo "==> search log"
adb logcat -d 2>/dev/null | grep -a -E 'sendSearchNumber|searchNumber|searchDone' | tail -6

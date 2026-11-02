#!/usr/bin/env bash
# Tap every icon of the GameGuardian floating panel one after the other and
# record what each of them opens.  Used to find the entry points of the value
# search dialog without guessing the icon order.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
OUT="${1:-$ROOT/build/panel_icons}"
mkdir -p "$OUT"
X="${GG_ICON_X:-50}"

for y in $(seq "${GG_ICON_FROM:-195}" "${GG_ICON_STEP:-14}" "${GG_ICON_TO:-330}"); do
    adb shell input tap "$X" "$y" >/dev/null 2>&1
    sleep 2
    adb shell uiautomator dump "/sdcard/pi_$y.xml" >/dev/null 2>&1
    adb pull "/sdcard/pi_$y.xml" "$OUT/$y.xml" >/dev/null 2>&1
    adb shell screencap -p "/sdcard/pi_$y.png" >/dev/null 2>&1
    adb pull "/sdcard/pi_$y.png" "$OUT/$y.png" >/dev/null 2>&1
    echo "=== icon y=$y"
    python3 "$ROOT/tools/uix.py" "$OUT/$y.xml" 2>/dev/null | head -6
    # close the dialog if one opened
    adb shell input keyevent 4 >/dev/null 2>&1
    sleep 1
done

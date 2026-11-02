#!/usr/bin/env bash
# Tap the icons of the expanded floating panel one by one and write down
# which dialog every icon opens.  The panel can be re-opened by tapping the
# collapsed strip, so the script re-opens it before every attempt.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
OUT="${1:-$ROOT/build/panel_icons2}"
mkdir -p "$OUT"
X="${GG_ICON_X:-49}"

for y in $(seq "${GG_FROM:-260}" "${GG_STEP:-12}" "${GG_TO:-620}"); do
    adb shell input tap "$X" "$y" >/dev/null 2>&1
    sleep 2
    adb shell uiautomator dump "/sdcard/p2_$y.xml" >/dev/null 2>&1
    adb pull "/sdcard/p2_$y.xml" "$OUT/$y.xml" >/dev/null 2>&1
    echo "=== icon y=$y"
    python3 "$ROOT/tools/uix.py" "$OUT/$y.xml" 2>/dev/null | head -4
    adb shell input keyevent 4 >/dev/null 2>&1
    sleep 1
done
echo DONE

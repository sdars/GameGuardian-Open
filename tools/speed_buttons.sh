#!/usr/bin/env bash
# Open the floating panel of the running GameGuardian, tap the speedometer
# in the toolbar and capture the floating icon right afterwards - that is where
# the speed_inc / speed_dec buttons have to show up.
#
#   tools/speed_buttons.sh <tag>
set -uo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
TAG="${1:-cur}"

adb_() {
    for _ in 1 2 3 4 5; do
        if adb "$@" 2>/dev/null; then
            return 0
        fi
        sleep 1
    done
    return 1
}

echo "==> open the panel"
adb_ shell input tap 48 104
sleep 3
for _ in 1 2 3; do
    adb_ shell uiautomator dump /sdcard/sb.xml >/dev/null 2>&1
    adb_ pull /sdcard/sb.xml "$ROOT/build/sb.xml" >/dev/null 2>&1
    if grep -aq "toolbar_row" "$ROOT/build/sb.xml"; then
        break
    fi
    adb_ shell input keyevent KEYCODE_BACK
    sleep 3
done
grep -aq "toolbar_row" "$ROOT/build/sb.xml" || { echo "!! no panel" >&2; exit 1; }
echo "    the panel is open"

echo "==> tap the speedometer"
adb_ shell input tap 405 254
sleep 3

adb_ shell screencap -p /sdcard/sb_$TAG.png
adb_ pull /sdcard/sb_$TAG.png "$ROOT/build/logs/sb_$TAG.png" >/dev/null 2>&1
echo "    build/logs/sb_$TAG.png"

echo "==> overlay windows"
adb_ shell dumpsys window windows | grep -a -A2 "ty=APPLICATION_OVERLAY" | grep -aE "mAttrs|Requested"

echo "==> icon area"
python3 "$ROOT/tools/ascii_region.py" "$ROOT/build/logs/sb_$TAG.png" 0,20,320,140 4

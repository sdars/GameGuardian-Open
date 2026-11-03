#!/usr/bin/env bash
# Check the speed hack entry point of the running GameGuardian (ours or the
# original): open the floating panel, tap the speedometer in the toolbar and
# report what the window manager sees afterwards.
#
#   tools/speed_probe.sh <tag>
#
# The tag is used for the file names under build/logs.
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
    adb_ shell uiautomator dump /sdcard/sp_probe.xml >/dev/null 2>&1
    adb_ pull /sdcard/sp_probe.xml "$ROOT/build/sp_probe.xml" >/dev/null 2>&1
    if grep -aq "toolbar_row" "$ROOT/build/sp_probe.xml"; then
        break
    fi
    echo "    (the panel is not open yet - closing the dialog)"
    adb_ shell input keyevent KEYCODE_BACK
    sleep 3
done
if ! grep -aq "toolbar_row" "$ROOT/build/sp_probe.xml"; then
    echo "!! the panel did not open" >&2
    exit 1
fi
echo "    the panel is open"

echo "==> tap the speedometer (405,254)"
adb_ logcat -c
adb_ shell input tap 405 254
sleep 5

echo "==> bring the floating icon back (48,104)"
adb_ shell input tap 48 104
sleep 4
adb_ shell input keyevent KEYCODE_BACK
sleep 3

echo "==> overlay windows"
adb_ shell dumpsys window windows | grep -a -A2 "ty=APPLICATION_OVERLAY"

echo "==> screenshot"
adb_ shell screencap -p /sdcard/sp_$TAG.png
adb_ pull /sdcard/sp_$TAG.png "$ROOT/build/logs/sp_$TAG.png" >/dev/null 2>&1
echo "    build/logs/sp_$TAG.png"

echo "==> speed icons in the screenshot"
python3 "$ROOT/tools/find_speed_icons.py" "$ROOT/build/logs/sp_$TAG.png" \
    "$ROOT/app/src/main/res/drawable-xxhdpi/ic_fast_forward_white_48dp.png" \
    "$ROOT/app/src/main/res/drawable-xxhdpi/ic_rewind_white_48dp.png" \
    0,0,460,260

echo "==> app log"
adb_ logcat -d -v time | grep -aE "AndroidService|android-daemon" | grep -avE "SP NU" | tail -20

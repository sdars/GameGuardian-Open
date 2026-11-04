#!/usr/bin/env bash
# Drive the speed hack of the running GameGuardian and report what the daemon
# answers.  The panel is opened, the speedometer of the toolbar is tapped and
# the fast forward button of the floating icon is pressed afterwards.
#
#   tools/speed_action.sh <tag> [x] [y]
#
# The tag is used for the file names under build/logs.
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
TAG="${1:-cur}"
FX="${2:-334}"
FY="${3:-98}"
LOG="$ROOT/build/logs"
mkdir -p "$LOG"

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
    adb_ shell uiautomator dump /sdcard/sa.xml >/dev/null 2>&1
    adb_ pull /sdcard/sa.xml "$ROOT/build/sa.xml" >/dev/null 2>&1
    if grep -aq "toolbar_row" "$ROOT/build/sa.xml"; then
        break
    fi
    adb_ shell input keyevent KEYCODE_BACK
    sleep 3
done
grep -aq "toolbar_row" "$ROOT/build/sa.xml" || { echo "!! no panel" >&2; exit 1; }
echo "    the panel is open"

echo "==> tap the speedometer (405,254)"
adb_ logcat -c
adb_ shell input tap 405 254
sleep 4

echo "==> bring the floating icon back (48,104)"
adb_ shell input tap 48 104
sleep 3
adb_ shell screencap -p /sdcard/sa_$TAG.png
adb_ pull /sdcard/sa_$TAG.png "$LOG/sa_$TAG.png" >/dev/null 2>&1

echo "==> the icon area before the tap"
python3 "$ROOT/tools/ascii_region.py" "$LOG/sa_$TAG.png" 180,60,400,140 4 | head -30

echo "==> tap the fast forward button ($FX,$FY)"
adb_ shell input tap "$FX" "$FY"
sleep 6

adb_ shell screencap -p /sdcard/sa2_$TAG.png
adb_ pull /sdcard/sa2_$TAG.png "$LOG/sa2_$TAG.png" >/dev/null 2>&1
echo "    build/logs/sa2_$TAG.png"

echo "==> the daemon and the app log"
adb_ logcat -d -v time 2>/dev/null \
    | grep -aE "AndroidService|android-daemon" \
    | grep -avE "SP NU|Kbd:|dbg2:|getRunningAppProcesses|getResized" | tail -25

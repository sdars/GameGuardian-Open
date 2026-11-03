#!/usr/bin/env bash
# Drive the reconstructed GameGuardian (or the original that is installed on
# the device) to the point where a lua script is executed against an attached
# target process.  The script prints the speed before/after gg.setSpeed(), so
# the logcat of the run is a direct A/B of the speedhack implementation.
#
#   tools/speed_ab_run.sh <package> [pid] [script]
#
#   package  the installed package of the app that shall be driven
#   pid      the pid of the target process that shall be attached
#   script   the lua file that is executed
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}
PID=${2:-2424}
SCRIPT=${3:-com.gg.abitest.lua}
LOG=$ROOT/build/logs
mkdir -p "$LOG"

dump() {
    adb shell uiautomator dump /sdcard/ui_now.xml >/dev/null 2>&1
    adb pull /sdcard/ui_now.xml "$ROOT/build/ui_now.xml" >/dev/null 2>&1
    python3 "$ROOT/tools/uix.py" "$ROOT/build/ui_now.xml"
}

# tap the widget whose text is exactly $1 (the ui dump can be passed in $2)
tap_exact() {
    local line
    local ui=${2:-}
    [ -z "$ui" ] && ui=$(dump)
    line=$(printf '%s' "$ui" | awk -v w="$1" 'index($0, w) == 1 && substr($0, length(w) + 1, 1) == " " { print; exit }')
    [ -z "$line" ] && return 1
    local coord
    coord=$(printf '%s' "$line" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
    [ -z "$coord" ] && return 1
    echo "    tap '$1' at $coord"
    adb shell input tap $coord
    return 0
}

echo '==> start the app'
adb shell am force-stop "$PKG" >/dev/null 2>&1
adb logcat -c >/dev/null 2>&1
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9

echo '==> answer the dialogs and open the floating panel'
for _ in $(seq 1 12); do
    UI=$(dump)
    if printf '%s' "$UI" | grep -aq "\[$PID\]"; then
        echo '    the process list is open'
        break
    fi
    if printf '%s' "$UI" | grep -aq 'id/more_btn'; then
        echo '    the panel is open'
        break
    fi
    for t in '=Root' '=重启' '忽略' '=开始' '开始' '确定' '默认'; do
        if tap_exact "$t" "$UI"; then
            sleep 5
            break
        fi
    done
    # the floating icon is a 96x96 window in the top left corner, its centre
    # depends on where the panel was left - try both positions
    adb shell input tap 48 72
    sleep 2
    adb shell input tap 48 104
    sleep 3
done

echo '==> select the target process'
for _ in 1 2 3 4; do
    if dump | grep -aq "\[$PID\]"; then
        break
    fi
    adb shell input swipe 360 1000 360 400 400
    sleep 2
done
LINE=$(dump | grep -aF "[$PID]" | head -1)
echo "    $LINE"
if [ -z "$LINE" ]; then
    echo "!! the process $PID is not in the list" >&2
    exit 1
fi
COORD=$(printf '%s' "$LINE" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
adb shell input tap $COORD
sleep 8

echo '==> more menu -> execute script'
adb shell input tap 675 254
sleep 3
LINE=$(dump | grep -a '执行脚本' | head -1)
echo "    $LINE"
COORD=$(printf '%s' "$LINE" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
adb shell input tap $COORD
sleep 4

echo '==> script dialog'
dump | head -14

echo '==> run'
adb logcat -c >/dev/null 2>&1
LINE=$(dump | grep -aE '^执行 ' | head -1)
if [ -z "$LINE" ]; then
    LINE=$(dump | grep -a '执行' | tail -1)
fi
echo "    $LINE"
COORD=$(printf '%s' "$LINE" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
adb shell input tap $COORD
sleep 10

echo '==> result'
adb logcat -d -v time 2>/dev/null | grep -aE 'AndroidService|android-daemon' \
    | grep -avE 'SP NU|checkContrast' | tail -30 | tee "$LOG/speed_$PKG.log"
exit 0

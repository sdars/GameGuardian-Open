#!/usr/bin/env bash
# Attach GameGuardian to a process by its pid.
#
#   tools/attach_pid.sh <pid>
#
# The process list of the floating panel is a scrolling dialog.  The 32 bit
# processes carry no [x64] tag, so they are found by their pid.  The list is
# scrolled one screen at a time until the pid shows up.
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PID=${1:?usage: attach_pid.sh <pid>}
XML=$ROOT/build/attach_pid.xml

dump() {
    adb shell uiautomator dump /sdcard/attach_pid.xml >/dev/null 2>&1
    adb pull /sdcard/attach_pid.xml "$XML" >/dev/null 2>&1
    [ -s "$XML" ] || return 1
    python3 "$ROOT/tools/uix.py" "$XML"
}

for _ in $(seq 1 14); do
    UI=$(dump) || { sleep 2; continue; }
    line=$(printf '%s' "$UI" | grep -aF "[$PID]" | head -1)
    if [ -n "$line" ]; then
        echo "    -> $line"
        coord=$(printf '%s' "$line" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
        set -- $coord
        adb shell input tap "$1" "$2"
        sleep 6
        echo '==> attach result'
        adb logcat -d -v time 2>/dev/null | grep -aE 'used: ProcessInfo|DI: |InOut:|RegionList' | tail -8
        exit 0
    fi
    adb shell input swipe 360 1000 360 400 400 >/dev/null 2>&1
    sleep 2
done
echo "!! the pid $PID is not in the list" >&2
exit 1

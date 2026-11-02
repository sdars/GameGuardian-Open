#!/usr/bin/env bash
# Open the "search known value" dialog on a live device, pick one entry from
# the type list, run the search and print the daemon log lines of the run.
#
#   tools/probe_type.sh "D: Dword" [value]
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
TYPE="${1:?usage: probe_type.sh <type text> [value]}"
VALUE="${2:-}"

open_dialog() {
    adb shell input keyevent KEYCODE_HOME >/dev/null 2>&1
    sleep 3
    adb shell input tap 67 57 >/dev/null 2>&1      # panel: select process
    sleep 4
    adb shell input tap 360 217 >/dev/null 2>&1    # Trebuchet
    sleep 8
}

tap_text() { bash "$ROOT/tools/tap_text.sh" "$1" 3 >/dev/null 2>&1; }

tap_text "确定" && sleep 2        # dismiss a possible range error dialog
open_dialog

if [ -n "$VALUE" ]; then
    adb shell input tap 385 233 >/dev/null 2>&1
    sleep 2
    adb shell input keyevent KEYCODE_MOVE_END >/dev/null 2>&1
    for _ in $(seq 1 16); do adb shell input keyevent KEYCODE_DEL >/dev/null 2>&1; done
    adb shell input text "$VALUE" >/dev/null 2>&1
    sleep 2
fi

adb shell input tap 402 337 >/dev/null 2>&1       # type button
sleep 3

for attempt in 1 2 3; do
    if tap_text "$TYPE"; then
        break
    fi
    adb shell input swipe 360 200 360 900 400 >/dev/null 2>&1
    sleep 2
done
sleep 2

adb logcat -c >/dev/null 2>&1
tap_text "新搜索"                                 # start the search
sleep 8
adb logcat -d -v time 2>/dev/null | grep -a -E 'sendSearchNumber|searchNumber|searchDone' | tail -4

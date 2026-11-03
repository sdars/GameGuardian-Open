#!/usr/bin/env bash
# Run one value search on the running device and print the daemon log of the
# run.  The search dialog is opened through the shipped menu of the floating
# panel (more button -> "known (exact) search"), so no debug hook is needed.
#
#   tools/probe_search_shipped.sh [value] [type]
#
# type : the text of the entry in the type list, e.g. "A: Auto" or "D: Dword"
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
VALUE="${1:-777}"
TYPE="${2:-}"
LOG="$ROOT/build/logs/daemon_$(date +%H%M%S).log"
mkdir -p "$ROOT/build/logs"

(setsid nohup adb logcat -v time > "$LOG" 2>&1 &)
sleep 2

tap_text() { bash "$ROOT/tools/tap_text.sh" "$1" 3 >/dev/null 2>&1; }

echo "==> open the search dialog (more menu -> known (exact) search)"
adb shell input tap 48 104 >/dev/null 2>&1       # floating gg icon -> full dialog
sleep 3
adb shell input tap 294 104 >/dev/null 2>&1      # search tab
sleep 2
adb shell input tap 675 254 >/dev/null 2>&1      # more_btn of the search toolbar
sleep 3
tap_text "已知（精确）搜索" || tap_text "已知"
sleep 4

echo "==> value $VALUE"
adb shell input tap 385 233 >/dev/null 2>&1      # value field
sleep 2
adb shell input keyevent KEYCODE_MOVE_END >/dev/null 2>&1
for _ in $(seq 1 16); do adb shell input keyevent KEYCODE_DEL >/dev/null 2>&1; done
adb shell input text "$VALUE" >/dev/null 2>&1
sleep 2

if [ -n "$TYPE" ]; then
    echo "==> type $TYPE"
    adb shell input tap 400 337 >/dev/null 2>&1   # type button
    sleep 3
    for _ in 1 2 3 4; do
        if tap_text "$TYPE"; then break; fi
        adb shell input swipe 360 300 360 700 300 >/dev/null 2>&1
        sleep 2
    done
    sleep 2
fi

echo "==> start the search"
adb logcat -c >/dev/null 2>&1
tap_text "新搜索"
sleep 12

echo "==> daemon log"
grep -a -E 'sendSearchNumber|searchNumber:|searchDone|::search' "$LOG" | tail -6
echo "==> log file: $LOG"

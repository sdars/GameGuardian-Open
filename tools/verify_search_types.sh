#!/usr/bin/env bash
# Run one value search on the attached target and print what the daemon
# answered plus the type tags of the result rows.
#
#   tools/verify_search_types.sh "<type entry>" "<value>"
#   tools/verify_search_types.sh "D: Dword" "777"
#
# The search is started from the shipped menu of the floating panel
# (more -> "known (exact) search"), the type is picked from the type list of
# the dialog and the value is typed into the dialog value field.
set -uo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
TYPE="${1:?usage: verify_search_types.sh <type entry> <value>}"
VALUE="${2:-}"
XML="$ROOT/build/vst.xml"

dump() {
    adb shell uiautomator dump /sdcard/vst.xml >/dev/null 2>&1
    adb pull /sdcard/vst.xml "$XML" >/dev/null 2>&1
}

# find_text <text> -> "x y" of the widget whose text contains <text>
find_text() {
    python3 "$ROOT/tools/uix.py" "$XML" 2>/dev/null | grep -F "$1" | head -1 \
        | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p'
}

tap_text() {
    local c
    c="$(find_text "$1")"
    [ -n "$c" ] || return 1
    # shellcheck disable=SC2086
    adb shell input tap $c >/dev/null 2>&1
    echo "    tap '$1' at $c"
    return 0
}

echo "==> open the search dialog (more -> known (exact) search)"
adb shell input tap 48 104 >/dev/null 2>&1      # floating icon
sleep 3
adb shell input keyevent KEYCODE_BACK >/dev/null 2>&1
sleep 2
adb shell input tap 294 104 >/dev/null 2>&1     # search tab
sleep 2
adb shell input tap 675 254 >/dev/null 2>&1     # more
sleep 3
dump
tap_text "已知（精确）搜索" || tap_text "已知"
sleep 4

echo "==> pick the type '$TYPE'"
dump
read -r TX TY <<< "$(python3 "$ROOT/tools/find_widget.py" "$XML" type_button)"
if [ -n "${TX:-}" ]; then
    adb shell input tap "$TX" "$TY" >/dev/null 2>&1
    sleep 3
    # scroll the type list to the top, the list keeps the last position
    adb shell input swipe 360 300 360 900 400 >/dev/null 2>&1
    sleep 2
    adb shell input swipe 360 300 360 900 400 >/dev/null 2>&1
    sleep 2
    dump
    for _ in 1 2 3 4; do
        tap_text "$TYPE" && break
        adb shell input swipe 360 300 360 700 300 >/dev/null 2>&1
        sleep 2
    done
    sleep 2
fi

if [ -n "$VALUE" ]; then
    echo "==> value '$VALUE'"
    dump
    read -r VX VY VLEN <<< "$(python3 "$ROOT/tools/find_widget.py" "$XML" value_field)"
    if [ -n "${VX:-}" ]; then
        adb shell input tap "$VX" "$VY" >/dev/null 2>&1
        sleep 2
        adb shell input keyevent KEYCODE_MOVE_END >/dev/null 2>&1
        # keep the first character: it is the type prefix the app itself put
        # there ("=" for numbers, ":" / ";" for the text types)
        DELS="${VLEN:-1}"
        [ "$DELS" -lt 1 ] && DELS=1
        for _ in $(seq 1 "$DELS"); do adb shell input keyevent KEYCODE_DEL >/dev/null 2>&1; done
        adb shell input text "$VALUE" >/dev/null 2>&1
        sleep 2
    fi
fi

echo "==> start the search"
adb logcat -c >/dev/null 2>&1
dump
tap_text "新搜索"
sleep 14

echo "==> daemon log"
adb logcat -d -v time 2>/dev/null | grep -a -E 'sendSearchNumber|sendSearchText|searchNumber:|searchText:|searchDone' | tail -n 6

echo "==> result rows"
dump
python3 "$ROOT/tools/uix.py" "$XML" | head -n 14

#!/usr/bin/env bash
# Tap the first on screen widget whose text contains the given string.
#
#   tools/tap_text.sh "安装模式" [tries]
#   tools/tap_text.sh "=Root" [tries]     # exact match
#
# The ui hierarchy is dumped again for every try, so the script also works
# when the wanted dialog only shows up after a delay.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
WANT="${1:?usage: tap_text.sh <text> [tries]}"
TRIES="${2:-8}"
XML="$ROOT/build/tap_text.xml"
EXACT=0
case "$WANT" in
    =*) WANT="${WANT#=}"; EXACT=1 ;;
esac

for _ in $(seq 1 "$TRIES"); do
    adb shell uiautomator dump /sdcard/tap_text.xml >/dev/null 2>&1
    # the link to the device drops often, so the dump is read back with
    # exec-out instead of a pull - a half transferred file would look like
    # an empty dump
    adb exec-out cat /sdcard/tap_text.xml > "$XML" 2>/dev/null
    if [ -s "$XML" ]; then
        if [ "$EXACT" = "1" ]; then
            line="$(python3 "$ROOT/tools/uix.py" "$XML" 2>/dev/null \
                | awk -v w="$WANT" 'index($0, w) == 1 && substr($0, length(w) + 1, 1) == " " { print; exit }')"
        else
            line="$(python3 "$ROOT/tools/uix.py" "$XML" 2>/dev/null | grep -F "$WANT" | head -1)"
        fi
        if [ -n "$line" ]; then
            coords="$(printf '%s' "$line" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')"
            set -- $coords
            adb shell input tap "$1" "$2"
            echo "tap '$WANT' at $1,$2"
            exit 0
        fi
    fi
    sleep 2
done
echo "!! no widget with text '$WANT'" >&2
exit 1

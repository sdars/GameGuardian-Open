#!/usr/bin/env bash
# Attach GameGuardian to a running process on the device.
#
# The main window of the app is a translucent activity, the floating panel
# is an overlay window (WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY)
# and the process list is a dialog of that overlay - uiautomator dumps it as
# soon as it is on top of the focused window.
#
#   tools/attach_process.sh [text of the process to attach]
#
# Without an argument the first entry of the list is used.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
WANT="${1:-}"
XML="$ROOT/build/attach_process.xml"

if ! adb shell 'dumpsys window windows | grep -q "ty=APPLICATION_OVERLAY"'; then
    echo "!! no overlay window of GameGuardian - is the app running?" >&2
    exit 1
fi

# the floating panel sits in the top left corner (0,56)-(96,152)
adb shell input tap 48 104
sleep 3

adb shell uiautomator dump /sdcard/attach_process.xml >/dev/null 2>&1
adb pull /sdcard/attach_process.xml "$XML" >/dev/null 2>&1
if [ ! -s "$XML" ]; then
    echo "!! no ui hierarchy" >&2
    exit 1
fi

line="$(python3 "$ROOT/tools/uix.py" "$XML" | grep -E '\[[0-9]+\]' | head -1)"
if [ -z "$line" ]; then
    echo "!! the process list is empty" >&2
    python3 "$ROOT/tools/uix.py" "$XML" >&2
    exit 1
fi
if [ -n "$WANT" ]; then
    line="$(python3 "$ROOT/tools/uix.py" "$XML" | grep -F "$WANT" | grep -E '\[[0-9]+\]' | head -1)"
    if [ -z "$line" ]; then
        echo "!! no process matching '$WANT'" >&2
        exit 1
    fi
fi
echo "    -> $line"
coords="$(printf '%s' "$line" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')"
set -- $coords
adb shell input tap "$1" "$2"
sleep 6

echo "==> attach result"
adb logcat -d -v time 2>/dev/null | grep -aE 'used: ProcessInfo|DI: |InOut:|RegionList|attach' | tail -8
exit 0

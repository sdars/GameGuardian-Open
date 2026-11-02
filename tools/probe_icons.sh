#!/usr/bin/env bash
# Tap every icon of the search toolbar of the reconstructed GameGuardian and
# report the dialog that each of them opens.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
OUT="$ROOT/build/icon_probe.txt"
: > "$OUT"

dump() {
    adb shell uiautomator dump /sdcard/probe.xml >/dev/null 2>&1
    adb pull /sdcard/probe.xml "$ROOT/build/probe.xml" >/dev/null 2>&1
    python3 "$ROOT/tools/uix.py" "$ROOT/build/probe.xml" 2>/dev/null
}

for x in 45 135 225 315 405 495 585; do
    # the main window is translucent, a back press closes it -> restart it
    adb shell am start -n com.qgneurveavkmljs/.ActivityMain >/dev/null 2>&1
    sleep 3
    adb shell input tap "$x" 254
    sleep 3
    echo "=== icon x=$x" >> "$OUT"
    dump | head -8 >> "$OUT"
    # dismiss the dialog with its own cancel button when there is one
    line="$(dump | grep -E '取消' | head -1)"
    if [ -n "$line" ]; then
        coords="$(printf '%s' "$line" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')"
        set -- $coords
        adb shell input tap "$1" "$2"
    else
        adb shell input keyevent KEYCODE_BACK
    fi
    sleep 2
done
echo "done" >> "$OUT"

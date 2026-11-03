#!/usr/bin/env bash
# Long press the floating GameGuardian icon - that is the documented way to
# open the speedhack panel (the arrows next to the icon).
#
#   tools/speed_longpress.sh <tag>
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

echo "==> make sure the panel is closed"
adb_ shell input tap 48 104
sleep 3
adb_ shell input tap 672 104
sleep 3

echo "==> long press the floating icon (48,104)"
adb_ logcat -c
adb_ shell input swipe 48 104 48 104 1200
sleep 4

adb_ shell screencap -p /sdcard/lp_$TAG.png
adb_ pull /sdcard/lp_$TAG.png "$ROOT/build/logs/lp_$TAG.png" >/dev/null 2>&1
echo "    build/logs/lp_$TAG.png"

echo "==> icon area"
python3 "$ROOT/tools/ascii_region.py" "$ROOT/build/logs/lp_$TAG.png" 0,20,460,140 4

echo "==> log"
adb_ logcat -d -v time | grep -aE "AndroidService" | grep -avE "SP NU" | tail -14

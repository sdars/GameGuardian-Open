#!/usr/bin/env bash
# Sweep long press positions over the top left corner of the screen and
# report the ones that reach the floating icon of the running GameGuardian.
#
#   tools/sweep_longpress.sh <package> [x1,y1 x2,y2 ...]
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}
shift || true
POS=${*:-48,48 48,72 48,96 48,120 48,144 24,80 72,80 24,104 72,104}

for pos in $POS; do
    x=${pos%,*}
    y=${pos#*,}
    adb logcat -c >/dev/null 2>&1
    adb shell input swipe "$x" "$y" "$x" "$y" 1500 >/dev/null 2>&1
    sleep 3
    HIT=$(adb logcat -d -v time 2>/dev/null | grep -acE 'Fake long click')
    echo "    $x,$y -> long click hits: $HIT"
    if [ "$HIT" != "0" ]; then
        adb logcat -d -v time 2>/dev/null | grep -aE 'Fake long click|Real long click' | head -4
        echo '    (window list)'
        adb shell dumpsys window windows 2>/dev/null | grep -a -B6 'ty=APPLICATION_OVERLAY' \
            | grep -aE 'Window #|mAttrs=' | head -12
    fi
done
exit 0

#!/usr/bin/env bash
# Probe where the floating icon of the given package accepts a long press.
#
#   tools/probe_longpress.sh <package> [x,y ...]
#
# The app logs "Fake long click" (android.ext.HotFrame) and "Real long
# click" (android.ext.HotFrame$a) when the gesture reaches the icon.
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}
shift || true
POS=${*:-48,20 48,60 48,104 48,140}

adb shell am force-stop "$PKG" >/dev/null 2>&1
sleep 2
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
adb shell input tap 668 1232 >/dev/null 2>&1
sleep 7

echo '=== windows'
adb shell dumpsys window windows 2>/dev/null | grep -a 'mAttrs=' | grep -a APPLICATION_OVERLAY

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
    fi
done
exit 0

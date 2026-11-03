#!/usr/bin/env bash
# Start the given GameGuardian package, run the value search flow and store
# a screenshot of every step, so the reconstruction and the original can be
# compared screen by screen.
#
#   tools/probe_flow.sh <package> <outdir>
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}
OUT=${2:-$ROOT/build/probe_$PKG}
VALUE=${GG_VALUE:-999}
mkdir -p "$OUT"

dump() {
    local name="$1"
    adb shell uiautomator dump /sdcard/probe.xml >/dev/null 2>&1
    adb pull /sdcard/probe.xml "$OUT/$name.xml" >/dev/null 2>&1
    adb shell screencap -p "/sdcard/$name.png" >/dev/null 2>&1
    adb pull "/sdcard/$name.png" "$OUT/$name.png" >/dev/null 2>&1
}

adb shell am force-stop com.fqqvbgr >/dev/null 2>&1
adb shell am force-stop com.utnciuwv.ldcsra >/dev/null 2>&1
sleep 2
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
adb shell input tap 668 1232 >/dev/null 2>&1
sleep 7

echo '==> open the panel'
adb shell input tap 48 104 >/dev/null 2>&1
sleep 4
dump panel

echo '==> open the value search dialog'
adb shell input tap 495 254 >/dev/null 2>&1
sleep 4
dump dialog

echo '==> type the value'
adb shell input tap 385 241 >/dev/null 2>&1
sleep 1
adb shell input keyevent KEYCODE_MOVE_END >/dev/null 2>&1
for _ in $(seq 1 16); do adb shell input keyevent KEYCODE_DEL >/dev/null 2>&1; done
adb shell input text "$VALUE" >/dev/null 2>&1
sleep 1
dump value

echo '==> start the search'
adb shell input tap 598 1173 >/dev/null 2>&1
sleep 3
dump typerq

echo '==> pick the type'
adb shell input tap 360 316 >/dev/null 2>&1
sleep 2
dump auto

echo '==> wait for the result'
sleep 12
adb shell input tap 472 1173 >/dev/null 2>&1
sleep 3
dump results

echo '==> search log'
adb logcat -d -v time 2>/dev/null | grep -aE 'sendSearchNumber|searchNumber|searchDone' | tail -6
echo "screenshots in $OUT"
exit 0

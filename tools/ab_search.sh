#!/usr/bin/env bash
# Drive a GameGuardian build through the value search with the shipped code
# path and take a screenshot of the result list.
#
#   tools/ab_search.sh <package> <tag> <pid> [value]
#
# The coordinates are the ones of the panel of the 101.4 build:
#
#   the floating icon / the app icon of the panel  (48,72)
#   the more menu of the panel                     (675,254)
#   the entry "known (exact) search"              (360,248)
#   the number field of the search dialog         (385,241)
#   the type spinner of the search dialog         (200,338)
#   the entry "Dword (32 bit)" of the type list   (360,842)
#   the button "new search"                       (598,1173)
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
OUT="$ROOT/build/flow"
mkdir -p "$OUT"

PKG="$1"
TAG="$2"
PID="$3"
VALUE="$4"
VALUE="${VALUE:-999}"

shot() {
    adb exec-out screencap -p > "$OUT/screen_${TAG}_$1.png" 2>/dev/null
    echo "    shot $1 -> $OUT/screen_$TAG_$1.png"
}

dump() {
    adb shell rm -f /sdcard/ab.xml >/dev/null 2>&1
    adb shell uiautomator dump /sdcard/ab.xml >/dev/null 2>&1
    adb exec-out cat /sdcard/ab.xml 2>/dev/null > "$OUT/ab_${TAG}_$1.xml"
}

echo "==> start $PKG"
adb shell am force-stop com.wrw >/dev/null 2>&1
adb shell am force-stop com.utnciuwv.ldcsra >/dev/null 2>&1
adb shell am force-stop "$PKG" >/dev/null 2>&1
sleep 2
adb logcat -c >/dev/null 2>&1
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 12

echo "==> start the service and open the panel"
adb shell input tap 668 1232 >/dev/null 2>&1
sleep 8
adb shell input tap 48 72 >/dev/null 2>&1
sleep 5

echo "==> pick the process $PID"
dump procs
COORD=$(python3 "$ROOT/tools/uix.py" "$OUT/ab_${TAG}_procs.xml" 2>/dev/null \
    | grep -aF "[$PID]" | head -1 \
    | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
if [ -z "$COORD" ]; then
    echo "!! the process $PID is not in the list" >&2
    python3 "$ROOT/tools/uix.py" "$OUT/ab_${TAG}_procs.xml" >&2
    shot procs
    exit 1
fi
echo "    at $COORD"
adb shell input tap $COORD >/dev/null 2>&1
sleep 8

echo "==> the memory list (the opcode columns)"
adb shell input tap 558 104 >/dev/null 2>&1
sleep 6
shot mem
dump mem

echo "==> the value search"
adb shell input tap 675 254 >/dev/null 2>&1
sleep 5
adb shell input tap 360 248 >/dev/null 2>&1
sleep 5
adb shell input tap 385 241 >/dev/null 2>&1
sleep 2
adb shell input text "$VALUE" >/dev/null 2>&1
sleep 2
adb shell input tap 200 338 >/dev/null 2>&1
sleep 4
adb shell input tap 360 842 >/dev/null 2>&1
sleep 4
shot typed
adb shell input tap 598 1173 >/dev/null 2>&1
sleep 20
shot results
dump results

echo "==> the daemon log"
adb logcat -d -v time 2>/dev/null | grep -aE 'sendSearchNumber|searchNumber|searchDone|Search' | tail -6
exit 0

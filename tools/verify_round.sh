#!/usr/bin/env bash
# Run the whole regression of the reconstruction against the device and store
# the result in build/verify_round/.
#
#   tools/verify_round.sh <package> <tag> <pid> [value]
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
PKG="${1:-com.wrw}"
TAG="${2:-ours}"
PID="${3:-2427}"
VALUE="${4:-999}"
OUT=$ROOT/build/verify_round
mkdir -p "$OUT"

echo "=== restart the app so that it reads the preferences again"
adb shell "am start -n com.gg.abitest/.MainActivity" >/dev/null 2>&1
sleep 3
adb shell "am force-stop $PKG"
sleep 2
adb shell "am start -n $PKG/.MainActivity"
sleep 12

echo "=== the preferences of the build"
adb shell "su -c 'cat /data/user/0/$PKG/shared_prefs/${PKG}_preferences.xml'" > "$OUT/${TAG}_prefs.xml" 2>&1
grep -a 'memory-editor-format' "$OUT/${TAG}_prefs.xml"

echo "=== the memory list (the disassembly columns)"
python3 "$ROOT/tools/mem_list.py" "$PKG" "$TAG" "$PID" > "$OUT/${TAG}_memlist.txt" 2>&1
tail -40 "$OUT/${TAG}_memlist.txt"

echo "=== the search"
python3 "$ROOT/tools/ui_flow.py" "$PKG" "$TAG" "$PID" "$VALUE" > "$OUT/${TAG}_search.txt" 2>&1
tail -40 "$OUT/${TAG}_search.txt"

echo "=== the speed hack"
python3 "$ROOT/tools/speed_hot.py" "$PKG" "$TAG" "$PID" > "$OUT/${TAG}_speed.txt" 2>&1
tail -60 "$OUT/${TAG}_speed.txt"
echo done

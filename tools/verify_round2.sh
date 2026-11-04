#!/usr/bin/env bash
# Run the regression of one build against the device.
#
#   tools/verify_round2.sh <package> <tag> <pid> [value]
#
# The three steps are the memory list (the disassembly columns), the value
# search and the speed hack.  Every step writes its own file under
# build/verify_round/ so that the reconstruction and the original can be
# compared line by line.
set -uo pipefail
ROOT=/root/gameguardian
OUT=$ROOT/build/verify_round
mkdir -p "$OUT"

PKG="${1:-com.wrw}"
TAG="${2:-ours}"
PID="${3:-2418}"
VALUE="${4:-999}"

echo "=== $TAG ($PKG) pid $PID"

echo "=== the memory list (the disassembly columns)"
python3 "$ROOT/tools/mem_list.py" "$PKG" "$TAG" "$PID" > "$OUT/${TAG}_memlist.txt" 2>&1
tail -40 "$OUT/${TAG}_memlist.txt"

echo "=== the search"
python3 "$ROOT/tools/ui_flow.py" "$PKG" "$TAG" "$PID" "$VALUE" > "$OUT/${TAG}_search.txt" 2>&1
tail -40 "$OUT/${TAG}_search.txt"

echo "=== the speed hack"
python3 "$ROOT/tools/speed_hot.py" "$PKG" "$TAG" "$PID" > "$OUT/${TAG}_speed.txt" 2>&1
tail -60 "$OUT/${TAG}_speed.txt"
echo "=== done $TAG"

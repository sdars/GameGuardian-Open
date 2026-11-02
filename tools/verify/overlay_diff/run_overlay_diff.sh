#!/usr/bin/env bash
# Behavioural differential test for the three methods that used to be shipped
# as a smali overlay and are plain java source now:
#
#   android.ext.m.e(android.ext.n, int[], long, java.lang.String, int)
#   android.ext.n$a.a(android.ext.n, long, java.lang.String, int)
#   luaj.LuaClosure.Y2(luaj.LuaValue[], luaj.Varargs, boolean)
#
#   ours : build/app_classes          (pure-source reconstruction)
#   orig : tmp/analysis/.../classes.fixed.jar (dex2jar dump of the original dex)
#
# The same harness is compiled once and executed twice - once with the
# reference implementation of the original dex and once with the pure source
# reconstruction.  Both runs see the same 620 input vectors (fixed vectors
# plus a seeded random sweep) and their output has to be byte identical.
#
# luaj.LuaClosure.Y2 is covered by tools/verify/luaj_diff/run_diff.sh, which
# drives the whole Lua VM.
set -uo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/../../.." && pwd)"
HERE="$ROOT/tools/verify/overlay_diff"
OUT="$ROOT/build/overlay_diff"
SDK="$ROOT/tmp/tools/android-sdk/platforms/android-34/android.jar"
ORIG="$ROOT/tmp/analysis/2026-11-01/classes.fixed.jar"
OURS="$ROOT/build/app_classes"

if [ ! -f "$SDK" ] || [ ! -f "$ORIG" ] || [ ! -d "$OURS" ]; then
  echo "missing inputs: sdk=$SDK orig=$ORIG ours=$OURS" >&2
  exit 2
fi

mkdir -p "$OUT"

echo "[1/3] compiling the harness"
javac -nowarn -g:none -encoding UTF-8 -cp "$OURS:$SDK" -d "$OUT" \
    "$HERE/OverlayDiffHarness.java" || exit 1

echo "[2/3] running against the original dex"
timeout 1800 java -cp "$OUT:$ORIG:$SDK" android.ext.OverlayDiffHarness \
    > "$OUT/orig.txt" 2> "$OUT/orig.err" || { echo "reference run failed" >&2; tail -5 "$OUT/orig.err" >&2; exit 1; }

echo "[3/3] running against the pure source reconstruction"
timeout 1800 java -cp "$OUT:$OURS:$SDK" android.ext.OverlayDiffHarness \
    > "$OUT/ours.txt" 2> "$OUT/ours.err" || { echo "reconstruction run failed" >&2; tail -5 "$OUT/ours.err" >&2; exit 1; }

if diff -q "$OUT/orig.txt" "$OUT/ours.txt" >/dev/null 2>&1; then
  echo "RESULT: PASS - $(wc -l < "$OUT/ours.txt") lines identical between the original dex and the pure source"
  exit 0
fi
echo "RESULT: FAIL - the two implementations differ" >&2
diff -u "$OUT/orig.txt" "$OUT/ours.txt" | head -60 >&2
exit 1

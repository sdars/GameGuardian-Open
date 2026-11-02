#!/usr/bin/env bash
# Behavioural differential test for the pure-source luaj VM.
#
#   ours : build/app_classes          (pure-source reconstruction)
#   orig : tmp/analysis/.../classes.jar (dex2jar dump of the original dex)
#
# The same harness + the same Lua source is executed on both classpaths and
# stdout is compared byte for byte.
set -uo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/../../.." && pwd)"
HERE="$ROOT/tools/verify/luaj_diff"
OUT="$ROOT/build/luaj_diff"
SDK="$ROOT/tmp/tools/android-sdk/platforms/android-34/android.jar"
ORIG="$ROOT/tmp/analysis/2026-11-01/classes.jar"
ORIG_FIXED="$ROOT/tmp/analysis/2026-11-01/classes.fixed.jar"
OURS="$ROOT/build/app_classes"

if [ ! -f "$SDK" ] || [ ! -f "$ORIG" ] || [ ! -d "$OURS" ]; then
  echo "missing inputs: sdk=$SDK orig=$ORIG ours=$OURS" >&2
  exit 2
fi

if [ ! -f "$ORIG_FIXED" ]; then
  echo "[0/4] repairing the dex2jar reference jar (class flags + InnerClasses)"
  python3 "$HERE/fix_jar.py" "$ORIG" "$ROOT/build/puresrc/original" "$ORIG_FIXED" || exit 1
fi

mkdir -p "$OUT/ours" "$OUT/orig" "$OUT/work" "$OUT/log"

compile_harness() {
  local dest="$1"; shift
  local cp="$*"
  mkdir -p "$dest"
  find "$dest" -type f -name '*.class' -delete
  javac -nowarn -g:none -encoding UTF-8 -cp "$cp" -d "$dest" \
    "$HERE/LuaDiffHarness.java" 2>"$OUT/log/compile_$(basename "$dest").log"
  if [ $? -ne 0 ]; then
    echo "harness compile failed for $dest" >&2
    cat "$OUT/log/compile_$(basename "$dest").log" >&2
    return 1
  fi
}

echo "[1/4] compiling harness (ours)"
compile_harness "$OUT/ours" "$OURS:$SDK" || exit 1
echo "[2/4] compiling harness (orig)"
compile_harness "$OUT/orig" "$ORIG_FIXED:$SDK" || exit 1

run_one() {
  local script="$1"
  local name; name="$(basename "$script" .lua)"
  local work="$OUT/work/$name.lua"
  cat "$HERE/prelude.lua" "$script" > "$work"
  java -cp "$OUT/ours:$OURS:$SDK" LuaDiffHarness "$work" > "$OUT/log/$name.ours.txt" 2>"$OUT/log/$name.ours.err"
  java -cp "$OUT/orig:$ORIG_FIXED:$SDK" LuaDiffHarness "$work" > "$OUT/log/$name.orig.txt" 2>"$OUT/log/$name.orig.err"
  if diff -q "$OUT/log/$name.ours.txt" "$OUT/log/$name.orig.txt" >/dev/null 2>&1; then
    local n; n="$(wc -l < "$OUT/log/$name.ours.txt")"
    echo "  OK   $name ($n lines identical)"
    return 0
  fi
  echo "  DIFF $name"
  diff -u "$OUT/log/$name.orig.txt" "$OUT/log/$name.ours.txt" | head -60
  return 1
}

echo "[3/4] running differential scripts"
fail=0
total=0
for s in "$HERE"/scripts/*.lua; do
  total=$((total + 1))
  run_one "$s" || fail=$((fail + 1))
done

echo "[4/4] stderr sanity check (stack traces must not differ structurally)"
for s in "$HERE"/scripts/*.lua; do
  name="$(basename "$s" .lua)"
  if [ -s "$OUT/log/$name.ours.err" ]; then
    echo "  stderr non-empty for $name (ours):"
    head -5 "$OUT/log/$name.ours.err"
  fi
done

echo
if [ "$fail" -eq 0 ]; then
  echo "RESULT: PASS - $total/$total scripts byte-identical between pure-source and original luaj VM"
  exit 0
fi
echo "RESULT: FAIL - $fail/$total scripts differ"
exit 1

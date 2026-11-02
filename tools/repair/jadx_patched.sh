#!/usr/bin/env bash
# Decompile the three methods that plain jadx 1.5.6 refuses to produce,
# using the locally patched jadx (BlockProcessor + TypeInferenceVisitor).
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
CP="$ROOT/build/jadxpatch/patched:$ROOT/tmp/tools/jadx-1.5.6/lib/jadx-1.5.6-all.jar"
APK="$ROOT/tmp/analysis/2026-11-01/GameGuardian-101.4.apk"
OUT="$ROOT/build/jadx3"
mkdir -p "$OUT"

mode="${1:-normal}"
shift || true
classes=("$@")
if [ ${#classes[@]} -eq 0 ]; then
  classes=(android.ext.m 'android.ext.n$a' luaj.LuaClosure)
fi

for c in "${classes[@]}"; do
  safe="$(echo "$c" | tr '$.' '__')"
  out="$OUT/${safe}_${mode}.java"
  log="$OUT/${safe}_${mode}.log"
  echo "==> $c  mode=$mode  -> $out"
  java -Xmx2g -cp "$CP" jadx.cli.JadxCLI \
      --decompilation-mode "$mode" --comments-level none --log-level warn \
      --threads-count 1 \
      --single-class "$c" --single-class-output "$out" \
      "$APK" > "$log" 2>&1
  rc=$?
  echo "    rc=$rc  size=$(wc -c < "$out" 2>/dev/null || echo 0)"
  [ $rc -ne 0 ] && tail -5 "$log"
done

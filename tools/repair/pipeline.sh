#!/usr/bin/env bash
# Rebuild the source tree from the pristine jadx output and repair it until
# javac is happy.  Every step is deterministic, so the whole pipeline can be
# replayed from scratch at any time:
#
#     bash tools/repair/pipeline.sh
#
# The phases are
#   1. structural fixes (placeholders, package names, framework constants,
#      marker classes) - they do not depend on the compiler
#   2. name resolution - driven by javac ("package a does not exist" ...)
#   3. catch registers, access modifiers and value types - driven by javac
#   4. the hand written repairs in fix_misc.py
set -u
ROOT=$(cd "$(dirname "$0")/../.." && pwd)
cd "$ROOT"

errcount() { grep -c ': error:' /tmp/ggjc_err.log 2>/dev/null || echo 0; }

echo "== phase 1: structural =="
python3 tools/repair/reset_tree.py
python3 tools/repair/fix_placeholders.py > /dev/null
python3 tools/repair/rename_packages.py > /dev/null
python3 tools/repair/fix_android_r.py > /dev/null
python3 tools/repair/gen_synthetic.py

echo "== phase 2: name resolution =="
for round in 1 2 3 4 5 6 7 8; do
  bash tools/javac_check.sh | head -1
  before=$(errcount)
  python3 tools/repair/fix_refs.py 2>/dev/null | head -1
  python3 tools/repair/fix_catch_vars.py 2>/dev/null | tail -1
  bash tools/javac_check.sh | head -1
  now=$(errcount)
  echo "   errors: $before -> $now"
  if [ "$now" -ge "$before" ] && [ "$round" -gt 2 ]; then break; fi
done

echo "== phase 3: access and value types =="
for round in 1 2 3 4 5 6; do
  bash tools/javac_check.sh | head -1
  before=$(errcount)
  python3 tools/repair/fix_private_access.py | tail -1
  python3 tools/repair/fix_types.py
  python3 tools/repair/fix_misc.py | tail -2
  bash tools/javac_check.sh | head -1
  now=$(errcount)
  echo "   errors: $before -> $now"
  if [ "$now" -ge "$before" ] && [ "$round" -gt 2 ]; then break; fi
done

echo "== result =="
bash tools/javac_check.sh

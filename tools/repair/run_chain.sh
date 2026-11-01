#!/usr/bin/env bash
# Repair loop: compile, apply the javac driven fixes, repeat until stable.
#
# Every fixer runs against a snapshot of the source tree.  When a fixer makes
# the compiler report more errors than before the snapshot is restored and the
# fixer is skipped for that round: a repair must never make the tree worse.
set -u
ROOT=$(cd "$(dirname "$0")/../.." && pwd)
cd "$ROOT"
MAX=8
if [ $# -gt 0 ]; then MAX=$1; fi
SRC=app/src/main/java
SNAP=/tmp/gg_snap

count_errors() {
  bash tools/javac_check.sh > /tmp/gg_chain.log 2>&1
  grep -c ': error:' /tmp/ggjc_err.log
}

for i in $(seq 1 "$MAX"); do
  ERR=$(count_errors)
  echo "=== round $i: javac errors = $ERR"
  if [ "$ERR" -eq 0 ]; then
    echo clean
    exit 0
  fi
  for FIX in fix_pollution fix_definite_assignment fix_checked_exceptions fix_wrapper_scope fix_flow fix_never_thrown fix_static_init; do
    python3 -c "import shutil; shutil.rmtree('$SNAP', ignore_errors=True)"
    cp -r "$SRC" "$SNAP"
    python3 tools/repair/$FIX.py > /tmp/gg_fix_$FIX.log 2>&1
    NEW=$(count_errors)
    if [ "$NEW" -gt "$ERR" ]; then
      python3 -c "import shutil; shutil.rmtree('$SRC'); shutil.copytree('$SNAP', '$SRC')"
      echo "  $FIX made it worse ($ERR -> $NEW), reverted"
    else
      echo "  $FIX: $ERR -> $NEW"
      ERR=$NEW
    fi
  done
done
echo "final errors: $(count_errors)"

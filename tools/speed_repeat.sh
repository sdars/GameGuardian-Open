#!/usr/bin/env bash
# run the speed panel flow several times and keep every log
ROOT=/root/gameguardian
PKG=${1:-com.saweyhfbpyrcxakywsq}
TAG=${2:-ours}
N=${3:-3}
for i in $(seq 1 $N); do
    echo "===== run $i"
    python3 -u $ROOT/tools/speed_panel_ab.py "$PKG" "$TAG" 2418 > $ROOT/build/flow/sp_${TAG}_$i.log 2>&1
    grep -E "Report Error|107|not support|elf_hook_sections32 Find|Send code: 1[18]" $ROOT/build/flow/sp_${TAG}_$i.log | head -8
    cp $ROOT/build/flow/lc_${TAG}.txt $ROOT/build/flow/lc_${TAG}_$i.txt 2>/dev/null
done

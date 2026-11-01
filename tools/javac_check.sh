#!/usr/bin/env bash
# 编译校验：javac 全量编译源码树（含 R 桩），输出错误汇总
# usage: bash tools/javac_check.sh [src-dir]
set -u
ROOT=$(cd "$(dirname "$0")/.." && pwd)
SRC=${1:-$ROOT/app/src/main/java}
STUBS=$ROOT/tools/stubs/java
SDK=${GG_SDK:-/root/gameguardian/tmp/tools/android-sdk}
OUT=$(mktemp -d)
find "$SRC" "$STUBS" -name '*.java' | sort -u > /tmp/ggjc_srcs.txt
echo "files=$(wc -l < /tmp/ggjc_srcs.txt)"
javac -J-Xmx1400m -J-XX:+UseSerialGC -source 8 -target 8 -Xlint:-options -nowarn -Xmaxerrs 100000 -XDshould-stop.ifError=FLOW \
  -cp "$SDK/platforms/android-34/android.jar" \
  -d "$OUT" @/tmp/ggjc_srcs.txt 2> /tmp/ggjc_err.log
rc=$?
echo "javac rc=$rc  errors=$(grep -c ': error:' /tmp/ggjc_err.log)"
grep ': error:' /tmp/ggjc_err.log | sed 's/:[0-9]*: error:.*//' | sort | uniq -c | sort -rn | head -30

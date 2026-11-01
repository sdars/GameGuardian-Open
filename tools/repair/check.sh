#!/bin/sh
# fast javac check of app/src/main/java
set -e
ROOT=/root/gameguardian
OUT=${1:-/tmp/ggchk}
mkdir -p "$OUT/out"
find "$ROOT/app/src/main/java" -name '*.java' > "$OUT/srcs.txt"
/usr/lib/jvm/java-21-openjdk-amd64/bin/javac -source 8 -target 8 -Xlint:-options -Xmaxerrs 200000 \
  -cp "$ROOT/tmp/tools/android-sdk/platforms/android-34/android.jar" \
  -d "$OUT/out" @"$OUT/srcs.txt" 2>"$OUT/err.log" || true
grep -cE ': error:' "$OUT/err.log" || true
grep -oE 'error: .*' "$OUT/err.log" | sed 's/[0-9]\+//g' | sort | uniq -c | sort -rn | head -20

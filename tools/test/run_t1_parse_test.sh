#!/usr/bash
# JVM regression harness: android.ext.t1.h() vs the original commercial smali.
# usage: bash tools/test/run_t1_parse_test.sh
set -u
ROOT=$(cd "$(dirname "$0")/../.." && pwd)
SDK=""${GG_SDK-}""
[ -n "$SDK" ] || SDK="$ROOT/tmp/tools/android-sdk"
AJ="$SDK/platforms/android-34/android.jar"
OUT=$(mktemp -d)
trap 'rm -rf "$OUT"' EXIT

find "$ROOT/app/src/main/java" "$ROOT/tools/stubs/java" "$ROOT/tools/test/stubs" -name '*.java' \
  | sort -u | grep -v 'tools/test/T1ParseTest.java' > "$OUT/srcs.txt"
javac -J-Xmx1400m -source 8 -target 8 -Xlint:-options -nowarn -Xprefer:source \
  -cp "$AJ" -d "$OUT/classes" @"$OUT/srcs.txt" 2> "$OUT/main.log"
if [ $? -ne 0 ]; then
  echo "MAIN COMPILE FAIL"
  grep ': error:' "$OUT/main.log" | head -20
  exit 1
fi

javac -source 8 -target 8 -Xlint:-options -nowarn \
  -cp "$OUT/classes:$AJ" -d "$OUT/classes" "$ROOT/tools/test/T1ParseTest.java" 2> "$OUT/test.log"
if [ $? -ne 0 ]; then
  echo "TEST COMPILE FAIL"
  head -20 "$OUT/test.log"
  exit 1
fi

java -cp "$OUT/classes:$AJ" T1ParseTest

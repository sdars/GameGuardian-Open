#!/usr/bin/env bash
# push the missing chunks of an APK transfer and assemble the file
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
APK="${1:-$ROOT/release/GameGuardian-101.4-open.apk}"
REMOTE="${2:-/data/local/tmp/gg-release.apk}"
WORK=/tmp/ggpart
CHUNK=2097152
split -b $CHUNK -d -a 4 "$APK" "$WORK/part."
TOTAL=$(md5sum "$APK" | cut -d' ' -f1)
for part in "$WORK"/part.*; do
    name=$(basename "$part")
    want=$(md5sum "$part" | cut -d' ' -f1)
    for attempt in 1 2 3 4 5 6 7 8 9 10 11 12; do
        got=$(adb shell "md5sum /data/local/tmp/$name" 2>/dev/null | tr -d '\r' | cut -d' ' -f1)
        if [ "$got" = "$want" ]; then
            echo "  $name already ok"
            break
        fi
        adb connect 123.57.254.92:51213 >/dev/null 2>&1
        adb push "$part" "/data/local/tmp/$name" >/dev/null 2>&1
        got=$(adb shell "md5sum /data/local/tmp/$name" 2>/dev/null | tr -d '\r' | cut -d' ' -f1)
        if [ "$got" = "$want" ]; then
            echo "  $name ok (attempt $attempt)"
            break
        fi
        echo "  $name retry $attempt (got=$got)"
        sleep 3
    done
done
PARTS=""
for part in "$WORK"/part.*; do PARTS="$PARTS /data/local/tmp/$(basename $part)"; done
adb shell "cat $PARTS > $REMOTE" >/dev/null 2>&1
got=$(adb shell "md5sum $REMOTE" 2>/dev/null | tr -d '\r' | cut -d' ' -f1)
echo "remote md5 $got  local $TOTAL"
if [ "$got" = "$TOTAL" ]; then echo OK; else echo FAILED >&2; exit 1; fi

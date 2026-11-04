#!/usr/bin/env bash
# Robust APK transfer over a flaky adb link.
#
# The link to the device drops the transfer of an 18 MB file from time to time
# ("failed to read copy response: EOF"), so the file is cut into chunks that
# are pushed one after the other.  Every chunk is verified with its md5 on
# the device, the chunks are concatenated there and the result is compared
# with the md5 of the local file.
#
#   tools/push_apk.sh <apk> [remote-path]
set -uo pipefail
ROOT=/root/gameguardian
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
APK="${1:-$ROOT/release/GameGuardian-101.4-open.apk}"
REMOTE="${2:-/data/local/tmp/gg-release.apk}"
CHUNK=$((2 * 1024 * 1024))
WORK=$(mktemp -d /tmp/ggpush.XXXXXX)

split -b $CHUNK -d -a 4 "$APK" "$WORK/part."
TOTAL=$(md5sum "$APK" | cut -d' ' -f1)
echo "local md5 $TOTAL  ($(stat -c%s "$APK") bytes)"

adb shell "rm -f $REMOTE" >/dev/null 2>&1
PARTS=""
for part in "$WORK"/part.*; do
    name=$(basename "$part")
    want=$(md5sum "$part" | cut -d' ' -f1)
    ok=0
    for attempt in 1 2 3 4 5 6 7 8 9 10; do
        adb push "$part" "/data/local/tmp/$name" >/dev/null 2>&1
        got=$(adb shell "md5sum /data/local/tmp/$name" 2>/dev/null | tr -d '\r' | cut -d' ' -f1)
        if [ "$got" = "$want" ]; then
            echo "  $name ok (attempt $attempt)"
            ok=1
            break
        fi
        echo "  $name retry $attempt (got=$got)"
        sleep 2
    done
    if [ "$ok" != "1" ]; then
        echo "FAILED: $name" >&2
        exit 1
    fi
    PARTS="$PARTS /data/local/tmp/$name"
done

adb shell "cat $PARTS > $REMOTE" >/dev/null 2>&1
for part in "$WORK"/part.*; do
    adb shell "rm -f /data/local/tmp/$(basename "$part")" >/dev/null 2>&1
done
got=$(adb shell "md5sum $REMOTE" 2>/dev/null | tr -d '\r' | cut -d' ' -f1)
size=$(adb shell "stat -c %s $REMOTE" 2>/dev/null | tr -d '\r')
echo "remote md5 $got  ($size bytes)"
if [ "$got" = "$TOTAL" ]; then
    echo "OK: $REMOTE is identical to $APK"
else
    echo "FAILED: $REMOTE differs from $APK" >&2
    exit 1
fi

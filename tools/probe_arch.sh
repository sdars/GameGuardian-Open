#!/usr/bin/env bash
# Extract the architecture probe binaries of the raw resources onto the
# device and run every one of them.  The probe prints the architecture id
# as its exit code, that is how android.ext.e0 finds the right daemon.
set -u
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
for f in ydw00 ydw01 ydw02 ydw05 ydw07 ydw08; do
  adb push $ROOT/app/src/main/res/raw/$f /data/local/tmp/$f >/dev/null
done
adb shell su -mm -c 'chmod 755 /data/local/tmp/ydw*; for f in /data/local/tmp/ydw00 /data/local/tmp/ydw01 /data/local/tmp/ydw02 /data/local/tmp/ydw05 /data/local/tmp/ydw07 /data/local/tmp/ydw08; do $f >/dev/null 2>&1; echo "$f exit=$?"; done'

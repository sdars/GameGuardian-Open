#!/usr/bin/env bash
# Compare the native daemon blobs (res/raw/ydw*) that ship inside the
# reconstructed APK against the ones of the original APK on the device.
set -uo pipefail
ROOT=/root/gameguardian
OUT=$ROOT/build/cmp_daemon
mkdir -p "$OUT"

for f in ydw0 ydw1 ydw2 ydw3 ydw5 ydw7 ydw8 ydw4 ydw6 ydw9; do
    unzip -p "$ROOT/release/GameGuardian-101.4-open.apk" "res/raw/$f" 2>/dev/null > "$OUT/ours_$f"
    if [ -s "$OUT/ours_$f" ]; then
        printf '%s ours %s\n' "$f" "$(sha256sum < "$OUT/ours_$f" | cut -d' ' -f1)"
    fi
done

echo '--- apkraw (source of the resources) ---'
for f in ydw0 ydw1 ydw2; do
    [ -f "$ROOT/build/apkraw/$f" ] && printf '%s raw  %s\n' "$f" "$(sha256sum < "$ROOT/build/apkraw/$f" | cut -d' ' -f1)"
done

echo '--- device: original package com.utnciuwv.ldcsra ---'
APK=$(/root/gameguardian/tmp/tools/platform-tools/adb shell pm path com.utnciuwv.ldcsra | tr -d '\r' | sed -n 's/^package://p')
echo "    apk: $APK"
if [ -n "$APK" ]; then
    for f in ydw0 ydw1 ydw2; do
        /root/gameguardian/tmp/tools/platform-tools/adb shell "su -c 'cat $APK' | dd bs=1 skip=0 count=0 2>/dev/null" >/dev/null 2>&1
    done
fi
echo '--- device: our packages ---'
for p in com.fqqvbgr com.xzqwitnufxpj; do
    APK=$(/root/gameguardian/tmp/tools/platform-tools/adb shell pm path "$p" | tr -d '\r' | sed -n 's/^package://p')
    echo "    $p -> $APK"
done
exit 0

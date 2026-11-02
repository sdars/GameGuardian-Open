#!/usr/bin/env bash
# Build a throw-away signed APK.  Installing it changes /data/system/packages.list,
# which is what APatch's uid-listener watches in order to re-sync the uid of the
# superuser entries in /data/adb/ap/package_config.
set -euo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SDK="$ROOT/tmp/tools/android-sdk"
BT="$SDK/build-tools/34.0.0"
OUT="$ROOT/build/uidprobe"
mkdir -p "$OUT"

cat > "$OUT/AndroidManifest.xml" <<'XML'
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.gg.uidprobe">
    <application android:label="uidprobe" />
</manifest>
XML

"$BT/aapt2" link -I "$SDK/platforms/android-34/android.jar" \
    --manifest "$OUT/AndroidManifest.xml" -o "$OUT/uidprobe.apk"
# aapt2 does not emit a dex - borrow a valid one so that the package scanner
# accepts the apk
( cd "$OUT" && unzip -o -q "$ROOT/release/GameGuardian-101.4-open.apk" classes.dex && zip -q "$OUT/uidprobe.apk" classes.dex )
"$BT/zipalign" -f -p 4 "$OUT/uidprobe.apk" "$OUT/uidprobe-aligned.apk"
"$BT/apksigner" sign \
    --ks "$ROOT/keystore/release.jks" --ks-pass pass:gameguardian \
    --ks-key-alias gameguardian --key-pass pass:gameguardian \
    --out "$OUT/uidprobe-signed.apk" "$OUT/uidprobe-aligned.apk"
"$BT/apksigner" verify "$OUT/uidprobe-signed.apk"
echo "$OUT/uidprobe-signed.apk"

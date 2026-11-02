#!/usr/bin/env bash
# Build the GameGuardian 101.4 open source reconstruction.
#
#   1. javac/d8 through Gradle turns app/src/main/java into classes.dex
#      (the three methods that no decompiler was able to reconstruct are
#      plain java source now, see tools/repair/smali_to_java.py)
#   2. the APK is aligned and signed
#
# Environment:
#   GG_SDK                  android sdk location (default tmp/tools/android-sdk)
#   GG_KEYSTORE_PASSWORD    keystore password (default gameguardian)
#   GG_KEY_ALIAS            key alias        (default CERT)
#
# The alias name decides the name of the v1 signature files inside the APK.
# The original GameGuardian package is signed with the alias "CERT", so the
# generated META-INF/CERT.SF and META-INF/CERT.RSA have to keep that name:
# android.ext.b1 reads those two entries by their hard coded names when it
# re-signs the APK that it installs under a randomised package name.
#   GG_KEY_PASSWORD         key password     (default gameguardian)
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT"

SDK="${GG_SDK:-$ROOT/tmp/tools/android-sdk}"
BT="$SDK/build-tools/34.0.0"
LIB="$ROOT/tools/lib"
WORK="$ROOT/build/release"
KS="$ROOT/keystore/release.jks"
KSPASS="${GG_KEYSTORE_PASSWORD:-gameguardian}"
KEYALIAS="${GG_KEY_ALIAS:-CERT}"
KEYPASS="${GG_KEY_PASSWORD:-gameguardian}"

echo "==> [1/2] gradle assembleRelease"
./gradlew :app:assembleRelease --offline -q
APK="$ROOT/app/build/outputs/apk/release/app-release.apk"

echo "==> [2/2] align and sign"
cp "$APK" "$WORK/unsigned.apk"
"$BT/zipalign" -p -f 4 "$WORK/unsigned.apk" "$WORK/aligned.apk"
"$BT/apksigner" sign \
    --ks "$KS" --ks-pass "pass:$KSPASS" \
    --ks-key-alias "$KEYALIAS" --key-pass "pass:$KEYPASS" \
    --out "$ROOT/release/GameGuardian-101.4-open.apk" "$WORK/aligned.apk"

"$BT/apksigner" verify --print-certs "$ROOT/release/GameGuardian-101.4-open.apk" | head -4
sha256sum "$ROOT/release/GameGuardian-101.4-open.apk"
echo "==> done: release/GameGuardian-101.4-open.apk"

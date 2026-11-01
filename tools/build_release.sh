#!/usr/bin/env bash
# Build the GameGuardian 101.4 open source reconstruction.
#
#   1. javac/d8 through Gradle turns app/src/main/java into classes.dex
#   2. baksmali turns that dex back into smali
#   3. the smali overlay (app/src/main/smali_overlay) replaces the three
#      methods that no Java decompiler was able to reconstruct
#   4. smali assembles the patched tree into the final classes.dex
#   5. the dex is put back into the APK, aligned and signed
#
# Environment:
#   GG_SDK                  android sdk location (default tmp/tools/android-sdk)
#   GG_KEYSTORE_PASSWORD    keystore password (default gameguardian)
#   GG_KEY_ALIAS            key alias        (default gameguardian)
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
KEYALIAS="${GG_KEY_ALIAS:-gameguardian}"
KEYPASS="${GG_KEY_PASSWORD:-gameguardian}"

echo "==> [1/5] gradle assembleRelease"
./gradlew :app:assembleRelease --offline -q
APK="$ROOT/app/build/outputs/apk/release/app-release.apk"

echo "==> [2/5] baksmali"
python3 -c "import shutil,os,sys; p=sys.argv[1]; shutil.rmtree(p, ignore_errors=True); os.makedirs(p, exist_ok=True)" "$WORK"
( cd "$WORK" && unzip -o -q "$APK" classes.dex )
java -cp "$LIB/*" org.jf.baksmali.Main d "$WORK/classes.dex" -o "$WORK/smali"

echo "==> [3/5] apply smali overlay"
python3 "$ROOT/tools/repair/overlay_smali.py" apply "$WORK/smali"

echo "==> [4/5] smali assemble"
java -Xmx2g -cp "$LIB/*" org.jf.smali.Main assemble "$WORK/smali" -o "$WORK/classes.dex"

echo "==> [5/5] package, align, sign"
cp "$APK" "$WORK/unsigned.apk"
( cd "$WORK" && zip -q -d unsigned.apk classes.dex && zip -q -X unsigned.apk classes.dex )
"$BT/zipalign" -p -f 4 "$WORK/unsigned.apk" "$WORK/aligned.apk"
"$BT/apksigner" sign \
    --ks "$KS" --ks-pass "pass:$KSPASS" \
    --ks-key-alias "$KEYALIAS" --key-pass "pass:$KEYPASS" \
    --out "$ROOT/release/GameGuardian-101.4-open.apk" "$WORK/aligned.apk"

"$BT/apksigner" verify --print-certs "$ROOT/release/GameGuardian-101.4-open.apk" | head -4
sha256sum "$ROOT/release/GameGuardian-101.4-open.apk"
echo "==> done: release/GameGuardian-101.4-open.apk"
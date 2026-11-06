#!/usr/bin/env bash
# Build the test bed for the freeze of GameGuardian.
#
#   tools/make_freeze_probe_apk.sh [32|64|both]
#
# The activity keeps a volatile int array in the heap: the first word is
# changed every 200 ms, the three words behind it are the canary that shows
# a freeze that writes more bytes than the type of the value asks for.
set -euo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
SDK="$ROOT/tmp/tools/android-sdk"
BT="$SDK/build-tools/34.0.0"
AJ="$SDK/platforms/android-34/android.jar"
SRC="$ROOT/tools/freeze_probe/src/com/gg/freezeprobe/FreezeProbeActivity.java"
OUT="$ROOT/build/freezeprobe"
WHICH="${1:-both}"

mkdir -p "$OUT"

cat > "$OUT/AndroidManifest.xml" <<'XML'
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.gg.freezeprobe">
    <uses-sdk android:minSdkVersion="21" android:targetSdkVersion="24" />
    <application android:label="GGFreezeProbe">
        <activity android:name=".FreezeProbeActivity" android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
</manifest>
XML

build_one() {
    ABI_DIR="$1"
    OUT_APK="$2"
    WORK="$OUT/work_$ABI_DIR"
    rm -rf "$WORK"
    mkdir -p "$WORK/classes" "$WORK/dex" "$WORK/apk"

    javac -source 8 -target 8 -nowarn -classpath "$AJ" -d "$WORK/classes" "$SRC" 2>&1 \
        | grep -v 'bootstrap class path' || true
    # every class has to go into the dex, the anonymous inner classes included
    "$BT/d8" --lib "$AJ" --output "$WORK/dex" $(find "$WORK/classes" -name '*.class')
    "$BT/aapt" package -f -M "$OUT/AndroidManifest.xml" -I "$AJ" -F "$WORK/apk/base.apk"
    cp "$WORK/dex/classes.dex" "$WORK/apk/classes.dex"
    ( cd "$WORK/apk" && zip -X -q base.apk classes.dex )
    "$BT/zipalign" -f 4 "$WORK/apk/base.apk" "$WORK/apk/aligned.apk"
    "$BT/apksigner" sign --ks "$ROOT/keystore/release.jks" --ks-pass pass:gameguardian \
        --key-pass pass:gameguardian --ks-key-alias gameguardian \
        --out "$OUT_APK" "$WORK/apk/aligned.apk"
    echo "built $OUT_APK"
}

case "$WHICH" in
    32)  build_one armeabi-v7a "$OUT/freezeprobe-32.apk" ;;
    64)  build_one arm64-v8a "$OUT/freezeprobe-64.apk" ;;
    both)
        build_one armeabi-v7a "$OUT/freezeprobe-32.apk"
        build_one arm64-v8a "$OUT/freezeprobe-64.apk"
        ;;
    *) echo "usage: $0 [32|64|both]" >&2; exit 1 ;;
esac

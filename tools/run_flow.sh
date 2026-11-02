#!/usr/bin/env bash
# Full start up cycle of the reconstructed GameGuardian on the attached device.
#
#   tools/run_flow.sh [install]
#
# install : push release/GameGuardian-101.4-open.apk, install it with pm and
#           grant root to the package before it is started.
#
# The cycle is
#   1. install the apk (the package is catch_.me_.if_.you_.can_)
#   2. grant root to it (APatch keeps the uid in /data/adb/ap/package_config,
#      a fresh install always gets a new uid, so the list has to be rewritten)
#   3. start the app, answer the "install mode" dialog
#   4. the app copies itself into a randomly named package and removes itself
#   5. grant root to that new package as well - it is the one that keeps
#      running from now on
#   6. answer the quick start dialog and check that the daemon handshake
#      finished ("DI: <arch> <qe> <pid>")
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
PKG=catch_.me_.if_.you_.can_
APK="$ROOT/release/GameGuardian-101.4-open.apk"

adb connect 123.57.254.92:51213 >/dev/null 2>&1

if [ "${1:-}" = "install" ]; then
    echo "==> push $APK"
    adb push "$APK" /data/local/tmp/gg.apk >/dev/null
    echo "==> pm install"
    adb shell "su -c 'pm install -r -d /data/local/tmp/gg.apk'" | tail -1
fi

echo "==> grant root to $PKG"
bash "$ROOT/tools/grant_root.sh" "$PKG" | tail -1

adb shell pm clear "$PKG" >/dev/null 2>&1
adb logcat -c >/dev/null 2>&1
echo "==> start"
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 11
adb shell uiautomator dump /sdcard/gg_flow1.xml >/dev/null 2>&1
adb pull /sdcard/gg_flow1.xml "$ROOT/build/gg_flow1.xml" >/dev/null 2>&1
echo "--- ui 1 (install mode dialog) ---"
python3 "$ROOT/tools/uix.py" "$ROOT/build/gg_flow1.xml" 2>/dev/null | head -8

# answer the install mode dialog with the default entry
adb shell input tap 360 567 >/dev/null 2>&1
sleep 16

echo "--- ui 2 ---"
adb shell uiautomator dump /sdcard/gg_flow2.xml >/dev/null 2>&1
adb pull /sdcard/gg_flow2.xml "$ROOT/build/gg_flow2.xml" >/dev/null 2>&1
python3 "$ROOT/tools/uix.py" "$ROOT/build/gg_flow2.xml" 2>/dev/null | head -8

# the app copied itself into a random package - that one keeps running
HELPER="$(adb logcat -d -v time 2>/dev/null | grep -a -o 'BaseActivity init: [a-z0-9_.]*' | tail -1 | awk '{print $3}')"
echo "==> helper package: $HELPER"
if [ -n "$HELPER" ]; then
    bash "$ROOT/tools/grant_root.sh" "$HELPER" | tail -2
fi

# quick start dialog of the helper
adb shell input tap 582 970 >/dev/null 2>&1
sleep 12

echo "--- ui 3 (main menu) ---"
adb shell uiautomator dump /sdcard/gg_flow3.xml >/dev/null 2>&1
adb pull /sdcard/gg_flow3.xml "$ROOT/build/gg_flow3.xml" >/dev/null 2>&1
python3 "$ROOT/tools/uix.py" "$ROOT/build/gg_flow3.xml" 2>/dev/null | head -10

echo "--- daemon handshake ---"
adb logcat -d -v time 2>/dev/null | grep -a -E "DI: |InOut: x64|start daemon failed|Good: android-daemon|verify: generated APK|package-installed|installer-removed" | tail -12
echo "--- packages ---"
adb shell pm list packages -U 2>/dev/null | grep -E "catch_|com\.[a-z]{8}" | head -5

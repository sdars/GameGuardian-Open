#!/usr/bin/env bash
# Start the reconstructed GameGuardian that is already installed on the device
# (self installed package names) and print the ui tree of the main window.
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
OURS=${OURS:-com.fqqvbgr}

echo '==> stop the other app'
adb shell am force-stop com.utnciuwv.ldcsra >/dev/null 2>&1
adb shell am force-stop com.xzqwitnufxpj >/dev/null 2>&1
adb shell am force-stop "$OURS" >/dev/null 2>&1
sleep 2

echo '==> start'
adb logcat -c >/dev/null 2>&1
adb shell am start -n "$OURS/.MainActivity" >/dev/null 2>&1
sleep 8

adb shell uiautomator dump /sdcard/ui_now.xml >/dev/null 2>&1
adb pull /sdcard/ui_now.xml "$ROOT/build/ui_now.xml" >/dev/null 2>&1
echo '=== ui'
python3 "$ROOT/tools/uix.py" "$ROOT/build/ui_now.xml" | head -30
echo '=== windows'
adb shell dumpsys window windows 2>/dev/null | grep -a -B1 'ty=APPLICATION_OVERLAY' | grep -a 'mAttrs=' | head -10
echo '=== log'
adb logcat -d -v time 2>/dev/null | grep -aE 'AndroidService|android-daemon' | tail -12

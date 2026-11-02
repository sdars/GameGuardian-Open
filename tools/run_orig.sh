#!/usr/bin/env bash
# Drive the *original* GameGuardian APK (already installed on the device) to
# the point where the floating window is up and a target process is attached.
# Used as the reference rendering / behaviour for the reconstruction.
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
PKG=catch_.me_.if_.you_.can_

tap_if() {
    if bash "$ROOT/tools/tap_text.sh" "$1" 3; then
        echo "    -> '$1'"
    else
        echo "    (no '$1' on screen)"
    fi
}

echo "==> start"
adb shell am force-stop "$PKG" >/dev/null 2>&1
adb logcat -c >/dev/null 2>&1
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9

echo "==> install mode dialog"
tap_if "默认"
sleep 16

HELPER="$(adb logcat -d -v time 2>/dev/null \
    | grep -a -o 'onActivity\(Created\|Resumed\): [a-z0-9_.]*' \
    | awk '{print $2}' | sed 's/\.[^.]*$//' \
    | grep -v "^$PKG\$" | grep -v '^$' | tail -1)"
echo "    helper: ${HELPER:-<none>}"
if [ -n "$HELPER" ]; then
    bash "$ROOT/tools/grant_root.sh" "$HELPER" --verify | tail -2
    adb shell am force-stop "$HELPER" >/dev/null 2>&1
    sleep 2
    adb shell am start -n "$HELPER/.MainActivity" >/dev/null 2>&1
    sleep 8
fi

echo "==> work mode dialog (root)"
tap_if "=Root"
sleep 6

echo "==> quick start dialog"
tap_if "确定"
sleep 5

echo "==> restart the app"
tap_if "=重启"
sleep 12
tap_if "=忽略"
sleep 5

echo "==> main menu -> 开始"
tap_if "=开始"
sleep 8

echo "==> open the floating window"
adb shell input tap 48 104
sleep 3

echo "==> attach a target process"
bash "$ROOT/tools/attach_process.sh" "${GG_TARGET:-}" || echo "    (no target attached)"
sleep 4

echo "==> state"
adb shell dumpsys window | grep -a mCurrentFocus | head -2
adb logcat -d -v time 2>/dev/null | grep -aE "AndroidService" | tail -5

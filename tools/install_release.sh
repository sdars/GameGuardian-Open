#!/usr/bin/env bash
# Install the reconstructed APK, grant root and start the app.
#
# One command for the whole cycle, so a reinstall can never leave the device
# in the state where the package has a new uid but the superuser list still
# carries the old one.
#
#   tools/install_release.sh [apk]
set -euo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
APK="${1:-$ROOT/release/GameGuardian-101.4-open.apk}"
PKG=catch_.me_.if_.you_.can_

echo "==> installing $APK"
adb install -r -d "$APK" || {
    echo "!! install failed, removing the old copy and retrying"
    adb uninstall "$PKG" >/dev/null 2>&1 || true
    adb install "$APK"
}

"$ROOT/tools/grant_root.sh" "$PKG"

adb shell am force-stop "$PKG" >/dev/null 2>&1 || true
adb logcat -c >/dev/null 2>&1 || true
echo "==> starting $PKG"
adb shell am start -n "$PKG/.MainActivity" >/dev/null
sleep 10
adb shell uiautomator dump /sdcard/gg_ui.xml >/dev/null 2>&1
adb pull /sdcard/gg_ui.xml "$ROOT/build/gg_ui.xml" >/dev/null 2>&1
python3 "$ROOT/tools/uix.py" "$ROOT/build/gg_ui.xml" 2>/dev/null | head -20
echo "==> daemon / root lines from logcat:"
adb logcat -d -v time 2>/dev/null \
    | grep -E 'Daemon:|getArch|start daemon failed|FATAL EXCEPTION|uid=0' | tail -15

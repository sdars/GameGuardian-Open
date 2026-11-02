#!/usr/bin/env bash
# Install the reconstructed GameGuardian on the device and drive it to the
# point where the main window is up and a target process is attached.
#
#   tools/deploy.sh [apk]
#
# The app installs *itself* under a randomised package name and removes the
# launcher package afterwards, so the root grant has to be given twice:
# once for the launcher package and once for the randomised helper package
# that keeps running.  Every fresh install also gets a new uid, so the
# superuser list of APatch has to be rewritten for the new uid - that is
# what tools/grant_root.sh does.  Doing it by hand is where the previous
# runs got stuck; this script does the whole cycle in one command.
#
# Environment:
#   GG_SKIP_BUILD=1   use the APK as is, do not rebuild it
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
PKG=catch_.me_.if_.you_.can_
APK="${1:-$ROOT/release/GameGuardian-101.4-open.apk}"
STATE="$ROOT/build/deploy.state"

tap_if() {
    if bash "$ROOT/tools/tap_text.sh" "$1" 3; then
        echo "    -> '$1'"
    else
        echo "    (no '$1' on screen)"
    fi
}

if [ "${GG_SKIP_BUILD:-0}" != "1" ]; then
    echo "==> build"
    bash "$ROOT/tools/build_release.sh" | tail -2
fi

echo "==> remove the packages of the previous run"
if [ -f "$STATE" ]; then
    while read -r old; do
        [ -n "$old" ] && adb uninstall "$old" >/dev/null 2>&1
    done < "$STATE"
fi
: > "$STATE"
adb uninstall "$PKG" >/dev/null 2>&1

echo "==> install $APK"
# the link to the device is slow (0.1 MB/s), so the apk is pushed first and
# the package manager installs it from the device - that way a broken link
# does not lose the transfer
timeout 900 adb push "$APK" /data/local/tmp/gg-release.apk 2>&1 | tail -1
timeout 300 adb shell pm install -r -d /data/local/tmp/gg-release.apk 2>&1 | tail -1
adb shell rm -f /data/local/tmp/gg-release.apk
if ! adb shell pm path "$PKG" 2>/dev/null | grep -aq "package:"; then
    echo "!! install failed" >&2
    exit 1
fi
echo "$PKG" >> "$STATE"

echo "==> grant root to the launcher package"
bash "$ROOT/tools/grant_root.sh" "$PKG" --verify | tail -4

echo "==> start"
adb shell am force-stop "$PKG" >/dev/null 2>&1
adb logcat -c >/dev/null 2>&1
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9

echo "==> install mode dialog"
tap_if "默认"
sleep 16

# The app installs *itself* under a randomised package name and removes the
# launcher package afterwards.  The helper package is the one that keeps
# running and that asks for the work mode, so the root grant has to follow
# the self install: the helper gets a new uid and APatch hides the su binary
# from every uid that is not on its superuser list.
echo "==> wait for the self installed helper package"
HELPER=""
for _ in $(seq 1 12); do
    HELPER="$(adb logcat -d -v time 2>/dev/null \
        | grep -a -o 'onActivity\(Created\|Resumed\): [a-z0-9_.]*' \
        | awk '{print $2}' | sed 's/\.[^.]*$//' \
        | grep -v "^$PKG\$" | grep -v '^$' | tail -1)"
    [ -n "$HELPER" ] && break
    sleep 3
done
echo "    helper: ${HELPER:-<none>}"
if [ -n "$HELPER" ]; then
    echo "$HELPER" >> "$STATE"
    echo "==> grant root to the helper package"
    bash "$ROOT/tools/grant_root.sh" "$HELPER" --verify | tail -4
    echo "==> restart the helper so that it picks the grant up"
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

echo "==> restart the app (the work mode is applied after a restart)"
tap_if "=重启"
sleep 12
tap_if "=忽略"
sleep 5

echo "==> main menu -> 开始"
tap_if "=开始"
sleep 8

echo "==> attach a target process"
bash "$ROOT/tools/attach_process.sh" "${GG_TARGET:-}" || echo "    (no target attached)"
sleep 4

echo "==> state"
adb shell pm list packages -U 2>/dev/null | grep -aE "catch_|com\.[a-z]{8}" | tr -d '\r'
adb shell "su -c 'ps -A -o USER,PID,PPID,NAME | grep -a lib5'" 2>/dev/null | tr -d '\r'
adb logcat -d -v time 2>/dev/null | grep -aE "DI: |InOut:|Daemon:" | tail -6

echo "==> regression check"
BAD="$(adb logcat -d -v time 2>/dev/null \
    | grep -aE "Bad cmdline length|Bad name length|NameNotFoundException|java.lang.RuntimeException" \
    | grep -av "Failed sendLogBlocking" | tail -5)"
if [ -n "$BAD" ]; then
    echo "!! the reconstruction still hits the known faults:" >&2
    printf '%s\n' "$BAD" >&2
    exit 1
fi
echo "    no known fault in the log"

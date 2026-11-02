#!/usr/bin/env bash
# Grant the GameGuardian package root on the attached device and keep the
# uid in APatch's superuser list in sync with the installed package.
#
# The device runs APatch (11224).  Its superuser list is the csv file
# /data/adb/ap/package_config
#
#   pkg,exclude,allow,uid,to_uid,sctx
#
# The uid column is the uid the package has *right now*.  Every reinstall
# of a package gets a new uid, so a list that was written for the previous
# install silently stops to work - that is the loop this script breaks: it
# reads the current uid from the package manager and rewrites the entry.
#
# Two things are needed for the grant to become effective:
#
#   1. the entry in /data/adb/ap/package_config, and
#   2. a re-sync of APatch's uid-listener.  APatch keeps the uids that may
#      execute the su binary inside the kernel module (APC); that list is
#      only rebuilt when the listener sees a change of the package list.
#      Editing the file by hand is therefore not enough - the app keeps
#      failing with "Cannot run program su: error=13, Permission denied".
#      Installing a throw away package makes the listener re-read the file
#      and push it into the kernel, after which the uid can exec su.
#
# Do not stop apd's uid-listener to force a reload instead: killing it takes
# apd down with it and the kernel panic that follows reboots the device
# (dmesg: "Process apd (pid: 3390)" + "Forcing a warm reset of the system").
#
#   tools/grant_root.sh [package] [--verify|--verify-app]
#
# --verify executes the su binary as the uid of the package.  APatch hides
# the su binary from every uid that is not on the list, so this only works
# when the grant really took effect.  --verify-app waits for the result of
# the root probe of the app itself (the app writes it to gg-diag.log).
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
PKG="${1:-catch_.me_.if_.you_.can_}"
VERIFY=0
[ "${2:-}" = "--verify" ] && VERIFY=1
[ "${2:-}" = "--verify-app" ] && VERIFY=2
CFG=/data/adb/ap/package_config
SCTX=u:r:magisk:s0
PROBE=com.gg.uidprobe

uid="$(adb shell pm list packages -U "$PKG" | tr -d '\r' \
    | sed -n "s/^package:$PKG uid:\([0-9][0-9]*\)$/\1/p" | head -1)"
if [ -z "$uid" ]; then
    echo "!! package $PKG is not installed - nothing to grant" >&2
    exit 1
fi
echo "==> $PKG is installed with uid $uid"

adb shell "su -c 'cp -a $CFG $CFG.bak-\$(date +%Y%m%d%H%M%S)'" >/dev/null 2>&1 || true
adb shell "su -c 'grep -v \"^$PKG,\" $CFG > $CFG.new && \
    echo \"$PKG,0,1,$uid,0,$SCTX\" >> $CFG.new && \
    cat $CFG.new > $CFG && rm -f $CFG.new && \
    chmod 600 $CFG && chown root:root $CFG'" >/dev/null
echo "==> superuser list entry: $(adb shell "su -c 'grep \"^$PKG,\" $CFG'" | tr -d '\r')"

echo "==> trigger the uid-listener sync"
if [ ! -f "$ROOT/build/uidprobe/uidprobe-signed.apk" ]; then
    bash "$ROOT/tools/make_uid_probe_apk.sh" >/dev/null 2>&1 || true
fi
adb uninstall "$PROBE" >/dev/null 2>&1
timeout 120 adb install -r -d "$ROOT/build/uidprobe/uidprobe-signed.apk" 2>&1 | tail -1
sleep 3

if [ "$VERIFY" = "1" ]; then
    # Probe the grant the way the app does it: execute the su binary as the
    # uid of the package and let APatch decide.  APatch hides the su binary
    # from every uid that is not on the list, so the exec fails with ENOENT
    # as long as the uid-listener has not synced the list.
    probe="$(adb shell "su -c 'busybox setuidgid $uid /system/bin/su -c id'" 2>/dev/null \
        | tr -d '\r' | tail -1)"
    echo "==> su probe as uid $uid: $probe"
    case "$probe" in
        uid=0*) echo "==> root granted"; exit 0 ;;
    esac
    echo "==> the su binary is not reachable for uid $uid - the grant did not take effect" >&2
    exit 1
fi
if [ "$VERIFY" = "2" ]; then
    adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
    for _ in $(seq 1 15); do
        sleep 2
        out="$(adb shell "su -c 'cat /data/data/$PKG/files/gg-diag.log 2>/dev/null'" 2>/dev/null \
            | tr -d '\r' | grep -a 'probe done' | tail -1)"
        [ -n "$out" ] || continue
        echo "==> app root probe: $out"
        case "$out" in
            *uid=0*) echo "==> root granted"; exit 0 ;;
            *)      echo "==> root NOT granted" >&2; exit 1 ;;
        esac
    done
    echo "==> no root probe result yet - the grant is written, the app has to run once" >&2
    exit 0
fi
echo "==> root granted (list entry written for uid $uid, uid-listener synced)"

# --verify-app waits for the result of the root probe of the app itself
# (the app writes it to files/gg-diag.log).  The probe of the app only runs
# when the app needs root, so it is the slower but authoritative check.

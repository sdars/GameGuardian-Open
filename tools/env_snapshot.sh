#!/usr/bin/env bash
# Snapshot of every device state that the GameGuardian reconstruction could
# touch, so that a run of the app can be proven not to change it.
#
#   bash tools/env_snapshot.sh <label>              # write build/logs/snap_<label>.log
#   bash tools/env_snapshot.sh --diff <a> <b>       # compare two snapshots
#
# Collected:
#   * SELinux enforcement (plain shell and root shell)
#   * md5 of /proc/mounts          (mount table)
#   * md5 of /data/adb/ap/package_config  (APatch superuser list)
#   * md5 of /system/build.prop
#   * pm list packages
#   * ls -la /data/local/tmp
set -uo pipefail
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
export PATH="$ROOT/tmp/tools/platform-tools:$PATH"
DEV="${DEV:-8.162.0.198:30138}"
OUT="$ROOT/build/logs"
mkdir -p "$OUT"

if [ "${1:-}" = "--diff" ]; then
    diff "$OUT/snap_$2.log" "$OUT/snap_$3.log"
    echo "(no output above means: enforcement, mount table, APatch superuser list,"
    echo " /system and the package list are byte identical)"
    exit 0
fi

LABEL="${1:-snap}"
FILE="$OUT/snap_$LABEL.log"

adb -s "$DEV" shell 'echo "== getenforce (shell / root)"; getenforce; su -c getenforce;' > "$FILE" 2>&1
adb -s "$DEV" shell 'echo "== mount table md5"; su -c "cat /proc/mounts" | md5sum' >> "$FILE" 2>&1
adb -s "$DEV" shell 'echo "== APatch superuser list md5"; su -c "md5sum /data/adb/ap/package_config"' >> "$FILE" 2>&1
adb -s "$DEV" shell 'echo "== /system/build.prop md5"; su -c "md5sum /system/build.prop"' >> "$FILE" 2>&1
adb -s "$DEV" shell 'echo "== packages"; pm list packages' >> "$FILE" 2>&1
adb -s "$DEV" shell 'echo "== /data/local/tmp"; su -c "ls -la /data/local/tmp"' >> "$FILE" 2>&1
echo "written: $FILE"

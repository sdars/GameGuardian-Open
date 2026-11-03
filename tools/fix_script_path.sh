#!/usr/bin/env bash
# Repair the script-path preference of the reconstructed GameGuardian.
#
# The self install of the app copies the preferences of the previously
# installed package over (that is what android.ext.x2.n() does in the
# original as well).  The copy can carry a value of the wrong type or an
# empty value, so the directory that holds the lua scripts is lost and the
# script runner ends up with a path like "//<package>.lua".
#
#   tools/fix_script_path.sh [package] [dir]
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.fqqvbgr}
DIR=${2:-/storage/emulated/0/Notes}
PREFS=/data/data/$PKG/shared_prefs/${PKG}_preferences.xml

adb shell am force-stop "$PKG" >/dev/null 2>&1
sleep 2

adb shell su -c "cat $PREFS" 2>/dev/null | tr -d '\r' > /tmp/prefs.xml
if [ ! -s /tmp/prefs.xml ]; then
    echo "!! cannot read $PREFS" >&2
    exit 1
fi
python3 - "$DIR" <<'PY'
import re
import sys

path = '/tmp/prefs.xml'
dir_ = sys.argv[1]
body = open(path, encoding='utf-8').read()
new = '<string name="script-path">%s</string>' % dir_
if re.search(r'<string name="script-path">.*?</string>', body):
    body = re.sub(r'<string name="script-path">.*?</string>', new, body)
else:
    body = body.replace('</map>', '    ' + new + '\n</map>')
open(path, 'w', encoding='utf-8').write(body)
print('script-path ->', dir_)
PY

adb push /tmp/prefs.xml /data/local/tmp/gg-prefs.xml >/dev/null 2>&1
adb shell su -c "cp /data/local/tmp/gg-prefs.xml $PREFS" >/dev/null 2>&1
adb shell su -c "chown 10228:10228 $PREFS" >/dev/null 2>&1
adb shell su -c "chmod 660 $PREFS" >/dev/null 2>&1
adb shell rm -f /data/local/tmp/gg-prefs.xml >/dev/null 2>&1

adb shell su -c "grep -a script-path $PREFS" 2>/dev/null | tr -d '\r'

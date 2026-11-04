#!/usr/bin/env bash
# Open the speedhack panel of the floating icon and report what the app
# answers.  The panel is the documented way to change the speed (long press
# on the floating icon), the lua API gg.setSpeed() is a different path.
#
#   tools/ui_speed_test.sh <package> <tag>
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.hdzj.yopvkq}
TAG=${2:-ui}
LOG=$ROOT/build/logs
mkdir -p "$LOG"

A() { adb -s 123.57.254.92:51213 "$@"; }

echo "==> stop every other GameGuardian on the device"
for other in com.utnciuwv.ldcsra com.fqqvbgr com.xzqwitnufxpj com.oyn com.uyileqmdfw com.xplwru com.zijosy; do
    A shell am force-stop "$other" >/dev/null 2>&1
done
sleep 2

echo "==> start $PKG"
A shell am force-stop "$PKG" >/dev/null 2>&1
A logcat -c >/dev/null 2>&1
A shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9

echo "==> start the service and open the floating panel"
A shell input tap 668 1232
sleep 4
A shell input tap 48 72
sleep 4

echo "==> long press the floating icon (48,104)"
A shell input swipe 48 104 48 104 1200
sleep 4

A shell screencap -p /sdcard/sp_$TAG.png
A pull /sdcard/sp_$TAG.png "$LOG/sp_$TAG.png" >/dev/null 2>&1
A shell uiautomator dump /sdcard/sp_$TAG.xml >/dev/null 2>&1
A pull /sdcard/sp_$TAG.xml "$LOG/sp_$TAG.xml" >/dev/null 2>&1
echo "    build/logs/sp_$TAG.png"

echo "==> the nodes of the screen"
python3 - "$LOG/sp_$TAG.xml" <<'PY'
import re, sys
try:
    s = open(sys.argv[1], encoding='utf-8', errors='ignore').read()
except Exception as exc:
    print('no dump:', exc)
    raise SystemExit
for m in re.finditer(r'<node[^>]*>', s):
    n = m.group(0)
    txt = re.search(r'text="([^"]*)"', n)
    rid = re.search(r'resource-id="([^"]*)"', n)
    desc = re.search(r'content-desc="([^"]*)"', n)
    cls = re.search(r'class="([^"]*)"', n)
    bnd = re.search(r'bounds="([^"]*)"', n)
    val = (txt.group(1) if txt else '') or (desc.group(1) if desc else '')
    if not val:
        continue
    print('%-28s %-22s %s' % (val[:28], (rid.group(1) if rid else '')[-22:], bnd.group(1) if bnd else ''))
PY

echo "==> log"
A logcat -d -v time | grep -aE 'AndroidService|GameGuardian|com.hdzj|utnciuwv' | tail -40

#!/usr/bin/env bash
# Attach a target process and drive the speedhack panel of the floating
# icon (long press), then report the nodes, the log and the answer of the
# app.  This is the UI path of the speedhack, gg.setSpeed() is a different
# one.
#
#   tools/attach_speed.sh <package> <tag> [attach-y]
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.hdzj.yopvkq}
TAG=${2:-sp}
Y=${3:-601}
LOG=$ROOT/build/logs
mkdir -p "$LOG"
A() { adb -s 8.162.0.198:30138 "$@"; }

dump() {
    A shell uiautomator dump /sdcard/d_$TAG.xml >/dev/null 2>&1
    A pull /sdcard/d_$TAG.xml "$LOG/d_$TAG.xml" >/dev/null 2>&1
    A shell screencap -p /sdcard/d_$TAG.png >/dev/null 2>&1
    A pull /sdcard/d_$TAG.png "$LOG/d_$TAG.png" >/dev/null 2>&1
    echo "--- screen $1 ($LOG/d_$TAG.png)"
    python3 - "$LOG/d_$TAG.xml" <<'PY'
import re, sys
try:
    s = open(sys.argv[1], encoding='utf-8', errors='ignore').read()
except Exception as exc:
    print('no dump:', exc)
    raise SystemExit
for m in re.finditer(r'<node[^>]*>', s):
    n = m.group(0)
    def g(k):
        mm = re.search(k + r'="([^"]*)"', n)
        return mm.group(1) if mm else ''
    val = g('text') or g('content-desc')
    if not val:
        continue
    print('  %-34s %s' % (val[:34], g('bounds')))
PY
}

echo "==> start"
for other in com.utnciuwv.ldcsra com.fqqvbgr com.xzqwitnufxpj com.oyn com.uyileqmdfw com.xplwru com.zijosy; do
    A shell am force-stop "$other" >/dev/null 2>&1
done
A shell am force-stop "$PKG" >/dev/null 2>&1
A logcat -c >/dev/null 2>&1
A shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
A shell input tap 668 1232
sleep 4

echo "==> open the process list and attach the process at y=$Y"
A shell input tap 48 72
sleep 4
A shell input tap 360 "$Y"
sleep 6
dump after_attach

echo "==> long press the floating icon (48,40)"
A shell input swipe 48 40 48 40 1200
sleep 5
dump speed_panel

echo "== log"
A logcat -d -v time | grep -aE 'AndroidService|android-daemon' | tail -40

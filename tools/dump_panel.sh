#!/usr/bin/env bash
# Open the floating panel of the app and print the nodes of the screen.
#
#   tools/dump_panel.sh <package> <tag> [extra taps]
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.hdzj.yopvkq}
TAG=${2:-panel}
LOG=$ROOT/build/logs
mkdir -p "$LOG"
A() { adb -s 123.57.254.92:51213 "$@"; }

for other in com.utnciuwv.ldcsra com.fqqvbgr com.xzqwitnufxpj com.oyn com.uyileqmdfw com.xplwru com.zijosy com.hdzj.yopvkq; do
    A shell am force-stop "$other" >/dev/null 2>&1
done
A shell am force-stop "$PKG" >/dev/null 2>&1
A logcat -c >/dev/null 2>&1
A shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
A shell input tap 668 1232
sleep 4
A shell input tap 48 72
sleep 4

for extra in ${3:-}; do
    A shell input tap $extra
    sleep 3
done

A shell uiautomator dump /sdcard/p_$TAG.xml >/dev/null 2>&1
A pull /sdcard/p_$TAG.xml "$LOG/p_$TAG.xml" >/dev/null 2>&1
A shell screencap -p /sdcard/p_$TAG.png
A pull /sdcard/p_$TAG.png "$LOG/p_$TAG.png" >/dev/null 2>&1

python3 - "$LOG/p_$TAG.xml" <<'PY'
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
    rid = g('resource-id')
    bnd = g('bounds')
    if not val and not rid:
        continue
    print('%-30s %-26s %-22s %s' % (val[:30], rid[-26:], g('class')[-22:], bnd))
PY

echo "== log tail"
A logcat -d -v time | grep -aE 'AndroidService' | tail -12

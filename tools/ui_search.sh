#!/usr/bin/env bash
# Attach a target process, run a value search for a known number and report
# the rows of the result list together with the log of the daemon.
#
#   tools/ui_search.sh <package> <tag> <pid> [value]
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.hdzj.yopvkq}
TAG=${2:-s1}
PID=${3:-18122}
VALUE=${4:-999}
OUT=$ROOT/build/search_$TAG
mkdir -p "$OUT"
A() { adb -s 8.162.0.198:30138 "$@"; }

dump() {
    A shell uiautomator dump /sdcard/s_$TAG.xml >/dev/null 2>&1
    A pull /sdcard/s_$TAG.xml "$OUT/$1.xml" >/dev/null 2>&1
}

for other in com.utnciuwv.ldcsra com.fqqvbgr com.xzqwitnufxpj com.oyn com.uyileqmdfw com.xplwru com.zijosy com.hdzj.yopvkq; do
    A shell am force-stop "$other" >/dev/null 2>&1
done
A shell am force-stop "$PKG" >/dev/null 2>&1
A logcat -c >/dev/null 2>&1
A shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9
A shell input tap 668 1232
sleep 5
A shell input tap 48 72
sleep 4

echo "==> attach the process $PID"
A shell input tap 32 178
sleep 5
for _ in $(seq 1 12); do
    dump procs
    LINE=$(python3 "$ROOT/tools/uix.py" "$OUT/procs.xml" | grep -aF "[$PID]" | head -1)
    if [ -n "$LINE" ]; then
        echo "    $LINE"
        COORD=$(printf '%s' "$LINE" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
        set -- $COORD
        A shell input tap "$1" "$2"
        sleep 7
        break
    fi
    A shell input swipe 360 1000 360 400 400
    sleep 2
done
dump panel
echo "    panel: $(python3 "$ROOT/tools/uix.py" "$OUT/panel.xml" | head -6 | tr '\n' ' ')"

echo "==> open the value search"
A shell input tap 675 254
sleep 5
dump menu
MENU=$(python3 "$ROOT/tools/uix.py" "$OUT/menu.xml" | grep -a '搜索' | head -1)
echo "    menu: $MENU"
if [ -z "$MENU" ]; then
    python3 "$ROOT/tools/uix.py" "$OUT/menu.xml"
    exit 1
fi
COORD=$(printf '%s' "$MENU" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
set -- $COORD
A shell input tap "$1" "$2"
sleep 5
dump dialog
grep -aq ':id/number' "$OUT/dialog.xml" || { echo '!! no number field'; exit 1; }

echo "==> type $VALUE"
A shell input text "$VALUE"
sleep 1
sleep 2
dump typed
python3 - "$OUT/typed.xml" <<'PY'
import re, sys
s = open(sys.argv[1], encoding='utf-8', errors='ignore').read()
for m in re.finditer(r'<node[^>]*>', s):
    n = m.group(0)
    if ':id/number' in n:
        t = re.search(r'text="([^"]*)"', n)
        print('    the field is %r' % (t.group(1) if t else ''))
PY

echo "==> run the search"
BUTTON=$(python3 - "$OUT/typed.xml" <<'PY'
import re, sys
s = open(sys.argv[1], encoding='utf-8', errors='ignore').read()
for m in re.finditer(r'<node[^>]*>', s):
    n = m.group(0)
    t = re.search(r'text="([^"]*)"', n)
    b = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', n)
    if t and b and t.group(1).strip() in ('新搜索', 'Search'):
        print((int(b.group(1)) + int(b.group(3))) // 2, (int(b.group(2)) + int(b.group(4))) // 2)
        break
PY
)
echo "    the button is at $BUTTON"
set -- $BUTTON
A shell input tap "$1" "$2"
sleep 18
dump results
A shell screencap -p /sdcard/res_$TAG.png >/dev/null 2>&1
A pull /sdcard/res_$TAG.png "$OUT/results.png" >/dev/null 2>&1

echo "==> the rows of the result list"
python3 - "$OUT/results.xml" <<'PY'
import re, sys
s = open(sys.argv[1], encoding='utf-8', errors='ignore').read()
rows = []
tags = []
for m in re.finditer(r'<node[^>]*>', s):
    n = m.group(0)
    t = re.search(r'text="([^"]*)"', n)
    b = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', n)
    if not t or not b:
        continue
    txt = t.group(1).strip()
    if re.match(r'^[0-9A-Fa-f]{4,}$', txt) and not re.match(r'^[0-9A-Fa-f]{1,3}$', txt):
        rows.append((txt, int(b.group(2)), int(b.group(4)), b.group(0)))
    elif re.match(r'^(D|W|B|Q|F|X|A|Ca|Cb|Cd|Ch|Cs|Jh|PS|O|Xa|Xs|[A-Z]{1,2})$', txt):
        tags.append((txt, b.group(0)))
for r in rows[:14]:
    print('   %-16s top=%-5d bottom=%-5s' % (r[0], r[1], r[2]))
print('   tags: %s' % (tags[:10],))
PY

echo "==> daemon log"
A logcat -d -v time | grep -aE 'android-daemon' | grep -avE 'SP NU' | tail -25

echo "==> the log of the app"
A logcat -d -v time | grep -aE 'AndroidService' | tail -30

A logcat -d -v time > "$OUT/logcat.txt"
echo "    full logcat: $OUT/logcat.txt"

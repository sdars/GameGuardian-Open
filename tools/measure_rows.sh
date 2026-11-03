#!/usr/bin/env bash
# Measure the pitch of the rows of the result list of the value search.
#
#   tools/measure_rows.sh <package> [value]
#
# The script drives the shipped code path (floating panel -> magnifier ->
# search dialog -> search), then brings the floating panel to the front so
# that the ui dump contains the result list, and prints the bounds of every
# row together with the distance between two rows.
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.hdzj.yopvkq}
VALUE=${2:-999}
XML=$ROOT/build/rows_$PKG.xml

tap_text() { bash "$ROOT/tools/tap_text.sh" "$1" 3 >/dev/null 2>&1; }

dump() {
    adb shell uiautomator dump /sdcard/rows.xml >/dev/null 2>&1
    adb pull /sdcard/rows.xml "$XML" >/dev/null 2>&1
    python3 "$ROOT/tools/uix.py" "$XML"
}

echo "==> start $PKG"
adb shell am force-stop "$PKG" >/dev/null 2>&1
adb logcat -c >/dev/null 2>&1
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 9

echo "==> open the panel and the value search dialog"
adb shell input tap 668 1232 >/dev/null 2>&1   # 开始
sleep 7
for t in '确定' '默认' '=Root' '忽略'; do
    if tap_text "$t"; then
        echo "    answered '$t'"
        sleep 5
        break
    fi
done
adb shell input tap 48 104 >/dev/null 2>&1     # the floating icon
sleep 4
adb shell input tap 495 254 >/dev/null 2>&1     # the magnifier of the toolbar
sleep 5
dump | head -8

echo "==> type $VALUE"
adb shell input tap 385 241 >/dev/null 2>&1
sleep 1
adb shell input keyevent KEYCODE_MOVE_END >/dev/null 2>&1
for _ in $(seq 1 16); do adb shell input keyevent KEYCODE_DEL >/dev/null 2>&1; done
adb shell input text "$VALUE" >/dev/null 2>&1
sleep 2

echo "==> run the search"
adb shell input tap 598 1173 >/dev/null 2>&1
sleep 12

echo "==> bring the panel to the front and dump the result list"
adb shell input tap 48 104 >/dev/null 2>&1
sleep 3
adb shell screencap -p /sdcard/rows.png >/dev/null 2>&1
adb pull /sdcard/rows.png "$ROOT/build/rows_$PKG.png" >/dev/null 2>&1
dump > "$ROOT/build/rows_$PKG.txt"

python3 - "$XML" <<'PY'
import re, sys
s = open(sys.argv[1]).read()
rows = []
tags = []
for m in re.finditer(r'<node[^>]*text="([^"]*)"[^>]*bounds="(\[\d+,\d+\]\[\d+,\d+\])"', s):
    t = m.group(1).strip()
    b = [int(x) for x in re.findall(r'\d+', m.group(2))]
    if re.match(r'^[0-9A-Fa-f]{6,}$', t):
        rows.append((t, b[1], b[3], m.group(2)))
    elif re.match(r'^(D|W|B|Q|F|X|S|A|C|Ca|Cb|Cd|Cc|Ch|Cs|Jh|PS|[A-Z]{1,2})$', t):
        tags.append((t, m.group(2)))
print('rows: %d' % len(rows))
for r in rows[:12]:
    print('   address %-14s top=%-5d bottom=%-5d %s' % r)
tops = [r[1] for r in rows]
if len(tops) > 1:
    print('pitch: %s' % [tops[i + 1] - tops[i] for i in range(len(tops) - 1)])
print('type/area tags: %s' % tags[:8])
PY

echo '==> daemon log'
adb logcat -d -v time 2>/dev/null | grep -aE 'sendSearchNumber|searchNumber|searchDone' | tail -4
exit 0

#!/usr/bin/env bash
# Drive the value search of a GameGuardian package and dump the result list.
#
#   tools/run_search_999.sh <package> <out-prefix>
#
# The flow is the shipped code path:
#   start -> 开始 -> the floating icon -> the panel -> the magnifier of the
#   search toolbar -> the value search dialog (its number field is focused and
#   the app draws its own keypad) -> the keys -> 新搜索
#
# The keypad of the app is drawn with the phone layout (7 8 9 / 4 5 6 /
# 1 2 3 / 0) but the touch handler of the original walks a 5 column grid
# (1 2 3 4 5 / 6 7 8 9 0), so the key that inserts a 9 sits in the second row
# of the keypad, column four.
set -uo pipefail
ROOT=/root/gameguardian
export PATH=$ROOT/tmp/tools/platform-tools:$PATH
PKG=${1:-com.hdzj.yopvkq}
OUT=${2:-$ROOT/build/search_$PKG}
mkdir -p "$OUT"

dump() {
    adb shell uiautomator dump /sdcard/srch.xml >/dev/null 2>&1
    adb pull /sdcard/srch.xml "$OUT/$1.xml" >/dev/null 2>&1
}

number() {
    python3 - "$OUT/$1.xml" <<'PY'
import re, sys
try:
    s = open(sys.argv[1]).read()
except Exception:
    print('')
    raise SystemExit
for m in re.finditer(r'<node[^>]*>', s):
    n = m.group(0)
    rid = re.search(r'resource-id="([^"]*)"', n)
    if rid and rid.group(1).endswith(':id/number'):
        t = re.search(r'text="([^"]*)"', n)
        print(t.group(1) if t else '')
        break
PY
}

echo "==> start $PKG"
adb shell am force-stop "$PKG" >/dev/null 2>&1
adb logcat -c >/dev/null 2>&1
adb shell am start -n "$PKG/.MainActivity" >/dev/null 2>&1
sleep 10

echo "==> start the service and open the panel"
for _ in $(seq 1 10); do
    dump panel
    if grep -aq 'toolbar_row' "$OUT/panel.xml"; then
        break
    fi
    if grep -aq '崩溃' "$OUT/panel.xml"; then
        echo '    the crash dialog of the app is open - dismiss it'
        bash "$ROOT/tools/tap_text.sh" '确定' 2 >/dev/null 2>&1
        sleep 4
        continue
    fi
    bash "$ROOT/tools/tap_text.sh" '开始' 1 >/dev/null 2>&1 && sleep 6
    adb shell input tap 48 72 >/dev/null 2>&1   # the floating icon
    sleep 3
done
if ! grep -aq 'toolbar_row' "$OUT/panel.xml"; then
    echo "!! the panel is not open" >&2
    python3 "$ROOT/tools/uix.py" "$OUT/panel.xml" >&2
    exit 1
fi
echo "    the panel is open: $(python3 "$ROOT/tools/uix.py" "$OUT/panel.xml" | grep -a 'app_name' | head -1)"

echo "==> attach the target process"
adb shell input tap 32 178 >/dev/null 2>&1    # process_pause -> the process list
sleep 4
for _ in $(seq 1 12); do
    dump procs
    LINE=$(python3 "$ROOT/tools/uix.py" "$OUT/procs.xml" | grep -aF '[2424]' | head -1)
    if [ -n "$LINE" ]; then
        echo "    $LINE"
        COORD=$(printf '%s' "$LINE" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
        set -- $COORD
        adb shell input tap "$1" "$2" >/dev/null 2>&1
        sleep 6
        break
    fi
    adb shell input swipe 360 1000 360 400 400 >/dev/null 2>&1
    sleep 2
done
dump panel
echo "    attached: $(python3 "$ROOT/tools/uix.py" "$OUT/panel.xml" | grep -a 'app_name' | head -1)"
echo '==> the more menu of the panel'
adb shell input tap 675 254 >/dev/null 2>&1   # more_btn
sleep 5
dump menu
MENU=$(python3 "$ROOT/tools/uix.py" "$OUT/menu.xml" | grep -a '搜索' | head -1)
echo "    $MENU"
if [ -z "$MENU" ]; then
    echo '!! the more menu has no search entry' >&2
    python3 "$ROOT/tools/uix.py" "$OUT/menu.xml" >&2
    exit 1
fi
COORD=$(printf '%s' "$MENU" | sed -n 's/.*center=(\([0-9]*\),\([0-9]*\)).*/\1 \2/p')
set -- $COORD
adb shell input tap "$1" "$2" >/dev/null 2>&1
sleep 5
dump dialog
if ! grep -aq ':id/number' "$OUT/dialog.xml"; then
    echo "!! the value search dialog is not open" >&2
    python3 "$ROOT/tools/uix.py" "$OUT/dialog.xml" >&2
    exit 1
fi
echo "    the field is '$(number dialog)'"

echo "==> type 999"
for _ in 1 2 3; do
    adb shell input tap 356 780 >/dev/null 2>&1
    sleep 1
done
sleep 2
dump typed
echo "    the field is '$(number typed)'"

echo "==> run the search"
adb shell input tap 598 1173 >/dev/null 2>&1
sleep 15
adb shell screencap -p /sdcard/srch.png >/dev/null 2>&1
adb pull /sdcard/srch.png "$OUT/results.png" >/dev/null 2>&1
dump results

echo "==> the rows of the result list"
python3 - "$OUT/results.xml" <<'PY'
import re, sys
s = open(sys.argv[1]).read()
rows = []
tags = []
for m in re.finditer(r'<node[^>]*text="([^"]*)"[^>]*bounds="(\[\d+,\d+\]\[\d+,\d+\])"', s):
    t = m.group(1).strip()
    b = [int(x) for x in re.findall(r'\d+', m.group(2))]
    if re.match(r'^[0-9A-Fa-f]{6,}$', t):
        rows.append((t, b[1], b[3], m.group(2)))
    elif re.match(r'^(D|W|B|Q|F|X|A|C|Ca|Cb|Cd|Ch|Cs|Jh|PS|[A-Z]{1,2})$', t):
        tags.append((t, m.group(2)))
for r in rows[:12]:
    print('   address %-14s top=%-5d bottom=%-5d %s' % r)
tops = [r[1] for r in rows]
if len(tops) > 1:
    print('   pitch: %s' % [tops[i + 1] - tops[i] for i in range(len(tops) - 1)])
print('   type/area tags: %s' % tags[:8])
PY

echo '==> daemon log'
adb logcat -d -v time 2>/dev/null | grep -aE 'sendSearchNumber|searchNumber|searchDone' | tail -4
exit 0

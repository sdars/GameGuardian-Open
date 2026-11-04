#!/usr/bin/env python3
"""Drive one GameGuardian build through the value search on the device.

    python3 tools/search_flow.py <package> <tag> <pid> [value] [type]

The script talks to the real device (no mock, no local stand in): it starts
the package, attaches the target process, opens the value search dialog of
the panel, types the value with the internal keypad of the app, runs the
search and reads the result list back from the screen.

Every step is logged to stdout so that the run can be watched while it is
going on; the uiautomator dumps of the device are kept in build/flow.
"""
import os
import re
import sys
import time

sys.path.insert(0, '/root/gameguardian/tools')
import adlib  # noqa: E402


# The keypad that the app draws is a 5 x 2 grid, but the touch handler of
# the original walks the keys in the order 1 2 3 4 5 / 6 7 8 9 0.
KEYS = {
    '1': (78, 684), '2': (170, 684), '3': (263, 684),
    '4': (356, 684), '5': (450, 684),
    '6': (78, 780), '7': (170, 780), '8': (263, 780),
    '9': (356, 780), '0': (450, 780),
}

PANEL = '/root/gameguardian/build/flow'


def log(msg):
    print('    %s' % msg, flush=True)


def node_by_id(xml, rid):
    return adlib.find(xml, rid=rid)


def node_by_text(xml, text, exact=False):
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if not t:
            continue
        if (t == text) if exact else (text in t):
            return n
    return None


def tap_node(n, what):
    x, y = adlib.centre(n)
    log('tap %s at %d,%d' % (what, x, y))
    adlib.tap(x, y)


def rows_of(xml):
    """the rows of the result list: address, value, type, region"""
    out = []
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if not t or not n['bounds']:
            continue
        out.append((t, n['bounds']))
    return out


def print_rows(xml, title):
    print('   -- %s' % title, flush=True)
    for t, b in rows_of(xml):
        if t in ('开始', '确定', '取消', '帮助', '修复', '退出'):
            continue
        print('      %-28s %s' % (t, b), flush=True)


def main():
    pkg = sys.argv[1]
    tag = sys.argv[2]
    pid = sys.argv[3]
    value = sys.argv[4] if len(sys.argv) > 4 else '999'
    want_type = sys.argv[5] if len(sys.argv) > 5 else 'Dword'

    print('==> package %s tag %s pid %s value %s type %s'
          % (pkg, tag, pid, value, want_type), flush=True)

    for other in ('com.utnciuwv.ldcsra', 'com.wrw', pkg):
        adlib.sh('am force-stop %s' % other)
    adlib.adb('logcat', '-c')
    adlib.sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(12)

    xml = adlib.dump(tag, 'main')
    crash = node_by_text(xml, '崩溃')
    if crash:
        log('a crash dialog is open')
        tap_node(node_by_text(xml, '确定', exact=True) or crash, 'the crash dialog')
        time.sleep(5)
        xml = adlib.dump(tag, 'main2')
    start = node_by_text(xml, '开始', exact=True)
    if start:
        tap_node(start, '开始')
        time.sleep(8)

    # the panel and the process list are two windows of the app: as long as
    # no target is attached the app shows the list of the processes, and the
    # panel comes up after one of them has been picked
    print('==> attach the process %s' % pid, flush=True)
    xml = ''
    for attempt in range(8):
        xml = adlib.dump(tag, 'main%d' % attempt)
        if node_by_id(xml, 'toolbar_row'):
            break
        row = None
        for n in adlib.nodes(xml):
            if ('[%s]' % pid) in n['text']:
                row = n
                break
        if row is not None:
            log('the process list is open, pick %s' % pid)
            tap_node(row, 'the target process')
            time.sleep(8)
            continue
        log('the panel is not up yet, tap the floating icon')
        adlib.tap(48, 72)
        time.sleep(6)
    if not node_by_id(xml, 'toolbar_row'):
        print('!! the panel did not open', flush=True)
        print_rows(xml, 'panel')
        return 1
    log('the panel is open')

    print('==> the target of the panel', flush=True)
    nm = node_by_id(xml, 'app_name')
    if not nm or ('[%s]' % pid) not in nm['text']:
        pc = node_by_id(xml, 'process_pause')
        if pc:
            tap_node(pc, 'process_pause')
            time.sleep(5)
        xml = adlib.dump(tag, 'procs')
        row = None
        for n in adlib.nodes(xml):
            if ('[%s]' % pid) in n['text']:
                row = n
                break
        if row is None:
            print('!! the process %s is not in the list' % pid, flush=True)
            print_rows(xml, 'processes')
            return 1
        log('the target row is %r' % row['text'])
        tap_node(row, 'the target process')
        time.sleep(8)
        xml = adlib.dump(tag, 'panel2')
    nm = node_by_id(xml, 'app_name')
    log('attached: %r' % (nm['text'] if nm else '?'))

    print('==> the memory list (the opcode column)', flush=True)
    mt = node_by_id(xml, 'memory_tab_icon')
    if mt:
        tap_node(mt, 'memory_tab_icon')
        time.sleep(6)
        mx = adlib.dump(tag, 'mem')
        print_rows(mx, 'the memory list')
        adlib.screencap('%s_mem' % tag)
        # back to the search tab
        st = node_by_id(adlib.dump(tag, 'mem2'), 'search_tab_icon')
        if st:
            tap_node(st, 'search_tab_icon')
            time.sleep(4)

    print('==> the more menu of the panel', flush=True)
    adlib.tap(675, 254)
    time.sleep(5)
    xml = adlib.dump(tag, 'menu')
    entry = node_by_text(xml, '已知（精确）搜索')
    if entry is None:
        entry = node_by_text(xml, '搜索')
    if entry is None:
        print('!! the more menu has no search entry', flush=True)
        print_rows(xml, 'menu')
        return 1
    tap_node(entry, 'the exact search')
    time.sleep(5)

    xml = adlib.dump(tag, 'dialog')
    num = node_by_id(xml, 'number')
    if num is None:
        print('!! the value search dialog is not open', flush=True)
        print_rows(xml, 'dialog')
        return 1
    tap_node(num, 'the number field')
    time.sleep(2)

    # the field is filled with the value of the last search, clear it
    adlib.sh('input keyevent 123')          # KEYCODE_MOVE_END
    time.sleep(1)
    for _ in range(14):
        adlib.sh('input keyevent 67')        # KEYCODE_DEL
        time.sleep(0.35)
    xml = adlib.dump(tag, 'cleared')
    num = node_by_id(xml, 'number')
    log('the field after the clear is %r' % (num['text'] if num else '?'))

    print('==> type %r' % value, flush=True)
    for ch in value:
        if ch not in KEYS:
            print('!! the key %r is not on the keypad' % ch, flush=True)
            return 1
        x, y = KEYS[ch]
        adlib.tap(x, y)
        time.sleep(1.2)
    time.sleep(2)

    if want_type:
        print('==> the type %s' % want_type, flush=True)
        xml = adlib.dump(tag, 'dialog2')
        ty = node_by_id(xml, 'type')
        if ty:
            tap_node(ty, 'the type spinner')
            time.sleep(4)
            xml = adlib.dump(tag, 'type')
            item = node_by_text(xml, want_type)
            if item is None:
                print('!! the type list has no %r' % want_type, flush=True)
                print_rows(xml, 'the type list')
            else:
                tap_node(item, 'the type %s' % want_type)
                time.sleep(4)

    xml = adlib.dump(tag, 'typed')
    num = node_by_id(xml, 'number')
    log('the field is %r' % (num['text'] if num else '?'))
    ty = node_by_id(xml, 'type')
    log('the type is %r' % (ty['text'] if ty else '?'))
    adlib.screencap('%s_typed' % tag)

    print('==> run the search', flush=True)
    adlib.tap(598, 1173)
    time.sleep(25)
    adlib.screencap('%s_results' % tag)
    xml = adlib.dump(tag, 'results')
    print_rows(xml, 'the result list')

    cnt = node_by_id(xml, 'found_count')
    log('found_count is %r' % (cnt['text'] if cnt else '?'))
    st = node_by_id(xml, 'status_bar')
    log('status_bar is %r' % (st['text'] if st else '?'))

    print('==> the daemon log', flush=True)
    for line in adlib.logcat().splitlines():
        if re.search(r'sendSearchNumber|searchNumber|searchDone|searchText', line):
            print('      %s' % line, flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

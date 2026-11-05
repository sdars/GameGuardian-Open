#!/usr/bin/env python3
"""Check the value search of a build on a real device.

    python3 tools/search_verify.py <package> <tag> <pid> [value] [type]

The script attaches the target with the same routine as the speed panel
test (``adlib.attach``), opens the exact value search of the floating
panel, types the value, runs the search and prints the answer of the
daemon out of the log.  Nothing is mocked: the panel, the daemon and the
target process are the ones of the device.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

KEYS = {
    '1': (78, 684), '2': (170, 684), '3': (263, 684),
    '4': (356, 684), '5': (450, 684),
    '6': (78, 780), '7': (170, 780), '8': (263, 780),
    '9': (356, 780), '0': (450, 780),
}


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
    pkg, tag = sys.argv[1], sys.argv[2]
    pid = sys.argv[3]
    value = sys.argv[4] if len(sys.argv) > 4 else '777'
    want_type = sys.argv[5] if len(sys.argv) > 5 else 'Dword'

    if not pid.isdigit():
        # a package name: the process of it is looked up right before the
        # run, the device restarts the processes of the apps
        out = adlib.sh('pidof %s' % pid, timeout=120).strip().split()
        if not out:
            print('!! %s is not running' % pid)
            return 1
        pid = out[0]

    print('==> package %s tag %s pid %s value %s type %s'
          % (pkg, tag, pid, value, want_type), flush=True)
    adlib.attach(tag, pkg, pid)
    xml = adlib.dump(tag, 'panel')
    if not node_by_id(xml, 'toolbar_row'):
        print('!! the panel did not open', flush=True)
        print_rows(xml, 'panel')
        return 1

    print('==> the more menu of the panel', flush=True)
    adlib.tap(675, 254)
    time.sleep(5)
    xml = adlib.dump(tag, 'menu')
    entry = node_by_text(xml, '已知（精确）搜索') or node_by_text(xml, '搜索')
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
    adlib.sh('input keyevent 123')
    time.sleep(1)
    for _ in range(14):
        adlib.sh('input keyevent 67')
        time.sleep(0.3)

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

    print('==> run the search', flush=True)
    adlib.tap(598, 1173)
    time.sleep(30)
    adlib.screencap('%s_results' % tag)
    xml = adlib.dump(tag, 'results')
    print_rows(xml, 'the result list')
    cnt = node_by_id(xml, 'found_count')
    log('found_count is %r' % (cnt['text'] if cnt else '?'))
    st = node_by_id(xml, 'status_bar')
    log('status_bar is %r' % (st['text'] if st else '?'))

    print('==> the daemon log', flush=True)
    for line in adlib.logcat().splitlines():
        if re.search(r'sendSearchNumber|searchNumber|searchDone|searchText|VM_FAIL|Report Error', line):
            print('      %s' % line, flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

#!/usr/bin/env python3
"""Drive one GameGuardian build through the value search and print what it
shows, so that the reconstruction and the original can be compared.

    tools/ab_flow.py <package> <tag> <pid> [value]

The script uses the shipped code path only:

    start -> 开始 -> the floating icon -> the panel -> the process list ->
    the process -> the memory tab (the list with the opcode columns) -> the
    more menu -> the value search -> the type -> 新搜索 -> the result list

Every step is verified with an uiautomator dump, so the script follows the
widgets of the app instead of a fixed coordinate whenever it can.
"""
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

adb = adlib.adb
sh = adlib.sh
tap = adlib.tap
dump = adlib.dump
nodes = adlib.nodes
find = adlib.find
centre = adlib.centre


def click_text(xml, text, exact=False):
    for node in nodes(xml):
        t = node['text'].strip()
        if not t:
            continue
        if (t == text) if exact else (text in t):
            if node['bounds']:
                x, y = centre(node)
                tap(x, y)
                return (x, y)
    return None


def open_panel(tag):
    """start the app and open the floating panel"""
    for _ in range(12):
        xml = dump(tag, 'panel')
        if 'toolbar_row' in xml:
            return xml
        if '崩溃' in xml:
            click_text(xml, '确定')
            time.sleep(4)
            continue
        # the dialog that reports that the last run of the app failed
        if '忽略' in xml:
            click_text(xml, '忽略')
            time.sleep(4)
            continue
        icon = find(xml, rid='hot_point_icon')
        if icon:
            x, y = centre(icon)
            tap(x, y)
            time.sleep(4)
            continue
        if find(xml, rid='btn_start_usage'):
            # the launcher screen: start the service
            click_text(xml, '开始')
            time.sleep(6)
            continue
        # the floating icon is a window of its own, uiautomator does not
        # dump it - it sits in the top left corner of the screen (the
        # position that the app stores in its preferences).
        tap(48, 72)
        time.sleep(4)
    return dump(tag, 'panel')


def attach(tag, pid):
    """open the process list and attach to the given pid"""
    xml = dump(tag, 'panel2')
    btn = None
    for node in nodes(xml):
        if 'process' in node['rid'] and node['bounds']:
            btn = node
            break
    if btn:
        x, y = centre(btn)
        tap(x, y)
    else:
        tap(32, 178)
    time.sleep(4)
    for _ in range(14):
        xml = dump(tag, 'procs')
        for node in nodes(xml):
            if '[%s]' % pid in node['text']:
                x, y = centre(node)
                tap(x, y)
                time.sleep(8)
                return node['text'].strip()
        sh('input swipe 360 1000 360 400 400')
        time.sleep(2)
    return None


def memory_rows(tag):
    """the rows of the memory list - they carry the opcode columns"""
    xml = dump(tag, 'main')
    tab = find(xml, rid='memory_tab_icon')
    if tab:
        x, y = centre(tab)
        tap(x, y)
        time.sleep(6)
    xml = dump(tag, 'mem')
    rows = []
    for node in nodes(xml):
        rid = node['rid'].split('/')[-1]
        if rid.startswith('value_') or rid in ('address', 'addr_item_region',
                                               'name', 'type'):
            rows.append((rid, node['text']))
    return xml, rows


def search(tag, value):
    """open the value search, enter the value and run it"""
    tap(675, 254)
    time.sleep(5)
    xml = dump(tag, 'menu')
    pos = click_text(xml, '搜索')
    if not pos:
        return None, 'the more menu has no search entry'
    time.sleep(5)
    xml = dump(tag, 'dialog')
    num = find(xml, rid='/number')
    if not num:
        return None, 'the value search dialog is not open'
    x, y = centre(num)
    tap(x, y)
    time.sleep(1)
    sh('input text ' + value)
    time.sleep(2)
    xml = dump(tag, 'typed')
    num = find(xml, rid='/number')
    typed = num['text'] if num else ''
    if value not in typed:
        # the app draws its own keypad, the touch handler of the original
        # walks a five column grid - the key that inserts a nine sits in the
        # second row, column four.
        for _ in value:
            tap(356, 780)
            time.sleep(1)
        xml = dump(tag, 'typed')
        num = find(xml, rid='/number')
        typed = num['text'] if num else ''
    # the type of the search: Dword
    typedlg = find(xml, ridpart='select_dialog_listview')
    if typedlg:
        item = find(xml, contains='Dword')
        if item:
            x, y = centre(item)
            tap(x, y)
            time.sleep(8)
    pos = click_text(xml, '新搜索')
    if not pos:
        pos = click_text(xml, '搜索')
    time.sleep(10)
    xml = dump(tag, 'results')
    return xml, 'typed=%r' % typed


def main():
    pkg = sys.argv[1]
    tag = sys.argv[2]
    pid = sys.argv[3]
    value = sys.argv[4] if len(sys.argv) > 4 else '999'

    for other in ('com.utnciuwv.ldcsra', 'com.wrw'):
        if other != pkg:
            sh('am force-stop ' + other)
    sh('am force-stop ' + pkg)
    time.sleep(2)
    adb('logcat', '-c')
    sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(10)

    xml = open_panel(tag)
    title = find(xml, rid='app_name')
    print('== the app in the foreground: %s' % (title['text'] if title else '?'))
    if 'toolbar_row' not in xml:
        print('== the panel is not open')
        for node in nodes(xml):
            if node['text'].strip():
                print('   %-30s %s' % (node['text'].strip()[:30], node['bounds']))
        return 1
    print('== the panel is open')

    line = attach(tag, pid)
    print('== attached to: %s' % (line or 'NOT FOUND'))

    xml, rows = memory_rows(tag)
    print('== the rows of the memory list')
    for rid, txt in rows:
        print('   %-16s %r' % (rid, txt))

    xml, note = search(tag, value)
    print('== the search: %s' % note)
    if xml is None:
        return 1
    print('== the rows of the result list')
    for node in nodes(xml):
        txt = node['text'].strip()
        if txt and node['bounds']:
            print('   %-24s %s' % (txt[:24], node['bounds']))
    return 0


if __name__ == '__main__':
    sys.exit(main())

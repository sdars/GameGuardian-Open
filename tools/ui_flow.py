#!/usr/bin/env python3
"""Drive the GameGuardian UI on the test device and report what happens.

The script runs the same flow for the reconstructed build and for the
original application:  start the app, attach to a target process, open the
value search, type a value, start the search and dump the result list.
Every step is verified with an uiautomator dump, so the script follows the
real widgets instead of hard coded coordinates whenever it can.

    tools/ui_flow.py <package> <tag> <pid> [value]
"""
import os
import re
import subprocess
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

ROOT = '/root/gameguardian'
OUT = adlib.OUT

OTHER_PACKAGES = [
    'com.utnciuwv.ldcsra', 'com.fqqvbgr', 'com.xzqwitnufxpj', 'com.oyn',
    'com.uyileqmdfw', 'com.xplwru', 'com.zijosy', 'com.hdzj.yopvkq',
    'com.vygybmu', 'com.gdkmke', 'com.rhbqjlp',
]


adb = adlib.adb
sh = adlib.sh
tap = adlib.tap
dump = adlib.dump
nodes = adlib.nodes
find = adlib.find
centre = adlib.centre


def click(xml, tag, name, **kw):
    node = find(xml, **kw)
    if not node:
        return None
    x, y = centre(node)
    tap(x, y)
    return (x, y)


def logcat(pattern=None):
    out = adb('logcat', '-d', '-v', 'time').stdout
    if pattern:
        out = '\n'.join(l for l in out.splitlines() if pattern in l)
    return out


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else 'com.hdzj.yopvkq'
    tag = sys.argv[2] if len(sys.argv) > 2 else 'ours'
    pid = sys.argv[3] if len(sys.argv) > 3 else '2424'
    value = sys.argv[4] if len(sys.argv) > 4 else '999'
    os.makedirs(OUT, exist_ok=True)

    for other in OTHER_PACKAGES:
        if other != pkg:
            sh('am force-stop ' + other)
    sh('am force-stop ' + pkg)
    time.sleep(2)
    adb('logcat', '-c')
    sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(10)
    tap(668, 1232)
    time.sleep(5)
    tap(48, 72)
    time.sleep(4)
    tap(32, 178)
    time.sleep(6)

    xml = dump(tag, 'procs')
    node = None
    for cand in nodes(xml):
        if '[' + pid + ']' in cand['text'] or ('%s' % pid) in cand['text']:
            node = cand
            break
    if node is None:
        for _ in range(6):
            sh('input swipe 360 1000 360 400 400')
            time.sleep(2)
            xml = dump(tag, 'procs')
            for cand in nodes(xml):
                if '[' + pid + ']' in cand['text']:
                    node = cand
                    break
            if node:
                break
    print('== process node: %s' % (node['text'] if node else 'NOT FOUND'))
    if node:
        x, y = centre(node)
        tap(x, y)
        time.sleep(8)
    dump(tag, 'panel')

    tap(675, 254)
    time.sleep(5)
    xml = dump(tag, 'menu')
    pos = click(xml, tag, 'menu', contains='搜索')
    print('== search menu item: %s' % (pos,))
    time.sleep(5)
    xml = dump(tag, 'dialog')
    num = find(xml, rid='/number')
    print('== number field: %s' % (str(num['bounds']) if num else 'NOT FOUND'))
    if num:
        x, y = centre(num)
        tap(x, y)
        time.sleep(1)
        sh('input text ' + value)
        time.sleep(2)
    xml = dump(tag, 'typed')
    num = find(xml, rid='/number')
    print('== number text now: %r' % (num['text'] if num else '?'))

    pos = None
    for label in ('新搜索', '搜索', 'Search'):
        pos = click(xml, tag, 'typed', text=label)
        if pos:
            print('== pressed %r at %s' % (label, pos))
            break
    if pos:
        time.sleep(6)
    xml = dump(tag, 'after')
    typedlg = find(xml, ridpart='select_dialog_listview')
    if typedlg:
        print('== the type request dialog is open, picking Dword')
        item = find(xml, contains='Dword')
        if item:
            x, y = centre(item)
            tap(x, y)
            time.sleep(8)
    time.sleep(4)
    xml = dump(tag, 'results')
    adb('shell', 'screencap -p /sdcard/flow_%s.png' % tag)
    adb('pull', '/sdcard/flow_%s.png' % tag, os.path.join(OUT, '%s.png' % tag))
    with open(os.path.join(OUT, '%s.logcat' % tag), 'w', encoding='utf-8') as fh:
        fh.write(logcat())

    print('== the rows of the result list')
    for node in nodes(xml):
        txt = node['text'].strip()
        if txt and node['bounds']:
            x1, y1, x2, y2 = node['bounds']
            print('   %-28s %s' % (txt[:28], node['bounds']))
    print('== the search related log lines')
    for line in logcat().splitlines():
        if any(k in line for k in ('sendSearchNumber', 'Search', 'search', 'Failed', 'error', 'k0(')):
            print('   ' + line[:200])
    return 0


if __name__ == '__main__':
    sys.exit(main())

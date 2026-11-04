#!/usr/bin/env python3
"""Trigger the speed hack through the floating icon of a GameGuardian build.

The floating icon (hot_point_icon) opens the speed panel on a long press, the
panel holds the two arrows (speed_dec / speed_inc) and the speed text.  The
script reports what the app showed and what the daemon logged, so that the
original and the reconstruction can be compared.

    tools/speed_hot.py <package> <tag> <pid>
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

adb = adlib.adb
sh = adlib.sh
tap = adlib.tap
dump = adlib.dump
nodes = adlib.nodes
find = adlib.find
centre = adlib.centre


def attach(pid):
    """open the process list of the floating panel and pick the target"""
    tap(48, 104)
    time.sleep(4)
    xml = dump('x', 'procs')
    node = None
    for cand in nodes(xml):
        if '[%s]' % pid in cand['text']:
            node = cand
            break
    if node is None:
        for _ in range(8):
            sh('input swipe 360 1000 360 400 400')
            time.sleep(2)
            xml = dump('x', 'procs')
            for cand in nodes(xml):
                if '[%s]' % pid in cand['text']:
                    node = cand
                    break
            if node:
                break
    print('== process: %s' % (node['text'] if node else 'NOT FOUND'))
    if node:
        x, y = centre(node)
        tap(x, y)
        time.sleep(8)
    return node is not None


def main():
    pkg = sys.argv[1]
    tag = sys.argv[2]
    pid = sys.argv[3]
    others = ['com.utnciuwv.ldcsra', 'com.fqqvbgr', 'com.xzqwitnufxpj', 'com.oyn',
              'com.uyileqmdfw', 'com.xplwru', 'com.zijosy', 'com.hdzj.yopvkq',
              'com.vygybmu', 'com.gdkmke', 'com.rhbqjlp']
    for other in others:
        if other != pkg:
            sh('am force-stop ' + other)
    sh('am force-stop ' + pkg)
    time.sleep(2)
    adb('logcat', '-c')
    sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(10)
    for _ in range(3):
        node = find(dump(tag, 'welcome'), rid='btn_start_usage')
        if node:
            x, y = centre(node)
            tap(x, y)
            time.sleep(8)
        if find(dump(tag, 'main'), rid='search_tab_icon'):
            break
    attach(pid)
    # the floating icon belongs to the overlay of the app
    xml = dump(tag, 'overlay')
    icon = find(xml, rid='hot_point_icon')
    if icon is None:
        icon = find(xml, rid='hot_frame')
    if icon is None:
        print('== no floating icon in the dump')
        for node in nodes(xml):
            if node['bounds'] and node['pkg'] == pkg:
                print('   %-20s %-14s %s' % (node['rid'], node['cls'], node['bounds']))
        return 1
    x, y = centre(icon)
    print('== floating icon at %d,%d' % (x, y))
    # long press
    sh('input swipe %d %d %d %d 900' % (x, y, x, y))
    time.sleep(4)
    xml = dump(tag, 'panel')
    inc = find(xml, rid='speed_inc')
    print('== the speed panel')
    for node in nodes(xml):
        if node['rid'] in ('speed_inc', 'speed_dec', 'speed_text', 'hot_point_icon'):
            print('   %-16s %s' % (node['rid'], node['bounds']))
    if inc is None:
        print('== no speed_inc in the panel')
        for node in nodes(xml):
            if node['bounds'] and node['pkg'] == pkg:
                print('   %-20s %-14s %s' % (node['rid'], node['cls'], node['bounds']))
        return 1
    x, y = centre(inc)
    print('== tap speed_inc at %d,%d' % (x, y))
    tap(x, y)
    time.sleep(8)
    xml = dump(tag, 'after')
    print('== the screen after the speed change')
    for node in nodes(xml):
        if node['text'].strip():
            print('   %-44s %s' % (node['text'][:44], node['bounds']))
    adb('shell', 'screencap -p /sdcard/hp_%s.png' % tag)
    adb('pull', '/sdcard/hp_%s.png' % tag, os.path.join(OUT, 'hp_%s.png' % tag))
    print('== the log of the app and the daemon')
    log = adb('logcat', '-d', '-v', 'time').stdout
    for line in log.splitlines():
        if re.search(r'AndroidService|android-daemon|Daemon', line) and re.search(
                r'speed|SP |>>|<<|rror|107|TE get|not supported|fail|Speed', line):
            print('   ' + line[:220])
    return 0


if __name__ == '__main__':
    sys.exit(main())

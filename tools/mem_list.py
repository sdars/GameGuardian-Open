#!/usr/bin/env python3
"""Dump the memory range list of a GameGuardian build on the device.

The memory list is the list that carries the disassembly columns
(value_arm / value_thumb / value_arm8 - the opcodes the user sees) and the
reversed hex column (value_rhex).  The script attaches to a target process
and prints every row of that list so that the reconstruction and the
original can be compared row by row.

    tools/mem_list.py <package> <tag> <pid>
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
OUT = adlib.OUT


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
    sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(10)
    node = find(dump(tag, 'welcome'), rid='btn_start_usage')
    if node:
        x, y = centre(node)
        tap(x, y)
        time.sleep(10)
    tap(48, 104)
    time.sleep(4)
    xml = dump(tag, 'procs')
    node = None
    for cand in nodes(xml):
        if '[%s]' % pid in cand['text']:
            node = cand
            break
    if node is None:
        for _ in range(8):
            sh('input swipe 360 1000 360 400 400')
            time.sleep(2)
            xml = dump(tag, 'procs')
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
    tab = find(dump(tag, 'main'), rid='memory_tab_icon')
    if tab:
        x, y = centre(tab)
        tap(x, y)
        time.sleep(6)
    xml = dump(tag, 'mem')
    adb('shell', 'screencap -p /sdcard/ml_%s.png' % tag)
    adb('pull', '/sdcard/ml_%s.png' % tag, os.path.join(OUT, 'ml_%s.png' % tag))
    print('== the rows of the memory list')
    for node in nodes(xml):
        if node['rid'] in ('address', 'value_hex', 'value_rhex', 'value_string',
                           'value_java', 'value_arm', 'value_thumb', 'value_arm8',
                           'value_dword', 'value_float', 'value_double', 'value_word',
                           'value_byte', 'value_qword', 'value_xor', 'addr_item_region'):
            print('   %-16s %s' % (node['rid'], repr(node['text'])))
    return 0


if __name__ == '__main__':
    sys.exit(main())

#!/usr/bin/env python3
"""Trigger the speed hack of a GameGuardian build and report the answer.

The speedometer of the search toolbar opens the list of speeds, picking one
sends the speed hack command to the daemon.  The daemon answers with the
error 107 (speedhack for this process is not supported) when it cannot
apply it - the script reports what the app showed and what the daemon
logged, so that the original and the reconstruction can be compared.

    tools/speed_ab.py <package> <tag> <pid>
"""
import os
import re
import subprocess
import sys
import time

ROOT = '/root/gameguardian'
ADB = os.path.join(ROOT, 'tmp/tools/platform-tools/adb')
SERIAL = '8.162.0.198:30138'
OUT = os.path.join(ROOT, 'build/flow')
os.makedirs(OUT, exist_ok=True)


def adb(*args, **kw):
    return subprocess.run([ADB, '-s', SERIAL] + list(args), capture_output=True,
                          text=True, timeout=kw.get('timeout', 120))


def sh(cmd, timeout=120):
    return adb('shell', cmd, timeout=timeout).stdout


def tap(x, y):
    sh('input tap %d %d' % (x, y))


def dump(tag, name):
    path = '/sdcard/sp_%s_%s.xml' % (tag, name)
    adb('shell', 'uiautomator dump %s' % path)
    local = os.path.join(OUT, 'sp_%s_%s.xml' % (tag, name))
    adb('pull', path, local)
    try:
        return open(local, encoding='utf-8', errors='ignore').read()
    except OSError:
        return ''


def nodes(xml):
    out = []
    for m in re.finditer(r'<node[^>]*>', xml):
        n = m.group(0)
        txt = re.search(r'text="([^"]*)"', n)
        rid = re.search(r'resource-id="([^"]*)"', n)
        cls = re.search(r'class="([^"]*)"', n)
        bnd = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', n)
        out.append({
            'text': (txt.group(1) if txt else ''),
            'rid': (rid.group(1).split('/')[-1] if rid else ''),
            'cls': (cls.group(1) if cls else ''),
            'bounds': tuple(int(x) for x in bnd.groups()) if bnd else None,
        })
    return out


def find(xml, **kw):
    for node in nodes(xml):
        if 'text' in kw and node['text'] != kw['text']:
            continue
        if 'contains' in kw and kw['contains'] not in node['text']:
            continue
        if 'rid' in kw and node['rid'] != kw['rid']:
            continue
        if 'cls' in kw and node['cls'] != kw['cls']:
            continue
        if node['bounds']:
            return node
    return None


def centre(node):
    x1, y1, x2, y2 = node['bounds']
    return (x1 + x2) // 2, (y1 + y2) // 2


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
    # the welcome screen, the start button starts the service
    for _ in range(3):
        node = find(dump(tag, 'welcome'), rid='btn_start_usage')
        if node:
            x, y = centre(node)
            tap(x, y)
            time.sleep(8)
        if find(dump(tag, 'main'), rid='search_tab_icon'):
            break
    # the process list of the floating panel
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
    xml = dump(tag, 'tabs')
    tab = find(xml, rid='search_tab_icon')
    if tab:
        x, y = centre(tab)
        tap(x, y)
        time.sleep(4)
    xml = dump(tag, 'search')
    # the speedometer is the 21st icon of the search toolbar
    icons = []
    for node in nodes(xml):
        if node['rid'] == '' and node['cls'].endswith('ImageButtonView') and node['bounds']:
            icons.append(node)
    print('== the icons of the search toolbar: %d' % len(icons))
    if len(icons) > 20:
        x, y = centre(icons[20])
        print('== tap the speedometer at %d,%d' % (x, y))
        tap(x, y)
        time.sleep(5)
    xml = dump(tag, 'speeds')
    print('== the speed dialog')
    for node in nodes(xml):
        if node['text'].strip():
            print('   %-20s %s' % (node['text'][:20], node['bounds']))
    item = find(xml, text='2')
    if item is None:
        item = find(xml, cls='android.widget.TextView')
    if item:
        x, y = centre(item)
        print('== pick the speed at %d,%d' % (x, y))
        tap(x, y)
        time.sleep(8)
    xml = dump(tag, 'after')
    print('== the screen after the speed change')
    for node in nodes(xml):
        if node['text'].strip():
            print('   %-40s %s' % (node['text'][:40], node['bounds']))
    adb('shell', 'screencap -p /sdcard/sp_%s.png' % tag)
    adb('pull', '/sdcard/sp_%s.png' % tag, os.path.join(OUT, 'sp_%s.png' % tag))
    print('== the log of the app and the daemon')
    log = adb('logcat', '-d', '-v', 'time').stdout
    for line in log.splitlines():
        if re.search(r'AndroidService|android-daemon', line) and re.search(
                r'speed|SP |>>|<<|error|Error|107|TE get|not supported|fail', line):
            print('   ' + line[:200])
    return 0


if __name__ == '__main__':
    sys.exit(main())

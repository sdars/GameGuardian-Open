#!/usr/bin/env python3
"""Attach the panel of the app to a running process.

    tools/attach2.py <package> [name]

The script opens the panel of the app, opens the list of the processes and
picks the row of the target.  The target is not stopped, so the process that
runs the script has to start it before.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402


def dump(tag, name, tries=2):
    """a dump that gives up instead of hanging for minutes"""
    for _ in range(tries):
        try:
            xml = adlib.adb('shell', 'uiautomator dump /sdcard/ui_%s_%s.xml' % (tag, name),
                            timeout=25).stdout
        except Exception:
            xml = ''
        if 'dumped' in xml:
            out = adlib.adb('exec-out', 'cat /sdcard/ui_%s_%s.xml' % (tag, name),
                            timeout=25).stdout
            if out:
                with open(os.path.join(adlib.OUT, 'ui_%s_%s.xml' % (tag, name)), 'w') as fh:
                    fh.write(out)
                return out
        time.sleep(1)
    return ''


def rows(xml):
    out = []
    for n in adlib.nodes(xml):
        if n['text'].strip() and n['bounds']:
            out.append(n['text'].strip())
    return out


def main():
    pkg = sys.argv[1]
    name = sys.argv[2] if len(sys.argv) > 2 else pkg
    pid = adlib.sh('pidof %s' % pkg).strip().split()
    pid = pid[0] if pid else '?'
    print('== target %s pid %s' % (pkg, pid), flush=True)
    for other in ('com.utnciuwv.ldcsra', 'com.wrw'):
        adlib.sh('am force-stop %s' % other)
    adlib.sh('am start -n com.dwgibmeuyozjuswy/.MainActivity')
    time.sleep(10)
    xml = dump('at', 'main')
    # the dialog of the selinux mode and the tips of the first start
    for _ in range(3):
        hit = False
        for n in adlib.nodes(xml):
            t = n['text'].strip()
            if t in ('忽略', 'Ignore', 'Skip') or 'SeLinux' in t or 'SELinux' in t:
                x, y = adlib.centre(n)
                print('== the selinux dialog: %s' % t, flush=True)
                adlib.tap(x, y)
                time.sleep(6)
                xml = dump('at', 'main')
                hit = True
                break
        if hit:
            continue
        for n in adlib.nodes(xml):
            if n['text'].strip() in ('开始', '\u00d7', '\u2715', '已阅读并同意', '同意并继续'):
                x, y = adlib.centre(n)
                print('== take the entry %r' % n['text'].strip(), flush=True)
                adlib.tap(x, y)
                time.sleep(6)
                xml = dump('at', 'main')
                hit = True
                break
        if not hit:
            break
    if not adlib.find(xml, rid='toolbar_row'):
        # the panel is not open yet, the icon of the app opens it
        print('== the panel is not open, the texts are:', flush=True)
        for t in rows(xml)[:25]:
            print('   %r' % t, flush=True)
        return 1
    icon = adlib.find(xml, rid='app_icon')
    if icon is not None:
        x, y = adlib.centre(icon)
        print('== open the list of the processes', flush=True)
        adlib.tap(x, y)
        time.sleep(5)
        xml = dump('at', 'list')
    for attempt in range(40):
        row = None
        for n in adlib.nodes(xml):
            if n['text'].strip().startswith('[%s]' % pid):
                row = n
                break
        if row is not None:
            x, y = adlib.centre(row)
            print('== pick %r' % row['text'].strip(), flush=True)
            adlib.tap(x, y)
            time.sleep(8)
            xml = dump('at', 'panel')
            if adlib.find(xml, rid='toolbar_row'):
                print('== attached', flush=True)
                return 0
            print('== the panel is not open yet', flush=True)
            for t in rows(xml)[:25]:
                print('   %r' % t, flush=True)
            return 1
        if not adlib.find(xml, rid='select_dialog_listview'):
            print('== the list of the processes is not open, the texts are:', flush=True)
            for t in rows(xml)[:25]:
                print('   %r' % t, flush=True)
            return 1
        adlib.sh('input swipe 360 1000 360 500 250')
        time.sleep(1.5)
        xml = dump('at', 'list%d' % attempt)
    print('== the row of the target was not found', flush=True)
    return 1


if __name__ == '__main__':
    sys.exit(main())

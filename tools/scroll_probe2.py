#!/usr/bin/env python3
"""Find the gesture that scrolls the list of the processes.

    python3 tools/scroll_probe2.py
"""
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

PKG = 'com.jjzwqi'


def rows(xml):
    out = []
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if t.startswith('['):
            out.append(t.split(chr(10))[0][:26])
    return out


def show(tag):
    xml = adlib.dump('probe2', tag)
    r = rows(xml)
    print('   first=%-28s last=%-28s n=%d' % (
        r[0] if r else '?', r[-1] if r else '?', len(r)), flush=True)
    return xml


def main():
    adlib.sh('am start -n %s/.MainActivity' % PKG)
    time.sleep(12)
    xml = adlib.dump('probe2', 'main')
    for n in adlib.nodes(xml):
        if n['text'].strip() == '开始':
            x, y = adlib.centre(n)
            print('tap 开始', flush=True)
            adlib.tap(x, y)
            time.sleep(8)
            xml = adlib.dump('probe2', 'main2')
            break
    if not rows(xml):
        # the panel of the app is an overlay, the list of the processes opens
        # with the button in its upper left corner
        print('tap 48,72', flush=True)
        adlib.tap(48, 72)
        time.sleep(8)
    show('open')
    gestures = [
        'input swipe 360 1100 360 400 300',
        'input swipe 360 1100 360 400 1200',
        'input swipe 360 1000 360 300 300',
        'input swipe 360 1200 360 200 300',
        'input swipe 100 1100 100 400 300',
        'input swipe 360 1100 360 400 300',
        'input swipe 360 1100 360 400 300',
        'input swipe 360 1100 360 400 300',
    ]
    for i, cmd in enumerate(gestures):
        adlib.sh(cmd)
        time.sleep(2)
        print('%2d %s' % (i, cmd), flush=True)
        show('g%d' % i)
    return 0


if __name__ == '__main__':
    sys.exit(main())

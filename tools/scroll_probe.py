#!/usr/bin/env python3
"""Try the gestures that scroll the list of the processes.

    python3 tools/scroll_probe.py

The script opens the list of the processes of the app on the device and
prints the first visible entry after every gesture, so that the gesture
that really moves the list can be found.
"""
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

PKG = 'com.jjzwqi'


def first_entry(xml):
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if t.startswith('['):
            return t.split(chr(10))[0]
    return '?'


def open_list():
    adlib.sh('am start -n %s/.MainActivity' % PKG)
    time.sleep(12)
    xml = adlib.dump('probe', 'main')
    for n in adlib.nodes(xml):
        if n['text'].strip() == '开始':
            x, y = adlib.centre(n)
            print('tap 开始', flush=True)
            adlib.tap(x, y)
            time.sleep(8)
            break
    return adlib.dump('probe', 'list')


def main():
    xml = open_list()
    print('start: %r' % first_entry(xml), flush=True)
    gestures = [
        ('swipe 360 1150 360 250 250', 'input swipe 360 1150 360 250 250'),
        ('swipe 360 1150 360 250 800', 'input swipe 360 1150 360 250 800'),
        ('swipe 360 1000 360 500 600', 'input swipe 360 1000 360 500 600'),
        ('swipe 360 900 360 300 1500', 'input swipe 360 900 360 300 1500'),
        ('swipe 600 1000 600 400 600', 'input swipe 600 1000 600 400 600'),
        ('swipe 360 1150 360 250 250', 'input swipe 360 1150 360 250 250'),
    ]
    for name, cmd in gestures:
        adlib.sh(cmd)
        time.sleep(3)
        xml = adlib.dump('probe', 'g%d' % len(name))
        print('%-32s -> %r' % (name, first_entry(xml)), flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

#!/usr/bin/env python3
"""Drive the start flow of the app on the device.

    python3 tools/drive_start.py [package]

The app asks for the install mode, then for the work mode (root), then it
restarts itself and installs itself under a randomised package name.  Every
step is taken from the real screen: the script dumps the ui, finds the
button and taps it.
"""
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

PKG = 'catch_.me_.if_.you_.can_'


def texts(tag):
    xml = adlib.dump(tag, 'step')
    out = []
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if t:
            out.append((t, n['bounds']))
    return xml, out


def tap_text(tag, wanted, exact=True):
    xml, items = texts(tag)
    for t, b in items:
        if (t == wanted) if exact else (wanted in t):
            if not b:
                continue
            x = (b[0] + b[2]) // 2
            y = (b[1] + b[3]) // 2
            print('   tap %r at %d,%d' % (t, x, y), flush=True)
            adlib.tap(x, y)
            return True
    print('   no %r on the screen' % wanted, flush=True)
    return False


def main():
    global PKG
    if len(sys.argv) > 1:
        PKG = sys.argv[1]
    tag = 'drv'
    steps = ['默认', '=Root', '确定', '=重启', '=忽略', '开始']
    for round_no in range(3):
        for s in steps:
            if tap_text(tag, s, exact=(s != '=Root' and s != '=重启' and s != '=忽略')):
                time.sleep(6)
        time.sleep(4)
        xml, items = texts(tag + str(round_no))
        print('   screen: %s' % [t for t, _b in items][:8], flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

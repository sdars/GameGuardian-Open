#!/usr/bin/env python3
"""Read the speed value of the floating panel back from the screen.

The panel of the floating icon shows the current speed in the text view
``speed_text`` of ``res/layout/hot_point_view.xml``.  This script opens the
panel, renders the area of that text view from the screenshot before and
after the fast forward button was pressed and prints the daemon log of the
run, so that the read back can be compared with the original.

    tools/speed_panel_readback.py <package> <tag> <pid>
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402
import speed_panel_ab  # noqa: E402

ROOT = '/root/gameguardian'
PNG = os.path.join(ROOT, 'tools', 'png_probe.py')


def render(path, x0, y0, x1, y1, step=1):
    """print the pixels of an area as ascii art (dark = '#')"""
    src = open(PNG, encoding='utf-8').read().split('w, h, px = load')[0]
    scope = {}
    exec(src, scope)  # noqa: S102
    w, h, px = scope['load'](path)
    out = []
    for y in range(y0, min(h, y1), step):
        row = ''
        for x in range(x0, min(w, x1), step):
            i = (y * w + x) * 4
            lum = (px[i] * 299 + px[i + 1] * 587 + px[i + 2] * 114) // 1000
            row += '#' if lum < 100 else ('+' if lum < 175 else '.')
        out.append('%4d %s' % (y, row))
    return '\n'.join(out)


def main():
    pkg, tag, pid = sys.argv[1], sys.argv[2], sys.argv[3]
    adlib.attach(tag, pkg, pid)
    xml = adlib.dump(tag, 'panel')
    btn = adlib.find(xml, rid='back_btn')
    if btn is not None:
        x, y = adlib.centre(btn)
        print('== hide the main panel with back_btn at %d,%d' % (x, y), flush=True)
        adlib.tap(x, y)
        time.sleep(4)
    else:
        print('!! no back_btn in the dump', flush=True)
    speed_panel_ab.PKG = pkg
    win = speed_panel_ab.windows()
    print('== the overlay windows', flush=True)
    for name, attrs, frame in win:
        print('   %-24s %-46s %s' % (name[:24], attrs[:46], frame), flush=True)
    icon = speed_panel_ab.icon_window(win)
    if icon is None:
        print('!! no floating icon window', flush=True)
        return 1
    x1, y1, x2, y2 = icon[2]
    x, y = (x1 + x2) // 2, (y1 + y2) // 2
    print('== the floating icon at %d,%d' % (x, y), flush=True)
    # the floating icon is the small overlay in the top left corner
    adlib.sh('input swipe %d %d %d %d 1500' % (x, y, x, y))
    time.sleep(5)
    win = speed_panel_ab.windows()
    print('== the overlay windows after the long press', flush=True)
    for name, attrs, frame in win:
        print('   %-24s %-46s %s' % (name[:24], attrs[:46], frame), flush=True)
    panel = speed_panel_ab.panel_window(win)
    if panel is None:
        print('!! the speed panel did not open', flush=True)
        return 1
    px1, py1, px2, py2 = panel[2]
    print('== the speed panel is now %s' % (panel[2],), flush=True)
    shot = adlib.screencap(tag + '_before')
    print('== the panel before the button (the text view of the speed)', flush=True)
    print(render(shot, max(0, px1), max(0, py1), min(720, px2), min(1280, py2), 2), flush=True)
    adlib.tap(px2 - 58, (py1 + py2) // 2)
    time.sleep(3)
    shot = adlib.screencap(tag + '_after')
    print('== the panel after the fast forward button', flush=True)
    print(render(shot, max(0, px1), max(0, py1), min(720, px2), min(1280, py2), 2), flush=True)
    log = adlib.adb('logcat', '-d', '-v', 'time', timeout=240).stdout
    with open(os.path.join(ROOT, 'build', 'flow', 'lc_%s.txt' % tag), 'w', encoding='utf-8') as fh:
        fh.write(log)
    print('== the daemon', flush=True)
    for line in log.splitlines():
        if re.search(r'AndroidService|android-daemon', line) and re.search(
                r'>>|<<|Send code|Report Error|elf_hook|find all|_reader|SP T', line):
            print('   ' + line[:200], flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

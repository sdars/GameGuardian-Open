#!/usr/bin/env python3
"""Apply the speed hack to the process that is already attached.

    tools/speed_trigger.py [tag]

The floating icon of the panel is long pressed, the speed panel opens and
the "faster" button is pressed.  The script does not attach a process, the
target has to be attached already - it is used to put the speed hack on top
of a running freeze.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402


def main():
    tag = sys.argv[1] if len(sys.argv) > 1 else 'spd'
    xml = adlib.dump(tag, 'overlay')
    icon = adlib.find(xml, rid='hot_point_icon')
    if icon is None:
        icon = adlib.find(xml, rid='hot_frame')
    if icon is None:
        # the panel is open - the icon of the panel closes it and leaves
        # the floating button on the screen
        app_icon = adlib.find(xml, rid='app_icon')
        if app_icon is not None:
            x, y = adlib.centre(app_icon)
            print('== close the panel with the icon at %d,%d' % (x, y))
            adlib.tap(x, y)
            time.sleep(4)
            xml = adlib.dump(tag, 'overlay')
            icon = adlib.find(xml, rid='hot_point_icon')
            if icon is None:
                icon = adlib.find(xml, rid='hot_frame')
    if icon is None:
        print('== no floating icon in the dump')
        for node in adlib.nodes(xml):
            if node['bounds'] and node['pkg'] != 'com.android.launcher3':
                print('   %-20s %-14s %s' % (node['rid'], node['cls'], node['bounds']))
        return 1
    x, y = adlib.centre(icon)
    print('== the floating icon at %d,%d' % (x, y))
    adlib.sh('input swipe %d %d %d %d 900' % (x, y, x, y))
    time.sleep(4)
    xml = adlib.dump(tag, 'panel')
    inc = adlib.find(xml, rid='speed_inc')
    if inc is None:
        print('== the speed panel did not open')
        for node in adlib.nodes(xml):
            if node['bounds'] and node['pkg'] != 'com.android.launcher3':
                print('   %-20s %-14s %s' % (node['rid'], node['cls'], node['bounds']))
        return 1
    x, y = adlib.centre(inc)
    print('== the button of the speed hack at %d,%d' % (x, y))
    adlib.logcat_clear()
    adlib.tap(x, y)
    time.sleep(8)
    log = adlib.logcat()
    for line in log.splitlines():
        if re.search(r'android-daemon|AndroidService', line) and re.search(
                r'speed|SP |rror|107|fail|Speed|detach|unrestored|code', line):
            print('   ' + line[:220])
    return 0


if __name__ == '__main__':
    sys.exit(main())

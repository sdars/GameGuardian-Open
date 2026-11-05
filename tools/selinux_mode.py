#!/usr/bin/env python3
"""Switch the app into the 'work with SELinux' mode.

When the daemon of a previous run left the ``sel.txt`` marker behind, the app
starts with a dialog that offers two entries: "switch to work with SELinux"
and "ignore".  The first entry sets the ``selinux`` option of the config,
which adds the bit 4 to the flags the app sends to the daemon.  This script
clicks that entry and waits for the app to come back.
"""
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

PKG = 'com.fifunrftosjpvh'


def main():
    adlib.sh('am force-stop %s' % PKG)
    adlib.sh('am start -n %s/.MainActivity' % PKG)
    time.sleep(12)
    xml = adlib.dump('sel', 'dialog')
    item = None
    for node in adlib.nodes(xml):
        if 'SELinux' in node['text'] or 'SeLinux' in node['text']:
            item = node
            break
    if item is None:
        print('no selinux entry in the dialog')
        xml = adlib.dump('sel', 'dialog2')
        for node in adlib.nodes(xml):
            if node['text']:
                print('   %r %s' % (node['text'], node['rid']))
        return 1
    x, y = adlib.centre(item)
    print('tap the selinux entry at %s' % ((x, y),))
    adlib.tap(x, y)
    time.sleep(8)
    xml = adlib.dump('sel', 'after')
    for node in adlib.nodes(xml):
        if node['text']:
            print('   %r %s' % (node['text'], node['rid']))
    return 0


if __name__ == '__main__':
    sys.exit(main())

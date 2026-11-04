#!/usr/bin/env python3
"""Open the value format dialog of the memory list of a GameGuardian build.

    python3 tools/mem_formats.py <package> <tag> <pid> [enable-all]

The value format of the memory list decides which columns a row shows - the
hex value, the ARM/Thumb/x64 disassembly, the dword, the float and so on.
The dialog is opened by tapping the ``value_format`` field of the memory tab
and it holds one check box per format.  With ``enable-all`` every check box
is ticked and the dialog is confirmed, so that the disassembly columns are
visible in the list.
"""
import re
import sys
import time

sys.path.insert(0, '/root/gameguardian/tools')
import adlib  # noqa: E402


def log(msg):
    print('    %s' % msg, flush=True)


def find(xml, **kw):
    return adlib.find(xml, **kw)


def tap_node(n, what):
    x, y = adlib.centre(n)
    log('tap %s at %d,%d' % (what, x, y))
    adlib.tap(x, y)


def attach(tag, pkg, pid):
    for other in ('com.utnciuwv.ldcsra', 'com.wrw', pkg):
        adlib.sh('am force-stop %s' % other)
    adlib.adb('logcat', '-c')
    adlib.sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(12)
    xml = adlib.dump(tag, 'main')
    for n in adlib.nodes(xml):
        if n['text'].strip() == '开始':
            tap_node(n, '开始')
            time.sleep(8)
            break
    for attempt in range(8):
        xml = adlib.dump(tag, 'main%d' % attempt)
        if find(xml, rid='toolbar_row'):
            break
        row = None
        for n in adlib.nodes(xml):
            if ('[%s]' % pid) in n['text']:
                row = n
                break
        if row is not None:
            tap_node(row, 'the target process')
            time.sleep(8)
            continue
        adlib.tap(48, 72)
        time.sleep(6)
    if not find(xml, rid='toolbar_row'):
        print('!! the panel did not open', flush=True)
        return None
    nm = find(xml, rid='app_name')
    log('attached: %r' % (nm['text'] if nm else '?'))
    mt = find(xml, rid='memory_tab_icon')
    if mt:
        tap_node(mt, 'memory_tab_icon')
        time.sleep(6)
    return adlib.dump(tag, 'mem')


def main():
    pkg = sys.argv[1]
    tag = sys.argv[2]
    pid = sys.argv[3]
    enable = len(sys.argv) > 4 and sys.argv[4] == 'enable-all'

    xml = attach(tag, pkg, pid)
    if xml is None:
        return 1

    vf = find(xml, rid='value_format')
    log('the value format is %r' % (vf['text'] if vf else '?'))
    if vf is None:
        print('!! the memory list has no value_format field', flush=True)
        return 1
    tap_node(vf, 'value_format')
    time.sleep(4)
    dx = adlib.dump(tag, 'format')
    items = []
    for n in adlib.nodes(dx):
        if n['cls'].endswith('CheckBox') or n['cls'].endswith('CheckedTextView'):
            checked = 'checked="true"' in n['raw']
            items.append((n['text'].strip(), checked, n['bounds']))
    print('   -- the format dialog', flush=True)
    for t, c, b in items:
        print('      %-34s checked=%-5s %s' % (t, c, b), flush=True)

    if enable:
        for t, c, b in items:
            if c:
                continue
            x1, y1, x2, y2 = b
            adlib.tap((x1 + x2) // 2, (y1 + y2) // 2)
            time.sleep(1.2)
        dx = adlib.dump(tag, 'format2')
        ok = None
        for n in adlib.nodes(dx):
            if n['text'].strip() in ('是', 'Yes', 'OK'):
                ok = n
                break
        if ok:
            tap_node(ok, 'the confirmation')
        else:
            for n in adlib.nodes(dx):
                if n['cls'].endswith('Button') and n['bounds'][1] > 1000:
                    tap_node(n, 'the confirmation')
                    break
        time.sleep(5)
        xml = adlib.dump(tag, 'mem2')
        vf = find(xml, rid='value_format')
        log('the value format is now %r' % (vf['text'] if vf else '?'))

    print('   -- the memory list', flush=True)
    for n in adlib.nodes(xml):
        t = n['text'].strip()
        if t and n['bounds']:
            print('      %-30s %s' % (t, n['bounds']), flush=True)
    adlib.screencap('%s_mem' % tag)
    return 0


if __name__ == '__main__':
    sys.exit(main())

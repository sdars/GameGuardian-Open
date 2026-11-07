#!/usr/bin/env python3
"""Reproduce the failure of the speed hack on a live target.

    tools/speed_repro.py <package>

The script attaches the panel to the target, turns the speed hack on and
then looks at the memory of the target: the address that the daemon
reports as a failed write is read back from the target and the maps of
the target are compared with the maps that were taken before.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import adlib  # noqa: E402


def su(cmd, timeout=120):
    quoted = cmd.replace("'", "'\\''")
    return adlib.adb('shell', "su -c '%s'" % quoted, timeout=timeout).stdout


def target_pid(pkg):
    out = su('pidof %s' % pkg).strip()
    return int(out.split()[0]) if out else None


def maps(pid):
    return su('cat /proc/%d/maps' % pid)


def read(pid, addr, size):
    page = addr & ~0xfff
    out = su('dd if=/proc/%d/mem bs=4096 skip=%d count=1 2>/dev/null | od -A n -v -t x1'
             % (pid, page >> 12))
    try:
        data = bytes.fromhex(''.join(out.split()))
    except ValueError:
        return b''
    return data[addr - page:addr - page + size]


def main():
    pkg = sys.argv[1] if len(sys.argv) > 1 else 'com.gg.freezeprobe'
    pid = target_pid(pkg)
    print('== target %s pid %s' % (pkg, pid), flush=True)
    before = maps(pid)
    with open('/tmp/repro_before.maps', 'w') as fh:
        fh.write(before)
    adlib.logcat_clear()
    xml = adlib.dump('spd', 'overlay')
    icon = adlib.find(xml, rid='hot_point_icon') or adlib.find(xml, rid='hot_frame')
    if icon is None:
        app_icon = adlib.find(xml, rid='app_icon')
        if app_icon is not None:
            x, y = adlib.centre(app_icon)
            adlib.tap(x, y)
            time.sleep(4)
            xml = adlib.dump('spd', 'overlay2')
            icon = adlib.find(xml, rid='hot_point_icon') or adlib.find(xml, rid='hot_frame')
    if icon is None:
        print('!! no floating icon', flush=True)
        for node in adlib.nodes(xml):
            if node['bounds'] and node['pkg'] != 'com.android.launcher3':
                print('   %-22s %-16s %s' % (node['rid'], node['cls'], node['bounds']))
        return 1
    x, y = adlib.centre(icon)
    print('== long press the icon at %d,%d' % (x, y), flush=True)
    adlib.sh('input swipe %d %d %d %d 900' % (x, y, x, y))
    time.sleep(5)
    xml = adlib.dump('spd', 'panel')
    inc = adlib.find(xml, rid='speed_inc')
    if inc is None:
        print('!! the speed panel did not open', flush=True)
        for node in adlib.nodes(xml):
            if node['bounds'] and node['pkg'] != 'com.android.launcher3':
                print('   %-22s %-16s %s' % (node['rid'], node['cls'], node['bounds']))
        return 1
    x, y = adlib.centre(inc)
    print('== press the faster button at %d,%d' % (x, y), flush=True)
    adlib.tap(x, y)
    time.sleep(12)
    log = adlib.logcat()
    with open('/tmp/repro.log', 'w') as fh:
        fh.write(log)
    fails = re.findall(r'check fail \((\d+) != (\d+)\), error (\d+): (.*)', log)
    addrs = re.findall(r'PTRACE_POKEDATA addr: ([0-9a-f]+)', log)
    print('== the daemon reports %d check failures' % len(fails), flush=True)
    for f in fails[:10]:
        print('   expected %s read %s error %s %s' % f, flush=True)
    for a in addrs[:10]:
        addr = int(a, 16)
        data = read(pid, addr, 64)
        print('== target memory at 0x%x:' % addr, flush=True)
        print('   ' + ' '.join('%02x' % b for b in data), flush=True)
    after = maps(pid)
    with open('/tmp/repro_after.maps', 'w') as fh:
        fh.write(after)
    old = set(before.splitlines())
    new = [l for l in after.splitlines() if l not in old]
    print('== new mappings of the target:', flush=True)
    for l in new:
        print('   ' + l, flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

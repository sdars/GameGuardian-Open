#!/usr/bin/env python3
"""Run the speed panel of a build against a list of targets and report it.

For every target process the script attaches the package, opens the speed
panel of the floating icon, presses the fast forward button and reads the
answer of the daemon out of the log.  The answer is the interesting part:
the daemon writes "Report Error: <code>" when it cannot install the hook
into the target, and the app turns 107 into "此进程不支持变速".

    tools/speed_matrix.py <package> <tag> <pid>[,<pid>...]

The lines of the log of the run are kept in build/flow/lc_<tag>_<pid>.txt,
the summary of the run is printed as a table.
"""
import os
import re
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402
import speed_panel_ab  # noqa: E402

ROOT = '/root/gameguardian'


def verdict(log):
    """the answer of the daemon of one run"""
    errors = re.findall(r'Report Error: (\d+)', log)
    hook32 = re.findall(r'elf_hook_sections32 Find \d+ [^:]*: ([0-9a-f]+)', log)
    hook64 = re.findall(r'elf_hook_sections64 Find \d+ [^:]*: ([0-9a-f]+)', log)
    codes = re.findall(r'Send code: (\d+)', log)
    pkg = re.findall(r'package name: (\S+)', log)
    return {
        'package': pkg[-1] if pkg else '?',
        'errors': errors,
        'hook32': [h for h in hook32 if h != '0'],
        'hook64': [h for h in hook64 if h != '0'],
        'codes': codes,
    }


def one(pkg, tag, pid):
    """the speed panel of one target, returns the verdict"""
    # the package of the target must not be stopped while the app is started
    keep = []
    for line in adlib.sh('ps -A -o PID,NAME', timeout=90).splitlines():
        parts = line.split()
        if len(parts) >= 2 and parts[0] == str(pid):
            keep.append(parts[1])
            break
    adlib.attach(tag, pkg, pid, keep=keep)
    xml = adlib.dump(tag, 'panel')
    btn = adlib.find(xml, rid='back_btn')
    if btn is not None:
        x, y = adlib.centre(btn)
        adlib.tap(x, y)
        time.sleep(4)
    speed_panel_ab.PKG = pkg
    win = speed_panel_ab.windows()
    icon = speed_panel_ab.icon_window(win)
    if icon is None:
        print('   !! no floating icon', flush=True)
        return None
    x1, y1, x2, y2 = icon[2]
    x, y = (x1 + x2) // 2, (y1 + y2) // 2
    adlib.sh('input swipe %d %d %d %d 1500' % (x, y, x, y))
    time.sleep(5)
    win = speed_panel_ab.windows()
    panel = speed_panel_ab.panel_window(win)
    if panel is None:
        print('   !! the speed panel did not open', flush=True)
        return None
    px1, py1, px2, py2 = panel[2]
    adlib.tap(px2 - 58, (py1 + py2) // 2)
    time.sleep(8)
    log = adlib.adb('logcat', '-d', '-v', 'time', timeout=240).stdout
    with open(os.path.join(ROOT, 'build', 'flow', 'lc_%s_%s.txt' % (tag, pid)),
              'w', encoding='utf-8') as fh:
        fh.write(log)
    return verdict(log)


def main():
    pkg, tag = sys.argv[1], sys.argv[2]
    pids = sys.argv[3].split(',')
    print('== %s (%s)' % (pkg, tag), flush=True)
    for pid in pids:
        print('== target %s' % pid, flush=True)
        v = one(pkg, tag, pid)
        if v is None:
            continue
        print('   package=%s errors=%s hook32=%s hook64=%s codes=%s' % (
            v['package'], v['errors'] or 'none', v['hook32'] or '-',
            v['hook64'] or '-', v['codes']), flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

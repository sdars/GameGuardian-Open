#!/usr/bin/env python3
"""Shared helpers for the scripts that drive the remote device.

The device sits behind a slow mobile link that drops often.  Every command
goes through a reconnecting wrapper and every UI dump is read with
``exec-out cat`` instead of ``adb pull`` so that a half transferred file can
never be mistaken for an empty dump.
"""
import os
import re
import subprocess
import sys
import time

ROOT = '/root/gameguardian'
ADB = os.path.join(ROOT, 'tmp/tools/platform-tools/adb')
SERIAL = '8.162.0.198:30138'
OUT = os.path.join(ROOT, 'build/flow')
os.makedirs(OUT, exist_ok=True)


def _run(args, timeout):
    return subprocess.run([ADB, '-s', SERIAL] + list(args), capture_output=True,
                          text=True, timeout=timeout, errors='replace')


def _run_bin(args, timeout):
    """same as _run but keeps the payload binary (screenshots, dex files)"""
    return subprocess.run([ADB, '-s', SERIAL] + list(args), capture_output=True,
                          timeout=timeout)


def reconnect():
    try:
        subprocess.run([ADB, 'disconnect', SERIAL], capture_output=True,
                       text=True, timeout=30)
        time.sleep(1)
        subprocess.run([ADB, 'connect', SERIAL], capture_output=True,
                       text=True, timeout=30)
    except subprocess.TimeoutExpired:
        pass


def adb(*args, **kw):
    """run one adb command, reconnecting and retrying when the link drops"""
    timeout = kw.get('timeout', 90)
    last = None
    for attempt in range(4):
        try:
            r = _run(args, timeout)
            if r.returncode == 0:
                return r
            last = r
        except subprocess.TimeoutExpired as exc:
            last = exc
        reconnect()
        time.sleep(1)
    if isinstance(last, subprocess.TimeoutExpired):
        raise last
    return last


def sh(cmd, timeout=90):
    return adb('shell', cmd, timeout=timeout).stdout


def tap(x, y):
    sh('input tap %d %d' % (x, y))


def dump(tag, name):
    """uiautomator dump, read back with exec-out and keep it on disk"""
    path = '/sdcard/ui_%s_%s.xml' % (tag, name)
    adb('shell', 'rm -f %s' % path)
    for _ in range(3):
        out = adb('shell', 'uiautomator dump %s' % path, timeout=120).stdout
        if 'ERROR' not in out and 'dumped' in out:
            break
        time.sleep(2)
    xml = adb('exec-out', 'cat %s' % path, timeout=120).stdout
    local = os.path.join(OUT, 'ui_%s_%s.xml' % (tag, name))
    try:
        with open(local, 'w', encoding='utf-8') as fh:
            fh.write(xml)
    except OSError:
        pass
    return xml


def nodes(xml):
    out = []
    for m in re.finditer(r'<node[^>]*>', xml or ''):
        n = m.group(0)
        txt = re.search(r'text="([^"]*)"', n)
        rid = re.search(r'resource-id="([^"]*)"', n)
        cls = re.search(r'class="([^"]*)"', n)
        pkg = re.search(r'package="([^"]*)"', n)
        bnd = re.search(r'bounds="\[(\d+),(\d+)\]\[(\d+),(\d+)\]"', n)
        out.append({
            'text': (txt.group(1) if txt else ''),
            'rid': (rid.group(1) if rid else ''),
            'cls': (cls.group(1) if cls else ''),
            'pkg': (pkg.group(1) if pkg else ''),
            'bounds': tuple(int(x) for x in bnd.groups()) if bnd else None,
            'raw': n,
        })
    return out


def find(xml, **kw):
    for node in nodes(xml):
        if 'text' in kw and node['text'] != kw['text']:
            continue
        if 'contains' in kw and kw['contains'] not in node['text']:
            continue
        if 'rid' in kw and not node['rid'].endswith(kw['rid']):
            continue
        if 'ridpart' in kw and kw['ridpart'] not in node['rid']:
            continue
        if 'cls' in kw and node['cls'] != kw['cls']:
            continue
        if 'pkg' in kw and node['pkg'] != kw['pkg']:
            continue
        if node['bounds']:
            return node
    return None


def centre(node):
    x1, y1, x2, y2 = node['bounds']
    return (x1 + x2) // 2, (y1 + y2) // 2


def logcat(pattern=None):
    if pattern and re.match(r'^[A-Za-z0-9_.-]+$', pattern):
        # a tag is much cheaper than the whole buffer of the device
        return adb('logcat', '-d', '-v', 'time', '-s', pattern, timeout=120).stdout
    out = adb('logcat', '-d', '-v', 'time', timeout=120).stdout
    if pattern:
        out = '\n'.join(l for l in out.splitlines() if pattern in l)
    return out


def logcat_clear():
    """empty the buffer of the device, the next logcat only shows what follows"""
    adb('logcat', '-c', timeout=60)


def screencap(tag):
    path = '/sdcard/shot_%s.png' % tag
    adb('shell', 'screencap -p %s' % path)
    data = b''
    for _ in range(4):
        try:
            r = _run_bin(('exec-out', 'cat %s' % path), 180)
            if r.returncode == 0 and r.stdout:
                data = r.stdout
                break
        except subprocess.TimeoutExpired:
            pass
        reconnect()
    local = os.path.join(OUT, 'shot_%s.png' % tag)
    with open(local, 'wb') as fh:
        fh.write(data)
    return local


def pull(remote, local, timeout=180):
    """read a device file into a local file without corrupting binary data"""
    data = b''
    for _ in range(4):
        try:
            r = _run_bin(('exec-out', 'cat %s' % remote), timeout)
            if r.returncode == 0:
                data = r.stdout
                break
        except subprocess.TimeoutExpired:
            pass
        reconnect()
    with open(local, 'wb') as fh:
        fh.write(data)
    return len(data)


def overlay_windows(pkg):
    """the overlay windows of the app with their frames

    The panel of the app is a floating window, it is not part of the
    hierarchy that uiautomator dumps while it is closed.  ``dumpsys window``
    knows every window of the device, so the overlays are taken from there.
    """
    out = sh('dumpsys window windows | grep -E "Window #|ty=APPLICATION_OVERLAY|mFrame="',
             timeout=240)
    res = []
    state = {'name': None, 'attrs': None, 'frame': None}

    def flush():
        if state['name'] and state['attrs'] and state['frame']:
            res.append((state['name'], state['attrs'], state['frame']))

    for line in out.splitlines():
        m = re.match(r'\s*Window #\d+ Window\{(.*?)\}', line)
        if m:
            flush()
            state['name'] = m.group(1)
            state['attrs'] = None
            state['frame'] = None
            continue
        if state['name'] is None:
            continue
        if 'ty=APPLICATION_OVERLAY' in line:
            state['attrs'] = line.strip()
        m = re.search(r'mFrame=\[(\d+),(\d+)\]\[(\d+),(\d+)\]', line)
        if m and state['frame'] is None:
            state['frame'] = tuple(int(x) for x in m.groups())
    flush()
    return [r for r in res if pkg in r[0]]


def float_row(pkg):
    """the frame of the row of the floating icon of the panel of the app

    The icon sits in the row of the floating panel, that row is the overlay
    of the app in the top left corner of the screen that is the tallest one:
    the text of the speed hack sits in a window of its own below the row and
    is lower.
    """
    cands = []
    for name, attrs, frame in overlay_windows(pkg):
        if 'gr=TOP LEFT CENTER' not in attrs:
            continue
        x1, y1, x2, y2 = frame
        if x1 < 0 or y1 < 0 or x2 > 720 or y2 > 1280:
            continue
        if '10000,10000' in attrs:
            continue
        cands.append((name, attrs, frame))
    if not cands:
        return None
    icon = max(cands, key=lambda c: (c[2][3] - c[2][1],
                                     (c[2][2] - c[2][0]) * (c[2][3] - c[2][1])))
    return icon[2]


def float_icon(pkg):
    """the centre of the floating icon of the panel of the app

    The icon is in the middle of the row of the floating panel.
    """
    row = float_row(pkg)
    if row is None:
        return None
    x1, y1, x2, y2 = row
    return (x1 + x2) // 2, (y1 + y2) // 2


def attach(tag, pkg, pid, memory_tab=False, keep=()):
    """start the package, open its panel and attach the target process.

    The panel of the app and the list of the processes are two windows: as
    long as no target is attached the app shows the list of the processes, and
    the panel comes up after one of them has been picked.  The list is long,
    so it is scrolled until the target is on the screen.
    """
    # the overlay of another application (a clicker) covers the panel of the
    # app and hides the list of the processes, it is closed before the run.
    # The target itself is not closed: its pid is the key of the run and the
    # list of the processes has to show that very pid.
    others = ['com.utnciuwv.ldcsra', 'com.wrw', 'com.dianjiqi']
    try:
        with open(os.path.join(ROOT, 'build', 'deploy.state')) as fh:
            others += [line.strip() for line in fh if line.strip()]
    except OSError:
        pass
    for other in others:
        if other in keep:
            continue
        sh('am force-stop %s' % other)
    adb('logcat', '-c')
    sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(12)
    xml = dump(tag, 'main')
    # the app does not always come to the front: when it was already
    # running, the start only delivers the intent to the instance that is
    # already up and the launcher stays in the foreground.  The start is
    # repeated until the window of the app is the one that is dumped.
    for _ in range(4):
        if any(n['pkg'] == pkg for n in nodes(xml)):
            break
        sh('am start -n %s/.MainActivity' % pkg)
        time.sleep(8)
        xml = dump(tag, 'main')
    # a run that died leaves the sel.txt marker behind and the app then
    # starts with the "switch to work with SELinux" dialog, which covers the
    # whole screen.  Take the first entry of that dialog so the flow can
    # continue (it also switches the daemon into its SELinux mode).
    for n in nodes(xml):
        if 'SELinux' in n['text'] or 'SeLinux' in n['text']:
            # the first entry of that dialog switches the app to the mode
            # "work with SELinux", that mode can not inject into a target of
            # a privileged application while the policy of the device is
            # enforced (the daemon answers with the error 107), so the
            # second entry - "ignore" - is taken
            skip = None
            for m in nodes(xml):
                if m['text'].strip() in ('忽略', 'Ignore', 'Skip'):
                    skip = m
                    break
            x, y = centre(skip if skip is not None else n)
            print('    selinux dialog: take the entry that keeps the mode', flush=True)
            tap(x, y)
            time.sleep(8)
            xml = dump(tag, 'main_sel')
            break
    for n in nodes(xml):
        if n['text'].strip() == '开始':
            x, y = centre(n)
            tap(x, y)
            time.sleep(8)
            break
    # the list of the processes holds more than a hundred entries and only
    # seven of them are visible, so the target is looked for by walking
    # through the list one screen at a time
    last_sig = None
    at_top = False
    for attempt in range(150):
        xml = dump(tag, 'main%d' % attempt)
        if find(xml, rid='toolbar_row'):
            break
        # the panel of the app is a floating window: when the app goes to
        # the background, the list of the processes is only reachable by
        # tapping the floating icon
        if not any(n['pkg'] == pkg for n in nodes(xml)):
            icon = float_icon(pkg)
            if icon is not None:
                print('    open the panel with the icon at %d,%d' % icon, flush=True)
                tap(*icon)
                time.sleep(6)
                continue
        # a fresh install shows the agreement of the user before anything
        # else, it covers the whole screen and has to be accepted first
        for n in nodes(xml):
            if n['text'].strip() in ('已阅读并同意', '同意并继续', '我同意'):
                x, y = centre(n)
                print('    agreement: accept', flush=True)
                tap(x, y)
                time.sleep(8)
                xml = dump(tag, 'main%d' % attempt)
                break
        # the window with the tips of the first start covers the panel, it is
        # closed with the cross in its corner
        for n in nodes(xml):
            if n['text'].strip() in ('\u00d7', '\u2715') and n['bounds']:
                x, y = centre(n)
                print('    tips: close', flush=True)
                tap(x, y)
                time.sleep(5)
                xml = dump(tag, 'main%d' % attempt)
                break
        # the starter screen is shown again after every restart of the app and
        # it holds the start button below the fold, so look for it here too
        start = None
        for n in nodes(xml):
            if n['text'].strip() == '开始':
                start = n
                break
        if start is not None:
            x, y = centre(start)
            print('    starter: press 开始', flush=True)
            tap(x, y)
            time.sleep(8)
            continue
        row = None
        for n in nodes(xml):
            if ('[%s]' % pid) in n['text']:
                row = n
                break
        if row is not None:
            x, y = centre(row)
            tap(x, y)
            time.sleep(8)
            continue
        if find(xml, rid='select_dialog_listview'):
            sig = tuple(n['text'] for n in nodes(xml)
                        if n['bounds'] and n['text'].strip())
            if sig and sig == last_sig:
                # the list does not move any more, the end of it is reached:
                # walk it again from its top
                for _ in range(20):
                    sh('input swipe 360 300 360 1100 300')
                time.sleep(2)
                last_sig = None
                at_top = True
                continue
            last_sig = sig
            if not at_top:
                # the list does not open at its top, the walk starts there
                for _ in range(20):
                    sh('input swipe 360 300 360 1100 300')
                time.sleep(2)
                at_top = True
                last_sig = None
                continue
            # a drag of one screen, a fling would jump over the entries
            sh('input swipe 360 1100 360 400 300')
            time.sleep(1.5)
        else:
            tap(48, 72)
            time.sleep(6)
    if not find(xml, rid='toolbar_row'):
        print('!! the panel did not open', flush=True)
        return None
    nm = find(xml, rid='app_name')
    print('    attached: %r' % (nm['text'] if nm else '?'), flush=True)
    if memory_tab:
        mt = find(xml, rid='memory_tab_icon')
        if mt:
            x, y = centre(mt)
            tap(x, y)
            time.sleep(6)
        xml = dump(tag, 'mem')
    return xml


if __name__ == '__main__':
    if len(sys.argv) > 1:
        r = adb(*sys.argv[1:])
        sys.stdout.write(r.stdout)
        sys.stderr.write(r.stderr)

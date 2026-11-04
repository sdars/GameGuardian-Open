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
SERIAL = '123.57.254.92:51213'
OUT = os.path.join(ROOT, 'build/flow')
os.makedirs(OUT, exist_ok=True)


def _run(args, timeout):
    return subprocess.run([ADB, '-s', SERIAL] + list(args), capture_output=True,
                          text=True, timeout=timeout)


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
    out = adb('logcat', '-d', '-v', 'time', timeout=120).stdout
    if pattern:
        out = '\n'.join(l for l in out.splitlines() if pattern in l)
    return out


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


def attach(tag, pkg, pid, memory_tab=False):
    """start the package, open its panel and attach the target process.

    The panel of the app and the list of the processes are two windows: as
    long as no target is attached the app shows the list of the processes, and
    the panel comes up after one of them has been picked.  The list is long,
    so it is scrolled until the target is on the screen.
    """
    others = ['com.utnciuwv.ldcsra', 'com.wrw', pkg]
    try:
        with open(os.path.join(ROOT, 'build', 'deploy.state')) as fh:
            others += [line.strip() for line in fh if line.strip()]
    except OSError:
        pass
    for other in others:
        sh('am force-stop %s' % other)
    adb('logcat', '-c')
    sh('am start -n %s/.MainActivity' % pkg)
    time.sleep(12)
    xml = dump(tag, 'main')
    for n in nodes(xml):
        if n['text'].strip() == '开始':
            x, y = centre(n)
            tap(x, y)
            time.sleep(8)
            break
    for attempt in range(14):
        xml = dump(tag, 'main%d' % attempt)
        if find(xml, rid='toolbar_row'):
            break
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
            sh('input swipe 360 1000 360 400 400')
            time.sleep(3)
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

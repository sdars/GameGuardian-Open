#!/usr/bin/env python3
"""Wait for the device, then run the whole speed hack matrix on it.

The link to the phone drops every now and then.  This script does not care:
it waits until the device answers again and then verifies the *published*
build on the real device, against real processes of both architectures.

    tools/auto_verify.py [max_targets]

It writes

    build/flow/auto_verify.out    - the log of the run
    build/flow/auto_verify.json   - the verdict of every target

The verdict of one target is the answer of the daemon in the log of the
device: "Report Error: 107" means that the daemon refused to install the
hook into that process, a missing error together with a "Send code: 11"
means that the hook is in place.
"""
import json
import os
import re
import subprocess
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

ROOT = '/root/gameguardian'
OUT = os.path.join(ROOT, 'build', 'flow')


def log(msg):
    print(msg, flush=True)


def wait_for_device(limit=2000):
    """block until the device answers again, reconnecting on the way"""
    for i in range(limit):
        try:
            out = adlib.adb('shell', 'echo', 'alive', timeout=45).stdout
        except Exception:                       # the link is slow, it throws
            out = ''
        if 'alive' in out:
            log('==> device is back after %d tries' % (i + 1))
            return True
        adlib.reconnect()
        time.sleep(8)
    return False


def gg_packages():
    """the packages of the app: the launcher one and the helper one"""
    out = []
    for line in adlib.sh('pm list packages', timeout=180).splitlines():
        pkg = line.strip().replace('package:', '')
        if not pkg:
            continue
        if pkg in ('catch_.me_.if_.you_.can_', 'com.utnciuwv.ldcsra'):
            out.append(pkg)
            continue
        if not re.match(r'^[a-z][a-z0-9_]*(\.[a-z0-9_]+)+$', pkg):
            continue
        if len(pkg.split('.')) < 3:
            continue
        info = adlib.sh('dumpsys package %s | grep -c MainService' % pkg,
                        timeout=180)
        if 'MainService' in info or re.search(r'\b1\b', info.strip()):
            out.append(pkg)
    return out


def target_info():
    """every process of the device with its architecture and page rights"""
    out = []
    ps = adlib.sh('ps -A -o PID,NAME', timeout=180)
    for line in ps.splitlines()[1:]:
        parts = line.split()
        if len(parts) < 2 or not parts[0].isdigit():
            continue
        pid, name = parts[0], parts[1]
        if name == 'adbd':
            continue
        maps = adlib.sh('cat /proc/%s/maps 2>/dev/null | head -400' % pid,
                        timeout=120)
        if not maps:
            continue
        first = maps.splitlines()[0].split('-')[0] if maps.splitlines() else ''
        bit = '64' if len(first) >= 8 else '32'
        # an execute only mapping is the reason for the old failure: the
        # system libraries of an application with targetSdk >= 29 are mapped
        # with "--xp" and can not be read with process_vm_readv
        exec_only = bool(re.search(r'^[0-9a-f]+-[0-9a-f]+ --xp ', maps, re.M))
        out.append({'pid': pid, 'name': name, 'bit': bit,
                    'exec_only': exec_only})
    return out


def pick_targets(procs, limit):
    """a representative set: both architectures, with and without execute
    only pages, a system process and a normal application"""
    buckets = {}
    for p in procs:
        key = (p['bit'], p['exec_only'])
        buckets.setdefault(key, []).append(p)
    picked = []
    for key in sorted(buckets):
        picked += buckets[key][:3]
    for name in ('systemui', 'com.android.systemui', 'launcher3',
                 'com.miui.home', 'surfaceflinger'):
        for p in procs:
            if p['name'] == name and p not in picked:
                picked.append(p)
                break
    return picked[:limit]


def run_speed(pkg, tag, pid):
    """the speed panel of one target, returns the verdict of the daemon"""
    cmd = [sys.executable, os.path.join(ROOT, 'tools', 'speed_matrix.py'),
           pkg, tag, str(pid)]
    try:
        r = subprocess.run(cmd, capture_output=True, text=True, timeout=1800)
    except subprocess.TimeoutExpired:
        return {'pid': pid, 'verdict': 'timeout', 'errors': [], 'codes': [],
                'hook32': 0, 'hook64': 0, 'cv': ''}
    path = os.path.join(OUT, 'lc_%s_%s.txt' % (tag, pid))
    logtext = ''
    if os.path.isfile(path):
        with open(path, encoding='utf-8', errors='replace') as fh:
            logtext = fh.read()
    errors = re.findall(r'Report Error: (\d+)', logtext)
    codes = re.findall(r'Send code: (\d+)', logtext)
    hook32 = len([h for h in re.findall(
        r'elf_hook_sections32 Find \d+ [^:]*: ([0-9a-f]+)', logtext) if h != '0'])
    hook64 = len([h for h in re.findall(
        r'elf_hook_sections64 Find \d+ [^:]*: ([0-9a-f]+)', logtext) if h != '0'])
    cv = re.findall(r'CV: (\d\d)', logtext)
    if errors:
        verdict = 'error ' + errors[0]
    elif codes:
        verdict = 'ok'
    else:
        verdict = 'no answer'
    return {'pid': pid, 'verdict': verdict, 'errors': errors, 'codes': codes,
            'hook32': hook32, 'hook64': hook64, 'cv': cv[-1] if cv else '',
            'stdout': (r.stdout or '').strip().splitlines()[-3:]}


def main():
    limit = int(sys.argv[1]) if len(sys.argv) > 1 else 8
    if not wait_for_device():
        log('!! the device never came back')
        return 1
    pkgs = gg_packages()
    log('==> packages of the app: %s' % pkgs)
    pkg = None
    for p in pkgs:
        if p != 'catch_.me_.if_.you_.can_':
            pkg = p
            break
    if pkg is None and pkgs:
        pkg = pkgs[0]
    if pkg is None:
        log('!! no package of the app on the device')
        return 1
    log('==> helper package %s' % pkg)
    procs = target_info()
    log('==> %d processes on the device' % len(procs))
    targets = pick_targets(procs, limit)
    log('==> %d targets: %s' % (len(targets),
                                 ', '.join('%s/%s%s' % (t['pid'], t['name'],
                                                       '/xp' if t['exec_only'] else '')
                                           for t in targets)))
    results = []
    for t in targets:
        tag = 'auto%s' % t['pid']
        log('== target %s %s (%s bit%s)' % (t['pid'], t['name'], t['bit'],
                                           ', execute only pages' if t['exec_only'] else ''))
        v = run_speed(pkg, tag, t['pid'])
        v.update({'name': t['name'], 'bit': t['bit'], 'exec_only': t['exec_only']})
        log('   -> %s codes=%s hook32=%s hook64=%s' % (v['verdict'], v.get('codes'),
                                                       v.get('hook32'), v.get('hook64')))
        results.append(v)
    with open(os.path.join(OUT, 'auto_verify.json'), 'w', encoding='utf-8') as fh:
        json.dump({'package': pkg, 'results': results}, fh, indent=1,
                  ensure_ascii=False)
    bad = [r for r in results if r['verdict'] != 'ok']
    log('==> %d/%d targets ok' % (len(results) - len(bad), len(results)))
    for r in bad:
        log('   !! %s %s -> %s' % (r['pid'], r.get('name'), r['verdict']))
    return 0


if __name__ == '__main__':
    sys.exit(main())

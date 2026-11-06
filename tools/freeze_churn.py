#!/usr/bin/env python3
"""Reproduce the crash of a target that is frozen on a stale address.

    python3 tools/freeze_churn.py <package> <pid> [seconds]

The script drives the real panel of GameGuardian on the phone: it attaches
to the target, searches the value of the test bed, locks the row and then
puts the test bed into the mode 'churn'.  In that mode the garbage
collector of the target moves the array that holds the value, so the
address that the panel writes to is not used by the target any more.

What the script reports

* the address that the panel writes to and the bytes that are there,
* the death of the target and the crash in the log of the device,
* the canary of the test bed - a write with the wrong width destroys it.
"""
import re
import subprocess
import sys
import time

sys.path.insert(0, '/root/gameguardian/tools')
import adlib  # noqa: E402
import freeze_flow as ff  # noqa: E402

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'


def log(msg):
    print('    %s' % msg, flush=True)


def shell(cmd, timeout=120):
    return subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                          capture_output=True, text=True, timeout=timeout).stdout


def seed_of(pkg):
    out = adlib.logcat('GGFreezeProbe')
    seed = None
    for line in out.splitlines():
        m = re.search(r'seed=(\d+)', line)
        if m:
            seed = m.group(1)
    return seed


def watch_memory(pid, addr, rounds=20, pause=1.0):
    """read the memory of the target in one shell on the phone

    Every round prints the bytes at the address of the frozen value.  A
    daemon that writes the frozen value shows the value of the seed, a
    target that owns the address shows the poison of the test bed and an
    address that the target gave back shows zeros.
    """
    script = ('i=0; '
              'while [ $i -lt %d ]; do '
              'dd if=/proc/%s/mem bs=1 skip=%d count=16 2>/dev/null | xxd -p; '
              'i=$((i+1)); sleep %s; done'
              % (rounds, pid, addr, pause))
    out = shell(script, timeout=rounds * 20 + 60)
    return [l.strip() for l in out.splitlines() if l.strip()]


def main():
    pkg = sys.argv[1]
    pid = sys.argv[2]
    seconds = int(sys.argv[3]) if len(sys.argv) > 3 else 300

    seed = seed_of(pkg)
    if seed is None:
        print('!! the log of the target has no seed', flush=True)
        return 1
    log('the seed of the test bed is %s' % seed)

    print('==> attach to %s (%s)' % (pkg, pid), flush=True)
    if not ff.attach(pkg, pid):
        return 1

    ff.set_mode('search')
    print('==> the value search for %s' % seed, flush=True)
    if not ff.run_the_search(seed):
        return 1
    xml, rows = ff.collect_rows()
    fc = ff.by_id(xml, 'found_count')
    log('found_count is %r' % (fc['text'] if fc else '?'))
    target = ff.live_address(pid, rows)
    if target is None:
        print('!! the address of the test bed is not in the result list', flush=True)
        return 1

    print('==> freeze it', flush=True)
    if not ff.freeze_value(pid, seed, target):
        return 1
    addr = target[2]
    log('the panel writes to 0x%x' % addr)

    ff.set_mode('test')
    want = int(seed).to_bytes(4, 'little', signed=False)
    written = 0
    for _ in range(8):
        time.sleep(1)
        if ff.read_mem(pid, addr, 4) == want:
            written += 1
    log('the daemon wrote the frozen value back %d of 8 times' % written)

    print('==> churn the heap of the target', flush=True)
    ff.set_mode('churn')

    started = time.time()
    dead = False
    while time.time() - started < seconds:
        time.sleep(5)
        alive = shell('pidof %s' % pkg).strip()
        samples = watch_memory(pid, addr, rounds=3, pause=0.5)
        out = adlib.logcat('GGFreezeProbe')
        corrupt = len([l for l in out.splitlines() if 'CORRUPTION' in l])
        churn = len([l for l in out.splitlines() if 'churn tick' in l])
        status = [l for l in out.splitlines() if 'status ticks' in l]
        log('alive=%s churn=%d corrupt=%d mem=%s %s'
            % (alive or 'DEAD', churn, corrupt,
               ','.join(s[:8] for s in samples),
               (status[-1].split('GGFreezeProbe:')[-1].strip() if status else '-')))
        if not alive:
            dead = True
            break

    print('==> the log of the device', flush=True)
    out = adlib.logcat()
    for line in out.splitlines():
        if re.search(r'GGFreezeProbe|FATAL|ANR in|has died|Force finishing|am_crash'
                     r'|am_kill|SIGSEGV|signal 11|tombstone', line):
            print('      %s' % line[:220], flush=True)
    print('==> the target %s' % ('died' if dead else 'is alive'), flush=True)
    return 1 if dead else 0


if __name__ == '__main__':
    sys.exit(main())

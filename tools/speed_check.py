#!/usr/bin/env python3
"""Watch the speed hack of the panel on a real process.

    python3 tools/speed_check.py <package> <pid> [seconds]

The script attaches the panel to the target, turns the speed hack on and
then watches the target: the log of the daemon, the state of the target
and the flags of the daemon that decide how it reads and writes.
"""
import re
import subprocess
import sys
import time

sys.path.insert(0, '/root/gameguardian/tools')
import adlib  # noqa: E402
import freeze_flow as ff  # noqa: E402

ADB = '/root/gameguardian/tmp/tools/platform-tools/adb'


def sh(cmd, timeout=120):
    return subprocess.run([ADB, 'shell', 'su', '-c', cmd],
                          capture_output=True, text=True, timeout=timeout).stdout


def daemon_pid():
    out = sh('ps -A -o PID,PPID,NAME 2>/dev/null')
    app = None
    for line in out.splitlines():
        if 'com.dwgibmeuyozjuswy' in line:
            app = int(line.split()[0])
            break
    for line in out.splitlines():
        parts = line.split()
        if len(parts) >= 3 and parts[1] == str(app) and parts[2].startswith('['):
            return int(parts[0])
    return None


def base_of(pid):
    out = sh('cat /proc/%d/maps' % pid)
    for line in out.splitlines():
        if 'lib5.so' in line and 'r-xp' in line:
            return int(line.split('-')[0], 16)
    return None


def read(pid, addr, count):
    out = sh('dd if=/proc/%d/mem bs=1 skip=%d count=%d 2>/dev/null | xxd -p'
             % (pid, addr, count))
    try:
        return bytes.fromhex(''.join(out.split()))
    except ValueError:
        return b''


def flags(daemon, base):
    """the flags of the daemon that decide how it reads and writes"""
    out = []
    for name, va in (('read_vm', 0x3f4b6c), ('write_vm', 0x3f4b70),
                     ('flag_68', 0x3f4b68), ('flag_74', 0x3f4b74),
                     ('unrestored', 0x3f4b78)):
        b = read(daemon, base + va, 1)
        out.append('%s=%s' % (name, ('0x%02x' % b[0]) if b else '?'))
    pid = int.from_bytes(read(daemon, base + 0x3ea740, 4), 'little')
    out.append('target=%d' % pid)
    return ' '.join(out)


def main():
    pkg = sys.argv[1]
    pid = sys.argv[2]
    seconds = int(sys.argv[3]) if len(sys.argv) > 3 else 120

    # the list of the processes of the panel starts with the processes
    # that were used last, so the target is put in the front of it
    adlib.sh('am start -n %s/.FreezeProbeActivity' % pkg)
    time.sleep(3)
    if pid == 'auto':
        pid = adlib.sh('pidof %s' % pkg).strip().split()
        pid = pid[0] if pid else '0'
        print('the target is %s' % pid, flush=True)

    print('==> attach the panel to %s (%s)' % (pkg, pid), flush=True)
    if not ff.attach(pkg, pid):
        return 1
    time.sleep(4)
    daemon = daemon_pid()
    base = base_of(daemon) if daemon else None
    print('the daemon is %s at %s' % (daemon, hex(base) if base else '?'), flush=True)
    if daemon and base:
        print('the flags: %s' % flags(daemon, base), flush=True)

    adlib.logcat_clear()
    print('==> turn the speed hack on', flush=True)
    rc = subprocess.run([sys.executable, '/root/gameguardian/tools/speed_trigger.py', 'spd'],
                        capture_output=True, text=True, timeout=300).stdout
    print(rc, flush=True)

    started = time.time()
    while time.time() - started < seconds:
        time.sleep(5)
        alive = sh('pidof %s' % pkg).strip()
        state = sh('cat /proc/%s/status | grep TracerPid' % pid).strip()
        extra = flags(daemon, base) if daemon and base else ''
        print('alive=%s %s %s' % (alive or 'DEAD', ' '.join(state.split()), extra), flush=True)
        if not alive:
            break

    print('==> the log of the device', flush=True)
    out = adlib.logcat()
    for line in out.splitlines():
        if re.search(r'android-daemon|FATAL|ANR in|has died|SIGSEGV|signal 11'
                     r'|speed|Speed|107|unrestored|detach', line):
            print('      %s' % line[:220], flush=True)
    return 0


if __name__ == '__main__':
    sys.exit(main())

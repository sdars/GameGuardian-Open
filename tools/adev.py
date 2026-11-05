#!/usr/bin/env python3
"""Robust adb wrapper for the flaky remote device.

The device is reached over a mobile link that drops often, so every command
is retried: the transport is reconnected and the command is sent again.

    tools/adev.py shell 'ls'
    tools/adev.py pull /sdcard/x /tmp/x
"""
import os
import subprocess
import sys
import time

ROOT = '/root/gameguardian'
ADB = os.path.join(ROOT, 'tmp/tools/platform-tools/adb')
SERIAL = '8.162.0.198:30138'


def _run(args, timeout):
    return subprocess.run([ADB, '-s', SERERIAL] + list(args), capture_output=True,
                          text=True, timeout=timeout)


def reconnect():
    subprocess.run([ADB, 'disconnect', SERIAL], capture_output=True, text=True,
                   timeout=30)
    time.sleep(1)
    subprocess.run([ADB, 'connect', SERIAL], capture_output=True, text=True,
                   timeout=30)


def adb(*args, **kw):
    timeout = kw.get('timeout', 90)
    last = None
    for _ in range(4):
        try:
            r = _run(args, timeout)
            if r.returncode == 0:
                return r
            last = r
        except subprocess.TimeoutExpired as exc:
            last = exc
        reconnect()
        time.sleep(1)
    raise last if last else RuntimeError('adb failed')


def main():
    args = sys.argv[1:]
    if args and args[0] == 'raw':
        args = args[1:]
    r = adb(*args)
    sys.stdout.write(r.stdout)
    sys.stderr.write(r.stderr)
    return r.returncode


if __name__ == '__main__':
    sys.exit(main())

#!/usr/bin/env python3
"""Push an APK to the device over the flaky link.

    python3 tools/push_apk.py <apk> [remote path]

The file is cut into chunks that are pushed one after the other.  Every
chunk is verified with its md5 on the device, the chunks are concatenated
there and the result is compared with the md5 of the local file.  The
transfer goes through ``adlib``, so a dropped link is reconnected instead of
losing the whole file.
"""
import hashlib
import os
import sys
import time

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))

import adlib  # noqa: E402

CHUNK = 1024 * 1024
REMOTE_DIR = '/data/local/tmp'


def md5(data):
    return hashlib.md5(data).hexdigest()


def remote_md5(path):
    out = adlib.adb('shell', 'md5sum %s' % path, timeout=120).stdout
    return out.strip().split()[0] if out.strip() else ''


def main():
    if len(sys.argv) < 2:
        print(__doc__)
        return 1
    apk = sys.argv[1]
    remote = sys.argv[2] if len(sys.argv) > 2 else REMOTE_DIR + '/gg-release.apk'
    data = open(apk, 'rb').read()
    total = md5(data)
    print('local md5 %s (%d bytes)' % (total, len(data)), flush=True)
    parts = []
    for i in range(0, len(data), CHUNK):
        parts.append(data[i:i + CHUNK])
    names = []
    for idx, part in enumerate(parts):
        name = 'ggpart.%04d' % idx
        want = md5(part)
        rpath = '%s/%s' % (REMOTE_DIR, name)
        ok = False
        for attempt in range(1, 11):
            with open('/tmp/%s' % name, 'wb') as fh:
                fh.write(part)
            adlib.adb('push', '/tmp/%s' % name, rpath, timeout=300)
            got = remote_md5(rpath)
            if got == want:
                print('  %s ok (attempt %d)' % (name, attempt), flush=True)
                ok = True
                break
            print('  %s retry %d (got=%r)' % (name, attempt, got), flush=True)
            time.sleep(2)
        if not ok:
            print('FAILED: %s' % name)
            return 1
        names.append(rpath)
    adlib.adb('shell', 'cat %s > %s' % (' '.join(names), remote), timeout=300)
    for rpath in names:
        adlib.adb('shell', 'rm -f %s' % rpath, timeout=60)
    got = remote_md5(remote)
    print('remote md5 %s' % got, flush=True)
    if got != total:
        print('FAILED: %s differs from %s' % (remote, apk))
        return 1
    print('OK: %s is identical to %s' % (remote, apk))
    return 0


if __name__ == '__main__':
    sys.exit(main())

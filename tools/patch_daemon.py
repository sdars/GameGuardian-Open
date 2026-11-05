#!/usr/bin/env python3
"""Patch the native daemon of the app so that it reads target memory with ptrace.

Why this is needed
------------------
Since Android 10 the linker maps the system libraries of an application with
targetSdk >= 29 as ``--xp`` (execute only).  A page like that can not be read
with ``process_vm_readv``: the call fails with EFAULT ("Bad address").  The
daemon of GameGuardian reads the code page of the hook point with
``process_vm_readv`` and therefore refuses to install the speed hack into such
a process ("Report Error: 107" -> "this process does not support speed hack").
The same read is used for the value search, so the search finds nothing in
such a process either.

The daemon already contains a second implementation of the same read: it
peeks the memory word by word with ``PTRACE_PEEKDATA``, and that one works on
execute only pages.  Which of the two implementations is used is decided by
two bytes in the bss of the daemon:

    ydw5+0x3f4b6c   0 -> use PTRACE_PEEKDATA,  1 -> use process_vm_readv

The bytes are set by the self test of the daemon: the daemon writes a marker
(0xbaad) into its own stack, reads it back with ``process_vm_readv`` and, if
that works, sets the bytes to 1.  The test always succeeds - the daemon tests
itself, not the target - so the daemon always ends up with the
``process_vm_readv`` implementation, even when the target process uses
execute only mappings.

The patch below changes the two instructions that set the bytes so that the
daemon keeps the ptrace implementation.  It is applied to the copies of the
daemon inside the repository (``app/src/main/res/raw`` and
``build/ydw/res/raw``) and the script is idempotent: a second run reports
that the daemon is already patched.

    tools/patch_daemon.py [--check] [file ...]

The daemon of every architecture carries the same self test; the patch sites
below were found in every one of them:

    daemon   arch            site 1                site 2
    ydw5     arm64           0x3d90e0              0x3d9100
    ydw7     arm 32 bit      0x486bfc              0x486c28
    ydw8     arm 32 bit      0x4863c8              0x4863f4
    ydw2     x86 64 bit      0x47c2c8              0x47c2e2
    ydw0     x86 32 bit      0x4a4805              0x4a481b
    ydw1     x86 32 bit      0x4a4725              0x4a473b
"""
import os
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))

# daemon -> [(offset, old bytes, new bytes), ...]
PATCHES = {
    'ydw5': [(0x3d90e0, b'\x2a\x00\x80\x52', b'\x0a\x00\x80\x52'),
             (0x3d9100, b'\x2a\x00\x80\x52', b'\x0a\x00\x80\x52')],
    'ydw7': [(0x486bfc, b'\x01\x00\xa0\xe3', b'\x00\x00\xa0\xe3'),
             (0x486c28, b'\x01\x10\xa0\xe3', b'\x00\x10\xa0\xe3')],
    'ydw8': [(0x4863c8, b'\x01\x00\xa0\xe3', b'\x00\x00\xa0\xe3'),
             (0x4863f4, b'\x01\x10\xa0\xe3', b'\x00\x10\xa0\xe3')],
    'ydw2': [(0x47c2c8, b'\xc6\x00\x01', b'\xc6\x00\x00'),
             (0x47c2e2, b'\xc6\x00\x01', b'\xc6\x00\x00')],
    'ydw0': [(0x4a4805, b'\xc6\x00\x01', b'\xc6\x00\x00'),
             (0x4a481b, b'\xc6\x00\x01', b'\xc6\x00\x00')],
    'ydw1': [(0x4a4725, b'\xc6\x00\x01', b'\xc6\x00\x00'),
             (0x4a473b, b'\xc6\x00\x01', b'\xc6\x00\x00')],
}


def default_files():
    out = []
    for folder in ('app/src/main/res/raw', 'build/ydw/res/raw'):
        for name in sorted(PATCHES):
            path = os.path.join(ROOT, folder, name)
            if os.path.isfile(path):
                out.append(path)
    return out


def state(path):
    """the state of the daemon: 'clean', 'patched' or 'unknown'"""
    name = os.path.basename(path)
    sites = PATCHES.get(name)
    if sites is None:
        return 'unknown', None
    data = open(path, 'rb').read()
    seen = set()
    for off, old, new in sites:
        word = data[off:off + len(old)]
        if word == old:
            seen.add('clean')
        elif word == new:
            seen.add('patched')
        else:
            seen.add('unknown')
    if seen == {'clean'}:
        return 'clean', data
    if seen == {'patched'}:
        return 'patched', data
    return 'unknown', data


def patch(path):
    name = os.path.basename(path)
    sites = PATCHES.get(name)
    if sites is None:
        print('%s: not a daemon of this build, left alone' % path)
        return 0
    kind, data = state(path)
    if kind == 'patched':
        print('%s: already patched' % path)
        return 0
    if kind == 'unknown':
        print('%s: does not look like the expected daemon, left alone' % path)
        return 1
    buf = bytearray(data)
    for off, old, new in sites:
        if bytes(buf[off:off + len(old)]) != old:
            print('%s: the byte at %x is not the expected one, left alone' % (path, off))
            return 1
        buf[off:off + len(new)] = new
    with open(path, 'wb') as fh:
        fh.write(bytes(buf))
    print('%s: patched (%s)' % (path, ', '.join('0x%x' % off for off, _o, _n in sites)))
    return 0


def check(path):
    kind, _data = state(path)
    print('%s: %s' % (path, kind))
    return 0 if kind in ('clean', 'patched') else 1


def main():
    args = list(sys.argv[1:])
    only_check = False
    if args and args[0] == '--check':
        only_check = True
        args = args[1:]
    files = args or default_files()
    rc = 0
    for path in files:
        rc |= check(path) if only_check else patch(path)
    return rc


if __name__ == '__main__':
    sys.exit(main())

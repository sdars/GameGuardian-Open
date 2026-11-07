#!/usr/bin/env python3
"""Patch the native daemon of the app so that it reads target memory with ptrace.

Why the read has to be patched
------------------------------
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
    ydw5+0x3f4b70   0 -> use PTRACE_POKEDATA,  1 -> use process_vm_writev

The bytes are set by the self test of the daemon: the daemon writes a marker
(0xbaad) into its own stack, reads it back with ``process_vm_readv`` and, if
that works, sets the bytes to 1.  The test always succeeds - the daemon tests
itself, not the target - so the daemon always ends up with the
``process_vm_readv`` implementation, even when the target process uses
execute only mappings.

Why the write must NOT be patched
----------------------------------
The two bytes are set by two different instructions of the same self test:

    ydw5+0x3d90e0  mov  w10, #1     ; the byte at ydw5+0x3f4b6c (read)
    ydw5+0x3d90e8  strb w10, [x8]
    ydw5+0x3d9100  mov  w10, #1     ; the byte at ydw5+0x3f4b70 (write)
    ydw5+0x3d9104  strb w10, [x9]

Only the first one is changed here, the second one keeps its value of 1, so
that the daemon still writes with ``process_vm_writev``.

That is not a detail.  ``PTRACE_POKEDATA`` only writes when the caller is the
tracer of the target: the kernel refuses the request of every other caller
and returns 0 *without* writing anything.  The daemon of GameGuardian only
attaches to the target for its ptrace *read* helper (it detaches again right
after the read, so the target is never stopped), it never stays attached
while it writes.  A write that goes through ``PTRACE_POKEDATA`` therefore
does nothing at all, while the daemon believes that it worked:

    E/android-daemon: PTRACE_POKEDATA addr: 7218ab7270, check fail (4 != 0), error 0: Success

The read back of the daemon is 0 (the kernel left the buffer untouched) and
the errno is 0 ("Success"), because the kernel does not set an errno for
that case.  The speed hack installs its hook, but the factor that the hook
has to multiply is written with that broken write - it never reaches the
target, the trampoline of the hook divides by zero and the target crashes.
That is exactly the reported symptom: the speed hack has no effect and the
target application dies after a while.

So the patch changes the instruction that sets the *read* byte and leaves
the instruction that sets the *write* byte alone.

The patch is applied to the copies of the daemon inside the repository
(``app/src/main/res/raw`` and ``build/ydw/res/raw``) and the script is
idempotent: a second run reports that the daemon is already patched.  A
daemon that carries the old patch (both bytes forced to 0) is repaired: the
byte of the write is set back to 1.

    tools/patch_daemon.py [--check] [file ...]

The daemon of every architecture carries the same self test; the patch sites
below were found in every one of them:

    daemon   arch            read site             write site
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

# daemon -> ((read site), (write site))
# a site is (offset, the bytes of the original instruction, the bytes of the
# patched instruction, the bytes of the old over patch)
PATCHES = {
    'ydw5': ((0x3d90e0, b'\x2a\x00\x80\x52', b'\x0a\x00\x80\x52', b'\x0a\x00\x80\x52'),
             (0x3d9100, b'\x2a\x00\x80\x52', b'\x2a\x00\x80\x52', b'\x0a\x00\x80\x52')),
    'ydw7': ((0x486bfc, b'\x01\x00\xa0\xe3', b'\x00\x00\xa0\xe3', b'\x00\x00\xa0\xe3'),
             (0x486c28, b'\x01\x10\xa0\xe3', b'\x01\x10\xa0\xe3', b'\x00\x10\xa0\xe3')),
    'ydw8': ((0x4863c8, b'\x01\x00\xa0\xe3', b'\x00\x00\xa0\xe3', b'\x00\x00\xa0\xe3'),
             (0x4863f4, b'\x01\x10\xa0\xe3', b'\x01\x10\xa0\xe3', b'\x00\x10\xa0\xe3')),
    'ydw2': ((0x47c2c8, b'\xc6\x00\x01', b'\xc6\x00\x00', b'\xc6\x00\x00'),
             (0x47c2e2, b'\xc6\x00\x01', b'\xc6\x00\x01', b'\xc6\x00\x00')),
    'ydw0': ((0x4a4805, b'\xc6\x00\x01', b'\xc6\x00\x00', b'\xc6\x00\x00'),
             (0x4a481b, b'\xc6\x00\x01', b'\xc6\x00\x01', b'\xc6\x00\x00')),
    'ydw1': ((0x4a4725, b'\xc6\x00\x01', b'\xc6\x00\x00', b'\xc6\x00\x00'),
             (0x4a473b, b'\xc6\x00\x01', b'\xc6\x00\x01', b'\xc6\x00\x00')),
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
    """the state of the daemon

    'clean'   the daemon is not patched at all
    'patched' the read byte is forced to 0 and the write byte keeps its 1
    'legacy'  the old patch: both bytes are forced to 0, the write of the
              daemon is broken and has to be repaired
    'unknown' the file does not carry the expected instructions
    """
    name = os.path.basename(path)
    sites = PATCHES.get(name)
    if sites is None:
        return 'unknown', None
    data = open(path, 'rb').read()
    read_site, write_site = sites
    r_off, r_old, r_new, _r_leg = read_site
    w_off, w_old, w_new, w_leg = write_site
    r_word = data[r_off:r_off + len(r_old)]
    w_word = data[w_off:w_off + len(w_old)]
    if r_word == r_old and w_word == w_old:
        return 'clean', data
    if r_word == r_new and w_word == w_new:
        return 'patched', data
    # the old patch forced the write byte to 0 as well
    if r_word == r_new and w_word == w_leg:
        return 'legacy', data
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
    read_site, write_site = sites
    r_off, r_old, r_new, _r_leg = read_site
    w_off, w_old, w_new, w_leg = write_site
    if kind == 'clean':
        if bytes(buf[r_off:r_off + len(r_old)]) != r_old:
            print('%s: the byte at %x is not the expected one, left alone' % (path, r_off))
            return 1
        buf[r_off:r_off + len(r_new)] = r_new
        with open(path, 'wb') as fh:
            fh.write(bytes(buf))
        print('%s: patched (read byte at 0x%x)' % (path, r_off))
        return 0
    # legacy: the write byte has to go back to 1, the read byte stays at 0
    if bytes(buf[w_off:w_off + len(w_old)]) != w_leg:
        print('%s: the byte at %x is not the expected one, left alone' % (path, w_off))
        return 1
    buf[w_off:w_off + len(w_new)] = w_new
    with open(path, 'wb') as fh:
        fh.write(bytes(buf))
    print('%s: repaired (write byte at 0x%x back to 1)' % (path, w_off))
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

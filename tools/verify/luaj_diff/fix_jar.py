#!/usr/bin/env python3
"""Repair the dex2jar reference jar so the JVM accepts it.

dex2jar (d2j 2.4) writes two kinds of broken metadata into classes.jar:

  1. wrong class access flags - classes such as luaj/LuaValue come out as
     ACC_PUBLIC|ACC_SUPER|ACC_INTERFACE instead of
     ACC_PUBLIC|ACC_SUPER|ACC_ABSTRACT;
  2. InnerClasses attributes whose inner_class_info constant pool index points
     at the wrong class.  The JVM applies the inner access flags to the class
     whose this_class matches, so a mis-indexed entry turns luaj/LuaString into
     ACC_PRIVATE|ACC_STATIC|ACC_FINAL|ACC_INTERFACE (0x41A) and the class loader
     aborts with ClassFormatError: Illegal class modifiers.

The ground truth for both is the original baksmali output in
build/puresrc/original - its .class directives carry the exact DEX access flags
of every class.  This script therefore

  * rewrites every class access_flags from the smali ground truth and
  * drops the mis-indexed InnerClasses attributes, which are only reflection
    metadata and irrelevant for behavioural testing.

usage: fix_jar.py <classes.jar> <smali-root> <out.jar>
"""

import os
import struct
import sys
import zipfile

DEX_FLAGS = {
    'public': 0x0001, 'private': 0x0002, 'protected': 0x0004, 'static': 0x0008,
    'final': 0x0010, 'synchronized': 0x0020, 'volatile': 0x0040,
    'transient': 0x0080, 'native': 0x0100, 'interface': 0x0200,
    'abstract': 0x0400, 'strictfp': 0x0800, 'synthetic': 0x1000,
    'annotation': 0x2000, 'enum': 0x4000,
}

def dex_to_jvm(dex_flags):
    # DEX and class file access flags use identical bit values
    # (JVMS 4.1: INTERFACE=0x0200, ABSTRACT=0x0400, SUPER=0x0020).
    out = dex_flags & 0xffff
    if out & 0x0200:          # interface
        out |= 0x0400         # interfaces are implicitly abstract
    else:
        out |= 0x0020         # ACC_SUPER
    return out


def load_smali_flags(root):
    flags = {}
    for dirpath, _dirs, files in os.walk(root):
        for fn in files:
            if not fn.endswith('.smali'):
                continue
            path = os.path.join(dirpath, fn)
            with open(path, 'r', encoding='utf-8', errors='replace') as fh:
                for line in fh:
                    if not line.startswith('.class'):
                        continue
                    parts = line.split()
                    desc = parts[-1]
                    dex = 0
                    for tok in parts[1:-1]:
                        dex |= DEX_FLAGS.get(tok, 0)
                    flags[desc] = dex
                    break
    return flags


class ClassFile:
    def __init__(self, data):
        self.d = data
        self.p = 8
        cpc = struct.unpack_from('>H', data, self.p)[0]
        self.p += 2
        self.cp = [None] * cpc
        i = 1
        while i < cpc:
            tag = data[self.p]
            if tag == 1:
                ln = struct.unpack_from('>H', data, self.p + 1)[0]
                self.cp[i] = ('utf8', data[self.p + 3:self.p + 3 + ln])
                self.p += 3 + ln
            elif tag in (7, 8, 16, 19, 20):
                self.cp[i] = (tag, struct.unpack_from('>H', data, self.p + 1)[0])
                self.p += 3
            elif tag == 15:
                self.cp[i] = (tag, data[self.p + 1:self.p + 3])
                self.p += 4
            elif tag in (3, 4, 9, 10, 11, 12, 17, 18):
                self.cp[i] = (tag, struct.unpack_from('>H', data, self.p + 1)[0])
                self.p += 5
            elif tag in (5, 6):
                self.cp[i] = (tag, data[self.p + 1:self.p + 9])
                self.p += 9
                i += 1
            else:
                raise ValueError('unknown constant pool tag %d' % tag)
            i += 1
        self.cp_end = self.p
        self.flags_off = self.p
        self.this = struct.unpack_from('>H', data, self.p + 2)[0]
        self.super = struct.unpack_from('>H', data, self.p + 4)[0]
        nif = struct.unpack_from('>H', data, self.p + 6)[0]
        self.p += 8 + 2 * nif
        self.body_start = self.p
        for _ in range(2):
            n = struct.unpack_from('>H', data, self.p)[0]
            self.p += 2
            for _ in range(n):
                self.p += 6
                na = struct.unpack_from('>H', data, self.p)[0]
                self.p += 2
                for _ in range(na):
                    _, ln = struct.unpack_from('>HI', data, self.p)
                    self.p += 6 + ln
        self.body_end = self.p
        self.attrs = []
        na = struct.unpack_from('>H', data, self.p)[0]
        self.p += 2
        for _ in range(na):
            ni, ln = struct.unpack_from('>HI', data, self.p)
            self.p += 6
            self.attrs.append((self.cp[ni][1].decode('utf-8', 'replace'), self.p, ln))
            self.p += ln
        if self.p != len(data):
            raise ValueError('trailing bytes %d != %d' % (self.p, len(data)))

    def name(self, idx):
        if idx == 0:
            return None
        e = self.cp[idx]
        if e[0] == 7:
            return self.cp[e[1]][1].decode('utf-8', 'replace')
        return None

    def rebuild(self, new_flags, drop_inner_classes=True):
        head = bytearray(self.d[:self.flags_off + 2])
        struct.pack_into('>H', head, self.flags_off, new_flags)
        out = bytes(head) + self.d[self.flags_off + 2:self.body_end]
        kept = []
        for name, off, ln in self.attrs:
            if drop_inner_classes and name == 'InnerClasses':
                continue
            kept.append(self.d[off - 6:off + ln])
        out += struct.pack('>H', len(kept))
        for blob in kept:
            out += blob
        return out


def main():
    if len(sys.argv) != 4:
        print(__doc__)
        return 2
    src, smali_root, dst = sys.argv[1], sys.argv[2], sys.argv[3]
    flags = load_smali_flags(smali_root)
    print('smali classes: %d' % len(flags))
    zin = zipfile.ZipFile(src)
    fixed = 0
    missing = []
    with zipfile.ZipFile(dst, 'w', zipfile.ZIP_DEFLATED) as zout:
        for item in zin.infolist():
            data = zin.read(item.filename)
            if item.filename.endswith('.class'):
                cf = ClassFile(data)
                desc = 'L' + cf.name(cf.this) + ';'
                if desc not in flags:
                    missing.append(desc)
                    new_flags = cf.flags
                else:
                    new_flags = dex_to_jvm(flags[desc])
                data = cf.rebuild(new_flags)
                fixed += 1
            zi = zipfile.ZipInfo(item.filename, date_time=item.date_time)
            zi.compress_type = zipfile.ZIP_DEFLATED
            zi.external_attr = item.external_attr
            zout.writestr(zi, data)
    print('rewritten classes: %d' % fixed)
    if missing:
        print('no smali ground truth for %d classes: %s' % (len(missing), missing[:10]))
    return 0


if __name__ == '__main__':
    sys.exit(main())

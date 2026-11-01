#!/usr/bin/env python3
"""Static check of the smali overlay against the compiled dex.

The overlay keeps the original dex bytecode of three methods.  For it to link
correctly every class and every member it touches has to exist in the classes
compiled from the Java sources - with exactly the name and the descriptor the
original dex used.  This script parses the dex directly (no external tool) and
reports every dangling reference.

Usage: verify_overlay.py <classes.dex> [overlay-dir]
"""
import os
import re
import struct
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
DEFAULT_OVERLAY = os.path.join(ROOT, "app", "src", "main", "smali_overlay")

RE_CLASS = re.compile(r"(L[A-Za-z0-9_$/]+;)")
RE_MEMBER = re.compile(r"(L[A-Za-z0-9_$/]+;)->([A-Za-z0-9_$]+):(\([^)]*\)|[A-Za-z0-9_$/;]+)")


class Dex:
    def __init__(self, path):
        self.data = open(path, "rb").read()
        d = self.data
        if d[:4] != b"dex\n":
            raise SystemExit("not a dex file: " + path)
        hdr = struct.unpack_from("<20I", d, 32)
        (self.string_ids_size, self.string_ids_off, self.type_ids_size, self.type_ids_off,
         self.proto_ids_size, self.proto_ids_off, self.field_ids_size, self.field_ids_off,
         self.method_ids_size, self.method_ids_off, self.class_defs_size, self.class_defs_off) = hdr[6:18]
        self._strings = None
        self._types = None

    def string(self, idx):
        if self._strings is None:
            self._strings = []
            for i in range(self.string_ids_size):
                off = struct.unpack_from("<I", self.data, self.string_ids_off + 4 * i)[0]
                n, p = self._uleb(off)
                end = self.data.index(b"\x00", p)
                self._strings.append(self.data[p:end].decode("utf-8", "replace"))
        return self._strings[idx]

    def _uleb(self, off):
        result = shift = 0
        while True:
            b = self.data[off]
            off += 1
            result |= (b & 0x7F) << shift
            if not (b & 0x80):
                return result, off
            shift += 7

    def type(self, idx):
        if self._types is None:
            self._types = []
            for i in range(self.type_ids_size):
                sid = struct.unpack_from("<I", self.data, self.type_ids_off + 4 * i)[0]
                self._types.append(self.string(sid))
        return self._types[idx]

    def proto(self, idx):
        d = self.data
        shorty, ret, params_off = struct.unpack_from("<III", d, self.proto_ids_off + 12 * idx)
        types = []
        if params_off:
            n = struct.unpack_from("<I", d, params_off)[0]
            for i in range(n):
                t = struct.unpack_from("<H", d, params_off + 4 + 2 * i)[0]
                types.append(self.type(t))
        return "(" + "".join(types) + ")" + self.type(ret)

    def classes(self):
        d = self.data
        out = []
        for i in range(self.class_defs_size):
            off = self.class_defs_off + 32 * i
            cidx, access, superidx = struct.unpack_from("<III", d, off)
            out.append((self.type(cidx), self.type(superidx) if superidx != 0xFFFFFFFF else None))
        return out

    def fields(self):
        d = self.data
        out = []
        for i in range(self.field_ids_size):
            off = self.field_ids_off + 8 * i
            cidx, tidx, nidx = struct.unpack_from("<HHI", d, off)
            out.append((self.type(cidx), self.string(nidx), self.type(tidx)))
        return out

    def methods(self):
        d = self.data
        out = []
        for i in range(self.method_ids_size):
            off = self.method_ids_off + 8 * i
            cidx, pidx, nidx = struct.unpack_from("<HHI", d, off)
            out.append((self.type(cidx), self.string(nidx), self.proto(pidx)))
        return out


def main():
    dexpath = sys.argv[1]
    overlay = sys.argv[2] if len(sys.argv) > 2 else DEFAULT_OVERLAY
    dex = Dex(dexpath)

    class_desc = set()
    supers = {}
    for c, s in dex.classes():
        class_desc.add(c)
        supers[c] = s

    fields = {}
    for c, n, t in dex.fields():
        fields.setdefault(c, set()).add((n, t))
    methods = {}
    for c, n, p in dex.methods():
        methods.setdefault(c, set()).add((n, p))

    def all_members(c):
        out = set(fields.get(c, ())) | set(methods.get(c, ()))
        s = supers.get(c)
        while s:
            out |= set(fields.get(s, ())) | set(methods.get(s, ()))
            s = supers.get(s)
        return out

    APP_PREFIXES = ("Landroid/ext/", "Lluaj/", "Llasm/", "Lcatch_/", "Lgg_")

    def is_app(cls):
        return cls.startswith(APP_PREFIXES)

    missing_class = {}
    missing_member = {}
    checked = 0
    for dirpath, _dirs, names in os.walk(overlay):
        for n in names:
            if not n.endswith(".smali"):
                continue
            p = os.path.join(dirpath, n)
            text = open(p, encoding="utf-8").read()
            for cls in set(RE_CLASS.findall(text)):
                if is_app(cls) and cls not in class_desc:
                    missing_class.setdefault(p, set()).add(cls)
            for cls, name, desc in set(RE_MEMBER.findall(text)):
                checked += 1
                if not is_app(cls) or cls not in class_desc:
                    continue
                if (name, desc) not in all_members(cls):
                    missing_member.setdefault(p, set()).add(cls + "->" + name + ":" + desc)

    print("dex classes      :", len(class_desc))
    print("member references:", checked)
    ok = True
    if missing_class:
        ok = False
        print("MISSING CLASSES")
        for p, s in missing_class.items():
            for c in sorted(s):
                print("  ", os.path.relpath(p, overlay), c)
    if missing_member:
        ok = False
        print("MISSING MEMBERS")
        for p, s in missing_member.items():
            for c in sorted(s):
                print("  ", os.path.relpath(p, overlay), c)
    if ok:
        print("OK - every class and member referenced by the overlay exists")
    sys.exit(0 if ok else 1)


if __name__ == "__main__":
    main()
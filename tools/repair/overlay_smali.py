#!/usr/bin/env python3
"""smali overlay for the methods no Java decompiler could reconstruct.

GameGuardian 101.4 contains four methods whose control flow defeats jadx,
Procyon, CFR and Vineflower alike:

  android/ext/f1$a.run()V                                       (hand written)
  android/ext/m.e(Landroid/ext/n;[IJLjava/lang/String;I)I         (ARM64 disassembler)
  android/ext/n$a.a(Landroid/ext/n;JLjava/lang/String;I)I        (ARM64 decoder)
  luaj/LuaClosure.Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;

For the three large ones the original dex bytecode is kept verbatim and
patched into the smali tree of the compiled Java sources.  Two rewrites are
needed for that:

  * the obfuscator packages a..g were renamed to gg_a..gg_g in the Java tree,
  * jadx renamed every member whose name collides with a class of the same
    package (f1062a instead of a, f1676f instead of f, ...).

Both rewrites are applied to the smali fragment, so the overlay compiles
against the Java classes exactly.

Usage:
  overlay_smali.py gen    <baksmali-dir>   apply the overlay to a smali tree
  overlay_smali.py show                   print what the overlay contains
"""
import json
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ORIG = os.path.join(ROOT, "tmp", "analysis", "2026-11-01", "apktool_src", "smali")
REMAP = os.path.join(ROOT, "tools", "repair", "member_renames.json")
OUTDIR = os.path.join(ROOT, "app", "src", "main", "smali_overlay")

TARGETS = [
    ("android/ext/m.smali", "e(Landroid/ext/n;[IJLjava/lang/String;I)I"),
    ("android/ext/n$a.smali", "a(Landroid/ext/n;JLjava/lang/String;I)I"),
    ("luaj/LuaClosure.smali", "Y2([Lluaj/LuaValue;Lluaj/Varargs;Z)Lluaj/Varargs;"),
]

RE_PKG = re.compile(r"(?<![A-Za-z0-9_$])L([a-g])/")
RE_MEMBER = re.compile(r"(L[A-Za-z0-9_$/]+;)->([A-Za-z0-9_$]+):")
RE_METHOD_LINE = re.compile(r"^\.method\s+(.*?)\s*([^\s(]+)(\(.*)$")


def load_map():
    raw = json.load(open(REMAP, encoding="utf-8"))
    inverted = {}
    for desc, members in raw.items():
        inverted[desc] = {orig: new for new, orig in members.items()}
    return inverted


def rewrite(text, memmap):
    text = RE_PKG.sub(lambda m: "Lgg_" + m.group(1) + "/", text)

    def sub_member(m):
        cls, name = m.group(1), m.group(2)
        table = memmap.get(cls)
        if table and name in table:
            return cls + "->" + table[name] + ":"
        return m.group(0)

    return RE_MEMBER.sub(sub_member, text)


def extract_method(path, sig):
    """Return the smali block of the method with the given name+descriptor."""
    lines = open(path, encoding="utf-8").read().splitlines()
    for i, line in enumerate(lines):
        if not line.startswith(".method "):
            continue
        m = RE_METHOD_LINE.match(line)
        if not m:
            continue
        name, desc = m.group(2), m.group(3)
        if name + desc != sig:
            continue
        for j in range(i + 1, len(lines)):
            if lines[j].strip() == ".end method":
                return "\n".join(lines[i:j + 1]) + "\n"
        raise SystemExit("unterminated method " + sig + " in " + path)
    raise SystemExit("method " + sig + " not found in " + path)


def cmd_show():
    memmap = load_map()
    for rel, sig in TARGETS:
        block = extract_method(os.path.join(ORIG, rel), sig)
        print("%-32s %-52s %6d lines" % (rel, sig, block.count("\n")))


def cmd_gen(dest):
    memmap = load_map()
    manifest = []
    for rel, sig in TARGETS:
        block = rewrite(extract_method(os.path.join(ORIG, rel), sig), memmap)
        out = os.path.join(dest, rel)
        os.makedirs(os.path.dirname(out), exist_ok=True)
        open(out, "w", encoding="utf-8").write(block)
        manifest.append({"file": rel, "signature": sig, "lines": block.count("\n")})
        print("overlay", rel, sig, manifest[-1]["lines"], "lines")
    json.dump(manifest, open(os.path.join(dest, "manifest.json"), "w", encoding="utf-8"), indent=1)


def cmd_apply(smalidir):
    memmap = load_map()
    manifest = json.load(open(os.path.join(OUTDIR, "manifest.json"), encoding="utf-8"))
    for entry in manifest:
        rel, sig = entry["file"], entry["signature"]
        target = os.path.join(smalidir, rel)
        if not os.path.exists(target):
            raise SystemExit("missing " + target)
        fragment = rewrite(open(os.path.join(OUTDIR, rel), encoding="utf-8").read(), memmap)
        lines = open(target, encoding="utf-8").read().splitlines()
        start = end = None
        for i, line in enumerate(lines):
            if not line.startswith(".method "):
                continue
            m = RE_METHOD_LINE.match(line)
            if not m:
                continue
            if m.group(2) + m.group(3) != sig:
                continue
            start = i
            for j in range(i + 1, len(lines)):
                if lines[j].strip() == ".end method":
                    end = j
                    break
            break
        if start is None:
            raise SystemExit("method " + sig + " not found in " + target)
        body = fragment.rstrip("\n").splitlines()
        lines[start:end + 1] = body
        open(target, "w", encoding="utf-8").write("\n".join(lines) + "\n")
        print("patched", rel, sig)


if __name__ == "__main__":
    if len(sys.argv) < 2:
        raise SystemExit(__doc__)
    cmd = sys.argv[1]
    if cmd == "show":
        cmd_show()
    elif cmd == "gen":
        cmd_gen(OUTDIR)
    elif cmd == "apply":
        cmd_apply(sys.argv[2])
    else:
        raise SystemExit(__doc__)
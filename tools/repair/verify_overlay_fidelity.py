#!/usr/bin/env python3
"""Prove that the three overlaid methods are the original dex implementation.

The release APK keeps the original bytecode of the methods that no Java
decompiler could reconstruct.  This script disassembles the original dex and
the release dex and compares the method bodies instruction by instruction
(after applying the two documented renames: obfuscator packages a..g ->
gg_a..gg_g and the member names jadx had to rename).

Usage: verify_overlay_fidelity.py <release classes.dex> [original classes.dex]
"""
import os
import re
import subprocess
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
ORIG_DEX = os.path.join(ROOT, "tmp", "analysis", "2026-11-01", "classes.dex")
LIB = os.path.join(ROOT, "tools", "lib")

sys.path.insert(0, os.path.join(ROOT, "tools", "repair"))
import overlay_smali  # noqa: E402


def disassemble(dex, outdir):
    subprocess.run(["java", "-cp", LIB + "/*", "org.jf.baksmali.Main", "d", dex, "-o", outdir],
                   check=True, capture_output=True)


def normalise(block):
    """Drop the debug line directives, they differ between the two dexes."""
    out = []
    for line in block.splitlines():
        s = line.strip()
        if s.startswith(".line "):
            continue
        if s.startswith(".source "):
            continue
        out.append(line.rstrip())
    while out and not out[-1]:
        out.pop()
    return "\n".join(out)


def main():
    release_dex = sys.argv[1]
    orig_dex = sys.argv[2] if len(sys.argv) > 2 else ORIG_DEX
    work = os.path.join(ROOT, "build", "fidelity")
    os.makedirs(work, exist_ok=True)
    rel_smali = os.path.join(work, "release")
    orig_smali = os.path.join(work, "original")
    for d in (rel_smali, orig_smali):
        subprocess.run(["python3", "-c",
                        "import shutil,sys; shutil.rmtree(sys.argv[1], ignore_errors=True)", d],
                       check=True)
    print("disassembling original dex ...")
    disassemble(orig_dex, orig_smali)
    print("disassembling release dex ...")
    disassemble(release_dex, rel_smali)

    memmap = overlay_smali.load_map()
    ok = True
    for rel, sig in overlay_smali.TARGETS:
        orig = overlay_smali.rewrite(
            overlay_smali.extract_method(os.path.join(orig_smali, rel), sig), memmap)
        rel_block = overlay_smali.extract_method(os.path.join(rel_smali, rel), sig)
        a = normalise(orig)
        b = normalise(rel_block)
        if a == b:
            print("IDENTICAL  %-28s %s  (%d lines)" % (rel, sig, a.count("\n") + 1))
        else:
            ok = False
            print("DIFFERS    %-28s %s" % (rel, sig))
            al, bl = a.splitlines(), b.splitlines()
            for i in range(max(len(al), len(bl))):
                x = al[i] if i < len(al) else "<none>"
                y = bl[i] if i < len(bl) else "<none>"
                if x != y:
                    print("   line %d\n     original: %s\n     release : %s" % (i + 1, x, y))
                    break
    sys.exit(0 if ok else 1)


if __name__ == "__main__":
    main()
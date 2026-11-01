#!/usr/bin/env python3
"""Extract the member renames jadx applied to the reconstructed sources.

jadx renames a member whenever its name collides with a class that lives in
the same package (the obfuscator emitted packages a..g in which every class
is named a..g, so a field called "a" inside package "android.ext" cannot be
written as "a" in Java).  The smali of the original APK still carries the
original names, so the overlay build needs the mapping in order to rewrite
field references of the smali fragments back to the names the compiled Java
classes actually use.

Output: tools/repair/member_renames.json
    { "<class descriptor>": { "<new name>": "<original name>" } }
"""
import json
import os
import re

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, "app", "src", "main", "java")
OUT = os.path.join(ROOT, "tools", "repair", "member_renames.json")

RE_COMMENT = re.compile(r"/\*\s*JADX INFO: renamed from: ([A-Za-z0-9_$]+), reason:")
RE_PKG = re.compile(r"^package\s+([A-Za-z0-9_.]+);", re.M)
RE_CLASS = re.compile(r"\b(?:class|interface|enum|@interface)\s+([A-Za-z0-9_$]+)")
RE_MOD = re.compile(r"\b(final|static|public|protected|private|volatile|transient|abstract|native|synchronized)\b")


def descriptor(pkg, name):
    return "L" + (pkg.replace(".", "/") + "/" if pkg else "") + name + ";"


def declared_name(line):
    """Return the identifier a declaration line introduces (None if unknown)."""
    s = line.strip()
    if not s or s.startswith("//") or s.startswith("/*") or s.startswith("*"):
        return None
    s = re.sub(r"@[A-Za-z0-9_.]+(\([^)]*\))?", " ", s)
    s = RE_MOD.sub(" ", s)
    s = s.strip()
    if not s:
        return None
    p_paren = s.find("(")
    p_eq = s.find("=")
    p_semi = s.find(";")
    ends = [x for x in (p_eq, p_semi) if x >= 0]
    p_end = min(ends) if ends else -1
    if p_paren >= 0 and (p_end < 0 or p_paren < p_end):
        m = re.search(r"([A-Za-z_$][\w$]*)\s*\($", s[:p_paren + 1].rstrip() + "(")
        if m:
            return m.group(1)
        m = re.search(r"([A-Za-z_$][\w$]*)\s*$", s[:p_paren].rstrip())
        return m.group(1) if m else None
    if p_end >= 0:
        m = re.search(r"([A-Za-z_$][\w$]*)\s*$", s[:p_end].rstrip())
        return m.group(1) if m else None
    m = re.search(r"([A-Za-z_$][\w$]*)\s*$", s.rstrip())
    return m.group(1) if m else None


def main():
    result = {}
    total = 0
    for dirpath, _dirs, names in os.walk(SRC):
        for n in sorted(names):
            if not n.endswith(".java"):
                continue
            p = os.path.join(dirpath, n)
            src = open(p, encoding="utf-8").read()
            m = RE_PKG.search(src)
            pkg = m.group(1) if m else ""
            base = n[:-5]
            cls = base
            if "$" not in base:
                m = RE_CLASS.search(src)
                if m and m.group(1) != base:
                    cls = m.group(1)
            desc = descriptor(pkg, cls)
            lines = src.splitlines()
            mapping = {}
            for i, line in enumerate(lines):
                mm = RE_COMMENT.search(line)
                if not mm:
                    continue
                orig = mm.group(1)
                newname = None
                for j in range(i + 1, min(i + 8, len(lines))):
                    newname = declared_name(lines[j])
                    if newname:
                        break
                if not newname or newname == orig:
                    continue
                mapping[newname] = orig
                total += 1
            if mapping:
                result.setdefault(desc, {}).update(mapping)
    json.dump(result, open(OUT, "w", encoding="utf-8"), indent=1, sort_keys=True)
    print("classes with renames:", len(result), "members:", total)


if __name__ == "__main__":
    main()
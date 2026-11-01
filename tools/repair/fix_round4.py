#!/usr/bin/env python3
"""Fourth repair round - the places where jadx duplicated a block.

The entries were verified against the smali of the original dex.
"""
import os
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from fix_misc import replace_guarded          # noqa: E402

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')

PATCHES = [
    # --- android/ext/n1.java --------------------------------------------
    # dex: ":goto_a" performs the "O(view, text)" and "setTextColor" once,
    #      the region entry is null on the ":cond_c" path.  jadx emitted the
    #      tail of the block a second time and left the region variable
    #      uninitialised on the path that reaches the first copy.
    ('android/ext/n1.java',
     """        if ((i & 1) != 0) {
            if (z) {
                j3 = iN3 != 8 ? j2 & ((1 << (iN3 * 8)) - 1) : j2;
                str3 = android.ext.t2.e(iN3 * 2, j3) + \"h;\";
                android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
                if (iN3 == 4 || (z1_d != null && z1_d.n && iN3 == 8)) {
                    regionList$bB = android.ext.RegionList.b(j3);
                }
                O(b3Var.f663c, str3);
                b3Var.f663c.setTextColor(android.ext.RegionList$b.c(regionList$bB));
                if (iN3 == 1) {
                    z2 = true;
                }
            } else {
                j3 = j2;
                str3 = \"?\";
            }
            regionList$bB = null;
            O(b3Var.f663c, str3);
            b3Var.f663c.setTextColor(android.ext.RegionList$b.c(regionList$bB));
            if (iN3 == 1) {
                z2 = true;
            }
        } else {""",
     """        if ((i & 1) != 0) {
            regionList$bB = null;
            if (z) {
                j3 = iN3 != 8 ? j2 & ((1 << (iN3 * 8)) - 1) : j2;
                str3 = android.ext.t2.e(iN3 * 2, j3) + \"h;\";
                android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
                if (iN3 == 4 || (z1_d != null && z1_d.n && iN3 == 8)) {
                    regionList$bB = android.ext.RegionList.b(j3);
                }
            } else {
                j3 = j2;
                str3 = \"?\";
            }
            O(b3Var.f663c, str3);
            b3Var.f663c.setTextColor(android.ext.RegionList$b.c(regionList$bB));
            if (iN3 == 1) {
                z2 = true;
            }
        } else {"""),
    # dex: the handler of ":catch_0" is a plain java.io.IOException, but the
    #      buffer based reader of android.ext.w can only raise the unchecked
    #      variant, so the handler keeps the matching unchecked type.
    ('android/ext/n1.java',
     """        } catch (java.io.IOException e2) {
            e = e2;
            android.ext.e1.s(\"Failed load data to memory editor\", e);""",
     """        } catch (java.io.UncheckedIOException e2) {
            e = e2;
            android.ext.e1.s(\"Failed load data to memory editor\", e);"""),
]


def main():
    n = 0
    for rel, old, new in PATCHES:
        path = os.path.join(SRC, rel)
        if not os.path.exists(path):
            print('MISSING', rel)
            continue
        text = open(path, encoding='utf-8').read()
        text, hits = replace_guarded(text, old, new)
        if not hits:
            print('NOT FOUND in %s: %r' % (rel, old.splitlines()[0][:70]))
            continue
        open(path, 'w', encoding='utf-8').write(text)
        n += 1
    print('round4 patches applied:', n)


if __name__ == '__main__':
    main()

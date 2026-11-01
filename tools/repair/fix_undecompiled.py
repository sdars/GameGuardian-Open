#!/usr/bin/env python3
"""Hand written implementations for the four methods jadx could not decompile.

jadx refuses four methods of GameGuardian 101.4 (they are either far too large
for the decompiler or use a control flow shape it cannot express).  Every
implementation below was reconstructed from the smali of the original APK
which is kept next to the sources in tmp/analysis/2026-11-01/apktool_src.
"""
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, "app", "src", "main", "java")


def path(rel):
    return os.path.join(SRC, rel)


def replace(rel, old, new):
    p = path(rel)
    s = open(p, encoding="utf-8").read()
    if old not in s:
        print("MISS", rel)
        return False
    s = s.replace(old, new, 1)
    open(p, "w", encoding="utf-8").write(s)
    print("patched", rel)
    return True


# ------------------------------------------------- android/ext/f1$a.java
F1A_OLD = """        throw new UnsupportedOperationException("Method not decompiled: android.ext.f1$a.run():void");"""
F1A_NEW = """        android.ext.f1.B(1, (java.lang.String) null);
        boolean z = android.ext.b1.j0().f610a;
        android.ext.r rVar = android.ext.r.n;
        boolean z2 = z && (!android.ext.Config.vSpaceReal || android.ext.Config.D);
        rVar.f1206d = z2;
        if (z) {
            boolean z3 = android.ext.ConfigListAdapter.k();
            android.ext.e1.d("Install64: " + z3);
            if (z3) {
                android.ext.f1.M();
            } else {
                android.ext.f1.L();
            }
            return;
        }
        android.ext.r.q = false;
        if (android.ext.f1.f954d) {
            android.ext.f1.B(8, (java.lang.String) null);
            android.ext.f1.D();
            return;
        }
        boolean z4 = android.ext.u.c();
        android.ext.f1.f(z4 ? (byte) 1 : (byte) 2);
        if (!z4) {
            android.ext.e1.d("Not instr: " + android.os.Process.myUid());
            android.ext.f1.B(2, "" + android.ext.Config.z);
            android.ext.n2.i(new android.ext.f1$a$a(this));
            android.ext.f1.B(4, (java.lang.String) null);
            return;
        }
        android.ext.e1.d("Use instr: " + android.os.Process.myUid());
        android.ext.f1.B(9, (java.lang.String) null);
        android.ext.f1.O();
        android.ext.f1.D();"""

if __name__ == "__main__":
    replace("android/ext/f1$a.java", F1A_OLD, F1A_NEW)
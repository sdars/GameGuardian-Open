#!/usr/bin/env python3
"""Rewrite android.ext.e0.l() so that it matches the original dex.

The decompiler duplicated the shared loop body and inverted the isFile()
test in both copies, so the library was loaded only when it did *not* exist.
"""
import io
import os
import sys

PATH = os.path.join(os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))),
                    "app/src/main/java/android/ext/e0.java")

NEW = '''    public static void l() {
        char[] cArr = {0, 'q', 'p', 'r', 's', 't'};
        java.lang.String strG = g();
        for (int i = 0; i < cArr.length; i++) {
            if (i == 0) {
                for (int i2 = 1; i2 < cArr.length; i2++) {
                    if (new java.io.File(strG, q(cArr[i2])).exists()) {
                        cArr[0] = cArr[i2];
                        break;
                    }
                }
                if (cArr[0] == 0) {
                    continue;
                }
            }
            java.io.File file = new java.io.File(strG, q(cArr[i]));
            if (!file.isFile()) {
                b(cArr[i]);
            }
            if (!file.isFile()) {
                android.ext.e1.d("Not a file " + file + ' ' + file.getAbsolutePath());
                continue;
            }
            try {
                java.lang.System.load(file.getAbsolutePath());
                try {
                    android.lang.ProcessBuilder.loaded();
                    return;
                } catch (java.lang.Throwable th_c) {
                    android.ext.e1.g("Failed check " + file + ' ' + file.getAbsolutePath(), th_c);
                }
            } catch (java.lang.Throwable th2) {
                android.ext.e1.g("Failed load " + file + ' ' + file.getAbsolutePath(), th2);
            }
        }
    }
'''


def main():
    src = io.open(PATH, encoding="utf-8").read()
    start = src.index("    public static void l() {")
    # find the end of the method: the next line that is exactly four spaces + '}'
    end = src.index("\n    }\n", start) + len("\n    }\n")
    out = src[:start] + NEW + src[end:]
    io.open(PATH, "w", encoding="utf-8").write(out)
    print("e0.l() rewritten (%d -> %d bytes)" % (len(src), len(out)))


if __name__ == "__main__":
    sys.exit(main())

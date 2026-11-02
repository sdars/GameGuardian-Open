#!/usr/bin/env python3
"""Rewrite android.ext.b1.x() - the MUTF-8 decoder used by fixDex().

The decompiler dropped the "continue" of the two- and three-byte branches,
so every multi byte string was rejected with "bad MUTF-8".  The replacement
follows the original dex (build/smali_dbg/android/ext/b1.smali) instruction by
instruction.
"""
import io
import os
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
PATH = os.path.join(ROOT, "app/src/main/java/android/ext/b1.java")

SIG = "    private static android.ext.b1$u x(byte[] bArr, int i, int i2, int i3) {"

NEW = '''    private static android.ext.b1$u x(byte[] bArr, int i, int i2, int i3) {
        java.lang.String str = "fixDex: string " + i3 + " is malformed";
        int i5 = 0;
        int i6 = 0;
        do {
            int i7 = i2 - i;
            if (i5 >= i7) {
                throw new android.ext.b1$v(str + ": truncated ULEB128 length");
            }
            int i8 = bArr[i + i5];
            i6 |= (i8 & 127) << (i5 * 7);
            i5++;
            if ((i8 & 128) == 0) {
                if (i6 < 0 || i6 + 1 > i7 - i5) {
                    throw new android.ext.b1$v(str + ": payload overruns its bound");
                }
                int i9 = i + i5;
                char[] cArr = new char[i6];
                for (int i10 = 0; i10 < i6; i10++) {
                    if (i9 >= i2) {
                        throw new android.ext.b1$v(str + ": truncated MUTF-8 payload");
                    }
                    byte b2 = bArr[i9];
                    int i11 = b2 & 255;
                    if (i11 == 0) {
                        throw new android.ext.b1$v(str + ": string shorter than indicated size " + i6);
                    }
                    if (i11 < 128) {
                        cArr[i10] = (char) i11;
                        i9++;
                        continue;
                    }
                    if ((b2 & 224) == 192) {
                        int i4 = i9 + 2;
                        if (i4 <= i2) {
                            byte b3 = bArr[i9 + 1];
                            if ((b3 & 192) == 128) {
                                int i12 = (b3 & 63) | ((b2 & 31) << 6);
                                if (i12 != 0 && i12 < 128) {
                                    throw new android.ext.b1$v(str + ": overlong MUTF-8");
                                }
                                cArr[i10] = (char) i12;
                                i9 = i4;
                                continue;
                            }
                        }
                        throw new android.ext.b1$v(str + ": bad MUTF-8");
                    }
                    if ((b2 & 240) != 224) {
                        throw new android.ext.b1$v(str + ": invalid MUTF-8");
                    }
                    int i14 = i9 + 3;
                    if (i14 <= i2) {
                        byte b4 = bArr[i9 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i9 + 2];
                            if ((b5 & 192) == 128) {
                                int i13 = (b5 & 63) | ((b2 & 15) << 12) | ((b4 & 63) << 6);
                                if (i13 < 2048) {
                                    throw new android.ext.b1$v(str + ": overlong MUTF-8");
                                }
                                cArr[i10] = (char) i13;
                                i9 = i14;
                                continue;
                            }
                        }
                    }
                    throw new android.ext.b1$v(str + ": bad MUTF-8");
                }
                if (i9 < i2 && bArr[i9] == 0) {
                    return new android.ext.b1$u(new java.lang.String(cArr), i6, (i9 - i) + 1);
                }
                throw new android.ext.b1$v(str + ": missing NUL terminator");
            }
        } while (i5 <= 4);
        throw new android.ext.b1$v(str + ": invalid ULEB128 length");
    }
'''


def replace_method(src, sig, new):
    start = src.index(sig)
    depth = 0
    i = start
    while i < len(src):
        c = src[i]
        if c == '{':
            depth += 1
        elif c == '}':
            depth -= 1
            if depth == 0:
                end = i + 1
                break
        i += 1
    return src[:start] + new.rstrip("\n") + src[end:]


def main():
    src = io.open(PATH, encoding="utf-8").read()
    out = replace_method(src, SIG, NEW)
    io.open(PATH, "w", encoding="utf-8").write(out)
    print("b1.x() rewritten (%d -> %d bytes)" % (len(src), len(out)))


if __name__ == "__main__":
    sys.exit(main())

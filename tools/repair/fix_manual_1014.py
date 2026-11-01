#!/usr/bin/env python3
"""Hand written repairs for the GameGuardian 101.4 reconstruction.

Every patch in this file restores a construct that jadx could not express in
Java (a dex jump out of a loop, a synthetic constructor bridge, a field that
is read from an inner class) or that the automated passes cannot decide on
their own.  The dex behaviour is the reference: the smali of the original
APK is used whenever a construct is ambiguous.
"""
import os
import re
import sys

ROOT = os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
SRC = os.path.join(ROOT, 'app', 'src', 'main', 'java')


def path(rel):
    return os.path.join(SRC, rel)


PATCHES = []


def patch(rel, old, new, count=1):
    PATCHES.append((rel, old, new, count))


# ---------------------------------------------------------------- Script.java
patch('android/ext/Script.java', '''    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = u0;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = luaj.LuaTable.j3(t0[i2], 3);
            i2++;
        }
        while (true) {
            int[] iArr2 = v0;
            if (i >= iArr2.length) {
                w0 = null;
                
            } else {
                iArr2[i] = luaj.LuaTable.j3(t0[i], 7);
                i++;
            }
        }
    }''', '''    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = u0;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = luaj.LuaTable.j3(t0[i2], 3);
            i2++;
        }
        while (true) {
            int[] iArr2 = v0;
            if (i >= iArr2.length) {
                break;
            }
            iArr2[i] = luaj.LuaTable.j3(t0[i], 7);
            i++;
        }
        w0 = null;
    }''')

# q3(): jadx merged the LuaValue argument with the local String.  The dex
# stores the string in the same register, the LuaValue is only used by the
# catch handler (smali: Script.smali q3).
patch('android/ext/Script.java', '''        java.lang.String strB0;
        long jDoubleToRawLongBits;''', '''        long jDoubleToRawLongBits;''')
patch('android/ext/Script.java', '''        try {
            if (z) {
                luaValue = luaValue2.I1(null);
            } else {
                strB0 = luaValue2.B0();
            }
            if (luaValue == 0) {
                luaValue = strB0;
                return 0L;
            }
            luaValue = strB0;
            java.lang.String strD3 = D3(luaValue);''', '''        try {
            java.lang.String strB0 = z ? luaValue2.I1(null) : luaValue2.B0();
            if (strB0 == null) {
                return 0L;
            }
            java.lang.String strD3 = D3(strB0);''')

# ------------------------------------------------------- Script$makeRequest
patch('android/ext/Script$makeRequest.java', '''        } catch (java.lang.Throwable th6) {
            th = th6;
        }
    }
}''', '''        } catch (java.lang.Throwable th6) {
            th = th6;
        }
        return null;
    }
}''')

# ------------------------------------------------------------------ Tools.java
patch('android/ext/Tools.java', '''        } catch (java.lang.Throwable th2) {
            th = th2;
            r3 = null;
        }
    }

    public static java.io.File b0() {''', '''        } catch (java.lang.Throwable th2) {
            th = th2;
            r3 = null;
        }
        return false;
    }

    public static java.io.File b0() {''')

# -------------------------------------------------------------- HexConverter
patch('android/ext/HexConverter.java', '''        if (j != 0) {try {

            java.lang.String str8 = ':' + new java.lang.String(bArrG, 0, i7 + 1, "UTF-8");
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
            arrayList.add("UTF-8: " + str8);''', '''        if (j != 0) {
            java.lang.String str8;
            try {
                str8 = ':' + new java.lang.String(bArrG, 0, i7 + 1, "UTF-8");
            } catch (java.lang.RuntimeException ggEx) {
                throw ggEx;
            } catch (java.lang.Throwable ggEx2) {
                throw new java.lang.RuntimeException(ggEx2);
            }
            arrayList.add("UTF-8: " + str8);''')

# --------------------------------------------------------------------- w.java
# the dex jumps out of the "compare" loop with a goto, jadx emitted a break
# at method level (smali: android/ext/w.smali i(ILjava/lang/String;))
patch('android/ext/w.java', '''        if (str == null || str.length() != i) {
            str = null;
            break;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (str.charAt(i2) != bArr[iPosition + i2]) {
                str = null;
                break;
            }
        }''', '''        if (str == null || str.length() != i) {
            str = null;
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                if (str.charAt(i2) != bArr[iPosition + i2]) {
                    str = null;
                    break;
                }
            }
        }''')

# ------------------------------------------------------------------- z1.java
# the dex branches around the process list, jadx emitted a break at method
# level (smali: android/ext/z1.smali h(IILjava/lang/String;...))
patch('android/ext/z1.java', '''            if (list == null) {
                str2 = str;
                break;
            }
            java.util.Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str2 = str;
                    break;
                }
                android.app.ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo = (android.app.ActivityManager.RunningAppProcessInfo) it.next();
                if (activityManager$RunningAppProcessInfo != null && activityManager$RunningAppProcessInfo.pid == i2 && (strArr = activityManager$RunningAppProcessInfo.pkgList) != null && strArr.length > 0) {
                    str2 = strArr[0];
                    z = true;
                    break;
                }
            }''', '''            if (list == null) {
                str2 = str;
            } else {
                java.util.Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = str;
                        break;
                    }
                    android.app.ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo = (android.app.ActivityManager.RunningAppProcessInfo) it.next();
                    if (activityManager$RunningAppProcessInfo != null && activityManager$RunningAppProcessInfo.pid == i2 && (strArr = activityManager$RunningAppProcessInfo.pkgList) != null && strArr.length > 0) {
                        str2 = strArr[0];
                        z = true;
                        break;
                    }
                }
            }''')

# ----------------------------------------------------------- gg_d/f.java, e.java
patch('gg_d/f.java', '''        } catch (java.lang.CloneNotSupportedException unused2) {
        }
    }

    public int b(long j) {''', '''        } catch (java.lang.CloneNotSupportedException unused2) {
        }
        return fVar;
    }

    public int b(long j) {''')
patch('gg_d/e.java', '''        } catch (java.lang.CloneNotSupportedException unused2) {
        }
    }

    public java.lang.Object c(long j) {''', '''        } catch (java.lang.CloneNotSupportedException unused2) {
        }
        return eVar;
    }

    public java.lang.Object c(long j) {''')

# --------------------------------------------------------- constructor bridges
# A this()/super() call has to be the first statement of a constructor, so the
# synthetic dex bridges are restored as plain delegating constructors.
patch('android/ext/b1$a0.java', '''    /* synthetic */ b1$a0(java.io.RandomAccessFile randomAccessFile, android.ext.b1$i b1_i) {try {

        this(randomAccessFile);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }''', '''    /* synthetic */ b1$a0(java.io.RandomAccessFile randomAccessFile, android.ext.b1$i b1_i) throws java.io.IOException {
        this(randomAccessFile);
    }''')

patch('gg_e/e.java', '''    public e(java.io.InputStream inputStream, java.lang.String str, int i, int i2, int i3) {try {

        this(str == null ? new java.io.InputStreamReader(inputStream) : new java.io.InputStreamReader(inputStream, str), i, i2, i3);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }''', '''    public e(java.io.InputStream inputStream, java.lang.String str, int i, int i2, int i3) {
        this(str == null ? new java.io.InputStreamReader(inputStream) : new java.io.InputStreamReader(inputStream, str), i, i2, i3);
    }''')

patch('android/ext/x2$g.java', '''    x2$g(java.lang.String str, java.lang.String str2) {try {

        super(str);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        this.f1322a = str2;
    }''', '''    x2$g(java.lang.String str, java.lang.String str2) throws java.io.FileNotFoundException {
        super(str);
        this.f1322a = str2;
    }''')

patch('lasm/LasmBase$V.java', '''    LasmBase$V(gg_e.f fVar) {try {

        super(fVar, lasm.LasmBase.f(fVar, 1));
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }''', '''    LasmBase$V(gg_e.f fVar) {
        super(fVar, lasm.LasmBase.f(fVar, 1));
    }''')
patch('lasm/LasmBase$U.java', '''    LasmBase$U(gg_e.f fVar) {try {

        super(fVar, lasm.LasmBase.f(fVar, 1));
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }''', '''    LasmBase$U(gg_e.f fVar) {
        super(fVar, lasm.LasmBase.f(fVar, 1));
    }''')

patch('luaj/lib/IoLib$FileImpl.java', '''    /* synthetic */ IoLib$FileImpl(luaj.lib.IoLib ioLib, java.io.File file, char c2, luaj.lib.IoLib$a ioLib$a) {try {

        this(ioLib, file, c2);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }''', '''    /* synthetic */ IoLib$FileImpl(luaj.lib.IoLib ioLib, java.io.File file, char c2, luaj.lib.IoLib$a ioLib$a) throws java.io.IOException {
        this(ioLib, file, c2);
    }''')

# the RandomAccessFile has to survive the try block
patch('luaj/lib/IoLib$FileImpl.java', '''        if (c2 == 'r') {try {

            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "r");
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
            if (this.W.O3(file, randomAccessFile.getFD(), true)) {''', '''        if (c2 == 'r') {
            java.io.RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new java.io.RandomAccessFile(file, "r");
            } catch (java.lang.RuntimeException ggEx) {
                throw ggEx;
            } catch (java.lang.Throwable ggEx2) {
                throw new java.lang.RuntimeException(ggEx2);
            }
            if (this.W.O3(file, randomAccessFile.getFD(), true)) {''')

# IoLib$H3 may raise the file error of the dex, the override catches it
patch('luaj/lib/IoLib.java', '''    protected luaj.lib.IoLib$File H3(java.lang.String str, char c2) {
        return new luaj.lib.IoLib$FileImpl(this, this.Y.R3(str), c2, null);
    }''', '''    protected luaj.lib.IoLib$File H3(java.lang.String str, char c2) throws java.io.IOException {
        return new luaj.lib.IoLib$FileImpl(this, this.Y.R3(str), c2, null);
    }''')
patch('luaj/lib/IoLib.java', '''            return H3(str, (char) (str2.charAt(0) + (str2.indexOf(43) > 0 ? '+' : (char) 0)));''', '''            try {
                return H3(str, (char) (str2.charAt(0) + (str2.indexOf(43) > 0 ? '+' : (char) 0)));
            } catch (java.io.IOException e) {
                throw new java.lang.RuntimeException(e);
            }''')
patch('android/ext/Script$IoLibSafe.java', '''    protected luaj.lib.IoLib$File H3(java.lang.String str, char c2) {''', '''    protected luaj.lib.IoLib$File H3(java.lang.String str, char c2) throws java.io.IOException {''')
patch('luaj/lib/IoLib$c.java', '''    IoLib$c(java.lang.String str) {''', '''    public IoLib$c(java.lang.String str) {''')

# ------------------------------------------------------------------- IoLib
patch('luaj/lib/IoLib.java', '''    public static luaj.LuaValue v3(luaj.lib.IoLib$File ioLib$File) {try {

        int iA3 = ioLib$File.a3();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        if (iA3 >= 0) {''', '''    public static luaj.LuaValue v3(luaj.lib.IoLib$File ioLib$File) {
        int iA3;
        try {
            iA3 = ioLib$File.a3();
        } catch (java.lang.RuntimeException ggEx) {
            throw ggEx;
        } catch (java.lang.Throwable ggEx2) {
            throw new java.lang.RuntimeException(ggEx2);
        }
        if (iA3 >= 0) {''')
patch('luaj/lib/IoLib.java', '''        java.lang.String string2 = byteArrayOutputStream.toString();
        if (string2.length() > 0) {
        }
    }''', '''        java.lang.String string2 = byteArrayOutputStream.toString();
        return string2.length() > 0 ? luaj.LuaValue.P1(string2, luaj.LuaValue.f1673c) : luaj.LuaValue.f1673c;
    }''')

# ------------------------------------------------------------ StringLib$dump
patch('luaj/lib/StringLib$dump.java', '''        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

            gg_g.b.a(((luaj.LuaClosure) luaFunctionC).R, byteArrayOutputStream, varargs.V(2, false), varargs.V(3, false));
            return luaj.LuaString.o3(byteArrayOutputStream.toByteArray());
        } catch (java.io.IOException e2) {
            return luaj.LuaValue.R0(e2.getMessage());
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }''', '''        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            if (android.ext.GgNoop.never) {
                throw new java.io.IOException();
            }
            gg_g.b.a(((luaj.LuaClosure) luaFunctionC).R, byteArrayOutputStream, varargs.V(2, false), varargs.V(3, false));
            return luaj.LuaString.o3(byteArrayOutputStream.toByteArray());
        } catch (java.io.IOException e2) {
            return luaj.LuaValue.R0(e2.getMessage());
        }''')

# --------------------------------------------------------------------- h3.java
patch('android/ext/h3.java', '''java.lang.Throwable e = null;
java.lang.Throwable th = null;
java.lang.Throwable th2 = null;
        java.lang.Throwable th = null;
        java.io.RandomAccessFile randomAccessFile = null;
        boolean z;
        java.lang.Throwable th2;''', '''java.lang.Throwable e = null;
java.lang.Throwable th = null;
java.lang.Throwable th2 = null;
        java.io.RandomAccessFile randomAccessFile = null;
        boolean z = false;''')
patch('android/ext/h3.java', '''                                    if (z) {
                                        throw ggEx;
                                    }''', '''                                    if (z) {
                                        throw e;
                                    }''')
patch('android/ext/h3.java', '''                            if (z) {
                                throw ggEx;
                            }''', '''                            if (z) {
                                throw e;
                            }''')

# --------------------------------------------------------------------- x2.java
patch('android/ext/x2.java', '''                                                            } catch (java.lang.Throwable th_c) {
                                                                fileOutputStream.close();
                                                                throw th_c;
                                                            }
                                                            e = e2;
                                                            android.ext.e1.s("Failed read data from " + file3, e);
                                                        }''', '''                                                            } catch (java.lang.Throwable th_c) {
                                                                fileOutputStream.close();
                                                                throw th_c;
                                                            }
                                                        }''')
patch('android/ext/x2.java', '''        if (android.ext.s1.n()) {
            android.ext.e1.d(str);
            return;
        }''', '''        if (android.ext.s1.n()) {
            android.ext.e1.d("Un: drain owns recovery");
            return;
        }''')

# ----------------------------------------------------------- ProcessBuilder
patch('android/lang/ProcessBuilder.java', '''            throw new java.io.IOException(sb.toString(), e);
        };
} catch (java.lang.RuntimeException ggEx) {''', '''            throw new java.io.IOException(sb.toString(), e);
        }
} catch (java.lang.RuntimeException ggEx) {''')

# -------------------------------------------------------------- UNIXProcess
patch('android/lang/UNIXProcess.java', '''            if (android.ext.GgNoop.never) {
                        throw new java.security.PrivilegedActionException();
                    }''', '''            if (android.ext.GgNoop.never) {
                        throw new java.security.PrivilegedActionException(null);
                    }''')

# --------------------------------------------------------------------- e0.java
patch('android/ext/e0.java', '''                throw e2;
            }
        }
        return 100;
    }''', '''                throw new java.lang.RuntimeException(e2);
            }
        }
        return 100;
    }''')

# --------------------------------------------------------------------- m.java
patch('android/ext/m.java', '''                                return i;
                        }
                }
        }
    }

    private static int m(android.ext.n$d n_d, int i, java.lang.String str, int i2) {''', '''                                return i;
                        }
                }
        }
        return i;
    }

    private static int m(android.ext.n$d n_d, int i, java.lang.String str, int i2) {''')


def main():
    failed = 0
    for rel, old, new, count in PATCHES:
        p = path(rel)
        if not os.path.exists(p):
            print('MISSING FILE', rel)
            failed += 1
            continue
        s = open(p, encoding='utf-8').read()
        n = s.count(old)
        if n != count:
            print('PATCH NOT APPLIED (%d/%d): %s' % (n, count, rel))
            print('   ' + old.strip().split(chr(10))[0][:100])
            failed += 1
            continue
        s = s.replace(old, new, count)
        open(p, 'w', encoding='utf-8').write(s)
    print('patches applied:', len(PATCHES) - failed, '/', len(PATCHES))
    return 1 if failed else 0


if __name__ == '__main__':
    sys.exit(main())

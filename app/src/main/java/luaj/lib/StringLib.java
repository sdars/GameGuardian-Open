package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class StringLib extends luaj.lib.TwoArgFunction {
    private static final luaj.LuaString T = luaj.LuaValue.K2("^$*+?.([%-");
    static final byte[] U = new byte[256];

    static {
        for (int i = 0; i < 128; i++) {
            char c2 = (char) i;
            byte[] bArr = U;
            byte b2 = (byte) (((c2 < ' ' || c2 == 127) ? 64 : 0) | (java.lang.Character.isDigit(c2) ? 8 : 0) | (java.lang.Character.isLowerCase(c2) ? 2 : 0) | (java.lang.Character.isUpperCase(c2) ? 4 : 0));
            bArr[i] = b2;
            if ((c2 >= 'a' && c2 <= 'f') || ((c2 >= 'A' && c2 <= 'F') || (c2 >= '0' && c2 <= '9'))) {
                bArr[i] = (byte) (b2 | (-128));
            }
            if ((c2 >= '!' && c2 <= '/') || ((c2 >= ':' && c2 <= '@') || ((c2 >= '[' && c2 <= '`') || (c2 >= '{' && c2 <= '~')))) {
                bArr[i] = (byte) (bArr[i] | 16);
            }
            byte b3 = bArr[i];
            if ((b3 & 6) != 0) {
                bArr[i] = (byte) (b3 | 1);
            }
        }
        byte[] bArr2 = U;
        bArr2[32] = 32;
        bArr2[13] = (byte) (bArr2[13] | 32);
        bArr2[10] = (byte) (bArr2[10] | 32);
        bArr2[9] = (byte) (bArr2[9] | 32);
        bArr2[11] = (byte) (bArr2[11] | 32);
        bArr2[12] = (byte) (bArr2[12] | 32);
    }

    static void X2(gg_f.a aVar, luaj.LuaString luaString) {
        aVar.a((byte) 34);
        int iS1 = luaString.s1();
        for (int i = 0; i < iS1; i++) {
            int iG3 = luaString.g3(i);
            if (iG3 == 10 || iG3 == 34 || iG3 == 92) {
                aVar.a((byte) 92);
            } else {
                if (iG3 <= 31 || iG3 == 127) {
                    aVar.a((byte) 92);
                    int i2 = i + 1;
                    if (i2 == iS1 || luaString.g3(i2) < 48 || luaString.g3(i2) > 57) {
                        aVar.b(java.lang.Integer.toString(iG3));
                    } else {
                        aVar.a((byte) 48);
                        aVar.a((byte) ((char) ((iG3 / 10) + 48)));
                        iG3 = (char) ((iG3 % 10) + 48);
                    }
                }
            }
            aVar.a((byte) iG3);
        }
        aVar.a((byte) 34);
    }

    static byte Y2(luaj.lib.StringLib$c stringLib$c, int i) {
        byte bA3 = a3(stringLib$c);
        int i2 = stringLib$c.f1791g;
        if (bA3 == 8) {
            if (stringLib$c.f1788d.length() <= stringLib$c.f1789e) {
                luaj.LuaValue.k0(1, "no next option for option 'X' at pos " + stringLib$c.f1789e);
            }
            if (a3(stringLib$c) == 4 || (i2 = stringLib$c.f1791g) == 0) {
                luaj.LuaValue.k0(1, android.ext.t2.f("invalid next option '%c' for option 'X' at pos %d", java.lang.Character.valueOf(stringLib$c.f1790f), java.lang.Integer.valueOf(stringLib$c.f1789e)));
            }
            stringLib$c.i = 0;
        }
        if (i2 <= 1 || bA3 == 4) {
            stringLib$c.h = 0;
        } else {
            int i3 = stringLib$c.f1787c;
            if (i2 > i3) {
                stringLib$c.f1791g = i3;
                i2 = i3;
            }
            int i4 = i2 - 1;
            if ((i2 & i4) != 0) {
                luaj.LuaValue.k0(1, android.ext.t2.f("format option '%c' asks for alignment not power of 2 at pos %d", java.lang.Character.valueOf(stringLib$c.f1790f), java.lang.Integer.valueOf(stringLib$c.f1789e)));
            }
            stringLib$c.h = (i2 - (i & i4)) & i4;
        }
        return bA3;
    }

    static int Z2(luaj.lib.StringLib$c stringLib$c, int i, boolean z) {
        char cCharAt;
        java.lang.String str = stringLib$c.f1788d;
        int length = str.length();
        int i2 = stringLib$c.f1789e;
        if (i2 < length && (cCharAt = str.charAt(i2)) <= '9' && cCharAt >= '0') {
            i = 0;
            do {
                i = (i * 10) + (cCharAt - '0');
                i2++;
                if (i2 >= length || (cCharAt = str.charAt(i2)) > '9' || cCharAt < '0') {
                    break;
                }
            } while (i <= 214748363);
            stringLib$c.f1789e = i2;
        }
        if (z && (i > 8 || i <= 0)) {
            luaj.LuaValue.R0(android.ext.t2.f("integral size (%d) out of limits [1,%d] at pos %d", java.lang.Integer.valueOf(i), 8, java.lang.Integer.valueOf(stringLib$c.f1789e)));
        }
        return i;
    }

    static byte a3(luaj.lib.StringLib$c stringLib$c) {
        java.lang.String str = stringLib$c.f1788d;
        int i = stringLib$c.f1789e;
        stringLib$c.f1789e = i + 1;
        char cCharAt = str.charAt(i);
        stringLib$c.f1790f = cCharAt;
        int i2 = 4;
        int i3 = 1;
        try {
            switch (cCharAt) {
                case ' ':
                    break;
                case '!':
                    stringLib$c.f1787c = Z2(stringLib$c, stringLib$c.f1785a, true);
                    break;
                case '<':
                case '=':
                    stringLib$c.f1786b = true;
                    break;
                case '>':
                    stringLib$c.f1786b = false;
                    break;
                case 'B':
                    stringLib$c.i = 1;
                    stringLib$c.f1791g = 1;
                    return (byte) 2;
                case 'H':
                    stringLib$c.i = 2;
                    stringLib$c.f1791g = cCharAt != 'c' ? 2 : 1;
                    return (byte) 2;
                case 'I':
                    int iZ2 = Z2(stringLib$c, 4, true);
                    stringLib$c.i = iZ2;
                    if (cCharAt == 'c') {
                        i2 = 1;
                    } else if (iZ2 < 8) {
                        i2 = iZ2;
                    }
                    stringLib$c.f1791g = i2;
                    return (byte) 2;
                case 'J':
                    stringLib$c.i = 8;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 4;
                    return (byte) 2;
                case 'L':
                    stringLib$c.i = 8;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 4;
                    return (byte) 2;
                case 'T':
                    byte b2 = stringLib$c.f1785a;
                    stringLib$c.i = b2;
                    if (cCharAt == 'c') {
                        i2 = 1;
                    } else if (b2 < 8) {
                        i2 = b2;
                    }
                    stringLib$c.f1791g = i2;
                    return (byte) 2;
                case 'X':
                    stringLib$c.i = 0;
                    stringLib$c.f1791g = cCharAt != 'c' ? 0 : 1;
                    return (byte) 8;
                case 'b':
                    stringLib$c.i = 1;
                    stringLib$c.f1791g = 1;
                    return (byte) 1;
                case 'c':
                    int iZ3 = Z2(stringLib$c, -1, false);
                    if (iZ3 == -1) {
                        luaj.LuaValue.R0("missing size for format option 'c' at pos " + stringLib$c.f1789e);
                    }
                    stringLib$c.i = iZ3;
                    if (cCharAt != 'c') {
                        i3 = iZ3 >= 8 ? 4 : iZ3;
                    }
                    stringLib$c.f1791g = i3;
                    return (byte) 4;
                case 'd':
                    stringLib$c.i = 8;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 4;
                    return (byte) 9;
                case 'f':
                    stringLib$c.i = 4;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 4;
                    return (byte) 3;
                case 'h':
                    stringLib$c.i = 2;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 2;
                    return (byte) 1;
                case 'i':
                    int iZ4 = Z2(stringLib$c, 4, true);
                    stringLib$c.i = iZ4;
                    if (cCharAt == 'c') {
                        i2 = 1;
                    } else if (iZ4 < 8) {
                        i2 = iZ4;
                    }
                    stringLib$c.f1791g = i2;
                    return (byte) 1;
                case 'j':
                    stringLib$c.i = 8;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 4;
                    return (byte) 1;
                case 'l':
                    stringLib$c.i = 8;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 4;
                    return (byte) 1;
                case 'n':
                    stringLib$c.i = 9;
                    stringLib$c.f1791g = cCharAt == 'c' ? 1 : 4;
                    return (byte) 10;
                case 's':
                    int iZ5 = Z2(stringLib$c, stringLib$c.f1785a, true);
                    stringLib$c.i = iZ5;
                    if (cCharAt == 'c') {
                        i2 = 1;
                    } else if (iZ5 < 8) {
                        i2 = iZ5;
                    }
                    stringLib$c.f1791g = i2;
                    return (byte) 5;
                case 'x':
                    stringLib$c.i = 1;
                    stringLib$c.f1791g = 1;
                    return (byte) 7;
                case 'z':
                    stringLib$c.i = 0;
                    stringLib$c.f1791g = cCharAt != 'c' ? 0 : 1;
                    return (byte) 6;
                default:
                    luaj.LuaValue.R0(android.ext.t2.f("invalid format option '%c' at pos %d", java.lang.Character.valueOf(cCharAt), java.lang.Integer.valueOf(stringLib$c.f1789e)));
                    break;
            }
            stringLib$c.i = 0;
            stringLib$c.f1791g = cCharAt != 'c' ? 0 : 1;
            return (byte) 0;
        } catch (java.lang.Throwable th_c_c_c) {
            stringLib$c.i = 0;
            if (cCharAt == 'c') {
                i2 = 1;
            } else if (0 < 8) {
                i2 = 0;
            }
            stringLib$c.f1791g = i2;
            throw th_c_c_c;
        }
    }

    static void b3(luaj.lib.StringLib$c stringLib$c, gg_f.a aVar, long j) {
        stringLib$c.k.order(stringLib$c.f1786b ? java.nio.ByteOrder.LITTLE_ENDIAN : java.nio.ByteOrder.BIG_ENDIAN).putLong(0, j);
        aVar.e(stringLib$c.j, stringLib$c.f1786b ? 0 : 8 - stringLib$c.i, stringLib$c.i);
    }

    static int c3(int i, int i2) {
        return i >= 0 ? i : i2 + i + 1;
    }

    static luaj.Varargs d3(luaj.Varargs varargs, boolean z) {
        boolean z2;
        int i;
        luaj.LuaString luaStringH = varargs.H(1);
        luaj.LuaString luaStringH2 = varargs.H(2);
        int iS1 = luaStringH.s1();
        int iC3 = c3(varargs.Y(3, 1), iS1);
        if (iC3 < 1) {
            iC3 = 1;
        } else if (iC3 > iS1 + 1) {
            return luaj.LuaValue.f1673c;
        }
        int i2 = iC3 - 1;
        if (z && (varargs.v(4).w2() || luaStringH2.e3(T) == -1)) {
            int iD3 = luaStringH.d3(luaStringH2, i2);
            if (iD3 != -1) {
                return luaj.LuaValue.N2(luaj.LuaValue.I2(iD3 + 1), luaj.LuaValue.I2(iD3 + luaStringH2.s1()));
            }
        } else {
            luaj.lib.StringLib$b stringLib$b = new luaj.lib.StringLib$b(varargs, luaStringH, luaStringH2);
            if (luaStringH2.s1() <= 0 || luaStringH2.g3(0) != 94) {
                z2 = false;
                i = 0;
            } else {
                z2 = true;
                i = 1;
            }
            while (true) {
                stringLib$b.p();
                int iG = stringLib$b.g(i2, i);
                if (iG != -1) {
                    return z ? luaj.LuaValue.M2(luaj.LuaValue.I2(i2 + 1), luaj.LuaValue.I2(iG), stringLib$b.n(false, i2, iG)) : stringLib$b.n(true, i2, iG);
                }
                int i3 = i2 + 1;
                if (i2 >= iS1 || z2) {
                    break;
                }
                i2 = i3;
            }
        }
        return luaj.LuaValue.f1673c;
    }

    static long e3(luaj.lib.StringLib$c stringLib$c, luaj.LuaString luaString, int i, boolean z) {
        int i2;
        int i3 = stringLib$c.i;
        if (i3 == 1) {
            long j = luaString.P[luaString.Q + i];
            return !z ? j & 255 : j;
        }
        byte[] bArr = stringLib$c.j;
        if (i3 < 8) {
            if (!stringLib$c.f1786b) {
                i2 = 8 - i3;
                int i4 = i2;
                while (true) {
                    i4--;
                    if (i4 < 0) {
                        break;
                    }
                    bArr[i4] = 0;
                }
            } else {
                int i5 = i3 - 1;
                while (true) {
                    i5++;
                    if (i5 >= 8) {
                        break;
                    }
                    bArr[i5] = 0;
                }
                i2 = 0;
            }
        } else {
            i2 = 0;
        }
        luaString.U2(i, bArr, i2, i3);
        long j2 = stringLib$c.k.order(stringLib$c.f1786b ? java.nio.ByteOrder.LITTLE_ENDIAN : java.nio.ByteOrder.BIG_ENDIAN).getLong(0);
        if (i3 >= 8 || !z) {
            return j2;
        }
        long j3 = 1 << ((i3 * 8) - 1);
        return (j2 ^ j3) - j3;
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaTable luaTable = new luaj.LuaTable();
        luaTable.i2("byte", new luaj.lib.StringLib$_byte());
        luaTable.i2("char", new luaj.lib.StringLib$_char());
        luaTable.i2("dump", new luaj.lib.StringLib$dump());
        luaTable.i2("find", new luaj.lib.StringLib$find());
        luaTable.i2("format", new luaj.lib.StringLib$format());
        luaTable.i2("gmatch", new luaj.lib.StringLib$gmatch());
        luaTable.i2("gsub", new luaj.lib.StringLib$gsub());
        luaTable.i2("len", new luaj.lib.StringLib$len());
        luaTable.i2("lower", new luaj.lib.StringLib$lower());
        luaTable.i2("match", new luaj.lib.StringLib$match());
        luaTable.i2("pack", new luaj.lib.StringLib$pack());
        luaTable.i2("packsize", new luaj.lib.StringLib$packsize());
        luaTable.i2("rep", new luaj.lib.StringLib$rep());
        luaTable.i2("reverse", new luaj.lib.StringLib$reverse());
        luaTable.i2("sub", new luaj.lib.StringLib$sub());
        luaTable.i2("unpack", new luaj.lib.StringLib$unpack());
        luaTable.i2("upper", new luaj.lib.StringLib$upper());
        luaValue2.i2("string", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("string", luaTable);
        }
        if (luaj.LuaString.U == null) {
            luaj.LuaString.U = luaj.LuaValue.u2(new luaj.LuaValue[]{luaj.LuaValue.l, luaTable});
        }
        return luaTable;
    }
}

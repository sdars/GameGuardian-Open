package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class Utf8Lib extends luaj.lib.TwoArgFunction {
    static void X2(java.lang.String str, int i, int i2, int i3) {
        luaj.LuaValue.l0(i, str, "'" + i2 + "': final position out of string length [" + i3 + "]");
    }

    static int Y2(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = bArr[i] & 255;
        int i5 = 127;
        if (i4 <= 127) {
            i5 = -1;
            i3 = 1;
        } else {
            if (i4 < 192) {
                return i | 1342177280;
            }
            if (i4 < 224) {
                i4 ^= 192;
                i3 = 2;
            } else if (i4 < 240) {
                i4 ^= 224;
                i3 = 3;
                i5 = 2047;
            } else {
                if (i4 >= 248) {
                    return i | 1342177280;
                }
                i4 ^= 240;
                i3 = 4;
                i5 = 65535;
            }
        }
        for (int i6 = 1; i6 < i3; i6++) {
            if (i6 >= i2) {
                return i | 1342177280;
            }
            int i7 = bArr[i + i6];
            if ((i7 & 192) != 128) {
                return i | 1342177280;
            }
            i4 = (i4 << 6) | (i7 & 63);
        }
        return (i4 > 1114111 || i4 <= i5) ? i | 1342177280 : (i3 << 28) | i4;
    }

    static luaj.d Z2(int i) {
        return new luaj.d("invalid UTF-8 code at " + (i + 1) + " byte");
    }

    static void a3(java.lang.String str, int i, int i2, int i3) {
        luaj.LuaValue.l0(i, str, "'" + i2 + "': position out of range [1; " + i3 + "]");
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaTable luaTable = new luaj.LuaTable();
        luaTable.i2("char", new luaj.lib.Utf8Lib$_char());
        luaTable.i2("charpattern", luaj.LuaString.o3(new byte[]{91, 0, 45, 127, -62, 45, -12, 93, 91, -128, 45, -65, 93, 42}));
        luaTable.i2("codes", new luaj.lib.Utf8Lib$codes());
        luaTable.i2("codepoint", new luaj.lib.Utf8Lib$codepoint());
        luaTable.i2("len", new luaj.lib.Utf8Lib$len());
        luaTable.i2("offset", new luaj.lib.Utf8Lib$offset());
        luaValue2.i2("utf8", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("utf8", luaTable);
        }
        return luaj.LuaValue.f1673c;
    }
}

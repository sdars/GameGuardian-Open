package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class Utf8Lib$len extends luaj.lib.VarArgFunction {
    Utf8Lib$len() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        int i = luaStringH.R;
        int iC3 = luaj.lib.StringLib.c3(varargs.Y(2, 1), i);
        int iC4 = luaj.lib.StringLib.c3(varargs.Y(3, -1), i);
        if (iC3 < 1 || iC3 > i + 1) {
            luaj.lib.Utf8Lib.a3(T2(), 2, iC3, i);
        }
        if (iC4 > i) {
            luaj.lib.Utf8Lib.X2(T2(), 3, iC4, i);
        }
        if (iC3 > iC4) {
            return luaj.LuaValue.f1677g;
        }
        byte[] bArr = luaStringH.P;
        int i2 = luaStringH.Q;
        int i3 = luaStringH.R + i2;
        int i4 = iC3 - 1;
        int i5 = 0;
        while (i4 < iC4) {
            int iY2 = luaj.lib.Utf8Lib.Y2(bArr, i2 + i4, i3);
            int i6 = iY2 >> 28;
            if (i6 == 5) {
                return luaj.LuaValue.N2(luaj.LuaValue.f1673c, luaj.LuaValue.I2(((268435455 & iY2) - i2) + 1));
            }
            i4 += i6;
            i5++;
        }
        return luaj.LuaValue.I2(i5);
    }
}

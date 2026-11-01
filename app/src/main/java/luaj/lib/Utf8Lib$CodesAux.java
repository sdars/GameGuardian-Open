package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class Utf8Lib$CodesAux extends luaj.lib.VarArgFunction {
    private int T = 0;
    private final luaj.LuaString U;

    public Utf8Lib$CodesAux(luaj.LuaString luaString) {
        this.U = luaString;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        int i = this.T;
        luaj.LuaString luaString = this.U;
        int i2 = luaString.Q;
        int i3 = luaString.R + i2;
        if (i >= i3) {
            return luaj.LuaValue.f1673c;
        }
        int iY2 = luaj.lib.Utf8Lib.Y2(luaString.P, i2 + i, i3);
        int i4 = iY2 >> 28;
        int i5 = iY2 & 268435455;
        if (i4 == 5) {
            throw luaj.lib.Utf8Lib.Z2((i5 - this.U.Q) + 1);
        }
        this.T = i4 + i;
        return luaj.LuaValue.N2(luaj.LuaValue.I2(i + 1), luaj.LuaValue.I2(i5));
    }
}

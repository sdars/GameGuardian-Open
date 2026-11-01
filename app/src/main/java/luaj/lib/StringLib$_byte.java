package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$_byte extends luaj.lib.VarArgFunction {
    StringLib$_byte() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        int i = luaStringH.R;
        int iC3 = luaj.lib.StringLib.c3(varargs.Y(2, 1), i);
        int iC4 = luaj.lib.StringLib.c3(varargs.Y(3, iC3), i);
        if (iC3 <= 0) {
            iC3 = 1;
        }
        if (iC4 <= i) {
            i = iC4;
        }
        if (iC3 > i) {
            return luaj.LuaValue.f1676f;
        }
        int i2 = (i - iC3) + 1;
        if (iC3 + i2 <= i) {
            luaj.LuaValue.R0("string slice too long");
        }
        luaj.LuaValue[] luaValueArr = new luaj.LuaValue[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            luaValueArr[i3] = luaj.LuaValue.I2(luaStringH.g3((iC3 + i3) - 1));
        }
        return luaj.LuaValue.O2(luaValueArr);
    }
}

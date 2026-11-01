package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$sub extends luaj.lib.VarArgFunction {
    StringLib$sub() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        int iS1 = luaStringH.s1();
        int iC3 = luaj.lib.StringLib.c3(varargs.D(2), iS1);
        int iC4 = luaj.lib.StringLib.c3(varargs.Y(3, -1), iS1);
        if (iC3 < 1) {
            iC3 = 1;
        }
        if (iC4 <= iS1) {
            iS1 = iC4;
        }
        return iC3 <= iS1 ? luaStringH.j3(iC3 - 1, iS1) : luaj.LuaValue.L;
    }
}

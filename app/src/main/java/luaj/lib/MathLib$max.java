package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class MathLib$max extends luaj.lib.VarArgFunction {
    MathLib$max() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueK = varargs.K(1);
        int iU = varargs.U();
        for (int i = 2; i <= iU; i++) {
            luaj.LuaValue luaValueK2 = varargs.K(i);
            if (luaValueK.u1(luaValueK2)) {
                luaValueK = luaValueK2;
            }
        }
        return luaValueK;
    }
}

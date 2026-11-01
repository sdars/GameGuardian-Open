package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class MathLib$min extends luaj.lib.VarArgFunction {
    MathLib$min() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueK = varargs.K(1);
        int iU = varargs.U();
        for (int i = 2; i <= iU; i++) {
            luaj.LuaValue luaValueK2 = varargs.K(i);
            if (luaValueK2.u1(luaValueK)) {
                luaValueK = luaValueK2;
            }
        }
        return luaValueK;
    }
}

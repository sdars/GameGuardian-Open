package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$print extends luaj.lib.VarArgFunction {
    final luaj.lib.BaseLib T;
    final /* synthetic */ luaj.lib.BaseLib U;

    BaseLib$print(luaj.lib.BaseLib baseLib, luaj.lib.BaseLib baseLib2) {
        this.U = baseLib;
        this.T = baseLib2;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueT0 = this.U.T.T0("tostring");
        int iU = varargs.U();
        for (int i = 1; i <= iU; i++) {
            if (i > 1) {
                this.U.T.c0.print(" \t");
            }
            luaj.LuaValue luaValueCall = luaValueT0.call(varargs.v(i));
            if (!luaValueCall.n1()) {
                throw new luaj.d("'tostring' must return a string to 'print', got " + luaValueCall.D2());
            }
            this.U.T.c0.print(luaValueCall.q2().g0());
        }
        this.U.T.c0.println();
        return luaj.LuaValue.f1676f;
    }
}

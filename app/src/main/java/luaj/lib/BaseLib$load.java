package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$load extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.BaseLib T;

    BaseLib$load(luaj.lib.BaseLib baseLib) {
        this.T = baseLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueW = varargs.w();
        if (!luaValueW.n1() && !luaValueW.g1()) {
            luaj.LuaValue.l0(1, "load", "string or function expected, got " + luaValueW.D2());
        }
        java.lang.String strZ = varargs.Z(2, luaValueW.n1() ? luaValueW.g0() : "=(load)");
        java.lang.String strZ2 = varargs.Z(3, "bt");
        luaj.LuaValue luaValueD0 = varargs.d0(4, this.T.T);
        luaj.LuaString luaStringQ2 = luaValueW.n1() ? luaValueW.q2() : null;
        java.io.InputStream inputStreamK3 = luaStringQ2 != null ? luaStringQ2.k3() : new luaj.lib.BaseLib$d(luaValueW.y0());
        if (this.T.U != null) {
            inputStreamK3 = this.T.Y2(luaStringQ2, null, false, inputStreamK3);
        }
        return this.T.b3(inputStreamK3, strZ, strZ2, luaValueD0);
    }
}

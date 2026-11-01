package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$dofile extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.BaseLib T;

    BaseLib$dofile(luaj.lib.BaseLib baseLib) {
        this.T = baseLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueW = varargs.w();
        if (!luaValueW.n1() && !luaValueW.l1()) {
            luaj.LuaValue.l0(1, "dofile", "string expected, got " + luaValueW.D2());
        }
        java.lang.String strB0 = luaValueW.B0();
        luaj.lib.BaseLib baseLib = this.T;
        luaj.Varargs varargsA3 = baseLib.a3(strB0, "bt", baseLib.T);
        return varargsA3.Q(1) ? luaj.LuaValue.R0(varargsA3.h0(2)) : varargsA3.w().invoke();
    }
}

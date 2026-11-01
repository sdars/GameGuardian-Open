package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class PackageLib$lua_searcher extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.PackageLib T;

    public PackageLib$lua_searcher(luaj.lib.PackageLib packageLib) {
        this.T = packageLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        luaj.LuaValue luaValueU0 = this.T.U.U0(luaj.lib.PackageLib.d0);
        if (!luaValueU0.n1()) {
            return luaj.LuaValue.K2("\n\tpackage.path is not a string");
        }
        luaj.Varargs varargsInvoke = this.T.U.U0(luaj.lib.PackageLib.e0).invoke(luaj.LuaValue.N2(luaStringH, luaValueU0));
        if (!varargsInvoke.S(1)) {
            return varargsInvoke.v(2).B2();
        }
        luaj.LuaString luaStringQ2 = varargsInvoke.w().q2();
        java.lang.String strG0 = luaStringQ2.g0();
        this.T.T.g0.Y2(null, strG0, true, null);
        luaj.LuaValue luaValueQ3 = this.T.T.Q3(strG0);
        if (luaValueQ3.w().g1()) {
            return luaj.LuaValue.N2(luaValueQ3.w(), luaStringQ2);
        }
        return luaj.LuaValue.N2(luaj.LuaValue.f1673c, luaj.LuaValue.K2("'" + luaStringQ2 + "': " + luaValueQ3.v(2).g0()));
    }
}

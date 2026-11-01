package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$format extends luaj.lib.VarArgFunction {
    final luaj.LuaValue T;

    public Script$format(luaj.LuaValue luaValue) {
        this.T = luaValue;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return this.T.invoke(luaj.LuaValue.N2(luaj.LuaValue.K2(android.ext.b2.g(varargs.E(1)).replace("%,d", "%d")), varargs.e0(2)));
    }
}

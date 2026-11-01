package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$xpcall extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.BaseLib T;

    BaseLib$xpcall(luaj.lib.BaseLib baseLib) {
        this.T = baseLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaThread luaThread = this.T.T.f0;
        luaj.LuaValue luaValue = luaThread.S;
        luaThread.S = varargs.K(2);
        try {
            luaj.Varargs varargsD3 = luaj.LuaClosure.d3(this.T.T, this, varargs.K(1), varargs.e0(3));
            luaThread.S = luaValue;
            return varargsD3;
        } catch (java.lang.Throwable th_c_c_c) {
            luaThread.S = luaValue;
            throw th_c_c_c;
        }
    }
}

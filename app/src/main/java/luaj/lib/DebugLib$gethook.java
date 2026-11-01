package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$gethook extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.DebugLib T;

    DebugLib$gethook(luaj.lib.DebugLib debugLib) {
        this.T = debugLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaThread$a luaThread$a = (varargs.U() > 0 ? varargs.J(1) : this.T.T.f0).P;
        luaj.LuaValue luaValue = luaThread$a.f1670f;
        if (luaValue == null) {
            luaValue = luaj.LuaValue.f1673c;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(luaThread$a.h ? "c" : "");
        sb.append(luaThread$a.i ? "r" : "");
        sb.append(luaThread$a.f1671g ? "l" : "");
        return luaj.LuaValue.M2(luaValue, luaj.LuaValue.K2(sb.toString()), luaj.LuaValue.I2(luaThread$a.j));
    }
}

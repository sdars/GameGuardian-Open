package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$setupvalue extends luaj.lib.VarArgFunction {
    DebugLib$setupvalue() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaClosure luaClosure;
        luaj.LuaString luaStringC3;
        luaj.LuaFunction luaFunctionC = varargs.C(1);
        int iD = varargs.D(2);
        luaj.LuaValue luaValueV = varargs.v(3);
        if (!(luaFunctionC instanceof luaj.LuaClosure) || (luaStringC3 = luaj.lib.DebugLib.c3((luaClosure = (luaj.LuaClosure) luaFunctionC), iD)) == null) {
            return luaj.LuaValue.f1673c;
        }
        luaClosure.S[iD - 1].c(luaValueV);
        return luaStringC3;
    }
}

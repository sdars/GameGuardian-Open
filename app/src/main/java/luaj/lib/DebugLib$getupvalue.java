package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$getupvalue extends luaj.lib.VarArgFunction {
    DebugLib$getupvalue() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaClosure luaClosure;
        luaj.LuaString luaStringC3;
        luaj.LuaFunction luaFunctionC = varargs.C(1);
        int iD = varargs.D(2);
        return (!(luaFunctionC instanceof luaj.LuaClosure) || (luaStringC3 = luaj.lib.DebugLib.c3((luaClosure = (luaj.LuaClosure) luaFunctionC), iD)) == null) ? luaj.LuaValue.f1673c : luaj.LuaValue.N2(luaStringC3, luaClosure.S[iD - 1].b());
    }
}

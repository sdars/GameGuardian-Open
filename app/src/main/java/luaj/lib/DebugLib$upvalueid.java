package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$upvalueid extends luaj.lib.VarArgFunction {
    DebugLib$upvalueid() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.i[] iVarArr;
        luaj.LuaFunction luaFunctionC = varargs.C(1);
        int iD = varargs.D(2);
        if ((luaFunctionC instanceof luaj.LuaClosure) && (iVarArr = ((luaj.LuaClosure) luaFunctionC).S) != null && iD > 0 && iD <= iVarArr.length) {
            return luaj.LuaValue.I2(iVarArr[iD - 1].hashCode());
        }
        return luaj.LuaValue.l0(2, "debug.upvalueid", "invalid upvalue index " + iD);
    }
}

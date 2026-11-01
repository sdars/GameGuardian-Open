package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$upvaluejoin extends luaj.lib.VarArgFunction {
    DebugLib$upvaluejoin() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaClosure luaClosureA = varargs.A(1);
        int iD = varargs.D(2);
        luaj.LuaClosure luaClosureA2 = varargs.A(3);
        int iD2 = varargs.D(4);
        if (iD < 1 || iD > luaClosureA.S.length) {
            m0("index out of range");
        }
        if (iD2 < 1 || iD2 > luaClosureA2.S.length) {
            m0("index out of range");
        }
        luaClosureA.S[iD - 1] = luaClosureA2.S[iD2 - 1];
        return luaj.LuaValue.f1676f;
    }
}

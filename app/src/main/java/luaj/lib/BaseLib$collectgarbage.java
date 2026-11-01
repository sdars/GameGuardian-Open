package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$collectgarbage extends luaj.lib.VarArgFunction {
    BaseLib$collectgarbage() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.String strZ = varargs.Z(1, "collect");
        if ("collect".equals(strZ)) {
            java.lang.System.gc();
            return luaj.LuaValue.f1677g;
        }
        if ("count".equals(strZ)) {
            java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
            long jFreeMemory = runtime.totalMemory() - runtime.freeMemory();
            return luaj.LuaValue.N2(luaj.LuaValue.J2(jFreeMemory / 1024.0d), luaj.LuaValue.I2(jFreeMemory % 1024));
        }
        if ("step".equals(strZ)) {
            java.lang.System.gc();
            return luaj.LuaValue.f1674d;
        }
        luaj.LuaValue.l0(1, "collectgarbage", "invalid option '" + strZ + "'");
        return luaj.LuaValue.f1673c;
    }
}

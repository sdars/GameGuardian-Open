package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$wrap extends luaj.lib.VarArgFunction {
    final luaj.LuaValue T;
    final java.lang.String U;
    final int V;
    final /* synthetic */ android.ext.Script W;

    Script$wrap(android.ext.Script script, java.lang.String str, luaj.LuaValue luaValue, int i) {
        this.W = script;
        this.T = luaValue;
        this.U = str;
        this.V = i;
    }

    @Override // luaj.lib.LibFunction, luaj.LuaFunction, luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return this.T.g0();
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        android.ext.Script$DebugLog script$DebugLog = android.ext.Script.w0;
        java.io.Writer writer = script$DebugLog == null ? null : script$DebugLog.f378a;
        if (writer != null) {
            long jNanoTime = java.lang.System.nanoTime();
            try {
                writer.write(this.U);
                writer.write("(");
                int iU = varargs.U();
                int i = this.V;
                if (i >= 0 && iU > i) {
                    iU = i;
                }
                for (int i2 = 1; i2 <= iU; i2++) {
                    if (i2 != 1) {
                        writer.write(", ");
                    }
                    android.ext.Script$ApiFunction.e3(null, writer, i2, varargs.v(i2));
                }
                writer.write(")\n");
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed write log for " + this.U, th);
            }
            luaj.Globals globals = script$DebugLog.f379b;
            globals.b0 = (int) (((long) globals.b0) + ((java.lang.System.nanoTime() - jNanoTime) / 1000000));
        }
        return this.T.invoke(varargs);
    }
}

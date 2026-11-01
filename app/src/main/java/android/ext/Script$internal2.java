package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$internal2 extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$internal2(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        luaj.LuaClosure luaClosureA = varargs.A(1);
        java.lang.String strE = varargs.E(2);
        luaj.Varargs varargsK2 = luaj.LuaValue.f1674d;
        java.io.PrintStream printStream = luaj.g.f1716b;
        try {
            luaj.g.f1716b = new java.io.PrintStream(new java.io.BufferedOutputStream(new java.io.FileOutputStream(strE), 65536));
            luaj.g.A(luaClosureA.R);
            luaj.g.f1716b.close();
            luaj.g.M(luaClosureA, strE + ".tail");
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed dump " + luaClosureA + " into '" + strE + '\'', th);
            varargsK2 = luaj.LuaValue.K2(android.ext.Script.V3(th));
        }
        luaj.g.f1716b = printStream;
        return varargsK2;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "do not use";
    }
}

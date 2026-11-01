package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getSelectedResults extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$getSelectedResults(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.c cVarF;
        gg_d.a aVar = android.ext.MainService.instance.s0;
        luaj.LuaTable luaTable = new luaj.LuaTable();
        int i = 1;
        for (int i2 = 0; i2 < aVar.i(); i2++) {
            try {
                if (aVar.c(i2) && (cVarF = aVar.f(i2, null)) != null) {
                    int i3 = i + 1;
                    try {
                        luaTable.Y1(i, android.ext.Script.n3(null, cVarF));
                    } catch (java.lang.IndexOutOfBoundsException unused) {
                    }
                    i = i3;
                }
            } catch (java.lang.IndexOutOfBoundsException unused2) {
            }
        }
        return luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getSelectedResults() -> table || string with error";
    }
}

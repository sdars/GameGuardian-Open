package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getSelectedListItems extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$getSelectedListItems(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.h2 h2Var;
        gg_d.e eVarF = android.ext.MainService.instance.t0.f();
        luaj.LuaTable luaTable = new luaj.LuaTable();
        int i = 1;
        for (int i2 = 0; i2 < eVarF.l(); i2++) {
            try {
                if (eVarF.a(i2) && (h2Var = (android.ext.h2) eVarF.n(i2)) != null) {
                    int i3 = i + 1;
                    try {
                        luaTable.Y1(i, android.ext.Script.o3(h2Var));
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
        return "gg.getSelectedListItems() -> table || string with error";
    }
}

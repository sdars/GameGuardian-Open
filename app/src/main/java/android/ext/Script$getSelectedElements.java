package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getSelectedElements extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$getSelectedElements(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.n1 n1Var = android.ext.MainService.instance.N;
        boolean[] zArrF = n1Var.f();
        luaj.LuaTable luaTable = new luaj.LuaTable();
        int i = 1;
        for (int i2 = 0; i2 < zArrF.length; i2++) {
            try {
                if (zArrF[i2]) {
                    int i3 = i + 1;
                    try {
                        luaTable.Y1(i, luaj.LuaLong.I2(n1Var.e(i2)));
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
        return "gg.getSelectedElements() -> table || string with error";
    }
}

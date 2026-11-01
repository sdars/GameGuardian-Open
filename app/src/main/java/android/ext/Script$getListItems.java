package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getListItems extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$getListItems(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        try {
            java.util.ArrayList<android.ext.h2> arrayList = new java.util.ArrayList(android.ext.MainService.instance.t0.getCount());
            java.lang.Object obj = new java.lang.Object();
            synchronized (obj) {
                try {
                    android.ext.n2.i(new android.ext.Script$getListItems$1(this, arrayList, obj));
                    android.ext.Script.W3(obj);
                } catch (java.lang.Throwable th_c_c_c) {
                    throw th_c_c_c;
                }
            }
            luaj.LuaTable luaTable = new luaj.LuaTable();
            luaTable.R1(arrayList.size());
            int i = 1;
            for (android.ext.h2 h2Var : arrayList) {
                if (h2Var != null) {
                    int i2 = i + 1;
                    luaTable.Y1(i, android.ext.Script.o3(h2Var));
                    i = i2;
                }
            }
            return luaTable;
        } catch (luaj.d e2_c_c_c) {
            throw e2_c_c_c;
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Failed get list items", th2);
            return luaj.LuaValue.K2(android.ext.Script.V3(th2));
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getListItems() -> table || string with error";
    }
}

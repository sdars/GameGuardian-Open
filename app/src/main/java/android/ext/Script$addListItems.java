package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$addListItems extends android.ext.Script$ApiFunction {
    final java.util.ArrayList e0 = new java.util.ArrayList();
    luaj.LuaValue f0 = null;
    final /* synthetic */ android.ext.Script g0;

    Script$addListItems(android.ext.Script script) {
        this.g0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
/* gg-shared-throwable */ java.lang.Throwable e = null;
        luaj.Varargs varargsK2;
        java.util.ArrayList arrayList = this.e0;
        try {
            try {
                arrayList.clear();
                luaj.LuaTable luaTableI = varargs.I(1);
                android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
                boolean z = z1_d != null ? z1_d.n : false;
                luaj.LuaTable$i luaTable$iS3 = luaTableI.s3();
                while (luaTable$iS3.c()) {
                    luaj.LuaValue luaValueD = luaTable$iS3.d();
                    try {
                        android.ext.h2 h2VarU3 = android.ext.Script.U3(luaValueD.H0(), z);
                        if (h2VarU3 != null) {
                            arrayList.add(h2VarU3);
                        }
                    } catch (java.lang.NumberFormatException e2) {
                        e = e2;
                        throw android.ext.Script.m3(luaTable$iS3.b(), luaValueD, e);
                    } catch (luaj.d e3) {
                        e = e3;
                        throw android.ext.Script.m3(luaTable$iS3.b(), luaValueD, e);
                    }
                }
                this.f0 = null;
                java.lang.Object obj = new java.lang.Object();
                synchronized (obj) {
                    try {
                        android.ext.n2.i(new android.ext.Script$addListItems$1(this, obj));
                        android.ext.Script.W3(obj);
                    } catch (java.lang.Throwable th_c_c_c) {
                        throw th_c_c_c;
                    }
                }
                varargsK2 = this.f0;
            } catch (java.lang.Throwable th2) {
                android.ext.e1.l("Failed add list items", th2);
                varargsK2 = luaj.LuaValue.K2(android.ext.Script.V3(th2));
            }
            try {
                arrayList.clear();
                arrayList.trimToSize();
            } catch (java.lang.Throwable th3) {
                android.ext.e1.a(th3);
            }
            this.f0 = null;
            return varargsK2;
        } catch (luaj.d e4_c_c_c) {
            throw e4_c_c_c;
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.addListItems(table items) -> true || string with error";
    }
}

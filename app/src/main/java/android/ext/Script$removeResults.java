package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$removeResults extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$removeResults(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        this.e0.y3();
        android.ext.MainService.instance.i.i0(this.e0.t3(), android.ext.Script.r3(varargs));
        java.lang.Object obj = new java.lang.Object();
        synchronized (obj) {
            try {
                android.ext.n2.i(new android.ext.Script$removeResults$1(this, obj));
                android.ext.Script.W3(obj);
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        return luaj.LuaValue.f1674d;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.removeResults(table results) -> true || string with error";
    }
}

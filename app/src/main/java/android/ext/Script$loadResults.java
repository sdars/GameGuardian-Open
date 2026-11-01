package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$loadResults extends android.ext.Script$BusyApiFunction {
    java.util.ArrayList f0;
    final /* synthetic */ android.ext.Script g0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$loadResults(android.ext.Script script) {
        super(script);
        this.g0 = script;
        this.f0 = null;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        this.g0.y3();
        java.util.ArrayList arrayListR3 = android.ext.Script.r3(varargs);
        android.ext.MainService.instance.n(this.g0.t3());
        if (arrayListR3.size() == 0) {
            return luaj.LuaValue.f1674d;
        }
        this.f0 = arrayListR3;
        return super.b3(varargs);
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        try {
            android.ext.MainService.instance.i.f0(this.g0.t3(), this.f0);
            this.f0 = null;
            return null;
        } catch (java.lang.Throwable th_c_c_c) {
            this.f0 = null;
            throw th_c_c_c;
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.loadResults(table results) -> true || string with error";
    }
}

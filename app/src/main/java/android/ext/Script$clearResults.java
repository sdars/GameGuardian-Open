package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$clearResults extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$clearResults(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.Script script = this.e0;
        script.d0 = android.ext.Script.J3(script.d0);
        android.ext.MainService.instance.n(this.e0.t3());
        return luaj.LuaValue.f1673c;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.clearResults() -> nil";
    }
}

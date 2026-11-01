package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$processToggle extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$processToggle(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        return luaj.LuaValue.H2(android.ext.MainService.instance.B0(this.e0.t3(), true));
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.processToggle() -> bool";
    }
}

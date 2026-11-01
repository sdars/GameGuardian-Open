package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$skipRestoreState extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$skipRestoreState(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        this.e0.m0 = null;
        return luaj.LuaValue.f1673c;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.skipRestoreState() -> nil";
    }
}

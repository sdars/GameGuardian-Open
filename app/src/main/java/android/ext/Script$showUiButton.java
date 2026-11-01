package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$showUiButton extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$showUiButton(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.MainService.instance.R0(true);
        return luaj.LuaValue.f1673c;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.showUiButton() -> nil";
    }
}

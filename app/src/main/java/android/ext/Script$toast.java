package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$toast extends android.ext.Script$ApiFunction {
    Script$toast() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        android.ext.n2.i(new android.ext.Script$toast$1(this, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script) + ": " + varargs.E(1), varargs.V(2, false)));
        return luaj.LuaValue.f1673c;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.toast(string text [, bool fast = false]) -> nil";
    }
}

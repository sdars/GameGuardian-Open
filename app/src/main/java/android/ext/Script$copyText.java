package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$copyText extends android.ext.Script$ApiFunction {
    Script$copyText() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        java.lang.String strE = varargs.E(1);
        if (varargs.V(2, true)) {
            strE = android.ext.Script.D3(strE);
        }
        android.ext.Tools.z(android.ext.b2.g(strE));
        return luaj.LuaValue.f1673c;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.copyText(string text [, bool fixLocale = true]) -> nil";
    }
}

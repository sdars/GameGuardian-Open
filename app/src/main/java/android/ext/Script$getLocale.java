package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getLocale extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$getLocale(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        return luaj.LuaValue.K2(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.lang_code).replace("~", ""));
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getLocale() -> string";
    }
}

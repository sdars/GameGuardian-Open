package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$numberFromLocale extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$numberFromLocale(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        return luaj.LuaValue.K2(android.ext.Script.E3(varargs.h0(1)));
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.numberFromLocale(string num) -> string";
    }
}

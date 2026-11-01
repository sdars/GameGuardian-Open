package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$saveVariable extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$saveVariable(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        return new luaj.lib.GgLib$saveVariable(this.e0.T).invoke(varargs);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.saveVariable(mixed variable, string filename) -> true || string with error";
    }
}

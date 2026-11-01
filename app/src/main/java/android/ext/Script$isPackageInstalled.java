package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$isPackageInstalled extends android.ext.Script$ApiFunction {
    Script$isPackageInstalled() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        return luaj.LuaValue.H2(android.ext.Tools.e1(varargs.E(1)));
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.isPackageInstalled(string pkg) -> bool";
    }
}

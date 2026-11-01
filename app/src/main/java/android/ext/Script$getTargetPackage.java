package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getTargetPackage extends android.ext.Script$ApiFunction {
    Script$getTargetPackage() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        java.lang.String str = z1_d != null ? z1_d.f1434c : null;
        return str == null ? luaj.LuaValue.f1673c : luaj.LuaValue.K2(str);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getTargetPackage() -> string || nil";
    }
}

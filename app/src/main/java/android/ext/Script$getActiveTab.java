package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getActiveTab extends android.ext.Script$ApiFunction {
    Script$getActiveTab() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        return luaj.LuaValue.I2(android.ext.MainService.instance.H());
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getActiveTab() -> int";
    }
}

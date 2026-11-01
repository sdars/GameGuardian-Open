package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getRanges extends android.ext.Script$ApiFunction {
    Script$getRanges() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        return luaj.LuaValue.I2(android.ext.Config.i);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getRanges() -> int";
    }
}

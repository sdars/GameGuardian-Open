package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getLine extends android.ext.Script$DebugFunction {
    final /* synthetic */ android.ext.Script f0;

    Script$getLine(android.ext.Script script) {
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        luaj.h hVar;
        luaj.LuaClosure luaClosure = this.e0;
        int i = -1;
        if (luaClosure != null && (hVar = luaClosure.R) != null && hVar.f1726d != null && luaClosure.W >= 0) {
            int i2 = this.e0.W;
            luaj.LuaClosure luaClosure2 = this.e0;
            int[] iArr = luaClosure2.R.f1726d;
            if (i2 < iArr.length) {
                i = iArr[luaClosure2.W];
            }
        }
        return luaj.LuaValue.I2(i);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getLine() -> int";
    }
}

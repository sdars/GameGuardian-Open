package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$processKill extends android.ext.Script$ApiFunction {
    private int e0 = 0;
    private long f0 = 0;
    final /* synthetic */ android.ext.Script g0;

    Script$processKill(android.ext.Script script) {
        this.g0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        long jNanoTime = java.lang.System.nanoTime() / 60000000000L;
        if (jNanoTime != this.f0) {
            this.f0 = jNanoTime;
            this.e0 = 0;
        }
        int i = this.e0 + 1;
        this.e0 = i;
        if (i > 4) {
            this.g0.x3(3);
        }
        return luaj.LuaValue.H2(android.ext.MainService.instance.w0(this.g0.t3()));
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.processKill() -> bool";
    }
}

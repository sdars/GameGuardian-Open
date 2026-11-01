package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$setSpeed extends android.ext.Script$BusyApiFunction {
    final /* synthetic */ android.ext.Script f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$setSpeed(android.ext.Script script) {
        super(script);
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        double dB = varargs.B(1);
        if (dB >= 1.0E-9d && dB <= 1.0E9d) {
            android.ext.MainService.instance.S0(this.f0.t3(), dB);
            return null;
        }
        return luaj.LuaValue.K2("Speed outside range: " + dB + " (1.0E-9; 1.0E9)");
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.setSpeed(double speed) -> true || string with error";
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$timeJump extends android.ext.Script$BusyApiFunction {
    final /* synthetic */ android.ext.Script f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$timeJump(android.ext.Script script) {
        super(script);
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        try {
            android.ext.MainService.instance.i.d(this.f0.t3(), android.ext.o2.i(android.ext.Script.D3(varargs.E(1))));
            return null;
        } catch (java.lang.NumberFormatException e2) {
            return luaj.LuaValue.K2(android.ext.Script.V3(e2));
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.timeJump(string time) -> true || string with error";
    }
}

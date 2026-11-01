package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$clearList extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$clearList(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        try {
            android.ext.MainService.instance.t0.c();
            return luaj.LuaValue.f1674d;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed clear list", th);
            return luaj.LuaValue.K2(android.ext.Script.V3(th));
        }
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.clearList() -> true || string with error";
    }
}

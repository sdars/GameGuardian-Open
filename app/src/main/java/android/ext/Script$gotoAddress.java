package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$gotoAddress extends android.ext.Script$ApiFunction {
    Script$gotoAddress() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.MainService.instance.J(varargs.F(1));
        return luaj.LuaValue.f1673c;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.gotoAddress(long address) -> nil";
    }
}

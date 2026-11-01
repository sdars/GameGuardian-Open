package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$allocatePage extends android.ext.Script$BusyApiFunction {
    final /* synthetic */ android.ext.Script f0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Script$allocatePage(android.ext.Script script) {
        super(script);
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    protected luaj.Varargs a3() {
        long j = android.ext.Script.s0;
        if (-1024 >= j || j > 0) {
            return luaj.LuaValue.I2(android.ext.Script.s0);
        }
        return luaj.LuaValue.K2(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.allocate_fail) + ' ' + (-j));
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        int iY = varargs.Y(1, 6);
        long jA0 = varargs.a0(2, 0L);
        android.ext.Script.s0 = 0L;
        android.ext.MainService.instance.i.f(this.f0.t3(), jA0, iY);
        return null;
    }

    @Override // android.ext.Script$ApiFunction
    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        if (i != 1) {
            if (i == 2 && luaValue.j1()) {
                return android.ext.Script$ApiFunction.h3(writer, luaValue);
            }
        } else if (luaValue.h1()) {
            return android.ext.Script$ApiFunction.g3(writer, this.f0.g0.f377g, luaValue);
        }
        return super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.allocatePage([int mode = gg.PROT_READ | gg.PROT_EXEC [, long address = 0]) -> long || string with error";
    }
}

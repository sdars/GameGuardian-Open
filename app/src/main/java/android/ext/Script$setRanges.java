package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$setRanges extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$setRanges(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 1;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_ranges).f42d = varargs.D(1);
        android.ext.Config.k();
        return luaj.LuaValue.f1673c;
    }

    @Override // android.ext.Script$ApiFunction
    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        return (i == 1 && luaValue.h1()) ? android.ext.Script$ApiFunction.g3(writer, this.e0.g0.f371a, luaValue) : super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.setRanges(int ranges) -> nil";
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$getFile extends android.ext.Script$DebugFunction {
    final /* synthetic */ android.ext.Script f0;

    Script$getFile(android.ext.Script script) {
        this.f0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        java.lang.String strG0;
        luaj.LuaClosure luaClosure = this.e0;
        if (luaClosure == null) {
            strG0 = "?";
        } else {
            java.lang.String str = luaClosure.U;
            if (str != null) {
                strG0 = str;
            } else {
                luaj.h hVar = luaClosure.R;
                if (hVar != null) {
                    luaj.LuaString luaString = hVar.f1729g;
                    strG0 = luaString != null ? luaString.g0() : "??";
                } else {
                    strG0 = "???";
                }
            }
        }
        if (strG0.startsWith("@")) {
            strG0 = strG0.substring(1);
        }
        return luaj.LuaValue.K2(strG0);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.getFile() -> string";
    }
}

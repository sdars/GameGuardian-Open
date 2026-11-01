package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$isClickedUiButton extends android.ext.Script$ApiFunction {
    Script$isClickedUiButton() {
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 0;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        android.ext.MainService mainService = android.ext.MainService.instance;
        luaj.LuaValue luaValue = luaj.LuaValue.f1673c;
        if (mainService.f214d == null) {
            return luaValue;
        }
        if (!mainService.f215e) {
            return luaj.LuaValue.f1675e;
        }
        mainService.f215e = false;
        return luaj.LuaValue.f1674d;
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.isClickedUiButton() -> bool || nil";
    }
}

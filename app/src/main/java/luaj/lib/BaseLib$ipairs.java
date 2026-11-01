package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$ipairs extends luaj.lib.VarArgFunction {
    luaj.lib.BaseLib$inext T = new luaj.lib.BaseLib$inext();

    BaseLib$ipairs() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return luaj.LuaValue.M2(this.T, varargs.I(1), luaj.LuaValue.f1677g);
    }
}

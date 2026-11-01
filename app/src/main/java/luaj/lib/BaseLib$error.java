package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$error extends luaj.lib.TwoArgFunction {
    BaseLib$error() {
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        if (luaValue.l1()) {
            throw new luaj.d(luaj.LuaValue.f1673c);
        }
        if (!luaValue.n1() || luaValue2.H1(1) == 0) {
            throw new luaj.d(luaValue);
        }
        throw new luaj.d(luaValue.g0(), luaValue2.H1(1));
    }
}

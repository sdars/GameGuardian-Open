package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$type extends luaj.lib.LibFunction {
    BaseLib$type() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.K2(luaValue.D2());
    }
}

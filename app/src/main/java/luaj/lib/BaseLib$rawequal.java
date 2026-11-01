package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$rawequal extends luaj.lib.LibFunction {
    BaseLib$rawequal() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call() {
        return luaj.LuaValue.k0(1, "value expected");
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.k0(2, "value expected");
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return luaj.LuaValue.H2(luaValue.T1(luaValue2));
    }
}

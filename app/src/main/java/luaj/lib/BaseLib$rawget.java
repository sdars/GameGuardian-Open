package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$rawget extends luaj.lib.TableLibFunction {
    BaseLib$rawget() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.k0(2, "value expected");
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return luaValue.H0().V1(luaValue2);
    }
}

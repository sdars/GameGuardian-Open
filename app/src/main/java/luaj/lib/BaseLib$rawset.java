package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$rawset extends luaj.lib.TableLibFunction {
    BaseLib$rawset() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.k0(2, "value expected");
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return luaj.LuaValue.k0(3, "value expected");
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        luaj.LuaTable luaTableH0 = luaValue.H0();
        if (!luaValue2.q1()) {
            luaj.LuaValue.k0(2, "table index is nil");
        }
        luaTableH0.d2(luaValue2, luaValue3);
        return luaTableH0;
    }
}

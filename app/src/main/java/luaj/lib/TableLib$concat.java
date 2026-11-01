package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class TableLib$concat extends luaj.lib.TableLibFunction {
    TableLib$concat() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaValue.H0().W2(luaj.LuaValue.L, 1, luaValue.s1());
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return luaValue.H0().W2(luaValue2.G0(), 1, luaValue.s1());
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        return luaValue.H0().W2(luaValue2.G0(), luaValue3.A0(), luaValue.s1());
    }

    @Override // luaj.lib.LibFunction
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3, luaj.LuaValue luaValue4) {
        return luaValue.H0().W2(luaValue2.G0(), luaValue3.A0(), luaValue4.A0());
    }
}

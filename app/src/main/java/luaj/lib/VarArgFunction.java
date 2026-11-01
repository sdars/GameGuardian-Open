package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public abstract class VarArgFunction extends luaj.lib.LibFunction {
    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call() {
        return invoke(luaj.LuaValue.f1676f).w();
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return invoke(luaValue).w();
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return invoke(luaj.LuaValue.N2(luaValue, luaValue2)).w();
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        return invoke(luaj.LuaValue.M2(luaValue, luaValue2, luaValue3)).w();
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public abstract luaj.Varargs invoke(luaj.Varargs varargs);
}

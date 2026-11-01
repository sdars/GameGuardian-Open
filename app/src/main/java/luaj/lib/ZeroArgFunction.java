package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public abstract class ZeroArgFunction extends luaj.lib.LibFunction {
    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public abstract luaj.LuaValue call();

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return call();
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return call();
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        return call();
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return call();
    }
}

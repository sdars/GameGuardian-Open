package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public abstract class OneArgFunction extends luaj.lib.LibFunction {
    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public final luaj.LuaValue call() {
        return call(luaj.LuaValue.f1673c);
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public abstract luaj.LuaValue call(luaj.LuaValue luaValue);

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public final luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return call(luaValue);
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        return call(luaValue);
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return call(varargs.w());
    }
}

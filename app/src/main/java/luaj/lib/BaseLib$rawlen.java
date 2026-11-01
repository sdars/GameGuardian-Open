package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$rawlen extends luaj.lib.LibFunction {
    BaseLib$rawlen() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.I2(luaValue.W1());
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$tostring extends luaj.lib.LibFunction {
    BaseLib$tostring() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.lib.BaseLib.d3(luaValue);
    }
}

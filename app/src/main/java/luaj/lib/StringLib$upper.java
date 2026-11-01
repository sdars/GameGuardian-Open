package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$upper extends luaj.lib.OneArgFunction {
    StringLib$upper() {
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.K2(luaValue.B0().toUpperCase(java.util.Locale.US));
    }
}

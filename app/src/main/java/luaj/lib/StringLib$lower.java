package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$lower extends luaj.lib.OneArgFunction {
    StringLib$lower() {
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaj.LuaValue.K2(luaValue.B0().toLowerCase(java.util.Locale.US));
    }
}

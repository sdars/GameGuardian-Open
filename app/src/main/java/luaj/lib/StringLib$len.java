package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$len extends luaj.lib.OneArgFunction {
    StringLib$len() {
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return luaValue.G0().r1();
    }
}

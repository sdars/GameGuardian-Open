package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$type extends luaj.lib.OneArgFunction {
    MathLib$type() {
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        java.lang.String str;
        if (luaValue instanceof luaj.LuaLong) {
            str = "integer";
        } else {
            if (!(luaValue instanceof luaj.LuaDouble)) {
                return luaj.LuaValue.f1673c;
            }
            str = "float";
        }
        return luaj.LuaValue.K2(str);
    }
}

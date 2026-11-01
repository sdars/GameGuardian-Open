package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class TableLib$pack extends luaj.lib.VarArgFunction {
    TableLib$pack() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaTable luaTableT2 = luaj.LuaValue.t2(varargs, 1);
        luaTableT2.g2("n", varargs.U());
        return luaTableT2;
    }
}

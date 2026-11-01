package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class TableLib$unpack extends luaj.lib.VarArgFunction {
    TableLib$unpack() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaTable luaTableI = varargs.I(1);
        return luaTableI.F3(varargs.a0(2, 1L), varargs.a0(3, varargs.v(3).l1() ? luaTableI.s1() : 0L));
    }
}

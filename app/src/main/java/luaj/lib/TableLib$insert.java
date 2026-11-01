package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class TableLib$insert extends luaj.lib.VarArgFunction {
    TableLib$insert() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        int iU = varargs.U();
        if (iU != 2 && iU != 3) {
            throw new luaj.d("wrong number of arguments to 'table.insert': " + varargs.U() + " (must be 2 or 3)");
        }
        luaj.LuaTable luaTableI = varargs.I(1);
        int iS1 = luaTableI.s1();
        if (iS1 >= 16777215) {
            throw new luaj.d("array too big: " + iS1 + " >= 16777215");
        }
        int i = iS1 + 1;
        int iD = iU == 2 ? i : varargs.D(2);
        if (iD < 1 || iD > i) {
            luaj.LuaValue.l0(2, "table.insert", "position out of bounds: " + iD + " not between 1 and " + i);
        }
        if (iD < 16777215) {
            luaTableI.q3(iD, varargs.v(iU == 2 ? 2 : 3));
            return luaj.LuaValue.f1676f;
        }
        throw new luaj.d("position too big: " + iD + " >= 16777215");
    }
}

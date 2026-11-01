package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class TableLib$sort extends luaj.lib.VarArgFunction {
    TableLib$sort() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        varargs.I(1).D3(varargs.Q(2) ? luaj.LuaValue.f1673c : varargs.C(2));
        return luaj.LuaValue.f1676f;
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$pairs extends luaj.lib.VarArgFunction {
    final luaj.lib.BaseLib$next T;

    BaseLib$pairs(luaj.lib.BaseLib$next baseLib$next) {
        this.T = baseLib$next;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return luaj.LuaValue.M2(this.T, varargs.I(1), luaj.LuaValue.f1673c);
    }
}

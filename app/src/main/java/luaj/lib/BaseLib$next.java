package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$next extends luaj.lib.VarArgFunction {
    BaseLib$next() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return varargs.I(1).v3(varargs.v(2));
    }
}

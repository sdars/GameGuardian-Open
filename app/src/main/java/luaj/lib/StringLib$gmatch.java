package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$gmatch extends luaj.lib.VarArgFunction {
    StringLib$gmatch() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return new luaj.lib.StringLib$GMatchAux(varargs, varargs.H(1), varargs.H(2));
    }
}

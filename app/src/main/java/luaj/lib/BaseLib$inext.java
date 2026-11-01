package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$inext extends luaj.lib.VarArgFunction {
    BaseLib$inext() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return varargs.I(1).p3(varargs.v(2));
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$_assert extends luaj.lib.VarArgFunction {
    BaseLib$_assert() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        if (varargs.U() == 0) {
            luaj.LuaValue.l0(1, "assert", "value expected");
        }
        if (varargs.f0(1)) {
            return varargs;
        }
        if (varargs.U() == 1) {
            throw new luaj.d("assertion failed!");
        }
        throw new luaj.d(varargs.v(2));
    }
}

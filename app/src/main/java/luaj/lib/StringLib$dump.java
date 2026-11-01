package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$dump extends luaj.lib.VarArgFunction {
    StringLib$dump() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaFunction luaFunctionC = varargs.C(1);
        if (!(luaFunctionC instanceof luaj.LuaClosure)) {
            throw new luaj.d("unable to dump given function");
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        try {
            if (android.ext.GgNoop.never) {
                throw new java.io.IOException();
            }
            gg_g.b.a(((luaj.LuaClosure) luaFunctionC).R, byteArrayOutputStream, varargs.V(2, false), varargs.V(3, false));
            return luaj.LuaString.o3(byteArrayOutputStream.toByteArray());
        } catch (java.io.IOException e2) {
            return luaj.LuaValue.R0(e2.getMessage());
        }
    }
}

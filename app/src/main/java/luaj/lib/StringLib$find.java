package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$find extends luaj.lib.VarArgFunction {
    StringLib$find() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return luaj.lib.StringLib.d3(varargs, true);
    }
}

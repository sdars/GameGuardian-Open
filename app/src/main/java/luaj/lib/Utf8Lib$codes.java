package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class Utf8Lib$codes extends luaj.lib.VarArgFunction {
    Utf8Lib$codes() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return new luaj.lib.Utf8Lib$CodesAux(varargs.H(1));
    }
}

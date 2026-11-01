package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$exit extends luaj.lib.VarArgFunction {
    Script$exit() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        throw new android.ext.Script$OsExit(varargs.Y(1, 0));
    }
}

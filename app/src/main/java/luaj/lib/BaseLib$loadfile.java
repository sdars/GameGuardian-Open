package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$loadfile extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.BaseLib T;

    BaseLib$loadfile(luaj.lib.BaseLib baseLib) {
        this.T = baseLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueW = varargs.w();
        if (!luaValueW.n1() && !luaValueW.l1()) {
            luaj.LuaValue.l0(1, "loadfile", "string expected, got " + luaValueW.D2());
        }
        return this.T.a3(luaValueW.B0(), varargs.Z(2, "bt"), varargs.d0(3, this.T.T));
    }
}

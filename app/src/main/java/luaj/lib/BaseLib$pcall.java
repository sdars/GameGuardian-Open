package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class BaseLib$pcall extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.BaseLib T;

    BaseLib$pcall(luaj.lib.BaseLib baseLib) {
        this.T = baseLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return luaj.LuaClosure.d3(this.T.T, this, varargs.K(1), varargs.e0(2));
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class PackageLib$preload_searcher extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.PackageLib T;

    public PackageLib$preload_searcher(luaj.lib.PackageLib packageLib) {
        this.T = packageLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaString luaStringH = varargs.H(1);
        luaj.LuaValue luaValueU0 = this.T.U.U0(luaj.lib.PackageLib.c0).U0(luaStringH);
        if (!luaValueU0.l1()) {
            return luaValueU0;
        }
        return luaj.LuaValue.K2("\n\tno field package.preload['" + luaStringH + "']");
    }
}

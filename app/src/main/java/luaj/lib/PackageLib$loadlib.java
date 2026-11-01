package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class PackageLib$loadlib extends luaj.lib.VarArgFunction {
    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        varargs.H(1);
        return luaj.LuaValue.M2(luaj.LuaValue.f1673c, luaj.LuaValue.K2("dynamic libraries not enabled"), luaj.LuaValue.K2("absent"));
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$getregistry extends luaj.lib.ZeroArgFunction {
    final /* synthetic */ luaj.lib.DebugLib T;

    DebugLib$getregistry(luaj.lib.DebugLib debugLib) {
        this.T = debugLib;
    }

    @Override // luaj.lib.ZeroArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call() {
        return this.T.T;
    }
}

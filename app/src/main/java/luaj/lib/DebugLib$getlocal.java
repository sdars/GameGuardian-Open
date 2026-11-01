package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$getlocal extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.DebugLib T;

    DebugLib$getlocal(luaj.lib.DebugLib debugLib) {
        this.T = debugLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaThread luaThreadJ;
        int i;
        if (varargs.T(1)) {
            luaThreadJ = varargs.J(1);
            i = 2;
        } else {
            luaThreadJ = this.T.T.f0;
            i = 1;
        }
        luaj.LuaValue luaValueV = varargs.v(i);
        int iD = varargs.D(i + 1);
        if (luaValueV.g1()) {
            return !luaValueV.f1() ? luaj.LuaValue.f1673c : luaValueV.w0().R.a(iD, 0);
        }
        int iD2 = varargs.D(i);
        luaj.lib.DebugLib$b debugLib$bZ2 = this.T.Z2(luaThreadJ);
        int i2 = debugLib$bZ2.f1757b;
        if (debugLib$bZ2.e(1).f1749a == this) {
            iD2++;
            i2--;
        }
        luaj.lib.DebugLib$a debugLib$aE = debugLib$bZ2.e(iD2);
        if (debugLib$aE != null) {
            return debugLib$aE.b(iD);
        }
        return luaj.LuaValue.l0(i, "debug.getlocal", "level out of range: " + iD2 + " not between 1 and " + i2);
    }
}

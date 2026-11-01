package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$traceback extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.DebugLib T;

    DebugLib$traceback(luaj.lib.DebugLib debugLib) {
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
        int i2 = i + 1;
        luaj.LuaValue luaValueV = varargs.v(i);
        if (!luaValueV.n1() && !luaValueV.l1()) {
            return luaValueV;
        }
        int iY = varargs.Y(i2, 1);
        luaj.lib.DebugLib$b debugLib$bZ2 = this.T.Z2(luaThreadJ);
        if (debugLib$bZ2.e(1).f1749a == this) {
            iY++;
        }
        java.lang.String strM = debugLib$bZ2.m(this.T.T, iY);
        if (luaValueV.n1()) {
            strM = luaValueV.g0() + '\n' + strM;
        }
        return luaj.LuaValue.K2(strM);
    }
}

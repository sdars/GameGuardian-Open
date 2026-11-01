package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class DebugLib$sethook extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.DebugLib T;

    DebugLib$sethook(luaj.lib.DebugLib debugLib) {
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
        luaj.LuaFunction luaFunctionX = varargs.X(i, null);
        java.lang.String strZ = varargs.Z(i + 1, "");
        int iY = varargs.Y(i + 2, 0);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = 0; i2 < strZ.length(); i2++) {
            char cCharAt = strZ.charAt(i2);
            if (cCharAt == 'c') {
                z = true;
            } else if (cCharAt == 'l') {
                z2 = true;
            } else if (cCharAt == 'r') {
                z3 = true;
            }
        }
        luaj.LuaThread$a luaThread$a = luaThreadJ.P;
        luaThread$a.f1670f = luaFunctionX;
        luaThread$a.h = z;
        luaThread$a.f1671g = z2;
        luaThread$a.j = iY;
        luaThread$a.i = z3;
        this.T.Y2().l(luaThread$a);
        return luaj.LuaValue.f1676f;
    }
}

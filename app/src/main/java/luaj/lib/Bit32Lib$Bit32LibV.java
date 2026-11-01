package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class Bit32Lib$Bit32LibV extends luaj.lib.VarArgFunction {
    Bit32Lib$Bit32LibV() {
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        switch (this.R) {
            case 0:
                return luaj.lib.Bit32Lib.Y2(varargs);
            case 1:
                return luaj.lib.Bit32Lib.a3(varargs);
            case 2:
                return luaj.lib.Bit32Lib.b3(varargs);
            case 3:
                return luaj.lib.Bit32Lib.c3(varargs);
            case 4:
                return luaj.lib.Bit32Lib.d3(varargs);
            case 5:
                return luaj.lib.Bit32Lib.e3((int) varargs.F(1), (int) varargs.F(2), (int) varargs.a0(3, 1L));
            case 6:
                return luaj.lib.Bit32Lib.h3((int) varargs.F(1), (int) varargs.F(2), (int) varargs.F(3), (int) varargs.a0(4, 1L));
            default:
                return luaj.LuaValue.f1673c;
        }
    }
}

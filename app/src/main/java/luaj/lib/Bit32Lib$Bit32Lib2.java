package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class Bit32Lib$Bit32Lib2 extends luaj.lib.TwoArgFunction {
    Bit32Lib$Bit32Lib2() {
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        int i = this.R;
        if (i == 0) {
            return luaj.lib.Bit32Lib.X2((int) luaValue.C0(), (int) luaValue2.C0());
        }
        if (i == 1) {
            return luaj.lib.Bit32Lib.f3((int) luaValue.C0(), (int) luaValue2.C0());
        }
        if (i == 2) {
            return luaj.lib.Bit32Lib.g3((int) luaValue.C0(), (int) luaValue2.C0());
        }
        if (i != 3) {
            return i != 4 ? luaj.LuaValue.f1673c : luaj.lib.Bit32Lib.j3((int) luaValue.C0(), (int) luaValue2.C0());
        }
        return luaj.lib.Bit32Lib.i3((int) luaValue.C0(), (int) luaValue2.C0());
    }
}

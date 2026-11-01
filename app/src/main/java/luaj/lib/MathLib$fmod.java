package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class MathLib$fmod extends luaj.lib.TwoArgFunction {
    MathLib$fmod() {
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return (luaValue.j1() && luaValue2.j1()) ? luaj.LuaValue.I2(luaValue.z2() % luaValue2.z2()) : luaj.LuaValue.J2(luaj.lib.MathLib.X2(this, 1, luaValue) % luaj.lib.MathLib.X2(this, 2, luaValue2));
    }
}

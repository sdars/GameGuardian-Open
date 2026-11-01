package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class MathLib$random extends luaj.lib.LibFunction {
    java.util.Random T = new java.util.Random();

    MathLib$random() {
    }

    private long X2() {
        long jNextLong = this.T.nextLong();
        return jNextLong < 0 ? jNextLong - Long.MIN_VALUE : jNextLong;
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call() {
        return luaj.LuaValue.J2(this.T.nextDouble());
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        long jC0 = luaValue.C0();
        if (jC0 < 1) {
            luaj.LuaValue.k0(1, "interval is empty");
        }
        return luaj.LuaValue.I2((X2() % jC0) + 1);
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        long jC0 = luaValue.C0();
        long jC1 = luaValue2.C0();
        if (jC1 < jC0) {
            luaj.LuaValue.k0(2, "interval is empty");
        }
        long j = jC1 - jC0;
        if (j < 0) {
            luaj.LuaValue.k0(2, "interval too large");
        }
        long jX2 = X2();
        if (j != Long.MAX_VALUE) {
            jX2 %= j + 1;
        }
        return luaj.LuaValue.I2(jC0 + jX2);
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        return luaj.LuaValue.k0(3, "too many arguments");
    }
}

package luaj;

/* JADX INFO: loaded from: classes.dex */
class LuaTable$k extends luaj.LuaTable$o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f1662c;

    LuaTable$k(luaj.LuaValue luaValue, long j) {
        super(luaValue);
        this.f1662c = j;
    }

    @Override // luaj.LuaTable$e
    public luaj.LuaTable$e j0(luaj.LuaValue luaValue) {
        if (luaValue instanceof luaj.LuaBoolean) {
            return new luaj.LuaTable$b(this.f1664b, luaValue.w2());
        }
        luaj.LuaValue luaValueA2 = luaValue.A2();
        if (luaValueA2.l1()) {
            return new luaj.LuaTable$l(this.f1664b, luaValue);
        }
        if (!(luaValueA2 instanceof luaj.LuaLong)) {
            double dX2 = luaValueA2.x2();
            float f2 = (float) dX2;
            return ((double) f2) == dX2 ? new luaj.LuaTable$f(this.f1664b, f2) : new luaj.LuaTable$d(this.f1664b, dX2);
        }
        long jZ2 = luaValueA2.z2();
        int i = (int) jZ2;
        if (i == jZ2) {
            return new luaj.LuaTable$h(this.f1664b, i);
        }
        this.f1662c = jZ2;
        return this;
    }

    long k0() {
        return this.f1662c;
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$n
    public luaj.LuaValue t() {
        return luaj.LuaValue.I2(this.f1662c);
    }
}

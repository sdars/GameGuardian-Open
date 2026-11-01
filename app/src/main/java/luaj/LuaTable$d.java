package luaj;

/* JADX INFO: loaded from: classes.dex */
class LuaTable$d extends luaj.LuaTable$o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f1651c;

    LuaTable$d(luaj.LuaValue luaValue, double d2) {
        super(luaValue);
        this.f1651c = d2;
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
        if (luaValueA2 instanceof luaj.LuaLong) {
            long jZ2 = luaValueA2.z2();
            int i = (int) jZ2;
            return ((long) i) == jZ2 ? new luaj.LuaTable$h(this.f1664b, i) : new luaj.LuaTable$k(this.f1664b, jZ2);
        }
        double dX2 = luaValueA2.x2();
        float f2 = (float) dX2;
        if (f2 == dX2) {
            return new luaj.LuaTable$f(this.f1664b, f2);
        }
        this.f1651c = dX2;
        return this;
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$n
    public luaj.LuaValue t() {
        return luaj.LuaValue.J2(this.f1651c);
    }
}

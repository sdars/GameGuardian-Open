package luaj;

/* JADX INFO: loaded from: classes.dex */
class LuaTable$l extends luaj.LuaTable$o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private luaj.LuaValue f1663c;

    LuaTable$l(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        super(luaValue);
        this.f1663c = luaValue2;
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$n
    public luaj.Varargs c() {
        return this;
    }

    @Override // luaj.LuaTable$e
    public luaj.LuaTable$e j0(luaj.LuaValue luaValue) {
        if (luaValue instanceof luaj.LuaBoolean) {
            return new luaj.LuaTable$b(this.f1664b, luaValue.w2());
        }
        if (luaValue instanceof luaj.LuaLong) {
            long jZ2 = luaValue.z2();
            int i = (int) jZ2;
            return ((long) i) == jZ2 ? new luaj.LuaTable$h(this.f1664b, i) : new luaj.LuaTable$k(this.f1664b, jZ2);
        }
        if (!(luaValue instanceof luaj.LuaDouble)) {
            this.f1663c = luaValue;
            return this;
        }
        double dX2 = luaValue.x2();
        float f2 = (float) dX2;
        return ((double) f2) == dX2 ? new luaj.LuaTable$f(this.f1664b, f2) : new luaj.LuaTable$d(this.f1664b, dX2);
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$n
    public luaj.LuaValue t() {
        return this.f1663c;
    }
}

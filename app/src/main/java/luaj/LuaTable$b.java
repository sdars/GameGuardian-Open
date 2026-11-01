package luaj;

/* JADX INFO: loaded from: classes.dex */
class LuaTable$b extends luaj.LuaTable$o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1648c;

    LuaTable$b(luaj.LuaValue luaValue, boolean z) {
        super(luaValue);
        this.f1648c = z;
    }

    @Override // luaj.LuaTable$e
    public luaj.LuaTable$e j0(luaj.LuaValue luaValue) {
        if (luaValue instanceof luaj.LuaBoolean) {
            this.f1648c = luaValue == luaj.LuaValue.f1674d;
            return this;
        }
        if (luaValue instanceof luaj.LuaLong) {
            long jZ2 = luaValue.z2();
            int i = (int) jZ2;
            return ((long) i) == jZ2 ? new luaj.LuaTable$h(this.f1664b, i) : new luaj.LuaTable$k(this.f1664b, jZ2);
        }
        if (!(luaValue instanceof luaj.LuaDouble)) {
            return new luaj.LuaTable$l(this.f1664b, luaValue);
        }
        double dX2 = luaValue.x2();
        float f2 = (float) dX2;
        return ((double) f2) == dX2 ? new luaj.LuaTable$f(this.f1664b, f2) : new luaj.LuaTable$d(this.f1664b, dX2);
    }

    @Override // luaj.LuaTable$e, luaj.LuaTable$n
    public luaj.LuaValue t() {
        return luaj.LuaValue.H2(this.f1648c);
    }
}

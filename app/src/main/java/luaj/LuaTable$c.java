package luaj;

/* JADX INFO: loaded from: classes.dex */
class LuaTable$c implements luaj.LuaTable$m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.Object f1649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private luaj.LuaTable$m f1650b;

    private LuaTable$c(luaj.LuaValue luaValue, luaj.LuaTable$m luaTable$m) {
        this.f1649a = luaj.LuaTable.r3(luaValue) ? new java.lang.ref.WeakReference(luaValue) : luaValue;
        this.f1650b = luaTable$m;
    }

    /* synthetic */ LuaTable$c(luaj.LuaValue luaValue, luaj.LuaTable$m luaTable$m, luaj.LuaTable$a luaTable$a) {
        this(luaValue, luaTable$m);
    }

    private luaj.LuaValue i() {
        java.lang.Object obj = this.f1649a;
        if (obj instanceof java.lang.ref.WeakReference) {
            obj = ((java.lang.ref.WeakReference) obj).get();
        }
        return (luaj.LuaValue) obj;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m a() {
        return this.f1650b;
    }

    @Override // luaj.LuaTable$m
    public int b(int i) {
        return 0;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m d(luaj.LuaTable$m luaTable$m) {
        luaj.LuaTable$m luaTable$m2 = this.f1650b;
        return luaTable$m2 != null ? luaTable$m2.d(luaTable$m) : luaTable$m;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n f(luaj.LuaValue luaValue) {
        return null;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m h(luaj.LuaTable$n luaTable$n) {
        if (i() == null) {
            return this.f1650b;
        }
        this.f1650b = this.f1650b.h(luaTable$n);
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m j(luaj.LuaTable$n luaTable$n, luaj.LuaValue luaValue) {
        luaj.LuaTable$m luaTable$m = this.f1650b;
        luaj.LuaTable$m luaTable$mJ = luaTable$m != null ? luaTable$m.j(luaTable$n, luaValue) : null;
        if (i() == null) {
            return luaTable$mJ;
        }
        this.f1650b = luaTable$mJ;
        return this;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$n l() {
        return null;
    }

    @Override // luaj.LuaTable$m
    public luaj.LuaTable$m n(luaj.LuaTable$m luaTable$m) {
        return luaTable$m;
    }

    @Override // luaj.LuaTable$m
    public int r(int i) {
        return -1;
    }

    @Override // luaj.LuaTable$m
    public boolean s(luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueI = i();
        return luaValueI != null && luaValue.T1(luaValueI);
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("<dead");
        luaj.LuaValue luaValueI = i();
        if (luaValueI != null) {
            sb.append(": ");
            sb.append(luaValueI.toString());
        }
        sb.append('>');
        if (this.f1650b != null) {
            sb.append("; ");
            sb.append(this.f1650b.toString());
        }
        return sb.toString();
    }
}

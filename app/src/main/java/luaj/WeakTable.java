package luaj;

/* JADX INFO: loaded from: classes.dex */
public class WeakTable implements luaj.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f1687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f1688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final luaj.LuaValue f1689c;

    public WeakTable(boolean z, boolean z2, luaj.LuaValue luaValue) {
        this.f1687a = z;
        this.f1688b = z2;
        this.f1689c = luaValue;
    }

    protected static luaj.LuaValue a(java.lang.Object obj) {
        if (obj instanceof java.lang.ref.WeakReference) {
            obj = ((java.lang.ref.WeakReference) obj).get();
        }
        return obj instanceof luaj.WeakTable$WeakValue ? ((luaj.WeakTable$WeakValue) obj).p2() : (luaj.LuaValue) obj;
    }

    protected static luaj.LuaValue b(luaj.LuaValue luaValue) {
        int iC2 = luaValue.C2();
        return (iC2 == 5 || iC2 == 6 || iC2 == 7 || iC2 == 8) ? new luaj.WeakTable$WeakValue(luaValue) : luaValue;
    }

    @Override // luaj.e
    public luaj.LuaValue e() {
        return this.f1689c;
    }

    @Override // luaj.e
    public luaj.LuaValue g(luaj.LuaValue luaValue) {
        return this.f1688b ? b(luaValue) : luaValue;
    }

    @Override // luaj.e
    public luaj.LuaTable$m k(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaValue luaValueP2 = luaValue2.p2();
        if (luaValueP2 == null) {
            return null;
        }
        if (!this.f1687a || luaValue.m1() || luaValue.n1() || luaValue.e1()) {
            return (!this.f1688b || luaValueP2.m1() || luaValueP2.n1() || luaValueP2.e1()) ? luaj.LuaTable.Z2(luaValue, luaValueP2) : new luaj.WeakTable$d(luaValue, luaValueP2, null);
        }
        return (!this.f1688b || luaValueP2.m1() || luaValueP2.n1() || luaValueP2.e1()) ? new luaj.WeakTable$b(luaValue, luaValueP2, null) : new luaj.WeakTable$a(luaValue, luaValueP2, null);
    }

    @Override // luaj.e
    public luaj.LuaValue o(luaj.LuaValue[] luaValueArr, int i) {
        luaj.LuaValue luaValueA = luaValueArr[i];
        if (luaValueA != null && (luaValueA = a(luaValueA)) == null) {
            luaValueArr[i] = null;
        }
        return luaValueA;
    }

    @Override // luaj.e
    public boolean p() {
        return this.f1688b;
    }

    @Override // luaj.e
    public boolean q() {
        return this.f1687a;
    }
}

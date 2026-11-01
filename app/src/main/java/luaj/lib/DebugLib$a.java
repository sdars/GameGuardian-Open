package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class DebugLib$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    luaj.LuaFunction f1749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private luaj.LuaValue[] f1751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    luaj.lib.DebugLib$a f1752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f1753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f1754f;

    public int a() {
        int[] iArr;
        int i;
        if (this.f1749a.f1() && (iArr = this.f1749a.w0().R.f1726d) != null && (i = this.f1750b) >= 0 && i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    luaj.Varargs b(int i) {
        luaj.LuaValue luaValue;
        if (i < 0) {
            if (!this.f1749a.f1()) {
                return luaj.LuaValue.f1673c;
            }
            int i2 = -i;
            luaj.Varargs varargsB3 = this.f1749a.w0().b3();
            return (varargsB3 == null || i2 > varargsB3.U()) ? luaj.LuaValue.f1673c : luaj.LuaValue.N2(luaj.lib.DebugLib.r0, varargsB3.v(i2));
        }
        luaj.LuaString luaStringC = c(i);
        luaj.LuaValue[] luaValueArr = this.f1751c;
        if (luaValueArr == null || i < 1 || i > luaValueArr.length || (luaValue = luaValueArr[i - 1]) == null) {
            return luaj.LuaValue.f1673c;
        }
        if (luaStringC == null) {
            luaStringC = luaj.lib.DebugLib.q0;
        }
        return luaj.LuaValue.N2(luaStringC, luaValue);
    }

    luaj.LuaString c(int i) {
        if (this.f1749a.f1()) {
            return this.f1749a.w0().R.a(i, this.f1750b);
        }
        return null;
    }

    void d(int i, luaj.Varargs varargs, int i2) {
        this.f1750b = i;
        if (luaj.lib.DebugLib.V) {
            luaj.g.I(this.f1749a.w0(), i, this.f1751c, i2, varargs);
        }
    }

    void e() {
        this.f1749a = null;
        this.f1751c = null;
        this.f1750b = 0;
        this.f1753e = false;
        this.f1754f = false;
    }

    void f(luaj.LuaClosure luaClosure, luaj.Varargs varargs, luaj.LuaValue[] luaValueArr, boolean z, boolean z2) {
        this.f1749a = luaClosure;
        this.f1751c = luaValueArr;
        this.f1750b = 0;
        this.f1753e = z;
        this.f1754f = z2;
    }

    void g(luaj.LuaFunction luaFunction, boolean z, boolean z2) {
        this.f1749a = luaFunction;
        this.f1751c = null;
        this.f1750b = 0;
        this.f1753e = z;
        this.f1754f = z2;
    }

    luaj.Varargs h(int i, luaj.LuaValue luaValue) {
        int i2 = 1;
        if (i >= 0) {
            luaj.LuaString luaStringC = c(i);
            luaj.LuaValue[] luaValueArr = this.f1751c;
            if (luaValueArr != null && i >= 1 && i <= luaValueArr.length) {
                int i3 = i - 1;
                if (luaValueArr[i3] != null) {
                    luaValueArr[i3] = luaValue;
                    return luaStringC == null ? luaj.lib.DebugLib.q0 : luaStringC;
                }
            }
            return luaj.LuaValue.f1673c;
        }
        if (!this.f1749a.f1()) {
            return luaj.LuaValue.f1673c;
        }
        luaj.LuaClosure luaClosureW0 = this.f1749a.w0();
        int i4 = -i;
        luaj.Varargs varargsB3 = luaClosureW0.b3();
        if (varargsB3 == null || i4 > varargsB3.U()) {
            return luaj.LuaValue.f1673c;
        }
        int iU = varargsB3.U();
        luaj.LuaValue[] luaValueArr2 = new luaj.LuaValue[iU];
        while (i2 <= iU) {
            luaValueArr2[i2 - 1] = i4 == i2 ? luaValue : varargsB3.v(i2);
            i2++;
        }
        luaClosureW0.f3(luaj.LuaValue.O2(luaValueArr2));
        return luaj.lib.DebugLib.r0;
    }

    public java.lang.String i() {
        return this.f1749a.f1() ? this.f1749a.w0().R.b() : "[Java]";
    }

    public java.lang.String toString() {
        return "CallFrame [f=" + this.f1749a + ", pc=" + this.f1750b + ", hookcall=" + this.f1753e + "]";
    }
}

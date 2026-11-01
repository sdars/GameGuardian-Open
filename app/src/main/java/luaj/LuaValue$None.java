package luaj;

/* JADX INFO: loaded from: classes.dex */
final class LuaValue$None extends luaj.LuaNil {
    private LuaValue$None() {
    }

    /* synthetic */ LuaValue$None(luaj.LuaValue$a luaValue$a) {
        this();
    }

    @Override // luaj.Varargs
    void L(luaj.LuaValue[] luaValueArr, int i, int i2) {
        while (i2 > 0) {
            luaValueArr[i] = luaj.LuaValue.f1673c;
            i2--;
            i++;
        }
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public int U() {
        return 0;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public luaj.Varargs e0(int i) {
        return i > 0 ? this : luaj.LuaValue.k0(1, "start must be > 0");
    }

    @Override // luaj.LuaNil, luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return "none";
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public luaj.LuaValue v(int i) {
        return luaj.LuaValue.f1673c;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public luaj.LuaValue w() {
        return luaj.LuaValue.f1673c;
    }
}

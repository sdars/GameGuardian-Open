package luaj;

/* JADX INFO: loaded from: classes.dex */
public final class LuaBoolean extends luaj.LuaValue {
    public static luaj.LuaValue Q;
    public final boolean P;

    LuaBoolean(boolean z) {
        this.P = z;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue B1() {
        return this.P ? luaj.LuaValue.f1675e : luaj.LuaValue.f1674d;
    }

    @Override // luaj.LuaValue
    public int C2() {
        return 1;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        return "boolean";
    }

    @Override // luaj.LuaValue
    public boolean E1(boolean z) {
        return this.P;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue V0() {
        return Q;
    }

    @Override // luaj.LuaValue
    public boolean e1() {
        return true;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return this.P ? "true" : "false";
    }

    @Override // luaj.LuaValue
    public boolean v0() {
        return this.P;
    }

    @Override // luaj.LuaValue
    public boolean w2() {
        return this.P;
    }
}

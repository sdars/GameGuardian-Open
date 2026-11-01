package luaj;

/* JADX INFO: loaded from: classes.dex */
public class LuaNil extends luaj.LuaValue {
    public static luaj.LuaValue P;

    LuaNil() {
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue B1() {
        return luaj.LuaValue.f1674d;
    }

    @Override // luaj.LuaValue
    public int C2() {
        return 0;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        return "nil";
    }

    @Override // luaj.LuaValue
    public boolean E1(boolean z) {
        return z;
    }

    @Override // luaj.LuaValue
    public double F1(double d2) {
        return d2;
    }

    @Override // luaj.LuaValue
    public luaj.LuaFunction G1(luaj.LuaFunction luaFunction) {
        return luaFunction;
    }

    @Override // luaj.LuaValue
    public int H1(int i) {
        return i;
    }

    @Override // luaj.LuaValue
    public java.lang.String I1(java.lang.String str) {
        return str;
    }

    @Override // luaj.LuaValue
    public long J1(long j) {
        return j;
    }

    @Override // luaj.LuaValue
    public luaj.LuaString K1(luaj.LuaString luaString) {
        return luaString;
    }

    @Override // luaj.LuaValue
    public luaj.LuaTable L1(luaj.LuaTable luaTable) {
        return luaTable;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue M1(luaj.LuaValue luaValue) {
        return luaValue;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue V0() {
        return P;
    }

    @Override // luaj.LuaValue
    public boolean equals(java.lang.Object obj) {
        return obj instanceof luaj.LuaNil;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return "nil";
    }

    @Override // luaj.LuaValue
    public boolean l1() {
        return true;
    }

    @Override // luaj.LuaValue
    public boolean q1() {
        return false;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String toString() {
        return "nil";
    }

    @Override // luaj.LuaValue
    public boolean w2() {
        return false;
    }
}

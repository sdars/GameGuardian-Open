package luaj;

/* JADX INFO: loaded from: classes.dex */
public abstract class LuaNumber extends luaj.LuaValue {
    public static luaj.LuaValue P;

    @Override // luaj.LuaValue
    public luaj.LuaValue A2() {
        return this;
    }

    @Override // luaj.LuaValue
    public int C2() {
        return 3;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        return "number";
    }

    @Override // luaj.LuaValue
    public luaj.LuaNumber E0() {
        return this;
    }

    @Override // luaj.LuaValue
    public luaj.LuaNumber F0(java.lang.String str) {
        return this;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue K0(luaj.LuaValue luaValue) {
        return luaValue.L0(this);
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue L0(luaj.LuaNumber luaNumber) {
        return q2().M0(luaNumber.q2());
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue M0(luaj.LuaString luaString) {
        return q2().M0(luaString);
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue V0() {
        return P;
    }

    @Override // luaj.LuaValue
    public boolean m1() {
        return true;
    }

    @Override // luaj.LuaValue
    public boolean n1() {
        return true;
    }

    @Override // luaj.LuaValue
    public int o2(luaj.LuaString luaString) {
        java.lang.String string = luaString.toString();
        if (string.length() > 50) {
            string = string.substring(0, 50) + "...";
        }
        throw new luaj.d("attempt to compare number with string (" + this + " with '" + string + "')");
    }
}

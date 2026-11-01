package luaj;

/* JADX INFO: loaded from: classes.dex */
class WeakTable$WeakValue extends luaj.LuaValue {
    java.lang.ref.WeakReference P;

    protected WeakTable$WeakValue(luaj.LuaValue luaValue) {
        this.P = new java.lang.ref.WeakReference(luaValue);
    }

    @Override // luaj.LuaValue
    public int C2() {
        a1("type", "weak value");
        return 0;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        a1("typename", "weak value");
        return null;
    }

    @Override // luaj.LuaValue
    public boolean T1(luaj.LuaValue luaValue) {
        java.lang.Object obj = this.P.get();
        return obj != null && luaValue.T1((luaj.LuaValue) obj);
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue p2() {
        return (luaj.LuaValue) this.P.get();
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String toString() {
        return "weak<" + this.P.get() + '>';
    }
}

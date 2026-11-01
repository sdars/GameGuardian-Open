package luaj;

/* JADX INFO: loaded from: classes.dex */
public class LuaThread extends luaj.LuaValue {
    public static luaj.LuaValue T;
    public static final java.lang.String[] U = {"suspended", "suspended", "running", "normal", "dead"};
    public final luaj.LuaThread$a P;
    public java.lang.Object Q;
    public final luaj.Globals R;
    public luaj.LuaValue S;

    public LuaThread(luaj.Globals globals) {
        luaj.LuaThread$a luaThread$a = new luaj.LuaThread$a(globals, this, null);
        this.P = luaThread$a;
        luaThread$a.o = 2;
        this.R = globals;
    }

    @Override // luaj.LuaValue
    public int C2() {
        return 8;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        return "thread";
    }

    @Override // luaj.LuaValue
    public luaj.LuaThread I0() {
        return this;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue V0() {
        return T;
    }

    @Override // luaj.LuaValue
    public boolean p1() {
        return true;
    }
}

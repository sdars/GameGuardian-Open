package luaj;

/* JADX INFO: loaded from: classes.dex */
final class Varargs$c extends luaj.Varargs {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final luaj.LuaValue f1685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final luaj.Varargs f1686c;

    Varargs$c(luaj.LuaValue luaValue, luaj.Varargs varargs) {
        this.f1685b = luaValue;
        this.f1686c = varargs;
    }

    @Override // luaj.Varargs
    public int U() {
        return this.f1686c.U() + 1;
    }

    @Override // luaj.Varargs
    public luaj.Varargs e0(int i) {
        if (i == 1) {
            return this;
        }
        if (i == 2) {
            return this.f1686c;
        }
        return i > 2 ? this.f1686c.e0(i - 1) : luaj.LuaValue.k0(1, "start must be > 0");
    }

    @Override // luaj.Varargs
    public luaj.LuaValue v(int i) {
        return i == 1 ? this.f1685b : this.f1686c.v(i - 1);
    }

    @Override // luaj.Varargs
    public luaj.LuaValue w() {
        return this.f1685b;
    }
}

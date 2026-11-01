package lasm;

/* JADX INFO: loaded from: classes.dex */
class LasmBase$Internal extends luaj.LuaValue {
    int P;
    gg_e.f Q;

    LasmBase$Internal(gg_e.f fVar, int i) {
        this.Q = fVar;
        this.P = i;
    }

    @Override // luaj.LuaValue
    public int C2() {
        return this.P;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        return null;
    }
}

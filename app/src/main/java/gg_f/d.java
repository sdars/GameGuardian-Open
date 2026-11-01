package gg_f;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public luaj.LuaString f1565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f1567c;

    public d(luaj.LuaString luaString, boolean z, int i) {
        this.f1565a = luaString;
        this.f1566b = z;
        this.f1567c = (short) i;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(java.lang.String.valueOf(this.f1566b ? 'v' : 'u'));
        sb.append((int) this.f1567c);
        sb.append(" \"");
        sb.append(java.lang.String.valueOf(this.f1565a));
        sb.append("\"");
        return sb.toString();
    }
}

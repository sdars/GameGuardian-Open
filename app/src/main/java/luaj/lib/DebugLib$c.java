package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class DebugLib$c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.lang.String f1758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    java.lang.String f1759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.lang.String f1760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    java.lang.String f1761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1764g;
    short h;
    short i;
    boolean j;
    boolean k;
    java.lang.String l;
    luaj.lib.DebugLib$a m;

    DebugLib$c() {
    }

    public void a(luaj.LuaFunction luaFunction) {
        java.lang.String strB;
        if (luaFunction.f1()) {
            luaj.h hVar = luaFunction.w0().R;
            luaj.LuaString luaString = hVar.f1729g;
            this.f1761d = luaString != null ? luaString.g0() : "=?";
            int i = hVar.h;
            this.f1763f = i;
            this.f1764g = hVar.i;
            this.f1760c = i == 0 ? "main" : "Lua";
            strB = hVar.b();
        } else {
            this.f1761d = "=[Java]";
            this.f1763f = -1;
            this.f1764g = -1;
            this.f1760c = "Java";
            strB = "[Java]";
        }
        this.l = strB;
    }

    public java.lang.String toString() {
        return "DebugInfo [\n\tname=" + this.f1758a + "\n\tnamewhat=" + this.f1759b + "\n\twhat=" + this.f1760c + "\n\tsource=" + this.f1761d + "\n\tcurrentline=" + this.f1762e + "\n\tlinedefined=" + this.f1763f + "\n\tlastlinedefined=" + this.f1764g + "\n\tnups=" + ((int) this.h) + "\n\tnparams=" + ((int) this.i) + "\n\tisvararg=" + this.j + "\n\tistailcall=" + this.k + "\n\tshort_src=" + this.l + "\n\tcf=" + this.m + "\n]";
    }
}

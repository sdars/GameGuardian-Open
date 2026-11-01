package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class h extends a implements luaj.Globals$a, luaj.Globals$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f1631b = new h();

    protected h() {
    }

    public static void M(luaj.Globals globals) {
        h hVar = f1631b;
        globals.k0 = hVar;
        globals.j0 = hVar;
    }

    @Override // luaj.Globals$b
    public luaj.LuaFunction a(luaj.h hVar, java.lang.String str, luaj.LuaValue luaValue) {
        return new luaj.LuaClosure(hVar, luaValue, true);
    }

    @Override // luaj.Globals$a
    public luaj.h b(java.io.InputStream inputStream, java.lang.String str) {
        return new h$a().b(inputStream, str);
    }
}

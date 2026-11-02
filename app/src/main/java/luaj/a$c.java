package luaj;

/* JADX INFO: loaded from: classes.dex */
final class a$c implements luaj.Globals$d {
    private a$c() {
    }

    /* synthetic */ a$c(luaj.a$a a_a) {
        this();
    }

    @Override // luaj.Globals$d
    public luaj.h a(java.io.InputStream inputStream, java.lang.String str) {try {

        return luaj.a.o(inputStream, str);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }
}

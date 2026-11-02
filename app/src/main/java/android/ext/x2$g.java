package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x2$g extends java.io.FileInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1322a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    x2$g(java.lang.String str, java.lang.String str2) throws java.io.FileNotFoundException {
        super(str);
        this.f1322a = str2;
    }

    @Override // java.io.FileInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        super.close();
        new java.io.File(this.f1322a).delete();
    }

    @Override // java.io.FileInputStream
    protected void finalize() throws java.io.IOException {try {

        super.finalize();
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        new java.io.File(this.f1322a).delete();
    }
}

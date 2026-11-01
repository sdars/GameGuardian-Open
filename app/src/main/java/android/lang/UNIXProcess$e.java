package android.lang;

/* JADX INFO: loaded from: classes.dex */
class UNIXProcess$e extends java.io.OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final android.lang.UNIXProcess$e f1484a = new android.lang.UNIXProcess$e();

    private UNIXProcess$e() {
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        throw new java.io.IOException("Stream closed");
    }
}

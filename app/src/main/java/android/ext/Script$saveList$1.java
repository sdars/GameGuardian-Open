package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$saveList$1 extends java.io.OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.io.RandomAccessFile f438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$saveList f439b;

    Script$saveList$1(android.ext.Script$saveList script$saveList, java.io.RandomAccessFile randomAccessFile) {
        this.f439b = script$saveList;
        this.f438a = randomAccessFile;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.f438a.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        this.f438a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.f438a.write(bArr, i, i2);
    }
}

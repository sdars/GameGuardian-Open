package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class GgLib$saveVariable$a extends java.io.OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.RandomAccessFile f1767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ luaj.lib.GgLib$saveVariable f1768b;

    GgLib$saveVariable$a(luaj.lib.GgLib$saveVariable ggLib$saveVariable, java.io.RandomAccessFile randomAccessFile) {
        this.f1768b = ggLib$saveVariable;
        this.f1767a = randomAccessFile;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.f1767a.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        this.f1768b.T.M3(1L);
        this.f1767a.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        this.f1768b.T.M3(bArr.length);
        this.f1767a.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.f1768b.T.M3(i2);
        this.f1767a.write(bArr, i, i2);
    }
}

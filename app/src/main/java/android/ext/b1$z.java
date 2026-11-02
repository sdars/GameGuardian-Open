package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$z extends java.io.InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.RandomAccessFile f654a;

    private b1$z(java.io.RandomAccessFile randomAccessFile) {
        this.f654a = randomAccessFile;
        try {
            randomAccessFile.seek(0L);
        } catch (java.io.IOException ggEx) {
            throw new java.lang.RuntimeException(ggEx);
        }
    }

    /* synthetic */ b1$z(java.io.RandomAccessFile randomAccessFile, android.ext.b1$i b1_i) {
        this(randomAccessFile);
    }

    @Override // java.io.InputStream
    public int available() {
        int length;
        try {
            length = (int) (this.f654a.length() - this.f654a.getFilePointer());
        } catch (java.lang.Throwable ggEx2) {
            throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
        }
        if (length > 0) {
            return length;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f654a.read();
        } catch (java.lang.Throwable ggEx2) {
            throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f654a.read(bArr);
        } catch (java.lang.Throwable ggEx2) {
            throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f654a.read(bArr, i, i2);
        } catch (java.lang.Throwable ggEx2) {
            throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
    }

    @Override // java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile = this.f654a;
        randomAccessFile.seek(randomAccessFile.getFilePointer() + j);
        return j;
    }
}


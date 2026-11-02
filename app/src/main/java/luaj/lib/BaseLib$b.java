package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class BaseLib$b extends java.io.BufferedInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1737b;

    public BaseLib$b(java.io.InputStream inputStream) {
        super(inputStream);
        this.f1737b = -1L;
    }

    public long a() {
        return this.f1736a;
    }

    public java.io.InputStream b() {
        return this.in;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        try {
            super.mark(i);
            this.f1737b = this.f1736a;
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int i = super.read();
        if (i != -1) {
            this.f1736a++;
        }
        return i;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = super.read(bArr, i, i2);
        if (i3 != -1) {
            this.f1736a += (long) i3;
        }
        return i3;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            if (!super.markSupported()) {
                throw new java.io.IOException("Mark not supported");
            }
            if (this.f1737b == -1) {
                throw new java.io.IOException("Mark not set");
            }
            super.reset();
            this.f1736a = this.f1737b;
        } catch (java.lang.Throwable th_c_c_c) {try {

            throw th_c_c_c;
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        long jSkip = super.skip(j);
        this.f1736a += jSkip;
        return jSkip;
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x2$i extends java.io.InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.InputStream f1326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1327b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1328c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f1329d = new byte[512];

    public x2$i(java.io.InputStream inputStream) {
        this.f1326a = inputStream;
    }

    public java.lang.String a() {
        java.lang.StringBuilder sb;
        java.lang.String str;
        java.lang.String str2 = "buf[" + this.f1327b + "]: ";
        if (this.f1327b <= this.f1329d.length) {
            sb = new java.lang.StringBuilder();
            sb.append(str2);
            str = new java.lang.String(this.f1329d, 0, this.f1328c);
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(str2);
            byte[] bArr = this.f1329d;
            int i = this.f1328c;
            sb.append(new java.lang.String(bArr, i, bArr.length - i));
            str = new java.lang.String(this.f1329d, 0, this.f1328c);
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // java.io.InputStream
    public int available() {try {

        return this.f1326a.available();
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.f1326a.close();
    }

    public boolean equals(java.lang.Object obj) {
        return this.f1326a.equals(obj);
    }

    public int hashCode() {
        return this.f1326a.hashCode();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f1326a.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f1326a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        int i = this.f1326a.read();
        if (i > 0) {
            this.f1327b++;
            byte[] bArr = this.f1329d;
            int i2 = this.f1328c;
            bArr[i2] = (byte) i;
            this.f1328c = (i2 + 1) % bArr.length;
        }
        return i;
    }

    @Override // java.io.InputStream
    public void reset() throws java.io.IOException {
        this.f1326a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {try {

        return this.f1326a.skip(j);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    public java.lang.String toString() {
        return this.f1326a.toString();
    }
}

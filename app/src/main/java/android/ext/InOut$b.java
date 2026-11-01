package android.ext;

/* JADX INFO: loaded from: classes.dex */
class InOut$b extends java.io.OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.OutputStream f183a;

    public InOut$b(java.io.OutputStream outputStream) {
        this.f183a = outputStream;
    }

    private byte[] a(byte[] bArr, int i, int i2) {
        int i3 = i2 * 2;
        byte[] bArr2 = new byte[i3 + 4];
        bArr2[0] = 59;
        bArr2[1] = 59;
        for (int i4 = 0; i4 < i2; i4++) {
            byte b2 = bArr[i + i4];
            int i5 = i4 * 2;
            bArr2[i5 + 2] = (byte) b(b2 & 15);
            bArr2[i5 + 3] = (byte) b((b2 & 240) >> 4);
        }
        bArr2[i3 + 2] = 10;
        bArr2[i3 + 3] = 10;
        return bArr2;
    }

    private int b(int i) {
        return (i < 0 || i > 15) ? i : i + 97;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws java.io.IOException {
        this.f183a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws java.io.IOException {
        this.f183a.write(b(i & 15));
        this.f183a.write(b((i & 240) >> 4));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws java.io.IOException {
        this.f183a.write(a(bArr, 0, bArr.length));
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        this.f183a.write(a(bArr, i, i2));
    }
}

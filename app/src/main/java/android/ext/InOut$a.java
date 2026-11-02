package android.ext;

/* JADX INFO: loaded from: classes.dex */
class InOut$a extends java.io.InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.InputStream f181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f182b = -2017;

    public InOut$a(java.io.InputStream inputStream) {
        this.f181a = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        int i = this.f182b;
        if (i != -2017) {
            this.f182b = -2017;
            return i;
        }
        java.io.InputStream inputStream = this.f181a;
        int i2 = inputStream.read();
        if (i2 < 97 || i2 > 112) {
            if (i2 != -1) {
                return i2;
            }
            throw android.ext.InOut.f();
        }
        int i3 = i2 - 97;
        int i4 = inputStream.read();
        if (i4 >= 97 && i4 <= 112) {
            return i3 + ((i4 - 97) * 16);
        }
        if (i4 == -1) {
            throw android.ext.InOut.f();
        }
        this.f182b = i4;
        return i2;
    }

    /**
     * Bulk read of the hex framed daemon stream.
     *
     * Faithful port of the original {@code InOut$a.read([BII)I} dalvik routine:
     * the stream carries every payload byte as two characters in the range
     * {@code 'a'..'p'} (low nibble first). Characters outside of that range are
     * passed through verbatim, a trailing half byte is kept in the pending
     * field and the pending state survives across calls.
     */
    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = i2 + i;
        int i4 = this.f182b;
        java.io.InputStream inputStream = this.f181a;
        while (i < i3) {
            int i5 = -2017;
            if (i4 == -2017 || i4 == -1) {
                if (i4 == -1) {
                    i4 = -2017;
                }
                int i6 = inputStream.read();
                if (i6 >= 97 && i6 <= 112) {
                    int i7 = i6 - 97;
                    int i8 = inputStream.read();
                    if (i8 >= 97 && i8 <= 112) {
                        i5 = i7 + ((i8 - 97) * 16);
                        int i9 = i4;
                        i4 = i5;
                        i5 = i9;
                    } else {
                        if (i8 == -1) {
                            throw android.ext.InOut.f();
                        }
                        i5 = i8;
                        i4 = i6;
                    }
                } else {
                    if (i6 == -1) {
                        throw android.ext.InOut.f();
                    }
                    int i9 = i4;
                    i4 = i6;
                    i5 = i9;
                }
            }
            bArr[i] = (byte) i4;
            i++;
            i4 = i5;
        }
        this.f182b = i4;
        return 0;
    }
}

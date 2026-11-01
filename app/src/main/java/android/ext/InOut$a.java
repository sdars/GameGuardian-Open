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

    /* JADX WARN: Code duplicated, block: B:22:0x003b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0045 A[SYNTHETIC] */
    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        int i4 = i2 + i;
        int i5 = this.f182b;
        java.io.InputStream inputStream = this.f181a;
        while (i < i4) {
            int i6 = -2017;
            if (i5 == -2017) {
                i3 = inputStream.read();
                if (i3 < 97 && i3 <= 112) {
                    int i7 = i3 - 97;
                    int i8 = inputStream.read();
                    if (i8 >= 97 && i8 <= 112) {
                        i3 = i7 + ((i8 - 97) * 16);
                    } else {
                        if (i8 == -1) {
                            throw android.ext.InOut.f();
                        }
                        i5 = i3;
                        i6 = i8;
                    }
                } else if (i3 == -1) {
                    throw android.ext.InOut.f();
                }
                int i9 = i3;
                i6 = i5;
                i5 = i9;
            } else if (i5 != -1) {
                continue;
            } else {
                i5 = -2017;
                i3 = inputStream.read();
                if (i3 < 97) {
                    if (i3 == -1) {
                        throw android.ext.InOut.f();
                    }
                    int i10 = i3;
                    i6 = i5;
                    i5 = i10;
                } else {
                    if (i3 == -1) {
                        throw android.ext.InOut.f();
                    }
                    int i11 = i3;
                    i6 = i5;
                    i5 = i11;
                }
            }
            bArr[i] = (byte) i5;
            i++;
            i5 = i6;
        }
        this.f182b = i5;
        return 0;
    }
}

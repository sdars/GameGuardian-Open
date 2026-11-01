package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class b1$t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f642c;

    b1$t(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    b1$t(byte[] bArr, int i, int i2) {
        this.f640a = bArr;
        this.f642c = i;
        this.f641b = i + i2;
    }

    boolean a() {
        return this.f642c == this.f641b;
    }

    android.ext.b1$t b(int[] iArr) {
        return new android.ext.b1$t(this.f640a, iArr[0], iArr[1]);
    }

    int[] c(int i) {
        int i2;
        int i3 = this.f642c;
        int i4 = i3 + 2;
        int i5 = this.f641b;
        if (i4 <= i5) {
            byte[] bArr = this.f640a;
            if ((bArr[i3] & 255) == i) {
                int i6 = i3 + 1;
                int i7 = i3 + 2;
                int i8 = bArr[i6];
                int i9 = i8 & 255;
                if ((i8 & 128) != 0) {
                    int i10 = i8 & 127;
                    if (i10 == 0 || i10 > 4 || i7 + i10 > i5) {
                        return null;
                    }
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < i10) {
                        i12 = (i12 << 8) | (this.f640a[i7] & 255);
                        i11++;
                        i7++;
                    }
                    i9 = i12;
                }
                if (i9 >= 0 && (i2 = i7 + i9) <= this.f641b) {
                    this.f642c = i2;
                    return new int[]{i7, i9};
                }
            }
        }
        return null;
    }

    byte[] d(int[] iArr) {
        int i = iArr[1];
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this.f640a, iArr[0], bArr, 0, i);
        return bArr;
    }
}

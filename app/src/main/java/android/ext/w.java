package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.nio.ByteBuffer f1287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f1288b;

    public w(byte[] bArr) {
        this.f1288b = bArr;
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        this.f1287a = byteBufferWrap;
        byteBufferWrap.order(java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public int a() {
        return this.f1287a.position();
    }

    public byte b() {
        byte bE;
        int iPosition = this.f1287a.position();
        this.f1287a.position(1);try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

            bE = e();
        } catch (java.io.IOException e2) {
            android.ext.e1.l("getSeq fail", e2);
            bE = -1;
        };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        this.f1287a.position(iPosition);
        return bE;
    }

    public void c(byte[] bArr) {
        this.f1287a.get(bArr);
    }

    public void d(byte[] bArr, int i, int i2) {
        this.f1287a.get(bArr, i, i2);
    }

    public byte e() {
        return this.f1287a.get();
    }

    public int f() {
        return this.f1287a.getInt();
    }

    public long g() {
        return android.ext.InOut.m ? this.f1287a.getLong() : ((long) f()) & 4294967295L;
    }

    public long h() {
        return this.f1287a.getLong();
    }

    public java.lang.String i(int i, java.lang.String str) {
        if (i == 0) {
            return "";
        }
        int iPosition = this.f1287a.position();
        byte[] bArr = this.f1288b;
        if (str == null || str.length() != i) {
            str = null;
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                if (str.charAt(i2) != bArr[iPosition + i2]) {
                    str = null;
                    break;
                }
            }
        }
        if (str == null) {
            str = new java.lang.String(bArr, iPosition, i);
        }
        this.f1287a.position(iPosition + i);
        return str;
    }

    public void j() {
        this.f1287a.position(2);
    }

    public int k() {
        return this.f1287a.capacity();
    }

    public void l(int i) {
        java.nio.ByteBuffer byteBuffer = this.f1287a;
        byteBuffer.position(byteBuffer.position() + i);
    }
}

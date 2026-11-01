package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.io.RandomAccessFile f605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.nio.ByteBuffer f606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.b1 f608d;

    private b1$b0(android.ext.b1 b1Var, int i) {
        byte[] bArr;
        this.f608d = b1Var;
        this.f605a = null;
        this.f606b = null;
        boolean z = android.ext.b1.A[i];
        this.f607c = z;
        if (!z) {
            this.f605a = b1Var.h0(i);
            return;
        }
        byte[][] bArr2 = android.ext.b1.z;
        if (bArr2 != null && (bArr = bArr2[i]) != null) {
            this.f606b = java.nio.ByteBuffer.wrap(bArr);
            return;
        }
        throw new android.ext.b1$v("memCache is null 3: " + i + ' ' + android.ext.b1.z);
    }

    /* synthetic */ b1$b0(android.ext.b1 b1Var, int i, android.ext.b1$i b1_i) {
        this(b1Var, i);
    }

    private b1$b0(android.ext.b1 b1Var, byte[] bArr, java.lang.String str) {
        this.f608d = b1Var;
        this.f605a = null;
        this.f606b = null;
        if (bArr != null) {
            this.f607c = true;
            this.f606b = java.nio.ByteBuffer.wrap(bArr);
        } else {
            throw new android.ext.b1$v("RandomAccessData: null data for " + str);
        }
    }

    /* synthetic */ b1$b0(android.ext.b1 b1Var, byte[] bArr, java.lang.String str, android.ext.b1$i b1_i) {
        this(b1Var, bArr, str);
    }

    public void a() {
    }

    public long b() {try {

        return this.f607c ? this.f606b.capacity() : this.f605a.length();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    public long c() {try {

        return this.f607c ? this.f606b.position() : this.f605a.getFilePointer();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    public int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    public int e(byte[] bArr, int i, int i2) {
        if (!this.f607c) {try {

            return this.f605a.read(bArr, i, i2);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
        int iMin = java.lang.Math.min(i2, this.f606b.remaining());
        if (iMin == 0) {
            return -1;
        }
        this.f606b.get(bArr, i, iMin);
        return iMin;
    }

    public void f(long j) {
        if (this.f607c) {
            this.f606b.position((int) j);
        } else {try {

            this.f605a.seek(j);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
    }

    public void g(int i) {
        if (!this.f607c) {try {

            this.f605a.skipBytes(i);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        } else {
            java.nio.ByteBuffer byteBuffer = this.f606b;
            byteBuffer.position(byteBuffer.position() + i);
        }
    }

    public void h(byte[] bArr) {
        if (this.f607c) {
            this.f606b.put(bArr);
        } else {try {

            this.f605a.write(bArr);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
    }

    public void i(byte[] bArr, int i, int i2) {
        if (this.f607c) {
            this.f606b.put(bArr, i, i2);
        } else {try {

            this.f605a.write(bArr, i, i2);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
    }
}

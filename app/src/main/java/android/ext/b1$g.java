package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$g extends java.io.ByteArrayOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.b1 f622b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b1$g(android.ext.b1 b1Var, int i, int i2) {
        super(i);
        this.f622b = b1Var;
        this.f621a = i2;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        super.close();
        byte[][] bArr = android.ext.b1.z;
        if (bArr != null) {
            byte[] byteArray = toByteArray();
            if (byteArray == null) {
                android.ext.e1.a(new java.lang.RuntimeException("toByteArray return null"));
            }
            bArr[this.f621a] = byteArray;
        }
    }
}

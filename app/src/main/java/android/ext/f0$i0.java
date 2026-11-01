package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$i0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f879c;

    f0$i0(android.ext.f0 f0Var, byte[] bArr, byte b2) {
        this.f879c = f0Var;
        this.f877a = bArr;
        this.f878b = b2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f879c.f793b;
        int length = this.f877a.length;
        inOut.q(this.f878b, (byte) 48, length + 4);
        inOut.u(length);
        inOut.t(this.f877a, length);
        this.f879c.t0();
    }
}

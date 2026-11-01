package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$w implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte[] f942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.lang.String f943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f944d;

    f0$w(android.ext.f0 f0Var, byte b2, byte[] bArr, java.lang.String str) {
        this.f944d = f0Var;
        this.f941a = b2;
        this.f942b = bArr;
        this.f943c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f944d.f793b;
        inOut.q(this.f941a, (byte) 54, 0);
        inOut.u(android.ext.Config.h);
        inOut.u(android.ext.Config.A);
        inOut.w(android.ext.Config.j);
        inOut.u(android.ext.Config.m);
        inOut.u(android.ext.Config.i);
        inOut.u(this.f942b.length);
        byte[] bArr = this.f942b;
        inOut.t(bArr, bArr.length);
        long jE = inOut.e();
        android.ext.f0 f0Var = this.f944d;
        if (jE != f0Var.t) {
            f0Var.t = jE;
            f0Var.t0();
            android.ext.e1.d("Sended config: " + android.ext.Config.h + ' ' + java.lang.Integer.toBinaryString(android.ext.Config.A) + ' ' + java.lang.Long.toBinaryString(android.ext.Config.j) + ' ' + android.ext.Config.m + ' ' + android.ext.Config.i + ' ' + this.f943c + "; " + this.f942b.length);
        }
    }
}

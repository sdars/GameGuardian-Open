package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f864d;

    f0$h(android.ext.f0 f0Var, byte b2, long j, int i) {
        this.f864d = f0Var;
        this.f861a = b2;
        this.f862b = j;
        this.f863c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f0 f0Var = this.f864d;
        android.ext.InOut inOut = f0Var.f793b;
        f0Var.u0(this.f861a, (byte) 58);
        inOut.q(this.f861a, (byte) 59, 0);
        inOut.v(this.f862b);
        inOut.u(this.f863c);
        this.f864d.t0();
    }
}

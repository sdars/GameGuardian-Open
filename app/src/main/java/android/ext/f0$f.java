package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean[] f847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f848d;

    f0$f(android.ext.f0 f0Var, byte b2, int i, boolean[] zArr) {
        this.f848d = f0Var;
        this.f845a = b2;
        this.f846b = i;
        this.f847c = zArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f848d.f793b;
        inOut.q(this.f845a, (byte) 35, 0);
        inOut.u(this.f846b | 32);
        this.f848d.W0(this.f847c);
        this.f848d.t0();
    }
}

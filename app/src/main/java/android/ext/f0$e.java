package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean[] f833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f837f;

    f0$e(android.ext.f0 f0Var, byte b2, boolean[] zArr, int i, int i2, long j) {
        this.f837f = f0Var;
        this.f832a = b2;
        this.f833b = zArr;
        this.f834c = i;
        this.f835d = i2;
        this.f836e = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f837f.f793b;
        inOut.q(this.f832a, (byte) 35, 0);
        inOut.u(16);
        this.f837f.W0(this.f833b);
        inOut.u(this.f834c);
        inOut.u(this.f835d);
        inOut.w(this.f836e);
        this.f837f.t0();
    }
}

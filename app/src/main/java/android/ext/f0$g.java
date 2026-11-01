package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean[] f855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f856d;

    f0$g(android.ext.f0 f0Var, byte b2, int i, boolean[] zArr) {
        this.f856d = f0Var;
        this.f853a = b2;
        this.f854b = i;
        this.f855c = zArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f856d.f793b;
        inOut.q(this.f853a, (byte) 35, 0);
        inOut.u(this.f854b | 8);
        this.f856d.W0(this.f855c);
        this.f856d.t0();
    }
}

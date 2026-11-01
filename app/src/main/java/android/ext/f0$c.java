package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f819e;

    f0$c(android.ext.f0 f0Var, byte b2, long j, long j2, int i) {
        this.f819e = f0Var;
        this.f815a = b2;
        this.f816b = j;
        this.f817c = j2;
        this.f818d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f819e.f793b;
        inOut.q(this.f815a, (byte) 62, 0);
        inOut.v(this.f816b);
        inOut.v(this.f817c);
        inOut.u(this.f818d);
        this.f819e.t0();
    }
}

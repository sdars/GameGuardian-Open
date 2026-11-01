package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$l implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ short f894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f899g;

    f0$l(android.ext.f0 f0Var, byte b2, short s, int i, long j, long j2, long j3) {
        this.f899g = f0Var;
        this.f893a = b2;
        this.f894b = s;
        this.f895c = i;
        this.f896d = j;
        this.f897e = j2;
        this.f898f = j3;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f899g.f793b;
        inOut.q(this.f893a, (byte) 64, 0);
        inOut.u(this.f894b);
        inOut.u(this.f895c);
        inOut.v(this.f896d);
        inOut.v(this.f897e);
        inOut.v(this.f898f);
        this.f899g.t0();
        android.ext.f0.w = false;
    }
}

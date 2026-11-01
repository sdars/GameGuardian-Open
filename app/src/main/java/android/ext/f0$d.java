package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean[] f823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f825e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ double f826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ double f827g;
    final /* synthetic */ android.ext.f0 h;

    f0$d(android.ext.f0 f0Var, byte b2, int i, boolean[] zArr, long j, long j2, double d2, double d3) {
        this.h = f0Var;
        this.f821a = b2;
        this.f822b = i;
        this.f823c = zArr;
        this.f824d = j;
        this.f825e = j2;
        this.f826f = d2;
        this.f827g = d3;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.h.f793b;
        inOut.q(this.f821a, (byte) 35, 0);
        inOut.u(this.f822b | 17);
        this.h.W0(this.f823c);
        inOut.w(this.f824d);
        inOut.w(this.f825e);
        inOut.w(java.lang.Double.doubleToRawLongBits(this.f826f));
        inOut.w(java.lang.Double.doubleToRawLongBits(this.f827g));
        this.h.t0();
    }
}

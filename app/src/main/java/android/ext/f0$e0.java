package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$e0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f841d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f842e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f844g;
    final /* synthetic */ int h;
    final /* synthetic */ long i;
    final /* synthetic */ int j;
    final /* synthetic */ int k;
    final /* synthetic */ int l;
    final /* synthetic */ double m;
    final /* synthetic */ int n;
    final /* synthetic */ android.ext.f0 o;

    f0$e0(android.ext.f0 f0Var, byte b2, int i, int i2, int i3, long j, long j2, long j3, int i4, long j4, int i5, int i6, int i7, double d2, int i8) {
        this.o = f0Var;
        this.f838a = b2;
        this.f839b = i;
        this.f840c = i2;
        this.f841d = i3;
        this.f842e = j;
        this.f843f = j2;
        this.f844g = j3;
        this.h = i4;
        this.i = j4;
        this.j = i5;
        this.k = i6;
        this.l = i7;
        this.m = d2;
        this.n = i8;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.o.f793b;
        inOut.q(this.f838a, (byte) 39, 0);
        inOut.u(this.f839b);
        inOut.u(this.f840c);
        inOut.u(this.f841d);
        inOut.w(this.f842e);
        inOut.w(this.f843f);
        inOut.w(this.f844g);
        inOut.u(this.h);
        inOut.w(this.i);
        inOut.u(this.j);
        inOut.u(this.k);
        inOut.u(this.l);
        inOut.w(java.lang.Double.doubleToRawLongBits(this.m));
        inOut.u(this.n);
        this.o.t0();
    }
}

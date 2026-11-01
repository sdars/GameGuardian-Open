package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$n implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f913e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f914f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f915g;
    final /* synthetic */ long h;
    final /* synthetic */ android.ext.f0 i;

    f0$n(android.ext.f0 f0Var, byte b2, long j, long j2, int i, int i2, long j3, long j4, long j5) {
        this.i = f0Var;
        this.f909a = b2;
        this.f910b = j;
        this.f911c = j2;
        this.f912d = i;
        this.f913e = i2;
        this.f914f = j3;
        this.f915g = j4;
        this.h = j5;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.i.f793b;
        inOut.q(this.f909a, (byte) 38, 0);
        inOut.w(this.f910b);
        inOut.w(this.f911c);
        inOut.u(this.f912d);
        inOut.u(this.f913e);
        inOut.v(this.f914f);
        inOut.v(this.f915g);
        inOut.v(this.h);
        this.i.t0();
        android.ext.f0.w = (this.f913e & Integer.MIN_VALUE) != 0;
    }
}

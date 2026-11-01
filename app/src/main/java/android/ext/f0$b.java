package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte[] f807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ byte f808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ java.lang.String f812g;
    final /* synthetic */ android.ext.f0 h;

    f0$b(android.ext.f0 f0Var, byte[] bArr, byte[] bArr2, byte b2, long j, long j2, int i, java.lang.String str) {
        this.h = f0Var;
        this.f806a = bArr;
        this.f807b = bArr2;
        this.f808c = b2;
        this.f809d = j;
        this.f810e = j2;
        this.f811f = i;
        this.f812g = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.h.f793b;
        int length = this.f806a.length;
        int length2 = this.f807b.length;
        inOut.q(this.f808c, (byte) 61, 0);
        inOut.v(this.f809d);
        inOut.v(this.f810e);
        inOut.u(this.f811f);
        inOut.u(length);
        inOut.t(this.f806a, length);
        inOut.u(length2);
        inOut.t(this.f807b, length2);
        this.h.t0();
        android.ext.MainService.instance.h0(android.ext.Tools.L1("%s: %s - %s > %s", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.dump_memory), android.ext.c.G(this.f809d, 4), android.ext.c.G(this.f810e, 4), this.f812g));
    }
}

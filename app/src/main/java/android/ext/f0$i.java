package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int[] f870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ long f874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ long f876g;
    final /* synthetic */ long[] h;
    final /* synthetic */ long[] i;
    final /* synthetic */ android.ext.f0 j;

    f0$i(android.ext.f0 f0Var, int[] iArr, byte b2, int i, int i2, long j, long j2, long j3, long[] jArr, long[] jArr2) {
        this.j = f0Var;
        this.f870a = iArr;
        this.f871b = b2;
        this.f872c = i;
        this.f873d = i2;
        this.f874e = j;
        this.f875f = j2;
        this.f876g = j3;
        this.h = jArr;
        this.i = jArr2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.j.f793b;
        int length = this.f870a.length;
        android.ext.y yVar = new android.ext.y();
        yVar.a(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.union));
        yVar.a(" = ");
        inOut.q(this.f871b, (byte) 55, 0);
        inOut.u(this.f872c);
        inOut.u(this.f873d);
        inOut.v(this.f874e);
        inOut.v(this.f875f);
        inOut.v(this.f876g);
        inOut.u(length);
        for (int i = 0; i < length; i++) {
            long[] jArr = this.h;
            jArr[i] = android.ext.c.h(jArr[i], this.f870a[i]);
            long[] jArr2 = this.i;
            jArr2[i] = android.ext.c.h(jArr2[i], this.f870a[i]);
            inOut.u(this.f870a[i]);
            inOut.w(this.h[i]);
            inOut.w(this.i[i]);
            java.lang.String strK = android.ext.c.K(0L, this.h[i], this.f870a[i]);
            if ((this.f870a[i] & 805306368) != 0) {
                strK = strK + '~' + android.ext.c.K(0L, this.i[i], this.f870a[i]);
            }
            if ((this.f870a[i] & 268435456) != 0) {
                strK = "≠ " + strK;
            }
            if (i != 0) {
                yVar.a("; ");
            }
            yVar.a(android.ext.Tools.t(strK + ((java.lang.Object) android.ext.c.A(this.f870a[i])), android.ext.c.n(this.f870a[i])));
        }
        this.j.t0();
        yVar.a(" :");
        if ((this.f872c & 4194304) != 0) {
            yVar.a(":");
        }
        yVar.a(android.ext.Tools.L1("%,d", java.lang.Integer.valueOf(this.f873d)));
        android.ext.MainService.instance.h0(yVar.d());
        android.ext.f0.w = false;
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$r implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.h2[] f928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f930c;

    f0$r(android.ext.f0 f0Var, android.ext.h2[] h2VarArr, byte b2) {
        this.f930c = f0Var;
        this.f928a = h2VarArr;
        this.f929b = b2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f930c.f793b;
        int length = this.f928a.length;
        int i = 0;
        while (i < length) {
            int i2 = length - i;
            if (i2 > 100000000) {
                i2 = 100000000;
            }
            inOut.q(this.f929b, (byte) 41, (android.ext.InOut.n + 4) * i2);
            int i3 = i2 + i;
            while (i < i3) {
                android.ext.h2 h2Var = this.f928a[i];
                int i4 = h2Var.f674c;
                if (i4 != 0) {
                    inOut.u(i4);
                    inOut.v(h2Var.f672a);
                }
                i++;
            }
            inOut.u(0);
            this.f930c.t0();
            i = i3;
        }
    }
}

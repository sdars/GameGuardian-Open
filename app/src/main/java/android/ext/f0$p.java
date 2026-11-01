package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$p implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.h2[] f923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f925c;

    f0$p(android.ext.f0 f0Var, android.ext.h2[] h2VarArr, byte b2) {
        this.f925c = f0Var;
        this.f923a = h2VarArr;
        this.f924b = b2;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.InOut inOut = this.f925c.f793b;
        int length = this.f923a.length;
        int i = 0;
        while (i < length) {
            int i2 = length - i;
            if (i2 > 100000000) {
                i2 = 100000000;
            }
            inOut.q(this.f924b, (byte) 40, (android.ext.InOut.n + 29) * i2);
            int i3 = i2 + i;
            while (i < i3) {
                android.ext.h2 h2Var = this.f923a[i];
                int i4 = h2Var.f674c;
                if (i4 != 0) {
                    inOut.u(i4);
                    inOut.v(h2Var.f672a);
                    inOut.w(h2Var.f673b);
                    inOut.s(h2Var.n);
                    inOut.w(h2Var.o);
                    inOut.w(h2Var.p);
                }
                i++;
            }
            inOut.u(0);
            this.f925c.t0();
            i = i3;
        }
    }
}

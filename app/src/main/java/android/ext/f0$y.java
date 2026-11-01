package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$y implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte f947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ byte f948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f949c;

    f0$y(android.ext.f0 f0Var, byte b2, byte b3) {
        this.f949c = f0Var;
        this.f947a = b2;
        this.f948b = b3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f949c.f793b.q(this.f947a, this.f948b, 0);
        this.f949c.t0();
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.b1 f619b;

    b1$e(android.ext.b1 b1Var, int i) {
        this.f619b = b1Var;
        this.f618a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.b1.C.j &= ~this.f618a;
    }
}

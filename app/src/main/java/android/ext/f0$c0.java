package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$c0 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f820a;

    f0$c0(android.ext.f0 f0Var) {
        this.f820a = f0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService.instance.W(android.ext.MainService.instance.Y);
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f467a;

    ShowApp$g(android.ext.ShowApp showApp) {
        this.f467a = showApp;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.view.View view = this.f467a.f459g;
        if (view == null) {
            return;
        }
        if (android.ext.MainService.instance.f213c == null || android.ext.MainService.instance.n == null) {
            this.f467a.f(view);
        }
    }
}

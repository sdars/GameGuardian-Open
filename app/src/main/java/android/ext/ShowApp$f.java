package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f466a;

    ShowApp$f(android.ext.ShowApp showApp) {
        this.f466a = showApp;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.view.View view;
        android.ext.n2.d().removeCallbacks(this.f466a.j);
        android.ext.ShowApp showApp = this.f466a;
        showApp.f(showApp.f459g);
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (mainService == null || (view = mainService.f213c) == null) {
            return;
        }
        android.view.View view2 = mainService.f214d;
        if (view2 != null && android.ext.MainService.instance.n != null) {
            android.ext.ShowApp showApp2 = this.f466a;
            if (showApp2.l(view2, showApp2.f454b)) {
                this.f466a.h = view2;
            }
        }
        android.ext.ShowApp showApp3 = this.f466a;
        if (showApp3.l(view, showApp3.f454b)) {
            this.f466a.f459g = view;
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f468a;

    ShowApp$h(android.ext.ShowApp showApp) {
        this.f468a = showApp;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.ShowApp showApp = this.f468a;
        if (showApp.b(showApp.i)) {
            this.f468a.i = null;
        }
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (mainService == null) {
            return;
        }
        android.view.View view = mainService.f217g;
        android.ext.ShowApp showApp2 = this.f468a;
        if (showApp2.l(view, showApp2.f454b)) {
            this.f468a.i = view;
        }
    }
}

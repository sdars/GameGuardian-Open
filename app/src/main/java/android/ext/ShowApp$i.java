package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f469a;

    ShowApp$i(android.ext.ShowApp showApp) {
        this.f469a = showApp;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.ShowApp showApp = this.f469a;
        if (showApp.b(showApp.i)) {
            this.f469a.i = null;
        }
    }
}

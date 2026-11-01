package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$k implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f471a;

    ShowApp$k(android.ext.ShowApp showApp) {
        this.f471a = showApp;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f471a.f457e) {
            android.ext.ShowApp showApp = this.f471a;
            if (showApp.b(showApp.f455c)) {
                this.f471a.f457e = false;
            }
        }
        android.ext.ShowApp showApp2 = this.f471a;
        if (showApp2.l(showApp2.f455c, showApp2.f456d)) {
            this.f471a.f457e = true;
        }
    }
}

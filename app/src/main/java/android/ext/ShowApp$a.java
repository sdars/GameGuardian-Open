package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f460a;

    ShowApp$a(android.ext.ShowApp showApp) {
        this.f460a = showApp;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f460a.f457e) {
            android.ext.ShowApp showApp = this.f460a;
            if (showApp.b(showApp.f455c)) {
                this.f460a.f457e = false;
            }
        }
    }
}

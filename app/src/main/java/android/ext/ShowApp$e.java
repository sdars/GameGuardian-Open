package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f465a;

    ShowApp$e(android.ext.ShowApp showApp) {
        this.f465a = showApp;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f465a.f459g == null) {
            this.f465a.o();
            android.ext.n2.d().postDelayed(this.f465a.j, 2000L);
        }
    }
}

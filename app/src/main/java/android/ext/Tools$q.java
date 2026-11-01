package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$q implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.View f533a;

    Tools$q(android.view.View view) {
        this.f533a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.ext.MainService.instance.l.removeView(this.f533a);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed removeView: " + this.f533a, th);
        }
    }
}

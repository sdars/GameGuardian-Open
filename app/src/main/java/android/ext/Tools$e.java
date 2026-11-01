package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.Window f506a;

    Tools$e(android.view.Window window) {
        this.f506a = window;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.view.View currentFocus = this.f506a.getCurrentFocus();
            if (currentFocus == null) {
                currentFocus = this.f506a.peekDecorView();
            }
            if (currentFocus != null) {
                android.ext.Tools.S0(currentFocus);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("hideSoftInputFromWindow", th);
        }
    }
}

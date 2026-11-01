package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$f implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.View f507a;

    Tools$f(android.view.View view) {
        this.f507a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (android.ext.Tools.f495g == null) {
                android.ext.Tools.f495g = (android.view.inputmethod.InputMethodManager) android.ext.MainService.context.getSystemService("input_method");
            }
            android.view.View view = this.f507a;
            if (view != null) {
                android.ext.Tools.f495g.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("hideSoftInputFromWindow", th);
        }
    }
}

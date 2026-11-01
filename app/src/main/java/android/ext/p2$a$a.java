package android.ext;

/* JADX INFO: loaded from: classes.dex */
class p2$a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.p2$a f1183a;

    p2$a$a(android.ext.p2$a p2_a) {
        this.f1183a = p2_a;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.widget.Toast toastMakeText = android.widget.Toast.makeText(android.ext.p2.h(), " ", 1);
            android.view.View view = toastMakeText.getView();
            view.setBackgroundColor(0);
            toastMakeText.setView(view);
            android.ext.p2.g(toastMakeText).show();
            synchronized (android.ext.p2.f1177b) {
                try {
                    android.widget.Toast unused = android.ext.p2.f1176a = toastMakeText;
                } catch (java.lang.Throwable th_c_c_c) {
                    throw th_c_c_c;
                }
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.s("Toast show", th2);
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$k implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface f512a;

    Tools$k(android.content.DialogInterface dialogInterface) {
        this.f512a = dialogInterface;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f512a.dismiss();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}

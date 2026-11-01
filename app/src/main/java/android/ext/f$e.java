package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$e implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f$n f769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.os.Handler f770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f773e;

    f$e(android.ext.f$n f_n, android.os.Handler handler, java.lang.Runnable runnable, android.app.AlertDialog alertDialog, java.lang.Runnable runnable2) {
        this.f769a = f_n;
        this.f770b = handler;
        this.f771c = runnable;
        this.f772d = alertDialog;
        this.f773e = runnable2;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        this.f769a.f785a = true;
        this.f770b.removeCallbacks(this.f771c);
        android.ext.f.j(this.f772d, this.f769a, this.f773e);
    }
}

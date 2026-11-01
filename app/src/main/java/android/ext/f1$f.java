package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$f implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f965b;

    f1$f(boolean[] zArr, java.lang.Runnable runnable) {
        this.f964a = zArr;
        this.f965b = runnable;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        if (this.f964a[0]) {
            return;
        }
        this.f965b.run();
    }
}

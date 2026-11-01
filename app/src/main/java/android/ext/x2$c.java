package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x2$c implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean[] f1315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1316b;

    x2$c(boolean[] zArr, java.lang.Runnable runnable) {
        this.f1315a = zArr;
        this.f1316b = runnable;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        if (this.f1315a[0]) {
            return;
        }
        this.f1316b.run();
    }
}

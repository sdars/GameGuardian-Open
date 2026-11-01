package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x2$e implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1319a;

    x2$e(java.lang.Runnable runnable) {
        this.f1319a = runnable;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.f1319a.run();
    }
}

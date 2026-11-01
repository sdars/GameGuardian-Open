package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$c implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f765a;

    f$c(java.lang.Runnable runnable) {
        this.f765a = runnable;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.e1.d(this.f765a + ": 40_");
        android.ext.n2.d().postDelayed(this.f765a, 5000L);
    }
}

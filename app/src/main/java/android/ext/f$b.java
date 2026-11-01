package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$b implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f764a;

    f$b(java.lang.Runnable runnable) {
        this.f764a = runnable;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.e1.d(this.f764a + ": 30_");
        android.ext.n2.d().removeCallbacks(this.f764a);
    }
}

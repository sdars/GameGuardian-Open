package android.ext;

/* JADX INFO: loaded from: classes.dex */
class x2$f implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Runnable f1320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1321b;

    x2$f(java.lang.Runnable runnable, java.lang.String str) {
        this.f1320a = runnable;
        this.f1321b = str;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.e1.d(this.f1320a + ": 120");
        android.ext.x2.t(this.f1321b);
        android.ext.e1.d(this.f1320a + ": 130");
    }
}

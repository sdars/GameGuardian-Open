package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f628a;

    b1$o(java.lang.String str) {
        this.f628a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.io.File file;
        android.ext.b1 b1Var = android.ext.b1.B;
        java.lang.String absolutePath = (b1Var == null || (file = b1Var.f594c) == null) ? null : file.getAbsolutePath();
        android.ext.f.m(android.ext.f.c(android.ext.r.p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no_space) + '\n' + this.f628a + '\n' + absolutePath).setPositiveButton(catch_.me_.if_.you_.can_.R.string.ok, new android.ext.b1$o$a(this)).setCancelable(false).create());
    }
}

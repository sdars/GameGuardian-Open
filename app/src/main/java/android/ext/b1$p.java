package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$p implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.Throwable f630a;

    b1$p(java.lang.Throwable th) {
        this.f630a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.b1$p$a b1_p_a = new android.ext.b1$p$a(this);
        android.ext.f.m(android.ext.f.c(android.ext.r.p).setMessage(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.reinstall_fail) + ":\n\n" + android.ext.e1.n(this.f630a)).setPositiveButton(catch_.me_.if_.you_.can_.R.string.more, b1_p_a).setNegativeButton(catch_.me_.if_.you_.can_.R.string.ok, b1_p_a).setCancelable(false).create());
    }
}

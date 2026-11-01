package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$m implements java.lang.Runnable {
    b1$m() {
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.b1$m$a b1_m_a = new android.ext.b1$m$a(this);
        android.ext.f.o(android.ext.f.c(android.ext.r.p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.failed_install)).setPositiveButton(catch_.me_.if_.you_.can_.R.string.yes, b1_m_a).setNegativeButton(catch_.me_.if_.you_.can_.R.string.no, b1_m_a).setCancelable(false));
    }
}

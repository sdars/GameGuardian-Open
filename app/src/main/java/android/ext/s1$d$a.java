package android.ext;

/* JADX INFO: loaded from: classes.dex */
class s1$d$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.s1$d f1245a;

    s1$d$a(android.ext.s1$d s1_d) {
        this.f1245a = s1_d;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (android.ext.s1.u() && android.ext.s1.O() == 1 && android.ext.r.n != null) {
            android.ext.s1.N();
        }
    }
}

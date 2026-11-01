package android.ext;

/* JADX INFO: loaded from: classes.dex */
class e1$d$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.e1$d f744a;

    e1$d$a(android.ext.e1$d e1_d) {
        this.f744a = e1_d;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.MainService.instance.p0((byte) 0, 20, null);
    }
}

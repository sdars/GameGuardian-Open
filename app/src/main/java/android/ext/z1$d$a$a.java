package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z1$d$a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.z1$d$a f1441a;

    z1$d$a$a(android.ext.z1$d$a z1_d_a) {
        this.f1441a = z1_d_a;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.Object tag = this.f1441a.f1439a.getTag();
        android.ext.z1$d$a z1_d_a = this.f1441a;
        android.ext.z1$d z1_d = z1_d_a.f1440b;
        if (tag == z1_d) {
            android.ext.Tools.c(z1_d_a.f1439a, z1_d.f1436e, 48);
        }
    }
}

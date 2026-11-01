package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z1$d$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f1439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.z1$d f1440b;

    z1$d$a(android.ext.z1$d z1_d, android.widget.TextView textView) {
        this.f1440b = z1_d;
        this.f1439a = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1440b.h();
        if (this.f1440b.f1436e != null) {
            android.ext.n2.i(new android.ext.z1$d$a$a(this));
        }
    }
}

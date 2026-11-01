package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1210a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.os.Bundle f1211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.r f1212c;

    r$a(android.ext.r rVar, android.os.Bundle bundle) {
        this.f1212c = rVar;
        this.f1211b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1.d(this + ": 1200");
        if (!this.f1210a) {
            this.f1210a = true;
            this.f1212c.F(this.f1211b);
        } else {
            android.ext.e1.d(this + ": already");
        }
    }
}

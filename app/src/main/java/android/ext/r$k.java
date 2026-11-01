package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$k implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1224a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.os.Bundle f1225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.r f1226c;

    r$k(android.ext.r rVar, android.os.Bundle bundle) {
        this.f1226c = rVar;
        this.f1225b = bundle;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1.d(this + ": 200");
        if (!this.f1224a) {
            this.f1224a = true;
            this.f1226c.B(this.f1225b);
        } else {
            android.ext.e1.d(this + ": already");
        }
    }
}

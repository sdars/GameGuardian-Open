package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f1399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f1400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1401c;

    z$h(android.app.Activity activity, boolean z, int i) {
        this.f1399a = activity;
        this.f1400b = z;
        this.f1401c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.z.o(this.f1399a, this.f1400b, this.f1401c);
    }
}

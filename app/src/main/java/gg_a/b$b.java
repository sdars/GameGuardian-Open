package gg_a;

/* JADX INFO: loaded from: classes.dex */
class b$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f12a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.content.Intent f13b;

    b$b(android.content.Context context, android.content.Intent intent) {
        this.f12a = context;
        this.f13b = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f12a.startActivity(this.f13b);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed startActivity from UI thread: " + this.f13b, th);
        }
    }
}

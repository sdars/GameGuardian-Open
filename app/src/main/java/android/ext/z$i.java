package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f1402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface f1403b;

    z$i(android.app.Activity activity, android.content.DialogInterface dialogInterface) {
        this.f1402a = activity;
        this.f1403b = dialogInterface;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.z.D(this.f1402a, this.f1403b);
    }
}

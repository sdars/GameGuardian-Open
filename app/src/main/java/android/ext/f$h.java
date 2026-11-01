package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$h implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog.Builder f776a;

    f$h(android.app.AlertDialog.Builder alertDialog$Builder) {
        this.f776a = alertDialog$Builder;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f.q(this.f776a, null);
    }
}

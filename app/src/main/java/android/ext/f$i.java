package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$i implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog.Builder f777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.EditText f778b;

    f$i(android.app.AlertDialog.Builder alertDialog$Builder, android.ext.EditText editText) {
        this.f777a = alertDialog$Builder;
        this.f778b = editText;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.f.n(this.f777a.create(), this.f778b);
    }
}

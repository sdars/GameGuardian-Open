package luaj;

/* JADX INFO: loaded from: classes.dex */
class a$a$b implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.a$a f1705a;

    a$a$b(luaj.a$a a_a) {
        this.f1705a = a_a;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        synchronized (this.f1705a.f1702a) {
            try {
                this.f1705a.f1702a.notify();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$f implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f$n f774a;

    f$f(android.ext.f$n f_n) {
        this.f774a = f_n;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.f774a.a();
    }
}

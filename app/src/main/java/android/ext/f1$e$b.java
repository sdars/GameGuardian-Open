package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$e$b implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f1$e f963a;

    f1$e$b(android.ext.f1$e f1_e) {
        this.f963a = f1_e;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.f963a.f961b.run();
    }
}

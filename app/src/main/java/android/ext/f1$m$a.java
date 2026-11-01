package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$m$a implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f1$m f977a;

    f1$m$a(android.ext.f1$m f1_m) {
        this.f977a = f1_m;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.f977a.f976b.run();
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z0$i implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f1411a;

    z0$i(android.app.AlertDialog alertDialog) {
        this.f1411a = alertDialog;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.z0.j(this.f1411a);
    }
}

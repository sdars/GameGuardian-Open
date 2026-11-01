package android.ext;

/* JADX INFO: loaded from: classes.dex */
class s1$f implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f1246a;

    s1$f(android.app.AlertDialog alertDialog) {
        this.f1246a = alertDialog;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.u1(this.f1246a);
    }
}

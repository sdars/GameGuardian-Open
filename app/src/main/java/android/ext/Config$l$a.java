package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$l$a implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f37a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Config$l f38b;

    Config$l$a(android.ext.Config$l config$l, android.app.AlertDialog alertDialog) {
        this.f38b = config$l;
        this.f37a = alertDialog;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.u1(this.f37a);
    }
}

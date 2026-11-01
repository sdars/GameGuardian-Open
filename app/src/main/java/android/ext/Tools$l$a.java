package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$l$a implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Tools$l f516b;

    Tools$l$a(android.ext.Tools$l tools$l, android.app.AlertDialog alertDialog) {
        this.f516b = tools$l;
        this.f515a = alertDialog;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.u1(this.f515a);
    }
}

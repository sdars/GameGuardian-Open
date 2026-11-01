package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$m implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.View.OnClickListener f75a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.app.AlertDialog f76b;

    ConfigListAdapter$m(android.view.View.OnClickListener view$OnClickListener, android.app.AlertDialog alertDialog) {
        this.f75a = view$OnClickListener;
        this.f76b = alertDialog;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f75a.onClick(this.f76b.getButton(-1));
    }
}

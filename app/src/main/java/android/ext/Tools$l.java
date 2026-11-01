package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$l implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f514b;

    Tools$l(java.lang.String str, int i) {
        this.f513a = str;
        this.f514b = i;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setMessage(android.ext.b2.g(this.f513a) + '\n' + android.ext.b2.f(this.f514b)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).create();
        android.ext.f.m(alertDialogCreate);
        android.ext.f.l(alertDialogCreate, new android.ext.Tools$l$a(this, alertDialogCreate));
    }
}

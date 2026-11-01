package android.ext;

/* JADX INFO: loaded from: classes.dex */
class d0$d implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface.OnClickListener f710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.d0 f711c;

    d0$d(android.ext.d0 d0Var, java.lang.String str, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        this.f711c = d0Var;
        this.f709a = str;
        this.f710b = dialogInterface$OnClickListener;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f711c.j(this.f709a, this.f710b);
    }
}

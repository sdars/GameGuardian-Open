package android.ext;

/* JADX INFO: loaded from: classes.dex */
class d0$c implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.d0 f708b;

    d0$c(android.ext.d0 d0Var, java.lang.String str) {
        this.f708b = d0Var;
        this.f707a = str;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1) {
            android.ext.Tools.A(this.f707a, true);
        } else {
            android.ext.MainService.instance.m.setCurrentTab(1);
            android.ext.MainService.instance.W.u(this.f707a);
        }
    }
}

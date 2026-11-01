package android.ext;

/* JADX INFO: loaded from: classes.dex */
class l0$e implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.l0 f1061a;

    l0$e(android.ext.l0 l0Var) {
        this.f1061a = l0Var;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f1061a.w.setVisibility(i == 3 ? 0 : 8);
    }
}

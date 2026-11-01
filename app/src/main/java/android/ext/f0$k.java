package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f0$k implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f0 f890a;

    f0$k(android.ext.f0 f0Var) {
        this.f890a = f0Var;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.ConfigListAdapter.b();
    }
}

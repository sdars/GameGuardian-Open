package android.ext;

/* JADX INFO: loaded from: classes.dex */
class o0$b$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f1148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.o0$b f1149b;

    o0$b$a(android.ext.o0$b o0_b, int i) {
        this.f1149b = o0_b;
        this.f1148a = i;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.MainService.instance.P();
        this.f1149b.onClick(null, this.f1148a);
    }
}

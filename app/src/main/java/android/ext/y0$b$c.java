package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y0$b$c implements android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditText f1345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.y0$b f1346b;

    y0$b$c(android.ext.y0$b y0_b, android.ext.EditText editText) {
        this.f1346b = y0_b;
        this.f1345a = editText;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.o1(this.f1345a);
        this.f1345a.requestFocus();
    }
}

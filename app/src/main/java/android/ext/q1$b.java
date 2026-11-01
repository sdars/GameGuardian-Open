package android.ext;

/* JADX INFO: loaded from: classes.dex */
class q1$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.q1 f1203a;

    q1$b(android.ext.q1 q1Var) {
        this.f1203a = q1Var;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            this.f1203a.f1198a.startActivity(new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(android.ext.Tools.removeNewLinesChars(this.f1203a.g()))));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed call activity", th);
        }
    }
}

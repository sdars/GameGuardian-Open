package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y0$b$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.y0$c f1342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.EditText f1343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.y0$b f1344c;

    y0$b$b(android.ext.y0$b y0_b, android.ext.y0$c y0_c, android.ext.EditText editText) {
        this.f1344c = y0_b;
        this.f1342a = y0_c;
        this.f1343b = editText;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f1344c.c(this.f1342a, this.f1343b.getText().toString(), true);
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class q0$b$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.CheckBox f1196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.q0$b f1197b;

    q0$b$b(android.ext.q0$b q0_b, android.widget.CheckBox checkBox) {
        this.f1197b = q0_b;
        this.f1196a = checkBox;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f1196a.setChecked(true);
    }
}

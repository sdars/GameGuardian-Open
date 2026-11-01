package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$z implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextSpeeds f106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f107b;

    ConfigListAdapter$z(android.ext.ConfigListAdapter configListAdapter, android.ext.EditTextSpeeds editTextSpeeds) {
        this.f107b = configListAdapter;
        this.f106a = editTextSpeeds;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.String strTrim = this.f106a.getText().toString().trim();
        android.ext.y0.b(strTrim, 16);
        android.ext.MainService.instance.k0.g(strTrim);
    }
}

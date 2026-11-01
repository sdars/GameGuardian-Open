package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$x implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextSpeeds f101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f102b;

    ConfigListAdapter$x(android.ext.ConfigListAdapter configListAdapter, android.ext.EditTextSpeeds editTextSpeeds) {
        this.f102b = configListAdapter;
        this.f101a = editTextSpeeds;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        this.f101a.setText(android.ext.d1.c());
    }
}

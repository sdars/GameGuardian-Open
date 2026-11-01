package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y2$b$b implements android.widget.CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.CheckBox f1372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.y2$b f1373b;

    y2$b$b(android.ext.y2$b y2_b, android.widget.CheckBox checkBox) {
        this.f1373b = y2_b;
        this.f1372a = checkBox;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        if (z) {
            return;
        }
        this.f1372a.setChecked(false);
    }
}

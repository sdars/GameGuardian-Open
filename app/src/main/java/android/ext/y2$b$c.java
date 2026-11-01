package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y2$b$c implements android.widget.CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.CheckBox f1374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.y2$b f1375b;

    y2$b$c(android.ext.y2$b y2_b, android.widget.CheckBox checkBox) {
        this.f1375b = y2_b;
        this.f1374a = checkBox;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        if (z) {
            this.f1374a.setChecked(true);
        }
    }
}

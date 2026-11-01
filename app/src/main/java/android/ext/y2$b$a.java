package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y2$b$a implements android.text.TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.CheckBox f1369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.widget.CheckBox f1370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.y2$b f1371c;

    y2$b$a(android.ext.y2$b y2_b, android.widget.CheckBox checkBox, android.widget.CheckBox checkBox2) {
        this.f1371c = y2_b;
        this.f1369a = checkBox;
        this.f1370b = checkBox2;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        this.f1369a.setChecked(true);
        android.widget.CheckBox checkBox = this.f1370b;
        if (checkBox != null) {
            checkBox.setChecked(true);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }
}

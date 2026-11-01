package android.ext;

/* JADX INFO: loaded from: classes.dex */
class q0$b$a implements android.text.TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.CheckBox f1194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.q0$b f1195b;

    q0$b$a(android.ext.q0$b q0_b, android.widget.CheckBox checkBox) {
        this.f1195b = q0_b;
        this.f1194a = checkBox;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        this.f1194a.setChecked(true);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }
}

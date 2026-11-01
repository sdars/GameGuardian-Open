package android.ext;

/* JADX INFO: loaded from: classes.dex */
class l0$b implements android.text.TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.l0 f1058a;

    l0$b(android.ext.l0 l0Var) {
        this.f1058a = l0Var;
    }

    private void a() {
        this.f1058a.t.setChecked(true);
        this.f1058a.u();
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        a();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        a();
    }
}

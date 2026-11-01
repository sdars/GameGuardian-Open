package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y0$b$a implements android.text.TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.y0$b$e f1340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.y0$b f1341b;

    y0$b$a(android.ext.y0$b y0_b, android.ext.y0$b$e y0_b_e) {
        this.f1341b = y0_b;
        this.f1340a = y0_b_e;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        android.ext.y0$b$e y0_b_e = this.f1340a;
        android.ext.y0$b$d y0_b_d = y0_b_e.h;
        if (y0_b_d == null) {
            return;
        }
        this.f1341b.c(y0_b_d.f1347a, y0_b_e.f1351c.getText().toString(), false);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }
}

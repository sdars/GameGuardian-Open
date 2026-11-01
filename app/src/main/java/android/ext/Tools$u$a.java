package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$u$a implements android.text.TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Tools$u f545b;

    Tools$u$a(android.ext.Tools$u tools$u, android.widget.TextView textView) {
        this.f545b = tools$u;
        this.f544a = textView;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        onTextChanged(editable, 0, 0, 0);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        try {
            java.lang.String string = charSequence.toString();
            int i4 = 0;
            while (true) {
                java.lang.CharSequence[] charSequenceArr = this.f545b.f541b;
                if (i4 >= charSequenceArr.length) {
                    return;
                }
                if (charSequenceArr[i4].toString().equals(string)) {
                    android.widget.TextView textView = this.f544a;
                    android.ext.Tools$u tools$u = this.f545b;
                    android.ext.Tools.c(textView, tools$u.f542c[i4], tools$u.f543d);
                    return;
                }
                i4++;
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}

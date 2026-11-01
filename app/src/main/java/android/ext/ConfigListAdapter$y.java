package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$y implements android.ext.EditTextSpeeds$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextSpeeds f103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f105c;

    ConfigListAdapter$y(android.ext.ConfigListAdapter configListAdapter, android.ext.EditTextSpeeds editTextSpeeds, android.widget.TextView textView) {
        this.f105c = configListAdapter;
        this.f103a = editTextSpeeds;
        this.f104b = textView;
    }

    @Override // android.ext.EditTextSpeeds$a
    public void a(android.ext.EditText editText, int i, int i2) {
        c();
    }

    @Override // android.ext.EditTextSpeeds$a
    public void b(android.ext.EditText editText, java.lang.CharSequence charSequence, int i, int i2, int i3) {
        c();
    }

    public void c() {
        java.lang.String strL1;
        android.ext.EditTextSpeeds editTextSpeeds = this.f103a;
        if (editTextSpeeds == null || this.f104b == null) {
            strL1 = "?";
        } else {
            try {
                java.lang.String strTrim = editTextSpeeds.getText().toString().trim();
                int selectionStart = this.f103a.getSelectionStart();
                if (selectionStart < 0) {
                    selectionStart = 0;
                }
                if (selectionStart >= strTrim.length()) {
                    selectionStart = strTrim.length() - 1;
                }
                int i = -1;
                int iLastIndexOf = selectionStart <= 0 ? -1 : strTrim.lastIndexOf(59, selectionStart - 1);
                if (iLastIndexOf >= 0) {
                    i = iLastIndexOf;
                }
                int iIndexOf = strTrim.indexOf(59, selectionStart);
                if (iIndexOf < 0) {
                    iIndexOf = strTrim.length();
                }
                double dJ1 = android.ext.Tools.j1(strTrim.substring(i + 1, iIndexOf));
                if (dJ1 > 0.0d) {
                    android.ext.d1$a d1_aD = android.ext.d1.d(dJ1);
                    strL1 = android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.speed_info), android.ext.Tools.g1(d1_aD.f719b), android.ext.Tools.g1(d1_aD.f718a));
                } else {
                    strL1 = "??";
                }
            } catch (java.lang.NumberFormatException unused) {
                strL1 = "???";
            }
        }
        this.f104b.setText(strL1);
    }
}

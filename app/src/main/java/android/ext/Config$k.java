package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$k extends android.ext.Config$s {
    Config$k(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, iArr, i3, str, z);
    }

    private java.lang.String l(java.lang.String str) {
        java.util.Locale localeD;
        try {
            if (str.length() == 0) {
                localeD = android.ext.k.c();
                str = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.default_);
            } else {
                localeD = android.ext.k.d(str);
            }
            java.lang.String str2 = "";
            try {
                str2 = java.lang.String.format(localeD, "\n[%,.1f | %.2e]", java.lang.Double.valueOf(-1234.0d), java.lang.Double.valueOf(-4.56E-78d));
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
            return str + str2;
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
            return str;
        }
    }

    private java.lang.String[] m() {
        return new java.lang.String[]{"", "en_US", "in_ID", "ru_RU"};
    }

    @Override // android.ext.Config$p
    protected void d() {
        if (this.f42d <= 0) {
            return;
        }
        java.lang.String[] strArrM = m();
        int i = this.f42d;
        if (i >= strArrM.length) {
            return;
        }
        android.ext.k.j(android.ext.k.d(strArrM[i]));
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        boolean zE = super.e(dialogInterface, i);
        if (zE) {
            android.ext.ConfigListAdapter.m();
        }
        return zE;
    }

    @Override // android.ext.Config$s
    protected void i() {
        super.i();
        if (this.l == null) {
            java.lang.String[] strArrM = m();
            java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[strArrM.length];
            for (int i = 0; i < strArrM.length; i++) {
                charSequenceArr[i] = l(strArrM[i]);
            }
            this.l = charSequenceArr;
        }
    }
}

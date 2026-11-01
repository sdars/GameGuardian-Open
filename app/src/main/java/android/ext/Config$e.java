package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$e extends android.ext.Config$OptionMultiChoice {
    Config$e(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, iArr, i3, str, z);
    }

    @Override // android.ext.Config$s
    protected void i() {
        super.i();
        if (this.m == null) {
            java.lang.String str = " (" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.slow) + ')';
            this.m = new int[]{1, 2, 4, 8};
            this.l = new java.lang.CharSequence[]{1 + str, 2 + str, 3 + str, 4 + str};
            this.k = null;
            if (this.j == null) {
                this.j = new android.ext.Config$e$a(this);
            }
        }
    }
}

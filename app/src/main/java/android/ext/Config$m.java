package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$m extends android.ext.Config$s {
    Config$m(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, iArr, i3, str, z);
    }

    private java.lang.String l(int i) {
        if (i == Integer.MAX_VALUE) {
            return android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes);
        }
        if (i == 0) {
            return android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no);
        }
        return android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.first_mb), java.lang.Integer.valueOf(java.lang.Math.round((i * 5.0f) / 1024.0f)));
    }

    @Override // android.ext.Config$s
    protected void i() {
        super.i();
        if (this.m == null) {
            int iE0 = android.ext.Tools.E0();
            int iFloor = iE0 > 0 ? ((int) java.lang.Math.floor(java.lang.Math.log(iE0 / 5.0f) / java.lang.Math.log(2.0d))) - 8 : 0;
            if (iFloor <= 0) {
                iFloor = 7;
            }
            if (iFloor >= 20) {
                iFloor = 20;
            }
            int i = iFloor + 2;
            int[] iArr = new int[i];
            java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[i];
            iArr[0] = 0;
            charSequenceArr[0] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no);
            int i2 = iFloor + 1;
            iArr[i2] = Integer.MAX_VALUE;
            charSequenceArr[i2] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes);
            java.lang.String strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.first_mb);
            for (int i3 = 1; i3 <= iFloor; i3++) {
                int i4 = 1 << (i3 + 8);
                iArr[i3] = i4;
                charSequenceArr[i3] = android.ext.Tools.L1(strF, java.lang.Integer.valueOf(java.lang.Math.round((i4 * 5.0f) / 1024.0f)));
            }
            this.m = iArr;
            this.l = charSequenceArr;
            this.k = null;
        }
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public java.lang.String toString() {
        return android.ext.Tools.N1(this.f39a) + ": " + l(this.f42d);
    }
}

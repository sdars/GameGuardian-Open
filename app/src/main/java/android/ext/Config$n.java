package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$n extends android.ext.Config$s {
    Config$n(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, iArr, i3, str, z);
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public void b() {
        if (android.ext.f1.y()) {
            super.b();
        }
    }

    @Override // android.ext.Config$s
    protected void i() {
        super.i();
        int length = android.ext.Config.f28a.length;
        int[] iArr = this.m;
        if (iArr == null || iArr.length != length + 1) {
            int i = length + 1;
            int[] iArr2 = new int[i];
            java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[i];
            int i2 = 0;
            iArr2[0] = 0;
            charSequenceArr[0] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no);
            while (i2 < length) {
                int i3 = android.ext.Config.f28a[i2];
                i2++;
                iArr2[i2] = i3;
                charSequenceArr[i2] = android.ext.Config.f(i3);
            }
            this.m = iArr2;
            this.l = charSequenceArr;
            this.k = null;
        }
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public java.lang.String toString() {
        return android.ext.Tools.N1(this.f39a) + ": " + android.ext.Config.f(this.f42d);
    }
}

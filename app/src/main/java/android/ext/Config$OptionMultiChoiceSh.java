package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Config$OptionMultiChoiceSh extends android.ext.Config$OptionMultiChoice {
    private final int o;

    public Config$OptionMultiChoiceSh(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z, int i4) {
        super(i, i2, iArr, i3, str, z);
        this.o = i4;
    }

    @Override // android.ext.Config$OptionMultiChoice, android.ext.Config$s, android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        boolean zE = super.e(dialogInterface, i);
        if (zE) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.need_restart);
        }
        return zE;
    }

    @Override // android.ext.Config$s
    protected void i() {
        super.i();
        if (this.m == null) {
            int i = this.o;
            int[] iArr = new int[i];
            java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[i];
            int i2 = 0;
            while (i2 < i) {
                iArr[i2] = 1 << i2;
                int i3 = i2 + 1;
                charSequenceArr[i2] = java.lang.Integer.toString(i3);
                i2 = i3;
            }
            this.m = iArr;
            this.l = charSequenceArr;
            this.k = null;
        }
    }
}

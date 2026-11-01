package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$c extends android.ext.Config$OptionMultiChoice {
    Config$c(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z, int i4) {
        super(i, i2, iArr, i3, str, z, i4);
    }

    @Override // android.ext.Config$s
    protected void i() {
        super.i();
        if (this.j == null) {
            this.j = new android.ext.Config$c$a(this);
        }
        l(true);
    }
}

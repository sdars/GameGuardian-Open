package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Config$s extends android.ext.Config$p {
    int[] k;
    java.lang.CharSequence[] l;
    int[] m;

    public Config$s(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, i3, str, z);
        this.l = null;
        this.m = null;
        this.k = iArr;
    }

    public Config$s(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z, int i4) {
        this(i, i2, iArr, i3, str, z);
        this.h = i4;
    }

    @Override // android.ext.Config$p
    public void b() {
        i();
        java.lang.CharSequence[] charSequenceArr = this.l;
        int[] iArr = this.k;
        if (iArr != null) {
            charSequenceArr = new java.lang.CharSequence[iArr.length];
            int i = 0;
            while (true) {
                int[] iArr2 = this.k;
                if (i >= iArr2.length) {
                    break;
                }
                charSequenceArr[i] = android.ext.b2.f(iArr2[i]);
                i++;
            }
        }
        j(charSequenceArr);
    }

    @Override // android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        this.f42d = h(i);
        android.ext.Config.k();
        android.ext.Tools.D(dialogInterface);
        return true;
    }

    public int h(int i) {
        i();
        int[] iArr = this.m;
        return iArr == null ? i : iArr[i];
    }

    protected void i() {
    }

    protected void j(java.lang.CharSequence[] charSequenceArr) {
        int iK = k(this.f40b);
        java.lang.CharSequence[] charSequenceArr2 = new java.lang.CharSequence[charSequenceArr.length];
        for (int i = 0; i < charSequenceArr.length; i++) {
            charSequenceArr2[i] = (i != iK || charSequenceArr[i] == null) ? charSequenceArr[i] : ((java.lang.Object) charSequenceArr[i]) + " (" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.default_mark) + ')';
        }
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Config.c(this.f39a, this.h, this.f45g)).setSingleChoiceItems(charSequenceArr2, k(this.f42d), this));
    }

    public int k(int i) {
        i();
        if (this.m == null) {
            return i;
        }
        int i2 = 1;
        while (true) {
            int[] iArr = this.m;
            if (i2 >= iArr.length) {
                return 0;
            }
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
    }

    @Override // android.ext.Config$p
    public java.lang.String toString() {
        java.lang.CharSequence charSequenceF;
        try {
            int iK = k(this.f42d);
            int[] iArr = this.k;
            charSequenceF = iArr != null ? android.ext.b2.f(iArr[iK]) : this.l[iK];
        } catch (java.lang.IndexOutOfBoundsException unused) {
            charSequenceF = null;
        }
        if (charSequenceF == null) {
            charSequenceF = "int:" + this.f42d;
        }
        return android.ext.Tools.N1(this.f39a) + ": " + ((java.lang.Object) charSequenceF);
    }
}

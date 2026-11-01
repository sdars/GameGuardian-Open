package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$a extends android.ext.Config$OptionMultiChoice {
    private java.lang.CharSequence[] o;
    private java.lang.CharSequence[] p;
    private int[] q;

    Config$a(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, iArr, i3, str, z);
    }

    @Override // android.ext.Config$p
    public java.lang.CharSequence a() {
        if (this.m == null) {
            i();
        }
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[this.m.length * 2];
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.m;
            if (i >= iArr.length) {
                return android.ext.Tools.x((java.lang.CharSequence[]) java.util.Arrays.copyOf(charSequenceArr, i2));
            }
            int i3 = iArr[i];
            if ((this.f42d & i3) == i3) {
                if (i2 > 0) {
                    charSequenceArr[i2] = ",";
                    i2++;
                }
                charSequenceArr[i2] = this.o[i];
                i2++;
            }
            i++;
        }
    }

    @Override // android.ext.Config$p
    protected void d() {
        this.f40b = 262207;
    }

    @Override // android.ext.Config$OptionMultiChoice, android.ext.Config$s, android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        android.ext.c2 c2Var;
        boolean zE = super.e(dialogInterface, i);
        if (zE && (c2Var = android.ext.MainService.instance.f216f) != null) {
            c2Var.write("gg.setRanges(");
            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f371a, this.f42d);
            c2Var.write(")\n");
        }
        return zE;
    }

    @Override // android.ext.Config$s
    protected void i() {
        super.i();
        if (this.m == null) {
            int iD0 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_good);
            int iD1 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_good);
            int iD2 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_good);
            int iD3 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_good);
            int iD4 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_good);
            int iD5 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_good);
            int iD6 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_good);
            int iD7 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_other);
            int iD8 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_other);
            int iD9 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_other);
            int iD10 = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_other);
            int[] iArr = {2, 1, 4, 8, 16, 262144, 32, 65536, 64, 524288, 1048576, -2080896, 131072, 16384, 32768};
            int[] iArr2 = {iD0, iD1, iD2, iD3, iD4, iD5, iD6, iD7, iD8, iD9, iD10, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_slow), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_bad), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_code), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.region_system_code)};
            java.lang.CharSequence[] charSequenceArr = {android.ext.Tools.t("Jh: Java heap", iD0), android.ext.Tools.t("Ch: C++ heap", iD1), android.ext.Tools.t("Ca: C++ alloc", iD2), android.ext.Tools.t("Cd: C++ .data", iD3), android.ext.Tools.t("Cb: C++ .bss", iD4), android.ext.Tools.t("PS: PPSSPP", iD5), android.ext.Tools.t("A: Anonymous", iD6), android.ext.Tools.t("J: Java", iD7), android.ext.Tools.t("S: Stack", iD8), android.ext.Tools.t("As: Ashmem", iD9), android.ext.Tools.t("V: Video", iD10), android.ext.Tools.t(android.ext.b2.g("O: Other (__slow__)"), iArr2[11]), android.ext.Tools.t(android.ext.b2.g("B: Bad (__dangerous__)"), iArr2[12]), android.ext.Tools.t(android.ext.b2.g("Xa: Code app (__dangerous__)"), iArr2[13]), android.ext.Tools.t(android.ext.b2.g("Xs: Code system (__dangerous__)"), iArr2[14])};
            java.lang.CharSequence[] charSequenceArr2 = new java.lang.CharSequence[15];
            for (int i = 0; i < 15; i++) {
                charSequenceArr2[i] = android.ext.Tools.t(charSequenceArr[i].toString().split(":")[0], iArr2[i]);
            }
            this.q = iArr2;
            this.m = iArr;
            this.p = charSequenceArr;
            this.o = charSequenceArr2;
            this.k = null;
            android.ext.RegionList.k(iArr, charSequenceArr2, iArr2);
        }
        java.lang.CharSequence[] charSequenceArr3 = new java.lang.CharSequence[this.m.length];
        java.lang.CharSequence[] charSequenceArr4 = this.p;
        android.content.Context contextF0 = android.ext.Tools.f0();
        for (int i2 = 0; i2 < charSequenceArr4.length; i2++) {
            java.lang.String string = charSequenceArr4[i2].toString();
            try {
                string = string + " [" + android.ext.Tools.U(contextF0, android.ext.RegionList.d(i2)) + ']';
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
                android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
            }
            charSequenceArr3[i2] = android.ext.Tools.t(string, this.q[i2]);
        }
        this.l = charSequenceArr3;
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$i extends android.ext.Config$s {
    Config$i(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z, int i4) {
        super(i, i2, iArr, i3, str, z, i4);
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        boolean zE = super.e(dialogInterface, i);
        if (zE && this.f42d == 3) {
            android.ext.f.o(android.ext.f.c(android.ext.Tools.f0()).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_faq_33_a)).setNegativeButton(catch_.me_.if_.you_.can_.R.string.ok, (android.content.DialogInterface.OnClickListener) null));
        }
        return zE;
    }
}

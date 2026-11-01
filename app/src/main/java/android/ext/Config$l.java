package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$l extends android.ext.Config$s {
    private int n;

    Config$l(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z, int i4) {
        super(i, i2, iArr, i3, str, z, i4);
        this.n = 0;
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        if (i < 0) {
            if (i == -2) {
                this.f42d = 0;
                android.ext.Config.k();
            }
            if (android.ext.Config.vSpaceReal && this.n != this.f42d) {
                android.ext.ConfigListAdapter.m();
            }
            return false;
        }
        this.n = this.f42d;
        boolean zE = super.e(dialogInterface, i);
        if (zE) {
            if (i == 1) {
                android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.Tools.f0()).setCustomTitle(android.ext.Tools.g0(this.f39a)).setMessage(android.ext.b2.f(this.h)).setPositiveButton(catch_.me_.if_.you_.can_.R.string.save, this).setNegativeButton(catch_.me_.if_.you_.can_.R.string.cancel, this).create();
                android.ext.f.m(alertDialogCreate);
                android.ext.f.l(alertDialogCreate, new android.ext.Config$l$a(this, alertDialogCreate));
            } else if (android.ext.Config.vSpaceReal && this.n != this.f42d) {
                android.ext.ConfigListAdapter.m();
            }
        }
        return zE;
    }
}

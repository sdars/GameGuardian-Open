package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Config$j extends android.ext.Config$s {
    Config$j(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, iArr, i3, str, z);
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        boolean zE = super.e(dialogInterface, i);
        if (zE) {
            android.ext.MainService.instance.j.z();
        }
        return zE;
    }
}

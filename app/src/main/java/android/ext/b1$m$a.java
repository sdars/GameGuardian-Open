package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b1$m$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.b1$m f627a;

    b1$m$a(android.ext.b1$m b1_m) {
        this.f627a = b1_m;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i != -1) {
            android.ext.b1.k(false);
            return;
        }
        android.ext.b1$c0 b1_c0J0 = android.ext.b1.j0();
        b1_c0J0.l = 0;
        b1_c0J0.m = false;
        android.ext.b1.z1();
    }
}

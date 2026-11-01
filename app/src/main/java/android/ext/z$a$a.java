package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$a$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.z$a f1386a;

    z$a$a(android.ext.z$a z_a) {
        this.f1386a = z_a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        boolean zX;
        android.content.Intent intent = new android.content.Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(android.net.Uri.parse("package:" + android.ext.Tools.C0()));
        synchronized (android.ext.z.class) {
            try {
                zX = android.ext.z.x();
                if (zX) {
                    android.ext.z.g();
                    android.ext.s1.x();
                }
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        try {
            this.f1386a.f1383a.startActivityForResult(intent, 0);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Failed call intent", th2);
            if (zX) {
                android.ext.s1.g();
            }
        }
    }
}

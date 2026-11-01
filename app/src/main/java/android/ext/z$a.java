package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f1383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f1384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f1385c;

    z$a(android.app.Activity activity, boolean z, int i) {
        this.f1383a = activity;
        this.f1384b = z;
        this.f1385c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            synchronized (android.ext.z.class) {
                try {
                    if (android.ext.z.j(this.f1383a) && (!this.f1384b || android.ext.z.s(this.f1385c, true))) {
                        android.app.AlertDialog alertDialogCreate = android.ext.f.c(this.f1383a).setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.floating_window_fail)).setMessage(catch_.me_.if_.you_.can_.R.string.enable_draw_perm).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), new android.ext.z$a$b(this)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.z$a$a(this)).create();
                        android.ext.f.k(alertDialogCreate, new android.ext.z$a$c(this));
                        if (android.ext.z.r(this.f1383a, this.f1384b, this.f1385c, alertDialogCreate)) {
                            android.ext.f.w(alertDialogCreate);
                            return;
                        }
                        return;
                    }
                    android.ext.z.q(this.f1383a);
                } catch (java.lang.Throwable th_c_c_c) {
                    throw th_c_c_c;
                }
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Failed show float dialog", th2);
            android.ext.z.q(this.f1383a);
            if (this.f1384b && android.ext.z.x()) {
                android.ext.z.F();
            }
        }
    }
}

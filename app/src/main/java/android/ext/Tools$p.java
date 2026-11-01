package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$p implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.view.WindowManager.LayoutParams f531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.view.View f532c;

    Tools$p(boolean z, android.view.WindowManager.LayoutParams windowManager$LayoutParams, android.view.View view) {
        this.f530a = z;
        this.f531b = windowManager$LayoutParams;
        this.f532c = view;
    }

    @Override // java.lang.Runnable
    public void run() {
/* gg-shared-throwable */ java.lang.Throwable e = null;
        android.ext.Tools.p();
        try {
            if (this.f530a) {
                android.ext.MainService.instance.l.addView(this.f532c, this.f531b);
            } else {
                android.ext.MainService.instance.l.updateViewLayout(this.f532c, this.f531b);
            }
        } catch (android.view.WindowManager.BadTokenException e2_c_c_c) {
            java.lang.String message = e2_c_c_c.getMessage();
            if (!android.ext.m2.f1074a || message == null || !message.contains("permission denied") || this.f531b.type == android.ext.m2.c()) {
                throw e2_c_c_c;
            }
            android.view.WindowManager.LayoutParams windowManager$LayoutParams = this.f531b;
            int i = windowManager$LayoutParams.type;
            windowManager$LayoutParams.type = android.ext.m2.c();
            try {
                if (this.f530a) {
                    android.ext.MainService.instance.l.addView(this.f532c, this.f531b);
                } else {
                    android.ext.MainService.instance.l.updateViewLayout(this.f532c, this.f531b);
                }
            } catch (android.view.WindowManager.BadTokenException e3_c_c_c) {
                this.f531b.type = i;
                throw e3_c_c_c;
            }
        } catch (java.lang.IllegalArgumentException e4) {
            e = e4;
            android.ext.e1.s("Fail", e);
        } catch (java.lang.NullPointerException e5) {
            android.ext.e1.a(e5);
        } catch (java.lang.Throwable th) {
            e = th;
            android.ext.e1.s("Fail", e);
        }
        if (this.f530a) {
            android.ext.Tools.S(this.f532c);
        }
    }
}

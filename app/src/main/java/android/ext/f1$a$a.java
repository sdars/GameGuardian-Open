package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$a$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.f1$a f955a;

    f1$a$a(android.ext.f1$a f1_a) {
        this.f955a = f1_a;
    }

    @Override // java.lang.Runnable
    public void run() {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        boolean zStartInstrumentation = false;
        boolean z;
        try {
            if (!android.ext.Config.vSpaceReal && android.ext.Config.z == 0) {
                android.content.ComponentName componentNameU = android.ext.f1.u();
                if (componentNameU != null) {
                    android.ext.e1.d("Try instr: " + android.os.Process.myUid());
                    android.ext.f1.f((byte) 0);
                    try {
                        zStartInstrumentation = android.ext.r.p.startInstrumentation(componentNameU, null, android.ext.r.u());
                        android.ext.f1.f((byte) 1);
                        android.ext.e1.d("Fail instr: " + android.os.Process.myUid());
                    } catch (java.lang.Throwable th_c) {
                        th = th_c;
                        z = true;
                        android.ext.e1.l("Failed load Instrumentation", th_c);
                        if (z) {
                            android.ext.f1.f((byte) 1);
                        }
                    }
                }
                android.ext.f1.B(3, "" + zStartInstrumentation + ' ' + android.ext.Config.z);
                android.ext.f1.B(6, null);
                android.ext.f1.I();
            }
            android.ext.f1.i();
            zStartInstrumentation = false;
            android.ext.f1.B(3, "" + zStartInstrumentation + ' ' + android.ext.Config.z);
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        android.ext.f1.B(6, null);
        android.ext.f1.I();
    }
}

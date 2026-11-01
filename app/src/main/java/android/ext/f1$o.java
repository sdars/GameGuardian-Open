package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$o implements java.lang.Runnable {
    f1$o() {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            android.content.Context contextF0 = android.ext.Tools.f0();
            android.content.ComponentName componentNameU = android.ext.f1.u();
            android.ext.e1$e.a("AndroidService", "Restart: true " + android.ext.Config.z + ' ' + componentNameU);
            if (!android.ext.Config.vSpaceReal && android.ext.Config.z == 0 && componentNameU != null && contextF0.startInstrumentation(componentNameU, null, android.ext.r.u())) {
                android.ext.e1$e.a("AndroidService", "Restart 1");
            }
            android.ext.e1$e.a("AndroidService", "Restart 2");
            java.lang.String strC0 = android.ext.Tools.C0();
            java.lang.String strT = android.ext.r.t();
            android.ext.Tools.w1(200, new android.content.ComponentName(strC0, strT), 1);
            android.content.Intent intentN0 = android.ext.Tools.N0(contextF0, strC0, strT);
            android.ext.e1.d("Restart: " + intentN0);
            ((android.app.AlarmManager) contextF0.getSystemService("alarm")).set(1, java.lang.System.currentTimeMillis() + 1000, android.app.PendingIntent.getActivity(contextF0, 123456, intentN0, 268435456));
            android.ext.f1.n();
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException("Failed restart", th);
        }
    }
}

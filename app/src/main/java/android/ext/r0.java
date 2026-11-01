package android.ext;

/* JADX INFO: loaded from: classes.dex */
public final class r0 {
    public r0(boolean z) {
        if (z) {
            new android.ext.g0(new android.ext.r0$a(this), "FloatCheck").start();
        } else {
            a();
        }
    }

    private void b(java.lang.String str) {
        android.ext.e1.d("FloatCheck: float off by " + str);
        android.ext.m2.f1074a = false;
    }

    private void c() {
        java.lang.String line;
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(android.ext.Tools.I(new java.lang.String[]{"getprop"}).getInputStream()));
            do {
                line = bufferedReader.readLine();
                if (line != null) {
                }
                bufferedReader.close();
            } while (!line.contains("ro.build.remixos.version"));
            android.ext.e1.d("Remix-detect: " + line);
            if (line.contains("[2.")) {
                b(line);
            }
            bufferedReader.close();
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Remix-detect", th);
        }
    }

    public static void d(boolean z) {
        new android.ext.g2().c("float-off", z, false).commit();
    }

    void a() {
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        if (!sharedPreferencesM0.contains("float-off")) {
            c();
        } else if (sharedPreferencesM0.getBoolean("float-off", false)) {
            b("pref");
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class r$g implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.r f1220b;

    r$g(android.ext.r rVar, java.lang.String str) {
        this.f1220b = rVar;
        this.f1219a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.String str;
        try {
            java.lang.String strV = android.ext.r.v();
            java.io.File file = new java.io.File(strV);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            android.ext.r.U(fileOutputStream, strV, this.f1219a);
            android.ext.Tools.q(file, 420);
            java.lang.String str2 = "chmod 0644 " + strV + " 2>&1 ; logcat -v threadtime -b main -b system *:V 2>&1 ; exit\n";
            if (strV.contains("/emulated/0")) {
                str2 = "chmod 0644 " + strV.replace("/emulated/0", "/emulated/legacy") + " 2>&1 ; " + str2;
            }
            java.lang.Process processQ = android.ext.e2.q(str2);
            java.io.InputStream inputStream = processQ.getInputStream();
            byte[] bArr = new byte[8192];
            if (android.ext.Tools.Z0(processQ)) {
                str = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record_logcat) + ": " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.error);
            } else {
                str = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record_logcat) + ": " + strV;
            }
            android.ext.Tools.J1(str);
            while (!java.lang.Thread.interrupted()) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    if (i == -1 && android.ext.Tools.Z0(processQ)) {
                        break;
                    }
                } else {
                    fileOutputStream.write(bArr, 0, i);
                    fileOutputStream.flush();
                }
            }
            fileOutputStream.close();
            android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record_logcat) + ": " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit));
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record_logcat) + "> " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.error));
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class e2$a implements java.util.concurrent.Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.String f753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean[] f754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ java.lang.StringBuilder f755d;

    e2$a(java.lang.String str, java.lang.String str2, boolean[] zArr, java.lang.StringBuilder sb) {
        this.f752a = str;
        this.f753b = str2;
        this.f754c = zArr;
        this.f755d = sb;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.String call() throws java.io.IOException {
        java.lang.String strH;
        android.ext.e1.d("cmd (" + this.f752a + ") start");
        if (!android.ext.Config.C || "" != (strH = this.f753b)) {
            strH = android.ext.e2.h(this.f753b);
        }
        android.ext.e1.d("su (" + strH + ") used");
        java.lang.Process processI = strH == "" ? android.ext.Tools.I(new java.lang.String[]{this.f752a}) : android.ext.e2.r(this.f752a, strH, true);
        if (processI == null) {
            android.ext.e1.i("cmd fail: " + android.ext.e2.f745a);
            return "cmd fail - got null";
        }
        this.f754c[0] = true;
        int iD0 = android.ext.Tools.D0(processI);
        android.ext.e2.f749e = iD0;
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processI.getInputStream()));
        while (true) {
            try {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                android.ext.e1.d("cmd (" + this.f752a + ") out: " + line);
                this.f755d.append(line);
                this.f755d.append('\n');
            } catch (java.lang.Throwable th_c_c_c) {
                bufferedReader.close();
                throw th_c_c_c;
            }
        }
        bufferedReader.close();
        try {
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            byte[] buf = new byte[4096];
            int n;
            while ((n = processI.getErrorStream().read(buf)) > 0) {
                baos.write(buf, 0, n);
            }
            android.ext.e2.diag("stderr of '" + this.f752a + "': [" + baos.toString("UTF-8") + "]");
        } catch (java.lang.Throwable th3) {
            android.ext.e2.diag("stderr read failed: " + th3);
        }
        this.f755d.append("exit code: ");try {

        this.f755d.append(processI.waitFor());
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        android.ext.e1.d("cmd (" + this.f752a + ") exit: " + processI.exitValue());
        if (iD0 > 0) {
            try {
                android.ext.e1.d("Kill at end: " + iD0);
                android.os.Process.killProcess(iD0);
                android.ext.e1.d("Kill at end: ok");
            } catch (java.lang.Throwable th2) {
                android.ext.e1.g("Failed kill at end", th2);
            }
        }
        android.ext.e2.f749e = 0;
        return null;
    }
}

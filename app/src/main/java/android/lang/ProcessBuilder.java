package android.lang;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessBuilder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f1454d = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String[] f1455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.io.File f1456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private java.util.Map f1457c;

    public ProcessBuilder(java.lang.String... strArr) {
        this.f1455a = strArr;
    }

    public static java.lang.Process c(java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) {
        if (!f1454d) {
            f1454d = true;
            android.ext.e0.l();
        }try {

        return new android.lang.ProcessBuilder(strArr).b(strArr2).a(file).d();
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    public static native boolean loaded();

    public android.lang.ProcessBuilder a(java.io.File file) {
        this.f1456b = file;
        return this;
    }

    android.lang.ProcessBuilder b(java.lang.String[] strArr) {
        if (strArr != null) {
            this.f1457c = android.lang.ProcessEnvironment.i(strArr.length);
            for (java.lang.String strReplaceFirst : strArr) {
                if (strReplaceFirst.indexOf(0) != -1) {
                    strReplaceFirst = strReplaceFirst.replaceFirst("\u0000.*", "");
                }
                int iIndexOf = strReplaceFirst.indexOf(61, 0);
                if (iIndexOf != -1) {
                    this.f1457c.put(strReplaceFirst.substring(0, iIndexOf), strReplaceFirst.substring(iIndexOf + 1));
                }
            }
        }
        return this;
    }

    public java.lang.Process d() throws java.io.IOException {
java.lang.Throwable e = null;
        java.lang.String[] strArr = (java.lang.String[]) this.f1455a.clone();
        for (java.lang.String str : strArr) {
            str.getClass();
        }
        java.lang.String str2 = strArr[0];
        java.lang.SecurityManager securityManager = java.lang.System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkExec(str2);
        }
        java.io.File file = this.f1456b;
        java.lang.String string = file == null ? null : file.toString();
        for (int i = 1; i < strArr.length; i++) {
            if (strArr[i].indexOf(0) >= 0) {
                throw new java.io.IOException("invalid null character in command");
            }
        }try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

            return android.lang.a.b(strArr, this.f1457c, string, false);
        } catch (java.io.IOException | java.lang.IllegalArgumentException e2) {
            e = e2;
            java.lang.String str3 = ": " + e.getMessage();
            if ((e instanceof java.io.IOException) && securityManager != null) {
                try {
                    securityManager.checkRead(str2);
                } catch (java.lang.SecurityException e3) {
                    e = e3;
                    str3 = "";
                }
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Cannot run program \"");
            sb.append(str2);
            sb.append('\"');
            sb.append(string != null ? " (in directory \"" + string + "\")" : "");
            sb.append(str3);
            throw new java.io.IOException(sb.toString(), e);
        }
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }
}

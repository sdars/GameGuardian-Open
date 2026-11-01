package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile java.lang.String f569f = ";;";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f568e = j();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final java.lang.String f566c = "bugged-packages";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final java.lang.String f567d = "bugged-uids";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f564a = "native_crash.txt";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final java.lang.String f565b = " _QAZ_WSX_EDC_RFV_TGB_YHN_UJM_ ";

    public static boolean a(java.lang.String str, java.lang.String str2) {
        boolean z = f568e;
        if (!z || android.ext.i.f1002d.equals(str)) {
            return false;
        }
        if (str.startsWith("uid:")) {
            if (str.equals("uid:" + android.os.Process.myUid())) {
                return false;
            }
        }
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("CNC[");
            sb.append(z ? '1' : '0');
            sb.append("] - n: ");
            sb.append(str2);
            sb.append("; ");
            sb.append(str);
            android.ext.e1.d(sb.toString());
            if (!z) {
                return true;
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(g());
            fileOutputStream.write(str.getBytes());
            fileOutputStream.write(f565b.getBytes());
            fileOutputStream.write((str2 + '\n' + android.ext.h0.c()).getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed n CNC", th);
            return true;
        }
    }

    public static void b(boolean z) {
        boolean z2 = f568e;
        if (z2 && z) {
            try {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("CNC[");
                sb.append(z2 ? '1' : '0');
                sb.append("] - x");
                android.ext.e1.d(sb.toString());
                if (z2) {
                    g().delete();
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("Failed x CNC", th);
            }
        }
    }

    public static java.lang.String[] c() {
        if (f568e) {
            java.lang.String strD = d();
            if (strD.length() > 0) {
                android.ext.e1.d("BUGGED_PACKAGES: " + strD);
                return strD.split(";");
            }
        }
        return gg_d.b.f1511a;
    }

    private static java.lang.String d() {
        java.lang.String strL = l(android.ext.Tools.M0().getString(f566c, ""));
        if (strL.length() > 0) {
            f569f = ';' + strL + ';';
        }
        return strL;
    }

    public static java.lang.String[] e() {
        if (f568e) {
            java.lang.String strF = f();
            if (strF.length() > 0) {
                android.ext.e1.d("BUGGED_UIDS: " + strF);
                return strF.split(";");
            }
        }
        return gg_d.b.f1511a;
    }

    private static java.lang.String f() {
        return l(android.ext.Tools.M0().getString(f567d, ""));
    }

    private static java.io.File g() {
        java.io.File file = new java.io.File(android.ext.Tools.q0(), android.os.Process.myPid() + f564a);
        try {
            file.getParentFile().mkdirs();
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed mkdirs CNC", th);
        }
        return file;
    }

    private static java.lang.String[] h() {
        java.io.File[] fileArrListFiles;
        java.io.File parentFile = g().getParentFile();
        if (parentFile == null || (fileArrListFiles = parentFile.listFiles()) == null) {
            return null;
        }
        int length = fileArrListFiles.length;
        java.lang.String[] strArr = new java.lang.String[length * 2];
        for (int i = 0; i < length; i++) {
            java.io.File file = fileArrListFiles[i];
            if (file != null && file.getName().endsWith(f564a)) {
                try {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                    byte[] bArr = new byte[java.lang.Math.min(((int) file.length()) + 8192, 102400)];
                    int i2 = fileInputStream.read(bArr);
                    fileInputStream.close();
                    if (i2 > 0) {
                        java.lang.String[] strArrSplit = new java.lang.String(bArr, 0, i2).split(f565b, 2);
                        if (strArrSplit.length == 2) {
                            int i3 = i * 2;
                            strArr[i3] = strArrSplit[0];
                            strArr[i3 + 1] = strArrSplit[1];
                        }
                    }
                } catch (java.lang.Throwable th) {
                    android.ext.e1.l("Failed read native crash", th);
                }
                file.delete();
            }
        }
        return strArr;
    }

    public static boolean i(java.lang.String str) {
        if (!f568e) {
            return false;
        }
        return f569f.contains(';' + str + ';');
    }

    private static boolean j() {
        java.lang.Throwable th;
        boolean z;
        boolean z2 = false;
        try {
            java.io.File file = new java.io.File("/system/lib/libandroidfw.so");
            if (file.exists()) {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                byte[] bytes = "_ZN7android12AssetManager10getPkgNameEPKc".getBytes();
                byte[] bArr = new byte[8192];
                int length = bytes.length;
                int i = 0;
                z = false;
                while (true) {
                    try {
                        int i2 = fileInputStream.read(bArr, i, 8192 - i);
                        if (i2 <= 0) {
                            break;
                        }
                        i += i2;
                        if (i >= length) {
                            int i3 = (i - length) + 1;
                            for (int i4 = 0; i4 < i3; i4++) {
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= length) {
                                        z = true;
                                        break;
                                    }
                                    if (bArr[i4 + i5] != bytes[i5]) {
                                        break;
                                    }
                                    i5++;
                                }
                            }
                            if (z) {
                                break;
                            }
                            int i6 = length - 1;
                            for (int i7 = 0; i7 < i6; i7++) {
                                bArr[i7] = bArr[(i - i6) + i7];
                            }
                            i = i6;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                }
                z2 = z;
                try {
                    fileInputStream.close();
                } catch (java.lang.Throwable th3) {
                    z = z2;
                    th = th3;
                    android.ext.e1.s("Failed detect CM13", th);
                    z2 = z;
                }
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            z = false;
        }
        android.ext.e1.d("CM13: " + z2);
        return z2;
    }

    public static void k() {
        android.ext.e1.d("lLC - 1");
        d();
        f();
        java.lang.String[] strArrH = h();
        if (strArrH != null) {
            int length = strArrH.length;
            for (int i = 0; i < length; i += 2) {
                java.lang.String str = strArrH[i];
                if (str != null) {
                    android.ext.e1.i("Bad package: '" + str + "' " + strArrH[i + 1]);
                    java.lang.String str2 = f566c;
                    if (str.contains("uid:")) {
                        str2 = f567d;
                        str = str.split(":", -1)[1];
                    }
                    android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
                    java.lang.String string = sharedPreferencesM0.getString(str2, "");
                    if (string != null && string.length() != 0) {
                        str = (';' + string + ';').contains(';' + str + ';') ? string : string + ';' + str;
                    }
                    sharedPreferencesM0.edit().putString(str2, l(str)).commit();
                }
            }
        }
        d();
        f();
        android.ext.e1.d("lLC - 0");
    }

    private static java.lang.String l(java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList(new java.util.HashSet(java.util.Arrays.asList(str.split(";"))));
        return android.text.TextUtils.join(";", arrayList.toArray(new java.lang.String[arrayList.size()]));
    }
}

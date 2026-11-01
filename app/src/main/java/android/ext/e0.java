package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class e0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile java.lang.String f725b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile java.lang.String f726c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile int f727d = 100;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile char f728e = 'i';

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile char f729f = 'g';

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static java.lang.StringBuilder f730g = new java.lang.StringBuilder();
    public static java.lang.StringBuilder h = new java.lang.StringBuilder();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String f731a = i();

    private static void a(java.util.ArrayList arrayList, java.lang.String str, java.lang.String str2, boolean z) {
        java.io.File file = new java.io.File(str);
        if (!z || file.exists()) {
            arrayList.add(new java.io.File(str + "/files", str2));
            arrayList.add(new java.io.File(str + "/cache", str2));
            arrayList.add(new java.io.File(str + "/files"));
            arrayList.add(new java.io.File(str + "/cache"));
            arrayList.add(file);
        }
    }

    private static void b(char c2) {
        c(java.lang.Character.toString(c2));
    }

    private static void c(java.lang.String str) {
        java.io.File file = new java.io.File(g(), r(str));
        if (file.isFile()) {
            return;
        }
        android.ext.e1.d("Extract file " + file);
        android.content.res.Resources resources = android.ext.Tools.f0().getResources();
        int iD = android.ext.b2.d("ydw" + str, "raw");
        if (iD == 0) {
            android.ext.e1.d("Nothing extract file " + str + ' ' + file.getAbsolutePath());
            return;
        }
        try {
            byte[] bArr = new byte[8192];
            java.io.InputStream inputStreamOpenRawResource = resources.openRawResource(iD);
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            while (true) {
                int i = inputStreamOpenRawResource.read(bArr);
                if (i <= 0) {
                    fileOutputStream.close();
                    inputStreamOpenRawResource.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("Failed extract file " + str + ' ' + file.getAbsolutePath(), th);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0017. Please report as an issue. */
    private void d(char c2) {
        char c3 = 0;
        b(c2);
        try {
            if (c2 != '5') {
                if (c2 != '7' && c2 != '8') {
                    if (c2 != 'a' && c2 != 'b') {
                        switch (c2) {
                            case '2':
                                c("01");
                                b('4');
                                b('f');
                                f729f = 'f';
                                b('k');
                            case '0':
                            case '1':
                                b('3');
                                b('e');
                                f728e = 'e';
                                c3 = 'j';
                                break;
                        }
                        android.ext.Tools.M("sh", new java.io.File(android.ext.Tools.q0(), "sh.jar"));
                        return;
                    }
                    b('d');
                    b('i');
                    f728e = 'i';
                    c3 = 'o';
                }
                b(c3);
                android.ext.Tools.M("sh", new java.io.File(android.ext.Tools.q0(), "sh.jar"));
                return;
            }
            c("08");
            b('6');
            b('g');
            f729f = 'g';
            b('l');
            android.ext.Tools.M("sh", new java.io.File(android.ext.Tools.q0(), "sh.jar"));
            return;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("JVM fail", th);
            return;
        }
    }

    private int e(java.lang.String str) {
        android.ext.Tools.j(str);
        for (int i = 0; i < 2; i++) {
            try {                if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                java.lang.String[] strArr = new java.lang.String[2];
                strArr[0] = android.ext.Tools.F0(str);
                strArr[1] = android.ext.Config.vSpaceReal ? android.ext.Config.E : "1";
                java.lang.Process processI = android.ext.Tools.I(strArr);
                if (android.ext.Tools.X1(processI, 30)) {
                    return processI.exitValue();
                }
                throw new java.lang.RuntimeException("timeout: 30");
            } catch (java.io.IOException e2) {
                if (i == 0) {
                    try {
                        java.lang.String message = e2.getMessage();
                        if (message != null && message.indexOf("denied") != -1) {
                            android.ext.Tools.r(str, "0755");
                        }
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.s("getArch: " + str, th);
                        h.append(th.toString());
                        return 100;
                    }
                }
                throw new java.lang.RuntimeException(e2);
            }
        }
        return 100;
    }

    public static int f() {
        h();
        return f727d;
    }

    public static java.lang.String g() {
        if (f726c == null) {
            java.io.File fileJ = j();
            if (fileJ == null) {
                fileJ = android.ext.Tools.q0();
            }
            f726c = s(fileJ.getAbsolutePath());
        }
        return f726c;
    }

    public static java.lang.String h() {
        if (f725b == null) {
            f725b = new android.ext.e0().f731a;
        }
        return f725b;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    /* JADX WARN: Code duplicated, block: B:28:0x0083  */
    /* JADX WARN: Code duplicated, block: B:31:0x008e  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:85:0x010a A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x0053, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x008e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x00d0, please report this as an issue */
    private java.lang.String i() {
        java.lang.String str;
        java.io.File file;
        int iE;
        char[] cArr = {0, '2', '1', '5', '8', 'b', '0', '7', 'a'};
        java.lang.String strG = g();
        boolean z = true;
        char c2 = (android.ext.Config.C && (android.ext.Config.G == 1 || (android.ext.Config.G == 0 && android.ext.Config.E.contains("64")))) ? (char) 0 : (char) 2;
        for (int i = 0; i < cArr.length; i++) {
            if (i == 0) {
                for (int i2 = 1; i2 < cArr.length; i2++) {
                    if (new java.io.File(strG, q(cArr[i2])).exists()) {
                        cArr[0] = cArr[i2];
                        break;
                    }
                }
                if (cArr[0] == 0) {
                    continue;
                } else {
                    h.append(cArr[i]);
                    h.append(": ");
                    str = "0" + cArr[i];
                    file = new java.io.File(strG, r(str));
                    if (!file.isFile()) {
                        c(str);
                    }
                    if (file.isFile()) {
                        f730g.append(cArr[i]);
                        iE = e(file.getAbsolutePath());
                        if (!o(cArr[i], iE)) {
                            if (iE != 105 && iE != 102) {
                                z = false;
                            }
                            android.ext.InOut.p(z);
                            f730g = new java.lang.StringBuilder(0);
                            h = new java.lang.StringBuilder(0);
                            java.lang.String absolutePath = new java.io.File(strG, q(cArr[i])).getAbsolutePath();
                            android.ext.e1.d("Daemon: " + absolutePath);
                            f727d = iE;
                            d(cArr[i]);
                            android.ext.Tools.j(absolutePath);
                            return absolutePath;
                        }
                        android.ext.e1.d("getArch " + cArr[i] + ' ' + iE);
                        h.append("; ");
                        h.append(iE);
                        h.append('\n');
                        if (c2 != 0 && (iE & 127) < 100) {
                            c2 = 1;
                        }
                    } else {
                        h.append(file);
                        h.append(" NF.\n");
                        android.ext.e1.d("Not a file " + file + ' ' + file.getAbsolutePath());
                    }
                }
            } else {
                h.append(cArr[i]);
                h.append(": ");
                str = "0" + cArr[i];
                file = new java.io.File(strG, r(str));
                if (!file.isFile()) {
                    c(str);
                }
                if (file.isFile()) {
                    h.append(file);
                    h.append(" NF.\n");
                    android.ext.e1.d("Not a file " + file + ' ' + file.getAbsolutePath());
                } else {
                    f730g.append(cArr[i]);
                    iE = e(file.getAbsolutePath());
                    if (!o(cArr[i], iE)) {
                        if (iE != 105) {
                            z = false;
                        }
                        android.ext.InOut.p(z);
                        f730g = new java.lang.StringBuilder(0);
                        h = new java.lang.StringBuilder(0);
                        java.lang.String absolutePath2 = new java.io.File(strG, q(cArr[i])).getAbsolutePath();
                        android.ext.e1.d("Daemon: " + absolutePath2);
                        f727d = iE;
                        d(cArr[i]);
                        android.ext.Tools.j(absolutePath2);
                        return absolutePath2;
                    }
                    android.ext.e1.d("getArch " + cArr[i] + ' ' + iE);
                    h.append("; ");
                    h.append(iE);
                    h.append('\n');
                    if (c2 != 0) {
                    }
                }
            }
        }
        if (c2 == 1) {
            try {
                java.io.File file2 = new java.io.File(android.ext.Tools.K0());
                if (n(file2)) {
                    file2 = android.ext.Tools.f0().getExternalCacheDir();
                    if (n(file2)) {
                        file2 = android.ext.Tools.f0().getExternalFilesDir(null);
                        if (n(file2)) {
                            file2 = new java.io.File("/sdcard");
                        }
                    }
                }
                java.io.File file3 = new java.io.File(file2, "gg_fixer.apk");
                if (file3.exists()) {
                    file3.delete();
                }
                android.ext.Tools.M("fx", file3);
                android.ext.n2.i(new android.ext.e0$a(this, file3));
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed extract fx", th);
            }
        }
        f730g.append(';');
        java.lang.String strF0 = android.ext.Tools.F0(strG);
        java.lang.String[] strArr = {"ls", "-l", strF0};
        try {
            h.append("\n\n");
            h.append("ls -l ");
            h.append(strF0);
            h.append(":\n");
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(android.ext.Tools.I(strArr).getInputStream()));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.indexOf("lib") != -1 && line.indexOf(".so") != -1) {
                    android.ext.e1.d("ls: " + line);
                    h.append(line);
                    h.append('\n');
                }
            }
            bufferedReader.close();
        } catch (java.lang.Exception e2) {
            android.ext.e1.s("ls: " + strF0, e2);
            h.append(e2);
            h.append('\n');
        }
        h.append('\n');
        return "no_binary_for_your_arch";
    }

    private static java.io.File j() {
        java.io.File fileP0 = android.ext.Tools.p0();
        java.io.File fileB0 = android.ext.Tools.b0();
        java.lang.String strS0 = android.ext.Tools.s0();
        java.util.ArrayList<java.io.File> arrayList = new java.util.ArrayList(64);
        arrayList.add(android.ext.Tools.q0());
        arrayList.add(android.ext.Tools.c0());
        arrayList.add(fileP0);
        arrayList.add(fileB0);
        arrayList.add(new java.io.File(fileP0.getParentFile(), strS0));
        arrayList.add(new java.io.File(fileB0.getParentFile(), strS0));
        arrayList.add(fileP0.getParentFile());
        arrayList.add(fileB0.getParentFile());
        java.lang.String absolutePath = fileP0.getAbsolutePath();
        java.lang.String str = absolutePath.startsWith("/data/user/") ? absolutePath.split("/", -1)[3] : "0";
        java.lang.String str2 = absolutePath.startsWith("/data/user/") ? "/data/user/" + str + "/" : "/data/data/";
        if (android.ext.Config.vSpaceReal) {
            java.lang.String str3 = str2 + android.ext.Config.E;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str3);
            sb.append("/parallel_intl/0/");
            java.lang.String str4 = android.ext.i.f1002d;
            sb.append(str4);
            a(arrayList, sb.toString(), strS0, true);
            a(arrayList, str3 + "/parallel_lite/0/" + str4, strS0, true);
            a(arrayList, str3 + "/parallel_pro/0/" + str4, strS0, true);
            a(arrayList, str3 + "/virtual/data/user/0/" + str4, strS0, true);
            a(arrayList, str3 + "/gaia/data/user/0/" + str4, strS0, true);
            a(arrayList, str3 + "/com.vmos.glb/osimg/r/ot01/data/data/" + str4, strS0, true);
            a(arrayList, str3 + "/mopen/data/user/0/" + str4, strS0, true);
            a(arrayList, str3 + "/vbox/data/user/0/" + str4, strS0, true);
            a(arrayList, str3 + "/sandboxdata/" + str4, strS0, true);
            a(arrayList, str3 + "/gameplugins/" + str4, strS0, true);
            a(arrayList, str3 + "/Plugin/0/" + str4 + "/data/" + str4, strS0, true);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("/data/user_de/");
            sb2.append(str);
            sb2.append("/");
            sb2.append(android.ext.Config.E);
            a(arrayList, sb2.toString(), strS0, false);
            a(arrayList, str3, strS0, false);
        } else {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(str2);
            java.lang.String str5 = android.ext.i.f1002d;
            sb3.append(str5);
            a(arrayList, sb3.toString(), strS0, false);
            a(arrayList, "/data/user_de/" + str + "/" + str5, strS0, false);
            arrayList.add(new java.io.File("/data/data"));
            arrayList.add(new java.io.File("/data"));
        }
        for (java.io.File file : arrayList) {
            if (file != null) {
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (file.exists()) {
                    return file;
                }
                try {
                    java.lang.String absolutePath2 = file.getAbsolutePath();
                    try {
                        if ((android.system.Os.stat(absolutePath2).st_mode & 16384) != 0) {
                            return file;
                        }
                    } catch (java.lang.Exception e2) {
                        android.ext.e1.s(e2 instanceof android.system.ErrnoException ? "Errno for path '" + absolutePath2 + "': " + ((android.system.ErrnoException) e2).errno : "Exception for path '" + absolutePath2 + "'", e2);
                    }
                } catch (java.lang.Throwable th) {
                    android.ext.e1.a(th);
                }
            }
        }
        android.ext.e1.p("Failed get dir for fix");
        return null;
    }

    public static java.lang.String k(boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("/lib");
        sb.append(z ? f729f : f728e);
        sb.append(".so");
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:18:0x0044  */
    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:22:0x0070  */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0051, please report this as an issue */
    public static void l() {
java.lang.Throwable th = null;
        java.io.File file;
        java.lang.StringBuilder sb;
        java.lang.String str;
        char[] cArr = {0, 'q', 'p', 'r', 's', 't'};
        java.lang.String strG = g();
        for (int i = 0; i < cArr.length; i++) {
            if (i == 0) {
                for (int i2 = 1; i2 < cArr.length; i2++) {
                    if (new java.io.File(strG, q(cArr[i2])).exists()) {
                        cArr[0] = cArr[i2];
                        break;
                    }
                }
                if (cArr[0] == 0) {
                    continue;
                } else {
                    file = new java.io.File(strG, q(cArr[i]));
                    if (!file.isFile()) {
                        b(cArr[i]);
                    }
                    if (!file.isFile()) {
                        try {
                            java.lang.System.load(file.getAbsolutePath());
                            try {
                                android.lang.ProcessBuilder.loaded();
                                return;
                            } catch (java.lang.Throwable th_c) {
                                th = th_c;
                                sb = new java.lang.StringBuilder();
                                str = "Failed check ";
                                sb.append(str);
                                sb.append(file);
                                sb.append(' ');
                                sb.append(file.getAbsolutePath());
                                android.ext.e1.g(sb.toString(), th_c);
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            sb = new java.lang.StringBuilder();
                            str = "Failed load ";
                        }
                    } else {
                        android.ext.e1.d("Not a file " + file + ' ' + file.getAbsolutePath());
                    }
                }
            } else {
                file = new java.io.File(strG, q(cArr[i]));
                if (!file.isFile()) {
                    b(cArr[i]);
                }
                if (!file.isFile()) {
                    java.lang.System.load(file.getAbsolutePath());
                    android.lang.ProcessBuilder.loaded();
                    return;
                }
                android.ext.e1.d("Not a file " + file + ' ' + file.getAbsolutePath());
            }
        }
    }

    public static boolean m() {
        return f() == 105;
    }

    private boolean n(java.io.File file) {
        if (file == null) {
            return true;
        }
        if (file.exists()) {
            return false;
        }
        file.mkdirs();
        return !file.exists();
    }

    private boolean o(char c2, int i) {
        if (c2 != '5') {
            if (c2 != '7') {
                if (c2 != '8') {
                    if (c2 != 'a') {
                        if (c2 != 'b') {
                            switch (c2) {
                                case '0':
                                    if (101 != i) {
                                        return false;
                                    }
                                    break;
                                case '1':
                                    if (101 != i) {
                                        return false;
                                    }
                                    break;
                                case '2':
                                    if (102 != i) {
                                        return false;
                                    }
                                    break;
                                default:
                                    throw new java.lang.RuntimeException("Unknown lib: " + c2);
                            }
                        } else if (103 != i) {
                            return false;
                        }
                    } else if (103 != i) {
                        return false;
                    }
                } else if (104 != i) {
                    return false;
                }
            } else if (104 != i) {
                return false;
            }
        } else if (105 != i) {
            return false;
        }
        return true;
    }

    public static boolean p() {
        int iF = f();
        return iF == 101 || iF == 102;
    }

    private static java.lang.String q(char c2) {
        return r(java.lang.Character.toString(c2));
    }

    private static java.lang.String r(java.lang.String str) {
        return "lib" + str + ".so";
    }

    private static java.lang.String s(java.lang.String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'd'};
        for (int i = 0; i < 13; i++) {
            java.io.File file = new java.io.File(str, q(cArr[i]));
            if (file.exists()) {
                java.lang.String absolutePath = file.getAbsolutePath();
                if (!android.ext.Tools.j(absolutePath)) {
                    android.ext.e1.d("Can not execute " + absolutePath);
                }
            }
        }
        return str;
    }
}

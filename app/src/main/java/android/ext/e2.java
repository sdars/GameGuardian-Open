package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f745a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f746b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static java.lang.String f747c = "su";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final java.lang.String[] f748d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile int f749e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final java.lang.Object f750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f751g;
    private static int h;
    private static boolean i;
    private static android.ext.e2$c j;

    static {
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        f747c = sharedPreferencesM0.getString("su", "su");
        f746b = sharedPreferencesM0.getBoolean("sh", false);
        f748d = new java.lang.String[]{"/debug_ramdisk", "/sbin", "/su/bin", "/magisk/.core/bin", "/magisk/phh/bin", "/system/xbin"};
        f749e = 0;
        f750f = new java.lang.Object();
        f751g = false;
        h = 0;
        i = false;
    }

    private static java.lang.String b() {
        return c(new java.lang.String[]{"/debug_ramdisk", "/vendor/bin", "/system/bin", "/bin", "/data/local", "/data/local/bin", "/system/sd/bin", "/system/bin/failsafe", "/system/bin/bstk", "/su/bin", "/magisk/.core/bin", "/magisk/phh/bin"});
    }

    private static java.lang.String c(java.lang.String[] strArr) {
        java.util.ArrayList arrayList = new java.util.ArrayList(strArr.length * 3);
        for (java.lang.String str : strArr) {
            arrayList.add(str);
            if (str.contains("/bin")) {
                arrayList.add(str.replace("/bin", "/xbin"));
                arrayList.add(str.replace("/bin", "/sbin"));
            }
        }
        return android.text.TextUtils.join(":", arrayList);
    }

    static void d(int i2) {
        android.ext.e2$c e2_c;
        synchronized (f750f) {
            try {
                h = i2;
                f751g = true;
                i = false;
                e2_c = j;
                j = null;
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        if (e2_c != null) {
            e2_c.a(i2);
        }
    }

    private static java.lang.String e(java.lang.String str, java.io.InputStream inputStream) {
        byte[] bArr;
        int i2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(": ");
        try {
            int iAvailable = inputStream.available();
            if (iAvailable > 0 && (i2 = inputStream.read((bArr = new byte[iAvailable]))) > 0) {
                sb.append(new java.lang.String(java.util.Arrays.copyOf(bArr, i2)));
            }
        } catch (java.io.IOException e2) {
            sb.append(e2.toString());
        }
        sb.append('\n');
        return sb.toString();
    }

    private static java.lang.String[] f(boolean z) {
        java.lang.StringBuilder sb;
        java.util.Map<java.lang.String, java.lang.String> map = java.lang.System.getenv();
        int size = map.size();
        java.lang.String str = map.get("PATH");
        if (str == null) {
            size++;
        }
        java.lang.String[] strArr = new java.lang.String[size];
        int i2 = 0;
        for (java.util.Map.Entry<java.lang.String, java.lang.String> map$Entry : map.entrySet()) {
            java.lang.String key = map$Entry.getKey();
            java.lang.String value = map$Entry.getValue();
            if ("PATH".equals(key)) {
                if (z) {
                    sb = new java.lang.StringBuilder();
                    sb.append(m());
                    sb.append(':');
                    sb.append(b());
                    sb.append(':');
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append(value);
                    sb.append(':');
                    value = b();
                }
                sb.append(value);
                value = sb.toString();
            }
            strArr[i2] = key + '=' + value;
            i2++;
        }
        if (str == null) {
            strArr[i2] = "PATH=" + (z ? m() + ':' + b() : b());
        }
        return strArr;
    }

    public static java.lang.String g(java.lang.Process process) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (process != null) {
            sb.append(e("stdout", process.getInputStream()));
            sb.append(e("stderr", process.getErrorStream()));
            sb.append("exit value: ");
            try {
                sb.append(process.exitValue());
            } catch (java.lang.IllegalThreadStateException unused) {
                sb.append("already run");
            }
            sb.append('\n');
        } else {
            sb.append("process is null\n");
        }
        return sb.toString();
    }

    static java.lang.String h(java.lang.String str) {
        if (android.ext.Config.C) {
            return "sh";
        }
        return str != null ? str : f747c;
    }

    static void i(android.ext.e2$c e2_c) {
        synchronized (f750f) {
            try {
                if (f751g) {
                    e2_c.a(h);
                    return;
                }
                j = e2_c;
                if (i) {
                    return;
                }
                i = true;
                new android.ext.n0$i(new android.ext.e2$b(), "RootProbe").start();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    static android.ext.e2$d j(java.lang.String str) {try {

        return p("exec id", 20, str);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    static int k(java.lang.String str) {
        try {
            android.ext.e2$d e2_dJ = j(str);
            f745a = "";
            if (!e2_dJ.f758c) {
                android.ext.e1.d("root probe refused: no root shell could be started");
                return -1;
            }
            if (e2_dJ.f757b) {
                android.ext.e1.d("root probe unanswered: bound expired after 20s");
                return 0;
            }
            android.ext.e1.d("root probe: " + e2_dJ.f756a);
            return e2_dJ.f756a.contains("uid=0") ? 1 : 0;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed root probe", th);
            return 0;
        }
    }

    private static java.lang.String l() {
        for (java.lang.String str : f748d) {
            java.io.File file = new java.io.File(str, "su");
            if (file.isFile() && file.canExecute()) {
                android.ext.e1.d("absolute su fallback selected: " + str);
                return file.getAbsolutePath();
            }
        }
        android.ext.e1.d("no absolute su candidate usable; falling back to bare su");
        return "su";
    }

    private static java.lang.String m() {
        return c(new java.lang.String[]{"/debug_ramdisk", "/su/bin", "/magisk/.core/bin", "/magisk/phh/bin", "/system/xbin", "/system/sbin", "/system/bin/failsafe", "/system/bin/bstk", "/bin"});
    }

    public static java.lang.String n(java.lang.String str, int i2) {
        java.lang.String strO = o(str, i2, null);
        f745a = "";
        return strO;
    }

    public static java.lang.String o(java.lang.String str, int i2, java.lang.String str2) {try {

        return p(str, i2, str2).f756a;
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    private static android.ext.e2$d p(java.lang.String str, int i2, java.lang.String str2) throws java.lang.InterruptedException {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        boolean z = true;
        boolean[] zArr = {false};
        f749e = 0;
        java.util.concurrent.FutureTask futureTask = new java.util.concurrent.FutureTask(new android.ext.e2$a(str, str2, zArr, sb));
        new android.ext.n0$i(futureTask, "runCmd: " + str).start();
        try {
            futureTask.get(i2, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.util.concurrent.ExecutionException e2) {
            android.ext.e1.l("cmd (" + str + ") expection", e2);
            sb.append("expection: ");
            sb.append(e2.getMessage());
        } catch (java.util.concurrent.TimeoutException e3) {
            android.ext.e1.g("cmd (" + str + ") exit: timeout " + i2, e3);
            sb.append("timeout: ");
            sb.append(i2);
        }
        z = false;
        int i3 = f749e;
        if (i3 > 0) {
            try {
                android.ext.e1.d("Kill: " + i3);
                android.os.Process.killProcess(i3);
                android.ext.e1.d("Kill: ok");
            } catch (java.lang.Throwable th) {
                android.ext.e1.g("Failed kill", th);
            }
        }
        f749e = 0;
        return new android.ext.e2$d(sb.toString(), z, zArr[0]);
    }

    public static java.lang.Process q(java.lang.String str) {
        return r(str, null, false);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x015b A[LOOP:1: B:37:0x0159->B:38:0x015b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:42:0x0177 A[LOOP:0: B:19:0x00bd->B:42:0x0177, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:50:0x017b A[EDGE_INSN: B:50:0x017b->B:43:0x017b BREAK  A[LOOP:0: B:19:0x00bd->B:42:0x0177], SYNTHETIC] */
    public static java.lang.Process r(java.lang.String str, java.lang.String str2, boolean z) {
        java.lang.Throwable th = null;
        java.lang.String str3;
        java.lang.String str4 = null;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        android.ext.e1.d("try: " + str);
        if (!str.contains("exec") && !str.contains("exit")) {
            throw new java.lang.RuntimeException("You forgot exec or exit");
        }
        if (str.contains("/emulated/0")) {
            android.ext.e1.p("Possible bugged call to /emulated/0 from root: " + str);
        }
        sb.append("try: ");
        sb.append(str);
        sb.append('\n');
        java.lang.String strH = h(str2);
        sb.append("su: ");
        sb.append(strH);
        sb.append('\n');
        if (android.ext.Config.C || !f746b) {
            str3 = strH;
        } else {
            str = "exec " + strH + '\n' + str;
            str3 = "sh";
        }
        java.lang.String[] strArr = {str3};
        android.ext.e1.d("suCmd: '" + str2 + "'; su: '" + strH + "'; runBin: '" + str3 + '\'');
        java.lang.Process processI = null;
        for (int i2 = 0; i2 < 2; i2++) {
            if (i2 != 0) {
                if (i2 != 1) {try {

                    throw new java.lang.IllegalAccessException();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
                }
                try {
                    android.ext.e1.d("exec 1 start");
                    processI = android.ext.Tools.J("su".equals(str3) ? new java.lang.String[]{l()} : strArr, f("su".equals(str3)));
                    str4 = "exec 1 end: " + processI;
                } catch (java.lang.Throwable th_c) {
                    th = th_c;
                    for (th = th; th != null; th = th.getCause()) {
                        sb.append(th.toString());
                        sb.append('\n');
                    }
                    sb.append('\n');
                    sb.append(g(processI));
                }
                while (th != null) {
                    sb.append(th.toString());
                    sb.append('\n');
                }
                sb.append('\n');
                sb.append(g(processI));
                if (processI != null) {
                    break;
                }
            } else {
                android.ext.e1.d("exec 0 start");
                processI = android.ext.Tools.I(strArr);
                str4 = "exec 0 end: " + processI;
            }
            android.ext.e1.d(str4);
            java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(processI.getOutputStream());try {

            dataOutputStream.writeBytes(android.ext.Tools.F0(str) + '\n');
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}try {

            dataOutputStream.flush();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
            sb.append("process started: " + i2 + '\n');
            if (processI != null) {
                break;
            }
        }
        android.ext.e1.d("tryRoot end");
        if (z) {
            f745a = sb.toString();
        }
        return processI;
    }
}

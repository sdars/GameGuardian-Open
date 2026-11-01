package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile boolean f735a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile java.io.BufferedWriter f736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final java.lang.Runnable f738d = new android.ext.e1$a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static java.lang.String f739e = "/last_run.log";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static java.lang.String f740f = "- none -";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static java.lang.StringBuilder f741g = null;

    public static int a(java.lang.Throwable th) {
        return s("Bad implementation", th);
    }

    public static void b() {
        android.ext.n2.g(new android.ext.e1$b());
    }

    public static void c() {
        android.ext.n2.g(new android.ext.e1$c());
    }

    public static int d(java.lang.String str) {
        return e("AndroidService", str);
    }

    public static int e(java.lang.String str, java.lang.String str2) {
        return android.ext.e1$e.a(str, str2);
    }

    public static int f(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        return android.ext.e1$e.b(str, str2, th);
    }

    public static int g(java.lang.String str, java.lang.Throwable th) {
        return f("AndroidService", str, th);
    }

    public static int h(java.lang.String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = i + 1003;
            d(str.substring(i, i2 < length ? i2 : length));
            i = i2;
        }
        return 0;
    }

    public static int i(java.lang.String str) {
        return j("AndroidService", str);
    }

    public static int j(java.lang.String str, java.lang.String str2) {
        return android.ext.e1$e.c(str, str2);
    }

    public static int k(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        return android.ext.e1$e.d(str, str2, th);
    }

    public static int l(java.lang.String str, java.lang.Throwable th) {
        return k("AndroidService", str, th);
    }

    public static boolean m(boolean z) {
        if (f736b == null) {
            return false;
        }
        try {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (jCurrentTimeMillis - f737c > 5000 || z) {
                try {
                    f736b.flush();
                } catch (java.lang.NullPointerException unused) {
                }
                f737c = jCurrentTimeMillis;
                return true;
            }
        } catch (java.io.IOException e2) {
            android.ext.e1$e.b("AndroidService", "Log write: I/O", e2);
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:35:? A[RETURN, SYNTHETIC] */
    public static java.lang.String n(java.lang.Throwable th) {
        java.lang.String str;
        java.lang.String string;
        if (th == null) {
            return "";
        }
        for (java.lang.Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof java.net.UnknownHostException) {
                return "";
            }
        }
        java.io.StringWriter stringWriter = new java.io.StringWriter();
        java.io.PrintWriter printWriter = new java.io.PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (java.lang.OutOfMemoryError unused) {
            printWriter.write("OutOfMemoryError 1\n");
            while (th != null) {
                try {
                    printWriter.write(th.toString());
                    printWriter.write("\n");
                    th = th.getCause();
                } catch (java.lang.OutOfMemoryError unused2) {
                    str = "OutOfMemoryError 2\n";
                    printWriter.write(str);
                    printWriter.flush();
                    string = stringWriter.toString();
                    if (string == null) {
                        return "";
                    }
                    return string;
                }
            }
        } catch (java.lang.Throwable th2) {
            str = "Exception on printStackTrace: " + th2.getMessage();
            printWriter.write(str);
        }
        printWriter.flush();
        string = stringWriter.toString();
        if (string == null) {
            return "";
        }
        return string;
    }

    public static void o(java.lang.Process process, java.io.InputStream inputStream) {
        if (process == null) {
            return;
        }
        new android.ext.e1$d("runLogOnProcessErrStream", inputStream, process).start();
    }

    public static int p(java.lang.String str) {
        return q("AndroidService", str);
    }

    public static int q(java.lang.String str, java.lang.String str2) {
        return android.ext.e1$e.g(str, str2);
    }

    public static int r(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        return android.ext.e1$e.h(str, str2, th);
    }

    public static int s(java.lang.String str, java.lang.Throwable th) {
        return r("AndroidService", str, th);
    }
}

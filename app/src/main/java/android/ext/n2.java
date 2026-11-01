package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final android.os.Looper[] f1137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final android.os.Handler[] f1138b;

    static {
        android.ext.n2$a n2_a = new android.ext.n2$a("Main");
        n2_a.start();
        android.ext.n2$a n2_a2 = new android.ext.n2$a("Log");
        n2_a2.start();
        android.ext.n2$a n2_a3 = new android.ext.n2$a("Write");
        n2_a3.start();
        android.os.Looper[] looperArr = {android.os.Looper.getMainLooper(), n2_a.getLooper(), n2_a2.getLooper(), n2_a3.getLooper()};
        android.os.Handler[] handlerArr = {new android.os.Handler(looperArr[0]), new android.os.Handler(looperArr[1]), new android.os.Handler(looperArr[2]), new android.os.Handler(looperArr[3])};
        f1137a = looperArr;
        f1138b = handlerArr;
    }

    public static void a() {
        int i = 0;
        while (true) {
            android.os.Looper[] looperArr = f1137a;
            if (i >= looperArr.length) {
                return;
            }
            if (i != 0) {
                android.os.Looper looper = looperArr[i];
                try {
                    looper.quitSafely();
                } catch (java.lang.NoSuchMethodError unused) {
                    looper.quit();
                }
            }
            i++;
        }
    }

    private static android.os.Handler b(int i) {
        return f1138b[i];
    }

    public static android.os.Handler c() {
        return b(1);
    }

    public static android.os.Handler d() {
        return b(0);
    }

    public static boolean e() {
        return android.os.Looper.myLooper() == android.os.Looper.getMainLooper();
    }

    private static void f(int i, java.lang.Runnable runnable, boolean z) {
        android.os.Looper[] looperArr = f1137a;
        if (looperArr == null) {
            android.ext.e1$e.d("AndroidService", "Bad implementation", new java.lang.NullPointerException("loopers"));
            return;
        }
        if (looperArr[i] == null) {
            android.ext.e1$e.d("AndroidService", "Bad implementation", new java.lang.NullPointerException("loopers[" + i + ']'));
            return;
        }
        if (android.os.Looper.myLooper() != looperArr[i] || z) {
            f1138b[i].post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void g(java.lang.Runnable runnable) {
        try {
            f(2, runnable, false);
        } catch (java.lang.Throwable th) {
            android.ext.e1$e.d("AndroidService", "Bad implementation", th);
        }
    }

    public static void h(java.lang.Runnable runnable) {
        f(1, runnable, false);
    }

    public static void i(java.lang.Runnable runnable) {
        f(0, runnable, false);
    }

    public static void j(java.lang.Runnable runnable) {
        f(3, runnable, false);
    }
}

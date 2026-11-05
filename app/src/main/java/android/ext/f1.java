package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile java.lang.Boolean f951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f952b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static volatile int f953c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile boolean f954d = false;

    static boolean A() {
        java.lang.Throwable th;
        boolean z;
        java.lang.String str = null;
        android.ext.v.f1278b = true;
        try {
            android.content.ComponentName componentNameStartService = android.ext.r.p.startService(new android.content.Intent().setClassName(android.ext.Tools.C0(), catch_.me_.if_.you_.can_.AnalyticsService.class.getName()));
            z = componentNameStartService != null;
            if (componentNameStartService == null) {
                str = null;
            } else {
                try {
                    str = componentNameStartService.toString() + ' ' + componentNameStartService.toShortString();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    android.ext.e1.l("Failed load Service", th);
                }
            }
            B(10, str);
        } catch (java.lang.Throwable th3) {
            th = th3;
            z = false;
        }
        return z;
    }

    static void B(int i, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("main ");
        sb.append(i);
        sb.append(':');
        sb.append(android.os.Process.myUid());
        sb.append(": ");
        sb.append(android.ext.u.c());
        sb.append(' ');
        sb.append(android.ext.r.n == null ? null : java.lang.Boolean.valueOf(android.ext.r.n.f1206d));
        sb.append(' ');
        sb.append(android.ext.u.f1267b);
        sb.append(' ');
        sb.append(android.ext.v.f1277a);
        sb.append(' ');
        sb.append(str);
        android.ext.e1.d(sb.toString());
    }

    private static void C() {
        try {
            java.io.File file = new java.io.File(android.ext.Tools.q0(), "client_exit");
            if (file.exists() || file.createNewFile()) {
                return;
            }
            android.ext.e1$e.a("AndroidService", "Failed mark client exit");
        } catch (java.lang.Throwable th) {
            android.ext.e1$e.a("AndroidService", "Failed mark client exit: " + th);
        }
    }

    public static void D() {
        android.ext.r.n.L(2);
        if (f954d) {
            return;
        }
        f954d = true;
        android.ext.h0.i();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("GG started: ");
        float f2 = 1;
        sb.append((108.9f * f2) - 7.5f);
        sb.append(" (");
        sb.append((int) (((f2 * 16916.8f) - 761.8f) + 0.5f));
        sb.append(") on ");
        sb.append(android.ext.h0.b());
        android.ext.e1.h(sb.toString());
        new android.ext.r0(false);
        new android.ext.h2(0L, 0L, 0);
        if (!android.ext.s1.E()) {
            android.ext.r.n.m();
            android.ext.z.m();
        }
        android.ext.t.c();
        android.ext.y0.e();
        new android.ext.q1().h();
        h();
        android.ext.n0.b();
        B(5, null);
        b();
        l();
        c();
        j();
        g();
        k();
        if (!android.ext.s1.E()) {
            d(false);
        }
        android.ext.c1.g();
        android.ext.p2.i();
        android.ext.ConfigListAdapter.j(3);
    }

    private static java.lang.String E() {
        java.io.File file = new java.io.File(android.ext.Tools.q0(), "FC.txt");
        if (!file.exists()) {
            return null;
        }
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            try {
                byte[] bArr = new byte[41];
                int i = fileInputStream.read(bArr);
                java.lang.String str = i > 0 ? new java.lang.String(bArr, 0, i) : null;
                fileInputStream.close();
                return str;
            } catch (java.lang.Throwable th_c_c_c) {
                fileInputStream.close();
                throw th_c_c_c;
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Fail get FC file", th2);
            return null;
        }
    }

    static void F() {
        if (t()) {
            return;
        }
        boolean zQ = android.ext.s1.Q();
        java.lang.String strE = E();
        boolean zC = android.ext.s0.c(android.ext.s0.a(strE), android.ext.s0.e(strE), s(), m());
        d(true);
        a();
        if (!zC || zQ) {
            return;
        }
        android.ext.s1.v(4, "");
    }

    static boolean G(java.lang.Runnable runnable) {
        return e(false, runnable);
    }

    public static void H() {
        if (f953c == 0) {
            return;
        }
        android.ext.n2.i(new android.ext.f1$o());
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0026 -> B:16:0x0029). Please report as a decompilation issue!!! */
    static void I() {
        android.content.Context baseContext = null;
        android.content.Context context;
        try {
            int i = android.ext.Config.z;
            if (i == 2) {
                baseContext = android.ext.r.n.createPackageContext(r.n.getPackageName(), 3);
            } else if (i != 3) {
                baseContext = i != 4 ? null : r.n.getBaseContext();
            } else {
                baseContext = android.ext.r.o;
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        android.ext.e1.d("setContext: " + android.ext.Config.z + ' ' + baseContext);
        if (baseContext != null) {
            try {
                ((gg_a.d) gg_a.f.a(android.view.LayoutInflater.from(baseContext))).inflate(catch_.me_.if_.you_.can_.R.layout.service_dialog, (android.view.ViewGroup) null);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.s("Failed use context: " + baseContext, th2);
            }
        }
        context = baseContext;
        if (context != null) {
            android.ext.Tools.X0(context);
            android.ext.MainService.context = android.ext.l2.i(context);
            O();
            D();
            return;
        }
        android.ext.v.f1280d = true;
        if (A()) {
            return;
        }
        android.ext.Tools.J1(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.could_not_use) + ": " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.service));
        android.ext.r.n.T();
    }

    static java.lang.Runnable J(android.content.Context context, java.lang.String str, long j, boolean z) {
        return new android.ext.f1$i(context, str, j);
    }

    public static void K() {
        android.ext.n2.i(new android.ext.f1$a());
    }

    static void L() {
        android.ext.r.n.L(1);
        android.ext.b1.z1();
    }

    static void M() {
        android.ext.z0.h();
    }

    private static boolean N() {
        boolean zStopService = false;
        try {
            android.content.Context contextF0 = android.ext.Tools.f0();
            if (contextF0 != null) {
                zStopService = contextF0.stopService(new android.content.Intent().setClassName(android.ext.Tools.C0(), catch_.me_.if_.you_.can_.AnalyticsService.class.getName()));
                B(100, " " + zStopService);
            } else {
                B(101, "");
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed unload Service", th);
        }
        return zStopService;
    }

    static void O() {
        if (android.ext.Config.z == 1) {
            return;
        }
        if ((android.ext.Config.B & 256) != 0) {
            A();
        } else {
            N();
        }
    }

    private static void P(java.io.File file) {
        try {
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            try {
                fileOutputStream.write(android.ext.s0.b(s(), m()).getBytes());
                fileOutputStream.close();
            } catch (java.lang.Throwable th_c_c_c) {
                fileOutputStream.close();
                throw th_c_c_c;
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Fail set FC file", th2);
        }
    }

    static void a() {
        if (t()) {
            return;
        }
        java.io.File file = new java.io.File(android.ext.Tools.q0(), "FC.txt");
        if (file.exists()) {
            return;
        }
        P(file);
    }

    public static void b() {
        new android.ext.g0(new android.ext.f1$g(), "checkAutoTranslation").start();
    }

    private static void c() {
        new android.ext.g0(new android.ext.f1$l(), "checkBadApps").start();
    }

    private static void d(boolean z) {
        e(z, null);
    }

    private static boolean e(boolean z, java.lang.Runnable runnable) {
        boolean z2 = false;
        if (t()) {
            return false;
        }
        java.io.File file = new java.io.File(android.ext.Tools.q0(), "FC.txt");
        if (z) {
            file.delete();
            return false;
        }
        java.lang.String strE = E();
        if (android.ext.s0.c(android.ext.s0.a(strE), android.ext.s0.e(strE), s(), m())) {
            z2 = true;
            boolean[] zArr = new boolean[1];
            android.app.AlertDialog alertDialogCreate = android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.force_close_)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.f1$e(zArr, runnable)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), w(64L)).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help), new android.ext.f1$d()).create();
            if (runnable != null) {
                android.ext.f.k(alertDialogCreate, new android.ext.f1$f(zArr, runnable));
            }
            android.ext.f.m(alertDialogCreate);
        }
        file.delete();
        P(file);
        return z2;
    }

    static void f(byte b2) {
        java.io.File file = new java.io.File(android.ext.Tools.q0(), "instr.check");
        int i = (int) (((1 * 16258.4f) - 103.4f) + 0.5f);
        if (b2 == 0) {
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    fileOutputStream.write(java.lang.Integer.toString(i).getBytes());
                    fileOutputStream.close();
                    return;
                } catch (java.lang.Throwable th_c_c_c) {
                    fileOutputStream.close();
                    throw th_c_c_c;
                }
            } catch (java.lang.Throwable th2) {
                android.ext.e1.l("Fail set instr file", th2);
                return;
            }
        }
        if (b2 == 1) {
            if (!file.exists()) {
                android.ext.e1.i("No instr file: " + file);
            }
        } else {
            if (!file.exists()) {
                return;
            }
            try {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                try {
                    byte[] bArr = new byte[12];
                    int i2 = fileInputStream.read(bArr);
                    if ((i2 > 0 ? java.lang.Integer.parseInt(new java.lang.String(bArr, 0, i2)) : 0) == i && android.ext.Config.z == 0) {
                        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_context_source).f42d = 1;
                        android.ext.Config.k();
                    }
                    fileInputStream.close();
                } catch (java.lang.Throwable th3_c_c_c) {
                    fileInputStream.close();
                    throw th3_c_c_c;
                }
            } catch (java.lang.Throwable th4) {
                android.ext.e1.l("Fail get instr file", th4);
            }
        }
        file.delete();
    }

    private static void g() {
        if ((android.ext.Config.f30c & 128) != 0) {
            return;
        }
        try {
            java.lang.String strL1 = android.ext.Tools.L1("%e", java.lang.Float.valueOf(1.2E34f));
            if (strL1.indexOf(101) == -1 && strL1.indexOf(69) == -1 && strL1.indexOf(1077) == -1 && strL1.indexOf(1045) == -1) {
                android.ext.n2.i(J(android.ext.r.p, android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.wrong_float_), java.lang.Float.toString(1.2E34f), strL1), 128L, false));
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    private static void h() {
        new android.ext.g0(new android.ext.f1$b(), "checkNewVersion").start();
    }

    static void i() {
        if (android.ext.Tools.e1("com.chaozhuo.permission.controller") && (android.ext.Config.f30c & 4) == 0) {
            android.ext.n2.i(J(android.ext.r.p, android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_allow_background) + "\n\n" + android.ext.Tools.removeNewLinesChars("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh25<70krz0wr0uxq0lq0skrhql{rv0jdphjxdugldq2"), 4L, true));
        }
    }

    private static void j() {
        new android.ext.g0(new android.ext.f1$j(), "checkRandomName").start();
    }

    private static void k() {
        java.io.File file = new java.io.File(android.ext.Tools.q0(), "sel.txt");
        try {
            if (enforcing()) {
                /* The policy of the device is enforced.  The mode "work with
                   SELinux" can not inject into a target of a privileged
                   application in that case: the daemon has to copy its helper
                   library into the directory of the target inside the system
                   partition, the partition is read only and the policy of
                   the root manager does not allow to create a directory
                   there.  The daemon answers that with the error 107 and the
                   app shows "this process does not support the speed hack".

                   The mode "work without SELinux" is the one that works on
                   such a device - the daemon turns the enforcement off while
                   it runs.  It is also the mode the daemon of the original
                   application uses there.  Switch to it instead of asking
                   the same question again, the question would only lead to
                   the same failure. */
                if (file.exists()) {
                    file.delete();
                }
                if (android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.selinux).f42d == 1) {
                    android.ext.e1.d("the policy is enforced: work without SELinux");
                    android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.selinux).f42d = 0;
                    android.ext.Config.k();
                    android.ext.r.I();
                }
                return;
            }
            if (file.exists()) {
                if ((android.ext.Config.A & 4) != 0) {
                    file.delete();
                } else {
                    d(true);
                    android.ext.f.m(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.last_run_failed)).setItems(new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.work_with_selinux), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip)}, new android.ext.f1$c(file)).create());
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    /* the state of the enforcement of the policy on the device: the daemon
       needs the permission to read the memory of a target and to run a
       library inside of it, that is only possible while the enforcement is
       off or while the target is not protected by the policy */
    private static boolean enforcing() {
        /* the file of the kernel is read first, it is cheap and it does not
           need a root shell */
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream("/sys/fs/selinux/enforce");
            byte[] bArr = new byte[8];
            int i = fileInputStream.read(bArr);
            fileInputStream.close();
            if (i > 0) {
                return bArr[0] == '1';
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        try {
            /* the root shell of the app runs the command, the app itself
               may not read the file of the kernel */
            java.lang.String str = android.ext.e2.n("exec getenforce", 5);
            if (str != null && str.toLowerCase(java.util.Locale.US).contains("enforcing")) {
                return true;
            }
            if (str != null && str.toLowerCase(java.util.Locale.US).contains("permissive")) {
                return false;
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        return false;
    }

    private static void l() {
        new android.ext.g0(new android.ext.f1$k(), "checkSlowEmulator").start();
    }

    private static long m() {
        try {
            android.content.pm.PackageInfo packageInfoA0 = android.ext.Tools.A0(android.ext.Tools.C0(), 0);
            if (packageInfoA0 != null) {
                return packageInfoA0.lastUpdateTime;
            }
            return -1L;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Fail get package info", th);
            return -1L;
        }
    }

    public static void n() {
        C();
        N();
        android.ext.e1$e.a("AndroidService", "Main: die");
        try {
            java.lang.System.exit(0);
        } catch (java.lang.Throwable th) {
            android.ext.e1$e.d("AndroidService", "OnExit", th);
        }
        android.ext.e1$e.a("AndroidService", "exit: 14");
        try {
            java.lang.Runtime.getRuntime().halt(0);
        } catch (java.lang.Throwable th2) {
            android.ext.e1$e.d("AndroidService", "OnExit", th2);
        }
        android.ext.e1$e.a("AndroidService", "exit: 15");
        try {
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (java.lang.Throwable th3) {
            android.ext.e1$e.d("AndroidService", "OnExit", th3);
        }
        android.ext.e1$e.a("AndroidService", "exit: 16");
        try {
            android.ext.e2.n("exec kill " + android.os.Process.myPid(), 45);
        } catch (java.lang.Throwable th4) {
            android.ext.e1$e.d("AndroidService", "OnExit", th4);
        }
        android.ext.e1$e.a("AndroidService", "exit: 17");
        throw new android.ext.n0$h("Failed exit from the app normally");
    }

    public static void o() {
        android.ext.e1.d("Main: exit");
        boolean z = true;
        f952b = true;
        try {
            if (android.ext.MainService.instance != null) {
                android.ext.MainService.instance.m1(true);
                android.ext.MainService.instance.a0();
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Exception on exit", th);
        }
        android.ext.e1$e.a("AndroidService", "exit: 1");
        new java.io.File(android.ext.Tools.q0(), "sel.txt").delete();
        d(true);
        android.ext.e1$e.a("AndroidService", "exit: 2");
        try {
            android.ext.e1.b();
        } catch (java.lang.Throwable th2) {
            android.ext.e1$e.d("AndroidService", "OnExit", th2);
        }
        android.ext.e1$e.a("AndroidService", "exit: 3");
        boolean z2 = android.ext.v.f1277a != null;
        android.ext.f1$n f1_n = new android.ext.f1$n();
        android.ext.e1$e.a("AndroidService", "wait 1: " + z2);
        if (z2) {
            android.ext.v.f1279c = f1_n;
            android.ext.v.f1277a.c();
        }
        if (!N() && !z2) {
            z = false;
        }
        android.ext.e1$e.a("AndroidService", "wait 2: " + z);
        if (!z) {
            p();
            return;
        }
        if (android.ext.v.f1279c == null) {
            android.ext.v.f1279c = f1_n;
        }
        android.ext.n2.d().postDelayed(f1_n, 3000L);
    }

    static void p() {
        C();
        try {
            H();
        } catch (java.lang.Throwable th) {
            android.ext.e1$e.d("AndroidService", "OnExit", th);
        }
        android.ext.e1$e.a("AndroidService", "exit: 4");
        try {
            android.ext.n2.a();
        } catch (java.lang.Throwable th2) {
            android.ext.e1$e.d("AndroidService", "OnExit", th2);
        }
        android.ext.e1$e.a("AndroidService", "exit: 5");
        try {
            android.ext.u.a();
        } catch (java.lang.Throwable th3) {
            android.ext.e1$e.d("AndroidService", "OnExit", th3);
        }
        android.ext.e1$e.a("AndroidService", "exit: 6");
        java.io.File file = new java.io.File(android.ext.Tools.b0(), "skipFinalization");
        android.ext.e1$e.a("AndroidService", "exit: 7");
        if (!file.exists()) {
            android.ext.e1$e.a("AndroidService", "exit: 8");
            try {
                file.createNewFile();
            } catch (java.lang.Throwable th4) {
                android.ext.e1$e.d("AndroidService", "OnExit", th4);
            }
            android.ext.e1$e.a("AndroidService", "exit: 9");
            try {
                java.lang.System.runFinalization();
            } catch (java.lang.Throwable th5) {
                android.ext.e1$e.d("AndroidService", "OnExit", th5);
            }
            android.ext.e1$e.a("AndroidService", "exit: 10");
            try {
                file.delete();
            } catch (java.lang.Throwable th6) {
                android.ext.e1$e.d("AndroidService", "OnExit", th6);
            }
        }
        android.ext.e1$e.a("AndroidService", "exit: 11");
        if (!android.ext.Config.vSpaceReal) {
            try {
                android.ext.e2.n("exec am force-stop " + android.ext.Tools.C0(), 45);
            } catch (java.lang.Throwable th7) {
                android.ext.e1$e.d("AndroidService", "OnExit", th7);
            }
            android.ext.e1$e.a("AndroidService", "exit: 12");
            try {
                android.ext.e2.n("exec am kill " + android.ext.Tools.C0(), 45);
            } catch (java.lang.Throwable th8) {
                android.ext.e1$e.d("AndroidService", "OnExit", th8);
            }
            android.ext.e1$e.a("AndroidService", "exit: 13");
        }
        n();
    }

    public static void q(android.content.Context context) {
        r(context, null);
    }

    public static void r(android.content.Context context, java.lang.Runnable runnable) {
        android.ext.n2.i(new android.ext.f1$m(context, runnable));
    }

    private static int s() {
        return (int) (((1 * 17371.5f) - 1216.5f) + 0.5f);
    }

    private static boolean t() {
        return ((android.ext.Config.f30c & 64) == 0 && (android.ext.Config.B & 8192) == 0) ? false : true;
    }

    static android.content.ComponentName u() {
        try {
            return new android.content.ComponentName(android.ext.Tools.C0(), catch_.me_.if_.you_.can_.Instrumentation.class.getName());
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return null;
        }
    }

    static java.lang.String v() {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        int i = 0;
        int i2;
        int i3 = 0;
        try {
            android.content.res.Resources resources = android.ext.Tools.f0().getResources();
            android.content.res.Configuration configuration = resources.getConfiguration();
            try {
                i2 = configuration.screenWidthDp;
                try {
                    i = configuration.screenHeightDp;
                    i3 = i2;
                } catch (java.lang.Throwable th_c) {
                    th = th_c;
                    try {
                        android.ext.e1.a(th_c);
                        i3 = i2;
                        i = 0;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        i3 = i2;
                        i = 0;
                        android.ext.e1.a(th_c);
                        return "" + i3 + 'x' + i;
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                i2 = 0;
            }
            try {
                android.util.DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                if (i3 == 0 && displayMetrics != null) {
                    float f2 = displayMetrics.density;
                    if (f2 != 0.0f) {
                        i3 = (int) (displayMetrics.widthPixels / f2);
                    }
                }
                if (i == 0 && displayMetrics != null) {
                    float f3 = displayMetrics.density;
                    if (f3 != 0.0f) {
                        i = (int) (displayMetrics.heightPixels / f3);
                    }
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                android.ext.e1.a(th);
            }
        } catch (java.lang.Throwable th5) {
            th = th5;
        }
        return "" + i3 + 'x' + i;
    }

    static android.content.DialogInterface.OnClickListener w(long j) {
        return new android.ext.f1$h(j);
    }

    static java.lang.String x() {
        if (android.ext.Config.C) {
            return android.ext.Config.E;
        }
        if (!android.ext.Config.vSpaceReal) {
            return android.ext.e2.h(null);
        }
        return android.ext.e2.h(null) + "@" + android.ext.Config.E;
    }

    public static boolean y() {
        return z(null, null);
    }

    public static boolean z(android.content.Context context, android.content.DialogInterface.OnDismissListener dialogInterface$OnDismissListener) {
        if (!android.ext.Config.C) {
            return true;
        }
        if (context == null) {
            context = android.ext.Tools.f0();
        }
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(context).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_root_mode)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).create();
        if (dialogInterface$OnDismissListener != null) {
            android.ext.f.k(alertDialogCreate, dialogInterface$OnDismissListener);
        }
        android.ext.f.m(alertDialogCreate);
        return false;
    }
}

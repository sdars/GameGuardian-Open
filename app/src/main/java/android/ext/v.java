package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends android.app.Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile android.ext.v f1277a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f1278b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile java.lang.Runnable f1279c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile boolean f1280d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f1281e = false;

    public v() {
        f1277a = this;
    }

    private void a() {
        if (f1281e || !f1280d) {
            return;
        }
        java.lang.String[] strArrE = android.ext.n0.e();
        for (int i = 2; i < strArrE.length; i += 2) {
            java.lang.String str = strArrE[i];
            if (android.ext.Tools.e1(strArrE[i + 1])) {
                java.lang.RuntimeException runtimeException = new java.lang.RuntimeException("BootstrapService stop: " + str);
                android.ext.e1.s("Found: " + str, runtimeException);
                android.ext.n0.m(java.lang.Thread.currentThread(), runtimeException);
            }
        }
    }

    private void b() {
        android.ext.Tools.X0(this);
        if (f1280d) {
            if (android.ext.MainService.context == null) {
                android.ext.MainService.context = android.ext.l2.i(this);
            }
            android.ext.n0.f();
        }
    }

    void c() {
        try {
            stopForeground(true);
            android.ext.e1.d("BootstrapService stopForeground");
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        try {
            android.ext.e1.d("BootstrapService stop: " + stopService(new android.content.Intent().setClassName(android.ext.Tools.C0(), catch_.me_.if_.you_.can_.AnalyticsService.class.getName())));
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Failed stop Service", th2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.SharedPreferences getSharedPreferences(java.lang.String str, int i) {
        return android.ext.f2.a(super.getSharedPreferences(str, i));
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        android.ext.e1.d("BootstrapService onBind: " + intent);
        return null;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        android.ext.e1.d("BootstrapService onConfigurationChanged: " + configuration);
        if (f1278b) {
            android.content.res.Configuration configurationF = gg_a.b.f(configuration);
            super.onConfigurationChanged(configurationF);
            android.ext.MainService.Y(configurationF);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        android.ext.e1.d("BootstrapService onCreate: " + f1278b + '-' + f1280d + "; " + f1277a + "; " + this);
        if (f1278b) {
            f1277a = this;
            super.onCreate();
            b();
        } else {
            if (!android.ext.r.o(this)) {
                c();
                return;
            }
            f1278b = true;
            f1277a = this;
            super.onCreate();
            b();
            android.ext.s1.w();
            android.ext.r.J(this, 1000L);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (f1279c != null) {
            android.ext.e1$e.a("AndroidService", "wait 3");
            f1279c.run();
            return;
        }
        if (!f1278b) {
            android.ext.e1.d("BootstrapService onDestroy 1: " + f1278b + '-' + f1281e);
            return;
        }
        android.ext.e1.g("BootstrapService onDestroy 2: " + f1278b + '-' + f1281e, new java.lang.RuntimeException());
        a();
        stopForeground(true);
        if (!android.ext.u.c()) {
            android.ext.t.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        android.ext.e1.d("BootstrapService onLowMemory");
        if (f1278b) {
            super.onLowMemory();
            android.ext.MainService.t0(-1);
        }
    }

    @Override // android.app.Service
    public void onRebind(android.content.Intent intent) {
        android.ext.e1.d("BootstrapService onRebind: " + intent);
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public void onStart(android.content.Intent intent, int i) {
        android.ext.e1.d("BootstrapService onStart: " + i + "; " + intent);
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        android.ext.e1.d("BootstrapService onStartCommand: " + f1278b + '-' + f1280d + "; " + f1277a + "; " + this + "; " + android.ext.MainService.context);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("BootstrapService onStartCommand: ");
        sb.append(i2);
        sb.append(' ');
        sb.append(i);
        sb.append(' ');
        sb.append(intent);
        android.ext.e1.d(sb.toString());
        if (!f1278b) {
            c();
            return 2;
        }
        b();
        if (f1280d) {
            android.ext.f1.D();
            int i3 = android.ext.Config.vSpaceReal ? 4 : 2;
            java.lang.Throwable th = null;
            int i4 = 0;
            while (i4 < i3) {
                try {
                    startForeground(1, android.ext.MainService.instance.F(i4 % 2 == 0, i4 >= 2));
                    android.ext.e1.d("startForeground 1." + i4);
                    break;
                } catch (java.lang.Throwable th2) {
                    if (th != null) {
                        th2.addSuppressed(th);
                    }
                    if (i4 == i3 - 1) {
                        android.ext.e1.s("Failed startForeground", th2);
                        android.ext.n0.h(java.lang.Thread.currentThread(), th2, false);
                    }
                    i4++;
                    th = th2;
                }
            }
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(android.content.Intent intent) {
        android.ext.e1.g("BootstrapService onTaskRemoved: " + f1278b + '-' + f1281e + '-' + f1280d + "; " + intent, new java.lang.RuntimeException());
        if (f1278b) {
            a();
            super.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        android.ext.e1.d("BootstrapService onTrimMemory: " + i);
        if (f1278b) {
            super.onTrimMemory(i);
            android.ext.MainService.t0(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(android.content.Intent intent) {
        android.ext.e1.d("BootstrapService onUnbind: " + intent);
        return super.onUnbind(intent);
    }
}

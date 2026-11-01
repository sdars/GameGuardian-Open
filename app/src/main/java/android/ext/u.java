package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class u extends android.app.Instrumentation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1266a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile android.ext.u f1267b;

    static {
        android.ext.e1.d("Instrumentation clinit");
        android.ext.i.a();
        android.ext.n0.f();
    }

    public u() {
        f1267b = this;
        android.ext.e1.d("Instrumentation init");
        android.ext.n0.f();
    }

    public static void a() {
        android.ext.u uVar = f1267b;
        if (uVar != null) {
            uVar.finish(0, new android.os.Bundle());
        }
    }

    public static boolean c() {
        return f1266a;
    }

    public android.content.Context b(boolean z) {
        android.content.Context targetContext = z ? getTargetContext() : getContext();
        android.content.Context targetContext2 = !z ? getTargetContext() : getContext();
        if (targetContext == null) {
            targetContext = targetContext2;
        }
        return gg_a.b.i(targetContext);
    }

    @Override // android.app.Instrumentation
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        android.ext.r.K(bundle);
        android.ext.Tools.X0(getTargetContext());
        android.ext.Tools.X0(getContext());
        if (android.ext.MainService.context == null) {
            android.ext.MainService.context = android.ext.l2.i(b(false));
        }
        android.ext.e1.d("Instrumentation onCreate " + bundle);
        android.ext.n0.f();
        f1267b = this;
        f1266a = true;
        start();
    }

    @Override // android.app.Instrumentation
    public void onDestroy() {
        android.ext.t.a();
        super.onDestroy();
    }

    @Override // android.app.Instrumentation
    public boolean onException(java.lang.Object obj, java.lang.Throwable th) {
        android.ext.e1.s("Instrumentation onException: " + obj, th);
        return super.onException(obj, th);
    }

    @Override // android.app.Instrumentation
    public void onStart() {
        super.onStart();
        java.lang.String strT = android.ext.r.t();
        android.ext.e1.d("Instrumentation onStart " + strT);
        android.content.Context contextB = b(true);
        java.lang.String packageName = contextB.getPackageName();
        android.ext.Tools.w1(100, new android.content.ComponentName(packageName, strT), 1);
        contextB.startActivity(android.ext.Tools.N0(contextB, packageName, strT));
    }
}

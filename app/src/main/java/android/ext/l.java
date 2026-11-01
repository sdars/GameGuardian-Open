package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class l extends android.app.Application {
    static {
        android.ext.e1.d("Application clinit");
        android.ext.i.a();
        android.ext.n0.f();
    }

    public l() {
        android.ext.e1.d("Application init");
        android.ext.n0.f();
    }

    @Override // android.app.Application
    public void onCreate() {
        android.ext.e1.d("Application onCreate");
        super.onCreate();
        try {
            registerActivityLifecycleCallbacks(new android.ext.l$a(this));
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        android.ext.e1.d("Application onLowMemory");
        super.onLowMemory();
        android.ext.MainService.t0(-1);
    }

    @Override // android.app.Application
    public void onTerminate() {
        android.ext.e1.d("Application onTerminate");
        super.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        android.ext.e1.d("Application onTrimMemory: " + i);
        super.onTrimMemory(i);
        android.ext.MainService.t0(i);
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class l$a implements android.app.Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.l f1049a;

    l$a(android.ext.l lVar) {
        this.f1049a = lVar;
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        android.ext.e1.d("onActivityCreated: " + activity + "; " + bundle);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityDestroyed(android.app.Activity activity) {
        android.ext.e1.d("onActivityDestroyed: " + activity);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityPaused(android.app.Activity activity) {
        android.ext.e1.d("onActivityPaused: " + activity);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityResumed(android.app.Activity activity) {
        android.ext.e1.d("onActivityResumed: " + activity);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        android.ext.e1.d("onActivitySaveInstanceState: " + activity + "; " + bundle);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStarted(android.app.Activity activity) {
        android.ext.e1.d("onActivityStarted: " + activity);
    }

    @Override // android.app.Application$ActivityLifecycleCallbacks
    public void onActivityStopped(android.app.Activity activity) {
        android.ext.e1.d("onActivityStopped: " + activity);
    }
}

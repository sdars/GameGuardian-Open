package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$t implements android.content.ComponentCallbacks2 {
    MainService$t() {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        android.ext.e1.d("ComponentCallbacks2 onConfigurationChanged: " + configuration);
        android.ext.MainService.Y(gg_a.b.f(configuration));
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        android.ext.e1.d("ComponentCallbacks2 onLowMemory");
        android.ext.MainService.t0(-1);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        android.ext.e1.d("ComponentCallbacks2 onTrimMemory: " + i);
        android.ext.MainService.t0(i);
    }
}

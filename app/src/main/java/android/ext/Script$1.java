package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$SavedState f365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Script f366b;

    Script$1(android.ext.Script script, android.ext.Script$SavedState script$SavedState) {
        this.f366b = script;
        this.f365a = script$SavedState;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_ranges).f42d = this.f365a.f389a;
        android.ext.Config.k();
    }
}

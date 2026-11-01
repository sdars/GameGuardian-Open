package android.ext;

/* JADX INFO: loaded from: classes.dex */
class i1$b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.View f1007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.i1 f1008b;

    i1$b(android.ext.i1 i1Var, android.view.View view) {
        this.f1008b = i1Var;
        this.f1007a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1007a.requestApplyInsets();
    }
}

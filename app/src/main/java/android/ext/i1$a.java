package android.ext;

/* JADX INFO: loaded from: classes.dex */
class i1$a implements android.view.View.OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.i1 f1006a;

    i1$a(android.ext.i1 i1Var) {
        this.f1006a = i1Var;
    }

    @Override // android.view.View$OnApplyWindowInsetsListener
    public android.view.WindowInsets onApplyWindowInsets(android.view.View view, android.view.WindowInsets windowInsets) {
        this.f1006a.c(android.ext.i1.f(windowInsets));
        return windowInsets;
    }
}

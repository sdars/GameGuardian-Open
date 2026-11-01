package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$j implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.WindowManager.LayoutParams f510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.view.View f511b;

    Tools$j(android.view.WindowManager.LayoutParams windowManager$LayoutParams, android.view.View view) {
        this.f510a = windowManager$LayoutParams;
        this.f511b = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.Tools.n1(this.f511b);
        android.ext.Tools$ViewWrapper tools$ViewWrapper = new android.ext.Tools$ViewWrapper(this.f511b.getContext());
        tools$ViewWrapper.addView(this.f511b);
        android.ext.Tools.f(tools$ViewWrapper, this.f510a);
    }
}

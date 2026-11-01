package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$o implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.view.View f529a;

    Tools$o(android.view.View view) {
        this.f529a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.view.ViewParent parent = this.f529a.getParent();
        if (parent instanceof android.ext.Tools$ViewWrapper) {
            android.ext.Tools$ViewWrapper tools$ViewWrapper = (android.ext.Tools$ViewWrapper) parent;
            android.ext.Tools.m1(tools$ViewWrapper);
            tools$ViewWrapper.removeAllViews();
        }
    }
}

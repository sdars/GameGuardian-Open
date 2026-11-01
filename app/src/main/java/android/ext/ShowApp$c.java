package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ShowApp$c implements android.view.View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ShowApp f463a;

    ShowApp$c(android.ext.ShowApp showApp) {
        this.f463a = showApp;
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f463a.h(true);
            return true;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.f463a.h(false);
        return true;
    }
}

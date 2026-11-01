package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$w implements android.view.View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.ArrayList f548a;

    private Tools$w() {
        this.f548a = new java.util.ArrayList();
    }

    /* synthetic */ Tools$w(android.ext.Tools$j tools$j) {
        this();
    }

    void a(android.view.View.OnFocusChangeListener view$OnFocusChangeListener) {
        if (view$OnFocusChangeListener == null || this.f548a.contains(view$OnFocusChangeListener)) {
            return;
        }
        this.f548a.add(view$OnFocusChangeListener);
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(android.view.View view, boolean z) {
        java.util.Iterator it = this.f548a.iterator();
        while (it.hasNext()) {
            ((android.view.View.OnFocusChangeListener) it.next()).onFocusChange(view, z);
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$o implements android.widget.AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.widget.AdapterView.OnItemClickListener f787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.ext.f$n f788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final java.lang.Runnable f789c;

    private f$o(android.widget.AdapterView.OnItemClickListener adapterView$OnItemClickListener, android.ext.f$n f_n, java.lang.Runnable runnable) {
        this.f787a = adapterView$OnItemClickListener;
        this.f788b = f_n;
        this.f789c = runnable;
    }

    /* synthetic */ f$o(android.widget.AdapterView.OnItemClickListener adapterView$OnItemClickListener, android.ext.f$n f_n, java.lang.Runnable runnable, android.ext.f$a f_a) {
        this(adapterView$OnItemClickListener, f_n, runnable);
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        boolean zB = this.f788b.b();
        android.widget.AdapterView.OnItemClickListener adapterView$OnItemClickListener = this.f787a;
        if (adapterView$OnItemClickListener != null) {
            try {
                adapterView$OnItemClickListener.onItemClick(adapterView, view, i, j);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        if (!zB || this.f789c == null) {
            return;
        }
        android.ext.n2.d().post(this.f789c);
    }
}

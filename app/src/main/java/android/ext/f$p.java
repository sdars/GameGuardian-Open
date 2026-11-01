package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$p implements android.widget.AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.widget.AdapterView.OnItemClickListener f790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final android.app.AlertDialog f791b;

    private f$p(android.app.AlertDialog alertDialog, android.widget.AdapterView.OnItemClickListener adapterView$OnItemClickListener) {
        this.f790a = adapterView$OnItemClickListener;
        this.f791b = alertDialog;
    }

    /* synthetic */ f$p(android.app.AlertDialog alertDialog, android.widget.AdapterView.OnItemClickListener adapterView$OnItemClickListener, android.ext.f$a f_a) {
        this(alertDialog, adapterView$OnItemClickListener);
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        try {
            this.f790a.onItemClick(adapterView, view, i, j);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            android.ext.Tools.D(this.f791b);
        }
    }
}

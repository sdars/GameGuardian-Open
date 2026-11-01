package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class FastScrollerFix implements android.widget.AbsListView.OnScrollListener, java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.ListView f135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f136b = 0;

    public FastScrollerFix(android.widget.ListView listView) {
        this.f135a = listView;
        b(listView, false);
        try {
            listView.setOnScrollListener(this);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public static void a(android.widget.ListView listView, boolean z) {
        if (listView == null) {
            return;
        }
        listView.setScrollBarStyle(16777216);
        b(listView, z);
    }

    private static void b(android.widget.ListView listView, boolean z) {
        if (listView == null) {
            return;
        }
        try {
            listView.setFastScrollEnabled(z);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        try {
            listView.setFastScrollAlwaysVisible(z);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
    }

    @Override // android.widget.AbsListView$OnScrollListener
    public void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
        if (this.f136b != 0) {
            return;
        }
        android.os.Handler handlerD = android.ext.n2.d();
        handlerD.removeCallbacks(this);
        handlerD.postDelayed(this, 1000L);
    }

    @Override // android.widget.AbsListView$OnScrollListener
    public void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
        this.f136b = i;
        android.os.Handler handlerD = android.ext.n2.d();
        handlerD.removeCallbacks(this);
        if (i != 0) {
            b(this.f135a, true);
        } else {
            handlerD.postDelayed(this, 1000L);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        b(this.f135a, false);
    }
}

package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class ScrollView extends android.widget.ScrollView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f1444d = android.view.ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1447c;

    public ScrollView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1445a = false;
        this.f1446b = -1L;
        this.f1447c = 1;
    }

    private void a() {
        this.f1446b = -1L;
        this.f1447c = 2;
        requestDisallowInterceptTouchEvent(true);
        b();
    }

    private void b() {
        android.view.MotionEvent motionEventObtain = android.view.MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0);
        onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private void c() {
        this.f1446b = -1L;
    }

    private int d(float f2) {
        int height = getHeight();
        float fH = android.ext.Tools.H() / 2;
        float f3 = (height - 1) - (2.0f * fH);
        float height2 = getChildAt(0).getHeight();
        return (int) java.lang.Math.min(java.lang.Math.max(((f2 - fH) / f3) * height2, 0.0f), height2);
    }

    private boolean e(float f2) {
        return f2 >= ((float) (getWidth() - android.ext.Tools.H()));
    }

    private void f() {
        this.f1446b = android.os.SystemClock.uptimeMillis() + f1444d;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (java.lang.IllegalArgumentException e2) {
            android.ext.e1.a(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x001e  */
    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.f1445a) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    c();
                } else if (actionMasked != 2) {
                    if (actionMasked == 3) {
                        c();
                    }
                } else if (e(motionEvent.getX())) {
                    long j = this.f1446b;
                    if (j >= 0 && j <= android.os.SystemClock.uptimeMillis()) {
                        a();
                        scrollTo(getScrollX(), d(motionEvent.getY()));
                        return onTouchEvent(motionEvent);
                    }
                } else {
                    c();
                }
            } else if (e(motionEvent.getX())) {
                f();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, android.graphics.Rect rect) {
        try {
            return super.onRequestFocusInDescendants(i, rect);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (this.f1445a) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1) {
                    if (this.f1446b >= 0) {
                        a();
                        scrollTo(getScrollX(), d(motionEvent.getY()));
                    }
                    if (this.f1447c == 2) {
                        requestDisallowInterceptTouchEvent(false);
                        this.f1447c = 1;
                        return true;
                    }
                } else if (actionMasked == 2) {
                    if (this.f1446b >= 0) {
                        a();
                    }
                    if (this.f1447c == 2) {
                        scrollTo(getScrollX(), d(motionEvent.getY()));
                        return true;
                    }
                } else if (actionMasked == 3) {
                    c();
                }
            } else if (e(motionEvent.getX())) {
                a();
                return true;
            }
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.view.View
    public void playSoundEffect(int i) {
        try {
            super.playSoundEffect(i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i) {
        try {
            super.sendAccessibilityEvent(i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public void setFastScrollEnabled(boolean z) {
        this.f1445a = z;
        setScrollBarSize(android.ext.Tools.H() / 2);
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        try {
            super.setOverScrollMode(i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}

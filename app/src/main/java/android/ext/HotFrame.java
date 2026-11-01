package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class HotFrame extends android.fix.FrameLayout implements android.view.View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.Runnable f156a;

    public HotFrame(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        setHapticFeedbackEnabled(false);
        setOnLongClickListener(this);
        this.f156a = new android.ext.HotFrame$a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action == 0 || action == 1 || action == 3) {
                removeCallbacks(this.f156a);
            }
        } catch (java.lang.NoSuchMethodError e2) {
            android.ext.e1.a(e2);
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        int longPressTimeout = android.view.ViewConfiguration.getLongPressTimeout();
        if (longPressTimeout < 0) {
            longPressTimeout = 0;
        }
        int i = 750 - longPressTimeout;
        android.ext.e1.d("Fake long click: " + i);
        if (i <= 0) {
            this.f156a.run();
            return true;
        }
        removeCallbacks(this.f156a);
        postDelayed(this.f156a, i);
        return true;
    }
}

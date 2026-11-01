package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class SeekBar extends android.widget.SeekBar {
    public SeekBar(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(android.graphics.Canvas canvas) {
        try {
            try {
                super.onDraw(canvas);
            } catch (java.lang.RuntimeException e2) {
                android.ext.e1.a(e2);
            }
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(android.view.View view, int i) {
        try {
            super.onVisibilityChanged(view, i);
        } catch (java.lang.RuntimeException e2) {
            android.ext.e1.a(e2);
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

    @Override // android.widget.ProgressBar
    public void setInterpolator(android.content.Context context, int i) {
        try {
            super.setInterpolator(context, i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.widget.ProgressBar
    public void setInterpolator(android.view.animation.Interpolator interpolator) {
        try {
            super.setInterpolator(interpolator);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i) {
        try {
            try {
                super.setProgress(i);
            } catch (java.lang.NullPointerException e2) {
                android.ext.e1.a(e2);
            }
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }
}

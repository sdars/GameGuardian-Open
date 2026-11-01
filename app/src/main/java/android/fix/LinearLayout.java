package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayout extends android.widget.LinearLayout {
    public LinearLayout(android.content.Context context) {
        super(context);
    }

    public LinearLayout(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        android.ext.e1.d("LinearLayout onConfigurationChanged: " + (configuration == null ? null : configuration.toString()));
        super.onConfigurationChanged(gg_a.b.f(configuration));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
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
}

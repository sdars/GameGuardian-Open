package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class TabWidget extends android.widget.TabWidget {
    public TabWidget(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TabWidget
    public void focusCurrentTab(int i) {
        try {
            super.focusCurrentTab(i);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
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
    public boolean performClick() {
        try {
            return super.performClick();
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
}

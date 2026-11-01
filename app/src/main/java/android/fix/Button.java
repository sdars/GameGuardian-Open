package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class Button extends android.widget.Button {
    public Button(android.content.Context context) {
        super(context);
    }

    public Button(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        try {
            super.drawableStateChanged();
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
        }
    }

    public boolean getSecClipboardEnabled() {
        return false;
    }

    @Override // android.widget.TextView, android.view.View, android.graphics.drawable.Drawable$Callback
    public void invalidateDrawable(android.graphics.drawable.Drawable drawable) {
        try {
            super.invalidateDrawable(drawable);
        } catch (java.lang.NoSuchFieldError e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(android.view.DragEvent dragEvent) {
        try {
            return super.onDragEvent(dragEvent);
        } catch (java.lang.ClassCastException e2) {
            android.ext.e1.a(e2);
            return false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (java.lang.ArrayIndexOutOfBoundsException | java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo accessibilityNodeInfo) {
        try {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyShortcut(int i, android.view.KeyEvent keyEvent) {
        try {
            return super.onKeyShortcut(i, keyEvent);
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
            return false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        try {
            return super.onTextContextMenuItem(i);
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
            return false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return super.onTouchEvent(motionEvent);
        } catch (android.content.ActivityNotFoundException e2) {
            android.ext.e1.a(e2);
            return false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        try {
            return super.performLongClick();
        } catch (java.lang.ClassCastException e2) {
            android.ext.e1.a(e2);
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

    @Override // android.view.View
    public void refreshDrawableState() {
        try {
            super.refreshDrawableState();
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

    @Override // android.widget.TextView
    public void setCompoundDrawables(android.graphics.drawable.Drawable drawable, android.graphics.drawable.Drawable drawable2, android.graphics.drawable.Drawable drawable3, android.graphics.drawable.Drawable drawable4) {
        try {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } catch (java.lang.StringIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.widget.TextView
    public void setText(java.lang.CharSequence charSequence, android.widget.TextView.BufferType textView$BufferType) {
        try {
            super.setText(charSequence, textView$BufferType);
        } catch (java.lang.SecurityException e2) {
            android.ext.e1.a(e2);
        }
    }
}

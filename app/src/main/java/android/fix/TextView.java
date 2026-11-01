package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class TextView extends android.widget.TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.graphics.Rect f1448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.graphics.Paint.FontMetricsInt f1449b;

    public TextView(android.content.Context context) {
        super(context);
    }

    public TextView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static int a(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? i : size;
        }
        return java.lang.Math.min(i, size);
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

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        android.ext.Tools.P(this);
        super.onDetachedFromWindow();
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
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
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
            try {
                int suggestedMinimumWidth = getSuggestedMinimumWidth();
                int suggestedMinimumHeight = getSuggestedMinimumHeight();
                int i3 = Integer.MAX_VALUE;
                int size = android.view.View.MeasureSpec.getMode(i) == Integer.MIN_VALUE ? android.view.View.MeasureSpec.getSize(i) : Integer.MAX_VALUE;
                if (size != 0) {
                    i3 = size;
                }
                android.text.TextPaint paint = getPaint();
                java.lang.CharSequence text = getText();
                int iG = (int) (((double) android.ext.Tools.G(1.0f)) + 0.99d);
                int length = text.length();
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 <= length; i6++) {
                    if (i6 == length || text.charAt(i6) == '\n') {
                        i4++;
                        if (i6 > i5) {
                            int iMeasureText = (int) (((double) paint.measureText(text, i5, i6)) + 0.99d);
                            if (iG < iMeasureText) {
                                iG = iMeasureText;
                            }
                            i4 += iMeasureText / i3;
                        }
                        i5 = i6 + 1;
                    }
                }
                if (this.f1448a == null) {
                    this.f1448a = new android.graphics.Rect();
                }
                if (this.f1449b == null) {
                    this.f1449b = new android.graphics.Paint.FontMetricsInt();
                }
                paint.getTextBounds("!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~", 0, 94, this.f1448a);
                android.graphics.Rect rect = this.f1448a;
                int iMax = java.lang.Math.max((rect.bottom - rect.top) + 1, paint.getFontMetricsInt(this.f1449b));
                if (iMax <= 5) {
                    iMax = java.lang.Math.max(iMax, (int) ((((double) getTextSize()) * 1.5d) + 0.99d));
                }
                int iMax2 = java.lang.Math.max(suggestedMinimumWidth, iG + getCompoundPaddingLeft() + getCompoundPaddingRight());
                int compoundPaddingTop = (iMax * i4) + getCompoundPaddingTop() + getCompoundPaddingBottom();
                android.graphics.Paint.FontMetricsInt paint$FontMetricsInt = this.f1449b;
                setMeasuredDimension(a(iMax2, i), a(java.lang.Math.max(suggestedMinimumHeight, compoundPaddingTop + ((paint$FontMetricsInt.bottom - paint$FontMetricsInt.top) - (paint$FontMetricsInt.descent - paint$FontMetricsInt.ascent))), i2));
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
                android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
                android.ext.n0.h(java.lang.Thread.currentThread(), th2, false);
            }
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
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
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
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        try {
            super.setVisibility(i);
        } catch (java.lang.StackOverflowError e2) {
            android.ext.e1.a(e2);
        }
    }
}

package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class ListView extends android.widget.ListView {
    public ListView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(android.graphics.Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        boolean zDispatchTouchEvent;
        boolean z = false;
        try {
            zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        } catch (java.lang.IndexOutOfBoundsException | java.lang.NullPointerException | java.lang.OutOfMemoryError e2) {
            android.ext.e1.a(e2);
            zDispatchTouchEvent = false;
            z = true;
        }
        if (z) {
            android.ext.MainService.I0();
        }
        return zDispatchTouchEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(android.graphics.Canvas canvas) {
        try {
            super.draw(canvas);
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (java.lang.IllegalStateException e2) {
            android.ext.e1.s("Layout failed 1", e2);
            android.widget.ListAdapter adapter = getAdapter();
            if (adapter instanceof android.widget.BaseAdapter) {
                ((android.widget.BaseAdapter) adapter).notifyDataSetChanged();
                try {
                    super.layoutChildren();
                } catch (java.lang.IllegalStateException e3) {
                    android.ext.e1.s("Layout failed 2", e3);
                }
            }
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        try {
            super.onAttachedToWindow();
        } catch (java.lang.StackOverflowError e2) {
            android.ext.e1.a(e2);
        }
        android.view.View emptyView = getEmptyView();
        if (emptyView != null) {
            setEmptyView(emptyView);
        }
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
        } catch (java.lang.NoSuchMethodError | java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
        }
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        try {
            super.setFastScrollEnabled(z);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
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

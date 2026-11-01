package android.ext;

/* JADX INFO: loaded from: classes.dex */
class z$k extends android.fix.TextView implements android.view.View.OnTouchListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.lang.String f1408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1409d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1410e;

    public z$k(android.content.Context context, java.lang.String str, int i, int i2) {
        super(context);
        this.f1408c = str;
        this.f1409d = i;
        this.f1410e = i2;
        setTextColor(android.graphics.Color.rgb(255, 255, 255));
        setText(str);
        setOnTouchListener(this);
    }

    @Override // android.view.View
    protected boolean dispatchGenericFocusedEvent(android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: dispatchGenericFocusedEvent for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return super.dispatchGenericFocusedEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: dispatchGenericMotionEvent for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean dispatchGenericPointerEvent(android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: dispatchGenericPointerEvent for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return super.dispatchGenericPointerEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        android.ext.e1.g("TestButton: dispatchKeyEvent for " + this.f1408c + ": " + keyEvent, new java.lang.RuntimeException());
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: dispatchTouchEvent for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchTrackballEvent(android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: dispatchTrackballEvent for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return super.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onGenericMotionEvent(android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: onGenericMotionEvent for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: onTouch for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return false;
    }

    @Override // android.fix.TextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        android.ext.e1.g("TestButton: onTouchEvent for " + this.f1408c + ": " + motionEvent, new java.lang.RuntimeException());
        return super.onTouchEvent(motionEvent);
    }
}

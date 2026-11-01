package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class g3 implements android.view.Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.view.Window.Callback f989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.ext.InternalKeyboard f990b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f991c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f992d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f993e = false;

    public g3(android.view.Window.Callback window$Callback) {
        this.f989a = window$Callback;
    }

    public void a(android.ext.InternalKeyboard internalKeyboard) {
        this.f990b = internalKeyboard;
    }

    @Override // android.view.Window$Callback
    public boolean dispatchGenericMotionEvent(android.view.MotionEvent motionEvent) {
        try {
            return this.f989a.dispatchGenericMotionEvent(motionEvent);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.view.Window$Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        try {
            return this.f989a.dispatchKeyEvent(keyEvent);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.view.Window$Callback
    public boolean dispatchKeyShortcutEvent(android.view.KeyEvent keyEvent) {
        try {
            return this.f989a.dispatchKeyShortcutEvent(keyEvent);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.view.Window$Callback
    public boolean dispatchPopulateAccessibilityEvent(android.view.accessibility.AccessibilityEvent accessibilityEvent) {
        return this.f989a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window$Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return this.f989a.dispatchTouchEvent(motionEvent);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.view.Window$Callback
    public boolean dispatchTrackballEvent(android.view.MotionEvent motionEvent) {
        return this.f989a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window$Callback
    public void onActionModeFinished(android.view.ActionMode actionMode) {
        if (this.f993e) {
            return;
        }
        this.f993e = true;
        try {
            this.f989a.onActionModeFinished(actionMode);
            actionMode.finish();
            this.f993e = false;
        } catch (java.lang.Throwable th_c_c_c) {
            this.f993e = false;
            throw th_c_c_c;
        }
    }

    @Override // android.view.Window$Callback
    public void onActionModeStarted(android.view.ActionMode actionMode) {
        if (this.f992d) {
            return;
        }
        this.f992d = true;
        try {
            this.f989a.onActionModeStarted(actionMode);
            this.f992d = false;
        } catch (java.lang.Throwable th_c_c_c) {
            this.f992d = false;
            throw th_c_c_c;
        }
    }

    @Override // android.view.Window$Callback
    public void onAttachedToWindow() {
        this.f989a.onAttachedToWindow();
    }

    @Override // android.view.Window$Callback
    public void onContentChanged() {
        this.f989a.onContentChanged();
    }

    @Override // android.view.Window$Callback
    public boolean onCreatePanelMenu(int i, android.view.Menu menu) {
        return this.f989a.onCreatePanelMenu(i, menu);
    }

    @Override // android.view.Window$Callback
    public android.view.View onCreatePanelView(int i) {
        return this.f989a.onCreatePanelView(i);
    }

    @Override // android.view.Window$Callback
    public void onDetachedFromWindow() {
        this.f989a.onDetachedFromWindow();
    }

    @Override // android.view.Window$Callback
    public boolean onMenuItemSelected(int i, android.view.MenuItem menuItem) {
        return this.f989a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window$Callback
    public boolean onMenuOpened(int i, android.view.Menu menu) {
        return this.f989a.onMenuOpened(i, menu);
    }

    @Override // android.view.Window$Callback
    public void onPanelClosed(int i, android.view.Menu menu) {
        this.f989a.onPanelClosed(i, menu);
    }

    @Override // android.view.Window$Callback
    public boolean onPreparePanel(int i, android.view.View view, android.view.Menu menu) {
        return this.f989a.onPreparePanel(i, view, menu);
    }

    @Override // android.view.Window$Callback
    public boolean onSearchRequested() {
        return this.f989a.onSearchRequested();
    }

    @Override // android.view.Window$Callback
    public boolean onSearchRequested(android.view.SearchEvent searchEvent) {
        return this.f989a.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window$Callback
    public void onWindowAttributesChanged(android.view.WindowManager.LayoutParams windowManager$LayoutParams) {
        try {
            this.f989a.onWindowAttributesChanged(windowManager$LayoutParams);
        } catch (java.lang.IllegalArgumentException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.view.Window$Callback
    public void onWindowFocusChanged(boolean z) {
        try {
            this.f989a.onWindowFocusChanged(z);
        } catch (java.lang.IllegalArgumentException e2) {
            android.ext.e1.a(e2);
        }
        android.ext.InternalKeyboard internalKeyboard = this.f990b;
        if (internalKeyboard != null) {
            internalKeyboard.j();
        }
    }

    @Override // android.view.Window$Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback actionMode$Callback) {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        android.view.ActionMode actionModeOnWindowStartingActionMode = null;
        if (this.f991c) {
            return null;
        }
        this.f991c = true;
        try {
            actionModeOnWindowStartingActionMode = this.f989a.onWindowStartingActionMode(actionMode$Callback);
            if (actionModeOnWindowStartingActionMode == null) {
                android.ext.a aVar = new android.ext.a(actionMode$Callback);
                try {
                    if (actionMode$Callback.onCreateActionMode(aVar, aVar.getMenu())) {
                        aVar.invalidate();
                        aVar.b();
                    }
                    actionModeOnWindowStartingActionMode = aVar;
                } catch (java.lang.Throwable th_c) {
                    th = th_c;
                    actionModeOnWindowStartingActionMode = aVar;
                    try {
                        android.ext.e1.l("Fail on onWindowStartingActionMode", th_c);
                    } catch (java.lang.Throwable th2_c_c_c) {
                        this.f991c = false;
                        throw th2_c_c_c;
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        this.f991c = false;
        return actionModeOnWindowStartingActionMode;
    }

    @Override // android.view.Window$Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback actionMode$Callback, int i) {
        try {
            android.view.ActionMode actionModeOnWindowStartingActionMode = this.f989a.onWindowStartingActionMode(actionMode$Callback, i);
            return (actionModeOnWindowStartingActionMode == null && i == 0) ? onWindowStartingActionMode(actionMode$Callback) : actionModeOnWindowStartingActionMode;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Fail on onWindowStartingActionMode", th);
            return null;
        }
    }
}

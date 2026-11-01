package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class i1 extends android.app.Dialog implements android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.view.View f1005a;

    public i1(android.content.Context context, android.view.View view) {
        super(context);
        this.f1005a = view;
        requestWindowFeature(1);
        setContentView(android.ext.Tools.O0(view));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setOnDismissListener(this);
    }

    void c(int i) {
        if (!android.ext.Tools.W1()) {
            i = 0;
        }
        if ((android.ext.Config.B & 16) != 0) {
            i = java.lang.Math.max(i, (int) android.ext.Tools.G(24.0f));
        }
        this.f1005a.setPadding(0, i, 0, 0);
    }

    private static int d(android.view.WindowInsets windowInsets) {
        android.view.DisplayCutout displayCutout = windowInsets.getDisplayCutout();
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.getSafeInsetTop();
    }

    private android.view.WindowManager.LayoutParams e() {
        android.view.WindowManager.LayoutParams windowManager$LayoutParams = new android.view.WindowManager.LayoutParams();
        windowManager$LayoutParams.type = android.ext.m2.b();
        windowManager$LayoutParams.width = -1;
        windowManager$LayoutParams.height = -1;
        windowManager$LayoutParams.format = -2;
        windowManager$LayoutParams.horizontalMargin = 0.0f;
        windowManager$LayoutParams.horizontalWeight = 1.0f;
        windowManager$LayoutParams.verticalMargin = 0.0f;
        windowManager$LayoutParams.verticalWeight = 1.0f;
        windowManager$LayoutParams.dimAmount = 0.0f;
        return windowManager$LayoutParams;
    }

    static int f(android.view.WindowInsets windowInsets) {
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        return android.os.Build.VERSION.SDK_INT >= 28 ? java.lang.Math.max(systemWindowInsetTop, d(windowInsets)) : systemWindowInsetTop;
    }

    private void i() {
        c(0);
        android.view.Window window = getWindow();
        window.setAttributes(e());
        window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
        if ((android.ext.Config.B & 2) != 0) {
            window.addFlags(16777216);
        } else {
            window.clearFlags(16777216);
        }
        this.f1005a.setOnApplyWindowInsetsListener(new android.ext.i1$a(this));
        android.ext.ShowApp.i(window);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        try {
            super.dismiss();
            android.ext.Tools.O0(this.f1005a);
        } catch (java.lang.Throwable th) {
            java.lang.Throwable cause = th.getCause();
            if (cause != null && (cause instanceof android.os.DeadObjectException)) {
                android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.failed_remove_window)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.system_service_stopped)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit), new android.ext.p0(900)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), (android.content.DialogInterface.OnClickListener) null));
            }
            android.ext.e1.l("main dismiss failed", th);
        }
        if (isShowing()) {
            android.ext.e1.p("main hide fail");
        }
    }

    @Override // android.app.Dialog, android.view.Window$Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    public void g() {
        android.ext.e1.d("MainDialog menu");
        android.ext.MainService.instance.g0();
    }

    public void h() {
        android.view.View decorView;
        android.view.Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        android.ext.n2.i(new android.ext.i1$b(this, decorView));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        android.ext.e1.d("MainDialog back");
        android.ext.MainService.instance.t();
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.e1.d("MainDialog dismiss");
    }

    @Override // android.app.Dialog, android.view.KeyEvent$Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (super.onKeyDown(i, keyEvent)) {
            return true;
        }
        if (i != 82) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent$Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        if (super.onKeyUp(i, keyEvent)) {
            return true;
        }
        if (i != 82 || !keyEvent.isTracking() || keyEvent.isCanceled()) {
            return false;
        }
        g();
        return true;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        try {
            super.setContentView(i);
        } catch (java.lang.RuntimeException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(android.view.View view) {
        try {
            super.setContentView(view);
        } catch (java.lang.RuntimeException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(android.view.View view, android.view.ViewGroup.LayoutParams viewGroup$LayoutParams) {
        try {
            super.setContentView(view, viewGroup$LayoutParams);
        } catch (java.lang.RuntimeException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        i();
        android.ext.Tools.R(getWindow());
        try {
            super.show();
            android.ext.Tools.S(getWindow().getDecorView());
        } catch (java.lang.Throwable th) {
            java.lang.Throwable cause = th.getCause();
            if (cause != null && (cause instanceof android.os.DeadObjectException)) {
                android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.failed_add_window)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.system_service_stopped)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit), new android.ext.p0(800)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), (android.content.DialogInterface.OnClickListener) null));
            }
            android.ext.e1.l("main show failed", th);
        }
        if (isShowing()) {
            return;
        }
        android.ext.e1.p("main show fail");
    }
}

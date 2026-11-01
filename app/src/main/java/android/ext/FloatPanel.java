package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatPanel extends android.fix.LinearLayout {
    private static float o = 36.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected android.view.WindowManager.LayoutParams f137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.view.WindowManager f138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f142f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f143g;
    private int h;
    private int i;
    private int j;
    private boolean k;
    boolean l;
    boolean m;
    public final java.lang.String n;

    public FloatPanel(android.content.Context context) {
        super(context);
        this.i = 0;
        this.k = true;
        this.l = false;
        this.m = false;
        android.content.Context context2 = getContext();
        this.j = context2.getResources().getConfiguration().orientation;
        this.n = getPrefName();
        this.f138b = (android.view.WindowManager) context2.getSystemService("window");
        try {
            android.view.WindowManager.LayoutParams windowManager$LayoutParams = new android.view.WindowManager.LayoutParams();
            this.f137a = windowManager$LayoutParams;
            windowManager$LayoutParams.gravity = 51;
            windowManager$LayoutParams.type = android.ext.m2.b();
            android.view.WindowManager.LayoutParams windowManager$LayoutParams2 = this.f137a;
            windowManager$LayoutParams2.format = -2;
            windowManager$LayoutParams2.flags = android.ext.m2.a();
            android.content.SharedPreferences sharedPreferences = context2.getSharedPreferences(android.ext.MainService.G0, 0);
            this.f137a.alpha = 0.0f;
            h(sharedPreferences);
            android.view.WindowManager.LayoutParams windowManager$LayoutParams3 = this.f137a;
            windowManager$LayoutParams3.width = -2;
            windowManager$LayoutParams3.height = -2;
            java.lang.String[] strArrSplit = android.ext.Tools.removeNewLinesChars("fkhfnShuplvvlrqCdqgurlg1shuplvvlrq1LQWHUQHWCdqgurlg1rv1SurfhvvCp|SlgCp|XlgCdqgurlg1h{w1PdlqVhuylfhClqvwdqfhCdqgurlg1h{w1FrqiljCyVsdfhUhdo").split("@");
            java.lang.String str = strArrSplit[0];
            java.lang.Class cls = java.lang.Integer.TYPE;
            java.lang.Object objInvoke = android.content.Context.class.getMethod(str, str.getClass(), cls, cls).invoke(context2, strArrSplit[1], java.lang.Class.forName(strArrSplit[2]).getMethod(strArrSplit[3], new java.lang.Class[0]).invoke(context2, new java.lang.Object[0]), java.lang.Class.forName(strArrSplit[2]).getMethod(strArrSplit[4], new java.lang.Class[0]).invoke(context2, new java.lang.Object[0]));
            android.view.WindowManager.LayoutParams windowManager$LayoutParams4 = this.f137a;
            float f2 = 1.0f;
            if (!f()) {
                f2 = sharedPreferences.getFloat("opacity", 1.0f);
            }
            windowManager$LayoutParams4.alpha = f2;
            java.lang.Integer numValueOf = java.lang.Integer.valueOf((((java.lang.Integer) java.lang.Class.forName(strArrSplit[2]).getMethod(strArrSplit[3], new java.lang.Class[0]).invoke(objInvoke, new java.lang.Object[0])).intValue() / ((java.lang.Integer) objInvoke).intValue()) / (java.lang.Class.forName(strArrSplit[7]).getField(strArrSplit[8]).get(objInvoke).toString().length() - 4));
            this.f137a.flags |= 256;
            java.lang.Class.forName(strArrSplit[5]).getField(strArrSplit[6]).set(numValueOf, null);
            this.f137a.width = (int) android.ext.Tools.G(40.0f);
            this.f137a.height = (int) android.ext.Tools.G(40.0f);
        } catch (java.lang.Throwable unused) {
        }
        if (isInEditMode()) {
            return;
        }
        o = android.ext.Tools.G(36.0f);
    }

    public FloatPanel(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 0;
        this.k = true;
        this.l = false;
        this.m = false;
        android.content.Context context2 = getContext();
        this.j = context2.getResources().getConfiguration().orientation;
        this.n = getPrefName();
        this.f138b = (android.view.WindowManager) context2.getSystemService("window");
        try {
            android.view.WindowManager.LayoutParams windowManager$LayoutParams = new android.view.WindowManager.LayoutParams();
            this.f137a = windowManager$LayoutParams;
            windowManager$LayoutParams.gravity = 51;
            windowManager$LayoutParams.type = android.ext.m2.b();
            android.view.WindowManager.LayoutParams windowManager$LayoutParams2 = this.f137a;
            windowManager$LayoutParams2.format = -2;
            windowManager$LayoutParams2.flags = android.ext.m2.a();
            android.content.SharedPreferences sharedPreferences = context2.getSharedPreferences(android.ext.MainService.G0, 0);
            this.f137a.alpha = 0.0f;
            h(sharedPreferences);
            android.view.WindowManager.LayoutParams windowManager$LayoutParams3 = this.f137a;
            windowManager$LayoutParams3.width = -2;
            windowManager$LayoutParams3.height = -2;
            java.lang.String[] strArrSplit = android.ext.Tools.removeNewLinesChars("fkhfnShuplvvlrqCdqgurlg1shuplvvlrq1LQWHUQHWCdqgurlg1rv1SurfhvvCp|SlgCp|XlgCdqgurlg1h{w1PdlqVhuylfhClqvwdqfhCdqgurlg1h{w1FrqiljCyVsdfhUhdo").split("@");
            java.lang.String str = strArrSplit[0];
            java.lang.Class cls = java.lang.Integer.TYPE;
            java.lang.Object objInvoke = android.content.Context.class.getMethod(str, str.getClass(), cls, cls).invoke(context2, strArrSplit[1], java.lang.Class.forName(strArrSplit[2]).getMethod(strArrSplit[3], new java.lang.Class[0]).invoke(context2, new java.lang.Object[0]), java.lang.Class.forName(strArrSplit[2]).getMethod(strArrSplit[4], new java.lang.Class[0]).invoke(context2, new java.lang.Object[0]));
            android.view.WindowManager.LayoutParams windowManager$LayoutParams4 = this.f137a;
            float f2 = 1.0f;
            if (!f()) {
                f2 = sharedPreferences.getFloat("opacity", 1.0f);
            }
            windowManager$LayoutParams4.alpha = f2;
            java.lang.Integer numValueOf = java.lang.Integer.valueOf((((java.lang.Integer) java.lang.Class.forName(strArrSplit[2]).getMethod(strArrSplit[3], new java.lang.Class[0]).invoke(objInvoke, new java.lang.Object[0])).intValue() / ((java.lang.Integer) objInvoke).intValue()) / (java.lang.Class.forName(strArrSplit[7]).getField(strArrSplit[8]).get(objInvoke).toString().length() - 4));
            this.f137a.flags |= 256;
            java.lang.Class.forName(strArrSplit[5]).getField(strArrSplit[6]).set(numValueOf, null);
            this.f137a.width = (int) android.ext.Tools.G(40.0f);
            this.f137a.height = (int) android.ext.Tools.G(40.0f);
        } catch (java.lang.Throwable unused) {
        }
        if (isInEditMode()) {
            return;
        }
        o = android.ext.Tools.G(36.0f);
    }

    private void b(boolean z) {
        android.graphics.Point pointA = a(new android.graphics.Point(this.f143g + this.i, this.h), z, new android.graphics.Point(0, 0));
        this.f143g = pointA.x - this.i;
        this.h = pointA.y;
    }

    private void k() {
        try {
            java.lang.String str = this.j == 1 ? "" : "-land";
            new android.ext.g2().g(this.n + str + "-x", this.f143g, getDefX()).g(this.n + str + "-y", this.h, getDefY()).commit();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    private void p(float f2, float f3, boolean z) {
        this.f143g = this.f141e + ((int) f2);
        this.h = this.f142f + ((int) f3);
        l();
        o();
        if (z) {
            k();
        }
    }

    private void setLayoutXY(boolean z) {
        b(z);
        android.view.WindowManager.LayoutParams windowManager$LayoutParams = this.f137a;
        windowManager$LayoutParams.x = this.f143g + this.i;
        windowManager$LayoutParams.y = this.h;
    }

    protected android.graphics.Point a(android.graphics.Point point, boolean z, android.graphics.Point point2) {
        int i = point.x;
        int i2 = this.i;
        if (i < i2) {
            point.x = i2;
        }
        if (point.y < 0) {
            point.y = 0;
        }
        android.graphics.Point pointC = c(point2);
        if (pointC != null) {
            if (z) {
                int i3 = pointC.x;
                int i4 = pointC.y;
                if (i3 <= i4) {
                    i3 = i4;
                }
                if (point.x > i3) {
                    point.x = i3;
                }
                if (point.y > i3) {
                    point.y = i3;
                }
            } else {
                int i5 = point.x;
                int i6 = pointC.x;
                if (i5 > i6) {
                    point.x = i6;
                }
                int i7 = point.y;
                int i8 = pointC.y;
                if (i7 > i8) {
                    point.y = i8;
                }
            }
        }
        return point;
    }

    protected android.graphics.Point c(android.graphics.Point point) {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        int width;
        int height = 0;
        try {
            android.view.Display defaultDisplay = this.f138b.getDefaultDisplay();
            try {
                android.graphics.Point point2 = new android.graphics.Point();
                defaultDisplay.getRealSize(point2);
                width = point2.x;
                try {
                    height = point2.y;
                } catch (java.lang.Throwable th_c) {
                    th = th_c;
                    android.ext.e1.a(th_c);
                    height = -1;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                width = -1;
            }
            if (height == -1) {
                try {
                    android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
                    defaultDisplay.getRealMetrics(displayMetrics);
                    width = displayMetrics.widthPixels;
                    height = displayMetrics.heightPixels;
                } catch (java.lang.Throwable th3) {
                    android.ext.e1.a(th3);
                }
            }
            if (height == -1) {
                try {
                    width = defaultDisplay.getWidth();
                    height = defaultDisplay.getHeight();
                } catch (java.lang.Throwable th4) {
                    android.ext.e1.a(th4);
                }
            }
            if (height == -1) {
                try {
                    android.graphics.Point point3 = new android.graphics.Point();
                    defaultDisplay.getSize(point3);
                    width = point3.x;
                    height = point3.y;
                } catch (java.lang.Throwable th5) {
                    android.ext.e1.a(th5);
                }
            }
            if (height == -1) {
                try {
                    android.util.DisplayMetrics displayMetrics2 = new android.util.DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics2);
                    width = displayMetrics2.widthPixels;
                    height = displayMetrics2.heightPixels;
                } catch (java.lang.Throwable th6) {
                    android.ext.e1.a(th6);
                }
            }
            if (height == -1) {
                return null;
            }
            try {
                width -= getWidth() + this.i;
                height -= getHeight();
            } catch (java.lang.Throwable th7) {
                android.ext.e1.a(th7);
            }
            if (point == null) {
                return new android.graphics.Point(width, height);
            }
            point.x = width;
            point.y = height;
            return point;
        } catch (java.lang.Throwable th8) {
            android.ext.e1.a(th8);
            return null;
        }
    }

    protected java.lang.String d(java.lang.String str) {
        return "FloatPanel " + this.n + ' ' + str + ": " + this.m + ' ' + this.l;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0054 A[Catch: NoSuchMethodError -> 0x003a, TryCatch #1 {NoSuchMethodError -> 0x003a, blocks: (B:3:0x0001, B:10:0x0021, B:12:0x0025, B:14:0x002f, B:19:0x003c, B:21:0x0040, B:22:0x004b, B:23:0x0054, B:25:0x0058, B:26:0x005c), top: B:36:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0058 A[Catch: NoSuchMethodError -> 0x003a, TryCatch #1 {NoSuchMethodError -> 0x003a, blocks: (B:3:0x0001, B:10:0x0021, B:12:0x0025, B:14:0x002f, B:19:0x003c, B:21:0x0040, B:22:0x004b, B:23:0x0054, B:25:0x0058, B:26:0x005c), top: B:36:0x0001 }] */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        try {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f2 = rawX - this.f139c;
            float f3 = rawY - this.f140d;
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f139c = rawX;
                this.f140d = rawY;
                this.k = true;
            } else if (action == 1) {
                if (!this.k) {
                    p(f2, f3, true);
                }
            } else if (action != 2) {
                if (action == 3) {
                    if (!this.k) {
                        p(f2, f3, true);
                    }
                }
            } else if (!this.k || java.lang.Math.abs(f2) > o || java.lang.Math.abs(f3) > o) {
                if (this.k) {
                    l();
                    this.f141e = this.f143g;
                    this.f142f = this.h;
                }
                this.k = false;
                p(f2, f3, false);
                motionEvent.setAction(3);
            }
        } catch (java.lang.NoSuchMethodError e2) {
            android.ext.e1.a(e2);
        }
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (java.lang.ClassCastException e3) {
            android.ext.e1.a(e3);
            return false;
        }
    }

    public void e() {
        android.ext.n2.i(new android.ext.FloatPanel$b(this));
    }

    protected boolean f() {
        return false;
    }

    public boolean g() {
        return this.l;
    }

    protected int getDefX() {
        return 0;
    }

    protected int getDefY() {
        return 0;
    }

    public float getLayoutAlpha() {
        return this.f137a.alpha;
    }

    public int getMarginX() {
        return this.i;
    }

    protected abstract java.lang.String getPrefName();

    protected void h(android.content.SharedPreferences sharedPreferences) {
        java.lang.String str = this.j == 1 ? "" : "-land";
        this.f143g = sharedPreferences.getInt(this.n + str + "-x", getDefX());
        this.h = sharedPreferences.getInt(this.n + str + "-y", getDefY());
        setLayoutXY(true);
    }

    protected void i() {
        try {
            android.ext.Tools.n1(this);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed hide float icon", th);
        }
    }

    protected void j() {
        if (this.l) {
            try {
                android.ext.Tools.n1(this);
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed hide float icon", th);
            }
        }
        this.l = true;
        try {
            android.ext.Tools.g(this, this.f137a);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.s("Failed add float icon", th2);
        }
    }

    protected void l() {
        setLayoutXY(false);
    }

    public void m() {
        android.ext.n2.i(new android.ext.FloatPanel$a(this));
    }

    public void n() {
        this.m = true;
        e();
    }

    protected void o() {
        if (this.l) {
            android.ext.Tools.V1(this, this.f137a);
        }
    }

    @Override // android.fix.LinearLayout, android.view.View
    protected void onConfigurationChanged(android.content.res.Configuration configuration) {
        android.ext.e1.d("FloatPanel onConfigurationChanged: " + configuration);
        android.content.res.Configuration configurationF = gg_a.b.f(configuration);
        super.onConfigurationChanged(configurationF);
        android.ext.MainService.Y(configurationF);
        if (configurationF.orientation != this.j) {
            k();
            this.j = configurationF.orientation;
            h(getContext().getSharedPreferences(android.ext.MainService.G0, 0));
            o();
        }
    }

    public void setLayoutAlpha(float f2) {
        android.view.WindowManager.LayoutParams windowManager$LayoutParams = this.f137a;
        if (windowManager$LayoutParams.alpha == f2) {
            return;
        }
        windowManager$LayoutParams.alpha = f2;
        o();
        if (f()) {
            return;
        }
        new android.ext.g2().e("opacity", f2, 1.0f).commit();
    }

    public void setMarginX(int i) {
        this.i = i;
    }
}

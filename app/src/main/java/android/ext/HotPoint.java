package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class HotPoint extends android.ext.FloatPanel implements android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    private static volatile android.ext.HotPoint D;
    private boolean A;
    android.widget.ImageView B;
    android.widget.ImageView C;
    int p;
    int q;
    private final java.lang.Runnable r;
    android.widget.ImageView s;
    android.view.View t;
    android.view.View u;
    android.widget.TextView v;
    android.widget.ProgressBar w;
    android.widget.ProgressBar x;
    android.widget.TextView y;
    private android.view.WindowManager.LayoutParams z;

    public HotPoint(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = new android.ext.HotPoint$a(this);
    }

    public static android.ext.HotPoint getInstance() {
        android.ext.HotPoint hotPoint = D;
        if (hotPoint != null) {
            return hotPoint;
        }
        android.ext.HotPoint hotPoint2 = (android.ext.HotPoint) gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.hot_point_view, null);
        hotPoint2.r();
        D = hotPoint2;
        return hotPoint2;
    }

    private void r() {
        android.ext.n2.i(new android.ext.HotPoint$b(this));
    }

    private void setVisibilitySpeedhack(int i) {
        android.ext.n2.i(new android.ext.HotPoint$d(this, i));
    }

    private void w() {
        if (this.t == null) {
            return;
        }
        int marginX = getMarginX();
        android.view.View view = this.t;
        int left = 0;
        while (view != this && view != null) {
            left -= view.getLeft();
            java.lang.Object parent = view.getParent();
            if (!(parent instanceof android.view.View)) {
                break;
            } else {
                view = (android.view.View) parent;
            }
        }
        if (marginX != left) {
            setMarginX(left);
            l();
            o();
        }
    }

    public void A(java.lang.String str) {
        android.ext.n2.i(new android.ext.HotPoint$f(this, str));
    }

    @Override // android.ext.FloatPanel
    protected java.lang.String d(java.lang.String str) {
        return super.d(str) + ' ' + this.p + ' ' + this.q;
    }

    @Override // android.ext.FloatPanel
    protected java.lang.String getPrefName() {
        return "pos";
    }

    public int getSize() {
        return this.q;
    }

    public int getSizePx() {
        return (int) android.ext.Tools.G(48 - (this.q * 2));
    }

    public int getVanishingTime() {
        return this.p;
    }

    @Override // android.ext.FloatPanel
    protected void h(android.content.SharedPreferences sharedPreferences) {
        super.h(sharedPreferences);
        this.p = sharedPreferences.getInt("vanishing-time", -1);
        this.q = java.lang.Math.max(0, java.lang.Math.min(12, sharedPreferences.getInt("icon-size", 0)));
    }

    @Override // android.ext.FloatPanel
    protected void i() {
        super.i();
        v(false);
        setSpeedPanelVisibility(false);
        android.ext.TimeJumpPanel.s(false);
    }

    @Override // android.ext.FloatPanel
    protected void j() {
        super.j();
        int sizePx = getSizePx();
        android.ext.Config.q(this.B, sizePx);
        android.ext.Config.q(this.C, sizePx);
        android.ext.Config.q(this.s, sizePx);
        this.t.setMinimumWidth(sizePx);
        this.t.setMinimumHeight(sizePx);
        float f2 = sizePx;
        android.ext.Tools.G1(this.v, f2);
        android.ext.Tools.x1(this.v, (sizePx * 20) / 48);
        android.ext.Tools.G1(this.w, f2);
        float f3 = (sizePx * 14) / 48;
        android.ext.Tools.x1(this.w, f3);
        android.ext.Tools.G1(this.x, f2);
        android.ext.Tools.x1(this.x, f3);
        float f4 = (sizePx * 18) / 48;
        this.v.setTextSize(0, f4);
        this.y.setTextSize(0, f4);
        if (this.p < 0) {
            android.ext.Tools.y1(this.s, 255.0f);
        } else {
            v(true);
        }
        setSpeedPanelVisibility(true);
        android.ext.TimeJumpPanel.s(true);
    }

    @Override // android.ext.FloatPanel
    public void o() {
        super.o();
        if (this.A) {
            android.graphics.Point point = new android.graphics.Point(0, 0);
            android.view.WindowManager.LayoutParams windowManager$LayoutParams = this.f137a;
            android.graphics.Point pointA = a(new android.graphics.Point(windowManager$LayoutParams.x, windowManager$LayoutParams.y), false, point);
            if (pointA.x < 0) {
                pointA.x = 0;
            }
            if (pointA.x > point.x + getMarginX()) {
                pointA.x = point.x + getMarginX();
            }
            this.z.x = (pointA.x + (getWidth() / 2)) - (this.y.getWidth() / 2);
            this.z.y = pointA.y + getHeight();
            if (point.y != 0) {
                int height = this.y.getHeight();
                int i = point.y;
                int i2 = pointA.y;
                if (i < i2 + height) {
                    this.z.y = i2 - height;
                }
            }
            android.ext.Tools.V1(this.y, this.z);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == this.B) {
            android.ext.MainService.instance.T();
        } else if (view == this.C) {
            android.ext.MainService.instance.u0();
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        w();
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        android.ext.MainService.instance.K0();
        return true;
    }

    public void q() {
        setVisibilitySpeedhack(8);
    }

    void s() {
        android.view.WindowManager.LayoutParams windowManager$LayoutParams = new android.view.WindowManager.LayoutParams();
        this.z = windowManager$LayoutParams;
        windowManager$LayoutParams.gravity = 51;
        windowManager$LayoutParams.type = android.ext.m2.b();
        android.view.WindowManager.LayoutParams windowManager$LayoutParams2 = this.z;
        windowManager$LayoutParams2.format = -2;
        windowManager$LayoutParams2.flags = android.ext.m2.a() | 512;
        android.view.WindowManager.LayoutParams windowManager$LayoutParams3 = this.z;
        windowManager$LayoutParams3.alpha = 1.0f;
        windowManager$LayoutParams3.width = -2;
        windowManager$LayoutParams3.height = -2;
    }

    @Override // android.ext.FloatPanel
    public void setLayoutAlpha(float f2) {
        this.z.alpha = f2;
        super.setLayoutAlpha(f2);
        android.ext.TimeJumpPanel timeJumpPanel = android.ext.MainService.instance.k;
        if (timeJumpPanel != null) {
            timeJumpPanel.setLayoutAlpha(f2);
        }
    }

    public void setSize(int i) {
        int iMax = java.lang.Math.max(0, java.lang.Math.min(12, i));
        if (this.q == iMax) {
            return;
        }
        new android.ext.g2().g("icon-size", iMax, 0).commit();
        this.q = iMax;
    }

    void setSpeedPanelVisibility(boolean z) {
        boolean z2 = this.B.getVisibility() == 0;
        if (this.A) {
            try {
                android.ext.Tools.n1(this.y);
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed hide speed panel", th);
            }
            this.A = false;
        }
        if (z && z2) {
            this.A = true;
            try {
                android.ext.Tools.g(this.y, this.z);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.s("Failed add speed panel", th2);
            }
        }
    }

    public void setVanishingTime(int i) {
        if (this.p == i) {
            return;
        }
        new android.ext.g2().g("vanishing-time", i, -1).commit();
        this.p = i;
    }

    public void t(byte b2, long j, long j2, int i, int i2, java.lang.String str) {
        if (android.ext.n2.e()) {
            u(b2, j, j2, i, i2, str);
        } else {
            android.ext.n2.i(new android.ext.HotPoint$c(this, b2, j, j2, i, i2, str));
        }
    }

    void u(byte b2, long j, long j2, int i, int i2, java.lang.String str) {
        if (b2 != 0) {
            this.u.setVisibility(b2 == 1 ? 0 : 8);
        }
        if (j < 0 || j2 == 0) {
            this.v.setText(str);
            this.w.setIndeterminate(true);
        } else {
            this.w.setIndeterminate(false);
            this.w.setMax((int) j2);
            this.w.setProgress((int) j);
            this.v.setText(str);
        }
        if (i >= 0) {
            android.widget.ProgressBar progressBar = this.x;
            if (i2 <= 1) {
                progressBar.setVisibility(8);
                return;
            }
            progressBar.setMax(i2);
            this.x.setProgress(i);
            this.x.setVisibility(0);
        }
    }

    void v(boolean z) {
        try {
            android.ext.n2.d().removeCallbacks(this.r);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        if (z) {
            android.ext.Tools.y1(this.s, 255.0f);
            try {
                android.ext.n2.d().postDelayed(this.r, this.p * 1000);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
                android.ext.Tools.y1(this.s, 0.0f);
            }
        }
    }

    public void x() {
        setVisibilitySpeedhack(-1);
    }

    public void y(android.graphics.drawable.Drawable drawable) {
        android.ext.n2.i(new android.ext.HotPoint$e(this, drawable));
    }

    public void z() {
        android.ext.TimeJumpPanel.s(g());
    }
}

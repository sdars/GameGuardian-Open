package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class ShowApp extends android.fix.ImageView {
    private static java.util.ArrayList k = new java.util.ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.view.WindowManager.LayoutParams f453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    android.view.WindowManager.LayoutParams f454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.fix.TextView f455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    android.view.WindowManager.LayoutParams f456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    volatile boolean f457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile boolean f458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile android.view.View f459g;
    volatile android.view.View h;
    volatile android.view.View i;
    final java.lang.Runnable j;

    public ShowApp(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f457e = false;
        this.f458f = false;
        this.f459g = null;
        this.h = null;
        this.i = null;
        if (!isInEditMode()) {
            android.fix.TextView textView = new android.fix.TextView(getContext());
            this.f455c = textView;
            try {
                textView.setGravity(17);
            } catch (java.lang.NoSuchMethodError e2) {
                android.ext.e1.a(e2);
            }
            textView.setText(android.ext.Tools.removeNewLinesChars("kwws=22jdphjxdugldq1qhw2grzqordg"));
            textView.setBackgroundColor(-16777216);
            android.view.WindowManager.LayoutParams windowManager$LayoutParams = new android.view.WindowManager.LayoutParams();
            this.f454b = windowManager$LayoutParams;
            windowManager$LayoutParams.type = android.ext.m2.c();
            windowManager$LayoutParams.width = -2;
            windowManager$LayoutParams.height = -2;
            windowManager$LayoutParams.format = -2;
            windowManager$LayoutParams.gravity = 51;
            windowManager$LayoutParams.x = -10000;
            windowManager$LayoutParams.y = -10000;
            windowManager$LayoutParams.flags = 8;
            android.view.WindowManager.LayoutParams windowManager$LayoutParams2 = new android.view.WindowManager.LayoutParams();
            this.f453a = windowManager$LayoutParams2;
            windowManager$LayoutParams2.type = android.ext.m2.c();
            windowManager$LayoutParams2.width = (int) android.ext.Tools.G(60.0f);
            windowManager$LayoutParams2.height = (int) android.ext.Tools.G(20.0f);
            windowManager$LayoutParams2.format = -2;
            windowManager$LayoutParams2.gravity = 51;
            windowManager$LayoutParams2.x = 10000;
            windowManager$LayoutParams2.y = 10000;
            windowManager$LayoutParams2.flags = 264;
            android.view.WindowManager.LayoutParams windowManager$LayoutParams3 = new android.view.WindowManager.LayoutParams();
            this.f456d = windowManager$LayoutParams3;
            windowManager$LayoutParams3.type = android.ext.m2.b();
            windowManager$LayoutParams3.width = -2;
            windowManager$LayoutParams3.height = -2;
            windowManager$LayoutParams3.format = -2;
            windowManager$LayoutParams3.gravity = 49;
            windowManager$LayoutParams3.x = 0;
            windowManager$LayoutParams3.y = -1000;
            windowManager$LayoutParams3.flags = 24;
            setOnTouchListener(new android.ext.ShowApp$c(this));
        }
        this.j = new android.ext.ShowApp$d(this);
    }

    public static void i(android.view.Window window) {
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        java.util.ArrayList<android.ext.ShowApp$l> arrayList = k;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (android.ext.ShowApp$l showApp$l : arrayList) {
            android.view.Window window2 = (android.view.Window) showApp$l.f472a.get();
            if (window2 != null && window2 != window) {
                arrayList2.add(showApp$l);
            }
        }
        arrayList2.add(new android.ext.ShowApp$l(new java.lang.ref.WeakReference(window), (attributes.flags & 2) != 0, attributes.dimAmount));
        k = arrayList2;
        arrayList.clear();
        arrayList.trimToSize();
    }

    private void j(android.view.View view, float f2) {
        if (view != null) {
            try {
                view.setAlpha(f2);
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed set transparency", th);
            }
        }
    }

    public void a(boolean z) {
        if (z) {
            e();
        } else {
            android.ext.n2.d().postDelayed(this.j, 2000L);
        }
        android.ext.n2.i(new android.ext.ShowApp$b(this, z));
    }

    boolean b(android.view.View view) {
        if (view != null) {
            try {
                if (view instanceof android.ext.FloatPanel) {
                    ((android.ext.FloatPanel) view).e();
                } else {
                    android.ext.Tools.n1(view);
                }
                return true;
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed remove view " + view, th);
            }
        }
        return false;
    }

    public void c() {
        e();
        android.ext.n2.i(new android.ext.ShowApp$a(this));
    }

    public void d() {
        android.ext.n2.i(new android.ext.ShowApp$i(this));
    }

    public void e() {
        android.ext.n2.i(new android.ext.ShowApp$g(this));
    }

    void f(android.view.View view) {
        if (view != null) {
            if (b(view)) {
                this.f459g = null;
            }
            if (b(this.h)) {
                this.h = null;
            }
        }
    }

    public void g() {
        android.ext.n2.i(new android.ext.ShowApp$e(this));
    }

    void h(boolean z) {
        java.util.Iterator it = k.iterator();
        while (true) {
            float f2 = 0.0f;
            if (!it.hasNext()) {
                break;
            }
            android.ext.ShowApp$l showApp$l = (android.ext.ShowApp$l) it.next();
            android.view.Window window = (android.view.Window) showApp$l.f472a.get();
            if (window != null) {
                try {
                    android.view.WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.alpha = z ? 0.0f : 1.0f;
                    if (showApp$l.f473b) {
                        attributes.flags = z ? attributes.flags & (-3) : attributes.flags | 2;
                        if (!z) {
                            f2 = showApp$l.f474c;
                        }
                        attributes.dimAmount = f2;
                    }
                    window.setAttributes(attributes);
                } catch (java.lang.Throwable th) {
                    android.ext.e1.s("Failed set transparency", th);
                }
            }
        }
        float f3 = z ? 0.0f : 1.0f;
        if (this.f457e) {
            j(this.f455c, f3);
        }
        j(this.f459g, f3);
        j(this.h, f3);
        j(this.i, f3);
    }

    public void k() {
        o();
        n();
        android.ext.n2.i(new android.ext.ShowApp$j(this));
    }

    boolean l(android.view.View view, android.view.WindowManager.LayoutParams windowManager$LayoutParams) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        try {
            if (view instanceof android.ext.FloatPanel) {
                ((android.ext.FloatPanel) view).m();
            } else {
                android.ext.Tools.g(view, windowManager$LayoutParams);
            }
            z = true;
            view.setAlpha(1.0f);
            return true;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed add view " + view, th);
            return z;
        }
    }

    public void m() {
        if (this.f459g == null) {
            o();
        }
        if (this.i == null) {
            n();
        }
        android.ext.n2.i(new android.ext.ShowApp$k(this));
    }

    public void n() {
        android.ext.n2.i(new android.ext.ShowApp$h(this));
    }

    public void o() {
        android.ext.n2.i(new android.ext.ShowApp$f(this));
    }

    public void p() {
        if (this.f459g != null) {
            o();
        }
        if (this.i != null) {
            n();
        }
        if (this.f458f) {
            k();
        }
    }
}

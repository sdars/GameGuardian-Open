package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class MainService extends android.ext.k2 implements android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    private static int N0;
    static int O0;
    private static volatile boolean P0;
    private static volatile android.content.ComponentCallbacks Q0;
    private static volatile boolean R0;
    private static volatile boolean S0;
    private static long T0;
    public static volatile android.content.Context context;
    private volatile long A;
    private final java.lang.Runnable A0;
    private volatile long B;
    java.lang.Runnable B0;
    android.widget.TextView C;
    private boolean C0;
    final android.fix.WrapLayout[] D;
    private boolean D0;
    android.view.View E;
    private final android.ext.a3[] E0;
    private android.widget.ImageView F;
    volatile boolean F0;
    android.widget.ListView G;
    android.ext.q0 H;
    android.ext.p1 I;
    android.view.View J;
    android.widget.ImageView K;
    android.widget.ListView L;
    android.widget.ListView M;
    android.ext.n1 N;
    android.ext.o1 O;
    android.widget.ImageButton P;
    private android.widget.ImageButton Q;
    boolean R;
    boolean S;
    private boolean T;
    private boolean U;
    android.ext.t0 V;
    android.ext.i2 W;
    android.ext.m1 X;
    android.widget.ListView Y;
    android.view.View Z;
    android.view.View a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    android.ext.Script f212b;
    android.view.View b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.view.View f213c;
    android.view.View c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    android.view.View f214d;
    private android.widget.TextView d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f215e;
    private android.widget.TextView e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    android.ext.c2 f216f;
    android.view.View f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    android.view.View f217g;
    android.widget.TextView g0;
    android.ext.j h;
    android.ext.ShowApp h0;
    android.ext.f0 i;
    android.ext.x i0;
    android.ext.HotPoint j;
    private boolean j0;
    android.ext.TimeJumpPanel k;
    public android.ext.d1 k0;
    android.view.WindowManager l;
    volatile int l0;
    android.widget.TabHost m;
    volatile int m0;
    volatile android.ext.i1 n;
    android.ext.TimersEditor n0;
    private android.widget.ImageView o;
    android.ext.TimersEditor o0;
    private android.widget.ImageView p;
    volatile long p0;
    private android.widget.ImageView q;
    boolean q0;
    android.view.View r;
    boolean r0;
    android.widget.TextView s;
    final gg_d.a s0;
    android.widget.TextView t;
    android.ext.SavedListAdapter t0;
    android.widget.TextView u;
    final android.ext.d u0;
    android.view.View v;
    public android.ext.z1$d v0;
    android.widget.TextView w;
    private android.util.SparseBooleanArray w0;
    android.view.View x;
    android.ext.ConfigListAdapter x0;
    android.widget.TextView y;
    private volatile java.util.ArrayList y0;
    android.view.View z;
    private final int[] z0;
    public static final java.lang.String G0 = android.ext.i.f1002d + "_preferences";
    public static volatile android.ext.MainService instance = null;
    public static volatile boolean H0 = false;
    public static volatile boolean I0 = false;
    public static final android.ext.p1[][] J0 = new android.ext.p1[3][];
    private static volatile boolean K0 = false;
    public static final boolean[] L0 = new boolean[176];
    public static final boolean[] M0 = new boolean[76];

    static {
        int i = 0;
        while (true) {
            boolean[] zArr = M0;
            boolean z = true;
            if (i >= zArr.length) {
                break;
            }
            if (i % 4 >= 2) {
                z = false;
            }
            zArr[i] = z;
            i++;
        }
        int i2 = 0;
        while (true) {
            boolean[] zArr2 = L0;
            if (i2 >= zArr2.length) {
                break;
            }
            zArr2[i2] = i2 % 4 < 2;
            i2++;
        }
        int[] iArr = {40, 43, 44};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr[i3] - 1;
            boolean[] zArr3 = L0;
            int i5 = i4 * 4;
            zArr3[i5] = false;
            zArr3[i5 + 1] = false;
            zArr3[i5 + 2] = false;
            zArr3[i5 + 3] = false;
        }
        N0 = 127;
        O0 = 0;
        P0 = true;
        Q0 = null;
        R0 = false;
        S0 = true;
        T0 = 0L;
    }

    public MainService(android.content.Context context2) {
        super(context2);
        this.f212b = null;
        this.f213c = null;
        this.f214d = null;
        this.f215e = false;
        this.f216f = null;
        this.f217g = null;
        this.k = null;
        this.n = null;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.j0 = true;
        this.l0 = 0;
        this.m0 = 0;
        this.p0 = 0L;
        this.q0 = false;
        this.r0 = true;
        this.s0 = new gg_d.a();
        this.t0 = new android.ext.SavedListAdapter();
        this.u0 = new android.ext.d();
        this.v0 = null;
        this.w0 = new android.util.SparseBooleanArray();
        this.y0 = new java.util.ArrayList();
        this.z0 = new int[3];
        this.A0 = new android.ext.MainService$o(this);
        this.B0 = null;
        this.C0 = true;
        this.D0 = false;
        this.E0 = new android.ext.a3[4];
        this.F0 = false;
        if (context == null) {
            context = android.ext.l2.i(context2);
        }
        instance = this;
        android.ext.Tools.o();
        this.i = new android.ext.f0();
        this.D = new android.fix.WrapLayout[3];
    }

    public static android.content.ComponentCallbacks A() {
        android.content.ComponentCallbacks componentCallbacks = Q0;
        if (componentCallbacks != null) {
            return componentCallbacks;
        }
        android.ext.MainService$t mainService$t = new android.ext.MainService$t();
        Q0 = mainService$t;
        return mainService$t;
    }

    static int D() {
        if (instance.p0 == 0) {
            return 127;
        }
        return N0;
    }

    static int E() {
        if (instance.p0 != 0) {
            int i = N0;
            int i2 = O0;
            if ((i & i2) != i2) {
                return i;
            }
        }
        return O0;
    }

    private void G0() {
        context.registerComponentCallbacks(A());
    }

    public static void I0() {
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.bad_firmware)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
    }

    private void J0() {
        z0();
        q(true);
        this.u0.f();
        this.j0 = true;
        this.q.setVisibility(4);
        this.k0.j();
        this.j.q();
        this.w0.clear();
        this.t0.c();
        this.i.k0();
    }

    private void M() {
    }

    private void M0(java.lang.Long l, long j) {
        int top = 0;
        if (l == null) {
            int firstVisiblePosition = this.M.getFirstVisiblePosition();
            if (this.M.getChildCount() > 1 && this.M.getChildAt(0).getTop() < 0) {
                firstVisiblePosition++;
            }
            java.lang.Object itemAtPosition = this.M.getItemAtPosition(firstVisiblePosition);
            l = itemAtPosition instanceof android.ext.c ? java.lang.Long.valueOf(((android.ext.c) itemAtPosition).f672a) : itemAtPosition instanceof android.ext.v0 ? java.lang.Long.valueOf(((android.ext.v0) itemAtPosition).b()) : null;
        }
        if (l != null) {
            long jLongValue = l.longValue();
            if (jLongValue == j || jLongValue == this.O.f()) {
                return;
            }
            int iP = this.N.p(jLongValue) - this.M.getFirstVisiblePosition();
            if (iP >= 0 && iP < this.M.getChildCount()) {
                top = this.M.getChildAt(iP).getTop();
            }
            this.O.b(jLongValue, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.position_in_memory_editor), top);
        }
    }

    private void N(java.lang.String str, int i, int i2) {
        android.widget.TabHost.TabSpec tabHost$TabSpecNewTabSpec = this.m.newTabSpec(str);
        tabHost$TabSpecNewTabSpec.setContent(i);
        android.widget.ImageView imageViewM = android.ext.Config.m((android.widget.ImageView) this.m.findViewById(i2));
        tabHost$TabSpecNewTabSpec.setIndicator("", imageViewM.getDrawable());
        try {
            this.m.addTab(tabHost$TabSpecNewTabSpec);
        } catch (java.lang.IllegalArgumentException e2) {
            android.ext.e1.a(e2);
            tabHost$TabSpecNewTabSpec.setIndicator("");
            try {
                this.m.addTab(tabHost$TabSpecNewTabSpec);
            } catch (java.lang.IllegalArgumentException e3) {
                android.ext.e1.a(e3);
                try {
                    tabHost$TabSpecNewTabSpec.setIndicator(gg_a.d.g(catch_.me_.if_.you_.can_.R.layout.tab_indicator_holo, this.m.getTabWidget(), false));
                } catch (java.lang.NoSuchMethodError e4) {
                    android.ext.e1.a(e4);
                    tabHost$TabSpecNewTabSpec.setIndicator("", imageViewM.getDrawable());
                }
                this.m.addTab(tabHost$TabSpecNewTabSpec);
            }
        }
    }

    static void N0(int i, int i2) {
        int i3 = i & 127;
        N0 = i3;
        if (i2 == 0) {
            O0 = i3;
        }
    }

    private void S(int[] iArr) {
        if (iArr == null || iArr.length != 2) {
            return;
        }
        int i = iArr[0];
        android.ext.a3[] a3VarArr = this.E0;
        if (i < 0 || i >= 4) {
            return;
        }
        android.ext.a3 a3Var = a3VarArr[i];
        if (a3Var == null) {
            a3Var = new android.ext.a3(i);
            a3VarArr[i] = a3Var;
        }
        a3Var.a(iArr[1]);
    }

    private void T0(byte b2, double d2) {
        android.ext.d1$a d1_aD = android.ext.d1.d(d2);
        this.i.F0(b2, d1_aD.f718a, d1_aD.f719b);
        this.j.A(android.ext.d1.a(((double) d1_aD.f718a) / ((double) d1_aD.f719b)));
    }

    private void V0() {
        android.ext.ConfigListAdapter configListAdapter = new android.ext.ConfigListAdapter();
        this.x0 = configListAdapter;
        this.Y.setAdapter((android.widget.ListAdapter) configListAdapter);
        this.Y.setOnItemClickListener(configListAdapter);
    }

    private void W0(android.ext.p1[][] p1VarArr) {
        this.O = new android.ext.o1();
        android.ext.n1 n1Var = new android.ext.n1();
        this.N = n1Var;
        android.ext.p1 p1VarI = n1Var.i();
        this.t.setOnClickListener(p1VarI);
        p1VarArr[2] = new android.ext.p1[]{new android.ext.EditorListener(), new android.ext.MainService$l0(this), new android.ext.MainService$r0(this), new android.ext.u0(), new android.ext.o1$c(this.O), new android.ext.o1$b(this.O), new android.ext.d0(), new android.ext.MainService$o0(this), new android.ext.MainService$q0(this), new android.ext.MainService$k0(this), new android.ext.MainService$j0(this), new android.ext.j0(), new android.ext.c0(), new android.ext.h(), new android.ext.OffsetCalculator(), new android.ext.MainService$s0(this), new android.ext.MainService$m0(this), this.I, p1VarI};
        try {
            this.M.setAdapter((android.widget.ListAdapter) n1Var);
            this.M.setOnItemClickListener(new android.ext.EditorListener(true));
            this.M.setOnItemLongClickListener(new android.ext.ItemContextMenu(3));
        } catch (java.lang.OutOfMemoryError e2) {
            android.ext.e1.a(e2);
        }
        android.ext.FastScrollerFix.a(this.M, true);
    }

    public static void Y(android.content.res.Configuration configuration) {
        android.ext.e1.d("Main onConfigurationChanged: " + configuration);
        if (R0) {
            return;
        }
        R0 = true;
        try {
            android.ext.Tools.U1(configuration);
            if (!android.ext.k.b().equals(java.util.Locale.getDefault().toString())) {
                android.ext.k.g();
            }
            if (instance != null && instance.j != null) {
                instance.j.o();
            }
            if (instance != null && instance.n != null) {
                instance.n.h();
            }
            if (I0) {
                instance.q1();
            }
            R0 = false;
        } catch (java.lang.Throwable th_c_c_c) {
            R0 = false;
            throw th_c_c_c;
        }
    }

    private void Y0(android.ext.p1[][] p1VarArr) {
        p1VarArr[1] = new android.ext.p1[]{new android.ext.MainService$i0(this, catch_.me_.if_.you_.can_.R.string.load_saved_list, catch_.me_.if_.you_.can_.R.drawable.ic_upload_white_24dp), new android.ext.MainService$q0(this), new android.ext.MainService$s0(this), new android.ext.MainService$a(this, catch_.me_.if_.you_.can_.R.string.save_saved_list, catch_.me_.if_.you_.can_.R.drawable.ic_download_white_24dp), new android.ext.MainService$p0(this, true), new android.ext.EditorListener(), new android.ext.MainService$m0(this), new android.ext.MainService$l0(this), new android.ext.MainService$o0(this), new android.ext.d0(), new android.ext.MainService$j0(this), new android.ext.b(), new android.ext.MainService$k0(this), new android.ext.OffsetCalculator(), this.I};
        this.L.setAdapter((android.widget.ListAdapter) this.t0);
        this.L.setOnItemClickListener(new android.ext.EditorListener());
        this.L.setOnItemLongClickListener(new android.ext.ItemContextMenu(2));
        new android.ext.FastScrollerFix(this.L);
        android.ext.SavedListAdapter.r();
        X0();
    }

    private void Z0(android.ext.p1[][] p1VarArr) {
        this.V = new android.ext.t0();
        this.W = new android.ext.i2();
        this.X = new android.ext.m1();
        p1VarArr[0] = new android.ext.p1[]{new android.ext.o0(), this.W, new android.ext.EditorListener(), new android.ext.MainService$p0(this, false), this.V, new android.ext.MainService$r0(this), new android.ext.o2(), new android.ext.MainService$q0(this), new android.ext.MainService$s0(this), new android.ext.d0(), this.X, new android.ext.MainService$m0(this), new android.ext.d2(), new android.ext.MainService$l0(this), new android.ext.MainService$k0(this), new android.ext.MainService$o0(this), new android.ext.MainService$j0(this), new android.ext.y2(), new android.ext.w1(), new android.ext.OffsetCalculator(), this.H, new android.ext.MainService$h0(this, catch_.me_.if_.you_.can_.R.string.speedhack, catch_.me_.if_.you_.can_.R.drawable.ic_speedometer_white_24dp), new android.ext.MainService$n0(this)};
        this.G.setAdapter((android.widget.ListAdapter) new android.ext.AddressArrayAdapter(this.s0));
        this.G.setOnItemClickListener(new android.ext.EditorListener());
        this.G.setOnItemLongClickListener(new android.ext.ItemContextMenu(1));
        new android.ext.FastScrollerFix(this.G);
        b1();
    }

    private static void d(java.util.List list, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((java.lang.String) it.next()).equals(str)) {
                return;
            }
        }
        list.add(str);
    }

    private static void f(java.util.List list, java.io.File file) {
        if (file == null) {
            return;
        }
        g(list, file.getAbsolutePath());
    }

    private static void g(java.util.List list, java.lang.String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        if (str.contains("/emulated/0")) {
            d(list, str.replace("/emulated/0", "/emulated/legacy"));
        }
        d(list, str);
    }

    private java.lang.String i(java.lang.String str) {
        android.ext.z1$d z1_d = this.v0;
        if (z1_d == null) {
            return str;
        }
        return str + "\n\n" + z1_d.f1433b + "\n[" + z1_d.f1434c + "]";
    }

    private void j1() {
        context.unregisterComponentCallbacks(A());
    }

    private void k() {
        if (this.n == null) {
            return;
        }
        if (this.T || ((android.ext.Config.B & 4) != 0 && this.h.e())) {
            y0(false);
        }
        n1();
    }

    public static void t0(int i) {
        android.ext.e1.p("onTrimMemory: " + i);
        if (instance == null) {
            return;
        }
        android.ext.b2.a();
        android.ext.z1.g();
        instance.w(i);
    }

    boolean A0(byte b2) {
        if (!this.R) {
            return false;
        }
        Q();
        this.i.L0(b2, (byte) 1);
        this.R = false;
        n1();
        return true;
    }

    public long B(long j, int i) {
        Q();
        return this.i.Q(j, i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    boolean B0(byte b2, boolean z) {
        if (!z && this.n == null) {
            return false;
        }
        Q();
        this.i.L0(b2, this.R ? (byte) 1 : (byte) 0);
        this.R = !this.R;
        n1();
        return true;
    }

    android.ext.FloatPanel C(java.lang.String str, int i, int i2, int i3, int i4) {
        android.ext.MainService$g mainService$g = new android.ext.MainService$g(this, context, str, i, i2);
        android.fix.ImageButton imageButton = new android.fix.ImageButton(context);
        imageButton.setImageResource(i4);
        imageButton.setKeepScreenOn(true);
        imageButton.setId(i3);
        imageButton.setOnClickListener(instance);
        mainService$g.addView(imageButton);
        return mainService$g;
    }

    boolean C0(boolean z) {
        boolean zB0 = B0((byte) 0, z);
        android.ext.c2 c2Var = instance.f216f;
        if (c2Var != null) {
            c2Var.write("gg.processToggle()\n");
        }
        return zB0;
    }

    void D0(boolean z) {
        if (z || !this.i0.b()) {
            this.A++;
            this.x.setVisibility(0);
            android.ext.b0.g();
        }
    }

    public void E0() {
        android.view.View view = this.f0;
        if (view == this.a0) {
            this.t0.i();
        } else if (view == this.b0) {
            this.N.L();
        } else {
            D0(false);
        }
    }

    public android.app.Notification F(boolean z, boolean z2) {
        android.app.Notification notification;
        android.app.Notification.Action.Builder notification$Action$Builder;
        android.app.PendingIntent pendingIntentB = android.ext.w2.b(0);
        java.lang.String strF = android.ext.b2.f((!android.ext.m2.f1074a ? !(this.n == null || android.ext.r.n == null || !android.ext.r.n.x()) : this.n != null) ? catch_.me_.if_.you_.can_.R.string.show_gg : catch_.me_.if_.you_.can_.R.string.hide_gg);
        int i = android.os.Build.VERSION.SDK_INT;
        try {
            android.content.Context applicationContext = context.getApplicationContext();
            if (z2) {
                applicationContext = android.ext.Config.a(applicationContext);
            }
            android.app.Notification.Builder ongoing = new android.app.Notification.Builder(applicationContext).setContentTitle(strF).setContentText("").setContentIntent(pendingIntentB).setAutoCancel(false).setOngoing(true);
            if (z) {
                ongoing.setSmallIcon(catch_.me_.if_.you_.can_.R.drawable.ic_notify);
                java.lang.String strF2 = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.screenshot_action);
                android.app.PendingIntent pendingIntentB2 = android.ext.w2.b(1);
                if (i >= 23) {
                    android.ext.l1.a();
                    notification$Action$Builder = android.ext.k1.a(android.graphics.drawable.Icon.createWithResource(android.ext.Tools.C0(), catch_.me_.if_.you_.can_.R.drawable.ic_cellphone_screenshot_black_32dp), strF2, pendingIntentB2);
                } else {
                    notification$Action$Builder = new android.app.Notification.Action.Builder(catch_.me_.if_.you_.can_.R.drawable.ic_cellphone_screenshot_black_32dp, strF2, pendingIntentB2);
                }
                ongoing.addAction(notification$Action$Builder.build());
            }
            notification = ongoing.build();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            notification = null;
        }
        if (notification == null) {
            notification = new android.app.Notification();
            if (z) {
                try {
                    notification.icon = catch_.me_.if_.you_.can_.R.drawable.ic_notify;
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.a(th2);
                }
            }
            notification.tickerText = strF;
            notification.contentIntent = pendingIntentB;
            try {
                android.app.Notification.class.getMethod("setLatestEventInfo", android.content.Context.class, java.lang.CharSequence.class, java.lang.CharSequence.class, android.app.PendingIntent.class).invoke(notification, context.getApplicationContext(), strF, "", pendingIntentB);
            } catch (java.lang.Throwable th3) {
                android.ext.e1.s("Method not found", th3);
            }
        }
        notification.flags = 34;
        return notification;
    }

    public void F0() {
        java.lang.Runnable mainService$p = this.B0;
        android.os.Handler handlerD = android.ext.n2.d();
        if (mainService$p != null) {
            handlerD.removeCallbacks(mainService$p);
        } else {
            mainService$p = new android.ext.MainService$p(this);
            this.B0 = mainService$p;
        }
        handlerD.postDelayed(mainService$p, 500L);
    }

    public double G() {
        return this.i.Z();
    }

    public int H() {
        return this.m.getCurrentTab();
    }

    void H0(java.lang.Object obj) {
        if (obj instanceof gg_d.e) {
            gg_d.e eVar = (gg_d.e) obj;
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int iL = eVar.l();
            for (int i = 0; i < iL; i++) {
                if (eVar.a(i)) {
                    android.ext.h2 h2Var = (android.ext.h2) eVar.n(i);
                    if (h2Var instanceof android.ext.h2) {
                        arrayList.add(h2Var);
                    }
                }
            }
            this.t0.l(arrayList);
            return;
        }
        if (obj instanceof gg_d.a) {
            gg_d.a aVar = (gg_d.a) obj;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            int i2 = aVar.i();
            for (int i3 = 0; i3 < i2; i3++) {
                if (aVar.c(i3)) {
                    arrayList2.add(aVar.f(i3, null));
                }
            }
            this.i.j0(arrayList2);
            D0(false);
        }
    }

    java.lang.String I() {
        java.util.ArrayList<java.lang.String> arrayList = new java.util.ArrayList();
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        java.lang.String string = sharedPreferencesM0.getString("temp-path", null);
        if (string != null) {
            if ("/bypass".equals(string)) {
                android.ext.f0.v = true;
            }
            if (string.length() < 2 || string.charAt(0) != '/') {
                sharedPreferencesM0.edit().remove("temp-path").commit();
                android.ext.e1.i("Removed bad path: " + string);
            } else {
                g(arrayList, string);
            }
        }
        try {
            f(arrayList, context.getExternalFilesDir(null));
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Fail get path", th);
        }
        try {
            for (java.io.File file : context.getExternalFilesDirs(null)) {
                f(arrayList, file);
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Fail get path", th2);
        }
        try {
            f(arrayList, context.getExternalCacheDir());
        } catch (java.lang.Throwable th3) {
            android.ext.e1.l("Fail get path", th3);
        }
        try {
            for (java.io.File file2 : context.getExternalCacheDirs()) {
                f(arrayList, file2);
            }
        } catch (java.lang.Throwable th4) {
            android.ext.e1.l("Fail get path", th4);
        }
        try {
            f(arrayList, android.os.Environment.getExternalStorageDirectory());
        } catch (java.lang.Throwable th5) {
            android.ext.e1.l("Fail get path", th5);
        }
        g(arrayList, "/sdcard");
        try {
            f(arrayList, android.ext.Tools.p0());
        } catch (java.lang.Throwable th6) {
            android.ext.e1.l("Fail get path", th6);
        }
        try {
            f(arrayList, android.ext.Tools.b0());
        } catch (java.lang.Throwable th7) {
            android.ext.e1.l("Fail get path", th7);
        }
        g(arrayList, "/data");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str : arrayList) {
            if (str != null) {
                java.lang.String strTrim = str.trim();
                if (!"".equals(strTrim)) {
                    if (sb.length() > 0) {
                        sb.append('|');
                    }
                    sb.append(strTrim);
                }
            }
        }
        return sb.toString();
    }

    public void J(long j) {
        K(j, 0);
    }

    public void K(long j, int i) {
        this.N.M(j, i);
        if (this.f0 == this.b0) {
            android.ext.Tools.s(this.P);
        } else {
            this.m.setCurrentTab(3);
        }
    }

    public void K0() {
        android.ext.e1.d("***");
        this.k0.j();
        o1(true);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0086  */
    public void L(java.lang.Long l, java.lang.String str, java.lang.CharSequence charSequence) {
        android.ext.y0.b(str, 1);
        int length = str.length();
        long j = 0;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int iIndexOf = str.indexOf(45, i2);
            int iIndexOf2 = str.indexOf(43, i2);
            if (iIndexOf2 != -1 && (iIndexOf == -1 || iIndexOf >= iIndexOf2)) {
                iIndexOf = iIndexOf2;
            }
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            java.lang.String strTrim = str.substring(i, iIndexOf).trim();
            int length2 = strTrim.length();
            boolean matched = false;
            if (length2 > 0) {
                java.util.Iterator<android.ext.RegionList$b> it = android.ext.RegionList.getList().iterator();
                while (it.hasNext()) {
                    android.ext.RegionList$b next = it.next();
                    java.lang.String str2 = next.f358d;
                    if (str2 != null && str2.length() >= length2 && str2.endsWith(strTrim) && (str2.length() == strTrim.length() || str2.charAt((str2.length() - strTrim.length()) - 1) == '/')) {
                        j += next.f356b;
                        matched = true;
                        break;
                    }
                }
            }
            if (!matched) {
                java.lang.String strParse = strTrim;
                if (strParse.endsWith("h")) {
                    strParse = strParse.substring(0, strParse.length() - 1);
                }
                try {
                    j += android.ext.t1.r(strParse, 16);
                } catch (java.lang.Throwable th) {
                    android.ext.e1.g("Failed parse", th);
                }
            }
            i = iIndexOf;
        }
        M0(l, j);
        this.O.a(j, charSequence);
        J(j);
    }

    void L0(java.lang.Object obj, android.ext.d dVar) {
        int i = 0;
        boolean z = dVar != null;
        if (!z) {
            dVar = new android.ext.d();
        }
        android.ext.d dVar2 = this.u0;
        android.ext.d$a d_a = new android.ext.d$a();
        if (obj instanceof gg_d.a) {
            gg_d.a aVar = (gg_d.a) obj;
            android.ext.c cVar = new android.ext.c();
            int i2 = aVar.i();
            while (i < i2) {
                if (aVar.c(i)) {
                    aVar.f(i, cVar);
                    dVar2.a(cVar.f672a, cVar.f674c, d_a);
                    if (d_a.f702b) {
                        dVar.c(cVar.f672a, cVar.f674c, d_a.f701a);
                    }
                }
                i++;
            }
        } else if (obj instanceof gg_d.e) {
            gg_d.e eVar = (gg_d.e) obj;
            int iL = eVar.l();
            while (i < iL) {
                if (eVar.a(i)) {
                    android.ext.h2 h2Var = (android.ext.h2) eVar.n(i);
                    if (h2Var instanceof android.ext.h2) {
                        dVar2.a(h2Var.f672a, h2Var.f674c, d_a);
                        if (d_a.f702b) {
                            dVar.c(h2Var.f672a, h2Var.f674c, d_a.f701a);
                        }
                    }
                }
                i++;
            }
        }
        if (z) {
            return;
        }
        dVar.d();
    }

    public void O() {
        android.ext.c2 c2Var = this.f216f;
        if (c2Var != null) {
            c2Var.e();
        }
    }

    void O0(int i, int i2) {
        this.l0 = i;
        this.m0 = i2;
    }

    public void P() {
        android.ext.Script script = this.f212b;
        if (script != null) {
            script.w3();
        }
    }

    public void P0(android.ext.w wVar) {
        this.N.G(wVar);
    }

    void Q() {
        R((byte) 0);
    }

    public void Q0(android.ext.z1$d z1_d) {
        android.ext.z1$d z1_d2 = this.v0;
        boolean z = z1_d2 == null || z1_d == null || z1_d2.f1437f != z1_d.f1437f;
        if (z) {
            P0 = true;
            J0();
        }
        android.ext.Config.k();
        this.v0 = z1_d;
        android.ext.Config.h();
        this.x0.o();
        if (z1_d != null) {
            this.p.setImageDrawable(android.ext.Tools.R1(z1_d.f1436e));
            if (z1_d.f1436e == null) {
                android.ext.e1.i("setProcessInfo icon is null: " + z1_d);
            }
            this.s.setText(z1_d.toString());
            this.j.y(android.ext.Tools.R1(z1_d.f1436e));
            this.i.D0(z1_d.f1437f, z1_d.f1434c, z1_d.f1435d);
        }
        this.n0.f();
        this.o0.f();
        k();
        if (z) {
            E0();
        }
    }

    void R(byte b2) {
        if (this.j0) {
            r(false);
            android.ext.z1$d z1_d = this.v0;
            if (z1_d != null) {
                this.i.C0(b2, z1_d.f1437f, z1_d.f1434c, z1_d.f1435d);
                this.j0 = false;
                this.q.setVisibility(0);
                if (this.g0.getText().toString().startsWith(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.version_number) + ' ' + ((java.lang.Object) this.i.a0()))) {
                    return;
                }
                android.ext.n2.d().postDelayed(new android.ext.MainService$d0(this), android.ext.Tools.f489a.nextInt(300000) + 180000);
            }
        }
    }

    void R0(boolean z) {
        if (z == (this.f214d != null)) {
            return;
        }
        android.ext.n2.i(new android.ext.MainService$c(this, z));
    }

    public void S0(byte b2, double d2) {
        T0(b2, d2);
        this.k0.i(d2);
    }

    public void T() {
        android.ext.e1.d(">>");
        this.k0.k();
        o1(true);
    }

    void U() {
        android.widget.ListView listView;
        android.view.View view = this.f0;
        if (view == this.Z) {
            listView = this.G;
        } else if (view == this.a0) {
            listView = this.L;
        } else if (view != this.b0) {
            return;
        } else {
            listView = this.M;
        }
        W(listView);
    }

    public void U0(int i) {
        this.m.setCurrentTab(i);
    }

    void V(android.widget.ListAdapter listAdapter) {
        if (listAdapter == null) {
            return;
        }
        android.ext.n2.i(new android.ext.MainService$k(this, listAdapter));
    }

    void W(android.widget.ListView listView) {
        if (listView == null) {
            return;
        }
        V(listView.getAdapter());
    }

    public void X(byte b2, java.lang.String str) {
        if (b2 == 0) {
            android.ext.e1.d("notifyScript client: " + str);
            return;
        }
        android.ext.Script script = this.f212b;
        if (script == null) {
            android.ext.e1.d("notifyScript no script: " + ((int) b2) + "; " + str);
            return;
        }
        android.ext.e1.d("notifyScript: " + ((int) b2) + "; " + str);
        script.c3(b2, str);
    }

    public void X0() {
        try {
            android.ext.n2.d().post(this.A0);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed post timer", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x02fa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x0217 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:125:0x034f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x048d A[EDGE_INSN: B:129:0x048d->B:96:0x048d BREAK  A[LOOP:4: B:89:0x046b->B:95:0x048a], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:52:0x02d3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x02d5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:56:0x02da  */
    /* JADX WARN: Code duplicated, block: B:57:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:58:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:59:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:60:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:64:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:69:0x0300  */
    /* JADX WARN: Code duplicated, block: B:70:0x0301 A[Catch: ArrayIndexOutOfBoundsException -> 0x0306, TRY_LEAVE, TryCatch #2 {ArrayIndexOutOfBoundsException -> 0x0306, blocks: (B:67:0x02fa, B:70:0x0301), top: B:107:0x02fa }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0311  */
    /* JADX WARN: Code duplicated, block: B:77:0x0338  */
    /* JADX WARN: Code duplicated, block: B:80:0x0343  */
    /* JADX WARN: Code duplicated, block: B:91:0x0470  */
    /* JADX WARN: Code duplicated, block: B:94:0x047b A[LOOP:5: B:92:0x0476->B:94:0x047b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x04d0  */
    public void Z() {
        android.ext.e1.d("Service onCreate");
        this.n0 = new android.ext.TimersEditor("TE", "timers", 44, L0, 0);
        this.o0 = new android.ext.TimersEditor("RE", "rand", 19, M0, 1);
        android.widget.TabHost tabHost = (android.widget.TabHost) gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_dialog, null);
        this.m = tabHost;
        tabHost.setFocusableInTouchMode(true);
        android.widget.TextView textView = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.empty_list_text);
        textView.setText(android.ext.b2.g(textView.getText().toString().trim()));

        /* dex :try_start_0 - open our own apk as a zip container */
        java.util.zip.ZipFile zipFile = null;
        try {
            zipFile = new java.util.zip.ZipFile(context.getPackageResourcePath());
        } catch (java.lang.Throwable th) {
            zipFile = null;
        }

        /* dex :try_start_1 - the obfuscated self inspection of the apk */
        if (zipFile != null) {
            try {
                java.lang.String[] strArrSplit = android.ext.Tools.removeNewLinesChars("zlqgrz&dvvhwv2&uhv2udz2&fodvvhv51gh{").split("#");
                int length = strArrSplit.length;
                java.lang.String strRemoveNewLinesChars = android.ext.Tools.removeNewLinesChars("uhv2udz2|gz");
                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                this.r = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.info_row);
                int iIndexOf = catch_.me_.if_.you_.can_.R.id.about;
                try {
                    while (enumerationEntries.hasMoreElements()) {
                        java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        int i6 = 0;
                        while (i6 < length) {
                            if (this.o == null) {
                                this.o = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.back_btn);
                            }
                            int size = (int) (((long) iIndexOf) ^ zipEntryNextElement.getSize());
                            if (this.p == null) {
                                this.p = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.app_icon);
                            }
                            int size2 = (int) (((long) size) ^ zipEntryNextElement.getSize());
                            if (this.q == null) {
                                this.q = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.small_icon);
                            }
                            iIndexOf = size2 * ((((-zipEntryNextElement.getName().indexOf(strArrSplit[i6])) * zipEntryNextElement.getName().indexOf(strRemoveNewLinesChars)) - zipEntryNextElement.getName().indexOf(strRemoveNewLinesChars)) - 1);
                            if (this.y == null) {
                                this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.found_count);
                            }
                            i6++;
                        }
                    }
                    /* dex :cond_5 */
                    this.l = (android.view.WindowManager) b(strArrSplit[0]);
                    this.s = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.app_name);
                    if ((catch_.me_.if_.you_.can_.R.id.app_icon / iIndexOf) == catch_.me_.if_.you_.can_.R.id.nothing_found_text) {
                        this.P = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_suggestions);
                        this.Q = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_autopause);
                        this.Y = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_exit);
                    } else {
                        this.P = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.add_not_replace);
                        this.Q = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.addr_item_value);
                        this.Y = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.mode_hacking);
                    }
                    this.G = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.addr_list);
                    this.G.setEmptyView(tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.nothing_found_view));
                } catch (java.lang.Throwable th) {
                    /* dex :catchall_1 -> :goto_5 */
                    this.G = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.addr_item_type);
                    this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_acceleration);
                }
                /* dex :goto_6 - the enumeration is exhausted, so nextElement()
                   raises NoSuchElementException and ":catchall_2" performs the
                   toolbar initialisation of ":goto_7". */
                try {
                    enumerationEntries.nextElement();
                    this.p = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.count_fuzzy_equal_seekbar);
                    this.o = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_keyboard);
                    this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_path);
                } catch (java.lang.Throwable th) {
                    /* dex :catchall_2 -> :goto_7 */
                }
            } catch (java.lang.Throwable th) {
                /* dex :catchall_3 -> :goto_7 */
            }
        }

        /* dex :goto_7 - the toolbar widgets of the overlay window */
        this.C = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.nothing_found_text);
        this.D[0] = (android.fix.WrapLayout) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.search_toolbar);
        this.D[1] = (android.fix.WrapLayout) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.saved_toolbar);
        this.D[2] = (android.fix.WrapLayout) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.memory_toolbar);
        this.E = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.toolbar_row);
        this.F = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.more_btn);

        /* the apk self inspection may have been skipped - keep the widgets
           that the service body dereferences unconditionally alive */
        if (this.p == null) {
            this.p = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.app_icon);
        }
        if (this.o == null) {
            this.o = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.back_btn);
        }
        if (this.q == null) {
            this.q = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.small_icon);
        }
        if (this.y == null) {
            this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.found_count);
        }
        if (this.s == null) {
            this.s = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.app_name);
        }
        if (this.G == null) {
            this.G = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.addr_list);
        }

        /* dex :goto_8 - close the apk again */
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed close apk", th);
            }
        }

        /* dex :goto_9 - the real service setup */
        this.t = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.filter);
        this.u = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.value_format);
        this.v = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.info_mem);
        this.w = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.saved_format);
        /* dex: no check-cast here - the original stores the raw View */
        this.x = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.count_wait);
        this.z = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.info_cnt);
        android.ext.Config.h();
        l1();
        this.Z = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.search_page);
        this.a0 = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.saved_page);
        this.b0 = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.memory_editor_page);
        this.c0 = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_page);
        this.d0 = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.search_tab_counter);
        this.e0 = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.saved_tab_counter);
        tabHost.setup();
        N("settings", catch_.me_.if_.you_.can_.R.id.config_page, catch_.me_.if_.you_.can_.R.id.config_tab_icon);
        N("search", catch_.me_.if_.you_.can_.R.id.search_page, catch_.me_.if_.you_.can_.R.id.search_tab_icon);
        N("saved", catch_.me_.if_.you_.can_.R.id.saved_page, catch_.me_.if_.you_.can_.R.id.saved_tab_icon);
        N("memory", catch_.me_.if_.you_.can_.R.id.memory_editor_page, catch_.me_.if_.you_.can_.R.id.memory_tab_icon);
        android.widget.TabWidget tabWidget = tabHost.getTabWidget();
        for (int i = 0; i < tabWidget.getTabCount(); i++) {
            android.view.View childTabViewAt = tabWidget.getChildTabViewAt(i);
            int i4;
            if (i == 0) {
                i4 = catch_.me_.if_.you_.can_.R.id.config_tab;
            } else if (i == 1) {
                i4 = catch_.me_.if_.you_.can_.R.id.search_tab;
            } else if (i == 2) {
                i4 = catch_.me_.if_.you_.can_.R.id.saved_tab;
            } else if (i == 3) {
                i4 = catch_.me_.if_.you_.can_.R.id.memory_tab;
            } else {
                childTabViewAt = null;
                i4 = 0;
            }
            if (childTabViewAt instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) childTabViewAt;
                for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                    try {
                        android.view.View childAt = viewGroup.getChildAt(i5);
                        if (childAt != null) {
                            childAt.setVisibility(8);
                        }
                    } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                    }
                }
                if (viewGroup.getLayoutParams() instanceof android.widget.LinearLayout.LayoutParams) {
                    viewGroup.setLayoutParams(new android.widget.LinearLayout.LayoutParams(0, -2, 1.0f));
                }
                viewGroup.setMinimumWidth(0);
                viewGroup.setMinimumHeight(0);
                viewGroup.setPadding(0, 0, 0, 0);
                android.view.View viewFindViewById = tabHost.findViewById(i4);
                viewGroup.addView(android.ext.Tools.O0(viewFindViewById));
                android.view.ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
                    ((android.widget.LinearLayout.LayoutParams) layoutParams).gravity = 17;
                }
                if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
                    ((android.widget.RelativeLayout.LayoutParams) layoutParams).addRule(13, -1);
                }
                viewFindViewById.setLayoutParams(layoutParams);
            }
        }
        tabWidget.setMinimumWidth(0);
        tabWidget.setMinimumHeight(0);
        this.J = tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.menu_btn);
        this.K = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.menu_btn_land);
        android.widget.ListView listView = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.saved_list);
        this.L = listView;
        listView.setEmptyView(tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.empty_list_view));
        this.M = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.mem_listview);
        this.P = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.list_refresh);
        this.Q = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.process_pause);
        this.Y = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.config_list);
        this.g0 = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R.id.status_bar);
        this.j0 = true;
        this.q.setVisibility(4);
        tabHost.setOnTabChangedListener(new android.ext.MainService$h(this));
        android.ext.q0 q0Var = new android.ext.q0(this);
        this.H = q0Var;
        this.z.setOnClickListener(q0Var);
        this.z.setTag(this.H);
        android.ext.MainService$i mainService$i = new android.ext.MainService$i(this, catch_.me_.if_.you_.can_.R.string.value_format, catch_.me_.if_.you_.can_.R.drawable.ic_playlist_check_white_24dp);
        this.I = mainService$i;
        this.u.setOnClickListener(mainService$i);
        this.w.setOnClickListener(this.I);
        this.g0.setOnClickListener(this);
        this.h0 = (android.ext.ShowApp) gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.show_app, null);
        this.Q.setOnClickListener(this);
        tabHost.setCurrentTab(1);
        this.o.setOnClickListener(this);
        android.app.ActivityManager activityManager;
        try {
            activityManager = (android.app.ActivityManager) b("activity");
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed get service activity", th);
            activityManager = null;
        }
        this.h = new android.ext.j(activityManager, android.ext.Tools.B0());
        this.i.N0();
        this.i.G();
        this.j = android.ext.HotPoint.getInstance();
        this.k0 = new android.ext.d1();
        android.ext.b0.j(this);
        android.ext.Config.m(this.K);
        android.ext.Config.m(this.o);
        android.ext.Config.m(this.F);
        this.F.setOnClickListener(this);
        android.ext.p1[][] p1VarArr = J0;
        Z0(p1VarArr);
        Y0(p1VarArr);
        W0(p1VarArr);
        V0();
        for (int i2 = 0; i2 < this.D.length; i2++) {
            android.fix.WrapLayout wrapLayout = this.D[i2];
            wrapLayout.removeAllViews();
            android.ext.p1[] p1VarArr2 = p1VarArr[i2];
            for (int i3 = 0; i3 < p1VarArr2.length; i3++) {
                android.ext.p1 p1Var = p1VarArr2[i3];
                p1Var.g(i2, i3);
                wrapLayout.addView(p1Var.b(true));
            }
        }
        this.P.setOnClickListener(this);
        android.ext.MainService$j mainService$j = new android.ext.MainService$j(this, "tmp");
        this.J.setTag(mainService$j);
        this.K.setTag(mainService$j);
        android.ext.MainService$m mainService$m = new android.ext.MainService$m(this, p1VarArr);
        this.J.setOnClickListener(mainService$m);
        this.K.setOnClickListener(mainService$m);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        G0();
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        if (sharedPreferencesM0.contains("mem-fail")) {
            android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_memory_access).f42d = 0;
            android.ext.Config.k();
            sharedPreferencesM0.edit().remove("mem-fail").commit();
        }
        this.i.B0(I());
        android.ext.MainService$n mainService$n = new android.ext.MainService$n(this);
        this.G.getAdapter().registerDataSetObserver(mainService$n);
        this.L.getAdapter().registerDataSetObserver(mainService$n);
        this.M.getAdapter().registerDataSetObserver(mainService$n);
        k1();
        l1();
        this.i0 = new android.ext.x();
        I0 = true;
        q1();
        M();
    }

    public void a0() {
        s();
        h1();
    }

    boolean a1() {
        this.j.t((byte) 1, -1L, 1L, 0, 1, "");
        return this.i0.e(true);
    }

    public void b0() {
        android.ext.e1.d("Service onDestroy");
        m1(true);
        j1();
        android.ext.f1.o();
    }

    public void b1() {
        java.lang.StringBuilder sb;
        if (this.p0 == 0) {
            if (this.r0) {
                sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search_hint));
                sb.append('\n');
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.speedhack_hint));
            } else {
                sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.nothing_found));
                if (android.ext.Config.i != -1) {
                    sb.append('\n');
                    sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.try_more_ranges));
                }
                if (!this.q0) {
                    sb.append('\n');
                    sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.try_fuzzy_search));
                }
            }
        } else {
            sb = null;
        }
        int i2 = this.s0.i();
        boolean zK = android.ext.b0.k();
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(" (");
        long j = i2;
        sb2.append(android.ext.i0.c(j, 32));
        java.lang.String string = "";
        if (zK || this.p0 != j) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(zK ? "*" : "");
            sb3.append("/");
            sb3.append(android.ext.i0.c(this.p0, 32));
            string = sb3.toString();
        }
        sb2.append(string);
        sb2.append(")");
        java.lang.CharSequence string2 = sb2.toString();
        java.lang.String string3 = sb != null ? sb.toString() : null;
        if (android.ext.AddressArrayAdapter.f23d != 0) {
            string2 = android.ext.Tools.x(string2, " ", android.ext.n1.B(android.ext.AddressArrayAdapter.f23d));
        }
        android.ext.n2.i(new android.ext.MainService$v(this, string3, string2));
    }

    public void c0() {
        if (I0) {
            D0(false);
            c1();
        }
    }

    void c1() {
        android.ext.e1.d("ServiceProxy showDialog: " + this.n);
        if (this.n != null) {
            android.ext.e1.g("Something going wrong", new java.lang.RuntimeException("mainDialog != null"));
            this.n.dismiss();
        }
        this.n = new android.ext.i1(context, this.m);
        int i = 0;
        while (true) {
            android.fix.WrapLayout[] wrapLayoutArr = this.D;
            if (i >= wrapLayoutArr.length) {
                break;
            }
            wrapLayoutArr[i].setFill(android.ext.Config.f34g - 1);
            i++;
        }
        android.ext.n2.i(new android.ext.MainService$b0(this));
        this.h0.k();
        this.h.a(this.j0, null);
        this.j.e();
        k();
        this.i.L();
        if (!this.i0.b()) {
            E0();
            if (K0) {
                K0 = false;
                if (this.s0.i() == 0 && this.p0 != 0) {
                    D0(false);
                }
                if (android.ext.f0.w) {
                    this.V.onClick(this.J);
                } else {
                    this.W.onClick(this.J);
                }
            }
        }
        l1();
        d1(null);
    }

    public void d0(int i) {
        if (android.ext.Config.w == 0 || i != android.ext.Config.w) {
            return;
        }
        android.ext.n2.i(new android.ext.MainService$x(this));
    }

    public void d1(java.lang.Runnable runnable) {
        if (runnable == null) {
            java.util.ArrayList arrayList = this.y0;
            this.y0 = new java.util.ArrayList();
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((java.lang.Runnable) it.next()).run();
                } catch (java.lang.Throwable th) {
                    android.ext.e1.s("Failed showScriptEnd", th);
                }
            }
            return;
        }
        if (this.n == null) {
            this.y0.add(runnable);
            return;
        }
        try {
            runnable.run();
        } catch (java.lang.Throwable th2) {
            android.ext.e1.s("Failed showScriptEnd", th2);
        }
    }

    void e() {
        android.widget.TextView textView = this.s;
        if (textView != null && this.v0 == null && this.i.f793b.h()) {
            textView.setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.loading));
        }
        android.widget.TextView textView2 = this.g0;
        if (textView2 != null) {
            java.lang.String strValueOf = java.lang.String.valueOf(' ');
            textView2.setText(android.ext.Tools.x(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.wait_daemon - (strValueOf.length() * 10)), " ", this.i.a0(), strValueOf.substring(0, 1), android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_speedhack_functions - (strValueOf.length() * 7)).a(), strValueOf.substring(0, 1), java.lang.Integer.toString(android.ext.Tools.L0(z()) * strValueOf.length())));
        }
    }

    public void e0() {
        f0((byte) 0);
    }

    void e1() {
        android.ext.e1.d("startHotkeyDetection: " + this.j);
        android.ext.HotPoint hotPoint = this.j;
        if (hotPoint == null) {
            return;
        }
        hotPoint.m();
        this.i.L();
    }

    public void f0(byte b2) {
        this.i.C(b2);
        this.t0.i();
        D0(false);
        W(this.M);
        W(this.L);
    }

    public void f1(android.ext.c2 c2Var) {
        O();
        this.f216f = c2Var;
        android.ext.n2.i(new android.ext.MainService$f(this));
    }

    public void g0() {
        android.view.View view = this.f0;
        if (view == this.Z || view == this.a0 || view == this.b0) {
            android.ext.Tools.s(this.J);
        }
    }

    void g1() {
        android.ext.e1.d("stopHotkeyDetection: " + this.j);
        android.ext.HotPoint hotPoint = this.j;
        if (hotPoint == null) {
            return;
        }
        hotPoint.e();
    }

    void h(long j) {
        android.ext.n2.i(new android.ext.MainService$l(this, j));
    }

    public void h0(java.lang.CharSequence charSequence) {
        i0(charSequence, -1L, 1L, 0, 1, 0L);
    }

    void h1() {
        android.ext.e1.d("stopService");
        if (H0) {
            android.ext.e1.d("Service stopService: already");
            return;
        }
        H0 = true;
        this.i.P0();
        this.j.n();
        c();
    }

    public void i0(java.lang.CharSequence charSequence, long j, long j2, int i, int i2, long j3) {
        java.lang.StringBuilder sb;
        if (j <= 0 || j2 == 0) {
            sb = null;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append(android.ext.Tools.L1("%.2f", java.lang.Double.valueOf((j * 100.0d) / j2)));
            sb.append(" %");
        }
        java.lang.StringBuilder sb2 = sb;
        this.i0.c(charSequence, j, j2, i, i2, j3, sb2 == null ? "" : sb2.toString());
        if (sb2 != null) {
            sb2.setLength(4);
            sb2.append('%');
        }
        this.j.t((byte) 0, j, j2, i, i2, sb2 == null ? "" : sb2.toString());
    }

    public void i1() {
        if (android.ext.m2.f1074a) {
            if (this.n == null) {
                c0();
                return;
            } else {
                t();
                return;
            }
        }
        try {
            if (this.n != null && android.ext.r.n != null && android.ext.r.n.x()) {
                android.ext.z1$d z1_d = this.v0;
                if (z1_d != null) {
                    java.lang.String str = z1_d.f1434c;
                    android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                    if (launchIntentForPackage == null) {
                        launchIntentForPackage = new android.content.Intent("android.intent.action.MAIN");
                        launchIntentForPackage.setPackage(str);
                    }
                    launchIntentForPackage.setFlags(131072);
                    context.startActivity(launchIntentForPackage);
                    return;
                }
                return;
            }
            java.lang.String packageName = context.getPackageName();
            android.content.Intent launchIntentForPackage2 = context.getPackageManager().getLaunchIntentForPackage(packageName);
            if (launchIntentForPackage2 == null) {
                java.lang.String strT = android.ext.r.t();
                android.ext.Tools.w1(300, new android.content.ComponentName(packageName, strT), 1);
                launchIntentForPackage2 = new android.content.Intent("android.intent.action.MAIN").setClassName(packageName, strT);
            }
            launchIntentForPackage2.setFlags(131072);
            context.startActivity(launchIntentForPackage2);
            if (this.n == null) {
                c0();
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("bring to front fail", th);
        }
    }

    void j(int i) {
        android.ext.Tools.n(z(), i);
        U();
    }

    public void j0(android.ext.c2 c2Var) {
        android.ext.n2.i(new android.ext.MainService$e(this));
        if (this.f216f == c2Var) {
            this.f216f = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:61:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:64:0x01de  */
    /* JADX WARN: Code duplicated, block: B:66:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:68:0x0205  */
    /* JADX WARN: Code duplicated, block: B:70:0x0209  */
    /* JADX WARN: Code duplicated, block: B:72:0x0239  */
    /* JADX WARN: Code duplicated, block: B:73:0x023b  */
    /* JADX WARN: Code duplicated, block: B:76:0x024d  */
    /* JADX WARN: Code duplicated, block: B:78:0x025a  */
    /* JADX WARN: Code duplicated, block: B:80:0x025f  */
    /* JADX WARN: Code duplicated, block: B:81:0x026c  */
    /* JADX WARN: Code duplicated, block: B:83:0x0271  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:66:0x01e8, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x0209, please report this as an issue */
    public void k0(int i) {
        s();
        boolean z = i <= 100;
        /* dex: v10 is the id of the action/title line, v13 the id of the
           error description and v0 the optional extra text. */
        int titleId = catch_.me_.if_.you_.can_.R.string.reset_search;
        int bodyId = catch_.me_.if_.you_.can_.R.string.unknown_error;
        java.lang.String extra = null;
        if (i == 1) {
            bodyId = catch_.me_.if_.you_.can_.R.string.out_of_memory;
        } else if (i == 2) {
            bodyId = catch_.me_.if_.you_.can_.R.string.bug_detected;
        } else if (i == 3) {
            titleId = catch_.me_.if_.you_.can_.R.string.fix_path;
            bodyId = catch_.me_.if_.you_.can_.R.string.disk_full;
        } else if (i == 4) {
            titleId = catch_.me_.if_.you_.can_.R.string.fix_path;
            bodyId = catch_.me_.if_.you_.can_.R.string.io_error;
        } else if (i == 9) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.maps_failed));
            sb.append("\n\n");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.game_protected));
            java.lang.String str = sb.toString();
            if (android.ext.Config.C) {
                sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append("\n\n");
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_root));
                str = sb.toString();
            }
            extra = i(str);
            bodyId = catch_.me_.if_.you_.can_.R.string.io_error;
        } else if (i == 10) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.maps_failed));
            sb.append("\n\n");
            sb.append(android.ext.b2.f(android.ext.Config.C ? catch_.me_.if_.you_.can_.R.string.vspace_error : catch_.me_.if_.you_.can_.R.string.root_error));
            extra = sb.toString();
            bodyId = catch_.me_.if_.you_.can_.R.string.io_error;
        } else if (i == 105) {
            /* dex :pswitch_3 - check whether the target process is optimised */
            int t105 = catch_.me_.if_.you_.can_.R.string.reset_search;
            java.lang.String e105 = null;
            if (android.ext.Config.C) {
                int flags = 0;
                boolean flagsKnown = false;
                try {
                    flags = android.ext.Tools.Y(android.ext.Config.E).flags;
                    flagsKnown = true;
                } catch (java.lang.Throwable th) {
                    android.ext.e1.s("Failed check vSpace: " + android.ext.Config.E, th);
                    e105 = null;
                    t105 = catch_.me_.if_.you_.can_.R.string.reset_search;
                }
                if (flagsKnown) {
                    if ((flags & 2) == 0) {
                        try {
                            e105 = android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.not_optimized2), android.ext.Config.F, android.ext.Config.F);
                            t105 = catch_.me_.if_.you_.can_.R.string.not_optimized2;
                        } catch (java.lang.Throwable th) {
                            android.ext.e1.s("Failed check vSpace: " + android.ext.Config.E, th);
                            e105 = null;
                            t105 = catch_.me_.if_.you_.can_.R.string.not_optimized2;
                        }
                    } else {
                        e105 = null;
                        t105 = catch_.me_.if_.you_.can_.R.string.reset_search;
                    }
                }
            } else {
                e105 = null;
                t105 = catch_.me_.if_.you_.can_.R.string.reset_search;
            }
            /* dex :goto_3 - the eperm description is only built when the
               optimised check did not produce a message */
            if (t105 == catch_.me_.if_.you_.can_.R.string.reset_search) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.eperm_error_descr_0));
                sb.append('\n');
                sb.append(1);
                sb.append(": ");
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.eperm_error_descr_3));
                sb.append('\n');
                sb.append(2);
                sb.append(": ");
                sb.append(android.ext.b2.f(android.ext.Config.C ? catch_.me_.if_.you_.can_.R.string.eperm_error_descr_5 : catch_.me_.if_.you_.can_.R.string.eperm_error_descr_4));
                e105 = sb.toString();
            }
            titleId = t105;
            bodyId = catch_.me_.if_.you_.can_.R.string.eperm_error;
            extra = e105;
        } else if (i == 106) {
            /* dex :pswitch_2 */
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.eperm_error_descr_0));
            sb.append('\n');
            sb.append(1);
            sb.append(": ");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.eperm_error_descr_1));
            sb.append('\n');
            sb.append(64);
            sb.append(": ");
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.eperm_error_descr_2));
            extra = i(sb.toString());
            bodyId = catch_.me_.if_.you_.can_.R.string.eperm_error_defend;
        } else if (i == 107) {
            /* dex :pswitch_1 */
            titleId = catch_.me_.if_.you_.can_.R.string.speedhack_fail;
            bodyId = catch_.me_.if_.you_.can_.R.string.speedhack_fail;
            extra = null;
        } else if (i == 108) {
            /* dex :pswitch_0 */
            extra = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.too_many_union_numbers) + ": 64";
            bodyId = catch_.me_.if_.you_.can_.R.string.error;
        }
        if (extra == null) {
            extra = android.ext.b2.f(titleId);
        }
        java.lang.String strF2 = android.ext.b2.f(bodyId);
        java.lang.String str = "{" + i + '}';
        if (this.w0.get(i)) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            if (T0 < jCurrentTimeMillis) {
                T0 = jCurrentTimeMillis + 2000;
                android.ext.Tools.K1(str + android.ext.b2.f(bodyId), 0);
            }
            if (z) {
                q(true);
            }
            return;
        }
        this.w0.put(i, true);
        android.app.AlertDialog.Builder message = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(str)).setMessage(strF2 + "\n\n" + extra);
        java.lang.String strF4 = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok);
        android.content.DialogInterface.OnClickListener mainService$y = z ? new android.ext.MainService$y(this) : null;
        android.app.AlertDialog.Builder cancelable = message.setPositiveButton(strF4, mainService$y).setCancelable(false);
        java.lang.String strF3 = null;
        android.content.DialogInterface.OnClickListener r_n = null;
        if (titleId == catch_.me_.if_.you_.can_.R.string.fix_path) {
            strF3 = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it);
            r_n = new android.ext.MainService$z(this);
        } else if (bodyId == catch_.me_.if_.you_.can_.R.string.eperm_error_defend) {
            strF3 = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help);
            r_n = new android.ext.MainService$a0(this);
        } else if (titleId == catch_.me_.if_.you_.can_.R.string.not_optimized2) {
            strF3 = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it);
            r_n = new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2wrslf24<7540yluwxdo0vsdfhv0wr0uxq0jdphjxdugldq0zlwkrxw0urrw2");
        }
        if (r_n != null) {
            cancelable.setNeutralButton(strF3, r_n);
        }
        android.ext.f.o(cancelable);
    }

    void k1() {
        int count = this.G.getAdapter().getCount();
        this.d0.setVisibility(count == 0 ? 8 : 0);
        this.d0.setText(java.lang.Integer.toString(count));
        int count2 = this.L.getAdapter().getCount();
        this.e0.setVisibility(count2 == 0 ? 8 : 0);
        this.e0.setText(java.lang.Integer.toString(count2));
        p1();
    }

    void l() {
        if (!P0 || (android.ext.Config.B & 2048) == 0 || this.v0 == null || !android.ext.e0.p()) {
            return;
        }
        P0 = false;
        new android.ext.n0$i(new android.ext.MainService$e0(this), "CheckLibs").start();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ae A[Catch: all -> 0x005c, TRY_LEAVE, TryCatch #3 {all -> 0x005c, blocks: (B:5:0x002a, B:7:0x0032, B:9:0x0043, B:11:0x0049, B:21:0x0073, B:25:0x0081, B:26:0x0085, B:29:0x0091, B:33:0x009c, B:35:0x00ae, B:19:0x006b), top: B:84:0x002a, inners: #6 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:40:0x00be A[Catch: all -> 0x00cd, TryCatch #5 {all -> 0x00cd, blocks: (B:38:0x00b8, B:40:0x00be, B:42:0x00c2, B:55:0x00e6, B:45:0x00ca, B:48:0x00cf, B:67:0x011d, B:56:0x00f5, B:58:0x00fa, B:60:0x0106, B:62:0x010d, B:63:0x0110, B:64:0x0113, B:65:0x0119), top: B:86:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00cf A[Catch: all -> 0x00cd, TryCatch #5 {all -> 0x00cd, blocks: (B:38:0x00b8, B:40:0x00be, B:42:0x00c2, B:55:0x00e6, B:45:0x00ca, B:48:0x00cf, B:67:0x011d, B:56:0x00f5, B:58:0x00fa, B:60:0x0106, B:62:0x010d, B:63:0x0110, B:64:0x0113, B:65:0x0119), top: B:86:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00fa A[Catch: all -> 0x00cd, TryCatch #5 {all -> 0x00cd, blocks: (B:38:0x00b8, B:40:0x00be, B:42:0x00c2, B:55:0x00e6, B:45:0x00ca, B:48:0x00cf, B:67:0x011d, B:56:0x00f5, B:58:0x00fa, B:60:0x0106, B:62:0x010d, B:63:0x0110, B:64:0x0113, B:65:0x0119), top: B:86:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0106 A[Catch: all -> 0x00cd, TryCatch #5 {all -> 0x00cd, blocks: (B:38:0x00b8, B:40:0x00be, B:42:0x00c2, B:55:0x00e6, B:45:0x00ca, B:48:0x00cf, B:67:0x011d, B:56:0x00f5, B:58:0x00fa, B:60:0x0106, B:62:0x010d, B:63:0x0110, B:64:0x0113, B:65:0x0119), top: B:86:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x010d A[Catch: all -> 0x00cd, TryCatch #5 {all -> 0x00cd, blocks: (B:38:0x00b8, B:40:0x00be, B:42:0x00c2, B:55:0x00e6, B:45:0x00ca, B:48:0x00cf, B:67:0x011d, B:56:0x00f5, B:58:0x00fa, B:60:0x0106, B:62:0x010d, B:63:0x0110, B:64:0x0113, B:65:0x0119), top: B:86:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0177  */
    /* JADX WARN: Code duplicated, block: B:99:0x0110 A[SYNTHETIC] */
    public void l0(android.ext.w wVar) throws java.lang.Throwable {
        android.ext.Tools$a0 tools$a0 = android.ext.Tools.J0(this.G);
        byte b2 = wVar.b();
        long[] jArr = null;
        int[] iArr = null;
        int i = 0;
        boolean z2;
        int iK;
        gg_d.a aVar = this.s0;
        android.ext.c cVar = new android.ext.c();
        int i9 = android.ext.b0.i();
        try {
            wVar.j();
            iK = (wVar.k() - wVar.a()) - 1;
            wVar.f();
            synchronized (aVar) {
                /* dex :try_start_1 - remember whether the checked data was
                   already saved before it is invalidated */
                z2 = S0;
                S0 = false;
                if (!z2) {
                    /* dex :try_start_2 - collect the addresses of the ranges
                       that are currently marked */
                    try {
                        int i10 = aVar.i();
                        long[] jArr2 = new long[i10];
                        int[] iArr2 = new int[i10];
                        android.ext.c cVar2 = new android.ext.c();
                        int i11 = 0;
                        for (int i12 = 0; i12 < i10; i12++) {
                            if (aVar.c(i12)) {
                                aVar.f(i12, cVar2);
                                jArr2[i11] = cVar2.f672a;
                                int i13 = i11 + 1;
                                iArr2[i11] = android.ext.c.w(cVar2.f674c);
                                i11 = i13;
                            }
                        }
                        jArr = jArr2;
                        iArr = iArr2;
                        i = i11;
                    } catch (java.lang.OutOfMemoryError e) {
                        /* dex :catch_0 -> :goto_2 */
                        android.ext.e1.l("Failed save checked data", e);
                        jArr = null;
                        iArr = null;
                        i = 0;
                    }
                }
                /* dex :goto_3 */
                aVar.d();
                int i2 = iK / (android.ext.InOut.n + 12);
                if (b2 == 0 && i2 > i9) {
                    i2 = i9;
                }
                aVar.e(i2);
                int i3 = 0;
                /* dex :goto_4 */
                while (iK - wVar.a() > 10 && (b2 != 0 || aVar.i() < i9)) {
                    /* dex :goto_5 */
                    long jG = wVar.g();
                    long jH = wVar.h();
                    int iF = wVar.f();
                    cVar.f672a = jG;
                    cVar.f674c = iF;
                    boolean flag;
                    if (jArr != null) {
                        /* dex :goto_6 - look for the address in the saved set */
                        int iW = android.ext.c.w(iF);
                        flag = z2;
                        while (i3 < i) {
                            long j = jArr[i3];
                            if (j == jG) {
                                int i8 = iArr[i3];
                                if (i8 == iW) {
                                    i3 = i3 + 1;
                                    flag = true;
                                    break;
                                } else if (i8 > iW) {
                                    break;
                                }
                            } else if (!android.ext.Tools.S1(j, jG)) {
                                break;
                            }
                            i3++;
                        }
                    } else {
                        flag = z2;
                    }
                    aVar.a(jG, jH, iF, flag);
                }
                /* dex :goto_b */
                aVar.k();
                if (b2 != 0) {
                    int i4 = aVar.i();
                    java.util.ArrayList arrayList = new java.util.ArrayList(i4);
                    for (int i5 = 0; i5 < i4; i5++) {
                        android.ext.c cVarF = aVar.f(i5, null);
                        if (cVarF != null) {
                            arrayList.add(cVarF);
                        }
                    }
                    arrayList.trimToSize();
                    android.ext.Script.d3(b2, arrayList);
                }
            }
        } catch (java.io.UncheckedIOException e) {
            /* dex :catch_1 / :catch_3 -> :goto_10 - the dex catches a plain java.io.IOException here; the buffer based reader of android.ext.w can only raise the unchecked variant, so the handler keeps the matching unchecked type. */
            android.ext.e1.l("Failed read", e);
        } catch (java.lang.OutOfMemoryError e) {
            /* dex :catch_2 / :catch_4 -> :goto_11 */
            int i14 = this.s0.i();
            this.s0.d();
            this.s0.k();
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.out_of_memory_error);
            android.ext.e1.s("list.size() = " + i14 + "; show count = " + android.ext.b0.i(), e);
        }
        /* dex :goto_12 */
        this.V(this.G.getAdapter());
        this.b1();
        if (b2 == 0) {
            this.B++;
        }
        android.ext.Tools.A1(this.G, tools$a0);
        instance.p1();
        this.X(b2, null);
    }

    public void l1() {
        m1(false);
    }

    void m() {
        q(false);
    }

    public void m0(android.ext.Script script) {
        android.ext.n2.i(new android.ext.MainService$d(this));
        if (this.f212b == script) {
            this.f212b = null;
        }
    }

    public void m1(boolean z) {
        if (android.ext.f1.f952b) {
            z = true;
        }
        try {
            int i = android.ext.Config.vSpaceReal ? 4 : 2;
            java.lang.Throwable th = null;
            int i2 = 0;
            while (i2 < i) {
                boolean z2 = i2 >= 2;
                try {
                    android.content.Context applicationContext = context.getApplicationContext();
                    if (z2) {
                        applicationContext = android.ext.Config.a(applicationContext);
                    }
                    android.app.NotificationManager notificationManager = (android.app.NotificationManager) applicationContext.getSystemService("notification");
                    if ((z || !android.ext.v.f1280d) && (android.ext.Config.B & 256) == 0) {
                        if (i2 == 0) {
                            android.ext.e1.d("cancel notification");
                            if (android.ext.v.f1277a != null) {
                                android.ext.v.f1277a.stopForeground(true);
                            }
                        }
                        if (notificationManager != null) {
                            notificationManager.cancel(1);
                            notificationManager.cancelAll();
                            return;
                        }
                    } else {
                        if (i2 == 0) {
                            android.ext.e1.d("add notification");
                        }
                        if (notificationManager != null) {
                            android.app.Notification notificationF = F(i2 % 2 == 0, z2);
                            notificationManager.notify(1, notificationF);
                            if (android.ext.v.f1277a != null) {
                                android.ext.v.f1277a.startForeground(1, notificationF);
                                android.ext.e1.d("startForeground 2." + i2);
                                return;
                            }
                            return;
                        }
                    }
                    android.ext.e1.d("Failed get NotificationManager " + i2);
                } catch (java.lang.Throwable th2) {
                    if (th != null) {
                        th2.addSuppressed(th);
                    }
                    if (i2 == i - 1) {
                        android.ext.e1.s("Failed startForeground " + i2, th2);
                        android.ext.n0.h(java.lang.Thread.currentThread(), th2, false);
                    }
                    th = th2;
                }
                i2++;
            }
        } catch (java.lang.Throwable th3) {
            android.ext.e1.a(th3);
        }
    }

    void n(byte b2) {
        o(b2, false);
    }

    public void n0(android.ext.Script script) {
        android.ext.n2.i(new android.ext.MainService$b(this));
    }

    void n1() {
        this.Q.setImageResource(!this.R ? catch_.me_.if_.you_.can_.R.drawable.ic_pause_white_18dp : catch_.me_.if_.you_.can_.R.drawable.ic_play_arrow_white_18dp);
    }

    void o(byte b2, boolean z) {
        p(b2, z, true);
    }

    public void o0(byte b2, long j, long j2, int i) {
        this.p0 = j;
        if (i == 0) {
            s();
            S0 = true;
            if (b2 == 0) {
                if (android.ext.b0.k() || android.ext.Config.k == 0 || j <= android.ext.b0.i()) {
                    D0(true);
                } else {
                    t();
                    android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search_helper) + ' ' + android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.found_count), java.lang.Long.valueOf(j)));
                    K0 = android.ext.Config.k == 2;
                }
            }
        }
        if (this.p0 == 0) {
            p((byte) 0, false, false);
        }
    }

    public void o1(boolean z) {
        if (z) {
            Q();
        }
        double dE = this.k0.e();
        T0((byte) 0, dE);
        android.ext.c2 c2Var = instance.f216f;
        if (c2Var != null) {
            c2Var.write("gg.setSpeed(");
            c2Var.write(java.lang.Double.toString(dE));
            c2Var.write(")\n");
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        /* dex: the identity comparisons come first, the sparse switch on the
           view id is only reached for views that are not part of the
           overlay chrome. */
        if (view == this.p || view == this.q || view == this.s) {
            this.r(true);
            return;
        }
        if (view == this.P) {
            this.E0();
            return;
        }
        if (view == this.o) {
            this.t();
            return;
        }
        if (view == this.Q) {
            this.C0(true);
            return;
        }
        if (view == this.g0) {
            android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_ranges).b();
            return;
        }
        if (view == null) {
            return;
        }
        java.lang.Object tag = view.getTag();
        int id;
        if (tag instanceof java.lang.Integer) {
            id = ((java.lang.Integer) tag).intValue();
        } else {
            id = view.getId();
        }
        switch (id) {
            case catch_.me_.if_.you_.can_.R.drawable.ic_ui_button_24dp:
                /* dex :sswitch_6 */
                this.f215e = true;
                return;
            case catch_.me_.if_.you_.can_.R.id.abort_button:
                /* dex :sswitch_5 */
                this.i.h();
                this.s();
                return;
            case catch_.me_.if_.you_.can_.R.id.hot_frame:
                /* dex :sswitch_4 */
                this.c0();
                return;
            case catch_.me_.if_.you_.can_.R.id.more_btn:
                /* dex :sswitch_3 */
                android.ext.Tools.s(this.J);
                return;
            case catch_.me_.if_.you_.can_.R.string.hide:
                /* dex :sswitch_0 */
                this.t();
                return;
            case catch_.me_.if_.you_.can_.R.string.interrupt:
                /* dex :sswitch_2 - the running script */
                java.lang.String string = "?";
                android.ext.Script script = this.f212b;
                if (script != null) {
                    java.lang.Object obj = script.U;
                    if (obj != null) {
                        string = obj.toString();
                        if (string.length() > 250) {
                            string = string.substring(0, 250) + "...";
                        }
                    }
                } else {
                    string = "??";
                }
                android.app.AlertDialog.Builder message = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script))).setMessage(string);
                android.ext.f.o(message.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.interrupt), new android.ext.MainService$q(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), null));
                return;
            case catch_.me_.if_.you_.can_.R.string.record:
                /* dex :sswitch_1 - the running recording */
                java.lang.String string2 = "?";
                android.ext.c2 c2Var = this.f216f;
                if (c2Var != null) {
                    string2 = c2Var.c();
                }
                android.app.AlertDialog.Builder message2 = android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.record_script))).setMessage(string2);
                android.ext.f.o(message2.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.stop), new android.ext.MainService$r(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), null));
                return;
            default:
                return;
        }
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        this.h.a(false, new android.ext.MainService$s(this));
        o1(false);
        this.j.x();
        return true;
    }

    void p(byte b2, boolean z, boolean z2) {
        if (z) {
            this.r0 = true;
        }
        this.p0 = 0L;
        if (z2) {
            this.i.l(b2);
        }
        instance.i.f793b.r();
        gg_d.a aVar = this.s0;
        synchronized (aVar) {
            try {
                aVar.d();
                aVar.k();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        V(this.G.getAdapter());
        b1();
        K0 = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:41:0x0113 A[PHI: r9
      0x0113: PHI (r9v16 int) = (r9v2 int), (r9v5 int), (r9v17 int) binds: [B:63:0x019c, B:57:0x0189, B:40:0x0111] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    public void p0(byte b2, int i, int[] iArr) {
        android.content.SharedPreferences.Editor sharedPreferences$EditorPutBoolean;
        int i2;
        int i3;
        int i4;
        java.lang.String strF;
        int i5;
        android.app.AlertDialog.Builder negativeButton;
        int i6;
        switch (i) {
            case 0:
                sharedPreferences$EditorPutBoolean = android.ext.Tools.M0().edit().putBoolean("mem-fail", true);
                sharedPreferences$EditorPutBoolean.commit();
                break;
            case 1:
                sharedPreferences$EditorPutBoolean = android.ext.Tools.M0().edit().remove("mem-fail");
                sharedPreferences$EditorPutBoolean.commit();
                break;
            case 3:
                s();
                if (b2 == 0) {
                    i2 = catch_.me_.if_.you_.can_.R.string.dump_ended;
                    android.ext.Tools.I1(i2, 0);
                }
                X(b2, null);
                break;
            case 4:
                s();
                i3 = catch_.me_.if_.you_.can_.R.string.dump_failed;
                if (b2 == 0) {
                    android.ext.Tools.H1(i3);
                }
                X(b2, android.ext.b2.f(i3));
                break;
            case 5:
                if (b2 == 0) {
                    i2 = catch_.me_.if_.you_.can_.R.string.copy_ended;
                    android.ext.Tools.I1(i2, 0);
                }
                X(b2, null);
                break;
            case 6:
                i3 = catch_.me_.if_.you_.can_.R.string.copy_failed;
                if (b2 == 0) {
                    android.ext.Tools.H1(i3);
                }
                X(b2, android.ext.b2.f(i3));
                break;
            case 8:
                this.S = true;
                break;
            case 9:
                this.S = false;
                break;
            case 10:
                if (b2 == 0) {
                    i4 = catch_.me_.if_.you_.can_.R.string.speedhack_loading;
                    android.ext.Tools.I1(i4, 0);
                }
                break;
            case 11:
                if (b2 == 0) {
                    strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.speedhack_loaded);
                    if (this.D0) {
                        strF = strF + "\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.speedhack_no_x86);
                    }
                    i5 = (this.D0 ? 1 : 0);
                    android.ext.Tools.K1(strF, i5);
                }
                this.D0 = false;
                break;
            case 12:
                if (b2 == 0) {
                    i4 = catch_.me_.if_.you_.can_.R.string.patch_loading;
                    android.ext.Tools.I1(i4, 0);
                }
                break;
            case 13:
                if (b2 == 0) {
                    android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.patch_loaded);
                    android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.disable_protection)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.must_restart_if)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
                }
                X(b2, null);
                break;
            case 14:
                i3 = catch_.me_.if_.you_.can_.R.string.patch_failed;
                if (b2 == 0) {
                    android.ext.Tools.H1(i3);
                }
                X(b2, android.ext.b2.f(i3));
                break;
            case 15:
                if (b2 == 0) {
                    i4 = catch_.me_.if_.you_.can_.R.string.unrandomizer_loading;
                    android.ext.Tools.I1(i4, 0);
                }
                break;
            case 16:
                if (b2 == 0) {
                    strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.unrandomizer_loaded);
                    if (this.D0) {
                        strF = strF + "\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.speedhack_no_x86);
                    }
                    i5 = (this.D0 ? 1 : 0);
                    android.ext.Tools.K1(strF, i5);
                }
                this.D0 = false;
                break;
            case 17:
                if (b2 == 0) {
                    negativeButton = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.waitpid_mode)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_waitpid)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.alternative), new android.ext.MainService$w(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), (android.content.DialogInterface.OnClickListener) null);
                    android.ext.f.o(negativeButton);
                }
                break;
            case 18:
                X(b2, null);
                break;
            case 19:
                S(iArr);
                break;
            case 20:
                android.app.AlertDialog.Builder alertDialog$BuilderB = android.ext.f.b();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ptrace_fail));
                sb.append("\n\n");
                sb.append(android.ext.b2.f(iArr[0] != 0 ? catch_.me_.if_.you_.can_.R.string.ptrace_fail_partially : catch_.me_.if_.you_.can_.R.string.ptrace_fail_full));
                sb.append("\n\n");
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ptrace_fail_solve));
                negativeButton = alertDialog$BuilderB.setMessage(sb.toString()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null);
                android.ext.f.o(negativeButton);
                break;
            case 21:
                if (iArr[1] != 0) {
                    i6 = catch_.me_.if_.you_.can_.R.string.feature_hide_4;
                } else if (iArr[2] != 0) {
                    i6 = catch_.me_.if_.you_.can_.R.string.feature_firmware;
                } else {
                    if (this.C0 && (android.ext.Config.A & 131072) != 0) {
                        this.C0 = false;
                        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_ptrace_bypass_mode).b();
                    }
                    i6 = catch_.me_.if_.you_.can_.R.string.feature_protection;
                }
                android.ext.Tools.K1(android.ext.b2.f(i6), 1);
                break;
            case 22:
                this.D0 = true;
                break;
        }
    }

    void p1() {
        if (android.ext.n2.e()) {
            e();
        } else {
            android.ext.n2.i(new android.ext.MainService$u(this));
        }
    }

    void q(boolean z) {
        o((byte) 0, z);
    }

    public void q0() {
        p1();
    }

    public void q1() {
        if (!I0) {
            return;
        }
        int iH = H() - 1;
        int iD1 = android.ext.Tools.d1();
        boolean z = (android.ext.Config.p & (1 << ((iH * 2) + iD1))) != 0;
        int i = android.ext.Config.r;
        if (iH >= 0) {
            int[] iArr = this.z0;
            if (iArr[iH] != i) {
                iArr[iH] = i;
                this.m.getCurrentView().setBackgroundColor((i & (1 << iH)) == 0 ? 0 : -16777216);
            }
        }
        this.J.setVisibility((z || iD1 != 0) ? 8 : 0);
        this.K.setVisibility(iD1 == 1 ? iH >= 0 ? 0 : 4 : 8);
        this.F.setVisibility(iD1 == 0 ? 0 : 8);
        this.E.setVisibility((iH < 0 || !z) ? 8 : 0);
        int i2 = 0;
        while (true) {
            android.fix.WrapLayout[] wrapLayoutArr = this.D;
            if (i2 >= wrapLayoutArr.length) {
                return;
            }
            android.fix.WrapLayout wrapLayout = wrapLayoutArr[i2];
            wrapLayout.setFill(android.ext.Config.f34g - 1);
            wrapLayout.setVisibility(i2 == iH ? 0 : 8);
            long j = android.ext.Config.f29b[(i2 * 2) + iD1];
            for (int i3 = 0; i3 < wrapLayout.getChildCount(); i3++) {
                try {
                    android.view.View childAt = wrapLayout.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setVisibility(((1 << i3) & j) != 0 ? 0 : 8);
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                } catch (java.lang.Throwable th) {
                    android.ext.e1.a(th);
                }
            }
            i2++;
        }
    }

    void r(boolean z) {
        this.h.b(z);
    }

    public void r0() {
        P();
        if (this.F0) {
            return;
        }
        this.F0 = true;
        android.ext.z1$d z1_d = this.v0;
        java.lang.String str = z1_d == null ? null : z1_d.f1434c;
        boolean z = z1_d == null ? false : z1_d.n;
        r(false);
        J0();
        s();
        s0(str, z);
    }

    void s() {
        this.j.t((byte) 2, -1L, 1L, 0, 1, "");
        this.i0.a(true);
        this.i.m();
        this.i.L();
        this.U = false;
    }

    void s0(java.lang.String str, boolean z) {
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.game_dead)).setItems(new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart_game), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart_game_without_protection), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_games_protection_title), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok)}, new android.ext.MainService$c0(this, str, z)).setCancelable(false));
    }

    void t() {
        u(true);
    }

    void u(boolean z) {
        java.lang.StringBuilder sb;
        java.lang.String strF;
        android.ext.e1.d("ServiceProxy dismissDialog: " + this.n);
        if (this.n == null) {
            return;
        }
        this.i0.a(false);
        this.n.dismiss();
        this.n = null;
        this.h0.a(z);
        this.j.m();
        this.T = this.R;
        boolean z2 = this.S;
        boolean z3 = (android.ext.Config.A & 128) != 0;
        if (this.i0.b() && (z3 || z2)) {
            java.lang.String string = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.paused) + ":\n";
            if (z3) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(string);
                sb2.append("- ");
                sb2.append(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.by_option), android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.hide_from_game) + ": 1"));
                sb2.append(";\n");
                string = sb2.toString();
            }
            if (z2) {
                if ((android.ext.Config.B & 4) != 0) {
                    sb = new java.lang.StringBuilder();
                    sb.append(string);
                    sb.append("- ");
                    strF = android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.by_option), android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.autopause) + ": " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes));
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append(string);
                    sb.append("- ");
                    strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.by_pause_button);
                }
                sb.append(strF);
                sb.append(";\n");
                string = sb.toString();
            }
            java.lang.String strTrim = string.trim();
            if (this.U) {
                android.ext.Tools.J1(strTrim);
            } else {
                this.U = true;
                android.ext.f.m(android.ext.f.c(android.ext.r.p).setMessage(strTrim).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).create());
            }
        }
        z0();
        this.i.L();
        l1();
    }

    public void u0() {
        android.ext.e1.d("<<");
        this.k0.l();
        o1(true);
    }

    int v() {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        try {
            android.content.pm.ApplicationInfo applicationInfoY = android.ext.Tools.Y(this.v0.f1434c);
            boolean z = true;
            if (applicationInfoY == null) {
                return 1;
            }
            java.lang.String str = applicationInfoY.nativeLibraryDir;
            if (str == null) {
                return 2;
            }
            byte[] bArr = new byte[20];
            java.io.File[] fileArrListFiles = new java.io.File(str).listFiles();
            if (fileArrListFiles != null) {
                boolean z2 = false;
                for (java.io.File file : fileArrListFiles) {
                    if (z2) {
                        break;
                    }
                    if (file != null && file.getName().startsWith("lib") && file.getName().endsWith(".so")) {
                        try {
                            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                            if (fileInputStream.read(bArr) > 13 && bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70 && bArr[18] == 40) {
                                try {
                                    android.ext.e1.d("doCheckLibs: " + file + " is ARM lib");
                                    z2 = true;
                                } catch (java.lang.Throwable th_c) {
                                    th = th_c;
                                    z2 = true;
                                    android.ext.e1.l("Failed check lib " + file, th_c);
                                }
                            }
                            fileInputStream.close();
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    }
                }
                if (z2) {
                    java.lang.String str2 = applicationInfoY.sourceDir;
                    if (str2 == null) {
                        return 4;
                    }
                    java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(str2);
                    java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                    while (true) {
                        if (!enumerationEntries.hasMoreElements()) {
                            z = false;
                            break;
                        }
                        java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        if (zipEntryNextElement.getName().contains("lib/x86/lib")) {
                            android.ext.e1.d("doCheckLibs: " + zipEntryNextElement.getName() + " is x86 lib");
                            break;
                        }
                    }
                    zipFile.close();
                    if (!z) {
                        return 5;
                    }
                    android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.h0(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.check_libs))).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.arm_libs)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), !android.ext.Config.C ? new android.ext.MainService$g0(this, str2) : new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2jdoohu|2lpdjh278:0krz0wr0uhsodfh0dup0oleudulhv0zlwk0{;90oleudulhv0{0soruh2")).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), new android.ext.MainService$f0(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
                    return 6;
                }
            }
            return 3;
        } catch (java.lang.Throwable th3) {
            android.ext.e1.l("Failed check libs for " + this.v0, th3);
            return 0;
        }
    }

    boolean v0() {
        boolean zW0 = w0((byte) 0);
        android.ext.c2 c2Var = instance.f216f;
        if (c2Var != null) {
            c2Var.write("gg.processKill()\n");
        }
        return zW0;
    }

    public void w(int i) {
        android.ext.f0 f0Var = this.i;
        if (f0Var == null || i < 80) {
            return;
        }
        f0Var.z();
    }

    boolean w0(byte b2) {
        android.ext.z1$d z1_d = this.v0;
        if (z1_d == null) {
            android.ext.Tools.J1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no_application));
            return false;
        }
        android.ext.e1.d("Kill game");
        this.i.C0(b2, z1_d.f1437f, z1_d.f1434c, z1_d.f1435d);
        this.i.L0(b2, (byte) 2);
        return true;
    }

    public void x(java.lang.String str, int i, java.lang.String str2) {
        P();
        android.ext.Script script = new android.ext.Script(new java.io.File(str), i, str2);
        this.f212b = script;
        script.R3();
    }

    boolean x0(byte b2, boolean z) {
        if ((!z && this.n == null) || this.R) {
            return false;
        }
        Q();
        this.i.L0(b2, (byte) 0);
        this.R = true;
        n1();
        return true;
    }

    void y(boolean z) {
        if (this.n != null) {
            return;
        }
        if (z) {
            this.h0.k();
        } else {
            this.h0.a(true);
        }
    }

    boolean y0(boolean z) {
        boolean zX0 = x0((byte) 0, z);
        android.ext.c2 c2Var = instance.f216f;
        if (c2Var != null) {
            c2Var.write("gg.processPause()\n");
        }
        return zX0;
    }

    java.lang.Object z() {
        android.ext.n1 n1Var;
        android.view.View view = this.f0;
        if (view == this.Z) {
            return this.s0;
        }
        if (view == this.a0) {
            android.ext.SavedListAdapter savedListAdapter = this.t0;
            if (savedListAdapter != null) {
                return savedListAdapter.f();
            }
        } else if (view == this.b0 && (n1Var = this.N) != null) {
            return n1Var.f();
        }
        return null;
    }

    boolean z0() {
        boolean zA0 = A0((byte) 0);
        android.ext.c2 c2Var = instance.f216f;
        if (c2Var != null) {
            c2Var.write("gg.processResume()\n");
        }
        return zA0;
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class Tools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.util.Random f489a = new java.util.Random(java.lang.System.currentTimeMillis());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f490b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static float f491c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile int f492d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static volatile int f493e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static java.util.regex.Pattern f494f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static android.view.inputmethod.InputMethodManager f495g;
    private static java.lang.String h;
    private static java.lang.String i;
    private static java.lang.String j;
    private static volatile android.content.pm.PackageManager k;
    private static volatile java.lang.String l;
    private static java.lang.String m;
    private static final android.ext.Tools$b0 n;
    private static int[] o;
    private static volatile java.lang.Object p;
    private static volatile java.lang.ref.WeakReference q;
    private static int r;
    private static java.lang.ref.WeakReference s;
    private static volatile boolean t;
    private static volatile byte u;
    static volatile java.lang.String[] v;
    private static volatile int w;

    static {
        f490b = android.os.Build.VERSION.SDK_INT >= 23 ? -1 : 1;
        f491c = 0.0f;
        f492d = -1;
        f493e = -1;
        f494f = java.util.regex.Pattern.compile("(\\d+)");
        h = null;
        i = null;
        j = null;
        k = null;
        l = null;
        m = null;
        n = new android.ext.Tools$b0(null);
        o = new int[]{catch_.me_.if_.you_.can_.R.string.unit_seconds_short, 60, catch_.me_.if_.you_.can_.R.string.unit_minutes_short, 60, catch_.me_.if_.you_.can_.R.string.unit_hours_short, 24, catch_.me_.if_.you_.can_.R.string.unit_days_short, 365, catch_.me_.if_.you_.can_.R.string.unit_years_short, -1};
        p = null;
        q = new java.lang.ref.WeakReference(null);
        r = 0;
        s = new java.lang.ref.WeakReference(null);
        t = false;
        u = (byte) 0;
        v = null;
        w = -1;
    }

    public static void A(java.lang.String str, boolean z) {
        if (str == null) {
            return;
        }
        android.ext.n2.i(new android.ext.Tools$a(str, z));
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b4 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #3 {all -> 0x00ca, blocks: (B:31:0x005e, B:33:0x00b4, B:35:0x00be, B:38:0x00c4, B:39:0x00c9, B:43:0x00cd, B:44:0x00d1, B:45:0x00d2, B:47:0x00d6, B:34:0x00ba), top: B:62:0x005e, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4 A[Catch: all -> 0x00ca, TryCatch #3 {all -> 0x00ca, blocks: (B:31:0x005e, B:33:0x00b4, B:35:0x00be, B:38:0x00c4, B:39:0x00c9, B:43:0x00cd, B:44:0x00d1, B:45:0x00d2, B:47:0x00d6, B:34:0x00ba), top: B:62:0x005e, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #3 {all -> 0x00ca, blocks: (B:31:0x005e, B:33:0x00b4, B:35:0x00be, B:38:0x00c4, B:39:0x00c9, B:43:0x00cd, B:44:0x00d1, B:45:0x00d2, B:47:0x00d6, B:34:0x00ba), top: B:62:0x005e, inners: #5 }] */
    public static android.content.pm.PackageInfo A0(java.lang.String str, int i2) throws android.content.pm.PackageManager.NameNotFoundException {
java.lang.Throwable th = null;
        android.content.pm.PackageInfo packageInfo = null;
        java.lang.Object objU0 = null;
        android.ext.Tools$y tools$yX0;
        boolean zA;
        java.lang.Object objB = null;
        if (android.ext.a0.i(str)) {
            android.ext.e1.i("Failed getPackageInfo, isBuggedPackage: " + str);
            return null;
        }
        android.content.pm.PackageManager packageManagerB0 = B0();
        if (packageManagerB0 != null) {
            try {
                boolean zA2 = android.ext.a0.a(str, "pkg_info");
                try {
                    packageInfo = packageManagerB0.getPackageInfo(str, i2);
                    try {
                        android.ext.a0.b(zA2);
                    } catch (java.lang.Throwable th_c) {
                        th = th_c;
                        if (!(th_c instanceof android.content.pm.PackageManager.NameNotFoundException)) {
                            throw th_c;
                        }
                        android.ext.e1.l("Failed getPackageInfo", th_c);
                    }
                } catch (java.lang.Throwable th2) {
                    try {
                        android.ext.a0.b(zA2);
                        throw th2;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        packageInfo = null;
                        if (!(th instanceof android.content.pm.PackageManager.NameNotFoundException)) {
                            throw th;
                        }
                        android.ext.e1.l("Failed getPackageInfo", th);
                        if (packageInfo == null) {
                            try {
                                java.lang.Class<?> cls = objU0.getClass();
                                java.lang.Class cls2 = java.lang.Integer.TYPE;
                                tools$yX0 = x0(cls, new android.ext.Tools$y[]{new android.ext.Tools$y(cls, "getPackageInfo", new java.lang.Class[]{java.lang.String.class, cls2, cls2}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2), 0}), new android.ext.Tools$y(cls, "getPackageInfo", new java.lang.Class[]{java.lang.String.class, cls2}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2)})});
                                if (tools$yX0 != null) {
                                    zA = android.ext.a0.a(str, "pkg_info2");
                                    try {
                                        objB = tools$yX0.b();
                                        android.ext.a0.b(zA);
                                        if (objB != null) {
                                            throw new android.content.pm.PackageManager.NameNotFoundException(str);
                                        }
                                    } catch (java.lang.Throwable th4) {
                                        android.ext.a0.b(zA);
                                        throw th4;
                                    }
                                }
                                if (objB instanceof android.content.pm.PackageInfo) {
                                    return (android.content.pm.PackageInfo) objB;
                                }
                            } catch (java.lang.Throwable th5) {
                                if (th5 instanceof android.content.pm.PackageManager.NameNotFoundException) {
                                    throw th5;
                                }
                                android.ext.e1.l("Failed getPackageInfo", th5);
                            }
                        }
                        return packageInfo;
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        } else {
            packageInfo = null;
        }
        if (packageInfo == null && (objU0 = u0()) != null) {
            java.lang.Class<?> cls3 = objU0.getClass();
            java.lang.Class cls4 = java.lang.Integer.TYPE;
            tools$yX0 = x0(cls3, new android.ext.Tools$y[]{new android.ext.Tools$y(cls3, "getPackageInfo", new java.lang.Class[]{java.lang.String.class, cls4, cls4}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2), 0}), new android.ext.Tools$y(cls3, "getPackageInfo", new java.lang.Class[]{java.lang.String.class, cls4}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2)})});
            if (tools$yX0 != null) {
                zA = android.ext.a0.a(str, "pkg_info2");
                objB = tools$yX0.b();
                android.ext.a0.b(zA);
                if (objB != null) {
                    throw new android.content.pm.PackageManager.NameNotFoundException(str);
                }
            }
            if (objB instanceof android.content.pm.PackageInfo) {
                return (android.content.pm.PackageInfo) objB;
            }
        }
        return packageInfo;
    }

    public static void A1(android.widget.ListView listView, android.ext.Tools$a0 tools$a0) {
        if (tools$a0 == null) {
            return;
        }
        B1(listView, tools$a0.f498a, tools$a0.f499b);
    }

    public static void B(java.lang.String str, java.lang.StringBuilder sb) {
        android.content.pm.PackageInfo packageInfoA0;
        java.lang.StringBuilder sb2 = sb == null ? new java.lang.StringBuilder() : sb;
        sb2.append("\nActivities:\n");
        if (sb == null) {
            android.ext.e1.d(sb2.toString().trim());
            sb2 = new java.lang.StringBuilder();
        }
        try {
            packageInfoA0 = A0(str, 1);
        } catch (java.lang.Throwable unused) {
            packageInfoA0 = null;
        }
        if (packageInfoA0 == null) {
            sb2.append("Null for: " + str);
            if (sb != null) {
                return;
            }
        } else {
            android.content.pm.ActivityInfo[] activityInfoArr = packageInfoA0.activities;
            if (activityInfoArr != null) {
                for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                    try {
                        sb2.append(activityInfo);
                        if (activityInfo != null) {
                            sb2.append('\n');
                            for (java.lang.reflect.Field field : android.content.pm.ActivityInfo.class.getFields()) {
                                int modifiers = field.getModifiers();
                                if (java.lang.reflect.Modifier.isPublic(modifiers) && !java.lang.reflect.Modifier.isStatic(modifiers)) {
                                    sb2.append(field.getName());
                                    sb2.append(": ");
                                    try {
                                        sb2.append(field.get(activityInfo));
                                    } catch (java.lang.Throwable th) {
                                        sb2.append(th);
                                    }
                                    sb2.append("; ");
                                }
                            }
                        }
                    } catch (java.lang.Throwable th2) {
                        sb2.append(th2);
                    }
                    try {
                        android.content.ComponentName componentName = new android.content.ComponentName(str, activityInfo.name);
                        sb2.append("enabled: ");
                        sb2.append(B0().getComponentEnabledSetting(componentName));
                        sb2.append("; ");
                    } catch (java.lang.Throwable th3) {
                        sb2.append(th3);
                    }
                    sb2.append('\n');
                    if (sb == null) {
                        android.ext.e1.d(sb2.toString().trim());
                        sb2 = new java.lang.StringBuilder();
                    }
                }
                return;
            }
            sb2.append("Null");
            if (sb != null) {
                return;
            }
        }
        android.ext.e1.d(sb2.toString().trim());
    }

    public static android.content.pm.PackageManager B0() {
        if (k == null && n.b(1)) {
            try {
                k = android.ext.r.n.getPackageManager();
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
            n.a(1);
        }
        if (k == null && n.b(2)) {
            try {
                k = android.ext.r.n.getApplication().getPackageManager();
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
            }
            n.a(2);
        }
        if (k == null && n.b(4)) {
            try {
                k = android.ext.r.n.getApplicationContext().getPackageManager();
            } catch (java.lang.Throwable th3) {
                android.ext.e1.a(th3);
            }
            n.a(4);
        }
        if (k == null && n.b(8)) {
            try {
                k = android.ext.MainService.context.getPackageManager();
            } catch (java.lang.Throwable th4) {
                android.ext.e1.a(th4);
            }
            n.a(8);
        }
        if (k == null && n.b(16)) {
            try {
                k = android.ext.MainService.context.getApplicationContext().getPackageManager();
            } catch (java.lang.Throwable th5) {
                android.ext.e1.a(th5);
            }
            n.a(16);
        }
        return k;
    }

    public static void B1(android.widget.ListView listView, int i2, int i3) {
        listView.setSelectionFromTop(i2, i3);
        listView.post(new android.ext.Tools$n(listView, i2, i3));
    }

    private static void C(android.view.ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            try {
                android.view.View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    childAt.setSoundEffectsEnabled(false);
                    if (childAt instanceof android.view.ViewGroup) {
                        C((android.view.ViewGroup) childAt);
                    }
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            }
        }
    }

    public static java.lang.String C0() {
        java.lang.String str = h;
        return str == null ? android.ext.i.f1002d : str;
    }

    public static void C1(android.widget.ListView listView, int i2) {
        listView.setOnHierarchyChangeListener(new android.ext.Tools$t(i2));
    }

    public static void D(android.content.DialogInterface dialogInterface) {
        dialogInterface.getClass();
        android.ext.n2.i(new android.ext.Tools$k(dialogInterface));
    }

    public static int D0(java.lang.Process process) {
        try {
            java.lang.reflect.Field declaredField = process.getClass().getDeclaredField("pid");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(process);
            declaredField.setAccessible(false);
            return i2;
        } catch (java.lang.Throwable unused) {
            return -1;
        }
    }

    public static void D1(android.widget.TextView textView, int i2) {
        try {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i2);
            } else {
                textView.setTextAppearance(textView.getContext(), i2);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public static void E(java.lang.ref.WeakReference weakReference) {
        android.app.AlertDialog alertDialog;
        if (weakReference == null || (alertDialog = (android.app.AlertDialog) weakReference.get()) == null) {
            return;
        }
        D(alertDialog);
    }

    public static int E0() {
        try {
            java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile("/proc/meminfo", "r");
            java.util.regex.Matcher matcher = f494f.matcher(randomAccessFile.readLine());
            java.lang.String strGroup = "-2";
            while (matcher.find()) {
                strGroup = matcher.group(1);
            }
            randomAccessFile.close();
            return java.lang.Integer.parseInt(strGroup);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed get RAM size", th);
            return -1;
        }
    }

    public static void E1(android.view.View view) {
        if ((android.ext.Config.B & 32) == 0 && view != null) {
            android.view.View viewI0 = I0(view);
            viewI0.setSoundEffectsEnabled(false);
            if (viewI0 instanceof android.view.ViewGroup) {
                C((android.view.ViewGroup) viewI0);
            }
        }
    }

    public static java.lang.String F(double d2) {
        long j2;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        long jAbs = java.lang.Math.abs((long) d2);
        int i2 = 0;
        while (true) {
            int[] iArr = o;
            if (i2 >= iArr.length) {
                break;
            }
            int i3 = iArr[i2 + 1];
            if (i3 <= 0) {
                j2 = 0;
            } else {
                long j3 = i3;
                long j4 = jAbs % j3;
                j2 = jAbs / j3;
                jAbs = j4;
            }
            if (jAbs >= 0) {
                if (sb.length() > 0) {
                    sb.insert(0, ":");
                }
                if (i2 == 0) {
                    sb.insert(0, L1("%f", java.lang.Double.valueOf(java.lang.Math.abs(d2) % ((double) i3))).replaceFirst("\\D?0+$", ""));
                } else {
                    sb.insert(0, jAbs);
                }
            }
            if (j2 == 0) {
                break;
            }
            i2 += 2;
            jAbs = j2;
        }
        if (sb.length() == 0) {
            sb.insert(0, "0");
        }
        if (d2 < 0.0d) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    public static java.lang.String F0(java.lang.String str) {
        return v != null ? str.replace(v[0], v[1]) : str;
    }

    private static void F1(android.view.View view, android.view.WindowManager.LayoutParams windowManager$LayoutParams, boolean z) {
        Q(windowManager$LayoutParams);
        android.ext.n2.i(new android.ext.Tools$p(z, windowManager$LayoutParams, view));
    }

    public static float G(float f2) {
        android.content.Context contextF0;
        float f3 = f491c;
        if (f3 == 0.0f && (contextF0 = f0()) != null) {
            f3 = contextF0.getResources().getDisplayMetrics().density;
        }
        if (f3 == 0.0f) {
            f3 = 1.0f;
        }
        return f2 * f3;
    }

    public static android.graphics.drawable.Drawable G0(android.graphics.drawable.Drawable drawable, int i2) {
java.lang.Throwable th = null;
        android.graphics.Bitmap bitmap;
        try {
            if (!(drawable instanceof android.graphics.drawable.BitmapDrawable) || (bitmap = ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap()) == null) {
                return drawable;
            }
            int i3 = i2 + 4;
            if (bitmap.getWidth() <= i3 && bitmap.getHeight() <= i3) {
                return drawable;
            }
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            android.graphics.drawable.BitmapDrawable bitmapDrawable = new android.graphics.drawable.BitmapDrawable(f0().getResources(), android.graphics.Bitmap.createScaledBitmap(bitmap, i2, i2, false));
            try {
                android.ext.e1.d("getResized: " + bitmap.getWidth() + 'x' + bitmap.getHeight() + " -> " + i2 + 'x' + i2 + " in " + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
                return bitmapDrawable;
            } catch (java.lang.Throwable th_c) {
                th = th_c;
                drawable = bitmapDrawable;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
        android.ext.e1.a(th);
        return drawable;
    }

    public static void G1(android.view.View view, float f2) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) f2;
            view.setLayoutParams(layoutParams);
        }
    }

    public static int H() {
        if (f492d < 0) {
            f492d = (int) G(48.0f);
        }
        return f492d;
    }

    private static java.lang.String H0() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < 4; i2++) {
            int iNextInt = f489a.nextInt(63);
            sb.append((char) (iNextInt < 10 ? iNextInt + 48 : iNextInt < 36 ? iNextInt + 55 : iNextInt + 61));
        }
        return sb.toString();
    }

    public static void H1(int i2) {
        K1(android.ext.b2.f(i2), 1);
    }

    public static java.lang.Process I(java.lang.String[] strArr) {
        return K(strArr, null, null);
    }

    public static android.view.View I0(android.view.View view) {
        android.view.View rootView = view.getRootView();
        if (rootView != null) {
            return rootView;
        }
        while (true) {
            java.lang.Object parent = view.getParent();
            if (parent == null || !(parent instanceof android.view.View)) {
                break;
            }
            view = (android.view.View) parent;
        }
        return view;
    }

    public static void I1(int i2, int i3) {
        K1(android.ext.b2.f(i2), i3);
    }

    public static java.lang.Process J(java.lang.String[] strArr, java.lang.String[] strArr2) {
        return K(strArr, strArr2, null);
    }

    public static android.ext.Tools$a0 J0(android.widget.ListView listView) {
        android.view.View childAt;
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        try {
            childAt = listView.getChildAt(0);
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            childAt = null;
        }
        return new android.ext.Tools$a0(firstVisiblePosition, childAt != null ? childAt.getTop() - listView.getPaddingTop() : 0);
    }

    public static void J1(java.lang.String str) {
        K1(str, 1);
    }

    public static java.lang.Process K(java.lang.String[] strArr, java.lang.String[] strArr2, java.io.File file) {
        if (!t) {
            try {
                return java.lang.Runtime.getRuntime().exec(strArr, strArr2, file);
            } catch (java.lang.Throwable th) {
                java.lang.String message = th.getMessage();
                if (!message.contains("nknown error") && !message.contains("xec failed") && !message.contains("ead failed")) {try {

                    throw th;
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
                }
                android.ext.e1.s("Failed exec: " + java.util.Arrays.toString(strArr) + "; " + strArr2 + "; " + file, th);
            }
        }
        java.lang.Process processC = android.lang.ProcessBuilder.c(strArr, strArr2, file);
        t = true;
        return processC;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    public static java.lang.String K0() {
        java.lang.String absolutePath;
        int i2;
        try {
            absolutePath = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Fail get sdcard path", th);
            absolutePath = null;
        }
        if (absolutePath == null) {
            return "/sdcard";
        }
        if (!absolutePath.startsWith("/storage/emulated/0")) {
            return absolutePath;
        }
        if (r == 0) {
            if (c1(absolutePath)) {
                i2 = -1;
            } else {
                if (c1("/storage/emulated/legacy" + absolutePath.substring(19))) {
                    i2 = 1;
                } else {
                    i2 = -1;
                }
            }
            r = i2;
        }
        if (r <= 0) {
            return absolutePath;
        }
        return "/storage/emulated/legacy" + absolutePath.substring(19);
    }

    public static void K1(java.lang.String str, int i2) {
        android.ext.n2.i(new android.ext.Tools$b(str, i2));
    }

    public static void L(android.view.Window window, android.view.View view, boolean z) {
        android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager) f0().getSystemService("input_method");
        int i2 = window.getAttributes().softInputMode & (-16);
        if (z) {
            window.clearFlags(131072);
            window.setSoftInputMode(i2 | 5);
            inputMethodManager.showSoftInput(view, 0);
        } else {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            window.addFlags(131072);
            window.setSoftInputMode(i2 | 2);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static int L0(java.lang.Object obj) {
        int i2;
        int i3 = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof gg_d.a) {
            gg_d.a aVar = (gg_d.a) obj;
            int i4 = aVar.i();
            i2 = 0;
            while (i3 < i4) {
                try {
                    if (aVar.c(i3)) {
                        i2++;
                    }
                } catch (java.lang.IndexOutOfBoundsException unused) {
                }
                i3++;
            }
        } else {
            if (!(obj instanceof gg_d.e)) {
                if (!(obj instanceof boolean[])) {
                    throw new java.lang.IllegalArgumentException();
                }
                boolean[] zArr = (boolean[]) obj;
                int length = zArr.length - 1;
                for (int i5 = 1; i5 < length; i5++) {
                    if (zArr[i5]) {
                        i3++;
                    }
                }
                return i3;
            }
            gg_d.e eVar = (gg_d.e) obj;
            int iL = eVar.l();
            i2 = 0;
            while (i3 < iL) {
                if (eVar.a(i3)) {
                    i2++;
                }
                i3++;
            }
        }
        return i2;
    }

    public static java.lang.String L1(java.lang.String str, java.lang.Object... objArr) {
        try {
            str = java.lang.String.format(android.ext.k.f(), str.replace((char) 65292, ','), objArr);
        } catch (java.lang.Throwable th) {
            java.lang.String str2 = "Failed String.format('" + str + "', " + java.util.Arrays.toString(objArr) + ") with '" + android.ext.k.f() + "' (" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.lang_code) + ") " + android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_number_locale).f42d;
            android.ext.e1.l(str2, th);
            android.ext.n0.i(str2 + "\n\n" + android.ext.e1.n(th));
            if (str != null && objArr != null) {
                java.lang.String[] strArrSplit = str.split("%(\\d+\\$)?([\\-#+ 0;\\(])?(\\d+)?(\\.\\d+)?([bBhHsScCdoxXeEfgGaA]|[tT][HIklMSLNpzZsQBbhAaCYyjmdeRTrDFc])", objArr.length + 1);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    if (i2 < strArrSplit.length) {
                        sb.append(strArrSplit[i2]);
                    }
                    sb.append(objArr[i2]);
                }
                if (objArr.length < strArrSplit.length) {
                    sb.append(strArrSplit[objArr.length]);
                }
                str = sb.toString().replace("%n", "\n").replace("%%", "%");
            }
        }
        return str == null ? "Failed call String.format" : str;
    }

    public static void M(java.lang.String str, java.io.File file) {
        android.content.res.Resources resources = f0().getResources();
        int iD = android.ext.b2.d("ydw" + str, "raw");
        if (iD == 0) {
            android.ext.e1.d("Nothing extract file " + str + ' ' + file.getAbsolutePath());
            throw new java.lang.RuntimeException("Nothing extract");
        }
        try {
            byte[] bArr = new byte[8192];
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
            java.io.InputStream inputStreamOpenRawResource = resources.openRawResource(iD);
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr);
                if (i2 <= 0) {
                    inputStreamOpenRawResource.close();
                    fileOutputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (java.io.IOException e2) {
            android.ext.e1.g("Failed extract file " + str + ' ' + file.getAbsolutePath(), e2);
            throw new java.lang.RuntimeException(e2);
        }
    }

    public static android.content.SharedPreferences M0() {
        android.content.SharedPreferences sharedPreferences = (android.content.SharedPreferences) s.get();
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        android.content.SharedPreferences sharedPreferences2 = f0().getSharedPreferences(android.ext.MainService.G0, 0);
        s = new java.lang.ref.WeakReference(sharedPreferences2);
        return sharedPreferences2;
    }

    public static java.lang.String M1(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.Object obj) {
        java.lang.String str4;
        try {
            str4 = java.lang.String.format(android.ext.k.f(), str, obj);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Format fail 1", th);
            str4 = null;
        }
        if (str4 == null) {
            try {
                str4 = java.lang.String.format(android.ext.k.f(), str2, obj);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.s("Format fail 2", th2);
            }
        }
        return str4 == null ? str3 : str4;
    }

    public static void N(android.app.AlertDialog alertDialog) {
        if (alertDialog == null) {
            return;
        }
        int i2 = 0;
        android.widget.TextView[] textViewArr = {alertDialog.getButton(-1), alertDialog.getButton(-2), alertDialog.getButton(-3)};
        android.view.ViewGroup viewGroup = null;
        for (int i3 = 0; i3 < 3; i3++) {
            android.widget.TextView textView = textViewArr[i3];
            if (textView != null && (viewGroup = (android.view.ViewGroup) textView.getParent()) != null) {
                break;
            }
        }
        if (viewGroup == null) {
            return;
        }
        int width = viewGroup.getWidth();
        if (width == 0) {
            viewGroup.requestLayout();
            width = viewGroup.getWidth();
            if (width == 0) {
                width = viewGroup.getMeasuredWidth();
            }
            if (width == 0) {
                viewGroup.measure(-1, -2);
                width = viewGroup.getMeasuredWidth();
            }
        }
        if (width == 0 || P0(width, viewGroup, 0)) {
            return;
        }
        for (int i4 = 0; i4 < 3; i4++) {
            android.widget.TextView textView2 = textViewArr[i4];
            if (textView2 != null) {
                textView2.setAllCaps(false);
            }
        }
        if (P0(width, viewGroup, 5)) {
            return;
        }
        for (int i5 = 0; i5 < 3; i5++) {
            android.widget.TextView textView3 = textViewArr[i5];
            if (textView3 != null) {
                android.content.res.ColorStateList textColors = textView3.getTextColors();
                D1(textView3, catch_.me_.if_.you_.can_.R.style.SmallText);
                textView3.setTextColor(textColors);
            }
        }
        if (P0(width, viewGroup, 10)) {
            return;
        }
        java.lang.String[][] strArr = {new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no)}, new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.save), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok)}, new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.new_search), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.new_search_short)}};
        int i6 = 0;
        while (i6 < 3) {
            java.lang.String[] strArr2 = strArr[i6];
            if (strArr2 != null) {
                int i7 = 0;
                for (int i8 = 0; i8 < strArr2.length; i8++) {
                    if (strArr2[i7].length() >= strArr2[i8].length()) {
                        i7 = i8;
                    }
                }
                int i9 = 0;
                boolean z = false;
                while (i9 < 3) {
                    android.widget.TextView textView4 = textViewArr[i9];
                    if (textView4 != null) {
                        java.lang.String string = textView4.getText().toString();
                        while (i2 < strArr2.length) {
                            if (i2 != i7 && strArr2[i2].equals(string)) {
                                textView4.setText(strArr2[i7]);
                                z = true;
                            }
                            i2++;
                        }
                    }
                    i9++;
                    i2 = 0;
                }
                if (z && P0(width, viewGroup, i6 + 20)) {
                    return;
                }
            }
            i6++;
            i2 = 0;
        }
        boolean z2 = false;
        for (int i10 = 0; i10 < 3; i10++) {
            android.widget.TextView textView5 = textViewArr[i10];
            if (textView5 != null && textView5.getText().toString().indexOf(32) != -1) {
                textView5.setText(textView5.getText().toString().replace(' ', '\n'));
                z2 = true;
            }
        }
        if (z2 && P0(width, viewGroup, 40)) {
            return;
        }
        if (viewGroup instanceof android.widget.LinearLayout) {
            android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) viewGroup;
            if (linearLayout.getOrientation() == 0) {
                linearLayout.setOrientation(1);
                if (P0(width, viewGroup, 100)) {
                    return;
                }
            }
        }
        P0(width, viewGroup, -1);
    }

    public static android.content.Intent N0(android.content.Context context, java.lang.String str, java.lang.String str2) {
        if (context == null) {
            context = f0();
        }
        android.content.Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            launchIntentForPackage = new android.content.Intent("android.intent.action.MAIN");
        }
        launchIntentForPackage.setPackage(str);
        if (str2 != null) {
            launchIntentForPackage.setClassName(str, str2);
        }
        launchIntentForPackage.setFlags(268435456);
        return launchIntentForPackage;
    }

    public static java.lang.String N1(int i2) {
        return O1(android.ext.b2.f(i2));
    }

    public static void O(android.view.View view) {
    }

    public static android.view.View O0(android.view.View view) {
        android.view.ViewParent parent;
        if (view != null && (parent = view.getParent()) != null && (parent instanceof android.view.ViewGroup)) {
            try {
                ((android.view.ViewGroup) parent).removeView(view);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        return view;
    }

    public static java.lang.String O1(java.lang.String str) {
        return P1(str, ":");
    }

    public static void P(android.widget.TextView textView) {
        try {
            android.view.ViewTreeObserver viewTreeObserver = textView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnPreDrawListener(textView);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    private static boolean P0(int i2, android.view.ViewGroup viewGroup, int i3) {
        viewGroup.requestLayout();
        viewGroup.measure(-2, -2);
        int measuredWidth = viewGroup.getMeasuredWidth();
        boolean z = measuredWidth <= i2;
        if (i3 != 0 || !z) {
            android.ext.e1.d("fixDialogButtonsSize: " + measuredWidth + " <= " + i2 + " = " + z + " [" + i3 + ']');
        }
        return z;
    }

    private static java.lang.String P1(java.lang.String str, java.lang.String str2) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return str;
        }
        if (str2 != null) {
            if (!str2.isEmpty()) {
                while (length != 0) {
                    char cCharAt = str.charAt(length - 1);
                    if (str2.indexOf(cCharAt) == -1 && !java.lang.Character.isWhitespace(cCharAt)) {
                        break;
                    }
                    length--;
                }
            } else {
                return str;
            }
        } else {
            while (length != 0 && java.lang.Character.isWhitespace(str.charAt(length - 1))) {
                length--;
            }
        }
        return str.substring(0, length);
    }

    public static android.view.WindowManager.LayoutParams Q(android.view.WindowManager.LayoutParams windowManager$LayoutParams) {
        android.os.IBinder windowToken;
        windowManager$LayoutParams.flags = (android.ext.Config.B & 2) != 0 ? windowManager$LayoutParams.flags | 16777216 : windowManager$LayoutParams.flags & (-16777217);
        boolean zW1 = W1();
        if (android.ext.m2.f1074a && !zW1) {
            android.ext.e1.d("canDrawOverlays = false; fixed");
        }
        if (zW1) {
            if ((windowManager$LayoutParams.type == android.ext.m2.b() || windowManager$LayoutParams.type == android.ext.m2.c()) && windowManager$LayoutParams.token != null) {
                android.ext.e1.d("token: null " + windowManager$LayoutParams.token);
                windowToken = null;
            }
            if (android.ext.Config.vSpaceReal && !android.ext.Config.D) {
                android.ext.e1.d("Use 10 " + android.ext.Config.E + " instead of " + windowManager$LayoutParams.packageName);
                windowManager$LayoutParams.packageName = android.ext.Config.E;
            }
            return windowManager$LayoutParams;
        }
        windowManager$LayoutParams.type = 2;
        windowToken = android.ext.r.n.getWindow().getAttributes().token;
        if (windowToken == null) {
            windowToken = android.ext.r.n.getWindow().getDecorView().getRootView().getWindowToken();
        }
        windowManager$LayoutParams.token = windowToken;
        if (android.ext.Config.vSpaceReal) {
            android.ext.e1.d("Use 10 " + android.ext.Config.E + " instead of " + windowManager$LayoutParams.packageName);
            windowManager$LayoutParams.packageName = android.ext.Config.E;
        }
        return windowManager$LayoutParams;
    }

    public static boolean Q0(android.view.View view) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                try {
                    android.view.View childAt = viewGroup.getChildAt(i2);
                    if (childAt == null || childAt.getVisibility() != 0 || (!(childAt instanceof android.widget.EditText) && (!(childAt instanceof android.view.ViewGroup) || !Q0(childAt)))) {
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                }
            }
            return false;
        }
        if (!(view instanceof android.widget.EditText)) {
            return false;
        }
        return true;
    }

    public static java.lang.String Q1(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        int length = strTrim.length();
        for (int i2 = length - 1; i2 > 0 && strTrim.charAt(i2) == '/'; i2--) {
            length--;
        }
        return length < strTrim.length() ? strTrim.substring(0, length) : strTrim;
    }

    public static void R(android.view.Window window) {
        window.setAttributes(Q(window.getAttributes()));
    }

    public static void R0(android.app.AlertDialog alertDialog) {
        android.ext.n2.i(new android.ext.Tools$d(alertDialog));
    }

    public static android.graphics.drawable.Drawable R1(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            return drawable;
        }
        try {
            android.graphics.drawable.Drawable.ConstantState constantState = drawable.getConstantState();
            return constantState != null ? constantState.newDrawable() : drawable;
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return drawable;
        }
    }

    public static void S(android.view.View view) {
        android.view.View viewI0 = I0(view);
        E1(viewI0);
        O(viewI0);
    }

    public static void S0(android.view.View view) {
        android.ext.n2.i(new android.ext.Tools$f(view));
    }

    public static boolean S1(long j2, long j3) {
        return ((j2 < 0) ^ (j2 < j3)) ^ (j3 < 0);
    }

    private static java.lang.String T(long j2, boolean z) {
        java.lang.String str;
        java.lang.String strL1;
        float f2 = j2;
        if (f2 > 900.0f) {
            f2 /= 1024.0f;
            str = "KB";
        } else {
            str = "B";
        }
        if (f2 > 900.0f) {
            f2 /= 1024.0f;
            str = "MB";
        }
        if (f2 > 900.0f) {
            f2 /= 1024.0f;
            str = "GB";
        }
        if (f2 > 900.0f) {
            f2 /= 1024.0f;
            str = "TB";
        }
        if (f2 > 900.0f) {
            f2 /= 1024.0f;
            str = "PB";
        }
        if (f2 < 1.0f) {
            strL1 = L1("%.2f", java.lang.Float.valueOf(f2));
        } else if (f2 < 10.0f) {
            java.lang.Object[] objArr = new java.lang.Object[1];
            java.lang.Float fValueOf = java.lang.Float.valueOf(f2);
            if (z) {
                objArr[0] = fValueOf;
                strL1 = L1("%.1f", objArr);
            } else {
                objArr[0] = fValueOf;
                strL1 = L1("%.2f", objArr);
            }
        } else if (f2 < 100.0f) {
            java.lang.Object[] objArr2 = new java.lang.Object[1];
            java.lang.Float fValueOf2 = java.lang.Float.valueOf(f2);
            if (z) {
                objArr2[0] = fValueOf2;
                strL1 = L1("%.0f", objArr2);
            } else {
                objArr2[0] = fValueOf2;
                strL1 = L1("%.2f", objArr2);
            }
        } else {
            strL1 = L1("%.0f", java.lang.Float.valueOf(f2));
        }
        return strL1 + ' ' + str;
    }

    public static void T0(android.view.Window window) {
        android.ext.n2.i(new android.ext.Tools$e(window));
    }

    public static boolean T1(long j2, long j3) {
        return j2 == j3 || S1(j2, j3);
    }

    public static java.lang.String U(android.content.Context context, long j2) {
        try {
            return android.text.format.Formatter.formatFileSize(context, j2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            try {
                return T(j2, false);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
                return java.lang.Long.toString(j2);
            }
        }
    }

    public static void U0(java.lang.ref.WeakReference weakReference) {
        android.app.AlertDialog alertDialog;
        if (weakReference == null || (alertDialog = (android.app.AlertDialog) weakReference.get()) == null) {
            return;
        }
        R0(alertDialog);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0017  */
    public static void U1(android.content.res.Configuration configuration) {
        int i2 = 0;
        if (configuration == null) {
            try {
                configuration = f0().getResources().getConfiguration();
                if (configuration.orientation == 2) {
                    i2 = 1;
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        } else if (configuration.orientation == 2) {
            i2 = 1;
        }
        w = i2;
    }

    public static int V(int i2, int i3) {
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 == 0) {
                return i5;
            }
            i3 = i5 % i2;
        }
    }

    public static int V0(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return -1;
        }
        int[] iArrW = w(bArr2);
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            while (i2 > 0 && bArr2[i2] != bArr[i3]) {
                i2 = iArrW[i2 - 1];
            }
            if (bArr2[i2] == bArr[i3]) {
                i2++;
            }
            if (i2 == bArr2.length) {
                return (i3 - bArr2.length) + 1;
            }
        }
        return -1;
    }

    public static void V1(android.view.View view, android.view.WindowManager.LayoutParams windowManager$LayoutParams) {
        android.view.ViewParent parent = view.getParent();
        if (parent instanceof android.ext.Tools$ViewWrapper) {
            view = (android.ext.Tools$ViewWrapper) parent;
        }
        F1(view, windowManager$LayoutParams, false);
    }

    public static java.lang.String W() {
        java.lang.String packageCodePath = null;
        java.lang.String str = null;
        try {
            android.content.Context contextF0 = f0();
            packageCodePath = contextF0 != null ? contextF0.getPackageCodePath() : null;
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        if (packageCodePath == null) {
            try {
                android.content.pm.ApplicationInfo applicationInfoY = Y(android.ext.i.f1002d);
                if (applicationInfoY != null) {
                    packageCodePath = applicationInfoY.sourceDir;
                }
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
            }
        }
        if (packageCodePath != null) {
            return packageCodePath;
        }
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("/proc/self/maps")));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains(android.ext.i.f1002d) && line.contains(".apk")) {
                        java.lang.String str2 = line.split("\\.apk", 2)[0] + ".apk";
                        if (str2.indexOf(64) == -1) {
                            packageCodePath = '/' + str2.split("/", 2)[1].trim();
                            break;
                        }
                        java.lang.String[] strArrSplit = str2.trim().split("/");
                        str = '/' + strArrSplit[strArrSplit.length - 1].trim().replace('@', '/');
                    }
                } else {
                    break;
                }
            }
            bufferedReader.close();
            return (packageCodePath != null || str == null) ? packageCodePath : str;
        } catch (java.lang.Throwable th3) {
            android.ext.e1.a(th3);
            return packageCodePath;
        }
    }

    public static void W0(android.app.Activity activity) {
        try {
            a(activity);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        try {
            a(activity.getApplication());
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
        try {
            a(activity.getApplicationContext());
        } catch (java.lang.Throwable th3) {
            android.ext.e1.a(th3);
        }
    }

    static boolean W1() {
        if (!android.ext.m2.f1074a) {
            return false;
        }
        if (f490b == -1) {
            f490b = m(f0()) ? 1 : 0;
        }
        return f490b != 0;
    }

    public static android.graphics.drawable.Drawable X(android.content.pm.ApplicationInfo applicationInfo) {
        android.content.pm.PackageManager packageManager = k;
        android.graphics.drawable.Drawable drawableLoadIcon = null;
        if (applicationInfo != null && packageManager != null) {
            try {
                boolean zA = android.ext.a0.a(applicationInfo.packageName, "icon");
                try {
                    drawableLoadIcon = applicationInfo.loadIcon(packageManager);
                    android.ext.a0.b(zA);
                    if (drawableLoadIcon == null) {
                        boolean zA2 = android.ext.a0.a(applicationInfo.packageName, "icon2");
                        try {
                            drawableLoadIcon = packageManager.getApplicationIcon(applicationInfo);
                            android.ext.a0.b(zA2);
                        } catch (java.lang.Throwable th) {
                            android.ext.a0.b(zA2);
                            throw th;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    android.ext.a0.b(zA);
                    throw th2;
                }
            } catch (java.lang.Throwable th3) {
                android.ext.e1.l("Failed load icon for: " + applicationInfo.packageName, th3);
            }
        }
        return drawableLoadIcon;
    }

    public static void X0(android.content.Context context) {
        try {
            a(context);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public static boolean X1(java.lang.Process process, int i2) {
        java.util.concurrent.FutureTask futureTask = new java.util.concurrent.FutureTask(new android.ext.Tools$h(process));
        new android.ext.n0$i(futureTask, "waitForTimeout: " + process).start();
        try {
            return ((java.lang.Boolean) futureTask.get(i2, java.util.concurrent.TimeUnit.SECONDS)).booleanValue();
        } catch (java.lang.Exception unused) {
            return Z0(process);
        }
    }

    public static android.content.pm.ApplicationInfo Y(java.lang.String str) {try {

        return Z(str, 0);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    public static int[] Y0(java.util.List list) {
        int[] iArr = new int[list.size()];
        java.util.Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((java.lang.Integer) it.next()).intValue();
            i2++;
        }
        return iArr;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x004c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0050  */
    /* JADX WARN: Code duplicated, block: B:33:0x00b4 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #3 {all -> 0x00ca, blocks: (B:31:0x005e, B:33:0x00b4, B:35:0x00be, B:38:0x00c4, B:39:0x00c9, B:43:0x00cd, B:44:0x00d1, B:45:0x00d2, B:47:0x00d6, B:34:0x00ba), top: B:62:0x005e, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4 A[Catch: all -> 0x00ca, TryCatch #3 {all -> 0x00ca, blocks: (B:31:0x005e, B:33:0x00b4, B:35:0x00be, B:38:0x00c4, B:39:0x00c9, B:43:0x00cd, B:44:0x00d1, B:45:0x00d2, B:47:0x00d6, B:34:0x00ba), top: B:62:0x005e, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00d6 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #3 {all -> 0x00ca, blocks: (B:31:0x005e, B:33:0x00b4, B:35:0x00be, B:38:0x00c4, B:39:0x00c9, B:43:0x00cd, B:44:0x00d1, B:45:0x00d2, B:47:0x00d6, B:34:0x00ba), top: B:62:0x005e, inners: #5 }] */
    public static android.content.pm.ApplicationInfo Z(java.lang.String str, int i2) throws android.content.pm.PackageManager.NameNotFoundException {
java.lang.Throwable th = null;
        android.content.pm.ApplicationInfo applicationInfo = null;
        java.lang.Object objU0 = null;
        android.ext.Tools$y tools$yX0;
        boolean zA;
        java.lang.Object objB = null;
        if (android.ext.a0.i(str)) {
            android.ext.e1.i("Failed getApplicationInfo, isBuggedPackage: " + str);
            return null;
        }
        android.content.pm.PackageManager packageManagerB0 = B0();
        if (packageManagerB0 != null) {
            try {
                boolean zA2 = android.ext.a0.a(str, "app_info");
                try {
                    applicationInfo = packageManagerB0.getApplicationInfo(str, i2);
                    try {
                        android.ext.a0.b(zA2);
                    } catch (java.lang.Throwable th_c) {
                        th = th_c;
                        if (!(th_c instanceof android.content.pm.PackageManager.NameNotFoundException)) {
                            throw th_c;
                        }
                        android.ext.e1.l("Failed getApplicationInfo", th_c);
                    }
                } catch (java.lang.Throwable th2) {
                    try {
                        android.ext.a0.b(zA2);
                        throw th2;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        applicationInfo = null;
                        if (!(th instanceof android.content.pm.PackageManager.NameNotFoundException)) {
                            throw th;
                        }
                        android.ext.e1.l("Failed getApplicationInfo", th);
                        if (applicationInfo == null) {
                            try {
                                java.lang.Class<?> cls = objU0.getClass();
                                java.lang.Class cls2 = java.lang.Integer.TYPE;
                                tools$yX0 = x0(cls, new android.ext.Tools$y[]{new android.ext.Tools$y(cls, "getApplicationInfo", new java.lang.Class[]{java.lang.String.class, cls2, cls2}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2), 0}), new android.ext.Tools$y(cls, "getApplicationInfo", new java.lang.Class[]{java.lang.String.class, cls2}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2)})});
                                if (tools$yX0 != null) {
                                    zA = android.ext.a0.a(str, "app_info2");
                                    try {
                                        objB = tools$yX0.b();
                                        android.ext.a0.b(zA);
                                        if (objB != null) {
                                            throw new android.content.pm.PackageManager.NameNotFoundException(str);
                                        }
                                    } catch (java.lang.Throwable th4) {
                                        android.ext.a0.b(zA);
                                        throw th4;
                                    }
                                }
                                if (objB instanceof android.content.pm.ApplicationInfo) {
                                    return (android.content.pm.ApplicationInfo) objB;
                                }
                            } catch (java.lang.Throwable th5) {
                                if (th5 instanceof android.content.pm.PackageManager.NameNotFoundException) {
                                    throw th5;
                                }
                                android.ext.e1.l("Failed getApplicationInfo", th5);
                            }
                        }
                        return applicationInfo;
                    }
                }
            } catch (java.lang.Throwable th6) {
                th = th6;
            }
        } else {
            applicationInfo = null;
        }
        if (applicationInfo == null && (objU0 = u0()) != null) {
            java.lang.Class<?> cls3 = objU0.getClass();
            java.lang.Class cls4 = java.lang.Integer.TYPE;
            tools$yX0 = x0(cls3, new android.ext.Tools$y[]{new android.ext.Tools$y(cls3, "getApplicationInfo", new java.lang.Class[]{java.lang.String.class, cls4, cls4}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2), 0}), new android.ext.Tools$y(cls3, "getApplicationInfo", new java.lang.Class[]{java.lang.String.class, cls4}, objU0, new java.lang.Object[]{str, java.lang.Integer.valueOf(i2)})});
            if (tools$yX0 != null) {
                zA = android.ext.a0.a(str, "app_info2");
                objB = tools$yX0.b();
                android.ext.a0.b(zA);
                if (objB != null) {
                    throw new android.content.pm.PackageManager.NameNotFoundException(str);
                }
            }
            if (objB instanceof android.content.pm.ApplicationInfo) {
                return (android.content.pm.ApplicationInfo) objB;
            }
        }
        return applicationInfo;
    }

    public static boolean Z0(java.lang.Process process) {
        try {
            process.exitValue();
            return true;
        } catch (java.lang.IllegalThreadStateException unused) {
            return false;
        }
    }

    private static void a(android.content.Context context) {
        if (k == null) {
            try {
                k = context.getPackageManager();
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        if (h == null) {
            try {
                h = context.getPackageName();
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
            }
        }
        if (h == null) {
            h = android.ext.i.f1002d;
        }
        if (i == null) {
            try {
                i = context.getFilesDir().getAbsolutePath();
            } catch (java.lang.Throwable th3) {
                android.ext.e1.a(th3);
            }
        }
        if (j == null) {
            try {
                j = context.getCacheDir().getAbsolutePath();
            } catch (java.lang.Throwable th4) {
                android.ext.e1.a(th4);
            }
        }
        if (i == null && h != null) {
            i = n0() + "/files";
        }
        if (j == null && h != null) {
            j = n0() + "/cache";
        }
        if (i != null) {
            try {
                java.io.File file = new java.io.File(i);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (java.lang.Throwable th5) {
                android.ext.e1.a(th5);
            }
        }
        if (j != null) {
            try {
                java.io.File file2 = new java.io.File(j);
                if (file2.exists()) {
                    return;
                }
                file2.mkdirs();
            } catch (java.lang.Throwable th6) {
                android.ext.e1.a(th6);
            }
        }
    }

    public static java.lang.String a0(android.content.pm.ApplicationInfo applicationInfo) {
java.lang.Throwable th = null;
        java.lang.CharSequence charSequenceLoadLabel;
        android.content.pm.PackageManager packageManager = k;
        if (applicationInfo == null || packageManager == null) {
            return null;
        }
        try {
            boolean zA = android.ext.a0.a(applicationInfo.packageName, "label");
            try {
                charSequenceLoadLabel = applicationInfo.loadLabel(packageManager);
                try {
                    android.ext.a0.b(zA);
                    if (charSequenceLoadLabel == null) {
                        boolean zA2 = android.ext.a0.a(applicationInfo.packageName, "label2");
                        try {
                            charSequenceLoadLabel = packageManager.getApplicationLabel(applicationInfo);
                            android.ext.a0.b(zA2);
                        } catch (java.lang.Throwable th_c) {
                            android.ext.a0.b(zA2);
                            throw th_c;
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    android.ext.e1.l("Failed load label for: " + applicationInfo.packageName, th);
                }
            } catch (java.lang.Throwable th3) {
                android.ext.a0.b(zA);
                throw th3;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            charSequenceLoadLabel = null;
        }
        if (charSequenceLoadLabel != null) {
            return charSequenceLoadLabel.toString();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.io.FileInputStream] */
    public static boolean a1(java.lang.Object obj) throws java.lang.Throwable {
java.lang.Throwable e = null;
java.lang.Throwable th = null;
        int r1;
        java.io.FileInputStream fileInputStream;
        java.lang.String str = null;
        java.io.File file = obj instanceof java.io.File ? (java.io.File) obj : new java.io.File(obj.toString());
        if (file.exists()) {
            r1 = !file.isFile() ? 2131296818 : 0;
        } else {
            r1 = 2131296450;
        }
        java.io.Closeable r3 = null;
        try {
            if (r1 != 0) {
                str = N1(r1) + ": " + obj;
            } else {
                try {
                    fileInputStream = new java.io.FileInputStream(file);
                    try {
                        fileInputStream.read();
                        try {
                            fileInputStream.close();
                            return true;
                        } catch (java.io.IOException unused) {
                            return true;
                        }
                    } catch (java.io.IOException e2) {
                        e = e2;
                        str = obj + "\n\n" + e.getMessage();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException unused2) {
                            }
                        }
                        android.ext.f.o(android.ext.f.b().setCustomTitle(g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(str).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
                        return false;
                    }
                } catch (java.io.IOException e3) {
                    e = e3;
                    fileInputStream = null;
                } catch (java.lang.Throwable th_c) {
                    th = th_c;
                    if (r3 != null) {
                        try {
                            r3.close();
                        } catch (java.io.IOException unused3) {
                        }
                    }
                    throw th_c;
                }
            }
            android.ext.f.o(android.ext.f.b().setCustomTitle(g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(str).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
            return false;
        } catch (java.lang.Throwable th2) {
            th = th2;
            r3 = null;
        }
        return false;
    }

    public static java.io.File b0() {
        java.lang.String strM0 = j;
        if (strM0 == null) {
            strM0 = m0("/cache");
        }
        if (strM0 != null) {
            return new java.io.File(strM0);
        }
        return null;
    }

    public static java.lang.Throwable b1(android.content.Context context) {
        try {
            context.getPackageName();
            context.getPackageManager();
            context.getCacheDir();
            context.getFilesDir();
            context.getExternalCacheDir();
            context.getExternalFilesDir(null);
            return null;
        } catch (java.lang.Throwable th) {
            return th;
        }
    }

    public static void c(android.widget.TextView textView, android.graphics.drawable.Drawable drawable, int i2) {
        if (textView == null) {
            return;
        }
        android.ext.n2.i(new android.ext.Tools$s(textView, drawable, i2));
    }

    public static java.io.File c0() {
        java.io.File fileB0 = b0();
        if (fileB0 == null) {
            return fileB0;
        }
        java.io.File file = new java.io.File(fileB0, s0());
        file.mkdirs();
        return file;
    }

    private static boolean c1(java.lang.String str) {
        try {
            java.io.File file = new java.io.File(str);
            java.lang.String[] list = file.list();
            if (list == null) {
                return false;
            }
            if (list.length == 0) {
                java.io.File file2 = new java.io.File(file, ".gg." + java.lang.System.nanoTime());
                file2.createNewFile();
                list = file.list();
                file2.delete();
            }
            return list.length > 0;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("isGoodDir: '" + str + "'", th);
            return false;
        }
    }

    static void d(android.widget.TextView textView, android.graphics.drawable.Drawable drawable, int i2) {
        android.graphics.drawable.Drawable[] compoundDrawables;
        if (f493e == -1) {
            f493e = (int) (G(12.0f) + 0.5f);
        }
        if (drawable != null) {
            int iG = (int) G(i2);
            try {
                drawable.setBounds(0, 0, iG, iG);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        try {
            java.lang.Object tag = textView.getTag(catch_.me_.if_.you_.can_.R.id.icon);
            int iIntValue = tag instanceof java.lang.Integer ? ((java.lang.Integer) tag).intValue() : 0;
            if (iIntValue == 0) {
                android.graphics.drawable.Drawable[] compoundDrawables2 = textView.getCompoundDrawables();
                compoundDrawables = textView.getCompoundDrawablesRelative();
                if (compoundDrawables[0] != null) {
                    iIntValue = 4;
                } else if (compoundDrawables2[0] != null) {
                    compoundDrawables = compoundDrawables2;
                    iIntValue = 2;
                } else {
                    iIntValue = 3;
                }
                textView.setTag(catch_.me_.if_.you_.can_.R.id.icon, java.lang.Integer.valueOf(iIntValue));
            } else {
                compoundDrawables = null;
            }
            boolean z = iIntValue == 1 || iIntValue == 2;
            if (compoundDrawables == null) {
                compoundDrawables = z ? textView.getCompoundDrawables() : textView.getCompoundDrawablesRelative();
            }
            char c2 = (iIntValue == 1 || iIntValue == 3) ? (char) 0 : (char) 2;
            if (compoundDrawables[c2] != drawable) {
                compoundDrawables[c2] = drawable;
                if (z) {
                    textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
                } else {
                    textView.setCompoundDrawablesRelative(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
                }
            }
        } catch (java.lang.StringIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
        }
        textView.setCompoundDrawablePadding(f493e);
    }

    public static int d0(int i2) {
        return e0(i2, -1);
    }

    public static int d1() {
        int i2 = w;
        if (i2 != -1) {
            return i2;
        }
        U1(null);
        return w;
    }

    public static void e(android.widget.ListView listView, java.lang.CharSequence[] charSequenceArr, android.graphics.drawable.Drawable[] drawableArr, int i2, int i3) {
        try {
            listView.setOnHierarchyChangeListener(new android.ext.Tools$u(i3, charSequenceArr, drawableArr, i2));
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public static int e0(int i2, int i3) {
        try {
            android.content.Context contextF0 = f0();
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                try {
                    return contextF0.getColor(i2);
                } catch (java.lang.Throwable th) {
                    android.ext.e1.a(th);
                }
            }
            return contextF0.getResources().getColor(i2);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
            return i3;
        }
    }

    public static boolean e1(java.lang.String str) {
        try {
            Z(str, 0);
            return true;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void f(android.view.View view, android.view.WindowManager.LayoutParams windowManager$LayoutParams) {
        android.ext.e1.d("dbg2: " + view + ' ' + windowManager$LayoutParams);
        F1(view, windowManager$LayoutParams, true);
    }

    public static android.content.Context f0() {
        android.content.Context context = android.ext.MainService.context;
        if (context != null || android.ext.r.p == null) {
            return context;
        }
        return l1(android.ext.r.p) == null ? android.ext.r.o : android.ext.r.p;
    }

    public static boolean f1(java.lang.String str) {
        if (str.length() >= 2 && str.charAt(0) == '/') {
            return true;
        }
        android.ext.f.o(android.ext.f.b().setCustomTitle(g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(str + "\n\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.path_must_be)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
        return false;
    }

    public static void g(android.view.View view, android.view.WindowManager.LayoutParams windowManager$LayoutParams) {
        android.ext.n2.i(new android.ext.Tools$j(windowManager$LayoutParams, view));
    }

    public static android.view.View g0(int i2) {
        return h0(android.ext.b2.f(i2));
    }

    public static java.lang.String g1(long j2) {
        long j3;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        long jAbs = java.lang.Math.abs(j2);
        int i2 = 0;
        while (true) {
            int[] iArr = o;
            if (i2 >= iArr.length) {
                break;
            }
            int i3 = iArr[i2 + 1];
            if (i3 <= 0) {
                j3 = 0;
            } else {
                long j4 = i3;
                long j5 = jAbs % j4;
                j3 = jAbs / j4;
                jAbs = j5;
            }
            if (jAbs > 0) {
                if (sb.length() > 0) {
                    sb.insert(0, " ");
                }
                sb.insert(0, android.ext.b2.f(o[i2]));
                sb.insert(0, " ");
                sb.insert(0, jAbs);
            }
            if (j3 == 0) {
                break;
            }
            i2 += 2;
            jAbs = j3;
        }
        if (sb.length() == 0) {
            sb.insert(0, android.ext.b2.f(o[0]));
            sb.insert(0, "0 ");
        }
        if (j2 < 0) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }

    public static void h(java.lang.String str, int i2) {
        i(str, i2, null, null);
    }

    public static android.view.View h0(java.lang.String str) {
        return i0(str, null);
    }

    static void h1() {
        f490b = 1;
    }

    public static void i(java.lang.String str, int i2, java.lang.String str2, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        android.ext.n2.i(new android.ext.Tools$m(str, i2, str2, dialogInterface$OnClickListener));
    }

    public static android.view.View i0(java.lang.String str, java.lang.String str2) {
        return j0(str, str2, -1);
    }

    public static boolean i1(java.lang.String str) {
        android.content.Intent intent;
        try {
            android.content.Context contextF0 = f0();
            try {
                intent = new android.content.Intent("android.settings.APPLICATION_DETAILS_SETTINGS", android.net.Uri.fromParts("package", str, null));
            } catch (android.content.ActivityNotFoundException e2) {
                android.ext.e1.s("Failed open app info for: " + str, e2);
                intent = new android.content.Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
            }
            intent.setFlags(268435456);
            contextF0.startActivity(intent);
            return true;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed open app info for: " + str, th);
            return false;
        }
    }

    public static boolean j(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (file.canExecute()) {
            return true;
        }
        java.lang.String[] strArr = {"chmod", "0755", F0(str)};
        try {
            if (!X1(I(strArr), 15)) {
                android.ext.e1.s("timeout fail 1: " + java.util.Arrays.toString(strArr), new java.lang.RuntimeException());
            }
        } catch (java.lang.Exception e2) {
            android.ext.e1.s("exec", e2);
        }
        if (!android.ext.Config.C) {
            if (file.canExecute()) {
                return true;
            }
            try {
                if (!X1(android.ext.e2.q("exec " + y(strArr, " ")), 15)) {
                    android.ext.e1.s("timeout fail 2: " + java.util.Arrays.toString(strArr), new java.lang.RuntimeException());
                }
            } catch (java.lang.Exception e3) {
                android.ext.e1.s("root", e3);
            }
        }
        return file.canExecute();
    }

    public static android.view.View j0(java.lang.String str, java.lang.String str2, int i2) {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.dialog_title, null);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.alertTitle);
        textView.setText(str);
        if (i2 != -1 && i2 != 0) {
            r1(textView);
            textView.setOnClickListener(new android.ext.Tools$l(str, i2));
        }
        if (str2 != null) {
            android.widget.TextView textView2 = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.subTitle);
            textView2.setText(str2);
            textView2.setVisibility(0);
        }
        return viewF;
    }

    public static double j1(java.lang.String str) {
        double d2;
        java.lang.String strTrim = str.trim();
        if (strTrim.startsWith("-")) {
            strTrim = strTrim.substring(1);
            d2 = -1.0d;
        } else {
            d2 = 1.0d;
        }
        java.lang.String[] strArrSplit = strTrim.split(":", o.length / 2);
        android.ext.t1$b t1_b = new android.ext.t1$b();
        double dLongBitsToDouble = 0.0d;
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            int length = (((strArrSplit.length - 1) - i2) * 2) + 1;
            if (length < o.length) {
                dLongBitsToDouble = (dLongBitsToDouble * ((double) o[length])) + java.lang.Double.longBitsToDouble(android.ext.t1.t(t1_b, strArrSplit[i2], strTrim).f1261a);
            }
        }
        return dLongBitsToDouble * d2;
    }

    public static boolean[] k(java.util.List list) {
        boolean[] zArr = new boolean[list.size()];
        java.util.Iterator it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            zArr[i2] = ((java.lang.Boolean) it.next()).booleanValue();
            i2++;
        }
        return zArr;
    }

    public static android.content.Context k0() {
        return l0(f0());
    }

    public static java.lang.String k1(java.lang.String str) {
        return java.util.regex.Pattern.quote(str).replace("^", "\\E^\\Q").replace("$", "\\E$\\Q").replace("?", "\\E.\\Q").replace("*", "\\E.*\\Q").replace("\\Q\\E", "");
    }

    public static final java.lang.String l(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b2 : bArr) {
            java.lang.String upperCase = java.lang.Integer.toHexString(b2 & 255).toUpperCase(java.util.Locale.US);
            while (upperCase.length() < 2) {
                upperCase = '0' + upperCase;
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static android.content.Context l0(android.content.Context context) {
        return context;
    }

    public static android.content.Context l1(android.content.Context context) {
        while (context instanceof android.content.ContextWrapper) {
            context = ((android.content.ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    public static boolean m(android.content.Context context) {
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return true;
        }
        try {
            return android.provider.Settings.canDrawOverlays(context);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return true;
        }
    }

    private static java.lang.String m0(java.lang.String str) {
        if (l == null) {
            try {
                android.content.pm.ApplicationInfo applicationInfoY = Y(android.ext.i.f1002d);
                if (applicationInfoY != null) {
                    l = applicationInfoY.dataDir;
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        if (l == null || str == null) {
            return l;
        }
        return l + str;
    }

    public static void m1(android.view.View view) {
        android.ext.n2.i(new android.ext.Tools$q(view));
    }

    public static void n(java.lang.Object obj, int i2) {
        if (obj == null) {
            return;
        }
        boolean z = i2 == 1;
        if (obj instanceof gg_d.a) {
            gg_d.a aVar = (gg_d.a) obj;
            int i3 = aVar.i();
            for (int i4 = 0; i4 < i3; i4++) {
                aVar.b(i4, i2 == 2 ? !aVar.c(i4) : z);
            }
            return;
        }
        if (obj instanceof gg_d.e) {
            gg_d.e eVar = (gg_d.e) obj;
            int iL = eVar.l();
            for (int i5 = 0; i5 < iL; i5++) {
                eVar.k(i5, i2 == 2 ? !eVar.a(i5) : z);
            }
            return;
        }
        if (!(obj instanceof boolean[])) {
            throw new java.lang.IllegalArgumentException();
        }
        boolean[] zArr = (boolean[]) obj;
        int length = zArr.length - 1;
        for (int i6 = 1; i6 < length; i6++) {
            zArr[i6] = i2 == 2 ? !zArr[i6] : z;
        }
    }

    public static java.lang.String n0() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("/data/");
        int iMyUid = android.os.Process.myUid() / 100000;
        if (iMyUid == 0) {
            sb.append("data");
        } else {
            sb.append("user/");
            sb.append(iMyUid);
        }
        sb.append('/');
        java.lang.String str = h;
        if (str == null) {
            str = android.ext.i.f1002d;
        }
        sb.append(str);
        return sb.toString();
    }

    public static void n1(android.view.View view) {
        android.ext.n2.i(new android.ext.Tools$o(view));
    }

    public static void o() {
        new android.ext.g0(new android.ext.Tools$i(), "checkForBadContext").start();
    }

    public static android.graphics.drawable.Drawable o0(int i2) {
        try {
            return f0().getDrawable(i2);
        } catch (java.lang.NoSuchMethodError unused) {
            return f0().getResources().getDrawable(i2);
        }
    }

    public static void o1(android.widget.EditText editText) {
        if (editText == null) {
            return;
        }
        android.ext.n2.i(new android.ext.Tools$g(editText));
    }

    static void p() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            try {
                if (m(f0())) {
                    return;
                }
                android.ext.e1.p("canDrawOverlays = false");
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
    }

    public static java.io.File p0() {
        java.lang.String strM0 = i;
        if (strM0 == null) {
            strM0 = m0("/files");
        }
        if (strM0 != null) {
            return new java.io.File(strM0);
        }
        return null;
    }

    public static void p1(android.view.View view) {
        q1(view, view.getBackground());
    }

    public static void q(java.io.File file, int i2) {
        file.setExecutable((i2 & 64) != 0, (i2 & 9) == 0);
        file.setWritable((i2 & 128) != 0, (i2 & 18) == 0);
        file.setReadable((i2 & 256) != 0, (i2 & 36) == 0);
        try {
            android.system.Os.chmod(file.getAbsolutePath(), i2);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed chmod " + java.lang.Integer.toOctalString(i2) + " '" + file + "'", th);
        }
    }

    public static java.io.File q0() {
        java.io.File fileP0 = p0();
        if (fileP0 == null) {
            return fileP0;
        }
        java.io.File file = new java.io.File(fileP0, s0());
        file.mkdirs();
        return file;
    }

    public static void q1(android.view.View view, android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            try {
                drawable = new android.graphics.drawable.ColorDrawable(0);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
                return;
            }
        }
        view.setFocusable(true);
        android.graphics.drawable.StateListDrawable stateListDrawable = new android.graphics.drawable.StateListDrawable();
        android.graphics.drawable.Drawable background = new android.widget.ImageButton(view.getContext()).getBackground();
        stateListDrawable.addState(gg_a.g.f19a, background);
        stateListDrawable.addState(gg_a.g.f20b, background);
        stateListDrawable.addState(gg_a.g.f21c, background);
        stateListDrawable.addState(android.util.StateSet.WILD_CARD, drawable);
        view.setBackground(drawable);
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackground(stateListDrawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void r(java.lang.String str, java.lang.String str2) {
        try {
            android.system.Os.chmod(str, java.lang.Integer.parseInt(str2, 8));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed chmod " + str2 + " '" + str + "'", th);
        }
        java.lang.String[] strArr = {"chmod", str2, F0(str)};
        try {
            if (!X1(I(strArr), 15)) {
                android.ext.e1.s("timeout fail 1: " + java.util.Arrays.toString(strArr), new java.lang.RuntimeException());
            }
        } catch (java.lang.Exception e2) {
            android.ext.e1.s("exec", e2);
        }
        try {
            if (android.ext.Config.C) {
                return;
            }
            if (X1(android.ext.e2.q("exec " + y(strArr, " ")), 15)) {
                return;
            }
            android.ext.e1.s("timeout fail 2: " + java.util.Arrays.toString(strArr), new java.lang.RuntimeException());
        } catch (java.lang.Exception e3) {
            android.ext.e1.s("root", e3);
        }
    }

    public static long r0() {
        try {
            android.app.ActivityManager.MemoryInfo activityManager$MemoryInfo = new android.app.ActivityManager.MemoryInfo();
            android.app.ActivityManager activityManager = (android.app.ActivityManager) f0().getSystemService("activity");
            if (activityManager == null) {
                return -1L;
            }
            activityManager.getMemoryInfo(activityManager$MemoryInfo);
            return activityManager$MemoryInfo.availMem / 1048576;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed get free mem", th);
            return -1L;
        }
    }

    public static void r1(android.view.View view) {
        q1(view, o0(catch_.me_.if_.you_.can_.R.drawable.ic_information_white_12dp));
    }

    public static java.lang.String removeNewLinesChars(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            boolean z = false;
            for (int i3 = 0; i3 < 2; i3++) {
                z = z || cCharAt == '\n';
                if (i3 != 1) {
                    cCharAt = (char) (cCharAt - 3);
                }
            }
            if (z) {
                sb.append("");
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static boolean s(android.view.View view) {
        if (view == null) {
            return false;
        }
        return view.callOnClick();
    }

    public static java.lang.String s0() {
        java.lang.String strT0;
        android.content.SharedPreferences.Editor sharedPreferences$EditorRemove;
        if (m == null) {
            try {
                android.content.SharedPreferences sharedPreferencesM0 = M0();
                if (!sharedPreferencesM0.contains("hidden-dir")) {
                    java.lang.String strT1 = t0();
                    if (strT1 == null) {
                        strT1 = H0();
                    }
                    sharedPreferencesM0.edit().putString("hidden-dir", strT1).commit();
                }
                strT0 = null;
                try {
                    strT0 = sharedPreferencesM0.getString("hidden-dir", null);
                } catch (java.lang.ClassCastException unused) {
                }
                if (strT0 == null) {
                    int i2 = sharedPreferencesM0.getInt("hidden-dir", 0);
                    if (i2 != 0) {
                        strT0 = java.lang.Integer.toString(i2);
                        sharedPreferences$EditorRemove = sharedPreferencesM0.edit().putString("hidden-dir", strT0);
                    } else {
                        sharedPreferences$EditorRemove = sharedPreferencesM0.edit().remove("hidden-dir");
                    }
                    sharedPreferences$EditorRemove.commit();
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed get num", th);
                strT0 = t0();
            }
            if (strT0 == null) {
                strT0 = H0();
            }
            m = "GG-" + strT0;
        }
        return m;
    }

    public static boolean s1(android.content.DialogInterface dialogInterface, int i2, java.lang.Object obj, android.view.View.OnClickListener view$OnClickListener) {
        android.widget.Button button;
        if (!(dialogInterface instanceof android.app.AlertDialog) || (button = ((android.app.AlertDialog) dialogInterface).getButton(i2)) == null) {
            return false;
        }
        button.setTag(obj);
        button.setOnClickListener(view$OnClickListener);
        return true;
    }

    public static java.lang.CharSequence t(java.lang.CharSequence charSequence, int i2) {
        try {
            android.text.Spannable spannableString = charSequence instanceof android.text.Spannable ? (android.text.Spannable) charSequence : new android.text.SpannableString(charSequence);
            spannableString.setSpan(new android.text.style.ForegroundColorSpan(i2), 0, charSequence.length(), 33);
            return spannableString;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed colorize", th);
            return charSequence;
        }
    }

    private static java.lang.String t0() {
        java.lang.String[] list;
        try {
            java.io.File fileP0 = p0();
            if (fileP0 == null || (list = fileP0.list()) == null) {
                return null;
            }
            for (java.lang.String str : list) {
                if (str != null && str.startsWith("GG-")) {
                    return str.substring(3);
                }
            }
            return null;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed get dir", th);
            return null;
        }
    }

    public static boolean t1(android.content.DialogInterface dialogInterface, int i2, java.lang.Object obj, android.view.View.OnClickListener view$OnClickListener, android.ext.EditText editText) {
        if (editText != null) {
            editText.requestFocus();
            o1(editText);
        }
        return s1(dialogInterface, i2, obj, view$OnClickListener);
    }

    public static java.lang.CharSequence u(java.lang.CharSequence charSequence) {
        if (charSequence instanceof android.text.Spannable) {
            android.ext.Tools$v[] tools$vArr = (android.ext.Tools$v[]) q.get();
            if (tools$vArr == null) {
                tools$vArr = new android.ext.Tools$v[]{new android.ext.Tools$v(android.ext.c.v(1), android.ext.c.n(1)), new android.ext.Tools$v(android.ext.c.v(2), android.ext.c.n(2)), new android.ext.Tools$v(android.ext.c.v(4), android.ext.c.n(4)), new android.ext.Tools$v(android.ext.c.v(8), android.ext.c.n(8)), new android.ext.Tools$v(android.ext.c.v(16), android.ext.c.n(16)), new android.ext.Tools$v(android.ext.c.v(32), android.ext.c.n(32)), new android.ext.Tools$v(android.ext.c.v(64), android.ext.c.n(64)), new android.ext.Tools$v(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.executable), d0(catch_.me_.if_.you_.can_.R.color.pointer_executable)), new android.ext.Tools$v(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.writable), d0(catch_.me_.if_.you_.can_.R.color.pointer_writable)), new android.ext.Tools$v(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.read_only), d0(catch_.me_.if_.you_.can_.R.color.pointer_readable)), new android.ext.Tools$v(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.writable_and_executable), d0(catch_.me_.if_.you_.can_.R.color.pointer_executable_writable))};
                q = new java.lang.ref.WeakReference(tools$vArr);
            }
            for (android.ext.Tools$v tools$v : tools$vArr) {
                v(charSequence, tools$v.f546a, tools$v.f547b);
            }
        }
        return charSequence;
    }

    public static java.lang.Object u0() {
        if (p == null) {
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("android.os.ServiceManager").getDeclaredMethod("getIServiceManager", new java.lang.Class[0]);
                declaredMethod.setAccessible(true);
                java.lang.Object objInvoke = declaredMethod.invoke(null, gg_d.b.f1516f);
                java.lang.reflect.Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("getService", java.lang.String.class);
                declaredMethod2.setAccessible(true);
                java.lang.Object objInvoke2 = declaredMethod2.invoke(objInvoke, "package");
                java.lang.reflect.Method declaredMethod3 = java.lang.Class.forName("android.content.pm.IPackageManager$Stub").getDeclaredMethod("asInterface", android.os.IBinder.class);
                declaredMethod3.setAccessible(true);
                p = declaredMethod3.invoke(null, objInvoke2);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        return p;
    }

    public static android.app.AlertDialog u1(android.app.AlertDialog alertDialog) {
        try {
            android.widget.TextView textView = (android.widget.TextView) alertDialog.findViewById(android.R.id.message);
            if (textView != null) {
                v1(textView, textView.getText().toString());
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        return alertDialog;
    }

    public static java.lang.CharSequence v(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2, int i2) {
        try {
            if (charSequence instanceof android.text.Spannable) {
                android.text.Spannable spannable = (android.text.Spannable) charSequence;
                int length = charSequence2.length();
                java.lang.String string = charSequence.toString();
                java.lang.String string2 = charSequence2.toString();
                int i3 = 0;
                while (true) {
                    int iIndexOf = string.indexOf(string2, i3);
                    if (iIndexOf < 0) {
                        break;
                    }
                    int i4 = iIndexOf + length;
                    spannable.setSpan(new android.text.style.ForegroundColorSpan(i2), iIndexOf, i4, 33);
                    i3 = i4;
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed colorize text", th);
        }
        return charSequence;
    }

    public static java.lang.String v0(android.content.Context context) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String str = "Context: ";
        while (true) {
            sb.append(str);
            sb.append(context);
            if (context == null || !(context instanceof android.content.ContextWrapper)) {
                break;
            }
            context = ((android.content.ContextWrapper) context).getBaseContext();
            str = ", base: ";
        }
        return sb.toString();
    }

    public static void v1(android.widget.TextView textView, java.lang.String str) {
        android.ext.n2.i(new android.ext.Tools$c(textView, str));
    }

    private static int[] w(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        int i2 = 0;
        for (int i3 = 1; i3 < bArr.length; i3++) {
            while (i2 > 0 && bArr[i2] != bArr[i3]) {
                i2 = iArr[i2 - 1];
            }
            if (bArr[i2] == bArr[i3]) {
                i2++;
            }
            iArr[i3] = i2;
        }
        return iArr;
    }

    public static android.widget.ListView w0(android.view.View view) {
        while (view != null) {
            if (view instanceof android.widget.ListView) {
                return (android.widget.ListView) view;
            }
            java.lang.Object parent = view.getParent();
            if (!(parent instanceof android.view.View)) {
                break;
            }
            view = (android.view.View) parent;
        }
        return null;
    }

    public static void w1(int i2, android.content.ComponentName componentName, int i3) {
        try {
            android.content.pm.PackageManager packageManagerB0 = B0();
            android.ext.e1.d("hide " + i2 + ": " + i3 + ' ' + componentName);
            B(componentName.getPackageName(), null);
            packageManagerB0.setComponentEnabledSetting(componentName, i3, 1);
            android.ext.e1.d("hide " + (i2 + 1) + ": " + i3 + ' ' + componentName);
            B(componentName.getPackageName(), null);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public static java.lang.CharSequence x(java.lang.CharSequence... charSequenceArr) {
        try {
            return android.text.TextUtils.concat(charSequenceArr);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.CharSequence charSequence : charSequenceArr) {
                sb.append(charSequence);
            }
            return sb.toString();
        }
    }

    private static android.ext.Tools$y x0(java.lang.Class cls, android.ext.Tools$y[] tools$yArr) {
        android.ext.Tools$y tools$yA;try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.lang.NoSuchMethodException();
                    }

            tools$yA = tools$yArr[0].a();
        } catch (java.lang.NoSuchMethodException unused) {
            android.ext.Tools$y tools$yA2 = null;
            for (int i2 = 0; i2 < tools$yArr.length; i2++) {
                if (i2 != 0) {
                    try {                        if (android.ext.GgNoop.never) {
                        throw new java.lang.NoSuchMethodException();
                    }

                        tools$yA2 = tools$yArr[i2].a();
                    } catch (java.lang.NoSuchMethodException unused2) {
                    }
                }
            }
            tools$yA = tools$yA2;
        };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        if (tools$yA == null) {
            android.ext.e1.d("Methods: " + java.util.Arrays.toString(cls.getMethods()));
        }
        return tools$yA;
    }

    public static void x1(android.view.View view, float f2) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) f2;
            view.setLayoutParams(layoutParams);
        }
    }

    public static java.lang.String y(java.lang.String[] strArr, java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.String str2 : strArr) {
            if (sb.length() != 0) {
                sb.append(str);
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    public static java.lang.String y0(java.lang.String str) {
        if (u == 0 || u == 1) {
            try {
                java.io.File file = new java.io.File(str);
                java.lang.String str2 = '/' + file.getName();
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                java.nio.MappedByteBuffer map = fileInputStream.getChannel().map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, 4096L);
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/self/maps"));
                while (true) {
                    java.lang.String line = bufferedReader.readLine();
                    if (line != null) {
                        int iIndexOf = line.indexOf(str2);
                        if (iIndexOf >= 0) {
                            int i2 = iIndexOf;
                            while (i2 > 0 && line.charAt(i2) > ' ') {
                                i2--;
                            }
                            if (i2 >= iIndexOf) {
                                break;
                            }
                            str = line.substring(i2, line.length()).trim();
                            if (u != 0) {
                                break;
                            }
                            u = (byte) 1;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                bufferedReader.close();
                if (u == 0) {
                    u = (byte) 2;
                }
                map.capacity();
                fileInputStream.close();
            } catch (java.io.IOException e2) {
                android.ext.e1.s("Failed getNativePath: " + str, e2);
            }
        }
        return str;
    }

    public static void y1(android.widget.ImageView imageView, float f2) {
        android.ext.n2.i(new android.ext.Tools$r(imageView, f2));
    }

    public static void z(java.lang.String str) {
        A(str, true);
    }

    public static android.content.pm.PackageInfo z0(java.lang.String str) {try {

        return A0(str, 0);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    public static void z1(android.view.View view, android.view.View.OnFocusChangeListener view$OnFocusChangeListener) {
        android.ext.Tools$w tools$w = (android.ext.Tools$w) view.getTag(catch_.me_.if_.you_.can_.R.layout.memory_range);
        if (tools$w == null) {
            tools$w = new android.ext.Tools$w(null);
            view.setOnFocusChangeListener(tools$w);
            view.setTag(catch_.me_.if_.you_.can_.R.layout.memory_range, tools$w);
        }
        tools$w.a(view$OnFocusChangeListener);
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class p2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile android.widget.Toast f1176a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile java.lang.ref.WeakReference f1178c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile java.lang.ref.WeakReference f1180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static android.content.Context f1181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static android.content.Context f1182g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final java.lang.Object f1177b = new java.lang.Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final java.lang.Object f1179d = new java.lang.Object();

    static {
        new android.ext.g0(new android.ext.p2$a(), "toastThread").start();
        f1181f = null;
        f1182g = null;
    }

    static void f(android.widget.Toast toast) {
        if (toast != null) {
            android.ext.n2.i(new android.ext.p2$c(toast));
        }
    }

    static android.widget.Toast g(android.widget.Toast toast) {
        java.lang.Object objA;
        try {
            java.lang.reflect.Field declaredField = android.widget.Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(toast);
            for (java.lang.reflect.Field field : obj.getClass().getDeclaredFields()) {
                java.lang.String name = field.getName();
                if (name.equals("mShow") || name.equals("mHide")) {
                    field.setAccessible(true);
                    java.lang.Object obj2 = field.get(obj);
                    if (obj2 instanceof java.lang.Runnable) {
                        objA = android.ext.Tools$z.a((java.lang.Runnable) obj2);
                        field.set(obj, objA);
                    }
                } else if (name.equals("mHandler")) {
                    field.setAccessible(true);
                    java.lang.Object obj3 = field.get(obj);
                    if (obj3 instanceof android.os.Handler) {
                        objA = android.ext.Tools$x.a((android.os.Handler) obj3);
                        field.set(obj, objA);
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        return toast;
    }

    public static android.content.Context h() {
        android.content.Context contextF0 = android.ext.Tools.f0();
        if (!android.ext.Config.vSpaceReal || android.ext.Config.D) {
            return contextF0;
        }
        android.content.Context context = f1181f;
        if (context == null || context != contextF0) {
            f1182g = android.ext.Config.a(contextF0);
            f1181f = contextF0;
        }
        return f1182g;
    }

    public static void i() {
    }

    public static void j(android.widget.Toast toast) {
        android.widget.Toast toast2;
        java.lang.Runnable runnable;
        android.widget.Toast toast3;
        java.lang.Object obj = f1179d;
        synchronized (obj) {
            try {
                java.lang.ref.WeakReference weakReference = f1178c;
                toast2 = weakReference == null ? null : (android.widget.Toast) weakReference.get();
                f1178c = null;
                java.lang.ref.WeakReference weakReference2 = f1180e;
                runnable = weakReference2 == null ? null : (java.lang.Runnable) weakReference2.get();
                f1180e = null;
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
        g(toast).show();
        android.ext.p2$b p2_b = new android.ext.p2$b(toast);
        synchronized (obj) {
            try {
                f1178c = new java.lang.ref.WeakReference(toast);
                f1180e = new java.lang.ref.WeakReference(p2_b);
            } catch (java.lang.Throwable th2_c_c_c) {
                throw th2_c_c_c;
            }
        }
        synchronized (f1177b) {
            try {
                toast3 = f1176a;
                f1176a = null;
            } catch (java.lang.Throwable th3_c_c_c) {
                throw th3_c_c_c;
            }
        }
        f(toast3);
        f(toast2);
        android.os.Handler handlerD = android.ext.n2.d();
        if (runnable != null) {
            handlerD.removeCallbacks(runnable);
        }
        handlerD.postDelayed(p2_b, 3000L);
    }
}

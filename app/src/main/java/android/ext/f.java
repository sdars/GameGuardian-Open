package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final java.lang.Runnable f759a = new android.ext.f$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f760b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final java.util.List f761c = new java.util.ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final java.util.List f762d = new java.util.ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static java.util.ArrayList f763e = new java.util.ArrayList();

    public static android.app.AlertDialog.Builder b() {
        return c(android.ext.Tools.f0());
    }

    public static android.app.AlertDialog.Builder c(android.content.Context context) {
        return new android.app.AlertDialog.Builder(context);
    }

    public static void d() {
        java.util.Iterator it = f763e.iterator();
        while (it.hasNext()) {
            android.app.AlertDialog alertDialog = (android.app.AlertDialog) ((java.lang.ref.WeakReference) it.next()).get();
            if (alertDialog != null) {
                try {
                    if (alertDialog.isShowing()) {
                        android.ext.Tools.D(alertDialog);
                    }
                } catch (java.lang.Throwable th) {
                    android.ext.e1.s("Failed dismiss dialog: " + alertDialog, th);
                }
            }
        }
        if (android.ext.MainService.instance != null) {
            android.ext.MainService.instance.t();
        }
    }

    private static void e(android.app.AlertDialog alertDialog) {
        android.view.Window window = alertDialog.getWindow();
        window.setCallback(new android.ext.g3(window.getCallback()));
        if (h()) {
            window.clearFlags(16777216);
            return;
        }
        window.setType(android.ext.m2.b());
        android.ext.Tools.R(window);
        if ((android.ext.Config.B & 2) != 0) {
            window.addFlags(16777216);
        } else {
            window.clearFlags(16777216);
        }
    }

    private static void f(android.app.AlertDialog alertDialog) {
        android.widget.ListView listView;
        try {
            listView = alertDialog.getListView();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            listView = null;
        }
        if (listView == null) {
            return;
        }
        try {
            android.widget.AdapterView.OnItemClickListener onItemClickListener = listView.getOnItemClickListener();
            if (onItemClickListener == null || (onItemClickListener instanceof android.ext.f$p)) {
                return;
            }
            listView.setOnItemClickListener(new android.ext.f$p(alertDialog, onItemClickListener, null));
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
    }

    static void g() {
        if (android.ext.MainService.instance == null) {
            return;
        }
        f760b--;
        if (f760b <= 0) {
            android.ext.n2.d().removeCallbacks(f759a);
            android.ext.MainService.instance.h0.c();
            f760b = 0;
        }
    }

    private static boolean h() {
        return android.ext.MainService.instance == null;
    }

    public static void i(android.app.AlertDialog alertDialog) {
        if (alertDialog.getWindow().getAttributes().type < 2000) {
            return;
        }
        java.util.ArrayList<java.lang.ref.WeakReference> arrayList = f763e;
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (java.lang.ref.WeakReference weakReference : arrayList) {
            android.app.AlertDialog alertDialog2 = (android.app.AlertDialog) weakReference.get();
            if (alertDialog2 != null && alertDialog2 != alertDialog) {
                arrayList2.add(weakReference);
            }
        }
        arrayList2.add(new java.lang.ref.WeakReference(alertDialog));
        f763e = arrayList2;
        arrayList.clear();
        arrayList.trimToSize();
    }

    static void j(android.app.AlertDialog alertDialog, android.ext.f$n f_n, java.lang.Runnable runnable) {
        android.widget.ListView listView = alertDialog.getListView();
        if (listView == null) {
            return;
        }
        android.widget.AdapterView.OnItemClickListener onItemClickListener = listView.getOnItemClickListener();
        if (onItemClickListener instanceof android.ext.f$o) {
            return;
        }
        listView.setOnItemClickListener(new android.ext.f$o(onItemClickListener, f_n, runnable, null));
    }

    public static void k(android.app.AlertDialog alertDialog, android.content.DialogInterface.OnDismissListener dialogInterface$OnDismissListener) {
        java.util.List list;
        android.app.AlertDialog alertDialog2;
        int i = 0;
        android.ext.f$j f_j = null;
        while (true) {
            list = f762d;
            if (i >= list.size()) {
                break;
            }
            android.ext.f$j f_j2 = (android.ext.f$j) list.get(i);
            if (f_j2 == null || (alertDialog2 = (android.app.AlertDialog) f_j2.f779a.get()) == null) {
                list.remove(i);
                i--;
            } else if (alertDialog2 == alertDialog) {
                f_j = f_j2;
            }
            i++;
        }
        if (f_j == null) {
            android.ext.f$k f_k = new android.ext.f$k(null);
            alertDialog.setOnDismissListener(f_k);
            f_j = new android.ext.f$j(alertDialog, f_k);
            list.add(f_j);
        }
        ((android.ext.f$k) f_j.f780b.get()).a(dialogInterface$OnDismissListener);
    }

    public static void l(android.app.AlertDialog alertDialog, android.content.DialogInterface.OnShowListener dialogInterface$OnShowListener) {
        java.util.List list;
        android.app.AlertDialog alertDialog2;
        int i = 0;
        android.ext.f$l f_l = null;
        while (true) {
            list = f761c;
            if (i >= list.size()) {
                break;
            }
            android.ext.f$l f_l2 = (android.ext.f$l) list.get(i);
            if (f_l2 == null || (alertDialog2 = (android.app.AlertDialog) f_l2.f782a.get()) == null) {
                list.remove(i);
                i--;
            } else if (alertDialog2 == alertDialog) {
                f_l = f_l2;
            }
            i++;
        }
        if (f_l == null) {
            android.ext.f$m f_m = new android.ext.f$m(null);
            alertDialog.setOnShowListener(f_m);
            f_l = new android.ext.f$l(alertDialog, f_m);
            list.add(f_l);
        }
        ((android.ext.f$m) f_l.f783b.get()).a(dialogInterface$OnShowListener);
    }

    public static android.app.AlertDialog m(android.app.AlertDialog alertDialog) {
        n(alertDialog, null);
        return alertDialog;
    }

    public static android.app.AlertDialog n(android.app.AlertDialog alertDialog, android.widget.EditText editText) {
        if (editText != null) {
            editText.setOnEditorActionListener(new android.ext.EditorActionListener(alertDialog));
        }
        e(alertDialog);
        android.ext.n2.i(new android.ext.f$g(alertDialog));
        return alertDialog;
    }

    public static void o(android.app.AlertDialog.Builder alertDialog$Builder) {
        q(alertDialog$Builder, null);
    }

    public static void p(android.app.AlertDialog.Builder alertDialog$Builder, android.content.Context context) {
        q(alertDialog$Builder, null);
    }

    public static void q(android.app.AlertDialog.Builder alertDialog$Builder, android.ext.EditText editText) {
        android.ext.n2.i(new android.ext.f$i(alertDialog$Builder, editText));
    }

    public static void r(android.app.AlertDialog alertDialog, java.lang.Runnable runnable, boolean z) {
        l(alertDialog, new android.ext.f$b(runnable));
        if (z) {
            k(alertDialog, new android.ext.f$c(runnable));
        }
        android.ext.n2.d().postDelayed(runnable, 3000L);
        android.ext.e1.d(runnable + ": 10_");
        m(alertDialog);
        android.ext.e1.d(runnable + ": 20_");
    }

    public static void s(android.app.AlertDialog.Builder alertDialog$Builder) {
        android.ext.f0.m0(new android.ext.f$h(alertDialog$Builder));
    }

    static void t(android.app.AlertDialog alertDialog) {
        l(alertDialog, null);
        alertDialog.show();
        if (h()) {
            return;
        }
        f(alertDialog);
        android.view.Window window = alertDialog.getWindow();
        android.view.View decorView = window.getDecorView();
        android.ext.InternalKeyboard internalKeyboard = (android.ext.InternalKeyboard) decorView.findViewById(catch_.me_.if_.you_.can_.R.id.keyboard);
        if (internalKeyboard != null) {
            internalKeyboard.g(window);
        }
        window.setSoftInputMode(((android.ext.Tools.Q0(decorView) && (internalKeyboard == null || (android.ext.Config.B & 1) == 0)) ? 5 : 2) | 16);
        android.ext.Tools.S(decorView);
        android.ext.ShowApp.i(window);
        android.os.Handler handlerD = android.ext.n2.d();
        java.lang.Runnable runnable = f759a;
        handlerD.removeCallbacks(runnable);
        handlerD.postDelayed(runnable, 100L);
        if (f760b <= 0) {
            f760b = 1;
        } else {
            f760b++;
        }
        k(alertDialog, null);
        i(alertDialog);
    }

    public static void u(android.app.AlertDialog alertDialog, java.lang.Runnable runnable, java.lang.Runnable runnable2) {
        android.ext.f$n f_n = new android.ext.f$n(null);
        android.os.Handler handlerD = android.ext.n2.d();
        android.ext.f$d f_d = new android.ext.f$d(alertDialog, f_n, runnable2);
        l(alertDialog, new android.ext.f$e(f_n, handlerD, f_d, alertDialog, runnable));
        k(alertDialog, new android.ext.f$f(f_n));
        handlerD.postDelayed(f_d, 3000L);
        m(alertDialog);
    }

    static void v() {
        if (android.ext.MainService.instance == null) {
            return;
        }
        android.ext.MainService.instance.h0.p();
        if (android.ext.MainService.instance.f0 == android.ext.MainService.instance.c0) {
            return;
        }
        android.ext.MainService.instance.h0.m();
    }

    public static void w(android.app.AlertDialog alertDialog) {
        try {
            alertDialog.show();
        } catch (android.view.WindowManager.BadTokenException unused) {
            m(alertDialog);
        }
    }
}

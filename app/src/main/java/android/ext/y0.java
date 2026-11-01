package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final java.util.LinkedList f1331a = new java.util.LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static int f1332b = 0;

    public static void a(java.lang.String str, byte b2, int i) {
        if (str == null || str.length() == 0 || "0".equals(str) || "-1".equals(str) || "1".equals(str)) {
            return;
        }
        android.ext.y0$c y0_c = new android.ext.y0$c(str, i, "...");
        java.util.ListIterator listIterator = f1331a.listIterator();
        int i2 = 0;
        while (listIterator.hasNext()) {
            android.ext.y0$c y0_c2 = (android.ext.y0$c) listIterator.next();
            if (y0_c2.equals(y0_c)) {
                y0_c.f1359d = y0_c2.f1359d;
                listIterator.remove();
                int i3 = f1332b;
                if (i2 >= i3) {
                    break;
                }
                f1332b = i3 - 1;
                if (b2 != 0) {
                    break;
                }
                b2 = 1;
                break;
            }
            i2++;
        }
        if (b2 != 0 && b2 == 1) {
            f1331a.addFirst(y0_c);
            f1332b++;
        } else {
            d();
            f1331a.add(f1332b, y0_c);
        }
        j();
        h();
    }

    public static void b(java.lang.String str, int i) {
        a(str, (byte) 0, i);
    }

    public static void c() {
        f1331a.clear();
        d();
    }

    static void d() {
        int i = f1332b;
        if (i < 0) {
            f1332b = 0;
            return;
        }
        int size = f1331a.size();
        if (i > size) {
            f1332b = size;
        }
    }

    public static void e() {
        f();
    }

    private static void f() {
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        if (sharedPreferencesM0 == null) {
            return;
        }
        java.util.LinkedList linkedList = f1331a;
        int i = sharedPreferencesM0.getInt("history-size", 0);
        int i2 = i > android.ext.Config.x ? android.ext.Config.x : i;
        int iG = g(i2);
        boolean[] zArr = new boolean[iG];
        int i3 = iG - 1;
        for (int i4 = 0; i4 < i; i4++) {
            java.lang.String string = sharedPreferencesM0.getString("history-" + i4, null);
            if (string != null && string.length() != 0) {
                int i5 = sharedPreferencesM0.getInt("h-" + i4, 1);
                if (i5 == 0) {
                    i5 = 1;
                }
                android.ext.y0$c y0_c = new android.ext.y0$c(string, i5, sharedPreferencesM0.getString("hi-" + i4, "..."));
                int iHashCode = y0_c.hashCode() & i3;
                if (!zArr[iHashCode]) {
                    zArr[iHashCode] = true;
                } else if (linkedList.indexOf(y0_c) != -1) {
                    continue;
                }
                linkedList.addLast(y0_c);
                if (linkedList.size() >= i2) {
                    break;
                }
            }
        }
        f1332b = sharedPreferencesM0.getInt("history-sticked", 0);
        d();
        j();
    }

    private static int g(int i) {
        int i2 = i | (i >> 1);
        int i3 = i2 | (i2 >> 2);
        int i4 = i3 | (i3 >> 4);
        int i5 = i4 | (i4 >> 8);
        return (i5 | (i5 >> 16)) + 1;
    }

    static void h() {
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        if (sharedPreferencesM0 == null) {
            return;
        }
        android.ext.g2 g2Var = new android.ext.g2(sharedPreferencesM0.edit());
        int i = 0;
        for (android.ext.y0$c y0_c : (java.util.Collection<android.ext.y0$c>) f1331a) {
            g2Var.putString("history-" + i, y0_c.f1356a);
            g2Var.g("h-" + i, y0_c.f1357b, 1);
            g2Var.k("hi-" + i, y0_c.f1359d, "...");
            i++;
        }
        g2Var.g("history-size", i, 0);
        g2Var.g("history-sticked", f1332b, 0);
        g2Var.commit();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(android.widget.EditText editText) {
        android.ext.y0$b y0_b = new android.ext.y0$b(android.ext.Tools.k0(), editText instanceof android.ext.k0 ? ((android.ext.k0) editText).getDataType() : -1);
        if (y0_b.getCount() == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.history_empty);
            return;
        }
        android.ext.y0$b.f1335e = false;
        android.view.View viewI0 = android.ext.Tools.i0(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.history), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.click_edit));
        viewI0.setOnClickListener(y0_b);
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.Tools.k0()).setCustomTitle(viewI0).setAdapter(y0_b, new android.ext.y0$a(y0_b, editText)).create();
        y0_b.f1336a = alertDialogCreate;
        android.ext.f.m(alertDialogCreate);
    }

    private static void j() {
        java.util.LinkedList linkedList = f1331a;
        int i = android.ext.Config.x;
        if (linkedList.size() <= i) {
            return;
        }
        for (int size = linkedList.size() - i; size > 0; size--) {
            linkedList.removeLast();
        }
        d();
    }
}

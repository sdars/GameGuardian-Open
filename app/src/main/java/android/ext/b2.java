package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile java.lang.ref.WeakReference f655a = new java.lang.ref.WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static volatile gg_a.e f656b = new gg_a.e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static int[] f657c = gg_d.b.f1514d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static volatile long f658d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final java.lang.Runnable f659e = new android.ext.b2$a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static java.util.regex.Pattern f660f = java.util.regex.Pattern.compile("__([a-z0-9_]+?)__");

    public static void a() {
        gg_a.e eVar = f656b;
        if (eVar.size() <= f657c.length) {
            return;
        }
        gg_a.e eVar2 = new gg_a.e();
        for (int i : f657c) {
            java.lang.String str = (java.lang.String) eVar.b(i);
            if (str != null) {
                eVar2.put(i, str);
            }
        }
        f656b = eVar2;
        f658d = 0L;
    }

    public static java.lang.String b(int i) {
        try {
            return c().getResourceEntryName(i);
        } catch (java.lang.Throwable th) {
            java.lang.String str = "Resource name for id 0x" + android.ext.t2.e(8, i) + " not found";
            android.ext.e1.l(str, th);
            return str;
        }
    }

    private static android.content.res.Resources c() {
        android.content.res.Resources resources = (android.content.res.Resources) f655a.get();
        if (resources == null) {
            resources = android.ext.Tools.f0().getResources();
            f655a = new java.lang.ref.WeakReference(resources);
            f659e.run();
            gg_a.e eVar = new gg_a.e();
            java.util.ArrayList arrayList = f657c.length == 0 ? new java.util.ArrayList() : null;
            int iD = d(android.ext.Tools.removeNewLinesChars("dssbqdph"), "string");
            java.lang.String strIntern = android.ext.Tools.removeNewLinesChars("JdphJxdugldq").intern();
            if (arrayList != null) {
                arrayList.add(java.lang.Integer.valueOf(iD));
            }
            eVar.put(iD, strIntern);
            try {
                java.lang.String.format(android.ext.k.f(), h(catch_.me_.if_.you_.can_.R.string.d), 1000);
            } catch (java.lang.Exception e2) {
                android.ext.e1.l("Check format", e2);
                if (arrayList != null) {
                    arrayList.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.string.d));
                }
                eVar.put(catch_.me_.if_.you_.can_.R.string.d, "%d");
            }
            java.lang.String strRemoveNewLinesChars = android.ext.Tools.removeNewLinesChars("kwws=22jdphjxdugldq1qhw2iruxp");
            if (arrayList != null) {
                arrayList.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.string.forum));
            }
            eVar.put(catch_.me_.if_.you_.can_.R.string.forum, strRemoveNewLinesChars);
            if (arrayList != null) {
                arrayList.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.string.decimal));
            }
            eVar.put(catch_.me_.if_.you_.can_.R.string.decimal, java.lang.String.valueOf(android.ext.t1.f1252b));
            if (arrayList != null) {
                arrayList.add(java.lang.Integer.valueOf(catch_.me_.if_.you_.can_.R.string.thousands));
            }
            eVar.put(catch_.me_.if_.you_.can_.R.string.thousands, android.ext.t1.f1251a);
            if (arrayList != null) {
                f657c = android.ext.Tools.Y0(arrayList);
            }
            f656b = eVar;
        }
        return resources;
    }

    public static int d(java.lang.String str, java.lang.String str2) {
        try {
            android.content.res.Resources resourcesC = c();
            return resourcesC.getIdentifier(str, str2, resourcesC.getResourcePackageName(catch_.me_.if_.you_.can_.R.string.d));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Resource id for name '" + str + "' not found", th);
            return 0;
        }
    }

    private static java.lang.String e(java.lang.String str) {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        java.lang.String strReplace;
        if (str == null) {
            str = "null";
        }
        if (str.indexOf(95) < 0) {
            return str;
        }
        try {
            java.util.regex.Matcher matcher = f660f.matcher(str);
            strReplace = str;
            while (matcher.find()) {
                try {
                    try {
                        int iD = d(matcher.group(1), "string");
                        if (iD != 0) {
                            strReplace = strReplace.replace(matcher.group(0), h(iD));
                        }
                    } catch (java.lang.Throwable th_c) {
                        android.ext.e1.l("Exception for: " + str, th_c);
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    android.ext.e1.l("Exception on: " + str, th);
                    return strReplace;
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            strReplace = str;
        }
        return strReplace;
    }

    public static java.lang.String f(int i) {
        return h(i);
    }

    public static java.lang.String g(java.lang.String str) {
        return e(str);
    }

    private static java.lang.String h(int i) {
        java.lang.String string;
        if (i == 0 || i == -1) {
            return "(Invalid resource id " + i + ")";
        }
        gg_a.e eVar = f656b;
        java.lang.Object objB = eVar.b(i);
        java.lang.String string2 = objB == null ? null : objB.toString();
        if (string2 == null) {
            try {
                string = c().getString(i);
            } catch (java.lang.Throwable th) {
                java.lang.String str = "Resource for id 0x" + android.ext.t2.e(8, i) + " not found";
                android.ext.e1.l(str, th);
                string = str;
            }
            string2 = e(string);
            try {
                eVar.c(i, string2);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.a(th2);
            }
            f658d = java.lang.System.currentTimeMillis();
        }
        return string2;
    }
}

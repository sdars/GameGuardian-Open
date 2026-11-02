package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class z1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final java.util.Map f1412c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final android.util.SparseIntArray f1414e;
    static final android.util.SparseIntArray h;
    static android.ext.z1 i;
    static java.util.HashMap j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.app.ActivityManager f1417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.content.pm.PackageManager f1418b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final java.util.Map f1415f = new android.ext.z1$a(128, 0.75f, true);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static volatile int f1416g = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f1413d = -1;

    static {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        f1414e = sparseIntArray;
        f1412c = new java.util.HashMap();
        android.ext.a0.k();
        f();
        for (java.lang.String str : android.ext.a0.e()) {
            if (str != null && str.length() != 0) {
                try {
                    sparseIntArray.put(java.lang.Integer.parseInt(str), 1);
                } catch (java.lang.NumberFormatException e2) {
                    android.ext.e1.l("Failed load bugged uid: " + str, e2);
                }
            }
        }
        h = new android.util.SparseIntArray();
        i = null;
        j = null;
    }

    public z1(android.app.ActivityManager activityManager, android.content.pm.PackageManager packageManager) {
        this.f1417a = activityManager;
        this.f1418b = packageManager;
        i = this;
    }

    private static void f() {
        java.util.Map map = f1412c;
        for (java.lang.String str : android.ext.a0.c()) {
            if (str != null && str.length() != 0) {
                map.put(str, k(str, null));
            }
        }
    }

    public static void g() {
        java.util.Map map = f1415f;
        synchronized (map) {
            try {
                f1416g++;
                map.clear();
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        java.util.Map map2 = f1412c;
        int size = map2.size();
        if (size == 0) {
            return;
        }
        map2.clear();
        f();
        android.ext.e1.d("PL: " + size + " -> " + map2.size());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x004a A[PHI: r2
      0x004a: PHI (r2v12 android.content.pm.ApplicationInfo) = 
      (r2v1 android.content.pm.ApplicationInfo)
      (r2v1 android.content.pm.ApplicationInfo)
      (r2v1 android.content.pm.ApplicationInfo)
      (r2v4 android.content.pm.ApplicationInfo)
     binds: [B:20:0x003a, B:25:0x0045, B:26:0x0049, B:22:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:72:0x00bd A[Catch: NoSuchMethodError -> 0x00b5, PackageManager$NameNotFoundException -> 0x00b8, TryCatch #3 {PackageManager$NameNotFoundException -> 0x00b8, NoSuchMethodError -> 0x00b5, blocks: (B:66:0x00b0, B:72:0x00bd, B:74:0x00c5, B:75:0x00da, B:77:0x00e4, B:79:0x00ea, B:84:0x00f1, B:87:0x00fb, B:90:0x010b, B:92:0x0113, B:94:0x011b, B:95:0x013d, B:97:0x0141), top: B:109:0x00b0 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00c5 A[Catch: NoSuchMethodError -> 0x00b5, PackageManager$NameNotFoundException -> 0x00b8, TryCatch #3 {PackageManager$NameNotFoundException -> 0x00b8, NoSuchMethodError -> 0x00b5, blocks: (B:66:0x00b0, B:72:0x00bd, B:74:0x00c5, B:75:0x00da, B:77:0x00e4, B:79:0x00ea, B:84:0x00f1, B:87:0x00fb, B:90:0x010b, B:92:0x0113, B:94:0x011b, B:95:0x013d, B:97:0x0141), top: B:109:0x00b0 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00e4 A[Catch: NoSuchMethodError -> 0x00b5, PackageManager$NameNotFoundException -> 0x00b8, TryCatch #3 {PackageManager$NameNotFoundException -> 0x00b8, NoSuchMethodError -> 0x00b5, blocks: (B:66:0x00b0, B:72:0x00bd, B:74:0x00c5, B:75:0x00da, B:77:0x00e4, B:79:0x00ea, B:84:0x00f1, B:87:0x00fb, B:90:0x010b, B:92:0x0113, B:94:0x011b, B:95:0x013d, B:97:0x0141), top: B:109:0x00b0 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:97:0x0141 A[Catch: NoSuchMethodError -> 0x00b5, PackageManager$NameNotFoundException -> 0x00b8, TRY_LEAVE, TryCatch #3 {PackageManager$NameNotFoundException -> 0x00b8, NoSuchMethodError -> 0x00b5, blocks: (B:66:0x00b0, B:72:0x00bd, B:74:0x00c5, B:75:0x00da, B:77:0x00e4, B:79:0x00ea, B:84:0x00f1, B:87:0x00fb, B:90:0x010b, B:92:0x0113, B:94:0x011b, B:95:0x013d, B:97:0x0141), top: B:109:0x00b0 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x00c5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:97:0x0141, please report this as an issue */
    private android.ext.z1$c h(int i2, int i3, java.lang.String str, java.util.List list, android.util.SparseArray sparseArray) {
        boolean z = false;
        java.lang.String str2;
        java.lang.String strJ;
        boolean z2;
        java.util.HashMap map;
        java.lang.Integer num = null;
        int i4;
        android.ext.z1$c z1_cI;
        java.lang.String strM;
        java.lang.String str3;
        java.lang.String[] strArr;
        if (str.indexOf(58) != -1) {
            str = str.split(":", -1)[0];
        }
        boolean z3 = str.indexOf(46) != -1 && str.indexOf(47) == -1;
        android.content.pm.ApplicationInfo applicationInfoY = null;
        android.ext.z1$c z1_cI2 = z3 ? i(str) : null;
        if (z1_cI2 != null) {
            if (z1_cI2.f1425a == f1413d) {
                z1_cI2.f1425a = i3;
            }
            return z1_cI2;
        }
        if (z3) {try {

            try {                if (android.ext.GgNoop.never) {
                        throw new android.content.pm.PackageManager.NameNotFoundException();
                    }

                applicationInfoY = android.ext.Tools.Y(str);
                if (applicationInfoY != null) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            } catch (java.lang.NoSuchMethodError e2) {
                android.ext.e1.a(e2);
            };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        } else {
            z = false;
        }
        if (applicationInfoY == null) {
            if (list == null) {
                str2 = str;
            } else {
                java.util.Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str2 = str;
                        break;
                    }
                    android.app.ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo = (android.app.ActivityManager.RunningAppProcessInfo) it.next();
                    if (activityManager$RunningAppProcessInfo != null && activityManager$RunningAppProcessInfo.pid == i2 && (strArr = activityManager$RunningAppProcessInfo.pkgList) != null && strArr.length > 0) {
                        str2 = strArr[0];
                        z = true;
                        break;
                    }
                }
            }
            if (!android.ext.Config.vSpaceReal) {
                if (!z && (str3 = (java.lang.String) sparseArray.get(i3)) != null) {
                    str2 = str3;
                    z = true;
                }
                if (!z && (strM = m(i3)) != null) {
                    sparseArray.put(i3, strM);
                    str2 = strM;
                    z = true;
                }
            }
            if (z && (z1_cI = i(str2)) != null) {
                if (z1_cI.f1425a == f1413d) {
                    z1_cI.f1425a = i3;
                }
                if (z3) {
                    f1412c.put(str, z1_cI);
                }
                return z1_cI;
            }
        } else {
            str2 = str;
        }
        android.ext.z1$c z1_c = new android.ext.z1$c(i3, str2);
        if (z) {
            if (applicationInfoY == null) {try {

                try {                    if (android.ext.GgNoop.never) {
                        throw new android.content.pm.PackageManager.NameNotFoundException();
                    }

                    applicationInfoY = android.ext.Tools.Y(str2);
                    if (applicationInfoY != null) {
                        strJ = j(str2, applicationInfoY);
                        z1_c.f1428d = strJ;
                        if (strJ != null) {
                            z1_c.f1428d += "";
                        }
                        if (applicationInfoY.sourceDir.startsWith("/system/")) {
                            z2 = true;
                        } else {
                            i4 = applicationInfoY.flags;
                            if ((i4 & 128) == 0 || (i4 & 1) != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        z1_c.f1430f = z2;
                        z1_c.f1431g = (applicationInfoY.flags & 33554432) != 0;
                        z1_c.f1429e = applicationInfoY.nativeLibraryDir;
                        z1_c.f1426b = applicationInfoY.uid;
                        map = j;
                        if (map != null && (num = (java.lang.Integer) map.get(str2)) != null && num.intValue() != applicationInfoY.uid) {
                            android.ext.e1.p("real uid: " + applicationInfoY.uid + " != " + num);
                            z1_c.f1426b = num.intValue();
                        }
                        if (z1_c.f1426b != i3) {
                            android.ext.e1.p("vs app: " + z1_c.f1426b + " != " + i3);
                        }
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException e3) {
                    android.ext.e1.l("Package not found: " + z1_c.f1427c + " [" + z1_c.f1425a + ']', e3);
                } catch (java.lang.NoSuchMethodError e4) {
                    android.ext.e1.a(e4);
                };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
            } else if (applicationInfoY != null) {
                strJ = j(str2, applicationInfoY);
                z1_c.f1428d = strJ;
                if (strJ != null) {
                    z1_c.f1428d += "";
                }
                if (applicationInfoY.sourceDir.startsWith("/system/")) {
                    i4 = applicationInfoY.flags;
                    if ((i4 & 128) == 0) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = true;
                }
                z1_c.f1430f = z2;
                z1_c.f1431g = (applicationInfoY.flags & 33554432) != 0;
                z1_c.f1429e = applicationInfoY.nativeLibraryDir;
                z1_c.f1426b = applicationInfoY.uid;
                map = j;
                if (map != null) {
                    android.ext.e1.p("real uid: " + applicationInfoY.uid + " != " + num);
                    z1_c.f1426b = num.intValue();
                }
                if (z1_c.f1426b != i3) {
                    android.ext.e1.p("vs app: " + z1_c.f1426b + " != " + i3);
                }
            }
        }
        java.util.Map map2 = f1412c;
        map2.put(str2, z1_c);
        if (z3 && !str.equals(str2)) {
            map2.put(str, z1_c);
        }
        return z1_c;
    }

    android.ext.z1$c i(java.lang.String str) {
        java.lang.String strC0 = android.ext.Tools.C0();
        if (str.equals(strC0)) {
            return k(strC0, "GG");
        }
        return str.startsWith("com.bluestacks.") ? k(str, str) : (android.ext.z1$c) f1412c.get(str);
    }

    private java.lang.String j(java.lang.String str, android.content.pm.ApplicationInfo applicationInfo) {
        java.lang.String str2 = applicationInfo.packageName;
        try {
            java.lang.String strA0 = android.ext.Tools.a0(applicationInfo);
            return strA0 != null ? strA0 : str2;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed load label for: " + applicationInfo.packageName, th);
            return str2;
        }
    }

    private static android.ext.z1$c k(java.lang.String str, java.lang.String str2) {
        android.ext.z1$c z1_c = new android.ext.z1$c(f1413d, str);
        if (str2 != null) {
            z1_c.f1428d = str2;
        }
        z1_c.h = true;
        return z1_c;
    }

    public static android.graphics.drawable.Drawable l(java.lang.String str) {
        android.graphics.drawable.Drawable drawable;
        android.graphics.drawable.Drawable drawableR1;
        if (str == null) {
            return null;
        }
        java.util.Map map = f1415f;
        synchronized (map) {
            try {
                drawable = (android.graphics.drawable.Drawable) map.get(str);
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        if (drawable == null || (drawableR1 = android.ext.Tools.R1(drawable)) == drawable) {
            return null;
        }
        return drawableR1;
    }

    java.lang.String m(int i2) {
        if (android.ext.Config.C) {
            return android.ext.Config.E;
        }
        java.lang.String str = null;
        if (android.ext.Config.vSpaceReal) {
            java.util.HashMap map = j;
            if (map != null) {
                for (java.util.Map.Entry map$Entry : (java.util.Collection<java.util.Map.Entry>) map.entrySet()) {
                    if (map$Entry != null && ((java.lang.Integer) map$Entry.getValue()).intValue() == i2) {
                        break;
                    }
                }
                return null;
            }
        } else if (f1414e.get(i2) != 1) {
            try {
                android.content.pm.PackageManager packageManager = this.f1418b;
                boolean zA = android.ext.a0.a("uid:" + i2, "uid");
                try {
                    java.lang.String[] packagesForUid = packageManager.getPackagesForUid(i2);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        str = packagesForUid[0];
                    }
                    android.ext.a0.b(zA);
                } catch (java.lang.Throwable th) {
                    android.ext.a0.b(zA);
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                android.ext.e1.l("Failed getPackagesForUid", th2);
            }
        }
        return str;
    }

    /* ------------------------------------------------------------- *
     *  .method private n(Landroid/ext/w;)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    private void n(android.ext.w wVar) {
        z1nState st = new z1nState();
        st.v22o = this;
        st.v23o = wVar;
        z1n_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void z1n_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class z1nState {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
        int v10i;
        long v10j;
        java.lang.Object v10o;
        double v10d;
        int v11i;
        long v11j;
        java.lang.Object v11o;
        double v11d;
        int v12i;
        long v12j;
        java.lang.Object v12o;
        double v12d;
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
        int v14i;
        long v14j;
        java.lang.Object v14o;
        double v14d;
        int v15i;
        long v15j;
        java.lang.Object v15o;
        double v15d;
        int v16i;
        long v16j;
        java.lang.Object v16o;
        double v16d;
        int v17i;
        long v17j;
        java.lang.Object v17o;
        double v17d;
        int v18i;
        long v18j;
        java.lang.Object v18o;
        double v18d;
        int v19i;
        long v19j;
        java.lang.Object v19o;
        double v19d;
        int v20i;
        long v20j;
        java.lang.Object v20o;
        double v20d;
        int v21i;
        long v21j;
        java.lang.Object v21o;
        double v21d;
        java.lang.Object v22o;
        java.lang.Object v23o;
    }

    private static void z1n_run(z1nState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 136) {
                done = z1n_c0(st);
            }
            else {
                done = z1n_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean z1n_c0(z1nState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v7o = st.v22o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 1:
                        st.pc = 1;
                        ((android.ext.w) st.v23o).j();
                    case 2:
                        st.pc = 2;
                        st.v8o = null;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v8o = new java.util.ArrayList();
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v0o = android.ext.z1.h;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        ((android.util.SparseIntArray) st.v0o).clear();
                    case 6:
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 7:
                        st.v0o = "getRunningAppProcesses: start";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpI = android.ext.e1.d((java.lang.String) st.v0o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.pc = 9;
                        st.v0o = ((android.ext.z1) st.v7o).f1417a;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((android.app.ActivityManager) st.v0o).getRunningAppProcesses();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 14:
                        st.v2o = "getRunningAppProcesses: end ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.pc = 16;
                        st.tmpI = ((java.util.List) st.v1o).size();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 17:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.tmpI = android.ext.e1.d((java.lang.String) st.v0o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 22:
                        st.v10o = st.v1o;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.pc = 31;
                        continue;
                    case 24:
                        st.pc = 24;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.pc = 28;
                        continue;
                    case 26:
                        st.pc = 26;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 27:
                        st.v1o = st.v9o;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 28:
                        st.v2o = "Failed getRunningAppProcesses";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.tmpI = android.ext.e1.l((java.lang.String) st.v2o, (java.lang.Throwable) st.v0o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 30:
                        st.pc = 30;
                        st.pc = 22;
                        continue;
                    case 31:
                        st.pc = 31;
                        st.tmpI = android.os.Process.myPid();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 32:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 33:
                        st.pc = 33;
                        st.v1o = android.ext.MainService.instance;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 34:
                        st.pc = 34;
                        st.v1o = ((android.ext.MainService) st.v1o).i;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.tmpI = ((android.ext.f0) st.v1o).J();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 36:
                        st.v11i = st.tmpI;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.v1o = android.ext.MainService.instance;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.v1o = ((android.ext.MainService) st.v1o).i;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.tmpI = ((android.ext.f0) st.v1o).b0();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 40:
                        st.v12i = st.tmpI;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 41:
                        st.pc = 41;
                        st.v13o = null;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.v13o = new gg_a.e();
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 43:
                        st.pc = 43;
                        st.tmpI = ((android.ext.w) st.v23o).f();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 44:
                        st.v15i = st.tmpI;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 45:
                        st.pc = 45;
                        if (st.v15i != 0) {
                            st.pc = 47;
                            continue;
                        }
                    case 46:
                        st.pc = 46;
                        st.pc = 130;
                        continue;
                    case 47:
                        st.pc = 47;
                        st.tmpI = ((android.ext.w) st.v23o).f();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 48:
                        st.v17i = st.tmpI;
                        st.v17j = 0L;
                        st.v17o = null;
                        st.v17d = 0.0;
                    case 49:
                        st.pc = 49;
                        st.tmpI = (int) ((android.ext.w) st.v23o).e();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 50:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 51:
                        st.pc = 51;
                        if (st.v1i == 0) {
                            st.pc = 55;
                            continue;
                        }
                    case 52:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 53:
                        st.v20i = 1;
                        st.v20j = 0L;
                        st.v20o = null;
                        st.v20d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.pc = 57;
                        continue;
                    case 55:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 56:
                        st.v20i = 0;
                        st.v20j = 0L;
                        st.v20o = null;
                        st.v20d = 0.0;
                    case 57:
                        st.pc = 57;
                        st.tmpI = ((android.ext.w) st.v23o).f();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 58:
                        st.v21i = st.tmpI;
                        st.v21j = 0L;
                        st.v21o = null;
                        st.v21d = 0.0;
                    case 59:
                        st.pc = 59;
                        st.tmpI = ((android.ext.w) st.v23o).f();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 60:
                        st.v19i = st.tmpI;
                        st.v19j = 0L;
                        st.v19o = null;
                        st.v19d = 0.0;
                    case 61:
                        st.pc = 61;
                        st.tmpI = ((android.ext.w) st.v23o).f();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 62:
                        st.v14i = st.tmpI;
                        st.v14j = 0L;
                        st.v14o = null;
                        st.v14d = 0.0;
                    case 63:
                        st.pc = 63;
                        st.tmpI = ((android.ext.w) st.v23o).f();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 64:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 65:
                        st.pc = 65;
                        if (st.v1i < 0) {
                            st.pc = 117;
                            continue;
                        }
                    case 66:
                        st.v2i = 200;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 67:
                        st.pc = 67;
                        if (st.v1i <= st.v2i) {
                            st.pc = 69;
                            continue;
                        }
                    case 68:
                        st.pc = 68;
                        st.pc = 117;
                        continue;
                    case 69:
                        st.v6o = st.v23o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 70:
                        st.pc = 70;
                        st.tmpO = ((android.ext.w) st.v6o).i(st.v1i, (java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 71:
                        st.v18o = st.tmpO;
                        st.v18i = 0;
                        st.v18j = 0L;
                        st.v18d = 0.0;
                    case 72:
                        st.pc = 72;
                        if (st.v15i == st.v0i) {
                            st.pc = 43;
                            continue;
                        }
                    case 73:
                        st.pc = 73;
                        if (st.v15i == st.v11i) {
                            st.pc = 43;
                            continue;
                        }
                    case 74:
                        st.pc = 74;
                        if (st.v15i != st.v12i) {
                            st.pc = 76;
                            continue;
                        }
                    case 75:
                        st.pc = 75;
                        st.pc = 43;
                        continue;
                    case 76:
                        st.v1o = st.v22o;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 77:
                        st.v2i = st.v15i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 78:
                        st.v3i = st.v17i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 79:
                        st.v4o = st.v18o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 80:
                        st.v5o = st.v10o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 81:
                        st.v6o = st.v13o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 82:
                        st.pc = 82;
                        st.tmpO = ((android.ext.z1) st.v1o).h(st.v2i, st.v3i, (java.lang.String) st.v4o, (java.util.List) st.v5o, (android.util.SparseArray) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 83:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 84:
                        st.pc = 84;
                        if (st.v1o == null) {
                            st.pc = 43;
                            continue;
                        }
                    case 85:
                        st.pc = 85;
                        st.v2o = ((android.ext.z1$c) st.v1o).f1427c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 86:
                        st.pc = 86;
                        st.tmpO = android.ext.Tools.C0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 87:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 88:
                        st.pc = 88;
                        st.tmpI = (((java.lang.String) st.v2o).equals(st.v3o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 89:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 90:
                        st.pc = 90;
                        if (st.v2i == 0) {
                            st.pc = 92;
                            continue;
                        }
                    case 91:
                        st.pc = 91;
                        st.pc = 43;
                        continue;
                    case 92:
                        st.pc = 92;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 93:
                        st.v3i = st.v14i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 94:
                        st.v14o = st.v2o;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 95:
                        st.v4i = st.v15i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 96:
                        st.v15o = st.v1o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 97:
                        st.v16i = st.v4i;
                        st.v16j = 0L;
                        st.v16o = null;
                        st.v16d = 0.0;
                    case 98:
                        st.pc = 98;
                        st.v14o = new android.ext.z1$d((android.ext.z1$c) st.v15o, st.v16i, st.v17i, (java.lang.String) st.v18o, st.v19i, (st.v20i != 0), st.v21i);
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 99:
                        st.pc = 99;
                        st.tmpI = (((java.util.List) st.v8o).add(st.v2o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 100:
                        st.pc = 100;
                        if (st.v3i == 0) {
                            st.pc = 43;
                            continue;
                        }
                    case 101:
                        st.pc = 101;
                        st.v1o = android.ext.z1.h;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 102:
                        st.pc = 102;
                        ((android.util.SparseIntArray) st.v1o).put(st.v4i, st.v3i);
                    case 103:
                        st.pc = 103;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 104:
                        st.pc = 104;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 105:
                        st.v2o = "Tracer: ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 106:
                        st.pc = 106;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 107:
                        st.pc = 107;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 108:
                        st.v2o = " -> ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 109:
                        st.pc = 109;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 110:
                        st.pc = 110;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 111:
                        st.pc = 111;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 112:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 113:
                        st.pc = 113;
                        st.tmpI = android.ext.e1.d((java.lang.String) st.v1o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 114:
                        st.pc = 114;
                        st.pc = 43;
                        continue;
                    case 115:
                        st.pc = 115;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 116:
                        st.pc = 116;
                        st.pc = 128;
                        continue;
                    case 117:
                        st.pc = 117;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 118:
                        st.pc = 118;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 119:
                        st.v2o = "Bad cmdline length: ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 120:
                        st.pc = 120;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 121:
                        st.pc = 121;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 122:
                        st.pc = 122;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 123:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 124:
                        st.pc = 124;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 125:
                        st.pc = 125;
                        st.v1o = new java.lang.RuntimeException();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 126:
                        st.pc = 126;
                        st.tmpI = android.ext.e1.l((java.lang.String) st.v0o, (java.lang.Throwable) st.v1o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 127:
                        st.pc = 127;
                        st.pc = 130;
                        continue;
                    case 128:
                        st.v1o = "???";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 129:
                        st.pc = 129;
                        st.tmpI = android.ext.e1.l((java.lang.String) st.v1o, (java.lang.Throwable) st.v0o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 130:
                        st.pc = 130;
                        st.v0o = android.ext.MainService.instance;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 131:
                        st.pc = 131;
                        st.v0o = ((android.ext.MainService) st.v0o).h;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 132:
                        st.pc = 132;
                        st.tmpO = ((android.ext.z1) st.v7o).s((java.util.List) st.v8o, (java.util.List) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 133:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 134:
                        st.pc = 134;
                        ((android.ext.j) st.v0o).d((java.util.List) st.v1o);
                    case 135:
                        st.pc = 135;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = z1n_handler(st.pc, t);
            if (h < 0) {
                z1n_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] z1n_ctypes = {
        java.io.IOException.class
    };
    private static final int[] z1n_handlers = {
        7, 12, 26, -1, 12, 22, 24, -1, 31, 127, 115, 0
    };
    private static int z1n_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < z1n_handlers.length; i += 4) {
            if (pc < z1n_handlers[i] || pc >= z1n_handlers[i + 1]) {
                continue;
            }
            int ti = z1n_handlers[i + 3];
            if (ti < 0 || z1n_ctypes[ti].isInstance(t)) {
                return z1n_handlers[i + 2];
            }
        }
        return -1;
    }

    public static void o(android.ext.w wVar) {
        i.n(wVar);
    }

    public static void p(java.util.List list) {
        if (list == null) {
            return;
        }
        int i2 = f1416g + 1;
        f1416g = i2;
        q(list, i2, 0, java.lang.Math.min(list.size(), 128));
    }

    static void q(java.util.List list, int i2, int i3, int i4) {
        android.ext.n2.h(new android.ext.z1$b(i2, i3, i4, list));
    }

    public static void r(java.lang.String str, android.graphics.drawable.Drawable drawable) {
        android.graphics.drawable.Drawable drawableR1;
        if (str == null || drawable == null || (drawableR1 = android.ext.Tools.R1(drawable)) == null || drawableR1 == drawable) {
            return;
        }
        java.util.Map map = f1415f;
        synchronized (map) {
            try {
                map.put(str, drawableR1);
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
    }

    private java.util.List s(java.util.List list, java.util.List list2) {
java.lang.Throwable e = null;
        long j2 = 0L;
        android.ext.z1$d z1_d;
        java.lang.String str = "Class not found";
        android.ext.z1$d[] z1_dArr = (android.ext.z1$d[]) list.toArray(new android.ext.z1$d[list.size()]);
        char c2 = 0;
        for (android.ext.z1$d z1_d2 : z1_dArr) {
            z1_d2.k = 0L;
        }
        int i2 = 2;
        java.util.List[] listArr = new java.util.List[2];
        try {
            listArr[0] = this.f1417a.getRunningTasks(50);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed getRunningTasks", th);
        }
        char c3 = 1;
        listArr[1] = list2;
        int i3 = 0;
        while (i3 < i2) {
            java.util.List list3 = listArr[i3];
            if (list3 != null) {
                boolean[] zArr = new boolean[z1_dArr.length];
                int i4 = 0;
                while (i4 < list3.size()) {
                    java.lang.Object obj = list3.get(i4);
                    if (obj != null) {
                        java.lang.String[] strArr = null;
                        try {
                            if (obj instanceof android.app.ActivityManager.RunningTaskInfo) {
                                android.app.ActivityManager.RunningTaskInfo activityManager$RunningTaskInfo = (android.app.ActivityManager.RunningTaskInfo) obj;
                                java.lang.String[] strArr2 = new java.lang.String[i2];
                                strArr2[c2] = activityManager$RunningTaskInfo.topActivity != null ? activityManager$RunningTaskInfo.topActivity.getPackageName() : null;
                                java.lang.String packageName = activityManager$RunningTaskInfo.baseActivity != null ? activityManager$RunningTaskInfo.baseActivity.getPackageName() : null;
                                strArr2[c3] = packageName;
                                try {
                                    java.lang.String str2 = strArr2[c2];
                                    if (str2 != null && str2.equals(packageName)) {
                                        strArr2[c3] = null;
                                    }
                                    j2 = 1000000;
                                    strArr = strArr2;
                                } catch (java.lang.NoClassDefFoundError e2) {
                                    e = e2;
                                    strArr = strArr2;
                                    android.ext.e1.s(str, e);
                                    j2 = 0;
                                }
                            } else {
                                j2 = 0;
                            }
                        } catch (java.lang.NoClassDefFoundError e3) {
                            e = e3;
                        }
                        try {
                            if (obj instanceof android.app.ActivityManager.RunningAppProcessInfo) {
                                strArr = ((android.app.ActivityManager.RunningAppProcessInfo) obj).pkgList;
                                j2 = 1000;
                            }
                        } catch (java.lang.NoClassDefFoundError e4) {
                            android.ext.e1.s(str, e4);
                        }
                        if (strArr != null) {
                            int length = strArr.length;
                            int i5 = 0;
                            while (i5 < length) {
                                java.lang.String str3 = strArr[i5];
                                if (str3 != null) {
                                    int i6 = 0;
                                    while (i6 < z1_dArr.length) {
                                        if (!zArr[i6] && (z1_d = z1_dArr[i6]) != null && str3.equals(z1_d.f1434c)) {
                                            z1_d.k += ((long) (list3.size() - i4)) * j2;
                                            zArr[i6] = true;
                                        }
                                        i6++;
                                        i3 = i3;
                                        str = str;
                                        length = length;
                                    }
                                }
                                i5++;
                                i3 = i3;
                                str = str;
                                length = length;
                            }
                        }
                    }
                    i4++;
                    i3 = i3;
                    str = str;
                    c2 = 0;
                    i2 = 2;
                    c3 = 1;
                }
            }
            i3++;
            str = str;
            c2 = 0;
            i2 = 2;
            c3 = 1;
        }
        try {
            java.util.Arrays.sort(z1_dArr);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(z1_dArr.length);
        for (android.ext.z1$d z1_d3 : z1_dArr) {
            arrayList.add(z1_d3);
        }
        return arrayList;
    }
}

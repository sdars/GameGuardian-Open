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
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
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
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
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

    private void n(android.ext.w wVar) {
java.lang.Throwable th = null;
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = null;
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> list = null;
        int iMyPid = 0;
        int iJ = 0;
        int iB0 = 0;
        gg_a.e eVar = null;
        android.ext.z1$c z1_cH;
        wVar.j();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        h.clear();try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

            try {
                android.ext.e1.d("getRunningAppProcesses: start");
                runningAppProcesses = this.f1417a.getRunningAppProcesses();
                try {
                    android.ext.e1.d("getRunningAppProcesses: end " + runningAppProcesses.size());
                    while (true) {
                        int iF = wVar.f();
                        if (iF != 0) {
                            int iF2 = wVar.f();
                            boolean z = wVar.e() != 0;
                            int iF3 = wVar.f();
                            int iF4 = wVar.f();
                            int iF5 = wVar.f();
                            int iF6 = wVar.f();
                            if (iF6 >= 0 && iF6 <= 200) {
                                java.lang.String strI = wVar.i(iF6, null);
                                if (iF != iMyPid && iF != iJ && iF != iB0 && (z1_cH = h(iF, iF2, strI, list, eVar)) != null && !z1_cH.f1427c.equals(android.ext.Tools.C0())) {
                                    arrayList.add(new android.ext.z1$d(z1_cH, iF, iF2, strI, iF4, z, iF3));
                                    if (iF5 != 0) {
                                        h.put(iF, iF5);
                                        android.ext.e1.d("Tracer: " + iF5 + " -> " + iF);
                                    }
                                }
                            }
                            android.ext.e1.l("Bad cmdline length: " + iF6, new java.lang.RuntimeException());
                            break;
                        }
                        break;
                    }
                } catch (java.lang.Throwable th_c) {
                    th = th_c;
                    android.ext.e1.l("Failed getRunningAppProcesses", th_c);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                runningAppProcesses = null;
            }
            iMyPid = android.os.Process.myPid();
            iJ = android.ext.MainService.instance.i.J();
            iB0 = android.ext.MainService.instance.i.b0();
            eVar = new gg_a.e();
        } catch (java.io.IOException e2) {
            android.ext.e1.l("???", e2);
        };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        list = runningAppProcesses;
        android.ext.MainService.instance.h.d(s(arrayList, list));
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

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class x2 {
    /* JADX WARN: Code duplicated, block: B:7:0x003d  */
    public static java.io.InputStream a(java.lang.String str, int i) {
        java.lang.String str2;
        java.lang.String str3 = android.ext.Tools.K0() + "/tmp.file.tmp";
        java.io.File externalFilesDir = android.ext.Tools.f0().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            externalFilesDir.mkdirs();
            if (externalFilesDir.exists()) {
                str2 = externalFilesDir.getAbsolutePath() + "/tmp.file.tmp";
            } else {
                str2 = null;
            }
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = str3;
        }
        java.lang.String[][] strArr = {new java.lang.String[]{"exec cat " + str, null}, new java.lang.String[]{"exec dalvikvm -cp " + android.ext.Tools.W() + ' ' + android.ext.Cat.class.getName() + ' ' + str, null}, new java.lang.String[]{"exec cp " + str + ' ' + str2, str2}, new java.lang.String[]{"exec cp " + str + ' ' + str3, str3}, new java.lang.String[]{"exec cp " + str + ' ' + str2.replace("/emulated/0", "/emulated/legacy"), str2}};
        if (i >= 5) {
            return null;
        }
        java.lang.String[] strArr2 = strArr[i];
        java.lang.Process processQ = android.ext.e2.q(strArr2[0]);
        if (processQ == null) {
            android.ext.e1.p("Failed run " + java.util.Arrays.toString(strArr2));
            return null;
        }
        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

            if (strArr2[1] == null) {
                return processQ.getInputStream();
            }
            try {
                processQ.waitFor();
            } catch (java.lang.InterruptedException e2) {
                android.ext.e1.s("Wait fail: " + strArr2[0], e2);
            }
            return new android.ext.x2$g(strArr2[1], strArr2[1]);
        } catch (java.io.IOException e3) {
            android.ext.e1.s("Failed read xml", e3);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:85:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x0104 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:95:0x00d8 A[SYNTHETIC] */
    private static void b(java.io.File file, java.io.File file2, java.lang.String str) {
java.lang.Throwable e = null;
java.lang.Throwable th = null;
        int i;
        int i2 = 0;
        while (true) {
            int i3 = 10;
            if (i2 >= 10) {
                return;
            }
            java.io.InputStream inputStreamI = i(file.getAbsolutePath(), i2);
            if (inputStreamI != null) {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStreamI));
                int i4 = 0;
                while (true) {
                    try {
                        java.lang.String line = bufferedReader.readLine();
                        if (line == null) {
                            bufferedReader.close();
                            break;
                        }
                        i4++;
                        if (!line.endsWith("_preferences.xml") && line.endsWith(".xml")) {
                            java.io.File file3 = line.startsWith("/") ? new java.io.File(line) : new java.io.File(file, line);
                            java.lang.String name = file3.getName();
                            try {
                                if (!name.equals(str) && !name.equals("DefaultStorage.xml")) {
                                    try {
                                        java.io.File file4 = new java.io.File(file2, file3.getName());
                                        file2.mkdirs();
                                        if (!file4.exists()) {
                                            int i5 = 0;
                                            while (i5 < i3) {
                                                java.io.InputStream inputStreamA = a(file3.getAbsolutePath(), i5);
                                                if (inputStreamA != null) {
                                                    try {
                                                        byte[] bArr = new byte[8192];
                                                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file4);
                                                        i = 0;
                                                        while (true) {
                                                            try {
                                                                int i6 = inputStreamA.read(bArr);
                                                                if (i6 != -1) {
                                                                    fileOutputStream.write(bArr, 0, i6);
                                                                    i += i6;
                                                                } else {
                                                                    try {                                                                        if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                                                                        break;
                                                                    } catch (java.io.IOException e2) {
                                                                        e = e2;
                                                                        android.ext.e1.s("Failed read data from " + file3, e);
                                                                    }
                                                                }
                                                                if (i > 0) {
                                                                    break;
                                                                }
                                                            } catch (java.lang.Throwable th_c) {
                                                                fileOutputStream.close();
                                                                throw th_c;
                                                            }
                                                        }
                                                        fileOutputStream.close();
                                                        inputStreamA.close();
                                                    } catch (java.io.IOException e3) {
                                                        e = e3;
                                                        i = 0;
                                                    }
                                                    if (i > 0) {
                                                        break;
                                                    }
                                                }
                                                i5++;
                                                i3 = 10;
                                            }
                                        }
                                    } catch (java.lang.Throwable th2) {
                                        th = th2;
                                        android.ext.e1.s("Failed read list from " + file, th);
                                        if (i4 > 0) {
                                            return;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                            }
                        }
                        i3 = 10;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                    }
                }
                if (i4 > 0) {
                    return;
                }
            }
            i2++;
        }
    }

    private static boolean c(gg_a.e eVar) {
        java.io.File fileG = g(android.ext.MainService.G0);
        boolean zD = false;
        if (h()) {
            return false;
        }
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        java.util.HashMap map = new java.util.HashMap(sharedPreferencesM0.getAll());
        android.content.SharedPreferences.Editor sharedPreferences$EditorEdit = sharedPreferencesM0.edit();
        java.lang.String absolutePath = fileG.getAbsolutePath();
        java.lang.String strC0 = android.ext.Tools.C0();
        java.io.File fileG2 = g("DefaultStorage");
        if (fileG2.exists()) {
            zD = d(absolutePath, strC0, fileG, map, sharedPreferences$EditorEdit, strC0, true);
            fileG2.delete();
        }
        boolean z = zD;
        for (int size = eVar.size() - 1; size >= 0; size--) {
            if (d(absolutePath, strC0, fileG, map, sharedPreferences$EditorEdit, ((android.ext.x2$h) eVar.valueAt(size)).f1323a, false)) {
                z = true;
            }
        }
        android.ext.e1.d("New: " + n(sharedPreferences$EditorEdit, map) + " from " + map.size());
        sharedPreferences$EditorEdit.putBoolean("installed", true).commit();
        return z;
    }

    private static boolean d(java.lang.String str, java.lang.String str2, java.io.File file, java.util.Map map, android.content.SharedPreferences.Editor sharedPreferences$Editor, java.lang.String str3, boolean z) {
        java.lang.String strReplace = str.replace(str2, str3);
        int i = 0;
        if (!z && str.equals(strReplace)) {
            return false;
        }
        if (!z) {
            b(new java.io.File(strReplace).getParentFile(), file.getParentFile(), android.ext.MainService.G0.replace(str2, str3));
        }
        java.util.HashMap mapK = z ? null : k(strReplace);
        if (mapK == null && (mapK = k(str.replace(android.ext.MainService.G0, "DefaultStorage").replace(str2, str3))) == null) {
            return false;
        }
        java.util.Iterator it = mapK.entrySet().iterator();
        while (it.hasNext()) {
            if (!map.containsKey(((java.util.Map.Entry) it.next()).getKey())) {
                i++;
            }
        }
        android.ext.e1.d("Copy: " + n(sharedPreferences$Editor, mapK) + " from " + mapK.size() + " new " + i);
        return true;
    }

    private static gg_a.e e(java.lang.String str) {
        int i;
        gg_a.e eVar = new gg_a.e();
        if (str != null && str.length() != 0) {
            for (java.lang.String str2 : str.split(";")) {
                int iIndexOf = str2.indexOf(124);
                int iIndexOf2 = iIndexOf < 0 ? -1 : str2.indexOf(124, iIndexOf + 1);
                if (iIndexOf >= 0 && iIndexOf2 >= 0) {
                    try {
                        i = java.lang.Integer.parseInt(str2.substring(iIndexOf + 1, iIndexOf2));
                    } catch (java.lang.NumberFormatException e2) {
                        android.ext.e1.s("Failed parse deferred old version code", e2);
                        i = 0;
                    }
                    eVar.put(eVar.size(), new android.ext.x2$h(android.ext.s1.S(str2.substring(0, iIndexOf)), i, android.ext.s1.S(str2.substring(iIndexOf2 + 1))));
                }
            }
        }
        return eVar;
    }

    private static java.lang.String f(gg_a.e eVar) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < eVar.size(); i++) {
            android.ext.x2$h x2_h = (android.ext.x2$h) eVar.valueAt(i);
            if (x2_h != null && x2_h.f1323a != null) {
                if (sb.length() > 0) {
                    sb.append(';');
                }
                sb.append(android.ext.s1.p(x2_h.f1323a));
                sb.append('|');
                sb.append(x2_h.f1324b);
                sb.append('|');
                java.lang.String str = x2_h.f1325c;
                if (str == null) {
                    str = "";
                }
                sb.append(android.ext.s1.p(str));
            }
        }
        return sb.toString();
    }

    public static java.io.File g(java.lang.String str) {
        java.io.File file;
        android.content.Context context = android.ext.MainService.context;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 24) {
                try {
                    file = (java.io.File) context.getClass().getMethod("getSharedPreferencesPath", java.lang.String.class).invoke(context, str);
                } catch (java.lang.Throwable th) {
                    android.ext.e1.s("Failed call getSharedPreferencesPath", th);
                    file = null;
                }
            } else {
                file = null;
            }
            return file == null ? (java.io.File) context.getClass().getMethod("getSharedPrefsFile", java.lang.String.class).invoke(context, str) : file;
        } catch (java.lang.Throwable th2) {
            android.ext.e1.s("Failed call getSharedPrefsFile", th2);
            return new java.io.File(android.ext.Tools.p0(), "../shared_prefs/" + str + ".xml");
        }
    }

    public static boolean h() {
        return android.ext.Tools.M0().getBoolean("installed", false);
    }

    public static java.io.InputStream i(java.lang.String str, int i) {
        java.lang.String[] strArr = {"exec ls " + str, "exec dalvikvm -cp " + android.ext.Tools.W() + ' ' + android.ext.Ls.class.getName() + ' ' + str};
        if (i >= 2) {
            return null;
        }
        java.lang.String str2 = strArr[i];
        java.lang.Process processQ = android.ext.e2.q(str2);
        if (processQ != null) {
            return processQ.getInputStream();
        }
        android.ext.e1.p("Failed run " + str2);
        return null;
    }

    private static final java.lang.String j(java.lang.String str) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return android.ext.Tools.l(messageDigest.digest());
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed check old versions", th);
            return null;
        }
    }

    public static java.util.HashMap k(java.lang.String str) {
        java.util.HashMap mapA = null;
        for (int i = 0; i < 10; i++) {
            try {
                java.io.InputStream inputStreamA = a(str, i);
                if (inputStreamA != null) {
                    android.ext.x2$i x2_i = new android.ext.x2$i(inputStreamA);
                    try {
                        mapA = gg_b.b.a(x2_i);
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.s("Fail: " + str, th);
                        android.ext.e1.p("Last data: " + x2_i.a());
                    }
                    x2_i.close();
                    if (mapA != null) {
                        break;
                    }
                }
            } catch (java.io.IOException e2) {
                android.ext.e1.s("Failed read xml", e2);
            }
        }
        if (mapA == null) {
            try {
                android.ext.e2.n("exec ls -l " + str, 10);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.s("Failed check xml", th2);
            }
        }
        return mapA;
    }

    private static void l(gg_a.e eVar) {
        m(eVar, null);
    }

    private static boolean m(gg_a.e eVar, java.lang.Runnable runnable) {
        boolean[] zArr = new boolean[1];
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.app_name)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit_confirm)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart), new android.ext.x2$b(zArr, new android.ext.p0(1300, true))).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), new android.ext.x2$a(eVar, runnable, zArr)).setCancelable(false).create();
        if (runnable != null) {
            android.ext.f.k(alertDialogCreate, new android.ext.x2$c(zArr, runnable));
        }
        android.ext.f.m(alertDialogCreate);
        return true;
    }

    private static int n(android.content.SharedPreferences.Editor sharedPreferences$Editor, java.util.Map map) {
        int i = 0;
        for (java.util.Map.Entry map$Entry : (java.util.Collection<java.util.Map.Entry>) map.entrySet()) {
            java.lang.Object value = map$Entry.getValue();
            if (value instanceof java.lang.Boolean) {
                sharedPreferences$Editor.putBoolean((java.lang.String) map$Entry.getKey(), ((java.lang.Boolean) map$Entry.getValue()).booleanValue());
                i++;
            }
            if (value instanceof java.lang.Float) {
                sharedPreferences$Editor.putFloat((java.lang.String) map$Entry.getKey(), ((java.lang.Float) map$Entry.getValue()).floatValue());
                i++;
            }
            if (value instanceof java.lang.Integer) {
                sharedPreferences$Editor.putInt((java.lang.String) map$Entry.getKey(), ((java.lang.Integer) map$Entry.getValue()).intValue());
                i++;
            }
            if (value instanceof java.lang.Long) {
                sharedPreferences$Editor.putLong((java.lang.String) map$Entry.getKey(), ((java.lang.Long) map$Entry.getValue()).longValue());
                i++;
            }
            if (value instanceof java.lang.String) {
                sharedPreferences$Editor.putString((java.lang.String) map$Entry.getKey(), (java.lang.String) map$Entry.getValue());
                i++;
            }
            if (value instanceof java.util.Set) {
                sharedPreferences$Editor.putStringSet((java.lang.String) map$Entry.getKey(), (java.util.Set) map$Entry.getValue());
                i++;
            }
        }
        return i;
    }

    static boolean o(java.lang.String str, java.lang.Runnable runnable) {
        gg_a.e eVarE = e(str);
        if (eVarE.size() == 0) {
            return false;
        }
        return r(eVarE, runnable);
    }

    static boolean p(java.lang.String str, java.lang.Runnable runnable) {
        gg_a.e eVarE = e(str);
        if (eVarE.size() == 0) {
            return false;
        }
        return m(eVarE, runnable);
    }

    static void q(gg_a.e eVar) {
        r(eVar, null);
    }

    static boolean r(gg_a.e eVar, java.lang.Runnable runnable) {
        java.lang.String str;
        android.content.pm.PackageInfo packageInfoZ0;
        float f2 = 1;
        int i = (int) (((16391.2f * f2) - 236.2f) + 0.5f);
        int i2 = 0;
        while (i2 < eVar.size()) {
            android.ext.x2$h x2_h = (android.ext.x2$h) eVar.valueAt(i2);
            if ((x2_h.f1324b == i && !android.ext.i.f1000b.equals(x2_h.f1323a)) || !android.ext.Tools.e1(x2_h.f1323a)) {
                eVar.removeAt(i2);
                i2--;
                android.ext.e1.d("Un: ignore: " + x2_h.f1323a + ' ' + x2_h.f1324b);
            }
            i2++;
        }
        if (eVar.size() == 0) {
            str = "Un: empty";
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.found_old_version));
            int i3 = 0;
            while (true) {
                if (i3 >= eVar.size()) {
                    break;
                }
                android.ext.x2$h x2_h2 = (android.ext.x2$h) eVar.valueAt(i3);
                sb.append("\n\n");
                try {                    if (android.ext.GgNoop.never) {
                        throw new android.content.pm.PackageManager.NameNotFoundException();
                    }

                    packageInfoZ0 = android.ext.Tools.z0(x2_h2.f1323a);
                } catch (android.content.pm.PackageManager.NameNotFoundException e2) {
                    android.ext.e1.l("Package not found: " + x2_h2.f1323a, e2);
                    packageInfoZ0 = null;
                }
                if (packageInfoZ0 != null) {
                    android.content.pm.ApplicationInfo applicationInfo = packageInfoZ0.applicationInfo;
                    sb.append(applicationInfo != null ? android.ext.Tools.a0(applicationInfo) : null);
                    sb.append(" (");
                    sb.append(x2_h2.f1323a);
                    sb.append(") - ");
                    sb.append(x2_h2.f1325c.length() > 0 ? x2_h2.f1325c : packageInfoZ0.versionName);
                    sb.append(" (");
                    int i4 = x2_h2.f1324b;
                    if (i4 <= 0) {
                        i4 = packageInfoZ0.versionCode;
                    }
                    sb.append(i4);
                    sb.append(')');
                } else {
                    sb.append(x2_h2.f1323a);
                    sb.append(" - ");
                    sb.append(x2_h2.f1324b);
                }
                i3++;
            }
            android.ext.e1.d("Un: alert: " + eVar.size());
            java.lang.String string = sb.toString();
            int iHashCode = ((int) (((f2 * 17734.3f) - 1579.3f) + 0.5f)) ^ string.hashCode();
            if (iHashCode != android.ext.Tools.M0().getInt("skip-old", 0)) {
                android.ext.x2$d x2_d = new android.ext.x2$d(iHashCode, eVar);
                android.app.AlertDialog alertDialogCreate = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.old_version)).setMessage(string).setCancelable(false).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), x2_d).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), x2_d).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null).create();
                if (runnable != null) {
                    android.ext.f.k(alertDialogCreate, new android.ext.x2$e(runnable));
                }
                android.ext.f.m(alertDialogCreate);
                return true;
            }
            str = "Un: skip";
        }
        android.ext.e1.d(str);
        return false;
    }

    public static void s(java.lang.String str, java.lang.Runnable runnable) {
        if (!android.ext.Tools.e1(str)) {
            android.ext.e1.d(runnable + ": 50");
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (runnable == null) {
            t(str);
            return;
        }
        android.ext.e1.d(runnable + ": 60");
        try {
            android.ext.e2.n("exec pm uninstall --user -1 " + str, 45);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("run cmd fail", th);
        }
        android.ext.e1.d(runnable + ": 70");
        if (android.ext.Tools.e1(str)) {
            try {
                android.ext.e2.n("exec pm uninstall " + str, 45);
            } catch (java.lang.Throwable th2) {
                android.ext.e1.l("run cmd fail", th2);
            }
        }
        android.ext.e1.d(runnable + ": 80");
        if (android.ext.Tools.e1(str)) {
            android.ext.f.r(android.ext.f.c(android.ext.r.p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_uninstall)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.x2$f(runnable, str)).create(), runnable, true);
            return;
        }
        android.ext.e1.d(runnable + ": 110");
        runnable.run();
    }

    static boolean t(java.lang.String str) {
        for (android.content.Intent intent : android.ext.b1.k0(str)) {
            try {
                android.ext.Tools.f0().startActivity(intent);
                return true;
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("intent fail", th);
            }
        }
        return false;
    }

    public static void u(android.ext.w wVar, boolean z) {
        java.lang.String[] strArr = {"df1e68bf2355bb69260b6efaa7fdacc1", "f63d4ea576f8d71e0963de6834e0c219", "b333d385ec3aeaaf7598031a42f99961", "f6d10cdcc825ab580f2fbb8ae2752990", "6c188a31fe500c3ada0914215e7df3b3", "4aa610afe8a9f409d98e62b4ed2ef780", "bbc0c87ac43ea5b61f59d6607a1eaf84", "70fb9cca0e11cb09250a11ba0c23b4c2", "b4d8929ffb0484d60369dd2c2e5c919d", "1517a1932503e400deef335e1d331593", "761cf7c032752696b26cd60ea3f3d74d", "1027157cbd6831cfebb80321570bb784", "8791855c8c65cb6a950f34ec0b093668", "a517cf7078e7e9b25ae975b4bdb2cc65", "b4ab3afbb70f23f600d048be0e8d49b2", "bd2173c6afb552fae3d9428756430123", "9bcf2de327544b17352830f9b004b229", "94d8ee3a7d26aa70f473e0ac8845b040", "d6683c02b361fed6c0ece0338921cf2b", "2cba6ddcf12910bc651455907da1fa00", "95760d2d26320be5d407e9823fd089ea", "db2aaa81ea92a69ae45642d0f5142c24", "6e513de086b0378f970968445a5da263", "60ee44a5be7a862f6615d5b68ca0d017", "0e41efb62a276c61f7b2253a1cb70c96", "3534ed8e94149e09012244b0053f387c", "7e146f369544a77f5bd3dcaa498a1e93", "5ff0619a03b5424a273491e365b6356a", "7abdd4c0904fe8f0a78424f971ff52f4", "4be2ea55d617fc0362440a93ae8a0bda", "25a4c4b1be1822ea6b990582e5038364", "b3ea34ef077e6fb86332e03b5321b28c", "ff748cbd537fd83894360f37ac9ccb03", "1353d43dff30877182f5d709e282d224"};
        gg_a.e eVar = new gg_a.e();
        wVar.j();
        int i = (int) (((1 * 16327.1f) - 172.1f) + 0.5f);
        java.lang.String strC0 = android.ext.Tools.C0();
        int iK = wVar.k() / 9;
        java.util.HashMap map = z ? new java.util.HashMap() : null;
        int i2 = 0;
        while (true) {
            try {                if (android.ext.GgNoop.never) {
                        throw new java.io.IOException();
                    }

                int iF = wVar.f();
                if (iF < 0 || iF > 1024) {
                    android.ext.e1.l("Bad pkg length: " + iF, new java.lang.RuntimeException());
                    break;
                }
                if (iF == 0) {
                    break;
                }
                int iF2 = wVar.f();
                int iF3 = wVar.f();
                java.lang.String strI = wVar.i(iF, null);
                java.lang.String strI2 = wVar.i(wVar.e(), null);
                if (z) {
                    map.put(strI, java.lang.Integer.valueOf(iF3));
                }
                if (!strC0.equals(strI)) {
                    if (iF2 <= 0) {
                        if (strI.equals(android.ext.i.f1000b)) {
                            eVar.put((iK * i) + 1, new android.ext.x2$h(strI, iF2, strI2));
                        }
                        java.lang.String strJ = j(strI);
                        for (int i3 = 33; i3 >= 0; i3--) {
                            if (strArr[i3].equalsIgnoreCase(strJ)) {
                                eVar.put((35 - i3) + (iK * i), new android.ext.x2$h(strI, iF2, strI2));
                                break;
                            }
                        }
                    } else if (iF2 <= i) {
                        eVar.put(((i - iF2) * iK) + i2, new android.ext.x2$h(strI, iF2, strI2));
                        i2++;
                    }
                }
            } catch (java.io.IOException e2) {
                android.ext.e1.l("???", e2);
                java.lang.String str = eVar.size() == 0 ? "Un: what?" : "Un: drain owns recovery";
                android.ext.e1.d(str);
                return;
            }
        }
        if (z) {
            android.ext.z1.j = map;
        }
        boolean z2 = !h();
        android.ext.e1.d("Un: copy " + eVar.size());
        boolean zC = c(eVar);
        if (android.ext.s1.u()) {
            java.lang.String strF = f(eVar);
            if (zC) {
                android.ext.e1.d("Un: defer restart");
                android.ext.s1.v(1, strF);
                return;
            } else {
                android.ext.e1.d("Un: defer show");
                android.ext.s1.v(2, strF);
                return;
            }
        }
        if (android.ext.s1.n()) {
            android.ext.e1.d("Un: drain owns recovery");
            return;
        }
        if (zC) {
            android.ext.e1.d("Un: restart?");
            l(eVar);
        } else {
            android.ext.e1.d("Un: show");
            q(eVar);
        }
        if (z2 && h()) {
            android.ext.e1.d("Un: faq");
            android.ext.f1.q(android.ext.Tools.f0());
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {
    public static void a() {
        int i;
        java.lang.String strK0 = android.ext.Tools.K0();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("GG_");
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        sb.append(str);
        sb.append("_API_");
        int i2 = android.os.Build.VERSION.SDK_INT;
        sb.append(i2);
        sb.append(".log");
        java.lang.String absolutePath = new java.io.File(strK0, sb.toString()).getAbsolutePath();
        try {
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(absolutePath, false));
            bufferedWriter.write(new java.util.GregorianCalendar().getTime().toString());
            bufferedWriter.write("\n");
            bufferedWriter.write("Release: ");
            bufferedWriter.write(str);
            bufferedWriter.write("\n");
            bufferedWriter.write("SDK: ");
            bufferedWriter.write("" + i2);
            bufferedWriter.write("\n");
            try {
                java.lang.Process processR = android.ext.e2.r(android.ext.Tools.removeNewLinesChars("hfkr#%olvw=%>#ov#0o#2surf2>#iru#l#lq#2surf2->#gr#hfkr#%fdw#'l2pdsv=%>#fdw#'l2pdsv>#grqh>#h{lw>"), null, true);
                if (processR == null) {
                    bufferedWriter.write(android.ext.e2.f745a);
                } else {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processR.getInputStream()));
                    while (true) {
                        java.lang.String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        bufferedWriter.write(line);
                        bufferedWriter.write("\n");
                    }
                    bufferedReader.close();
                }
                android.ext.e2.f745a = "";
                bufferedWriter.write("current pid: ");
                android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
                bufferedWriter.write(z1_d != null ? "" + z1_d.f1437f : "0");
                bufferedWriter.write("\n");
                bufferedWriter.write("search results:\n");
                gg_d.a aVar = android.ext.MainService.instance.s0;
                android.ext.c cVar = new android.ext.c();
                synchronized (aVar) {
                    try {
                        int i3 = aVar.i();
                        for (int i4 = 0; i4 < i3; i4++) {
                            aVar.f(i4, cVar);
                            bufferedWriter.write(android.ext.t2.e(8, cVar.f672a) + ' ' + cVar.J() + ' ' + ((java.lang.Object) cVar.u()) + " (" + java.lang.Integer.toBinaryString(cVar.f674c) + ")\n");
                        }
                    } catch (java.lang.Throwable th_c_c_c) {
                        throw th_c_c_c;
                    }
                }
                bufferedWriter.write("saved list:\n");
                gg_d.e eVarF = android.ext.MainService.instance.t0.f();
                for (int i5 = 0; i5 < eVarF.l(); i5++) {
                    android.ext.h2 h2Var = (android.ext.h2) eVarF.n(i5);
                    if (h2Var != null) {
                        bufferedWriter.write(android.ext.t2.e(8, h2Var.f672a) + ' ' + h2Var.J() + ' ' + ((java.lang.Object) h2Var.u()) + " (" + java.lang.Integer.toBinaryString(h2Var.f674c) + ")\n");
                    }
                }
            } catch (java.lang.Exception e2) {
                bufferedWriter.write(e2.getMessage());
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            i = catch_.me_.if_.you_.can_.R.string.log_saved;
        } catch (java.lang.Exception e3) {
            android.ext.e1.l("Error opening file to save: " + absolutePath, e3);
            i = catch_.me_.if_.you_.can_.R.string.failed_save;
        }
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.region_log)).setMessage(android.ext.Tools.L1(android.ext.b2.f(i), absolutePath)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
    }

    public static java.lang.String b() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(" Android(");
        java.lang.Class[] clsArr = {android.os.Build.VERSION.class, android.os.Build.class};
        for (int i = 0; i < 2; i++) {
            for (java.lang.reflect.Field field : clsArr[i].getFields()) {
                try {
                    int modifiers = field.getModifiers();
                    if (java.lang.reflect.Modifier.isPublic(modifiers) && java.lang.reflect.Modifier.isStatic(modifiers)) {
                        sb.append(field.getName());
                        sb.append(": ");
                        try {
                            java.lang.Object obj = field.get(null);
                            if (obj instanceof java.lang.Object[]) {
                                sb.append(java.util.Arrays.toString((java.lang.Object[]) obj));
                            } else {
                                sb.append(obj);
                            }
                        } catch (java.lang.Throwable th) {
                            sb.append(th.getMessage());
                        }
                        sb.append("; ");
                    }
                } catch (java.lang.Throwable th2) {
                    sb.append(th2.getMessage());
                }
            }
        }
        sb.append(')');
        return sb.toString();
    }

    public static java.lang.String c() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        float f2 = 1;
        sb.append((103.5f * f2) - 2.1f);
        sb.append(" (");
        sb.append((int) (((f2 * 16372.7f) - 217.7f) + 0.5f));
        sb.append(") ");
        sb.append(android.ext.b1.X());
        sb.append(" on ");
        sb.append(b());
        return sb.toString();
    }

    public static int d() {
        return e("" + ((1 * 112.8f) - 11.4f));
    }

    public static int e(java.lang.String str) {
        java.lang.String[] strArrSplit = str.replaceAll("[^\\d.]", "").split("\\.", -1);
        int i = 0;
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            try {
                i = (i * 100) + java.lang.Integer.parseInt(strArrSplit[i2]);
            } catch (java.lang.NumberFormatException e2) {
                android.ext.e1.s("bad part of version: " + strArrSplit[i2] + '(' + str + ')', e2);
            }
        }
        return i;
    }

    public static java.lang.String f(boolean z) {
        return g(z, 0);
    }

    private static java.lang.String g(boolean z, int i) {
        java.lang.StringBuilder sb;
        int i2;
        java.lang.String line;
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        try {
            try {
                java.lang.String strRemoveNewLinesChars = android.ext.Tools.removeNewLinesChars("h{hf#orjfdw#0g#");
                if (z) {
                    sb = new java.lang.StringBuilder();
                    sb.append(strRemoveNewLinesChars);
                    sb.append("-v threadtime ");
                } else {
                    sb = new java.lang.StringBuilder();
                    sb.append(strRemoveNewLinesChars);
                    sb.append("-v brief ");
                }
                java.lang.Process processR = android.ext.e2.r(sb.toString(), null, true);
                if (processR == null) {
                    sb2.append(android.ext.e2.f745a);
                } else {
                    java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processR.getInputStream()));
                    java.lang.String[] strArr = i > 0 ? new java.lang.String[i] : null;
                    loop0: while (true) {
                        i2 = 0;
                        while (true) {
                            if (java.lang.Thread.interrupted() || (line = bufferedReader.readLine()) == null) {
                                break loop0;
                            }
                            boolean zContains = line.contains("AndroidService");
                            if (!zContains && line.contains("android-daemon")) {
                                zContains = true;
                            }
                            if (!zContains && line.contains("AndroidRuntime")) {
                                zContains = true;
                            }
                            if (!zContains && line.contains("libc")) {
                                zContains = true;
                            }
                            if (!zContains && line.contains("Vold")) {
                                zContains = true;
                            }
                            if (!zContains && line.contains("DEBUG")) {
                                zContains = true;
                            }
                            if (!zContains && line.contains("CRASH")) {
                                zContains = true;
                            }
                            if (!zContains && line.contains("*** *** *** *** *** *** ***")) {
                                zContains = true;
                            }
                            if (!zContains && line.contains(android.ext.Tools.C0())) {
                                zContains = true;
                            }
                            if (!zContains && line.contains("--- beginning of ")) {
                                zContains = true;
                            }
                            int iMyPid = android.os.Process.myPid();
                            if (!zContains && iMyPid > 0 && line.contains(java.lang.Integer.toString(iMyPid))) {
                                zContains = true;
                            }
                            int iJ = android.ext.MainService.instance.i.J();
                            if (!zContains && iJ > 0 && line.contains(java.lang.Integer.toString(iJ))) {
                                zContains = true;
                            }
                            int iB0 = android.ext.MainService.instance.i.b0();
                            if ((!zContains && iB0 > 0 && line.contains(java.lang.Integer.toString(iB0))) || zContains) {
                                if (strArr != null) {
                                    int i3 = i2 + 1;
                                    strArr[i2] = line;
                                    if (i3 >= i) {
                                        break;
                                    }
                                    i2 = i3;
                                } else {
                                    sb2.append(line);
                                    sb2.append('\n');
                                }
                            }
                        }
                    }
                    if (strArr != null) {
                        int i4 = i2;
                        while (!java.lang.Thread.interrupted()) {
                            int i5 = i4 + 1;
                            java.lang.String str = strArr[i4];
                            if (str != null) {
                                sb2.append(str);
                                sb2.append('\n');
                            }
                            i4 = i5 >= i ? 0 : i5;
                            if (i4 == i2) {
                                break;
                            }
                        }
                    }
                }
            } catch (java.lang.OutOfMemoryError unused) {
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("OutOfMemoryError\n");
                sb2 = sb3;
            }
        } catch (java.lang.OutOfMemoryError unused2) {
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append(g(z, 500));
            sb2 = sb4;
        } catch (java.lang.Throwable th) {
            sb2.append(th.getMessage());
            sb2.append('\n');
            android.ext.e1.g("getLogcat fail.", th);
        }
        android.ext.e2.f745a = "";
        try {
            return sb2.toString();
        } catch (java.lang.OutOfMemoryError unused3) {
            return "OutOfMemoryError\n";
        }
    }

    public static void h() {
        android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.collect_data_to_region_log);
        new android.ext.h0$a("runCollectRegionLog").start();
    }

    public static void i() {
        new android.ext.h0$b("showInfo").start();
    }
}

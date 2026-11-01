package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.content.Context f1198a = android.ext.r.n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.lang.StringBuilder f1199b = new java.lang.StringBuilder();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1200c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private java.util.Map f1201d;

    public q1() {
        java.util.HashMap map = new java.util.HashMap();
        this.f1201d = map;
        map.put("android.permission.SYSTEM_ALERT_WINDOW", 24);
    }

    private int a() {
        return 134217728;
    }

    private int c(int i) {
        try {
            android.content.pm.ApplicationInfo applicationInfo = this.f1198a.getApplicationInfo();
            android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) this.f1198a.getSystemService("appops");
            java.lang.Class cls = java.lang.Integer.TYPE;
            return ((java.lang.Integer) android.app.AppOpsManager.class.getMethod("checkOp", cls, cls, java.lang.String.class).invoke(appOpsManager, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(applicationInfo.uid), applicationInfo.packageName)).intValue();
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("MIUI-checkOp(" + i + ") failed", th);
            this.f1199b.append("\nMIUI-checkOp(" + i + ") failed:\n");
            this.f1199b.append(android.ext.e1.n(th));
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006c  */
    private boolean d(java.lang.String str) {
        this.f1199b.append("\nMIUI-checkPermission ");
        this.f1199b.append(str);
        this.f1199b.append(" - ");
        java.lang.Integer num = (java.lang.Integer) this.f1201d.get(str);
        boolean z = true;
        if (num == null) {
            this.f1199b.append("unknown - ");
        } else if (num.intValue() == 24 && this.f1200c == 5) {
            int iA = a();
            if ((this.f1198a.getApplicationInfo().flags & iA) != iA) {
                z = false;
            }
        } else {
            try {
                if (c(num.intValue()) != 0) {
                    z = false;
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.g("MIUI-checkPermission failed", th);
                this.f1199b.append("failed:\n");
                this.f1199b.append(android.ext.e1.n(th));
                this.f1199b.append('\n');
            }
        }
        this.f1199b.append(z);
        return z;
    }

    private void e() {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(android.ext.Tools.I(new java.lang.String[]{"getprop"}).getInputStream()));
            this.f1199b.append("\ngetprop:\n");
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line != null) {
                    if (line.contains("ro.product.device") && line.contains("_sprout")) {
                        this.f1200c = -1;
                        break;
                    }
                    if (!line.contains("fpc.fp.miui.") && !line.contains("ro.ril.miui.imei")) {
                        if (line.contains("miui") || line.contains("MIUI")) {
                            android.ext.e1.d("MIUI found: " + line);
                            this.f1199b.append(line);
                            this.f1199b.append('\n');
                            if (this.f1200c == -1) {
                                this.f1200c = 0;
                            }
                        }
                        if (line.contains("ro.miui.ui.version.name")) {
                            if (line.contains("V5")) {
                                this.f1200c = 5;
                            }
                            if (line.contains("V6")) {
                                this.f1200c = 6;
                            }
                        }
                    }
                } else {
                    break;
                }
            }
            bufferedReader.close();
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("MIUI-detect", th);
            this.f1199b.append("\nMIUI-detect failed:\n");
            this.f1199b.append(android.ext.e1.n(th));
        }
    }

    private void f(java.lang.String str) {
        this.f1199b.append("\nMIUI-fixPermission ");
        this.f1199b.append(str);
        this.f1199b.append(" - ");
        java.lang.Integer num = (java.lang.Integer) this.f1201d.get(str);
        if (num == null) {
            this.f1199b.append("unknown");
            return;
        }
        if (num.intValue() == 24 && this.f1200c == 5) {
            try {
                android.ext.Tools.B0().setApplicationEnabledSetting(android.ext.Tools.C0(), 134217728, a());
                this.f1199b.append("success 1");
            } catch (java.lang.Throwable th) {
                android.ext.e1.g("MIUI-fixPermission failed", th);
                this.f1199b.append("failed 1:\n");
                this.f1199b.append(android.ext.e1.n(th));
                this.f1199b.append('\n');
            }
        }
        try {
            android.content.pm.ApplicationInfo applicationInfo = this.f1198a.getApplicationInfo();
            java.lang.Class cls = java.lang.Integer.TYPE;
            android.app.AppOpsManager.class.getMethod("setMode", cls, cls, java.lang.String.class, cls).invoke((android.app.AppOpsManager) this.f1198a.getSystemService("appops"), num, java.lang.Integer.valueOf(applicationInfo.uid), applicationInfo.packageName, 0);
            this.f1199b.append("success 2");
        } catch (java.lang.Throwable th2) {
            android.ext.e1.g("MIUI-fixPermission failed", th2);
            this.f1199b.append("failed 2:\n");
            this.f1199b.append(android.ext.e1.n(th2));
            this.f1199b.append('\n');
        }
    }

    private void i() {
        java.lang.String string = this.f1199b.toString();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        this.f1199b = sb;
        sb.append("MIUI\nGG: ");
        float f2 = 1;
        this.f1199b.append((117.200005f * f2) - 15.8f);
        this.f1199b.append(" [");
        this.f1199b.append((int) (((f2 * 17130.1f) - 975.1f) + 0.5f));
        this.f1199b.append("]\nAndroid: ");
        this.f1199b.append(android.os.Build.VERSION.RELEASE);
        this.f1199b.append("\nSDK: ");
        this.f1199b.append(android.os.Build.VERSION.SDK_INT);
        this.f1199b.append("\nappInfo.flags: ");
        this.f1199b.append("0x" + android.ext.t2.e(8, this.f1198a.getApplicationInfo().flags));
        this.f1199b.append("\ncheckOp(OP_SYSTEM_ALERT_WINDOW): ");
        this.f1199b.append(c(24));
        this.f1199b.append(string);
        for (java.lang.String str : this.f1199b.toString().split("[\\r\\n]+")) {
            android.ext.e1.d(str);
        }
    }

    public void b() {
        try {
            e();
            if (this.f1200c == -1 || (android.ext.Config.f30c & 2) != 0) {
                return;
            }
            if (!d("android.permission.SYSTEM_ALERT_WINDOW")) {
                f("android.permission.SYSTEM_ALERT_WINDOW");
                android.app.AlertDialog.Builder neutralButton = android.ext.f.c(this.f1198a).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.skip), android.ext.f1.w(2L));
                if (d("android.permission.SYSTEM_ALERT_WINDOW")) {
                    neutralButton.setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.miui_restart)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart), new android.ext.p0(1200, true)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null);
                } else {
                    android.ext.z.H(neutralButton);
                    neutralButton.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.q1$b(this));
                }
                android.ext.n2.i(new android.ext.q1$c(this, neutralButton));
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("MIUI-check", th);
            this.f1199b.append("\nMIUI-check failed:\n");
            this.f1199b.append(android.ext.e1.n(th));
        }
        i();
    }

    java.lang.String g() {
        return this.f1200c != 6 ? "kwws=22zzz1|rxwxeh1frp2zdwfkBy@3[{m:N}:ZmT" : "kwws=22zzz1|rxwxeh1frp2zdwfkBy@k]ifLW:7SV;";
    }

    public void h() {
        new android.ext.g0(new android.ext.q1$a(this), "runCheck").start();
    }
}

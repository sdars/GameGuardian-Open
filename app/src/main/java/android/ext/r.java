package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class r extends gg_a.a implements android.view.View.OnClickListener {
    public static volatile boolean k = false;
    public static volatile boolean l = true;
    public static volatile boolean m = false;
    public static volatile android.ext.r n = null;
    public static volatile android.content.Context o = null;
    public static volatile android.content.Context p = null;
    public static volatile boolean q = true;
    private static volatile boolean r;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f1206d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f1207e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    java.lang.ref.WeakReference f1208f = new java.lang.ref.WeakReference(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private java.lang.ref.WeakReference f1209g = new java.lang.ref.WeakReference(null);
    private java.lang.ref.WeakReference h = new java.lang.ref.WeakReference(null);
    private java.lang.StringBuilder i = new java.lang.StringBuilder();
    java.lang.Runnable j;

    static {
        android.ext.e1.d("BaseActivity clinit");
        android.ext.i.a();
        android.ext.n0.f();
        r = false;
    }

    public r() {
        boolean z = this instanceof catch_.me_.if_.you_.can_.MainActivity;
        if (z || n == null) {
            n = this;
        }
        if (z || p == null) {
            p = this;
        }
        l = true ^ z;
        android.ext.e1.d("BaseActivity init: " + this);
        android.ext.n0.f();
    }

    private void A() {
        android.widget.TextView textView = (android.widget.TextView) this.f1209g.get();
        if (textView == null) {
            return;
        }
        java.lang.CharSequence charSequence = (java.lang.CharSequence) this.h.get();
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        java.lang.String str = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.download) + android.ext.Tools.removeNewLinesChars("#kwws=22jdphjxdugldq1qhw2grzqordg") + "\n\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.front_text) + "\n\n";
        java.lang.String strG = android.ext.b2.g("     32. __help_faq_32_q__\r\n        __help_faq_32_b__\r\n\r\n__rtfm__");
        android.ext.Tools.v1(textView, str + strG + ("\n\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_front)));
        android.ext.Tools.u(textView.getText());
        android.ext.Tools.v(textView.getText(), strG, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.alert));
        this.h = new java.lang.ref.WeakReference(textView.getText());
    }

    void E(android.os.Bundle bundle, int i) {
        if (i == 1) {
            new android.ext.g2().putInt("root-ok", (int) (((1 * 23979.6f) - 7824.6f) + 0.5f)).commit();
        }
        D(bundle, i != -1);
    }

    boolean G() {
        return (this != n || isFinishing() || isDestroyed()) ? false : true;
    }

    static void H() {
        android.ext.f.o(android.ext.f.c(p).setMessage(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record_logcat_info), v())).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.r$h()).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
    }

    public static void I() {
        try {
            android.ext.f1.f953c = 2;
            android.ext.f1.o();
        } catch (java.lang.Throwable th) {
            throw new java.lang.RuntimeException("Failed restart", th);
        }
    }

    public static void J(android.content.Context context, long j) {
        if (context == null) {
            return;
        }
        try {
            android.ext.Tools.w1(200, new android.content.ComponentName(android.ext.Tools.C0(), t()), 1);
            android.app.PendingIntent activity = android.app.PendingIntent.getActivity(context, 123456, android.ext.Tools.N0(context, android.ext.Tools.C0(), t()), 268435456);
            android.app.AlarmManager alarmManager = (android.app.AlarmManager) context.getSystemService("alarm");
            if (alarmManager != null) {
                alarmManager.set(1, java.lang.System.currentTimeMillis() + j, activity);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public static void K(android.os.Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("reminst")) {
            android.ext.e1.d("removeInstaller: from bundle");
            m = true;
        }
        if (bundle.containsKey("hw")) {
            l = bundle.getBoolean("hw");
        }
        if (bundle.containsKey("uid")) {
            int i = bundle.getInt("uid");
            int iMyUid = android.os.Process.myUid();
            if (!bundle.getBoolean("vspace") || iMyUid == i) {
                return;
            }
            android.ext.e1.d("Kill by diff uids: " + iMyUid + " != " + i);
            android.ext.f1.n();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x005e  */
    /* JADX WARN: Code duplicated, block: B:22:0x00a1  */
    private void N(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.StringBuilder sb = this.i;
        if (str.startsWith("/mnt/expand/")) {
            str = str.replace("/mnt/expand/" + str.split("/", -1)[3], "/data");
            r = true;
            sb.append("1\n");
        }
        if (str.startsWith("/data/data/")) {
            str2 = str.split("/", -1)[3];
            str3 = "2\n";
        } else if (str.startsWith("/data/user/")) {
            str2 = str.split("/", -1)[4];
            str3 = "3\n";
        } else {
            str2 = null;
            str3 = null;
        }
        if (str3 != null) {
            sb.append(str3);
        }
        android.ext.Config.F = "";
        if (str2 != null) {
            sb.append(str2);
            sb.append("\n4\n");
            android.ext.Config.C = !str2.startsWith(android.ext.i.f1002d);
            android.ext.Config.E = str2;
            android.ext.Config.D = str2.contains("vmos");
            try {
                android.ext.Config.F = android.ext.Tools.a0(android.ext.Tools.Y(str2));
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed get vSpace name for " + str2, th);
            }
        }
        if (android.ext.Config.F.length() == 0) {
            android.ext.Config.F = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.virtual_space);
        }
        sb.append(android.ext.Config.C);
        sb.append('\n');
    }

    static void O() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        q(sb, 1);
        try {
            sb.append(n.getFilesDir());
        } catch (java.lang.Throwable th) {
            sb.append(th);
        }
        q(sb, 2);
        int iMyUid = android.os.Process.myUid();
        try {
            sb.append(iMyUid);
        } catch (java.lang.Throwable th2) {
            sb.append(th2);
        }
        q(sb, 3);
        try {
            sb.append(java.util.Arrays.toString(n.getPackageManager().getPackagesForUid(iMyUid)));
        } catch (java.lang.Throwable th3) {
            sb.append(th3);
        }
        q(sb, 4);
        try {
            sb.append(java.util.Arrays.toString(n.getPackageManager().getPackageGids(n.getPackageName())));
        } catch (java.lang.Throwable th4) {
            sb.append(th4);
        }
        q(sb, 5);
        try {
            sb.append(n.getPackageManager().getPackageUid(n.getPackageName(), 0));
        } catch (java.lang.Throwable th5) {
            sb.append(th5);
        }
        q(sb, 6);
        try {
            sb.append(n.checkCallingOrSelfPermission(android.ext.Tools.removeNewLinesChars("dqgurlg1shuplvvlrq1UHDGbVPV")));
        } catch (java.lang.Throwable th6) {
            sb.append(th6);
        }
        sb.append(' ');
        sb.append(android.ext.Tools.M0().getInt("odd-vspace", 0));
        q(sb, 7);
        try {
            sb.append(android.os.Build.VERSION.SDK_INT);
        } catch (java.lang.Throwable th7) {
            sb.append(th7);
        }
        q(sb, 8);
        try {
            java.lang.String str = android.ext.Tools.f489a.nextInt() + ".txt";
            java.io.File file = new java.io.File(n.getFilesDir(), str);
            try {
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                fileOutputStream.write(new byte[4096]);
                fileOutputStream.flush();
                java.io.File file2 = new java.io.File("/proc/self/fd/" + android.lang.a.a(fileOutputStream.getFD()));
                sb.append(file2.getPath());
                sb.append(" -> ");
                sb.append(file2.getCanonicalPath());
                try {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                    java.nio.MappedByteBuffer map = fileInputStream.getChannel().map(java.nio.channels.FileChannel.MapMode.READ_ONLY, 0L, 4096L);
                    l(sb, str);
                    map.capacity();
                    fileInputStream.close();
                } catch (java.lang.Throwable th8) {
                    sb.append('\n');
                    sb.append(th8);
                }
                sb.append("\nN: '");
                sb.append(android.ext.Tools.y0(file.getAbsolutePath()));
                sb.append('\'');
                fileOutputStream.close();
                file.delete();
            } catch (java.lang.Throwable th9_c_c_c) {
                file.delete();
                throw th9_c_c_c;
            }
        } catch (java.lang.Throwable th10) {
            sb.append(th10);
        }
        q(sb, 9);
        try {
            l(sb, n.getPackageName());
        } catch (java.lang.Throwable th11) {
            sb.append(th11);
        }
        q(sb, 10);
        try {
            sb.append(android.ext.ConfigListAdapter.k());
        } catch (java.lang.Throwable th12) {
            sb.append(th12);
        }
        q(sb, 11);
        try {
            java.io.File file3 = new java.io.File("/proc/self/exe");
            sb.append(file3.getPath());
            sb.append(" -> ");
            sb.append(file3.getCanonicalPath());
        } catch (java.lang.Throwable th13) {
            sb.append(th13);
        }
        q(sb, 12);
        try {
            sb.append(android.os.Process.myPid());
        } catch (java.lang.Throwable th14) {
            sb.append(th14);
        }
        q(sb, 13);
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream("/proc/self/status");
            byte[] bArr = new byte[65536];
            int i = fileInputStream2.read(bArr);
            sb.append(i);
            sb.append(" -> ");
            if (i > 0) {
                sb.append(new java.lang.String(bArr, 0, i));
            }
            fileInputStream2.close();
        } catch (java.lang.Throwable th15) {
            sb.append(th15);
        }
        android.ext.e1.d("FIN");
        android.ext.Tools.h(sb.toString().trim(), 0);
    }

    private android.app.AlertDialog P(android.content.Context context) {
        android.app.AlertDialog.Builder customTitle = android.ext.f.c(context).setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.fix_it));
        java.lang.String[] strArr = new java.lang.String[15];
        strArr[0] = android.ext.b2.f(android.ext.m2.f1074a ? catch_.me_.if_.you_.can_.R.string.disable_floating_windows : catch_.me_.if_.you_.can_.R.string.enable_floating_windows);
        strArr[1] = android.ext.b2.f((android.ext.Config.A & 4) != 0 ? catch_.me_.if_.you_.can_.R.string.work_without_selinux : catch_.me_.if_.you_.can_.R.string.work_with_selinux);
        strArr[2] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.change_float_type);
        strArr[3] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reset_float_type);
        strArr[4] = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_use_notification).toString();
        strArr[5] = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_hot_key).toString();
        strArr[6] = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_context_source).toString();
        strArr[7] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reset_ignore);
        strArr[8] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.su_command);
        strArr[9] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record_logcat);
        strArr[10] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.show_debug_info);
        strArr[11] = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_prevent_unload).toString();
        strArr[12] = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_acceleration).toString();
        strArr[13] = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_vspace_root).toString();
        strArr[14] = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_number_locale).toString();
        return customTitle.setItems(strArr, new android.ext.r$e(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
    }

    private void R(android.os.Bundle bundle) {
        android.ext.e2.i(new android.ext.r$m(this, bundle));
    }

    private static void S() {
        android.ext.n2.d().post(new android.ext.r$d());
    }

    static void U(java.io.OutputStream outputStream, java.lang.String str, java.lang.String str2) {
        try {
            outputStream.write(("\n\n" + new java.util.GregorianCalendar().getTime().toString() + '\n' + str + '\n' + android.ext.h0.c() + '\n' + android.ext.f1.x() + '\n' + android.ext.Tools.f0().getFilesDir().getAbsolutePath() + '\n' + str2 + "\n\n").getBytes());
            outputStream.flush();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Fail write logcat header", th);
        }
    }

    private static void i(android.content.Context context) {
        try {
            context.getSharedPreferences(android.ext.MainService.G0, 0).edit().putBoolean("perm-restart", true).commit();
            J(context, 3000L);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    static void j() {
        android.app.AlarmManager alarmManager;
        try {
            if (android.ext.Tools.M0().contains("perm-restart")) {
                android.ext.e1.d("cancelPermissionRestart");
                android.ext.Tools.M0().edit().remove("perm-restart").commit();
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        try {
            android.content.Context contextF0 = android.ext.Tools.f0();
            if (contextF0 == null || (alarmManager = (android.app.AlarmManager) contextF0.getSystemService("alarm")) == null) {
                return;
            }
            alarmManager.cancel(android.app.PendingIntent.getActivity(contextF0, 123456, android.ext.Tools.N0(contextF0, android.ext.Tools.C0(), t()), 268435456));
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
    }

    static void k() {
        if (r) {
            android.ext.f.o(android.ext.f.c(p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.mnt_expand)).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fix_it), new android.ext.r$c()));
        }
    }

    private static void l(java.lang.StringBuilder sb, java.lang.String str) throws java.io.IOException {
        java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader("/proc/self/maps"));
        while (true) {
            java.lang.String line = bufferedReader.readLine();
            if (line == null) {
                bufferedReader.close();
                return;
            }
            int iIndexOf = line.indexOf(str);
            if (iIndexOf >= 0) {
                int i = iIndexOf;
                while (i > 0 && line.charAt(i) > ' ') {
                    i--;
                }
                if (i < iIndexOf) {
                    sb.append("\n'");
                    sb.append(line.substring(i, line.length()).trim());
                    sb.append('\'');
                }
            }
        }
    }

    private void n() {
        android.widget.TextView textView = (android.widget.TextView) this.f1209g.get();
        if (textView != null) {
            textView.setText("");
        }
        y(false);
    }

    static boolean o(android.content.Context context) {
        try {
            android.content.SharedPreferences sharedPreferences = context.getSharedPreferences(android.ext.MainService.G0, 0);
            if (!sharedPreferences.getBoolean("perm-restart", false)) {
                return false;
            }
            sharedPreferences.edit().remove("perm-restart").commit();
            android.ext.e1.d("consumePermissionRestart");
            return true;
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    private static void q(java.lang.StringBuilder sb, int i) {
        android.ext.e1.d("START: " + i);
        sb.append('\n');
        sb.append(i);
        sb.append(": ");
    }

    private void r() {
        java.lang.StringBuilder sb = this.i;
        try {
            java.io.File filesDir = getFilesDir();
            java.lang.String absolutePath = filesDir.getAbsolutePath();
            sb.append(absolutePath);
            sb.append('\n');
            java.lang.String str = android.ext.i.f1002d;
            sb.append(str);
            sb.append('\n');
            N(absolutePath);
            if (!android.ext.Config.C && (n.checkCallingOrSelfPermission(android.ext.Tools.removeNewLinesChars("dqgurlg1shuplvvlrq1UHDGbVPV")) == 0 || !new java.io.File("/proc/self/exe").getCanonicalPath().startsWith("/system/"))) {
                sb.append("? ");
                java.lang.String str2 = android.ext.Tools.f489a.nextInt() + ".txt";
                java.io.File file = new java.io.File(filesDir, str2);
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file);
                fileOutputStream.write(new byte[4096]);
                fileOutputStream.flush();
                fileOutputStream.close();
                java.lang.String strReplace = android.ext.Tools.y0(file.getAbsolutePath()).replace('/' + str2, "");
                file.delete();
                sb.append(strReplace);
                sb.append('\n');
                N(strReplace);
                if (android.ext.Config.C) {
                    java.lang.String str3 = '/' + filesDir.getName();
                    java.lang.String strReplace2 = strReplace.replace(str3, "");
                    java.lang.String strReplace3 = absolutePath.replace(str3, "");
                    java.lang.String str4 = "F2R: [" + strReplace2.length() + "] " + strReplace3 + " -> " + strReplace2;
                    android.ext.e1.p(str4);
                    sb.append(str4);
                    sb.append('\n');
                    android.ext.Tools.v = new java.lang.String[]{strReplace3, strReplace2};
                } else {
                    java.lang.String str5 = "Odd vSpace: " + absolutePath + "; " + strReplace;
                    android.ext.e1.p(str5);
                    sb.append(str5);
                    sb.append('\n');
                    int i = android.ext.Tools.M0().getInt("odd-vspace", 0);
                    sb.append(i);
                    sb.append('\n');
                    if (i == 1) {
                        android.ext.Config.C = true;
                    } else if (i == 0) {
                        android.ext.r$j r_j = new android.ext.r$j(this);
                        android.ext.f.o(android.ext.f.c(p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.odd_vspace)).setCancelable(false).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), r_j).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), r_j));
                    }
                }
            }
            java.lang.String str6 = "Files: " + absolutePath + ' ' + str;
            android.ext.e1.d(str6);
            sb.append(str6);
            sb.append('\n');
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            sb.append(th.toString());
            sb.append('\n');
        }
        android.ext.Config.vSpaceReal = android.ext.Config.C;
        if (!android.ext.Config.C || (android.ext.Config.B & 512) == 0) {
            return;
        }
        android.ext.Config.C = false;
    }

    private static void s() {
        try {
            java.lang.reflect.Field declaredField = android.animation.ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(null);
            if ((obj instanceof java.lang.Float) && java.lang.Float.valueOf(0.0f).equals(obj)) {
                declaredField.set(null, java.lang.Float.valueOf(1.0f));
                android.ext.e1.d("Fix sDurationScale");
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("failed fix sDurationScale", th);
        }
    }

    public static java.lang.String t() {
        return (l ? catch_.me_.if_.you_.can_.ActivityMain.class : catch_.me_.if_.you_.can_.MainActivity.class).getName();
    }

    public static android.os.Bundle u() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putBoolean("hw", l);
        bundle.putInt("uid", android.os.Process.myUid());
        bundle.putBoolean("vspace", android.ext.Config.C);
        if (m) {
            android.ext.e1.d("removeInstaller: to bundle");
            bundle.putBoolean("reminst", true);
        }
        return bundle;
    }

    static java.lang.String v() {
        java.lang.String str;
        java.lang.String strK0 = android.ext.Tools.K0();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("GG_logcat_");
        if (android.ext.Config.C) {
            str = "v";
        } else {
            str = android.ext.Config.vSpaceReal ? "R" : "r";
        }
        sb.append(str);
        float f2 = 1;
        sb.append((115.700005f * f2) - 14.3f);
        sb.append('_');
        sb.append((int) (((f2 * 16480.3f) - 325.3f) + 0.5f));
        sb.append('_');
        sb.append(android.os.Build.VERSION.RELEASE);
        sb.append('_');
        sb.append(android.os.Build.VERSION.SDK_INT);
        sb.append(".log");
        return new java.io.File(strK0, sb.toString()).getAbsolutePath();
    }

    private java.lang.String w() {
        java.lang.StringBuilder sb = this.i;
        this.i = null;
        return sb == null ? "" : sb.toString();
    }

    private void y(boolean z) {
        android.view.View view = (android.view.View) this.f1208f.get();
        if (view == null) {
            return;
        }
        android.view.View viewFindViewById = view.findViewById(catch_.me_.if_.you_.can_.R.id.starter);
        if (!z) {
            if (viewFindViewById != null) {
                android.widget.TextView textView = (android.widget.TextView) this.f1209g.get();
                if (textView != null) {
                    android.ext.Tools.P(textView);
                    android.ext.Tools.O0(textView);
                }
                android.ext.Tools.O0(viewFindViewById);
                return;
            }
            return;
        }
        if (viewFindViewById == null) {
            ((android.view.ViewGroup) view).addView(android.ext.Tools.O0(((android.view.ViewGroup) gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.main, null)).findViewById(catch_.me_.if_.you_.can_.R.id.starter)));
        }
        android.widget.TextView textView2 = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.front_text);
        this.f1209g = new java.lang.ref.WeakReference(textView2);
        int[] iArr = {catch_.me_.if_.you_.can_.R.id.btn_stop_service, catch_.me_.if_.you_.can_.R.id.btn_start_usage, catch_.me_.if_.you_.can_.R.id.check, catch_.me_.if_.you_.can_.R.id.fix_it, catch_.me_.if_.you_.can_.R.id.language, catch_.me_.if_.you_.can_.R.id.help};
        for (int i = 0; i < 6; i++) {
            android.view.View viewFindViewById2 = view.findViewById(iArr[i]);
            if (viewFindViewById2 instanceof android.widget.TextView) {
                android.widget.TextView textView3 = (android.widget.TextView) viewFindViewById2;
                textView3.setText(android.ext.b2.g(textView3.getText().toString()));
            }
            viewFindViewById2.setOnClickListener(this);
        }
        android.ext.Tools.S(textView2);
    }

    private void z() {
        s();
        setContentView(catch_.me_.if_.you_.can_.R.layout.main);
        android.view.View viewFindViewById = findViewById(catch_.me_.if_.you_.can_.R.id.root);
        this.f1208f = new java.lang.ref.WeakReference(viewFindViewById);
        android.widget.TextView textView = (android.widget.TextView) viewFindViewById.findViewById(catch_.me_.if_.you_.can_.R.id.installing);
        textView.setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.installing));
        android.ext.b1.G = new java.lang.ref.WeakReference((android.widget.ProgressBar) viewFindViewById.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar));
        android.ext.b1.H = new java.lang.ref.WeakReference((android.widget.TextView) viewFindViewById.findViewById(catch_.me_.if_.you_.can_.R.id.progress_bar_text));
        android.ext.b1.I = new java.lang.ref.WeakReference(textView);
        android.ext.b1.E = new java.lang.ref.WeakReference((android.widget.Button) viewFindViewById.findViewById(catch_.me_.if_.you_.can_.R.id.abort_button));
        L(0);
        y(true);
    }

    void B(android.os.Bundle bundle) {
        boolean zU = android.ext.s1.u();
        android.ext.s1.d();
        if (!zU) {
            C(bundle, android.ext.s1.E());
        } else if (android.ext.s1.O() < 2) {
            this.j = new android.ext.r$l(this, bundle);
        } else {
            C(bundle, true);
        }
    }

    void C(android.os.Bundle bundle, boolean z) {
        if (z || android.ext.Config.vSpaceReal || android.ext.b1.B0() || android.ext.Tools.M0().getInt("root-ok", 0) == ((int) (((1 * 17178.5f) - 1023.5f) + 0.5f))) {
            D(bundle, true);
            return;
        }
        try {
            R(bundle);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed start root probe", th);
            D(bundle, true);
        }
    }

    void D(android.os.Bundle bundle, boolean z) {
        if (z) {
            F(bundle);
        } else {
            android.ext.r$a r_a = new android.ext.r$a(this, bundle);
            android.ext.f.r(android.ext.f.c(p).setTitle(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.work_mode)).setCancelable(false).setItems(new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.root), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no_root), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.exit)}, new android.ext.r$b(this, r_a)).create(), r_a, false);
        }
    }

    void F(android.os.Bundle bundle) {
        if (bundle != null) {
            android.os.Parcelable parcelable = bundle.getParcelable("installer-state");
            if (parcelable instanceof android.ext.b1$c0) {
                android.ext.b1.s1((android.ext.b1$c0) parcelable);
            }
        }
        if (android.ext.f1.f954d) {
            L(2);
        } else {
            android.ext.f1.K();
        }
        android.ext.s1.C();
    }

    void L(int i) {
        android.ext.n2.i(new android.ext.r$i(this, i));
    }

    public void M(boolean z) {
        boolean z2 = this.f1207e;
        this.f1207e = z;
        if (z2 == z || android.ext.MainService.instance == null) {
            return;
        }
        android.ext.MainService.instance.l1();
    }

    void Q() {
        java.lang.String strW = w();
        if (android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.record_logcat).f42d != ((int) (((1 * 16493.2f) - 338.2f) + 0.5f))) {
            return;
        }
        android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.record_logcat).f42d = 0;
        android.ext.Config.k();
        new android.ext.g0(new android.ext.r$g(this, strW), "RecordLogcat").start();
    }

    void T() {
        android.ext.Config$p config$pB = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_context_source);
        config$pB.g(new android.ext.r$f(this, config$pB));
        config$pB.b();
    }

    @Override // android.app.Activity, android.view.Window$Callback
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        try {
            return super.dispatchKeyEvent(keyEvent);
        } catch (java.lang.IllegalStateException e2) {
            android.ext.e1.a(e2);
            return false;
        }
    }

    public void m() {
        if (!android.ext.Config.vSpaceReal) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            try {
                sb.append("INTERNET: 0~");
                sb.append(android.ext.Config.vSpaceReal ? '$' : '#');
                sb.append(";1~");
                android.content.Context contextF0 = android.ext.Tools.f0();
                int iCheckPermission = contextF0.checkPermission("android.permission.INTERNET", android.os.Process.myPid(), android.os.Process.myUid());
                sb.append(iCheckPermission);
                sb.append(";2~");
                sb.append(contextF0.checkCallingOrSelfPermission("android.permission.INTERNET"));
                sb.append(";3~");
                sb.append(contextF0.checkCallingPermission("android.permission.INTERNET"));
                android.ext.e1.d(sb.toString());
                if (iCheckPermission != 0) {
                    android.ext.n0.h(java.lang.Thread.currentThread(), new java.lang.RuntimeException(sb.toString()), false);
                }
            } catch (java.lang.Throwable th) {
                java.lang.RuntimeException runtimeException = new java.lang.RuntimeException(sb.toString(), th);
                android.ext.e1.a(runtimeException);
                android.ext.n0.h(java.lang.Thread.currentThread(), runtimeException, false);
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 23) {
            return;
        }
        try {
            android.content.Context contextF1 = android.ext.Tools.f0();
            android.content.pm.PackageInfo packageInfoA0 = android.ext.Tools.A0(android.ext.Tools.C0(), 4096);
            if (packageInfoA0 == null || packageInfoA0.requestedPermissions == null) {
                return;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            android.content.pm.PackageManager packageManagerB0 = android.ext.Tools.B0();
            for (java.lang.String str : packageInfoA0.requestedPermissions) {
                if (str != null && (contextF1.checkSelfPermission(str) != 0 || (android.ext.Config.vSpaceReal && packageManagerB0.checkPermission(str, android.ext.Config.E) != 0))) {
                    arrayList.add(str);
                }
            }
            if (arrayList.size() <= 0) {
                j();
                android.ext.s1.B();
                return;
            }
            java.lang.String[] strArr = (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
            android.ext.e1.d("requestPermissions: " + java.util.Arrays.toString(strArr));
            i(contextF1);
            android.ext.s1.y();
            requestPermissions(strArr, 0);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onActivityResult()");
        android.ext.e1.d(sb.toString());
        super.onActivityResult(i, i2, intent);
        if (this.f1206d) {
            android.ext.b1.F0(i, i2, intent);
        } else if (android.ext.s1.u()) {
            android.ext.s1.A();
        } else {
            android.ext.z.m();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (java.lang.IllegalStateException e2) {
            android.ext.e1.a(e2);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null) {
        }
        switch (view.getId()) {
            case catch_.me_.if_.you_.can_.R.id.btn_start_usage /* 2131034133 */:
                if (android.ext.m2.f1074a) {
                    try {
                        if (!moveTaskToBack(true)) {
                            finish();
                        }
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.a(th);
                    }
                }
                android.ext.MainService.instance.e1();
                break;
            case catch_.me_.if_.you_.can_.R.id.btn_stop_service /* 2131034134 */:
                android.ext.e1.d("Pushed exit");
                finish();
                new android.ext.p0(100).onClick(null, 0);
                break;
            case catch_.me_.if_.you_.can_.R.id.check /* 2131034149 */:
                new android.ext.z(this).u();
                break;
            case catch_.me_.if_.you_.can_.R.id.fix_it /* 2131034263 */:
                try {
                    P(p).show();
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.a(th2);
                    android.ext.f.m(P(android.ext.Tools.f0()));
                    return;
                }
                break;
            case catch_.me_.if_.you_.can_.R.id.help /* 2131034277 */:
                android.ext.ConfigListAdapter.s();
                break;
            case catch_.me_.if_.you_.can_.R.id.language /* 2131034304 */:
                android.ext.ConfigListAdapter.d();
                break;
        }
    }

    @Override // a.a, android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        java.lang.String str;
        super.onCreate(bundle);
        android.ext.n0.f();
        boolean z = this instanceof catch_.me_.if_.you_.can_.MainActivity;
        if (z || n == null) {
            n = this;
        }
        if (z || !(p instanceof gg_a.b)) {
            p = gg_a.b.i(this);
        }
        if (z || o == null) {
            o = gg_a.b.i(getApplicationContext());
        }
        try {
            android.fix.Button button = new android.fix.Button(this);
            button.setText("Fix it");
            button.setId(catch_.me_.if_.you_.can_.R.id.fix_it);
            button.setOnClickListener(this);
            setContentView(button);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        r();
        gg_a.c.f14a = false;
        android.ext.Tools.W0(this);
        android.view.Window window = getWindow();
        if (window != null) {
            if (l) {
                window.addFlags(16777216);
            } else {
                window.clearFlags(16777216);
            }
        }
        gg_a.b.a(p);
        android.ext.k.g();
        Q();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (android.ext.Config.C) {
            str = "$";
        } else {
            str = android.ext.Config.vSpaceReal ? "@" : "#";
        }
        sb.append(str);
        sb.append(' ');
        sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.app_name));
        sb.append(' ');
        float f2 = 1;
        sb.append((105.0f * f2) - 3.6f);
        sb.append(" (");
        sb.append((int) (((f2 * 17071.5f) - 916.5f) + 0.5f));
        sb.append(") ");
        sb.append(l ? "HW" : "SW");
        setTitle(sb.toString());
        z();
        android.ext.Tools.o();
        android.ext.r$k r_k = new android.ext.r$k(this, bundle);
        android.ext.e1.d(r_k + ": 10");
        android.ext.b1.i1(r_k);
        android.ext.e1.d(r_k + ": 20");
    }

    @Override // a.a, android.app.Activity
    public void onDestroy() {
        if (isFinishing()) {
            j();
        }
        M(false);
        n();
        super.onDestroy();
        if (!this.f1206d && q) {
            android.ext.e1.d("onDestroy(exit)");
            android.ext.f1.o();
        } else {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(this.f1206d ? "Installer: " : "");
            sb.append("onDestroy()");
            android.ext.e1.d(sb.toString());
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent$Callback
    public boolean onKeyUp(int i, android.view.KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (java.lang.IllegalStateException e2) {
            android.ext.e1.a(e2);
            return false;
        }
    }

    @Override // a.a, android.app.Activity
    public void onPause() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onPause()");
        android.ext.e1.d(sb.toString());
        M(false);
        if (!this.f1206d && android.ext.MainService.instance != null && !android.ext.s1.u() && android.ext.m2.f1074a) {
            android.ext.MainService.instance.e1();
        }
        super.onPause();
    }

    @Override // a.a, android.app.Activity
    protected void onPostCreate(android.os.Bundle bundle) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onPostCreate()");
        android.ext.e1.d(sb.toString());
        super.onPostCreate(bundle);
    }

    @Override // a.a, android.app.Activity
    protected void onPostResume() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onPostResume()");
        android.ext.e1.d(sb.toString());
        M(true);
        y(true);
        super.onPostResume();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        j();
        if (strArr != null && iArr != null) {
            int iMin = java.lang.Math.min(strArr.length, iArr.length);
            for (int i2 = 0; i2 < iMin; i2++) {
                java.lang.String str = strArr[i2];
                if (str != null) {
                    android.ext.e1.d(str + ": " + iArr[i2]);
                }
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
        android.ext.s1.B();
    }

    @Override // a.a, android.app.Activity
    protected void onRestart() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onRestart()");
        android.ext.e1.d(sb.toString());
        M(true);
        y(true);
        super.onRestart();
    }

    @Override // a.a, android.app.Activity
    public void onResume() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onResume()");
        android.ext.e1.d(sb.toString());
        android.ext.b1.G0();
        M(true);
        y(true);
        super.onResume();
        if (android.ext.s1.O() != 1) {
            android.ext.s1.C();
        }
        if (this.f1206d || android.ext.MainService.instance == null) {
            return;
        }
        if (android.ext.m2.f1074a) {
            android.ext.MainService.instance.g1();
        } else if (android.ext.MainService.instance.n == null) {
            S();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        bundle.putParcelable("installer-state", android.ext.b1.j0());
        super.onSaveInstanceState(bundle);
    }

    @Override // a.a, android.app.Activity
    protected void onStart() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onStart()");
        android.ext.e1.d(sb.toString());
        M(true);
        y(true);
        A();
        super.onStart();
    }

    @Override // a.a, android.app.Activity
    public void onStop() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.f1206d ? "Installer: " : "");
        sb.append("onStop()");
        android.ext.e1.d(sb.toString());
        M(false);
        n();
        super.onStop();
    }

    void p() {
        java.lang.Runnable runnable = this.j;
        if (runnable != null) {
            runnable.run();
        }
    }

    public boolean x() {
        return this.f1207e;
    }
}

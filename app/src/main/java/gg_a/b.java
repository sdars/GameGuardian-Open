package gg_a;

/* JADX INFO: loaded from: classes.dex */
public class b extends android.view.ContextThemeWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f7c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static android.content.res.Configuration f8d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static java.util.Locale f9e = java.util.Locale.getDefault();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.res.Configuration f10a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.content.res.Resources f11b;

    public b(android.content.Context context) {
        super(context, catch_.me_.if_.you_.can_.R.style.FixTheme);
        this.f10a = null;
        this.f11b = null;
    }

    public static void a(android.content.Context context) {
        if (context instanceof b) {
            b bVar = (b) context;
            try {
                android.view.LayoutInflater.from(bVar);
            } catch (java.lang.AssertionError e2) {
                try {
                    android.view.LayoutInflater.from(bVar.getBaseContext());
                    android.ext.e1.l("Failed use fix for LayoutInflater", e2);
                    f7c = false;
                } catch (java.lang.AssertionError e3) {
                    android.ext.e1.l("Can not get LayoutInflater", e3);
                }
            }
            android.ext.e1.i("Check LayoutInflater - ok");
        }
    }

    private boolean b(android.content.Intent intent) {
        java.lang.String[] strArr = {"am", "start", intent.toUri(5)};
        android.ext.e1.p("Try exec intent: " + intent + "; " + java.util.Arrays.toString(strArr));
        try {
            java.lang.Process processI = android.ext.Tools.I(strArr);
            processI.getInputStream().close();
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(processI.getErrorStream()));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append('\n');
            }
            bufferedReader.close();
            if (sb.length() <= 0) {
                return true;
            }
            android.ext.e1.p("Failed exec intent: " + intent + "; " + java.util.Arrays.toString(strArr) + ":\n" + sb.toString());
            return false;
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed exec intent: " + intent + "; " + java.util.Arrays.toString(strArr), th);
            return false;
        }
    }

    public static android.content.res.Configuration c(android.content.res.Configuration configuration) {
        android.ext.ConfigListAdapter.q(configuration, f9e);
        return new android.content.res.Configuration(configuration);
    }

    public static b d(android.content.Context context) {
        try {
            java.lang.Class.forName("com.wobian.wv.wb.WBContext");
            return new b$a(context);
        } catch (java.lang.Throwable unused) {
            return new b(context);
        }
    }

    public static boolean e() {
        return f7c;
    }

    public static android.content.res.Configuration f(android.content.res.Configuration configuration) {
        android.content.res.Configuration configurationC = c(configuration);
        g(configurationC, null);
        return configurationC;
    }

    public static void g(android.content.res.Configuration configuration, java.util.Locale locale) {
        if (locale != null) {
            f9e = locale;
        }
        if (configuration == null) {
            configuration = f8d;
        }
        if (configuration == null) {
            configuration = android.ext.Tools.f0().getResources().getConfiguration();
        }
        android.content.res.Configuration configurationC = c(configuration);
        if (configurationC.equals(f8d)) {
            return;
        }
        f8d = configurationC;
    }

    public static boolean h(java.lang.Throwable th, android.content.Context context, android.content.Intent intent) {
        java.lang.String message = th.getMessage();
        if (android.ext.n2.e() || message == null || !message.contains("Looper.prepare()")) {
            return false;
        }
        android.ext.n2.i(new b$b(context, intent));
        return true;
    }

    public static android.content.Context i(android.content.Context context) {
        return (context == null || (context instanceof b)) ? context : d(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(android.content.Intent intent, android.content.ServiceConnection serviceConnection, int i) {
        try {
            return super.bindService(intent, serviceConnection, i);
        } catch (java.lang.IllegalArgumentException e2) {
            android.ext.e1.a(e2);
            return false;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getCacheDir() {
        try {
            return super.getCacheDir();
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
            return android.ext.Tools.b0();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getExternalCacheDir() {
        try {
            return super.getExternalCacheDir();
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            return null;
        } catch (java.lang.NullPointerException e3) {
            android.ext.e1.a(e3);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getExternalFilesDir(java.lang.String str) {
        try {
            return super.getExternalFilesDir(str);
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.a(e2);
            return null;
        } catch (java.lang.NullPointerException e3) {
            android.ext.e1.a(e3);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.io.File getFilesDir() {
        try {
            return super.getFilesDir();
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
            return android.ext.Tools.p0();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.pm.PackageManager getPackageManager() {
        try {
            return super.getPackageManager();
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
            return android.ext.Tools.B0();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String getPackageName() {
        try {
            return super.getPackageName();
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
            return android.ext.Tools.C0();
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.Resources getResources() {
        android.content.res.Configuration configuration = f8d;
        android.content.res.Configuration configuration2 = this.f10a;
        android.content.res.Resources resources = this.f11b;
        android.content.res.Resources resources2 = null;
        android.content.Context contextCreateConfigurationContext = null;
        resources2 = null;
        if (configuration2 != configuration || (resources != null && !resources.getConfiguration().equals(configuration2))) {
            this.f10a = configuration;
            android.content.res.Resources resources3 = super.getResources();
            if (configuration != null) {
                try {
                    resources3.updateConfiguration(configuration, null);
                    if (resources != null && resources != resources3) {
                        resources.updateConfiguration(configuration, null);
                    }
                } catch (java.lang.Throwable th) {
                    android.ext.e1.l("Failed set locale", th);
                }
                try {
                    contextCreateConfigurationContext = createConfigurationContext(configuration);
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.a(th2);
                }
                resources = contextCreateConfigurationContext == null ? resources3 : contextCreateConfigurationContext.getResources();
                resources2 = resources3;
            } else {
                resources = resources3;
                resources2 = resources;
            }
        }
        if (resources == null) {
            resources = resources2 == null ? super.getResources() : resources2;
        }
        this.f11b = resources;
        return resources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.SharedPreferences getSharedPreferences(java.lang.String str, int i) {
        return android.ext.f2.a(super.getSharedPreferences(str, i));
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        return f.a(super.getSystemService(str));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        try {
            super.startActivity(intent);
        } catch (java.lang.Throwable th_c_c_c) {
            if ((intent == null || !"android.intent.action.WEB_SEARCH".equals(intent.getAction())) && !h(th_c_c_c, this, intent) && !b(intent)) {
                throw th_c_c_c;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean startInstrumentation(android.content.ComponentName componentName, java.lang.String str, android.os.Bundle bundle) {
        try {
            return super.startInstrumentation(componentName, str, bundle);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return false;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(android.content.BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (java.lang.IllegalArgumentException e2) {
            android.ext.e1.a(e2);
        }
    }
}

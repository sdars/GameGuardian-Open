package gg_a;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends android.app.Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.view.View f0a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.app.AlertDialog f1b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.content.Context f2c = null;

    private android.content.Context b() {
        if (this.f2c == null) {
            android.content.Context baseContext = getBaseContext();
            if (baseContext == null) {
                return null;
            }
            this.f2c = b.i(baseContext);
        }
        return this.f2c;
    }

    private void c() {
        try {
            android.app.AlertDialog alertDialog = this.f1b;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    public void a() {
        try {
            super.finish();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(android.content.Context context) {
        super.attachBaseContext(b.i(context));
    }

    @Override // android.app.Activity
    public android.view.View findViewById(int i) {
        android.view.View view = this.f0a;
        return view == null ? super.findViewById(i) : view.findViewById(i);
    }

    @Override // android.app.Activity
    public void finish() {
        c();
        a();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public android.content.res.AssetManager getAssets() {
        android.content.Context contextB = b();
        return contextB == null ? super.getAssets() : contextB.getAssets();
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
        } catch (java.lang.SecurityException e4) {
            android.ext.e1.a(e4);
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
        } catch (java.lang.SecurityException e4) {
            android.ext.e1.a(e4);
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
        android.content.Context contextB = b();
        return contextB == null ? super.getResources() : contextB.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.SharedPreferences getSharedPreferences(java.lang.String str, int i) {
        return android.ext.f2.a(super.getSharedPreferences(str, i));
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        try {
            return f.a(super.getSystemService(str));
        } catch (java.lang.NullPointerException e2) {
            android.ext.e1.a(e2);
            return null;
        }
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        try {
            c();
            return super.moveTaskToBack(z);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        try {
            super.onCreate(bundle);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle, android.os.PersistableBundle persistableBundle) {
        try {
            super.onCreate(bundle, persistableBundle);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        c();
        try {
            super.onDestroy();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        android.ext.e1.d("Activity onLowMemory");
        super.onLowMemory();
        android.ext.MainService.t0(-1);
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(android.os.Bundle bundle) {
        try {
            super.onPostCreate(bundle);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        try {
            super.onPostResume();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        try {
            super.onRestart();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        try {
            super.onResume();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        android.ext.e1.d("Activity onTrimMemory: " + i);
        super.onTrimMemory(i);
        android.ext.MainService.t0(i);
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        java.lang.RuntimeException runtimeException = new java.lang.RuntimeException();
        try {
            super.setContentView(i);
        } catch (java.lang.RuntimeException e2_c_c_c) {
            if (runtimeException != e2_c_c_c) {
                try {
                    android.ext.e1.l("Failed call super setContentView", e2_c_c_c);
                } catch (java.lang.RuntimeException e3_c_c_c) {
                    try {
                        android.view.View viewF = d.f(i, null);
                        this.f0a = viewF;
                        android.app.AlertDialog alertDialogCreate = android.ext.f.c(this).setView(viewF).setTitle(getTitle()).setCancelable(false).create();
                        try {
                            alertDialogCreate.setOnCancelListener(new a$b(this));
                            alertDialogCreate.setCancelable(true);
                        } catch (java.lang.Throwable th) {
                            android.ext.e1.a(th);
                        }
                        this.f1b = alertDialogCreate;
                        alertDialogCreate.show();
                    } catch (java.lang.Throwable th2) {
                        android.ext.e1.l("Failed fix call setContentView", th2);
                        e3_c_c_c.addSuppressed(th2);
                        throw e3_c_c_c;
                    }
                }
            } else {
                runtimeException = e2_c_c_c;
            }
            try {
                getWindow().setContentView(i);
                try {
                    getActionBar();
                } catch (java.lang.RuntimeException e4) {
                    if (runtimeException != e4) {
                        android.ext.e1.l("Failed call setup action bar", e4);
                    } else {
                        runtimeException = e4;
                    }
                }
            } catch (java.lang.RuntimeException e5) {
                if (runtimeException != e5) {
                    android.ext.e1.l("Failed fix call setContentView", e5);
                }
                e2_c_c_c.addSuppressed(e5);
                throw e2_c_c_c;
            }
        }
        if (android.ext.e1.n(runtimeException).contains(getPackageName())) {
            this.f0a = null;
            super.setContentView(i - 1);
        }
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        java.lang.String str;
        try {
            super.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e2) {
            android.ext.e1.a(e2);
        } catch (java.lang.SecurityException e3_c_c_c) {
            if (intent.getAction().equals("android.intent.action.UNINSTALL_PACKAGE")) {
                str = "android.intent.action.DELETE";
            } else {
                if (!intent.getAction().equals("android.intent.action.INSTALL_PACKAGE")) {
                    throw e3_c_c_c;
                }
                str = "android.intent.action.VIEW";
            }
            intent.setAction(str);
            startActivity(intent);
        } catch (java.lang.RuntimeException e4_c_c_c) {
            if (!b.h(e4_c_c_c, this, intent)) {
                throw e4_c_c_c;
            }
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i) {
        java.lang.String str;
        try {
            super.startActivityForResult(intent, i);
        } catch (android.content.ActivityNotFoundException e2) {
            android.ext.e1.a(e2);
        } catch (java.lang.SecurityException e3_c_c_c) {
            if (intent.getAction().equals("android.intent.action.UNINSTALL_PACKAGE")) {
                str = "android.intent.action.DELETE";
            } else {
                if (!intent.getAction().equals("android.intent.action.INSTALL_PACKAGE")) {
                    throw e3_c_c_c;
                }
                str = "android.intent.action.VIEW";
            }
            intent.setAction(str);
            startActivityForResult(intent, i);
        } catch (java.lang.RuntimeException e4_c_c_c) {
            java.lang.String message = e4_c_c_c.getMessage();
            if (android.ext.n2.e() || message == null || !message.contains("Looper.prepare()")) {
                throw e4_c_c_c;
            }
            android.ext.n2.i(new a$a(this, intent, i));
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
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$c0$c$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$c0$c f230a;

    MainService$c0$c$a(android.ext.MainService$c0$c mainService$c0$c) {
        this.f230a = mainService$c0$c;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0112 A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #1 {all -> 0x00e9, blocks: (B:13:0x009e, B:15:0x00c8, B:17:0x00d8, B:20:0x00eb, B:22:0x00f1, B:24:0x0112), top: B:38:0x009e }] */
    @Override // java.lang.Runnable
    public void run() {
        android.ext.e1.d("Restart stub: " + this.f230a.f229a.f224a);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("exec setprop wrap.");
        java.lang.String str = this.f230a.f229a.f224a;
        boolean z = false;
        sb.append((str == null || str.length() <= 26) ? this.f230a.f229a.f224a : this.f230a.f229a.f224a.substring(0, 26));
        java.lang.String string = sb.toString();
        try {
            android.ext.e2.n(string + " LD_PRELOAD=" + (android.ext.e0.g() + android.ext.e0.k(this.f230a.f229a.f225b)), 5);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed stub app: " + this.f230a.f229a.f224a, th);
        }
        try {
            if (!android.ext.e2.n("exec monkey -p " + this.f230a.f229a.f224a + " 1", 10).contains("Events injected")) {
                android.content.Intent launchIntentForPackage = android.ext.Tools.B0().getLaunchIntentForPackage(this.f230a.f229a.f224a);
                if (launchIntentForPackage == null) {
                    launchIntentForPackage = new android.content.Intent("android.intent.action.MAIN");
                    launchIntentForPackage.setPackage(this.f230a.f229a.f224a);
                }
                android.content.ComponentName component = launchIntentForPackage.getComponent();
                if (component != null) {
                    if (!android.ext.e2.n("exec am start -n " + component.flattenToString(), 10).contains("Starting: Intent")) {
                        launchIntentForPackage.setFlags(268435456);
                        android.ext.n2.i(new android.ext.MainService$c0$c$a$a(this, launchIntentForPackage));
                    }
                } else {
                    launchIntentForPackage.setFlags(268435456);
                    android.ext.n2.i(new android.ext.MainService$c0$c$a$a(this, launchIntentForPackage));
                }
            }
            z = true;
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Failed restart app: " + this.f230a.f229a.f224a, th2);
        }
        android.ext.n2.c().postDelayed(new android.ext.MainService$c0$c$a$b(this, string), z ? 10000L : 0L);
        android.ext.n2.d().postDelayed(new android.ext.MainService$c0$c$a$c(this), z ? 4000L : 0L);
    }
}

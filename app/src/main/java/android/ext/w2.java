package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class w2 extends android.content.BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1289a = android.ext.Tools.f489a.nextInt();

    private static android.content.Intent a() {
        java.lang.String strC0 = android.ext.Tools.C0();
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(strC0, strC0 + ".Receiver");
        intent.setAction(strC0);
        intent.setFlags((intent.getFlags() | 16777248) & (-8388625));
        intent.putExtra("check-hash", f1289a);
        return intent;
    }

    public static android.app.PendingIntent b(int i) {
        try {
            return android.app.PendingIntent.getBroadcast(android.ext.Tools.f0(), android.ext.Tools.f489a.nextInt(), a().putExtra("action", i), 134217728);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return null;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        int i;
        try {
            android.ext.e1.p("onReceive broadcast: " + intent + "; " + context + "; " + android.ext.MainService.instance);
            if (android.ext.MainService.instance == null) {
                i = 1;
            } else if (intent == null) {
                i = 2;
            } else {
                i = intent.getIntExtra("check-hash", 0) != f1289a ? 3 : 0;
            }
            android.ext.e1.p("Broadcast: " + i);
            if (i != 0) {
                return;
            }
            try {
                context.sendBroadcast(new android.content.Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed hide status bar", th);
            }
            if (intent.getIntExtra("action", 0) != 1) {
                android.ext.MainService.instance.i1();
            } else {
                android.ext.ConfigListAdapter.v();
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.s("onReceive broadcast fail: " + intent, th2);
        }
    }
}

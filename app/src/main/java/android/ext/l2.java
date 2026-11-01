package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class l2 extends gg_a.b {
    public l2(android.content.Context context) {
        super(context);
    }

    public static android.content.Context i(android.content.Context context) {
        return (context == null || (context instanceof android.ext.l2)) ? context : new android.ext.l2(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public android.content.Context getApplicationContext() {
        android.content.Context applicationContext = super.getApplicationContext();
        return applicationContext == null ? android.ext.r.o : applicationContext;
    }

    @Override // a.b, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        try {
            return super.getSystemService(str);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("getSystemService fail: " + str, th);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr) {
        if (intentArr != null) {
            for (android.content.Intent intent : intentArr) {
                if (intent != null) {
                    intent.setFlags(268435456);
                }
            }
        }
        super.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(android.content.Intent[] intentArr, android.os.Bundle bundle) {
        if (intentArr != null) {
            for (android.content.Intent intent : intentArr) {
                if (intent != null) {
                    intent.setFlags(268435456);
                }
            }
        }
        super.startActivities(intentArr, bundle);
    }

    @Override // a.b, android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent) {
        if (intent != null) {
            intent.setFlags(268435456);
        }
        super.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(android.content.Intent intent, android.os.Bundle bundle) {
        if (intent != null) {
            intent.setFlags(268435456);
        }
        super.startActivity(intent, bundle);
    }

    @Override // a.b, android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(android.content.BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (java.lang.IllegalArgumentException e2) {
            android.ext.e1.a(e2);
        }
    }
}

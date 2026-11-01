package gg_a;

/* JADX INFO: loaded from: classes.dex */
class b$a extends b {
    private java.lang.Object mPackageInfo;

    b$a(android.content.Context context) {
        super(context);
        try {
            android.content.Context baseContext = getBaseContext();
            java.lang.Class<?> cls = java.lang.Class.forName("android.app.ContextImpl");
            if (cls.isInstance(baseContext)) {
                java.lang.reflect.Field declaredField = cls.getDeclaredField("mPackageInfo");
                declaredField.setAccessible(true);
                this.mPackageInfo = declaredField.get(baseContext);
                android.ext.e1.d("WBContext: " + this.mPackageInfo);
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}

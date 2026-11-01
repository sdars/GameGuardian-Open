package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.ThreadLocal f502a = new android.ext.Tools$b0$a();

    private Tools$b0() {
    }

    /* synthetic */ Tools$b0(android.ext.Tools$j tools$j) {
        this();
    }

    public void a(int i) {
        java.lang.ThreadLocal threadLocal = f502a;
        threadLocal.set(java.lang.Integer.valueOf((~i) & ((java.lang.Integer) threadLocal.get()).intValue()));
    }

    public boolean b(int i) {
        java.lang.ThreadLocal threadLocal = f502a;
        int iIntValue = ((java.lang.Integer) threadLocal.get()).intValue();
        if ((iIntValue & i) != 0) {
            return false;
        }
        threadLocal.set(java.lang.Integer.valueOf(i | iIntValue));
        return true;
    }
}

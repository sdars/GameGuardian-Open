package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class g0 extends java.lang.Thread {
    public g0(java.lang.Runnable runnable, java.lang.String str) {
        super(runnable, str);
        setDaemon(true);
        android.ext.n0.g(this);
    }

    public g0(java.lang.String str) {
        super(str);
        setDaemon(true);
        android.ext.n0.g(this);
    }
}

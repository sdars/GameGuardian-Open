package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Tools$x extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.os.Handler f549a;

    public Tools$x(android.os.Handler handler) {
        super(handler.getLooper());
        this.f549a = handler;
    }

    public static android.os.Handler a(android.os.Handler handler) {
        return !(handler instanceof android.ext.Tools$x) ? new android.ext.Tools$x(handler) : handler;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        try {
            this.f549a.handleMessage(message);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }
}

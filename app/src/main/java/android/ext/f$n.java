package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f$n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f786b;

    private f$n() {
        this.f785a = false;
        this.f786b = false;
    }

    /* synthetic */ f$n(android.ext.f$a f_a) {
        this();
    }

    synchronized void a() {
        try {
            this.f786b = true;
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    synchronized boolean b() {
        try {
            if (this.f786b) {
                return false;
            }
            this.f786b = true;
            return true;
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }

    synchronized boolean c() {
        try {
            if (!this.f786b && !this.f785a) {
                this.f786b = true;
                return true;
            }
            return false;
        } catch (java.lang.Throwable th_c_c_c) {
            throw th_c_c_c;
        }
    }
}

package android.app;

/* JADX INFO: loaded from: classes.dex */
class ANRManagerProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.os.IBinder f22a;

    public ANRManagerProxy(android.os.IBinder iBinder) {
        this.f22a = iBinder;
    }

    public android.os.IBinder asBinder() {
        return this.f22a;
    }

    public void informMessageDump(java.lang.String str) {
    }

    public void notifyLightWeightANR(int i, java.lang.String str, int i2) {
    }

    public boolean notifyWNR(int i, java.lang.String str) {
        return true;
    }
}

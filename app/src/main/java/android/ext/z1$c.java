package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class z1$c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public java.lang.String f1427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public java.lang.String f1428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public java.lang.String f1429e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1430f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1431g = false;
    public boolean h = false;

    public z1$c(int i, java.lang.String str) {
        this.f1425a = i;
        this.f1427c = str;
        this.f1428d = str;
        this.f1426b = i;
    }

    public java.lang.String toString() {
        return "AppInfo [uid=" + this.f1425a + ", pkg=" + this.f1427c + ", name=" + this.f1428d + ", isSystem=" + this.f1430f + ", isGame=" + this.f1431g + ']';
    }
}

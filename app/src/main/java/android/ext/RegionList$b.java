package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class RegionList$b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static android.util.SparseIntArray f353f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f354g = 16777215;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    java.lang.String f358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    java.lang.String f359e;

    public RegionList$b(int i, long j, long j2) {
        this.f355a = i;
        this.f356b = j;
        this.f357c = j2;
    }

    public static int c(android.ext.RegionList$b regionList$b) {
        try {
            android.util.SparseIntArray sparseIntArray = f353f;
            if (sparseIntArray == null) {
                sparseIntArray = new android.util.SparseIntArray(8);
                sparseIntArray.append(4, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_unknown));
                sparseIntArray.append(1, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_executable_writable));
                sparseIntArray.append(2, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_executable));
                sparseIntArray.append(16, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_writable));
                sparseIntArray.append(8, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_readable));
                f353f = sparseIntArray;
                f354g = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_unknown);
            }
            int i = regionList$b != null ? sparseIntArray.get(regionList$b.d()) : 4;
            return i == 4 ? f354g : i;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed getPointerColor for: " + regionList$b, th);
            return f354g;
        }
    }

    private int d() {
        int i = this.f355a;
        if ((i & 1536) == 1536) {
            return 1;
        }
        if ((i & 1024) == 1024) {
            return 2;
        }
        if ((i & 512) == 512) {
            return 16;
        }
        return (i & 256) == 256 ? 8 : 4;
    }

    public java.lang.String a() {
        if (this.f359e == null) {
            return this.f358d;
        }
        return this.f359e + ":bss";
    }

    public java.lang.String b() {
        return this.f358d;
    }

    public java.lang.CharSequence e() {
        return android.ext.RegionList.f346e[this.f355a & 255];
    }

    public java.lang.String f() {
        int i = this.f355a;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append((i & 256) == 256 ? "r" : "-");
        sb.append((i & 512) == 512 ? "w" : "-");
        sb.append((i & 1024) == 1024 ? "x" : "-");
        sb.append((i & 2048) == 2048 ? "s" : "p");
        return sb.toString();
    }

    public java.lang.CharSequence g() {
        return android.ext.Tools.t(toString(), android.ext.RegionList.f347f[this.f355a & 255]);
    }

    public java.lang.String toString() {
        return ((java.lang.Object) android.ext.RegionList.f346e[this.f355a & 255]) + ": " + android.ext.c.G(this.f356b, 4) + '-' + android.ext.c.G(this.f357c, 4) + ' ' + f() + " '" + this.f358d + '\'';
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final byte f1785a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final java.lang.String f1788d;
    final byte[] j;
    final java.nio.ByteBuffer k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f1786b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1787c = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1789e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    char f1790f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1791g = 0;
    int h = 0;
    int i = 0;

    public StringLib$c(java.lang.String str) {
        byte[] bArr = new byte[8];
        this.j = bArr;
        this.k = java.nio.ByteBuffer.wrap(bArr);
        this.f1788d = str;
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        this.f1785a = (z1_d == null || !z1_d.n) ? (byte) 4 : (byte) 8;
    }

    public java.lang.String toString() {
        return "PackState [size_t=" + ((int) this.f1785a) + ", islittle=" + this.f1786b + ", maxalign=" + this.f1787c + ", fmt=" + this.f1788d + ", pos=" + this.f1789e + ", last=" + this.f1790f + ", align=" + this.f1791g + ", ntoalign=" + this.h + ", size=" + this.i + "]";
    }
}

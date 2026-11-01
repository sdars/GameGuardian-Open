package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class BaseLib$a extends java.io.InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1732a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.io.InputStream f1733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ luaj.lib.BaseLib$c f1734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ luaj.lib.BaseLib f1735d;

    BaseLib$a(luaj.lib.BaseLib baseLib, java.io.InputStream inputStream, luaj.lib.BaseLib$c baseLib$c) {
        this.f1735d = baseLib;
        this.f1733b = inputStream;
        this.f1734c = baseLib$c;
    }

    @Override // java.io.InputStream
    public int read() throws java.io.IOException {
        int i = this.f1733b.read();
        try {
            if (i != -1) {
                this.f1734c.f1739b.write(i);
                this.f1732a++;
            } else {
                int i2 = this.f1732a;
                if (i2 > 0) {
                    this.f1734c.f1741d.writeInt(i2);
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed write log file", th);
        }
        return i;
    }
}

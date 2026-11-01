package luaj;

/* JADX INFO: loaded from: classes.dex */
class Globals$c extends java.io.PushbackInputStream {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f1645b = 65;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f1646a;

    private Globals$c(java.io.InputStream inputStream) {
        super(inputStream, f1645b);
        this.f1646a = false;
    }

    static luaj.Globals$c b(java.io.InputStream inputStream) {
        if (!(inputStream instanceof luaj.Globals$c)) {
            inputStream = new luaj.Globals$c(inputStream);
        }
        return (luaj.Globals$c) inputStream;
    }

    public luaj.Globals$c a(boolean z) {
        this.f1646a = z;
        return this;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int i;
        byte[] bArr = this.buf;
        if (bArr == null) {
            throw new java.io.IOException();
        }
        int i2 = this.pos;
        if (i2 < f1645b) {
            this.pos = i2 + 1;
            i = bArr[i2] & 255;
        } else {
            i = this.in.read();
        }
        if (i != 239 || !this.f1646a) {
            return i;
        }
        int i3 = super.read();
        if (i3 != 187) {
            unread(i3);
            return i;
        }
        int i4 = super.read();
        if (i4 == 191) {
            return read();
        }
        unread(i4);
        unread(i3);
        return i;
    }
}

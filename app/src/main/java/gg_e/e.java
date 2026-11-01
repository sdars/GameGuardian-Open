package gg_e;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int[] f1543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int[] f1544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f1545g;
    protected int h;
    protected boolean i;
    protected boolean j;
    protected java.io.Reader k;
    protected char[] l;
    protected int m;
    protected int n;
    protected int o;

    public e(java.io.InputStream inputStream, java.lang.String str, int i, int i2) throws java.io.UnsupportedEncodingException {
        this(inputStream, str, i, i2, 4096);
    }

    public e(java.io.InputStream inputStream, java.lang.String str, int i, int i2, int i3) throws java.io.UnsupportedEncodingException {
        this(str == null ? new java.io.InputStreamReader(inputStream) : new java.io.InputStreamReader(inputStream, str), i, i2, i3);
    }

    public e(java.io.Reader reader, int i, int i2, int i3) {
        this.f1542d = -1;
        this.i = false;
        this.j = false;
        this.m = 0;
        this.n = 0;
        this.o = 8;
        this.k = reader;
        this.h = i;
        this.f1545g = i2 - 1;
        this.f1539a = i3;
        this.f1540b = i3;
        this.l = new char[i3];
        this.f1543e = new int[i3];
        this.f1544f = new int[i3];
    }

    public char a() throws java.io.IOException {
        this.f1541c = -1;
        char cK = k();
        this.f1541c = this.f1542d;
        return cK;
    }

    protected void b(boolean z) {
        int i;
        int i2 = this.f1539a;
        char[] cArr = new char[i2 + 2048];
        int[] iArr = new int[i2 + 2048];
        int[] iArr2 = new int[i2 + 2048];
        try {
            if (z) {
                char[] cArr2 = this.l;
                int i3 = this.f1541c;
                java.lang.System.arraycopy(cArr2, i3, cArr, 0, i2 - i3);
                java.lang.System.arraycopy(this.l, 0, cArr, this.f1539a - this.f1541c, this.f1542d);
                this.l = cArr;
                int[] iArr3 = this.f1543e;
                int i4 = this.f1541c;
                java.lang.System.arraycopy(iArr3, i4, iArr, 0, this.f1539a - i4);
                java.lang.System.arraycopy(this.f1543e, 0, iArr, this.f1539a - this.f1541c, this.f1542d);
                this.f1543e = iArr;
                int[] iArr4 = this.f1544f;
                int i5 = this.f1541c;
                java.lang.System.arraycopy(iArr4, i5, iArr2, 0, this.f1539a - i5);
                java.lang.System.arraycopy(this.f1544f, 0, iArr2, this.f1539a - this.f1541c, this.f1542d);
                this.f1544f = iArr2;
                i = this.f1542d + (this.f1539a - this.f1541c);
                this.f1542d = i;
            } else {
                char[] cArr3 = this.l;
                int i6 = this.f1541c;
                java.lang.System.arraycopy(cArr3, i6, cArr, 0, i2 - i6);
                this.l = cArr;
                int[] iArr5 = this.f1543e;
                int i7 = this.f1541c;
                java.lang.System.arraycopy(iArr5, i7, iArr, 0, this.f1539a - i7);
                this.f1543e = iArr;
                int[] iArr6 = this.f1544f;
                int i8 = this.f1541c;
                java.lang.System.arraycopy(iArr6, i8, iArr2, 0, this.f1539a - i8);
                this.f1544f = iArr2;
                i = this.f1542d - this.f1541c;
                this.f1542d = i;
            }
            this.m = i;
            int i9 = this.f1539a + 2048;
            this.f1539a = i9;
            this.f1540b = i9;
            this.f1541c = 0;
        } catch (java.lang.Throwable th) {
            throw new java.lang.Error(th.getMessage());
        }
    }

    protected void c() throws java.io.IOException {
        int i = this.m;
        int i2 = this.f1540b;
        if (i == i2) {
            int i3 = this.f1539a;
            if (i2 == i3) {
                i3 = this.f1541c;
                if (i3 > 2048) {
                    this.m = 0;
                    this.f1542d = 0;
                    this.f1540b = i3;
                } else if (i3 < 0) {
                    this.m = 0;
                    this.f1542d = 0;
                } else {
                    b(false);
                }
            } else {
                int i4 = this.f1541c;
                if (i2 > i4) {
                    this.f1540b = i3;
                } else if (i4 - i2 < 2048) {
                    b(true);
                } else {
                    this.f1540b = i4;
                }
            }
        }
        try {
            java.io.Reader reader = this.k;
            char[] cArr = this.l;
            int i5 = this.m;
            int i6 = reader.read(cArr, i5, this.f1540b - i5);
            if (i6 != -1) {
                this.m += i6;
            } else {
                this.k.close();
                throw new java.io.IOException();
            }
        } catch (java.io.IOException e2_c_c_c) {
            this.f1542d--;
            f(0);
            if (this.f1541c == -1) {
                this.f1541c = this.f1542d;
            }
            throw e2_c_c_c;
        }
    }

    public java.lang.String d() {
        int i = this.f1542d;
        int i2 = this.f1541c;
        if (i >= i2) {
            return new java.lang.String(this.l, i2, (i - i2) + 1);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char[] cArr = this.l;
        int i3 = this.f1541c;
        sb.append(new java.lang.String(cArr, i3, this.f1539a - i3));
        sb.append(new java.lang.String(this.l, 0, this.f1542d + 1));
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0025 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:14:0x0027  */
    /* JADX WARN: Code duplicated, block: B:17:0x002c  */
    /* JADX WARN: Code duplicated, block: B:18:0x002f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    protected void e(char c2) {
        this.f1545g++;
        if (!this.j) {
            if (this.i) {
                this.i = false;
                if (c2 == '\n') {
                    this.j = true;
                }
            }
            if (c2 != '\t') {
                int i = this.f1545g - 1;
                this.f1545g = i;
                int i2 = this.o;
                this.f1545g = i + (i2 - (i % i2));
            } else if (c2 != '\n') {
                this.j = true;
            } else if (c2 == '\r') {
                this.i = true;
            }
            int[] iArr = this.f1543e;
            int i3 = this.f1542d;
            iArr[i3] = this.h;
            this.f1544f[i3] = this.f1545g;
        }
        this.j = false;
        int i4 = this.h;
        this.f1545g = 1;
        this.h = i4 + 1;
        if (c2 != '\t') {
            int i5 = this.f1545g - 1;
            this.f1545g = i5;
            int i6 = this.o;
            this.f1545g = i5 + (i6 - (i5 % i6));
        } else if (c2 != '\n') {
            this.j = true;
        } else if (c2 == '\r') {
            this.i = true;
        }
        int[] iArr2 = this.f1543e;
        int i7 = this.f1542d;
        iArr2[i7] = this.h;
        this.f1544f[i7] = this.f1545g;
    }

    public void f(int i) {
        this.n += i;
        int i2 = this.f1542d - i;
        this.f1542d = i2;
        if (i2 < 0) {
            this.f1542d = i2 + this.f1539a;
        }
    }

    public int g() {
        return this.f1544f[this.f1541c];
    }

    public int h() {
        return this.f1543e[this.f1541c];
    }

    public int i() {
        return this.f1544f[this.f1542d];
    }

    public int j() {
        return this.f1543e[this.f1542d];
    }

    public char k() throws java.io.IOException {
        int i = this.n;
        if (i > 0) {
            this.n = i - 1;
            int i2 = this.f1542d + 1;
            this.f1542d = i2;
            if (i2 == this.f1539a) {
                this.f1542d = 0;
            }
            return this.l[this.f1542d];
        }
        int i3 = this.f1542d + 1;
        this.f1542d = i3;
        if (i3 >= this.m) {
            c();
        }
        char c2 = this.l[this.f1542d];
        e(c2);
        return c2;
    }
}

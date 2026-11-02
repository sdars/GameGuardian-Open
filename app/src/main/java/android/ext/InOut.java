package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class InOut {
    public static volatile int byteOrderMask = 15;
    public static volatile boolean m;
    public static volatile int n;
    static boolean o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private java.nio.ByteBuffer f177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private java.nio.ByteBuffer f179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f180g;
    private int h;
    private boolean i;
    private final java.util.ArrayList j;
    private volatile boolean k;
    private java.util.zip.CRC32 l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.io.InputStream f174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.io.OutputStream f175b = null;

    static {
        boolean z = false;
        try {
            java.lang.String[] strArr = android.os.Build.SUPPORTED_64_BIT_ABIS;
            z = strArr != null && strArr.length > 0;
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        p(z);
        o = false;
    }

    public InOut() {
        byte[] bArr = new byte[4];
        this.f176c = bArr;
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        this.f177d = byteBufferWrap;
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        byteBufferWrap.order(byteOrder);
        byte[] bArr2 = new byte[8];
        this.f178e = bArr2;
        java.nio.ByteBuffer byteBufferWrap2 = java.nio.ByteBuffer.wrap(bArr2);
        this.f179f = byteBufferWrap2;
        byteBufferWrap2.order(byteOrder);
        this.f180g = new byte[1024];
        this.j = new java.util.ArrayList();
        this.k = false;
    }

    static java.lang.String b(byte[] bArr, int i, int i2) {
        if (bArr.length - 1 < i) {
            android.ext.e1.p("bytesToHex failed: " + bArr.length + ' ' + i + ' ' + i2);
            return "";
        }
        if (bArr.length < i + i2) {
            android.ext.e1.p("bytesToHex fix len: " + bArr.length + ' ' + i + ' ' + i2);
            i2 = bArr.length - i;
        }
        char[] cArr = new char[i2 * 3];
        char[] cArr2 = android.ext.x0.f1306a;
        for (int i3 = 0; i3 < i2; i3++) {
            byte b2 = bArr[i + i3];
            int i4 = i3 * 3;
            cArr[i4] = cArr2[(b2 & 255) >>> 4];
            cArr[i4 + 1] = cArr2[b2 & 15];
            cArr[i4 + 2] = ' ';
        }
        return new java.lang.String(cArr);
    }

    private void c(int i, boolean z) {
        byte[] bArr = this.f180g;
        int i2 = this.h;
        int i3 = i + i2;
        if (i3 > bArr.length || z) {
            byte[] bArr2 = new byte[i3 + 1024];
            if (i2 > 0) {
                java.lang.System.arraycopy(bArr, 0, bArr2, 0, i2);
            }
            this.f180g = bArr2;
        }
    }

    static java.io.EOFException f() {
        return new java.io.EOFException("daemon stream closed (EOF)");
    }

    public static java.lang.String g(byte[] bArr, int i, int i2) {
        if (bArr.length - 1 < i) {
            android.ext.e1.p("dump failed: " + bArr.length + ' ' + i + ' ' + i2);
            return "";
        }
        if (bArr.length < i + i2) {
            android.ext.e1.p("dump fix len: " + bArr.length + ' ' + i + ' ' + i2);
            i2 = bArr.length - i;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i3 = i;
        while (i3 < i2) {
            int i4 = i2 - i3;
            if (i4 > 32) {
                i4 = 32;
            }
            int i5 = i + i3;
            sb.append(b(bArr, i5, i4));
            sb.append('\'');
            sb.append(new java.lang.String(bArr, i5, i4));
            sb.append("'\n");
            i3 += i4;
        }
        return sb.toString();
    }

    private byte i() throws java.io.IOException {
        int i = this.f174a.read();
        if (i != -1) {
            return (byte) i;
        }
        throw f();
    }

    private int j() throws java.io.IOException {
        int i = 0;
        while (i < 4) {
            int i2 = this.f174a.read(this.f176c, i, 4 - i);
            if (i2 < 0) {
                throw f();
            }
            if (i2 == 0) {
                break;
            }
            i += i2;
        }
        return this.f177d.getInt(0);
    }

    static void p(boolean z) {
        m = z;
        n = z ? 8 : 4;
    }

    public void d() {
        this.h = 0;
    }

    public long e() {
        if (this.h < 2) {
            return 0L;
        }
        java.util.zip.CRC32 crc32 = this.l;
        if (crc32 == null) {
            crc32 = new java.util.zip.CRC32();
            this.l = crc32;
        } else {
            crc32.reset();
        }
        crc32.update(this.f180g, 2, this.h);
        return crc32.getValue();
    }

    public boolean h() {
        return this.k;
    }

    public byte[] k() throws java.io.IOException {
        java.lang.String str;
        byte[] bArr = null;
        int i = 0;
        while (true) {
            byte bI = i();
            if (bI == 2) {
                break;
            }
            if (bArr != null || (bI != 10 && bI != 59)) {
                if (bArr == null) {
                    bArr = new byte[4096];
                }
                if (i < bArr.length) {
                    bArr[i] = bI;
                }
                i++;
                if (i >= bArr.length || i % 10 == 0) {
                    android.ext.e1.d("Bad input from daemon: " + ((int) bI) + '\n' + g(bArr, 0, i));
                }
            }
        }
        if (bArr != null) {
            android.ext.e1.d("Bad input from daemon 2: " + i + '\n' + g(bArr, 0, i));
        }
        int iJ = j();
        if (iJ > 10485760 || iJ < 2) {
            str = "Bad len from daemon: " + iJ + ' ' + g(this.f176c, 0, 4);
        } else {
            byte[] bArr2 = new byte[iJ];
            int i2 = 0;
            while (i2 < iJ) {
                int i3 = this.f174a.read(bArr2, i2, iJ - i2);
                if (i3 < 0) {
                    throw f();
                }
                if (i3 == 0) {
                    if (i2 != 0) {
                        break;
                    }
                    i2 = -1;
                    break;
                }
                i2 += i3;
            }
            int i4 = iJ - 1;
            if (bArr2[i4] == 3) {
                return bArr2;
            }
            str = "Bad end from daemon: " + ((int) bArr2[i4]) + "; " + ((int) bArr2[0]) + "; " + i4 + "; " + i2;
        }
        android.ext.e1.d(str);
        return null;
    }

    public synchronized void l() {
        try {
            if (this.k) {
                m();
                this.f175b.write(this.f180g, 0, this.h);
                this.f175b.flush();
            } else if (this.h > 0) {
                synchronized (this.j) {
                    try {
                        this.j.add(java.util.Arrays.copyOf(this.f180g, this.h));
                        if (this.j.size() > 40) {
                        }
                    } catch (java.lang.Throwable th_c_c_c) {
                        throw th_c_c_c;
                    }
                }
            }
            this.h = 0;
        } catch (java.lang.Throwable th2_c_c_c) {try {

            throw th2_c_c_c;
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
    }

    public void m() {
        java.util.ArrayList arrayList = this.j;
        synchronized (arrayList) {
            try {
                if (arrayList.size() > 0) {
                    java.io.OutputStream outputStream = this.f175b;
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        outputStream.write((byte[]) it.next());
                        outputStream.flush();
                    }
                    arrayList.clear();
                    arrayList.trimToSize();
                }
            } catch (java.lang.Throwable th_c_c_c) {try {

                throw th_c_c_c;
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
            }
        }
    }

    public void n(boolean z) {
        this.k = z;
    }

    public void o(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        java.io.InputStream bufferedInputStream = new java.io.BufferedInputStream(inputStream, 65536);
        if (!o) {
            android.ext.InOut$b inOut$b = new android.ext.InOut$b(outputStream);
            bufferedInputStream = new android.ext.InOut$a(bufferedInputStream);
            outputStream = inOut$b;
        }
        this.f174a = bufferedInputStream;
        this.f175b = outputStream;
    }

    public void q(byte b2, byte b3, int i) {
        c(i + 2, this.i);
        this.i = false;
        byte[] bArr = this.f180g;
        bArr[0] = b3;
        bArr[1] = b2;
        this.h = 2;
    }

    public void r() {
        if (this.f180g.length > 65536) {
            this.i = true;
        }
    }

    public void s(byte b2) {
        c(1, false);
        byte[] bArr = this.f180g;
        int i = this.h;
        this.h = i + 1;
        bArr[i] = b2;
    }

    public void t(byte[] bArr, int i) {
        c(i, false);
        java.lang.System.arraycopy(bArr, 0, this.f180g, this.h, i);
        this.h += i;
    }

    public void u(int i) {
        this.f179f.putInt(0, i ^ byteOrderMask);
        t(this.f178e, 4);
    }

    public void v(long j) {
        if (!m) {
            u((int) j);
        } else {
            this.f179f.putLong(0, j);
            t(this.f178e, 8);
        }
    }

    public void w(long j) {
        this.f179f.putLong(0, j);
        t(this.f178e, 8);
    }
}

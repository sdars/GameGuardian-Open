package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class b1 {
    static android.ext.b1 B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.RandomAccessFile[] f592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final java.io.File f593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.io.File f594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    java.io.File f595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private java.lang.String f596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final java.lang.String f597f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final java.lang.String f598g;
    private final java.lang.String h;
    private final java.lang.String i;
    private final int j;
    private final android.ext.b1$w[] k;
    private final java.security.MessageDigest l;
    private final java.security.MessageDigest m;
    private final java.security.MessageDigest n;
    private java.util.jar.Manifest o;
    private java.util.Map p;
    private java.util.Set q;
    volatile android.app.AlertDialog r;
    private byte[] s;
    private static final java.lang.String[] t = {"archive-parse", "package", "version", "application", "label", "signature", "signature-digest", "signature-official", "commit-hash", "binding-missing", "binding-mismatch", "component", "instrumentation", "provider"};
    private static final java.lang.String[] u = {"repack-start", "verify-start", "verify-pass", "root-install-start", "root-install-return", "manual-install-start", "unknown-source-settings-start", "unknown-source-settings-failed", "package-installed", "old-uninstall-start", "preflight-start", "preflight-root-granted", "preflight-root-unavailable", "preflight-root-unanswered", "preflight-manual-start", "preflight-manual-granted", "preflight-manual-refused", "install-mode-unavailable", "installer-removed", "normal-service-ready"};
    private static final java.lang.String[] v = {"installer-removed", "normal-service-ready"};
    private static final java.util.regex.Pattern w = java.util.regex.Pattern.compile("[0-9a-f]{32}\\.part\\.apk");
    private static final java.lang.String[] x = {"classes.dex", "AndroidManifest.xml", "resources.arsc", "META-INF/MANIFEST.MF", "META-INF/CERT.SF", "META-INF/CERT.RSA"};
    static byte y = 0;
    static byte[][] z = null;
    static final boolean[] A = {false, true, false, true, true, true};
    static volatile android.ext.b1$c0 C = null;
    private static final java.lang.Object D = new java.lang.Object();
    public static volatile java.lang.ref.WeakReference E = new java.lang.ref.WeakReference(null);
    private static final java.lang.Runnable F = new android.ext.b1$b();
    public static volatile java.lang.ref.WeakReference G = new java.lang.ref.WeakReference(null);
    public static volatile java.lang.ref.WeakReference H = new java.lang.ref.WeakReference(null);
    public static volatile java.lang.ref.WeakReference I = new java.lang.ref.WeakReference(null);
    private static volatile int J = 0;
    private static volatile boolean K = false;
    static volatile int L = 0;
    private static final byte[] M = new byte[0];
    private static volatile java.lang.ref.WeakReference N = new java.lang.ref.WeakReference(null);
    private static java.lang.String O = null;
    private static final java.lang.Object P = new java.lang.Object();

    private b1() {
        java.lang.String strF0;
        java.lang.String[] strArr = x;
        this.f592a = new java.io.RandomAccessFile[strArr.length];
        this.k = new android.ext.b1$w[strArr.length];
        this.r = null;try {

        this.l = java.security.MessageDigest.getInstance("SHA1");
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}try {

        this.m = java.security.MessageDigest.getInstance("SHA1");
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}try {

        this.n = java.security.MessageDigest.getInstance("SHA-256");
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        this.f597f = d1();
        java.io.File fileT = T(true);
        fileT.mkdirs();
        this.f593b = fileT;
        android.ext.e1.d("Int dir: " + fileT.getAbsolutePath());
        i();
        android.ext.e1.d("Apk: " + this.f594c.getAbsolutePath());
        A1();
        if (C.f613d == null) {
            C.f613d = e0();
        }
        if (C.f614e == null) {
            do {
                strF0 = f0(1);
            } while (android.ext.i.f1001c.equals(strF0));
            C.f614e = strF0;
        }
        java.lang.String str = C.f613d;
        this.f598g = str;
        this.h = C.f614e;
        java.lang.String strF1 = C.f615f != null ? C.f615f : f0(2);
        this.i = strF1;
        C.f615f = strF1;
        int iE0 = C.f616g != 0 ? C.f616g : E0();
        this.j = iE0;
        C.f616g = iE0;
        android.ext.e1.d("package: " + android.ext.i.f1000b + " -> " + str);
    }

    private static int[] A(java.nio.ByteBuffer byteBuffer, int i, int i2, int i3, int i4, int i5) {
        if (i < i5 || i > i2 - 4) {
            throw new android.ext.b1$v("hashDex: map list out of bounds");
        }
        long jB = B(byteBuffer, i);
        long j = ((long) i) + 4 + (12 * jB);
        if (jB >= 1 && jB <= 2147483647L) {
            long j2 = i2;
            if (j <= j2) {
                int i6 = (int) jB;
                int i7 = (int) j;
                int[] iArr = new int[i6];
                int[] iArr2 = new int[i6];
                long[] jArr = new long[i6];
                int i8 = -1;
                for (int i9 = 0; i9 < i6; i9++) {
                    int i10 = i + 4 + (i9 * 12);
                    int i11 = byteBuffer.getShort(i10) & 65535;
                    int i12 = byteBuffer.getShort(i10 + 2) & 65535;
                    long jB2 = B(byteBuffer, i10 + 4);
                    long jB3 = B(byteBuffer, i10 + 8);
                    if (i12 != 0 || jB2 < 1 || jB3 >= j2 || (i9 > 0 && jB3 <= i8)) {
                        throw new android.ext.b1$v("hashDex: invalid map item");
                    }
                    iArr[i9] = i11;
                    i8 = (int) jB3;
                    iArr2[i9] = i8;
                    jArr[i9] = jB2;
                }
                int i13 = -1;
                int i14 = -1;
                int i15 = -1;
                for (int i16 = 0; i16 < i6; i16++) {
                    int i17 = iArr[i16];
                    if (i17 == 1) {
                        if (i14 >= 0) {
                            throw new android.ext.b1$v("hashDex: duplicate string_ids map item");
                        }
                        i14 = i16;
                    } else if (i17 == 4096) {
                        if (i15 >= 0) {
                            throw new android.ext.b1$v("hashDex: duplicate map_list item");
                        }
                        i15 = i16;
                    } else if (i17 != 8194) {
                        continue;
                    } else {
                        if (i13 >= 0) {
                            throw new android.ext.b1$v("hashDex: duplicate string_data map item");
                        }
                        i13 = i16;
                    }
                }
                if (i14 >= 0) {
                    long j3 = i3;
                    if (jArr[i14] == j3 && iArr2[i14] == i4) {
                        if (i15 < 0 || jArr[i15] != 1 || iArr2[i15] != i) {
                            throw new android.ext.b1$v("hashDex: map_list entry mismatch");
                        }
                        int i18 = i15 + 1;
                        if (i7 > (i18 < i6 ? iArr2[i18] : i2)) {
                            throw new android.ext.b1$v("hashDex: map list overlaps another section");
                        }
                        if (i13 < 0 || jArr[i13] != j3) {
                            throw new android.ext.b1$v("hashDex: string_data map mismatch");
                        }
                        int i19 = iArr2[i13];
                        int i20 = i13 + 1;
                        int i21 = i20 < i6 ? iArr2[i20] : i2;
                        if (i19 < i5 || i19 >= i21 || i21 > i2) {
                            throw new android.ext.b1$v("hashDex: string data out of bounds");
                        }
                        return new int[]{i19, i21};
                    }
                }
                throw new android.ext.b1$v("hashDex: string_ids map mismatch");
            }
        }
        throw new android.ext.b1$v("hashDex: map list out of bounds");
    }

    private static byte[] A0(java.lang.String str) {
        byte[] bArr = new byte[str.length() * 3];
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == 0) {
                int i3 = i + 1;
                bArr[i] = -64;
                i += 2;
                bArr[i3] = -128;
            } else if (cCharAt < 128) {
                bArr[i] = (byte) cCharAt;
                i++;
            } else if (cCharAt < 2048) {
                int i4 = i + 1;
                bArr[i] = (byte) ((cCharAt >> 6) | 192);
                i += 2;
                bArr[i4] = (byte) ((cCharAt & '?') | 128);
            } else {
                bArr[i] = (byte) ((cCharAt >> '\f') | 224);
                int i5 = i + 2;
                bArr[i + 1] = (byte) (((cCharAt >> 6) & 63) | 128);
                i += 3;
                bArr[i5] = (byte) ((cCharAt & '?') | 128);
            }
        }
        return java.util.Arrays.copyOf(bArr, i);
    }

    private void A1() {
        B1(this.f593b);
        java.io.File parentFile = this.f594c.getParentFile();
        if (parentFile == null || parentFile.equals(this.f593b)) {
            return;
        }
        B1(parentFile);
    }

    private static long B(java.nio.ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    public static boolean B0() {
        u1();
        try {
            if (!new java.io.File(android.ext.Tools.removeNewLinesChars("2gdwd2JJ1vnls1lqvwdoo")).exists()) {
                if (android.ext.i.f1000b.equals(android.ext.Tools.C0()) && !W("installer.fail").exists()) {
                    return true;
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
        return false;
    }

    private void B1(java.io.File file) {
        java.lang.String[] list;
        if (file == null || (list = file.list()) == null) {
            return;
        }
        for (java.lang.String str : list) {
            if (y0(str)) {
                java.io.File file2 = new java.io.File(file, str);
                if (!file2.equals(this.f595d) && file2.isFile() && !file2.delete()) {
                    android.ext.e1.p("Failed sweep orphaned part: " + str);
                }
            }
        }
    }

    private static java.io.File C(java.lang.String str) {
        java.io.File fileP0 = android.ext.Tools.p0();
        if (fileP0 != null && !fileP0.isDirectory()) {
            fileP0.mkdirs();
        }
        return new java.io.File(fileP0, str);
    }

    private static java.lang.String C0() {
        return android.ext.Tools.removeNewLinesChars("2gdwd2orfdo2wps21") + java.util.UUID.randomUUID();
    }

    private static byte[] C1(byte[] bArr) {
        byte[] bArrCopyOf = java.util.Arrays.copyOf(bArr, bArr.length);
        if (bArrCopyOf.length > 0) {
            int length = bArrCopyOf.length / 2;
            bArrCopyOf[length] = (byte) (bArrCopyOf[length] ^ 1);
        }
        return bArrCopyOf;
    }

    private void D(java.io.FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
        if (!this.f595d.exists() || this.f595d.delete()) {
            return;
        }
        android.ext.e1.p("Failed discard part: " + this.f595d.getName());
    }

    private static java.lang.String D0() {
        byte[] bArr = new byte[16];
        new java.security.SecureRandom().nextBytes(bArr);
        return android.ext.m0.i(bArr) + ".apk";
    }

    private static int D1(int i, byte[] bArr, int i2) {
        int i3 = 0;
        while (true) {
            int i4 = i & 127;
            i >>>= 7;
            if (i != 0) {
                i4 |= 128;
            }
            int i5 = i3 + 1;
            bArr[i3 + i2] = (byte) i4;
            if (i == 0) {
                return i5;
            }
            i3 = i5;
        }
    }

    private static int E0() {
        return android.ext.Tools.f489a.nextInt(((int) (((1 * 16985.2f) - 830.2f) + 0.5f)) * 2) + 1;
    }

    private static int E1(int i) {
        if (i < 128) {
            return 1;
        }
        if (i < 16384) {
            return 2;
        }
        return i < 2097152 ? 3 : 4;
    }

    private void F() throws java.io.IOException {
        java.lang.String str = null;
        java.util.zip.ZipInputStream zipInputStreamL0 = l0();
        while (true) {
            try {
                java.util.zip.ZipEntry nextEntry = zipInputStreamL0.getNextEntry();
                if (nextEntry == null) {
                    zipInputStreamL0.close();
                    return;
                }
                int iY = Y(nextEntry);
                if (iY != -1) {
                    this.k[iY] = new android.ext.b1$w(new java.util.zip.ZipEntry(nextEntry), G(nextEntry, zipInputStreamL0, iY));
                    str = "list: " + iY;
                } else if (z0(nextEntry.getName())) {
                    java.util.Map mapP1 = p1();
                    this.p = mapP1;
                    mapP1.put(nextEntry.getName(), c1(nextEntry, zipInputStreamL0));
                    str = "secondary dex: " + nextEntry.getName();
                }
                android.ext.e1.d(str);
            } catch (java.lang.Throwable th_c_c_c) {
                zipInputStreamL0.close();
                throw th_c_c_c;
            }
        }
    }

    public static void F0(int i, int i2, android.content.Intent intent) {
        android.ext.b1$c0 b1_c0 = C;
        android.ext.e1.d("instance: " + B + "; " + b1_c0);
        if (b1_c0 == null) {
            return;
        }
        b1_c0.k += "\nget: " + i2 + " for: " + i + " with: " + intent;
        android.ext.b1 b1Var = B;
        if (b1Var == null) {
            return;
        }
        if (i != 1) {
            if (i != 2) {
                return;
            }
            T0(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.failed_uninstall), i, i2, k0(android.ext.i.f1000b));
        } else {
            if (android.ext.Tools.e1(b1Var.f598g)) {
                b1_c0.j = (~i) & b1_c0.j;
                return;
            }
            T0(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.failed_install) + "\n\n" + android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.manual_install) + ":\n" + B.f594c.getAbsolutePath(), i, i2, B.a0());
        }
    }

    private void F1() {
        if (Q0(C.l)) {
            try {
                android.ext.e2.n("exec pm uninstall " + android.ext.i.f1000b, 45);
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("run cmd fail", th);
            }
        }
        java.lang.String str = android.ext.i.f1000b;
        if (!android.ext.Tools.e1(str)) {
            android.ext.f.o(android.ext.f.c(android.ext.r.p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.install_finished)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.p0(1600)));
            return;
        }
        if (C.h) {
            for (android.content.Intent intent : k0(str)) {
                try {
                    P1(intent, 2);
                    break;
                } catch (android.content.ActivityNotFoundException e2) {
                    android.ext.e1.l("intent fail", e2);
                }
            }
        } else {
            android.ext.f.o(android.ext.f.c(android.ext.r.p).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.need_uninstall)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.b1$d(this)));
        }
        throw new java.lang.RuntimeException("Failed uninstall self");
    }

    private java.lang.String G(java.util.zip.ZipEntry zipEntry, java.util.zip.ZipInputStream zipInputStream, int i) throws java.io.IOException {
        this.l.reset();
        java.security.DigestOutputStream digestOutputStream = new java.security.DigestOutputStream(g0(i), this.l);
        this.m.reset();
        java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(zipInputStream, this.m);
        try {
            byte[] bArrS = S();
            while (true) {
                int i2 = digestInputStream.read(bArrS);
                if (i2 == -1) {
                    digestOutputStream.flush();
                    digestOutputStream.close();
                    java.lang.String strEncodeToString = android.util.Base64.encodeToString(this.l.digest(), 2);
                    java.lang.String strEncodeToString2 = android.util.Base64.encodeToString(this.m.digest(), 2);
                    android.ext.e1.d("extract " + zipEntry.getName() + ": " + strEncodeToString2 + " -> " + strEncodeToString);
                    n(zipEntry, i, strEncodeToString, strEncodeToString2);
                    return strEncodeToString;
                }
                digestOutputStream.write(bArrS, 0, i2);
            }
        } catch (java.lang.Throwable th_c_c_c) {
            digestOutputStream.close();
            java.lang.String strEncodeToString3 = android.util.Base64.encodeToString(this.l.digest(), 2);
            android.ext.e1.d("extract " + zipEntry.getName() + ": " + android.util.Base64.encodeToString(this.m.digest(), 2) + " -> " + strEncodeToString3);
            throw th_c_c_c;
        }
    }

    static void G0() {
        android.ext.b1$c0 b1_c0 = C;
        if (b1_c0 != null && b1_c0.i && android.ext.b1$c0.p) {
            android.ext.b1$c0.q = true;
            b1_c0.i = false;
            b1_c0.j &= -5;
        }
    }

    private void G1(java.util.zip.ZipEntry zipEntry, int i) throws java.io.IOException {
        android.ext.e1.d("updateEntry f: " + android.ext.g.a(zipEntry));
        java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
        java.io.InputStream inputStreamZ = Z(i);
        try {
            byte[] bArrS = S();
            long j = 0;
            while (true) {
                int i2 = inputStreamZ.read(bArrS);
                if (i2 == -1) {
                    break;
                } else if (i2 != 0) {
                    j += (long) i2;
                    crc32.update(bArrS, 0, i2);
                }
            }
            inputStreamZ.close();
            zipEntry.setCrc(crc32.getValue());
            long jC0 = c0(i);
            zipEntry.setSize(jC0);
            zipEntry.setCompressedSize(zipEntry.getMethod() == 0 ? jC0 : -1L);
            android.ext.e1.d("updateEntry t: " + android.ext.g.a(zipEntry) + ' ' + jC0 + ' ' + j);
        } catch (java.lang.Throwable th_c_c_c) {
            inputStreamZ.close();
            throw th_c_c_c;
        }
    }

    private void H(android.ext.b1$b0 b1_b0) {
        I(b1_b0, true);
    }

    private static int H0() {
        return (int) (((1 * 18038.1f) - 1883.1f) + 0.5f);
    }

    static void H1() {
        int i = C.f611b + J;
        if (i > 1000) {
            i = 1000;
        }
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) G.get();
        if (progressBar != null) {
            progressBar.setMax(1000);
            progressBar.setProgress(i);
        }
        android.widget.TextView textView = (android.widget.TextView) H.get();
        if (textView != null) {
            textView.setText(android.ext.Tools.L1("%.1f %%", java.lang.Double.valueOf((((double) i) * 100.0d) / 1000.0d)));
        }
        if (J < 199) {
            J++;
        }
        if (C.f611b == 600) {
            if (J == 60) {
                android.widget.TextView textView2 = (android.widget.TextView) I.get();
                java.lang.String str = C.f612c;
                if (textView2 != null && str != null) {
                    textView2.setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.installing) + "\n\n" + android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.manual_install) + ":\n" + str);
                }
            }
            if (J == 198 && B != null && C.h) {
                T0(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.failed_install) + "\n\n" + android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.manual_install) + ":\n" + B.f594c.getAbsolutePath(), 1, -123, B.a0());
            }
        }
    }

    private boolean I(android.ext.b1$b0 b1_b0, boolean z2) {
        byte[] bArr = new byte[8];
        java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
        java.nio.ByteOrder byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        java.nio.ByteBuffer byteBufferOrder = byteBufferWrap.order(byteOrder);
        long jB = b1_b0.b();
        if (jB < 64) {
            throw new android.ext.b1$v("fixDex: truncated classes.dex header");
        }
        b1_b0.f(56L);
        if (b1_b0.e(bArr, 0, 8) != 8) {
            throw new android.ext.b1$v("fixDex: truncated classes.dex header");
        }
        byteBufferOrder.position(0);
        int i = byteBufferOrder.getInt();
        int i2 = byteBufferOrder.getInt();
        if (i >= 1) {
            int i3 = 64;
            if (i2 >= 64) {
                long j = i2;
                if ((((long) i) * 4) + j <= jB) {
                    int i4 = i * 4;
                    byte[] bArr2 = new byte[i4];
                    b1_b0.f(j);
                    if (b1_b0.d(bArr2) != i4) {
                        throw new android.ext.b1$v("fixDex: truncated string_ids table");
                    }
                    java.nio.ByteBuffer byteBufferOrder2 = java.nio.ByteBuffer.wrap(bArr2).order(byteOrder);
                    int[] iArr = new int[i];
                    int i5 = 0;
                    while (i5 < i) {
                        int i6 = byteBufferOrder2.getInt();
                        iArr[i5] = i6;
                        if (i6 >= i3) {
                            long j2 = j;
                            if (i6 < jB && (i5 <= 0 || i6 > iArr[i5 - 1])) {
                                i5++;
                                j = j2;
                                i3 = 64;
                                continue;
                            }
                        }
                        throw new android.ext.b1$v("fixDex: string_ids offsets are not strictly increasing");
                    }
                    long j3 = j;
                    int i7 = iArr[0];
                    long j4 = i7;
                    long j5 = jB - j4;
                    if (j5 > 2147483647L) {
                        throw new android.ext.b1$v("fixDex: string_data tail is out of bounds");
                    }
                    int i8 = (int) j5;
                    byte[] bArr3 = new byte[i8];
                    b1_b0.f(j4);
                    if (b1_b0.d(bArr3) != i8) {
                        throw new android.ext.b1$v("fixDex: truncated string_data section");
                    }
                    java.lang.String strReplace = android.ext.i.f1000b.replace('.', '/');
                    java.lang.String strReplace2 = this.f598g.replace('.', '/');
                    if (strReplace.length() < strReplace2.length()) {
                        throw new android.ext.b1$v("fixDex: generated package is longer than the original");
                    }
                    java.lang.String[] strArr = new java.lang.String[i];
                    int[] iArr2 = new int[i];
                    int i9 = 0;
                    while (true) {
                        java.lang.String str = "fixDex: string ";
                        if (i9 < i) {
                            long j6 = j4;
                            int i10 = iArr[i9] - i7;
                            int i11 = i9 + 1;
                            int i12 = i11 < i ? iArr[i11] - i7 : i8;
                            if (i10 >= i12) {
                                throw new android.ext.b1$v("fixDex: string " + i9 + " has an empty slot");
                            }
                            android.ext.b1$u b1_uX = x(bArr3, i10, i12, i9);
                            strArr[i9] = b1_uX.f643a;
                            iArr2[i9] = b1_uX.f645c;
                            i9 = i11;
                            j4 = j6;
                        } else {
                            long j7 = j4;
                            int i13 = i - 1;
                            int i14 = (iArr[i13] - i7) + iArr2[i13];
                            if (i14 < 1 || i14 > i8) {
                                throw new android.ext.b1$v("fixDex: string_data section is out of bounds");
                            }
                            byte[][] bArr4 = new byte[i][];
                            java.util.HashMap map = new java.util.HashMap();
                            int i15 = 0;
                            int i16 = 0;
                            int i17 = 0;
                            while (true) {
                                java.lang.String str2 = str;
                                if (i16 < i) {
                                    java.lang.String str3 = strArr[i16];
                                    java.lang.String strReplace3 = str3.replace(strReplace, strReplace2);
                                    if (!str3.equals(strReplace3)) {
                                        i17++;
                                    }
                                    strArr[i16] = strReplace3;
                                    byte[] bArrA0 = A0(strReplace3);
                                    java.lang.String str4 = strReplace2;
                                    java.lang.String[] strArr2 = strArr;
                                    int iE1 = E1(strReplace3.length()) + bArrA0.length + 1;
                                    byte[] bArr5 = new byte[iE1];
                                    int i18 = i17;
                                    java.lang.String str5 = strReplace;
                                    byte[] bArr6 = bArr3;
                                    java.lang.System.arraycopy(bArrA0, 0, bArr5, D1(strReplace3.length(), bArr5, 0), bArrA0.length);
                                    bArr4[i16] = bArr5;
                                    if (i15 > i14 - iE1) {
                                        throw new android.ext.b1$v("fixDex: repacked string_data section does not fit");
                                    }
                                    i15 += iE1;
                                    java.lang.Integer num = (java.lang.Integer) map.get(strReplace3);
                                    map.put(strReplace3, java.lang.Integer.valueOf(num == null ? 1 : num.intValue() + 1));
                                    i16++;
                                    str = str2;
                                    i17 = i18;
                                    strReplace2 = str4;
                                    strArr = strArr2;
                                    strReplace = str5;
                                    bArr3 = bArr6;
                                } else {
                                    byte[] bArr7 = bArr3;
                                    java.lang.String str6 = strReplace;
                                    if (i17 == 0) {
                                        if (z2) {
                                            throw new android.ext.b1$v("fixDex: no string in classes.dex carried the original package");
                                        }
                                        return false;
                                    }
                                    java.nio.ByteBuffer byteBufferOrder3 = java.nio.ByteBuffer.wrap(bArr2).order(java.nio.ByteOrder.LITTLE_ENDIAN);
                                    int length = 0;
                                    for (int i19 = 0; i19 < i; i19++) {
                                        int i20 = i7 + length;
                                        iArr[i19] = i20;
                                        byteBufferOrder3.putInt(i19 * 4, i20);
                                        byte[] bArr8 = bArr4[i19];
                                        java.lang.System.arraycopy(bArr8, 0, bArr7, length, bArr8.length);
                                        length += bArr4[i19].length;
                                    }
                                    java.util.Arrays.fill(bArr7, length, i14, (byte) 0);
                                    b1_b0.f(j3);
                                    b1_b0.h(bArr2);
                                    b1_b0.f(j7);
                                    b1_b0.i(bArr7, 0, i14);
                                    byte[] bArr9 = new byte[i14];
                                    b1_b0.f(j7);
                                    if (b1_b0.d(bArr9) != i14) {
                                        throw new android.ext.b1$v("fixDex: re-read of string_data section failed");
                                    }
                                    java.util.HashMap map2 = new java.util.HashMap();
                                    int i21 = 0;
                                    while (i21 < i) {
                                        int i22 = iArr[i21] - i7;
                                        int i23 = i21 + 1;
                                        int i24 = i23 < i ? iArr[i23] - i7 : i15;
                                        if (i22 >= i24) {
                                            throw new android.ext.b1$v(str2 + i21 + " has an empty slot");
                                        }
                                        android.ext.b1$u b1_uX2 = x(bArr9, i22, i24, i21);
                                        if (b1_uX2.f645c != i24 - i22) {
                                            throw new android.ext.b1$v("fixDex: string_data items are not contiguous at " + i21);
                                        }
                                        java.lang.String str7 = b1_uX2.f643a;
                                        java.lang.String str8 = str6;
                                        if (str7.indexOf(str8) >= 0) {
                                            throw new android.ext.b1$v("fixDex: rewritten DEX still contains the original package");
                                        }
                                        java.lang.Integer num2 = (java.lang.Integer) map2.get(str7);
                                        map2.put(str7, java.lang.Integer.valueOf(num2 == null ? 1 : num2.intValue() + 1));
                                        str6 = str8;
                                        i21 = i23;
                                    }
                                    if (!map.equals(map2)) {
                                        throw new android.ext.b1$v("fixDex: on-disk string_data does not match the expected re-base");
                                    }
                                    byte[] bArrS = S();
                                    b1_b0.f(32L);
                                    this.l.reset();
                                    while (true) {
                                        int iD = b1_b0.d(bArrS);
                                        if (iD == -1) {
                                            break;
                                        }
                                        this.l.update(bArrS, 0, iD);
                                    }
                                    b1_b0.f(12L);
                                    b1_b0.h(this.l.digest());
                                    java.util.zip.Adler32 adler32 = new java.util.zip.Adler32();
                                    b1_b0.f(12L);
                                    while (true) {
                                        int iD2 = b1_b0.d(bArrS);
                                        if (iD2 == -1) {
                                            b1_b0.f(8L);
                                            byteBufferOrder2.putInt(0, (int) adler32.getValue());
                                            b1_b0.i(byteBufferOrder2.array(), 0, 4);
                                            return true;
                                        }
                                        adler32.update(bArrS, 0, iD2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new android.ext.b1$v("fixDex: string_ids table is out of bounds");
    }

    private static java.lang.String I0() {
        return "" + ((1 * 109.9f) - 8.5f);
    }

    private void I1() throws java.io.IOException {
        if (!x0(C.o) || !x0(C.n)) {
            throw J1("binding-missing");
        }
        q();
        if (!this.f594c.isFile()) {
            throw J1("binding-mismatch");
        }try {

        if (!C.n.equals(v1(this.f594c))) {
            throw J1("commit-hash");
        };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        try {
            L1(this.f594c, C.o);
            N1();
        } catch (android.ext.b1$v e2) {
            throw K1("binding-mismatch", e2);
        }
    }

    private void J() throws java.io.IOException {
        O();
        int i = 0;
        while (true) {
            android.ext.b1$w[] b1_wArr = this.k;
            if (i >= b1_wArr.length) {
                return;
            }
            android.ext.b1$w b1_w = b1_wArr[i];
            if (b1_w != null) {
                K(b1_w.f646a, i);
            }
            i++;
        }
    }

    private static java.lang.String J0(java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageInfo = android.ext.Tools.B0().getPackageInfo(str, 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length == 1) {
                return l(signatureArr[0]);
            }
        } catch (java.lang.Throwable unused) {
        }
        return null;
    }

    private static android.ext.b1$v J1(java.lang.String str) {
        return K1(str, null);
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0104 A[Catch: all -> 0x002e, TRY_LEAVE, TryCatch #0 {all -> 0x002e, blocks: (B:14:0x0012, B:19:0x001c, B:21:0x001f, B:23:0x0029, B:26:0x0031, B:28:0x0041, B:29:0x0045, B:30:0x0052, B:31:0x0059, B:17:0x0018, B:32:0x005a, B:33:0x0070, B:34:0x0071, B:36:0x0075, B:37:0x007e, B:38:0x0089, B:40:0x008e, B:44:0x00a4, B:43:0x0099, B:45:0x00a7, B:46:0x00af, B:48:0x00b5, B:51:0x00c4, B:52:0x00cc, B:57:0x00d7, B:61:0x00eb, B:62:0x00f6, B:63:0x0100, B:64:0x0104, B:70:0x0114, B:74:0x011d, B:75:0x0120, B:66:0x010b, B:69:0x0111), top: B:79:0x0001, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x010b A[Catch: all -> 0x010f, TRY_ENTER, TryCatch #1 {all -> 0x010f, blocks: (B:66:0x010b, B:69:0x0111), top: B:80:0x0109, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0111 A[Catch: all -> 0x010f, TRY_LEAVE, TryCatch #1 {all -> 0x010f, blocks: (B:66:0x010b, B:69:0x0111), top: B:80:0x0109, outer: #0 }] */
    private void K(java.util.zip.ZipEntry zipEntry, int i) throws java.io.IOException {
        android.ext.b1$b0 b1_b0;
        java.io.OutputStream outputStreamG0 = null;
        try {
            if (i == 0) {
                b1_b0 = new android.ext.b1$b0(this, i, (android.ext.b1$i) null);
                try {
                    if (i == 0) {
                        H(b1_b0);
                    } else {
                        N(b1_b0);
                    }
                    b1_b0.a();
                } catch (java.lang.Throwable th_c_c_c) {
                    b1_b0.a();
                    throw th_c_c_c;
                }
            } else if (i == 1) {
                M();
            } else if (i == 2) {
                b1_b0 = new android.ext.b1$b0(this, i, (android.ext.b1$i) null);
                if (i == 0) {
                    H(b1_b0);
                } else {
                    N(b1_b0);
                }
                b1_b0.a();
            } else if (i == 3) {
                java.util.jar.Manifest manifestD0 = d0(zipEntry);
                this.o = manifestD0;
                java.util.Map<java.lang.String, java.util.jar.Attributes> entries = manifestD0.getEntries();
                int i2 = 0;
                while (true) {
                    java.lang.String[] strArr = x;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    java.util.jar.Attributes attributes = entries.get(strArr[i2]);
                    if (attributes != null) {
                        f1(attributes, U(Z(i2)));
                    }
                    i2++;
                }
                for (java.lang.String str : (java.util.Collection<java.lang.String>) P()) {
                    java.util.jar.Attributes attributes2 = entries.get(str);
                    if (attributes2 != null) {
                        f1(attributes2, w1(str));
                    }
                }
                byte b2 = y;
                if (b2 != 0) {
                    entries.put(b2 == 1 ? "lib/armeabi/libAndroid.so" : "lib/arm64-v8a/libAndroid.so", entries.remove("res/raw/ydw3a"));
                    entries.put(y == 1 ? "lib/x86/libAndroid.so" : "lib/x86_64/libAndroid.so", entries.remove("res/raw/ydw3x"));
                }
                java.util.jar.Manifest manifest = this.o;
                outputStreamG0 = g0(i);
                manifest.write(outputStreamG0);
            } else if (i == 4) {
                java.util.jar.Manifest manifest2 = this.o;
                if (manifest2 != null) {
                    outputStreamG0 = g0(i);
                    R(manifest2, outputStreamG0);
                }
            } else {
                if (i != 5) {
                    throw new java.io.IOException("unknown index: " + i);
                }
                byte[][] bArr = z;
                byte[] bArrC1 = bArr == null ? null : bArr[4];
                if (bArrC1 == null || bArrC1.length == 0) {
                    throw new android.ext.b1$v("CERT.SF is not available for signing");
                }
                if ("tamper-cert-sf".equals(this.f597f)) {
                    bArrC1 = C1(bArrC1);
                }
                android.ext.m0$b m0_bG = android.ext.m0.g(bArrC1);
                byte[] bArrC2 = m0_bG.f1072a;
                if ("tamper-cert-rsa".equals(this.f597f)) {
                    bArrC2 = C1(bArrC2);
                }
                this.f596e = m0_bG.f1073b;
                outputStreamG0 = g0(i);
                outputStreamG0.write(bArrC2);
            }
            if (outputStreamG0 != null) {
                outputStreamG0.close();
            }
        } catch (java.lang.Throwable th2_c_c_c) {
            if (0 != 0) {
                outputStreamG0.close();
            }try {

            throw th2_c_c_c;
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
    }

    private static java.io.File K0(java.io.File file) {
        java.lang.String name = file.getName();
        if (!name.endsWith(".apk")) {
            throw new android.ext.b1$v("committed apk name is not owned: " + name);
        }
        return new java.io.File(file.getParentFile(), name.substring(0, name.length() - 4) + ".part.apk");
    }

    private static android.ext.b1$v K1(java.lang.String str, java.lang.Throwable th) {
        java.lang.String str2;
        W1(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("verify: generated APK identity check failed: ");
        sb.append(str);
        if (th != null) {
            str2 = " (" + th + ")";
        } else {
            str2 = "";
        }
        sb.append(str2);
        android.ext.e1.i(sb.toString());
        return new android.ext.b1$v("verify: generated APK identity check failed: " + str, th);
    }

    private void L(java.util.zip.ZipEntry zipEntry, java.io.InputStream inputStream, java.util.zip.ZipOutputStream zipOutputStream) throws java.io.IOException {
        int iY = Y(zipEntry);
        java.util.zip.ZipEntry zipEntry2 = new java.util.zip.ZipEntry(zipEntry);
        if (iY == -1) {
            byte[] bArr = (byte[]) p1().get(zipEntry2.getName());
            if (bArr != null) {
                java.util.zip.CRC32 crc32 = new java.util.zip.CRC32();
                crc32.update(bArr);
                zipEntry2.setCrc(crc32.getValue());
                zipEntry2.setSize(bArr.length);
                zipEntry2.setCompressedSize(zipEntry2.getMethod() == 0 ? bArr.length : -1L);
                inputStream = new java.io.ByteArrayInputStream(bArr);
            }
            V0(zipEntry2, inputStream, zipOutputStream);
            return;
        }
        G1(zipEntry2, iY);
        android.ext.b1$w b1_w = this.k[iY];
        if (b1_w != null) {
            b1_w.f648c = U0(zipEntry2, zipOutputStream, iY);
            return;
        }
        android.ext.e1.p("List: " + iY + " is null!");
    }

    static boolean L0() {
        android.ext.b1$y b1_yM0;
        java.lang.String str;
        synchronized (D) {
            try {
                android.ext.b1$c0 b1_c0J0 = j0();
                if (b1_c0J0.m) {
                    if (N0(b1_c0J0.l)) {
                        return true;
                    }
                    R1("preflight-manual-refused");
                    S0();
                    return false;
                }
                R1("preflight-start");
                r1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.preflight_checking_root));
                int iO0 = O0();
                if (iO0 == -1) {
                    R1("preflight-root-unavailable");
                    r1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.preflight_root_unavailable));
                    b1_yM0 = M0(iO0, android.os.Build.VERSION.SDK_INT < 26 || u0(), b1_c0J0.i);
                    b1_c0J0.i = false;
                } else {
                    if (iO0 == 1) {
                        r1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.preflight_root_granted));
                    } else {
                        R1("preflight-root-unanswered");
                    }
                    b1_yM0 = M0(iO0, false, false);
                }
                if (b1_yM0 == android.ext.b1$y.ROOT) {
                    if (iO0 == 1) {
                        str = "preflight-root-granted";
                        R1(str);
                    }
                } else if (b1_yM0 == android.ext.b1$y.MANUAL) {
                    R1("preflight-manual-start");
                    str = "preflight-manual-granted";
                    R1(str);
                } else if (b1_yM0 == android.ext.b1$y.OPEN_SETTINGS) {
                    b1_yM0 = P0();
                }
                int iR0 = R0(b1_yM0);
                b1_c0J0.l = iR0;
                b1_c0J0.m = true;
                if (N0(iR0)) {
                    return true;
                }
                R1("preflight-manual-refused");
                S0();
                return false;
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    private java.lang.String L1(java.io.File file, java.lang.String str) throws java.io.IOException {
        q();
        M1(file, str);
        android.content.pm.PackageManager packageManagerB0 = android.ext.Tools.B0();
        android.content.pm.PackageInfo packageArchiveInfo = packageManagerB0.getPackageArchiveInfo(file.getAbsolutePath(), 95);
        if (packageArchiveInfo == null) {
            throw J1("archive-parse");
        }
        if (!this.f598g.equals(packageArchiveInfo.packageName)) {
            throw J1("package");
        }
        if (packageArchiveInfo.versionCode != this.j || !this.i.equals(packageArchiveInfo.versionName)) {
            throw J1("version");
        }
        android.content.pm.ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        if (applicationInfo == null) {
            throw J1("application");
        }
        applicationInfo.sourceDir = file.getAbsolutePath();
        packageArchiveInfo.applicationInfo.publicSourceDir = file.getAbsolutePath();
        try {
            if (!this.h.contentEquals(packageArchiveInfo.applicationInfo.loadLabel(packageManagerB0))) {
                throw J1("label");
            }
            android.content.pm.Signature[] signatureArr = packageArchiveInfo.signatures;
            if (signatureArr == null || signatureArr.length != 1) {
                throw J1("signature");
            }
            java.lang.String strL = l(signatureArr[0]);
            if (!str.equals(strL)) {
                throw J1("signature-digest");
            }
            if (strL.equals(y1()) || strL.equals(J0(android.ext.Tools.C0()))) {
                throw J1("signature-official");
            }
            java.lang.String str2 = android.ext.i.f1000b + ".";
            if (!(this.f598g + ".Application").equals(packageArchiveInfo.applicationInfo.className)) {
                throw J1("application");
            }
            int iM = m(packageArchiveInfo.activities, this.f598g, str2) + m(packageArchiveInfo.receivers, this.f598g, str2) + m(packageArchiveInfo.services, this.f598g, str2) + m(packageArchiveInfo.providers, this.f598g, str2);
            android.content.pm.InstrumentationInfo[] instrumentationInfoArr = packageArchiveInfo.instrumentation;
            if (instrumentationInfoArr != null) {
                /* b1.smali: the "instrumentation" error is only raised on the
                 * failing branches (cond_0/cond_1/cond_2).  A matching
                 * <instrumentation> element continues with cond_3, so the
                 * throw has to stay inside the else branch - jadx moved it
                 * out of the if and made every manifest fail the check. */
                if (instrumentationInfoArr.length == 1 && this.f598g.equals(instrumentationInfoArr[0].targetPackage) && this.f598g.equals(packageArchiveInfo.instrumentation[0].packageName) && (this.f598g + ".Instrumentation").equals(packageArchiveInfo.instrumentation[0].name)) {
                    int i = 0;
                    while (i < instrumentationInfoArr.length) {
                        android.content.pm.InstrumentationInfo instrumentationInfo = instrumentationInfoArr[i];
                        if (!this.f598g.equals(instrumentationInfo.packageName)) {
                            throw J1("instrumentation");
                        }
                        if (!this.f598g.equals(instrumentationInfo.targetPackage)) {
                            throw J1("instrumentation");
                        }
                        iM++;
                        i++;
                    }
                } else {
                    throw J1("instrumentation");
                }
            }
            if (iM == 0) {
                throw J1("component");
            }
            android.content.pm.ProviderInfo[] providerInfoArr = packageArchiveInfo.providers;
            if (providerInfoArr == null || providerInfoArr.length != 1) {
                throw J1("provider");
            }
            android.content.pm.ProviderInfo providerInfo = providerInfoArr[0];
            if (!(this.f598g + ".FileProvider").equals(providerInfo.name)) {
                throw J1("provider");
            }
            if (!this.f598g.equals(providerInfo.authority)) {
                throw J1("provider");
            }
            q();
            android.ext.e1.d("verify: generated APK identity ok");
            return v1(file);
        } catch (java.lang.Throwable th) {
            throw K1("label", th);
        }
    }

    private void M() {
        byte[] bArr = z[1];
        if (bArr == null) {
            throw new android.ext.b1$v("memCache is null 4: 1 " + A[1]);
        }
        try {
            byte[] bArrD = android.ext.s.d(android.ext.s.e(android.ext.s.e(android.ext.s.e(bArr, android.ext.i.f1000b, this.f598g, "package"), android.ext.i.f1001c, this.h, "label"), I0(), this.i, "versionName"), v0(v0(null, 4, H0()), 0, 268435464), v0(v0(null, 4, this.j), 0, 268435464), "versionCode");
            if (y != 0) {
                bArrD = android.ext.s.d(android.ext.s.d(android.ext.s.d(bArrD, v0(null, 0, catch_.me_.if_.you_.can_.R.drawable.ic_gg_48dp), v0(null, 0, y == 1 ? catch_.me_.if_.you_.can_.R.mipmap.ic_32_48dp : catch_.me_.if_.you_.can_.R.mipmap.ic_64_48dp), "icon_gg"), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_hw_48dp), v0(null, 0, y == 1 ? catch_.me_.if_.you_.can_.R.mipmap.ic_h2_48dp : catch_.me_.if_.you_.can_.R.mipmap.ic_h4_48dp), "icon_hw"), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_sw_48dp), v0(null, 0, y == 1 ? catch_.me_.if_.you_.can_.R.mipmap.ic_s2_48dp : catch_.me_.if_.you_.can_.R.mipmap.ic_s4_48dp), "icon_sw");
            }
            java.lang.String[] strArr = {"Application", "Receiver", "MainActivity", "ActivityMain", "FileProvider", "AnalyticsService"};
            for (int i = 0; i < 6; i++) {
                bArrD = android.ext.s.e(bArrD, android.ext.i.f1000b + "." + strArr[i], this.f598g + "." + strArr[i], "component:" + strArr[i]);
            }
            z[1] = android.ext.s.e(bArrD, android.ext.i.f1000b + ".Instrumentation", this.f598g + ".Instrumentation", "component:Instrumentation");
        } catch (java.io.IOException e2) {
            throw new android.ext.b1$v("manifest rewrite failed: " + e2.getMessage(), e2);
        }
    }

    static android.ext.b1$y M0(int i, boolean z2, boolean z3) {
        if (i != -1) {
            return android.ext.b1$y.ROOT;
        }
        int i2 = android.ext.b1$h.f623a[h(z3, z2).ordinal()];
        if (i2 != 1) {
            return i2 != 2 ? android.ext.b1$y.REFUSED : android.ext.b1$y.OPEN_SETTINGS;
        }
        return android.ext.b1$y.MANUAL;
    }

    private static void M1(java.io.File file, java.lang.String str) throws java.io.IOException {
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(file);
        try {
            byte[] bArrE1 = e1(zipFile, "META-INF/CERT.RSA");
            byte[] bArrE2 = e1(zipFile, "META-INF/CERT.SF");
            byte[] bArrE3 = e1(zipFile, "META-INF/MANIFEST.MF");
            zipFile.close();
            if (bArrE1 == null || bArrE2 == null || bArrE3 == null) {
                throw J1("signature");
            }
            if (w(bArrE1) != bArrE1.length) {
                throw J1("signature");
            }
            try {
                java.util.Collection<? extends java.security.cert.Certificate> collectionGenerateCertificates = java.security.cert.CertificateFactory.getInstance("X.509").generateCertificates(new java.io.ByteArrayInputStream(bArrE1));
                if (collectionGenerateCertificates.size() != 1) {
                    throw J1("signature");
                }
                java.security.cert.Certificate next = collectionGenerateCertificates.iterator().next();
                if (!str.equals(android.ext.m0.i(java.security.MessageDigest.getInstance("SHA-256").digest(next.getEncoded())))) {
                    throw J1("signature");
                }
                byte[] bArrS = s(bArrE1);
                if (bArrS == null) {
                    throw J1("signature");
                }
                try {
                    java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");
                    signature.initVerify(next.getPublicKey());
                    signature.update(bArrE2);
                    if (!signature.verify(bArrS)) {
                        throw J1("signature");
                    }
                    java.lang.String strX1 = x1(bArrE2);
                    if (strX1 == null) {
                        throw J1("signature");
                    }
                    if (!strX1.equals(android.ext.m0.h(java.security.MessageDigest.getInstance("SHA-256").digest(bArrE3)))) {
                        throw J1("signature");
                    }
                } catch (java.security.GeneralSecurityException e2) {
                    throw K1("signature", e2);
                }
            } catch (java.security.cert.CertificateException e3) {
                throw K1("signature", e3);
            }
        } catch (java.lang.Throwable th_c_c_c) {
            zipFile.close();try {

            throw th_c_c_c;
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
    }

    private void N(android.ext.b1$b0 b1_b0) {
        short s = 8;
        byte[] bArr = new byte[8];
        java.nio.ByteBuffer byteBufferOrder = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN);
        long jB = b1_b0.b();
        b1_b0.f(0L);
        int i = 0;
        long j = -1;
        short s2 = 0;
        while (b1_b0.c() < jB) {
            if (b1_b0.d(bArr) != s) {
                throw new android.ext.b1$v("fixResources: truncated resource-table chunk header at " + b1_b0.c());
            }
            android.ext.b1$s b1_s = new android.ext.b1$s(byteBufferOrder);
            short s3 = b1_s.f638b;
            if (s3 >= s && b1_s.f639c >= s3) {
                long jC = b1_b0.c();
                int i2 = b1_s.f639c;
                byte[] bArr2 = bArr;
                java.nio.ByteBuffer byteBuffer = byteBufferOrder;
                if (jC + ((long) (i2 - 8)) <= jB) {
                    short s4 = b1_s.f637a;
                    if (s4 == 512) {
                        i++;
                        if (i > 1) {
                            throw new android.ext.b1$v("fixResources: expected exactly one RES_TABLE_PACKAGE_TYPE chunk, found " + i);
                        }
                        long jC2 = b1_b0.c() - 8;
                        short s5 = b1_s.f638b;
                        b1_b0.g(b1_s.f639c - 8);
                        j = jC2;
                        s2 = s5;
                    } else {
                        b1_b0.g(s4 == 2 ? b1_s.f638b - 8 : i2 - 8);
                    }
                    bArr = bArr2;
                    byteBufferOrder = byteBuffer;
                    s = 8;
                    /* the original dex continues with the next chunk here
                       (b1.smali: :goto_2) - the throw below is only the
                       error path of an invalid chunk */
                    continue;
                }
            }
            throw new android.ext.b1$v("fixResources: invalid resource-table chunk at " + (b1_b0.c() - 8));
        }
        if (i != 1 || j < 0) {
            throw new android.ext.b1$v("fixResources: expected exactly one RES_TABLE_PACKAGE_TYPE chunk, found " + i);
        }
        if (s2 < 268) {
            throw new android.ext.b1$v("fixResources: package chunk header too small for the name field");
        }
        long j2 = j + 12;
        if (this.f598g.length() >= 30) {
            throw new android.ext.b1$v("fixResources: generated package name does not fit the 30-unit field");
        }
        byte[] bArrCopyOf = java.util.Arrays.copyOf(this.f598g.getBytes(android.ext.t1.i(true)), 60);
        b1_b0.f(j2);
        b1_b0.h(bArrCopyOf);
        int length = this.f598g.length() * 2;
        byte[] bArr3 = new byte[length];
        b1_b0.f(j2);
        if (b1_b0.d(bArr3) != length || !this.f598g.equals(new java.lang.String(bArr3, android.ext.t1.i(true)))) {
            throw new android.ext.b1$v("fixResources: package name read-back mismatch");
        }
    }

    static boolean N0(int i) {
        return i == 1 || i == 2;
    }

    private void N1() throws java.io.IOException {
        java.lang.String str = C.o + ' ' + C.n;
        java.io.File fileC = C("repack-binding.txt");
        java.lang.String strTrim = null;
        if (fileC.isFile() && fileC.length() > 0 && fileC.length() <= 256) {
            int length = (int) fileC.length();
            byte[] bArr = new byte[length];
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fileC);
            int i = 0;
            while (i < length) {
                try {
                    int i2 = fileInputStream.read(bArr, i, length - i);
                    if (i2 < 0) {
                        break;
                    } else {
                        i += i2;
                    }
                } catch (java.lang.Throwable th_c_c_c) {
                    fileInputStream.close();
                    throw th_c_c_c;
                }
            }
            strTrim = i == length ? new java.lang.String(bArr, "US-ASCII").trim() : null;
            fileInputStream.close();
        }
        if (!str.equals(strTrim)) {
            throw J1("binding-mismatch");
        }
    }

    private void O() {
        java.util.Map map = this.p;
        if (map == null || map.isEmpty()) {
            return;
        }
        for (java.util.Map.Entry map$Entry : (java.util.Collection<java.util.Map.Entry>) map.entrySet()) {
            android.ext.b1$b0 b1_b0 = new android.ext.b1$b0(this, (byte[]) map$Entry.getValue(), (java.lang.String) map$Entry.getKey(), null);
            try {
                if (I(b1_b0, false)) {
                    P().add((java.lang.String) map$Entry.getKey());
                }
                b1_b0.a();
                android.ext.e1.d("fixSecondaryDex: " + ((java.lang.String) map$Entry.getKey()));
            } catch (java.lang.Throwable th_c_c_c) {
                b1_b0.a();
                throw th_c_c_c;
            }
        }
    }

    private static int O0() {
        return android.ext.e2.k(null);
    }

    private static void O1(android.content.Intent intent) {
        android.ext.b1$c0 b1_c0J0 = j0();
        b1_c0J0.j |= 4;
        android.os.Handler handlerD = android.ext.n2.d();
        android.ext.b1$k b1_k = new android.ext.b1$k();
        handlerD.postDelayed(b1_k, 300000L);
        try {
            try {
                android.ext.r.n.startActivityForResult(intent, 4);
                while ((b1_c0J0.j & 4) == 4) {
                    java.lang.Thread.sleep(500L);
                }
            } catch (java.lang.InterruptedException e2) {
                android.ext.e1.l("Interrupted preflight wait", e2);
            }
            handlerD.removeCallbacks(b1_k);
        } catch (java.lang.Throwable th_c_c_c) {
            handlerD.removeCallbacks(b1_k);
            throw th_c_c_c;
        }
    }

    private java.util.Set P() {
        java.util.Set set = this.q;
        if (set != null) {
            return set;
        }
        java.util.HashSet hashSet = new java.util.HashSet();
        this.q = hashSet;
        return hashSet;
    }

    private static android.ext.b1$y P0() {
        android.ext.b1$c0 b1_c0J0 = j0();
        R1("preflight-manual-start");
        r1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.preflight_allow_installs));
        b1_c0J0.i = true;
        android.content.Intent intent = new android.content.Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", android.net.Uri.parse("package:" + android.ext.Tools.C0()));
        android.ext.b1$c0.p = true;
        android.ext.b1$c0.q = false;
        try {
            try {
                O1(intent);
                boolean z2 = android.ext.b1$c0.q;
                b1_c0J0.i = false;
                android.ext.b1$c0.p = false;
                android.ext.b1$c0.q = false;
                if (!z2 || !u0()) {
                    return android.ext.b1$y.REFUSED;
                }
                R1("preflight-manual-granted");
                return android.ext.b1$y.MANUAL;
            } catch (java.lang.RuntimeException e2) {
                Q1(4);
                b1_c0J0.i = false;
                android.ext.e1.l("Fail preflight settings", e2);
                android.ext.b1$y b1_y = android.ext.b1$y.REFUSED;
                android.ext.b1$c0.p = false;
                android.ext.b1$c0.q = false;
                return b1_y;
            }
        } catch (java.lang.Throwable th_c_c_c) {
            android.ext.b1$c0.p = false;
            android.ext.b1$c0.q = false;
            throw th_c_c_c;
        }
    }

    private void P1(android.content.Intent intent, int i) {
        C.j |= i;
        android.os.Handler handlerD = android.ext.n2.d();
        android.ext.b1$e b1_e = new android.ext.b1$e(this, i);
        handlerD.postDelayed(b1_e, 300000L);
        try {
            try {
                android.ext.r.n.startActivityForResult(intent, i);
                while ((C.j & i) == i) {
                    java.lang.Thread.sleep(500L);
                    if (i == 1 && android.ext.Tools.e1(this.f598g)) {
                        C.j &= ~i;
                    }
                }
            } catch (java.lang.InterruptedException e2) {
                android.ext.e1.l("Interrupted wait", e2);
            }
            handlerD.removeCallbacks(b1_e);
            android.ext.n2.i(new android.ext.b1$f(this));
        } catch (java.lang.Throwable th_c_c_c) {
            handlerD.removeCallbacks(b1_e);
            throw th_c_c_c;
        }
    }

    private static void Q(java.security.MessageDigest messageDigest, byte b2, byte[] bArr) {
        messageDigest.update(b2);
        int length = bArr.length;
        messageDigest.update((byte) (length >>> 24));
        messageDigest.update((byte) (length >>> 16));
        messageDigest.update((byte) (length >>> 8));
        messageDigest.update((byte) length);
        messageDigest.update(bArr, 0, length);
    }

    static boolean Q0(int i) {
        return i == 1;
    }

    static void Q1(int i) {
        android.ext.b1$c0 b1_c0 = C;
        if (b1_c0 == null) {
            return;
        }
        b1_c0.j = (~i) & b1_c0.j;
    }

    private void R(java.util.jar.Manifest manifest, java.io.OutputStream outputStream) throws java.io.IOException {
        outputStream.write("Signature-Version: 1.0\r\n".getBytes());
        outputStream.write("Created-By: 1.0 (Android SignApk)\r\n".getBytes());
        this.n.reset();
        java.io.PrintStream printStream = new java.io.PrintStream((java.io.OutputStream) new java.security.DigestOutputStream(new android.ext.b1$x(null), this.n), true, "UTF-8");
        manifest.write(printStream);
        printStream.flush();
        outputStream.write(("SHA-256-Digest-Manifest: " + android.ext.m0.h(this.n.digest()) + "\r\n\r\n").getBytes());
        for (java.util.Map.Entry<java.lang.String, java.util.jar.Attributes> map$Entry : manifest.getEntries().entrySet()) {
            java.lang.String str = "Name: " + map$Entry.getKey() + "\r\n";
            printStream.print(str);
            for (java.util.Map.Entry<java.lang.Object, java.lang.Object> map$Entry2 : map$Entry.getValue().entrySet()) {
                printStream.print(map$Entry2.getKey() + ": " + map$Entry2.getValue() + "\r\n");
            }
            printStream.print("\r\n");
            printStream.flush();
            outputStream.write(str.getBytes());
            outputStream.write(("SHA-256-Digest: " + android.ext.m0.h(this.n.digest()) + "\r\n\r\n").getBytes());
        }
        outputStream.flush();
    }

    static int R0(android.ext.b1$y b1_y) {
        int i = android.ext.b1$h.f624b[b1_y.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    static void R1(java.lang.String str) {
        java.lang.String str2;
        if (str != null) {
            int i = 0;
            while (true) {
                java.lang.String[] strArr = u;
                if (i >= strArr.length) {
                    str2 = "Failed write install stage: unknown code";
                    break;
                } else {
                    if (strArr[i].equals(str)) {
                        try {
                            T1("self-install.stage", str);
                            android.ext.e2.diag("stage: " + str);
                            return;
                        } catch (java.lang.Throwable th) {
                            android.ext.e1.s("Failed write install stage", th);
                            return;
                        }
                    }
                    i++;
                }
            }
        } else {
            str2 = "Failed write install stage: null code";
        }
        android.ext.e1.p(str2);
    }

    private byte[] S() {
        byte[] bArr = this.s;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[65536];
        this.s = bArr2;
        return bArr2;
    }

    private static void S0() {
        android.ext.n2.i(new android.ext.b1$m());
    }

    static void S1() {
        try {
            if (android.ext.Tools.e1(android.ext.i.f1000b)) {
                return;
            }
            R1("installer-removed");
            f("installer-removed");
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    private java.io.File T(boolean z2) {
        java.util.ArrayList<java.io.File> arrayList = new java.util.ArrayList();
        if (z2) {
            arrayList.add(android.ext.Tools.p0());
            arrayList.add(android.ext.Tools.b0());
        }
        try {
            arrayList.add(android.ext.r.p.getExternalCacheDir());
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Fail get path", th);
        }
        try {
            for (java.io.File file : android.ext.r.p.getExternalCacheDirs()) {
                arrayList.add(file);
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("Fail get path", th2);
        }
        try {
            arrayList.add(android.ext.r.p.getExternalFilesDir(null));
        } catch (java.lang.Throwable th3) {
            android.ext.e1.l("Fail get path", th3);
        }
        try {
            for (java.io.File file2 : android.ext.r.p.getExternalFilesDirs(null)) {
                arrayList.add(file2);
            }
        } catch (java.lang.Throwable th4) {
            android.ext.e1.l("Fail get path", th4);
        }
        try {
            arrayList.add(android.os.Environment.getExternalStorageDirectory());
        } catch (java.lang.Throwable th5) {
            android.ext.e1.l("Fail get path", th5);
        }
        try {
            arrayList.add(new java.io.File("/sdcard/Android/data/" + android.ext.Tools.C0() + "/files"));
            arrayList.add(new java.io.File("/mnt/sdcard/Android/data/" + android.ext.Tools.C0() + "/files"));
            arrayList.add(new java.io.File("/sdcard/Android/data/" + android.ext.Tools.C0() + "/cache"));
            arrayList.add(new java.io.File("/mnt/sdcard/Android/data/" + android.ext.Tools.C0() + "/cache"));
        } catch (java.lang.Throwable th6) {
            android.ext.e1.l("Fail get path", th6);
        }
        arrayList.add(new java.io.File("/sdcard"));
        arrayList.add(new java.io.File("/mnt/sdcard"));
        arrayList.add(new java.io.File("/data/local/tmp"));
        arrayList.add(android.ext.Tools.b0());
        arrayList.add(android.ext.Tools.p0());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Failed getDir: ");
        for (java.io.File file3 : arrayList) {
            java.lang.String strW0 = w0(file3);
            if (strW0 == null) {
                return file3;
            }
            if (file3 != null) {
                sb.append(file3.getAbsolutePath());
                sb.append(": ");
                sb.append(strW0);
                sb.append("; ");
            }
        }
        throw new java.lang.RuntimeException(sb.toString());
    }

    private static void T0(java.lang.String str, int i, int i2, android.content.Intent[] intentArr) {
        android.ext.n2.i(new android.ext.b1$a(i, intentArr, i2, str));
    }

    private static void T1(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        U1(str, str2, false);
    }

    private java.lang.String U(java.io.InputStream inputStream) throws java.io.IOException {
        this.n.reset();
        java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(inputStream, this.n);
        try {
            do {
            } while (digestInputStream.read(S()) != -1);
            digestInputStream.close();
            return android.ext.m0.h(this.n.digest());
        } catch (java.lang.Throwable th_c_c_c) {
            digestInputStream.close();
            throw th_c_c_c;
        }
    }

    private java.lang.String U0(java.util.zip.ZipEntry zipEntry, java.util.zip.ZipOutputStream zipOutputStream, int i) throws java.io.IOException {
        zipOutputStream.putNextEntry(zipEntry);
        this.l.reset();
        java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(Z(i), this.l);
        long j = 0;
        try {
            byte[] bArrS = S();
            while (true) {
                int i2 = digestInputStream.read(bArrS);
                if (i2 == -1) {
                    digestInputStream.close();
                    java.lang.String strEncodeToString = android.util.Base64.encodeToString(this.l.digest(), 2);
                    android.ext.e1.d("put " + zipEntry.getName() + ": " + strEncodeToString + "; " + j);
                    zipOutputStream.flush();
                    zipOutputStream.closeEntry();
                    return strEncodeToString;
                }
                if (i2 != 0) {
                    zipOutputStream.write(bArrS, 0, i2);
                    j += (long) i2;
                }
            }
        } catch (java.lang.Throwable th_c_c_c) {
            digestInputStream.close();
            android.ext.e1.d("put " + zipEntry.getName() + ": " + android.util.Base64.encodeToString(this.l.digest(), 2) + "; " + j);
            throw th_c_c_c;
        }
    }

    private static void U1(java.lang.String str, java.lang.String str2, boolean z2) throws java.io.IOException {
        java.io.File fileC = C(str);
        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(fileC, z2);
        android.ext.Tools.q(fileC, 384);
        try {
            fileOutputStream.write(str2.getBytes("US-ASCII"));
            fileOutputStream.close();
        } catch (java.lang.Throwable th_c_c_c) {
            fileOutputStream.close();
            throw th_c_c_c;
        }
    }

    private java.io.File V(int i) {
        java.io.File file = new java.io.File(this.f593b, x[i].replace('/', '@'));
        if (file.exists()) {
            android.ext.Tools.q(file, 384);
        }
        return file;
    }

    private void V0(java.util.zip.ZipEntry zipEntry, java.io.InputStream inputStream, java.util.zip.ZipOutputStream zipOutputStream) throws java.io.IOException {
        java.lang.String str;
        if (zipEntry.getMethod() != 0) {
            zipEntry.setCompressedSize(-1L);
        }
        if (y != 0) {
            java.lang.String name = zipEntry.getName();
            if ("res/raw/ydw3a".equals(name)) {
                str = y == 1 ? "lib/armeabi/libAndroid.so" : "lib/arm64-v8a/libAndroid.so";
            } else {
                str = null;
            }
            if ("res/raw/ydw3x".equals(name)) {
                str = y == 1 ? "lib/x86/libAndroid.so" : "lib/x86_64/libAndroid.so";
            }
            if (str != null) {
                java.util.zip.ZipEntry zipEntry2 = new java.util.zip.ZipEntry(str);
                zipEntry2.setTime(zipEntry.getTime());
                zipEntry2.setMethod(zipEntry.getMethod());
                zipEntry2.setCrc(zipEntry.getCrc());
                zipEntry2.setSize(zipEntry.getSize());
                zipEntry2.setCompressedSize(zipEntry.getMethod() == 0 ? zipEntry.getSize() : -1L);
                zipEntry2.setExtra(zipEntry.getExtra());
                zipEntry2.setComment(zipEntry.getComment());
                zipEntry2.setMethod(0);
                zipEntry = zipEntry2;
            }
        }
        zipOutputStream.putNextEntry(zipEntry);
        byte[] bArrS = S();
        while (true) {
            int i = inputStream.read(bArrS);
            if (i == -1) {
                zipOutputStream.flush();
                zipOutputStream.closeEntry();
                return;
            }
            zipOutputStream.write(bArrS, 0, i);
        }
    }

    private void V1() throws java.io.IOException {
        T1("repack-binding.txt", C.o + ' ' + C.n);
    }

    private static java.io.File W(java.lang.String str) {
        java.io.File fileQ0 = android.ext.Tools.q0();
        fileQ0.mkdirs();
        return new java.io.File(fileQ0, str.replace('/', '@'));
    }

    private static java.lang.String W0(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length() + 2);
        sb.append('\'');
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\'') {
                sb.append("'\\''");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\'');
        return sb.toString();
    }

    private static void W1(java.lang.String str) {
        try {
            T1("verify-generated-apk.fail", str);
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed write verify marker", th);
        }
    }

    public static java.lang.String X() {
        java.lang.String strO0;
        if (O == null) {
            synchronized (P) {
                try {
                    if (O == null) {
                        long j = -java.lang.System.currentTimeMillis();
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        try {
                            java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(i0());
                            try {
                                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                                long size = 0;
                                long crc = 0;
                                int i = 0;
                                java.util.zip.ZipEntry zipEntry = null;
                                java.util.zip.ZipEntry zipEntry2 = null;
                                java.util.zip.ZipEntry zipEntry3 = null;
                                while (enumerationEntries.hasMoreElements()) {
                                    java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                    java.util.Enumeration<? extends java.util.zip.ZipEntry> enumeration = enumerationEntries;
                                    boolean zContains = zipEntryNextElement.getName().contains("META-INF");
                                    int iY = Y(zipEntryNextElement);
                                    r(sb, zipEntry);
                                    if (zipEntry2 != null) {
                                        size += zipEntry2.getSize();
                                        i++;
                                    }
                                    if (zipEntry3 != null) {
                                        crc += zipEntry3.getCrc();
                                    }
                                    if (iY == 1 || iY == 0 || iY == 2) {
                                        sb.append(iY);
                                        sb.append('-');
                                        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("S@H@A@-@3@8@4".replace("@", ""));
                                        long j2 = -java.lang.System.currentTimeMillis();
                                        java.io.InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                                        if (iY == 2) {
                                            strO0 = q0(inputStream, messageDigest);
                                        } else {
                                            strO0 = iY == 0 ? o0(inputStream, messageDigest, android.ext.Tools.C0(), (int) zipEntryNextElement.getSize()) : p0(inputStream, messageDigest);
                                        }
                                        android.ext.e1.d("HH: " + iY + " = " + (j2 + java.lang.System.currentTimeMillis()));
                                        sb.append(zipEntryNextElement.getMethod());
                                        sb.append('-');
                                        sb.append(zipEntryNextElement.getTime());
                                        sb.append('-');
                                        sb.append(strO0);
                                        zipEntry = zipEntryNextElement;
                                        zipEntry3 = null;
                                    } else {
                                        zipEntry3 = !zContains ? zipEntryNextElement : null;
                                        crc = crc;
                                        zipEntry = null;
                                    }
                                    zipEntry2 = !zContains ? zipEntryNextElement : null;
                                    enumerationEntries = enumeration;
                                    size = size;
                                    crc = crc;
                                }
                                r(sb, zipEntry);
                                if (zipEntry2 != null) {
                                    size += zipEntry2.getSize();
                                    i++;
                                }
                                if (zipEntry3 != null) {
                                    crc += zipEntry3.getCrc();
                                }
                                sb.append(size);
                                sb.append(' ');
                                sb.append(i);
                                sb.append(' ');
                                sb.append(java.lang.Long.toHexString(crc));
                                zipFile.close();
                            } catch (java.lang.Throwable th_c_c_c) {
                                zipFile.close();
                                throw th_c_c_c;
                            }
                        } catch (java.lang.Throwable th2) {
                            android.ext.e1.l("Failed get hashes", th2);
                            sb.append("e:");
                            sb.append(th2);
                        }
                        O = sb.toString();
                        android.ext.e1.d("HH: " + (j + java.lang.System.currentTimeMillis()));
                    }
                } catch (java.lang.Throwable th3_c_c_c) {
                    throw th3_c_c_c;
                }
            }
        }
        return O;
    }

    private static long X0(int i, int i2) {
        return (((long) i2) & 4294967295L) | (((long) i) << 32);
    }

    private static int Y(java.util.zip.ZipEntry zipEntry) {
        java.lang.String name = zipEntry.getName();
        int i = 0;
        while (true) {
            java.lang.String[] strArr = x;
            if (i >= strArr.length) {
                return -1;
            }
            if (strArr[i].equals(name)) {
                return i;
            }
            i++;
        }
    }

    private static int Y0(java.io.InputStream inputStream, byte[] bArr) {try {

        return Z0(inputStream, bArr, 0, bArr.length);
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    private java.io.InputStream Z(int i) {
        if (!A[i]) {
            android.ext.e1.d("getInputStream: " + i);
            return new android.ext.b1$z(h0(i), null);
        }
        byte[][] bArr = z;
        if (bArr != null && bArr[i] != null) {
            return new java.io.ByteArrayInputStream(z[i]);
        }
        throw new android.ext.b1$v("memCache is null 1: " + i + ' ' + z);
    }

    private static int Z0(java.io.InputStream inputStream, byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 <= 0) {
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            i3 += i4;
        }
        return i3;
    }

    private boolean a() throws java.lang.Throwable {
        android.ext.e2.diag("b1.a(): start, progress=" + C.f611b + " pkg=" + this.f598g);
        o();
        if (android.ext.Tools.e1(this.f598g)) {
            t1(800);
        }
        if (C.f611b < 600) {
            t1(0);
            R1("repack-start");
            F();
            t1(200);
            J();
            t1(400);
            u();
            java.lang.String str = this.f596e;
            if (str == null) {
                throw J1("signature-digest");
            }
            R1("verify-start");
            t(L1(this.f595d, str), str);
            R1("verify-pass");
            t1(600);
            g();
        }
        if (C.f611b < 800) {
            t1(600);
            v();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            android.ext.b1$c0 b1_c0 = C;
            sb.append(b1_c0.k);
            sb.append(s0());
            b1_c0.k = sb.toString();
            t1(800);
        }
        if (!android.ext.Tools.e1(this.f598g)) {
            throw new android.ext.b1$v("package not installed: " + this.f598g + '\n' + C.k);
        }
        R1("package-installed");
        if (C.f611b < 1000) {
            t1(800);
            q1();
            try {
                o1();
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
            t1(1000);
        }
        R1("old-uninstall-start");
        try {
            F1();
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
        o();
        return true;
    }

    private android.content.Intent[] a0() {
        return b0(this.f594c);
    }

    private static byte[] a1(java.io.InputStream inputStream) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static android.content.Intent[] b0(java.io.File file) {
        android.content.Intent[] intentArr = new android.content.Intent[4];
        boolean z2 = android.os.Build.VERSION.SDK_INT >= 24;
        boolean z3 = K;
        int i = 0;
        int i2 = 0;
        while (i < 2) {
            boolean z4 = (i == 0) ^ z2;
            android.net.Uri uriFromFile = z4 ? android.net.Uri.fromFile(file) : gg_d.c.d(android.ext.Tools.f0(), android.ext.i.f1002d, file);
            android.content.Intent intent = new android.content.Intent("android.intent.action.INSTALL_PACKAGE");
            intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
            intent.addFlags(1);
            intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
            intent.putExtra("android.intent.extra.RETURN_RESULT", true);
            int i3 = i2 + 1;
            intentArr[i2] = m0(intent, (z3 || z4) ? false : true);
            android.content.Intent intent2 = new android.content.Intent("android.intent.action.VIEW");
            intent2.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
            intent2.addFlags(1);
            int i4 = i3 + 1;
            intentArr[i3] = m0(intent2, (z3 || z4) ? false : true);
            i++;
            i2 = i4;
        }
        K = true;
        return intentArr;
    }

    private static byte[] b1(java.io.InputStream inputStream, int i) throws java.io.IOException {
        if (i <= 0) {
            return a1(inputStream);
        }
        byte[] bArr = new byte[i];
        int iZ0 = Z0(inputStream, bArr, 0, i);
        if (iZ0 == i) {
            return bArr;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(iZ0 < 0 ? 0 : iZ0);
        if (iZ0 > 0) {
            byteArrayOutputStream.write(bArr, 0, iZ0);
        }
        byte[] bArr2 = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr2);
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, i2);
        }
    }

    private long c0(int i) {
        byte[] bArr;
        if (!A[i]) {try {

            return h0(i).length();
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
        byte[][] bArr2 = z;
        if (bArr2 != null && (bArr = bArr2[i]) != null) {
            return bArr.length;
        }
        throw new android.ext.b1$v("memCache is null 2: " + i + ' ' + z);
    }

    private byte[] c1(java.util.zip.ZipEntry zipEntry, java.util.zip.ZipInputStream zipInputStream) throws java.io.IOException {
        this.l.reset();
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.security.DigestOutputStream digestOutputStream = new java.security.DigestOutputStream(byteArrayOutputStream, this.l);
        this.m.reset();
        java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(zipInputStream, this.m);
        try {
            byte[] bArrS = S();
            while (true) {
                int i = digestInputStream.read(bArrS);
                if (i == -1) {
                    break;
                }
                digestOutputStream.write(bArrS, 0, i);
            }
            digestOutputStream.flush();
            digestOutputStream.close();
            java.lang.String strEncodeToString = android.util.Base64.encodeToString(this.l.digest(), 2);
            java.lang.String strEncodeToString2 = android.util.Base64.encodeToString(this.m.digest(), 2);
            android.ext.e1.d("extract " + zipEntry.getName() + ": " + strEncodeToString2 + " -> " + strEncodeToString);
            if (strEncodeToString.equals(strEncodeToString2)) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new android.ext.b1$v("check hash for " + zipEntry.getName() + ": " + strEncodeToString2 + " -> " + strEncodeToString);
        } catch (java.lang.Throwable th_c_c_c) {
            digestOutputStream.close();
            throw th_c_c_c;
        }
    }

    private java.util.jar.Manifest d0(java.util.zip.ZipEntry zipEntry) throws java.io.IOException {
        try {
            this.l.reset();
            java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(Z(3), this.l);
            try {
                java.util.jar.Manifest manifest = new java.util.jar.Manifest(digestInputStream);
                digestInputStream.close();
                android.ext.e1.d("Manifest: " + android.util.Base64.encodeToString(this.l.digest(), 2) + " -> " + this.k[3]);
                return manifest;
            } catch (java.lang.Throwable th_c_c_c) {
                digestInputStream.close();
                throw th_c_c_c;
            }
        } catch (java.io.IOException e2) {
            throw new java.io.IOException("Failed get manifest: " + android.util.Base64.encodeToString(this.l.digest(), 2) + " -> " + this.k[3], e2);
        }
    }

    private static java.lang.String d1() {
        return null;
    }

    private java.lang.String e0() {
        java.lang.String strF0;
        do {
            strF0 = f0(0);
        } while (android.ext.Tools.e1(strF0));
        return strF0;
    }

    private static byte[] e1(java.util.zip.ZipFile zipFile, java.lang.String str) throws java.io.IOException {
        java.util.zip.ZipEntry entry = zipFile.getEntry(str);
        if (entry == null) {
            return null;
        }
        java.io.InputStream inputStream = zipFile.getInputStream(entry);
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream((int) java.lang.Math.max(0L, java.lang.Math.min(entry.getSize(), 65536L)));
            byte[] bArr = new byte[65536];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (java.lang.Throwable th_c_c_c) {
            inputStream.close();
            throw th_c_c_c;
        }
    }

    static void f(java.lang.String str) {
        java.lang.String str2;
        if (str != null) {
            int i = 0;
            while (true) {
                java.lang.String[] strArr = v;
                if (i >= strArr.length) {
                    str2 = "Failed append readiness trace: unknown code";
                    break;
                }
                if (strArr[i].equals(str)) {
                    try {
                        U1("self-install.readiness", str + "\n", true);
                        return;
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.s("Failed append readiness trace", th);
                        return;
                    }
                }
                i++;
            }
        } else {
            str2 = "Failed append readiness trace: null code";
        }
        android.ext.e1.p(str2);
    }

    private static java.lang.String f0(int i) {
        char[] cArr = i == 2 ? new char[]{'.', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'} : new char[]{'.', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (i == 0) {
            sb.append("com.");
        }
        java.util.Random random = android.ext.Tools.f489a;
        java.lang.String str = "" + ((1 * 116.6f) - 15.2f);
        int length = (i == 1 ? android.ext.i.f1001c : i == 0 ? android.ext.i.f1000b : str).length() - sb.length();
        if (i != 2) {
            if (i != 0) {
                length++;
            }
            length = random.nextInt(length - 3) + 3;
        }
        boolean z2 = true;
        for (int i2 = 0; i2 < length; i2++) {
            if (i == 2 && str.charAt(i2) == '.') {
                sb.append('.');
            } else {
                int i3 = (i == 2 || z2) ? 1 : 0;
                int length2 = cArr.length;
                if (i2 == 0 && i != 1) {
                    i3 = 2;
                }
                if (i2 == length - 1 && i3 == 0) {
                    i3 = 1;
                }
                int iNextInt = i3 + random.nextInt(length2 - i3);
                char upperCase = cArr[iNextInt];
                if (i == 1) {
                    if (iNextInt == 0) {
                        upperCase = ' ';
                    } else if (z2) {
                        upperCase = java.lang.Character.toUpperCase(upperCase);
                    }
                }
                sb.append(upperCase);
                z2 = iNextInt == 0;
            }
        }
        return sb.toString();
    }

    private static void f1(java.util.jar.Attributes attributes, java.lang.String str) {
        h1(attributes);
        attributes.putValue("SHA-256-Digest", str);
    }

    private void g() {
    }

    private java.io.OutputStream g0(int i) {
        int i2;
        boolean z2 = A[i];
        android.ext.b1$a0 b1_a0 = null;
        if (!z2) {
            try {
                android.ext.e1.d("getOutputStream: " + i);
                b1_a0 = new android.ext.b1$a0(h0(i), null);
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
            if (b1_a0 == null) {
                android.ext.e1.d("Use mem cache for " + i);
                A[i] = true;
                z2 = true;
            }
        }
        if (!z2) {
            return b1_a0;
        }
        if (i == 1) {
            i2 = 9000;
        } else if (i == 3 || i == 4) {
            i2 = 75000;
        } else {
            i2 = i == 5 ? 2000 : 8192;
        }
        return new android.ext.b1$g(this, i2, i);
    }

    private static java.lang.Runnable g1(java.lang.Runnable runnable) {
        return new android.ext.b1$i(runnable);
    }

    static android.ext.b1$r h(boolean z2, boolean z3) {
        if (z2) {
            return z3 ? android.ext.b1$r.PROCEED : android.ext.b1$r.FAIL_PENDING;
        }
        return z3 ? android.ext.b1$r.PROCEED : android.ext.b1$r.OPEN_SETTINGS;
    }

    private static void h1(java.util.jar.Attributes attributes) {
        java.lang.String string;
        int length;
        java.util.Iterator<java.lang.Object> it = attributes.keySet().iterator();
        while (it.hasNext()) {
            java.lang.Object next = it.next();
            if ((next instanceof java.util.jar.Attributes.Name) && (length = (string = ((java.util.jar.Attributes.Name) next).toString()).length()) > 7 && string.regionMatches(true, length - 7, "-Digest", 0, 7)) {
                it.remove();
            }
        }
    }

    private void i() {
        java.io.File file;
        if (C.f611b < 600 || C.f612c == null) {
            java.io.File fileT = T(false);
            fileT.mkdirs();
            C.f612c = new java.io.File(fileT, D0()).getAbsolutePath();
            C.f613d = null;
            C.f614e = null;
            C.f615f = null;
            C.f616g = 0;
            C.n = null;
            C.o = null;
            file = new java.io.File(C.f612c);
        } else {
            file = new java.io.File(C.f612c);
        }
        this.f594c = file;
        this.f595d = K0(file);
    }

    private static java.io.File i0() {
        java.io.File file = (java.io.File) N.get();
        if (file != null) {
            return file;
        }
        java.io.File file2 = new java.io.File(android.ext.Tools.W());
        N = new java.lang.ref.WeakReference(file2);
        return file2;
    }

    public static void i1(java.lang.Runnable runnable) {
        android.content.Intent intent = android.ext.r.n.getIntent();
        boolean z2 = false;
        if (intent != null) {
            if (intent.getBooleanExtra(android.ext.i.f1000b + ".fromInstaller", false)) {
                z2 = true;
            }
        }
        android.ext.e1.d("removeInstaller: " + z2 + " + " + android.ext.r.m);
        if (!android.ext.r.m && !z2) {
            g1(runnable).run();
            return;
        }
        android.ext.r.m = true;
        android.ext.e1.d(runnable + ": 30");
        android.ext.x2.s(android.ext.i.f1000b, g1(runnable));
        android.ext.e1.d(runnable + ": 40");
    }

    private void j(java.io.FileOutputStream fileOutputStream) throws java.io.IOException {
        int i;
        java.lang.String[] strArrSplit = android.ext.Tools.removeNewLinesChars("uhv2udz2Cdvvhwv2").split("@");
        java.lang.String strRemoveNewLinesChars = android.ext.Tools.removeNewLinesChars("uhv2udz2|gz");
        java.util.zip.ZipFile zipFile = new java.util.zip.ZipFile(i0());
        try {
            android.ext.g gVar = new android.ext.g(fileOutputStream);
            try {
                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                while (true) {
                    i = 0;
                    if (!enumerationEntries.hasMoreElements()) {
                        break;
                    }
                    java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    java.lang.String name = zipEntryNextElement.getName();
                    int length = strArrSplit.length;
                    while (true) {
                        if (i >= length) {
                            java.io.InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                            try {
                                L(zipEntryNextElement, inputStream, gVar);
                                inputStream.close();
                                break;
                            } catch (java.lang.Throwable th_c_c_c) {
                                inputStream.close();
                                throw th_c_c_c;
                            }
                        }
                        if (name.startsWith(strArrSplit[i]) && !name.startsWith(strRemoveNewLinesChars)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                gVar.close();
                zipFile.close();
                android.ext.h3.a(this.f595d);
                android.ext.h3.f(this.f595d);
                while (i < this.k.length) {
                    android.ext.e1.d("copy " + i + ' ' + this.k[i]);
                    i++;
                }
            } catch (java.lang.Throwable th2_c_c_c) {
                gVar.close();
                throw th2_c_c_c;
            }
        } catch (java.lang.Throwable th3_c_c_c) {
            zipFile.close();
            throw th3_c_c_c;
        }
    }

    static android.ext.b1$c0 j0() {
        if (C == null) {
            android.ext.b1$c0 b1_c0 = new android.ext.b1$c0();
            b1_c0.f610a = B0();
            C = b1_c0;
        }
        return C;
    }

    private static boolean j1(java.lang.String str) {
        return str != null && str.endsWith(android.ext.Tools.removeNewLinesChars("h{lw#frgh=#3"));
    }

    static void k(boolean z2) {
        o();
        try {
            W("installer.fail").createNewFile();
        } catch (java.io.IOException e2) {
            android.ext.e1.l("Failed set install flag", e2);
        }
        if (z2) {
            android.ext.n2.i(new android.ext.b1$q());
        }
    }

    public static android.content.Intent[] k0(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent("android.intent.action.UNINSTALL_PACKAGE");
        intent.setData(android.net.Uri.fromParts("package", str, null));
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        intent.putExtra("android.intent.extra.UNINSTALL_ALL_USERS", true);
        android.content.Intent intent2 = new android.content.Intent("android.intent.action.DELETE");
        intent2.setData(android.net.Uri.fromParts("package", str, null));
        return new android.content.Intent[]{intent, intent2};
    }

    private static java.lang.String k1(java.lang.String str) {
        return android.ext.Tools.removeNewLinesChars("h{hf#sp#lqvwdoo#0i#") + str;
    }

    private static java.lang.String l(android.content.pm.Signature signature) {try {

        return android.ext.m0.i(java.security.MessageDigest.getInstance("SHA-256").digest(signature.toByteArray()));
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    private static java.util.zip.ZipInputStream l0() {try {

        return new java.util.zip.ZipInputStream(new java.io.BufferedInputStream(new java.io.FileInputStream(i0()), 65536));
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    private static java.lang.String l1(java.lang.String str, java.lang.String str2) {
        java.lang.String str3 = str2 + android.ext.Tools.removeNewLinesChars("2edvh1dsn");
        java.lang.StringBuilder sb = new java.lang.StringBuilder(256);
        sb.append(android.ext.Tools.removeNewLinesChars("fs#"));
        sb.append(W0(str));
        sb.append(android.ext.Tools.removeNewLinesChars("#"));
        sb.append(W0(str3));
        sb.append(android.ext.Tools.removeNewLinesChars("#))#fkprg#3977#"));
        sb.append(W0(str3));
        sb.append(android.ext.Tools.removeNewLinesChars("#))#sp#lqvwdoo#0i#"));
        sb.append(W0(str3));
        sb.append(android.ext.Tools.removeNewLinesChars(">#uf@'B>#up#0i#"));
        sb.append(W0(str3));
        sb.append(android.ext.Tools.removeNewLinesChars(">#upglu#"));
        sb.append(W0(str2));
        sb.append(android.ext.Tools.removeNewLinesChars(">#h{lw#'uf"));
        return sb.toString();
    }

    private static int m(android.content.pm.ComponentInfo[] componentInfoArr, java.lang.String str, java.lang.String str2) {
        if (componentInfoArr == null) {
            return 0;
        }
        for (int i = 0; i < componentInfoArr.length; i++) {
            if (!str.equals(componentInfoArr[i].packageName)) {
                throw J1("component");
            }
            java.lang.String str3 = componentInfoArr[i].name;
            if (str3 != null && str3.startsWith(str + ".") && !str3.startsWith(str2)) {
                continue;
            }
            throw J1("component");
        }
        return componentInfoArr.length;
    }

    private static android.content.Intent m0(android.content.Intent intent, boolean z2) {
        if (z2) {
            android.content.Context contextF0 = android.ext.Tools.f0();
            try {
                for (android.content.pm.ResolveInfo resolveInfo : android.ext.Tools.B0().queryIntentActivities(intent, 65536)) {
                    try {
                        contextF0.grantUriPermission(resolveInfo.activityInfo.packageName, intent.getData(), 1);
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.s("Failed grant 0 " + intent + "; " + resolveInfo, th);
                    }
                }
            } catch (java.lang.Throwable th2) {
                android.ext.e1.s("Failed grant 1 " + intent, th2);
            }
            try {
                contextF0.grantUriPermission("com.android.packageinstaller", intent.getData(), 1);
            } catch (java.lang.Throwable th3) {
                android.ext.e1.s("Failed grant 2 " + intent, th3);
            }
        }
        return intent;
    }

    private static java.lang.String m1(java.lang.String str) {
        return android.ext.Tools.removeNewLinesChars("h{hf#up#0ui#") + W0(str);
    }

    private void n(java.util.zip.ZipEntry zipEntry, int i, java.lang.String str, java.lang.String str2) throws java.io.IOException {
        this.l.reset();
        java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(Z(i), this.l);
        try {
            do {
            } while (digestInputStream.read(S()) != -1);
            digestInputStream.close();
            java.lang.String strEncodeToString = android.util.Base64.encodeToString(this.l.digest(), 2);
            android.ext.e1.d("check hash for " + zipEntry.getName() + " [" + i + "]: " + strEncodeToString + " : " + str2 + " -> " + str);
            if (str.equals(strEncodeToString)) {
                return;
            }
            throw new android.ext.b1$v("check hash for " + zipEntry.getName() + " [" + i + "]: " + strEncodeToString + " != " + str2 + " -> " + str);
        } catch (java.lang.Throwable th_c_c_c) {
            digestInputStream.close();
            android.ext.e1.d("check hash for " + zipEntry.getName() + " [" + i + "]: " + android.util.Base64.encodeToString(this.l.digest(), 2) + " : " + str2 + " -> " + str);
            throw th_c_c_c;
        }
    }

    private static int n0(java.io.InputStream inputStream, java.security.MessageDigest messageDigest, byte[] bArr, int i) throws java.io.IOException {
        int i2 = i;
        while (i2 > 0) {
            int i3 = inputStream.read(bArr, 0, i2 > bArr.length ? bArr.length : i2);
            if (i3 <= 0) {
                break;
            }
            i2 -= i3;
            messageDigest.update(bArr, 0, i3);
        }
        return i;
    }

    private static java.lang.String n1(java.lang.String str) {
        return android.ext.Tools.removeNewLinesChars("xpdvn#3::>#h{hf#pnglu#") + W0(str);
    }

    private static void o() {
        try {
            C("self-install.stage").delete();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed clear install stage", th);
        }
        p();
    }

    public static final java.lang.String o0(java.io.InputStream inputStream, java.security.MessageDigest messageDigest, java.lang.String str, int i) {
        try {
            byte[] bArrB1 = b1(inputStream, i);
            if (bArrB1.length < 112) {
                throw new android.ext.b1$v("hashDex: truncated DEX header");
            }
            if ((bArrB1[0] & 255) == 100 && (bArrB1[1] & 255) == 101 && (bArrB1[2] & 255) == 120 && (bArrB1[3] & 255) == 10) {
                byte b2 = bArrB1[4];
                if ((b2 & 255) >= 48 && (b2 & 255) <= 57) {
                    byte b3 = bArrB1[5];
                    if ((b3 & 255) >= 48 && (b3 & 255) <= 57) {
                        byte b4 = bArrB1[6];
                        if ((b4 & 255) >= 48 && (b4 & 255) <= 57 && (bArrB1[7] & 255) == 0) {
                            if (str == null || str.length() == 0) {
                                throw new android.ext.b1$v("hashDex: missing package identity");
                            }
                            java.nio.ByteBuffer byteBufferOrder = java.nio.ByteBuffer.wrap(bArrB1).order(java.nio.ByteOrder.LITTLE_ENDIAN);
                            if (byteBufferOrder.getInt(36) != 112) {
                                throw new android.ext.b1$v("hashDex: invalid DEX header size");
                            }
                            if (byteBufferOrder.getInt(40) != 305419896) {
                                throw new android.ext.b1$v("hashDex: invalid DEX endian tag");
                            }
                            if (B(byteBufferOrder, 32) != bArrB1.length) {
                                throw new android.ext.b1$v("hashDex: file size out of bounds");
                            }
                            int length = bArrB1.length;
                            long jB = B(byteBufferOrder, 104);
                            long jB2 = B(byteBufferOrder, 108);
                            if ((jB == 0 && jB2 != 0) || (jB != 0 && (jB2 < 112 || jB + jB2 != length))) {
                                throw new android.ext.b1$v("hashDex: data section out of bounds");
                            }
                            int i2 = (int) jB2;
                            long jB3 = B(byteBufferOrder, 56);
                            long jB4 = B(byteBufferOrder, 60);
                            if (jB3 < 1 || jB3 > 2147483647L || jB4 < 112 || (4 * jB3) + jB4 > length) {
                                throw new android.ext.b1$v("hashDex: string table out of bounds");
                            }
                            int i3 = (int) jB3;
                            int i4 = (int) jB4;
                            long jB5 = B(byteBufferOrder, 52);
                            if (jB5 > 2147483647L) {
                                throw new android.ext.b1$v("hashDex: map list out of bounds");
                            }
                            int[] iArrA = A(byteBufferOrder, (int) jB5, length, i3, i4, i2);
                            int i5 = iArrA[0];
                            int i6 = iArrA[1];
                            int[] iArr = new int[i3];
                            int i7 = 0;
                            while (i7 < i3) {
                                long jB6 = B(byteBufferOrder, (i7 * 4) + i4);
                                java.nio.ByteBuffer byteBuffer = byteBufferOrder;
                                if (jB6 < i5 || jB6 >= i6) {
                                    throw new android.ext.b1$v("hashDex: string data out of bounds");
                                }
                                int i8 = (int) jB6;
                                iArr[i7] = i8;
                                z(bArrB1, i8, i6);
                                i7++;
                                byteBufferOrder = byteBuffer;
                            }
                            int[] iArr2 = (int[]) iArr.clone();
                            java.util.Arrays.sort(iArr2);
                            if (iArr2[0] != i5) {
                                throw new android.ext.b1$v("hashDex: string data section has a gap");
                            }
                            int i9 = 0;
                            while (i9 < iArr2.length) {
                                int iZ = z(bArrB1, iArr2[i9], i6);
                                i9++;
                                if (i9 < iArr2.length && iZ != iArr2[i9]) {
                                    throw new android.ext.b1$v("hashDex: string data items are not contiguous");
                                }
                                if (i9 == iArr2.length) {
                                    while (iZ < i6) {
                                        if (bArrB1[iZ] != 0) {
                                            throw new android.ext.b1$v("hashDex: non-zero string data padding");
                                        }
                                        iZ++;
                                    }
                                }
                            }
                            long[] jArr = {X0(8, 32), X0(i4, (i3 * 4) + i4), X0(i5, i6)};
                            java.util.Arrays.sort(jArr);
                            int i10 = 0;
                            int i11 = 0;
                            while (i10 < 3) {
                                long j = jArr[i10];
                                long[] jArr2 = jArr;
                                int i12 = (int) (j >> 32);
                                int i13 = (int) j;
                                if (i12 > i11) {
                                    messageDigest.update(bArrB1, i11, i12 - i11);
                                }
                                if (i13 > i11) {
                                    i11 = i13;
                                }
                                i10++;
                                jArr = jArr2;
                            }
                            if (i11 < length) {
                                messageDigest.update(bArrB1, i11, length - i11);
                            }
                            java.lang.String strReplace = str.replace('.', '/');
                            for (int i14 = 0; i14 < i3; i14++) {
                                java.lang.String strY = y(bArrB1, iArr[i14], i6);
                                int length2 = 0;
                                while (true) {
                                    int iIndexOf = strY.indexOf(strReplace, length2);
                                    Q(messageDigest, (byte) 0, strY.substring(length2, iIndexOf < 0 ? strY.length() : iIndexOf).getBytes(android.ext.t1.i(false)));
                                    if (iIndexOf < 0) {
                                        break;
                                    }
                                    Q(messageDigest, (byte) 1, M);
                                    length2 = strReplace.length() + iIndexOf;
                                }
                            }
                            return android.ext.w0.b(messageDigest);
                        }
                    }
                }
            }
            throw new android.ext.b1$v("hashDex: invalid DEX magic");
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("hash fail", th);
            return th.toString();
        }
    }

    private void o1() {
        android.content.Intent intentN0 = android.ext.Tools.N0(android.ext.r.p, this.f598g, android.ext.r.t().replace(android.ext.Tools.C0(), this.f598g));
        if (!android.ext.x2.h()) {
            android.ext.e1.d("removeInstaller: just installer");
            intentN0.putExtra(android.ext.i.f1000b + ".fromInstaller", true);
        }
        android.ext.r.p.startActivity(intentN0);
    }

    private static void p() {
        try {
            C("self-install.readiness").delete();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed clear readiness trace", th);
        }
    }

    public static final java.lang.String p0(java.io.InputStream inputStream, java.security.MessageDigest messageDigest) {
        int i;
        java.lang.String str;
        int length = 0;
        java.lang.String str2 = null;
        try {
            byte[] bArr = new byte[16384];
            int iY0 = Y0(inputStream, bArr);
            try {
                android.content.pm.PackageInfo packageInfoZ0 = android.ext.Tools.z0(android.ext.Tools.C0());
                i = packageInfoZ0.versionCode;
                str = packageInfoZ0.versionName;
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
                float f2 = 1;
                i = (int) (((18113.3f * f2) - 1958.3f) + 0.5f);
                str = "" + ((f2 * 102.5f) - 1.1f);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("\u0000");
            java.lang.String str3 = android.ext.i.f1002d;
            sb.append((char) str3.length());
            sb.append(str3);
            sb.append((char) 0);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("\u0000");
            java.lang.String str4 = android.ext.i.f1003e;
            sb2.append((char) str4.length());
            sb2.append(str4);
            sb2.append((char) 0);
            byte[][] bArr2 = {sb.toString().getBytes(android.ext.t1.i(true)), sb2.toString().getBytes(android.ext.t1.i(true)), ("\u0000" + ((char) str.length()) + str + (char) 0).getBytes(android.ext.t1.i(true)), v0(null, 0, catch_.me_.if_.you_.can_.R.drawable.ic_gg_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_32_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_64_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_hw_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_h2_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_h4_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_sw_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_s2_48dp), v0(null, 0, catch_.me_.if_.you_.can_.R.mipmap.ic_s4_48dp), v0(v0(null, 4, i), 0, 268435464)};
            for (int i2 = 0; i2 < 13; i2++) {
                byte[] bArr3 = bArr2[i2];
                int iV0 = android.ext.Tools.V0(bArr, bArr3);
                if (iV0 >= 0) {
                    if (i2 == 0) {
                        str2 = android.ext.i.f1000b;
                    } else {
                        if (i2 == 1) {
                            str2 = android.ext.i.f1001c;
                        } else {
                            length = bArr3.length;
                        }
                        java.lang.System.arraycopy(new byte[length], 0, bArr, iV0, length);
                    }
                    length = (str2.length() + 4) * 2;
                    java.lang.System.arraycopy(new byte[length], 0, bArr, iV0, length);
                }
            }
            int i3 = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt(16) * 4;
            java.lang.System.arraycopy(new byte[i3], 0, bArr, 36, i3);
            messageDigest.update(bArr, 0, iY0);
            return android.ext.w0.b(messageDigest);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.l("hash fail", th2);
            return th2.toString();
        }
    }

    private java.util.Map p1() {
        java.util.Map map = this.p;
        if (map != null) {
            return map;
        }
        java.util.HashMap map2 = new java.util.HashMap();
        this.p = map2;
        return map2;
    }

    private static void q() {
        try {
            C("verify-generated-apk.fail").delete();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed clear verify marker", th);
        }
    }

    public static final java.lang.String q0(java.io.InputStream inputStream, java.security.MessageDigest messageDigest) {
        int i;
        try {
            byte[] bArr = new byte[8192];
            java.nio.ByteBuffer byteBufferOrder = java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.LITTLE_ENDIAN);
            while (Z0(inputStream, bArr, 0, 8) != -1) {
                messageDigest.update(bArr, 0, 8);
                android.ext.b1$s b1_s = new android.ext.b1$s(byteBufferOrder);
                short s = b1_s.f637a;
                if (s == 512) {
                    byte[] bArr2 = new byte[260];
                    Z0(inputStream, bArr2, 0, 4);
                    messageDigest.update(bArr2);
                    Z0(inputStream, bArr2, 4, 256);
                    i = b1_s.f639c - 268;
                } else {
                    i = (s == 2 ? b1_s.f638b : b1_s.f639c) - 8;
                }
                n0(inputStream, messageDigest, bArr, i);
            }
            return android.ext.w0.b(messageDigest);
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("hash fail", th);
            return th.toString();
        }
    }

    private void q1() {
        try {
            android.ext.Tools.B0().setInstallerPackageName(this.f598g, null);
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    private static void r(java.lang.StringBuilder sb, java.util.zip.ZipEntry zipEntry) {
        if (zipEntry == null) {
            return;
        }
        sb.append('-');
        sb.append(zipEntry.getSize());
        sb.append(' ');
    }

    private static void r0() {
        android.widget.Button button = (android.widget.Button) E.get();
        if (button != null) {
            button.setOnClickListener(new android.ext.b1$c());
        }
        android.widget.ProgressBar progressBar = (android.widget.ProgressBar) G.get();
        if (progressBar != null) {
            progressBar.setIndeterminate(false);
        }
        F.run();
    }

    private static void r1(java.lang.String str) {
        android.ext.n2.i(new android.ext.b1$l(str));
    }

    private static byte[] s(byte[] bArr) {
        android.ext.b1$t b1_t;
        int[] iArrC;
        int[] iArrC2;
        android.ext.b1$t b1_tB;
        int[] iArrC3;
        int[] iArrC4;
        android.ext.b1$t b1_tB2;
        int[] iArrC5;
        int[] iArrC6;
        if (bArr != null && (iArrC = (b1_t = new android.ext.b1$t(bArr)).c(48)) != null && b1_t.a()) {
            android.ext.b1$t b1_tB3 = b1_t.b(iArrC);
            if (b1_tB3.c(6) != null && (iArrC2 = b1_tB3.c(160)) != null && b1_tB3.a() && (iArrC3 = (b1_tB = b1_tB3.b(iArrC2)).c(48)) != null && b1_tB.a()) {
                android.ext.b1$t b1_tB4 = b1_tB.b(iArrC3);
                if (b1_tB4.c(2) != null && b1_tB4.c(49) != null && b1_tB4.c(48) != null && b1_tB4.c(160) != null && (iArrC4 = b1_tB4.c(49)) != null && b1_tB4.a() && (iArrC5 = (b1_tB2 = b1_tB4.b(iArrC4)).c(48)) != null && b1_tB2.a()) {
                    android.ext.b1$t b1_tB5 = b1_tB2.b(iArrC5);
                    if (b1_tB5.c(2) != null && b1_tB5.c(48) != null && b1_tB5.c(48) != null && b1_tB5.c(48) != null && (iArrC6 = b1_tB5.c(4)) != null && b1_tB5.a()) {
                        return b1_tB5.d(iArrC6);
                    }
                }
            }
        }
        return null;
    }

    private java.lang.String s0() throws java.io.IOException {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        boolean z2;
        java.lang.String str = null;
        boolean zJ1;
        I1();
        java.lang.String absolutePath = this.f594c.getAbsolutePath();
        java.lang.String[] strArr = absolutePath.contains("/emulated/0") ? new java.lang.String[]{absolutePath.replace("/emulated/0", "/emulated/legacy"), absolutePath} : new java.lang.String[]{absolutePath};
        for (java.lang.String str2 : strArr) {
            try {
                android.ext.Tools.q(new java.io.File(str2), 493);
            } catch (java.lang.Throwable th_c) {
                android.ext.e1.s("Failed allow execute 1: " + str2, th_c);
            }
            try {
                android.ext.Tools.r(str2, "0755");
            } catch (java.lang.Throwable th2) {
                android.ext.e1.s("Failed allow execute 2: " + str2, th2);
            }
        }
        boolean zQ0 = Q0(C.l);
        int length = strArr.length;
        java.lang.String str3 = "Install:";
        boolean z3 = true;
        int i = 0;
        while (i < length) {
            java.lang.String str4 = strArr[i];
            if (!zQ0) {
                break;
            }
            if (z3) {
                R1("root-install-start");
                z2 = false;
            } else {
                z2 = z3;
            }
            try {
                if (android.os.Build.VERSION.SDK_INT < 24) {
                    I1();
                    str = str3 + '\n' + android.ext.e2.n(k1(str4), 45);
                } else {
                    java.lang.String strC0 = C0();
                    try {
                        java.lang.String strN = android.ext.e2.n(n1(strC0), 45);
                        str3 = str3 + '\n' + strN;
                        zJ1 = j1(strN);
                        if (zJ1) {
                            try {
                                I1();
                                str3 = str3 + '\n' + android.ext.e2.n(l1(str4, strC0), 45);
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                if (zJ1) {
                                    java.lang.String strN2 = android.ext.e2.n(m1(strC0), 45);
                                    if (!j1(strN2)) {
                                        android.ext.e1.p("root stage cleanup: " + strN2);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (zJ1) {
                            java.lang.String strN3 = android.ext.e2.n(m1(strC0), 45);
                            if (!j1(strN3)) {
                                android.ext.e1.p("root stage cleanup: " + strN3);
                            }
                        }
                        str = str3;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        zJ1 = false;
                    }
                }
            } catch (java.lang.Throwable th5) {
                android.ext.e1.l("run cmd fail", th5);
                str = str3 + '\n' + th5.getMessage();
            }
            str3 = str;
            R1("root-install-return");
            if (android.ext.Tools.e1(this.f598g)) {
                R1("package-installed");
                break;
            }
            i++;
            z3 = z2;
        }
        if (!android.ext.Tools.e1(this.f598g)) {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                C.h = false;
                Q1(4);
                android.ext.b1$r b1_rH = h(C.i || C.l == 2, u0());
                C.i = false;
                if (b1_rH == android.ext.b1$r.OPEN_SETTINGS) {
                    R1("unknown-source-settings-start");
                    C.i = true;
                    android.content.Intent intent = new android.content.Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", android.net.Uri.parse("package:" + android.ext.Tools.C0()));
                    android.ext.b1$c0.p = true;
                    android.ext.b1$c0.q = false;
                    try {
                        try {
                            P1(intent, 4);
                            boolean z4 = android.ext.b1$c0.q;
                            C.i = false;
                            android.ext.b1$c0.p = false;
                            android.ext.b1$c0.q = false;
                            if (!z4 || !u0()) {
                                R1("unknown-source-settings-failed");
                                throw new android.ext.b1$v("unknown-source install permission was not granted");
                            }
                        } catch (java.lang.Throwable th6_c_c_c) {
                            android.ext.b1$c0.p = false;
                            android.ext.b1$c0.q = false;
                            throw th6_c_c_c;
                        }
                    } catch (android.content.ActivityNotFoundException e2) {
                        Q1(4);
                        C.i = false;
                        R1("unknown-source-settings-failed");
                        throw new android.ext.b1$v("unknown-source settings are unavailable", e2);
                    } catch (java.lang.RuntimeException e3_c_c_c) {
                        Q1(4);
                        C.i = false;
                        R1("unknown-source-settings-failed");
                        throw e3_c_c_c;
                    }
                } else if (b1_rH == android.ext.b1$r.FAIL_PENDING) {
                    R1("unknown-source-settings-failed");
                    throw new android.ext.b1$v("unknown-source install permission was not granted");
                }
            }
            R1("manual-install-start");
            int i2 = 1;
            C.h = true;
            android.content.Intent[] intentArrA0 = a0();
            L = 0;
            for (android.content.Intent intent2 : intentArrA0) {
                L += i2;
                str3 = str3 + "\nManual: " + intent2;
                try {
                    I1();
                    i2 = 1;
                    try {
                        P1(intent2, 1);
                        break;
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        str3 = str3 + '\n' + th.getMessage();
                    }
                } catch (java.lang.Throwable th8) {
                    th = th8;
                    i2 = 1;
                }
            }
        }
        if (android.ext.Tools.e1(this.f598g)) {
            R1("package-installed");
            C.i = false;
        }
        return str3;
    }

    static void s1(android.ext.b1$c0 b1_c0) {
        C = b1_c0;
    }

    private void t(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        try {
            android.system.Os.rename(this.f595d.getAbsolutePath(), this.f594c.getAbsolutePath());
            if (this.f595d.exists() || !this.f594c.isFile()) {
                throw new android.ext.b1$v("commit rename incomplete");
            }
            C.n = str;
            C.o = str2;
            V1();
        } catch (android.system.ErrnoException e2) {
            throw new java.io.IOException("commit rename failed: " + e2.getMessage(), e2);
        }
    }

    static void t0() {
        android.ext.e2.diag("t0: install start, progress=" + C.f611b);
        z = new byte[x.length][];
        try {
            android.ext.b1 b1Var = new android.ext.b1();
            B = b1Var;
            b1Var.a();
            android.ext.n2.i(new android.ext.b1$n());
        } catch (java.lang.Throwable th) {
            android.ext.e2.diag("t0: install failed: " + th);
            android.ext.e1.l("Failed install", th);
            java.lang.String message = th.getMessage();
            if (message != null && (message.contains("ENOSPC") || message.contains("o space left"))) {
                android.ext.n2.i(new android.ext.b1$o(message));
                return;
            }
            if (!(th instanceof android.ext.b1$v)) {
                android.ext.n0.h(java.lang.Thread.currentThread(), th, false);
            }
            k(false);
            android.ext.n2.i(new android.ext.b1$p(th));
        }
    }

    private static void t1(int i) {
        if (C.f611b != i) {
            J = 0;
        }
        C.f611b = i;
    }

    private void u() throws java.lang.Throwable {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        java.io.FileOutputStream fileOutputStream = null;
        for (int i = 0; i < 2; i++) {
            try {
                if (this.f595d.exists()) {
                    this.f595d.delete();
                }
                java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(this.f595d);
                try {
                    android.ext.Tools.q(this.f595d, 384);
                    fileOutputStream = fileOutputStream2;
                    break;
                } catch (java.lang.Throwable th_c_c_c) {
                    th = th_c_c_c;
                    fileOutputStream = fileOutputStream2;
                    if (i == 1) {
                        throw th_c_c_c;
                    }
                    android.ext.e1.a(th_c_c_c);
                    java.io.File file = new java.io.File(this.f593b, this.f594c.getName());
                    C.f612c = file.getAbsolutePath();
                    this.f594c = file;
                    this.f595d = K0(file);
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        }
        try {
            j(fileOutputStream);
        } catch (java.io.IOException e2_c_c_c) {
            D(fileOutputStream);
            throw e2_c_c_c;
        } catch (java.lang.Error e3_c_c_c) {
            D(fileOutputStream);
            throw e3_c_c_c;
        } catch (java.lang.RuntimeException e4_c_c_c) {
            D(fileOutputStream);
            throw e4_c_c_c;
        }
    }

    static boolean u0() {
        try {
            java.lang.String strPermissionToOp = android.app.AppOpsManager.permissionToOp("android.permission.REQUEST_INSTALL_PACKAGES");
            return strPermissionToOp != null && ((android.app.AppOpsManager) android.ext.Tools.f0().getSystemService("appops")).checkOpNoThrow(strPermissionToOp, android.os.Process.myUid(), android.ext.Tools.C0()) == 0;
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("installPermissionGranted failed", th);
            return false;
        }
    }

    private static void u1() {
        try {
            java.io.File fileW = W(android.ext.Tools.removeNewLinesChars("yhuvlrq1jj"));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            float f2 = 1;
            sb.append(java.lang.Integer.toString((int) (((16452.9f * f2) - 297.9f) + 0.5f)));
            sb.append(':');
            sb.append((f2 * 107.3f) - 5.9f);
            byte[] bytes = sb.toString().getBytes();
            if (fileW.exists()) {
                try {
                    java.io.FileInputStream fileInputStream = new java.io.FileInputStream(fileW);
                    try {
                        int length = bytes.length;
                        byte[] bArr = new byte[length];
                        if (fileInputStream.read(bArr) != length || !java.util.Arrays.equals(bArr, bytes)) {
                            W("installer.fail").delete();
                            java.io.File fileQ0 = android.ext.Tools.q0();
                            java.lang.String[] list = fileQ0.list();
                            if (list != null) {
                                for (java.lang.String str : list) {
                                    if ((str.startsWith("lib") && str.endsWith(".so")) || "gr".equals(str)) {
                                        new java.io.File(fileQ0, str).delete();
                                    }
                                }
                            }
                        }
                        fileInputStream.close();
                    } catch (java.lang.Throwable th_c_c_c) {
                        fileInputStream.close();
                        throw th_c_c_c;
                    }
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.l("Fail get version", th2);
                }
            }
            java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(fileW);
            android.ext.Tools.q(fileW, 384);
            try {
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (java.lang.Throwable th3_c_c_c) {
                fileOutputStream.close();
                throw th3_c_c_c;
            }
        } catch (java.lang.Throwable th4) {
            android.ext.e1.l("Fail set version", th4);
        }
    }

    private void v() {
        for (int i = 0; i < this.k.length; i++) {
            V(i).delete();
            java.io.RandomAccessFile randomAccessFile = this.f592a[i];
            if (randomAccessFile != null) {
                try {
                    android.ext.e1.d("Close: " + i);
                    randomAccessFile.close();
                } catch (java.lang.Throwable th) {
                    android.ext.e1.a(th);
                }
            }
        }
        this.p = null;
        this.q = null;
    }

    private static byte[] v0(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            bArr = new byte[i + 4];
        }
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i + i3] = (byte) ((i2 >> (i3 * 8)) & 255);
        }
        return bArr;
    }

    private static java.lang.String v1(java.io.File file) throws java.security.NoSuchAlgorithmException, java.io.IOException {
        java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA-256");
        java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
        try {
            byte[] bArr = new byte[65536];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i == -1) {
                    fileInputStream.close();
                    return android.ext.m0.i(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (java.lang.Throwable th_c_c_c) {
            fileInputStream.close();
            throw th_c_c_c;
        }
    }

    private static int w(byte[] bArr) {
        if (bArr != null) {
            int i = 2;
            if (bArr.length >= 2) {
                int i2 = 0;
                if (bArr[0] != 48) {
                    return -1;
                }
                byte b2 = bArr[1];
                int i3 = b2 & 255;
                if ((b2 & 128) != 0) {
                    int i4 = b2 & 127;
                    if (i4 == 0 || i4 > 4 || 2 + i4 > bArr.length) {
                        return -1;
                    }
                    int i5 = 0;
                    while (i2 < i4) {
                        i5 = (i5 << 8) | (bArr[i] & 255);
                        i2++;
                        i++;
                    }
                    i3 = i5;
                }
                return i + i3;
            }
        }
        return -1;
    }

    private java.lang.String w0(java.io.File file) {
        if (file == null) {
            android.ext.e1.d("path: " + file + " - null");
            return "is null";
        }
        file.mkdirs();
        java.io.File file2 = new java.io.File(file, "installer.dir.probe");
        try {
            try {
                file2.delete();
                byte[] bytes = "We need test read/write to this file".getBytes();
                byte[] bArr = new byte[bytes.length];
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file2);
                android.ext.Tools.q(file2, 384);
                fileOutputStream.write(bytes);
                fileOutputStream.close();
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file2);
                int i = fileInputStream.read(bArr);
                fileInputStream.close();
                if (i != bytes.length) {
                    java.lang.String str = "Length mismatch: " + i + " != " + bytes.length;
                    file2.delete();
                    return str;
                }
                if (java.util.Arrays.equals(bArr, bytes)) {
                    android.ext.e1.d("path: " + file + " - success");
                    file2.delete();
                    return null;
                }
                java.lang.String str2 = "Data mismatch: '" + new java.lang.String(bArr) + "' != '" + new java.lang.String(bytes) + '\'';
                file2.delete();
                return str2;
            } catch (java.io.IOException e2) {
                android.ext.e1.d("path: " + file + " - fail: " + e2.getMessage());
                java.lang.String message = e2.getMessage();
                file2.delete();
                return message;
            }
        } catch (java.lang.Throwable th_c_c_c) {
            file2.delete();
            throw th_c_c_c;
        }
    }

    private java.lang.String w1(java.lang.String str) {
        byte[] bArr = (byte[]) p1().get(str);
        if (bArr != null) {
            this.n.reset();
            this.n.update(bArr);
            return android.ext.m0.h(this.n.digest());
        }
        throw new android.ext.b1$v("missing secondary dex bytes: " + str);
    }

    private static android.ext.b1$u x(byte[] bArr, int i, int i2, int i3) {
        java.lang.String str = "fixDex: string " + i3 + " is malformed";
        int i5 = 0;
        int i6 = 0;
        do {
            int i7 = i2 - i;
            if (i5 >= i7) {
                throw new android.ext.b1$v(str + ": truncated ULEB128 length");
            }
            int i8 = bArr[i + i5];
            i6 |= (i8 & 127) << (i5 * 7);
            i5++;
            if ((i8 & 128) == 0) {
                if (i6 < 0 || i6 + 1 > i7 - i5) {
                    throw new android.ext.b1$v(str + ": payload overruns its bound");
                }
                int i9 = i + i5;
                char[] cArr = new char[i6];
                for (int i10 = 0; i10 < i6; i10++) {
                    if (i9 >= i2) {
                        throw new android.ext.b1$v(str + ": truncated MUTF-8 payload");
                    }
                    byte b2 = bArr[i9];
                    int i11 = b2 & 255;
                    if (i11 == 0) {
                        throw new android.ext.b1$v(str + ": string shorter than indicated size " + i6);
                    }
                    if (i11 < 128) {
                        cArr[i10] = (char) i11;
                        i9++;
                        continue;
                    }
                    if ((b2 & 224) == 192) {
                        int i4 = i9 + 2;
                        if (i4 <= i2) {
                            byte b3 = bArr[i9 + 1];
                            if ((b3 & 192) == 128) {
                                int i12 = (b3 & 63) | ((b2 & 31) << 6);
                                if (i12 != 0 && i12 < 128) {
                                    throw new android.ext.b1$v(str + ": overlong MUTF-8");
                                }
                                cArr[i10] = (char) i12;
                                i9 = i4;
                                continue;
                            }
                        }
                        throw new android.ext.b1$v(str + ": bad MUTF-8");
                    }
                    if ((b2 & 240) != 224) {
                        throw new android.ext.b1$v(str + ": invalid MUTF-8");
                    }
                    int i14 = i9 + 3;
                    if (i14 <= i2) {
                        byte b4 = bArr[i9 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i9 + 2];
                            if ((b5 & 192) == 128) {
                                int i13 = (b5 & 63) | ((b2 & 15) << 12) | ((b4 & 63) << 6);
                                if (i13 < 2048) {
                                    throw new android.ext.b1$v(str + ": overlong MUTF-8");
                                }
                                cArr[i10] = (char) i13;
                                i9 = i14;
                                continue;
                            }
                        }
                    }
                    throw new android.ext.b1$v(str + ": bad MUTF-8");
                }
                if (i9 < i2 && bArr[i9] == 0) {
                    return new android.ext.b1$u(new java.lang.String(cArr), i6, (i9 - i) + 1);
                }
                throw new android.ext.b1$v(str + ": missing NUL terminator");
            }
        } while (i5 <= 4);
        throw new android.ext.b1$v(str + ": invalid ULEB128 length");
    }

    private static boolean x0(java.lang.String str) {
        if (str == null || str.length() != 64) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && (cCharAt < 'a' || cCharAt > 'f')) {
                return false;
            }
        }
        return true;
    }

    private static java.lang.String x1(byte[] bArr) {try {

        for (java.lang.String str : new java.lang.String(bArr, "UTF-8").split("\r\n|\n", -1)) {
            if (str.isEmpty()) {
                return null;
            }
            int iIndexOf = str.indexOf(58);
            if (iIndexOf > 0 && "SHA-256-Digest-Manifest".equalsIgnoreCase(str.substring(0, iIndexOf).trim())) {
                java.lang.String strTrim = str.substring(iIndexOf + 1).trim();
                if (strTrim.isEmpty()) {
                    return null;
                }
                return strTrim;
            }
        };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        return null;
    }

    private static java.lang.String y(byte[] bArr, int i, int i2) {
        int i3;
        z(bArr, i, i2);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i3 = i + 1;
            int i6 = bArr[i];
            i4 |= (i6 & 127) << (i5 * 7);
            if ((i6 & 128) == 0) {
                break;
            }
            i5++;
            i = i3;
        }
        char[] cArr = new char[i4];
        for (int i7 = 0; i7 < i4; i7++) {
            byte b2 = bArr[i3];
            int i8 = b2 & 255;
            if (i8 < 128) {
                cArr[i7] = (char) i8;
                i3++;
            } else if ((b2 & 224) == 192) {
                int i9 = ((b2 & 31) << 6) | (bArr[i3 + 1] & 63);
                if (i9 != 0 && i9 < 128) {
                    throw new android.ext.b1$v("hashDex: overlong MUTF-8");
                }
                cArr[i7] = (char) i9;
                i3 += 2;
            } else {
                int i10 = ((b2 & 15) << 12) | ((bArr[i3 + 1] & 63) << 6) | (bArr[i3 + 2] & 63);
                if (i10 < 2048) {
                    throw new android.ext.b1$v("hashDex: overlong MUTF-8");
                }
                cArr[i7] = (char) i10;
                i3 += 3;
            }
        }
        return new java.lang.String(cArr);
    }

    private static boolean y0(java.lang.String str) {
        return w.matcher(str).matches();
    }

    private static java.lang.String y1() {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageArchiveInfo = android.ext.Tools.B0().getPackageArchiveInfo(i0().getAbsolutePath(), 64);
            if (packageArchiveInfo != null && (signatureArr = packageArchiveInfo.signatures) != null && signatureArr.length == 1) {
                return l(signatureArr[0]);
            }
            return null;
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
            return null;
        }
    }

    private static int z(byte[] bArr, int i, int i2) {
        boolean z2;
        long j = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= 5) {
                z2 = false;
                break;
            }
            if (i >= i2) {
                throw new android.ext.b1$v("hashDex: truncated ULEB128 length");
            }
            int i5 = i + 1;
            byte b2 = bArr[i];
            if (i4 == 4 && (b2 & 240) != 0) {
                throw new android.ext.b1$v("hashDex: invalid ULEB128 length");
            }
            j |= ((long) (b2 & 127)) << (i4 * 7);
            if ((b2 & 128) == 0) {
                i = i5;
                z2 = true;
                break;
            }
            i4++;
            i = i5;
        }
        if (!z2) {
            throw new android.ext.b1$v("hashDex: invalid ULEB128 length");
        }
        if (j > 2147483647L || 1 + j > i2 - i) {
            throw new android.ext.b1$v("hashDex: string length out of range");
        }
        while (i3 < ((int) j)) {
            if (i >= i2) {
                throw new android.ext.b1$v("hashDex: truncated MUTF-8 payload");
            }
            int i6 = i + 1;
            byte b3 = bArr[i];
            int i7 = b3 & 255;
            if (i7 == 0) {
                throw new android.ext.b1$v("hashDex: string shorter than indicated size");
            }
            if (i7 < 128) {
                i3++;
                i = i6;
            } else if ((b3 & 224) == 192) {
                if (i6 >= i2 || (bArr[i6] & 192) != 128) {
                    throw new android.ext.b1$v("hashDex: bad MUTF-8");
                }
                i3++;
                i += 2;
            } else {
                if ((b3 & 240) != 224) {
                    throw new android.ext.b1$v("hashDex: invalid MUTF-8");
                }
                int i8 = i + 2;
                if (i8 >= i2 || (bArr[i6] & 192) != 128 || (bArr[i8] & 192) != 128) {
                    throw new android.ext.b1$v("hashDex: bad MUTF-8");
                }
                i3++;
                i += 3;
            }
        }
        if (i >= i2 || bArr[i] != 0) {
            throw new android.ext.b1$v("hashDex: missing NUL terminator");
        }
        return i + 1;
    }

    private static boolean z0(java.lang.String str) {
        int length;
        if (str == null || !str.endsWith(".dex")) {
            return false;
        }
        if (!str.regionMatches(0, "classes", 0, 7) || (length = str.length() - 4) <= 7) {
            return false;
        }
        long j = 0;
        for (int i = 7; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
            j = (j * 10) + ((long) (cCharAt - '0'));
            if (j > 2147483647L) {
                break;
            }
        }
        return j >= 2;
    }

    public static void z1() {
        r0();
        new android.ext.n0$i(new android.ext.b1$j(), "Installer").start();
    }

    void E() {
        if (this.r != null) {
            try {
                android.ext.Tools.D(this.r);
                this.r = null;
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Exception on dismiss", th);
            }
        }
    }

    java.io.RandomAccessFile h0(int i) {
        java.io.RandomAccessFile randomAccessFile = this.f592a[i];
        if (randomAccessFile == null) {try {

            randomAccessFile = new java.io.RandomAccessFile(V(i), "rw");
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}try {

            android.ext.e1.d("RAF new: " + i + ' ' + randomAccessFile.getFD());
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
            this.f592a[i] = randomAccessFile;
        }try {

        android.ext.e1.d("RAF get: " + i + ' ' + randomAccessFile.getFD());
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        return randomAccessFile;
    }
}

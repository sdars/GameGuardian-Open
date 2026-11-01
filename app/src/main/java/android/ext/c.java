package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static gg_a.e f669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static gg_a.e f670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static gg_a.e f671g;
    private static gg_a.e h;
    private static final int[] k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f668d = {0, 255, 65535, 16777215, 4294967295L, 1099511627775L, 281474976710655L, 72057594037927935L, -1};
    private static android.util.SparseIntArray i = null;
    private static int j = 16777215;

    static {
        f669e = null;
        f670f = null;
        f671g = null;
        h = null;
        java.lang.Object[] objArrK = android.ext.t1.k();
        gg_a.e eVar = new gg_a.e();
        gg_a.e eVar2 = new gg_a.e();
        U(eVar, eVar2, 1, "B: %s (%,d - %,d)", catch_.me_.if_.you_.can_.R.string.type_byte, objArrK[0], objArrK[1]);
        U(eVar, eVar2, 2, "W: %s (%,d - %,d)", catch_.me_.if_.you_.can_.R.string.type_word, objArrK[2], objArrK[3]);
        U(eVar, eVar2, 4, "D: %s (%,d - %,d)", catch_.me_.if_.you_.can_.R.string.type_dword, objArrK[4], objArrK[5]);
        U(eVar, eVar2, 8, "X: %s (%,d - %,d)", catch_.me_.if_.you_.can_.R.string.type_xor, objArrK[4], objArrK[5]);
        U(eVar, eVar2, 16, "F: %s (%.1e - %.1e)", catch_.me_.if_.you_.can_.R.string.type_float, java.lang.Float.valueOf(-3.4028235E38f), java.lang.Float.valueOf(Float.MAX_VALUE));
        U(eVar, eVar2, 32, "Q: %s (%,d - %,d)", catch_.me_.if_.you_.can_.R.string.type_qword, objArrK[6], objArrK[7]);
        U(eVar, eVar2, 64, "E: %s (%.1e - %.1e)", catch_.me_.if_.you_.can_.R.string.type_double, java.lang.Double.valueOf(-1.7976931348623157E308d), java.lang.Double.valueOf(Double.MAX_VALUE));
        f670f = eVar2;
        f669e = eVar;
        updateLocale();
        gg_a.e eVar3 = new gg_a.e();
        eVar3.append(536870912, "=");
        eVar3.append(67108864, "≥");
        eVar3.append(134217728, "≤");
        eVar3.append(268435456, "≠");
        f671g = eVar3;
        gg_a.e eVar4 = new gg_a.e();
        eVar4.append(536870912, "=");
        eVar4.append(268435456, "≠");
        h = eVar4;
        android.ext.k.h(android.ext.c.class);
        k = new int[]{8, 32, 1, 2, 64, 16, 4};
    }

    protected c() {
    }

    public c(long j2, long j3, int i2) {
        this.f672a = j2;
        this.f673b = j3;
        this.f674c = i2;
    }

    public c(android.ext.c cVar) {
        this(cVar.f672a, cVar.f673b, cVar.f674c);
    }

    public static java.lang.CharSequence A(int i2) {
        return t(i2 & 127).toString().substring(0, 1).intern();
    }

    public static gg_a.e B() {
        return f671g;
    }

    public static gg_a.e C() {
        return h;
    }

    public static int E(int i2) {
        if ((i2 & 96) != 0) {
            return 8;
        }
        if ((i2 & 28) != 0) {
            return 4;
        }
        if ((i2 & 2) != 0) {
            return 2;
        }
        return (i2 & 1) != 0 ? 1 : 8;
    }

    public static java.lang.String G(long j2, int i2) {
        return android.ext.t2.e(8, j(j2, i2));
    }

    public static java.lang.String I(long j2, long j3, int i2) {
        int i3 = i2 & 127;
        java.lang.String strE = null;
        if (i3 == 8) {
            j3 ^= j2;
        } else if (i3 == 16) {
            strE = android.ext.b0.e(j3);
        } else if (i3 == 64 || i3 == 80) {
            strE = android.ext.b0.b(j3);
        }
        return strE == null ? android.ext.i0.c(j3, i3) : strE;
    }

    public static java.lang.String K(long j2, long j3, int i2) {
        return I(j2, j3, i2).trim();
    }

    public static java.lang.String M(long j2, long j3, int i2) {
        return N(j2, j3, i2, false);
    }

    private static java.lang.String N(long j2, long j3, int i2, boolean z) {
        int i3 = i2 & 127;
        if (i3 == 8) {
            j3 ^= j2;
        }
        if (z) {
            int iE = E(i3);
            int i4 = iE * 8;
            long jReverseBytes = java.lang.Long.reverseBytes(j3) >> (64 - i4);
            j3 = iE != 8 ? jReverseBytes & ((1 << i4) - 1) : jReverseBytes;
        }
        return android.ext.i0.d(j3, i3, true);
    }

    public static java.lang.String P(long j2, long j3, int i2) {
        return N(j2, j3, i2, true);
    }

    public static int R(int i2) {
        int i3 = i2 & 127;
        if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 4 || i3 == 8 || i3 == 16 || i3 == 32 || i3 == 64 || i3 == 127) {
            return i3;
        }
        return 127;
    }

    public static int S(long j2, boolean z) {
        return T(j2, z, null);
    }

    public static int T(long j2, boolean z, android.util.SparseIntArray sparseIntArray) {
        int i2;
        long j3 = 3 & j2;
        if (j3 != 0) {
            i2 = 0;
        } else {
            if (z) {
                return 32;
            }
            if (sparseIntArray != null) {
                sparseIntArray.put(32, sparseIntArray.get(32) + 1);
                sparseIntArray.put(64, sparseIntArray.get(64) + 1);
            }
            i2 = 96;
        }
        if (j3 == 0) {
            if (z) {
                return 4;
            }
            i2 |= 28;
            if (sparseIntArray != null) {
                sparseIntArray.put(4, sparseIntArray.get(4) + 1);
                sparseIntArray.put(8, sparseIntArray.get(8) + 1);
                sparseIntArray.put(16, sparseIntArray.get(16) + 1);
            }
        }
        if ((j2 & 1) == 0) {
            if (z) {
                return 2;
            }
            i2 |= 2;
            if (sparseIntArray != null) {
                sparseIntArray.put(2, sparseIntArray.get(2) + 1);
            }
        }
        int i3 = i2 | 1;
        if (sparseIntArray != null) {
            sparseIntArray.put(1, sparseIntArray.get(1) + 1);
        }
        return i3;
    }

    private static void U(gg_a.e eVar, gg_a.e eVar2, int i2, java.lang.String str, int i3, java.lang.Object obj, java.lang.Object obj2) {
        java.lang.String strF = android.ext.b2.f(i3);
        int iN = n(i2);
        eVar.append(i2, android.ext.Tools.t(android.ext.Tools.L1(str, strF, obj, obj2), iN));
        eVar2.append(i2, android.ext.Tools.t(strF, iN));
    }

    public static android.ext.t1$b W(android.ext.t1$b t1_b, java.lang.String str, int i2, int i3, long j2) {
        try {
            return android.ext.t1.p(t1_b, str, i2, true, j2);
        } catch (java.lang.NumberFormatException e2_c_c_c) {
            java.lang.String strF = android.ext.b2.f(i3);
            android.ext.e1.s("Failed parse '" + str + "' as " + i2 + " on '" + strF + '\'', e2_c_c_c);
            if ((e2_c_c_c instanceof android.ext.t1$a) || (e2_c_c_c instanceof android.ext.n$b)) {
                throw e2_c_c_c;
            }
            java.lang.NumberFormatException numberFormatException = new java.lang.NumberFormatException(strF + ": " + e2_c_c_c.getMessage());
            numberFormatException.initCause(e2_c_c_c);
            throw numberFormatException;
        }
    }

    public static long d(android.ext.t1$b t1_b, java.lang.String str, int i2) {
        return W(t1_b, str, i2 & 127, catch_.me_.if_.you_.can_.R.string.number_name, 0L).f1261a;
    }

    public static long e(long j2, java.lang.String str, int i2) {
        int i3 = i2 & 127;
        long j3 = W(null, str, i3, catch_.me_.if_.you_.can_.R.string.number_name, j2).f1261a;
        return i3 == 8 ? j3 ^ j2 : j3;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0029 A[PHI: r0
      0x0029: PHI (r0v8 int) = (r0v4 int), (r0v11 int) binds: [B:27:0x0048, B:17:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    public static int g(int i2, long j2, boolean z) {
        int i3;
        if (i2 == 80 || i2 == 64) {
            return i2;
        }
        if (z) {
            i3 = (j2 >> 7) == -1 ? 0 : 1;
            if ((j2 >> 15) != -1) {
                i3 |= 2;
            }
            if ((j2 >> 31) != -1) {
                i3 |= 12;
            }
        } else {
            i3 = (j2 >> 8) == 0 ? 0 : 1;
            if ((j2 >> 16) != 0) {
                i3 |= 2;
            }
            if ((j2 >> 32) != 0) {
                i3 |= 12;
            }
        }
        return i2 & (~i3);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x001e  */
    /* JADX WARN: Instruction removed from duplicated block: B:17:0x001e, please report this as an issue */
    public static long h(long j2, int i2) {
        long j3;
        int i4 = i2 & 127;
        if (i4 == 1) {
            j3 = (byte) j2;
        } else if (i4 == 2) {
            j3 = (short) j2;
        } else if (i4 == 4 || i4 == 8) {
            j3 = (int) j2;
        } else {
            j3 = j2;
        }
        if (j2 != j3) {
            android.ext.e1.d("fixValue[" + i2 + ", " + java.lang.Integer.toHexString(i2) + "]: " + j2 + '[' + java.lang.Long.toHexString(j2) + "] -> " + j3 + '[' + java.lang.Long.toHexString(j3) + ']');
        }
        return j3;
    }

    public static long j(long j2, int i2) {
        return j2;
    }

    public static int l(int i2) {
        if ((i2 & 96) != 0 || (i2 & 28) != 0) {
            return 4;
        }
        if ((i2 & 2) != 0) {
            return 2;
        }
        return (i2 & 1) != 0 ? 1 : 4;
    }

    public static int n(int i2) {
        try {
            android.util.SparseIntArray sparseIntArray = i;
            if (sparseIntArray == null) {
                sparseIntArray = new android.util.SparseIntArray(8);
                sparseIntArray.append(1, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_byte));
                sparseIntArray.append(2, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_word));
                sparseIntArray.append(4, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_dword));
                sparseIntArray.append(8, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_xor));
                sparseIntArray.append(16, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_float));
                sparseIntArray.append(32, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_qword));
                sparseIntArray.append(64, android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_double));
                i = sparseIntArray;
                j = android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.type_unknown);
            }
            int i3 = sparseIntArray.get(R(i2));
            return i3 == 0 ? j : i3;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed getColor for: " + i2, th);
            return j;
        }
    }

    public static gg_a.e o(int i2) {
        return p(i2, 0L);
    }

    public static gg_a.e p(int i2, long j2) {
        gg_a.e eVarQ = q(i2);
        eVarQ.remove(127);
        long j3 = 3 & j2;
        if (j3 != 0) {
            eVarQ.remove(32);
            eVarQ.remove(64);
        }
        if (j3 != 0) {
            eVarQ.remove(4);
            eVarQ.remove(8);
            eVarQ.remove(16);
        }
        if ((j2 & 1) != 0) {
            eVarQ.remove(2);
        }
        return eVarQ;
    }

    public static gg_a.e q(int i2) {
        return r(i2, false);
    }

    public static gg_a.e r(int i2, boolean z) {
        gg_a.e eVar = new gg_a.e();
        int size = f669e.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iKeyAt = f669e.keyAt(i3);
            if ((i2 & iKeyAt) == iKeyAt) {
                eVar.append(iKeyAt, (java.lang.CharSequence) f669e.valueAt(i3));
            }
        }
        if (z && eVar.get(i2) == null) {
            eVar.append(i2, (java.lang.CharSequence) f669e.get(127));
        }
        return eVar;
    }

    public static java.lang.String s(int i2) {
        if (i2 == 0 || (i2 & 64) != 0) {
            return android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_edit_limit), android.ext.Tools.L1("%.1e", java.lang.Double.valueOf(-1.7976931348623157E308d)), android.ext.Tools.L1("%.1e", java.lang.Double.valueOf(Double.MAX_VALUE)));
        }
        if ((i2 & 16) != 0) {
            return android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_edit_limit), android.ext.Tools.L1("%.1e", java.lang.Float.valueOf(-3.4028235E38f)), android.ext.Tools.L1("%.1e", java.lang.Float.valueOf(Float.MAX_VALUE)));
        }
        java.lang.Object[] objArrK = android.ext.t1.k();
        int iY = y(i2) * 2;
        return android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_edit_limit), android.ext.Tools.L1("%,d", objArrK[iY]), android.ext.Tools.L1("%,d", objArrK[iY + 1]));
    }

    public static java.lang.CharSequence t(int i2) {
        java.lang.CharSequence charSequence = (java.lang.CharSequence) f669e.get(R(i2));
        return charSequence == null ? "Unknown" : charSequence;
    }

    public static void updateLocale() {
        U(f669e, f670f, 127, "A: %s (%.1e - %.1e) (" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.slow) + ')', catch_.me_.if_.you_.can_.R.string.type_auto, java.lang.Double.valueOf(-1.7976931348623157E308d), java.lang.Double.valueOf(Double.MAX_VALUE));
    }

    public static java.lang.CharSequence v(int i2) {
        java.lang.CharSequence charSequence = (java.lang.CharSequence) f670f.get(R(i2));
        return charSequence == null ? "Unknown" : charSequence;
    }

    public static int w(int i2) {
        if (i2 == 1) {
            return 50;
        }
        if (i2 == 2) {
            return 40;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 8) {
            return 70;
        }
        if (i2 == 16) {
            return 20;
        }
        if (i2 != 32) {
            return i2 != 64 ? 250 : 30;
        }
        return 60;
    }

    public static android.ext.c$a[] x(gg_a.e eVar, android.util.SparseIntArray sparseIntArray) {
        int size = eVar.size();
        android.ext.c$a[] c_aArr = new android.ext.c$a[size];
        if (size == 1) {
            int iKeyAt = eVar.keyAt(0);
            c_aArr[0] = new android.ext.c$a(iKeyAt, (java.lang.CharSequence) eVar.valueAt(0), sparseIntArray == null ? 0 : sparseIntArray.get(iKeyAt));
        } else {
            boolean[] zArr = new boolean[size];
            int i2 = size - 1;
            for (int i3 = 0; i3 < size; i3++) {
                int iKeyAt2 = eVar.keyAt(i3);
                if (iKeyAt2 > -10) {
                    break;
                }
                c_aArr[i2] = new android.ext.c$a(iKeyAt2, (java.lang.CharSequence) eVar.valueAt(i3), sparseIntArray == null ? 0 : sparseIntArray.get(iKeyAt2));
                zArr[i3] = true;
                i2--;
            }
            for (int i4 : k) {
                int iIndexOfKey = eVar.indexOfKey(i4);
                if (iIndexOfKey >= 0 && !zArr[iIndexOfKey]) {
                    c_aArr[i2] = new android.ext.c$a(i4, (java.lang.CharSequence) eVar.valueAt(iIndexOfKey), sparseIntArray == null ? 0 : sparseIntArray.get(i4));
                    zArr[iIndexOfKey] = true;
                    i2--;
                }
            }
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                if (!zArr[i6]) {
                    int iKeyAt3 = eVar.keyAt(i6);
                    c_aArr[i5] = new android.ext.c$a(iKeyAt3, (java.lang.CharSequence) eVar.valueAt(i6), sparseIntArray == null ? 0 : sparseIntArray.get(iKeyAt3));
                    i5++;
                }
            }
        }
        return c_aArr;
    }

    public static int y(int i2) {
        if ((i2 & 96) != 0) {
            return 3;
        }
        if ((i2 & 28) != 0) {
            return 2;
        }
        if ((i2 & 2) != 0) {
            return 1;
        }
        return (i2 & 1) != 0 ? 0 : 3;
    }

    public int D() {
        return E(this.f674c);
    }

    public java.lang.String F() {
        return G(this.f672a, this.f674c);
    }

    public java.lang.String H() {
        return I(this.f672a, this.f673b, this.f674c);
    }

    public java.lang.String J() {
        return K(this.f672a, this.f673b, this.f674c);
    }

    public java.lang.String L() {
        return N(this.f672a, this.f673b, this.f674c, false);
    }

    public java.lang.String O() {
        return N(this.f672a, this.f673b, this.f674c, true);
    }

    public int Q() {
        return R(this.f674c);
    }

    public boolean V() {
        return (this.f672a & ((long) (k() - 1))) == 0;
    }

    public void X(java.lang.String str) {
        this.f673b = e(this.f672a, str, this.f674c);
    }

    public void a() {
        b(0);
    }

    public void b(int i2) {
        android.ext.MainService.instance.i.a(this, i2);
    }

    public android.ext.c c() {
        return new android.ext.c(this);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof android.ext.c)) {
            return false;
        }
        android.ext.c cVar = (android.ext.c) obj;
        if (this.f672a != cVar.f672a) {
            return false;
        }
        return ((cVar.f674c ^ this.f674c) & 127) == 0;
    }

    public android.ext.c$b f(android.ext.c$b c_b, android.ext.t1$b t1_b, java.lang.String str, long j2, java.lang.String str2, int i2) {
        if (t1_b == null) {
            t1_b = W(null, str, this.f674c, catch_.me_.if_.you_.can_.R.string.number_name, j2);
        }
        long jDoubleToRawLongBits = t1_b.f1261a;
        if (i2 != 0) {
            if (c_b == null) {
                android.ext.t1$b t1_bW = W(null, str2, this.f674c, catch_.me_.if_.you_.can_.R.string.step_name, 0L);
                android.ext.c$b c_b2 = new android.ext.c$b();
                c_b2.f678a = java.lang.Float.intBitsToFloat((int) t1_bW.f1261a);
                c_b2.f679b = java.lang.Double.longBitsToDouble(t1_bW.f1261a);
                c_b2.f680c = t1_bW.f1261a;
                c_b = c_b2;
            }
            int i3 = t1_b.f1263c;
            if (i3 == 16) {
                jDoubleToRawLongBits = java.lang.Float.floatToRawIntBits(java.lang.Float.intBitsToFloat((int) jDoubleToRawLongBits) + (c_b.f678a * i2));
            } else {
                jDoubleToRawLongBits = i3 == 64 ? java.lang.Double.doubleToRawLongBits(java.lang.Double.longBitsToDouble(jDoubleToRawLongBits) + (c_b.f679b * ((double) i2))) : jDoubleToRawLongBits + (c_b.f680c * ((long) i2));
            }
        }
        if (this.f674c == 8) {
            jDoubleToRawLongBits ^= this.f672a;
        }
        this.f673b = jDoubleToRawLongBits;
        return c_b;
    }

    public int hashCode() {
        long j2 = this.f672a;
        return ((((int) (j2 ^ (j2 >>> 32))) + 31) * 31) + (this.f674c & 127);
    }

    public long i() {
        return j(this.f672a, this.f674c);
    }

    public int k() {
        return l(this.f674c);
    }

    public int m() {
        return n(this.f674c);
    }

    public java.lang.String toString() {
        return F() + ": " + H() + ' ' + ((java.lang.Object) u()) + " (" + this.f674c + ')';
    }

    public java.lang.CharSequence u() {
        return v(this.f674c);
    }

    public java.lang.CharSequence z() {
        return A(this.f674c);
    }
}

package luaj;

/* JADX INFO: loaded from: classes.dex */
public abstract class LuaValue extends luaj.Varargs {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final java.lang.String[] f1672b = {"nil", "boolean", "lightuserdata", "number", "string", "table", "function", "userdata", "thread", "value"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final luaj.LuaValue f1673c = new luaj.LuaNil();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final luaj.LuaBoolean f1674d = new luaj.LuaBoolean(true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final luaj.LuaBoolean f1675e = new luaj.LuaBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final luaj.LuaValue f1676f = new luaj.LuaValue$None(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final luaj.LuaNumber f1677g = luaj.LuaLong.I2(0);
    public static final luaj.LuaNumber h = luaj.LuaLong.I2(1);
    public static final luaj.LuaNumber i = luaj.LuaLong.I2(-1);
    public static final luaj.LuaValue[] j = new luaj.LuaValue[0];
    public static final luaj.LuaString k = luaj.LuaString.i3("_ENV");
    public static final luaj.LuaString l = luaj.LuaString.i3("__index");
    public static final luaj.LuaString m = luaj.LuaString.i3("__newindex");
    public static final luaj.LuaString n = luaj.LuaString.i3("__call");
    public static final luaj.LuaString o = luaj.LuaString.i3("__mode");
    public static final luaj.LuaString p = luaj.LuaString.i3("__metatable");
    public static final luaj.LuaString q = luaj.LuaString.i3("__add");
    public static final luaj.LuaString r = luaj.LuaString.i3("__sub");
    public static final luaj.LuaString s = luaj.LuaString.i3("__div");
    public static final luaj.LuaString t = luaj.LuaString.i3("__mul");
    public static final luaj.LuaString u = luaj.LuaString.i3("__pow");
    public static final luaj.LuaString v = luaj.LuaString.i3("__mod");
    public static final luaj.LuaString w = luaj.LuaString.i3("__unm");
    public static final luaj.LuaString x = luaj.LuaString.i3("__len");
    public static final luaj.LuaString y = luaj.LuaString.i3("__eq");
    public static final luaj.LuaString z = luaj.LuaString.i3("__lt");
    public static final luaj.LuaString A = luaj.LuaString.i3("__le");
    public static final luaj.LuaString B = luaj.LuaString.i3("__tostring");
    public static final luaj.LuaString C = luaj.LuaString.i3("__concat");
    public static final luaj.LuaString D = luaj.LuaString.i3("__idiv");
    public static final luaj.LuaString E = luaj.LuaString.i3("__bnot");
    public static final luaj.LuaString F = luaj.LuaString.i3("__band");
    public static final luaj.LuaString G = luaj.LuaString.i3("__bor");
    public static final luaj.LuaString H = luaj.LuaString.i3("__bxor");
    public static final luaj.LuaString I = luaj.LuaString.i3("__shl");
    public static final luaj.LuaString J = luaj.LuaString.i3("__shr");
    public static final luaj.LuaString K = luaj.LuaString.i3("__name");
    public static final luaj.LuaString L = luaj.LuaString.i3("");
    public static final luaj.LuaString M = luaj.LuaString.i3("0");
    public static final luaj.LuaString N = luaj.LuaString.i3("1");
    public static final luaj.LuaValue[] O = new luaj.LuaValue[250];

    static {
        for (int i2 = 0; i2 < 250; i2++) {
            O[i2] = f1673c;
        }
    }

    public static luaj.LuaNumber C1(java.lang.String str) {
        if (str.length() <= 20 && str.indexOf(46) == -1 && str.indexOf(101) == -1 && str.indexOf(69) == -1) {
            try {
                return luaj.LuaLong.I2(java.lang.Long.parseLong(str));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        return luaj.LuaDouble.J2(java.lang.Double.parseDouble(str));
    }

    public static luaj.LuaBoolean H2(boolean z2) {
        return z2 ? f1674d : f1675e;
    }

    public static luaj.LuaLong I2(long j2) {
        return luaj.LuaLong.I2(j2);
    }

    public static luaj.LuaNumber J2(double d2) {
        return luaj.LuaDouble.J2(d2);
    }

    public static luaj.LuaString K2(java.lang.String str) {
        return luaj.LuaString.K2(str);
    }

    public static luaj.LuaString L2(byte[] bArr, int i2, int i3) {
        return luaj.LuaString.L2(bArr, i2, i3);
    }

    public static luaj.Varargs M2(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.Varargs varargs) {
        return varargs.U() != 0 ? new luaj.Varargs$a(new luaj.LuaValue[]{luaValue, luaValue2}, 0, 2, varargs) : new luaj.Varargs$c(luaValue, luaValue2);
    }

    public static luaj.LuaValue N1(java.lang.CharSequence charSequence) {
        char cCharAt;
        boolean z2;
        char cCharAt2;
        char cCharAt3;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && gg_g.g.P0(charSequence.charAt(i2))) {
            i2++;
        }
        double d2 = 1.0d;
        if (i2 < length && ((cCharAt3 = charSequence.charAt(i2)) == '-' || cCharAt3 == '+')) {
            d2 = cCharAt3 == '-' ? -1.0d : 1.0d;
            i2++;
        }
        if (i2 + 2 >= length) {
            return null;
        }
        int i3 = i2 + 1;
        if (charSequence.charAt(i2) != '0') {
            return null;
        }
        char cCharAt4 = charSequence.charAt(i3);
        if (cCharAt4 != 'x' && cCharAt4 != 'X') {
            return null;
        }
        int i4 = i2 + 2;
        double d3 = 0.0d;
        long j2 = 0;
        double dH0 = 0.0d;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            char cCharAt5 = charSequence.charAt(i4);
            if (!gg_g.g.Q0(cCharAt5)) {
                break;
            }
            int iH0 = gg_g.g.H0(cCharAt5);
            if (i5 != 0 || iH0 != 0) {
                if (i5 < 30) {
                    dH0 = (dH0 * 16.0d) + ((double) iH0);
                } else {
                    i6 += 4;
                }
                j2 = (j2 * 16) + ((long) iH0);
                i5++;
            }
            i4++;
        }
        if (i4 < length && charSequence.charAt(i4) == '.') {
            i5 += 8388608;
            i4++;
            int i7 = Integer.MAX_VALUE;
            int i8 = Integer.MAX_VALUE;
            while (i4 < length) {
                char cCharAt6 = charSequence.charAt(i4);
                if (!gg_g.g.Q0(cCharAt6)) {
                    break;
                }
                if (i8 == i7 && dH0 != d3) {
                    i8 = i4 + 30;
                }
                if (i4 < i8) {
                    dH0 = (dH0 * 16.0d) + ((double) gg_g.g.H0(cCharAt6));
                    i6 -= 4;
                    i5++;
                }
                i4++;
                i7 = Integer.MAX_VALUE;
                d3 = 0.0d;
            }
        }
        if ((8388607 & i5) == 0) {
            return null;
        }
        if (i4 < length && ((cCharAt = charSequence.charAt(i4)) == 'p' || cCharAt == 'P')) {
            i5 += 16777216;
            int i9 = i4 + 1;
            if (i9 >= length || !((cCharAt2 = charSequence.charAt(i9)) == '-' || cCharAt2 == '+')) {
                z2 = false;
            } else {
                i9 = i4 + 2;
                z2 = cCharAt2 == '-';
            }
            int i10 = i9;
            int i11 = 0;
            boolean z3 = false;
            while (i10 < length) {
                char cCharAt7 = charSequence.charAt(i10);
                if (!gg_g.g.O0(cCharAt7)) {
                    break;
                }
                i11 = ((i11 * 10) + cCharAt7) - 48;
                i10++;
                z3 = true;
            }
            if (!z3) {
                return null;
            }
            if (z2) {
                i11 = -i11;
            }
            i6 += i11;
            i4 = i10;
        }
        while (i4 < length && gg_g.g.P0(charSequence.charAt(i4))) {
            i4++;
        }
        if (i4 != length) {
            return null;
        }
        if (i5 >= 8388608) {
            return J2(d2 * dH0 * java.lang.Math.pow(2.0d, i6));
        }
        if (d2 <= 0.0d) {
            j2 = -j2;
        }
        return luaj.LuaLong.I2(j2);
    }

    public static luaj.Varargs N2(luaj.LuaValue luaValue, luaj.Varargs varargs) {
        return varargs.U() != 0 ? new luaj.Varargs$c(luaValue, varargs) : luaValue;
    }

    public static luaj.LuaValue O1(java.lang.String str) {
        return (str.indexOf(120) >= 0 || str.indexOf(88) >= 0) ? N1(str) : C1(str.trim());
    }

    public static luaj.Varargs O2(luaj.LuaValue[] luaValueArr) {
        int length = luaValueArr.length;
        if (length == 0) {
            return f1676f;
        }
        if (length != 1) {
            return length != 2 ? new luaj.Varargs$b(luaValueArr, f1676f) : new luaj.Varargs$c(luaValueArr[0], luaValueArr[1]);
        }
        return luaValueArr[0];
    }

    public static luaj.LuaValue P1(java.lang.String str, luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueO1;
        try {
            luaValueO1 = O1(str);
        } catch (java.lang.NumberFormatException unused) {
            luaValueO1 = null;
        }
        return luaValueO1 == null ? luaValue : luaValueO1;
    }

    public static luaj.Varargs P2(luaj.LuaValue[] luaValueArr, int i2, int i3) {
        if (i3 == 0) {
            return f1676f;
        }
        if (i3 != 1) {
            return i3 != 2 ? new luaj.Varargs$a(luaValueArr, i2, i3, f1676f) : new luaj.Varargs$c(luaValueArr[i2], luaValueArr[i2 + 1]);
        }
        return luaValueArr[i2];
    }

    public static final boolean Q0(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaValue luaValueV0;
        luaj.LuaValue luaValueV1 = f1673c;
        luaj.LuaValue luaValueV2 = luaValue.V0();
        if (luaValueV2 != null) {
            luaValueV1 = luaValueV2.V1(y);
        }
        if (luaValueV1.l1() && (luaValueV0 = luaValue2.V0()) != null) {
            luaValueV1 = luaValueV0.V1(y);
        }
        if (luaValueV1.l1()) {
            return false;
        }
        return luaValueV1.call(luaValue, luaValue2).w2();
    }

    public static luaj.Varargs Q2(luaj.LuaValue[] luaValueArr, int i2, int i3, luaj.Varargs varargs) {
        if (i3 == 0) {
            return varargs;
        }
        if (i3 == 1) {
            return varargs.U() > 0 ? new luaj.Varargs$c(luaValueArr[i2], varargs) : luaValueArr[i2];
        }
        if (i3 == 2 && varargs.U() <= 0) {
            return new luaj.Varargs$c(luaValueArr[i2], luaValueArr[i2 + 1]);
        }
        return new luaj.Varargs$a(luaValueArr, i2, i3, varargs);
    }

    public static luaj.LuaValue R0(java.lang.String str) {
        throw new luaj.d(str);
    }

    public static luaj.Varargs R2(luaj.LuaValue[] luaValueArr, luaj.Varargs varargs) {
        int length = luaValueArr.length;
        if (length == 0) {
            return varargs;
        }
        if (length == 1) {
            return varargs.U() > 0 ? new luaj.Varargs$c(luaValueArr[0], varargs) : luaValueArr[0];
        }
        if (length == 2 && varargs.U() <= 0) {
            return new luaj.Varargs$c(luaValueArr[0], luaValueArr[1]);
        }
        return new luaj.Varargs$b(luaValueArr, varargs);
    }

    public static luaj.LuaValue S0(java.lang.String str, java.lang.Throwable th) {
        throw new luaj.d(str, th);
    }

    protected static luaj.LuaValue W0(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaValue luaValueX1;
        luaj.LuaValue luaValueV1;
        int i2 = 0;
        while (true) {
            if (luaValue.o1()) {
                luaValueV1 = luaValue.V1(luaValue2);
                if (!luaValueV1.l1()) {
                    break;
                }
                luaj.LuaValue luaValueX2 = luaValue.x1(l);
                if (luaValueX2.l1()) {
                    break;
                }
                luaValueX1 = luaValueX2;
            } else {
                luaValueX1 = luaValue.x1(l);
                if (luaValueX1.l1()) {
                    luaValue.b1(luaValue2.g0());
                }
            }
            if (luaValueX1.g1()) {
                return luaValueX1.call(luaValue, luaValue2);
            }
            i2++;
            if (i2 >= 100) {
                R0("loop in gettable");
                return f1673c;
            }
            luaValue = luaValueX1;
        }
        return luaValueV1;
    }

    private void b1(java.lang.String str) {
        R0("attempt to index ? (a " + D2() + " value) with key '" + str + '\'');
    }

    public static luaj.LuaValue k0(int i2, java.lang.String str) {
        throw new luaj.c(i2, null, str);
    }

    public static luaj.LuaValue l0(int i2, java.lang.String str, java.lang.String str2) {
        throw new luaj.c(i2, str, str2);
    }

    protected static boolean l2(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        luaj.LuaValue luaValueX1;
        int i2 = 0;
        while (true) {
            if (!luaValue.o1()) {
                luaValueX1 = luaValue.x1(m);
                if (luaValueX1.l1()) {
                    throw new luaj.d("table expected for set index ('" + luaValue2 + "') value, got " + luaValue.D2());
                }
            } else {
                if (!luaValue.V1(luaValue2).l1()) {
                    break;
                }
                luaValueX1 = luaValue.x1(m);
                if (luaValueX1.l1()) {
                    break;
                }
            }
            if (luaValueX1.g1()) {
                luaValueX1.call(luaValue, luaValue2, luaValue3);
                return true;
            }
            i2++;
            if (i2 >= 100) {
                R0("loop in settable");
                return false;
            }
            luaValue = luaValueX1;
        }
        luaValue.d2(luaValue2, luaValue3);
        return true;
    }

    public static luaj.LuaValue n0(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        luaj.LuaValue luaValueX1 = luaValue2.x1(luaValue);
        if (luaValueX1.l1()) {
            luaValueX1 = luaValue3.x1(luaValue);
            if (luaValueX1.l1()) {
                R0("attempt to perform arithmetic " + luaValue + " on a " + luaValue2.E2() + " value and a " + luaValue3.E2() + " value");
            }
        }
        return luaValueX1.call(luaValue2, luaValue3);
    }

    public static luaj.LuaValue p0(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        luaj.LuaValue luaValue4;
        luaj.LuaValue luaValueX1 = luaValue2.x1(luaValue);
        if (luaValueX1.l1()) {
            luaValueX1 = luaValue3.x1(luaValue);
            if (luaValueX1.l1()) {
                if (!luaValue2.m1() || luaValue2.k1()) {
                    luaValue4 = (!luaValue3.m1() || luaValue3.k1()) ? null : luaValue3;
                } else {
                    luaValue4 = luaValue2;
                }
                java.lang.String strV2 = v2(luaValue);
                if (luaValue4 != null) {
                    throw new luaj.d("number '" + luaValue4.g0() + "' has no integer representation (for bitwise operation '" + luaValue2.g0() + " " + strV2 + " " + luaValue3.g0() + "')");
                }
                R0("attempt to perform bitwise operation " + strV2 + " on a " + luaValue2.D2() + " value and a " + luaValue3.D2() + " value");
            }
        }
        return luaValueX1.call(luaValue2, luaValue3);
    }

    public static luaj.LuaTable s2() {
        return new luaj.LuaTable();
    }

    public static luaj.LuaTable t2(luaj.Varargs varargs, int i2) {
        return new luaj.LuaTable(varargs, i2);
    }

    public static luaj.LuaTable u2(luaj.LuaValue[] luaValueArr) {
        return new luaj.LuaTable(luaValueArr, null, null);
    }

    public static java.lang.String v2(luaj.LuaValue luaValue) {
        if (luaValue == F) {
            return "&";
        }
        if (luaValue == G) {
            return "|";
        }
        if (luaValue == H) {
            return "~";
        }
        if (luaValue == I) {
            return "<<";
        }
        return luaValue == J ? ">>" : luaValue.g0();
    }

    protected static luaj.e w1(luaj.LuaValue luaValue) {
        if (luaValue == null || !luaValue.o1()) {
            if (luaValue != null) {
                return new luaj.f(luaValue);
            }
            return null;
        }
        luaj.LuaValue luaValueV1 = luaValue.V1(o);
        if (luaValueV1.n1()) {
            java.lang.String strG0 = luaValueV1.g0();
            boolean z2 = strG0.indexOf(107) >= 0;
            boolean z3 = strG0.indexOf(118) >= 0;
            if (z2 || z3) {
                return new luaj.WeakTable(z2, z3, luaValue);
            }
        }
        return (luaj.LuaTable) luaValue;
    }

    public int A0() {
        m0("int");
        return 0;
    }

    public luaj.LuaValue A1() {
        return D0(w, "attempt to perform arithmetic on ").call(this);
    }

    public luaj.LuaValue A2() {
        return f1673c;
    }

    public java.lang.String B0() {
        m0("string");
        return null;
    }

    public luaj.LuaValue B1() {
        return f1675e;
    }

    public luaj.LuaValue B2() {
        return f1673c;
    }

    public long C0() {
        m0("long");
        return 0L;
    }

    public abstract int C2();

    protected luaj.LuaValue D0(luaj.LuaValue luaValue, java.lang.String str) {
        luaj.LuaValue luaValueX1 = x1(luaValue);
        if (!luaValueX1.l1()) {
            return luaValueX1;
        }
        if (luaValue == E && m1()) {
            throw new luaj.d("number has no integer representation (for bitwise operation '~" + g0() + "')");
        }
        throw new luaj.d(str + "a " + E2() + " value");
    }

    public luaj.Varargs D1(luaj.Varargs varargs, boolean z2) {
        return invoke(varargs);
    }

    public abstract java.lang.String D2();

    public luaj.LuaNumber E0() {
        m0("number");
        return null;
    }

    public boolean E1(boolean z2) {
        m0("boolean");
        return false;
    }

    public java.lang.String E2() {
        luaj.LuaValue luaValueX1 = x1(K);
        return luaValueX1.n1() ? luaValueX1.g0() : D2();
    }

    public luaj.LuaNumber F0(java.lang.String str) {
        throw new luaj.d(str);
    }

    public double F1(double d2) {
        m0("number");
        return 0.0d;
    }

    protected luaj.LuaValue F2(java.lang.String str) {
        throw new luaj.d(str + " expected, got " + E2());
    }

    public luaj.LuaString G0() {
        m0("string");
        return null;
    }

    public luaj.LuaFunction G1(luaj.LuaFunction luaFunction) {
        m0("function");
        return null;
    }

    protected luaj.LuaValue G2(java.lang.String str) {
        throw new luaj.d('\'' + str + "' not implemented for " + D2());
    }

    public luaj.LuaTable H0() {
        m0("table");
        return null;
    }

    public int H1(int i2) {
        m0("int");
        return 0;
    }

    public luaj.LuaThread I0() {
        m0("thread");
        return null;
    }

    public java.lang.String I1(java.lang.String str) {
        m0("String");
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if (r0.l1() == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public luaj.LuaValue J0(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        java.lang.String str;
        luaj.LuaValue luaValueX1 = x1(luaValue);
        if (luaValueX1.l1()) {
            luaValueX1 = luaValue2.x1(luaValue);
            if (luaValueX1.l1()) {
                if (A.T1(luaValue)) {
                    luaj.LuaString luaString = z;
                    luaj.LuaValue luaValueX2 = x1(luaString);
                    if (luaValueX2.l1()) {
                        luaValueX2 = luaValue2.x1(luaString);
                    }
                    return luaValueX2.call(luaValue2, this).B1();
                }
                java.lang.String strE2 = E2();
                java.lang.String strE3 = luaValue2.E2();
                if (strE2.equals(strE3)) {
                    str = "two " + strE2 + " values";
                } else {
                    str = strE2 + " with " + strE3;
                }
                return R0("attempt to compare " + str);
            }
        }
        return luaValueX1.call(this, luaValue2);
    }

    public long J1(long j2) {
        m0("long");
        return 0L;
    }

    public luaj.LuaValue K0(luaj.LuaValue luaValue) {
        return N0(luaValue);
    }

    public luaj.LuaString K1(luaj.LuaString luaString) {
        m0("string");
        return null;
    }

    public luaj.LuaValue L0(luaj.LuaNumber luaNumber) {
        return luaNumber.N0(this);
    }

    public luaj.LuaTable L1(luaj.LuaTable luaTable) {
        m0("table");
        return null;
    }

    public luaj.LuaValue M0(luaj.LuaString luaString) {
        return luaString.N0(this);
    }

    public luaj.LuaValue M1(luaj.LuaValue luaValue) {
        return this;
    }

    public luaj.LuaValue N0(luaj.LuaValue luaValue) {
        luaj.LuaValue luaValue2;
        luaj.LuaString luaString = C;
        luaj.LuaValue luaValueX1 = x1(luaString);
        if (luaValueX1.l1()) {
            luaValueX1 = luaValue.x1(luaString);
            if (luaValueX1.l1()) {
                if (n1()) {
                    luaValue2 = !luaValue.n1() ? luaValue : null;
                } else {
                    luaValue2 = this;
                }
                if (luaValue2 != null) {
                    throw new luaj.d("attempt to concatenate a " + luaValue2.D2() + " value");
                }
                R0("attempt to concatenate " + D2() + " and " + luaValue.D2());
            }
        }
        return luaValueX1.call(this, luaValue);
    }

    public luaj.LuaValue O0(luaj.LuaValue luaValue) {
        return n0(s, this, luaValue);
    }

    public boolean P0(luaj.LuaValue luaValue) {
        return this == luaValue;
    }

    public luaj.LuaValue Q1(luaj.LuaValue luaValue) {
        return n0(u, this, luaValue);
    }

    public void R1(int i2) {
        F2("table");
    }

    public boolean S1(luaj.LuaString luaString) {
        return false;
    }

    public luaj.LuaValue T0(java.lang.String str) {
        return U0(K2(str));
    }

    public boolean T1(luaj.LuaValue luaValue) {
        return this == luaValue;
    }

    @Override // luaj.Varargs
    public int U() {
        return 1;
    }

    public luaj.LuaValue U0(luaj.LuaValue luaValue) {
        return W0(this, luaValue);
    }

    public luaj.LuaValue U1(java.lang.String str) {
        return V1(K2(str));
    }

    public luaj.LuaValue V0() {
        return null;
    }

    public luaj.LuaValue V1(luaj.LuaValue luaValue) {
        return G2("rawget");
    }

    public int W1() {
        F2("table or string");
        return 0;
    }

    public boolean X0(luaj.LuaValue luaValue) {
        return luaValue.J0(A, this).w2();
    }

    public void X1(int i2, java.lang.String str) {
        if (str != null) {
            Y1(i2, K2(str));
        }
    }

    public boolean Y0(luaj.LuaValue luaValue) {
        return luaValue.J0(z, this).w2();
    }

    public void Y1(int i2, luaj.LuaValue luaValue) {
        if (luaValue != null) {
            d2(I2(i2), luaValue);
        }
    }

    public luaj.LuaValue Z0(luaj.LuaValue luaValue) {
        return n0(D, this, luaValue);
    }

    public void Z1(java.lang.String str, double d2) {
        if (str != null) {
            d2(K2(str), J2(d2));
        }
    }

    protected luaj.LuaValue a1(java.lang.String str, java.lang.String str2) {
        throw new luaj.d("illegal operation '" + str + "' for " + str2);
    }

    public void a2(java.lang.String str, int i2) {
        if (str != null) {
            d2(K2(str), I2(i2));
        }
    }

    public void b2(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        d2(K2(str), K2(str2));
    }

    public void c1(luaj.LuaValue luaValue) {
    }

    public void c2(java.lang.String str, luaj.LuaValue luaValue) {
        if (str == null || luaValue == null) {
            return;
        }
        d2(K2(str), luaValue);
    }

    public luaj.LuaValue call() {
        return u0().call(this);
    }

    public luaj.LuaValue call(java.lang.String str) {
        return call(K2(str));
    }

    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        return u0().call(this, luaValue);
    }

    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return u0().call(this, luaValue, luaValue2);
    }

    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        return u0().invoke(new luaj.LuaValue[]{this, luaValue, luaValue2, luaValue3}).w();
    }

    public boolean d1() {
        return false;
    }

    public void d2(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        if (luaValue == null || luaValue2 == null) {
            return;
        }
        G2("rawset");
    }

    @Override // luaj.Varargs
    public luaj.Varargs e0(int i2) {
        if (i2 == 1) {
            return this;
        }
        return i2 > 1 ? f1676f : k0(1, "start must be > 0");
    }

    public boolean e1() {
        return false;
    }

    public void e2(int i2, luaj.LuaValue luaValue) {
        if (luaValue != null) {
            j2(luaj.LuaLong.I2(i2), luaValue);
        }
    }

    public boolean equals(java.lang.Object obj) {
        return this == obj;
    }

    public boolean f1() {
        return false;
    }

    public void f2(java.lang.String str, double d2) {
        if (str != null) {
            j2(K2(str), J2(d2));
        }
    }

    @Override // luaj.Varargs
    public java.lang.String g0() {
        return E2() + ": " + java.lang.Integer.toHexString(hashCode());
    }

    public boolean g1() {
        return false;
    }

    public void g2(java.lang.String str, int i2) {
        if (str != null) {
            j2(K2(str), I2(i2));
        }
    }

    public boolean h1() {
        return false;
    }

    public void h2(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        j2(K2(str), K2(str2));
    }

    public boolean i1() {
        return false;
    }

    public void i2(java.lang.String str, luaj.LuaValue luaValue) {
        if (str == null || luaValue == null) {
            return;
        }
        j2(K2(str), luaValue);
    }

    public luaj.Varargs invoke() {
        return invoke(f1676f);
    }

    public luaj.Varargs invoke(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.Varargs varargs) {
        return invoke(M2(luaValue, luaValue2, varargs));
    }

    public luaj.Varargs invoke(luaj.LuaValue luaValue, luaj.Varargs varargs) {
        return invoke(N2(luaValue, varargs));
    }

    public luaj.Varargs invoke(luaj.Varargs varargs) {
        return u0().invoke(this, varargs);
    }

    public luaj.Varargs invoke(luaj.LuaValue[] luaValueArr) {
        return invoke(O2(luaValueArr));
    }

    public luaj.Varargs invoke(luaj.LuaValue[] luaValueArr, luaj.Varargs varargs) {
        return invoke(R2(luaValueArr, varargs));
    }

    public luaj.LuaValue j0(luaj.LuaValue luaValue) {
        return n0(q, this, luaValue);
    }

    public boolean j1() {
        return false;
    }

    public void j2(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        if (luaValue == null || luaValue2 == null) {
            return;
        }
        l2(this, luaValue, luaValue2);
    }

    public boolean k1() {
        return false;
    }

    public luaj.LuaValue k2(luaj.LuaValue luaValue) {
        return m0("table");
    }

    public boolean l1() {
        return false;
    }

    protected luaj.LuaValue m0(java.lang.String str) {
        throw new luaj.d("bad argument: " + str + " expected, got " + E2());
    }

    public boolean m1() {
        return false;
    }

    public luaj.LuaValue m2(luaj.LuaValue luaValue) {
        return p0(I, this, luaValue);
    }

    public boolean n1() {
        return false;
    }

    public luaj.LuaValue n2(luaj.LuaValue luaValue) {
        return p0(J, this, luaValue);
    }

    public luaj.LuaValue o0(luaj.LuaValue luaValue) {
        return p0(F, this, luaValue);
    }

    public boolean o1() {
        return false;
    }

    public int o2(luaj.LuaString luaString) {
        R0("attempt to compare " + D2());
        return 0;
    }

    public boolean p1() {
        return false;
    }

    public luaj.LuaValue p2() {
        return this;
    }

    public luaj.LuaValue q0() {
        return D0(E, "attempt to perform bitwise on ").call(this);
    }

    public boolean q1() {
        return true;
    }

    public luaj.LuaString q2() {
        F2("string or number");
        return null;
    }

    public luaj.LuaValue r0(luaj.LuaValue luaValue) {
        return p0(G, this, luaValue);
    }

    public luaj.LuaValue r1() {
        return D0(x, "attempt to get length of ").call(this);
    }

    public luaj.LuaValue r2(luaj.LuaValue luaValue) {
        return n0(r, this, luaValue);
    }

    public gg_f.a s0() {
        return new gg_f.a(this);
    }

    public int s1() {
        return r1().y2();
    }

    public luaj.LuaValue t0(luaj.LuaValue luaValue) {
        return p0(H, this, luaValue);
    }

    public luaj.LuaValue t1(luaj.LuaValue luaValue) {
        return luaValue.call(L, this);
    }

    @Override // luaj.Varargs
    public java.lang.String toString() {
        return g0();
    }

    protected luaj.LuaValue u0() {
        return D0(n, "attempt to call ");
    }

    public boolean u1(luaj.LuaValue luaValue) {
        return J0(z, luaValue).w2();
    }

    @Override // luaj.Varargs
    public luaj.LuaValue v(int i2) {
        return i2 == 1 ? this : f1673c;
    }

    public boolean v0() {
        m0("boolean");
        return false;
    }

    public boolean v1(luaj.LuaValue luaValue) {
        return J0(A, luaValue).w2();
    }

    @Override // luaj.Varargs
    public luaj.LuaValue w() {
        return this;
    }

    public luaj.LuaClosure w0() {
        m0("closure");
        return null;
    }

    public boolean w2() {
        return true;
    }

    public double x0() {
        m0("number");
        return 0.0d;
    }

    public luaj.LuaValue x1(luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueV0 = V0();
        return luaValueV0 == null ? f1673c : luaValueV0.V1(luaValue);
    }

    public double x2() {
        return 0.0d;
    }

    public luaj.LuaFunction y0() {
        m0("function");
        return null;
    }

    public luaj.LuaValue y1(luaj.LuaValue luaValue) {
        return n0(v, this, luaValue);
    }

    public int y2() {
        return 0;
    }

    public luaj.Globals z0() {
        m0("globals");
        return null;
    }

    public luaj.LuaValue z1(luaj.LuaValue luaValue) {
        return n0(t, this, luaValue);
    }

    public long z2() {
        return 0L;
    }
}

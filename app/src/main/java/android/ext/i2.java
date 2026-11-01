package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class i2 extends android.ext.j2 implements android.view.View.OnClickListener {
    public static java.lang.String l;

    public i2() {
        super(catch_.me_.if_.you_.can_.R.string.search_known_value, catch_.me_.if_.you_.can_.R.drawable.ic_magnify_white_24dp);
    }

    private static boolean A(byte b2, long j, long j2, int i, int i2, long j3, long j4, boolean z, long j5) {
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        if (mainService.p0 != 0 && z) {
            mainService.n(b2);
        }
        if (mainService.p0 == 0) {
            mainService.q0 = false;
            mainService.i.x0(b2);
        }
        mainService.R(b2);
        mainService.r0 = false;
        mainService.i.r0(b2, j, j2, i, i2, j3, j4, j5);
        android.ext.MainService.N0(i2, b2);
        return false;
    }

    private static boolean k(byte b2, java.lang.String str, int i, boolean z, boolean z2, int i2, long j, long j2, boolean z3, long j3) {
        android.ext.i2$a i2_aV = v(str.trim(), i, z);
        int i3 = z ? 4194304 : 0;
        java.lang.String str2 = "";
        if (z2) {
            str2 = "" + android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.does_not_support), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_group_search_title), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.mode_hacking)) + '\n';
        }
        if (i2 == 536870912 || i2 == 268435456) {
            i3 |= i2;
        } else {
            str2 = str2 + android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.does_not_support), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_group_search_title), android.ext.c.B().get(i2)) + '\n';
        }
        int i4 = i3;
        if (str2.length() <= 0) {
            return z(b2, i2_aV.f1009a, i2_aV.f1010b, i2_aV.f1011c, i2_aV.f1012d, i4, j, j2, z3, j3);
        }
        throw new java.lang.NumberFormatException(str2);
    }

    private static boolean l(byte b2, java.lang.String str, int i, boolean z, int i2, long j, long j2, boolean z2, long j3, int i3) {
        java.lang.String strTrim = str.trim();
        android.ext.i2$c i2_cX = x(strTrim, true);
        int i4 = i2_cX != null ? i2_cX.f1018b : 0;
        if (i2_cX != null) {
            strTrim = i2_cX.f1017a;
        }
        android.ext.i2$b i2_bW = w(null, strTrim, i, i2);
        java.lang.String str2 = "";
        if (z) {
            str2 = "" + android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.does_not_support), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_range_search_title), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.mode_hacking)) + '\n';
        }
        if (i2 != 536870912 && i2 != 268435456) {
            str2 = str2 + android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.does_not_support), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_range_search_title), android.ext.c.B().get(i2)) + '\n';
        }
        if (str2.length() > 0) {
            throw new java.lang.NumberFormatException(str2);
        }
        if (i4 != 0) {
            i2_bW.f1015c |= 2097152;
        }
        return A(b2, i2_bW.f1013a, i2_bW.f1014b, i4, i2_bW.f1015c | i2_bW.f1016d | i3, j, j2, z2, j3);
    }

    public static boolean m(byte b2, int i, byte[] bArr, long j, long j2, boolean z, long j3) {
        int iD = i & 127;
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (mainService.p0 != 0 && !z) {
            iD &= android.ext.MainService.D() & 127;
        }
        int i2 = iD;
        if (i2 == 0) {
            mainService.n(b2);
            return true;
        }
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        if (mainService.p0 != 0 && z) {
            mainService.n(b2);
        }
        if (mainService.p0 == 0) {
            mainService.q0 = false;
            mainService.i.x0(b2);
        }
        mainService.R(b2);
        mainService.r0 = false;
        mainService.i.s0(b2, i2, bArr, j, j2, j3);
        android.ext.MainService.N0(i2, b2);
        return false;
    }

    public static boolean n(byte b2, java.lang.String str, int i, boolean z, int i2, long j, long j2, boolean z2, long j3) {
        return o(b2, str, i, z, i2, j, j2, z2, j3, 0);
    }

    public static boolean o(byte b2, java.lang.String str, int i, boolean z, int i2, long j, long j2, boolean z2, long j3, int i3) {
        java.lang.String str2;
        java.lang.String str3 = str;
        int iD = i & 127;
        int i4 = i2 & 1006632960;
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (android.ext.t1.m(str)) {
            boolean zM = m(b2, str3.charAt(0) == ';' ? 2 : 1, android.ext.t1.h(str), j, j2, z2, j3);
            l = str3;
            return zM;
        }
        if (str3.indexOf(59) != -1) {
            return k(b2, str, iD, str3.contains("::"), z, i4, j, j2, z2, j3);
        }
        if (str3.indexOf(126) != -1 && android.ext.t1.C(str) == 0) {
            return l(b2, str, iD, z, i4, j, j2, z2, j3, i3);
        }
        if (mainService.p0 != 0 && !z2) {
            iD &= android.ext.MainService.D() & 127;
        }
        if (iD == 0) {
            mainService.n(b2);
            return true;
        }
        android.ext.i2$c i2_cX = x(str3, true);
        int i5 = i2_cX != null ? i2_cX.f1018b : 0;
        if (i2_cX != null) {
            str3 = i2_cX.f1017a;
        }
        android.ext.t1$b t1_b = new android.ext.t1$b();
        long jD = android.ext.c.d(t1_b, str3, iD);
        int iG = iD & t1_b.f1263c;
        if (java.lang.Integer.bitCount(iG) > 1) {
            iG = android.ext.c.g(iG, jD, t1_b.f1262b);
        } else if (!z && iG != 16 && iG != 64 && ((i4 == 134217728 || i4 == 67108864) && str3.indexOf(45) == -1 && (jD & (1 << ((android.ext.c.E(iG) * 8) - 1))) != 0)) {
            android.ext.e1.d("unsigned search 1: '" + str3 + "' " + java.lang.Integer.toHexString(iG) + ' ' + z + ' ' + java.lang.Integer.toHexString(i4));
            if (i4 == 134217728) {
                str2 = str3 + "~0";
                i4 = 268435456;
            } else if (i4 == 67108864) {
                str2 = str3 + "~-1";
                i4 = 536870912;
            } else {
                str2 = str3;
            }
            android.ext.e1.d("unsigned search 2: '" + str2 + "' " + java.lang.Integer.toHexString(iG) + ' ' + z + ' ' + java.lang.Integer.toHexString(i4));
            return o(b2, str2, iG, z, i4, j, j2, z2, j3, i3);
        }
        int i6 = iG;
        if (z && i5 == 0) {
            i4 = 33554432;
        }
        int i7 = i6 | i4;
        if (i5 != 0) {
            if (z) {
                throw new java.lang.NumberFormatException(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.does_not_support), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_xor_search_title), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.mode_hacking)));
            }
            i7 |= 2097152;
        }
        int i8 = i7 | i3;
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        if (mainService.p0 != 0 && z2) {
            mainService.n(b2);
        }
        if (mainService.p0 == 0) {
            mainService.q0 = false;
            mainService.i.x0(b2);
        }
        mainService.R(b2);
        mainService.r0 = false;
        mainService.i.p0(b2, jD, i5, i8, j, j2, j3);
        android.ext.MainService.N0(i6, b2);
        return false;
    }

    public static boolean p(byte b2, short s, long j, long j2, long j3) {
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (mainService.p0 == 0) {
            mainService.n(b2);
            return true;
        }
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        mainService.R(b2);
        mainService.r0 = false;
        android.ext.z1$d z1_d = mainService.v0;
        int i = (z1_d == null || !z1_d.n) ? 4 : 32;
        mainService.i.q0(b2, s, i, j, j2, j3);
        android.ext.MainService.N0(i, b2);
        return false;
    }

    public static boolean q(java.lang.String str, int i, boolean z, int i2, long j, long j2, boolean z2, long j3) {
        return r(str, i, z, i2, j, j2, z2, j3, 0);
    }

    public static boolean r(java.lang.String str, int i, boolean z, int i2, long j, long j2, boolean z2, long j3, int i3) {
        java.lang.String str2;
        java.lang.String strH = android.ext.j2.h(str);
        boolean zO = o((byte) 0, strH, i, z, i2, j, j2, z2, j3, i3);
        android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
        if (c2Var != null) {
            if ((i3 & 1048576) != 0) {
                str2 = "\n-- pointer search by address: not recorded (no gg.searchNumber/gg.refineNumber equivalent for the ARM64 tag-normalizing pointer comparison)\n";
            } else {
                if (z2) {
                    c2Var.write("\ngg.clearResults()\n");
                }
                c2Var.write((z2 || android.ext.MainService.instance.p0 == 0) ? "gg.searchNumber(" : "gg.refineNumber(");
                android.ext.Script$Consts.c(c2Var, strH);
                c2Var.write(", ");
                android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, i);
                c2Var.write(", ");
                c2Var.write(java.lang.Boolean.toString(z));
                c2Var.write(", ");
                android.ext.Script$Consts.a(c2Var, c2Var.f697c.f374d, i2);
                c2Var.write(", ");
                android.ext.Script$Consts.b(c2Var, j);
                c2Var.write(", ");
                android.ext.Script$Consts.b(c2Var, j2);
                c2Var.write(", ");
                c2Var.write(java.lang.Long.toString(j3));
                str2 = ")\n";
            }
            c2Var.write(str2);
        }
        return zO;
    }

    private static void s(android.ext.i2$b i2_b, java.lang.String str) {
        int i = i2_b.f1015c & 127;
        long jE = 1 << ((android.ext.c.E(i) * 8) - 1);
        if (java.lang.Integer.bitCount(i) != 1 || i == 16 || i == 64 || str.indexOf(45) != -1 || (i2_b.f1013a & jE) != 0 || (i2_b.f1014b & jE) == 0) {
            return;
        }
        android.ext.e1.d("unsigned search 3: '" + str + "' " + i2_b.f1013a + ' ' + i2_b.f1014b + ' ' + java.lang.Integer.toHexString(i) + ' ' + java.lang.Integer.toHexString(i2_b.f1016d));
        long j = i2_b.f1014b;
        i2_b.f1014b = i2_b.f1013a;
        i2_b.f1013a = j;
        i2_b.f1016d = i2_b.f1016d == 536870912 ? 268435456 : 536870912;
        android.ext.e1.d("unsigned search 4: '" + str + "' " + i2_b.f1013a + ' ' + i2_b.f1014b + ' ' + java.lang.Integer.toHexString(i) + ' ' + java.lang.Integer.toHexString(i2_b.f1016d));
    }

    public static int t(java.lang.String str, int i, boolean z) {
        try {
            android.ext.i2$a i2_aV = v(str, i, z);
            int length = i2_aV.f1011c.length - 1;
            int iE = 0;
            for (int i2 = 0; i2 < length; i2++) {
                iE += android.ext.c.E(i2_aV.f1011c[i2]);
            }
            return iE + 1;
        } catch (java.lang.NumberFormatException unused) {
            return 2;
        }
    }

    private static android.ext.i2$a v(java.lang.String str, int i, boolean z) {
        java.lang.String strTrim = str.trim();
        java.lang.String str2 = z ? "::" : ":";
        java.lang.String[] strArrSplit = strTrim.split(str2);
        if (strArrSplit.length > 2) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.too_many) + " '" + str2 + '\'');
        }
        int i2 = (int) (strArrSplit.length == 1 ? 512L : android.ext.t1.x(strArrSplit[1]).f1261a);
        if (i2 < 2 || i2 > 65536) {
            android.ext.t1$a t1_a = new android.ext.t1$a(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.invalid_area), 2, 65536) + ' ' + i2);
            t1_a.a(65536L);
            throw t1_a;
        }
        java.lang.String[] strArrSplit2 = strArrSplit[0].split(";");
        if (strArrSplit2.length < 2) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.union_need_two_numbers));
        }
        if (strArrSplit2.length > 64) {
            throw new java.lang.NumberFormatException(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.too_many_union_numbers) + ": 64");
        }
        android.ext.i2$a i2_a = new android.ext.i2$a(strArrSplit2.length);
        android.ext.t1$b t1_bO = null;
        for (int i3 = 0; i3 < strArrSplit2.length; i3++) {
            if (strArrSplit2[i3].indexOf(126) != -1) {
                android.ext.i2$b i2_bW = w(t1_bO, strArrSplit2[i3], i, 536870912);
                i2_a.f1009a[i3] = i2_bW.f1013a;
                i2_a.f1010b[i3] = i2_bW.f1014b;
                i2_a.f1011c[i3] = i2_bW.f1016d | i2_bW.f1015c;
            } else {
                t1_bO = android.ext.t1.o(t1_bO, strArrSplit2[i3], i, false);
                i2_a.f1009a[i3] = t1_bO.f1261a;
                i2_a.f1010b[i3] = 0;
                i2_a.f1011c[i3] = t1_bO.f1263c;
            }
        }
        i2_a.f1012d = i2;
        return i2_a;
    }

    public static android.ext.i2$b w(android.ext.t1$b t1_b, java.lang.String str, int i, int i2) {
        java.lang.String strTrim;
        java.lang.String strTrim2 = str.trim();
        java.lang.String str2 = "~~";
        if (strTrim2.contains("~~")) {
            i2 = i2 == 536870912 ? 268435456 : 536870912;
        } else {
            str2 = "~";
        }
        java.lang.String[] strArrSplit = strTrim2.split(str2);
        if (strArrSplit.length > 2) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.too_many) + " '" + str2 + '\'');
        }
        if (strArrSplit.length != 2) {
            strArrSplit = (java.lang.String[]) java.util.Arrays.copyOf(strArrSplit, 2);
        }
        long[] jArr = new long[2];
        int[] iArr = new int[2];
        int i3 = 1;
        while (true) {
            if (i3 < 0) {
                break;
            }
            java.lang.String str3 = strArrSplit[i3];
            strTrim = str3 != null ? str3.trim() : "";
            t1_b = android.ext.t1.o(t1_b, strTrim, i3 == 1 ? i : iArr[1], false);
            if (i == 127 && t1_b.f1263c == 64 && "BWDXFQEAbwdxfqea".indexOf(strTrim.charAt(strTrim.length() - 1)) == -1) {
                t1_b.f1263c |= 16;
            }
            jArr[i3] = t1_b.f1261a;
            iArr[i3] = t1_b.f1263c;
            i3--;
        }
        int i4 = iArr[0] & iArr[1];
        strTrim = i4 == 0 ? "" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.range_bounds_diff_types) + '\n' : "";
        if (strTrim.length() > 0) {
            throw new java.lang.NumberFormatException(strTrim);
        }
        if (i == 127 && (i4 & 32) == 0) {
            for (int i5 = 0; i5 < 2; i5++) {
                if ((iArr[i5] & 32) != 0) {
                    jArr[i5] = java.lang.Double.doubleToRawLongBits(jArr[i5]);
                }
            }
        }
        android.ext.i2$b i2_b = new android.ext.i2$b();
        i2_b.f1013a = jArr[0];
        i2_b.f1014b = jArr[1];
        i2_b.f1015c = i4;
        i2_b.f1016d = i2;
        s(i2_b, strTrim2);
        return i2_b;
    }

    public static android.ext.i2$c x(java.lang.String str, boolean z) {
        if (android.ext.t1.m(str) || android.ext.t1.C(str) != 0) {
            return null;
        }
        if (str.indexOf(88) == -1 && str.indexOf(120) == -1) {
            return null;
        }
        android.ext.i2$c i2_c = new android.ext.i2$c();
        java.lang.String[] strArrSplit = str.split("[Xx]");
        java.lang.String str2 = strArrSplit.length == 2 ? strArrSplit[1] : "";
        int i = (int) android.ext.t1.o(null, str2, 2, false).f1261a;
        i2_c.f1017a = strArrSplit.length > 0 ? strArrSplit[0] : "";
        if (!z || (i >= 1 && i <= 4096)) {
            i2_c.f1018b = i;
            return i2_c;
        }
        android.ext.t1$a t1_a = new android.ext.t1$a(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.number_out_of_range), str2) + " [1; 4096]");
        t1_a.c(str2);
        throw t1_a;
    }

    private static boolean z(byte b2, long[] jArr, long[] jArr2, int[] iArr, int i, int i2, long j, long j2, boolean z, long j3) {
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        if (mainService.p0 != 0 && z) {
            mainService.n(b2);
        }
        if (mainService.p0 == 0) {
            mainService.q0 = false;
            mainService.i.x0(b2);
        }
        mainService.Q();
        mainService.r0 = false;
        mainService.i.n0(b2, i2, i, iArr, jArr, jArr2, j, j2, j3);
        int i3 = 0;
        for (int i4 : iArr) {
            i3 |= i4;
        }
        android.ext.MainService.N0(i3, b2);
        return false;
    }

    @Override // android.ext.j2
    public void j(android.content.DialogInterface dialogInterface, int i) {
        q(this.j.f(), i, this.j.p(), this.j.i(), this.j.e(0), this.j.e(1), this.i == -3, this.j.b());
    }

    @Override // android.ext.j2, android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        this.f1037f = this.j.f();
        this.f1038g = this.j.i();
        android.ext.MainService.O0 = this.j.j();
        super.onDismiss(dialogInterface);
    }

    public void u(java.lang.String str) {
        if (str == null) {
            str = "";
        }
        this.f1037f = str;
        a().performClick();
    }

    public void y(java.lang.String str) {
        a().performClick();
        android.ext.MemoryRange memoryRange = this.j.y;
        memoryRange.setType(2);
        memoryRange.setAddress(str);
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static android.ext.b0$a f582b = new android.ext.b0$a(0, 0, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final java.text.DecimalFormat f583c = new java.text.DecimalFormat("0.0#######E0");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final java.text.DecimalFormat f584d = new java.text.DecimalFormat("###,###,##0.0##########");

    public static java.lang.String a(double d2) {
        double dAbs = java.lang.Math.abs(d2);
        return (((1.0E-6d >= dAbs || dAbs >= 1.0E10d) && dAbs != 0.0d) ? f583c : f584d).format(d2).replace('E', 'e');
    }

    public static java.lang.String b(long j) {
        return a(java.lang.Double.longBitsToDouble(j));
    }

    public static java.lang.String c(float f2) {
        return a(f2);
    }

    public static java.lang.String d(int i) {
        return c(java.lang.Float.intBitsToFloat(i));
    }

    public static java.lang.String e(long j) {
        return d((int) j);
    }

    public static android.ext.b0$a f(long j, long j2, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, int i2) {
        long j3;
        int i3;
        long j4;
        int i4;
        double dLongBitsToDouble;
        int i5;
        int i6;
        int i7 = j != 0 ? 1 : 0;
        if (j2 != -1) {
            i7 |= 2;
        }
        if (str != null) {
            i7 |= 4;
            android.ext.t1$b t1_bO = android.ext.t1.o(null, str.trim(), 127, false);
            long j5 = t1_bO.f1261a;
            i3 = t1_bO.f1263c;
            j3 = j5;
        } else {
            j3 = 0;
            i3 = 0;
        }
        if (str2 != null) {
            i7 |= 8;
            android.ext.t1$b t1_bO2 = android.ext.t1.o(null, str2.trim(), 127, false);
            long j6 = t1_bO2.f1261a;
            i4 = t1_bO2.f1263c;
            j4 = j6;
        } else {
            j4 = 0;
            i4 = 0;
        }
        if (i != 0) {
            i7 |= 16;
        }
        if (str3 != null) {
            java.lang.String strTrim = str3.trim();
            i7 |= 32;
            if (strTrim.length() <= 0 || strTrim.charAt(0) != '!') {
                i6 = 536870912;
            } else {
                strTrim = strTrim.substring(1);
                i6 = 268435456;
            }
            i5 = i6;
            dLongBitsToDouble = java.lang.Double.longBitsToDouble(android.ext.t1.o(null, strTrim, 64, false).f1261a);
        } else {
            dLongBitsToDouble = 0.0d;
            i5 = 0;
        }
        return new android.ext.b0$a(i2 != 0 ? i7 | 64 : i7, j, j2, j3, i3, j4, i4, i, i5, dLongBitsToDouble, i2);
    }

    public static void g() {
        h((byte) 0, i(), 0, f582b);
    }

    public static void h(byte b2, int i, int i2, android.ext.b0$a b0_a) {
        android.ext.MainService.instance.i.Y(b2, i, i2, b0_a.f585a, b0_a.f586b, b0_a.f587c, b0_a.f588d, b0_a.f589e, b0_a.f590f, b0_a.f591g, b0_a.h, b0_a.i, b0_a.j, b0_a.k);
    }

    public static int i() {
        return f581a;
    }

    public static void j(android.ext.MainService mainService) {
        int iM;
        try {
            iM = m(android.ext.Tools.M0().getString(android.ext.b2.b(catch_.me_.if_.you_.can_.R.id.eMaxShow), "100"));
        } catch (java.lang.NumberFormatException unused) {
            iM = 100;
        }
        p(iM);
    }

    public static boolean k() {
        return f582b.f585a != 0;
    }

    public static int l(long j) {
        int i = (int) (j & 2147483647L);
        return ((-2147483648L) & j) != 0 ? Integer.MIN_VALUE | i : i;
    }

    public static int m(java.lang.String str) {
        java.lang.String strTrim = str.trim();
        java.lang.Integer numValueOf = strTrim.indexOf(46) != -1 ? java.lang.Integer.valueOf(java.lang.Float.floatToRawIntBits(java.lang.Float.parseFloat(strTrim))) : null;
        int length = strTrim.length();
        int i = 10;
        if (length >= 1) {
            int i2 = length - 1;
            char cCharAt = strTrim.charAt(i2);
            if (cCharAt == 'h') {
                strTrim = strTrim.substring(0, i2);
                i = 16;
            }
            if (cCharAt == 'f') {
                strTrim = strTrim.substring(0, i2);
                numValueOf = java.lang.Integer.valueOf(java.lang.Float.floatToRawIntBits(java.lang.Float.parseFloat(strTrim)));
            }
        }
        if (numValueOf == null) {
            numValueOf = java.lang.Integer.valueOf(l(android.ext.t1.r(strTrim, i)));
        }
        return numValueOf.intValue();
    }

    public static void n(android.ext.c2 c2Var, boolean z) {
        c2Var.write("gg.getResults(");
        c2Var.write(java.lang.Integer.toString(i()));
        if (z) {
            android.ext.b0$a b0_a = f582b;
            int i = b0_a.f585a;
            c2Var.write(", ");
            c2Var.write("nil");
            c2Var.write(", ");
            if ((i & 1) == 0) {
                c2Var.write("nil");
            } else {
                android.ext.Script$Consts.b(c2Var, b0_a.f586b);
            }
            c2Var.write(", ");
            if ((i & 2) == 0) {
                c2Var.write("nil");
            } else {
                android.ext.Script$Consts.b(c2Var, b0_a.f587c);
            }
            c2Var.write(", ");
            if ((i & 4) == 0) {
                c2Var.write("nil");
            } else {
                android.ext.Script$Consts.d(c2Var, android.ext.c.I(0L, b0_a.f588d, b0_a.f589e));
            }
            c2Var.write(", ");
            if ((i & 8) == 0) {
                c2Var.write("nil");
            } else {
                android.ext.Script$Consts.d(c2Var, android.ext.c.I(0L, b0_a.f590f, b0_a.f591g));
            }
            c2Var.write(", ");
            if ((i & 16) == 0) {
                c2Var.write("nil");
            } else {
                android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, b0_a.h);
            }
            c2Var.write(", ");
            if ((i & 32) == 0) {
                c2Var.write("nil");
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(b0_a.i == 268435456 ? "|" : "");
                sb.append(b0_a.j);
                android.ext.Script$Consts.d(c2Var, sb.toString());
            }
            c2Var.write(", ");
            if ((i & 64) == 0) {
                c2Var.write("nil");
            } else {
                android.ext.Script$Consts.a(c2Var, c2Var.f697c.h, b0_a.k);
            }
        }
        c2Var.write(")\n");
    }

    public static void o(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i, java.lang.String str5, int i2) {
        long j;
        long j2;
        if (str == null) {
            j = 0;
        } else {
            j = android.ext.t1.o(null, str.trim() + 'h', 127, false).f1261a;
        }
        long j3 = j;
        if (str2 == null) {
            j2 = -1;
        } else {
            j2 = android.ext.t1.o(null, str2.trim() + 'h', 127, false).f1261a;
        }
        f582b = f(j3, j2, str3, str4, i, str5, i2);
    }

    public static void p(int i) {
        f581a = java.lang.Math.min(java.lang.Math.max(1, i), 100000);
    }
}

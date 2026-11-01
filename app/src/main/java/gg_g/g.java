package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    protected static final java.lang.String[] r = {"(for control)", "(for generator)", "(for index)", "(for limit)", "(for state)", "(for step)", "break"};
    private static final java.util.Hashtable s = new java.util.Hashtable();
    static final java.lang.String[] t;
    static final java.util.Hashtable u;
    static g$g[] v;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1592d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    c f1595g;
    h$a h;
    java.io.InputStream i;
    int k;
    luaj.LuaString m;
    luaj.LuaString n;
    byte o;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final g$i f1593e = new g$i(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final g$i f1594f = new g$i(null);
    g$d l = new g$d();
    private g$b p = new g$b();
    private final int[] q = new int[24];
    char[] j = new char[32];

    static {
        int i = 0;
        while (true) {
            java.lang.String[] strArr = r;
            if (i >= strArr.length) {
                break;
            }
            s.put(strArr[i], java.lang.Boolean.TRUE);
            i++;
        }
        t = new java.lang.String[]{"and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", "true", "until", "while", "//", "..", "...", "==", ">=", "<=", "~=", "<<", ">>", "::", "<eof>", "<number>", "<integer>", "<name>", "<string>"};
        u = new java.util.Hashtable();
        for (int i2 = 0; i2 < 22; i2++) {
            u.put(luaj.LuaValue.K2(t[i2]), java.lang.Integer.valueOf(i2 + 257));
        }
        v = new g$g[]{new g$g(60, 60), new g$g(60, 60), new g$g(70, 70), new g$g(70, 70), new g$g(70, 70), new g$g(100, 90), new g$g(50, 40), new g$g(30, 30), new g$g(30, 30), new g$g(30, 30), new g$g(30, 30), new g$g(30, 30), new g$g(30, 30), new g$g(20, 20), new g$g(10, 10), new g$g(70, 70), new g$g(36, 36), new g$g(32, 32), new g$g(34, 34), new g$g(38, 38), new g$g(38, 38)};
    }

    public g(h$a h_a, java.io.InputStream inputStream) {
        this.i = inputStream;
        this.h = h_a;
    }

    private void B1() {
        if (this.f1590b == 35) {
            while (!j0() && this.f1590b != -1) {
                h1();
            }
        }
    }

    public static int H0(int i) {
        if (i <= 57) {
            return i - 48;
        }
        return i <= 70 ? i - 55 : i - 87;
    }

    public static boolean K0(java.lang.String str) {
        return s.containsKey(str);
    }

    public static boolean L0(int i) {
        return (i >= 48 && i <= 57) || (i >= 97 && i <= 122) || ((i >= 65 && i <= 90) || i == 95);
    }

    private static final java.lang.String M(java.lang.Object obj) {
        return N(java.lang.String.valueOf(obj));
    }

    public static boolean M0(int i) {
        return (i >= 97 && i <= 122) || (i >= 65 && i <= 90);
    }

    private static final java.lang.String N(java.lang.String str) {
        return '\'' + str + '\'';
    }

    private static boolean N0(int i) {
        return i < 32 || i == 255;
    }

    public static boolean O0(int i) {
        return i >= 48 && i <= 57;
    }

    public static boolean P0(int i) {
        return i >= 0 && i <= 32;
    }

    public static boolean Q0(int i) {
        return (i >= 48 && i <= 57) || (i >= 97 && i <= 102) || (i >= 65 && i <= 70);
    }

    static int Z0(int i) {
        int i2 = 0;
        while (i >= 16) {
            i = (i + 1) >> 1;
            i2++;
        }
        if (i < 8) {
            return i;
        }
        return (i - 8) | ((i2 + 1) << 3);
    }

    void A0(g$k g_k, int i) {
        int i2;
        c cVar = this.f1595g;
        g$k g_k2 = new g$k();
        g$i g_i = this.f1593e;
        int i3 = g_i.f1619a;
        if (i3 == 40) {
            g1();
            if (this.f1593e.f1619a == 41) {
                g_k2.f1622a = 0;
            } else {
                q0(g_k2);
                cVar.h1(g_k2);
            }
            Z(41, 40, i);
        } else if (i3 == 123) {
            i0(g_k2);
        } else if (i3 != 293) {
            J1("function arguments expected");
            return;
        } else {
            g0(g_k2, g_i.f1620b.f1618b);
            g1();
        }
        a.C(g_k.f1622a == 6);
        int i4 = g_k.f1623b.f1630e;
        if (G0(g_k2.f1622a)) {
            i2 = -1;
        } else {
            if (g_k2.f1622a != 0) {
                cVar.o0(g_k2);
            }
            i2 = cVar.p - (i4 + 1);
        }
        g_k.b(12, cVar.T(29, i4, i2 + 1, 2));
        cVar.s0(i);
        cVar.p = (short) (i4 + 1);
    }

    void A1(g$k g_k) {
        luaj.LuaString luaStringG1 = G1();
        c cVar = this.f1595g;
        boolean z = true;
        if (c.k1(cVar, luaStringG1, g_k, 1) == 0) {
            g$k g_k2 = new g$k();
            c.k1(cVar, this.n, g_k, 1);
            int i = g_k.f1622a;
            if (i != 7 && i != 8) {
                z = false;
            }
            a.C(z);
            g0(g_k2, luaStringG1);
            cVar.E0(g_k, g_k2);
        }
    }

    boolean B0(g$k g_k) {
        int i;
        A1(g_k);
        while (true) {
            i = this.f1593e.f1619a;
            if (i != 46) {
                break;
            }
            t0(g_k);
        }
        if (i != 58) {
            return false;
        }
        t0(g_k);
        return true;
    }

    void C0(int i) {
        g$k g_k = new g$k();
        g$k g_k2 = new g$k();
        g1();
        U(g_k2, B0(g_k), i);
        this.f1595g.l1(g_k, g_k2);
        this.f1595g.s0(i);
    }

    int C1() {
        int i;
        int i2 = this.f1590b;
        w1();
        int i3 = 0;
        while (true) {
            i = this.f1590b;
            if (i != 61) {
                break;
            }
            w1();
            i3++;
        }
        return i == i2 ? i3 : (-i3) - 1;
    }

    int D0(int i) {
        if (i == 37) {
            return 4;
        }
        if (i == 38) {
            return 16;
        }
        if (i == 42) {
            return 2;
        }
        if (i == 43) {
            return 0;
        }
        if (i == 45) {
            return 1;
        }
        if (i == 47) {
            return 3;
        }
        if (i == 60) {
            return 9;
        }
        if (i == 62) {
            return 11;
        }
        if (i == 94) {
            return 5;
        }
        if (i == 124) {
            return 17;
        }
        if (i == 126) {
            return 18;
        }
        if (i == 257) {
            return 13;
        }
        if (i == 272) {
            return 14;
        }
        if (i == 279) {
            return 15;
        }
        if (i == 280) {
            return 6;
        }
        switch (i) {
            case 282:
                return 8;
            case 283:
                return 12;
            case 284:
                return 10;
            case 285:
                return 7;
            case 286:
                return 19;
            case 287:
                return 20;
            default:
                return 21;
        }
    }

    void D1() {
        while (true) {
            int i = this.f1593e.f1619a;
            if (i != 59 && i != 288) {
                return;
            } else {
                E1();
            }
        }
    }

    int E0(int i) {
        if (i == 35) {
            return 2;
        }
        if (i == 45) {
            return 0;
        }
        if (i != 126) {
            return i != 271 ? 3 : 1;
        }
        return 4;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    void E1() {
        int i = this.f1591c;
        k0();
        int i2 = this.f1593e.f1619a;
        if (i2 == 59) {
            g1();
        } else if (i2 == 269) {
            g1();
            if (L1(265)) {
                W0();
            } else {
                X0();
            }
        } else if (i2 == 278) {
            P1(i);
        } else if (i2 == 288) {
            g1();
            R0(G1(), i);
        } else if (i2 == 258) {
            F0(this.f1595g.H0());
        } else if (i2 == 259) {
            g1();
            S();
            Z(262, 259, i);
        } else if (i2 == 273) {
            t1(i);
        } else if (i2 != 274) {
            switch (i2) {
                case 264:
                    z0(i);
                    break;
                case 265:
                    C0(i);
                    break;
                case 266:
                    F0(this.f1595g.H0());
                    break;
                case 267:
                    I0(i);
                    break;
                default:
                    s0();
                    break;
            }
        } else {
            g1();
            u1();
        }
        c cVar = this.f1595g;
        int i3 = cVar.f1575b.l;
        short s2 = cVar.p;
        a.C(i3 >= s2 && s2 >= cVar.n);
        c cVar2 = this.f1595g;
        cVar2.p = cVar2.n;
        S0();
    }

    void F0(int i) {
        luaj.LuaString luaStringK2;
        int i2 = this.f1591c;
        if (L1(266)) {
            luaStringK2 = G1();
        } else {
            g1();
            luaStringK2 = luaj.LuaString.K2("break");
        }
        luaj.LuaString luaString = luaStringK2;
        g$d g_d = this.l;
        g$f[] g_fArrD = a.D(g_d.f1605c, g_d.f1606d + 1);
        g_d.f1605c = g_fArrD;
        g$d g_d2 = this.l;
        int i3 = g_d2.f1606d;
        g_d2.f1606d = i3 + 1;
        v0(d1(g_fArrD, i3, luaString, i2, i));
    }

    void F1() {
        while (!T(true)) {
            int i = this.f1593e.f1619a;
            E1();
            if (i == 274) {
                return;
            }
        }
    }

    boolean G0(int i) {
        return i == 12 || i == 13;
    }

    luaj.LuaString G1() {
        W(292);
        luaj.LuaString luaString = this.f1593e.f1620b.f1618b;
        g1();
        return luaString;
    }

    int H1(g$k g_k, int i) {
        k0();
        int iE0 = E0(this.f1593e.f1619a);
        if (iE0 != 3) {
            int i2 = this.f1591c;
            g1();
            H1(g_k, 80);
            this.f1595g.Y0(iE0, g_k, i2);
        } else {
            z1(g_k);
        }
        int iD0 = D0(this.f1593e.f1619a);
        while (iD0 != 21 && v[iD0].f1615a > i) {
            g$k g_k2 = new g$k();
            int i3 = this.f1591c;
            g1();
            this.f1595g.F0(iD0, g_k);
            int iH1 = H1(g_k2, v[iD0].f1616b);
            this.f1595g.X0(iD0, g_k, g_k2, i3);
            iD0 = iH1;
        }
        S0();
        return iD0;
    }

    void I0(int i) {
        e eVar = new e(-1);
        do {
            K1(eVar);
        } while (this.f1593e.f1619a == 261);
        if (L1(260)) {
            S();
        }
        Z(262, 267, i);
        this.f1595g.W0(eVar.f1589a);
    }

    void I1(g$k g_k) {
        int i = this.f1591c;
        k1(g_k);
        while (true) {
            int i2 = this.f1593e.f1619a;
            if (i2 != 40) {
                if (i2 == 46) {
                    t0(g_k);
                } else if (i2 == 58) {
                    g$k g_k2 = new g$k();
                    g1();
                    b0(g_k2);
                    this.f1595g.f1(g_k, g_k2);
                    A0(g_k, i);
                } else if (i2 == 91) {
                    g$k g_k3 = new g$k();
                    this.f1595g.n0(g_k);
                    Q1(g_k3);
                    this.f1595g.E0(g_k, g_k3);
                } else if (i2 != 123 && i2 != 293) {
                    return;
                }
            }
            this.f1595g.o0(g_k);
            A0(g_k, i);
        }
    }

    void J0() {
        int i = this.f1590b;
        a.C(j0());
        h1();
        if (j0() && this.f1590b != i) {
            h1();
        }
        int i2 = this.f1591c + 1;
        this.f1591c = i2;
        if (i2 >= 2147483645) {
            J1("chunk has too many lines (> 2147483645)");
        }
    }

    void J1(java.lang.String str) {
        T0(str, this.f1593e.f1619a);
    }

    void K1(e eVar) {
        int iH0;
        g$k g_k = new g$k();
        c$a c_a = new c$a();
        g1();
        r0(g_k);
        c0(275);
        int i = this.f1593e.f1619a;
        if (i == 266 || i == 258) {
            this.f1595g.B0(g_k);
            this.f1595g.j0(c_a, false);
            F0(g_k.f1624c.f1589a);
            D1();
            if (T(false)) {
                this.f1595g.K0();
                return;
            }
            iH0 = this.f1595g.H0();
        } else {
            this.f1595g.C0(g_k);
            this.f1595g.j0(c_a, false);
            iH0 = g_k.f1625d.f1589a;
        }
        F1();
        this.f1595g.K0();
        int i2 = this.f1593e.f1619a;
        if (i2 == 260 || i2 == 261) {
            c cVar = this.f1595g;
            cVar.c0(eVar, cVar.H0());
        }
        this.f1595g.W0(iH0);
    }

    boolean L1(int i) {
        if (this.f1593e.f1619a != i) {
            return false;
        }
        g1();
        return true;
    }

    java.lang.String M1(int i) {
        h$a h_a;
        java.lang.String strValueOf;
        if (i >= 257) {
            java.lang.String str = t[i - 257];
            switch (i) {
                case 289:
                case 290:
                case 291:
                case 292:
                case 293:
                    return str;
                default:
                    return '\'' + str + '\'';
            }
        }
        if (N0(i)) {
            h_a = this.h;
            strValueOf = "'<\\" + i + ">' (symbol with decimal code " + i + " or 0x" + java.lang.Integer.toHexString(i) + ")";
        } else {
            h_a = this.h;
            strValueOf = java.lang.String.valueOf((char) i);
        }
        return h_a.e(strValueOf);
    }

    java.lang.String N1(int i) {
        switch (i) {
            case 290:
            case 291:
            case 292:
            case 293:
                return '\'' + new java.lang.String(this.j, 0, this.k) + '\'';
            default:
                return M1(i);
        }
    }

    luaj.h O() {
        c cVar = this.f1595g;
        luaj.h hVar = cVar.f1575b;
        luaj.h[] hVarArr = hVar.f1725c;
        if (hVarArr == null || cVar.k >= hVarArr.length) {
            hVar.f1725c = a.L(hVarArr, java.lang.Math.max(1, cVar.k * 2));
        }
        luaj.h[] hVarArr2 = hVar.f1725c;
        c cVar2 = this.f1595g;
        int i = cVar2.k;
        cVar2.k = i + 1;
        luaj.h hVar2 = new luaj.h();
        hVarArr2[i] = hVar2;
        return hVar2;
    }

    void O1(g$f g_f, c cVar, c$a c_a) {
        java.lang.StringBuilder sb;
        luaj.LuaString luaString;
        this.f1591c = g_f.f1613c;
        java.lang.String strG0 = g_f.f1611a.g0();
        boolean zK0 = K0(strG0);
        h$a h_a = this.h;
        if (zK0) {
            sb = new java.lang.StringBuilder();
            sb.append("<");
            sb.append(g_f.f1611a);
            sb.append("> at line ");
            sb.append(g_f.f1613c);
            sb.append(" not inside a loop");
        } else {
            sb = new java.lang.StringBuilder();
            sb.append("no visible label '");
            sb.append(g_f.f1611a);
            sb.append("' for <goto> at line ");
            sb.append(g_f.f1613c);
        }
        java.lang.String strE = h_a.e(sb.toString());
        if (!zK0) {
            g$d g_d = this.l;
            for (int i = c_a.f1582b; i < g_d.f1608f; i++) {
                g$f g_f2 = g_d.f1607e[i];
                if (g_f2 != null && (luaString = g_f2.f1611a) != null) {
                    java.lang.String strG1 = luaString.g0();
                    if (strG1.equalsIgnoreCase(strG0)) {
                        strE = strE + "\ndid you mean label '" + strG1 + "' at line " + g_f2.f1613c + '?';
                    }
                }
            }
        }
        x1(strE);
    }

    void P(int i, int i2, g$k g_k) {
        c cVar = this.f1595g;
        int i3 = i - i2;
        if (G0(g_k.f1622a)) {
            int i4 = i3 + 1;
            if (i4 < 0) {
                i4 = 0;
            }
            cVar.j1(g_k, i4);
            if (i4 > 1) {
                cVar.b1(i4 - 1);
                return;
            }
            return;
        }
        if (g_k.f1622a != 0) {
            cVar.o0(g_k);
        }
        if (i3 > 0) {
            short s2 = cVar.p;
            cVar.b1(i3);
            cVar.P0(s2, i3);
        }
    }

    void P1(int i) {
        c cVar = this.f1595g;
        c$a c_a = new c$a();
        g1();
        int iZ0 = cVar.z0();
        int iH0 = h0();
        cVar.j0(c_a, true);
        c0(259);
        S();
        cVar.T0(cVar.H0(), iZ0);
        Z(262, 278, i);
        cVar.K0();
        cVar.W0(iH0);
    }

    void Q(int i) {
        c cVar = this.f1595g;
        cVar.n = (short) (cVar.n + i);
        while (i > 0) {
            cVar.A0(cVar.n - i).f1559b = cVar.f1580g;
            i--;
        }
    }

    void Q1(g$k g_k) {
        g1();
        r0(g_k);
        this.f1595g.q0(g_k);
        c0(93);
    }

    void R(g$e g_e, int i) {
        g$k g_k = new g$k();
        int i2 = g_e.f1610b.f1622a;
        X(7 <= i2 && i2 <= 9, "syntax error");
        if (!L1(44)) {
            c0(61);
            int iQ0 = q0(g_k);
            if (iQ0 != i) {
                P(i, iQ0, g_k);
                if (iQ0 > i) {
                    c cVar = this.f1595g;
                    cVar.p = (short) (cVar.p - (iQ0 - i));
                }
            } else {
                this.f1595g.i1(g_k);
            }
            this.f1595g.l1(g_e.f1610b, g_k);
        }
        g$e g_e2 = new g$e();
        g_e2.f1609a = g_e;
        I1(g_e2.f1610b);
        g$k g_k2 = g_e2.f1610b;
        if (g_k2.f1622a != 9) {
            Y(g_e, g_k2);
        }
        R(g_e2, i + 1);
        g_k.b(6, this.f1595g.p - 1);
        this.f1595g.l1(g_e.f1610b, g_k);
    }

    void R0(luaj.LuaString luaString, int i) {
        c cVar = this.f1595g;
        g$d g_d = this.l;
        cVar.P(g_d.f1607e, g_d.f1608f, luaString);
        c0(288);
        g$d g_d2 = this.l;
        g$f[] g_fArrD = a.D(g_d2.f1607e, g_d2.f1608f + 1);
        g_d2.f1607e = g_fArrD;
        g$d g_d3 = this.l;
        int i2 = g_d3.f1608f;
        g_d3.f1608f = i2 + 1;
        int iD1 = d1(g_fArrD, i2, luaString, i, this.f1595g.z0());
        D1();
        if (T(false)) {
            this.l.f1607e[iD1].f1614d = this.f1595g.f1579f.f1584d;
        }
        u0(this.l.f1607e[iD1]);
    }

    void S() {
        c cVar = this.f1595g;
        cVar.j0(new c$a(), false);
        F1();
        cVar.K0();
    }

    void S0() {
        this.h.f1632a--;
    }

    boolean T(boolean z) {
        int i = this.f1593e.f1619a;
        if (i == 277) {
            return z;
        }
        if (i != 289) {
            switch (i) {
                case 260:
                case 261:
                case 262:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    void T0(java.lang.String str, int i) {
        java.lang.String strM = luaj.b.m(this.m.g0());
        this.h.e(strM + ':' + this.f1591c + ": " + str);
        if (i != 0) {
            str = str + " near " + N1(i);
            this.h.e("syntax error: " + str);
        }
        throw new luaj.d(strM, this.f1591c, str);
    }

    void U(g$k g_k, boolean z, int i) {
        c cVar = new c();
        c$a c_a = new c$a();
        luaj.h hVarO = O();
        cVar.f1575b = hVarO;
        hVarO.h = i;
        i1(cVar, c_a);
        c0(40);
        if (z) {
            c1("self");
            Q(1);
        }
        j1();
        c0(41);
        F1();
        cVar.f1575b.i = this.f1591c;
        Z(262, 265, i);
        f0(g_k);
        d0();
    }

    void U0(g$c g_c) {
        r0(g_c.f1598a);
        this.f1595g.O(g_c.f1601d, 2147483645, "items in a constructor");
        g_c.f1601d++;
        g_c.f1602e++;
    }

    void V() {
        luaj.LuaString luaStringK2 = luaj.LuaString.K2("break");
        g$d g_d = this.l;
        g$f[] g_fArrD = a.D(g_d.f1607e, g_d.f1608f + 1);
        g_d.f1607e = g_fArrD;
        g$d g_d2 = this.l;
        int i = g_d2.f1608f;
        g_d2.f1608f = i + 1;
        u0(this.l.f1607e[d1(g_fArrD, i, luaStringK2, 0, this.f1595g.f1580g)]);
    }

    int V0(g$h g_h) {
        int i;
        while (true) {
            this.k = 0;
            while (true) {
                int i2 = this.f1590b;
                if (i2 == -1) {
                    return 289;
                }
                if (i2 != 32) {
                    if (i2 == 34 || i2 == 39) {
                        n1(i2, g_h);
                        return 293;
                    }
                    if (i2 != 91) {
                        if (i2 == 126) {
                            h1();
                            if (this.f1590b != 61) {
                                return 126;
                            }
                            h1();
                            return 285;
                        }
                        switch (i2) {
                            case 9:
                            case 11:
                            case 12:
                                break;
                            case 10:
                            case 13:
                                J0();
                                break;
                            default:
                                switch (i2) {
                                    case 45:
                                        h1();
                                        if (this.f1590b != 45) {
                                            return 45;
                                        }
                                        h1();
                                        if (this.f1590b == 91) {
                                            int iC1 = C1();
                                            this.k = 0;
                                            if (iC1 >= 0) {
                                                l1(null, iC1);
                                            }
                                        }
                                        while (!j0() && this.f1590b != -1) {
                                            h1();
                                        }
                                        break;
                                    case 46:
                                        w1();
                                        if (a0(".")) {
                                            return a0(".") ? 281 : 280;
                                        }
                                        if (!O0(this.f1590b)) {
                                            return 46;
                                        }
                                        m1(g_h, false);
                                        return 290;
                                    case 47:
                                        h1();
                                        if (this.f1590b != 47) {
                                            return 47;
                                        }
                                        h1();
                                        return 279;
                                    case 48:
                                    case 49:
                                    case 50:
                                    case 51:
                                    case 52:
                                    case 53:
                                    case 54:
                                    case 55:
                                    case 56:
                                    case 57:
                                        m1(g_h, true);
                                        return 290;
                                    case 58:
                                        h1();
                                        if (this.f1590b != 58) {
                                            return 58;
                                        }
                                        h1();
                                        return 288;
                                    default:
                                        switch (i2) {
                                            case 60:
                                                h1();
                                                int i3 = this.f1590b;
                                                if (i3 == 61) {
                                                    h1();
                                                    return 284;
                                                }
                                                if (i3 != 60) {
                                                    return 60;
                                                }
                                                h1();
                                                return 286;
                                            case 61:
                                                break;
                                            case 62:
                                                h1();
                                                int i4 = this.f1590b;
                                                if (i4 == 61) {
                                                    h1();
                                                    return 283;
                                                }
                                                if (i4 != 62) {
                                                    return 62;
                                                }
                                                h1();
                                                return 287;
                                            default:
                                                if (!M0(i2) && (i = this.f1590b) != 95) {
                                                    h1();
                                                    return i;
                                                }
                                                do {
                                                    w1();
                                                } while (L0(this.f1590b));
                                                luaj.LuaString luaStringF1 = f1(this.j, 0, this.k);
                                                java.lang.Integer num = (java.lang.Integer) u.get(luaStringF1);
                                                if (num != null) {
                                                    return num.intValue();
                                                }
                                                g_h.f1618b = luaStringF1;
                                                return 292;
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        int iC2 = C1();
                        if (iC2 == -1) {
                            return 91;
                        }
                        if (iC2 >= 0) {
                            l1(g_h, iC2);
                            return 293;
                        }
                        T0("invalid long string delimiter", 293);
                    }
                }
                h1();
            }
        }
    }

    void W(int i) {
        if (this.f1593e.f1619a != i) {
            l0(i);
        }
    }

    void W0() {
        g$k g_k = new g$k();
        c cVar = this.f1595g;
        b1(G1());
        Q(1);
        U(g_k, false, this.f1591c);
        cVar.A0(cVar.n - 1).f1559b = cVar.f1580g;
    }

    void X(boolean z, java.lang.String str) {
        if (z) {
            return;
        }
        J1(str);
    }

    void X0() {
        g$k g_k = new g$k();
        int iQ0 = 0;
        int i = 0;
        do {
            b1(G1());
            i++;
        } while (L1(44));
        if (L1(61)) {
            iQ0 = q0(g_k);
        } else {
            g_k.f1622a = 0;
        }
        P(i, iQ0, g_k);
        Q(i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void Y(g$e g_e, g$k g_k) {
        c cVar = this.f1595g;
        short s2 = cVar.p;
        boolean z = false;
        while (g_e != null) {
            g$k g_k2 = g_e.f1610b;
            if (g_k2.f1622a == 9) {
                g$k$a g_k_a = g_k2.f1623b;
                short s3 = g_k_a.f1628c;
                int i = g_k.f1622a;
                if (s3 == i && g_k_a.f1627b == g_k.f1623b.f1630e) {
                    g_k_a.f1628c = (short) 7;
                    g_k_a.f1627b = s2;
                    z = true;
                }
                if (i == 7 && g_k_a.f1626a == g_k.f1623b.f1630e) {
                    g_k_a.f1626a = s2;
                    z = true;
                }
            }
            g_e = g_e.f1609a;
        }
        if (z) {
            cVar.T(g_k.f1622a == 7 ? 0 : 5, s2, g_k.f1623b.f1630e, 0);
            cVar.b1(1);
        }
    }

    void Y0() {
        a.C(this.f1594f.f1619a == 289);
        g$i g_i = this.f1594f;
        g_i.f1619a = V0(g_i.f1620b);
    }

    void Z(int i, int i2, int i3) {
        if (L1(i)) {
            return;
        }
        if (i3 == this.f1591c) {
            l0(i);
            return;
        }
        J1(this.h.e(N(M1(i)) + " expected (to close " + N(M1(i2)) + " at line " + i3 + ')'));
    }

    boolean a0(java.lang.String str) {
        if (str.indexOf(this.f1590b) < 0) {
            return false;
        }
        w1();
        return true;
    }

    public void a1(c cVar) {
        i1(cVar, new c$a());
        this.f1595g.f1575b.k = 1;
        g$k g_k = new g$k();
        g_k.b(7, 0);
        this.f1595g.O0(this.n, g_k);
        g1();
        F1();
        W(289);
        d0();
    }

    void b0(g$k g_k) {
        g0(g_k, G1());
    }

    void b1(luaj.LuaString luaString) {
        int iS1 = s1(luaString);
        this.f1595g.O(this.l.f1604b + 1, 200, "local variables");
        g$d g_d = this.l;
        g$j[] g_jArr = g_d.f1603a;
        if (g_jArr == null || g_d.f1604b + 1 > g_jArr.length) {
            g_d.f1603a = a.J(g_jArr, java.lang.Math.max(1, g_d.f1604b * 2));
        }
        g$d g_d2 = this.l;
        g$j[] g_jArr2 = g_d2.f1603a;
        int i = g_d2.f1604b;
        g_d2.f1604b = i + 1;
        g_jArr2[i] = new g$j(iS1);
    }

    void c0(int i) {
        W(i);
        g1();
    }

    void c1(java.lang.String str) {
        b1(e1(str));
    }

    void d0() {
        c cVar = this.f1595g;
        luaj.h hVar = cVar.f1575b;
        cVar.c1(0, 0);
        cVar.K0();
        hVar.f1724b = a.F(hVar.f1724b, cVar.f1580g);
        hVar.f1726d = a.F(hVar.f1726d, cVar.f1580g);
        hVar.f1723a = a.K(hVar.f1723a, cVar.j);
        hVar.f1725c = a.L(hVar.f1725c, cVar.k);
        hVar.f1727e = a.G(hVar.f1727e, cVar.m);
        hVar.f1728f = a.H(hVar.f1728f, cVar.o);
        a.C(cVar.f1579f == null);
        this.f1595g = cVar.f1577d;
    }

    int d1(g$f[] g_fArr, int i, luaj.LuaString luaString, int i2, int i3) {
        g_fArr[i] = new g$f(luaString, i3, i2, this.f1595g.n);
        return i;
    }

    void e0(int i, g$f g_f) {
        c cVar = this.f1595g;
        g$f[] g_fArr = this.l.f1605c;
        g$f g_f2 = g_fArr[i];
        a.C(g_f2.f1611a.P0(g_f.f1611a));
        short s2 = g_f2.f1614d;
        if (s2 < g_f.f1614d) {
            luaj.LuaString luaString = cVar.A0(s2).f1558a;
            x1(this.h.e("<goto " + g_f2.f1611a + "> at line " + g_f2.f1613c + " jumps into the scope of local '" + luaString.g0() + '\''));
        }
        cVar.T0(g_f2.f1612b, g_f.f1612b);
        java.lang.System.arraycopy(g_fArr, i + 1, g_fArr, i, (this.l.f1606d - i) - 1);
        g$d g_d = this.l;
        int i2 = g_d.f1606d - 1;
        g_d.f1606d = i2;
        g_fArr[i2] = null;
    }

    luaj.LuaString e1(java.lang.String str) {
        return this.h.c(str);
    }

    void f0(g$k g_k) {
        c cVar = this.f1595g.f1577d;
        g_k.b(11, cVar.U(37, 0, cVar.k - 1));
        cVar.o0(g_k);
    }

    luaj.LuaString f1(char[] cArr, int i, int i2) {
        return this.h.c(new java.lang.String(cArr, i, i2));
    }

    void g0(g$k g_k, luaj.LuaString luaString) {
        g_k.b(4, this.f1595g.m1(luaString));
    }

    void g1() {
        this.f1592d = this.f1591c;
        g$i g_i = this.f1594f;
        if (g_i.f1619a != 289) {
            this.f1593e.a(g_i);
            this.f1594f.f1619a = 289;
        } else {
            g$i g_i2 = this.f1593e;
            g_i2.f1619a = V0(g_i2.f1620b);
        }
    }

    int h0() {
        g$k g_k = new g$k();
        r0(g_k);
        if (g_k.f1622a == 1) {
            g_k.f1622a = 3;
        }
        this.f1595g.C0(g_k);
        return g_k.f1625d.f1589a;
    }

    void h1() {
        try {
            this.f1590b = this.i.read();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            this.f1590b = -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0061  */
    void i0(g$k g_k) {
        c cVar = this.f1595g;
        int i = this.f1591c;
        int iT = cVar.T(11, 0, 0, 0);
        g$c g_c = new g$c();
        g_c.f1602e = 0;
        g_c.f1600c = 0;
        g_c.f1601d = 0;
        g_c.f1599b = g_k;
        g_k.b(11, iT);
        g_c.f1598a.b(0, 0);
        cVar.o0(g_k);
        c0(123);
        while (true) {
            a.C(g_c.f1598a.f1622a == 0 || g_c.f1602e > 0);
            if (this.f1593e.f1619a != 125) {
                cVar.R(g_c);
                int i2 = this.f1593e.f1619a;
                if (i2 == 91) {
                    r1(g_c);
                } else {
                    if (i2 == 292) {
                        Y0();
                        if (this.f1594f.f1619a == 61) {
                            r1(g_c);
                        }
                    }
                    U0(g_c);
                }
                if (!L1(44) && !L1(59)) {
                    break;
                }
            } else {
                break;
            }
        }
        Z(125, 123, i);
        cVar.J0(g_c);
        d dVar = new d(cVar.f1575b.f1724b, iT);
        a.x(dVar, Z0(g_c.f1601d));
        a.z(dVar, Z0(g_c.f1600c));
    }

    void i1(c cVar, c$a c_a) {
        cVar.f1577d = this.f1595g;
        cVar.f1578e = this;
        this.f1595g = cVar;
        cVar.f1580g = 0;
        cVar.h = -1;
        cVar.i = new e(-1);
        cVar.p = (short) 0;
        cVar.j = 0;
        cVar.k = 0;
        cVar.o = (short) 0;
        cVar.m = (short) 0;
        cVar.n = (short) 0;
        cVar.l = this.l.f1604b;
        cVar.f1579f = null;
        luaj.h hVar = cVar.f1575b;
        hVar.f1729g = this.m;
        hVar.l = 2;
        cVar.j0(c_a, false);
    }

    boolean j0() {
        int i = this.f1590b;
        return i == 10 || i == 13;
    }

    void j1() {
        c cVar = this.f1595g;
        luaj.h hVar = cVar.f1575b;
        int i = 0;
        hVar.k = 0;
        if (this.f1593e.f1619a != 41) {
            do {
                int i2 = this.f1593e.f1619a;
                if (i2 == 281) {
                    g1();
                    hVar.k = 1;
                } else if (i2 != 292) {
                    J1("<name> or " + M("...") + " expected");
                } else {
                    b1(G1());
                    i++;
                }
                if (hVar.k != 0) {
                    break;
                }
            } while (L1(44));
        }
        Q(i);
        short s2 = cVar.n;
        hVar.j = s2;
        cVar.b1(s2);
    }

    void k0() {
        h$a h_a = this.h;
        int i = h_a.f1632a + 1;
        h_a.f1632a = i;
        if (i > 200) {
            T0("chunk has too many syntax levels", 0);
        }
    }

    void k1(g$k g_k) {
        int i = this.f1593e.f1619a;
        if (i != 40) {
            if (i != 292) {
                J1("unexpected symbol");
                return;
            } else {
                A1(g_k);
                return;
            }
        }
        int i2 = this.f1591c;
        g1();
        r0(g_k);
        Z(41, 40, i2);
        this.f1595g.i0(g_k);
    }

    void l0(int i) {
        J1(this.h.e(N(M1(i)) + " expected"));
    }

    void l1(g$h g_h, int i) {
        java.lang.String str = null;
        int i2 = 0;
        w1();
        if (j0()) {
            J0();
        }
        boolean z = false;
        while (!z) {
            int i3 = this.f1590b;
            if (i3 == -1) {
                str = g_h != null ? "unfinished long string" : "unfinished long comment";
                i2 = 289;
            } else if (i3 == 10 || i3 == 13) {
                v1(10);
                J0();
                if (g_h == null) {
                    this.k = 0;
                }
            } else {
                i2 = 91;
                if (i3 != 91) {
                    if (i3 != 93) {
                        if (g_h != null) {
                            w1();
                        } else {
                            h1();
                        }
                    } else if (C1() == i) {
                        w1();
                        z = true;
                    }
                } else if (C1() == i) {
                    w1();
                    if (i == 0) {
                        str = "nesting of [[...]] is deprecated";
                    }
                }
            }
            T0(str, i2);
        }
        if (g_h != null) {
            int i4 = i + 2;
            g_h.f1618b = this.h.d(luaj.LuaString.n3(this.j, i4, this.k - (i4 * 2)));
        }
    }

    void m0(int i, java.lang.String str) {
        v1(92);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.q[i2];
            if (i3 == -1) {
                break;
            }
            v1(i3);
        }
        T0(str, 293);
    }

    void m1(g$h g_h, boolean z) {
        double d2 = 0.0;
        luaj.LuaValue luaValueJ2;
        int i = this.f1590b;
        w1();
        boolean z2 = i == 48 && a0("Xx");
        java.lang.String str = z2 ? "Pp" : "Ee";
        while (true) {
            if (a0(str)) {
                a0("+-");
                z = false;
            }
            int i2 = this.f1590b;
            if ((i2 >= 48 && i2 <= 57) || (z2 && ((i2 >= 97 && i2 <= 102) || (i2 >= 65 && i2 <= 70)))) {
                w1();
            } else {
                if (i2 != 46) {
                    break;
                }
                w1();
                z = false;
            }
        }
        if (!z2 && z && this.k > 19) {
            z = false;
        }
        try {
            if (z2) {
                g$b g_b = this.p;
                g_b.f1596a = this.j;
                g_b.f1597b = this.k;
                luaValueJ2 = luaj.LuaValue.N1(g_b);
            } else {
                if (z) {
                    char[] cArr = this.j;
                    int i3 = this.k;
                    long j = 0;
                    if (i3 != 19) {
                        for (int i4 = 0; i4 < i3; i4++) {
                            j = (j * 10) + ((long) (cArr[i4] - '0'));
                        }
                        luaValueJ2 = luaj.LuaLong.I2(j);
                    } else {
                        for (int i5 = 0; i5 < 18; i5++) {
                            j = (j * 10) + ((long) (cArr[i5] - '0'));
                        }
                        long j2 = (10 * j) + ((long) (cArr[18] - '0'));
                        if (j2 < j) {
                            d2 = java.lang.Double.parseDouble(new java.lang.String(cArr, 0, i3));
                        } else {
                            luaValueJ2 = luaj.LuaLong.I2(j2);
                        }
                    }
                } else {
                    d2 = java.lang.Double.parseDouble(new java.lang.String(this.j, 0, this.k));
                }
                luaValueJ2 = luaj.LuaDouble.J2(d2);
            }
            g_h.f1617a = luaValueJ2;
        } catch (java.lang.NumberFormatException e2) {
            T0("malformed number (" + e2.getMessage() + ")", 290);
        }
    }

    void n0(int i, int i2, java.lang.String str) {
        int[] iArr = this.q;
        iArr[0] = 117;
        iArr[1] = i;
        m0(i2, str);
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x007f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:5:0x0008  */
    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x001f. Please report as an issue. */
    /* JADX WARN: Switch 'out' block B:3:0x0003 for B:15:0x001f already processed. Defaulting to fallback option. */
    void n1(int i, g$h g_h) {
        int i2;
        while (true) {
            w1();
            while (true) {
                int i3 = this.f1590b;
                if (i3 != i) {
                    w1();
                    g_h.f1618b = this.h.d(luaj.LuaString.n3(this.j, 1, this.k - 2));
                    return;
                }
                if (i3 != -1) {
                    int iP1 = 10;
                    if (i3 != 10 || i3 == 13) {
                        i2 = 293;
                    } else {
                        if (i3 != 92) {
                            break;
                        }
                        h1();
                        int i4 = this.f1590b;
                        switch (i4) {
                            case -1:
                                break;
                            case 10:
                            case 13:
                                v1(10);
                                J0();
                                break;
                            case 34:
                            case 39:
                            case 92:
                                break;
                            case 97:
                                iP1 = 7;
                                v1(iP1);
                                h1();
                                break;
                            case 98:
                                iP1 = 8;
                                v1(iP1);
                                h1();
                                break;
                            case 102:
                                iP1 = 12;
                                v1(iP1);
                                h1();
                                break;
                            case 110:
                                v1(iP1);
                                h1();
                                break;
                            case 114:
                                iP1 = 13;
                                v1(iP1);
                                h1();
                                break;
                            case 116:
                                iP1 = 9;
                                v1(iP1);
                                h1();
                                break;
                            case 117:
                                q1();
                                break;
                            case 118:
                                iP1 = 11;
                                v1(iP1);
                                h1();
                                break;
                            case 120:
                                iP1 = p1();
                                v1(iP1);
                                h1();
                                break;
                            case 122:
                                while (true) {
                                    h1();
                                    while (true) {
                                        if (P0(this.f1590b)) {
                                            if (j0()) {
                                                J0();
                                            }
                                        }
                                    }
                                }
                            default:
                                if (!O0(i4)) {
                                    this.q[0] = this.f1590b;
                                    m0(1, "invalid escape sequence");
                                } else {
                                    v1(o1());
                                }
                                break;
                        }
                        int i5 = this.f1590b;
                        if (i5 != i) {
                            w1();
                            g_h.f1618b = this.h.d(luaj.LuaString.n3(this.j, 1, this.k - 2));
                            return;
                        } else if (i5 != -1) {
                            int iP2 = 10;
                            if (i5 != 10) {
                            }
                            i2 = 293;
                        } else {
                            i2 = 289;
                        }
                    }
                } else {
                    i2 = 289;
                }
                T0("unfinished string", i2);
            }
        }
    }

    void o0(int i, java.lang.String str) {
        n0(123, i, str);
    }

    int o1() {
        int i = 0;
        int i2 = 0;
        while (i < 3 && O0(this.f1590b)) {
            int[] iArr = this.q;
            int i3 = this.f1590b;
            iArr[i] = i3;
            i2 = ((i2 * 10) + i3) - 48;
            h1();
            i++;
        }
        if (i2 > 255) {
            this.q[i] = this.f1590b;
            m0(i + 1, "decimal escape too large");
        }
        return i2;
    }

    int p0() {
        g$k g_k = new g$k();
        r0(g_k);
        int i = g_k.f1622a;
        this.f1595g.o0(g_k);
        return i;
    }

    int p1() {
        int iH0 = 0;
        for (int i = 1; i < 3; i++) {
            h1();
            int[] iArr = this.q;
            int i2 = this.f1590b;
            iArr[i] = i2;
            if (!Q0(i2)) {
                this.q[0] = 120;
                m0(i + 1, "hexadecimal digit expected");
            }
            iH0 = (iH0 << 4) + H0(i2);
        }
        return iH0;
    }

    int q0(g$k g_k) {
        r0(g_k);
        int i = 1;
        while (L1(44)) {
            this.f1595g.o0(g_k);
            r0(g_k);
            i++;
        }
        return i;
    }

    void q1() {
        int i;
        h1();
        int i2 = this.f1590b;
        if (i2 != 123) {
            n0(i2, 2, "missing '{', got '" + ((char) i2) + "'");
        }
        int i3 = 2;
        int iH0 = 0;
        while (true) {
            h1();
            if (i3 == 23) {
                o0(i3, "unicode escape too long");
            }
            int[] iArr = this.q;
            i = this.f1590b;
            iArr[i3] = i;
            if (!Q0(i)) {
                break;
            }
            iH0 = (iH0 << 4) + H0(i);
            if (iH0 > 1114111) {
                o0(i3 + 1, "UTF-8 value too large: 0x" + java.lang.Integer.toHexString(iH0) + " (max allowed = 0x" + java.lang.Integer.toHexString(1114111) + ")");
            }
            i3++;
        }
        if (i3 == 2) {
            o0(3, "hexadecimal digit expected, got '" + ((char) i) + "'");
        }
        if (i != 125) {
            o0(i3 + 1, "missing '}', got '" + ((char) i) + "'");
        }
        for (byte b2 : new java.lang.String(java.lang.Character.toChars(iH0)).getBytes()) {
            v1(b2);
        }
        h1();
    }

    void r0(g$k g_k) {
        H1(g_k, 0);
    }

    void r1(g$c g_c) {
        c cVar = this.f1595g;
        short s2 = cVar.p;
        g$k g_k = new g$k();
        g$k g_k2 = new g$k();
        if (this.f1593e.f1619a == 292) {
            cVar.O(g_c.f1600c, 2147483645, "items in a constructor");
            b0(g_k);
        } else {
            Q1(g_k);
        }
        g_c.f1600c++;
        c0(61);
        int iL0 = cVar.l0(g_k);
        r0(g_k2);
        cVar.T(10, g_c.f1599b.f1623b.f1630e, iL0, cVar.l0(g_k2));
        cVar.p = s2;
    }

    void s0() {
        c cVar = this.f1595g;
        g$e g_e = new g$e();
        I1(g_e.f1610b);
        int i = this.f1593e.f1619a;
        if (i == 61 || i == 44) {
            g_e.f1609a = null;
            R(g_e, 1);
        } else {
            X(g_e.f1610b.f1622a == 12, "syntax error");
            a.z(cVar.w0(g_e.f1610b), 1);
        }
    }

    int s1(luaj.LuaString luaString) {
        c cVar = this.f1595g;
        luaj.h hVar = cVar.f1575b;
        gg_f.b[] bVarArr = hVar.f1727e;
        if (bVarArr == null || cVar.m + 1 > bVarArr.length) {
            hVar.f1727e = a.G(bVarArr, (cVar.m * 2) + 1);
        }
        hVar.f1727e[cVar.m] = new gg_f.b(luaString, 0, 0);
        short s2 = cVar.m;
        cVar.m = (short) (s2 + 1);
        return s2;
    }

    void t0(g$k g_k) {
        c cVar = this.f1595g;
        g$k g_k2 = new g$k();
        cVar.n0(g_k);
        g1();
        b0(g_k2);
        cVar.E0(g_k, g_k2);
    }

    void t1(int i) {
        c cVar = this.f1595g;
        int iZ0 = cVar.z0();
        c$a c_a = new c$a();
        c$a c_a2 = new c$a();
        cVar.j0(c_a, true);
        cVar.j0(c_a2, false);
        g1();
        F1();
        Z(277, 273, i);
        int iH0 = h0();
        if (c_a2.f1585e) {
            cVar.S0(iH0, c_a2.f1584d);
        }
        cVar.K0();
        cVar.T0(iH0, iZ0);
        cVar.K0();
    }

    void u0(g$f g_f) {
        g$f[] g_fArr = this.l.f1605c;
        int i = this.f1595g.f1579f.f1583c;
        while (i < this.l.f1606d) {
            if (g_fArr[i].f1611a.P0(g_f.f1611a)) {
                e0(i, g_f);
            } else {
                i++;
            }
        }
    }

    void u1() {
        int iQ0;
        c cVar = this.f1595g;
        g$k g_k = new g$k();
        int iM0 = 0;
        if (T(true) || this.f1593e.f1619a == 59) {
            iQ0 = 0;
        } else {
            iQ0 = q0(g_k);
            if (G0(g_k.f1622a)) {
                cVar.h1(g_k);
                if (g_k.f1622a == 12 && iQ0 == 1) {
                    a.B(cVar.w0(g_k), 30);
                    a.C(luaj.b.c(cVar.v0(g_k)) == cVar.n);
                }
                iM0 = cVar.n;
                iQ0 = -1;
            } else if (iQ0 == 1) {
                iM0 = cVar.m0(g_k);
            } else {
                cVar.o0(g_k);
                short s2 = cVar.n;
                a.C(iQ0 == cVar.p - s2);
                iM0 = s2;
            }
        }
        cVar.c1(iM0, iQ0);
        L1(59);
    }

    boolean v0(int i) {
        c$a c_a = this.f1595g.f1579f;
        g$d g_d = this.l;
        g$f g_f = g_d.f1605c[i];
        for (int i2 = c_a.f1582b; i2 < g_d.f1608f; i2++) {
            g$f g_f2 = g_d.f1607e[i2];
            if (g_f2.f1611a.P0(g_f.f1611a)) {
                short s2 = g_f.f1614d;
                short s3 = g_f2.f1614d;
                if (s2 > s3 && (c_a.f1585e || g_d.f1608f > c_a.f1582b)) {
                    this.f1595g.S0(g_f.f1612b, s3);
                }
                e0(i, g_f2);
                return true;
            }
        }
        return false;
    }

    void v1(int i) {
        char[] cArrE = this.j;
        int i2 = this.k;
        if (cArrE == null || i2 + 1 > cArrE.length) {
            cArrE = a.E(cArrE, (i2 * 2) + 1);
            this.j = cArrE;
        }
        cArrE[i2] = (char) i;
        this.k = i2 + 1;
    }

    void w0(int i, int i2, int i3, boolean z) {
        int i4;
        c$a c_a = new c$a();
        c cVar = this.f1595g;
        Q(3);
        c0(259);
        int iV = z ? cVar.V(33, i, -1) : cVar.H0();
        cVar.j0(c_a, false);
        Q(i3);
        cVar.b1(i3);
        S();
        cVar.K0();
        cVar.W0(iV);
        if (z) {
            i4 = 32;
        } else {
            cVar.T(34, i, 0, i3);
            cVar.s0(i2);
            i += 2;
            i4 = 35;
        }
        cVar.T0(cVar.V(i4, i, -1), iV + 1);
        cVar.s0(i2);
    }

    void w1() {
        v1(this.f1590b);
        h1();
    }

    void x0(luaj.LuaString luaString) {
        c cVar = this.f1595g;
        g$k g_k = new g$k();
        short s2 = cVar.p;
        c1("(for generator)");
        c1("(for state)");
        c1("(for control)");
        b1(luaString);
        int i = 4;
        while (L1(44)) {
            b1(G1());
            i++;
        }
        c0(268);
        int i2 = this.f1591c;
        P(3, q0(g_k), g_k);
        cVar.Q(3);
        w0(s2, i2, i - 3, false);
    }

    void x1(java.lang.String str) {
        this.f1593e.f1619a = 0;
        J1(str);
    }

    void y0(luaj.LuaString luaString, int i) {
        c cVar = this.f1595g;
        short s2 = cVar.p;
        c1("(for index)");
        c1("(for limit)");
        c1("(for step)");
        b1(luaString);
        c0(61);
        p0();
        c0(44);
        p0();
        if (L1(44)) {
            p0();
        } else {
            cVar.W(cVar.p, cVar.R0(luaj.LuaLong.I2(1L)));
            cVar.b1(1);
        }
        w0(s2, i, 1, true);
    }

    void y1(h$a h_a, int i, java.io.InputStream inputStream, luaj.LuaString luaString) {
        this.o = (byte) 46;
        this.h = h_a;
        this.f1594f.f1619a = 289;
        this.i = inputStream;
        this.f1595g = null;
        this.f1591c = 1;
        this.f1592d = 1;
        this.m = luaString;
        this.n = luaj.LuaValue.k;
        this.k = 0;
        this.f1590b = i;
        B1();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x004f  */
    void z0(int i) {
        c cVar = this.f1595g;
        cVar.j0(new c$a(), true);
        g1();
        luaj.LuaString luaStringG1 = G1();
        int i2 = this.f1593e.f1619a;
        if (i2 == 44) {
            x0(luaStringG1);
        } else if (i2 == 61) {
            y0(luaStringG1, i);
        } else if (i2 != 268) {
            J1(M("=") + " or " + M("in") + " expected");
        } else {
            x0(luaStringG1);
        }
        Z(262, 264, i);
        cVar.K0();
    }

    void z1(g$k g_k) {
        int i;
        g$i g_i = this.f1593e;
        int i2 = g_i.f1619a;
        if (i2 == 123) {
            i0(g_k);
            return;
        }
        if (i2 != 263) {
            if (i2 == 265) {
                g1();
                U(g_k, false, this.f1591c);
                return;
            }
            if (i2 == 270) {
                g_k.b(1, 0);
            } else if (i2 == 276) {
                i = 2;
            } else if (i2 == 281) {
                c cVar = this.f1595g;
                X(cVar.f1575b.k != 0, "cannot use " + M("...") + " outside a vararg function");
                g_k.b(13, cVar.T(38, 0, 1, 0));
            } else if (i2 == 290) {
                g_k.b(5, 0);
                g_k.f1623b.b(this.f1593e.f1620b.f1617a);
            } else {
                if (i2 != 293) {
                    I1(g_k);
                    return;
                }
                g0(g_k, g_i.f1620b.f1618b);
            }
            g1();
        }
        i = 3;
        g_k.b(i, 0);
        g1();
    }
}

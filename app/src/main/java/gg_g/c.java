package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    luaj.h f1575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    java.util.Hashtable f1576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    c f1577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    g f1578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    c$a f1579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1580g;
    int h;
    e i;
    int j;
    int k;
    int l;
    short m;
    short n;
    short o;
    short p;

    c() {
    }

    static int k1(c cVar, luaj.LuaString luaString, g$k g_k, int i) {
        if (cVar == null) {
            return 0;
        }
        int iE1 = cVar.e1(luaString);
        if (iE1 >= 0) {
            g_k.b(7, iE1);
            if (i == 0) {
                cVar.L0(iE1);
            }
            return 7;
        }
        int iD1 = cVar.d1(luaString);
        if (iD1 < 0) {
            if (k1(cVar.f1577d, luaString, g_k, 0) == 0) {
                return 0;
            }
            iD1 = cVar.O0(luaString, g_k);
        }
        g_k.b(8, iD1);
        return 8;
    }

    static boolean n1(int i) {
        return i == 6 || i == 7;
    }

    gg_f.b A0(int i) {
        short s = this.f1578e.l.f1603a[this.l + i].f1621a;
        a.C(s < this.m);
        return this.f1575b.f1727e[s];
    }

    void B0(g$k g_k) {
        int iI0;
        i0(g_k);
        int i = g_k.f1622a;
        if (i == 1 || i == 3) {
            iI0 = -1;
        } else {
            iI0 = i != 10 ? I0(g_k, 1) : g_k.f1623b.f1630e;
        }
        c0(g_k.f1624c, iI0);
        W0(g_k.f1625d.f1589a);
        g_k.f1625d.f1589a = -1;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    void C0(g$k g_k) {
        int iI0;
        i0(g_k);
        int i = g_k.f1622a;
        if (i == 2) {
            iI0 = -1;
        } else if (i == 10) {
            G0(g_k);
            iI0 = g_k.f1623b.f1630e;
        } else if (i == 4 || i == 5) {
            iI0 = -1;
        } else {
            iI0 = I0(g_k, 0);
        }
        c0(g_k.f1625d, iI0);
        W0(g_k.f1624c.f1589a);
        g_k.f1624c.f1589a = -1;
    }

    boolean D0(int i) {
        return i == 12 || i == 13;
    }

    void E0(g$k g_k, g$k g_k2) {
        g$k$a g_k_a = g_k.f1623b;
        g_k_a.f1627b = (short) g_k_a.f1630e;
        g_k_a.f1626a = (short) l0(g_k2);
        int i = g_k.f1622a;
        a.C(i == 8 || n1(i));
        g_k.f1623b.f1628c = (short) (g_k.f1622a != 8 ? 7 : 8);
        g_k.f1622a = 9;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:8:0x0016  */
    void F0(int i, g$k g_k) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                if (g_k.c()) {
                }
                l0(g_k);
                break;
            case 6:
                o0(g_k);
                break;
            default:
                switch (i) {
                    case 13:
                        C0(g_k);
                        break;
                    case 14:
                        B0(g_k);
                        break;
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        if (g_k.c()) {
                        }
                        break;
                }
                l0(g_k);
                break;
        }
    }

    void G0(g$k g_k) {
        d dVarY0 = y0(g_k.f1623b.f1630e);
        a.C((!luaj.b.r(luaj.b.i(dVarY0.a())) || luaj.b.i(dVarY0.a()) == 28 || luaj.b.i(dVarY0.a()) == 27) ? false : true);
        a.v(dVarY0, luaj.b.c(dVarY0.a()) == 0 ? 1 : 0);
    }

    int H0() {
        e eVar = this.i;
        int i = eVar.f1589a;
        eVar.f1589a = -1;
        e eVar2 = new e(V(23, 0, -1));
        c0(eVar2, i);
        return eVar2.f1589a;
    }

    int I0(g$k g_k, int i) {
        if (g_k.f1622a == 11) {
            int iV0 = v0(g_k);
            if (luaj.b.i(iV0) == 20) {
                this.f1580g--;
                return d0(27, luaj.b.e(iV0), 0, i != 0 ? 0 : 1);
            }
        }
        f0(g_k);
        t0(g_k);
        return d0(28, 255, g_k.f1623b.f1630e, i);
    }

    void J0(g$c g_c) {
        if (g_c.f1602e == 0) {
            return;
        }
        if (D0(g_c.f1598a.f1622a)) {
            h1(g_c.f1598a);
            g1(g_c.f1599b.f1623b.f1630e, g_c.f1601d, -1);
            g_c.f1601d--;
        } else {
            g$k g_k = g_c.f1598a;
            if (g_k.f1622a != 0) {
                o0(g_k);
            }
            g1(g_c.f1599b.f1623b.f1630e, g_c.f1601d, g_c.f1602e);
        }
    }

    void K0() {
        c$a c_a = this.f1579f;
        if (c_a.f1581a != null && c_a.f1585e) {
            int iH0 = H0();
            S0(iH0, c_a.f1584d);
            W0(iH0);
        }
        if (c_a.f1586f) {
            this.f1578e.V();
        }
        this.f1579f = c_a.f1581a;
        a1(c_a.f1584d);
        a.C(c_a.f1584d == this.n);
        this.p = this.n;
        g gVar = this.f1578e;
        g$d g_d = gVar.l;
        g_d.f1608f = c_a.f1582b;
        if (c_a.f1581a != null) {
            M0(c_a);
            return;
        }
        short s = c_a.f1583c;
        if (s < g_d.f1606d) {
            gVar.O1(g_d.f1605c[s], this, c_a);
        }
    }

    void L0(int i) {
        c$a c_a = this.f1579f;
        while (c_a.f1584d > i) {
            c_a = c_a.f1581a;
        }
        c_a.f1585e = true;
    }

    int M(luaj.LuaValue luaValue) {
        java.util.Hashtable hashtable = this.f1576c;
        if (hashtable == null) {
            hashtable = new java.util.Hashtable();
            this.f1576c = hashtable;
        } else {
            java.lang.Integer num = (java.lang.Integer) hashtable.get(luaValue);
            if (num != null) {
                return num.intValue();
            }
        }
        int i = this.j;
        hashtable.put(luaValue, java.lang.Integer.valueOf(i));
        luaj.h hVar = this.f1575b;
        luaj.LuaValue[] luaValueArr = hVar.f1723a;
        if (luaValueArr == null || this.j + 1 >= luaValueArr.length) {
            hVar.f1723a = a.K(luaValueArr, (this.j * 2) + 1);
        }
        luaj.LuaValue[] luaValueArr2 = hVar.f1723a;
        int i2 = this.j;
        this.j = i2 + 1;
        luaValueArr2[i2] = luaValue;
        return i;
    }

    void M0(c$a c_a) {
        int i = c_a.f1583c;
        g$f[] g_fArr = this.f1578e.l.f1605c;
        while (i < this.f1578e.l.f1606d) {
            g$f g_f = g_fArr[i];
            short s = g_f.f1614d;
            short s2 = c_a.f1584d;
            if (s > s2) {
                if (c_a.f1585e) {
                    S0(g_f.f1612b, s2);
                }
                g_f.f1614d = c_a.f1584d;
            }
            if (!this.f1578e.v0(i)) {
                i++;
            }
        }
    }

    int N(boolean z) {
        return M(z ? luaj.LuaValue.f1674d : luaj.LuaValue.f1675e);
    }

    boolean N0(int i) {
        while (i != -1) {
            if (luaj.b.i(y0(i).a()) != 28) {
                return true;
            }
            i = x0(i);
        }
        return false;
    }

    void O(int i, int i2, java.lang.String str) {
        if (i > i2) {
            k0(i2, str);
        }
    }

    int O0(luaj.LuaString luaString, g$k g_k) {
        O(this.o + 1, 255, "upvalues");
        luaj.h hVar = this.f1575b;
        gg_f.d[] dVarArr = hVar.f1728f;
        if (dVarArr == null || this.o + 1 > dVarArr.length) {
            short s = this.o;
            hVar.f1728f = a.H(dVarArr, s > 0 ? s * 2 : 1);
        }
        this.f1575b.f1728f[this.o] = new gg_f.d(luaString, g_k.f1622a == 7, g_k.f1623b.f1630e);
        short s2 = this.o;
        this.o = (short) (s2 + 1);
        return s2;
    }

    void P(g$f[] g_fArr, int i, luaj.LuaString luaString) {
        for (int i2 = this.f1579f.f1582b; i2 < i; i2++) {
            if (luaString.P0(g_fArr[i2].f1611a)) {
                this.f1578e.x1(this.f1578e.h.e("label '" + luaString + "' already defined on line " + g_fArr[i2].f1613c));
            }
        }
    }

    void P0(int i, int i2) {
        int i3 = i + i2;
        int i4 = i3 - 1;
        int i5 = this.f1580g;
        if (i5 > this.h && i5 > 0) {
            int i6 = this.f1575b.f1724b[i5 - 1];
            if (luaj.b.i(i6) == 4) {
                int iC = luaj.b.c(i6);
                int iE = luaj.b.e(i6) + iC;
                if ((iC <= i && i <= iE + 1) || (i <= iC && iC <= i3)) {
                    if (iC < i) {
                        i = iC;
                    }
                    if (iE > i4) {
                        i4 = iE;
                    }
                    d dVar = new d(this.f1575b.f1724b, this.f1580g - 1);
                    a.v(dVar, i);
                    a.x(dVar, i4 - i);
                    return;
                }
            }
        }
        T(4, i, i2 - 1, 0);
    }

    void Q(int i) {
        int i2 = this.p + i;
        if (i2 > this.f1575b.l) {
            if (i2 >= 250) {
                this.f1578e.J1("function or expression needs too many registers");
            }
            this.f1575b.l = i2;
        }
    }

    int Q0() {
        return M(luaj.LuaValue.f1673c);
    }

    void R(g$c g_c) {
        g$k g_k = g_c.f1598a;
        if (g_k.f1622a == 0) {
            return;
        }
        o0(g_k);
        g_c.f1598a.f1622a = 0;
        int i = g_c.f1602e;
        if (i == 50) {
            g1(g_c.f1599b.f1623b.f1630e, g_c.f1601d, i);
            g_c.f1602e = 0;
        }
    }

    int R0(luaj.LuaValue luaValue) {
        return M(luaValue);
    }

    int S(int i, int i2) {
        luaj.h hVar = this.f1575b;
        h0();
        int[] iArr = hVar.f1724b;
        if (iArr == null || this.f1580g + 1 > iArr.length) {
            hVar.f1724b = a.F(iArr, (this.f1580g * 2) + 1);
        }
        int[] iArr2 = hVar.f1724b;
        int i3 = this.f1580g;
        iArr2[i3] = i;
        int[] iArr3 = hVar.f1726d;
        if (iArr3 == null || i3 + 1 > iArr3.length) {
            hVar.f1726d = a.F(iArr3, (i3 * 2) + 1);
        }
        int[] iArr4 = hVar.f1726d;
        int i4 = this.f1580g;
        iArr4[i4] = i2;
        this.f1580g = i4 + 1;
        return i4;
    }

    void S0(int i, int i2) {
        int i3 = i2 + 1;
        while (i != -1) {
            int iX0 = x0(i);
            a.C(luaj.b.i(this.f1575b.f1724b[i]) == 23 && (luaj.b.c(this.f1575b.f1724b[i]) == 0 || luaj.b.c(this.f1575b.f1724b[i]) >= i3));
            a.w(this.f1575b.f1724b, i, i3);
            i = iX0;
        }
    }

    int T(int i, int i2, int i3, int i4) {
        a.C(luaj.b.p(i) == 0);
        a.C(luaj.b.n(i) != 0 || i3 == 0);
        a.C(luaj.b.o(i) != 0 || i4 == 0);
        return S(a.s(i, i2, i3, i4), this.f1578e.f1592d);
    }

    void T0(int i, int i2) {
        int i3 = this.f1580g;
        if (i2 == i3) {
            W0(i);
        } else {
            a.C(i2 < i3);
            U0(i, i2, 255, i2);
        }
    }

    int U(int i, int i2, int i3) {
        boolean z = false;
        a.C(luaj.b.p(i) == 1 || luaj.b.p(i) == 2);
        a.C(luaj.b.o(i) == 0);
        if (i3 >= 0 && i3 <= 262143) {
            z = true;
        }
        a.C(z);
        return S(a.t(i, i2, i3), this.f1578e.f1592d);
    }

    void U0(int i, int i2, int i3, int i4) {
        while (i != -1) {
            int iX0 = x0(i);
            if (V0(i, i3)) {
                r0(i, i2);
            } else {
                r0(i, i4);
            }
            i = iX0;
        }
    }

    int V(int i, int i2, int i3) {
        return U(i, i2, i3 + 131071);
    }

    boolean V0(int i, int i2) {
        d dVarY0 = y0(i);
        if (luaj.b.i(dVarY0.a()) != 28) {
            return false;
        }
        if (i2 == 255 || i2 == luaj.b.e(dVarY0.a())) {
            dVarY0.b(a.s(27, luaj.b.e(dVarY0.a()), 0, luaj.b.g(dVarY0.a())));
            return true;
        }
        a.v(dVarY0, i2);
        return true;
    }

    int W(int i, int i2) {
        if (i2 <= 262143) {
            return U(1, i, i2);
        }
        int iU = U(2, i, 0);
        a0(i2);
        return iU;
    }

    void W0(int i) {
        z0();
        c0(this.i, i);
    }

    int X(int i, int i2, int i3) {
        z0();
        return T(3, i, i2, i3);
    }

    void X0(int i, g$k g_k, g$k g_k2, int i2) {
        int i3;
        e eVar;
        e eVar2;
        switch (i) {
            case 0:
                i3 = 13;
                Y(i3, g_k, g_k2, i2);
                break;
            case 1:
                i3 = 14;
                Y(i3, g_k, g_k2, i2);
                break;
            case 2:
                i3 = 15;
                Y(i3, g_k, g_k2, i2);
                break;
            case 3:
                i3 = 16;
                Y(i3, g_k, g_k2, i2);
                break;
            case 4:
                i3 = 17;
                Y(i3, g_k, g_k2, i2);
                break;
            case 5:
                i3 = 18;
                Y(i3, g_k, g_k2, i2);
                break;
            case 6:
                q0(g_k2);
                if (g_k2.f1622a == 11 && luaj.b.i(v0(g_k2)) == 22) {
                    a.C(g_k.f1623b.f1630e == luaj.b.e(v0(g_k2)) - 1);
                    t0(g_k);
                    a.x(w0(g_k2), g_k.f1623b.f1630e);
                    g_k.f1622a = 11;
                    g_k.f1623b.f1630e = g_k2.f1623b.f1630e;
                } else {
                    o0(g_k2);
                    Y(22, g_k, g_k2, i2);
                }
                break;
            case 7:
                Z(24, 0, g_k, g_k2);
                break;
            case 8:
                Z(24, 1, g_k, g_k2);
                break;
            case 9:
                Z(25, 1, g_k, g_k2);
                break;
            case 10:
                Z(26, 1, g_k, g_k2);
                break;
            case 11:
                Z(25, 0, g_k, g_k2);
                break;
            case 12:
                Z(26, 0, g_k, g_k2);
                break;
            case 13:
                a.C(g_k.f1624c.f1589a == -1);
                i0(g_k2);
                eVar = g_k2.f1625d;
                eVar2 = g_k.f1625d;
                c0(eVar, eVar2.f1589a);
                g_k.d(g_k2);
                break;
            case 14:
                a.C(g_k.f1625d.f1589a == -1);
                i0(g_k2);
                eVar = g_k2.f1624c;
                eVar2 = g_k.f1624c;
                c0(eVar, eVar2.f1589a);
                g_k.d(g_k2);
                break;
            case 15:
                i3 = 40;
                Y(i3, g_k, g_k2, i2);
                break;
            case 16:
                i3 = 42;
                Y(i3, g_k, g_k2, i2);
                break;
            case 17:
                i3 = 43;
                Y(i3, g_k, g_k2, i2);
                break;
            case 18:
                i3 = 44;
                Y(i3, g_k, g_k2, i2);
                break;
            case 19:
                i3 = 45;
                Y(i3, g_k, g_k2, i2);
                break;
            case 20:
                i3 = 46;
                Y(i3, g_k, g_k2, i2);
                break;
            default:
                a.C(false);
                break;
        }
    }

    void Y(int i, g$k g_k, g$k g_k2, int i2) {
        if (e0(i, g_k, g_k2)) {
            return;
        }
        int iL0 = (i == 19 || i == 21 || i == 41) ? 0 : l0(g_k2);
        int iL1 = l0(g_k);
        if (iL1 > iL0) {
            t0(g_k);
            t0(g_k2);
        } else {
            t0(g_k2);
            t0(g_k);
        }
        g_k.f1623b.f1630e = T(i, 0, iL1, iL0);
        g_k.f1622a = 11;
        s0(i2);
    }

    void Y0(int i, g$k g_k, int i2) {
        int i3;
        g$k$a g_k_a;
        luaj.LuaValue luaValueA1;
        g$k g_k2 = new g$k();
        g_k2.b(5, 0);
        if (i == 0) {
            if (g_k.c()) {
                g_k_a = g_k.f1623b;
                luaValueA1 = g_k_a.a().A1();
                g_k_a.b(luaValueA1);
                return;
            } else {
                m0(g_k);
                i3 = 19;
                Y(i3, g_k, g_k2, i2);
            }
        }
        if (i == 1) {
            b0(g_k);
            return;
        }
        if (i == 2) {
            m0(g_k);
            i3 = 21;
        } else if (i != 4) {
            a.C(false);
            return;
        } else {
            if (g_k.c()) {
                g_k_a = g_k.f1623b;
                luaValueA1 = g_k_a.a().q0();
                g_k_a.b(luaValueA1);
                return;
            }
            m0(g_k);
            i3 = 41;
        }
        Y(i3, g_k, g_k2, i2);
    }

    void Z(int i, int i2, g$k g_k, g$k g_k2) {
        int iL0 = l0(g_k);
        int iL1 = l0(g_k2);
        t0(g_k2);
        t0(g_k);
        if (i2 == 0 && i != 24) {
            i2 = 1;
            iL1 = iL0;
            iL0 = iL1;
        }
        g_k.f1623b.f1630e = d0(i, i2, iL0, iL1);
        g_k.f1622a = 10;
    }

    void Z0(int i) {
        while (i != -1) {
            V0(i, 255);
            i = x0(i);
        }
    }

    int a0(int i) {
        a.C(i <= 67108863);
        return S(a.u(39, i), this.f1578e.f1592d);
    }

    void a1(int i) {
        this.f1578e.l.f1604b -= this.n - i;
        while (true) {
            short s = this.n;
            if (s <= i) {
                return;
            }
            short s2 = (short) (s - 1);
            this.n = s2;
            A0(s2).f1560c = this.f1580g;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    void b0(g$k g_k) {
        int i;
        i0(g_k);
        int i2 = g_k.f1622a;
        if (i2 == 10) {
            G0(g_k);
        } else if (i2 != 11) {
            switch (i2) {
                case 1:
                case 3:
                    i = 2;
                    g_k.f1622a = i;
                    break;
                case 2:
                case 4:
                case 5:
                    i = 3;
                    g_k.f1622a = i;
                    break;
                case 6:
                    f0(g_k);
                    t0(g_k);
                    g$k$a g_k_a = g_k.f1623b;
                    g_k_a.f1630e = T(20, 0, g_k_a.f1630e, 0);
                    g_k.f1622a = 11;
                    break;
                default:
                    a.C(false);
                    break;
            }
        } else {
            f0(g_k);
            t0(g_k);
            g$k$a g_k_a2 = g_k.f1623b;
            g_k_a2.f1630e = T(20, 0, g_k_a2.f1630e, 0);
            g_k.f1622a = 11;
        }
        e eVar = g_k.f1625d;
        int i3 = eVar.f1589a;
        e eVar2 = g_k.f1624c;
        eVar.f1589a = eVar2.f1589a;
        eVar2.f1589a = i3;
        Z0(eVar.f1589a);
        Z0(g_k.f1624c.f1589a);
    }

    void b1(int i) {
        Q(i);
        this.p = (short) (this.p + i);
    }

    void c0(e eVar, int i) {
        if (i == -1) {
            return;
        }
        int i2 = eVar.f1589a;
        if (i2 == -1) {
            eVar.f1589a = i;
            return;
        }
        while (true) {
            int iX0 = x0(i2);
            if (iX0 == -1) {
                r0(i2, i);
                return;
            }
            i2 = iX0;
        }
    }

    void c1(int i, int i2) {
        T(31, i, i2 + 1, 0);
    }

    int d0(int i, int i2, int i3, int i4) {
        T(i, i2, i3, i4);
        return H0();
    }

    int d1(luaj.LuaString luaString) {
        gg_f.d[] dVarArr = this.f1575b.f1728f;
        for (int i = 0; i < this.o; i++) {
            if (dVarArr[i].f1565a.P0(luaString)) {
                return i;
            }
        }
        return -1;
    }

    boolean e0(int i, g$k g_k, g$k g_k2) {
        luaj.LuaValue luaValueJ0;
        if (!g_k.c() || !g_k2.c() || ((i == 16 || i == 40 || i == 17) && g_k2.f1623b.a().P0(luaj.LuaValue.f1677g))) {
            return false;
        }
        luaj.LuaValue luaValueA = g_k.f1623b.a();
        luaj.LuaValue luaValueA2 = g_k2.f1623b.a();
        if (i != 21) {
            switch (i) {
                case 13:
                    luaValueJ0 = luaValueA.j0(luaValueA2);
                    break;
                case 14:
                    luaValueJ0 = luaValueA.r2(luaValueA2);
                    break;
                case 15:
                    luaValueJ0 = luaValueA.z1(luaValueA2);
                    break;
                case 16:
                    luaValueJ0 = luaValueA.O0(luaValueA2);
                    break;
                case 17:
                    luaValueJ0 = luaValueA.y1(luaValueA2);
                    break;
                case 18:
                    luaValueJ0 = luaValueA.Q1(luaValueA2);
                    break;
                case 19:
                    luaValueJ0 = luaValueA.A1();
                    break;
                default:
                    switch (i) {
                        case 40:
                            luaValueJ0 = luaValueA.Z0(luaValueA2);
                            break;
                        case 41:
                            if (!luaValueA.k1()) {
                                return false;
                            }
                            luaValueJ0 = luaValueA.q0();
                            break;
                        case 42:
                            if (!luaValueA.k1() || !luaValueA2.k1()) {
                                return false;
                            }
                            luaValueJ0 = luaValueA.o0(luaValueA2);
                            break;
                        case 43:
                            if (!luaValueA.k1() || !luaValueA2.k1()) {
                                return false;
                            }
                            luaValueJ0 = luaValueA.r0(luaValueA2);
                            break;
                        case 44:
                            if (!luaValueA.k1() || !luaValueA2.k1()) {
                                return false;
                            }
                            luaValueJ0 = luaValueA.t0(luaValueA2);
                            break;
                        case 45:
                            if (!luaValueA.k1() || !luaValueA2.k1()) {
                                return false;
                            }
                            luaValueJ0 = luaValueA.m2(luaValueA2);
                            break;
                        case 46:
                            if (!luaValueA.k1() || !luaValueA2.k1()) {
                                return false;
                            }
                            luaValueJ0 = luaValueA.n2(luaValueA2);
                            break;
                        default:
                            a.C(false);
                            luaValueJ0 = null;
                            break;
                    }
                    break;
            }
            if (luaValueJ0 != null && !java.lang.Double.isNaN(luaValueJ0.x2())) {
                g_k.f1623b.b(luaValueJ0);
                return true;
            }
        }
        return false;
    }

    int e1(luaj.LuaString luaString) {
        for (int i = this.n - 1; i >= 0; i--) {
            if (luaString.P0(A0(i).f1558a)) {
                return i;
            }
        }
        return -1;
    }

    void f0(g$k g_k) {
        if (g_k.f1622a != 6) {
            b1(1);
            g0(g_k, this.p - 1);
        }
    }

    void f1(g$k g_k, g$k g_k2) {
        m0(g_k);
        t0(g_k);
        short s = this.p;
        b1(2);
        T(12, s, g_k.f1623b.f1630e, l0(g_k2));
        t0(g_k2);
        g_k.f1623b.f1630e = s;
        g_k.f1622a = 6;
    }

    void g0(g$k g_k, int i) {
        int iR0;
        i0(g_k);
        int i2 = g_k.f1622a;
        if (i2 != 11) {
            boolean z = true;
            switch (i2) {
                case 1:
                    P0(i, 1);
                    break;
                case 2:
                case 3:
                    T(3, i, i2 != 2 ? 0 : 1, 0);
                    break;
                case 4:
                    iR0 = g_k.f1623b.f1630e;
                    W(i, iR0);
                    break;
                case 5:
                    iR0 = R0(g_k.f1623b.a());
                    W(i, iR0);
                    break;
                case 6:
                    int i3 = g_k.f1623b.f1630e;
                    if (i != i3) {
                        T(0, i, i3, 0);
                    }
                    break;
                default:
                    if (i2 != 0 && i2 != 10) {
                        z = false;
                    }
                    a.C(z);
                    break;
            }
            return;
        }
        a.v(w0(g_k), i);
        g_k.f1623b.f1630e = i;
        g_k.f1622a = 6;
    }

    void g1(int i, int i2, int i3) {
        int i4 = ((i2 - 1) / 50) + 1;
        if (i3 == -1) {
            i3 = 0;
        }
        if (i4 <= 511) {
            T(36, i, i3, i4);
        } else {
            T(36, i, i3, 0);
            S(i4, this.f1578e.f1592d);
        }
        this.p = (short) (i + 1);
    }

    void h0() {
        int i = this.i.f1589a;
        int i2 = this.f1580g;
        U0(i, i2, 255, i2);
        this.i.f1589a = -1;
    }

    void h1(g$k g_k) {
        j1(g_k, -1);
    }

    void i0(g$k g_k) {
        g$k$a g_k_a;
        int iT;
        int i = g_k.f1622a;
        int i2 = 6;
        if (i == 7) {
            g_k.f1622a = 6;
            return;
        }
        if (i == 8) {
            g_k_a = g_k.f1623b;
            iT = T(5, 0, g_k_a.f1630e, 0);
        } else {
            if (i != 9) {
                if (i == 12 || i == 13) {
                    i1(g_k);
                    return;
                }
                return;
            }
            u0(g_k.f1623b.f1626a);
            g$k$a g_k_a2 = g_k.f1623b;
            if (g_k_a2.f1628c == 7) {
                u0(g_k_a2.f1627b);
                i2 = 7;
            }
            g_k_a = g_k.f1623b;
            iT = T(i2, 0, g_k_a.f1627b, g_k_a.f1626a);
        }
        g_k_a.f1630e = iT;
        g_k.f1622a = 11;
    }

    void i1(g$k g_k) {
        int i = g_k.f1622a;
        if (i == 12) {
            g_k.f1622a = 6;
            g_k.f1623b.f1630e = luaj.b.c(v0(g_k));
        } else if (i == 13) {
            a.x(w0(g_k), 2);
            g_k.f1622a = 11;
        }
    }

    void j0(c$a c_a, boolean z) {
        c_a.f1586f = z;
        short s = this.n;
        c_a.f1584d = s;
        g$d g_d = this.f1578e.l;
        c_a.f1582b = (short) g_d.f1608f;
        c_a.f1583c = (short) g_d.f1606d;
        c_a.f1585e = false;
        c_a.f1581a = this.f1579f;
        this.f1579f = c_a;
        a.C(this.p == s);
    }

    void j1(g$k g_k, int i) {
        int i2 = g_k.f1622a;
        if (i2 == 12) {
            a.z(w0(g_k), i + 1);
        } else if (i2 == 13) {
            a.x(w0(g_k), i + 1);
            a.v(w0(g_k), this.p);
            b1(1);
        }
    }

    void k0(int i, java.lang.String str) {
        h$a h_a;
        java.lang.StringBuilder sb;
        java.lang.String str2;
        if (this.f1575b.h == 0) {
            h_a = this.f1578e.h;
            sb = new java.lang.StringBuilder();
            str2 = "main function has more than ";
        } else {
            h_a = this.f1578e.h;
            sb = new java.lang.StringBuilder();
            sb.append("function at line ");
            sb.append(this.f1575b.h);
            str2 = " has more than ";
        }
        sb.append(str2);
        sb.append(i);
        sb.append(' ');
        sb.append(str);
        this.f1578e.T0(h_a.e(sb.toString()), 0);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    int l0(g$k g_k) {
        int iN;
        int i;
        q0(g_k);
        int i2 = g_k.f1622a;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (this.j <= 255) {
                g$k$a g_k_a = g_k.f1623b;
                if (i2 == 1) {
                    iN = Q0();
                } else {
                    iN = N(i2 == 2);
                }
                g_k_a.f1630e = iN;
                g_k.f1622a = 4;
                return luaj.b.l(g_k.f1623b.f1630e);
            }
        } else if (i2 == 4) {
            i = g_k.f1623b.f1630e;
            if (i <= 255) {
                return luaj.b.l(i);
            }
        } else if (i2 == 5) {
            g$k$a g_k_a2 = g_k.f1623b;
            g_k_a2.f1630e = R0(g_k_a2.a());
            g_k.f1622a = 4;
            i = g_k.f1623b.f1630e;
            if (i <= 255) {
                return luaj.b.l(i);
            }
        }
        return m0(g_k);
    }

    void l1(g$k g_k, g$k g_k2) {
        int i = g_k.f1622a;
        if (i == 7) {
            t0(g_k2);
            p0(g_k2, g_k.f1623b.f1630e);
            return;
        }
        if (i == 8) {
            T(9, m0(g_k2), g_k.f1623b.f1630e, 0);
        } else if (i != 9) {
            a.C(false);
        } else {
            int i2 = g_k.f1623b.f1628c == 7 ? 10 : 8;
            int iL0 = l0(g_k2);
            g$k$a g_k_a = g_k.f1623b;
            T(i2, g_k_a.f1627b, g_k_a.f1626a, iL0);
        }
        t0(g_k2);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    int m0(g$k g_k) {
        i0(g_k);
        if (g_k.f1622a != 6) {
            o0(g_k);
        } else if (g_k.a()) {
            int i = g_k.f1623b.f1630e;
            if (i >= this.n) {
                p0(g_k, i);
            } else {
                o0(g_k);
            }
        }
        return g_k.f1623b.f1630e;
    }

    int m1(luaj.LuaString luaString) {
        return M(luaString);
    }

    void n0(g$k g_k) {
        if (g_k.f1622a != 8 || g_k.a()) {
            m0(g_k);
        }
    }

    void o0(g$k g_k) {
        i0(g_k);
        t0(g_k);
        b1(1);
        p0(g_k, this.p - 1);
    }

    void p0(g$k g_k, int i) {
        int iX;
        int iX2;
        g0(g_k, i);
        if (g_k.f1622a == 10) {
            c0(g_k.f1624c, g_k.f1623b.f1630e);
        }
        if (g_k.a()) {
            if (N0(g_k.f1624c.f1589a) || N0(g_k.f1625d.f1589a)) {
                int iH0 = g_k.f1622a == 10 ? -1 : H0();
                iX = X(i, 0, 1);
                iX2 = X(i, 1, 0);
                W0(iH0);
            } else {
                iX2 = -1;
                iX = -1;
            }
            int iZ0 = z0();
            U0(g_k.f1625d.f1589a, iZ0, i, iX);
            U0(g_k.f1624c.f1589a, iZ0, i, iX2);
        }
        e eVar = g_k.f1625d;
        g_k.f1624c.f1589a = -1;
        eVar.f1589a = -1;
        g_k.f1623b.f1630e = i;
        g_k.f1622a = 6;
    }

    void q0(g$k g_k) {
        if (g_k.a()) {
            m0(g_k);
        } else {
            i0(g_k);
        }
    }

    void r0(int i, int i2) {
        d dVar = new d(this.f1575b.f1724b, i);
        int i3 = i2 - (i + 1);
        a.C(i2 != -1);
        if (java.lang.Math.abs(i3) > 131071) {
            this.f1578e.J1("control structure too long");
        }
        a.A(dVar, i3);
    }

    void s0(int i) {
        this.f1575b.f1726d[this.f1580g - 1] = i;
    }

    void t0(g$k g_k) {
        if (g_k.f1622a == 6) {
            u0(g_k.f1623b.f1630e);
        }
    }

    public java.lang.String toString() {
        return "FuncState [pc=" + this.f1580g + ", lasttarget=" + this.h + ", nk=" + this.j + ", np=" + this.k + ", firstlocal=" + this.l + ", nlocvars=" + ((int) this.m) + ", nactvar=" + ((int) this.n) + ", nups=" + ((int) this.o) + ", freereg=" + ((int) this.p) + ']';
    }

    void u0(int i) {
        if (luaj.b.k(i) || i < this.n) {
            return;
        }
        short s = (short) (this.p - 1);
        this.p = s;
        a.C(i == s);
    }

    int v0(g$k g_k) {
        return this.f1575b.f1724b[g_k.f1623b.f1630e];
    }

    d w0(g$k g_k) {
        return new d(this.f1575b.f1724b, g_k.f1623b.f1630e);
    }

    int x0(int i) {
        int iH = luaj.b.h(this.f1575b.f1724b[i]);
        if (iH == -1) {
            return -1;
        }
        return i + 1 + iH;
    }

    d y0(int i) {
        d dVar = new d(this.f1575b.f1724b, i);
        return (i < 1 || !luaj.b.r(luaj.b.i(dVar.f1587a[dVar.f1588b - 1]))) ? dVar : new d(dVar.f1587a, dVar.f1588b - 1);
    }

    int z0() {
        int i = this.f1580g;
        this.h = i;
        return i;
    }
}

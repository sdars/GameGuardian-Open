package lasm;

/* JADX INFO: loaded from: classes.dex */
public class a extends lasm.LasmBase implements gg_e.a {
    private static int[] l;
    private static int[] m;
    private static int[] n;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gg_e.c f1634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    gg_e.e f1635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gg_e.f f1636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public gg_e.f f1637e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1639g;
    private final int[] h;
    private java.util.List i;
    private int[] j;
    private int k;

    static {
        x();
        y();
        z();
    }

    public a(java.io.InputStream inputStream) {
        this(inputStream, null);
    }

    public a(java.io.InputStream inputStream, java.lang.String str) {
        this.h = new int[34];
        this.i = new java.util.ArrayList();
        this.k = -1;try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.UnsupportedEncodingException();
                    }

            this.f1635c = new gg_e.e(inputStream, str, 1, 1);
            this.f1634b = new gg_e.c(this.f1635c);
            this.f1636d = new gg_e.f();
            this.f1638f = -1;
            this.f1639g = 0;
            for (int i = 0; i < 34; i++) {
                this.h[i] = -1;
            }
        } catch (java.io.UnsupportedEncodingException e2) {
            throw new java.lang.RuntimeException(e2);
        };
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    private int A() {
        gg_e.f fVar = this.f1636d;
        gg_e.f fVarB = fVar.f1552g;
        this.f1637e = fVarB;
        if (fVarB == null) {
            fVarB = this.f1634b.b();
            fVar.f1552g = fVarB;
        }
        int i = fVarB.f1546a;
        this.f1638f = i;
        return i;
    }

    private gg_e.f w(int i) throws gg_e.d {
        gg_e.f fVar = this.f1636d;
        gg_e.f fVarB = fVar.f1552g;
        if (fVarB == null) {
            fVarB = this.f1634b.b();
            fVar.f1552g = fVarB;
        }
        this.f1636d = fVarB;
        this.f1638f = -1;
        gg_e.f fVar2 = this.f1636d;
        if (fVar2.f1546a == i) {
            this.f1639g++;
            return fVar2;
        }
        this.f1636d = fVar;
        this.k = i;
        throw v();
    }

    private static void x() {
        l = new int[]{0, 0, -32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 256, 67584, 0, 8273920, 58720288, 0, 0, 1879048192, 0, 0, 0, 0, 0, 0, 0, 0, -32, 0};
    }

    private static void y() {
        m = new int[]{0, 0, 2359295, 0, 251920384, 117702656, 134217728, 134217728, 1048576, 16777216, 0, 0, 0, 0, 0, 8388608, 64, 0, 0, 256000, 4096, 134217728, 176, 0, 0, 138412032, 138412032, 1028, 0, 0, 134217728, 537395200, 2359295, 0};
    }

    private static void z() {
        n = new int[]{1024, 16, 4192, 256, 1286144, 1277952, 24576, 8192, 4096, 131072, 4192, 128, 128, 128, 4192, 0, 0, 0, 2048, 0, 0, 8192, 0, 0, 2048, 8192, 8192, 0, 2048, 2048, 8192, 0, 0, 128};
    }

    public final lasm.b k() throws gg_e.d {
        lasm.b bVar = new lasm.b();
        w(62);
        w(81);
        bVar.f1729g = lasm.LasmBase.j(this.f1636d);
        w(74);
        w(63);
        w(79);
        bVar.h = lasm.LasmBase.e(this.f1636d);
        w(74);
        w(64);
        w(79);
        bVar.i = lasm.LasmBase.e(this.f1636d);
        w(74);
        w(65);
        w(79);
        bVar.j = lasm.LasmBase.g(this.f1636d, 255);
        w(74);
        w(66);
        w(79);
        bVar.k = lasm.LasmBase.g(this.f1636d, 255);
        w(74);
        w(67);
        w(79);
        bVar.p(this.f1636d);
        w(74);
        while (true) {
            int iA = this.f1638f;
            if (iA == -1) {
                iA = A();
            }
            if (iA != 68) {
                break;
            }
            t(bVar);
        }
        this.h[1] = this.f1639g;
        while (true) {
            o(bVar);
            int iA2 = this.f1638f;
            if (iA2 == -1) {
                iA2 = A();
            }
            if (iA2 != 53 && iA2 != 76 && iA2 != 69 && iA2 != 70) {
                switch (iA2) {
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        break;
                    default:
                        this.h[2] = this.f1639g;
                        while (true) {
                            int iA3 = this.f1638f;
                            if (iA3 == -1) {
                                iA3 = A();
                            }
                            if (iA3 != 72) {
                                this.h[3] = this.f1639g;
                                return bVar.j();
                            }
                            m(bVar);
                        }
                }
            }
        }
    }

    public final gg_e.f l() throws gg_e.d {
        int iA = this.f1638f;
        if (iA == -1) {
            iA = A();
        }
        if (iA == 52) {
            w(52);
            gg_e.f fVarW = w(60);
            w(89);
            return fVarW;
        }
        if (iA == 76) {
            return w(76);
        }
        this.h[8] = this.f1639g;
        w(-1);
        throw new gg_e.d();
    }

    public final void m(lasm.b bVar) throws gg_e.d {
        w(72);
        gg_e.f fVarW = w(61);
        w(74);
        bVar.d(fVarW, k());
        w(73);
        w(74);
    }

    public final luaj.LuaValue n() throws gg_e.d {
        int iA = this.f1638f;
        if (iA == -1) {
            iA = A();
        }
        if (iA == 50) {
            w(50);
            w(88);
            w(79);
            lasm.LasmBase$Const lasmBase$Const = new lasm.LasmBase$Const(this.f1636d);
            w(89);
            return lasmBase$Const;
        }
        if (iA != 84) {
            switch (iA) {
                case 56:
                    w(56);
                    return luaj.LuaValue.f1673c;
                case 57:
                    w(57);
                    return luaj.LuaValue.f1674d;
                case 58:
                    w(58);
                    return luaj.LuaValue.f1675e;
                default:
                    switch (iA) {
                        case 79:
                            w(79);
                            return luaj.LuaLong.I2(lasm.LasmBase.h(this.f1636d));
                        case 80:
                            w(80);
                            break;
                        case 81:
                            w(81);
                            return lasm.LasmBase.j(this.f1636d);
                        default:
                            this.h[5] = this.f1639g;
                            w(-1);
                            throw new gg_e.d();
                    }
                    break;
            }
        } else {
            w(84);
        }
        return lasm.LasmBase.i(this.f1636d);
    }

    /* JADX WARN: Code duplicated, block: B:224:0x0468  */
    /* JADX WARN: Code duplicated, block: B:229:0x0486 A[LOOP:1: B:222:0x0461->B:229:0x0486, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:272:0x0470 A[SYNTHETIC] */
    public final void o(lasm.b bVar) throws gg_e.d {
        gg_e.f fVarW;
        gg_e.f fVarW2;
        luaj.LuaValue luaValue;
        luaj.LuaValue luaValue2;
        luaj.LuaValue luaValue3;
        gg_e.f fVar;
        luaj.LuaValue luaValue4;
        luaj.LuaValue luaValue5;
        luaj.LuaValue luaValue6;
        int iA;
        int i;
        lasm.LasmBase$V lasmBase$VP;
        gg_e.f fVarW3;
        gg_e.f fVarW4;
        lasm.LasmBase$V lasmBase$V;
        luaj.LuaValue luaValue7;
        luaj.LuaValue luaValueS;
        luaj.LuaValue luaValueP;
        luaj.LuaValue luaValueS2;
        int i2;
        int i3;
        luaj.LuaValue luaValueQ;
        luaj.LuaValue luaValueQ2;
        luaj.LuaValue luaValueQ3;
        luaj.LuaValue luaValue8;
        luaj.LuaValue luaValue9;
        luaj.LuaValue luaValue10;
        luaj.LuaValue luaValue11;
        luaj.LuaValue luaValue12;
        lasm.LasmBase$V lasmBase$V2;
        gg_e.f fVarW5;
        int i4;
        lasm.LasmBase$V lasmBase$VP2;
        luaj.LuaValue luaValueP2;
        lasm.LasmBase$V lasmBase$VP3;
        lasm.LasmBase$V lasmBase$V3;
        int i5;
        lasm.LasmBase$V lasmBase$V4;
        lasm.LasmBase$V lasmBase$V5;
        lasm.LasmBase$V lasmBase$VP4;
        lasm.LasmBase$V lasmBase$VP5;
        while (true) {
            int iA2 = this.f1638f;
            if (iA2 == -1) {
                iA2 = A();
            }
            if (iA2 == 69 || iA2 == 70 || iA2 == 76) {
                int iA3 = this.f1638f;
                if (iA3 == -1) {
                    iA3 = A();
                }
                if (iA3 == 69) {
                    w(69);
                    w(79);
                    bVar.f(this.f1636d);
                    while (true) {
                        w(74);
                        int iA4 = this.f1638f;
                        if (iA4 == -1) {
                            iA4 = A();
                        }
                        if (iA4 != 71) {
                            break;
                        }
                        w(71);
                        lasm.LasmBase$V lasmBase$VP6 = p();
                        w(81);
                        bVar.l(lasmBase$VP6, this.f1636d, 0);
                    }
                    this.h[13] = this.f1639g;
                } else if (iA3 == 70) {
                    w(70);
                    lasm.LasmBase$V lasmBase$VP7 = p();
                    w(81);
                    bVar.q(lasmBase$VP7, this.f1636d);
                    while (true) {
                        w(74);
                        int iA5 = this.f1638f;
                        if (iA5 == -1) {
                            iA5 = A();
                        }
                        if (iA5 != 71) {
                            break;
                        }
                        w(71);
                        lasm.LasmBase$V lasmBase$VP8 = p();
                        w(81);
                        bVar.l(lasmBase$VP8, this.f1636d, 0);
                    }
                    this.h[12] = this.f1639g;
                } else {
                    if (iA3 != 76) {
                        this.h[14] = this.f1639g;
                        w(-1);
                        throw new gg_e.d();
                    }
                    w(76);
                    bVar.e(this.f1636d);
                    while (true) {
                        w(74);
                        int iA6 = this.f1638f;
                        if (iA6 == -1) {
                            iA6 = A();
                        }
                        if (iA6 != 71) {
                            break;
                        }
                        w(71);
                        lasm.LasmBase$V lasmBase$VP9 = p();
                        w(81);
                        bVar.l(lasmBase$VP9, this.f1636d, 0);
                    }
                    this.h[11] = this.f1639g;
                }
            } else {
                this.h[10] = this.f1639g;
                int iA7 = this.f1638f;
                if (iA7 == -1) {
                    iA7 = A();
                }
                if (iA7 != 53) {
                    switch (iA7) {
                        case 5:
                        case 23:
                        case 24:
                        case 25:
                        case 44:
                            int iA8 = this.f1638f;
                            if (iA8 == -1) {
                                iA8 = A();
                            }
                            if (iA8 == 5) {
                                i = 5;
                            } else if (iA8 != 44) {
                                switch (iA8) {
                                    case 23:
                                        i = 23;
                                        break;
                                    case 24:
                                        i = 24;
                                        break;
                                    case 25:
                                        i = 25;
                                        break;
                                    default:
                                        this.h[20] = this.f1639g;
                                        w(-1);
                                        throw new gg_e.d();
                                }
                            } else {
                                i = 44;
                            }
                            w(i);
                            fVarW = this.f1636d;
                            lasmBase$VP3 = p();
                            luaValueP2 = p();
                            lasmBase$V = lasmBase$VP3;
                            luaValue7 = luaValueP2;
                            luaValue12 = null;
                            luaValue11 = luaValue7;
                            luaValue10 = lasmBase$V;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 6:
                            fVarW = w(6);
                            lasmBase$VP3 = p();
                            luaValueP2 = n();
                            lasmBase$V = lasmBase$VP3;
                            luaValue7 = luaValueP2;
                            luaValue12 = null;
                            luaValue11 = luaValue7;
                            luaValue10 = lasmBase$V;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 7:
                            fVarW = w(7);
                            lasmBase$VP = p();
                            fVarW3 = w(79);
                            int iA9 = this.f1638f;
                            if (iA9 == -1) {
                                iA9 = A();
                            }
                            if (iA9 != 55) {
                                this.h[15] = this.f1639g;
                                luaValueQ = lasmBase$VP;
                                fVarW2 = fVarW3;
                                luaValueQ2 = null;
                                luaValue2 = null;
                                luaValue = luaValueQ2;
                                luaValue3 = luaValueQ;
                                break;
                            } else {
                                fVarW4 = w(55);
                                luaValue4 = lasmBase$VP;
                                fVarW2 = fVarW3;
                                fVar = fVarW4;
                                luaValue6 = null;
                                luaValue5 = null;
                                while (true) {
                                    w(74);
                                    iA = this.f1638f;
                                    if (iA == -1) {
                                        iA = A();
                                    }
                                    if (iA != 71) {
                                        this.h[33] = this.f1639g;
                                        bVar.h(fVarW, luaValue4, luaValue6, luaValue5, fVarW2, fVar);
                                        return;
                                    } else {
                                        w(71);
                                        lasm.LasmBase$V lasmBase$VP10 = p();
                                        w(81);
                                        bVar.l(lasmBase$VP10, this.f1636d, 1);
                                    }
                                }
                            }
                        case 8:
                        case 38:
                            int iA10 = this.f1638f;
                            if (iA10 == -1) {
                                iA10 = A();
                            }
                            if (iA10 == 8) {
                                w(8);
                            } else {
                                if (iA10 != 38) {
                                    this.h[16] = this.f1639g;
                                    w(-1);
                                    throw new gg_e.d();
                                }
                                w(38);
                            }
                            fVarW = this.f1636d;
                            lasm.LasmBase$V lasmBase$VP11 = p();
                            w(75);
                            lasm.LasmBase$V lasmBase$VP12 = p();
                            lasm.LasmBase.a(lasmBase$VP11, lasmBase$VP12, fVarW.f1546a == 38 ? 2 : 0);
                            lasmBase$V = lasmBase$VP11;
                            luaValue7 = lasmBase$VP12;
                            luaValue12 = null;
                            luaValue11 = luaValue7;
                            luaValue10 = lasmBase$V;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 9:
                            fVarW = w(9);
                            lasmBase$VP3 = p();
                            luaValueP2 = s();
                            lasmBase$V = lasmBase$VP3;
                            luaValue7 = luaValueP2;
                            luaValue12 = null;
                            luaValue11 = luaValue7;
                            luaValue10 = lasmBase$V;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 10:
                            fVarW = w(10);
                            luaValueP = p();
                            luaValueS = s();
                            luaValue9 = luaValueP;
                            luaValue8 = luaValueS;
                            luaValueQ3 = q();
                            luaValue10 = luaValue9;
                            luaValue11 = luaValue8;
                            luaValue12 = luaValueQ3;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 11:
                        case 16:
                            int iA11 = this.f1638f;
                            if (iA11 == -1) {
                                iA11 = A();
                            }
                            if (iA11 == 11) {
                                w(11);
                            } else {
                                if (iA11 != 16) {
                                    this.h[17] = this.f1639g;
                                    w(-1);
                                    throw new gg_e.d();
                                }
                                w(16);
                            }
                            fVarW = this.f1636d;
                            luaValueP = p();
                            luaValueS = p();
                            luaValue9 = luaValueP;
                            luaValue8 = luaValueS;
                            luaValueQ3 = q();
                            luaValue10 = luaValue9;
                            luaValue11 = luaValue8;
                            luaValue12 = luaValueQ3;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 12:
                            fVarW = w(12);
                            luaValueS2 = s();
                            luaValueP = luaValueS2;
                            luaValueS = q();
                            luaValue9 = luaValueP;
                            luaValue8 = luaValueS;
                            luaValueQ3 = q();
                            luaValue10 = luaValue9;
                            luaValue11 = luaValue8;
                            luaValue12 = luaValueQ3;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 13:
                            fVarW = w(13);
                            lasmBase$VP3 = p();
                            luaValueP2 = s();
                            lasmBase$V = lasmBase$VP3;
                            luaValue7 = luaValueP2;
                            luaValue12 = null;
                            luaValue11 = luaValue7;
                            luaValue10 = lasmBase$V;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 14:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 43:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            int iA12 = this.f1638f;
                            if (iA12 == -1) {
                                iA12 = A();
                            }
                            if (iA12 != 14) {
                                if (iA12 != 43) {
                                    switch (iA12) {
                                        case 17:
                                            i2 = 17;
                                            break;
                                        case 18:
                                            i2 = 18;
                                            break;
                                        case 19:
                                            i2 = 19;
                                            break;
                                        case 20:
                                            i2 = 20;
                                            break;
                                        case 21:
                                            i2 = 21;
                                            break;
                                        case 22:
                                            i2 = 22;
                                            break;
                                        default:
                                            switch (iA12) {
                                                case 45:
                                                    i2 = 45;
                                                    break;
                                                case 46:
                                                    i2 = 46;
                                                    break;
                                                case 47:
                                                    i2 = 47;
                                                    break;
                                                case 48:
                                                    i2 = 48;
                                                    break;
                                                case 49:
                                                    i2 = 49;
                                                    break;
                                                default:
                                                    this.h[19] = this.f1639g;
                                                    w(-1);
                                                    throw new gg_e.d();
                                            }
                                            break;
                                    }
                                } else {
                                    i2 = 43;
                                }
                                w(i2);
                            } else {
                                w(14);
                            }
                            fVarW = this.f1636d;
                            luaValueS2 = p();
                            luaValueP = luaValueS2;
                            luaValueS = q();
                            luaValue9 = luaValueP;
                            luaValue8 = luaValueS;
                            luaValueQ3 = q();
                            luaValue10 = luaValue9;
                            luaValue11 = luaValue8;
                            luaValue12 = luaValueQ3;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 15:
                            fVarW = w(15);
                            lasmBase$VP = p();
                            fVarW3 = w(79);
                            fVarW4 = w(79);
                            luaValue4 = lasmBase$VP;
                            fVarW2 = fVarW3;
                            fVar = fVarW4;
                            luaValue6 = null;
                            luaValue5 = null;
                            while (true) {
                                w(74);
                                iA = this.f1638f;
                                if (iA == -1) {
                                    iA = A();
                                }
                                if (iA != 71) {
                                    this.h[33] = this.f1639g;
                                    bVar.h(fVarW, luaValue4, luaValue6, luaValue5, fVarW2, fVar);
                                    return;
                                } else {
                                    w(71);
                                    lasm.LasmBase$V lasmBase$VP13 = p();
                                    w(81);
                                    bVar.l(lasmBase$VP13, this.f1636d, 1);
                                }
                            }
                        case 26:
                            fVarW = w(26);
                            lasm.LasmBase$V lasmBase$VP14 = p();
                            lasm.LasmBase$V lasmBase$VP15 = p();
                            w(75);
                            lasm.LasmBase$V lasmBase$VP16 = p();
                            lasm.LasmBase.a(lasmBase$VP15, lasmBase$VP16, 0);
                            luaValue9 = lasmBase$VP14;
                            luaValue8 = lasmBase$VP15;
                            luaValueQ3 = lasmBase$VP16;
                            luaValue10 = luaValue9;
                            luaValue11 = luaValue8;
                            luaValue12 = luaValueQ3;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 27:
                            fVarW = w(27);
                            int iA13 = this.f1638f;
                            if (iA13 == -1) {
                                iA13 = A();
                            }
                            if (iA13 == 59 || iA13 == 77) {
                                lasmBase$VP = p();
                            } else {
                                this.h[21] = this.f1639g;
                                lasmBase$VP = null;
                            }
                            fVarW3 = l();
                            luaValueQ = lasmBase$VP;
                            fVarW2 = fVarW3;
                            luaValueQ2 = null;
                            luaValue2 = null;
                            luaValue = luaValueQ2;
                            luaValue3 = luaValueQ;
                            break;
                        case 28:
                        case 29:
                        case 30:
                            int iA14 = this.f1638f;
                            if (iA14 == -1) {
                                iA14 = A();
                            }
                            switch (iA14) {
                                case 28:
                                    i3 = 28;
                                    break;
                                case 29:
                                    i3 = 29;
                                    break;
                                case 30:
                                    i3 = 30;
                                    break;
                                default:
                                    this.h[23] = this.f1639g;
                                    w(-1);
                                    throw new gg_e.d();
                            }
                            w(i3);
                            fVarW = this.f1636d;
                            fVarW2 = w(79);
                            luaValueQ = q();
                            luaValueQ2 = q();
                            luaValue2 = null;
                            luaValue = luaValueQ2;
                            luaValue3 = luaValueQ;
                            break;
                        case 31:
                            fVarW = w(31);
                            lasmBase$VP = p();
                            fVarW3 = w(79);
                            luaValueQ = lasmBase$VP;
                            fVarW2 = fVarW3;
                            luaValueQ2 = null;
                            luaValue2 = null;
                            luaValue = luaValueQ2;
                            luaValue3 = luaValueQ;
                            break;
                        case 32:
                            fVarW = w(32);
                            lasmBase$VP5 = p();
                            lasmBase$VP4 = p();
                            fVarW5 = w(79);
                            lasmBase$V5 = lasmBase$VP5;
                            lasmBase$V4 = lasmBase$VP4;
                            luaValueQ = lasmBase$V5;
                            luaValueQ2 = lasmBase$V4;
                            fVarW2 = fVarW5;
                            luaValue2 = null;
                            luaValue = luaValueQ2;
                            luaValue3 = luaValueQ;
                            break;
                        case 33:
                            fVarW = w(33);
                            lasm.LasmBase$V lasmBase$VP17 = p();
                            int iA15 = this.f1638f;
                            if (iA15 == -1) {
                                iA15 = A();
                            }
                            if (iA15 != 75) {
                                this.h[24] = this.f1639g;
                                lasmBase$V2 = null;
                            } else {
                                w(75);
                                lasm.LasmBase$V lasmBase$VP18 = p();
                                lasm.LasmBase.a(lasmBase$VP17, lasmBase$VP18, 0);
                                lasmBase$V2 = lasmBase$VP18;
                            }
                            int iA16 = this.f1638f;
                            if (iA16 == -1) {
                                iA16 = A();
                            }
                            if (iA16 == 54 || iA16 == 59 || iA16 == 77) {
                                int iA17 = this.f1638f;
                                if (iA17 == -1) {
                                    iA17 = A();
                                }
                                if (iA17 == 54) {
                                    fVarW5 = w(54);
                                    lasmBase$V5 = lasmBase$VP17;
                                    lasmBase$V4 = lasmBase$V2;
                                    luaValueQ = lasmBase$V5;
                                    luaValueQ2 = lasmBase$V4;
                                    fVarW2 = fVarW5;
                                    luaValue2 = null;
                                    luaValue = luaValueQ2;
                                    luaValue3 = luaValueQ;
                                } else {
                                    if (iA17 != 59 && iA17 != 77) {
                                        this.h[25] = this.f1639g;
                                        w(-1);
                                        throw new gg_e.d();
                                    }
                                    lasm.LasmBase.b(lasmBase$VP17, p());
                                    w(75);
                                    lasm.LasmBase$V lasmBase$VP19 = p();
                                    lasm.LasmBase.a(lasmBase$VP17, lasmBase$VP19, 0);
                                    luaValue9 = lasmBase$VP17;
                                    luaValue8 = lasmBase$V2;
                                    luaValueQ3 = lasmBase$VP19;
                                    luaValue10 = luaValue9;
                                    luaValue11 = luaValue8;
                                    luaValue12 = luaValueQ3;
                                    fVarW2 = null;
                                    luaValue = luaValue11;
                                    luaValue2 = luaValue12;
                                    luaValue3 = luaValue10;
                                }
                            } else {
                                this.h[26] = this.f1639g;
                                lasmBase$VP3 = lasmBase$VP17;
                                luaValueP2 = lasmBase$V2;
                                lasmBase$V = lasmBase$VP3;
                                luaValue7 = luaValueP2;
                                luaValue12 = null;
                                luaValue11 = luaValue7;
                                luaValue10 = lasmBase$V;
                                fVarW2 = null;
                                luaValue = luaValue11;
                                luaValue2 = luaValue12;
                                luaValue3 = luaValue10;
                            }
                            break;
                        case 34:
                        case 42:
                            int iA18 = this.f1638f;
                            if (iA18 == -1) {
                                iA18 = A();
                            }
                            if (iA18 == 34) {
                                i4 = 34;
                            } else {
                                if (iA18 != 42) {
                                    this.h[27] = this.f1639g;
                                    w(-1);
                                    throw new gg_e.d();
                                }
                                i4 = 42;
                            }
                            w(i4);
                            fVarW = this.f1636d;
                            lasmBase$VP2 = p();
                            int iA19 = this.f1638f;
                            if (iA19 == -1) {
                                iA19 = A();
                            }
                            if (iA19 != 75) {
                                this.h[28] = this.f1639g;
                                lasmBase$V3 = lasmBase$VP2;
                                lasmBase$V = lasmBase$V3;
                                luaValue7 = null;
                                luaValue12 = null;
                                luaValue11 = luaValue7;
                                luaValue10 = lasmBase$V;
                                fVarW2 = null;
                                luaValue = luaValue11;
                                luaValue2 = luaValue12;
                                luaValue3 = luaValue10;
                            }
                            w(75);
                            lasm.LasmBase$V lasmBase$VP20 = p();
                            lasm.LasmBase.a(lasmBase$VP2, lasmBase$VP20, 0);
                            lasmBase$VP3 = lasmBase$VP2;
                            luaValueP2 = lasmBase$VP20;
                            lasmBase$V = lasmBase$VP3;
                            luaValue7 = luaValueP2;
                            luaValue12 = null;
                            luaValue11 = luaValue7;
                            luaValue10 = lasmBase$V;
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 35:
                            fVarW = w(35);
                            int iA20 = this.f1638f;
                            if (iA20 == -1) {
                                iA20 = A();
                            }
                            if (iA20 == 59 || iA20 == 77) {
                                lasmBase$VP2 = p();
                                int iA21 = this.f1638f;
                                if (iA21 == -1) {
                                    iA21 = A();
                                }
                                if (iA21 != 75) {
                                    this.h[29] = this.f1639g;
                                    lasmBase$V3 = lasmBase$VP2;
                                    lasmBase$V = lasmBase$V3;
                                    luaValue7 = null;
                                    luaValue12 = null;
                                    luaValue11 = luaValue7;
                                    luaValue10 = lasmBase$V;
                                }
                                w(75);
                                lasm.LasmBase$V lasmBase$VP21 = p();
                                lasm.LasmBase.a(lasmBase$VP2, lasmBase$VP21, 0);
                                lasmBase$VP3 = lasmBase$VP2;
                                luaValueP2 = lasmBase$VP21;
                                lasmBase$V = lasmBase$VP3;
                                luaValue7 = luaValueP2;
                                luaValue12 = null;
                                luaValue11 = luaValue7;
                                luaValue10 = lasmBase$V;
                            } else {
                                this.h[30] = this.f1639g;
                                luaValue11 = null;
                                luaValue12 = null;
                                luaValue10 = null;
                            }
                            fVarW2 = null;
                            luaValue = luaValue11;
                            luaValue2 = luaValue12;
                            luaValue3 = luaValue10;
                            break;
                        case 36:
                        case 37:
                        case 39:
                            int iA22 = this.f1638f;
                            if (iA22 == -1) {
                                iA22 = A();
                            }
                            if (iA22 == 36) {
                                i5 = 36;
                            } else if (iA22 == 37) {
                                i5 = 37;
                            } else {
                                if (iA22 != 39) {
                                    this.h[22] = this.f1639g;
                                    w(-1);
                                    throw new gg_e.d();
                                }
                                i5 = 39;
                            }
                            w(i5);
                            fVarW = this.f1636d;
                            lasmBase$VP = p();
                            fVarW3 = l();
                            luaValueQ = lasmBase$VP;
                            fVarW2 = fVarW3;
                            luaValueQ2 = null;
                            luaValue2 = null;
                            luaValue = luaValueQ2;
                            luaValue3 = luaValueQ;
                            break;
                        case 40:
                            fVarW = w(40);
                            lasm.LasmBase$V lasmBase$VP22 = p();
                            int iA23 = this.f1638f;
                            if (iA23 == -1) {
                                iA23 = A();
                            }
                            if (iA23 != 75) {
                                this.h[18] = this.f1639g;
                                lasmBase$VP4 = null;
                                lasmBase$VP5 = lasmBase$VP22;
                            } else {
                                w(75);
                                lasm.LasmBase$V lasmBase$VP23 = p();
                                lasm.LasmBase.a(lasmBase$VP22, lasmBase$VP23, 1);
                                lasmBase$VP5 = lasmBase$VP22;
                                lasmBase$VP4 = lasmBase$VP23;
                            }
                            fVarW5 = w(79);
                            lasmBase$V5 = lasmBase$VP5;
                            lasmBase$V4 = lasmBase$VP4;
                            luaValueQ = lasmBase$V5;
                            luaValueQ2 = lasmBase$V4;
                            fVarW2 = fVarW5;
                            luaValue2 = null;
                            luaValue = luaValueQ2;
                            luaValue3 = luaValueQ;
                            break;
                        case 41:
                            fVarW = w(41);
                            lasmBase$VP = p();
                            int iA24 = this.f1638f;
                            if (iA24 == -1) {
                                iA24 = A();
                            }
                            if (iA24 == 51) {
                                w(51);
                                fVarW3 = w(79);
                                w(89);
                            } else {
                                if (iA24 != 61) {
                                    this.h[31] = this.f1639g;
                                    w(-1);
                                    throw new gg_e.d();
                                }
                                fVarW3 = w(61);
                            }
                            luaValueQ = lasmBase$VP;
                            fVarW2 = fVarW3;
                            luaValueQ2 = null;
                            luaValue2 = null;
                            luaValue = luaValueQ2;
                            luaValue3 = luaValueQ;
                            break;
                        default:
                            this.h[32] = this.f1639g;
                            w(-1);
                            throw new gg_e.d();
                    }
                } else {
                    w(53);
                    w(88);
                    fVarW = w(79);
                    w(89);
                    fVarW2 = w(80);
                    luaValue = null;
                    luaValue2 = null;
                    luaValue3 = null;
                }
                fVar = null;
                luaValue6 = luaValue;
                luaValue5 = luaValue2;
                luaValue4 = luaValue3;
                while (true) {
                    w(74);
                    iA = this.f1638f;
                    if (iA == -1) {
                        iA = A();
                    }
                    if (iA != 71) {
                        this.h[33] = this.f1639g;
                        bVar.h(fVarW, luaValue4, luaValue6, luaValue5, fVarW2, fVar);
                        return;
                    } else {
                        w(71);
                        lasm.LasmBase$V lasmBase$VP110 = p();
                        w(81);
                        bVar.l(lasmBase$VP110, this.f1636d, 1);
                    }
                }
            }
        }
    }

    public final lasm.LasmBase$V p() throws gg_e.d {
        int iA = this.f1638f;
        if (iA == -1) {
            iA = A();
        }
        int i = 59;
        if (iA != 59) {
            i = 77;
            if (iA != 77) {
                this.h[7] = this.f1639g;
                w(-1);
                throw new gg_e.d();
            }
        }
        w(i);
        return new lasm.LasmBase$V(this.f1636d);
    }

    public final luaj.LuaValue q() throws gg_e.d {
        int iA = this.f1638f;
        if (iA == -1) {
            iA = A();
        }
        if (iA != 50) {
            if (iA != 77) {
                if (iA != 84) {
                    switch (iA) {
                        case 56:
                        case 57:
                        case 58:
                            break;
                        case 59:
                            break;
                        default:
                            switch (iA) {
                                case 79:
                                case 80:
                                case 81:
                                    break;
                                default:
                                    this.h[4] = this.f1639g;
                                    w(-1);
                                    throw new gg_e.d();
                            }
                            break;
                    }
                }
            }
            return p();
        }
        return n();
    }

    public final lasm.LasmBase$Internal r() throws gg_e.d {
        int iA = this.f1638f;
        if (iA == -1) {
            iA = A();
        }
        if (iA == 59 || iA == 77) {
            return p();
        }
        if (iA == 78) {
            return s();
        }
        this.h[6] = this.f1639g;
        w(-1);
        throw new gg_e.d();
    }

    public final lasm.LasmBase$U s() throws gg_e.d {
        w(78);
        return new lasm.LasmBase$U(this.f1636d);
    }

    public final void t(lasm.b bVar) throws gg_e.d {
        w(68);
        lasm.LasmBase$Internal lasmBase$InternalR = r();
        int iA = this.f1638f;
        if (iA == -1) {
            iA = A();
        }
        int i = 56;
        if (iA != 56) {
            i = 81;
            if (iA != 81) {
                this.h[9] = this.f1639g;
                w(-1);
                throw new gg_e.d();
            }
        }
        gg_e.f fVarW = w(i);
        w(74);
        bVar.i(lasmBase$InternalR, fVarW);
    }

    public final luaj.h u() throws gg_e.d {
        int iA = this.f1638f;
        if (iA == -1) {
            iA = A();
        }
        if (iA != 74) {
            this.h[0] = this.f1639g;
        } else {
            w(74);
        }
        lasm.b bVarK = k();
        w(0);
        return bVarK;
    }

    public gg_e.d v() {
        this.i.clear();
        boolean[] zArr = new boolean[90];
        int i = this.k;
        if (i >= 0) {
            zArr[i] = true;
            this.k = -1;
        }
        for (int i2 = 0; i2 < 34; i2++) {
            if (this.h[i2] == this.f1639g) {
                for (int i3 = 0; i3 < 32; i3++) {
                    int i4 = 1 << i3;
                    if ((l[i2] & i4) != 0) {
                        zArr[i3] = true;
                    }
                    if ((m[i2] & i4) != 0) {
                        zArr[i3 + 32] = true;
                    }
                    if ((n[i2] & i4) != 0) {
                        zArr[i3 + 64] = true;
                    }
                }
            }
        }
        for (int i5 = 0; i5 < 90; i5++) {
            if (zArr[i5]) {
                int[] iArr = {i5};
                this.j = iArr;
                this.i.add(iArr);
            }
        }
        int[][] iArr2 = new int[this.i.size()][];
        for (int i6 = 0; i6 < this.i.size(); i6++) {
            iArr2[i6] = (int[]) this.i.get(i6);
        }
        return new gg_e.d(this.f1636d, iArr2, gg_e.a.f1528a);
    }
}

package lasm;

/* JADX INFO: loaded from: classes.dex */
public class b extends luaj.h {
    lasm.b$a[] A;
    gg_g.f B;
    java.util.HashMap C;
    java.util.HashMap D;
    java.util.HashMap E;
    lasm.b$a[] w;
    lasm.b$a[] y;
    int p = 0;
    int q = 0;
    int r = 0;
    int s = 0;
    int t = 0;
    int u = 0;
    int v = 0;
    int x = 0;
    int z = 0;

    b() {
        this.f1723a = new luaj.LuaValue[8];
        this.f1724b = new int[8];
        this.f1725c = new luaj.h[8];
        this.f1726d = new int[8];
        this.f1727e = new gg_f.b[8];
        this.f1728f = new gg_f.d[8];
        this.w = new lasm.b$a[8];
        this.y = new lasm.b$a[8];
        this.C = new java.util.HashMap();
        this.D = new java.util.HashMap();
        this.E = new java.util.HashMap();
        this.B = new gg_g.f(this);
    }

    int c(luaj.LuaValue luaValue) {
        return luaValue instanceof lasm.LasmBase$Internal ? luaValue.C2() : luaj.b.l(m(luaValue));
    }

    void d(gg_e.f fVar, lasm.b bVar) {
        java.lang.String lowerCase = fVar.f1551f.toLowerCase(java.util.Locale.ENGLISH);
        lasm.b$a b_a = (lasm.b$a) this.E.get(lowerCase);
        if (b_a == null) {
            this.E.put(lowerCase, new lasm.b$a(fVar, this.s));
            luaj.h[] hVarArr = this.f1725c;
            int i = this.s;
            this.s = i + 1;
            this.f1725c = (luaj.h[]) gg_d.d.b(hVarArr, i, bVar);
            return;
        }
        throw new gg_e.b(fVar, "Duplicate function name '" + fVar.f1551f + "' (used at line " + b_a.f1640a.f1547b + ")");
    }

    void e(gg_e.f fVar) {
        java.lang.String lowerCase = fVar.f1551f.toLowerCase(java.util.Locale.ENGLISH);
        lasm.b$a b_a = (lasm.b$a) this.D.get(lowerCase);
        if (b_a == null) {
            this.D.put(lowerCase, new lasm.b$a(fVar, this.q));
            return;
        }
        throw new gg_e.b(fVar, "Try redefine label '" + fVar.f1551f + "' (already defined at line " + b_a.f1640a.f1547b + ")");
    }

    void f(gg_e.f fVar) {
        this.r = lasm.LasmBase.e(fVar);
    }

    public int g(int i) {
        if (this.r != 0) {
            int[] iArr = this.f1726d;
            int length = iArr.length;
            int i2 = this.q;
            if (length <= i2) {
                this.f1726d = java.util.Arrays.copyOf(iArr, gg_d.d.c(i2 + 1));
            }
            int[] iArr2 = this.f1726d;
            int i3 = this.q;
            iArr2[i3] = this.r;
            this.t = i3 + 1;
        }
        int[] iArr3 = this.f1724b;
        int i4 = this.q;
        this.q = i4 + 1;
        this.f1724b = gg_d.d.a(iArr3, i4, i);
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x019c  */
    /* JADX WARN: Code duplicated, block: B:103:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:105:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:109:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:111:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:113:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:115:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:117:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:126:0x0205  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:31:0x00af A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x000b, B:6:0x0016, B:7:0x0019, B:8:0x0034, B:11:0x0038, B:14:0x004c, B:15:0x0064, B:17:0x007e, B:24:0x0096, B:23:0x008b, B:28:0x00a5, B:32:0x00b9, B:31:0x00af, B:41:0x00de, B:40:0x00d3, B:35:0x00c2, B:45:0x00f1, B:49:0x00fe, B:48:0x00fa, B:55:0x0111, B:63:0x0132, B:65:0x0136, B:69:0x0144, B:68:0x013e, B:70:0x014d, B:106:0x01a6, B:118:0x01ce, B:119:0x01e2, B:123:0x01f0, B:124:0x01f5, B:127:0x0206, B:128:0x0214), top: B:135:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00fa A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x000b, B:6:0x0016, B:7:0x0019, B:8:0x0034, B:11:0x0038, B:14:0x004c, B:15:0x0064, B:17:0x007e, B:24:0x0096, B:23:0x008b, B:28:0x00a5, B:32:0x00b9, B:31:0x00af, B:41:0x00de, B:40:0x00d3, B:35:0x00c2, B:45:0x00f1, B:49:0x00fe, B:48:0x00fa, B:55:0x0111, B:63:0x0132, B:65:0x0136, B:69:0x0144, B:68:0x013e, B:70:0x014d, B:106:0x01a6, B:118:0x01ce, B:119:0x01e2, B:123:0x01f0, B:124:0x01f5, B:127:0x0206, B:128:0x0214), top: B:135:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:52:0x010b  */
    /* JADX WARN: Code duplicated, block: B:54:0x010f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0128  */
    /* JADX WARN: Code duplicated, block: B:60:0x012c  */
    /* JADX WARN: Code duplicated, block: B:62:0x0130  */
    /* JADX WARN: Code duplicated, block: B:65:0x0136 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x000b, B:6:0x0016, B:7:0x0019, B:8:0x0034, B:11:0x0038, B:14:0x004c, B:15:0x0064, B:17:0x007e, B:24:0x0096, B:23:0x008b, B:28:0x00a5, B:32:0x00b9, B:31:0x00af, B:41:0x00de, B:40:0x00d3, B:35:0x00c2, B:45:0x00f1, B:49:0x00fe, B:48:0x00fa, B:55:0x0111, B:63:0x0132, B:65:0x0136, B:69:0x0144, B:68:0x013e, B:70:0x014d, B:106:0x01a6, B:118:0x01ce, B:119:0x01e2, B:123:0x01f0, B:124:0x01f5, B:127:0x0206, B:128:0x0214), top: B:135:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:66:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x013d  */
    /* JADX WARN: Code duplicated, block: B:68:0x013e A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:3:0x000b, B:6:0x0016, B:7:0x0019, B:8:0x0034, B:11:0x0038, B:14:0x004c, B:15:0x0064, B:17:0x007e, B:24:0x0096, B:23:0x008b, B:28:0x00a5, B:32:0x00b9, B:31:0x00af, B:41:0x00de, B:40:0x00d3, B:35:0x00c2, B:45:0x00f1, B:49:0x00fe, B:48:0x00fa, B:55:0x0111, B:63:0x0132, B:65:0x0136, B:69:0x0144, B:68:0x013e, B:70:0x014d, B:106:0x01a6, B:118:0x01ce, B:119:0x01e2, B:123:0x01f0, B:124:0x01f5, B:127:0x0206, B:128:0x0214), top: B:135:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0165  */
    /* JADX WARN: Code duplicated, block: B:75:0x0168  */
    /* JADX WARN: Code duplicated, block: B:77:0x016c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0170  */
    /* JADX WARN: Code duplicated, block: B:81:0x0174  */
    /* JADX WARN: Code duplicated, block: B:83:0x0178  */
    /* JADX WARN: Code duplicated, block: B:85:0x017c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0180  */
    /* JADX WARN: Code duplicated, block: B:89:0x0184  */
    /* JADX WARN: Code duplicated, block: B:91:0x0188  */
    /* JADX WARN: Code duplicated, block: B:93:0x018c  */
    /* JADX WARN: Code duplicated, block: B:95:0x0190  */
    /* JADX WARN: Code duplicated, block: B:97:0x0194  */
    /* JADX WARN: Code duplicated, block: B:99:0x0198  */
    void h(gg_e.f fVar, luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3, gg_e.f fVar2, gg_e.f fVar3) {
        int iC2;
        k(luaValue);
        k(luaValue2);
        k(luaValue3);
        try {
            int i = fVar.f1546a;
            if (i == 79) {
                g(lasm.LasmBase.d(fVar2));
                return;
            }
            int iC3 = 1;
            int iC4 = 0;
            int i2 = -1;
            switch (i) {
                case 5:
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.B.T(i2, luaValue.C2(), luaValue2.C2(), 0);
                    return;
                case 6:
                    this.B.W(luaValue.C2(), m(luaValue2));
                    return;
                case 7:
                    gg_g.f fVar4 = this.B;
                    int iC5 = luaValue.C2();
                    int iE = lasm.LasmBase.e(fVar2);
                    if (fVar3 == null) {
                        iC3 = 0;
                    }
                    fVar4.T(3, iC5, iE, iC3);
                    return;
                case 8:
                    this.B.T(4, luaValue.C2(), luaValue2.C2() - luaValue.C2(), 0);
                    return;
                case 9:
                    i2 = 5;
                    if (i2 < 0) {
                        i2 = 9;
                    }
                    if (i2 < 0) {
                        i2 = 19;
                    }
                    if (i2 < 0) {
                        i2 = 20;
                    }
                    if (i2 < 0) {
                        i2 = 21;
                    }
                    if (i2 < 0) {
                        i2 = 41;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.B.T(i2, luaValue.C2(), luaValue2.C2(), 0);
                    return;
                case 10:
                    i2 = 6;
                    if (i2 < 0) {
                        i2 = 7;
                    }
                    if (i2 < 0) {
                        i2 = 12;
                    }
                    if (i2 < 0) {
                        i2 = 8;
                    }
                    if (i2 < 0) {
                        i2 = 13;
                    }
                    if (i2 < 0) {
                        i2 = 14;
                    }
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 11:
                    if (i2 < 0) {
                        i2 = 7;
                    }
                    if (i2 < 0) {
                        i2 = 12;
                    }
                    if (i2 < 0) {
                        i2 = 8;
                    }
                    if (i2 < 0) {
                        i2 = 13;
                    }
                    if (i2 < 0) {
                        i2 = 14;
                    }
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 12:
                    if (i2 < 0) {
                        i2 = 8;
                    }
                    if (i2 < 0) {
                        i2 = 13;
                    }
                    if (i2 < 0) {
                        i2 = 14;
                    }
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 13:
                    if (i2 < 0) {
                        i2 = 9;
                    }
                    if (i2 < 0) {
                        i2 = 19;
                    }
                    if (i2 < 0) {
                        i2 = 20;
                    }
                    if (i2 < 0) {
                        i2 = 21;
                    }
                    if (i2 < 0) {
                        i2 = 41;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.B.T(i2, luaValue.C2(), luaValue2.C2(), 0);
                    return;
                case 14:
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 15:
                    this.B.T(11, luaValue.C2(), lasm.LasmBase.e(fVar2), lasm.LasmBase.e(fVar3));
                    return;
                case 16:
                    if (i2 < 0) {
                        i2 = 12;
                    }
                    if (i2 < 0) {
                        i2 = 8;
                    }
                    if (i2 < 0) {
                        i2 = 13;
                    }
                    if (i2 < 0) {
                        i2 = 14;
                    }
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 17:
                    if (i2 < 0) {
                        i2 = 13;
                    }
                    if (i2 < 0) {
                        i2 = 14;
                    }
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 18:
                    if (i2 < 0) {
                        i2 = 14;
                    }
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 19:
                    if (i2 < 0) {
                        i2 = 15;
                    }
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 20:
                    if (i2 < 0) {
                        i2 = 16;
                    }
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 21:
                    if (i2 < 0) {
                        i2 = 17;
                    }
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 22:
                    if (i2 < 0) {
                        i2 = 18;
                    }
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 23:
                    if (i2 < 0) {
                        i2 = 19;
                    }
                    if (i2 < 0) {
                        i2 = 20;
                    }
                    if (i2 < 0) {
                        i2 = 21;
                    }
                    if (i2 < 0) {
                        i2 = 41;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.B.T(i2, luaValue.C2(), luaValue2.C2(), 0);
                    return;
                case 24:
                    if (i2 < 0) {
                        i2 = 20;
                    }
                    if (i2 < 0) {
                        i2 = 21;
                    }
                    if (i2 < 0) {
                        i2 = 41;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.B.T(i2, luaValue.C2(), luaValue2.C2(), 0);
                    return;
                case 25:
                    if (i2 < 0) {
                        i2 = 21;
                    }
                    if (i2 < 0) {
                        i2 = 41;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.B.T(i2, luaValue.C2(), luaValue2.C2(), 0);
                    return;
                case 26:
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 27:
                    i2 = 23;
                    if (i2 < 0) {
                        i2 = 32;
                    }
                    if (i2 < 0) {
                        i2 = 33;
                    }
                    if (i2 < 0) {
                        i2 = 35;
                    }
                    gg_g.f fVar5 = this.B;
                    if (i2 != 23) {
                        iC4 = luaValue.C2();
                    } else if (luaValue == null) {
                        iC4 = luaValue.C2() + 1;
                    }
                    fVar5.V(i2, iC4, n(fVar2));
                    return;
                case 28:
                    i2 = 24;
                    if (i2 < 0) {
                        i2 = 25;
                    }
                    if (i2 < 0) {
                        i2 = 26;
                    }
                    this.B.T(i2, lasm.LasmBase.e(fVar2), c(luaValue), c(luaValue2));
                    return;
                case 29:
                    if (i2 < 0) {
                        i2 = 25;
                    }
                    if (i2 < 0) {
                        i2 = 26;
                    }
                    this.B.T(i2, lasm.LasmBase.e(fVar2), c(luaValue), c(luaValue2));
                    return;
                case 30:
                    if (i2 < 0) {
                        i2 = 26;
                    }
                    this.B.T(i2, lasm.LasmBase.e(fVar2), c(luaValue), c(luaValue2));
                    return;
                case 31:
                    i2 = 27;
                    if (i2 < 0) {
                        i2 = 28;
                    }
                    gg_g.f fVar6 = this.B;
                    int iC6 = luaValue.C2();
                    if (luaValue2 == null) {
                        iC4 = luaValue2.C2();
                    }
                    fVar6.T(i2, iC6, iC4, lasm.LasmBase.e(fVar2));
                    return;
                case 32:
                    if (i2 < 0) {
                        i2 = 28;
                    }
                    gg_g.f fVar7 = this.B;
                    int iC7 = luaValue.C2();
                    if (luaValue2 == null) {
                        iC4 = luaValue2.C2();
                    }
                    fVar7.T(i2, iC7, iC4, lasm.LasmBase.e(fVar2));
                    return;
                case 33:
                    int iC8 = luaValue2 == null ? 0 : (luaValue2.C2() - luaValue.C2()) + 1;
                    if (fVar2 != null) {
                        iC3 = 0;
                    } else if (luaValue3 != null) {
                        iC3 = (luaValue3.C2() - luaValue.C2()) + 2;
                    }
                    this.B.T(29, luaValue.C2(), iC8, iC3);
                    return;
                case 34:
                    i2 = 30;
                    if (i2 < 0) {
                        i2 = 38;
                    }
                    gg_g.f fVar8 = this.B;
                    int iC9 = luaValue.C2();
                    if (luaValue2 == null) {
                        iC2 = 0;
                    } else {
                        iC2 = (luaValue2.C2() - luaValue.C2()) + 1;
                    }
                    fVar8.T(i2, iC9, iC2, 0);
                    return;
                case 35:
                    int iC10 = luaValue != null ? luaValue.C2() : 0;
                    if (luaValue != null) {
                        iC3 = luaValue2 == null ? 0 : (luaValue2.C2() - luaValue.C2()) + 2;
                    }
                    this.B.T(31, iC10, iC3, 0);
                    return;
                case 36:
                    if (i2 < 0) {
                        i2 = 32;
                    }
                    if (i2 < 0) {
                        i2 = 33;
                    }
                    if (i2 < 0) {
                        i2 = 35;
                    }
                    gg_g.f fVar9 = this.B;
                    if (i2 != 23) {
                        iC4 = luaValue.C2();
                    } else if (luaValue == null) {
                        iC4 = luaValue.C2() + 1;
                    }
                    fVar9.V(i2, iC4, n(fVar2));
                    return;
                case 37:
                    if (i2 < 0) {
                        i2 = 33;
                    }
                    if (i2 < 0) {
                        i2 = 35;
                    }
                    gg_g.f fVar10 = this.B;
                    if (i2 != 23) {
                        iC4 = luaValue.C2();
                    } else if (luaValue == null) {
                        iC4 = luaValue.C2() + 1;
                    }
                    fVar10.V(i2, iC4, n(fVar2));
                    return;
                case 38:
                    this.B.T(34, luaValue.C2(), 0, (luaValue2.C2() - luaValue.C2()) - 2);
                    return;
                case 39:
                    if (i2 < 0) {
                        i2 = 35;
                    }
                    gg_g.f fVar11 = this.B;
                    if (i2 != 23) {
                        iC4 = luaValue.C2();
                    } else if (luaValue == null) {
                        iC4 = luaValue.C2() + 1;
                    }
                    fVar11.V(i2, iC4, n(fVar2));
                    return;
                case 40:
                    if (luaValue2 == null) {
                        luaValue2 = luaValue;
                    }
                    this.B.o1(luaValue.C2(), luaValue2.C2() - luaValue.C2(), lasm.LasmBase.e(fVar2));
                    return;
                case 41:
                    this.B.U(37, luaValue.C2(), o(fVar2));
                    return;
                case 42:
                    if (i2 < 0) {
                        i2 = 38;
                    }
                    gg_g.f fVar12 = this.B;
                    int iC11 = luaValue.C2();
                    if (luaValue2 == null) {
                        iC2 = 0;
                    } else {
                        iC2 = (luaValue2.C2() - luaValue.C2()) + 1;
                    }
                    fVar12.T(i2, iC11, iC2, 0);
                    return;
                case 43:
                    if (i2 < 0) {
                        i2 = 40;
                    }
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 44:
                    if (i2 < 0) {
                        i2 = 41;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    this.B.T(i2, luaValue.C2(), luaValue2.C2(), 0);
                    return;
                case 45:
                    if (i2 < 0) {
                        i2 = 42;
                    }
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 46:
                    if (i2 < 0) {
                        i2 = 43;
                    }
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 47:
                    if (i2 < 0) {
                        i2 = 44;
                    }
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 48:
                    if (i2 < 0) {
                        i2 = 45;
                    }
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                case 49:
                    if (i2 < 0) {
                        i2 = 46;
                    }
                    if (i2 < 0) {
                        i2 = 10;
                    }
                    if (i2 < 0) {
                        i2 = 22;
                    }
                    this.B.T(i2, luaValue.C2(), c(luaValue2), c(luaValue3));
                    return;
                default:
                    throw new gg_e.b(fVar, "Unknow token for OP: '" + fVar.f1551f + "'");
            }
        } catch (java.lang.Throwable th) {
            if (th instanceof gg_e.b) {
                throw th;
            }
            throw new gg_e.b(fVar, "Failed assemble OP '" + fVar.f1551f + "'", th);
        }
    }

    void i(lasm.LasmBase$Internal lasmBase$Internal, gg_e.f fVar) {
        gg_f.d[] dVarArr = this.f1728f;
        int i = this.v;
        this.v = i + 1;
        this.f1728f = (gg_f.d[]) gg_d.d.b(dVarArr, i, new gg_f.d(lasm.LasmBase.j(fVar), lasmBase$Internal instanceof lasm.LasmBase$V, lasmBase$Internal.P));
    }

    lasm.b j() throws gg_e.b {
        luaj.LuaValue[] luaValueArr = this.f1723a;
        int length = luaValueArr.length;
        int i = this.p;
        if (length != i) {
            this.f1723a = (luaj.LuaValue[]) java.util.Arrays.copyOf(luaValueArr, i);
        }
        int[] iArr = this.f1724b;
        int length2 = iArr.length;
        int i2 = this.q;
        if (length2 != i2) {
            this.f1724b = java.util.Arrays.copyOf(iArr, i2);
        }
        luaj.h[] hVarArr = this.f1725c;
        int length3 = hVarArr.length;
        int i3 = this.s;
        if (length3 != i3) {
            this.f1725c = (luaj.h[]) java.util.Arrays.copyOf(hVarArr, i3);
        }
        int[] iArr2 = this.f1726d;
        int length4 = iArr2.length;
        int i4 = this.t;
        if (length4 != i4) {
            this.f1726d = java.util.Arrays.copyOf(iArr2, i4);
        }
        gg_f.b[] bVarArr = this.f1727e;
        int length5 = bVarArr.length;
        int i5 = this.u;
        if (length5 != i5) {
            this.f1727e = (gg_f.b[]) java.util.Arrays.copyOf(bVarArr, i5);
        }
        gg_f.d[] dVarArr = this.f1728f;
        int length6 = dVarArr.length;
        int i6 = this.v;
        if (length6 != i6) {
            this.f1728f = (gg_f.d[]) java.util.Arrays.copyOf(dVarArr, i6);
        }
        int i7 = this.x;
        for (int i8 = 0; i8 < i7; i8++) {
            lasm.b$a b_a = this.w[i8];
            lasm.b$a b_a2 = (lasm.b$a) this.D.get(b_a.f1640a.f1551f.toLowerCase(java.util.Locale.ENGLISH));
            if (b_a2 == null) {
                throw new gg_e.b(b_a.f1640a, "The label " + b_a.f1640a.f1551f + " is missing");
            }
            gg_g.a.A(new gg_g.d(this.f1724b, b_a.f1641b), (b_a2.f1641b - b_a.f1641b) - 1);
        }
        int i9 = this.z;
        for (int i10 = 0; i10 < i9; i10++) {
            lasm.b$a b_a3 = this.y[i10];
            lasm.b$a b_a4 = (lasm.b$a) this.E.get(b_a3.f1640a.f1551f.toLowerCase(java.util.Locale.ENGLISH));
            if (b_a4 == null) {
                throw new gg_e.b(b_a3.f1640a, "The function " + b_a3.f1640a.f1551f + " is missing");
            }
            gg_g.a.y(new gg_g.d(this.f1724b, b_a3.f1641b), b_a4.f1641b);
        }
        int length7 = this.A.length;
        for (int i11 = 0; i11 < length7; i11++) {
            lasm.b$a b_a5 = this.A[i11];
            if (b_a5 != null) {
                throw new gg_e.b(b_a5.f1640a, "No '.end local' for local variable v" + i11);
            }
        }
        this.w = null;
        this.y = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.B = null;
        this.A = null;
        return this;
    }

    void k(luaj.LuaValue luaValue) {
    }

    void l(lasm.LasmBase$V lasmBase$V, gg_e.f fVar, int i) {
        k(lasmBase$V);
        int iC2 = lasmBase$V.C2();
        lasm.b$a b_a = this.A[iC2];
        if (b_a == null) {
            throw new gg_e.b(lasmBase$V.Q, "Try end not defined local variable v" + iC2);
        }
        if (b_a.f1640a.f1551f.equals(fVar.f1551f)) {
            gg_f.b[] bVarArr = this.f1727e;
            lasm.b$a[] b_aArr = this.A;
            bVarArr[b_aArr[iC2].f1641b].f1560c = this.q + i;
            b_aArr[iC2] = null;
            return;
        }
        throw new gg_e.b(lasmBase$V.Q, "Try end local variable v" + iC2 + " with different name (v" + iC2 + " defined at line " + this.A[iC2].f1640a.f1547b + " as '" + this.A[iC2].f1640a.f1551f + "')");
    }

    int m(luaj.LuaValue luaValue) {
        if (luaValue instanceof lasm.LasmBase$Const) {
            return luaValue.C2();
        }
        java.lang.Integer numValueOf = (java.lang.Integer) this.C.get(luaValue);
        if (numValueOf == null) {
            numValueOf = java.lang.Integer.valueOf(this.p);
            this.C.put(luaValue, numValueOf);
            luaj.LuaValue[] luaValueArr = this.f1723a;
            int i = this.p;
            this.p = i + 1;
            this.f1723a = (luaj.LuaValue[]) gg_d.d.b(luaValueArr, i, luaValue);
        }
        return numValueOf.intValue();
    }

    int n(gg_e.f fVar) {
        int iE = fVar.f1546a == 60 ? lasm.LasmBase.e(fVar) : -1;
        if (fVar.f1546a == 60) {
            return iE;
        }
        lasm.b$a b_a = (lasm.b$a) this.D.get(fVar.f1551f.toLowerCase(java.util.Locale.ENGLISH));
        if (b_a != null) {
            return (b_a.f1641b - this.q) - 1;
        }
        lasm.b$a[] b_aArr = this.w;
        int i = this.x;
        this.x = i + 1;
        this.w = (lasm.b$a[]) gg_d.d.b(b_aArr, i, new lasm.b$a(fVar, this.q));
        return iE;
    }

    int o(gg_e.f fVar) {
        if (fVar.f1546a == 79) {
            return lasm.LasmBase.e(fVar);
        }
        lasm.b$a[] b_aArr = this.y;
        int i = this.z;
        this.z = i + 1;
        this.y = (lasm.b$a[]) gg_d.d.b(b_aArr, i, new lasm.b$a(fVar, this.q));
        return 262143;
    }

    void p(gg_e.f fVar) {
        int iMax = java.lang.Math.max(2, lasm.LasmBase.g(fVar, 255));
        this.l = iMax;
        if (iMax >= this.j) {
            this.A = new lasm.b$a[iMax];
            return;
        }
        throw new gg_e.b(fVar, ".maxstacksize (" + this.l + ") must be not less .numparams (" + this.j + ")");
    }

    void q(lasm.LasmBase$V lasmBase$V, gg_e.f fVar) {
        k(lasmBase$V);
        int iC2 = lasmBase$V.C2();
        lasm.b$a[] b_aArr = this.A;
        if (b_aArr[iC2] == null) {
            b_aArr[iC2] = new lasm.b$a(fVar, this.u);
            gg_f.b[] bVarArr = this.f1727e;
            int i = this.u;
            this.u = i + 1;
            luaj.LuaString luaStringJ = lasm.LasmBase.j(fVar);
            int i2 = this.q;
            this.f1727e = (gg_f.b[]) gg_d.d.b(bVarArr, i, new gg_f.b(luaStringJ, i2, i2 + 1));
            return;
        }
        throw new gg_e.b(lasmBase$V.Q, "Try redefine not ended local variable v" + iC2 + " (v" + iC2 + " defined at line " + this.A[iC2].f1640a.f1547b + " as '" + this.A[iC2].f1640a.f1551f + "')");
    }
}

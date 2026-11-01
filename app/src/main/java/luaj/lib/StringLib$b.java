package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class StringLib$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final luaj.LuaString f1779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final luaj.LuaString f1780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final luaj.Varargs f1781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1782e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f1783f = new int[32];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f1784g = new int[32];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1778a = 200;

    StringLib$b(luaj.Varargs varargs, luaj.LuaString luaString, luaj.LuaString luaString2) {
        this.f1779b = luaString;
        this.f1780c = luaString2;
        this.f1781d = varargs;
    }

    private void a(gg_f.a aVar, luaj.LuaString luaString, int i, int i2) {
        java.lang.String str;
        int iS1 = luaString.s1();
        int i3 = 0;
        while (i3 < iS1) {
            byte bG3 = (byte) luaString.g3(i3);
            if (bG3 != 37) {
                aVar.a(bG3);
            } else {
                int i4 = i3 + 1;
                byte bG4 = (byte) (i4 < iS1 ? luaString.g3(i4) : 0);
                char c2 = (char) bG4;
                if (java.lang.Character.isDigit(c2)) {
                    aVar.c(bG4 == 48 ? this.f1779b.j3(i, i2) : o(bG4 - 49, i, i2).q2());
                } else {
                    if (bG4 != 37) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("invalid use of '%' in replacement string: after '%' must be '0'-'9' or '%', but found ");
                        if (i4 < iS1) {
                            str = "symbol '" + c2 + "' with code " + ((int) bG4) + " at pos " + (i3 + 2);
                        } else {
                            str = "end of string";
                        }
                        sb.append(str);
                        luaj.LuaValue.R0(sb.toString());
                    }
                    aVar.a(bG4);
                }
                i3 = i4;
            }
            i3++;
        }
    }

    private int c() {
        for (int i = this.f1782e - 1; i >= 0; i--) {
            if (this.f1784g[i] == -1) {
                return i;
            }
        }
        luaj.LuaValue.R0("invalid pattern capture");
        return 0;
    }

    private int d(int i) {
        int i2 = i - 49;
        if (i2 < 0 || i2 >= this.f1782e || this.f1784g[i2] == -1) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("invalid capture index %");
            sb.append(i - 48);
            luaj.LuaValue.R0(sb.toString());
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x003f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0041  */
    static boolean i(int i, int i2) {
        boolean z;
        char lowerCase = java.lang.Character.toLowerCase((char) i2);
        byte b2 = luaj.lib.StringLib.U[i];
        if (lowerCase != 'a') {
            if (lowerCase != 'g') {
                if (lowerCase != 'l') {
                    if (lowerCase != 'p') {
                        if (lowerCase != 's') {
                            if (lowerCase != 'u') {
                                if (lowerCase != 'z') {
                                    if (lowerCase != 'c') {
                                        if (lowerCase != 'd') {
                                            if (lowerCase != 'w') {
                                                if (lowerCase != 'x') {
                                                    return i2 == i;
                                                }
                                                if ((b2 & (-128)) != 0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                            } else if ((b2 & 9) != 0) {
                                                z = true;
                                            } else {
                                                z = false;
                                            }
                                        } else if ((b2 & 8) != 0) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                    } else if ((b2 & 64) != 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                } else if (i == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                            } else if ((b2 & 4) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                        } else if ((b2 & 32) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                    } else if ((b2 & 16) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else if ((b2 & 2) != 0) {
                    z = true;
                } else {
                    z = false;
                }
            } else if ((b2 & 25) != 0) {
                z = true;
            } else {
                z = false;
            }
        } else if ((b2 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (lowerCase == i2) {
            return z;
        }
        return !z;
    }

    private luaj.LuaValue o(int i, int i2, int i3) {
        if (i >= this.f1782e) {
            if (i == 0) {
                return this.f1779b.j3(i2, i3);
            }
            return luaj.LuaValue.R0("invalid capture index %" + (i + 1));
        }
        int i4 = this.f1784g[i];
        if (i4 == -1) {
            return luaj.LuaValue.R0("unfinished capture");
        }
        if (i4 == -2) {
            return luaj.LuaValue.I2(this.f1783f[i] + 1);
        }
        int i5 = this.f1783f[i];
        return this.f1779b.j3(i5, i4 + i5);
    }

    public void b(gg_f.a aVar, int i, int i2, luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueU0;
        int iC2 = luaValue.C2();
        if (iC2 == 3 || iC2 == 4) {
            a(aVar, luaValue.q2(), i, i2);
            return;
        }
        if (iC2 == 5) {
            luaValueU0 = luaValue.U0(o(0, i, i2));
        } else {
            if (iC2 != 6) {
                luaj.LuaValue.R0("bad argument: string/function/table expected");
                return;
            }
            luaValueU0 = luaValue.invoke(n(true, i, i2)).w();
        }
        if (!luaValueU0.w2()) {
            luaValueU0 = this.f1779b.j3(i, i2);
        } else if (!luaValueU0.n1()) {
            luaj.LuaValue.R0("invalid replacement value (a " + luaValueU0.D2() + ')');
        }
        aVar.c(luaValueU0.q2());
    }

    int e(int i) {
        int i2 = i + 1;
        int iG3 = this.f1780c.g3(i);
        if (iG3 == 37) {
            if (i2 == this.f1780c.s1()) {
                luaj.LuaValue.R0("malformed pattern (ends with '%')");
            }
            return i + 2;
        }
        if (iG3 != 91) {
            return i2;
        }
        if (i2 != this.f1780c.s1() && this.f1780c.g3(i2) == 94) {
            i2 = i + 2;
        }
        while (true) {
            if (i2 == this.f1780c.s1()) {
                luaj.LuaValue.R0("malformed pattern (missing ']')");
            }
            int i3 = i2 + 1;
            i2 = (this.f1780c.g3(i2) != 37 || i3 >= this.f1780c.s1()) ? i3 : i2 + 2;
            if (i2 != this.f1780c.s1() && this.f1780c.g3(i2) == 93) {
                return i2 + 1;
            }
        }
    }

    int f(int i, int i2) {
        int iC = c();
        this.f1784g[iC] = i - this.f1783f[iC];
        int iG = g(i, i2);
        if (iG == -1) {
            this.f1784g[iC] = -1;
        }
        return iG;
    }

    /* JADX WARN: Code duplicated, block: B:113:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x014a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0124  */
    /* JADX WARN: Code duplicated, block: B:79:0x012d A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:6:0x000e, B:10:0x001c, B:71:0x010a, B:73:0x0116, B:77:0x0125, B:79:0x012d, B:90:0x0147, B:92:0x014c, B:97:0x0160, B:99:0x0168, B:100:0x016f, B:18:0x0036, B:21:0x003f, B:23:0x0049, B:25:0x0051, B:26:0x0059, B:27:0x005e, B:29:0x0068, B:30:0x006d, B:34:0x007b, B:36:0x0088, B:41:0x0096, B:42:0x009c, B:44:0x00a6, B:47:0x00b5, B:51:0x00c5, B:55:0x00d4, B:57:0x00dc, B:54:0x00ce, B:50:0x00bd, B:46:0x00b0, B:61:0x00e6, B:64:0x00ef, B:65:0x00f3, B:67:0x00fd), top: B:104:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0137  */
    /* JADX WARN: Code duplicated, block: B:84:0x013b  */
    /* JADX WARN: Code duplicated, block: B:86:0x013f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0147 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:6:0x000e, B:10:0x001c, B:71:0x010a, B:73:0x0116, B:77:0x0125, B:79:0x012d, B:90:0x0147, B:92:0x014c, B:97:0x0160, B:99:0x0168, B:100:0x016f, B:18:0x0036, B:21:0x003f, B:23:0x0049, B:25:0x0051, B:26:0x0059, B:27:0x005e, B:29:0x0068, B:30:0x006d, B:34:0x007b, B:36:0x0088, B:41:0x0096, B:42:0x009c, B:44:0x00a6, B:47:0x00b5, B:51:0x00c5, B:55:0x00d4, B:57:0x00dc, B:54:0x00ce, B:50:0x00bd, B:46:0x00b0, B:61:0x00e6, B:64:0x00ef, B:65:0x00f3, B:67:0x00fd), top: B:104:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0168 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:6:0x000e, B:10:0x001c, B:71:0x010a, B:73:0x0116, B:77:0x0125, B:79:0x012d, B:90:0x0147, B:92:0x014c, B:97:0x0160, B:99:0x0168, B:100:0x016f, B:18:0x0036, B:21:0x003f, B:23:0x0049, B:25:0x0051, B:26:0x0059, B:27:0x005e, B:29:0x0068, B:30:0x006d, B:34:0x007b, B:36:0x0088, B:41:0x0096, B:42:0x009c, B:44:0x00a6, B:47:0x00b5, B:51:0x00c5, B:55:0x00d4, B:57:0x00dc, B:54:0x00ce, B:50:0x00bd, B:46:0x00b0, B:61:0x00e6, B:64:0x00ef, B:65:0x00f3, B:67:0x00fd), top: B:104:0x000e }] */
    int g(int i, int i2) {
        int iE;
        boolean z;
        int iG;
        int i3 = this.f1778a;
        this.f1778a = i3 - 1;
        if (i3 == 0) {
            luaj.LuaValue.R0("pattern too complex");
        }
        while (i2 != this.f1780c.s1()) {
            try {
                int iG3 = this.f1780c.g3(i2);
                int iG4 = 0;
                int iL = -1;
                if (iG3 != 36) {
                    if (iG3 == 37) {
                        int i4 = i2 + 1;
                        if (i4 == this.f1780c.s1()) {
                            luaj.LuaValue.R0("malformed pattern (ends with '%')");
                        }
                        int iG5 = this.f1780c.g3(i4);
                        if (iG5 == 98) {
                            i = j(i, i2 + 2);
                            if (i != -1) {
                                i2 += 4;
                            }
                        } else if (iG5 != 102) {
                            int iG6 = this.f1780c.g3(i4);
                            if (java.lang.Character.isDigit((char) iG6)) {
                                int iH = h(i, iG6);
                                if (iH != -1) {
                                    i = g(iH, i2 + 2);
                                    break;
                                }
                            }
                        } else {
                            int i5 = i2 + 2;
                            if (i5 == this.f1780c.s1() || this.f1780c.g3(i5) != 91) {
                                luaj.LuaValue.R0("missing '[' after '%f' in pattern");
                            }
                            iE = e(i5);
                            int iG7 = i == 0 ? 0 : this.f1779b.g3(i - 1);
                            if (i != this.f1779b.s1()) {
                                iG4 = this.f1779b.g3(i);
                            }
                            int i6 = iE - 1;
                            if (!k(iG7, i5, i6)) {
                                if (!k(iG4, i5, i6)) {
                                }
                                i2 = iE;
                            }
                        }
                        this.f1778a++;
                        return iL;
                    }
                    if (iG3 == 40) {
                        int i7 = i2 + 1;
                        if (i7 < this.f1780c.s1() && this.f1780c.g3(i7) == 41) {
                            i = r(i, i2 + 2, -2);
                            break;
                        }
                        i = r(i, i7, -1);
                        break;
                    }
                    if (iG3 == 41) {
                        i = f(i, i2 + 1);
                        break;
                    }
                    iE = e(i2);
                    if (i < this.f1779b.s1() || !q(this.f1779b.g3(i), i2, iE)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    iG4 = iE < this.f1780c.s1() ? this.f1780c.g3(iE) : 0;
                    if (iG4 != 42) {
                        i = l(i, i2, iE);
                        break;
                    }
                    if (iG4 != 43) {
                        if (iG4 != 45) {
                            i = m(i, i2, iE);
                            break;
                        }
                        if (iG4 == 63) {
                            if (!z) {
                                i++;
                                i2 = iE;
                            }
                        } else {
                            if (!z && (iG = g(i + 1, iE + 1)) != -1) {
                                this.f1778a++;
                                return iG;
                            }
                            i2 = iE + 1;
                        }
                    } else if (z) {
                        iL = l(i + 1, i2, iE);
                    }
                    this.f1778a++;
                    return iL;
                }
                if (i2 + 1 != this.f1780c.s1()) {
                    iE = e(i2);
                    if (i < this.f1779b.s1()) {
                        z = false;
                    } else {
                        z = false;
                    }
                    if (iE < this.f1780c.s1()) {
                    }
                    if (iG4 != 42) {
                        i = l(i, i2, iE);
                        break;
                    }
                    if (iG4 != 43) {
                        if (iG4 != 45) {
                            i = m(i, i2, iE);
                            break;
                        }
                        if (iG4 == 63) {
                            if (!z) {
                            }
                            i2 = iE + 1;
                        } else if (!z) {
                            i++;
                            i2 = iE;
                        }
                    } else if (z) {
                        iL = l(i + 1, i2, iE);
                    }
                    this.f1778a++;
                    return iL;
                }
                if (i != this.f1779b.s1()) {
                    i = -1;
                    break;
                }
                break;
            } catch (java.lang.Throwable th_c_c_c) {
                this.f1778a++;
                throw th_c_c_c;
            }
        }
        this.f1778a++;
        return i;
    }

    int h(int i, int i2) {
        int iD = d(i2);
        int i3 = this.f1784g[iD];
        if (this.f1779b.s1() - i < i3) {
            return -1;
        }
        luaj.LuaString luaString = this.f1779b;
        if (luaj.LuaString.W2(luaString, this.f1783f[iD], luaString, i, i3)) {
            return i + i3;
        }
        return -1;
    }

    int j(int i, int i2) {
        int iG3;
        int iS1 = this.f1780c.s1();
        if (i2 == iS1 || i2 + 1 == iS1) {
            luaj.LuaValue.R0("malformed pattern (missing arguments to '%b')");
        }
        int iS2 = this.f1779b.s1();
        if (i >= iS2 || this.f1779b.g3(i) != (iG3 = this.f1780c.g3(i2))) {
            return -1;
        }
        int i3 = 1;
        int iG4 = this.f1780c.g3(i2 + 1);
        while (true) {
            int i4 = i + 1;
            if (i4 >= iS2) {
                return -1;
            }
            if (this.f1779b.g3(i4) == iG4) {
                i3--;
                if (i3 == 0) {
                    return i + 2;
                }
            } else if (this.f1779b.g3(i4) == iG3) {
                i3++;
            }
            i = i4;
        }
    }

    boolean k(int i, int i2, int i3) {
        boolean z;
        int i4;
        int i5 = i2 + 1;
        if (this.f1780c.g3(i5) == 94) {
            i2 = i5;
            z = false;
        } else {
            z = true;
        }
        while (true) {
            int i6 = i2 + 1;
            if (i6 >= i3) {
                return !z;
            }
            if (this.f1780c.g3(i6) == 37) {
                i2 += 2;
                if (i(i, this.f1780c.g3(i2))) {
                    return z;
                }
            } else if (this.f1780c.g3(i2 + 2) != 45 || (i4 = i2 + 3) >= i3) {
                if (this.f1780c.g3(i6) == i) {
                    return z;
                }
                i2 = i6;
            } else {
                if (this.f1780c.g3(i2 + 1) <= i && i <= this.f1780c.g3(i4)) {
                    return z;
                }
                i2 = i4;
            }
        }
    }

    int l(int i, int i2, int i3) {
        int i4 = 0;
        while (true) {
            int i5 = i + i4;
            if (i5 >= this.f1779b.s1() || !q(this.f1779b.g3(i5), i2, i3)) {
                break;
            }
            i4++;
        }
        while (i4 >= 0) {
            int iG = g(i + i4, i3 + 1);
            if (iG != -1) {
                return iG;
            }
            i4--;
        }
        return -1;
    }

    int m(int i, int i2, int i3) {
        while (true) {
            int iG = g(i, i3 + 1);
            if (iG != -1) {
                return iG;
            }
            if (i >= this.f1779b.s1() || !q(this.f1779b.g3(i), i2, i3)) {
                return -1;
            }
            i++;
        }
    }

    luaj.Varargs n(boolean z, int i, int i2) {
        int i3 = this.f1782e;
        if (i3 == 0 && z) {
            i3 = 1;
        }
        if (i3 == 0) {
            return luaj.LuaValue.f1676f;
        }
        if (i3 == 1) {
            return o(0, i, i2);
        }
        luaj.LuaValue[] luaValueArr = new luaj.LuaValue[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            luaValueArr[i4] = o(i4, i, i2);
        }
        return luaj.LuaValue.O2(luaValueArr);
    }

    void p() {
        this.f1782e = 0;
        this.f1778a = 200;
    }

    boolean q(int i, int i2, int i3) {
        int iG3 = this.f1780c.g3(i2);
        if (iG3 == 37) {
            return i(i, this.f1780c.g3(i2 + 1));
        }
        if (iG3 == 46) {
            return true;
        }
        if (iG3 != 91) {
            return this.f1780c.g3(i2) == i;
        }
        return k(i, i2, i3 - 1);
    }

    int r(int i, int i2, int i3) {
        int i4 = this.f1782e;
        if (i4 >= 32) {
            luaj.LuaValue.R0("too many captures");
        }
        this.f1783f[i4] = i;
        this.f1784g[i4] = i3;
        this.f1782e = i4 + 1;
        int iG = g(i, i2);
        if (iG == -1) {
            this.f1782e--;
        }
        return iG;
    }
}

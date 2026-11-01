package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class StringLib$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1777g;
    public final int h;
    public final int i;
    public final java.lang.String j;

    public StringLib$a(luaj.Varargs varargs, luaj.LuaString luaString, int i) {
        int iS1 = luaString.s1();
        int iG3 = 0;
        int i2 = i;
        boolean z = true;
        int iG4 = 0;
        while (z) {
            if (i2 < iS1) {
                iG4 = luaString.g3(i2);
                i2++;
            } else {
                iG4 = 0;
            }
            if (iG4 == 32) {
                this.f1774d = true;
            } else if (iG4 == 35) {
                this.f1775e = true;
            } else if (iG4 == 43) {
                this.f1773c = true;
            } else if (iG4 == 45) {
                this.f1771a = true;
            } else if (iG4 != 48) {
                z = false;
            } else {
                this.f1772b = true;
            }
        }
        if (i2 - i > 5) {
            luaj.LuaValue.R0("invalid format (repeated flags)");
        }
        this.f1776f = -1;
        if (java.lang.Character.isDigit((char) iG4)) {
            this.f1776f = iG4 - 48;
            if (i2 < iS1) {
                iG4 = luaString.g3(i2);
                i2++;
            } else {
                iG4 = 0;
            }
            if (java.lang.Character.isDigit((char) iG4)) {
                this.f1776f = (this.f1776f * 10) + (iG4 - 48);
                if (i2 < iS1) {
                    iG4 = luaString.g3(i2);
                    i2++;
                } else {
                    iG4 = 0;
                }
            }
        }
        this.f1777g = -1;
        if (iG4 == 46) {
            if (i2 < iS1) {
                iG4 = luaString.g3(i2);
                i2++;
            } else {
                iG4 = 0;
            }
            if (java.lang.Character.isDigit((char) iG4)) {
                this.f1777g = iG4 - 48;
                if (i2 < iS1) {
                    iG4 = luaString.g3(i2);
                    i2++;
                } else {
                    iG4 = 0;
                }
                if (java.lang.Character.isDigit((char) iG4)) {
                    this.f1777g = (this.f1777g * 10) + (iG4 - 48);
                    if (i2 < iS1) {
                        iG3 = luaString.g3(i2);
                        i2++;
                    }
                    iG4 = iG3;
                }
            }
        }
        if (java.lang.Character.isDigit((char) iG4)) {
            luaj.LuaValue.R0("invalid format (width or precision too long) at pos " + i2);
        }
        this.f1772b &= !this.f1771a;
        this.h = iG4;
        this.i = i2 - i;
        this.j = luaString.j3(i - 1, i2).g0();
    }

    public static final void e(gg_f.a aVar, char c2, int i) {
        byte b2 = (byte) c2;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return;
            }
            aVar.a(b2);
            i = i2;
        }
    }

    public void a(gg_f.a aVar, byte b2) {
        aVar.a(b2);
    }

    public void b(gg_f.a aVar, double d2) {
        java.lang.String strValueOf;
        if (java.lang.Double.isNaN(d2)) {
            strValueOf = "nan";
        } else if (java.lang.Double.isInfinite(d2)) {
            strValueOf = d2 < 0.0d ? "-inf" : "inf";
        } else {
            strValueOf = null;
        }
        if (strValueOf == null) {
            try {
                strValueOf = java.lang.String.format(java.util.Locale.US, this.j, java.lang.Double.valueOf(d2));
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed format double " + d2 + " with '" + this.j + '\'', th);
                strValueOf = java.lang.String.valueOf(d2);
            }
        } else if (this.h < 97) {
            strValueOf = strValueOf.toUpperCase(java.util.Locale.US);
        }
        aVar.b(strValueOf);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    public void c(gg_f.a aVar, long j) {
        java.lang.String hexString;
        int i;
        int i2;
        int i3;
        if (j == 0 && this.f1777g == 0) {
            hexString = "";
        } else {
            int i4 = this.h;
            if (i4 == 88) {
                hexString = java.lang.Long.toHexString(j);
            } else if (i4 != 111) {
                if (i4 != 117) {
                    if (i4 == 120) {
                        hexString = java.lang.Long.toHexString(j);
                    }
                } else if (j < 0) {
                    long j2 = (j >>> 1) / 5;
                    hexString = java.lang.Long.toString(j2) + (j - (10 * j2));
                }
                hexString = java.lang.Long.toString(j);
            } else {
                hexString = java.lang.Long.toOctalString(j);
            }
            if (this.h == 88) {
                hexString = hexString.toUpperCase(java.util.Locale.US);
            }
        }
        int length = hexString.length();
        if (j < 0) {
            i = length;
            length--;
        } else {
            i = (this.f1773c || this.f1774d) ? length + 1 : length;
        }
        int i5 = this.f1777g;
        if (i5 > length) {
            i2 = i5 - length;
        } else {
            i2 = (i5 == -1 && this.f1772b && (i3 = this.f1776f) > i) ? i3 - i : 0;
        }
        int i6 = i + i2;
        int i7 = this.f1776f;
        int i8 = i7 > i6 ? i7 - i6 : 0;
        if (!this.f1771a) {
            e(aVar, ' ', i8);
        }
        if (j < 0) {
            if (i2 > 0) {
                aVar.a((byte) 45);
                hexString = hexString.substring(1);
            }
        } else if (this.f1773c) {
            aVar.a((byte) 43);
        } else if (this.f1774d) {
            aVar.a((byte) 32);
        }
        if (i2 > 0) {
            e(aVar, '0', i2);
        }
        aVar.b(hexString);
        if (this.f1771a) {
            e(aVar, ' ', i8);
        }
    }

    public void d(gg_f.a aVar, luaj.LuaString luaString) {
        int iS1 = luaString.s1();
        int i = this.f1776f;
        int i2 = this.f1777g;
        if (i2 == -1) {
            i2 = iS1;
        }
        if (iS1 > i2) {
            iS1 = i2;
        }
        if (iS1 < i && !this.f1771a) {
            byte b2 = (byte) (this.f1772b ? 48 : 32);
            for (int i3 = i - iS1; i3 > 0; i3--) {
                aVar.a(b2);
            }
        }
        aVar.e(luaString.P, luaString.Q, iS1);
        if (iS1 >= i || !this.f1771a) {
            return;
        }
        byte b3 = (byte) (this.f1772b ? 48 : 32);
        for (int i4 = i - iS1; i4 > 0; i4--) {
            aVar.a(b3);
        }
    }
}

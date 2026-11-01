package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class OsLib extends luaj.lib.TwoArgFunction {
    private static final long U;
    private static long V;
    private luaj.Globals T;

    static {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        U = jCurrentTimeMillis;
        V = jCurrentTimeMillis;
    }

    private luaj.LuaValue f3(luaj.LuaValue luaValue, boolean z) {
        if (luaValue.l1()) {
            if (z) {
                throw new luaj.d("missing in date table");
            }
        } else if (!luaValue.i1()) {
            throw new luaj.d("is not an integer");
        }
        return luaValue;
    }

    double g3() {
        return ((java.lang.System.currentTimeMillis() - U) - ((long) this.T.b0)) / 1000.0d;
    }

    double i3(double d2, double d3) {
        return d2 - d3;
    }

    luaj.Varargs j3(java.lang.String str) {
        throw new luaj.d("Failed os.execute('" + str + "'): disabled by security reason");
    }

    void k3(int i) {
    }

    java.lang.String m3(java.lang.String str) {
        java.lang.String str2 = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            str2 = java.lang.System.getenv(str);
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("Failed getenv '" + str + "'", th);
        }
        if (str2 != null) {
            return str2;
        }
        try {
            return java.lang.System.getProperty(str);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.g("Failed getProperty '" + str + "'", th2);
            return str2;
        }
    }

    private static luaj.LuaValue n3(byte[] bArr, int i, int i2) {
        return luaj.LuaValue.l0(1, "os.date", "invalid conversion specifier '" + luaj.LuaValue.L2(bArr, i, i2 - i) + "' at offset " + i);
    }

    private java.util.Calendar o3(java.util.Calendar calendar) {
        int i = calendar.get(6);
        int i2 = ((calendar.get(7) + 5) % 7) + 1;
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setLenient(true);
        calendar2.set(1, calendar.get(1));
        calendar2.set(6, (i - i2) + 4);
        return calendar2;
    }

    private int p3(java.util.Calendar calendar) {
        return ((o3(calendar).get(6) - 1) / 7) + 1;
    }

    private int q3(java.util.Calendar calendar) {
        return o3(calendar).get(1);
    }

    java.lang.String t3(java.lang.String str, java.lang.String str2) {
        return "C";
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    long u3(luaj.LuaTable luaTable) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        if (luaTable == null) {
            calendar.add(14, -this.T.b0);
        } else {
            java.lang.String str = "year";
            try {
                calendar.set(1, f3(luaTable.T0("year"), true).A0());
                calendar.set(2, f3(luaTable.T0("month"), true).A0() - 1);
                calendar.set(5, f3(luaTable.T0("day"), true).A0());
                calendar.set(11, f3(luaTable.T0("hour"), false).H1(12));
                calendar.set(12, f3(luaTable.T0("min"), false).H1(0));
                str = "sec";
                calendar.set(13, f3(luaTable.T0("sec"), false).H1(0));
                calendar.set(14, 0);
                l3(luaTable, calendar);
            } catch (luaj.d e2) {
                throw new luaj.d("field '" + str + "' " + e2.getMessage(), e2);
            }
        }
        return calendar.getTimeInMillis() / 1000;
    }

    java.lang.String v3() {
        try {
            java.io.File fileCreateTempFile = java.io.File.createTempFile(".gg.", ".tmp");
            try {
                fileCreateTempFile.deleteOnExit();
                fileCreateTempFile.delete();
            } catch (java.lang.Throwable unused) {
            }
            return fileCreateTempFile.getAbsolutePath();
        } catch (java.io.IOException unused2) {
            synchronized (luaj.lib.OsLib.class) {
                try {
                    long j = V;
                    V = 1 + j;
                    return android.ext.Tools.b0() + "/" + (".gg." + j + ".tmp");
                } catch (java.lang.Throwable th_c_c_c) {
                    throw th_c_c_c;
                }
            }
        }
    }

    private int w3(java.util.Calendar calendar, boolean z) {
        int i = calendar.get(6);
        int i2 = calendar.get(7);
        if (z) {
            i2 = ((i2 + 5) % 7) + 1;
        }
        if (i <= i2) {
            return 0;
        }
        int i3 = (i - i2) % 7;
        int iCeil = (int) java.lang.Math.ceil((i - i3) / 7.0f);
        return i3 != 0 ? iCeil : iCeil - 1;
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        java.lang.String[] strArr = {"clock", "date", "difftime", "execute", "exit", "getenv", "remove", "rename", "setlocale", "time", "tmpname"};
        this.T = luaValue2.z0();
        luaj.LuaTable luaTable = new luaj.LuaTable();
        for (int i = 0; i < 11; i++) {
            if (this.T.X || (i != 3 && i != 4 && i != 6 && i != 7 && i != 10)) {
                java.lang.String str = strArr[i];
                luaTable.i2(str, new luaj.lib.OsLib$OsLibFunc(this, i, str));
            }
        }
        luaValue2.i2("os", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("os", luaTable);
        }
        return luaTable;
    }

    public java.lang.String h3(java.lang.String str, java.util.Calendar calendar) {
        java.lang.String strSubstring = null;
        int iW3;
        int iQ3;
        int i;
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        gg_f.a aVar = new gg_f.a(length);
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            byte b2 = bytes[i2];
            if (b2 == 10) {
                aVar.b("\n");
            } else if (b2 != 37) {
                aVar.a(b2);
            } else {
                if (i3 >= length) {
                    n3(bytes, i2, i3);
                }
                int i4 = i2 + 2;
                byte b3 = bytes[i3];
                if (b3 == 69 || b3 == 79) {
                    if (i4 >= length) {
                        n3(bytes, i2, i4);
                    }
                    java.lang.String str2 = b3 == 69 ? "cCxXyY" : "deHImMSuUVwwy";
                    int i5 = i2 + 3;
                    byte b4 = bytes[i4];
                    if (str2.indexOf((char) (b4 & 255)) == -1) {
                        n3(bytes, i2, i5);
                    }
                    b3 = b4;
                    i4 = i5;
                }
                if (b3 == 37) {
                    aVar.b("%");
                    b3 = 0;
                } else if (b3 != 77 && b3 != 112) {
                    if (b3 == 103) {
                        strSubstring = java.lang.String.valueOf(q3(calendar) + 10000).substring(3);
                    } else if (b3 != 104) {
                        switch (b3) {
                            case 65:
                            case 66:
                            case 68:
                                break;
                            case 67:
                                iW3 = calendar.get(1) / 100;
                                iQ3 = iW3 + 100;
                                strSubstring = java.lang.String.valueOf(iQ3).substring(1);
                                break;
                            default:
                                switch (b3) {
                                    case 70:
                                    case 72:
                                    case 73:
                                        break;
                                    case 71:
                                        iQ3 = q3(calendar) + 10000;
                                        strSubstring = java.lang.String.valueOf(iQ3).substring(1);
                                        break;
                                    default:
                                        switch (b3) {
                                            case 82:
                                            case 83:
                                            case 84:
                                            case 89:
                                            case 90:
                                                break;
                                            case 85:
                                                iW3 = w3(calendar, false);
                                                iQ3 = iW3 + 100;
                                                strSubstring = java.lang.String.valueOf(iQ3).substring(1);
                                                break;
                                            case 86:
                                                iW3 = p3(calendar);
                                                iQ3 = iW3 + 100;
                                                strSubstring = java.lang.String.valueOf(iQ3).substring(1);
                                                break;
                                            case 87:
                                                iW3 = w3(calendar, true);
                                                iQ3 = iW3 + 100;
                                                strSubstring = java.lang.String.valueOf(iQ3).substring(1);
                                                break;
                                            case 88:
                                                b3 = 84;
                                                break;
                                            default:
                                                switch (b3) {
                                                    case 97:
                                                    case 98:
                                                    case 100:
                                                        break;
                                                    case 99:
                                                        strSubstring = h3("%a %b %d %H:%M:%S %Y", calendar);
                                                        break;
                                                    case 101:
                                                        i = calendar.get(5);
                                                        if (i < 10) {
                                                            aVar.b(" ");
                                                        }
                                                        strSubstring = java.lang.String.valueOf(i);
                                                        break;
                                                    default:
                                                        switch (b3) {
                                                            case 106:
                                                            case 107:
                                                            case 108:
                                                            case 109:
                                                                break;
                                                            case 110:
                                                                aVar.b("\n");
                                                                b3 = 0;
                                                                break;
                                                            default:
                                                                switch (b3) {
                                                                    case 114:
                                                                    case 115:
                                                                        break;
                                                                    case 116:
                                                                        strSubstring = "\t";
                                                                        break;
                                                                    case 117:
                                                                        i = ((calendar.get(7) + 5) % 7) + 1;
                                                                        strSubstring = java.lang.String.valueOf(i);
                                                                        break;
                                                                    default:
                                                                        switch (b3) {
                                                                            case 119:
                                                                                i = (calendar.get(7) + 6) % 7;
                                                                                strSubstring = java.lang.String.valueOf(i);
                                                                                break;
                                                                            case 120:
                                                                                b3 = 68;
                                                                                break;
                                                                            case 121:
                                                                            case 122:
                                                                                break;
                                                                            default:
                                                                                n3(bytes, i2, i4);
                                                                                aVar.b("%");
                                                                                b3 = 0;
                                                                                break;
                                                                        }
                                                                        break;
                                                                }
                                                                break;
                                                        }
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        b3 = 98;
                    }
                    aVar.b(strSubstring);
                    b3 = 0;
                }
                if (b3 != 0) {
                    java.util.Locale locale = java.util.Locale.US;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("%");
                    sb.append(b3 != 112 ? 't' : 'T');
                    sb.append((char) (b3 & 255));
                    aVar.b(java.lang.String.format(locale, sb.toString(), calendar));
                }
                i2 = i4;
            }
            i2 = i3;
        }
        return aVar.k();
    }

    void l3(luaj.LuaTable luaTable, java.util.Calendar calendar) {
        luaTable.i2("year", luaj.LuaValue.I2(calendar.get(1)));
        luaTable.i2("month", luaj.LuaValue.I2(calendar.get(2) + 1));
        luaTable.i2("day", luaj.LuaValue.I2(calendar.get(5)));
        luaTable.i2("hour", luaj.LuaValue.I2(calendar.get(11)));
        luaTable.i2("min", luaj.LuaValue.I2(calendar.get(12)));
        luaTable.i2("sec", luaj.LuaValue.I2(calendar.get(13)));
        luaTable.i2("wday", luaj.LuaValue.I2(calendar.get(7)));
        luaTable.i2("yday", luaj.LuaValue.I2(calendar.get(6)));
        luaTable.i2("isdst", luaj.LuaValue.H2(calendar.getTimeZone().inDaylightTime(calendar.getTime())));
    }

    protected void r3(java.lang.String str) throws java.io.IOException {
        java.io.File fileR3 = this.T.R3(str);
        if (!fileR3.exists()) {
            throw new java.io.IOException("No such file or directory: '" + str + "'");
        }
        if (fileR3.delete()) {
            return;
        }
        throw new java.io.IOException("Failed to delete: '" + str + "'");
    }

    protected void s3(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        java.io.File fileR3 = this.T.R3(str);
        if (!fileR3.exists()) {
            throw new java.io.IOException("No such file or directory: '" + str + "'");
        }
        if (fileR3.renameTo(this.T.R3(str2))) {
            return;
        }
        throw new java.io.IOException("Failed to rename '" + str + "' to '" + str2 + "'");
    }
}

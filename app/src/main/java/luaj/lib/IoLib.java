package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public abstract class IoLib extends luaj.lib.TwoArgFunction {
    private static final luaj.LuaValue Z = luaj.LuaValue.K2("stdout");
    private static final luaj.LuaValue a0 = luaj.LuaValue.K2("stderr");
    private static final luaj.LuaValue b0 = luaj.LuaValue.K2("file");
    private static final luaj.LuaValue c0 = luaj.LuaValue.K2("closed file");
    public static final java.lang.String[] d0 = {"close", "flush", "input", "lines", "open", "output", "popen", "read", "tmpfile", "type", "write"};
    public static final java.lang.String[] e0 = {"close", "flush", "lines", "read", "seek", "setvbuf", "write"};
    private boolean T = false;
    private luaj.lib.IoLib$File U = null;
    private luaj.lib.IoLib$File V = null;
    private luaj.lib.IoLib$File W = null;
    luaj.LuaTable X;
    public luaj.Globals Y;

    public static luaj.LuaValue A3(luaj.lib.IoLib$File ioLib$File, boolean z, boolean z2) {
        int iY2;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();try {

        try {            if (android.ext.GgNoop.never) {
                        throw new java.io.EOFException();
                    }

            if (!z) {
                while (true) {try {

                    iY2 = ioLib$File.Y2();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
                    if (iY2 < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(iY2);
                }
            } else {
                while (true) {try {

                    iY2 = ioLib$File.Y2();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
                    if (iY2 >= 0) {
                        if (iY2 == 10) {
                            if (!z2) {
                                break;
                            }
                            byteArrayOutputStream.write(iY2);
                            break;
                        }
                        if (iY2 != 13 || z2) {
                            byteArrayOutputStream.write(iY2);
                        }
                    } else {
                        break;
                    }
                }
            }
            if (iY2 < 0) {
                if (byteArrayOutputStream.size() == 0) {
                    return luaj.LuaValue.f1673c;
                }
            }
        } catch (java.io.EOFException unused) {
        };
} catch (java.lang.RuntimeException e) {
    throw e;
} catch (java.lang.Throwable e) {
    throw new java.lang.RuntimeException(e);
}
        return luaj.LuaString.o3(byteArrayOutputStream.toByteArray());
    }

    private luaj.lib.IoLib$File B3(boolean z) {
        luaj.lib.IoLib$File ioLib$File = this.U;
        if (ioLib$File == null) {
            luaj.LuaValue.R0("stdin not supported");
        }
        if (z && ioLib$File.V2()) {
            luaj.LuaValue.R0("standard input file is closed");
        }
        return ioLib$File;
    }

    private static luaj.Varargs C3(luaj.lib.IoLib$File ioLib$File) {
        if (ioLib$File.W2()) {
            return t3("cannot close standard file", 1000);
        }try {

        ioLib$File.S2();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        return M3();
    }

    private luaj.lib.IoLib$File D3(int i, java.lang.String str, java.lang.String str2) {
        try {
            return K3(i, str, str2);
        } catch (java.lang.Exception e2) {
            luaj.LuaValue.S0("io error: " + e2.getMessage(), e2);
            return null;
        }
    }

    private luaj.Varargs E3(luaj.lib.IoLib$File ioLib$File, luaj.Varargs varargs) {
        luaj.LuaValue luaValueW3;
        luaj.LuaString luaStringG0;
        int i;
        int iU = varargs.U();
        if (iU == 0) {
            return y3(ioLib$File, false);
        }
        luaj.LuaValue[] luaValueArr = new luaj.LuaValue[iU];
        int i2 = 0;
        while (i2 < iU) {
            int i3 = i2 + 1;
            luaj.LuaValue luaValueV = varargs.v(i3);
            int iC2 = luaValueV.C2();
            if (iC2 != 3) {
                if (iC2 == 4 && (i = (luaStringG0 = luaValueV.G0()).R) >= 1) {
                    byte[] bArr = luaStringG0.P;
                    int i4 = luaStringG0.Q;
                    byte b2 = bArr[i4];
                    if (b2 == 42 && i >= 2) {
                        b2 = bArr[i4 + 1];
                    }
                    if (b2 == 76) {
                        luaValueW3 = y3(ioLib$File, true);
                    } else if (b2 == 97) {
                        luaValueW3 = v3(ioLib$File);
                    } else if (b2 == 108) {
                        luaValueW3 = y3(ioLib$File, false);
                    } else if (b2 == 110) {
                        luaValueW3 = z3(ioLib$File);
                    }
                }
                return luaj.LuaValue.l0(i3, "read", "invalid format: '" + luaValueV + "'");
            }
            luaValueW3 = w3(ioLib$File, luaValueV.y2());
            luaValueArr[i2] = luaValueW3;
            if (luaValueW3.l1()) {
                i2 = i3;
                break;
            }
            i2 = i3;
        }
        return i2 == 0 ? luaj.LuaValue.f1673c : luaj.LuaValue.P2(luaValueArr, 0, i2);
    }

    private static luaj.Varargs F3(luaj.lib.IoLib$File ioLib$File, luaj.Varargs varargs) {
        int iU = varargs.U();
        for (int i = 1; i <= iU; i++) {try {

            ioLib$File.d3(varargs.H(i));
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
        return ioLib$File;
    }

    private luaj.Varargs G3(luaj.lib.IoLib$File ioLib$File, boolean z, luaj.Varargs varargs) {
        int iU = varargs.U();
        if (iU > 250) {
            if (z) {
                try {
                    ioLib$File.S2();
                } catch (java.io.IOException unused) {
                }
            }
            luaj.LuaValue.R0("too many arguments: " + iU + " max = 250");
        }
        try {
            return new luaj.lib.IoLib$IoLibV(ioLib$File, "lnext", 18, this, z, varargs);
        } catch (java.lang.Exception e2) {
            return luaj.LuaValue.S0("lines: " + e2, e2);
        }
    }

    private static luaj.lib.IoLib$File I3(luaj.LuaValue luaValue) {
        if (luaValue instanceof luaj.lib.IoLib$File) {
            return (luaj.lib.IoLib$File) luaValue;
        }
        return null;
    }

    private luaj.lib.IoLib$File J3(boolean z) {
        luaj.lib.IoLib$File ioLib$FileD3 = this.V;
        if (ioLib$FileD3 == null) {
            ioLib$FileD3 = D3(1, "-", "w");
            this.V = ioLib$FileD3;
        }
        if (z && ioLib$FileD3.V2()) {
            luaj.LuaValue.R0("standard output file is closed");
        }
        return ioLib$FileD3;
    }

    private luaj.lib.IoLib$File K3(int i, java.lang.String str, java.lang.String str2) {
        int length = str2.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str2.charAt(i2);
            if ((i2 != 0 || "rwa".indexOf(cCharAt) < 0) && ((i2 != 1 || cCharAt != '+') && (i2 < 1 || cCharAt != 'b'))) {
                length = -1;
            }
        }
        if (length <= 0) {
            luaj.LuaValue.l0(2, "io.open", "invalid mode: '" + str2 + "'");
        }
        if (i == 1) {
            return Q3();
        }
        if (i != 2) {
            try {
                return H3(str, (char) (str2.charAt(0) + (str2.indexOf(43) > 0 ? '+' : (char) 0)));
            } catch (java.io.IOException e) {
                throw new java.lang.RuntimeException(e);
            }
        }
        return P3();
    }

    private void L3(luaj.LuaTable luaTable) {
        for (luaj.LuaValue luaValue : luaTable.t3()) {
            ((luaj.lib.IoLib$IoLibV) luaTable.U0(luaValue)).U = this;
        }
    }

    private static luaj.Varargs M3() {
        return luaj.LuaValue.f1674d;
    }

    private luaj.lib.IoLib$File N3() throws java.io.IOException {
        java.io.File fileCreateTempFile = java.io.File.createTempFile(".gg.", ".tmp");
        this.T = true;
        try {
            luaj.lib.IoLib$FileImpl ioLib$FileImpl = new luaj.lib.IoLib$FileImpl(this, fileCreateTempFile, (char) 162, null);
            this.T = false;
            fileCreateTempFile.delete();
            return ioLib$FileImpl;
        } catch (java.lang.Throwable th) {
            this.T = false;
            throw th;
        }
    }

    private luaj.lib.IoLib$File P3() {
        return new luaj.lib.IoLib$StdoutFile(this, 2, null);
    }

    private luaj.lib.IoLib$File Q3() {
        return new luaj.lib.IoLib$StdoutFile(this, 1, null);
    }

    private static luaj.lib.IoLib$File q3(java.lang.String str, luaj.LuaValue luaValue) {
        luaj.lib.IoLib$File ioLib$FileI3 = I3(luaValue);
        if (ioLib$FileI3 == null) {
            luaj.LuaValue.l0(1, str, "FILE* expected, got " + luaValue.E2());
        }
        r3(ioLib$FileI3);
        return ioLib$FileI3;
    }

    private static luaj.lib.IoLib$File r3(luaj.lib.IoLib$File ioLib$File) {
        if (ioLib$File.V2()) {
            luaj.LuaValue.R0("attempt to use a closed file");
        }
        return ioLib$File;
    }

    static luaj.Varargs s3(java.io.IOException iOException, int i) {
        java.lang.String message = iOException.getMessage();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("io error: ");
        if (message == null) {
            message = iOException.toString();
        }
        sb.append(message);
        return t3(sb.toString(), i);
    }

    private static luaj.Varargs t3(java.lang.String str, int i) {
        return luaj.LuaValue.M2(luaj.LuaValue.f1673c, luaj.LuaValue.K2(str), luaj.LuaValue.I2(i));
    }

    private luaj.lib.IoLib$File u3() {
        luaj.lib.IoLib$File ioLib$File = this.W;
        if (ioLib$File != null) {
            return ioLib$File;
        }
        luaj.lib.IoLib$File ioLib$FileD3 = D3(2, "-", "w");
        this.W = ioLib$FileD3;
        return ioLib$FileD3;
    }

    public static luaj.LuaValue v3(luaj.lib.IoLib$File ioLib$File) {
        int iA3;
        try {
            iA3 = ioLib$File.a3();
        } catch (java.lang.RuntimeException ggEx) {
            throw ggEx;
        } catch (java.lang.Throwable ggEx2) {
            throw new java.lang.RuntimeException(ggEx2);
        }
        if (iA3 >= 0) {
            return iA3 == 0 ? luaj.LuaValue.L : w3(ioLib$File, iA3);
        }
        return A3(ioLib$File, false, false);
    }

    public static luaj.LuaValue w3(luaj.lib.IoLib$File ioLib$File, int i) {
        if (i == 0) {
            return ioLib$File.T2() ? luaj.LuaValue.f1673c : luaj.LuaValue.L;
        }
        byte[] bArr = new byte[i];int iZ2;
        try {
        iZ2 = ioLib$File.Z2(bArr, 0, i);;
        } catch (java.lang.RuntimeException ggEx) {
            throw ggEx;
        } catch (java.lang.Throwable ggEx2) {
            throw new java.lang.RuntimeException(ggEx2);
        }
        return iZ2 < 0 ? luaj.LuaValue.f1673c : luaj.LuaString.p3(bArr, 0, iZ2);
    }

    private static int x3(luaj.lib.IoLib$File ioLib$File, java.lang.String str, java.io.ByteArrayOutputStream byteArrayOutputStream, int i) {
        int i2 = 0;
        while (true) {int iX2;
            try {
            iX2 = ioLib$File.X2();;
            } catch (java.lang.RuntimeException ggEx) {
                throw ggEx;
            } catch (java.lang.Throwable ggEx2) {
                throw new java.lang.RuntimeException(ggEx2);
            }
            if (str.indexOf(iX2) < 0) {
                return i2;
            }try {

            ioLib$File.Y2();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
            i2++;
            if (byteArrayOutputStream != null) {
                if (byteArrayOutputStream.size() >= 200) {
                    byteArrayOutputStream.reset();
                    return 0;
                }
                byteArrayOutputStream.write(iX2);
            }
            if (i > 0 && i2 >= i) {
                return i2;
            }
        }
    }

    public static luaj.LuaValue y3(luaj.lib.IoLib$File ioLib$File, boolean z) {
        return A3(ioLib$File, true, z);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0030  */
    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    /* JADX WARN: Code duplicated, block: B:16:0x0040 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    /* JADX WARN: Code duplicated, block: B:21:0x004b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x004d  */
    /* JADX WARN: Code duplicated, block: B:23:0x0050  */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:29:0x0068  */
    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    public static luaj.LuaValue z3(luaj.lib.IoLib$File ioLib$File) {
        int i;
        boolean z = false;
        java.lang.String str;
        int iX3;
        java.lang.String str2;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        x3(ioLib$File, " \t\r\n", null, 0);
        x3(ioLib$File, "-+", byteArrayOutputStream, 1);
        if (x3(ioLib$File, "0", byteArrayOutputStream, 1) > 0) {
            if (x3(ioLib$File, "xX", byteArrayOutputStream, 1) > 0) {
                i = 0;
                z = true;
            } else {
                i = 1;
            }
            if (z) {
                str = "0123456789abcdefABCDEF";
            } else {
                str = "0123456789";
            }
            iX3 = i + x3(ioLib$File, str, byteArrayOutputStream, 0);
            if (x3(ioLib$File, ".", byteArrayOutputStream, 1) > 0) {
                iX3 += x3(ioLib$File, z ? "0123456789abcdefABCDEF" : "0123456789", byteArrayOutputStream, 0);
            }
            if (iX3 > 0) {
                if (z) {
                    str2 = "pP";
                } else {
                    str2 = "eE";
                }
                if (x3(ioLib$File, str2, byteArrayOutputStream, 1) > 0) {
                    x3(ioLib$File, "-+", byteArrayOutputStream, 1);
                    x3(ioLib$File, "0123456789", byteArrayOutputStream, 0);
                }
            }
            java.lang.String string = byteArrayOutputStream.toString();
            return string.length() > 0 ? luaj.LuaValue.P1(string, luaj.LuaValue.f1673c) : luaj.LuaValue.f1673c;
        }
        i = 0;
        z = false;
        if (z) {
            str = "0123456789abcdefABCDEF";
        } else {
            str = "0123456789";
        }
        iX3 = i + x3(ioLib$File, str, byteArrayOutputStream, 0);
        if (x3(ioLib$File, ".", byteArrayOutputStream, 1) > 0) {
            iX3 += x3(ioLib$File, z ? "0123456789abcdefABCDEF" : "0123456789", byteArrayOutputStream, 0);
        }
        if (iX3 > 0) {
            if (z) {
                str2 = "pP";
            } else {
                str2 = "eE";
            }
            if (x3(ioLib$File, str2, byteArrayOutputStream, 1) > 0) {
                x3(ioLib$File, "-+", byteArrayOutputStream, 1);
                x3(ioLib$File, "0123456789", byteArrayOutputStream, 0);
            }
        }
        java.lang.String string2 = byteArrayOutputStream.toString();
        return string2.length() > 0 ? luaj.LuaValue.P1(string2, luaj.LuaValue.f1673c) : luaj.LuaValue.f1673c;
    }

    protected luaj.lib.IoLib$File H3(java.lang.String str, char c2) throws java.io.IOException {
        return new luaj.lib.IoLib$FileImpl(this, this.Y.R3(str), c2, null);
    }

    protected boolean O3(java.io.File file, java.io.FileDescriptor fileDescriptor, boolean z) {
        if (this.T) {
            return true;
        }
        return luaj.lib.d.b(fileDescriptor, this.Y.Z, z);
    }

    public luaj.Varargs X2(luaj.LuaValue luaValue) {
        return C3(q3("file:close", luaValue));
    }

    public luaj.Varargs Y2(luaj.LuaValue luaValue) {try {

        q3("file:flush", luaValue).U2();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        return luaj.LuaValue.f1674d;
    }

    public luaj.Varargs Z2(luaj.Varargs varargs) {
        return G3(q3("file:lines", varargs.w()), false, varargs.e0(2));
    }

    public luaj.Varargs a3(luaj.LuaValue luaValue, luaj.Varargs varargs) {
        return E3(q3("file:read", luaValue), varargs);
    }

    public luaj.Varargs b3(luaj.LuaValue luaValue, java.lang.String str, int i) {
        if (!"set".equals(str) && !"end".equals(str) && !"cur".equals(str)) {
            luaj.LuaValue.l0(1, "file:seek", "invalid value: '" + str + "'; must be one of 'set', 'cur' or 'end'");
        }try {

        return luaj.LuaValue.I2(q3("file:seek", luaValue).b3(str, i));
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    public luaj.Varargs c3(luaj.LuaValue luaValue, java.lang.String str, int i) {
        if ("no".equals(str)) {
            i = 1;
        } else if (!"full".equals(str) && !"line".equals(str)) {
            luaj.LuaValue.l0(1, "file:setvbuf", "invalid value: '" + str + "'; must be one of 'no', 'full' or 'line'");
        }
        if (i <= 0) {
            luaj.LuaValue.l0(2, "file:setvbuf", "invalid value '" + i + "'; must be positive");
        }try {

        q3("file:setvbuf", luaValue).c3(str, i);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        return luaj.LuaValue.f1674d;
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        this.Y = luaValue2.z0();
        luaj.LuaTable luaTable = new luaj.LuaTable();
        V2(luaTable, new luaj.lib.IoLib$a(this), d0);
        luaj.LuaTable luaTable2 = new luaj.LuaTable();
        this.X = luaTable2;
        W2(luaTable2, new luaj.lib.IoLib$b(this), e0, 11);
        L3(luaTable);
        L3(this.X);
        this.X.h2("__name", "FILE*");
        luaj.LuaValue luaValue3 = this.X;
        luaValue3.i2("__index", luaValue3);
        luaTable.j2(Z, J3(false));
        luaTable.j2(a0, u3());
        luaValue2.i2("io", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("io", luaTable);
        }
        return luaTable;
    }

    public luaj.Varargs d3(luaj.LuaValue luaValue, luaj.Varargs varargs) {
        return F3(q3("file:write", luaValue), varargs);
    }

    public luaj.Varargs e3(luaj.LuaValue luaValue) {
        luaj.lib.IoLib$File ioLib$FileJ3 = luaValue.l1() ? J3(false) : q3("io.close", luaValue);
        r3(ioLib$FileJ3);
        return C3(ioLib$FileJ3);
    }

    public luaj.Varargs f3() {
        J3(true);try {

        this.V.U2();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        return luaj.LuaValue.f1674d;
    }

    public luaj.Varargs g3(luaj.LuaValue luaValue) {
        luaj.lib.IoLib$File ioLib$FileD3;
        if (luaValue.l1()) {
            ioLib$FileD3 = B3(false);
        } else {
            ioLib$FileD3 = luaValue.n1() ? D3(3, luaValue.B0(), "r") : q3("io.input", luaValue);
        }
        this.U = ioLib$FileD3;
        return ioLib$FileD3;
    }

    public luaj.Varargs h3(luaj.Varargs varargs) {
        java.lang.String strZ = varargs.Z(1, null);
        luaj.lib.IoLib$File ioLib$FileB3 = strZ == null ? B3(false) : D3(3, strZ, "r");
        r3(ioLib$FileB3);
        return G3(ioLib$FileB3, strZ != null, varargs.e0(2));
    }

    public luaj.Varargs i3(java.lang.String str, java.lang.String str2) {
        return K3(3, str, str2);
    }

    public luaj.Varargs j3(luaj.LuaValue luaValue) {
        luaj.lib.IoLib$File ioLib$FileD3;
        if (luaValue.l1()) {
            ioLib$FileD3 = J3(false);
        } else {
            ioLib$FileD3 = luaValue.n1() ? D3(3, luaValue.B0(), "w") : q3("io.output", luaValue);
        }
        this.V = ioLib$FileD3;
        return ioLib$FileD3;
    }

    public luaj.Varargs k3(java.lang.String str, java.lang.String str2) {
        throw new luaj.d("Failed io.popen('" + str + "', '" + str2 + "'): disabled by security reason");
    }

    public luaj.Varargs l3(luaj.Varargs varargs) {
        B3(true);
        return E3(this.U, varargs);
    }

    public luaj.Varargs m3() {try {

        return N3();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    public luaj.Varargs n3(luaj.LuaValue luaValue) {
        luaj.lib.IoLib$File ioLib$FileI3 = I3(luaValue);
        if (ioLib$FileI3 != null) {
            return ioLib$FileI3.V2() ? c0 : b0;
        }
        return luaj.LuaValue.f1673c;
    }

    public luaj.Varargs o3(luaj.Varargs varargs) {
        J3(true);
        return F3(this.V, varargs);
    }

    public luaj.Varargs p3(luaj.LuaValue luaValue, boolean z, luaj.Varargs varargs) {
        luaj.lib.IoLib$File ioLib$FileI3 = I3(luaValue);
        if (ioLib$FileI3 == null) {
            luaj.LuaValue.l0(1, "lines", "not a file: " + luaValue);
        }
        if (ioLib$FileI3.V2()) {
            luaj.LuaValue.R0("file is already closed");
        }
        luaj.Varargs varargsE3 = E3(ioLib$FileI3, varargs);
        if (z && varargsE3.Q(1) && ioLib$FileI3.T2()) {try {

            ioLib$FileI3.S2();
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
        return varargsE3;
    }
}

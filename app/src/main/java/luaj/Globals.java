package luaj;

/* JADX INFO: loaded from: classes.dex */
public class Globals extends luaj.LuaTable {
    public luaj.lib.e Z;
    public luaj.lib.f e0;
    public luaj.lib.BaseLib g0;
    public luaj.lib.PackageLib h0;
    public luaj.lib.DebugLib i0;
    public luaj.Globals$b j0;
    public luaj.Globals$a k0;
    public luaj.Globals$d l0;
    public boolean X = true;
    public int Y = 0;
    public long a0 = 0;
    public int b0 = 0;
    public java.io.PrintStream c0 = java.lang.System.out;
    public java.io.PrintStream d0 = java.lang.System.err;
    public luaj.LuaThread f0 = new luaj.LuaThread(this);
    private java.lang.String m0 = null;

    public void L3(java.lang.String str) {
        int i = this.Y;
        int i2 = i + 1;
        this.Y = i2;
        if (i2 < 1024) {
            return;
        }
        this.Y = i;
        throw new luaj.d("Too many open files: " + i2 + "; last: " + str);
    }

    public void M3(long j) {
        long j2 = this.a0 + j;
        this.a0 = j2;
        if (j2 < 1073741824) {
            return;
        }
        android.content.Context contextF0 = android.ext.Tools.f0();
        throw new luaj.d("Too many write to files: " + android.ext.Tools.U(contextF0, this.a0) + "; last: " + android.ext.Tools.U(contextF0, j));
    }

    public luaj.h N3(java.io.InputStream inputStream, java.lang.String str) {
        if (this.k0 == null) {
            luaj.LuaValue.R0("No compiler.");
        }
        return this.k0.b(luaj.Globals$c.b(inputStream).a(true), str);
    }

    public luaj.LuaValue O3(java.io.InputStream inputStream, java.lang.String str, java.lang.String str2, luaj.LuaValue luaValue) {
        try {
            try {
                luaj.LuaFunction luaFunctionA = this.j0.a(P3(inputStream, str, str2), str, luaValue);
                try {
                    inputStream.close();
                } catch (java.io.IOException unused) {
                }
                return luaFunctionA;
            } catch (java.io.EOFException e2) {
                luaj.LuaValue luaValueS0 = luaj.LuaValue.S0("truncated precompiled chunk", e2);
                try {
                    inputStream.close();
                } catch (java.io.IOException unused2) {
                }
                return luaValueS0;
            } catch (luaj.d e3_c_c_c) {
                throw e3_c_c_c;
            } catch (java.lang.Exception e4) {
                luaj.LuaValue luaValueS1 = luaj.LuaValue.S0("load " + str + ": " + e4, e4);
                try {
                    inputStream.close();
                } catch (java.io.IOException unused3) {
                }
                return luaValueS1;
            }
        } catch (java.lang.Throwable th_c_c_c) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused4) {
            }
            throw th_c_c_c;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[PHI: r0
      0x0073: PHI (r0v15 long) = (r0v14 long), (r0v17 long) binds: [B:25:0x0071, B:20:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.io.PushbackInputStream, luaj.Globals$c] */
    /* JADX WARN: Type inference failed for: r9v0, types: [luaj.Globals] */
    public luaj.h P3(java.io.InputStream inputStream, java.lang.String str, java.lang.String str2) throws java.io.IOException {
        java.io.InputStream r10;
        long jPosition;
        if (str2.indexOf(98) >= 0) {
            if (this.l0 == null) {
                luaj.LuaValue.R0("No undumper.");
            }
            byte[] bArr = new byte[4];
            int i = inputStream.read(bArr);
            byte b2 = bArr[0];
            byte[] bArr2 = luaj.a.n;
            if (b2 == bArr2[0] && bArr[1] == bArr2[1] && bArr[2] == bArr2[2] && bArr[3] == bArr2[3]) {
                luaj.h hVarA = this.l0.a(inputStream, str);
                if (inputStream instanceof luaj.lib.BaseLib$b) {
                    luaj.lib.BaseLib$b baseLib$b = (luaj.lib.BaseLib$b) inputStream;
                    java.io.InputStream inputStreamB = baseLib$b.b();
                    if (inputStreamB instanceof java.io.FileInputStream) {
                        jPosition = baseLib$b.a();
                        if (jPosition < ((java.io.FileInputStream) inputStreamB).getChannel().size()) {
                            hVarA.m = (int) jPosition;
                        }
                    }
                } else if (inputStream instanceof java.io.FileInputStream) {
                    java.nio.channels.FileChannel channel = ((java.io.FileInputStream) inputStream).getChannel();
                    jPosition = channel.position();
                    if (jPosition < channel.size()) {
                        hVarA.m = (int) jPosition;
                    }
                }
                return hVarA;
            }
            if (i > 0) {
                inputStream = luaj.Globals$c.b(inputStream);
                ((java.io.PushbackInputStream) inputStream).unread(bArr, 0, i);
            }
        }
        if (str2.indexOf(116) < 0) {
            throw new luaj.d("attempt to load a text chunk (mode is '" + str2 + "'");
        }
        byte[] bArr3 = new byte[61];
        int i2 = inputStream.read(bArr3);
        if (i2 > 0) {
            r10 = inputStream;
            luaj.Globals$c globals$cB = luaj.Globals$c.b(inputStream);
            globals$cB.unread(bArr3, 0, i2);
            r10 = globals$cB;
        }
        r10 = inputStream;
        if (new java.lang.String(bArr3).equals("; --[=========[ Lua assembler file generated by GameGuardian ")) {
            try {
                return new lasm.a(r10).u();
            } catch (gg_e.d e2) {
                throw new luaj.d("Failed assemble: " + e2.getMessage(), e2);
            }
        }
        byte b3 = bArr3[0];
        byte[] bArr4 = luaj.a.n;
        if (b3 != bArr4[0] || bArr3[1] != bArr4[1] || bArr3[2] != bArr4[2] || bArr3[3] != bArr4[3]) {
            return N3(r10, str);
        }
        throw new luaj.d("attempt to load a binary chunk (mode is '" + str2 + "')");
    }

    public luaj.LuaValue Q3(java.lang.String str) {
        try {
            java.io.InputStream inputStreamU = this.e0.u(str);
            java.lang.String absolutePath = R3(str).getAbsolutePath();
            luaj.LuaValue luaValueO3 = O3(inputStreamU, '@' + absolutePath, "bt", this);
            if (luaValueO3 instanceof luaj.LuaClosure) {
                ((luaj.LuaClosure) luaValueO3).U = absolutePath;
            }
            return luaValueO3;
        } catch (java.lang.Exception e2) {
            return luaj.LuaValue.S0("load " + str + ": " + e2, e2);
        }
    }

    public java.io.File R3(java.lang.String str) {
        java.lang.String str2 = this.m0;
        return (str2 == null || (str.length() != 0 && str.charAt(0) == '/')) ? new java.io.File(str) : new java.io.File(str2, str);
    }

    public void S3() {
        int i = this.Y;
        if (i > 0) {
            this.Y = i - 1;
        }
    }

    public void T3(java.lang.String str) {
        this.m0 = str;
    }

    @Override // luaj.LuaValue
    public luaj.Globals z0() {
        return this;
    }
}

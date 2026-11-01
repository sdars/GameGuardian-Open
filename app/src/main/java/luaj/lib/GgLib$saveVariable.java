package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public final class GgLib$saveVariable extends luaj.lib.VarArgFunction {
    static final java.lang.String[] Y = {"address", "value", "flags", "name", "freeze", "freezeType", "freezeFrom", "freezeTo"};
    final luaj.Globals T;
    java.io.Writer U;
    java.util.Map V;
    java.util.List W;
    final java.lang.Integer X = 0;

    public GgLib$saveVariable(luaj.Globals globals) {
        this.T = globals;
    }

    private void X2(luaj.LuaTable luaTable) {
        if (((java.lang.Integer) this.V.put(luaTable, this.X)) == null && (luaTable instanceof luaj.LuaTable)) {
            luaj.LuaTable$i luaTable$iS3 = luaTable.s3();
            while (luaTable$iS3.c()) {
                int i = 0;
                while (i < 2) {
                    luaj.LuaValue luaValueB = i == 0 ? luaTable$iS3.b() : luaTable$iS3.d();
                    if (luaValueB instanceof luaj.LuaTable) {
                        X2((luaj.LuaTable) luaValueB);
                    }
                    i++;
                }
            }
        }
    }

    private void Y2() throws java.io.IOException {
        luaj.LuaValue luaValueB = null;
        java.lang.String[] strArr = Y;
        java.io.Writer writer = this.U;
        java.util.List list = this.W;
        java.util.Map map = this.V;
        java.util.Iterator it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            boolean z = true;
            i++;
            luaj.LuaTable$i luaTable$iS3 = ((luaj.LuaTable) it.next()).s3();
            while (luaTable$iS3.c()) {
                int iA = luaTable$iS3.a();
                luaj.LuaValue luaValueD = luaTable$iS3.d();
                if (luaValueD instanceof luaj.LuaTable) {
                    luaValueB = iA != 0 ? null : luaTable$iS3.b();
                } else if (iA == 0) {
                    luaValueB = luaTable$iS3.b();
                    if (!(luaValueB instanceof luaj.LuaTable)) {
                    }
                }
                if (z) {
                    writer.write("\nt=v[");
                    writer.write(java.lang.Integer.toString(i));
                    writer.write(93);
                    z = false;
                }
                writer.write("\nt[");
                if (luaValueB == null) {
                    writer.write(java.lang.Integer.toString(iA));
                } else {
                    a3(writer, strArr, map, luaValueB);
                }
                writer.write("]=");
                a3(writer, strArr, map, luaValueD);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2  */
    private void Z2() throws java.io.IOException {
        luaj.LuaValue luaValueD;
        java.lang.String[] strArr = Y;
        this.U.write("local ");
        int length = strArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            this.U.write((char) (i2 + 97));
            this.U.write(44);
        }
        this.U.write("v,t=");
        for (java.lang.String str : strArr) {
            this.U.write(39);
            this.U.write(str);
            this.U.write("',");
        }
        this.U.write("nil\nv={");
        java.io.Writer writer = this.U;
        java.util.Map map = this.V;
        for (luaj.LuaTable luaTable : (java.util.Collection<luaj.LuaTable>) this.W) {
            int i3 = 1;
            i++;
            map.put(luaTable, java.lang.Integer.valueOf(i));
            writer.write("{");
            luaj.LuaTable$i luaTable$iS3 = luaTable.s3();
            while (luaTable$iS3.c()) {
                int iA = luaTable$iS3.a();
                if (iA == 0) {
                    luaj.LuaValue luaValueB = luaTable$iS3.b();
                    if (!(luaValueB instanceof luaj.LuaTable)) {
                        writer.write("[");
                        a3(writer, strArr, map, luaValueB);
                    }
                } else {
                    if (iA != i3) {
                        writer.write("[");
                        writer.write(java.lang.Integer.toString(iA));
                    } else {
                        i3++;
                    }
                    luaValueD = luaTable$iS3.d();
                    if (luaValueD instanceof luaj.LuaTable) {
                        writer.write("nil");
                    } else {
                        a3(writer, strArr, map, luaValueD);
                    }
                    writer.write(";");
                }
                writer.write("]=");
                luaValueD = luaTable$iS3.d();
                if (luaValueD instanceof luaj.LuaTable) {
                    writer.write("nil");
                } else {
                    a3(writer, strArr, map, luaValueD);
                }
                writer.write(";");
            }
            writer.write("};");
        }
        writer.write("}");
    }

    private void a3(java.io.Writer writer, java.lang.String[] strArr, java.util.Map map, luaj.LuaValue luaValue) throws java.io.IOException {
        if (luaValue instanceof luaj.LuaTable) {
            writer.write("v[");
            writer.write(java.lang.Integer.toString(((java.lang.Integer) map.get(luaValue)).intValue()));
            writer.write(93);
        } else {
            if (!(luaValue instanceof luaj.LuaString)) {
                writer.write(luaValue.g0());
                return;
            }
            java.lang.String strG0 = luaValue.g0();
            int length = strArr.length;
            for (int i = 0; i < length; i++) {
                if (strG0.equals(strArr[i])) {
                    writer.write(i + 97);
                    return;
                }
            }
            b3(writer, strG0);
        }
    }

    /* JADX WARN: Switch 'out' block B:18:0x0038 for B:9:0x001d already processed. Defaulting to fallback option. */
    private java.lang.Appendable b3(java.lang.Appendable appendable, java.lang.String str) throws java.io.IOException {
        if (appendable == null) {
            appendable = new java.lang.StringBuilder();
        }
        appendable.append('\'');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\'' && cCharAt != '\\') {
                switch (cCharAt) {
                    case 7:
                        cCharAt = 'a';
                        appendable.append('\\');
                        break;
                    case '\b':
                        cCharAt = 'b';
                        appendable.append('\\');
                        break;
                    case '\t':
                        cCharAt = 't';
                        appendable.append('\\');
                        break;
                    case '\n':
                        cCharAt = 'n';
                        appendable.append('\\');
                        break;
                    case 11:
                        cCharAt = 'v';
                        appendable.append('\\');
                        break;
                    case '\f':
                        cCharAt = 'f';
                        appendable.append('\\');
                        break;
                    case '\r':
                        cCharAt = 'r';
                        appendable.append('\\');
                        break;
                }
            } else {
                appendable.append('\\');
            }
            appendable.append(cCharAt);
        }
        appendable.append('\'');
        return appendable;
    }

    private void c3(luaj.LuaValue luaValue, java.io.RandomAccessFile randomAccessFile) {
        try {
            java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new luaj.lib.GgLib$saveVariable$a(this, randomAccessFile)), 65536);
            this.U = bufferedWriter;
            if (luaValue instanceof luaj.LuaTable) {
                this.V = new java.util.HashMap();
                X2((luaj.LuaTable) luaValue);
                this.W = new java.util.ArrayList(this.V.keySet());
                Z2();
                Y2();
                bufferedWriter.write("\nreturn v[" + this.V.get(luaValue) + "]\n");
                this.V = null;
            } else {
                if (luaValue instanceof luaj.LuaString) {
                    bufferedWriter.write("return ");
                    b3(bufferedWriter, luaValue.g0());
                } else {
                    bufferedWriter.write("return ");
                    bufferedWriter.write(luaValue.g0());
                }
                bufferedWriter.write(10);
            }
            bufferedWriter.close();
            this.U = null;
            this.V = null;
            this.W = null;
        } catch (java.lang.Throwable th_c_c_c) {
            this.U = null;
            this.V = null;
            this.W = null;try {

            throw th_c_c_c;
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        }
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaValue luaValueV = varargs.v(1);
        java.lang.String strE = varargs.E(2);
        this.T.L3(strE);
        try {
            java.io.RandomAccessFile randomAccessFileF = luaj.lib.d.f(new java.io.File(strE), this.T.Z);
            if (randomAccessFileF == null) {
                this.T.S3();
                return luaj.LuaValue.K2("File '" + strE + "' can not be written");
            }
            try {
                c3(luaValueV, randomAccessFileF);
                try {
                    randomAccessFileF.close();
                } catch (java.io.IOException unused) {
                }
                this.T.S3();
                return luaj.LuaValue.f1673c;
            } catch (java.lang.Throwable th) {
                try {
                    luaj.LuaString luaStringK2 = luaj.LuaValue.K2(th.toString());
                    try {
                        randomAccessFileF.close();
                    } catch (java.io.IOException unused2) {
                    }
                    this.T.S3();
                    return luaStringK2;
                } catch (java.lang.Throwable th2_c_c_c) {
                    try {
                        randomAccessFileF.close();
                    } catch (java.io.IOException unused3) {
                    }
                    this.T.S3();
                    throw th2_c_c_c;
                }
            }
        } catch (java.io.IOException e2) {
            this.T.S3();
            return luaj.LuaValue.K2(e2.toString());
        }
    }
}

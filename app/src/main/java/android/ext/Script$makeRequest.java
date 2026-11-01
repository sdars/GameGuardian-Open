package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$makeRequest extends android.ext.Script$ApiFunction implements android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnClickListener {
    private volatile byte e0 = 0;
    final /* synthetic */ android.ext.Script f0;

    Script$makeRequest(android.ext.Script script) {
        this.f0 = script;
    }

    private void l3(java.lang.String str, luaj.LuaTable luaTable, java.net.HttpURLConnection httpURLConnection) {
        luaj.LuaTable$i luaTable$iS3 = luaTable.s3();
        while (luaTable$iS3.c()) {
            httpURLConnection.addRequestProperty(str, luaTable$iS3.d().B0());
        }
    }

    private long m3(java.net.HttpURLConnection httpURLConnection) {
        java.lang.String headerField = httpURLConnection.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        java.lang.String strTrim = headerField.trim();
        if (strTrim.isEmpty()) {
            return -1L;
        }
        long j = 0;
        for (int i = 0; i < strTrim.length(); i++) {
            char cCharAt = strTrim.charAt(i);
            int i2 = cCharAt - '0';
            if (cCharAt < '0' || cCharAt > '9') {
                return -1L;
            }
            long j2 = i2;
            if (j > (16777216 - j2) / 10) {
                return 16777217L;
            }
            java.lang.Long.signum(j);
            j = (j * 10) + j2;
        }
        return j;
    }

    private luaj.LuaTable n3(java.net.HttpURLConnection httpURLConnection) {
        luaj.LuaTable luaTable = new luaj.LuaTable();
        for (java.util.Map.Entry<java.lang.String, java.util.List<java.lang.String>> map$Entry : httpURLConnection.getHeaderFields().entrySet()) {
            java.lang.String key = map$Entry.getKey();
            if (key == null) {
                key = "null";
            }
            java.util.List<java.lang.String> value = map$Entry.getValue();
            luaj.LuaTable luaTable2 = new luaj.LuaTable();
            luaTable2.R1(value.size());
            java.util.Iterator<java.lang.String> it = value.iterator();
            int i = 1;
            while (it.hasNext()) {
                luaTable2.X1(i, it.next());
                i++;
            }
            luaTable.c2(key, luaTable2);
        }
        return luaTable;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 3;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs b3(luaj.Varargs varargs) {
        java.lang.String strE = varargs.E(1);
        luaj.LuaTable luaTableC0 = varargs.c0(2, null);
        if (luaTableC0 == null) {
            luaTableC0 = new luaj.LuaTable();
        }
        luaj.LuaString luaStringB0 = varargs.b0(3, null);
        if (this.e0 == 0) {
            synchronized (this) {
                try {
                    android.ext.n2.i(new android.ext.Script$makeRequest$1(this));
                    android.ext.Script.W3(this);
                } catch (java.lang.Throwable th_c_c_c) {
                    throw th_c_c_c;
                }
            }
        }
        return this.e0 != 1 ? luaj.LuaValue.K2("The user did not allow access to the Internet.") : o3(strE, luaTableC0, luaStringB0);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.makeRequest(string url [, table headers = {} [, string data = nil]]) -> table || string";
    }

    public luaj.Varargs o3(java.lang.String str, luaj.LuaTable luaTable, luaj.LuaString luaString) {try {

        return p3(str, luaTable, luaString, 30000, 30000, 30000);
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.e0 = (byte) 1;
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        synchronized (this) {
            try {
                if (this.e0 == 0) {
                    this.e0 = (byte) 2;
                }
                notify();
            } catch (java.lang.Throwable th_c_c_c) {
                throw th_c_c_c;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:97:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    luaj.Varargs p3(java.lang.String str, luaj.LuaTable luaTable, luaj.LuaString luaString, int i, int i2, int i3) throws java.io.IOException {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        java.net.HttpURLConnection httpURLConnection = null;
        java.io.InputStream errorStream = null;
        try {
            luaj.LuaTable luaTable2 = new luaj.LuaTable();
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            try {
                httpURLConnection2.setConnectTimeout(i);
                httpURLConnection2.setReadTimeout(i2);
                luaj.LuaTable$i luaTable$iS3 = luaTable.s3();
                while (luaTable$iS3.c()) {
                    luaj.LuaValue luaValueB = luaTable$iS3.b();
                    luaj.LuaValue luaValueD = luaTable$iS3.d();
                    if (luaValueD instanceof luaj.LuaTable) {
                        l3(luaValueB.B0(), luaValueD.H0(), httpURLConnection2);
                    } else {
                        httpURLConnection2.addRequestProperty(luaValueB.B0(), luaValueD.B0());
                    }
                }
                if (luaString != null) {
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setRequestMethod("POST");
                    int i4 = luaString.R;
                    if (httpURLConnection2.getRequestProperty("Content-Length") == null) {
                        httpURLConnection2.addRequestProperty("Content-Length", java.lang.Integer.toString(i4));
                    }
                    if (httpURLConnection2.getRequestProperty("Content-Type") == null) {
                        httpURLConnection2.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    }
                    httpURLConnection2.setFixedLengthStreamingMode(i4);
                    httpURLConnection2.connect();
                    android.ext.Script$PostWriteWorker script$PostWriteWorker = new android.ext.Script$PostWriteWorker(httpURLConnection2.getOutputStream(), luaString.P, luaString.Q, i4);
                    script$PostWriteWorker.start();
                    try {
                        try {
                            script$PostWriteWorker.join(i3);
                            if (script$PostWriteWorker.isAlive()) {
                                throw new java.io.InterruptedIOException("POST body write timed out");
                            }
                            boolean zIsAlive = script$PostWriteWorker.isAlive();
                            if (zIsAlive) {
                                httpURLConnection2.disconnect();
                            }
                            script$PostWriteWorker.a(zIsAlive);
                        } catch (java.lang.Throwable th_c_c_c) {
                            boolean zIsAlive2 = script$PostWriteWorker.isAlive();
                            if (zIsAlive2) {
                                httpURLConnection2.disconnect();
                            }
                            script$PostWriteWorker.a(zIsAlive2);
                            throw th_c_c_c;
                        }
                    } catch (java.lang.InterruptedException e2_c_c_c) {
                        java.lang.Thread.currentThread().interrupt();
                        throw e2_c_c_c;
                    }
                } else {
                    httpURLConnection2.connect();
                }
                luaTable2.b2("url", str);
                luaTable2.b2("requestMethod", httpURLConnection2.getRequestMethod());
                luaTable2.a2("code", httpURLConnection2.getResponseCode());
                luaTable2.b2("message", httpURLConnection2.getResponseMessage());
                luaTable2.c2("headers", n3(httpURLConnection2));
                luaTable2.b2("contentEncoding", httpURLConnection2.getContentEncoding());
                luaTable2.a2("contentLength", httpURLConnection2.getContentLength());
                luaTable2.b2("contentType", httpURLConnection2.getContentType());
                luaTable2.Z1("date", httpURLConnection2.getDate());
                luaTable2.Z1("expiration", httpURLConnection2.getExpiration());
                luaTable2.Z1("lastModified", httpURLConnection2.getLastModified());
                luaTable2.c2("usingProxy", httpURLConnection2.usingProxy() ? luaj.LuaValue.f1674d : luaj.LuaValue.f1675e);
                if (httpURLConnection2 instanceof javax.net.ssl.HttpsURLConnection) {
                    luaTable2.b2("cipherSuite", ((javax.net.ssl.HttpsURLConnection) httpURLConnection2).getCipherSuite());
                }
                try {
                    try {
                        errorStream = httpURLConnection2.getInputStream();
                    } catch (java.io.IOException unused) {
                        errorStream = httpURLConnection2.getErrorStream();
                        luaTable2.c2("error", luaj.LuaValue.f1674d);
                    }
                    java.io.BufferedInputStream bufferedInputStream = new java.io.BufferedInputStream(errorStream);
                    try {
                        long jM3 = m3(httpURLConnection2);
                        if (jM3 > 16777216) {
                            throw new java.io.IOException("response body of " + jM3 + " bytes exceeds the 16777216 byte limit");
                        }
                        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                        byte[] bArr = new byte[8192];
                        long j = 0;
                        while (true) {
                            int i5 = bufferedInputStream.read(bArr);
                            if (i5 == -1) {
                                luaTable2.i2("content", luaj.LuaString.o3(byteArrayOutputStream.toByteArray()));
                                try {
                                    bufferedInputStream.close();
                                } catch (java.io.IOException unused2) {
                                }
                                httpURLConnection2.disconnect();
                                return luaTable2;
                            }
                            j += (long) i5;
                            if (j > 16777216) {
                                throw new java.io.IOException("response body exceeds the 16777216 byte limit");
                            }
                            byteArrayOutputStream.write(bArr, 0, i5);
                        }
                    } catch (java.lang.Throwable th2) {
                        errorStream = bufferedInputStream;
                        th = th2;
                        if (errorStream != null) {
                            try {
                                errorStream.close();
                            } catch (java.io.IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    if (errorStream != null) {
                        errorStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                httpURLConnection = httpURLConnection2;
                try {
                    android.ext.e1.p("makeRequest failed: " + th.getClass().getName());
                    luaj.LuaString luaStringK2 = luaj.LuaValue.K2(android.ext.Script.V3(th));
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return luaStringK2;
                } catch (java.lang.Throwable th5_c_c_c) {
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th5_c_c_c;
                }
            }
        } catch (java.lang.Throwable th6) {
            th = th6;
        }
        return null;
    }
}

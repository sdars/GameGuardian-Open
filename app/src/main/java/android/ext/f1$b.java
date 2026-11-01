package android.ext;

/* JADX INFO: loaded from: classes.dex */
class f1$b implements java.lang.Runnable {
    f1$b() {
    }

    @Override // java.lang.Runnable
    public void run() {
        byte[] bytes;
        java.io.BufferedReader bufferedReader = null;
        java.lang.StringBuilder sb = null;
        int iE = 0;
        int iE2 = 0;
        java.lang.String str = null;
        java.lang.String str2 = null;
        try {
            android.ext.f1.f951a = java.lang.Boolean.FALSE;
            java.lang.String str3 = "" + ((1 * 112.0f) - 10.6f);
            java.lang.String str4 = null;
            try {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
                for (int i = 0; i < 4; i++) {
                    java.lang.String str5 = "used-" + i;
                    if (sharedPreferencesM0.contains(str5)) {
                        java.lang.String string = sharedPreferencesM0.getString(str5, "");
                        if (string.length() != 0) {
                            if (sb2.length() != 0) {
                                sb2.append('&');
                            }
                            sb2.append(i);
                            sb2.append('=');
                            sb2.append(string);
                        }
                    }
                }
                android.content.SharedPreferences.Editor sharedPreferences$EditorEdit = sharedPreferencesM0.edit();
                for (int i2 = 0; i2 < 4; i2++) {
                    sharedPreferences$EditorEdit.remove("used-" + i2);
                }
                sharedPreferences$EditorEdit.commit();
                bytes = sb2.toString().getBytes();
                while (true) {
                    java.lang.String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (str4 == null) {
                        str4 = line;
                    }
                    if ("".equals(str)) {
                        if (android.ext.h0.e(line) <= iE) {
                            break;
                        } else {
                            str2 = line;
                        }
                    }
                    sb.append(line);
                    sb.append('\n');
                    if (line.contains("ARMv5") && android.ext.h0.e(str2) > iE2) {
                        try {
                            android.ext.i.f999a = java.lang.Float.parseFloat(str2);
                            iE2 = android.ext.h0.e(str2);
                        } catch (java.lang.NumberFormatException e2) {
                            android.ext.e1.s("Failed parse as float '" + str2 + "'", e2);
                        }
                    }
                    str = line;
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
                bytes = null;
            }
            java.net.URLConnection uRLConnectionOpenConnection = new java.net.URL(android.ext.Tools.L1(android.ext.Tools.removeNewLinesChars("kwws=22jdphjxdugldq1qhw2JJborjv2yhuvlrq1sksBv@(g)y@(v)o@(v)w@(v)d@(g)r@(v)x@(v"), java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT), str3, android.ext.k.b(), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.lang_code), java.lang.Integer.valueOf(android.ext.e0.f()), android.ext.f1.v(), android.ext.f1.x()) + android.ext.p1.d() + android.ext.ConfigListAdapter.i()).openConnection();
            if (bytes != null) {
                try {
                    uRLConnectionOpenConnection.setDoOutput(true);
                    java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(uRLConnectionOpenConnection.getOutputStream());
                    gZIPOutputStream.write(bytes);
                    gZIPOutputStream.close();
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.a(th2);
                }
            }
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(uRLConnectionOpenConnection.getInputStream()));
            sb = new java.lang.StringBuilder();
            iE = android.ext.h0.e(str3);
            iE2 = android.ext.h0.e(java.lang.Float.toString(android.ext.i.f999a));
            str = "";
            str2 = null;
            bufferedReader.close();
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("Server version: ");
            sb3.append(str4 != null ? str4 + ' ' + android.ext.h0.e(str4) : "null");
            android.ext.e1.d(sb3.toString());
            if (str4 == null || android.ext.h0.e(str4) <= iE) {
                return;
            }
            android.ext.f1.f951a = java.lang.Boolean.TRUE;
            android.ext.n2.i(new android.ext.f1$b$a(this, sb, str4));
        } catch (java.lang.Throwable th3) {
            android.ext.e1.l("checkNewVersion", th3);
        }
    }
}

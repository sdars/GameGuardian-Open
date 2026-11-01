package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$loadList extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$loadList(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        java.lang.StringBuilder sb;
        java.lang.String strV3 = null;
        java.lang.String str;
        java.io.File file = new java.io.File(varargs.E(1));
        if (file.exists()) {
            if (!file.isFile()) {
                sb = new java.lang.StringBuilder();
                sb.append("Path '");
                sb.append(file.getAbsolutePath());
                str = "' is not a file";
            } else if (!file.canRead() || this.e0.m(android.ext.Script.s3(file), true)) {
                sb = new java.lang.StringBuilder();
                sb.append("File '");
                sb.append(file.getAbsolutePath());
                sb.append("' can not be read");
                strV3 = sb.toString();
            } else {
                int iY = varargs.Y(2, 0);
                try {
                    java.io.FileInputStream fileInputStreamE = luaj.lib.d.e(file, this.e0);
                    if (fileInputStreamE == null) {
                        return luaj.LuaValue.K2("File '" + file.getAbsolutePath() + "' can not be read");
                    }
                    try {
                        android.ext.c1.c(new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStreamE)), android.ext.MainService.instance.v0.f1437f, iY | 4);
                        fileInputStreamE.close();
                        return luaj.LuaValue.f1674d;
                    } catch (java.lang.Throwable th_c_c_c) {
                        fileInputStreamE.close();
                        throw th_c_c_c;
                    }
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.l("Failed load list: " + file.getAbsolutePath() + "; " + iY, th2);
                    strV3 = android.ext.Script.V3(th2);
                }
            }
            return luaj.LuaValue.K2(strV3);
        }
        sb = new java.lang.StringBuilder();
        sb.append("File '");
        sb.append(file.getAbsolutePath());
        str = "' not found";
        sb.append(str);
        strV3 = sb.toString();
        return luaj.LuaValue.K2(strV3);
    }

    @Override // android.ext.Script$ApiFunction
    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        return (i == 2 && luaValue.h1()) ? android.ext.Script$ApiFunction.g3(writer, this.e0.g0.f375e, luaValue) : super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.loadList(string file [, int flags = 0]) -> true || string with error";
    }
}

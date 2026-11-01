package android.ext;

/* JADX INFO: loaded from: classes.dex */
final class Script$saveList extends android.ext.Script$ApiFunction {
    final /* synthetic */ android.ext.Script e0;

    Script$saveList(android.ext.Script script) {
        this.e0 = script;
    }

    @Override // android.ext.Script$ApiFunction
    protected int Y2() {
        return 2;
    }

    @Override // android.ext.Script$ApiFunction
    public luaj.Varargs c3(luaj.Varargs varargs) {
        java.lang.String strV3 = null;
        java.lang.StringBuilder sb;
        java.io.File file = new java.io.File(varargs.E(1));
        if (!file.isDirectory()) {
            if (this.e0.m(android.ext.Script.s3(file), false)) {
                sb = new java.lang.StringBuilder();
                sb.append("File '");
                sb.append(file.getAbsolutePath());
                sb.append("' can not be written");
            } else {
                int iY = varargs.Y(2, 0);
                android.ext.MainService mainService = android.ext.MainService.instance;
                try {
                    android.ext.SavedListAdapter savedListAdapter = mainService.t0;
                    int count = savedListAdapter.getCount();
                    android.ext.h2[] h2VarArr = new android.ext.h2[count];
                    for (int i = 0; i < count; i++) {
                        h2VarArr[i] = savedListAdapter.getItem(i);
                    }
                    java.io.RandomAccessFile randomAccessFileF = luaj.lib.d.f(file, this.e0);
                    if (randomAccessFileF == null) {
                        return luaj.LuaValue.K2("File '" + file.getAbsolutePath() + "' can not be written");
                    }
                    try {
                        android.ext.c1.e(new java.io.BufferedWriter(new java.io.OutputStreamWriter(new android.ext.Script$saveList$1(this, randomAccessFileF)), 65536), mainService.v0.f1437f, h2VarArr, iY);
                        try {
                            randomAccessFileF.close();
                        } catch (java.io.IOException unused) {
                        }
                        return luaj.LuaValue.f1674d;
                    } catch (java.lang.Throwable th_c_c_c) {
                        try {
                            randomAccessFileF.close();
                        } catch (java.io.IOException unused2) {
                        }
                        throw th_c_c_c;
                    }
                } catch (java.lang.Throwable th2) {
                    android.ext.e1.l("Failed saved list: " + file.getAbsolutePath() + "; " + iY, th2);
                    strV3 = android.ext.Script.V3(th2);
                }
            }
            return luaj.LuaValue.K2(strV3);
        }
        sb = new java.lang.StringBuilder();
        sb.append("Path '");
        sb.append(file.getAbsolutePath());
        sb.append("' is a directory");
        strV3 = sb.toString();
        return luaj.LuaValue.K2(strV3);
    }

    @Override // android.ext.Script$ApiFunction
    protected boolean d3(java.io.Writer writer, int i, luaj.LuaValue luaValue) {
        return (i == 2 && luaValue.h1()) ? android.ext.Script$ApiFunction.g3(writer, this.e0.g0.f376f, luaValue) : super.d3(writer, i, luaValue);
    }

    @Override // android.ext.Script$ApiFunction
    java.lang.String k3() {
        return "gg.saveList(string file [, int flags = 0]) -> true || string with error";
    }
}

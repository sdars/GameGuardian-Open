package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class PackageLib$searchpath extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.PackageLib T;

    public PackageLib$searchpath(luaj.lib.PackageLib packageLib) {
        this.T = packageLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.String strE = varargs.E(1);
        java.lang.String strE2 = varargs.E(2);
        java.lang.String strZ = varargs.Z(3, ".");
        java.lang.String strZ2 = varargs.Z(4, luaj.lib.PackageLib.h0);
        int length = strE2.length();
        int i = -1;
        java.lang.StringBuffer stringBuffer = null;
        if (strZ.length() > 0) {
            strE = strE.replace(strZ, strZ2);
        }
        while (i < length) {
            int i2 = i + 1;
            int iIndexOf = strE2.indexOf(59, i2);
            if (iIndexOf < 0) {
                iIndexOf = strE2.length();
            }
            java.lang.String strReplace = strE2.substring(i2, iIndexOf).replace("?", strE);
            java.io.InputStream inputStreamU = this.T.T.e0.u(strReplace);
            if (inputStreamU != null) {
                try {
                    inputStreamU.close();
                } catch (java.io.IOException unused) {
                }
                return luaj.LuaValue.K2(strReplace);
            }
            if (stringBuffer == null) {
                stringBuffer = new java.lang.StringBuffer();
            }
            stringBuffer.append("\n\t" + strReplace);
            i = iIndexOf;
        }
        return luaj.LuaValue.N2(luaj.LuaValue.f1673c, luaj.LuaValue.K2(stringBuffer.toString()));
    }
}

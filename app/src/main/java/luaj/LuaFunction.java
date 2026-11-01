package luaj;

/* JADX INFO: loaded from: classes.dex */
public abstract class LuaFunction extends luaj.LuaValue {
    public static luaj.LuaValue P;
    private static final java.lang.String Q = android.ext.Script.class.getName();

    public static java.lang.String U2(java.lang.String str) {
        java.lang.String str2;
        int iLastIndexOf = str.lastIndexOf(36);
        int iLastIndexOf2 = str.lastIndexOf(46);
        int iMax = java.lang.Math.max(iLastIndexOf2, iLastIndexOf);
        int i = iMax + 1;
        if (str.charAt(i) == '_') {
            i = iMax + 2;
        }
        java.lang.String strSubstring = str.substring(i);
        if (str.startsWith(Q)) {
            str2 = "gg.";
        } else if (iLastIndexOf <= iLastIndexOf2 || !str.contains("Lib$") || str.contains("BaseLib$")) {
            str2 = null;
        } else {
            str2 = str.substring(iLastIndexOf2 + 1, iLastIndexOf - 3).toLowerCase(java.util.Locale.ENGLISH) + '.';
        }
        if (str2 == null) {
            return strSubstring;
        }
        return str2 + strSubstring;
    }

    @Override // luaj.LuaValue
    public int C2() {
        return 6;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        return "function";
    }

    @Override // luaj.LuaValue
    public luaj.LuaFunction G1(luaj.LuaFunction luaFunction) {
        return this;
    }

    public java.lang.String S2() {
        return U2(getClass().getName());
    }

    public java.lang.String T2() {
        return S2();
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue V0() {
        return P;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return "function: " + S2();
    }

    @Override // luaj.LuaValue
    public boolean g1() {
        return true;
    }

    @Override // luaj.LuaValue
    public luaj.LuaString q2() {
        return luaj.LuaValue.K2(g0());
    }

    @Override // luaj.LuaValue
    public luaj.LuaFunction y0() {
        return this;
    }
}

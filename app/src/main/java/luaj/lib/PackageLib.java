package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class PackageLib extends luaj.lib.TwoArgFunction {
    public static final java.lang.String Z;
    static final luaj.LuaString a0;
    private static final luaj.LuaString b0;
    static final luaj.LuaString c0;
    static final luaj.LuaString d0;
    static final luaj.LuaString e0;
    static final luaj.LuaString f0;
    static final luaj.LuaString g0;
    static final java.lang.String h0;
    luaj.Globals T;
    luaj.LuaTable U;
    public luaj.lib.PackageLib$preload_searcher V;
    public luaj.lib.PackageLib$lua_searcher W;
    public luaj.lib.PackageLib$java_searcher X;
    private volatile java.lang.String[] Y = new java.lang.String[0];

    static {
        java.lang.String property;
        try {
            property = java.lang.System.getProperty("luaj.package.path");
        } catch (java.lang.Exception e2) {
            java.lang.System.out.println(e2.toString());
            property = null;
        }
        if (property == null) {
            property = "?.lua";
        }
        Z = property;
        a0 = luaj.LuaValue.K2("loaded");
        b0 = luaj.LuaValue.K2("loadlib");
        c0 = luaj.LuaValue.K2("preload");
        d0 = luaj.LuaValue.K2("path");
        e0 = luaj.LuaValue.K2("searchpath");
        f0 = luaj.LuaValue.K2("searchers");
        g0 = luaj.LuaValue.K2("\u0001");
        h0 = java.lang.System.getProperty("file.separator");
    }

    private static final boolean Y2(char c2) {
        return (c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z') || ((c2 >= '0' && c2 <= '9') || c2 == '$' || c2 == '.' || c2 == '_');
    }

    boolean Z2(java.lang.String str) {
        for (java.lang.String str2 : this.Y) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public static final java.lang.String a3(java.lang.String str) {
        int length = str.length();
        int i = str.endsWith(".lua") ? length - 4 : length;
        for (int i2 = 0; i2 < i; i2++) {
            char cCharAt = str.charAt(i2);
            if (!Y2(cCharAt) || cCharAt == '/' || cCharAt == '\\') {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(i);
                for (int i3 = 0; i3 < i; i3++) {
                    char cCharAt2 = str.charAt(i3);
                    if (!Y2(cCharAt2)) {
                        cCharAt2 = (cCharAt2 == '/' || cCharAt2 == '\\') ? '.' : '_';
                    }
                    stringBuffer.append(cCharAt2);
                }
                return stringBuffer.toString();
            }
        }
        return length == i ? str : str.substring(0, i);
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.Globals globalsZ0 = luaValue2.z0();
        this.T = globalsZ0;
        globalsZ0.i2("require", new luaj.lib.PackageLib$require(this));
        luaj.LuaTable luaTable = new luaj.LuaTable();
        this.U = luaTable;
        luaj.LuaString luaString = a0;
        luaTable.j2(luaString, new luaj.LuaTable());
        this.U.j2(c0, new luaj.LuaTable());
        this.U.j2(d0, luaj.LuaValue.K2(Z));
        this.U.j2(b0, new luaj.lib.PackageLib$loadlib());
        this.U.j2(e0, new luaj.lib.PackageLib$searchpath(this));
        luaj.LuaValue luaTable2 = new luaj.LuaTable();
        luaj.lib.PackageLib$preload_searcher packageLib$preload_searcher = new luaj.lib.PackageLib$preload_searcher(this);
        this.V = packageLib$preload_searcher;
        luaTable2.e2(1, packageLib$preload_searcher);
        luaj.lib.PackageLib$lua_searcher packageLib$lua_searcher = new luaj.lib.PackageLib$lua_searcher(this);
        this.W = packageLib$lua_searcher;
        luaTable2.e2(2, packageLib$lua_searcher);
        luaj.lib.PackageLib$java_searcher packageLib$java_searcher = new luaj.lib.PackageLib$java_searcher(this);
        this.X = packageLib$java_searcher;
        luaTable2.e2(3, packageLib$java_searcher);
        this.U.j2(f0, luaTable2);
        this.U.h2("config", h0 + "\n;\n?\n!\n-\n");
        this.U.U0(luaString).i2("package", this.U);
        luaValue2.i2("package", this.U);
        this.T.h0 = this;
        return luaValue2;
    }

    @Override // luaj.lib.LibFunction, luaj.LuaFunction, luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return "package";
    }
}

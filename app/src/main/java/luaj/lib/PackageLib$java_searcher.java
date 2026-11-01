package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class PackageLib$java_searcher extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.PackageLib T;

    public PackageLib$java_searcher(luaj.lib.PackageLib packageLib) {
        this.T = packageLib;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        java.lang.String string;
        java.lang.StringBuilder sb = null;
        java.lang.String strA3 = luaj.lib.PackageLib.a3(varargs.E(1));
        if (this.T.Z2(strA3)) {
            try {
                luaj.LuaValue luaValue = (luaj.LuaValue) java.lang.Class.forName(strA3, false, luaj.lib.PackageLib.class.getClassLoader()).asSubclass(luaj.LuaValue.class).newInstance();
                if (luaValue.g1()) {
                    ((luaj.LuaFunction) luaValue).c1(this.T.T);
                }
                return luaj.LuaValue.N2(luaValue, this.T.T);
            } catch (java.lang.ClassNotFoundException unused) {
                sb = new java.lang.StringBuilder();
                sb.append("\n\tno class '");
                sb.append(strA3);
                sb.append('\'');
            } catch (java.lang.Exception e2) {
                string = "\n\tjava load failed on '" + strA3 + "', " + e2;
            }
        } else {
            sb = new java.lang.StringBuilder();
            sb.append("\n\tjava class '");
            sb.append(strA3);
            sb.append("' not allowed");
        }
        string = sb.toString();
        return luaj.LuaValue.K2(string);
    }
}

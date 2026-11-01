package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class PackageLib$require extends luaj.lib.OneArgFunction {
    final /* synthetic */ luaj.lib.PackageLib T;

    public PackageLib$require(luaj.lib.PackageLib packageLib) {
        this.T = packageLib;
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        luaj.LuaValue luaValueV;
        java.lang.String str;
        luaj.Varargs varargsInvoke;
        luaj.LuaString luaStringG0 = luaValue.G0();
        luaj.LuaValue luaValueU0 = this.T.U.U0(luaj.lib.PackageLib.a0);
        luaj.LuaValue luaValueU1 = luaValueU0.U0(luaStringG0);
        if (luaValueU1.w2()) {
            if (luaValueU1 == luaj.lib.PackageLib.g0) {
                luaj.LuaValue.R0("loop or previous error loading module '" + luaStringG0 + '\'');
            }
            return luaValueU1;
        }
        luaj.LuaValue luaValueU2 = this.T.U.U0(luaj.lib.PackageLib.f0);
        if (!luaValueU2.o1()) {
            luaj.LuaValue.R0("'package.searchers' must be a table");
        }
        luaj.LuaTable luaTableH0 = luaValueU2.H0();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        int i = 1;
        while (true) {
            luaValueV = null;
            try {
                luaj.LuaValue luaValueC3 = luaTableH0.c3(i);
                if (luaValueC3.l1()) {
                    luaj.LuaValue.R0("module '" + luaStringG0 + "' not found: " + luaStringG0 + ((java.lang.Object) stringBuffer));
                }
                varargsInvoke = luaValueC3.invoke(luaStringG0);
                if (varargsInvoke.P(1)) {
                    break;
                }
                if (varargsInvoke.S(1)) {
                    stringBuffer.append(varargsInvoke.h0(1));
                }
                i++;
            } catch (java.lang.Exception e2_c_c_c) {
                if (e2_c_c_c instanceof luaj.d) {
                    luaj.d dVar = (luaj.d) e2_c_c_c;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("error loading module '");
                    sb.append(luaStringG0);
                    sb.append("'");
                    if (luaValueV == null) {
                        str = "";
                    } else {
                        str = " from file '" + luaValueV + "'";
                    }
                    sb.append(str);
                    sb.append(":\n");
                    dVar.i = sb.toString();
                }
                throw e2_c_c_c;
            }
        }
        luaj.LuaString luaString = luaj.lib.PackageLib.g0;
        luaValueU0.j2(luaStringG0, luaString);
        luaValueV = varargsInvoke.v(2);
        luaj.LuaValue luaValueCall = varargsInvoke.w().call(luaStringG0, luaValueV);
        if (luaValueCall.l1()) {
            luaValueCall = luaValueU0.U0(luaStringG0);
            if (luaValueCall == luaString) {
                luaValueCall = luaj.LuaValue.f1674d;
                luaValueU0.j2(luaStringG0, luaValueCall);
            }
        } else {
            luaValueU0.j2(luaStringG0, luaValueCall);
        }
        return luaValueCall;
    }
}

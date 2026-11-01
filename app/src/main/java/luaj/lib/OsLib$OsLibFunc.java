package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class OsLib$OsLibFunc extends luaj.lib.VarArgFunction {
    final /* synthetic */ luaj.lib.OsLib T;

    public OsLib$OsLibFunc(luaj.lib.OsLib osLib, int i, java.lang.String str) {
        this.T = osLib;
        this.R = i;
        this.S = str;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        try {
            switch (this.R) {
                case 0:
                    return luaj.LuaValue.J2(this.T.g3());
                case 1:
                    java.lang.String strZ = varargs.Z(1, "%c");
                    long jI0 = varargs.R(2) ? varargs.i0(2) : this.T.u3(null);
                    if (jI0 == -1) {
                        jI0 = this.T.u3(null);
                    }
                    if (jI0 > 9223372036854775L || jI0 < -9223372036854775L) {
                        throw new luaj.d("time result cannot be represented in this installation");
                    }
                    java.util.Calendar calendar = java.util.Calendar.getInstance(strZ.startsWith("!") ? java.util.TimeZone.getTimeZone("UTC") : java.util.TimeZone.getDefault());
                    calendar.setTimeInMillis(jI0 * 1000);
                    if (strZ.startsWith("!")) {
                        strZ = strZ.substring(1);
                    }
                    if (!strZ.equals("*t")) {
                        return luaj.LuaValue.K2(this.T.h3(strZ, calendar));
                    }
                    luaj.LuaTable luaTableS2 = luaj.LuaValue.s2();
                    this.T.l3(luaTableS2, calendar);
                    return luaTableS2;
                case 2:
                    return luaj.LuaValue.J2(this.T.i3(varargs.B(1), varargs.B(2)));
                case 3:
                    return this.T.j3(varargs.Z(1, null));
                case 4:
                    this.T.k3(varargs.Y(1, 0));
                    return luaj.LuaValue.f1676f;
                case 5:
                    java.lang.String strM3 = this.T.m3(varargs.E(1));
                    return strM3 != null ? luaj.LuaValue.K2(strM3) : luaj.LuaValue.f1673c;
                case 6:
                    this.T.r3(varargs.E(1));
                    return luaj.LuaValue.f1674d;
                case 7:
                    this.T.s3(varargs.E(1), varargs.E(2));
                    return luaj.LuaValue.f1674d;
                case 8:
                    java.lang.String strT3 = this.T.t3(varargs.Z(1, null), varargs.Z(2, "all"));
                    return strT3 != null ? luaj.LuaValue.K2(strT3) : luaj.LuaValue.f1673c;
                case 9:
                    return luaj.LuaValue.I2(this.T.u3(varargs.c0(1, null)));
                case 10:
                    return luaj.LuaValue.K2(this.T.v3());
                default:
                    return luaj.LuaValue.f1676f;
            }
        } catch (java.io.IOException e2) {
            return luaj.LuaValue.M2(luaj.LuaValue.f1673c, luaj.LuaValue.K2(e2.getMessage()), luaj.LuaValue.I2(this.R));
        }
    }
}

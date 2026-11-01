package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class MathLib extends luaj.lib.TwoArgFunction {
    static double X2(luaj.lib.LibFunction libFunction, int i, luaj.LuaValue luaValue) {
        try {
            return luaValue.x0();
        } catch (luaj.d e2) {
            luaj.LuaValue.l0(i, Z2(libFunction), e2.getMessage());
            return 0.0d;
        }
    }

    static long Y2(luaj.lib.LibFunction libFunction, int i, luaj.LuaValue luaValue) {
        try {
            return luaValue.C0();
        } catch (luaj.d e2) {
            luaj.LuaValue.l0(i, Z2(libFunction), e2.getMessage());
            return 0L;
        }
    }

    static java.lang.String Z2(luaj.lib.LibFunction libFunction) {
        return libFunction.getClass().getName().replace(luaj.lib.MathLib.class.getName() + '$', "math.");
    }

    static double a3(luaj.lib.LibFunction libFunction, int i, luaj.LuaValue luaValue, double d2) {
        try {
            return luaValue.F1(d2);
        } catch (luaj.d e2) {
            luaj.LuaValue.l0(i, Z2(libFunction), e2.getMessage());
            return 0.0d;
        }
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaValue luaTable = new luaj.LuaTable(0, 64);
        luaTable.i2("abs", new luaj.lib.MathLib$abs());
        luaTable.i2("acos", new luaj.lib.MathLib$acos());
        luaTable.i2("asin", new luaj.lib.MathLib$asin());
        luaj.LuaValue mathLib$atan2 = new luaj.lib.MathLib$atan2();
        luaTable.i2("atan", mathLib$atan2);
        luaTable.i2("atan2", mathLib$atan2);
        luaTable.i2("ceil", new luaj.lib.MathLib$ceil());
        luaTable.i2("cos", new luaj.lib.MathLib$cos());
        luaTable.i2("cosh", new luaj.lib.MathLib$cosh());
        luaTable.i2("deg", new luaj.lib.MathLib$deg());
        luaTable.i2("exp", new luaj.lib.MathLib$exp());
        luaTable.i2("floor", new luaj.lib.MathLib$floor());
        luaTable.i2("fmod", new luaj.lib.MathLib$fmod());
        luaTable.i2("frexp", new luaj.lib.MathLib$frexp());
        luaTable.i2("huge", luaj.LuaDouble.S);
        luaTable.i2("ldexp", new luaj.lib.MathLib$ldexp());
        luaTable.i2("log", new luaj.lib.MathLib$log());
        luaTable.i2("max", new luaj.lib.MathLib$max());
        luaTable.i2("maxinteger", luaj.LuaLong.R);
        luaTable.i2("min", new luaj.lib.MathLib$min());
        luaTable.i2("mininteger", luaj.LuaLong.S);
        luaTable.i2("modf", new luaj.lib.MathLib$modf());
        luaTable.f2("pi", 3.141592653589793d);
        luaTable.i2("pow", new luaj.lib.MathLib$pow());
        luaj.lib.MathLib$random mathLib$random = new luaj.lib.MathLib$random();
        luaTable.i2("random", mathLib$random);
        luaTable.i2("randomseed", new luaj.lib.MathLib$randomseed(mathLib$random));
        luaTable.i2("rad", new luaj.lib.MathLib$rad());
        luaTable.i2("sin", new luaj.lib.MathLib$sin());
        luaTable.i2("sinh", new luaj.lib.MathLib$sinh());
        luaTable.i2("sqrt", new luaj.lib.MathLib$sqrt());
        luaTable.i2("tan", new luaj.lib.MathLib$tan());
        luaTable.i2("tanh", new luaj.lib.MathLib$tanh());
        luaTable.i2("tointeger", new luaj.lib.MathLib$tointeger());
        luaTable.i2("type", new luaj.lib.MathLib$type());
        luaTable.i2("ult", new luaj.lib.MathLib$ult());
        luaValue2.i2("math", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("math", luaTable);
        }
        return luaTable;
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class Bit32Lib extends luaj.lib.TwoArgFunction {
    static luaj.LuaValue X2(int i, int i2) {
        return Z2(i2 >= 0 ? i >> i2 : i << (-i2));
    }

    static luaj.Varargs Y2(luaj.Varargs varargs) {
        int iF = -1;
        for (int i = 1; i <= varargs.U(); i++) {
            iF &= (int) varargs.F(i);
        }
        return Z2(iF);
    }

    private static luaj.LuaValue Z2(int i) {
        long j = i;
        if (i < 0) {
            j &= 4294967295L;
        }
        return luaj.LuaValue.I2(j);
    }

    static luaj.Varargs a3(luaj.Varargs varargs) {
        return Z2(~((int) varargs.F(1)));
    }

    static luaj.Varargs b3(luaj.Varargs varargs) {
        int iF = 0;
        for (int i = 1; i <= varargs.U(); i++) {
            iF |= (int) varargs.F(i);
        }
        return Z2(iF);
    }

    static luaj.Varargs c3(luaj.Varargs varargs) {
        int iF = -1;
        for (int i = 1; i <= varargs.U(); i++) {
            iF &= (int) varargs.F(i);
        }
        return luaj.LuaValue.H2(iF != 0);
    }

    static luaj.Varargs d3(luaj.Varargs varargs) {
        int iF = 0;
        for (int i = 1; i <= varargs.U(); i++) {
            iF ^= (int) varargs.F(i);
        }
        return Z2(iF);
    }

    static luaj.LuaValue e3(int i, int i2, int i3) {
        if (i2 < 0) {
            luaj.LuaValue.k0(2, "field cannot be negative");
        }
        if (i3 < 0) {
            luaj.LuaValue.k0(3, "width must be postive");
        }
        if (i2 + i3 > 32) {
            luaj.LuaValue.R0("trying to access non-existent bits");
        }
        return Z2((i >>> i2) & ((-1) >>> (32 - i3)));
    }

    static luaj.LuaValue f3(int i, int i2) {
        if (i2 < 0) {
            return i3(i, -i2);
        }
        int i3 = i2 & 31;
        return Z2((i >>> (32 - i3)) | (i << i3));
    }

    static luaj.LuaValue g3(int i, int i2) {
        if (i2 >= 32 || i2 <= -32) {
            return luaj.LuaValue.f1677g;
        }
        return Z2(i2 >= 0 ? i << i2 : i >>> (-i2));
    }

    static luaj.LuaValue h3(int i, int i2, int i3, int i4) {
        if (i3 < 0) {
            luaj.LuaValue.k0(3, "field cannot be negative");
        }
        if (i4 < 0) {
            luaj.LuaValue.k0(4, "width must be postive");
        }
        if (i3 + i4 > 32) {
            luaj.LuaValue.R0("trying to access non-existent bits");
        }
        int i5 = ((-1) >>> (32 - i4)) << i3;
        return Z2((i & (~i5)) | ((i2 << i3) & i5));
    }

    static luaj.LuaValue i3(int i, int i2) {
        if (i2 < 0) {
            return f3(i, -i2);
        }
        int i3 = i2 & 31;
        return Z2((i << (32 - i3)) | (i >>> i3));
    }

    static luaj.LuaValue j3(int i, int i2) {
        if (i2 >= 32 || i2 <= -32) {
            return luaj.LuaValue.f1677g;
        }
        return Z2(i2 >= 0 ? i >>> i2 : i << (-i2));
    }

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaTable luaTable = new luaj.LuaTable();
        V2(luaTable, new luaj.lib.Bit32Lib$a(this), new java.lang.String[]{"band", "bnot", "bor", "btest", "bxor", "extract", "replace"});
        V2(luaTable, new luaj.lib.Bit32Lib$b(this), new java.lang.String[]{"arshift", "lrotate", "lshift", "rrotate", "rshift"});
        luaValue2.i2("bit32", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("bit32", luaTable);
        }
        return luaTable;
    }
}

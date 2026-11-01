package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class TableLib$move extends luaj.lib.VarArgFunction {
    TableLib$move() {
    }

    private static long X2(long j, long j2) {
        long j3 = j - j2;
        if (((j ^ j3) & (j2 ^ j)) < 0) {
            return Long.MAX_VALUE;
        }
        return j3;
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        luaj.LuaTable luaTableI = varargs.I(1);
        long jF = varargs.F(2);
        long jF2 = varargs.F(3);
        long jF3 = varargs.F(4);
        luaj.LuaTable luaTableC0 = varargs.c0(5, luaTableI);
        if (jF <= jF2) {
            long jX2 = X2(jF2, jF);
            if (jX2 > 16777214) {
                throw new luaj.d("too many elements to move: " + jX2 + " (max is 16777215)");
            }
            if (jF3 > 0 && jX2 > Long.MAX_VALUE - jF3) {
                throw new luaj.d("move: destination wrap around");
            }
            boolean z = ((long) ((int) jF)) == jF && ((long) ((int) jF2)) == jF2;
            if (luaTableI != luaTableC0) {
                for (long j = jF; j <= jF2; j++) {
                    luaTableC0.j2(luaj.LuaLong.I2((j - jF) + jF3), z ? luaTableI.c3((int) j) : luaTableI.U0(luaj.LuaLong.I2(j)));
                    if (j == jF2) {
                        break;
                    }
                }
            } else if (jF3 <= jF || jF2 < jF3) {
                for (long j2 = jF; j2 <= jF2; j2++) {
                    luaTableC0.j2(luaj.LuaLong.I2((j2 - jF) + jF3), z ? luaTableI.c3((int) j2) : luaTableI.U0(luaj.LuaLong.I2(j2)));
                    if (j2 == jF2) {
                        break;
                    }
                }
            } else {
                while (jF2 >= jF) {
                    luaTableC0.j2(luaj.LuaLong.I2((jF2 - jF) + jF3), z ? luaTableI.c3((int) jF2) : luaTableI.U0(luaj.LuaLong.I2(jF2)));
                    if (jF2 == jF) {
                        break;
                    }
                    jF2--;
                }
            }
        }
        return luaTableC0;
    }
}

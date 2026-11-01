package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class TableLib extends luaj.lib.TwoArgFunction {
    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        luaj.LuaTable luaTable = new luaj.LuaTable();
        luaTable.i2("concat", new luaj.lib.TableLib$concat());
        luaTable.i2("insert", new luaj.lib.TableLib$insert());
        luaTable.i2("move", new luaj.lib.TableLib$move());
        luaTable.i2("pack", new luaj.lib.TableLib$pack());
        luaTable.i2("remove", new luaj.lib.TableLib$remove());
        luaTable.i2("sort", new luaj.lib.TableLib$sort());
        luaTable.i2("unpack", new luaj.lib.TableLib$unpack());
        luaValue2.i2("table", luaTable);
        if (!luaValue2.T0("package").l1()) {
            luaValue2.T0("package").T0("loaded").i2("table", luaTable);
        }
        return luaj.LuaValue.f1673c;
    }
}

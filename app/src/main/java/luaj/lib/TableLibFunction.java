package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
abstract class TableLibFunction extends luaj.lib.LibFunction {
    TableLibFunction() {
    }

    @Override // luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call() {
        return luaj.LuaValue.k0(1, "table expected, got no value");
    }
}

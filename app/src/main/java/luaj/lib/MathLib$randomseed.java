package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class MathLib$randomseed extends luaj.lib.OneArgFunction {
    final luaj.lib.MathLib$random T;

    MathLib$randomseed(luaj.lib.MathLib$random mathLib$random) {
        this.T = mathLib$random;
    }

    @Override // luaj.lib.OneArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue) {
        long jY2 = luaj.lib.MathLib.Y2(this, 1, luaValue);
        this.T.T = new java.util.Random(jY2);
        return luaj.LuaValue.f1676f;
    }
}

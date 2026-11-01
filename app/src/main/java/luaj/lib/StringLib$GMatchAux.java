package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class StringLib$GMatchAux extends luaj.lib.VarArgFunction {
    private final int T;
    private final luaj.lib.StringLib$b U;
    private int V = 0;
    private int W = -1;

    public StringLib$GMatchAux(luaj.Varargs varargs, luaj.LuaString luaString, luaj.LuaString luaString2) {
        this.T = luaString.s1();
        this.U = new luaj.lib.StringLib$b(varargs, luaString, luaString2);
    }

    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        while (this.V <= this.T) {
            this.U.p();
            int iG = this.U.g(this.V, 0);
            if (iG >= 0 && iG != this.W) {
                int i = this.V;
                this.V = iG;
                this.W = iG;
                return this.U.n(true, i, iG);
            }
            this.V++;
        }
        return luaj.LuaValue.f1673c;
    }
}

package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public abstract class LibFunction extends luaj.LuaFunction {
    protected int R;
    protected java.lang.String S;

    protected LibFunction() {
    }

    protected void V2(luaj.LuaValue luaValue, luaj.lib.LibFunction$a libFunction$a, java.lang.String[] strArr) {
        W2(luaValue, libFunction$a, strArr, 0);
    }

    protected void W2(luaj.LuaValue luaValue, luaj.lib.LibFunction$a libFunction$a, java.lang.String[] strArr, int i) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            luaj.lib.LibFunction libFunctionA = libFunction$a.a();
            libFunctionA.R = i + i2;
            java.lang.String str = strArr[i2];
            libFunctionA.S = str;
            luaValue.i2(str, libFunctionA);
        }
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue call() {
        return luaj.LuaValue.k0(1, "value expected");
    }

    @Override // luaj.LuaValue
    public abstract luaj.LuaValue call(luaj.LuaValue luaValue);

    @Override // luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        return call(luaValue);
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3) {
        return call(luaValue, luaValue2);
    }

    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2, luaj.LuaValue luaValue3, luaj.LuaValue luaValue4) {
        return call(luaValue, luaValue2, luaValue3);
    }

    @Override // luaj.LuaFunction, luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        if (this.S == null) {
            return super.g0();
        }
        return "function: " + this.S;
    }

    @Override // luaj.LuaValue
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        int iU = varargs.U();
        if (iU == 0) {
            return call();
        }
        if (iU == 1) {
            return call(varargs.w());
        }
        if (iU != 2) {
            return iU != 3 ? call(varargs.w(), varargs.v(2), varargs.v(3), varargs.v(4)) : call(varargs.w(), varargs.v(2), varargs.v(3));
        }
        return call(varargs.w(), varargs.v(2));
    }
}

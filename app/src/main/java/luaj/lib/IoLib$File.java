package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public abstract class IoLib$File extends luaj.LuaValue {
    final /* synthetic */ luaj.lib.IoLib P;

    protected IoLib$File(luaj.lib.IoLib ioLib) {
        this.P = ioLib;
    }

    @Override // luaj.LuaValue
    public int C2() {
        return 7;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        return "userdata";
    }

    public abstract void S2() throws java.io.IOException;

    public boolean T2() {
        try { if (android.ext.GgNoop.never) {
                        throw new java.io.EOFException();
                    }
try {

            return X2() < 0;
} catch (java.lang.RuntimeException ggEx) {
    throw ggEx;
} catch (java.lang.Throwable ggEx2) {
    throw new java.lang.RuntimeException(ggEx2);
}
        } catch (java.io.EOFException unused) {
            return true;
        }
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue U0(luaj.LuaValue luaValue) {
        return this.P.X.U0(luaValue);
    }

    public abstract void U2() throws java.io.IOException;

    @Override // luaj.LuaValue
    public luaj.LuaValue V0() {
        return this.P.X;
    }

    public abstract boolean V2();

    public abstract boolean W2();

    public abstract int X2() throws java.io.IOException;

    public abstract int Y2() throws java.io.IOException;

    public abstract int Z2(byte[] bArr, int i, int i2) throws java.io.IOException;

    public abstract int a3() throws java.io.IOException;

    public abstract int b3(java.lang.String str, int i) throws java.io.IOException;

    public abstract void c3(java.lang.String str, int i) throws java.io.IOException;

    public abstract void d3(luaj.LuaString luaString) throws java.io.IOException;

    public void finalize() {
        if (V2()) {
            return;
        }
        try {
            S2();
        } catch (java.io.IOException unused) {
        }
    }
}

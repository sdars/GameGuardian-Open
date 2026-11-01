package luaj;

/* JADX INFO: loaded from: classes.dex */
public abstract class Varargs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.ThreadLocal f1678a = new java.lang.ThreadLocal();

    private luaj.d y(int i, luaj.d dVar) {
        java.lang.String message = dVar.getMessage();
        if (message.startsWith("bad argument: ")) {
            message = message.substring(14);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(i <= U() ? v(i).D2() : "no value");
        sb.append(": ");
        sb.append(message);
        java.lang.String string = sb.toString();
        luaj.lib.VarArgFunction varArgFunction = (luaj.lib.VarArgFunction) f1678a.get();
        return new luaj.c(i, varArgFunction == null ? null : varArgFunction.T2(), string);
    }

    public luaj.LuaClosure A(int i) {
        try {
            return v(i).w0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public double B(int i) {
        try {
            return v(i).x0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaFunction C(int i) {
        try {
            return v(i).y0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public int D(int i) {
        try {
            return v(i).A0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public java.lang.String E(int i) {
        try {
            return v(i).B0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public long F(int i) {
        try {
            return v(i).C0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaNumber G(int i) {
        try {
            return v(i).E0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaString H(int i) {
        try {
            return v(i).G0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaTable I(int i) {
        try {
            return v(i).H0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaThread J(int i) {
        try {
            return v(i).I0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaValue K(int i) {
        return i <= U() ? v(i) : luaj.LuaValue.k0(i, "value expected");
    }

    void L(luaj.LuaValue[] luaValueArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i + i3;
            i3++;
            luaValueArr[i4] = v(i3);
        }
    }

    public luaj.Varargs M() {
        int iU = U();
        if (iU == 0) {
            return luaj.LuaValue.f1676f;
        }
        if (iU == 1) {
            return w();
        }
        if (iU == 2) {
            return new luaj.Varargs$c(w(), v(2));
        }
        luaj.LuaValue[] luaValueArr = new luaj.LuaValue[iU];
        L(luaValueArr, 0, iU);
        return new luaj.Varargs$b(luaValueArr, luaj.LuaValue.f1676f);
    }

    public luaj.Varargs N() {
        return this;
    }

    public boolean O() {
        return false;
    }

    public boolean P(int i) {
        return v(i).g1();
    }

    public boolean Q(int i) {
        return v(i).l1();
    }

    public boolean R(int i) {
        return v(i).m1();
    }

    public boolean S(int i) {
        return v(i).n1();
    }

    public boolean T(int i) {
        return v(i).p1();
    }

    public abstract int U();

    public boolean V(int i, boolean z) {
        try {
            return v(i).E1(z);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public double W(int i, double d2) {
        try {
            return v(i).F1(d2);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaFunction X(int i, luaj.LuaFunction luaFunction) {
        try {
            return v(i).G1(luaFunction);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public int Y(int i, int i2) {
        try {
            return v(i).H1(i2);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public java.lang.String Z(int i, java.lang.String str) {
        try {
            return v(i).I1(str);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public long a0(int i, long j) {
        try {
            return v(i).J1(j);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaString b0(int i, luaj.LuaString luaString) {
        try {
            return v(i).K1(luaString);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaTable c0(int i, luaj.LuaTable luaTable) {
        try {
            return v(i).L1(luaTable);
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }

    public luaj.LuaValue d0(int i, luaj.LuaValue luaValue) {
        return (i <= 0 || i > U()) ? luaValue : v(i);
    }

    public abstract luaj.Varargs e0(int i);

    public boolean f0(int i) {
        return v(i).w2();
    }

    public java.lang.String g0() {
        gg_f.a aVar = new gg_f.a();
        aVar.b("(");
        int iU = U();
        for (int i = 1; i <= iU; i++) {
            if (i > 1) {
                aVar.b(",");
            }
            aVar.b(v(i).g0());
        }
        aVar.b(")");
        return aVar.k();
    }

    public java.lang.String h0(int i) {
        return v(i).g0();
    }

    public long i0(int i) {
        return v(i).z2();
    }

    public java.lang.String toString() {
        return g0();
    }

    public abstract luaj.LuaValue v(int i);

    public abstract luaj.LuaValue w();

    public void x(boolean z, int i, java.lang.String str) {
        if (z) {
            return;
        }
        luaj.LuaValue.k0(i, str);
    }

    public boolean z(int i) {
        try {
            return v(i).v0();
        } catch (luaj.d e2) {
            throw y(i, e2);
        }
    }
}

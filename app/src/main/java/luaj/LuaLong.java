package luaj;

/* JADX INFO: loaded from: classes.dex */
public class LuaLong extends luaj.LuaNumber {
    public static final luaj.LuaLong R = new luaj.LuaLong(Long.MAX_VALUE);
    public static final luaj.LuaLong S = new luaj.LuaLong(Long.MIN_VALUE);
    private static final luaj.LuaLong[] T = new luaj.LuaLong[512];
    private static final luaj.LuaString[] U = new luaj.LuaString[512];
    private static final java.lang.String[] V = new java.lang.String[512];
    public final long Q;

    LuaLong(long j) {
        this.Q = j;
    }

    public static luaj.LuaLong I2(long j) {
        if (j > 255 || j < -256) {
            if (j == Long.MAX_VALUE) {
                return R;
            }
            return j == Long.MIN_VALUE ? S : new luaj.LuaLong(j);
        }
        luaj.LuaLong[] luaLongArr = T;
        int i = (int) (256 + j);
        luaj.LuaLong luaLong = luaLongArr[i];
        if (luaLong != null) {
            return luaLong;
        }
        luaj.LuaLong luaLong2 = new luaj.LuaLong(j);
        luaLongArr[i] = luaLong2;
        return luaLong2;
    }

    public static long S2(long j, long j2) {
        if (j2 != 0) {
            long j3 = j / j2;
            return ((j ^ j2) >= 0 || j2 * j3 == j) ? j3 : j3 - 1;
        }
        throw new luaj.d("attempt to divide by zero (as '" + j + " // " + j2 + "')");
    }

    private luaj.LuaString T2() {
        long j = this.Q;
        if (j > 255 || j < -256) {
            return luaj.LuaString.K2(U2());
        }
        luaj.LuaString[] luaStringArr = U;
        luaj.LuaString luaString = luaStringArr[(int) (j + 256)];
        if (luaString != null) {
            return luaString;
        }
        luaj.LuaString luaStringK2 = luaj.LuaString.K2(U2());
        luaStringArr[(int) (j + 256)] = luaStringK2;
        return luaStringK2;
    }

    private java.lang.String U2() {
        long j = this.Q;
        if (j > 255 || j < -256) {
            return java.lang.Long.toString(j);
        }
        java.lang.String[] strArr = V;
        java.lang.String str = strArr[(int) (j + 256)];
        if (str != null) {
            return str;
        }
        java.lang.String string = java.lang.Long.toString(j);
        strArr[(int) (256 + j)] = string;
        return string;
    }

    public static int V2(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static long W2(long j, long j2) {
        if (j2 != 0) {
            long j3 = j % j2;
            if (j3 != 0) {
                return (j2 < 0) ^ ((j3 > 0L ? 1 : (j3 == 0L ? 0 : -1)) < 0) ? j3 + j2 : j3;
            }
            return j3;
        }
        throw new luaj.d("attempt to perform 'n%0' (as '" + j + " % " + j2 + "')");
    }

    public static luaj.LuaValue X2(long j, long j2) {
        if (j2 < 0) {
            return Y2(j, -j2);
        }
        return j2 > 63 ? luaj.LuaValue.f1677g : I2(j << ((int) j2));
    }

    public static luaj.LuaValue Y2(long j, long j2) {
        if (j2 < 0) {
            return X2(j, -j2);
        }
        return j2 > 63 ? luaj.LuaValue.f1677g : I2(j >>> ((int) j2));
    }

    @Override // luaj.LuaValue
    public int A0() {
        return (int) this.Q;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue A1() {
        return I2(-this.Q);
    }

    @Override // luaj.LuaValue
    public java.lang.String B0() {
        return java.lang.String.valueOf(this.Q);
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue B2() {
        return T2();
    }

    @Override // luaj.LuaValue
    public long C0() {
        return this.Q;
    }

    @Override // luaj.LuaValue
    public double F1(double d2) {
        return this.Q;
    }

    @Override // luaj.LuaValue
    public luaj.LuaString G0() {
        return luaj.LuaValue.K2(java.lang.String.valueOf(this.Q));
    }

    @Override // luaj.LuaValue
    public int H1(int i) {
        return (int) this.Q;
    }

    @Override // luaj.LuaValue
    public java.lang.String I1(java.lang.String str) {
        return U2();
    }

    @Override // luaj.LuaValue
    public long J1(long j) {
        return this.Q;
    }

    @Override // luaj.LuaValue
    public luaj.LuaString K1(luaj.LuaString luaString) {
        return T2();
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue O0(luaj.LuaValue luaValue) {
        if (luaValue.m1()) {
            return (!luaValue.k1() || luaValue.z2() == 0) ? luaj.LuaDouble.S2(this.Q, luaValue.x2()) : I2(this.Q / luaValue.z2());
        }
        return super.O0(luaValue);
    }

    @Override // luaj.LuaValue
    public boolean P0(luaj.LuaValue luaValue) {
        if (!luaValue.m1()) {
            return super.P0(luaValue);
        }
        boolean zK1 = luaValue.k1();
        long j = this.Q;
        return !zK1 ? ((double) j) != luaValue.x2() : j != luaValue.z2();
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue Q1(luaj.LuaValue luaValue) {
        return !luaValue.m1() ? super.Q1(luaValue) : luaj.LuaValue.J2(java.lang.Math.pow(this.Q, luaValue.x2()));
    }

    @Override // luaj.LuaValue
    public boolean T1(luaj.LuaValue luaValue) {
        if (!luaValue.m1()) {
            return false;
        }
        boolean zK1 = luaValue.k1();
        long j = this.Q;
        if (zK1) {
            if (j != luaValue.z2()) {
                return false;
            }
        } else if (j != luaValue.x2()) {
            return false;
        }
        return true;
    }

    @Override // luaj.LuaValue
    public boolean X0(luaj.LuaValue luaValue) {
        if (!(luaValue instanceof luaj.LuaNumber)) {
            return super.X0(luaValue);
        }
        boolean zK1 = luaValue.k1();
        long j = this.Q;
        return !zK1 ? ((double) j) <= luaValue.x2() : j <= luaValue.z2();
    }

    @Override // luaj.LuaValue
    public boolean Y0(luaj.LuaValue luaValue) {
        if (!(luaValue instanceof luaj.LuaNumber)) {
            return super.Y0(luaValue);
        }
        boolean zK1 = luaValue.k1();
        long j = this.Q;
        return !zK1 ? ((double) j) < luaValue.x2() : j < luaValue.z2();
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue Z0(luaj.LuaValue luaValue) {
        if (luaValue.m1()) {
            return luaValue.j1() ? I2(S2(this.Q, luaValue.z2())) : luaj.LuaDouble.T2(this.Q, luaValue.x2());
        }
        return super.Z0(luaValue);
    }

    @Override // luaj.LuaValue
    public boolean equals(java.lang.Object obj) {
        return (obj instanceof luaj.LuaLong) && ((luaj.LuaLong) obj).Q == this.Q;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        return U2();
    }

    @Override // luaj.LuaValue
    public boolean h1() {
        return true;
    }

    public int hashCode() {
        return V2(this.Q);
    }

    @Override // luaj.LuaValue
    public boolean i1() {
        long j = this.Q;
        return ((long) ((int) j)) == j;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue j0(luaj.LuaValue luaValue) {
        if (luaValue.m1()) {
            return luaValue.k1() ? I2(this.Q + luaValue.z2()) : luaj.LuaValue.J2(this.Q + luaValue.x2());
        }
        return super.j0(luaValue);
    }

    @Override // luaj.LuaValue
    public boolean j1() {
        return true;
    }

    @Override // luaj.LuaValue
    public boolean k1() {
        return true;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue m2(luaj.LuaValue luaValue) {
        return !luaValue.k1() ? super.m2(luaValue) : X2(this.Q, luaValue.z2());
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue n2(luaj.LuaValue luaValue) {
        return !luaValue.k1() ? super.n2(luaValue) : Y2(this.Q, luaValue.z2());
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue o0(luaj.LuaValue luaValue) {
        return !luaValue.k1() ? super.o0(luaValue) : I2(this.Q & luaValue.z2());
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue q0() {
        return I2(~this.Q);
    }

    @Override // luaj.LuaValue
    public luaj.LuaString q2() {
        return T2();
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue r0(luaj.LuaValue luaValue) {
        return !luaValue.k1() ? super.r0(luaValue) : I2(this.Q | luaValue.z2());
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue r2(luaj.LuaValue luaValue) {
        if (luaValue.m1()) {
            return luaValue.k1() ? I2(this.Q - luaValue.z2()) : luaj.LuaValue.J2(this.Q - luaValue.x2());
        }
        return super.r2(luaValue);
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue t0(luaj.LuaValue luaValue) {
        return !luaValue.k1() ? super.t0(luaValue) : I2(this.Q ^ luaValue.z2());
    }

    @Override // luaj.LuaValue
    public boolean u1(luaj.LuaValue luaValue) {
        if (!(luaValue instanceof luaj.LuaNumber)) {
            return super.u1(luaValue);
        }
        boolean zK1 = luaValue.k1();
        long j = this.Q;
        return !zK1 ? ((double) j) >= luaValue.x2() : j >= luaValue.z2();
    }

    @Override // luaj.LuaValue
    public boolean v1(luaj.LuaValue luaValue) {
        if (!(luaValue instanceof luaj.LuaNumber)) {
            return super.v1(luaValue);
        }
        boolean zK1 = luaValue.k1();
        long j = this.Q;
        return !zK1 ? ((double) j) > luaValue.x2() : j > luaValue.z2();
    }

    @Override // luaj.LuaValue
    public double x0() {
        return this.Q;
    }

    @Override // luaj.LuaValue
    public double x2() {
        return this.Q;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue y1(luaj.LuaValue luaValue) {
        if (luaValue.m1()) {
            return luaValue.j1() ? I2(W2(this.Q, luaValue.z2())) : luaj.LuaDouble.U2(this.Q, luaValue.x2());
        }
        return super.y1(luaValue);
    }

    @Override // luaj.LuaValue
    public int y2() {
        return (int) this.Q;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue z1(luaj.LuaValue luaValue) {
        if (luaValue.m1()) {
            return luaValue.k1() ? I2(this.Q * luaValue.z2()) : luaj.LuaValue.J2(this.Q * luaValue.x2());
        }
        return super.z1(luaValue);
    }

    @Override // luaj.LuaValue
    public long z2() {
        return this.Q;
    }
}

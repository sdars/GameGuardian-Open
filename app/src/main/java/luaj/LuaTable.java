package luaj;

/* JADX INFO: loaded from: classes.dex */
public class LuaTable extends luaj.LuaValue implements luaj.e {
    private static final luaj.LuaString T = luaj.LuaValue.K2("n");
    private static final luaj.LuaTable$m[] U = new luaj.LuaTable$m[0];
    private static volatile java.util.Set V = null;
    private static volatile int W = 0;
    luaj.LuaValue[] P;
    luaj.LuaTable$m[] Q;
    protected int R;
    protected luaj.e S;

    public LuaTable() {
        this.P = luaj.LuaValue.j;
        this.Q = U;
    }

    public LuaTable(int i, int i2) {
        w3(i, i2);
    }

    public LuaTable(luaj.Varargs varargs, int i) {
        int i2 = i - 1;
        int iMax = java.lang.Math.max(varargs.U() - i2, 0);
        w3(iMax, 1);
        j2(T, luaj.LuaValue.I2(iMax));
        for (int i3 = 1; i3 <= iMax; i3++) {
            e2(i3, varargs.v(i3 + i2));
        }
    }

    public LuaTable(luaj.LuaValue[] luaValueArr, luaj.LuaValue[] luaValueArr2, luaj.Varargs varargs) {
        int length = luaValueArr != null ? luaValueArr.length : 0;
        int length2 = luaValueArr2 != null ? luaValueArr2.length : 0;
        w3((varargs != null ? varargs.U() : 0) + length2, length >> 1);
        int i = 0;
        while (i < length2) {
            int i2 = i + 1;
            Y1(i2, luaValueArr2[i]);
            i = i2;
        }
        if (varargs != null) {
            int iU = varargs.U();
            for (int i3 = 1; i3 <= iU; i3++) {
                Y1(length2 + i3, varargs.v(i3));
            }
        }
        for (int i4 = 0; i4 < length; i4 += 2) {
            int i5 = i4 + 1;
            if (!luaValueArr[i5].l1()) {
                d2(luaValueArr[i4], luaValueArr[i5]);
            }
        }
    }

    private static luaj.LuaValue[] A3(luaj.LuaValue[] luaValueArr, int i) {
        xm_A3State st = new xm_A3State();
        st.v2o = luaValueArr;
        st.v3i = i;
        return xm_A3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_A3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_A3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static luaj.LuaValue[] xm_A3_run(xm_A3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_A3_c0(st);
            }
            else {
                done = xm_A3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue[]) st.resultO;
            }
        }
    }

    private static boolean xm_A3_c0(xm_A3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v3o = new luaj.LuaValue[st.v3i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v3o, st.v1i, st.v0i);
                    case 4:
                        st.pc = 4;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_A3_handler(st.pc, t);
            if (h < 0) {
                xm_A3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_A3_ctypes = {
    };
    private static final int[] xm_A3_handlers = {
        
    };
    private static int xm_A3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_A3_handlers.length; i += 4) {
            if (pc < xm_A3_handlers[i] || pc >= xm_A3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_A3_handlers[i + 3];
            if (ti < 0 || xm_A3_ctypes[ti].isInstance(t)) {
                return xm_A3_handlers[i + 2];
            }
        }
        return -1;
    }

    private void B3(int i, int i2, luaj.LuaValue luaValue) {
        xm_B3State st = new xm_B3State();
        st.v3o = this;
        st.v4i = i;
        st.v5i = i2;
        st.v6o = luaValue;
        xm_B3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_B3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_B3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        java.lang.Object v6o;
    }

    private static void xm_B3_run(xm_B3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 20) {
                done = xm_B3_c0(st);
            }
            else {
                done = xm_B3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_B3_c0(xm_B3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = st.v4i * 2;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i > st.v5i) {
                            st.pc = 19;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        if (st.v0i >= st.v5i) {
                            st.pc = 8;
                            continue;
                        }
                    case 3:
                        st.v1i = st.v0i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = (((luaj.LuaTable) st.v3o).V2(st.v0i, st.v1i, (luaj.LuaValue) st.v6o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v2i == 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 7:
                        st.v0i = st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpI = (((luaj.LuaTable) st.v3o).V2(st.v4i, st.v0i, (luaj.LuaValue) st.v6o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v1i == 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((luaj.LuaTable) st.v3o).c3(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaTable) st.v3o).c3(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((luaj.LuaTable) st.v3o).e2(st.v4i, (luaj.LuaValue) st.v2o);
                    case 16:
                        st.pc = 16;
                        ((luaj.LuaTable) st.v3o).e2(st.v0i, (luaj.LuaValue) st.v1o);
                    case 17:
                        st.v4i = st.v0i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.pc = 0;
                        continue;
                    case 19:
                        st.pc = 19;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_B3_handler(st.pc, t);
            if (h < 0) {
                xm_B3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_B3_ctypes = {
    };
    private static final int[] xm_B3_handlers = {
        
    };
    private static int xm_B3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_B3_handlers.length; i += 4) {
            if (pc < xm_B3_handlers[i] || pc >= xm_B3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_B3_handlers[i + 3];
            if (ti < 0 || xm_B3_ctypes[ti].isInstance(t)) {
                return xm_B3_handlers[i + 2];
            }
        }
        return -1;
    }

    private luaj.LuaTable$n C3(luaj.LuaValue luaValue) {
        xm_C3State st = new xm_C3State();
        st.v2o = this;
        st.v3o = luaValue;
        return xm_C3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_C3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_C3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static luaj.LuaTable$n xm_C3_run(xm_C3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 16) {
                done = xm_C3_c0(st);
            }
            else {
                done = xm_C3_c0(st);
            }
            if (done) {
                return (luaj.LuaTable$n) st.resultO;
            }
        }
    }

    private static boolean xm_C3_c0(xm_C3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((luaj.LuaTable) st.v2o).R;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i <= 0) {
                            st.pc = 14;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v0o = ((luaj.LuaTable) st.v2o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((luaj.LuaTable) st.v2o).i3((luaj.LuaValue) st.v3o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v0o = ((java.lang.Object[]) st.v0o)[st.v1i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v0o == null) {
                            st.pc = 14;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((luaj.LuaTable$m) st.v0o).f((luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v1o == null) {
                            st.pc = 11;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((luaj.LuaTable$m) st.v0o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.pc = 6;
                        continue;
                    case 14:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_C3_handler(st.pc, t);
            if (h < 0) {
                xm_C3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_C3_ctypes = {
    };
    private static final int[] xm_C3_handlers = {
        
    };
    private static int xm_C3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_C3_handlers.length; i += 4) {
            if (pc < xm_C3_handlers[i] || pc >= xm_C3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_C3_handlers[i + 3];
            if (ti < 0 || xm_C3_ctypes[ti].isInstance(t)) {
                return xm_C3_handlers[i + 2];
            }
        }
        return -1;
    }

    private boolean U2(int i, luaj.LuaValue luaValue) {
        xm_U2State st = new xm_U2State();
        st.v3o = this;
        st.v4i = i;
        st.v5o = luaValue;
        return xm_U2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_U2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_U2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static boolean xm_U2_run(xm_U2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 19) {
                done = xm_U2_c0(st);
            }
            else {
                done = xm_U2_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_U2_c0(xm_U2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v4i <= 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 1:
                        st.pc = 1;
                        st.v0o = ((luaj.LuaTable) st.v3o).P;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v4i > st.v1i) {
                            st.pc = 17;
                            continue;
                        }
                    case 4:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.v4i = st.v4i - st.v1i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v5o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v2i == 0) {
                            st.pc = 11;
                            continue;
                        }
                    case 9:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.pc = 15;
                        continue;
                    case 11:
                        st.pc = 11;
                        st.v2o = ((luaj.LuaTable) st.v3o).S;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v2o == null) {
                            st.pc = 15;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.e) st.v2o).g((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((java.lang.Object[]) st.v0o)[st.v4i] = st.v5o;
                    case 16:
                        st.pc = 16;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 17:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_U2_handler(st.pc, t);
            if (h < 0) {
                xm_U2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_U2_ctypes = {
    };
    private static final int[] xm_U2_handlers = {
        
    };
    private static int xm_U2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_U2_handlers.length; i += 4) {
            if (pc < xm_U2_handlers[i] || pc >= xm_U2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_U2_handlers[i + 3];
            if (ti < 0 || xm_U2_ctypes[ti].isInstance(t)) {
                return xm_U2_handlers[i + 2];
            }
        }
        return -1;
    }

    private boolean V2(int i, int i2, luaj.LuaValue luaValue) {
        xm_V2State st = new xm_V2State();
        st.v0o = this;
        st.v1i = i;
        st.v2i = i2;
        st.v3o = luaValue;
        return xm_V2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_V2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_V2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
    }

    private static boolean xm_V2_run(xm_V2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 18) {
                done = xm_V2_c0(st);
            }
            else {
                done = xm_V2_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_V2_c0(xm_V2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaTable) st.v0o).c3(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((luaj.LuaTable) st.v0o).c3(st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v1o == null) {
                            st.pc = 16;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        if (st.v2o != null) {
                            st.pc = 7;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.pc = 16;
                        continue;
                    case 7:
                        st.pc = 7;
                        if (st.v3o == null) {
                            st.pc = 13;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.tmpO = ((luaj.LuaValue) st.v3o).call((luaj.LuaValue) st.v1o, (luaj.LuaValue) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpI = (((luaj.LuaValue) st.v1o).w2()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 11:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 13:
                        st.pc = 13;
                        st.tmpI = (((luaj.LuaValue) st.v1o).u1((luaj.LuaValue) st.v2o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 14:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 16:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_V2_handler(st.pc, t);
            if (h < 0) {
                xm_V2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_V2_ctypes = {
    };
    private static final int[] xm_V2_handlers = {
        
    };
    private static int xm_V2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_V2_handlers.length; i += 4) {
            if (pc < xm_V2_handlers[i] || pc >= xm_V2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_V2_handlers[i + 3];
            if (ti < 0 || xm_V2_ctypes[ti].isInstance(t)) {
                return xm_V2_handlers[i + 2];
            }
        }
        return -1;
    }

    private int X2() {
        xm_X2State st = new xm_X2State();
        st.v4o = this;
        return xm_X2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_X2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_X2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        java.lang.Object v4o;
    }

    private static int xm_X2_run(xm_X2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 17) {
                done = xm_X2_c0(st);
            }
            else {
                done = xm_X2_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_X2_c0(xm_X2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v2o = ((luaj.LuaTable) st.v4o).Q;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v3i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0i >= st.v3i) {
                            st.pc = 16;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v0i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v2o == null) {
                            st.pc = 14;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((luaj.LuaTable$m) st.v2o).l();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v3o == null) {
                            st.pc = 11;
                            continue;
                        }
                    case 10:
                        st.v1i = st.v1i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((luaj.LuaTable$m) st.v2o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.pc = 6;
                        continue;
                    case 14:
                        st.v0i = st.v0i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.pc = 2;
                        continue;
                    case 16:
                        st.pc = 16;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_X2_handler(st.pc, t);
            if (h < 0) {
                xm_X2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_X2_ctypes = {
    };
    private static final int[] xm_X2_handlers = {
        
    };
    private static int xm_X2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_X2_handlers.length; i += 4) {
            if (pc < xm_X2_handlers[i] || pc >= xm_X2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_X2_handlers[i + 3];
            if (ti < 0 || xm_X2_ctypes[ti].isInstance(t)) {
                return xm_X2_handlers[i + 2];
            }
        }
        return -1;
    }

    private int Y2(int[] iArr) {
        xm_Y2State st = new xm_Y2State();
        st.v9o = this;
        st.v10o = iArr;
        return xm_Y2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_Y2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_Y2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        java.lang.Object v9o;
        java.lang.Object v10o;
    }

    private static int xm_Y2_run(xm_Y2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 50) {
                done = xm_Y2_c0(st);
            }
            else {
                done = xm_Y2_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_Y2_c0(xm_Y2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 3:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 4:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 5:
                        st.v5i = 31;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v2i >= st.v5i) {
                            st.pc = 29;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.v5o = ((luaj.LuaTable) st.v9o).P;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v6i = java.lang.reflect.Array.getLength(st.v5o);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v3i <= st.v6i) {
                            st.pc = 11;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.pc = 29;
                        continue;
                    case 11:
                        st.pc = 11;
                        st.v5i = java.lang.reflect.Array.getLength(st.v5o);
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 12:
                        st.v6i = st.v1i << st.v2i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpI = java.lang.Math.min(st.v5i, st.v6i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 14:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 15:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 16:
                        st.pc = 16;
                        if (st.v3i > st.v5i) {
                            st.pc = 25;
                            continue;
                        }
                    case 17:
                        st.pc = 17;
                        st.v7o = ((luaj.LuaTable) st.v9o).P;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 18:
                        st.v8i = st.v3i + 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 19:
                        st.v3i = st.v3i + 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.v3o = ((java.lang.Object[]) st.v7o)[st.v3i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 21:
                        st.pc = 21;
                        if (st.v3o == null) {
                            st.pc = 23;
                            continue;
                        }
                    case 22:
                        st.v6i = st.v6i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 23:
                        st.v3i = st.v8i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.pc = 16;
                        continue;
                    case 25:
                        st.pc = 25;
                        ((int[]) st.v10o)[st.v2i] = st.v6i;
                    case 26:
                        st.v4i = st.v4i + st.v6i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 27:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.pc = 5;
                        continue;
                    case 29:
                        st.pc = 29;
                        st.v2o = ((luaj.LuaTable) st.v9o).Q;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.v3i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 31:
                        st.pc = 31;
                        if (st.v0i >= st.v3i) {
                            st.pc = 49;
                            continue;
                        }
                    case 32:
                        st.pc = 32;
                        st.v2o = ((java.lang.Object[]) st.v2o)[st.v0i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 33:
                        st.pc = 33;
                        if (st.v2o == null) {
                            st.pc = 47;
                            continue;
                        }
                    case 34:
                        st.v3i = 2147483647;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.tmpI = ((luaj.LuaTable$m) st.v2o).r(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 36:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 37:
                        st.pc = 37;
                        if (st.v3i <= 0) {
                            st.pc = 44;
                            continue;
                        }
                    case 38:
                        st.pc = 38;
                        st.tmpI = luaj.LuaTable.u3(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 39:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 40:
                        st.pc = 40;
                        st.v5i = ((int[]) st.v10o)[st.v3i];
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 41:
                        st.v5i = st.v5i + st.v1i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 42:
                        st.pc = 42;
                        ((int[]) st.v10o)[st.v3i] = st.v5i;
                    case 43:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.tmpO = ((luaj.LuaTable$m) st.v2o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 45:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.pc = 33;
                        continue;
                    case 47:
                        st.v0i = st.v0i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 48:
                        st.pc = 48;
                        st.pc = 29;
                        continue;
                    case 49:
                        st.pc = 49;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_Y2_handler(st.pc, t);
            if (h < 0) {
                xm_Y2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_Y2_ctypes = {
    };
    private static final int[] xm_Y2_handlers = {
        
    };
    private static int xm_Y2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_Y2_handlers.length; i += 4) {
            if (pc < xm_Y2_handlers[i] || pc >= xm_Y2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_Y2_handlers[i + 3];
            if (ti < 0 || xm_Y2_ctypes[ti].isInstance(t)) {
                return xm_Y2_handlers[i + 2];
            }
        }
        return -1;
    }

    protected static luaj.LuaTable$e Z2(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        xm_Z2State st = new xm_Z2State();
        st.v5o = luaValue;
        st.v6o = luaValue2;
        return xm_Z2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_Z2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_Z2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
    }

    private static luaj.LuaTable$e xm_Z2_run(xm_Z2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 46) {
                done = xm_Z2_c0(st);
            }
            else {
                done = xm_Z2_c0(st);
            }
            if (done) {
                return (luaj.LuaTable$e) st.resultO;
            }
        }
    }

    private static boolean xm_Z2_c0(xm_Z2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i == 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = ((luaj.LuaValue) st.v5o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v0o = new luaj.LuaTable$g(st.v5i, (luaj.LuaValue) st.v6o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 8:
                        st.v0i = (st.v6o instanceof luaj.LuaBoolean) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v0i == 0) {
                            st.pc = 15;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpI = (((luaj.LuaValue) st.v6o).w2()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 12:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.v0o = new luaj.LuaTable$b((luaj.LuaValue) st.v5o, (st.v6i != 0));
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 15:
                        st.v0i = (st.v6o instanceof luaj.LuaLong) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 16:
                        st.pc = 16;
                        if (st.v0i == 0) {
                            st.pc = 29;
                            continue;
                        }
                    case 17:
                        st.pc = 17;
                        st.tmpJ = ((luaj.LuaValue) st.v6o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 18:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 19:
                        st.v6i = (int) st.v0j;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 20:
                        st.v2j = st.v6i;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 21:
                        st.v4i = Long.compare(st.v2j, st.v0j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 22:
                        st.pc = 22;
                        if (st.v4i != 0) {
                            st.pc = 26;
                            continue;
                        }
                    case 23:
                        st.pc = 23;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.v0o = new luaj.LuaTable$h((luaj.LuaValue) st.v5o, st.v6i);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 26:
                        st.pc = 26;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.v6o = new luaj.LuaTable$k((luaj.LuaValue) st.v5o, st.v0j);
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.resultO = st.v6o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 29:
                        st.v0i = (st.v6o instanceof luaj.LuaDouble) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 30:
                        st.pc = 30;
                        if (st.v0i == 0) {
                            st.pc = 43;
                            continue;
                        }
                    case 31:
                        st.pc = 31;
                        st.tmpD = ((luaj.LuaValue) st.v6o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 32:
                        st.v0d = st.tmpD;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 33:
                        st.v6d = (float) st.v0d;
                        st.v6j = java.lang.Double.doubleToRawLongBits(st.v6d);
                        st.v6i = 0;
                        st.v6o = null;
                    case 34:
                        st.v2d = st.v6d;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 35:
                        st.pc = 35;
                        st.v4i = (Double.isNaN(st.v2d) || Double.isNaN(st.v0d) ? -1 : (st.v2d < st.v0d ? -1 : (st.v2d == st.v0d ? 0 : 1)));
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 36:
                        st.pc = 36;
                        if (st.v4i != 0) {
                            st.pc = 40;
                            continue;
                        }
                    case 37:
                        st.pc = 37;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.v0o = new luaj.LuaTable$f((luaj.LuaValue) st.v5o, (float) st.v6d);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 40:
                        st.pc = 40;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 41:
                        st.pc = 41;
                        st.v6o = new luaj.LuaTable$d((luaj.LuaValue) st.v5o, st.v0d);
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.resultO = st.v6o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 43:
                        st.pc = 43;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.v0o = new luaj.LuaTable$l((luaj.LuaValue) st.v5o, (luaj.LuaValue) st.v6o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 45:
                        st.pc = 45;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_Z2_handler(st.pc, t);
            if (h < 0) {
                xm_Z2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_Z2_ctypes = {
    };
    private static final int[] xm_Z2_handlers = {
        
    };
    private static int xm_Z2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_Z2_handlers.length; i += 4) {
            if (pc < xm_Z2_handlers[i] || pc >= xm_Z2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_Z2_handlers[i + 3];
            if (ti < 0 || xm_Z2_ctypes[ti].isInstance(t)) {
                return xm_Z2_handlers[i + 2];
            }
        }
        return -1;
    }

    private void a3() {
        xm_a3State st = new xm_a3State();
        st.v3o = this;
        xm_a3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_a3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_a3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
    }

    private static void xm_a3_run(xm_a3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 9) {
                done = xm_a3_c0(st);
            }
            else {
                done = xm_a3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_a3_c0(xm_a3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = ((luaj.LuaTable) st.v3o).P;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v2i = java.lang.reflect.Array.getLength(st.v1o);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i >= st.v2i) {
                            st.pc = 8;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v2o = ((luaj.LuaTable) st.v3o).S;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.e) st.v2o).o((luaj.LuaValue[]) st.v1o, st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v0i = st.v0i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.pc = 1;
                        continue;
                    case 8:
                        st.pc = 8;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_a3_handler(st.pc, t);
            if (h < 0) {
                xm_a3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_a3_ctypes = {
    };
    private static final int[] xm_a3_handlers = {
        
    };
    private static int xm_a3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_a3_handlers.length; i += 4) {
            if (pc < xm_a3_handlers[i] || pc >= xm_a3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_a3_handlers[i + 3];
            if (ti < 0 || xm_a3_ctypes[ti].isInstance(t)) {
                return xm_a3_handlers[i + 2];
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:102:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:104:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:105:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:110:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:113:0x0217  */
    /* JADX WARN: Code duplicated, block: B:114:0x021a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0223  */
    /* JADX WARN: Code duplicated, block: B:118:0x022c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0233 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:121:0x0235  */
    /* JADX WARN: Code duplicated, block: B:123:0x0238  */
    /* JADX WARN: Code duplicated, block: B:125:0x023c  */
    /* JADX WARN: Code duplicated, block: B:127:0x0240  */
    /* JADX WARN: Code duplicated, block: B:129:0x0244  */
    /* JADX WARN: Code duplicated, block: B:131:0x0248  */
    /* JADX WARN: Code duplicated, block: B:132:0x024a  */
    /* JADX WARN: Code duplicated, block: B:133:0x024d  */
    /* JADX WARN: Code duplicated, block: B:134:0x0250  */
    /* JADX WARN: Code duplicated, block: B:135:0x0253  */
    /* JADX WARN: Code duplicated, block: B:136:0x0256  */
    /* JADX WARN: Code duplicated, block: B:137:0x0259  */
    /* JADX WARN: Code duplicated, block: B:138:0x025c  */
    /* JADX WARN: Code duplicated, block: B:140:0x0260  */
    /* JADX WARN: Code duplicated, block: B:142:0x0268  */
    /* JADX WARN: Code duplicated, block: B:144:0x026f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x0271 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:146:0x0273  */
    /* JADX WARN: Code duplicated, block: B:149:0x0277  */
    /* JADX WARN: Code duplicated, block: B:150:0x027a  */
    /* JADX WARN: Code duplicated, block: B:151:0x027d  */
    /* JADX WARN: Code duplicated, block: B:152:0x0280  */
    /* JADX WARN: Code duplicated, block: B:155:0x0288  */
    /* JADX WARN: Code duplicated, block: B:157:0x0294  */
    /* JADX WARN: Code duplicated, block: B:160:0x029a  */
    /* JADX WARN: Code duplicated, block: B:163:0x02a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:166:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:168:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:169:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:171:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:81:0x017f  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d2  */
    private java.lang.Appendable b3(java.lang.String str, java.lang.Appendable appendable, java.util.Map map) {
        xm_b3State st = new xm_b3State();
        st.v27o = this;
        st.v28o = str;
        st.v29o = appendable;
        st.v30o = map;
        return xm_b3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_b3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_b3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
        int v10i;
        long v10j;
        java.lang.Object v10o;
        double v10d;
        int v11i;
        long v11j;
        java.lang.Object v11o;
        double v11d;
        int v12i;
        long v12j;
        java.lang.Object v12o;
        double v12d;
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
        int v14i;
        long v14j;
        java.lang.Object v14o;
        double v14d;
        int v15i;
        long v15j;
        java.lang.Object v15o;
        double v15d;
        int v16i;
        long v16j;
        java.lang.Object v16o;
        double v16d;
        int v17i;
        long v17j;
        java.lang.Object v17o;
        double v17d;
        int v18i;
        long v18j;
        java.lang.Object v18o;
        double v18d;
        int v19i;
        long v19j;
        java.lang.Object v19o;
        double v19d;
        int v20i;
        long v20j;
        java.lang.Object v20o;
        double v20d;
        int v21i;
        long v21j;
        java.lang.Object v21o;
        double v21d;
        int v22i;
        long v22j;
        java.lang.Object v22o;
        double v22d;
        int v23i;
        long v23j;
        java.lang.Object v23o;
        double v23d;
        int v24i;
        long v24j;
        java.lang.Object v24o;
        double v24d;
        int v25i;
        long v25j;
        java.lang.Object v25o;
        double v25d;
        int v26i;
        long v26j;
        java.lang.Object v26o;
        double v26d;
        java.lang.Object v27o;
        java.lang.Object v28o;
        java.lang.Object v29o;
        java.lang.Object v30o;
    }

    private static java.lang.Appendable xm_b3_run(xm_b3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 398) {
                done = xm_b3_c0(st);
            }
            else {
                done = xm_b3_c0(st);
            }
            if (done) {
                return (java.lang.Appendable) st.resultO;
            }
        }
    }

    private static boolean xm_b3_c0(xm_b3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v1o = st.v28o;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 1:
                        st.v2o = st.v29o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2:
                        st.v0o = st.v30o;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v3o = luaj.LuaTable.V;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 4:
                        st.v4o = st.v27o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v3o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((java.util.Set) st.v3o).add(st.v4o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v5o = "{ -- ";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpO = ((java.lang.Appendable) st.v2o).append((java.lang.CharSequence) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((luaj.LuaValue) st.v27o).E2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.Appendable) st.v2o).append((java.lang.CharSequence) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v5o = "(";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.Appendable) st.v2o).append((java.lang.CharSequence) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.pc = 14;
                        st.tmpI = ((java.lang.Object) st.v27o).hashCode();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 15:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.tmpO = java.lang.Integer.toHexString(st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((java.lang.Appendable) st.v2o).append((java.lang.CharSequence) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v5o = ")\n";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.tmpO = ((java.lang.Appendable) st.v2o).append((java.lang.CharSequence) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 21:
                        st.pc = 21;
                        st.tmpI = ((luaj.LuaTable) st.v27o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 22:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.v7i = luaj.LuaTable.W;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 24:
                        st.v7i = st.v7i + st.v6i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 25:
                        st.pc = 25;
                        luaj.LuaTable.W = st.v7i;
                    case 26:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 27:
                        st.pc = 27;
                        if (st.v6i != 0) {
                            st.pc = 30;
                            continue;
                        }
                    case 28:
                        st.v9i = 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.pc = 43;
                        continue;
                    case 30:
                        st.pc = 30;
                        st.tmpI = java.lang.Math.abs(st.v6i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 31:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 32:
                        st.v9d = (double) st.v9i;
                        st.v9j = java.lang.Double.doubleToRawLongBits(st.v9d);
                        st.v9i = 0;
                        st.v9o = null;
                    case 33:
                        st.pc = 33;
                        st.tmpD = java.lang.Math.log10(st.v9d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 34:
                        st.v9d = st.tmpD;
                        st.v9j = java.lang.Double.doubleToRawLongBits(st.v9d);
                        st.v9i = 0;
                        st.v9o = null;
                    case 35:
                        st.pc = 35;
                        st.v11j = 4607182418800017408L;
                        st.v11d = java.lang.Double.longBitsToDouble(st.v11j);
                        st.v11i = 0;
                        st.v11o = null;
                    case 36:
                        st.v9d = st.v9d + st.v11d;
                        st.v9j = java.lang.Double.doubleToRawLongBits(st.v9d);
                        st.v9i = 0;
                        st.v9o = null;
                    case 37:
                        st.pc = 37;
                        st.v13j = 4621819117588971520L;
                        st.v13d = java.lang.Double.longBitsToDouble(st.v13j);
                        st.v13i = 0;
                        st.v13o = null;
                    case 38:
                        st.pc = 38;
                        st.tmpD = java.lang.Math.min(java.lang.Double.longBitsToDouble(st.v13j), st.v9d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 39:
                        st.v9d = st.tmpD;
                        st.v9j = java.lang.Double.doubleToRawLongBits(st.v9d);
                        st.v9i = 0;
                        st.v9o = null;
                    case 40:
                        st.pc = 40;
                        st.tmpD = java.lang.Math.max(java.lang.Double.longBitsToDouble(st.v11j), st.v9d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 41:
                        st.v9d = st.tmpD;
                        st.v9j = java.lang.Double.doubleToRawLongBits(st.v9d);
                        st.v9i = 0;
                        st.v9o = null;
                    case 42:
                        st.v9i = (int) st.v9d;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 43:
                        st.pc = 43;
                        st.tmpO = ((luaj.LuaTable) st.v27o).s3();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 44:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 45:
                        st.pc = 45;
                        st.tmpI = ((java.lang.String) st.v28o).length();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 46:
                        st.v11i = st.tmpI;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 47:
                        st.pc = 47;
                        if (st.v11i <= 0) {
                            st.pc = 50;
                            continue;
                        }
                    case 48:
                        st.v11i = 1;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 49:
                        st.pc = 49;
                        st.pc = 51;
                        continue;
                    case 50:
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 51:
                        st.pc = 51;
                        st.tmpI = ((java.lang.String) st.v28o).length();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 52:
                        st.v13i = st.tmpI;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 53:
                        st.pc = 53;
                        if (st.v13i != st.v8i) {
                            st.pc = 56;
                            continue;
                        }
                    case 54:
                        st.v13i = 1;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 55:
                        st.pc = 55;
                        st.pc = 57;
                        continue;
                    case 56:
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 57:
                        st.v14i = 10000;
                        st.v14j = 0L;
                        st.v14o = null;
                        st.v14d = 0.0;
                    case 58:
                        st.pc = 58;
                        if (st.v7i >= st.v14i) {
                            st.pc = 61;
                            continue;
                        }
                    case 59:
                        st.v7i = 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 60:
                        st.pc = 60;
                        st.pc = 62;
                        continue;
                    case 61:
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 62:
                        st.v12i = 1;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 63:
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 64:
                        st.v16i = 1;
                        st.v16j = 0L;
                        st.v16o = null;
                        st.v16d = 0.0;
                    case 65:
                        st.v17i = 0;
                        st.v17j = 0L;
                        st.v17o = null;
                        st.v17d = 0.0;
                    case 66:
                        st.pc = 66;
                        st.tmpI = (((luaj.LuaTable$i) st.v10o).c()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 67:
                        st.v18i = st.tmpI;
                        st.v18j = 0L;
                        st.v18o = null;
                        st.v18d = 0.0;
                    case 68:
                        st.pc = 68;
                        if (st.v18i == 0) {
                            st.pc = 374;
                            continue;
                        }
                    case 69:
                        st.pc = 69;
                        st.tmpO = ((luaj.LuaTable$i) st.v10o).b();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 70:
                        st.v14o = st.tmpO;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 71:
                        st.pc = 71;
                        if (st.v13i == 0) {
                            st.pc = 77;
                            continue;
                        }
                    case 72:
                        st.pc = 72;
                        if (st.v0o == null) {
                            st.pc = 77;
                            continue;
                        }
                    case 73:
                        st.pc = 73;
                        st.tmpO = ((java.util.Map) st.v0o).get(st.v14o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 74:
                        st.v19o = st.tmpO;
                        st.v19i = 0;
                        st.v19j = 0L;
                        st.v19d = 0.0;
                    case 75:
                        st.pc = 75;
                        if (st.v19o != null) {
                            st.pc = 77;
                            continue;
                        }
                    case 76:
                        st.pc = 76;
                        st.pc = 66;
                        continue;
                    case 77:
                        st.pc = 77;
                        if (st.v7i == 0) {
                            st.pc = 91;
                            continue;
                        }
                    case 78:
                        st.pc = 78;
                        if (st.v16i == 0) {
                            st.pc = 91;
                            continue;
                        }
                    case 79:
                        st.pc = 79;
                        st.tmpI = (((luaj.LuaValue) st.v14o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 80:
                        st.v19i = st.tmpI;
                        st.v19j = 0L;
                        st.v19o = null;
                        st.v19d = 0.0;
                    case 81:
                        st.pc = 81;
                        if (st.v19i == 0) {
                            st.pc = 90;
                            continue;
                        }
                    case 82:
                        st.pc = 82;
                        st.tmpI = ((luaj.LuaValue) st.v14o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 83:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 84:
                        st.v20i = st.v12i + 1;
                        st.v20j = 0L;
                        st.v20o = null;
                        st.v20d = 0.0;
                    case 85:
                        st.pc = 85;
                        if (st.v8i == st.v12i) {
                            st.pc = 88;
                            continue;
                        }
                    case 86:
                        st.v12i = st.v20i;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 87:
                        st.pc = 87;
                        st.pc = 90;
                        continue;
                    case 88:
                        st.v12i = st.v20i;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 89:
                        st.pc = 89;
                        st.pc = 91;
                        continue;
                    case 90:
                        st.v16i = 0;
                        st.v16j = 0L;
                        st.v16o = null;
                        st.v16d = 0.0;
                    case 91:
                        st.pc = 91;
                        st.tmpI = (((luaj.LuaValue) st.v14o).d1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 92:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 93:
                        st.pc = 93;
                        if (st.v8i == 0) {
                            st.pc = 95;
                            continue;
                        }
                    case 94:
                        st.pc = 94;
                        st.pc = 100;
                        continue;
                    case 95:
                        st.pc = 95;
                        st.tmpO = ((luaj.LuaTable$i) st.v10o).d();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 96:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 97:
                        st.pc = 97;
                        st.tmpI = (((luaj.LuaValue) st.v8o).d1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 98:
                        st.v20i = st.tmpI;
                        st.v20j = 0L;
                        st.v20o = null;
                        st.v20d = 0.0;
                    case 99:
                        st.pc = 99;
                        if (st.v20i == 0) {
                            st.pc = 102;
                            continue;
                        }
                    case 100:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 101:
                        st.pc = 101;
                        st.pc = 66;
                        continue;
                    case 102:
                        st.pc = 102;
                        if (st.v16i == 0) {
                            st.pc = 105;
                            continue;
                        }
                    case 103:
                        st.v4o = st.v2o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 104:
                        st.pc = 104;
                        st.pc = 108;
                        continue;
                    case 105:
                        st.pc = 105;
                        st.v20o = null;
                        st.v20i = 0;
                        st.v20j = 0L;
                        st.v20d = 0.0;
                    case 106:
                        st.pc = 106;
                        st.v20o = new java.lang.StringBuilder();
                        st.v20i = 0;
                        st.v20j = 0L;
                        st.v20d = 0.0;
                    case 107:
                        st.v4o = st.v20o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 108:
                        st.pc = 108;
                        if (st.v11i == 0) {
                            st.pc = 110;
                            continue;
                        }
                    case 109:
                        st.pc = 109;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 110:
                        st.v20i = st.v7i;
                        st.v20j = 0L;
                        st.v20o = null;
                        st.v20d = 0.0;
                    case 111:
                        st.v7o = "\t[";
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 112:
                        st.pc = 112;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 113:
                        st.pc = 113;
                        st.tmpI = (((luaj.LuaValue) st.v14o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 114:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 115:
                        st.v21o = st.v10o;
                        st.v21i = 0;
                        st.v21j = 0L;
                        st.v21d = 0.0;
                    case 116:
                        st.v10o = "\\'";
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 117:
                        st.v22i = st.v13i;
                        st.v22j = 0L;
                        st.v22o = null;
                        st.v22d = 0.0;
                    case 118:
                        st.v13o = "'";
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 119:
                        st.v2o = "\t}";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 120:
                        st.v23i = st.v6i;
                        st.v23j = 0L;
                        st.v23o = null;
                        st.v23d = 0.0;
                    case 121:
                        st.v6o = "\t\t-- *** RECURSION ***\n";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 122:
                        st.v24i = st.v12i;
                        st.v24j = 0L;
                        st.v24o = null;
                        st.v24d = 0.0;
                    case 123:
                        st.v12o = "{ -- table(";
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 124:
                        st.v25o = st.v15o;
                        st.v25i = 0;
                        st.v25j = 0L;
                        st.v25d = 0.0;
                    case 125:
                        st.pc = 125;
                        if (st.v7i == 0) {
                            st.pc = 133;
                            continue;
                        }
                    case 126:
                        st.pc = 126;
                        st.tmpI = ((luaj.LuaValue) st.v14o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 127:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 128:
                        st.pc = 128;
                        st.tmpO = java.lang.Integer.toString(st.v7i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 129:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 130:
                        st.v15i = 32;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 131:
                        st.pc = 131;
                        st.tmpO = android.ext.t2.a((java.lang.Appendable) st.v4o, st.v9i, (char) st.v15i, (java.lang.String) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 132:
                        st.pc = 132;
                        st.pc = 154;
                        continue;
                    case 133:
                        st.pc = 133;
                        if (st.v3o == null) {
                            st.pc = 173;
                            continue;
                        }
                    case 134:
                        st.v7i = (st.v14o instanceof luaj.LuaTable) ? 1 : 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 135:
                        st.pc = 135;
                        if (st.v7i == 0) {
                            st.pc = 173;
                            continue;
                        }
                    case 136:
                        st.v7o = st.v14o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 137:
                        st.pc = 137;
                        st.v7o = (luaj.LuaTable) st.v7o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 138:
                        st.pc = 138;
                        st.tmpI = (((java.util.Set) st.v3o).contains(st.v7o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 139:
                        st.v15i = st.tmpI;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 140:
                        st.pc = 140;
                        if (st.v15i == 0) {
                            st.pc = 156;
                            continue;
                        }
                    case 141:
                        st.pc = 141;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v12o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 142:
                        st.pc = 142;
                        st.tmpI = ((java.lang.Object) st.v7o).hashCode();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 143:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 144:
                        st.pc = 144;
                        st.tmpO = java.lang.Integer.toHexString(st.v7i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 145:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 146:
                        st.pc = 146;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 147:
                        st.pc = 147;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 148:
                        st.pc = 148;
                        if (st.v11i == 0) {
                            st.pc = 150;
                            continue;
                        }
                    case 149:
                        st.pc = 149;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 150:
                        st.pc = 150;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 151:
                        st.pc = 151;
                        if (st.v11i == 0) {
                            st.pc = 153;
                            continue;
                        }
                    case 152:
                        st.pc = 152;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 153:
                        st.pc = 153;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 154:
                        st.v26i = st.v9i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 155:
                        st.pc = 155;
                        st.pc = 171;
                        continue;
                    case 156:
                        st.pc = 156;
                        if ((st.v17o != null || st.v17i != 0)) {
                            st.pc = 167;
                            continue;
                        }
                    case 157:
                        st.pc = 157;
                        st.v15o = null;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 158:
                        st.pc = 158;
                        st.v15o = new java.lang.StringBuilder();
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 159:
                        st.pc = 159;
                        st.tmpO = ((java.lang.StringBuilder) st.v15o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 160:
                        st.v26i = st.v9i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 161:
                        st.v9i = 9;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 162:
                        st.pc = 162;
                        st.tmpO = ((java.lang.StringBuilder) st.v15o).append((char) st.v9i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 163:
                        st.pc = 163;
                        st.tmpO = ((java.lang.StringBuilder) st.v15o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 164:
                        st.v17o = st.tmpO;
                        st.v17i = 0;
                        st.v17j = 0L;
                        st.v17d = 0.0;
                    case 165:
                        st.v9o = st.v17o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 166:
                        st.pc = 166;
                        st.pc = 169;
                        continue;
                    case 167:
                        st.v26i = st.v9i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 168:
                        st.pc = 168;
                        st.pc = 165;
                        continue;
                    case 169:
                        st.pc = 169;
                        st.tmpO = ((luaj.LuaTable) st.v7o).b3((java.lang.String) st.v9o, (java.lang.Appendable) st.v4o, (java.util.Map) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 170:
                        st.v17o = st.v9o;
                        st.v17i = 0;
                        st.v17j = 0L;
                        st.v17d = 0.0;
                    case 171:
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 172:
                        st.pc = 172;
                        st.pc = 192;
                        continue;
                    case 173:
                        st.v26i = st.v9i;
                        st.v26j = 0L;
                        st.v26o = null;
                        st.v26d = 0.0;
                    case 174:
                        st.v7i = (st.v14o instanceof luaj.LuaString) ? 1 : 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 175:
                        st.pc = 175;
                        if (st.v7i == 0) {
                            st.pc = 188;
                            continue;
                        }
                    case 176:
                        st.v7i = 39;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 177:
                        st.pc = 177;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((char) st.v7i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 178:
                        st.pc = 178;
                        st.tmpO = ((luaj.LuaValue) st.v14o).g0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 179:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 180:
                        st.pc = 180;
                        st.tmpI = ((java.lang.String) st.v9o).indexOf(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 181:
                        st.v15i = st.tmpI;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 182:
                        st.pc = 182;
                        if (st.v15i < 0) {
                            st.pc = 185;
                            continue;
                        }
                    case 183:
                        st.pc = 183;
                        st.tmpO = ((java.lang.String) st.v9o).replace((java.lang.CharSequence) st.v13o, (java.lang.CharSequence) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 184:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 185:
                        st.pc = 185;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 186:
                        st.pc = 186;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((char) st.v7i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 187:
                        st.pc = 187;
                        st.pc = 192;
                        continue;
                    case 188:
                        st.pc = 188;
                        st.tmpO = ((luaj.LuaValue) st.v14o).g0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 189:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 190:
                        st.pc = 190;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 191:
                        st.pc = 191;
                        st.pc = 171;
                        continue;
                    case 192:
                        st.v7o = "] = ";
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 193:
                        st.pc = 193;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 194:
                        st.v7i = 44;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 195:
                        st.pc = 195;
                        if (st.v3o == null) {
                            st.pc = 231;
                            continue;
                        }
                    case 196:
                        st.v15i = (st.v8o instanceof luaj.LuaTable) ? 1 : 0;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 197:
                        st.pc = 197;
                        if (st.v15i == 0) {
                            st.pc = 231;
                            continue;
                        }
                    case 198:
                        st.pc = 198;
                        st.v8o = (luaj.LuaTable) st.v8o;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 199:
                        st.pc = 199;
                        st.tmpI = (((java.util.Set) st.v3o).contains(st.v8o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 200:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 201:
                        st.pc = 201;
                        if (st.v9i == 0) {
                            st.pc = 216;
                            continue;
                        }
                    case 202:
                        st.pc = 202;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v12o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 203:
                        st.pc = 203;
                        st.tmpI = ((java.lang.Object) st.v8o).hashCode();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 204:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 205:
                        st.pc = 205;
                        st.tmpO = java.lang.Integer.toHexString(st.v8i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 206:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 207:
                        st.pc = 207;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 208:
                        st.pc = 208;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 209:
                        st.pc = 209;
                        if (st.v11i == 0) {
                            st.pc = 211;
                            continue;
                        }
                    case 210:
                        st.pc = 210;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 211:
                        st.pc = 211;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 212:
                        st.pc = 212;
                        if (st.v11i == 0) {
                            st.pc = 214;
                            continue;
                        }
                    case 213:
                        st.pc = 213;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 214:
                        st.pc = 214;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 215:
                        st.pc = 215;
                        st.pc = 227;
                        continue;
                    case 216:
                        st.pc = 216;
                        if ((st.v17o != null || st.v17i != 0)) {
                            st.pc = 224;
                            continue;
                        }
                    case 217:
                        st.pc = 217;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 218:
                        st.pc = 218;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 219:
                        st.pc = 219;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 220:
                        st.v6i = 9;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 221:
                        st.pc = 221;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((char) st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 222:
                        st.pc = 222;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 223:
                        st.v17o = st.tmpO;
                        st.v17i = 0;
                        st.v17j = 0L;
                        st.v17d = 0.0;
                    case 224:
                        st.v2o = st.v17o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 225:
                        st.pc = 225;
                        st.tmpO = ((luaj.LuaTable) st.v8o).b3((java.lang.String) st.v2o, (java.lang.Appendable) st.v4o, (java.util.Map) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 226:
                        st.v17o = st.v2o;
                        st.v17i = 0;
                        st.v17j = 0L;
                        st.v17d = 0.0;
                    case 227:
                        st.pc = 227;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((char) st.v7i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 228:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 229:
                        st.v9i = 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 230:
                        st.pc = 230;
                        st.pc = 342;
                        continue;
                    case 231:
                        st.v2i = (st.v8o instanceof luaj.LuaString) ? 1 : 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 232:
                        st.pc = 232;
                        if (st.v2i == 0) {
                            st.pc = 247;
                            continue;
                        }
                    case 233:
                        st.v2i = 39;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 234:
                        st.pc = 234;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((char) st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 235:
                        st.pc = 235;
                        st.tmpO = ((luaj.LuaValue) st.v8o).g0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 236:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 237:
                        st.pc = 237;
                        st.tmpI = ((java.lang.String) st.v6o).indexOf(st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 238:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 239:
                        st.pc = 239;
                        if (st.v2i < 0) {
                            st.pc = 242;
                            continue;
                        }
                    case 240:
                        st.pc = 240;
                        st.tmpO = ((java.lang.String) st.v6o).replace((java.lang.CharSequence) st.v13o, (java.lang.CharSequence) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 241:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 242:
                        st.pc = 242;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 243:
                        st.v2o = "',";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 244:
                        st.pc = 244;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 245:
                        st.v9i = 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 246:
                        st.pc = 246;
                        st.pc = 341;
                        continue;
                    case 247:
                        st.v2i = (st.v8o instanceof luaj.LuaLong) ? 1 : 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 248:
                        st.pc = 248;
                        if (st.v2i == 0) {
                            st.pc = 334;
                            continue;
                        }
                    case 249:
                        st.pc = 249;
                        if ((st.v9o == null && st.v9i == 0)) {
                            st.pc = 254;
                            continue;
                        }
                    case 250:
                        st.v2i = (st.v14o instanceof luaj.LuaString) ? 1 : 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 251:
                        st.pc = 251;
                        if (st.v2i == 0) {
                            st.pc = 254;
                            continue;
                        }
                    case 252:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 253:
                        st.pc = 253;
                        st.pc = 255;
                        continue;
                    case 254:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 255:
                        st.pc = 255;
                        if (st.v2i == 0) {
                            st.pc = 269;
                            continue;
                        }
                    case 256:
                        st.v6o = "address";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 257:
                        st.pc = 257;
                        st.tmpI = (((java.lang.String) st.v9o).equals(st.v6o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 258:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 259:
                        st.pc = 259;
                        if (st.v6i == 0) {
                            st.pc = 269;
                            continue;
                        }
                    case 260:
                        st.v2o = "0x";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 261:
                        st.pc = 261;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 262:
                        st.pc = 262;
                        st.tmpJ = ((luaj.LuaValue) st.v8o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 263:
                        st.v8j = st.tmpJ;
                        st.v8d = java.lang.Double.longBitsToDouble(st.v8j);
                        st.v8i = 0;
                        st.v8o = null;
                    case 264:
                        st.pc = 264;
                        st.tmpO = java.lang.Long.toHexString(st.v8j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 265:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 266:
                        st.pc = 266;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 267:
                        st.v9i = 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 268:
                        st.pc = 268;
                        st.pc = 331;
                        continue;
                    case 269:
                        st.pc = 269;
                        st.tmpO = ((luaj.LuaValue) st.v8o).g0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 270:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 271:
                        st.pc = 271;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 272:
                        st.pc = 272;
                        if (st.v2i == 0) {
                            st.pc = 267;
                            continue;
                        }
                    case 273:
                        st.v2o = "flags";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 274:
                        st.pc = 274;
                        st.tmpI = (((java.lang.String) st.v9o).equals(st.v2o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 275:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 276:
                        st.v6i = 2;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 277:
                        st.pc = 277;
                        if (st.v2i == 0) {
                            st.pc = 310;
                            continue;
                        }
                    case 278:
                        st.pc = 278;
                        st.tmpI = ((luaj.LuaValue) st.v8o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 279:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 280:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 281:
                        st.pc = 281;
                        if (st.v2i == st.v8i) {
                            st.pc = 307;
                            continue;
                        }
                    case 282:
                        st.pc = 282;
                        if (st.v2i == st.v6i) {
                            st.pc = 305;
                            continue;
                        }
                    case 283:
                        st.v6i = 4;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 284:
                        st.pc = 284;
                        if (st.v2i == st.v6i) {
                            st.pc = 303;
                            continue;
                        }
                    case 285:
                        st.v6i = 8;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 286:
                        st.pc = 286;
                        if (st.v2i == st.v6i) {
                            st.pc = 301;
                            continue;
                        }
                    case 287:
                        st.v6i = 16;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 288:
                        st.pc = 288;
                        if (st.v2i == st.v6i) {
                            st.pc = 299;
                            continue;
                        }
                    case 289:
                        st.v6i = 32;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 290:
                        st.pc = 290;
                        if (st.v2i == st.v6i) {
                            st.pc = 297;
                            continue;
                        }
                    case 291:
                        st.v6i = 64;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 292:
                        st.pc = 292;
                        if (st.v2i == st.v6i) {
                            st.pc = 295;
                            continue;
                        }
                    case 293:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 294:
                        st.pc = 294;
                        st.pc = 308;
                        continue;
                    case 295:
                        st.v2o = "gg.TYPE_DOUBLE";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 296:
                        st.pc = 296;
                        st.pc = 308;
                        continue;
                    case 297:
                        st.v2o = "gg.TYPE_QWORD";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 298:
                        st.pc = 298;
                        st.pc = 308;
                        continue;
                    case 299:
                        st.v2o = "gg.TYPE_FLOAT";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 300:
                        st.pc = 300;
                        st.pc = 308;
                        continue;
                    case 301:
                        st.v2o = "gg.TYPE_XOR";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 302:
                        st.pc = 302;
                        st.pc = 308;
                        continue;
                    case 303:
                        st.v2o = "gg.TYPE_DWORD";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 304:
                        st.pc = 304;
                        st.pc = 308;
                        continue;
                    case 305:
                        st.v2o = "gg.TYPE_WORD";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 306:
                        st.pc = 306;
                        st.pc = 308;
                        continue;
                    case 307:
                        st.v2o = "gg.TYPE_BYTE";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 308:
                        st.v9i = 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 309:
                        st.pc = 309;
                        st.pc = 332;
                        continue;
                    case 310:
                        st.v2o = "freezeType";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 311:
                        st.pc = 311;
                        st.tmpI = (((java.lang.String) st.v9o).equals(st.v2o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 312:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 313:
                        st.pc = 313;
                        if (st.v2i == 0) {
                            st.pc = 267;
                            continue;
                        }
                    case 314:
                        st.pc = 314;
                        st.tmpI = ((luaj.LuaValue) st.v8o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 315:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 316:
                        st.v9i = 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 317:
                        st.pc = 317;
                        if (st.v2i == 0) {
                            st.pc = 329;
                            continue;
                        }
                    case 318:
                        st.pc = 318;
                        if (st.v2i == st.v9i) {
                            st.pc = 327;
                            continue;
                        }
                    case 319:
                        st.pc = 319;
                        if (st.v2i == st.v6i) {
                            st.pc = 325;
                            continue;
                        }
                    case 320:
                        st.v6i = 3;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 321:
                        st.pc = 321;
                        if (st.v2i == st.v6i) {
                            st.pc = 323;
                            continue;
                        }
                    case 322:
                        st.pc = 322;
                        st.pc = 331;
                        continue;
                    case 323:
                        st.v2o = "gg.FREEZE_IN_RANGE";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 324:
                        st.pc = 324;
                        st.pc = 332;
                        continue;
                    case 325:
                        st.v2o = "gg.FREEZE_MAY_DECREASE";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 326:
                        st.pc = 326;
                        st.pc = 332;
                        continue;
                    case 327:
                        st.v2o = "gg.FREEZE_MAY_INCREASE";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 328:
                        st.pc = 328;
                        st.pc = 332;
                        continue;
                    case 329:
                        st.v2o = "gg.FREEZE_NORMAL";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 330:
                        st.pc = 330;
                        st.pc = 332;
                        continue;
                    case 331:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 332:
                        st.pc = 332;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((char) st.v7i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 333:
                        st.pc = 333;
                        st.pc = 342;
                        continue;
                    case 334:
                        st.v9i = 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 335:
                        st.pc = 335;
                        st.tmpO = ((luaj.LuaValue) st.v8o).g0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 336:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 337:
                        st.pc = 337;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 338:
                        st.v2i = (st.v8o instanceof android.ext.Script$ApiFunction) ? 1 : 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 339:
                        st.pc = 339;
                        if (st.v2i != 0) {
                            st.pc = 341;
                            continue;
                        }
                    case 340:
                        st.pc = 340;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((char) st.v7i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 341:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 342:
                        st.pc = 342;
                        if ((st.v2o == null && st.v2i == 0)) {
                            st.pc = 346;
                            continue;
                        }
                    case 343:
                        st.v6o = " -- ";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 344:
                        st.pc = 344;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 345:
                        st.pc = 345;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 346:
                        st.v2i = 10;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 347:
                        st.pc = 347;
                        st.tmpO = ((java.lang.Appendable) st.v4o).append((char) st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 348:
                        st.pc = 348;
                        if (st.v16i != 0) {
                            st.pc = 364;
                            continue;
                        }
                    case 349:
                        st.pc = 349;
                        if (st.v25o != null) {
                            st.pc = 359;
                            continue;
                        }
                    case 350:
                        st.v12i = st.v24i + 0xffffffff;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 351:
                        st.v6i = st.v23i - st.v12i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 352:
                        st.pc = 352;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 353:
                        st.pc = 353;
                        if (st.v6i >= 0) {
                            st.pc = 357;
                            continue;
                        }
                    case 354:
                        st.pc = 354;
                        st.v2o = new java.util.ArrayList();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 355:
                        st.v15o = st.v2o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 356:
                        st.pc = 356;
                        st.pc = 360;
                        continue;
                    case 357:
                        st.pc = 357;
                        st.v2o = new java.util.ArrayList(st.v6i);
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 358:
                        st.pc = 358;
                        st.pc = 355;
                        continue;
                    case 359:
                        st.v15o = st.v25o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 360:
                        st.pc = 360;
                        st.tmpO = ((java.lang.Object) st.v4o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 361:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 362:
                        st.pc = 362;
                        st.tmpI = (((java.util.List) st.v15o).add(st.v2o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 363:
                        st.pc = 363;
                        st.pc = 365;
                        continue;
                    case 364:
                        st.v15o = st.v25o;
                        st.v15i = 0;
                        st.v15j = 0L;
                        st.v15d = 0.0;
                    case 365:
                        st.v4o = st.v27o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 366:
                        st.v2o = st.v29o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 367:
                        st.v7i = st.v20i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 368:
                        st.v10o = st.v21o;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 369:
                        st.v13i = st.v22i;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 370:
                        st.v6i = st.v23i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 371:
                        st.v12i = st.v24i;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 372:
                        st.v9i = st.v26i;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 373:
                        st.pc = 373;
                        st.pc = 100;
                        continue;
                    case 374:
                        st.v25o = st.v15o;
                        st.v25i = 0;
                        st.v25j = 0L;
                        st.v25d = 0.0;
                    case 375:
                        st.pc = 375;
                        if (st.v25o == null) {
                            st.pc = 392;
                            continue;
                        }
                    case 376:
                        st.pc = 376;
                        java.util.Collections.sort((java.util.List) st.v25o);
                    case 377:
                        st.pc = 377;
                        st.pc = 381;
                        continue;
                    case 378:
                        st.pc = 378;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 379:
                        st.v2o = st.v0o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 380:
                        st.pc = 380;
                        st.tmpI = android.ext.e1.a((java.lang.Throwable) st.v2o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 381:
                        st.pc = 381;
                        st.tmpO = ((java.util.List) st.v25o).iterator();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 382:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 383:
                        st.pc = 383;
                        st.tmpI = (((java.util.Iterator) st.v0o).hasNext()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 384:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 385:
                        st.pc = 385;
                        if (st.v2i == 0) {
                            st.pc = 392;
                            continue;
                        }
                    case 386:
                        st.pc = 386;
                        st.tmpO = ((java.util.Iterator) st.v0o).next();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 387:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 388:
                        st.pc = 388;
                        st.v2o = (java.lang.String) st.v2o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 389:
                        st.v3o = st.v29o;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 390:
                        st.pc = 390;
                        st.tmpO = ((java.lang.Appendable) st.v3o).append((java.lang.CharSequence) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 391:
                        st.pc = 391;
                        st.pc = 383;
                        continue;
                    case 392:
                        st.v3o = st.v29o;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 393:
                        st.pc = 393;
                        if (st.v11i == 0) {
                            st.pc = 395;
                            continue;
                        }
                    case 394:
                        st.pc = 394;
                        st.tmpO = ((java.lang.Appendable) st.v3o).append((java.lang.CharSequence) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 395:
                        st.v0i = 125;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 396:
                        st.pc = 396;
                        st.tmpO = ((java.lang.Appendable) st.v3o).append((char) st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 397:
                        st.pc = 397;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_b3_handler(st.pc, t);
            if (h < 0) {
                xm_b3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_b3_ctypes = {
    };
    private static final int[] xm_b3_handlers = {
        376, 377, 378, -1
    };
    private static int xm_b3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_b3_handlers.length; i += 4) {
            if (pc < xm_b3_handlers[i] || pc >= xm_b3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_b3_handlers[i + 3];
            if (ti < 0 || xm_b3_ctypes[ti].isInstance(t)) {
                return xm_b3_handlers[i + 2];
            }
        }
        return -1;
    }

    private void h3(luaj.LuaValue luaValue) {
        xm_h3State st = new xm_h3State();
        st.v3o = this;
        st.v4o = luaValue;
        xm_h3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_h3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_h3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static void xm_h3_run(xm_h3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_h3_c0(st);
            }
            else {
                done = xm_h3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_h3_c0(xm_h3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v3o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i <= 0) {
                            st.pc = 23;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((luaj.LuaTable) st.v3o).i3((luaj.LuaValue) st.v4o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v1o = ((luaj.LuaTable) st.v3o).Q;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v1o = ((java.lang.Object[]) st.v1o)[st.v0i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v1o == null) {
                            st.pc = 23;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.tmpO = ((luaj.LuaTable$m) st.v1o).f((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v2o == null) {
                            st.pc = 20;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.v4o = ((luaj.LuaTable) st.v3o).Q;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v1o = ((java.lang.Object[]) st.v4o)[st.v0i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaTable$m) st.v1o).h((luaj.LuaTable$n) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((java.lang.Object[]) st.v4o)[st.v0i] = st.v1o;
                    case 16:
                        st.pc = 16;
                        st.v4i = ((luaj.LuaTable) st.v3o).R;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 17:
                        st.v4i = st.v4i + 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 18:
                        st.pc = 18;
                        ((luaj.LuaTable) st.v3o).R = st.v4i;
                    case 19:
                        st.pc = 19;
                        return true;
                    case 20:
                        st.pc = 20;
                        st.tmpO = ((luaj.LuaTable$m) st.v1o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 21:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.pc = 7;
                        continue;
                    case 23:
                        st.pc = 23;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_h3_handler(st.pc, t);
            if (h < 0) {
                xm_h3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_h3_ctypes = {
    };
    private static final int[] xm_h3_handlers = {
        
    };
    private static int xm_h3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_h3_handlers.length; i += 4) {
            if (pc < xm_h3_handlers[i] || pc >= xm_h3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_h3_handlers[i + 3];
            if (ti < 0 || xm_h3_ctypes[ti].isInstance(t)) {
                return xm_h3_handlers[i + 2];
            }
        }
        return -1;
    }

    private int i3(luaj.LuaValue luaValue) {
        xm_i3State st = new xm_i3State();
        st.v1o = this;
        st.v2o = luaValue;
        return xm_i3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_i3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_i3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
    }

    private static int xm_i3_run(xm_i3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 7) {
                done = xm_i3_c0(st);
            }
            else {
                done = xm_i3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_i3_c0(xm_i3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((java.lang.Object) st.v2o).hashCode();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v0o = ((luaj.LuaTable) st.v1o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v0i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.v0i = st.v0i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.v2i = st.v2i & st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_i3_handler(st.pc, t);
            if (h < 0) {
                xm_i3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_i3_ctypes = {
    };
    private static final int[] xm_i3_handlers = {
        
    };
    private static int xm_i3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_i3_handlers.length; i += 4) {
            if (pc < xm_i3_handlers[i] || pc >= xm_i3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_i3_handlers[i + 3];
            if (ti < 0 || xm_i3_ctypes[ti].isInstance(t)) {
                return xm_i3_handlers[i + 2];
            }
        }
        return -1;
    }

    public static int j3(luaj.LuaValue luaValue, int i) {
        xm_j3State st = new xm_j3State();
        st.v0o = luaValue;
        st.v1i = i;
        return xm_j3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_j3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_j3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
    }

    private static int xm_j3_run(xm_j3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_j3_c0(st);
            }
            else {
                done = xm_j3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_j3_c0(xm_j3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((java.lang.Object) st.v0o).hashCode();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v0i = st.v0i & st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_j3_handler(st.pc, t);
            if (h < 0) {
                xm_j3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_j3_ctypes = {
    };
    private static final int[] xm_j3_handlers = {
        
    };
    private static int xm_j3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_j3_handlers.length; i += 4) {
            if (pc < xm_j3_handlers[i] || pc >= xm_j3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_j3_handlers[i + 3];
            if (ti < 0 || xm_j3_ctypes[ti].isInstance(t)) {
                return xm_j3_handlers[i + 2];
            }
        }
        return -1;
    }

    public static int l3(int i, int i2) {
        xm_l3State st = new xm_l3State();
        st.v0i = i;
        st.v1i = i2;
        return xm_l3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_l3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_l3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
    }

    private static int xm_l3_run(xm_l3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_l3_c0(st);
            }
            else {
                done = xm_l3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_l3_c0(xm_l3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = st.v0i & st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_l3_handler(st.pc, t);
            if (h < 0) {
                xm_l3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_l3_ctypes = {
    };
    private static final int[] xm_l3_handlers = {
        
    };
    private static int xm_l3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_l3_handlers.length; i += 4) {
            if (pc < xm_l3_handlers[i] || pc >= xm_l3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_l3_handlers[i + 3];
            if (ti < 0 || xm_l3_ctypes[ti].isInstance(t)) {
                return xm_l3_handlers[i + 2];
            }
        }
        return -1;
    }

    private void n3(int i, luaj.LuaValue luaValue) {
        xm_n3State st = new xm_n3State();
        st.v3o = this;
        st.v4i = i;
        st.v5o = luaValue;
        xm_n3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_n3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_n3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        java.lang.Object v5o;
    }

    private static void xm_n3_run(xm_n3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 13) {
                done = xm_n3_c0(st);
            }
            else {
                done = xm_n3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_n3_c0(xm_n3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        ((luaj.LuaTable) st.v3o).o3(st.v4i, (luaj.LuaValue) st.v5o);
                    case 1:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v4i <= st.v0i) {
                            st.pc = 12;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((luaj.LuaTable) st.v3o).c3(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.LuaTable) st.v3o).c3(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((luaj.LuaTable) st.v3o).e2(st.v4i, (luaj.LuaValue) st.v2o);
                    case 8:
                        st.pc = 8;
                        ((luaj.LuaTable) st.v3o).e2(st.v0i, (luaj.LuaValue) st.v1o);
                    case 9:
                        st.v4i = st.v4i + 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((luaj.LuaTable) st.v3o).B3(st.v0i, st.v4i, (luaj.LuaValue) st.v5o);
                    case 11:
                        st.pc = 11;
                        st.pc = 1;
                        continue;
                    case 12:
                        st.pc = 12;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_n3_handler(st.pc, t);
            if (h < 0) {
                xm_n3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_n3_ctypes = {
    };
    private static final int[] xm_n3_handlers = {
        
    };
    private static int xm_n3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_n3_handlers.length; i += 4) {
            if (pc < xm_n3_handlers[i] || pc >= xm_n3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_n3_handlers[i + 3];
            if (ti < 0 || xm_n3_ctypes[ti].isInstance(t)) {
                return xm_n3_handlers[i + 2];
            }
        }
        return -1;
    }

    private void o3(int i, luaj.LuaValue luaValue) {
        xm_o3State st = new xm_o3State();
        st.v1o = this;
        st.v2i = i;
        st.v3o = luaValue;
        xm_o3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_o3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_o3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
        int v2i;
        java.lang.Object v3o;
    }

    private static void xm_o3_run(xm_o3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 6) {
                done = xm_o3_c0(st);
            }
            else {
                done = xm_o3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_o3_c0(xm_o3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = st.v2i / 2;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i <= 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        ((luaj.LuaTable) st.v1o).B3(st.v0i, st.v2i, (luaj.LuaValue) st.v3o);
                    case 3:
                        st.v0i = st.v0i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 1;
                        continue;
                    case 5:
                        st.pc = 5;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_o3_handler(st.pc, t);
            if (h < 0) {
                xm_o3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_o3_ctypes = {
    };
    private static final int[] xm_o3_handlers = {
        
    };
    private static int xm_o3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_o3_handlers.length; i += 4) {
            if (pc < xm_o3_handlers[i] || pc >= xm_o3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_o3_handlers[i + 3];
            if (ti < 0 || xm_o3_ctypes[ti].isInstance(t)) {
                return xm_o3_handlers[i + 2];
            }
        }
        return -1;
    }

    protected static boolean r3(luaj.LuaValue luaValue) {
        xm_r3State st = new xm_r3State();
        st.v4o = luaValue;
        return xm_r3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_r3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_r3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static boolean xm_r3_run(xm_r3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 16) {
                done = xm_r3_c0(st);
            }
            else {
                done = xm_r3_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_r3_c0(xm_r3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((luaj.LuaValue) st.v4o).C2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0i == st.v2i) {
                            st.pc = 15;
                            continue;
                        }
                    case 5:
                        st.v3i = 3;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v0i == st.v3i) {
                            st.pc = 15;
                            continue;
                        }
                    case 7:
                        st.v3i = 4;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v0i == st.v3i) {
                            st.pc = 10;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 10:
                        st.pc = 10;
                        st.tmpI = ((luaj.LuaValue) st.v4o).W1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 11:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 12:
                        st.v0i = 32;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v4i <= st.v0i) {
                            st.pc = 15;
                            continue;
                        }
                    case 14:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_r3_handler(st.pc, t);
            if (h < 0) {
                xm_r3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_r3_ctypes = {
    };
    private static final int[] xm_r3_handlers = {
        
    };
    private static int xm_r3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_r3_handlers.length; i += 4) {
            if (pc < xm_r3_handlers[i] || pc >= xm_r3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_r3_handlers[i + 3];
            if (ti < 0 || xm_r3_ctypes[ti].isInstance(t)) {
                return xm_r3_handlers[i + 2];
            }
        }
        return -1;
    }

    static int u3(int i) {
        xm_u3State st = new xm_u3State();
        st.v3i = i;
        return xm_u3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_u3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_u3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static int xm_u3_run(xm_u3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 32) {
                done = xm_u3_c0(st);
            }
            else {
                done = xm_u3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_u3_c0(xm_u3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v3i = st.v3i + 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v3i >= 0) {
                            st.pc = 4;
                            continue;
                        }
                    case 2:
                        st.v3i = 0x80000000;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.resultI = st.v3i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 4:
                        st.v0i = 0xffff0000;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.v0i = st.v0i & st.v3i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 6:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i == 0) {
                            st.pc = 11;
                            continue;
                        }
                    case 8:
                        st.v3i = st.v3i >>> 16;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 9:
                        st.v0i = 16;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.pc = 12;
                        continue;
                    case 11:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 12:
                        st.v2i = 65280;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 13:
                        st.v2i = st.v2i & st.v3i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v2i == 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.v0i = st.v0i + 8;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 16:
                        st.v3i = st.v3i >>> 8;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.v2i = st.v3i & 240;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 18:
                        st.pc = 18;
                        if (st.v2i == 0) {
                            st.pc = 21;
                            continue;
                        }
                    case 19:
                        st.v0i = st.v0i + 4;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 20:
                        st.v3i = st.v3i >>> 4;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 21:
                        switch (st.v3i) {
                            case 0: st.pc = 31; continue;
                            case 1: st.pc = 29; continue;
                            case 2: st.pc = 27; continue;
                            case 3: st.pc = 27; continue;
                            case 4: st.pc = 25; continue;
                            case 5: st.pc = 25; continue;
                            case 6: st.pc = 25; continue;
                            case 7: st.pc = 25; continue;
                            case 8: st.pc = 23; continue;
                            case 9: st.pc = 23; continue;
                            case 10: st.pc = 23; continue;
                            case 11: st.pc = 23; continue;
                            case 12: st.pc = 23; continue;
                            case 13: st.pc = 23; continue;
                            case 14: st.pc = 23; continue;
                            case 15: st.pc = 23; continue;
                            default: st.pc = 22; continue;
                        }
                    case 22:
                        st.pc = 22;
                        st.pc = 30;
                        continue;
                    case 23:
                        st.v0i = st.v0i + 4;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.pc = 30;
                        continue;
                    case 25:
                        st.v0i = st.v0i + 3;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.pc = 30;
                        continue;
                    case 27:
                        st.v0i = st.v0i + 2;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.pc = 30;
                        continue;
                    case 29:
                        st.v0i = st.v0i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 31:
                        st.pc = 31;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_u3_handler(st.pc, t);
            if (h < 0) {
                xm_u3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_u3_ctypes = {
    };
    private static final int[] xm_u3_handlers = {
        
    };
    private static int xm_u3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_u3_handlers.length; i += 4) {
            if (pc < xm_u3_handlers[i] || pc >= xm_u3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_u3_handlers[i + 3];
            if (ti < 0 || xm_u3_ctypes[ti].isInstance(t)) {
                return xm_u3_handlers[i + 2];
            }
        }
        return -1;
    }

    private void y3(int i) {
        xm_y3State st = new xm_y3State();
        st.v12o = this;
        st.v13i = i;
        xm_y3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_y3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_y3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
        int v10i;
        long v10j;
        java.lang.Object v10o;
        double v10d;
        int v11i;
        long v11j;
        java.lang.Object v11o;
        double v11d;
        java.lang.Object v12o;
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
    }

    private static void xm_y3_run(xm_y3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 172) {
                done = xm_y3_c0(st);
            }
            else {
                done = xm_y3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_y3_c0(xm_y3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v12o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0o == null) {
                            st.pc = 17;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpI = (((luaj.e) st.v0o).q()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0i != 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.v0o = ((luaj.LuaTable) st.v12o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.e) st.v0o).p()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v0i == 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.tmpI = ((luaj.LuaTable) st.v12o).X2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        ((luaj.LuaTable) st.v12o).R = st.v0i;
                    case 12:
                        st.pc = 12;
                        st.v0o = ((luaj.LuaTable) st.v12o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpI = (((luaj.e) st.v0o).p()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 14:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v0i == 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 16:
                        st.pc = 16;
                        ((luaj.LuaTable) st.v12o).a3();
                    case 17:
                        st.v0i = 32;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.v1o = new int[st.v0i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.tmpI = ((luaj.LuaTable) st.v12o).Y2((int[]) st.v1o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 20:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 21:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 22:
                        st.pc = 22;
                        if (st.v13i <= 0) {
                            st.pc = 29;
                            continue;
                        }
                    case 23:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.tmpI = luaj.LuaTable.u3(st.v13i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 25:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v5i = ((int[]) st.v1o)[st.v4i];
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 27:
                        st.v5i = st.v5i + st.v3i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 28:
                        st.pc = 28;
                        ((int[]) st.v1o)[st.v4i] = st.v5i;
                    case 29:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.v5i = ((int[]) st.v1o)[st.v4i];
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 31:
                        st.v6i = 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 32:
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 33:
                        st.v8i = 2;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 34:
                        st.pc = 34;
                        if (st.v6i >= st.v0i) {
                            st.pc = 47;
                            continue;
                        }
                    case 35:
                        st.pc = 35;
                        st.v9i = ((int[]) st.v1o)[st.v6i];
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 36:
                        st.v5i = st.v5i + st.v9i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 37:
                        st.v9i = st.v2i * 2;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 38:
                        st.v10i = st.v3i << st.v6i;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 39:
                        st.pc = 39;
                        if (st.v9i >= st.v10i) {
                            st.pc = 41;
                            continue;
                        }
                    case 40:
                        st.pc = 40;
                        st.pc = 47;
                        continue;
                    case 41:
                        st.v8i = st.v6i + 0xffffffff;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 42:
                        st.v8i = st.v3i << st.v8i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 43:
                        st.pc = 43;
                        if (st.v5i < st.v8i) {
                            st.pc = 45;
                            continue;
                        }
                    case 44:
                        st.v7i = st.v10i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 45:
                        st.v6i = st.v6i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.pc = 33;
                        continue;
                    case 47:
                        st.pc = 47;
                        st.v0o = ((luaj.LuaTable) st.v12o).P;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 48:
                        st.pc = 48;
                        st.v2o = ((luaj.LuaTable) st.v12o).Q;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 49:
                        st.pc = 49;
                        if (st.v13i <= 0) {
                            st.pc = 53;
                            continue;
                        }
                    case 50:
                        st.pc = 50;
                        if (st.v13i > st.v7i) {
                            st.pc = 53;
                            continue;
                        }
                    case 51:
                        st.v5i = 0xffffffff;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 52:
                        st.pc = 52;
                        st.pc = 54;
                        continue;
                    case 53:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.v6i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 55:
                        st.pc = 55;
                        if (st.v7i == st.v6i) {
                            st.pc = 90;
                            continue;
                        }
                    case 56:
                        st.pc = 56;
                        st.v6o = new luaj.LuaValue[st.v7i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 57:
                        st.pc = 57;
                        st.v9i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 58:
                        st.pc = 58;
                        if (st.v7i <= st.v9i) {
                            st.pc = 71;
                            continue;
                        }
                    case 59:
                        st.pc = 59;
                        st.v9i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 60:
                        st.v9i = st.v9i + st.v3i;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 61:
                        st.pc = 61;
                        st.tmpI = luaj.LuaTable.u3(st.v9i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 62:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 63:
                        st.pc = 63;
                        st.tmpI = luaj.LuaTable.u3(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 64:
                        st.v10i = st.tmpI;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 65:
                        st.v10i = st.v10i + st.v3i;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 66:
                        st.pc = 66;
                        if (st.v9i >= st.v10i) {
                            st.pc = 85;
                            continue;
                        }
                    case 67:
                        st.pc = 67;
                        st.v11i = ((int[]) st.v1o)[st.v9i];
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 68:
                        st.v5i = st.v5i + st.v11i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 69:
                        st.v9i = st.v9i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 70:
                        st.pc = 70;
                        st.pc = 66;
                        continue;
                    case 71:
                        st.pc = 71;
                        st.v9i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 72:
                        st.pc = 72;
                        if (st.v9i <= st.v7i) {
                            st.pc = 85;
                            continue;
                        }
                    case 73:
                        st.v9i = st.v7i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 74:
                        st.pc = 74;
                        st.tmpI = luaj.LuaTable.u3(st.v9i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 75:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 76:
                        st.pc = 76;
                        st.v10i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 77:
                        st.pc = 77;
                        st.tmpI = luaj.LuaTable.u3(st.v10i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 78:
                        st.v10i = st.tmpI;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 79:
                        st.v10i = st.v10i + st.v3i;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 80:
                        st.pc = 80;
                        if (st.v9i >= st.v10i) {
                            st.pc = 85;
                            continue;
                        }
                    case 81:
                        st.pc = 81;
                        st.v11i = ((int[]) st.v1o)[st.v9i];
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 82:
                        st.v5i = st.v5i - st.v11i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 83:
                        st.v9i = st.v9i + 1;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 84:
                        st.pc = 84;
                        st.pc = 80;
                        continue;
                    case 85:
                        st.pc = 85;
                        st.v1i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 86:
                        st.pc = 86;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 87:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 88:
                        st.pc = 88;
                        java.lang.System.arraycopy(st.v0o, st.v4i, st.v6o, st.v4i, st.v1i);
                    case 89:
                        st.pc = 89;
                        st.pc = 91;
                        continue;
                    case 90:
                        st.v6o = st.v0o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 91:
                        st.pc = 91;
                        st.v1i = ((luaj.LuaTable) st.v12o).R;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 92:
                        st.v1i = st.v1i - st.v5i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 93:
                        st.pc = 93;
                        if (st.v13i < 0) {
                            st.pc = 98;
                            continue;
                        }
                    case 94:
                        st.pc = 94;
                        if (st.v13i <= st.v7i) {
                            st.pc = 96;
                            continue;
                        }
                    case 95:
                        st.pc = 95;
                        st.pc = 98;
                        continue;
                    case 96:
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 97:
                        st.pc = 97;
                        st.pc = 99;
                        continue;
                    case 98:
                        st.v13i = 1;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 99:
                        st.v1i = st.v1i + st.v13i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 100:
                        st.pc = 100;
                        st.v13i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 101:
                        st.pc = 101;
                        if (st.v1i <= 0) {
                            st.pc = 110;
                            continue;
                        }
                    case 102:
                        st.pc = 102;
                        if (st.v1i >= st.v8i) {
                            st.pc = 104;
                            continue;
                        }
                    case 103:
                        st.pc = 103;
                        st.pc = 107;
                        continue;
                    case 104:
                        st.pc = 104;
                        st.tmpI = luaj.LuaTable.u3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 105:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 106:
                        st.v8i = st.v3i << st.v1i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 107:
                        st.v1i = st.v8i + 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 108:
                        st.pc = 108;
                        st.v3o = new luaj.LuaTable$m[st.v8i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 109:
                        st.pc = 109;
                        st.pc = 112;
                        continue;
                    case 110:
                        st.pc = 110;
                        st.v3o = luaj.LuaTable.U;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 111:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 112:
                        st.pc = 112;
                        if (st.v4i >= st.v13i) {
                            st.pc = 139;
                            continue;
                        }
                    case 113:
                        st.pc = 113;
                        st.v8o = ((java.lang.Object[]) st.v2o)[st.v4i];
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 114:
                        st.pc = 114;
                        if (st.v8o == null) {
                            st.pc = 137;
                            continue;
                        }
                    case 115:
                        st.pc = 115;
                        st.tmpI = ((luaj.LuaTable$m) st.v8o).r(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 116:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 117:
                        st.pc = 117;
                        if (st.v9i <= 0) {
                            st.pc = 126;
                            continue;
                        }
                    case 118:
                        st.pc = 118;
                        st.tmpO = ((luaj.LuaTable$m) st.v8o).l();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 119:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 120:
                        st.pc = 120;
                        if (st.v10o == null) {
                            st.pc = 134;
                            continue;
                        }
                    case 121:
                        st.v9i = st.v9i + 0xffffffff;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 122:
                        st.pc = 122;
                        st.tmpO = ((luaj.LuaTable$n) st.v10o).t();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 123:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 124:
                        st.pc = 124;
                        ((java.lang.Object[]) st.v6o)[st.v9i] = st.v10o;
                    case 125:
                        st.pc = 125;
                        st.pc = 134;
                        continue;
                    case 126:
                        st.v9i = (st.v8o instanceof luaj.LuaTable$c) ? 1 : 0;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 127:
                        st.pc = 127;
                        if (st.v9i != 0) {
                            st.pc = 134;
                            continue;
                        }
                    case 128:
                        st.pc = 128;
                        st.tmpI = ((luaj.LuaTable$m) st.v8o).b(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 129:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 130:
                        st.pc = 130;
                        st.v10o = ((java.lang.Object[]) st.v3o)[st.v9i];
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 131:
                        st.pc = 131;
                        st.tmpO = ((luaj.LuaTable$m) st.v8o).n((luaj.LuaTable$m) st.v10o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 132:
                        st.v10o = st.tmpO;
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 133:
                        st.pc = 133;
                        ((java.lang.Object[]) st.v3o)[st.v9i] = st.v10o;
                    case 134:
                        st.pc = 134;
                        st.tmpO = ((luaj.LuaTable$m) st.v8o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 135:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 136:
                        st.pc = 136;
                        st.pc = 114;
                        continue;
                    case 137:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 138:
                        st.pc = 138;
                        st.pc = 112;
                        continue;
                    case 139:
                        st.pc = 139;
                        st.v13i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 140:
                        st.pc = 140;
                        if (st.v7i >= st.v13i) {
                            st.pc = 166;
                            continue;
                        }
                    case 141:
                        st.v13i = st.v7i + 1;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 142:
                        st.pc = 142;
                        st.v2o = ((java.lang.Object[]) st.v0o)[st.v7i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 143:
                        st.pc = 143;
                        if (st.v2o == null) {
                            st.pc = 164;
                            continue;
                        }
                    case 144:
                        st.v7j = st.v13i;
                        st.v7d = java.lang.Double.longBitsToDouble(st.v7j);
                        st.v7i = 0;
                        st.v7o = null;
                    case 145:
                        st.pc = 145;
                        st.tmpI = luaj.LuaLong.V2(st.v7j);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 146:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 147:
                        st.pc = 147;
                        st.tmpI = luaj.LuaTable.l3(st.v4i, st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 148:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 149:
                        st.pc = 149;
                        st.v9o = ((luaj.LuaTable) st.v12o).S;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 150:
                        st.pc = 150;
                        st.tmpO = luaj.LuaValue.I2(st.v7j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 151:
                        st.v7o = st.tmpO;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 152:
                        st.pc = 152;
                        if (st.v9o == null) {
                            st.pc = 157;
                            continue;
                        }
                    case 153:
                        st.pc = 153;
                        st.tmpO = ((luaj.e) st.v9o).k((luaj.LuaValue) st.v7o, (luaj.LuaValue) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 154:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 155:
                        st.pc = 155;
                        if (st.v2o != null) {
                            st.pc = 159;
                            continue;
                        }
                    case 156:
                        st.pc = 156;
                        st.pc = 164;
                        continue;
                    case 157:
                        st.pc = 157;
                        st.tmpO = luaj.LuaTable.Z2((luaj.LuaValue) st.v7o, (luaj.LuaValue) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 158:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 159:
                        st.pc = 159;
                        st.v7o = ((java.lang.Object[]) st.v3o)[st.v4i];
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 160:
                        st.pc = 160;
                        if (st.v7o == null) {
                            st.pc = 163;
                            continue;
                        }
                    case 161:
                        st.pc = 161;
                        st.tmpO = ((luaj.LuaTable$m) st.v7o).d((luaj.LuaTable$m) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 162:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 163:
                        st.pc = 163;
                        ((java.lang.Object[]) st.v3o)[st.v4i] = st.v2o;
                    case 164:
                        st.v7i = st.v13i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 165:
                        st.pc = 165;
                        st.pc = 139;
                        continue;
                    case 166:
                        st.pc = 166;
                        ((luaj.LuaTable) st.v12o).Q = (luaj.LuaTable$m[]) st.v3o;
                    case 167:
                        st.pc = 167;
                        ((luaj.LuaTable) st.v12o).P = (luaj.LuaValue[]) st.v6o;
                    case 168:
                        st.pc = 168;
                        st.v13i = ((luaj.LuaTable) st.v12o).R;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 169:
                        st.v13i = st.v13i - st.v5i;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 170:
                        st.pc = 170;
                        ((luaj.LuaTable) st.v12o).R = st.v13i;
                    case 171:
                        st.pc = 171;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_y3_handler(st.pc, t);
            if (h < 0) {
                xm_y3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_y3_ctypes = {
    };
    private static final int[] xm_y3_handlers = {
        
    };
    private static int xm_y3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_y3_handlers.length; i += 4) {
            if (pc < xm_y3_handlers[i] || pc >= xm_y3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_y3_handlers[i + 3];
            if (ti < 0 || xm_y3_ctypes[ti].isInstance(t)) {
                return xm_y3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public int C2() {
        xm_C2State st = new xm_C2State();
        st.v1o = this;
        return xm_C2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_C2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_C2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static int xm_C2_run(xm_C2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_C2_c0(st);
            }
            else {
                done = xm_C2_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_C2_c0(xm_C2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 5;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_C2_handler(st.pc, t);
            if (h < 0) {
                xm_C2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_C2_ctypes = {
    };
    private static final int[] xm_C2_handlers = {
        
    };
    private static int xm_C2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_C2_handlers.length; i += 4) {
            if (pc < xm_C2_handlers[i] || pc >= xm_C2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_C2_handlers[i + 3];
            if (ti < 0 || xm_C2_ctypes[ti].isInstance(t)) {
                return xm_C2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public java.lang.String D2() {
        xm_D2State st = new xm_D2State();
        st.v1o = this;
        return xm_D2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_D2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_D2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static java.lang.String xm_D2_run(xm_D2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_D2_c0(st);
            }
            else {
                done = xm_D2_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_D2_c0(xm_D2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0o = "table";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_D2_handler(st.pc, t);
            if (h < 0) {
                xm_D2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_D2_ctypes = {
    };
    private static final int[] xm_D2_handlers = {
        
    };
    private static int xm_D2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_D2_handlers.length; i += 4) {
            if (pc < xm_D2_handlers[i] || pc >= xm_D2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_D2_handlers[i + 3];
            if (ti < 0 || xm_D2_ctypes[ti].isInstance(t)) {
                return xm_D2_handlers[i + 2];
            }
        }
        return -1;
    }

    public void D3(luaj.LuaValue luaValue) {
        xm_D3State st = new xm_D3State();
        st.v4o = this;
        st.v5o = luaValue;
        xm_D3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_D3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_D3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static void xm_D3_run(xm_D3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 31) {
                done = xm_D3_c0(st);
            }
            else {
                done = xm_D3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_D3_c0(xm_D3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((luaj.LuaTable) st.v4o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 16777215;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i >= st.v1i) {
                            st.pc = 18;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v1o = ((luaj.LuaTable) st.v4o).S;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v1o == null) {
                            st.pc = 10;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.e) st.v1o).p()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v1i == 0) {
                            st.pc = 10;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        ((luaj.LuaTable) st.v4o).a3();
                    case 10:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v0i <= st.v1i) {
                            st.pc = 17;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.tmpI = (((luaj.LuaValue) st.v5o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 13:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v1i == 0) {
                            st.pc = 16;
                            continue;
                        }
                    case 15:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 16:
                        st.pc = 16;
                        ((luaj.LuaTable) st.v4o).n3(st.v0i, (luaj.LuaValue) st.v5o);
                    case 17:
                        st.pc = 17;
                        return true;
                    case 18:
                        st.pc = 18;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 21:
                        st.v3o = "array too big: ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.v0o = " >= ";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 26:
                        st.pc = 26;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.pc = 27;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v5o = new luaj.d((java.lang.String) st.v0o);
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 30:
                        st.pc = 30;
                        throw (java.lang.Throwable) st.v5o;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_D3_handler(st.pc, t);
            if (h < 0) {
                xm_D3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_D3_ctypes = {
    };
    private static final int[] xm_D3_handlers = {
        
    };
    private static int xm_D3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_D3_handlers.length; i += 4) {
            if (pc < xm_D3_handlers[i] || pc >= xm_D3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_D3_handlers[i + 3];
            if (ti < 0 || xm_D3_ctypes[ti].isInstance(t)) {
                return xm_D3_handlers[i + 2];
            }
        }
        return -1;
    }

    public java.lang.String E3(java.lang.Appendable appendable, java.util.Map map) {
        xm_E3State st = new xm_E3State();
        st.v2o = this;
        st.v3o = appendable;
        st.v4o = map;
        return xm_E3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_E3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_E3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static java.lang.String xm_E3_run(xm_E3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 21) {
                done = xm_E3_c0(st);
            }
            else {
                done = xm_E3_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_E3_c0(xm_E3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = luaj.LuaTable.V;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1o = "";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0o != null) {
                            st.pc = 16;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v0o = new java.util.HashSet();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        luaj.LuaTable.V = (java.util.Set) st.v0o;
                    case 6:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        luaj.LuaTable.W = st.v0i;
                    case 8:
                        st.pc = 8;
                        st.tmpO = ((luaj.LuaTable) st.v2o).b3((java.lang.String) st.v1o, (java.lang.Appendable) st.v3o, (java.util.Map) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((java.lang.Object) st.v3o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        luaj.LuaTable.W = st.v0i;
                    case 13:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 14:
                        st.pc = 14;
                        luaj.LuaTable.V = (java.util.Set) st.v4o;
                    case 15:
                        st.pc = 15;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((luaj.LuaTable) st.v2o).b3((java.lang.String) st.v1o, (java.lang.Appendable) st.v3o, (java.util.Map) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((java.lang.Object) st.v3o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_E3_handler(st.pc, t);
            if (h < 0) {
                xm_E3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_E3_ctypes = {
    };
    private static final int[] xm_E3_handlers = {
        
    };
    private static int xm_E3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_E3_handlers.length; i += 4) {
            if (pc < xm_E3_handlers[i] || pc >= xm_E3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_E3_handlers[i + 3];
            if (ti < 0 || xm_E3_ctypes[ti].isInstance(t)) {
                return xm_E3_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.Varargs F3(long j, long j2) {
        xm_F3State st = new xm_F3State();
        st.v10o = this;
        st.v11j = j;
        st.v13j = j2;
        return xm_F3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_F3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_F3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        java.lang.Object v10o;
        int v11i;
        long v11j;
        java.lang.Object v11o;
        double v11d;
        int v12i;
        long v12j;
        java.lang.Object v12o;
        double v12d;
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
        int v14i;
        long v14j;
        java.lang.Object v14o;
        double v14d;
    }

    private static luaj.Varargs xm_F3_run(xm_F3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 120) {
                done = xm_F3_c0(st);
            }
            else {
                done = xm_F3_c0(st);
            }
            if (done) {
                return (luaj.Varargs) st.resultO;
            }
        }
    }

    private static boolean xm_F3_c0(xm_F3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = Long.compare(st.v13j, st.v11j);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i >= 0) {
                            st.pc = 4;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v11o = luaj.LuaValue.f1676f;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.resultO = st.v11o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 4:
                        st.v0j = st.v13j - st.v11j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 5:
                        st.v2j = 0L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 6:
                        st.v4i = Long.compare(st.v0j, st.v2j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v4i < 0) {
                            st.pc = 116;
                            continue;
                        }
                    case 8:
                        st.v2j = 16777215L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 9:
                        st.v4i = Long.compare(st.v0j, st.v2j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v4i >= 0) {
                            st.pc = 101;
                            continue;
                        }
                    case 11:
                        st.v2j = 1L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.v0j = st.v0j + st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 13:
                        st.v1i = (int) st.v0j;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 14:
                        st.v0i = (int) st.v11j;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 15:
                        st.v4j = st.v0i;
                        st.v4d = java.lang.Double.longBitsToDouble(st.v4j);
                        st.v4i = 0;
                        st.v4o = null;
                    case 16:
                        st.v6i = 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 17:
                        st.v7i = Long.compare(st.v4j, st.v11j);
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 18:
                        st.pc = 18;
                        if (st.v7i != 0) {
                            st.pc = 25;
                            continue;
                        }
                    case 19:
                        st.v4i = (int) st.v13j;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 20:
                        st.v4j = st.v4i;
                        st.v4d = java.lang.Double.longBitsToDouble(st.v4j);
                        st.v4i = 0;
                        st.v4o = null;
                    case 21:
                        st.v7i = Long.compare(st.v4j, st.v13j);
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 22:
                        st.pc = 22;
                        if (st.v7i != 0) {
                            st.pc = 25;
                            continue;
                        }
                    case 23:
                        st.v13i = 1;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.pc = 26;
                        continue;
                    case 25:
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 26:
                        st.pc = 26;
                        if (st.v1i > 0) {
                            st.pc = 29;
                            continue;
                        }
                    case 27:
                        st.pc = 27;
                        st.v11o = luaj.LuaValue.f1676f;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.resultO = st.v11o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 29:
                        st.pc = 29;
                        if (st.v1i != st.v6i) {
                            st.pc = 39;
                            continue;
                        }
                    case 30:
                        st.pc = 30;
                        if (st.v13i == 0) {
                            st.pc = 34;
                            continue;
                        }
                    case 31:
                        st.pc = 31;
                        st.tmpO = ((luaj.LuaTable) st.v10o).c3(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 32:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 33:
                        st.pc = 33;
                        st.pc = 38;
                        continue;
                    case 34:
                        st.pc = 34;
                        st.tmpO = luaj.LuaLong.I2(st.v11j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 35:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.tmpO = ((luaj.LuaTable) st.v10o).U0((luaj.LuaValue) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 37:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.resultO = st.v11o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 39:
                        st.v14i = 2;
                        st.v14j = 0L;
                        st.v14o = null;
                        st.v14d = 0.0;
                    case 40:
                        st.pc = 40;
                        if (st.v1i != st.v14i) {
                            st.pc = 62;
                            continue;
                        }
                    case 41:
                        st.pc = 41;
                        if (st.v13i == 0) {
                            st.pc = 45;
                            continue;
                        }
                    case 42:
                        st.pc = 42;
                        st.tmpO = ((luaj.LuaTable) st.v10o).c3(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 43:
                        st.v14o = st.tmpO;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.pc = 49;
                        continue;
                    case 45:
                        st.pc = 45;
                        st.tmpO = luaj.LuaLong.I2(st.v11j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 46:
                        st.v14o = st.tmpO;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 47:
                        st.pc = 47;
                        st.tmpO = ((luaj.LuaTable) st.v10o).U0((luaj.LuaValue) st.v14o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 48:
                        st.v14o = st.tmpO;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 49:
                        st.v11j = st.v11j + st.v2j;
                        st.v11d = java.lang.Double.longBitsToDouble(st.v11j);
                        st.v11i = 0;
                        st.v11o = null;
                    case 50:
                        st.pc = 50;
                        if (st.v13i == 0) {
                            st.pc = 55;
                            continue;
                        }
                    case 51:
                        st.v12i = (int) st.v11j;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 52:
                        st.pc = 52;
                        st.tmpO = ((luaj.LuaTable) st.v10o).c3(st.v12i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 53:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.pc = 59;
                        continue;
                    case 55:
                        st.pc = 55;
                        st.tmpO = luaj.LuaLong.I2(st.v11j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 56:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 57:
                        st.pc = 57;
                        st.tmpO = ((luaj.LuaTable) st.v10o).U0((luaj.LuaValue) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 58:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 59:
                        st.pc = 59;
                        st.tmpO = luaj.LuaValue.N2((luaj.LuaValue) st.v14o, (luaj.Varargs) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 60:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 61:
                        st.pc = 61;
                        st.resultO = st.v11o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 62:
                        st.pc = 62;
                        st.v14o = new luaj.LuaValue[st.v1i];
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 63:
                        st.v1i = st.v1i + 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 64:
                        st.pc = 64;
                        if (st.v1i < 0) {
                            st.pc = 80;
                            continue;
                        }
                    case 65:
                        st.v2j = st.v1i;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 66:
                        st.v2j = st.v2j + st.v11j;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 67:
                        st.pc = 67;
                        if (st.v13i == 0) {
                            st.pc = 74;
                            continue;
                        }
                    case 68:
                        st.v0i = (int) st.v2j;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 69:
                        st.pc = 69;
                        st.tmpO = ((luaj.LuaTable) st.v10o).c3(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 70:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 71:
                        st.pc = 71;
                        st.pc = 78;
                        continue;
                    case 72:
                        st.pc = 72;
                        st.v11o = st.ex;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 73:
                        st.pc = 73;
                        st.pc = 83;
                        continue;
                    case 74:
                        st.pc = 74;
                        st.tmpO = luaj.LuaLong.I2(st.v2j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 75:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 76:
                        st.pc = 76;
                        st.tmpO = ((luaj.LuaTable) st.v10o).U0((luaj.LuaValue) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 77:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 78:
                        st.pc = 78;
                        ((java.lang.Object[]) st.v14o)[st.v1i] = st.v0o;
                    case 79:
                        st.pc = 79;
                        st.pc = 63;
                        continue;
                    case 80:
                        st.pc = 80;
                        st.tmpO = luaj.LuaValue.O2((luaj.LuaValue[]) st.v14o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 81:
                        st.v11o = st.tmpO;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 82:
                        st.pc = 82;
                        st.resultO = st.v11o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 83:
                        st.pc = 83;
                        st.v12o = null;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 84:
                        st.pc = 84;
                        st.v12o = new java.lang.StringBuilder();
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 85:
                        st.v13o = "OOM on unpack: ";
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 86:
                        st.pc = 86;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append((java.lang.String) st.v13o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 87:
                        st.pc = 87;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 88:
                        st.pc = 88;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 89:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 90:
                        st.pc = 90;
                        st.tmpI = android.ext.e1.l((java.lang.String) st.v12o, (java.lang.Throwable) st.v11o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 91:
                        st.pc = 91;
                        st.v11o = null;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 92:
                        st.pc = 92;
                        st.v12o = null;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 93:
                        st.pc = 93;
                        st.v12o = new java.lang.StringBuilder();
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 94:
                        st.v13o = "too many results to unpack [out of memory]: ";
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 95:
                        st.pc = 95;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append((java.lang.String) st.v13o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 96:
                        st.pc = 96;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 97:
                        st.pc = 97;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 98:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 99:
                        st.pc = 99;
                        st.v11o = new luaj.d((java.lang.String) st.v12o);
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 100:
                        st.pc = 100;
                        throw (java.lang.Throwable) st.v11o;
                    case 101:
                        st.pc = 101;
                        st.v11o = null;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 102:
                        st.pc = 102;
                        st.v12o = null;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 103:
                        st.pc = 103;
                        st.v12o = new java.lang.StringBuilder();
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 104:
                        st.v13o = "too many results to unpack: ";
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 105:
                        st.pc = 105;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append((java.lang.String) st.v13o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 106:
                        st.pc = 106;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 107:
                        st.v13o = " (max is ";
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 108:
                        st.pc = 108;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append((java.lang.String) st.v13o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 109:
                        st.pc = 109;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append(st.v2j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 110:
                        st.v13i = 41;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 111:
                        st.pc = 111;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).append((char) st.v13i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 112:
                        st.pc = 112;
                        st.tmpO = ((java.lang.StringBuilder) st.v12o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 113:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 114:
                        st.pc = 114;
                        st.v11o = new luaj.d((java.lang.String) st.v12o);
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 115:
                        st.pc = 115;
                        throw (java.lang.Throwable) st.v11o;
                    case 116:
                        st.pc = 116;
                        st.v11o = null;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 117:
                        st.v12o = "too many results to unpack: greater 9223372036854775807";
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 118:
                        st.pc = 118;
                        st.v11o = new luaj.d((java.lang.String) st.v12o);
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 119:
                        st.pc = 119;
                        throw (java.lang.Throwable) st.v11o;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_F3_handler(st.pc, t);
            if (h < 0) {
                xm_F3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_F3_ctypes = {
        java.lang.OutOfMemoryError.class
    };
    private static final int[] xm_F3_handlers = {
        62, 82, 72, 0
    };
    private static int xm_F3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_F3_handlers.length; i += 4) {
            if (pc < xm_F3_handlers[i] || pc >= xm_F3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_F3_handlers[i + 3];
            if (ti < 0 || xm_F3_ctypes[ti].isInstance(t)) {
                return xm_F3_handlers[i + 2];
            }
        }
        return -1;
    }

    public void G3(int i, luaj.LuaString luaString, double d2) {
        xm_G3State st = new xm_G3State();
        st.v6o = this;
        st.v7i = i;
        st.v8o = luaString;
        st.v9d = d2;
        xm_G3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_G3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_G3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        java.lang.Object v6o;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
    }

    private static void xm_G3_run(xm_G3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 20) {
                done = xm_G3_c0(st);
            }
            else {
                done = xm_G3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_G3_c0(xm_G3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v6o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1d = (float) st.v9d;
                        st.v1j = java.lang.Double.doubleToRawLongBits(st.v1d);
                        st.v1i = 0;
                        st.v1o = null;
                    case 2:
                        st.v2d = st.v1d;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 3:
                        st.pc = 3;
                        st.v4i = (Double.isNaN(st.v2d) || Double.isNaN(st.v9d) ? -1 : (st.v2d < st.v9d ? -1 : (st.v2d == st.v9d ? 0 : 1)));
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v4i != 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.v9o = null;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v9o = new luaj.LuaTable$f((luaj.LuaValue) st.v8o, (float) st.v1d);
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.pc = 11;
                        continue;
                    case 8:
                        st.pc = 8;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v1o = new luaj.LuaTable$d((luaj.LuaValue) st.v8o, st.v9d);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 10:
                        st.v9o = st.v1o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v8o = ((java.lang.Object[]) st.v0o)[st.v7i];
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v8o == null) {
                            st.pc = 15;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaTable$m) st.v8o).d((luaj.LuaTable$m) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((java.lang.Object[]) st.v0o)[st.v7i] = st.v9o;
                    case 16:
                        st.pc = 16;
                        st.v7i = ((luaj.LuaTable) st.v6o).R;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 17:
                        st.v7i = st.v7i + 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 18:
                        st.pc = 18;
                        ((luaj.LuaTable) st.v6o).R = st.v7i;
                    case 19:
                        st.pc = 19;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_G3_handler(st.pc, t);
            if (h < 0) {
                xm_G3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_G3_ctypes = {
    };
    private static final int[] xm_G3_handlers = {
        
    };
    private static int xm_G3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_G3_handlers.length; i += 4) {
            if (pc < xm_G3_handlers[i] || pc >= xm_G3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_G3_handlers[i + 3];
            if (ti < 0 || xm_G3_ctypes[ti].isInstance(t)) {
                return xm_G3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaTable H0() {
        xm_H0State st = new xm_H0State();
        st.v0o = this;
        return xm_H0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_H0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_H0State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
    }

    private static luaj.LuaTable xm_H0_run(xm_H0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 1) {
                done = xm_H0_c0(st);
            }
            else {
                done = xm_H0_c0(st);
            }
            if (done) {
                return (luaj.LuaTable) st.resultO;
            }
        }
    }

    private static boolean xm_H0_c0(xm_H0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_H0_handler(st.pc, t);
            if (h < 0) {
                xm_H0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_H0_ctypes = {
    };
    private static final int[] xm_H0_handlers = {
        
    };
    private static int xm_H0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_H0_handlers.length; i += 4) {
            if (pc < xm_H0_handlers[i] || pc >= xm_H0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_H0_handlers[i + 3];
            if (ti < 0 || xm_H0_ctypes[ti].isInstance(t)) {
                return xm_H0_handlers[i + 2];
            }
        }
        return -1;
    }

    public void H3(int i, luaj.LuaString luaString, float f2) {
        xm_H3State st = new xm_H3State();
        st.v2o = this;
        st.v3i = i;
        st.v4o = luaString;
        st.v5d = f2;
        xm_H3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_H3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_H3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        double v5d;
    }

    private static void xm_H3_run(xm_H3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 12) {
                done = xm_H3_c0(st);
            }
            else {
                done = xm_H3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_H3_c0(xm_H3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v2o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1o = new luaj.LuaTable$f((luaj.LuaValue) st.v4o, (float) st.v5d);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v4o = ((java.lang.Object[]) st.v0o)[st.v3i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v4o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.LuaTable$m) st.v4o).d((luaj.LuaTable$m) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((java.lang.Object[]) st.v0o)[st.v3i] = st.v1o;
                    case 8:
                        st.pc = 8;
                        st.v3i = ((luaj.LuaTable) st.v2o).R;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 9:
                        st.v3i = st.v3i + 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((luaj.LuaTable) st.v2o).R = st.v3i;
                    case 11:
                        st.pc = 11;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_H3_handler(st.pc, t);
            if (h < 0) {
                xm_H3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_H3_ctypes = {
    };
    private static final int[] xm_H3_handlers = {
        
    };
    private static int xm_H3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_H3_handlers.length; i += 4) {
            if (pc < xm_H3_handlers[i] || pc >= xm_H3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_H3_handlers[i + 3];
            if (ti < 0 || xm_H3_ctypes[ti].isInstance(t)) {
                return xm_H3_handlers[i + 2];
            }
        }
        return -1;
    }

    public void I3(int i, luaj.LuaString luaString, int i2) {
        xm_I3State st = new xm_I3State();
        st.v2o = this;
        st.v3i = i;
        st.v4o = luaString;
        st.v5i = i2;
        xm_I3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_I3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_I3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
    }

    private static void xm_I3_run(xm_I3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 12) {
                done = xm_I3_c0(st);
            }
            else {
                done = xm_I3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_I3_c0(xm_I3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v2o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1o = new luaj.LuaTable$h((luaj.LuaValue) st.v4o, st.v5i);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v4o = ((java.lang.Object[]) st.v0o)[st.v3i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v4o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.LuaTable$m) st.v4o).d((luaj.LuaTable$m) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((java.lang.Object[]) st.v0o)[st.v3i] = st.v1o;
                    case 8:
                        st.pc = 8;
                        st.v3i = ((luaj.LuaTable) st.v2o).R;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 9:
                        st.v3i = st.v3i + 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((luaj.LuaTable) st.v2o).R = st.v3i;
                    case 11:
                        st.pc = 11;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_I3_handler(st.pc, t);
            if (h < 0) {
                xm_I3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_I3_ctypes = {
    };
    private static final int[] xm_I3_handlers = {
        
    };
    private static int xm_I3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_I3_handlers.length; i += 4) {
            if (pc < xm_I3_handlers[i] || pc >= xm_I3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_I3_handlers[i + 3];
            if (ti < 0 || xm_I3_ctypes[ti].isInstance(t)) {
                return xm_I3_handlers[i + 2];
            }
        }
        return -1;
    }

    public void J3(int i, luaj.LuaString luaString, long j) {
        xm_J3State st = new xm_J3State();
        st.v6o = this;
        st.v7i = i;
        st.v8o = luaString;
        st.v9j = j;
        xm_J3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_J3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_J3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        java.lang.Object v6o;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
    }

    private static void xm_J3_run(xm_J3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 20) {
                done = xm_J3_c0(st);
            }
            else {
                done = xm_J3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_J3_c0(xm_J3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v6o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = (int) st.v9j;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v2j = st.v1i;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 3:
                        st.v4i = Long.compare(st.v2j, st.v9j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v4i != 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.v9o = null;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v9o = new luaj.LuaTable$h((luaj.LuaValue) st.v8o, st.v1i);
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.pc = 11;
                        continue;
                    case 8:
                        st.pc = 8;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v1o = new luaj.LuaTable$k((luaj.LuaValue) st.v8o, st.v9j);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 10:
                        st.v9o = st.v1o;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v8o = ((java.lang.Object[]) st.v0o)[st.v7i];
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v8o == null) {
                            st.pc = 15;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaTable$m) st.v8o).d((luaj.LuaTable$m) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((java.lang.Object[]) st.v0o)[st.v7i] = st.v9o;
                    case 16:
                        st.pc = 16;
                        st.v7i = ((luaj.LuaTable) st.v6o).R;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 17:
                        st.v7i = st.v7i + 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 18:
                        st.pc = 18;
                        ((luaj.LuaTable) st.v6o).R = st.v7i;
                    case 19:
                        st.pc = 19;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_J3_handler(st.pc, t);
            if (h < 0) {
                xm_J3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_J3_ctypes = {
    };
    private static final int[] xm_J3_handlers = {
        
    };
    private static int xm_J3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_J3_handlers.length; i += 4) {
            if (pc < xm_J3_handlers[i] || pc >= xm_J3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_J3_handlers[i + 3];
            if (ti < 0 || xm_J3_ctypes[ti].isInstance(t)) {
                return xm_J3_handlers[i + 2];
            }
        }
        return -1;
    }

    public void K3(int i, luaj.LuaString luaString, boolean z) {
        xm_K3State st = new xm_K3State();
        st.v2o = this;
        st.v3i = i;
        st.v4o = luaString;
        st.v5i = (z ? 1 : 0);
        xm_K3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_K3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_K3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
    }

    private static void xm_K3_run(xm_K3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 12) {
                done = xm_K3_c0(st);
            }
            else {
                done = xm_K3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_K3_c0(xm_K3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v2o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1o = new luaj.LuaTable$b((luaj.LuaValue) st.v4o, (st.v5i != 0));
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v4o = ((java.lang.Object[]) st.v0o)[st.v3i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v4o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.LuaTable$m) st.v4o).d((luaj.LuaTable$m) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((java.lang.Object[]) st.v0o)[st.v3i] = st.v1o;
                    case 8:
                        st.pc = 8;
                        st.v3i = ((luaj.LuaTable) st.v2o).R;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 9:
                        st.v3i = st.v3i + 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((luaj.LuaTable) st.v2o).R = st.v3i;
                    case 11:
                        st.pc = 11;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_K3_handler(st.pc, t);
            if (h < 0) {
                xm_K3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_K3_ctypes = {
    };
    private static final int[] xm_K3_handlers = {
        
    };
    private static int xm_K3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_K3_handlers.length; i += 4) {
            if (pc < xm_K3_handlers[i] || pc >= xm_K3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_K3_handlers[i + 3];
            if (ti < 0 || xm_K3_ctypes[ti].isInstance(t)) {
                return xm_K3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaTable L1(luaj.LuaTable luaTable) {
        xm_L1State st = new xm_L1State();
        st.v0o = this;
        st.v1o = luaTable;
        return xm_L1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_L1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_L1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
        java.lang.Object v1o;
    }

    private static luaj.LuaTable xm_L1_run(xm_L1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 1) {
                done = xm_L1_c0(st);
            }
            else {
                done = xm_L1_c0(st);
            }
            if (done) {
                return (luaj.LuaTable) st.resultO;
            }
        }
    }

    private static boolean xm_L1_c0(xm_L1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_L1_handler(st.pc, t);
            if (h < 0) {
                xm_L1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_L1_ctypes = {
    };
    private static final int[] xm_L1_handlers = {
        
    };
    private static int xm_L1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_L1_handlers.length; i += 4) {
            if (pc < xm_L1_handlers[i] || pc >= xm_L1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_L1_handlers[i + 3];
            if (ti < 0 || xm_L1_ctypes[ti].isInstance(t)) {
                return xm_L1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean P0(luaj.LuaValue luaValue) {
        xm_P0State st = new xm_P0State();
        st.v1o = this;
        st.v2o = luaValue;
        return xm_P0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_P0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_P0State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
    }

    private static boolean xm_P0_run(xm_P0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 11) {
                done = xm_P0_c0(st);
            }
            else {
                done = xm_P0_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_P0_c0(xm_P0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v1o != st.v2o) {
                            st.pc = 3;
                            continue;
                        }
                    case 1:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 3:
                        st.pc = 3;
                        st.tmpI = (((luaj.LuaValue) st.v2o).o1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i != 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 6:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 8:
                        st.pc = 8;
                        st.tmpI = (luaj.LuaValue.Q0((luaj.LuaValue) st.v1o, (luaj.LuaValue) st.v2o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_P0_handler(st.pc, t);
            if (h < 0) {
                xm_P0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_P0_ctypes = {
    };
    private static final int[] xm_P0_handlers = {
        
    };
    private static int xm_P0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_P0_handlers.length; i += 4) {
            if (pc < xm_P0_handlers[i] || pc >= xm_P0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_P0_handlers[i + 3];
            if (ti < 0 || xm_P0_ctypes[ti].isInstance(t)) {
                return xm_P0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public void R1(int i) {
        xm_R1State st = new xm_R1State();
        st.v2o = this;
        st.v3i = i;
        xm_R1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_R1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_R1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static void xm_R1_run(xm_R1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 11) {
                done = xm_R1_c0(st);
            }
            else {
                done = xm_R1_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_R1_c0(xm_R1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v2o).P;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v3i <= st.v1i) {
                            st.pc = 10;
                            continue;
                        }
                    case 3:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = luaj.LuaTable.u3(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 6:
                        st.v3i = st.v1i << st.v3i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = luaj.LuaTable.A3((luaj.LuaValue[]) st.v0o, st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        ((luaj.LuaTable) st.v2o).P = (luaj.LuaValue[]) st.v3o;
                    case 10:
                        st.pc = 10;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_R1_handler(st.pc, t);
            if (h < 0) {
                xm_R1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_R1_ctypes = {
    };
    private static final int[] xm_R1_handlers = {
        
    };
    private static int xm_R1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_R1_handlers.length; i += 4) {
            if (pc < xm_R1_handlers[i] || pc >= xm_R1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_R1_handlers[i + 3];
            if (ti < 0 || xm_R1_ctypes[ti].isInstance(t)) {
                return xm_R1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue U0(luaj.LuaValue luaValue) {
        xm_U0State st = new xm_U0State();
        st.v2o = this;
        st.v3o = luaValue;
        return xm_U0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_U0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_U0State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        java.lang.Object v3o;
    }

    private static luaj.LuaValue xm_U0_run(xm_U0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 10) {
                done = xm_U0_c0(st);
            }
            else {
                done = xm_U0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_U0_c0(xm_U0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaTable) st.v2o).V1((luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpI = (((luaj.LuaValue) st.v0o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v1i == 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.v1o = ((luaj.LuaTable) st.v2o).S;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v1o == null) {
                            st.pc = 9;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.tmpO = luaj.LuaValue.W0((luaj.LuaValue) st.v2o, (luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_U0_handler(st.pc, t);
            if (h < 0) {
                xm_U0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_U0_ctypes = {
    };
    private static final int[] xm_U0_handlers = {
        
    };
    private static int xm_U0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_U0_handlers.length; i += 4) {
            if (pc < xm_U0_handlers[i] || pc >= xm_U0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_U0_handlers[i + 3];
            if (ti < 0 || xm_U0_ctypes[ti].isInstance(t)) {
                return xm_U0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue V0() {
        xm_V0State st = new xm_V0State();
        st.v1o = this;
        return xm_V0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_V0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_V0State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static luaj.LuaValue xm_V0_run(xm_V0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 7) {
                done = xm_V0_c0(st);
            }
            else {
                done = xm_V0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_V0_c0(xm_V0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v1o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0o == null) {
                            st.pc = 5;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((luaj.e) st.v0o).e();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 6;
                        continue;
                    case 5:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_V0_handler(st.pc, t);
            if (h < 0) {
                xm_V0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_V0_ctypes = {
    };
    private static final int[] xm_V0_handlers = {
        
    };
    private static int xm_V0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_V0_handlers.length; i += 4) {
            if (pc < xm_V0_handlers[i] || pc >= xm_V0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_V0_handlers[i + 3];
            if (ti < 0 || xm_V0_ctypes[ti].isInstance(t)) {
                return xm_V0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue V1(luaj.LuaValue luaValue) {
        xm_V1State st = new xm_V1State();
        st.v3o = this;
        st.v4o = luaValue;
        return xm_V1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_V1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_V1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static luaj.LuaValue xm_V1_run(xm_V1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 23) {
                done = xm_V1_c0(st);
            }
            else {
                done = xm_V1_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_V1_c0(xm_V1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v4o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i == 0) {
                            st.pc = 20;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((luaj.LuaValue) st.v4o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i <= 0) {
                            st.pc = 20;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.v1o = ((luaj.LuaTable) st.v3o).P;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v2i = java.lang.reflect.Array.getLength(st.v1o);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v0i > st.v2i) {
                            st.pc = 20;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.v4o = ((luaj.LuaTable) st.v3o).S;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 10:
                        st.v0i = st.v0i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v4o != null) {
                            st.pc = 14;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.v4o = ((java.lang.Object[]) st.v1o)[st.v0i];
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.pc = 16;
                        continue;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((luaj.e) st.v4o).o((luaj.LuaValue[]) st.v1o, st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 16:
                        st.pc = 16;
                        if (st.v4o == null) {
                            st.pc = 18;
                            continue;
                        }
                    case 17:
                        st.pc = 17;
                        st.pc = 19;
                        continue;
                    case 18:
                        st.pc = 18;
                        st.v4o = luaj.LuaValue.f1673c;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 20:
                        st.pc = 20;
                        st.tmpO = ((luaj.LuaTable) st.v3o).k3((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 21:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_V1_handler(st.pc, t);
            if (h < 0) {
                xm_V1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_V1_ctypes = {
    };
    private static final int[] xm_V1_handlers = {
        
    };
    private static int xm_V1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_V1_handlers.length; i += 4) {
            if (pc < xm_V1_handlers[i] || pc >= xm_V1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_V1_handlers[i + 3];
            if (ti < 0 || xm_V1_ctypes[ti].isInstance(t)) {
                return xm_V1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public int W1() {
        xm_W1State st = new xm_W1State();
        st.v5o = this;
        return xm_W1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_W1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_W1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        java.lang.Object v5o;
    }

    private static int xm_W1_run(xm_W1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 41) {
                done = xm_W1_c0(st);
            }
            else {
                done = xm_W1_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_W1_c0(xm_W1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((luaj.LuaTable) st.v5o).d3();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i == 0) {
                            st.pc = 11;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((luaj.LuaTable) st.v5o).x3(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v1o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v1i != 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.pc = 11;
                        continue;
                    case 9:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.pc = 29;
                        continue;
                    case 11:
                        st.v1i = st.v0i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 12:
                        st.v2i = st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaTable) st.v5o).x3(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpI = (((luaj.LuaValue) st.v3o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 16:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.pc = 17;
                        if (st.v3i != 0) {
                            st.pc = 27;
                            continue;
                        }
                    case 18:
                        st.pc = 18;
                        st.tmpI = ((luaj.LuaTable) st.v5o).f3();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 20:
                        st.v2i = st.v2i + st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 21:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 22:
                        st.v2i = st.v2i + st.v1i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 23:
                        st.v4i = st.v2i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 24:
                        st.v2i = st.v1i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 25:
                        st.v1i = st.v4i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.pc = 13;
                        continue;
                    case 27:
                        st.v0i = st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 28:
                        st.v1i = st.v2i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 29:
                        st.v2i = st.v1i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 30:
                        st.pc = 30;
                        if (st.v0i <= st.v2i) {
                            st.pc = 40;
                            continue;
                        }
                    case 31:
                        st.v2i = st.v1i + st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.v2i = st.v2i / 2;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 33:
                        st.pc = 33;
                        st.tmpO = ((luaj.LuaTable) st.v5o).x3(st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 34:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.tmpI = (((luaj.LuaValue) st.v3o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 36:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 37:
                        st.pc = 37;
                        if (st.v3i == 0) {
                            st.pc = 28;
                            continue;
                        }
                    case 38:
                        st.v0i = st.v2i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.pc = 29;
                        continue;
                    case 40:
                        st.pc = 40;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_W1_handler(st.pc, t);
            if (h < 0) {
                xm_W1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_W1_ctypes = {
    };
    private static final int[] xm_W1_handlers = {
        
    };
    private static int xm_W1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_W1_handlers.length; i += 4) {
            if (pc < xm_W1_handlers[i] || pc >= xm_W1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_W1_handlers[i + 3];
            if (ti < 0 || xm_W1_ctypes[ti].isInstance(t)) {
                return xm_W1_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.LuaValue W2(luaj.LuaString luaString, int i, int i2) {
        xm_W2State st = new xm_W2State();
        st.v2o = this;
        st.v3o = luaString;
        st.v4i = i;
        st.v5i = i2;
        return xm_W2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_W2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_W2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
    }

    private static luaj.LuaValue xm_W2_run(xm_W2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 17) {
                done = xm_W2_c0(st);
            }
            else {
                done = xm_W2_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_W2_c0(xm_W2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0o = new gg_f.a();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v4i > st.v5i) {
                            st.pc = 14;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((luaj.LuaTable) st.v2o).c3(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.LuaValue) st.v1o).G0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((gg_f.a) st.v0o).c((luaj.LuaString) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v1i = 2147483647;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v4i >= st.v1i) {
                            st.pc = 14;
                            continue;
                        }
                    case 10:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v4i > st.v5i) {
                            st.pc = 14;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.tmpO = ((gg_f.a) st.v0o).c((luaj.LuaString) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 13:
                        st.pc = 13;
                        st.pc = 3;
                        continue;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((gg_f.a) st.v0o).l();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_W2_handler(st.pc, t);
            if (h < 0) {
                xm_W2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_W2_ctypes = {
    };
    private static final int[] xm_W2_handlers = {
        
    };
    private static int xm_W2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_W2_handlers.length; i += 4) {
            if (pc < xm_W2_handlers[i] || pc >= xm_W2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_W2_handlers[i + 3];
            if (ti < 0 || xm_W2_ctypes[ti].isInstance(t)) {
                return xm_W2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public void Y1(int i, luaj.LuaValue luaValue) {
        xm_Y1State st = new xm_Y1State();
        st.v2o = this;
        st.v3i = i;
        st.v4o = luaValue;
        xm_Y1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_Y1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_Y1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        java.lang.Object v4o;
    }

    private static void xm_Y1_run(xm_Y1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 10) {
                done = xm_Y1_c0(st);
            }
            else {
                done = xm_Y1_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_Y1_c0(xm_Y1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v4o != null) {
                            st.pc = 2;
                            continue;
                        }
                    case 1:
                        st.pc = 1;
                        return true;
                    case 2:
                        st.pc = 2;
                        st.tmpI = (((luaj.LuaTable) st.v2o).U2(st.v3i, (luaj.LuaValue) st.v4o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0i != 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 5:
                        st.v0j = st.v3i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 6:
                        st.pc = 6;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 7:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        ((luaj.LuaTable) st.v2o).m3((luaj.LuaValue) st.v3o, (luaj.LuaValue) st.v4o);
                    case 9:
                        st.pc = 9;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_Y1_handler(st.pc, t);
            if (h < 0) {
                xm_Y1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_Y1_ctypes = {
    };
    private static final int[] xm_Y1_handlers = {
        
    };
    private static int xm_Y1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_Y1_handlers.length; i += 4) {
            if (pc < xm_Y1_handlers[i] || pc >= xm_Y1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_Y1_handlers[i + 3];
            if (ti < 0 || xm_Y1_ctypes[ti].isInstance(t)) {
                return xm_Y1_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.LuaValue c3(int i) {
        xm_c3State st = new xm_c3State();
        st.v2o = this;
        st.v3i = i;
        return xm_c3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_c3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_c3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static luaj.LuaValue xm_c3_run(xm_c3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 13) {
                done = xm_c3_c0(st);
            }
            else {
                done = xm_c3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_c3_c0(xm_c3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaTable) st.v2o).x3(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpI = (((luaj.LuaValue) st.v0o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v1i == 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.v1o = ((luaj.LuaTable) st.v2o).S;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v1o == null) {
                            st.pc = 12;
                            continue;
                        }
                    case 7:
                        st.v0j = st.v3i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 8:
                        st.pc = 8;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpO = luaj.LuaValue.W0((luaj.LuaValue) st.v2o, (luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_c3_handler(st.pc, t);
            if (h < 0) {
                xm_c3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_c3_ctypes = {
    };
    private static final int[] xm_c3_handlers = {
        
    };
    private static int xm_c3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_c3_handlers.length; i += 4) {
            if (pc < xm_c3_handlers[i] || pc >= xm_c3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_c3_handlers[i + 3];
            if (ti < 0 || xm_c3_ctypes[ti].isInstance(t)) {
                return xm_c3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public void d2(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        xm_d2State st = new xm_d2State();
        st.v1o = this;
        st.v2o = luaValue;
        st.v3o = luaValue2;
        xm_d2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_d2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_d2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
        java.lang.Object v2o;
        java.lang.Object v3o;
    }

    private static void xm_d2_run(xm_d2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 13) {
                done = xm_d2_c0(st);
            }
            else {
                done = xm_d2_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_d2_c0(xm_d2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v2o == null) {
                            st.pc = 12;
                            continue;
                        }
                    case 1:
                        st.pc = 1;
                        if (st.v3o != null) {
                            st.pc = 3;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.pc = 12;
                        continue;
                    case 3:
                        st.pc = 3;
                        st.tmpI = (((luaj.LuaValue) st.v2o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i == 0) {
                            st.pc = 11;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.tmpI = ((luaj.LuaValue) st.v2o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpI = (((luaj.LuaTable) st.v1o).U2(st.v0i, (luaj.LuaValue) st.v3o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v0i != 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        ((luaj.LuaTable) st.v1o).m3((luaj.LuaValue) st.v2o, (luaj.LuaValue) st.v3o);
                    case 12:
                        st.pc = 12;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_d2_handler(st.pc, t);
            if (h < 0) {
                xm_d2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_d2_ctypes = {
    };
    private static final int[] xm_d2_handlers = {
        
    };
    private static int xm_d2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_d2_handlers.length; i += 4) {
            if (pc < xm_d2_handlers[i] || pc >= xm_d2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_d2_handlers[i + 3];
            if (ti < 0 || xm_d2_ctypes[ti].isInstance(t)) {
                return xm_d2_handlers[i + 2];
            }
        }
        return -1;
    }

    public int d3() {
        xm_d3State st = new xm_d3State();
        st.v1o = this;
        return xm_d3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_d3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_d3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static int xm_d3_run(xm_d3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_d3_c0(st);
            }
            else {
                done = xm_d3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_d3_c0(xm_d3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v1o).P;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_d3_handler(st.pc, t);
            if (h < 0) {
                xm_d3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_d3_ctypes = {
    };
    private static final int[] xm_d3_handlers = {
        
    };
    private static int xm_d3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_d3_handlers.length; i += 4) {
            if (pc < xm_d3_handlers[i] || pc >= xm_d3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_d3_handlers[i + 3];
            if (ti < 0 || xm_d3_ctypes[ti].isInstance(t)) {
                return xm_d3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.e
    public luaj.LuaValue e() {
        xm_eState st = new xm_eState();
        st.v0o = this;
        return xm_e_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_e_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_eState {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
    }

    private static luaj.LuaValue xm_e_run(xm_eState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 1) {
                done = xm_e_c0(st);
            }
            else {
                done = xm_e_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_e_c0(xm_eState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_e_handler(st.pc, t);
            if (h < 0) {
                xm_e_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_e_ctypes = {
    };
    private static final int[] xm_e_handlers = {
        
    };
    private static int xm_e_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_e_handlers.length; i += 4) {
            if (pc < xm_e_handlers[i] || pc >= xm_e_handlers[i + 1]) {
                continue;
            }
            int ti = xm_e_handlers[i + 3];
            if (ti < 0 || xm_e_ctypes[ti].isInstance(t)) {
                return xm_e_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public void e2(int i, luaj.LuaValue luaValue) {
        xm_e2State st = new xm_e2State();
        st.v2o = this;
        st.v3i = i;
        st.v4o = luaValue;
        xm_e2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_e2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_e2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v2o;
        int v3i;
        java.lang.Object v4o;
    }

    private static void xm_e2_run(xm_e2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 15) {
                done = xm_e2_c0(st);
            }
            else {
                done = xm_e2_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_e2_c0(xm_e2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v2o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0o == null) {
                            st.pc = 13;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((luaj.LuaTable) st.v2o).x3(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = (((luaj.LuaValue) st.v0o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v0i == 0) {
                            st.pc = 13;
                            continue;
                        }
                    case 7:
                        st.v0j = st.v3i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 8:
                        st.pc = 8;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpI = (luaj.LuaValue.l2((luaj.LuaValue) st.v2o, (luaj.LuaValue) st.v0o, (luaj.LuaValue) st.v4o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 11:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v0i != 0) {
                            st.pc = 14;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        ((luaj.LuaTable) st.v2o).Y1(st.v3i, (luaj.LuaValue) st.v4o);
                    case 14:
                        st.pc = 14;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_e2_handler(st.pc, t);
            if (h < 0) {
                xm_e2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_e2_ctypes = {
    };
    private static final int[] xm_e2_handlers = {
        
    };
    private static int xm_e2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_e2_handlers.length; i += 4) {
            if (pc < xm_e2_handlers[i] || pc >= xm_e2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_e2_handlers[i + 3];
            if (ti < 0 || xm_e2_ctypes[ti].isInstance(t)) {
                return xm_e2_handlers[i + 2];
            }
        }
        return -1;
    }

    public int e3() {
        xm_e3State st = new xm_e3State();
        st.v1o = this;
        return xm_e3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_e3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_e3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static int xm_e3_run(xm_e3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_e3_c0(st);
            }
            else {
                done = xm_e3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_e3_c0(xm_e3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((luaj.LuaTable) st.v1o).R;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_e3_handler(st.pc, t);
            if (h < 0) {
                xm_e3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_e3_ctypes = {
    };
    private static final int[] xm_e3_handlers = {
        
    };
    private static int xm_e3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_e3_handlers.length; i += 4) {
            if (pc < xm_e3_handlers[i] || pc >= xm_e3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_e3_handlers[i + 3];
            if (ti < 0 || xm_e3_ctypes[ti].isInstance(t)) {
                return xm_e3_handlers[i + 2];
            }
        }
        return -1;
    }

    public int f3() {
        xm_f3State st = new xm_f3State();
        st.v1o = this;
        return xm_f3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_f3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_f3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static int xm_f3_run(xm_f3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_f3_c0(st);
            }
            else {
                done = xm_f3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_f3_c0(xm_f3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v1o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_f3_handler(st.pc, t);
            if (h < 0) {
                xm_f3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_f3_ctypes = {
    };
    private static final int[] xm_f3_handlers = {
        
    };
    private static int xm_f3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_f3_handlers.length; i += 4) {
            if (pc < xm_f3_handlers[i] || pc >= xm_f3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_f3_handlers[i + 3];
            if (ti < 0 || xm_f3_ctypes[ti].isInstance(t)) {
                return xm_f3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.e
    public luaj.LuaValue g(luaj.LuaValue luaValue) {
        xm_gState st = new xm_gState();
        st.v0o = this;
        st.v1o = luaValue;
        return xm_g_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_g_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_gState {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
        java.lang.Object v1o;
    }

    private static luaj.LuaValue xm_g_run(xm_gState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 1) {
                done = xm_g_c0(st);
            }
            else {
                done = xm_g_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_g_c0(xm_gState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_g_handler(st.pc, t);
            if (h < 0) {
                xm_g_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_g_ctypes = {
    };
    private static final int[] xm_g_handlers = {
        
    };
    private static int xm_g_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_g_handlers.length; i += 4) {
            if (pc < xm_g_handlers[i] || pc >= xm_g_handlers[i + 1]) {
                continue;
            }
            int ti = xm_g_handlers[i + 3];
            if (ti < 0 || xm_g_ctypes[ti].isInstance(t)) {
                return xm_g_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        xm_g0State st = new xm_g0State();
        st.v2o = this;
        return xm_g0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_g0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_g0State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
    }

    private static java.lang.String xm_g0_run(xm_g0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 10) {
                done = xm_g0_c0(st);
            }
            else {
                done = xm_g0_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_g0_c0(xm_g0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((luaj.LuaTable) st.v2o).E3((java.lang.Appendable) st.v0o, (java.util.Map) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 6:
                        st.pc = 6;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v1o = new java.lang.RuntimeException((java.lang.Throwable) st.v0o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        throw (java.lang.Throwable) st.v1o;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_g0_handler(st.pc, t);
            if (h < 0) {
                xm_g0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_g0_ctypes = {
        java.io.IOException.class
    };
    private static final int[] xm_g0_handlers = {
        0, 5, 6, 0
    };
    private static int xm_g0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_g0_handlers.length; i += 4) {
            if (pc < xm_g0_handlers[i] || pc >= xm_g0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_g0_handlers[i + 3];
            if (ti < 0 || xm_g0_ctypes[ti].isInstance(t)) {
                return xm_g0_handlers[i + 2];
            }
        }
        return -1;
    }

    public long g3(luaj.LuaValue luaValue) {
        xm_g3State st = new xm_g3State();
        st.v2o = this;
        st.v3o = luaValue;
        return xm_g3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_g3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_g3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static long xm_g3_run(xm_g3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 30) {
                done = xm_g3_c0(st);
            }
            else {
                done = xm_g3_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_g3_c0(xm_g3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaTable) st.v2o).C3((luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0o != null) {
                            st.pc = 12;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v0o = ((luaj.LuaTable) st.v2o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0o == null) {
                            st.pc = 8;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.tmpO = luaj.LuaValue.W0((luaj.LuaValue) st.v2o, (luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.pc = 9;
                        continue;
                    case 8:
                        st.pc = 8;
                        st.v3o = luaj.LuaValue.f1673c;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpJ = ((luaj.LuaValue) st.v3o).C0();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 10:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 11:
                        st.pc = 11;
                        st.resultJ = st.v0j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 12:
                        st.v3i = (st.v0o instanceof luaj.LuaTable$h) ? 1 : 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v3i == 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 14:
                        st.pc = 14;
                        st.v0o = (luaj.LuaTable$h) st.v0o;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpI = ((luaj.LuaTable$h) st.v0o).k0();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 16:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.v0j = st.v3i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 18:
                        st.pc = 18;
                        st.resultJ = st.v0j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 19:
                        st.v3i = (st.v0o instanceof luaj.LuaTable$k) ? 1 : 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 20:
                        st.pc = 20;
                        if (st.v3i == 0) {
                            st.pc = 25;
                            continue;
                        }
                    case 21:
                        st.pc = 21;
                        st.v0o = (luaj.LuaTable$k) st.v0o;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.tmpJ = ((luaj.LuaTable$k) st.v0o).k0();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 23:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 24:
                        st.pc = 24;
                        st.resultJ = st.v0j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 25:
                        st.pc = 25;
                        st.tmpO = ((luaj.LuaTable$n) st.v0o).t();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 26:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.tmpJ = ((luaj.LuaValue) st.v3o).C0();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 28:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 29:
                        st.pc = 29;
                        st.resultJ = st.v0j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_g3_handler(st.pc, t);
            if (h < 0) {
                xm_g3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_g3_ctypes = {
    };
    private static final int[] xm_g3_handlers = {
        
    };
    private static int xm_g3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_g3_handlers.length; i += 4) {
            if (pc < xm_g3_handlers[i] || pc >= xm_g3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_g3_handlers[i + 3];
            if (ti < 0 || xm_g3_ctypes[ti].isInstance(t)) {
                return xm_g3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public void j2(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        xm_j2State st = new xm_j2State();
        st.v2o = this;
        st.v3o = luaValue;
        st.v4o = luaValue2;
        xm_j2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_j2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_j2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static void xm_j2_run(xm_j2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 34) {
                done = xm_j2_c0(st);
            }
            else {
                done = xm_j2_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_j2_c0(xm_j2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v3o == null) {
                            st.pc = 22;
                            continue;
                        }
                    case 1:
                        st.pc = 1;
                        st.tmpI = (((luaj.LuaValue) st.v3o).q1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i != 0) {
                            st.pc = 10;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v0o = luaj.LuaValue.m;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.LuaValue) st.v2o).x1((luaj.LuaValue) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpI = (((luaj.LuaValue) st.v0o).g1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 8:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v0i == 0) {
                            st.pc = 22;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v0o = ((luaj.LuaTable) st.v2o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v0o == null) {
                            st.pc = 20;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.tmpO = ((luaj.LuaTable) st.v2o).V1((luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 13:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpI = (((luaj.LuaValue) st.v0o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 15:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 16:
                        st.pc = 16;
                        if (st.v0i == 0) {
                            st.pc = 20;
                            continue;
                        }
                    case 17:
                        st.pc = 17;
                        st.tmpI = (luaj.LuaValue.l2((luaj.LuaValue) st.v2o, (luaj.LuaValue) st.v3o, (luaj.LuaValue) st.v4o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 18:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 19:
                        st.pc = 19;
                        if (st.v0i != 0) {
                            st.pc = 21;
                            continue;
                        }
                    case 20:
                        st.pc = 20;
                        ((luaj.LuaTable) st.v2o).d2((luaj.LuaValue) st.v3o, (luaj.LuaValue) st.v4o);
                    case 21:
                        st.pc = 21;
                        return true;
                    case 22:
                        st.pc = 22;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 25:
                        st.v1o = "value ('";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.pc = 27;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.v3o = "') can not be used as a table index";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.pc = 30;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 31:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.v4o = new luaj.d((java.lang.String) st.v3o);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 33:
                        st.pc = 33;
                        throw (java.lang.Throwable) st.v4o;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_j2_handler(st.pc, t);
            if (h < 0) {
                xm_j2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_j2_ctypes = {
    };
    private static final int[] xm_j2_handlers = {
        
    };
    private static int xm_j2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_j2_handlers.length; i += 4) {
            if (pc < xm_j2_handlers[i] || pc >= xm_j2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_j2_handlers[i + 3];
            if (ti < 0 || xm_j2_ctypes[ti].isInstance(t)) {
                return xm_j2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.e
    public luaj.LuaTable$m k(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        xm_kState st = new xm_kState();
        st.v0o = this;
        st.v1o = luaValue;
        st.v2o = luaValue2;
        return xm_k_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_k_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_kState {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
    }

    private static luaj.LuaTable$m xm_k_run(xm_kState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_k_c0(st);
            }
            else {
                done = xm_k_c0(st);
            }
            if (done) {
                return (luaj.LuaTable$m) st.resultO;
            }
        }
    }

    private static boolean xm_k_c0(xm_kState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = luaj.LuaTable.Z2((luaj.LuaValue) st.v1o, (luaj.LuaValue) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_k_handler(st.pc, t);
            if (h < 0) {
                xm_k_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_k_ctypes = {
    };
    private static final int[] xm_k_handlers = {
        
    };
    private static int xm_k_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_k_handlers.length; i += 4) {
            if (pc < xm_k_handlers[i] || pc >= xm_k_handlers[i + 1]) {
                continue;
            }
            int ti = xm_k_handlers[i + 3];
            if (ti < 0 || xm_k_ctypes[ti].isInstance(t)) {
                return xm_k_handlers[i + 2];
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x003d  */
    @Override // luaj.LuaValue
    public luaj.LuaValue k2(luaj.LuaValue luaValue) {
        xm_k2State st = new xm_k2State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_k2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_k2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_k2State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static luaj.LuaValue xm_k2_run(xm_k2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 39) {
                done = xm_k2_c0(st);
            }
            else {
                done = xm_k2_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_k2_c0(xm_k2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v4o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0o == null) {
                            st.pc = 9;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.tmpI = (((luaj.e) st.v0o).q()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v0i == 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 7:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.pc = 10;
                        continue;
                    case 9:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v3o = ((luaj.LuaTable) st.v4o).S;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v3o == null) {
                            st.pc = 17;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.tmpI = (((luaj.e) st.v3o).p()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 13:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v3i == 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 18;
                        continue;
                    case 17:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = luaj.LuaValue.w1((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 20:
                        st.pc = 20;
                        ((luaj.LuaTable) st.v4o).S = (luaj.e) st.v5o;
                    case 21:
                        st.pc = 21;
                        if (st.v5o == null) {
                            st.pc = 27;
                            continue;
                        }
                    case 22:
                        st.pc = 22;
                        st.tmpI = (((luaj.e) st.v5o).q()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 23:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 24:
                        st.pc = 24;
                        if (st.v5i == 0) {
                            st.pc = 27;
                            continue;
                        }
                    case 25:
                        st.v5i = 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.pc = 28;
                        continue;
                    case 27:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 28:
                        st.pc = 28;
                        if (st.v0i != st.v5i) {
                            st.pc = 37;
                            continue;
                        }
                    case 29:
                        st.pc = 29;
                        st.v5o = ((luaj.LuaTable) st.v4o).S;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 30:
                        st.pc = 30;
                        if (st.v5o == null) {
                            st.pc = 35;
                            continue;
                        }
                    case 31:
                        st.pc = 31;
                        st.tmpI = (((luaj.e) st.v5o).p()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 32:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 33:
                        st.pc = 33;
                        if (st.v5i == 0) {
                            st.pc = 35;
                            continue;
                        }
                    case 34:
                        st.pc = 34;
                        st.pc = 36;
                        continue;
                    case 35:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 36:
                        st.pc = 36;
                        if (st.v3i == st.v1i) {
                            st.pc = 38;
                            continue;
                        }
                    case 37:
                        st.pc = 37;
                        ((luaj.LuaTable) st.v4o).y3(st.v2i);
                    case 38:
                        st.pc = 38;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_k2_handler(st.pc, t);
            if (h < 0) {
                xm_k2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_k2_ctypes = {
    };
    private static final int[] xm_k2_handlers = {
        
    };
    private static int xm_k2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_k2_handlers.length; i += 4) {
            if (pc < xm_k2_handlers[i] || pc >= xm_k2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_k2_handlers[i + 3];
            if (ti < 0 || xm_k2_ctypes[ti].isInstance(t)) {
                return xm_k2_handlers[i + 2];
            }
        }
        return -1;
    }

    protected luaj.LuaValue k3(luaj.LuaValue luaValue) {
        xm_k3State st = new xm_k3State();
        st.v0o = this;
        st.v1o = luaValue;
        return xm_k3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_k3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_k3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
    }

    private static luaj.LuaValue xm_k3_run(xm_k3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_k3_c0(st);
            }
            else {
                done = xm_k3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_k3_c0(xm_k3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaTable) st.v0o).C3((luaj.LuaValue) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v1o != null) {
                            st.pc = 5;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v1o = luaj.LuaValue.f1673c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 7;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((luaj.LuaTable$n) st.v1o).t();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_k3_handler(st.pc, t);
            if (h < 0) {
                xm_k3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_k3_ctypes = {
    };
    private static final int[] xm_k3_handlers = {
        
    };
    private static int xm_k3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_k3_handlers.length; i += 4) {
            if (pc < xm_k3_handlers[i] || pc >= xm_k3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_k3_handlers[i + 3];
            if (ti < 0 || xm_k3_ctypes[ti].isInstance(t)) {
                return xm_k3_handlers[i + 2];
            }
        }
        return -1;
    }

    public void m3(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        xm_m3State st = new xm_m3State();
        st.v3o = this;
        st.v4o = luaValue;
        st.v5o = luaValue2;
        xm_m3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_m3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_m3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static void xm_m3_run(xm_m3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 71) {
                done = xm_m3_c0(st);
            }
            else {
                done = xm_m3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_m3_c0(xm_m3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i == 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        ((luaj.LuaTable) st.v3o).h3((luaj.LuaValue) st.v4o);
                    case 4:
                        st.pc = 4;
                        st.pc = 70;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.v0o = ((luaj.LuaTable) st.v3o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v0i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i <= 0) {
                            st.pc = 25;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.tmpI = ((luaj.LuaTable) st.v3o).i3((luaj.LuaValue) st.v4o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v1o = ((luaj.LuaTable) st.v3o).Q;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v1o = ((java.lang.Object[]) st.v1o)[st.v0i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v1o == null) {
                            st.pc = 26;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaTable$m) st.v1o).f((luaj.LuaValue) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v2o == null) {
                            st.pc = 22;
                            continue;
                        }
                    case 16:
                        st.pc = 16;
                        st.v4o = ((luaj.LuaTable) st.v3o).Q;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v1o = ((java.lang.Object[]) st.v4o)[st.v0i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((luaj.LuaTable$m) st.v1o).j((luaj.LuaTable$n) st.v2o, (luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 20:
                        st.pc = 20;
                        ((java.lang.Object[]) st.v4o)[st.v0i] = st.v5o;
                    case 21:
                        st.pc = 21;
                        return true;
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((luaj.LuaTable$m) st.v1o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.pc = 12;
                        continue;
                    case 25:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v1i = ((luaj.LuaTable) st.v3o).R;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.v2o = ((luaj.LuaTable) st.v3o).Q;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.v2i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 29:
                        st.pc = 29;
                        if (st.v1i < st.v2i) {
                            st.pc = 54;
                            continue;
                        }
                    case 30:
                        st.pc = 30;
                        st.v0o = ((luaj.LuaTable) st.v3o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 31:
                        st.pc = 31;
                        if (st.v0o == null) {
                            st.pc = 35;
                            continue;
                        }
                    case 32:
                        st.pc = 32;
                        st.tmpI = (((luaj.e) st.v0o).p()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 33:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 34:
                        st.pc = 34;
                        if (st.v0i != 0) {
                            st.pc = 50;
                            continue;
                        }
                    case 35:
                        st.pc = 35;
                        st.tmpI = (((luaj.LuaValue) st.v4o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 36:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 37:
                        st.pc = 37;
                        if (st.v0i == 0) {
                            st.pc = 50;
                            continue;
                        }
                    case 38:
                        st.pc = 38;
                        st.tmpI = ((luaj.LuaValue) st.v4o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 39:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 40:
                        st.pc = 40;
                        if (st.v0i <= 0) {
                            st.pc = 50;
                            continue;
                        }
                    case 41:
                        st.pc = 41;
                        st.tmpI = ((luaj.LuaValue) st.v4o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 42:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 43:
                        st.pc = 43;
                        ((luaj.LuaTable) st.v3o).y3(st.v0i);
                    case 44:
                        st.pc = 44;
                        st.tmpI = ((luaj.LuaValue) st.v4o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 45:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.tmpI = (((luaj.LuaTable) st.v3o).U2(st.v0i, (luaj.LuaValue) st.v5o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 47:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 48:
                        st.pc = 48;
                        if (st.v0i == 0) {
                            st.pc = 52;
                            continue;
                        }
                    case 49:
                        st.pc = 49;
                        return true;
                    case 50:
                        st.v0i = 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 51:
                        st.pc = 51;
                        ((luaj.LuaTable) st.v3o).y3(st.v0i);
                    case 52:
                        st.pc = 52;
                        st.tmpI = ((luaj.LuaTable) st.v3o).i3((luaj.LuaValue) st.v4o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 53:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.v1o = ((luaj.LuaTable) st.v3o).S;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 55:
                        st.pc = 55;
                        if (st.v1o == null) {
                            st.pc = 59;
                            continue;
                        }
                    case 56:
                        st.pc = 56;
                        st.tmpO = ((luaj.e) st.v1o).k((luaj.LuaValue) st.v4o, (luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 57:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 58:
                        st.pc = 58;
                        st.pc = 61;
                        continue;
                    case 59:
                        st.pc = 59;
                        st.tmpO = luaj.LuaTable.Z2((luaj.LuaValue) st.v4o, (luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 60:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 61:
                        st.pc = 61;
                        st.v5o = ((luaj.LuaTable) st.v3o).Q;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 62:
                        st.pc = 62;
                        st.v1o = ((java.lang.Object[]) st.v5o)[st.v0i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 63:
                        st.pc = 63;
                        if (st.v1o == null) {
                            st.pc = 66;
                            continue;
                        }
                    case 64:
                        st.pc = 64;
                        st.tmpO = ((luaj.LuaTable$m) st.v1o).d((luaj.LuaTable$m) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 65:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 66:
                        st.pc = 66;
                        ((java.lang.Object[]) st.v5o)[st.v0i] = st.v4o;
                    case 67:
                        st.pc = 67;
                        st.v4i = ((luaj.LuaTable) st.v3o).R;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 68:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 69:
                        st.pc = 69;
                        ((luaj.LuaTable) st.v3o).R = st.v4i;
                    case 70:
                        st.pc = 70;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_m3_handler(st.pc, t);
            if (h < 0) {
                xm_m3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_m3_ctypes = {
    };
    private static final int[] xm_m3_handlers = {
        
    };
    private static int xm_m3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_m3_handlers.length; i += 4) {
            if (pc < xm_m3_handlers[i] || pc >= xm_m3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_m3_handlers[i + 3];
            if (ti < 0 || xm_m3_ctypes[ti].isInstance(t)) {
                return xm_m3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.e
    public luaj.LuaValue o(luaj.LuaValue[] luaValueArr, int i) {
        xm_oState st = new xm_oState();
        st.v0o = this;
        st.v1o = luaValueArr;
        st.v2i = i;
        return xm_o_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_o_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_oState {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        java.lang.Object v0o;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
    }

    private static luaj.LuaValue xm_o_run(xm_oState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_o_c0(st);
            }
            else {
                done = xm_o_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_o_c0(xm_oState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v1o = ((java.lang.Object[]) st.v1o)[st.v2i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_o_handler(st.pc, t);
            if (h < 0) {
                xm_o_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_o_ctypes = {
    };
    private static final int[] xm_o_handlers = {
        
    };
    private static int xm_o_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_o_handlers.length; i += 4) {
            if (pc < xm_o_handlers[i] || pc >= xm_o_handlers[i + 1]) {
                continue;
            }
            int ti = xm_o_handlers[i + 3];
            if (ti < 0 || xm_o_ctypes[ti].isInstance(t)) {
                return xm_o_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean o1() {
        xm_o1State st = new xm_o1State();
        st.v1o = this;
        return xm_o1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_o1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_o1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static boolean xm_o1_run(xm_o1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_o1_c0(st);
            }
            else {
                done = xm_o1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_o1_c0(xm_o1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_o1_handler(st.pc, t);
            if (h < 0) {
                xm_o1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_o1_ctypes = {
    };
    private static final int[] xm_o1_handlers = {
        
    };
    private static int xm_o1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_o1_handlers.length; i += 4) {
            if (pc < xm_o1_handlers[i] || pc >= xm_o1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_o1_handlers[i + 3];
            if (ti < 0 || xm_o1_ctypes[ti].isInstance(t)) {
                return xm_o1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.e
    public boolean p() {
        xm_pState st = new xm_pState();
        st.v1o = this;
        return xm_p_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_p_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_pState {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static boolean xm_p_run(xm_pState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_p_c0(st);
            }
            else {
                done = xm_p_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_p_c0(xm_pState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_p_handler(st.pc, t);
            if (h < 0) {
                xm_p_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_p_ctypes = {
    };
    private static final int[] xm_p_handlers = {
        
    };
    private static int xm_p_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_p_handlers.length; i += 4) {
            if (pc < xm_p_handlers[i] || pc >= xm_p_handlers[i + 1]) {
                continue;
            }
            int ti = xm_p_handlers[i + 3];
            if (ti < 0 || xm_p_ctypes[ti].isInstance(t)) {
                return xm_p_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.Varargs p3(luaj.LuaValue luaValue) {
        xm_p3State st = new xm_p3State();
        st.v3o = this;
        st.v4o = luaValue;
        return xm_p3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_p3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_p3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static luaj.Varargs xm_p3_run(xm_p3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 16) {
                done = xm_p3_c0(st);
            }
            else {
                done = xm_p3_c0(st);
            }
            if (done) {
                return (luaj.Varargs) st.resultO;
            }
        }
    }

    private static boolean xm_p3_c0(xm_p3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((luaj.LuaValue) st.v4o).A0();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 2:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((luaj.LuaTable) st.v3o).c3(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v0o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v1i == 0) {
                            st.pc = 10;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.v4o = luaj.LuaValue.f1676f;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.pc = 15;
                        continue;
                    case 10:
                        st.v1j = st.v4i;
                        st.v1d = java.lang.Double.longBitsToDouble(st.v1j);
                        st.v1i = 0;
                        st.v1o = null;
                    case 11:
                        st.pc = 11;
                        st.tmpO = luaj.LuaLong.I2(st.v1j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = luaj.LuaValue.N2((luaj.LuaValue) st.v4o, (luaj.Varargs) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_p3_handler(st.pc, t);
            if (h < 0) {
                xm_p3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_p3_ctypes = {
    };
    private static final int[] xm_p3_handlers = {
        
    };
    private static int xm_p3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_p3_handlers.length; i += 4) {
            if (pc < xm_p3_handlers[i] || pc >= xm_p3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_p3_handlers[i + 3];
            if (ti < 0 || xm_p3_ctypes[ti].isInstance(t)) {
                return xm_p3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.e
    public boolean q() {
        xm_qState st = new xm_qState();
        st.v1o = this;
        return xm_q_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_q_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_qState {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static boolean xm_q_run(xm_qState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_q_c0(st);
            }
            else {
                done = xm_q_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_q_c0(xm_qState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_q_handler(st.pc, t);
            if (h < 0) {
                xm_q_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_q_ctypes = {
    };
    private static final int[] xm_q_handlers = {
        
    };
    private static int xm_q_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_q_handlers.length; i += 4) {
            if (pc < xm_q_handlers[i] || pc >= xm_q_handlers[i + 1]) {
                continue;
            }
            int ti = xm_q_handlers[i + 3];
            if (ti < 0 || xm_q_ctypes[ti].isInstance(t)) {
                return xm_q_handlers[i + 2];
            }
        }
        return -1;
    }

    public void q3(int i, luaj.LuaValue luaValue) {
        xm_q3State st = new xm_q3State();
        st.v2o = this;
        st.v3i = i;
        st.v4o = luaValue;
        xm_q3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_q3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_q3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static void xm_q3_run(xm_q3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 11) {
                done = xm_q3_c0(st);
            }
            else {
                done = xm_q3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_q3_c0(xm_q3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v4o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i != 0) {
                            st.pc = 10;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((luaj.LuaTable) st.v2o).c3(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.v1i = st.v3i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        ((luaj.LuaTable) st.v2o).e2(st.v3i, (luaj.LuaValue) st.v4o);
                    case 7:
                        st.v4o = st.v0o;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 8:
                        st.v3i = st.v1i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.pc = 0;
                        continue;
                    case 10:
                        st.pc = 10;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_q3_handler(st.pc, t);
            if (h < 0) {
                xm_q3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_q3_ctypes = {
    };
    private static final int[] xm_q3_handlers = {
        
    };
    private static int xm_q3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_q3_handlers.length; i += 4) {
            if (pc < xm_q3_handlers[i] || pc >= xm_q3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_q3_handlers[i + 3];
            if (ti < 0 || xm_q3_ctypes[ti].isInstance(t)) {
                return xm_q3_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue r1() {
        xm_r1State st = new xm_r1State();
        st.v2o = this;
        return xm_r1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_r1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_r1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
    }

    private static luaj.LuaValue xm_r1_run(xm_r1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 15) {
                done = xm_r1_c0(st);
            }
            else {
                done = xm_r1_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_r1_c0(xm_r1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = luaj.LuaValue.x;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpO = ((luaj.LuaValue) st.v2o).x1((luaj.LuaValue) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = (((luaj.LuaValue) st.v0o).w2()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v1i == 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.tmpO = ((luaj.LuaValue) st.v0o).call((luaj.LuaValue) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 7:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 9:
                        st.pc = 9;
                        st.tmpI = ((luaj.LuaTable) st.v2o).W1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 11:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 12:
                        st.pc = 12;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 13:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_r1_handler(st.pc, t);
            if (h < 0) {
                xm_r1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_r1_ctypes = {
    };
    private static final int[] xm_r1_handlers = {
        
    };
    private static int xm_r1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_r1_handlers.length; i += 4) {
            if (pc < xm_r1_handlers[i] || pc >= xm_r1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_r1_handlers[i + 3];
            if (ti < 0 || xm_r1_ctypes[ti].isInstance(t)) {
                return xm_r1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public int s1() {
        xm_s1State st = new xm_s1State();
        st.v4o = this;
        return xm_s1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_s1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_s1State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        java.lang.Object v4o;
    }

    private static int xm_s1_run(xm_s1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 23) {
                done = xm_s1_c0(st);
            }
            else {
                done = xm_s1_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_s1_c0(xm_s1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.LuaTable) st.v4o).S;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0o == null) {
                            st.pc = 20;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((luaj.LuaTable) st.v4o).r1();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = (((luaj.LuaValue) st.v0o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v1i == 0) {
                            st.pc = 10;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.tmpI = ((luaj.LuaValue) st.v0o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 8:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 10:
                        st.pc = 10;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 13:
                        st.v3o = "table length is not an integer: ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.v1o = new luaj.d((java.lang.String) st.v0o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 19:
                        st.pc = 19;
                        throw (java.lang.Throwable) st.v1o;
                    case 20:
                        st.pc = 20;
                        st.tmpI = ((luaj.LuaTable) st.v4o).W1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_s1_handler(st.pc, t);
            if (h < 0) {
                xm_s1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_s1_ctypes = {
    };
    private static final int[] xm_s1_handlers = {
        
    };
    private static int xm_s1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_s1_handlers.length; i += 4) {
            if (pc < xm_s1_handlers[i] || pc >= xm_s1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_s1_handlers[i + 3];
            if (ti < 0 || xm_s1_ctypes[ti].isInstance(t)) {
                return xm_s1_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.LuaTable$i s3() {
        xm_s3State st = new xm_s3State();
        st.v1o = this;
        return xm_s3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_s3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_s3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
    }

    private static luaj.LuaTable$i xm_s3_run(xm_s3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_s3_c0(st);
            }
            else {
                done = xm_s3_c0(st);
            }
            if (done) {
                return (luaj.LuaTable$i) st.resultO;
            }
        }
    }

    private static boolean xm_s3_c0(xm_s3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0o = new luaj.LuaTable$i((luaj.LuaTable) st.v1o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_s3_handler(st.pc, t);
            if (h < 0) {
                xm_s3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_s3_ctypes = {
    };
    private static final int[] xm_s3_handlers = {
        
    };
    private static int xm_s3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_s3_handlers.length; i += 4) {
            if (pc < xm_s3_handlers[i] || pc >= xm_s3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_s3_handlers[i + 3];
            if (ti < 0 || xm_s3_ctypes[ti].isInstance(t)) {
                return xm_s3_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.LuaValue[] t3() {
        xm_t3State st = new xm_t3State();
        st.v3o = this;
        return xm_t3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_t3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_t3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
    }

    private static luaj.LuaValue[] xm_t3_run(xm_t3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 16) {
                done = xm_t3_c0(st);
            }
            else {
                done = xm_t3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue[]) st.resultO;
            }
        }
    }

    private static boolean xm_t3_c0(xm_t3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0o = new java.util.ArrayList();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((luaj.LuaTable) st.v3o).s3();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = (((luaj.LuaTable$i) st.v1o).c()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v2i == 0) {
                            st.pc = 11;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((luaj.LuaTable$i) st.v1o).b();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpI = (((java.util.ArrayList) st.v0o).add(st.v2o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.pc = 10;
                        st.pc = 4;
                        continue;
                    case 11:
                        st.pc = 11;
                        st.tmpI = ((java.util.ArrayList) st.v0o).size();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 12:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.v1o = new luaj.LuaValue[st.v1i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.util.ArrayList) st.v0o).toArray((java.lang.Object[]) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.pc = 15;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_t3_handler(st.pc, t);
            if (h < 0) {
                xm_t3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_t3_ctypes = {
    };
    private static final int[] xm_t3_handlers = {
        
    };
    private static int xm_t3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_t3_handlers.length; i += 4) {
            if (pc < xm_t3_handlers[i] || pc >= xm_t3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_t3_handlers[i + 3];
            if (ti < 0 || xm_t3_ctypes[ti].isInstance(t)) {
                return xm_t3_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.Varargs v3(luaj.LuaValue luaValue) {
        xm_v3State st = new xm_v3State();
        st.v5o = this;
        st.v6o = luaValue;
        return xm_v3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_v3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_v3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        java.lang.Object v5o;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
    }

    private static luaj.Varargs xm_v3_run(xm_v3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 99) {
                done = xm_v3_c0(st);
            }
            else {
                done = xm_v3_c0(st);
            }
            if (done) {
                return (luaj.Varargs) st.resultO;
            }
        }
    }

    private static boolean xm_v3_c0(xm_v3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v6o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0i != 0) {
                            st.pc = 59;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v6o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i == 0) {
                            st.pc = 16;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.tmpI = ((luaj.LuaValue) st.v6o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v0i <= 0) {
                            st.pc = 16;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.v3o = ((luaj.LuaTable) st.v5o).P;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v3i = java.lang.reflect.Array.getLength(st.v3o);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v0i > st.v3i) {
                            st.pc = 16;
                            continue;
                        }
                    case 14:
                        st.v2i = st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.pc = 59;
                        continue;
                    case 16:
                        st.pc = 16;
                        st.v0o = ((luaj.LuaTable) st.v5o).Q;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v0i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 18:
                        st.pc = 18;
                        if (st.v0i != 0) {
                            st.pc = 27;
                            continue;
                        }
                    case 19:
                        st.pc = 19;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 21:
                        st.v3o = "invalid key to 'next' 1: ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.pc = 24;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 25:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.pc = 27;
                        st.tmpI = ((luaj.LuaTable) st.v5o).i3((luaj.LuaValue) st.v6o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 28:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v3o = ((luaj.LuaTable) st.v5o).Q;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.v3o = ((java.lang.Object[]) st.v3o)[st.v0i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 31:
                        st.pc = 31;
                        if (st.v3o == null) {
                            st.pc = 46;
                            continue;
                        }
                    case 32:
                        st.pc = 32;
                        if (st.v2i == 0) {
                            st.pc = 39;
                            continue;
                        }
                    case 33:
                        st.pc = 33;
                        st.tmpO = ((luaj.LuaTable$m) st.v3o).l();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 34:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 35:
                        st.pc = 35;
                        if (st.v4o == null) {
                            st.pc = 43;
                            continue;
                        }
                    case 36:
                        st.pc = 36;
                        st.tmpO = ((luaj.LuaTable$n) st.v4o).c();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 37:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.resultO = st.v6o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 39:
                        st.pc = 39;
                        st.tmpI = (((luaj.LuaTable$m) st.v3o).s((luaj.LuaValue) st.v6o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 40:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 41:
                        st.pc = 41;
                        if (st.v4i == 0) {
                            st.pc = 43;
                            continue;
                        }
                    case 42:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 43:
                        st.pc = 43;
                        st.tmpO = ((luaj.LuaTable$m) st.v3o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 44:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 45:
                        st.pc = 45;
                        st.pc = 31;
                        continue;
                    case 46:
                        st.pc = 46;
                        if (st.v2i != 0) {
                            st.pc = 55;
                            continue;
                        }
                    case 47:
                        st.pc = 47;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 48:
                        st.pc = 48;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 49:
                        st.v3o = "invalid key to 'next' 2: ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 50:
                        st.pc = 50;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 51:
                        st.pc = 51;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 52:
                        st.pc = 52;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 53:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 55:
                        st.pc = 55;
                        st.v6o = ((luaj.LuaTable) st.v5o).P;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 56:
                        st.pc = 56;
                        st.v6i = java.lang.reflect.Array.getLength(st.v6o);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 57:
                        st.v6i = st.v6i + st.v1i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 58:
                        st.v2i = st.v0i + st.v6i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 59:
                        st.pc = 59;
                        st.v6o = ((luaj.LuaTable) st.v5o).P;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 60:
                        st.pc = 60;
                        st.v0i = java.lang.reflect.Array.getLength(st.v6o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 61:
                        st.pc = 61;
                        if (st.v2i >= st.v0i) {
                            st.pc = 79;
                            continue;
                        }
                    case 62:
                        st.pc = 62;
                        st.v0o = ((java.lang.Object[]) st.v6o)[st.v2i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 63:
                        st.pc = 63;
                        if (st.v0o == null) {
                            st.pc = 77;
                            continue;
                        }
                    case 64:
                        st.pc = 64;
                        st.v3o = ((luaj.LuaTable) st.v5o).S;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 65:
                        st.pc = 65;
                        if (st.v3o != null) {
                            st.pc = 67;
                            continue;
                        }
                    case 66:
                        st.pc = 66;
                        st.pc = 69;
                        continue;
                    case 67:
                        st.pc = 67;
                        st.tmpO = ((luaj.e) st.v3o).o((luaj.LuaValue[]) st.v6o, st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 68:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 69:
                        st.pc = 69;
                        if (st.v0o == null) {
                            st.pc = 77;
                            continue;
                        }
                    case 70:
                        st.v2i = st.v2i + st.v1i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 71:
                        st.v1j = st.v2i;
                        st.v1d = java.lang.Double.longBitsToDouble(st.v1j);
                        st.v1i = 0;
                        st.v1o = null;
                    case 72:
                        st.pc = 72;
                        st.tmpO = luaj.LuaLong.I2(st.v1j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 73:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 74:
                        st.pc = 74;
                        st.tmpO = luaj.LuaValue.N2((luaj.LuaValue) st.v6o, (luaj.Varargs) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 75:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 76:
                        st.pc = 76;
                        st.resultO = st.v6o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 77:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 78:
                        st.pc = 78;
                        st.pc = 59;
                        continue;
                    case 79:
                        st.pc = 79;
                        st.v6i = java.lang.reflect.Array.getLength(st.v6o);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 80:
                        st.v2i = st.v2i - st.v6i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 81:
                        st.pc = 81;
                        st.v6o = ((luaj.LuaTable) st.v5o).Q;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 82:
                        st.pc = 82;
                        st.v0i = java.lang.reflect.Array.getLength(st.v6o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 83:
                        st.pc = 83;
                        if (st.v2i >= st.v0i) {
                            st.pc = 97;
                            continue;
                        }
                    case 84:
                        st.pc = 84;
                        st.v6o = ((java.lang.Object[]) st.v6o)[st.v2i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 85:
                        st.pc = 85;
                        if (st.v6o == null) {
                            st.pc = 95;
                            continue;
                        }
                    case 86:
                        st.pc = 86;
                        st.tmpO = ((luaj.LuaTable$m) st.v6o).l();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 87:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 88:
                        st.pc = 88;
                        if (st.v0o == null) {
                            st.pc = 92;
                            continue;
                        }
                    case 89:
                        st.pc = 89;
                        st.tmpO = ((luaj.LuaTable$n) st.v0o).c();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 90:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 91:
                        st.pc = 91;
                        st.resultO = st.v6o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 92:
                        st.pc = 92;
                        st.tmpO = ((luaj.LuaTable$m) st.v6o).a();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 93:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 94:
                        st.pc = 94;
                        st.pc = 85;
                        continue;
                    case 95:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 96:
                        st.pc = 96;
                        st.pc = 81;
                        continue;
                    case 97:
                        st.pc = 97;
                        st.v6o = luaj.LuaValue.f1673c;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 98:
                        st.pc = 98;
                        st.resultO = st.v6o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_v3_handler(st.pc, t);
            if (h < 0) {
                xm_v3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_v3_ctypes = {
    };
    private static final int[] xm_v3_handlers = {
        
    };
    private static int xm_v3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_v3_handlers.length; i += 4) {
            if (pc < xm_v3_handlers[i] || pc >= xm_v3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_v3_handlers[i + 3];
            if (ti < 0 || xm_v3_ctypes[ti].isInstance(t)) {
                return xm_v3_handlers[i + 2];
            }
        }
        return -1;
    }

    public void w3(int i, int i2) {
        xm_w3State st = new xm_w3State();
        st.v1o = this;
        st.v2i = i;
        st.v3i = i2;
        xm_w3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_w3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_w3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static void xm_w3_run(xm_w3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_w3_c0(st);
            }
            else {
                done = xm_w3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_w3_c0(xm_w3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v3i <= 0) {
                            st.pc = 4;
                            continue;
                        }
                    case 1:
                        st.v0i = 2;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v3i >= st.v0i) {
                            st.pc = 4;
                            continue;
                        }
                    case 3:
                        st.v3i = 2;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 4:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v2i <= 0) {
                            st.pc = 11;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.tmpI = luaj.LuaTable.u3(st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 8:
                        st.v2i = st.v0i << st.v2i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v2o = new luaj.LuaValue[st.v2i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.pc = 12;
                        continue;
                    case 11:
                        st.pc = 11;
                        st.v2o = luaj.LuaValue.j;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        ((luaj.LuaTable) st.v1o).P = (luaj.LuaValue[]) st.v2o;
                    case 13:
                        st.pc = 13;
                        if (st.v3i <= 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 14:
                        st.pc = 14;
                        st.tmpI = luaj.LuaTable.u3(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 15:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 16:
                        st.v2i = st.v0i << st.v2i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v2o = new luaj.LuaTable$m[st.v2i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.pc = 20;
                        continue;
                    case 19:
                        st.pc = 19;
                        st.v2o = luaj.LuaTable.U;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 20:
                        st.pc = 20;
                        ((luaj.LuaTable) st.v1o).Q = (luaj.LuaTable$m[]) st.v2o;
                    case 21:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 22:
                        st.pc = 22;
                        ((luaj.LuaTable) st.v1o).R = st.v2i;
                    case 23:
                        st.pc = 23;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_w3_handler(st.pc, t);
            if (h < 0) {
                xm_w3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_w3_ctypes = {
    };
    private static final int[] xm_w3_handlers = {
        
    };
    private static int xm_w3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_w3_handlers.length; i += 4) {
            if (pc < xm_w3_handlers[i] || pc >= xm_w3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_w3_handlers[i + 3];
            if (ti < 0 || xm_w3_ctypes[ti].isInstance(t)) {
                return xm_w3_handlers[i + 2];
            }
        }
        return -1;
    }

    public luaj.LuaValue x3(int i) {
        xm_x3State st = new xm_x3State();
        st.v2o = this;
        st.v3i = i;
        return xm_x3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_x3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_x3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static luaj.LuaValue xm_x3_run(xm_x3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 21) {
                done = xm_x3_c0(st);
            }
            else {
                done = xm_x3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_x3_c0(xm_x3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v3i <= 0) {
                            st.pc = 15;
                            continue;
                        }
                    case 1:
                        st.pc = 1;
                        st.v0o = ((luaj.LuaTable) st.v2o).P;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v3i > st.v1i) {
                            st.pc = 15;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v1o = ((luaj.LuaTable) st.v2o).S;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.v3i = st.v3i + 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v1o != null) {
                            st.pc = 9;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.v3o = ((java.lang.Object[]) st.v0o)[st.v3i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.pc = 11;
                        continue;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((luaj.e) st.v1o).o((luaj.LuaValue[]) st.v0o, st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v3o == null) {
                            st.pc = 13;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.pc = 14;
                        continue;
                    case 13:
                        st.pc = 13;
                        st.v3o = luaj.LuaValue.f1673c;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 15:
                        st.v0j = st.v3i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 16:
                        st.pc = 16;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((luaj.LuaTable) st.v2o).k3((luaj.LuaValue) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_x3_handler(st.pc, t);
            if (h < 0) {
                xm_x3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_x3_ctypes = {
    };
    private static final int[] xm_x3_handlers = {
        
    };
    private static int xm_x3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_x3_handlers.length; i += 4) {
            if (pc < xm_x3_handlers[i] || pc >= xm_x3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_x3_handlers[i + 3];
            if (ti < 0 || xm_x3_ctypes[ti].isInstance(t)) {
                return xm_x3_handlers[i + 2];
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------- *
     *  .method public z3(II)Lluaj/LuaValue;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public luaj.LuaValue z3(int i, int i2) {
        xm_z3State st = new xm_z3State();
        st.v2o = this;
        st.v3i = i;
        st.v4i = i2;
        return xm_z3_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_z3_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_z3State {
        int pc;
        int resultI;
        long resultJ;
        double resultD;
        java.lang.Object resultO;
        int tmpI;
        long tmpJ;
        double tmpD;
        java.lang.Object tmpO;
        java.lang.Throwable ex;
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static luaj.LuaValue xm_z3_run(xm_z3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_z3_c0(st);
            }
            else {
                done = xm_z3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_z3_c0(xm_z3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v3i != 0) {
                            st.pc = 3;
                            continue;
                        }
                    case 1:
                        st.v3i = st.v4i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.pc = 6;
                        continue;
                    case 3:
                        st.pc = 3;
                        if (st.v3i <= st.v4i) {
                            st.pc = 6;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v3o = luaj.LuaValue.f1676f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.resultO = st.v3o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 6:
                        st.pc = 6;
                        st.tmpO = ((luaj.LuaTable) st.v2o).c3(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 7:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 8:
                        st.v0o = st.v4o;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpI = (((luaj.LuaValue) st.v0o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v0i != 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 12:
                        st.v0i = st.v3i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaTable) st.v2o).c3(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((luaj.LuaTable) st.v2o).e2(st.v3i, (luaj.LuaValue) st.v1o);
                    case 16:
                        st.v3i = st.v0i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.v0o = st.v1o;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.pc = 9;
                        continue;
                    case 19:
                        st.pc = 19;
                        st.tmpI = (((luaj.LuaValue) st.v4o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 20:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 21:
                        st.pc = 21;
                        if (st.v3i == 0) {
                            st.pc = 23;
                            continue;
                        }
                    case 22:
                        st.pc = 22;
                        st.v4o = luaj.LuaValue.f1676f;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_z3_handler(st.pc, t);
            if (h < 0) {
                xm_z3_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_z3_ctypes = {
    };
    private static final int[] xm_z3_handlers = {
        
    };
    private static int xm_z3_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_z3_handlers.length; i += 4) {
            if (pc < xm_z3_handlers[i] || pc >= xm_z3_handlers[i + 1]) {
                continue;
            }
            int ti = xm_z3_handlers[i + 3];
            if (ti < 0 || xm_z3_ctypes[ti].isInstance(t)) {
                return xm_z3_handlers[i + 2];
            }
        }
        return -1;
    }
}

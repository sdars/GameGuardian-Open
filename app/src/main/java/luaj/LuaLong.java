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
        xm_I2State st = new xm_I2State();
        st.v4j = j;
        return xm_I2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_I2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_I2State {
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
    }

    private static luaj.LuaLong xm_I2_run(xm_I2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 29) {
                done = xm_I2_c0(st);
            }
            else {
                done = xm_I2_c0(st);
            }
            if (done) {
                return (luaj.LuaLong) st.resultO;
            }
        }
    }

    private static boolean xm_I2_c0(xm_I2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0j = 255L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2i = Long.compare(st.v4j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v2i > 0) {
                            st.pc = 16;
                            continue;
                        }
                    case 3:
                        st.v0j = 0xffffffffffffff00L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 4:
                        st.v2i = Long.compare(st.v4j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v2i < 0) {
                            st.pc = 16;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.v0o = luaj.LuaLong.T;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.v1j = 256L;
                        st.v1d = java.lang.Double.longBitsToDouble(st.v1j);
                        st.v1i = 0;
                        st.v1o = null;
                    case 8:
                        st.v1j = st.v1j + st.v4j;
                        st.v1d = java.lang.Double.longBitsToDouble(st.v1j);
                        st.v1i = 0;
                        st.v1o = null;
                    case 9:
                        st.v2i = (int) st.v1j;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v1o = ((java.lang.Object[]) st.v0o)[st.v2i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v1o != null) {
                            st.pc = 15;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.v1o = new luaj.LuaLong(st.v4j);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 14:
                        st.pc = 14;
                        ((java.lang.Object[]) st.v0o)[st.v2i] = st.v1o;
                    case 15:
                        st.pc = 15;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 16:
                        st.v0j = 9223372036854775807L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 17:
                        st.v2i = Long.compare(st.v4j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 18:
                        st.pc = 18;
                        if (st.v2i != 0) {
                            st.pc = 21;
                            continue;
                        }
                    case 19:
                        st.pc = 19;
                        st.v4o = luaj.LuaLong.R;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 21:
                        st.pc = 21;
                        st.v0j = 0x8000000000000000L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 22:
                        st.v2i = Long.compare(st.v4j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v2i != 0) {
                            st.pc = 26;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        st.v4o = luaj.LuaLong.S;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 26:
                        st.pc = 26;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.v0o = new luaj.LuaLong(st.v4j);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 28:
                        st.pc = 28;
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
            int h = xm_I2_handler(st.pc, t);
            if (h < 0) {
                xm_I2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_I2_ctypes = {
    };
    private static final int[] xm_I2_handlers = {
        
    };
    private static int xm_I2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_I2_handlers.length; i += 4) {
            if (pc < xm_I2_handlers[i] || pc >= xm_I2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_I2_handlers[i + 3];
            if (ti < 0 || xm_I2_ctypes[ti].isInstance(t)) {
                return xm_I2_handlers[i + 2];
            }
        }
        return -1;
    }

    public static long S2(long j, long j2) {
        xm_S2State st = new xm_S2State();
        st.v9j = j;
        st.v11j = j2;
        return xm_S2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_S2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_S2State {
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
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
        int v11i;
        long v11j;
        java.lang.Object v11o;
        double v11d;
    }

    private static long xm_S2_run(xm_S2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 28) {
                done = xm_S2_c0(st);
            }
            else {
                done = xm_S2_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_S2_c0(xm_S2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0j = 0L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2i = Long.compare(st.v11j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v2i == 0) {
                            st.pc = 13;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v2j = st.v9j / st.v11j;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 4:
                        st.v4j = st.v9j ^ st.v11j;
                        st.v4d = java.lang.Double.longBitsToDouble(st.v4j);
                        st.v4i = 0;
                        st.v4o = null;
                    case 5:
                        st.v6i = Long.compare(st.v4j, st.v0j);
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v6i >= 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 7:
                        st.v11j = st.v11j * st.v2j;
                        st.v11d = java.lang.Double.longBitsToDouble(st.v11j);
                        st.v11i = 0;
                        st.v11o = null;
                    case 8:
                        st.v0i = Long.compare(st.v11j, st.v9j);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v0i == 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 10:
                        st.v9j = 1L;
                        st.v9d = java.lang.Double.longBitsToDouble(st.v9j);
                        st.v9i = 0;
                        st.v9o = null;
                    case 11:
                        st.v2j = st.v2j - st.v9j;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.pc = 12;
                        st.resultJ = st.v2j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 13:
                        st.pc = 13;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 16:
                        st.v2o = "attempt to divide by zero (as '";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v9j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v9o = " // ";
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 21:
                        st.pc = 21;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v11j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v9o = "')";
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.pc = 24;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 25:
                        st.v9o = st.tmpO;
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v0o = new luaj.d((java.lang.String) st.v9o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 27:
                        st.pc = 27;
                        throw (java.lang.Throwable) st.v0o;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_S2_handler(st.pc, t);
            if (h < 0) {
                xm_S2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_S2_ctypes = {
    };
    private static final int[] xm_S2_handlers = {
        
    };
    private static int xm_S2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_S2_handlers.length; i += 4) {
            if (pc < xm_S2_handlers[i] || pc >= xm_S2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_S2_handlers[i + 3];
            if (ti < 0 || xm_S2_ctypes[ti].isInstance(t)) {
                return xm_S2_handlers[i + 2];
            }
        }
        return -1;
    }

    private luaj.LuaString T2() {
        xm_T2State st = new xm_T2State();
        st.v7o = this;
        return xm_T2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_T2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_T2State {
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
        java.lang.Object v7o;
    }

    private static luaj.LuaString xm_T2_run(xm_T2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 26) {
                done = xm_T2_c0(st);
            }
            else {
                done = xm_T2_c0(st);
            }
            if (done) {
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_T2_c0(xm_T2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v7o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2j = 255L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 2:
                        st.v4i = Long.compare(st.v0j, st.v2j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v4i > 0) {
                            st.pc = 21;
                            continue;
                        }
                    case 4:
                        st.v2j = 0xffffffffffffff00L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 5:
                        st.v4i = Long.compare(st.v0j, st.v2j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v4i < 0) {
                            st.pc = 21;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.v2o = luaj.LuaLong.U;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 8:
                        st.v3j = 256L;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 9:
                        st.v5j = st.v0j + st.v3j;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 10:
                        st.v6i = (int) st.v5j;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v5o != null) {
                            st.pc = 20;
                            continue;
                        }
                    case 13:
                        st.v0j = st.v0j + st.v3j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 14:
                        st.v1i = (int) st.v0j;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((luaj.LuaLong) st.v7o).U2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.tmpO = luaj.LuaString.K2((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 19:
                        st.pc = 19;
                        ((java.lang.Object[]) st.v2o)[st.v1i] = st.v5o;
                    case 20:
                        st.pc = 20;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 21:
                        st.pc = 21;
                        st.tmpO = ((luaj.LuaLong) st.v7o).U2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.tmpO = luaj.LuaString.K2((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.v0o = st.tmpO;
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
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_T2_handler(st.pc, t);
            if (h < 0) {
                xm_T2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_T2_ctypes = {
    };
    private static final int[] xm_T2_handlers = {
        
    };
    private static int xm_T2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_T2_handlers.length; i += 4) {
            if (pc < xm_T2_handlers[i] || pc >= xm_T2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_T2_handlers[i + 3];
            if (ti < 0 || xm_T2_ctypes[ti].isInstance(t)) {
                return xm_T2_handlers[i + 2];
            }
        }
        return -1;
    }

    private java.lang.String U2() {
        xm_U2State st = new xm_U2State();
        st.v7o = this;
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
        java.lang.Object v7o;
    }

    private static java.lang.String xm_U2_run(xm_U2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 22) {
                done = xm_U2_c0(st);
            }
            else {
                done = xm_U2_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_U2_c0(xm_U2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v7o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2j = 255L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 2:
                        st.v4i = Long.compare(st.v0j, st.v2j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v4i > 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 4:
                        st.v2j = 0xffffffffffffff00L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 5:
                        st.v4i = Long.compare(st.v0j, st.v2j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v4i < 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.v2o = luaj.LuaLong.V;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 8:
                        st.v3j = 256L;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 9:
                        st.v5j = st.v0j + st.v3j;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 10:
                        st.v6i = (int) st.v5j;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v5o = ((java.lang.Object[]) st.v2o)[st.v6i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v5o != null) {
                            st.pc = 18;
                            continue;
                        }
                    case 13:
                        st.v3j = st.v3j + st.v0j;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 14:
                        st.v4i = (int) st.v3j;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = java.lang.Long.toString(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 17:
                        st.pc = 17;
                        ((java.lang.Object[]) st.v2o)[st.v4i] = st.v5o;
                    case 18:
                        st.pc = 18;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 19:
                        st.pc = 19;
                        st.tmpO = java.lang.Long.toString(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 21:
                        st.pc = 21;
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

    public static int V2(long j) {
        xm_V2State st = new xm_V2State();
        st.v3j = j;
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
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static int xm_V2_run(xm_V2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_V2_c0(st);
            }
            else {
                done = xm_V2_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_V2_c0(xm_V2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 32;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v0j = st.v3j >>> st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 2:
                        st.v3j = st.v3j ^ st.v0j;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 3:
                        st.v4i = (int) st.v3j;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
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

    public static long W2(long j, long j2) {
        xm_W2State st = new xm_W2State();
        st.v6j = j;
        st.v8j = j2;
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
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        long v8j;
    }

    private static long xm_W2_run(xm_W2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 33) {
                done = xm_W2_c0(st);
            }
            else {
                done = xm_W2_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_W2_c0(xm_W2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0j = 0L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2i = Long.compare(st.v8j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v2i == 0) {
                            st.pc = 18;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v6j = st.v6j % st.v8j;
                        st.v6d = java.lang.Double.longBitsToDouble(st.v6j);
                        st.v6i = 0;
                        st.v6o = null;
                    case 4:
                        st.v3i = Long.compare(st.v6j, st.v0j);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v3i == 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 6:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v3i >= 0) {
                            st.pc = 11;
                            continue;
                        }
                    case 9:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.pc = 12;
                        continue;
                    case 11:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v2i >= 0) {
                            st.pc = 14;
                            continue;
                        }
                    case 13:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 14:
                        st.v0i = st.v0i ^ st.v3i;
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
                        st.v6j = st.v6j + st.v8j;
                        st.v6d = java.lang.Double.longBitsToDouble(st.v6j);
                        st.v6i = 0;
                        st.v6o = null;
                    case 17:
                        st.pc = 17;
                        st.resultJ = st.v6j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 18:
                        st.pc = 18;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 21:
                        st.v2o = "attempt to perform 'n%0' (as '";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v6j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.v6o = " % ";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 26:
                        st.pc = 26;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v8j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.v6o = "')";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 29:
                        st.pc = 29;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.v0o = new luaj.d((java.lang.String) st.v6o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 32:
                        st.pc = 32;
                        throw (java.lang.Throwable) st.v0o;
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

    public static luaj.LuaValue X2(long j, long j2) {
        xm_X2State st = new xm_X2State();
        st.v5j = j;
        st.v7j = j2;
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
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private static luaj.LuaValue xm_X2_run(xm_X2State st) {
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
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_X2_c0(xm_X2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0j = 0L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2i = Long.compare(st.v7j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v2i >= 0) {
                            st.pc = 7;
                            continue;
                        }
                    case 3:
                        st.v7j = -st.v7j;
                        st.v7d = java.lang.Double.longBitsToDouble(st.v7j);
                        st.v7i = 0;
                        st.v7o = null;
                    case 4:
                        st.pc = 4;
                        st.tmpO = luaj.LuaLong.Y2(st.v5j, st.v7j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 7:
                        st.v0j = 63L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 8:
                        st.v2i = Long.compare(st.v7j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v2i <= 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v5o = luaj.LuaValue.f1677g;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 12:
                        st.v8i = (int) st.v7j;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 13:
                        st.v5j = st.v5j << st.v8j;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 14:
                        st.pc = 14;
                        st.tmpO = luaj.LuaLong.I2(st.v5j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
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

    public static luaj.LuaValue Y2(long j, long j2) {
        xm_Y2State st = new xm_Y2State();
        st.v5j = j;
        st.v7j = j2;
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
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private static luaj.LuaValue xm_Y2_run(xm_Y2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 17) {
                done = xm_Y2_c0(st);
            }
            else {
                done = xm_Y2_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_Y2_c0(xm_Y2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0j = 0L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2i = Long.compare(st.v7j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v2i >= 0) {
                            st.pc = 7;
                            continue;
                        }
                    case 3:
                        st.v7j = -st.v7j;
                        st.v7d = java.lang.Double.longBitsToDouble(st.v7j);
                        st.v7i = 0;
                        st.v7o = null;
                    case 4:
                        st.pc = 4;
                        st.tmpO = luaj.LuaLong.X2(st.v5j, st.v7j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 7:
                        st.v0j = 63L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 8:
                        st.v2i = Long.compare(st.v7j, st.v0j);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v2i <= 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v5o = luaj.LuaValue.f1677g;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 12:
                        st.v8i = (int) st.v7j;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 13:
                        st.v5j = st.v5j >>> st.v8j;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 14:
                        st.pc = 14;
                        st.tmpO = luaj.LuaLong.I2(st.v5j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
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

    @Override // luaj.LuaValue
    public int A0() {
        xm_A0State st = new xm_A0State();
        st.v2o = this;
        return xm_A0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_A0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_A0State {
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

    private static int xm_A0_run(xm_A0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_A0_c0(st);
            }
            else {
                done = xm_A0_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_A0_c0(xm_A0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v1i = (int) st.v0j;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
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
            int h = xm_A0_handler(st.pc, t);
            if (h < 0) {
                xm_A0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_A0_ctypes = {
    };
    private static final int[] xm_A0_handlers = {
        
    };
    private static int xm_A0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_A0_handlers.length; i += 4) {
            if (pc < xm_A0_handlers[i] || pc >= xm_A0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_A0_handlers[i + 3];
            if (ti < 0 || xm_A0_ctypes[ti].isInstance(t)) {
                return xm_A0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue A1() {
        xm_A1State st = new xm_A1State();
        st.v2o = this;
        return xm_A1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_A1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_A1State {
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
    }

    private static luaj.LuaValue xm_A1_run(xm_A1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_A1_c0(st);
            }
            else {
                done = xm_A1_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_A1_c0(xm_A1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v0j = -st.v0j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 2:
                        st.pc = 2;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
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
            int h = xm_A1_handler(st.pc, t);
            if (h < 0) {
                xm_A1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_A1_ctypes = {
    };
    private static final int[] xm_A1_handlers = {
        
    };
    private static int xm_A1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_A1_handlers.length; i += 4) {
            if (pc < xm_A1_handlers[i] || pc >= xm_A1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_A1_handlers[i + 3];
            if (ti < 0 || xm_A1_ctypes[ti].isInstance(t)) {
                return xm_A1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public java.lang.String B0() {
        xm_B0State st = new xm_B0State();
        st.v2o = this;
        return xm_B0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_B0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_B0State {
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
    }

    private static java.lang.String xm_B0_run(xm_B0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_B0_c0(st);
            }
            else {
                done = xm_B0_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_B0_c0(xm_B0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.pc = 1;
                        st.tmpO = java.lang.String.valueOf(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
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
            int h = xm_B0_handler(st.pc, t);
            if (h < 0) {
                xm_B0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_B0_ctypes = {
    };
    private static final int[] xm_B0_handlers = {
        
    };
    private static int xm_B0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_B0_handlers.length; i += 4) {
            if (pc < xm_B0_handlers[i] || pc >= xm_B0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_B0_handlers[i + 3];
            if (ti < 0 || xm_B0_ctypes[ti].isInstance(t)) {
                return xm_B0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue B2() {
        xm_B2State st = new xm_B2State();
        st.v1o = this;
        return xm_B2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_B2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_B2State {
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

    private static luaj.LuaValue xm_B2_run(xm_B2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_B2_c0(st);
            }
            else {
                done = xm_B2_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_B2_c0(xm_B2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaLong) st.v1o).T2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v0o = st.tmpO;
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
            int h = xm_B2_handler(st.pc, t);
            if (h < 0) {
                xm_B2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_B2_ctypes = {
    };
    private static final int[] xm_B2_handlers = {
        
    };
    private static int xm_B2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_B2_handlers.length; i += 4) {
            if (pc < xm_B2_handlers[i] || pc >= xm_B2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_B2_handlers[i + 3];
            if (ti < 0 || xm_B2_ctypes[ti].isInstance(t)) {
                return xm_B2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public long C0() {
        xm_C0State st = new xm_C0State();
        st.v2o = this;
        return xm_C0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_C0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_C0State {
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
    }

    private static long xm_C0_run(xm_C0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_C0_c0(st);
            }
            else {
                done = xm_C0_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_C0_c0(xm_C0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.pc = 1;
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
            int h = xm_C0_handler(st.pc, t);
            if (h < 0) {
                xm_C0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_C0_ctypes = {
    };
    private static final int[] xm_C0_handlers = {
        
    };
    private static int xm_C0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_C0_handlers.length; i += 4) {
            if (pc < xm_C0_handlers[i] || pc >= xm_C0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_C0_handlers[i + 3];
            if (ti < 0 || xm_C0_ctypes[ti].isInstance(t)) {
                return xm_C0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public double F1(double d2) {
        xm_F1State st = new xm_F1State();
        st.v1o = this;
        st.v2d = d2;
        return xm_F1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_F1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_F1State {
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
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
    }

    private static double xm_F1_run(xm_F1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_F1_c0(st);
            }
            else {
                done = xm_F1_c0(st);
            }
            if (done) {
                return st.resultD;
            }
        }
    }

    private static boolean xm_F1_c0(xm_F1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v2j = ((luaj.LuaLong) st.v1o).Q;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 1:
                        st.v2d = (double) st.v2j;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 2:
                        st.pc = 2;
                        st.resultD = st.v2d;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultO = null;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_F1_handler(st.pc, t);
            if (h < 0) {
                xm_F1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_F1_ctypes = {
    };
    private static final int[] xm_F1_handlers = {
        
    };
    private static int xm_F1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_F1_handlers.length; i += 4) {
            if (pc < xm_F1_handlers[i] || pc >= xm_F1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_F1_handlers[i + 3];
            if (ti < 0 || xm_F1_ctypes[ti].isInstance(t)) {
                return xm_F1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaString G0() {
        xm_G0State st = new xm_G0State();
        st.v2o = this;
        return xm_G0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_G0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_G0State {
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
    }

    private static luaj.LuaString xm_G0_run(xm_G0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 6) {
                done = xm_G0_c0(st);
            }
            else {
                done = xm_G0_c0(st);
            }
            if (done) {
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_G0_c0(xm_G0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.pc = 1;
                        st.tmpO = java.lang.String.valueOf(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpO = luaj.LuaValue.K2((java.lang.String) st.v0o);
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
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_G0_handler(st.pc, t);
            if (h < 0) {
                xm_G0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_G0_ctypes = {
    };
    private static final int[] xm_G0_handlers = {
        
    };
    private static int xm_G0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_G0_handlers.length; i += 4) {
            if (pc < xm_G0_handlers[i] || pc >= xm_G0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_G0_handlers[i + 3];
            if (ti < 0 || xm_G0_ctypes[ti].isInstance(t)) {
                return xm_G0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public int H1(int i) {
        xm_H1State st = new xm_H1State();
        st.v2o = this;
        st.v3i = i;
        return xm_H1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_H1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_H1State {
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

    private static int xm_H1_run(xm_H1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_H1_c0(st);
            }
            else {
                done = xm_H1_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_H1_c0(xm_H1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v3i = (int) st.v0j;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.resultI = st.v3i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_H1_handler(st.pc, t);
            if (h < 0) {
                xm_H1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_H1_ctypes = {
    };
    private static final int[] xm_H1_handlers = {
        
    };
    private static int xm_H1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_H1_handlers.length; i += 4) {
            if (pc < xm_H1_handlers[i] || pc >= xm_H1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_H1_handlers[i + 3];
            if (ti < 0 || xm_H1_ctypes[ti].isInstance(t)) {
                return xm_H1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public java.lang.String I1(java.lang.String str) {
        xm_I1State st = new xm_I1State();
        st.v0o = this;
        st.v1o = str;
        return xm_I1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_I1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_I1State {
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

    private static java.lang.String xm_I1_run(xm_I1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_I1_c0(st);
            }
            else {
                done = xm_I1_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_I1_c0(xm_I1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaLong) st.v0o).U2();
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
            int h = xm_I1_handler(st.pc, t);
            if (h < 0) {
                xm_I1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_I1_ctypes = {
    };
    private static final int[] xm_I1_handlers = {
        
    };
    private static int xm_I1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_I1_handlers.length; i += 4) {
            if (pc < xm_I1_handlers[i] || pc >= xm_I1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_I1_handlers[i + 3];
            if (ti < 0 || xm_I1_ctypes[ti].isInstance(t)) {
                return xm_I1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public long J1(long j) {
        xm_J1State st = new xm_J1State();
        st.v1o = this;
        st.v2j = j;
        return xm_J1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_J1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_J1State {
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
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
    }

    private static long xm_J1_run(xm_J1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_J1_c0(st);
            }
            else {
                done = xm_J1_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_J1_c0(xm_J1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v2j = ((luaj.LuaLong) st.v1o).Q;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 1:
                        st.pc = 1;
                        st.resultJ = st.v2j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_J1_handler(st.pc, t);
            if (h < 0) {
                xm_J1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_J1_ctypes = {
    };
    private static final int[] xm_J1_handlers = {
        
    };
    private static int xm_J1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_J1_handlers.length; i += 4) {
            if (pc < xm_J1_handlers[i] || pc >= xm_J1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_J1_handlers[i + 3];
            if (ti < 0 || xm_J1_ctypes[ti].isInstance(t)) {
                return xm_J1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaString K1(luaj.LuaString luaString) {
        xm_K1State st = new xm_K1State();
        st.v0o = this;
        st.v1o = luaString;
        return xm_K1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_K1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_K1State {
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

    private static luaj.LuaString xm_K1_run(xm_K1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_K1_c0(st);
            }
            else {
                done = xm_K1_c0(st);
            }
            if (done) {
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_K1_c0(xm_K1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaLong) st.v0o).T2();
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
            int h = xm_K1_handler(st.pc, t);
            if (h < 0) {
                xm_K1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_K1_ctypes = {
    };
    private static final int[] xm_K1_handlers = {
        
    };
    private static int xm_K1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_K1_handlers.length; i += 4) {
            if (pc < xm_K1_handlers[i] || pc >= xm_K1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_K1_handlers[i + 3];
            if (ti < 0 || xm_K1_ctypes[ti].isInstance(t)) {
                return xm_K1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue O0(luaj.LuaValue luaValue) {
        xm_O0State st = new xm_O0State();
        st.v5o = this;
        st.v6o = luaValue;
        return xm_O0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_O0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_O0State {
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
        java.lang.Object v5o;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
    }

    private luaj.LuaValue xm_O0_run(xm_O0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 28) {
                done = xm_O0_c0(st);
            }
            else {
                done = xm_O0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_O0_c0(xm_O0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v6o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.O0((luaj.LuaValue) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 27;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v6o).k1()) ? 1 : 0;
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
                            st.pc = 21;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.tmpJ = ((luaj.LuaValue) st.v6o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 10:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 11:
                        st.v2j = 0L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.v4i = Long.compare(st.v0j, st.v2j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v4i == 0) {
                            st.pc = 21;
                            continue;
                        }
                    case 14:
                        st.pc = 14;
                        st.v0j = ((luaj.LuaLong) st.v5o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 15:
                        st.pc = 15;
                        st.tmpJ = ((luaj.LuaValue) st.v6o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 16:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 17:
                        st.pc = 17;
                        st.v0j = st.v0j / st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 18:
                        st.pc = 18;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.pc = 27;
                        continue;
                    case 21:
                        st.pc = 21;
                        st.v0j = ((luaj.LuaLong) st.v5o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 22:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 23:
                        st.pc = 23;
                        st.tmpD = ((luaj.LuaValue) st.v6o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 24:
                        st.v2d = st.tmpD;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 25:
                        st.pc = 25;
                        st.tmpO = luaj.LuaDouble.S2(st.v0d, st.v2d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 26:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 27:
                        st.pc = 27;
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
            int h = xm_O0_handler(st.pc, t);
            if (h < 0) {
                xm_O0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_O0_ctypes = {
    };
    private static final int[] xm_O0_handlers = {
        
    };
    private static int xm_O0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_O0_handlers.length; i += 4) {
            if (pc < xm_O0_handlers[i] || pc >= xm_O0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_O0_handlers[i + 3];
            if (ti < 0 || xm_O0_ctypes[ti].isInstance(t)) {
                return xm_O0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean P0(luaj.LuaValue luaValue) {
        xm_P0State st = new xm_P0State();
        st.v7o = this;
        st.v8o = luaValue;
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private boolean xm_P0_run(xm_P0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 27) {
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

    private boolean xm_P0_c0(xm_P0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v8o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpI = (super.P0((luaj.LuaValue) st.v8o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 26;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v8o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v3j = ((luaj.LuaLong) st.v7o).Q;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 11:
                        st.pc = 11;
                        if (st.v0i == 0) {
                            st.pc = 20;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.tmpJ = ((luaj.LuaValue) st.v8o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 13:
                        st.v5j = st.tmpJ;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 14:
                        st.v8i = Long.compare(st.v3j, st.v5j);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v8i != 0) {
                            st.pc = 18;
                            continue;
                        }
                    case 16:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.pc = 26;
                        continue;
                    case 18:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.pc = 26;
                        continue;
                    case 20:
                        st.v3d = (double) st.v3j;
                        st.v3j = java.lang.Double.doubleToRawLongBits(st.v3d);
                        st.v3i = 0;
                        st.v3o = null;
                    case 21:
                        st.pc = 21;
                        st.tmpD = ((luaj.LuaValue) st.v8o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 22:
                        st.v5d = st.tmpD;
                        st.v5j = java.lang.Double.doubleToRawLongBits(st.v5d);
                        st.v5i = 0;
                        st.v5o = null;
                    case 23:
                        st.pc = 23;
                        st.v8i = (Double.isNaN(st.v3d) || Double.isNaN(st.v5d) ? -1 : (st.v3d < st.v5d ? -1 : (st.v3d == st.v5d ? 0 : 1)));
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 24:
                        st.pc = 24;
                        if (st.v8i != 0) {
                            st.pc = 18;
                            continue;
                        }
                    case 25:
                        st.pc = 25;
                        st.pc = 16;
                        continue;
                    case 26:
                        st.pc = 26;
                        st.resultI = st.v8i;
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
    public luaj.LuaValue Q1(luaj.LuaValue luaValue) {
        xm_Q1State st = new xm_Q1State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_Q1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_Q1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_Q1State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_Q1_run(xm_Q1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 15) {
                done = xm_Q1_c0(st);
            }
            else {
                done = xm_Q1_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_Q1_c0(xm_Q1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.Q1((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 14;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 7:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 8:
                        st.pc = 8;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v2d = st.tmpD;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpD = java.lang.Math.pow(st.v0d, st.v2d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 11:
                        st.v0d = st.tmpD;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 12:
                        st.pc = 12;
                        st.tmpO = luaj.LuaValue.J2(st.v0d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 13:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_Q1_handler(st.pc, t);
            if (h < 0) {
                xm_Q1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_Q1_ctypes = {
    };
    private static final int[] xm_Q1_handlers = {
        
    };
    private static int xm_Q1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_Q1_handlers.length; i += 4) {
            if (pc < xm_Q1_handlers[i] || pc >= xm_Q1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_Q1_handlers[i + 3];
            if (ti < 0 || xm_Q1_ctypes[ti].isInstance(t)) {
                return xm_Q1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean T1(luaj.LuaValue luaValue) {
        xm_T1State st = new xm_T1State();
        st.v7o = this;
        st.v8o = luaValue;
        return xm_T1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_T1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_T1State {
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private static boolean xm_T1_run(xm_T1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 23) {
                done = xm_T1_c0(st);
            }
            else {
                done = xm_T1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_T1_c0(xm_T1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v8o).m1()) ? 1 : 0;
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
                        st.pc = 3;
                        if (st.v0i != 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.pc = 22;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v8o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v3j = ((luaj.LuaLong) st.v7o).Q;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 9:
                        st.pc = 9;
                        if (st.v0i == 0) {
                            st.pc = 16;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.tmpJ = ((luaj.LuaValue) st.v8o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 11:
                        st.v5j = st.tmpJ;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 12:
                        st.v8i = Long.compare(st.v3j, st.v5j);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v8i != 0) {
                            st.pc = 22;
                            continue;
                        }
                    case 14:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.pc = 22;
                        continue;
                    case 16:
                        st.v3d = (double) st.v3j;
                        st.v3j = java.lang.Double.doubleToRawLongBits(st.v3d);
                        st.v3i = 0;
                        st.v3o = null;
                    case 17:
                        st.pc = 17;
                        st.tmpD = ((luaj.LuaValue) st.v8o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 18:
                        st.v5d = st.tmpD;
                        st.v5j = java.lang.Double.doubleToRawLongBits(st.v5d);
                        st.v5i = 0;
                        st.v5o = null;
                    case 19:
                        st.pc = 19;
                        st.v8i = (Double.isNaN(st.v3d) || Double.isNaN(st.v5d) ? -1 : (st.v3d < st.v5d ? -1 : (st.v3d == st.v5d ? 0 : 1)));
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 20:
                        st.pc = 20;
                        if (st.v8i != 0) {
                            st.pc = 22;
                            continue;
                        }
                    case 21:
                        st.pc = 21;
                        st.pc = 14;
                        continue;
                    case 22:
                        st.pc = 22;
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
            int h = xm_T1_handler(st.pc, t);
            if (h < 0) {
                xm_T1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_T1_ctypes = {
    };
    private static final int[] xm_T1_handlers = {
        
    };
    private static int xm_T1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_T1_handlers.length; i += 4) {
            if (pc < xm_T1_handlers[i] || pc >= xm_T1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_T1_handlers[i + 3];
            if (ti < 0 || xm_T1_ctypes[ti].isInstance(t)) {
                return xm_T1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean X0(luaj.LuaValue luaValue) {
        xm_X0State st = new xm_X0State();
        st.v7o = this;
        st.v8o = luaValue;
        return xm_X0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_X0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_X0State {
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private boolean xm_X0_run(xm_X0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 26) {
                done = xm_X0_c0(st);
            }
            else {
                done = xm_X0_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private boolean xm_X0_c0(xm_X0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = (st.v8o instanceof luaj.LuaNumber) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i != 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpI = (super.X0((luaj.LuaValue) st.v8o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 25;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v8o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v3j = ((luaj.LuaLong) st.v7o).Q;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 10:
                        st.pc = 10;
                        if (st.v0i == 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.tmpJ = ((luaj.LuaValue) st.v8o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 12:
                        st.v5j = st.tmpJ;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 13:
                        st.v8i = Long.compare(st.v3j, st.v5j);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v8i <= 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 25;
                        continue;
                    case 17:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.pc = 25;
                        continue;
                    case 19:
                        st.v3d = (double) st.v3j;
                        st.v3j = java.lang.Double.doubleToRawLongBits(st.v3d);
                        st.v3i = 0;
                        st.v3o = null;
                    case 20:
                        st.pc = 20;
                        st.tmpD = ((luaj.LuaValue) st.v8o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v5d = st.tmpD;
                        st.v5j = java.lang.Double.doubleToRawLongBits(st.v5d);
                        st.v5i = 0;
                        st.v5o = null;
                    case 22:
                        st.pc = 22;
                        st.v8i = (Double.isNaN(st.v3d) || Double.isNaN(st.v5d) ? -1 : (st.v3d < st.v5d ? -1 : (st.v3d == st.v5d ? 0 : 1)));
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v8i <= 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        st.pc = 15;
                        continue;
                    case 25:
                        st.pc = 25;
                        st.resultI = st.v8i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_X0_handler(st.pc, t);
            if (h < 0) {
                xm_X0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_X0_ctypes = {
    };
    private static final int[] xm_X0_handlers = {
        
    };
    private static int xm_X0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_X0_handlers.length; i += 4) {
            if (pc < xm_X0_handlers[i] || pc >= xm_X0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_X0_handlers[i + 3];
            if (ti < 0 || xm_X0_ctypes[ti].isInstance(t)) {
                return xm_X0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean Y0(luaj.LuaValue luaValue) {
        xm_Y0State st = new xm_Y0State();
        st.v7o = this;
        st.v8o = luaValue;
        return xm_Y0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_Y0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_Y0State {
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private boolean xm_Y0_run(xm_Y0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 26) {
                done = xm_Y0_c0(st);
            }
            else {
                done = xm_Y0_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private boolean xm_Y0_c0(xm_Y0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = (st.v8o instanceof luaj.LuaNumber) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i != 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpI = (super.Y0((luaj.LuaValue) st.v8o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 25;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v8o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v3j = ((luaj.LuaLong) st.v7o).Q;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 10:
                        st.pc = 10;
                        if (st.v0i == 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.tmpJ = ((luaj.LuaValue) st.v8o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 12:
                        st.v5j = st.tmpJ;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 13:
                        st.v8i = Long.compare(st.v3j, st.v5j);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v8i < 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 25;
                        continue;
                    case 17:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.pc = 25;
                        continue;
                    case 19:
                        st.v3d = (double) st.v3j;
                        st.v3j = java.lang.Double.doubleToRawLongBits(st.v3d);
                        st.v3i = 0;
                        st.v3o = null;
                    case 20:
                        st.pc = 20;
                        st.tmpD = ((luaj.LuaValue) st.v8o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v5d = st.tmpD;
                        st.v5j = java.lang.Double.doubleToRawLongBits(st.v5d);
                        st.v5i = 0;
                        st.v5o = null;
                    case 22:
                        st.pc = 22;
                        st.v8i = (Double.isNaN(st.v3d) || Double.isNaN(st.v5d) ? -1 : (st.v3d < st.v5d ? -1 : (st.v3d == st.v5d ? 0 : 1)));
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v8i < 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        st.pc = 15;
                        continue;
                    case 25:
                        st.pc = 25;
                        st.resultI = st.v8i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_Y0_handler(st.pc, t);
            if (h < 0) {
                xm_Y0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_Y0_ctypes = {
    };
    private static final int[] xm_Y0_handlers = {
        
    };
    private static int xm_Y0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_Y0_handlers.length; i += 4) {
            if (pc < xm_Y0_handlers[i] || pc >= xm_Y0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_Y0_handlers[i + 3];
            if (ti < 0 || xm_Y0_ctypes[ti].isInstance(t)) {
                return xm_Y0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue Z0(luaj.LuaValue luaValue) {
        xm_Z0State st = new xm_Z0State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_Z0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_Z0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_Z0State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_Z0_run(xm_Z0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_Z0_c0(st);
            }
            else {
                done = xm_Z0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_Z0_c0(xm_Z0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.Z0((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 23;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v5o).j1()) ? 1 : 0;
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
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 11:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.pc = 12;
                        st.tmpJ = luaj.LuaLong.S2(st.v0j, st.v2j);
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 13:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 14:
                        st.pc = 14;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 23;
                        continue;
                    case 17:
                        st.pc = 17;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 18:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 19:
                        st.pc = 19;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 20:
                        st.v2d = st.tmpD;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 21:
                        st.pc = 21;
                        st.tmpO = luaj.LuaDouble.T2(st.v0d, st.v2d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_Z0_handler(st.pc, t);
            if (h < 0) {
                xm_Z0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_Z0_ctypes = {
    };
    private static final int[] xm_Z0_handlers = {
        
    };
    private static int xm_Z0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_Z0_handlers.length; i += 4) {
            if (pc < xm_Z0_handlers[i] || pc >= xm_Z0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_Z0_handlers[i + 3];
            if (ti < 0 || xm_Z0_ctypes[ti].isInstance(t)) {
                return xm_Z0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean equals(java.lang.Object obj) {
        xm_equalsState st = new xm_equalsState();
        st.v6o = this;
        st.v7o = obj;
        return xm_equals_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_equals_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_equalsState {
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
    }

    private static boolean xm_equals_run(xm_equalsState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 10) {
                done = xm_equals_c0(st);
            }
            else {
                done = xm_equals_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_equals_c0(xm_equalsState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = (st.v7o instanceof luaj.LuaLong) ? 1 : 0;
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
                        if (st.v0i == 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v7o = (luaj.LuaLong) st.v7o;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v2j = ((luaj.LuaLong) st.v7o).Q;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 5:
                        st.pc = 5;
                        st.v4j = ((luaj.LuaLong) st.v6o).Q;
                        st.v4d = java.lang.Double.longBitsToDouble(st.v4j);
                        st.v4i = 0;
                        st.v4o = null;
                    case 6:
                        st.v7i = Long.compare(st.v2j, st.v4j);
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v7i != 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 8:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
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
            int h = xm_equals_handler(st.pc, t);
            if (h < 0) {
                xm_equals_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_equals_ctypes = {
    };
    private static final int[] xm_equals_handlers = {
        
    };
    private static int xm_equals_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_equals_handlers.length; i += 4) {
            if (pc < xm_equals_handlers[i] || pc >= xm_equals_handlers[i + 1]) {
                continue;
            }
            int ti = xm_equals_handlers[i + 3];
            if (ti < 0 || xm_equals_ctypes[ti].isInstance(t)) {
                return xm_equals_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue, luaj.Varargs
    public java.lang.String g0() {
        xm_g0State st = new xm_g0State();
        st.v1o = this;
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
        java.lang.Object v1o;
    }

    private static java.lang.String xm_g0_run(xm_g0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
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
                        st.tmpO = ((luaj.LuaLong) st.v1o).U2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v0o = st.tmpO;
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
    };
    private static final int[] xm_g0_handlers = {
        
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

    @Override // luaj.LuaValue
    public boolean h1() {
        xm_h1State st = new xm_h1State();
        st.v1o = this;
        return xm_h1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_h1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_h1State {
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

    private static boolean xm_h1_run(xm_h1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_h1_c0(st);
            }
            else {
                done = xm_h1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_h1_c0(xm_h1State st) {
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
            int h = xm_h1_handler(st.pc, t);
            if (h < 0) {
                xm_h1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_h1_ctypes = {
    };
    private static final int[] xm_h1_handlers = {
        
    };
    private static int xm_h1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_h1_handlers.length; i += 4) {
            if (pc < xm_h1_handlers[i] || pc >= xm_h1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_h1_handlers[i + 3];
            if (ti < 0 || xm_h1_ctypes[ti].isInstance(t)) {
                return xm_h1_handlers[i + 2];
            }
        }
        return -1;
    }

    public int hashCode() {
        xm_hashCodeState st = new xm_hashCodeState();
        st.v2o = this;
        return xm_hashCode_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_hashCode_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_hashCodeState {
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
    }

    private static int xm_hashCode_run(xm_hashCodeState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_hashCode_c0(st);
            }
            else {
                done = xm_hashCode_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_hashCode_c0(xm_hashCodeState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.pc = 1;
                        st.tmpI = luaj.LuaLong.V2(st.v0j);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
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
            int h = xm_hashCode_handler(st.pc, t);
            if (h < 0) {
                xm_hashCode_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_hashCode_ctypes = {
    };
    private static final int[] xm_hashCode_handlers = {
        
    };
    private static int xm_hashCode_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_hashCode_handlers.length; i += 4) {
            if (pc < xm_hashCode_handlers[i] || pc >= xm_hashCode_handlers[i + 1]) {
                continue;
            }
            int ti = xm_hashCode_handlers[i + 3];
            if (ti < 0 || xm_hashCode_ctypes[ti].isInstance(t)) {
                return xm_hashCode_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean i1() {
        xm_i1State st = new xm_i1State();
        st.v5o = this;
        return xm_i1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_i1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_i1State {
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
        java.lang.Object v5o;
    }

    private static boolean xm_i1_run(xm_i1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 9) {
                done = xm_i1_c0(st);
            }
            else {
                done = xm_i1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_i1_c0(xm_i1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v5o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2i = (int) st.v0j;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.v2j = st.v2i;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 3:
                        st.v4i = Long.compare(st.v2j, st.v0j);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v4i != 0) {
                            st.pc = 7;
                            continue;
                        }
                    case 5:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.pc = 8;
                        continue;
                    case 7:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
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
            int h = xm_i1_handler(st.pc, t);
            if (h < 0) {
                xm_i1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_i1_ctypes = {
    };
    private static final int[] xm_i1_handlers = {
        
    };
    private static int xm_i1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_i1_handlers.length; i += 4) {
            if (pc < xm_i1_handlers[i] || pc >= xm_i1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_i1_handlers[i + 3];
            if (ti < 0 || xm_i1_ctypes[ti].isInstance(t)) {
                return xm_i1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue j0(luaj.LuaValue luaValue) {
        xm_j0State st = new xm_j0State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_j0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_j0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_j0State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_j0_run(xm_j0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_j0_c0(st);
            }
            else {
                done = xm_j0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_j0_c0(xm_j0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.j0((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 23;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 16;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 11:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.v0j = st.v0j + st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 13:
                        st.pc = 13;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.pc = 23;
                        continue;
                    case 16:
                        st.pc = 16;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 17:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 18:
                        st.pc = 18;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v2d = st.tmpD;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 20:
                        st.v0d = st.v0d + st.v2d;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 21:
                        st.pc = 21;
                        st.tmpO = luaj.LuaValue.J2(st.v0d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_j0_handler(st.pc, t);
            if (h < 0) {
                xm_j0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_j0_ctypes = {
    };
    private static final int[] xm_j0_handlers = {
        
    };
    private static int xm_j0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_j0_handlers.length; i += 4) {
            if (pc < xm_j0_handlers[i] || pc >= xm_j0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_j0_handlers[i + 3];
            if (ti < 0 || xm_j0_ctypes[ti].isInstance(t)) {
                return xm_j0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean j1() {
        xm_j1State st = new xm_j1State();
        st.v1o = this;
        return xm_j1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_j1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_j1State {
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

    private static boolean xm_j1_run(xm_j1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_j1_c0(st);
            }
            else {
                done = xm_j1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_j1_c0(xm_j1State st) {
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
            int h = xm_j1_handler(st.pc, t);
            if (h < 0) {
                xm_j1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_j1_ctypes = {
    };
    private static final int[] xm_j1_handlers = {
        
    };
    private static int xm_j1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_j1_handlers.length; i += 4) {
            if (pc < xm_j1_handlers[i] || pc >= xm_j1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_j1_handlers[i + 3];
            if (ti < 0 || xm_j1_ctypes[ti].isInstance(t)) {
                return xm_j1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean k1() {
        xm_k1State st = new xm_k1State();
        st.v1o = this;
        return xm_k1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_k1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_k1State {
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

    private static boolean xm_k1_run(xm_k1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_k1_c0(st);
            }
            else {
                done = xm_k1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_k1_c0(xm_k1State st) {
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
            int h = xm_k1_handler(st.pc, t);
            if (h < 0) {
                xm_k1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_k1_ctypes = {
    };
    private static final int[] xm_k1_handlers = {
        
    };
    private static int xm_k1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_k1_handlers.length; i += 4) {
            if (pc < xm_k1_handlers[i] || pc >= xm_k1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_k1_handlers[i + 3];
            if (ti < 0 || xm_k1_ctypes[ti].isInstance(t)) {
                return xm_k1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue m2(luaj.LuaValue luaValue) {
        xm_m2State st = new xm_m2State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_m2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_m2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_m2State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_m2_run(xm_m2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 12) {
                done = xm_m2_c0(st);
            }
            else {
                done = xm_m2_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_m2_c0(xm_m2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.m2((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 11;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 7:
                        st.pc = 7;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 8:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 9:
                        st.pc = 9;
                        st.tmpO = luaj.LuaLong.X2(st.v0j, st.v2j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_m2_handler(st.pc, t);
            if (h < 0) {
                xm_m2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_m2_ctypes = {
    };
    private static final int[] xm_m2_handlers = {
        
    };
    private static int xm_m2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_m2_handlers.length; i += 4) {
            if (pc < xm_m2_handlers[i] || pc >= xm_m2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_m2_handlers[i + 3];
            if (ti < 0 || xm_m2_ctypes[ti].isInstance(t)) {
                return xm_m2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue n2(luaj.LuaValue luaValue) {
        xm_n2State st = new xm_n2State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_n2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_n2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_n2State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_n2_run(xm_n2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 12) {
                done = xm_n2_c0(st);
            }
            else {
                done = xm_n2_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_n2_c0(xm_n2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.n2((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 11;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 7:
                        st.pc = 7;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 8:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 9:
                        st.pc = 9;
                        st.tmpO = luaj.LuaLong.Y2(st.v0j, st.v2j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_n2_handler(st.pc, t);
            if (h < 0) {
                xm_n2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_n2_ctypes = {
    };
    private static final int[] xm_n2_handlers = {
        
    };
    private static int xm_n2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_n2_handlers.length; i += 4) {
            if (pc < xm_n2_handlers[i] || pc >= xm_n2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_n2_handlers[i + 3];
            if (ti < 0 || xm_n2_ctypes[ti].isInstance(t)) {
                return xm_n2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue o0(luaj.LuaValue luaValue) {
        xm_o0State st = new xm_o0State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_o0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_o0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_o0State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_o0_run(xm_o0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 13) {
                done = xm_o0_c0(st);
            }
            else {
                done = xm_o0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_o0_c0(xm_o0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.o0((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 12;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 7:
                        st.pc = 7;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 8:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 9:
                        st.v0j = st.v0j & st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_o0_handler(st.pc, t);
            if (h < 0) {
                xm_o0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_o0_ctypes = {
    };
    private static final int[] xm_o0_handlers = {
        
    };
    private static int xm_o0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_o0_handlers.length; i += 4) {
            if (pc < xm_o0_handlers[i] || pc >= xm_o0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_o0_handlers[i + 3];
            if (ti < 0 || xm_o0_ctypes[ti].isInstance(t)) {
                return xm_o0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue q0() {
        xm_q0State st = new xm_q0State();
        st.v2o = this;
        return xm_q0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_q0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_q0State {
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
    }

    private static luaj.LuaValue xm_q0_run(xm_q0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_q0_c0(st);
            }
            else {
                done = xm_q0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_q0_c0(xm_q0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v0j = ~st.v0j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 2:
                        st.pc = 2;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
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
            int h = xm_q0_handler(st.pc, t);
            if (h < 0) {
                xm_q0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_q0_ctypes = {
    };
    private static final int[] xm_q0_handlers = {
        
    };
    private static int xm_q0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_q0_handlers.length; i += 4) {
            if (pc < xm_q0_handlers[i] || pc >= xm_q0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_q0_handlers[i + 3];
            if (ti < 0 || xm_q0_ctypes[ti].isInstance(t)) {
                return xm_q0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaString q2() {
        xm_q2State st = new xm_q2State();
        st.v1o = this;
        return xm_q2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_q2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_q2State {
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

    private static luaj.LuaString xm_q2_run(xm_q2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_q2_c0(st);
            }
            else {
                done = xm_q2_c0(st);
            }
            if (done) {
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_q2_c0(xm_q2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.LuaLong) st.v1o).T2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v0o = st.tmpO;
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
            int h = xm_q2_handler(st.pc, t);
            if (h < 0) {
                xm_q2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_q2_ctypes = {
    };
    private static final int[] xm_q2_handlers = {
        
    };
    private static int xm_q2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_q2_handlers.length; i += 4) {
            if (pc < xm_q2_handlers[i] || pc >= xm_q2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_q2_handlers[i + 3];
            if (ti < 0 || xm_q2_ctypes[ti].isInstance(t)) {
                return xm_q2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue r0(luaj.LuaValue luaValue) {
        xm_r0State st = new xm_r0State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_r0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_r0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_r0State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_r0_run(xm_r0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 13) {
                done = xm_r0_c0(st);
            }
            else {
                done = xm_r0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_r0_c0(xm_r0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.r0((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 12;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 7:
                        st.pc = 7;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 8:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 9:
                        st.v0j = st.v0j | st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_r0_handler(st.pc, t);
            if (h < 0) {
                xm_r0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_r0_ctypes = {
    };
    private static final int[] xm_r0_handlers = {
        
    };
    private static int xm_r0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_r0_handlers.length; i += 4) {
            if (pc < xm_r0_handlers[i] || pc >= xm_r0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_r0_handlers[i + 3];
            if (ti < 0 || xm_r0_ctypes[ti].isInstance(t)) {
                return xm_r0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue r2(luaj.LuaValue luaValue) {
        xm_r2State st = new xm_r2State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_r2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_r2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_r2State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_r2_run(xm_r2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_r2_c0(st);
            }
            else {
                done = xm_r2_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_r2_c0(xm_r2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.r2((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 23;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 16;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 11:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.v0j = st.v0j - st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 13:
                        st.pc = 13;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.pc = 23;
                        continue;
                    case 16:
                        st.pc = 16;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 17:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 18:
                        st.pc = 18;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v2d = st.tmpD;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 20:
                        st.v0d = st.v0d - st.v2d;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 21:
                        st.pc = 21;
                        st.tmpO = luaj.LuaValue.J2(st.v0d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_r2_handler(st.pc, t);
            if (h < 0) {
                xm_r2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_r2_ctypes = {
    };
    private static final int[] xm_r2_handlers = {
        
    };
    private static int xm_r2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_r2_handlers.length; i += 4) {
            if (pc < xm_r2_handlers[i] || pc >= xm_r2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_r2_handlers[i + 3];
            if (ti < 0 || xm_r2_ctypes[ti].isInstance(t)) {
                return xm_r2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue t0(luaj.LuaValue luaValue) {
        xm_t0State st = new xm_t0State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_t0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_t0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_t0State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_t0_run(xm_t0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 13) {
                done = xm_t0_c0(st);
            }
            else {
                done = xm_t0_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_t0_c0(xm_t0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.t0((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 12;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 7:
                        st.pc = 7;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 8:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 9:
                        st.v0j = st.v0j ^ st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_t0_handler(st.pc, t);
            if (h < 0) {
                xm_t0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_t0_ctypes = {
    };
    private static final int[] xm_t0_handlers = {
        
    };
    private static int xm_t0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_t0_handlers.length; i += 4) {
            if (pc < xm_t0_handlers[i] || pc >= xm_t0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_t0_handlers[i + 3];
            if (ti < 0 || xm_t0_ctypes[ti].isInstance(t)) {
                return xm_t0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean u1(luaj.LuaValue luaValue) {
        xm_u1State st = new xm_u1State();
        st.v7o = this;
        st.v8o = luaValue;
        return xm_u1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_u1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_u1State {
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private boolean xm_u1_run(xm_u1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 26) {
                done = xm_u1_c0(st);
            }
            else {
                done = xm_u1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private boolean xm_u1_c0(xm_u1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = (st.v8o instanceof luaj.LuaNumber) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i != 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpI = (super.u1((luaj.LuaValue) st.v8o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 25;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v8o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v3j = ((luaj.LuaLong) st.v7o).Q;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 10:
                        st.pc = 10;
                        if (st.v0i == 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.tmpJ = ((luaj.LuaValue) st.v8o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 12:
                        st.v5j = st.tmpJ;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 13:
                        st.v8i = Long.compare(st.v3j, st.v5j);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v8i >= 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 25;
                        continue;
                    case 17:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.pc = 25;
                        continue;
                    case 19:
                        st.v3d = (double) st.v3j;
                        st.v3j = java.lang.Double.doubleToRawLongBits(st.v3d);
                        st.v3i = 0;
                        st.v3o = null;
                    case 20:
                        st.pc = 20;
                        st.tmpD = ((luaj.LuaValue) st.v8o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v5d = st.tmpD;
                        st.v5j = java.lang.Double.doubleToRawLongBits(st.v5d);
                        st.v5i = 0;
                        st.v5o = null;
                    case 22:
                        st.pc = 22;
                        st.v8i = (Double.isNaN(st.v3d) || Double.isNaN(st.v5d) ? 1 : (st.v3d < st.v5d ? -1 : (st.v3d == st.v5d ? 0 : 1)));
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v8i >= 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        st.pc = 15;
                        continue;
                    case 25:
                        st.pc = 25;
                        st.resultI = st.v8i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_u1_handler(st.pc, t);
            if (h < 0) {
                xm_u1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_u1_ctypes = {
    };
    private static final int[] xm_u1_handlers = {
        
    };
    private static int xm_u1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_u1_handlers.length; i += 4) {
            if (pc < xm_u1_handlers[i] || pc >= xm_u1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_u1_handlers[i + 3];
            if (ti < 0 || xm_u1_ctypes[ti].isInstance(t)) {
                return xm_u1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public boolean v1(luaj.LuaValue luaValue) {
        xm_v1State st = new xm_v1State();
        st.v7o = this;
        st.v8o = luaValue;
        return xm_v1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_v1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_v1State {
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private boolean xm_v1_run(xm_v1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 26) {
                done = xm_v1_c0(st);
            }
            else {
                done = xm_v1_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private boolean xm_v1_c0(xm_v1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = (st.v8o instanceof luaj.LuaNumber) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i != 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.tmpI = (super.v1((luaj.LuaValue) st.v8o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 25;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaValue) st.v8o).k1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v3j = ((luaj.LuaLong) st.v7o).Q;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 10:
                        st.pc = 10;
                        if (st.v0i == 0) {
                            st.pc = 19;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.tmpJ = ((luaj.LuaValue) st.v8o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 12:
                        st.v5j = st.tmpJ;
                        st.v5d = java.lang.Double.longBitsToDouble(st.v5j);
                        st.v5i = 0;
                        st.v5o = null;
                    case 13:
                        st.v8i = Long.compare(st.v3j, st.v5j);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v8i > 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 25;
                        continue;
                    case 17:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.pc = 25;
                        continue;
                    case 19:
                        st.v3d = (double) st.v3j;
                        st.v3j = java.lang.Double.doubleToRawLongBits(st.v3d);
                        st.v3i = 0;
                        st.v3o = null;
                    case 20:
                        st.pc = 20;
                        st.tmpD = ((luaj.LuaValue) st.v8o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v5d = st.tmpD;
                        st.v5j = java.lang.Double.doubleToRawLongBits(st.v5d);
                        st.v5i = 0;
                        st.v5o = null;
                    case 22:
                        st.pc = 22;
                        st.v8i = (Double.isNaN(st.v3d) || Double.isNaN(st.v5d) ? 1 : (st.v3d < st.v5d ? -1 : (st.v3d == st.v5d ? 0 : 1)));
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v8i > 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        st.pc = 15;
                        continue;
                    case 25:
                        st.pc = 25;
                        st.resultI = st.v8i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_v1_handler(st.pc, t);
            if (h < 0) {
                xm_v1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_v1_ctypes = {
    };
    private static final int[] xm_v1_handlers = {
        
    };
    private static int xm_v1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_v1_handlers.length; i += 4) {
            if (pc < xm_v1_handlers[i] || pc >= xm_v1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_v1_handlers[i + 3];
            if (ti < 0 || xm_v1_ctypes[ti].isInstance(t)) {
                return xm_v1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public double x0() {
        xm_x0State st = new xm_x0State();
        st.v2o = this;
        return xm_x0_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_x0_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_x0State {
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
    }

    private static double xm_x0_run(xm_x0State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_x0_c0(st);
            }
            else {
                done = xm_x0_c0(st);
            }
            if (done) {
                return st.resultD;
            }
        }
    }

    private static boolean xm_x0_c0(xm_x0State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 2:
                        st.pc = 2;
                        st.resultD = st.v0d;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultO = null;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_x0_handler(st.pc, t);
            if (h < 0) {
                xm_x0_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_x0_ctypes = {
    };
    private static final int[] xm_x0_handlers = {
        
    };
    private static int xm_x0_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_x0_handlers.length; i += 4) {
            if (pc < xm_x0_handlers[i] || pc >= xm_x0_handlers[i + 1]) {
                continue;
            }
            int ti = xm_x0_handlers[i + 3];
            if (ti < 0 || xm_x0_ctypes[ti].isInstance(t)) {
                return xm_x0_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public double x2() {
        xm_x2State st = new xm_x2State();
        st.v2o = this;
        return xm_x2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_x2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_x2State {
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
    }

    private static double xm_x2_run(xm_x2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_x2_c0(st);
            }
            else {
                done = xm_x2_c0(st);
            }
            if (done) {
                return st.resultD;
            }
        }
    }

    private static boolean xm_x2_c0(xm_x2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 2:
                        st.pc = 2;
                        st.resultD = st.v0d;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultO = null;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_x2_handler(st.pc, t);
            if (h < 0) {
                xm_x2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_x2_ctypes = {
    };
    private static final int[] xm_x2_handlers = {
        
    };
    private static int xm_x2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_x2_handlers.length; i += 4) {
            if (pc < xm_x2_handlers[i] || pc >= xm_x2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_x2_handlers[i + 3];
            if (ti < 0 || xm_x2_ctypes[ti].isInstance(t)) {
                return xm_x2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue y1(luaj.LuaValue luaValue) {
        xm_y1State st = new xm_y1State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_y1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_y1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_y1State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_y1_run(xm_y1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_y1_c0(st);
            }
            else {
                done = xm_y1_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_y1_c0(xm_y1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.y1((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 23;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v5o).j1()) ? 1 : 0;
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
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 11:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.pc = 12;
                        st.tmpJ = luaj.LuaLong.W2(st.v0j, st.v2j);
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 13:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 14:
                        st.pc = 14;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 23;
                        continue;
                    case 17:
                        st.pc = 17;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 18:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 19:
                        st.pc = 19;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 20:
                        st.v2d = st.tmpD;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 21:
                        st.pc = 21;
                        st.tmpO = luaj.LuaDouble.U2(st.v0d, st.v2d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_y1_handler(st.pc, t);
            if (h < 0) {
                xm_y1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_y1_ctypes = {
    };
    private static final int[] xm_y1_handlers = {
        
    };
    private static int xm_y1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_y1_handlers.length; i += 4) {
            if (pc < xm_y1_handlers[i] || pc >= xm_y1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_y1_handlers[i + 3];
            if (ti < 0 || xm_y1_ctypes[ti].isInstance(t)) {
                return xm_y1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public int y2() {
        xm_y2State st = new xm_y2State();
        st.v2o = this;
        return xm_y2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_y2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_y2State {
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

    private static int xm_y2_run(xm_y2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_y2_c0(st);
            }
            else {
                done = xm_y2_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_y2_c0(xm_y2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v1i = (int) st.v0j;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
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
            int h = xm_y2_handler(st.pc, t);
            if (h < 0) {
                xm_y2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_y2_ctypes = {
    };
    private static final int[] xm_y2_handlers = {
        
    };
    private static int xm_y2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_y2_handlers.length; i += 4) {
            if (pc < xm_y2_handlers[i] || pc >= xm_y2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_y2_handlers[i + 3];
            if (ti < 0 || xm_y2_ctypes[ti].isInstance(t)) {
                return xm_y2_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    public luaj.LuaValue z1(luaj.LuaValue luaValue) {
        xm_z1State st = new xm_z1State();
        st.v4o = this;
        st.v5o = luaValue;
        return xm_z1_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_z1_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_z1State {
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private luaj.LuaValue xm_z1_run(xm_z1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_z1_c0(st);
            }
            else {
                done = xm_z1_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private boolean xm_z1_c0(xm_z1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v5o).m1()) ? 1 : 0;
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
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = super.z1((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 23;
                        continue;
                    case 6:
                        st.pc = 6;
                        st.tmpI = (((luaj.LuaValue) st.v5o).k1()) ? 1 : 0;
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
                            st.pc = 16;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 10:
                        st.pc = 10;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 11:
                        st.v2j = st.tmpJ;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 12:
                        st.v0j = st.v0j * st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 13:
                        st.pc = 13;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.pc = 23;
                        continue;
                    case 16:
                        st.pc = 16;
                        st.v0j = ((luaj.LuaLong) st.v4o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 17:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 18:
                        st.pc = 18;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v2d = st.tmpD;
                        st.v2j = java.lang.Double.doubleToRawLongBits(st.v2d);
                        st.v2i = 0;
                        st.v2o = null;
                    case 20:
                        st.v0d = st.v0d * st.v2d;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 21:
                        st.pc = 21;
                        st.tmpO = luaj.LuaValue.J2(st.v0d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.resultO = st.v5o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_z1_handler(st.pc, t);
            if (h < 0) {
                xm_z1_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_z1_ctypes = {
    };
    private static final int[] xm_z1_handlers = {
        
    };
    private static int xm_z1_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_z1_handlers.length; i += 4) {
            if (pc < xm_z1_handlers[i] || pc >= xm_z1_handlers[i + 1]) {
                continue;
            }
            int ti = xm_z1_handlers[i + 3];
            if (ti < 0 || xm_z1_ctypes[ti].isInstance(t)) {
                return xm_z1_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.LuaValue
    /* ------------------------------------------------------------- *
     *  .method public z2()J
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public long z2() {
        xm_z2State st = new xm_z2State();
        st.v2o = this;
        return xm_z2_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_z2_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_z2State {
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
    }

    private static long xm_z2_run(xm_z2State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_z2_c0(st);
            }
            else {
                done = xm_z2_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_z2_c0(xm_z2State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0j = ((luaj.LuaLong) st.v2o).Q;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.pc = 1;
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
            int h = xm_z2_handler(st.pc, t);
            if (h < 0) {
                xm_z2_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_z2_ctypes = {
    };
    private static final int[] xm_z2_handlers = {
        
    };
    private static int xm_z2_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_z2_handlers.length; i += 4) {
            if (pc < xm_z2_handlers[i] || pc >= xm_z2_handlers[i + 1]) {
                continue;
            }
            int ti = xm_z2_handlers[i + 3];
            if (ti < 0 || xm_z2_ctypes[ti].isInstance(t)) {
                return xm_z2_handlers[i + 2];
            }
        }
        return -1;
    }
}

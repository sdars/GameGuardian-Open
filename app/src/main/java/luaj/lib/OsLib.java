package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
public class OsLib extends luaj.lib.TwoArgFunction {
    private static final long U;
    private static long V;
    private luaj.Globals T;

    static {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        U = jCurrentTimeMillis;
        V = jCurrentTimeMillis;
    }

    private luaj.LuaValue f3(luaj.LuaValue luaValue, boolean z) {
        xm_f3State st = new xm_f3State();
        st.v1o = this;
        st.v2o = luaValue;
        st.v3i = (z ? 1 : 0);
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
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static luaj.LuaValue xm_f3_run(xm_f3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 17) {
                done = xm_f3_c0(st);
            }
            else {
                done = xm_f3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_f3_c0(xm_f3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = (((luaj.LuaValue) st.v2o).l1()) ? 1 : 0;
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
                            st.pc = 9;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        if (st.v3i != 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.pc = 12;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 6:
                        st.v3o = "missing in date table";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v2o = new luaj.d((java.lang.String) st.v3o);
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 8:
                        st.pc = 8;
                        throw (java.lang.Throwable) st.v2o;
                    case 9:
                        st.pc = 9;
                        st.tmpI = (((luaj.LuaValue) st.v2o).i1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v3i == 0) {
                            st.pc = 13;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.resultO = st.v2o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 13:
                        st.pc = 13;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 14:
                        st.v3o = "is not an integer";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.v2o = new luaj.d((java.lang.String) st.v3o);
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 16:
                        st.pc = 16;
                        throw (java.lang.Throwable) st.v2o;
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

    double g3() {
        xm_g3State st = new xm_g3State();
        st.v4o = this;
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
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v4o;
    }

    private static double xm_g3_run(xm_g3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 12) {
                done = xm_g3_c0(st);
            }
            else {
                done = xm_g3_c0(st);
            }
            if (done) {
                return st.resultD;
            }
        }
    }

    private static boolean xm_g3_c0(xm_g3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpJ = java.lang.System.currentTimeMillis();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 1:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 2:
                        st.pc = 2;
                        st.v2j = luaj.lib.OsLib.U;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 3:
                        st.v0j = st.v0j - st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 4:
                        st.pc = 4;
                        st.v2o = ((luaj.lib.OsLib) st.v4o).T;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v2i = ((luaj.Globals) st.v2o).b0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.v2j = st.v2i;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 7:
                        st.v0j = st.v0j - st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 8:
                        st.v0d = (double) st.v0j;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 9:
                        st.v2j = 4652007308841189376L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 10:
                        st.v0d = st.v0d / st.v2d;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 11:
                        st.pc = 11;
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

    double i3(double d2, double d3) {
        xm_i3State st = new xm_i3State();
        st.v2o = this;
        st.v3d = d2;
        st.v5d = d3;
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
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        double v5d;
    }

    private static double xm_i3_run(xm_i3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_i3_c0(st);
            }
            else {
                done = xm_i3_c0(st);
            }
            if (done) {
                return st.resultD;
            }
        }
    }

    private static boolean xm_i3_c0(xm_i3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v3d = st.v3d - st.v5d;
                        st.v3j = java.lang.Double.doubleToRawLongBits(st.v3d);
                        st.v3i = 0;
                        st.v3o = null;
                    case 1:
                        st.pc = 1;
                        st.resultD = st.v3d;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultO = null;
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

    luaj.Varargs j3(java.lang.String str) {
        xm_j3State st = new xm_j3State();
        st.v3o = this;
        st.v4o = str;
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

    private static luaj.Varargs xm_j3_run(xm_j3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 12) {
                done = xm_j3_c0(st);
            }
            else {
                done = xm_j3_c0(st);
            }
            if (done) {
                return (luaj.Varargs) st.resultO;
            }
        }
    }

    private static boolean xm_j3_c0(xm_j3State st) {
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
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.v2o = "Failed os.execute('";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v4o = "'): disabled by security reason";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.pc = 8;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v0o = new luaj.d((java.lang.String) st.v4o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        throw (java.lang.Throwable) st.v0o;
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

    void k3(int i) {
        xm_k3State st = new xm_k3State();
        st.v0o = this;
        st.v1i = i;
        xm_k3_run(st);
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
    }

    private static void xm_k3_run(xm_k3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 1) {
                done = xm_k3_c0(st);
            }
            else {
                done = xm_k3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_k3_c0(xm_k3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
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

    java.lang.String m3(java.lang.String str) {
        xm_m3State st = new xm_m3State();
        st.v5o = this;
        st.v6o = str;
        return xm_m3_run(st);
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

    private static java.lang.String xm_m3_run(xm_m3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 36) {
                done = xm_m3_c0(st);
            }
            else {
                done = xm_m3_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_m3_c0(xm_m3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0o = "'";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v6o == null) {
                            st.pc = 35;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((java.lang.String) st.v6o).length();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v2i != 0) {
                            st.pc = 7;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.pc = 35;
                        continue;
                    case 7:
                        st.pc = 7;
                        st.tmpO = java.lang.System.getenv((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.pc = 20;
                        continue;
                    case 10:
                        st.pc = 10;
                        st.v2o = st.ex;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v3o = new java.lang.StringBuilder();
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 13:
                        st.v4o = "Failed getenv '";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.pc = 17;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.tmpI = android.ext.e1.g((java.lang.String) st.v3o, (java.lang.Throwable) st.v2o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 20:
                        st.pc = 20;
                        if ((st.v1o == null && st.v1i == 0)) {
                            st.pc = 22;
                            continue;
                        }
                    case 21:
                        st.pc = 21;
                        st.resultO = st.v1o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 22:
                        st.pc = 22;
                        st.tmpO = java.lang.System.getProperty((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.pc = 35;
                        continue;
                    case 25:
                        st.pc = 25;
                        st.v2o = st.ex;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.v3o = new java.lang.StringBuilder();
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 28:
                        st.v4o = "Failed getProperty '";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.pc = 30;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 31:
                        st.pc = 31;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 32:
                        st.pc = 32;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 33:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 34:
                        st.pc = 34;
                        st.tmpI = android.ext.e1.g((java.lang.String) st.v6o, (java.lang.Throwable) st.v2o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 35:
                        st.pc = 35;
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
        7, 9, 10, -1, 22, 24, 25, -1
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

    private static luaj.LuaValue n3(byte[] bArr, int i, int i2) {
        xm_n3State st = new xm_n3State();
        st.v2o = bArr;
        st.v3i = i;
        st.v4i = i2;
        return xm_n3_run(st);
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
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static luaj.LuaValue xm_n3_run(xm_n3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 18) {
                done = xm_n3_c0(st);
            }
            else {
                done = xm_n3_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_n3_c0(xm_n3State st) {
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
                        st.v1o = "invalid conversion specifier '";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v4i = st.v4i - st.v3i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = luaj.LuaValue.L2((byte[]) st.v2o, st.v3i, st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v2o = "' at offset ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 13:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 14:
                        st.v4o = "os.date";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = luaj.LuaValue.l0(st.v3i, (java.lang.String) st.v4o, (java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.resultO = st.v2o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
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

    private java.util.Calendar o3(java.util.Calendar calendar) {
        xm_o3State st = new xm_o3State();
        st.v5o = this;
        st.v6o = calendar;
        return xm_o3_run(st);
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

    private static java.util.Calendar xm_o3_run(xm_o3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 20) {
                done = xm_o3_c0(st);
            }
            else {
                done = xm_o3_c0(st);
            }
            if (done) {
                return (java.util.Calendar) st.resultO;
            }
        }
    }

    private static boolean xm_o3_c0(xm_o3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 6;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = ((java.util.Calendar) st.v6o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v2i = 7;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = ((java.util.Calendar) st.v6o).get(st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 6:
                        st.v3i = st.v3i + 5;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v3i = st.v3i % st.v2i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 8:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 9:
                        st.v3i = st.v3i + st.v2i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpO = java.util.Calendar.getInstance();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 12:
                        st.pc = 12;
                        ((java.util.Calendar) st.v4o).setLenient((st.v2i != 0));
                    case 13:
                        st.pc = 13;
                        st.tmpI = ((java.util.Calendar) st.v6o).get(st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 14:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((java.util.Calendar) st.v4o).set(st.v2i, st.v6i);
                    case 16:
                        st.v1i = st.v1i - st.v3i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 17:
                        st.v1i = st.v1i + 4;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 18:
                        st.pc = 18;
                        ((java.util.Calendar) st.v4o).set(st.v0i, st.v1i);
                    case 19:
                        st.pc = 19;
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

    private int p3(java.util.Calendar calendar) {
        xm_p3State st = new xm_p3State();
        st.v1o = this;
        st.v2o = calendar;
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
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
    }

    private static int xm_p3_run(xm_p3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 9) {
                done = xm_p3_c0(st);
            }
            else {
                done = xm_p3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_p3_c0(xm_p3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.lib.OsLib) st.v1o).o3((java.util.Calendar) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2:
                        st.v0i = 6;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((java.util.Calendar) st.v2o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.v2i = st.v2i + 0xffffffff;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v2i = st.v2i / 7;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 7:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 8:
                        st.pc = 8;
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

    private int q3(java.util.Calendar calendar) {
        xm_q3State st = new xm_q3State();
        st.v1o = this;
        st.v2o = calendar;
        return xm_q3_run(st);
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
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
    }

    private static int xm_q3_run(xm_q3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 6) {
                done = xm_q3_c0(st);
            }
            else {
                done = xm_q3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_q3_c0(xm_q3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((luaj.lib.OsLib) st.v1o).o3((java.util.Calendar) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 2:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((java.util.Calendar) st.v2o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
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

    java.lang.String t3(java.lang.String str, java.lang.String str2) {
        xm_t3State st = new xm_t3State();
        st.v0o = this;
        st.v1o = str;
        st.v2o = str2;
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
        java.lang.Object v0o;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
    }

    private static java.lang.String xm_t3_run(xm_t3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_t3_c0(st);
            }
            else {
                done = xm_t3_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_t3_c0(xm_t3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v1o = "C";
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

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    long u3(luaj.LuaTable luaTable) {
        xm_u3State st = new xm_u3State();
        st.v7o = this;
        st.v8o = luaTable;
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
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private static long xm_u3_run(xm_u3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 91) {
                done = xm_u3_c0(st);
            }
            else {
                done = xm_u3_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_u3_c0(xm_u3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = java.util.Calendar.getInstance();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 14;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v8o != null) {
                            st.pc = 9;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v8o = ((luaj.lib.OsLib) st.v7o).T;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v8i = ((luaj.Globals) st.v8o).b0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 6:
                        st.v8i = -st.v8i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((java.util.Calendar) st.v0o).add(st.v1i, st.v8i);
                    case 8:
                        st.pc = 8;
                        st.pc = 67;
                        continue;
                    case 9:
                        st.v2o = "year";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((luaj.LuaValue) st.v8o).T0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 12:
                        st.v4i = 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.lib.OsLib) st.v7o).f3((luaj.LuaValue) st.v3o, (st.v4i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpI = ((luaj.LuaValue) st.v3o).A0();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 16:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.pc = 17;
                        ((java.util.Calendar) st.v0o).set(st.v4i, st.v3i);
                    case 18:
                        st.v2o = "month";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((luaj.LuaValue) st.v8o).T0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.tmpO = ((luaj.lib.OsLib) st.v7o).f3((luaj.LuaValue) st.v3o, (st.v4i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.tmpI = ((luaj.LuaValue) st.v3o).A0();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 24:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 25:
                        st.v3i = st.v3i - st.v4i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 26:
                        st.v5i = 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 27:
                        st.pc = 27;
                        ((java.util.Calendar) st.v0o).set(st.v5i, st.v3i);
                    case 28:
                        st.v2o = "day";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.tmpO = ((luaj.LuaValue) st.v8o).T0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.tmpO = ((luaj.lib.OsLib) st.v7o).f3((luaj.LuaValue) st.v3o, (st.v4i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 32:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 33:
                        st.pc = 33;
                        st.tmpI = ((luaj.LuaValue) st.v3o).A0();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 34:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 35:
                        st.v4i = 5;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 36:
                        st.pc = 36;
                        ((java.util.Calendar) st.v0o).set(st.v4i, st.v3i);
                    case 37:
                        st.v2o = "hour";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.tmpO = ((luaj.LuaValue) st.v8o).T0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 39:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 40:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 41:
                        st.pc = 41;
                        st.tmpO = ((luaj.lib.OsLib) st.v7o).f3((luaj.LuaValue) st.v3o, (st.v4i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 42:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 43:
                        st.v5i = 12;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.tmpI = ((luaj.LuaValue) st.v3o).H1(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 45:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 46:
                        st.v6i = 11;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 47:
                        st.pc = 47;
                        ((java.util.Calendar) st.v0o).set(st.v6i, st.v3i);
                    case 48:
                        st.v2o = "min";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 49:
                        st.pc = 49;
                        st.tmpO = ((luaj.LuaValue) st.v8o).T0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 50:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 51:
                        st.pc = 51;
                        st.tmpO = ((luaj.lib.OsLib) st.v7o).f3((luaj.LuaValue) st.v3o, (st.v4i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 52:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 53:
                        st.pc = 53;
                        st.tmpI = ((luaj.LuaValue) st.v3o).H1(st.v4i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 54:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 55:
                        st.pc = 55;
                        ((java.util.Calendar) st.v0o).set(st.v5i, st.v3i);
                    case 56:
                        st.v2o = "sec";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 57:
                        st.pc = 57;
                        st.tmpO = ((luaj.LuaValue) st.v8o).T0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 58:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 59:
                        st.pc = 59;
                        st.tmpO = ((luaj.lib.OsLib) st.v7o).f3((luaj.LuaValue) st.v3o, (st.v4i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 60:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 61:
                        st.pc = 61;
                        st.tmpI = ((luaj.LuaValue) st.v3o).H1(st.v4i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 62:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 63:
                        st.v5i = 13;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 64:
                        st.pc = 64;
                        ((java.util.Calendar) st.v0o).set(st.v5i, st.v3i);
                    case 65:
                        st.pc = 65;
                        ((java.util.Calendar) st.v0o).set(st.v1i, st.v4i);
                    case 66:
                        st.pc = 66;
                        ((luaj.lib.OsLib) st.v7o).l3((luaj.LuaTable) st.v8o, (java.util.Calendar) st.v0o);
                    case 67:
                        st.pc = 67;
                        st.tmpJ = ((java.util.Calendar) st.v0o).getTimeInMillis();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 68:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 69:
                        st.v2j = 1000L;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 70:
                        st.pc = 70;
                        st.v0j = st.v0j / st.v2j;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 71:
                        st.pc = 71;
                        st.resultJ = st.v0j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 72:
                        st.pc = 72;
                        st.v8o = st.ex;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 73:
                        st.pc = 73;
                        st.pc = 76;
                        continue;
                    case 74:
                        st.pc = 74;
                        st.v8o = st.ex;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 75:
                        st.v2o = "";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 76:
                        st.pc = 76;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 77:
                        st.pc = 77;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 78:
                        st.pc = 78;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 79:
                        st.v3o = "field '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 80:
                        st.pc = 80;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 81:
                        st.pc = 81;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 82:
                        st.v2o = "' ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 83:
                        st.pc = 83;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 84:
                        st.pc = 84;
                        st.tmpO = ((luaj.d) st.v8o).getMessage();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 85:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 86:
                        st.pc = 86;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 87:
                        st.pc = 87;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 88:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 89:
                        st.pc = 89;
                        st.v0o = new luaj.d((java.lang.String) st.v1o, (java.lang.Throwable) st.v8o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 90:
                        st.pc = 90;
                        throw (java.lang.Throwable) st.v0o;
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
        luaj.d.class
    };
    private static final int[] xm_u3_handlers = {
        9, 10, 74, 0, 10, 65, 72, 0
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

    java.lang.String v3() {
        xm_v3State st = new xm_v3State();
        st.v5o = this;
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
        java.util.concurrent.locks.ReentrantLock mon;
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
        java.lang.Object v5o;
    }

    private static final java.util.concurrent.ConcurrentHashMap<Object, java.util.concurrent.locks.ReentrantLock> xm_v3_monitors = new java.util.concurrent.ConcurrentHashMap<Object, java.util.concurrent.locks.ReentrantLock>();
    private static java.util.concurrent.locks.ReentrantLock xm_v3_monitor(java.lang.Object o) {
        java.util.concurrent.locks.ReentrantLock l = xm_v3_monitors.get(o);
        if (l == null) {
            l = new java.util.concurrent.locks.ReentrantLock();
            java.util.concurrent.locks.ReentrantLock prev = xm_v3_monitors.putIfAbsent(o, l);
            if (prev != null) {
                l = prev;
            }
        }
        return l;
    }

    private static java.lang.String xm_v3_run(xm_v3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 39) {
                done = xm_v3_c0(st);
            }
            else {
                done = xm_v3_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_v3_c0(xm_v3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0o = ".gg.";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1o = ".tmp";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = java.io.File.createTempFile((java.lang.String) st.v0o, (java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        ((java.io.File) st.v0o).deleteOnExit();
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((java.io.File) st.v0o).delete()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.pc = 6;
                        st.tmpO = ((java.io.File) st.v0o).getAbsolutePath();
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
                        st.v0o = luaj.lib.OsLib.class;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.mon = xm_v3_monitor((java.lang.Object) st.v0o);
                        st.mon.lock();
                    case 11:
                        st.pc = 11;
                        st.v1j = luaj.lib.OsLib.V;
                        st.v1d = java.lang.Double.longBitsToDouble(st.v1j);
                        st.v1i = 0;
                        st.v1o = null;
                    case 12:
                        st.v3j = 1L;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 13:
                        st.v3j = st.v3j + st.v1j;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 14:
                        st.pc = 14;
                        luaj.lib.OsLib.V = st.v3j;
                    case 15:
                        st.pc = 15;
                        if (st.mon != null) {
                            st.mon.unlock();
                            st.mon = null;
                        }
                    case 16:
                        st.pc = 16;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 18:
                        st.v3o = ".gg.";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.pc = 20;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 21:
                        st.v1o = ".tmp";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.tmpO = android.ext.Tools.b0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.v2o = "/";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 32:
                        st.pc = 32;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 33:
                        st.pc = 33;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 34:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 36:
                        st.pc = 36;
                        st.v1o = st.ex;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 37:
                        st.pc = 37;
                        if (st.mon != null) {
                            st.mon.unlock();
                            st.mon = null;
                        }
                    case 38:
                        st.pc = 38;
                        throw (java.lang.Throwable) st.v1o;
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
        java.io.IOException.class
    };
    private static final int[] xm_v3_handlers = {
        0, 4, 9, 0, 4, 6, 6, -1, 6, 8, 9, 0, 11, 16, 36, -1, 37, 38, 36, -1
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

    private int w3(java.util.Calendar calendar, boolean z) {
        xm_w3State st = new xm_w3State();
        st.v2o = this;
        st.v3o = calendar;
        st.v4i = (z ? 1 : 0);
        return xm_w3_run(st);
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

    private static int xm_w3_run(xm_w3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 28) {
                done = xm_w3_c0(st);
            }
            else {
                done = xm_w3_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_w3_c0(xm_w3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 6;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = ((java.util.Calendar) st.v3o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.v1i = 7;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpI = ((java.util.Calendar) st.v3o).get(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 5:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v4i == 0) {
                            st.pc = 10;
                            continue;
                        }
                    case 7:
                        st.v3i = st.v3i + 5;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v3i = st.v3i % st.v1i;
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
                        if (st.v0i > st.v3i) {
                            st.pc = 13;
                            continue;
                        }
                    case 11:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.resultI = st.v3i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 13:
                        st.v3i = st.v0i - st.v3i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.v3i = st.v3i % st.v1i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 15:
                        st.v0i = st.v0i - st.v3i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 16:
                        st.v4d = (float) st.v0i;
                        st.v4j = java.lang.Double.doubleToRawLongBits(st.v4d);
                        st.v4i = 0;
                        st.v4o = null;
                    case 17:
                        st.v0i = 1088421888;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.v4i = st.v4i / st.v0i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 19:
                        st.v0d = st.v4d;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 20:
                        st.pc = 20;
                        st.tmpD = java.lang.Math.ceil(st.v0d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v0d = st.tmpD;
                        st.v0j = java.lang.Double.doubleToRawLongBits(st.v0d);
                        st.v0i = 0;
                        st.v0o = null;
                    case 22:
                        st.v4i = (int) st.v0d;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 23:
                        st.v0i = st.v4i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 24:
                        st.pc = 24;
                        if (st.v3i == 0) {
                            st.pc = 26;
                            continue;
                        }
                    case 25:
                        st.pc = 25;
                        st.pc = 27;
                        continue;
                    case 26:
                        st.v4i = st.v0i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 27:
                        st.pc = 27;
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

    @Override // luaj.lib.TwoArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    public luaj.LuaValue call(luaj.LuaValue luaValue, luaj.LuaValue luaValue2) {
        xm_callState st = new xm_callState();
        st.v11o = this;
        st.v12o = luaValue;
        st.v13o = luaValue2;
        return xm_call_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_call_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_callState {
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
        java.lang.Object v11o;
        int v12i;
        long v12j;
        java.lang.Object v12o;
        double v12d;
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
    }

    private static luaj.LuaValue xm_call_run(xm_callState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 55) {
                done = xm_call_c0(st);
            }
            else {
                done = xm_call_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_call_c0(xm_callState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0o = "clock";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1o = "date";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.v2o = "difftime";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 3:
                        st.v3o = "execute";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 4:
                        st.v4o = "exit";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 5:
                        st.v5o = "getenv";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 6:
                        st.v6o = "remove";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 7:
                        st.v7o = "rename";
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 8:
                        st.v8o = "setlocale";
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 9:
                        st.v9o = "time";
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 10:
                        st.v10o = "tmpname";
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = new java.lang.String[] {(java.lang.String) st.v0o, (java.lang.String) st.v1o, (java.lang.String) st.v2o, (java.lang.String) st.v3o, (java.lang.String) st.v4o, (java.lang.String) st.v5o, (java.lang.String) st.v6o, (java.lang.String) st.v7o, (java.lang.String) st.v8o, (java.lang.String) st.v9o, (java.lang.String) st.v10o};
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((luaj.LuaValue) st.v13o).z0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((luaj.lib.OsLib) st.v11o).T = (luaj.Globals) st.v0o;
                    case 16:
                        st.pc = 16;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v0o = new luaj.LuaTable();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 18:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 19:
                        st.v2i = 11;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 20:
                        st.pc = 20;
                        if (st.v1i >= st.v2i) {
                            st.pc = 40;
                            continue;
                        }
                    case 21:
                        st.pc = 21;
                        st.v2o = ((luaj.lib.OsLib) st.v11o).T;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.v2i = (((luaj.Globals) st.v2o).X ? 1 : 0);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v2i != 0) {
                            st.pc = 34;
                            continue;
                        }
                    case 24:
                        st.v2i = 3;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 25:
                        st.pc = 25;
                        if (st.v1i == st.v2i) {
                            st.pc = 38;
                            continue;
                        }
                    case 26:
                        st.v2i = 4;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 27:
                        st.pc = 27;
                        if (st.v1i == st.v2i) {
                            st.pc = 38;
                            continue;
                        }
                    case 28:
                        st.v2i = 6;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 29:
                        st.pc = 29;
                        if (st.v1i == st.v2i) {
                            st.pc = 38;
                            continue;
                        }
                    case 30:
                        st.v2i = 7;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 31:
                        st.pc = 31;
                        if (st.v1i == st.v2i) {
                            st.pc = 38;
                            continue;
                        }
                    case 32:
                        st.v2i = 10;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 33:
                        st.pc = 33;
                        if (st.v1i == st.v2i) {
                            st.pc = 38;
                            continue;
                        }
                    case 34:
                        st.pc = 34;
                        st.v2o = ((java.lang.Object[]) st.v12o)[st.v1i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.v3o = new luaj.lib.OsLib$OsLibFunc((luaj.lib.OsLib) st.v11o, st.v1i, (java.lang.String) st.v2o);
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 37:
                        st.pc = 37;
                        ((luaj.LuaValue) st.v0o).i2((java.lang.String) st.v2o, (luaj.LuaValue) st.v3o);
                    case 38:
                        st.v1i = st.v1i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.pc = 19;
                        continue;
                    case 40:
                        st.v12o = "os";
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 41:
                        st.pc = 41;
                        ((luaj.LuaValue) st.v13o).i2((java.lang.String) st.v12o, (luaj.LuaValue) st.v0o);
                    case 42:
                        st.v1o = "package";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 43:
                        st.pc = 43;
                        st.tmpO = ((luaj.LuaValue) st.v13o).T0((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 44:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 45:
                        st.pc = 45;
                        st.tmpI = (((luaj.LuaValue) st.v2o).l1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 46:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 47:
                        st.pc = 47;
                        if (st.v2i != 0) {
                            st.pc = 54;
                            continue;
                        }
                    case 48:
                        st.pc = 48;
                        st.tmpO = ((luaj.LuaValue) st.v13o).T0((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 49:
                        st.v13o = st.tmpO;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 50:
                        st.v1o = "loaded";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 51:
                        st.pc = 51;
                        st.tmpO = ((luaj.LuaValue) st.v13o).T0((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 52:
                        st.v13o = st.tmpO;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 53:
                        st.pc = 53;
                        ((luaj.LuaValue) st.v13o).i2((java.lang.String) st.v12o, (luaj.LuaValue) st.v0o);
                    case 54:
                        st.pc = 54;
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
            int h = xm_call_handler(st.pc, t);
            if (h < 0) {
                xm_call_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_call_ctypes = {
    };
    private static final int[] xm_call_handlers = {
        
    };
    private static int xm_call_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_call_handlers.length; i += 4) {
            if (pc < xm_call_handlers[i] || pc >= xm_call_handlers[i + 1]) {
                continue;
            }
            int ti = xm_call_handlers[i + 3];
            if (ti < 0 || xm_call_ctypes[ti].isInstance(t)) {
                return xm_call_handlers[i + 2];
            }
        }
        return -1;
    }

    public java.lang.String h3(java.lang.String str, java.util.Calendar calendar) {
        xm_h3State st = new xm_h3State();
        st.v13o = this;
        st.v14o = str;
        st.v15o = calendar;
        return xm_h3_run(st);
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
        java.lang.Object v13o;
        int v14i;
        long v14j;
        java.lang.Object v14o;
        double v14d;
        int v15i;
        java.lang.Object v15o;
    }

    private static java.lang.String xm_h3_run(xm_h3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 159) {
                done = xm_h3_c0(st);
            }
            else {
                done = xm_h3_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_h3_c0(xm_h3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((java.lang.String) st.v14o).getBytes();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v14o = st.tmpO;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v0i = java.lang.reflect.Array.getLength(st.v14o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v1o = new gg_f.a(st.v0i);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v3i >= st.v0i) {
                            st.pc = 156;
                            continue;
                        }
                    case 8:
                        st.v4i = st.v3i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v5i = ((byte[]) st.v14o)[st.v3i];
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 10:
                        st.v6o = "\n";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 11:
                        st.v7i = 10;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v5i == st.v7i) {
                            st.pc = 153;
                            continue;
                        }
                    case 13:
                        st.v8i = 37;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v5i == st.v8i) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((gg_f.a) st.v1o).a((byte) st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.pc = 16;
                        st.pc = 154;
                        continue;
                    case 17:
                        st.pc = 17;
                        if (st.v4i < st.v0i) {
                            st.pc = 19;
                            continue;
                        }
                    case 18:
                        st.pc = 18;
                        st.tmpO = luaj.lib.OsLib.n3((byte[]) st.v14o, st.v3i, st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v5i = st.v3i + 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.v4i = ((byte[]) st.v14o)[st.v4i];
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 21:
                        st.v9i = 69;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 22:
                        st.pc = 22;
                        if (st.v4i == st.v9i) {
                            st.pc = 25;
                            continue;
                        }
                    case 23:
                        st.v10i = 79;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 24:
                        st.pc = 24;
                        if (st.v4i != st.v10i) {
                            st.pc = 42;
                            continue;
                        }
                    case 25:
                        st.pc = 25;
                        if (st.v5i < st.v0i) {
                            st.pc = 27;
                            continue;
                        }
                    case 26:
                        st.pc = 26;
                        st.tmpO = luaj.lib.OsLib.n3((byte[]) st.v14o, st.v3i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.pc = 27;
                        if (st.v4i != st.v9i) {
                            st.pc = 30;
                            continue;
                        }
                    case 28:
                        st.v4o = "cCxXyY";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.pc = 31;
                        continue;
                    case 30:
                        st.v4o = "deHImMSuUVwwy";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 31:
                        st.v9i = st.v3i + 3;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.v5i = ((byte[]) st.v14o)[st.v5i];
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 33:
                        st.v10i = st.v5i & 255;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 34:
                        st.v10i = (char) st.v10i;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.tmpI = ((java.lang.String) st.v4o).indexOf(st.v10i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 36:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 37:
                        st.v10i = 0xffffffff;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 38:
                        st.pc = 38;
                        if (st.v4i != st.v10i) {
                            st.pc = 40;
                            continue;
                        }
                    case 39:
                        st.pc = 39;
                        st.tmpO = luaj.lib.OsLib.n3((byte[]) st.v14o, st.v3i, st.v9i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 40:
                        st.v4i = st.v5i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 41:
                        st.v5i = st.v9i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 42:
                        st.v9o = "%";
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 43:
                        st.v10i = 84;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 44:
                        st.v11i = 112;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 45:
                        st.v12i = 1;
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 46:
                        st.pc = 46;
                        if (st.v4i == st.v8i) {
                            st.pc = 130;
                            continue;
                        }
                    case 47:
                        st.v8i = 77;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 48:
                        st.pc = 48;
                        if (st.v4i == st.v8i) {
                            st.pc = 132;
                            continue;
                        }
                    case 49:
                        st.pc = 49;
                        if (st.v4i == st.v11i) {
                            st.pc = 132;
                            continue;
                        }
                    case 50:
                        st.v8i = 103;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 51:
                        st.pc = 51;
                        if (st.v4i == st.v8i) {
                            st.pc = 121;
                            continue;
                        }
                    case 52:
                        st.v8i = 104;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 53:
                        st.pc = 53;
                        if (st.v4i == st.v8i) {
                            st.pc = 119;
                            continue;
                        }
                    case 54:
                        switch (st.v4i) {
                            case 65: st.pc = 132; continue;
                            case 66: st.pc = 132; continue;
                            case 67: st.pc = 115; continue;
                            case 68: st.pc = 132; continue;
                            default: st.pc = 55; continue;
                        }
                    case 55:
                        switch (st.v4i) {
                            case 70: st.pc = 132; continue;
                            case 71: st.pc = 111; continue;
                            case 72: st.pc = 132; continue;
                            case 73: st.pc = 132; continue;
                            default: st.pc = 56; continue;
                        }
                    case 56:
                        switch (st.v4i) {
                            case 82: st.pc = 132; continue;
                            case 83: st.pc = 132; continue;
                            case 84: st.pc = 132; continue;
                            case 85: st.pc = 108; continue;
                            case 86: st.pc = 105; continue;
                            case 87: st.pc = 97; continue;
                            case 88: st.pc = 95; continue;
                            case 89: st.pc = 132; continue;
                            case 90: st.pc = 132; continue;
                            default: st.pc = 57; continue;
                        }
                    case 57:
                        st.v8i = 5;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 58:
                        switch (st.v4i) {
                            case 97: st.pc = 132; continue;
                            case 98: st.pc = 132; continue;
                            case 99: st.pc = 91; continue;
                            case 100: st.pc = 132; continue;
                            case 101: st.pc = 85; continue;
                            default: st.pc = 59; continue;
                        }
                    case 59:
                        switch (st.v4i) {
                            case 106: st.pc = 132; continue;
                            case 107: st.pc = 132; continue;
                            case 108: st.pc = 132; continue;
                            case 109: st.pc = 132; continue;
                            case 110: st.pc = 83; continue;
                            default: st.pc = 60; continue;
                        }
                    case 60:
                        st.v6i = 7;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 61:
                        switch (st.v4i) {
                            case 114: st.pc = 132; continue;
                            case 115: st.pc = 132; continue;
                            case 116: st.pc = 81; continue;
                            case 117: st.pc = 75; continue;
                            default: st.pc = 62; continue;
                        }
                    case 62:
                        switch (st.v4i) {
                            case 119: st.pc = 67; continue;
                            case 120: st.pc = 65; continue;
                            case 121: st.pc = 132; continue;
                            case 122: st.pc = 132; continue;
                            default: st.pc = 63; continue;
                        }
                    case 63:
                        st.pc = 63;
                        st.tmpO = luaj.lib.OsLib.n3((byte[]) st.v14o, st.v3i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 64:
                        st.pc = 64;
                        st.pc = 130;
                        continue;
                    case 65:
                        st.v4i = 68;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 66:
                        st.pc = 66;
                        st.pc = 132;
                        continue;
                    case 67:
                        st.pc = 67;
                        st.tmpI = ((java.util.Calendar) st.v15o).get(st.v6i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 68:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 69:
                        st.v3i = st.v3i + 6;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 70:
                        st.pc = 70;
                        st.v3i = st.v3i % st.v6i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 71:
                        st.pc = 71;
                        st.tmpO = java.lang.String.valueOf(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 72:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 73:
                        st.pc = 73;
                        st.tmpO = ((gg_f.a) st.v1o).b((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 74:
                        st.pc = 74;
                        st.pc = 131;
                        continue;
                    case 75:
                        st.pc = 75;
                        st.tmpI = ((java.util.Calendar) st.v15o).get(st.v6i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 76:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 77:
                        st.v3i = st.v3i + st.v8i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 78:
                        st.pc = 78;
                        st.v3i = st.v3i % st.v6i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 79:
                        st.v3i = st.v3i + st.v12i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 80:
                        st.pc = 80;
                        st.pc = 71;
                        continue;
                    case 81:
                        st.v3o = "\t";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 82:
                        st.pc = 82;
                        st.pc = 73;
                        continue;
                    case 83:
                        st.pc = 83;
                        st.tmpO = ((gg_f.a) st.v1o).b((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 84:
                        st.pc = 84;
                        st.pc = 131;
                        continue;
                    case 85:
                        st.pc = 85;
                        st.tmpI = ((java.util.Calendar) st.v15o).get(st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 86:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 87:
                        st.pc = 87;
                        if (st.v3i >= st.v7i) {
                            st.pc = 71;
                            continue;
                        }
                    case 88:
                        st.v4o = " ";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 89:
                        st.pc = 89;
                        st.tmpO = ((gg_f.a) st.v1o).b((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 90:
                        st.pc = 90;
                        st.pc = 71;
                        continue;
                    case 91:
                        st.v3o = "%a %b %d %H:%M:%S %Y";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 92:
                        st.pc = 92;
                        st.tmpO = ((luaj.lib.OsLib) st.v13o).h3((java.lang.String) st.v3o, (java.util.Calendar) st.v15o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 93:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 94:
                        st.pc = 94;
                        st.pc = 73;
                        continue;
                    case 95:
                        st.v4i = 84;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 96:
                        st.pc = 96;
                        st.pc = 132;
                        continue;
                    case 97:
                        st.pc = 97;
                        st.tmpI = ((luaj.lib.OsLib) st.v13o).w3((java.util.Calendar) st.v15o, (st.v12i != 0));
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 98:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 99:
                        st.v3i = st.v3i + 100;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 100:
                        st.pc = 100;
                        st.tmpO = java.lang.String.valueOf(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 101:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 102:
                        st.pc = 102;
                        st.tmpO = ((java.lang.String) st.v3o).substring(st.v12i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 103:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 104:
                        st.pc = 104;
                        st.pc = 73;
                        continue;
                    case 105:
                        st.pc = 105;
                        st.tmpI = ((luaj.lib.OsLib) st.v13o).p3((java.util.Calendar) st.v15o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 106:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 107:
                        st.pc = 107;
                        st.pc = 99;
                        continue;
                    case 108:
                        st.pc = 108;
                        st.tmpI = ((luaj.lib.OsLib) st.v13o).w3((java.util.Calendar) st.v15o, (st.v2i != 0));
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 109:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 110:
                        st.pc = 110;
                        st.pc = 99;
                        continue;
                    case 111:
                        st.pc = 111;
                        st.tmpI = ((luaj.lib.OsLib) st.v13o).q3((java.util.Calendar) st.v15o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 112:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 113:
                        st.pc = 113;
                        st.v3i = st.v3i + 10000;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 114:
                        st.pc = 114;
                        st.pc = 100;
                        continue;
                    case 115:
                        st.pc = 115;
                        st.tmpI = ((java.util.Calendar) st.v15o).get(st.v12i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 116:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 117:
                        st.pc = 117;
                        st.v3i = st.v3i / 100;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 118:
                        st.pc = 118;
                        st.pc = 99;
                        continue;
                    case 119:
                        st.v4i = 98;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 120:
                        st.pc = 120;
                        st.pc = 132;
                        continue;
                    case 121:
                        st.pc = 121;
                        st.tmpI = ((luaj.lib.OsLib) st.v13o).q3((java.util.Calendar) st.v15o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 122:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 123:
                        st.pc = 123;
                        st.v3i = st.v3i + 10000;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 124:
                        st.pc = 124;
                        st.tmpO = java.lang.String.valueOf(st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 125:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 126:
                        st.v4i = 3;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 127:
                        st.pc = 127;
                        st.tmpO = ((java.lang.String) st.v3o).substring(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 128:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 129:
                        st.pc = 129;
                        st.pc = 73;
                        continue;
                    case 130:
                        st.pc = 130;
                        st.tmpO = ((gg_f.a) st.v1o).b((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 131:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 132:
                        st.pc = 132;
                        if (st.v4i == 0) {
                            st.pc = 151;
                            continue;
                        }
                    case 133:
                        st.pc = 133;
                        st.v3o = java.util.Locale.US;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 134:
                        st.pc = 134;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 135:
                        st.pc = 135;
                        st.v6o = new java.lang.StringBuilder();
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 136:
                        st.pc = 136;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 137:
                        st.pc = 137;
                        if (st.v4i != st.v11i) {
                            st.pc = 139;
                            continue;
                        }
                    case 138:
                        st.pc = 138;
                        st.pc = 140;
                        continue;
                    case 139:
                        st.v10i = 116;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 140:
                        st.pc = 140;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((char) st.v10i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 141:
                        st.v4i = st.v4i & 255;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 142:
                        st.v4i = (char) st.v4i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 143:
                        st.pc = 143;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).append((char) st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 144:
                        st.pc = 144;
                        st.tmpO = ((java.lang.StringBuilder) st.v6o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 145:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 146:
                        st.pc = 146;
                        st.v6o = new java.lang.Object[st.v12i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 147:
                        st.pc = 147;
                        ((java.lang.Object[]) st.v6o)[st.v2i] = st.v15o;
                    case 148:
                        st.pc = 148;
                        st.tmpO = java.lang.String.format((java.util.Locale) st.v3o, (java.lang.String) st.v4o, (java.lang.Object[]) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 149:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 150:
                        st.pc = 150;
                        st.tmpO = ((gg_f.a) st.v1o).b((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 151:
                        st.v3i = st.v5i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 152:
                        st.pc = 152;
                        st.pc = 7;
                        continue;
                    case 153:
                        st.pc = 153;
                        st.tmpO = ((gg_f.a) st.v1o).b((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 154:
                        st.v3i = st.v4i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 155:
                        st.pc = 155;
                        st.pc = 7;
                        continue;
                    case 156:
                        st.pc = 156;
                        st.tmpO = ((gg_f.a) st.v1o).k();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 157:
                        st.v14o = st.tmpO;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 158:
                        st.pc = 158;
                        st.resultO = st.v14o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
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

    void l3(luaj.LuaTable luaTable, java.util.Calendar calendar) {
        xm_l3State st = new xm_l3State();
        st.v3o = this;
        st.v4o = luaTable;
        st.v5o = calendar;
        xm_l3_run(st);
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
        long v1j;
        java.lang.Object v1o;
        double v1d;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static void xm_l3_run(xm_l3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 76) {
                done = xm_l3_c0(st);
            }
            else {
                done = xm_l3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_l3_c0(xm_l3State st) {
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
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v1j = st.v1i;
                        st.v1d = java.lang.Double.longBitsToDouble(st.v1j);
                        st.v1i = 0;
                        st.v1o = null;
                    case 4:
                        st.pc = 4;
                        st.tmpO = luaj.LuaValue.I2(st.v1j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 6:
                        st.v2o = "year";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v2o, (luaj.LuaValue) st.v1o);
                    case 8:
                        st.v1i = 2;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 11:
                        st.v1i = st.v1i + st.v0i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 12:
                        st.v0j = st.v1i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 13:
                        st.pc = 13;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 15:
                        st.v1o = "month";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 16:
                        st.pc = 16;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v1o, (luaj.LuaValue) st.v0o);
                    case 17:
                        st.v0i = 5;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 20:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 21:
                        st.pc = 21;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 23:
                        st.v1o = "day";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 24:
                        st.pc = 24;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v1o, (luaj.LuaValue) st.v0o);
                    case 25:
                        st.v0i = 11;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 27:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 28:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 29:
                        st.pc = 29;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 31:
                        st.v1o = "hour";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 32:
                        st.pc = 32;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v1o, (luaj.LuaValue) st.v0o);
                    case 33:
                        st.v0i = 12;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 34:
                        st.pc = 34;
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 35:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 36:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 37:
                        st.pc = 37;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 38:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 39:
                        st.v1o = "min";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 40:
                        st.pc = 40;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v1o, (luaj.LuaValue) st.v0o);
                    case 41:
                        st.v0i = 13;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 43:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 44:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 45:
                        st.pc = 45;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 46:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 47:
                        st.v1o = "sec";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 48:
                        st.pc = 48;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v1o, (luaj.LuaValue) st.v0o);
                    case 49:
                        st.v0i = 7;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 50:
                        st.pc = 50;
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 51:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 52:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 53:
                        st.pc = 53;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 54:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 55:
                        st.v1o = "wday";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 56:
                        st.pc = 56;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v1o, (luaj.LuaValue) st.v0o);
                    case 57:
                        st.v0i = 6;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 58:
                        st.pc = 58;
                        st.tmpI = ((java.util.Calendar) st.v5o).get(st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 59:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 60:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 61:
                        st.pc = 61;
                        st.tmpO = luaj.LuaValue.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 62:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 63:
                        st.v1o = "yday";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 64:
                        st.pc = 64;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v1o, (luaj.LuaValue) st.v0o);
                    case 65:
                        st.pc = 65;
                        st.tmpO = ((java.util.Calendar) st.v5o).getTimeZone();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 66:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 67:
                        st.pc = 67;
                        st.tmpO = ((java.util.Calendar) st.v5o).getTime();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 68:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 69:
                        st.pc = 69;
                        st.tmpI = (((java.util.TimeZone) st.v0o).inDaylightTime((java.util.Date) st.v5o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 70:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 71:
                        st.pc = 71;
                        st.tmpO = luaj.LuaValue.H2((st.v5i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 72:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 73:
                        st.v0o = "isdst";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 74:
                        st.pc = 74;
                        ((luaj.LuaValue) st.v4o).i2((java.lang.String) st.v0o, (luaj.LuaValue) st.v5o);
                    case 75:
                        st.pc = 75;
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

    protected void r3(java.lang.String str) throws java.io.IOException {
        xm_r3State st = new xm_r3State();
        st.v4o = this;
        st.v5o = str;
        xm_r3_run(st);
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
        java.lang.Object v4o;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static void xm_r3_run(xm_r3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 33) {
                done = xm_r3_c0(st);
            }
            else {
                done = xm_r3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_r3_c0(xm_r3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.lib.OsLib) st.v4o).T;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpO = ((luaj.Globals) st.v0o).R3((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = (((java.io.File) st.v0o).exists()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.v2o = "'";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v1i == 0) {
                            st.pc = 22;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.tmpI = (((java.io.File) st.v0o).delete()) ? 1 : 0;
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
                            st.pc = 11;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        return true;
                    case 11:
                        st.pc = 11;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 14:
                        st.v3o = "Failed to delete: '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.pc = 17;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.v0o = new java.io.IOException((java.lang.String) st.v5o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 21:
                        st.pc = 21;
                        throw (java.lang.Throwable) st.v0o;
                    case 22:
                        st.pc = 22;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 25:
                        st.v3o = "No such file or directory: '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.pc = 27;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.pc = 28;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 29:
                        st.pc = 29;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.v0o = new java.io.IOException((java.lang.String) st.v5o);
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

    /* ------------------------------------------------------------- *
     *  .method protected s3(Ljava/lang/String;Ljava/lang/String;)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    protected void s3(java.lang.String str, java.lang.String str2) throws java.io.IOException {
        xm_s3State st = new xm_s3State();
        st.v4o = this;
        st.v5o = str;
        st.v6o = str2;
        xm_s3_run(st);
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
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
    }

    private static void xm_s3_run(xm_s3State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 39) {
                done = xm_s3_c0(st);
            }
            else {
                done = xm_s3_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_s3_c0(xm_s3State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.lib.OsLib) st.v4o).T;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpO = ((luaj.Globals) st.v0o).R3((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = (((java.io.File) st.v0o).exists()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.v2o = "'";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v1i == 0) {
                            st.pc = 28;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.v1o = ((luaj.lib.OsLib) st.v4o).T;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpO = ((luaj.Globals) st.v1o).R3((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpI = (((java.io.File) st.v0o).renameTo((java.io.File) st.v1o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 11:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v0i == 0) {
                            st.pc = 14;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        return true;
                    case 14:
                        st.pc = 14;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 17:
                        st.v3o = "Failed to rename '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.v5o = "' to '";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.pc = 24;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 25:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v0o = new java.io.IOException((java.lang.String) st.v5o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 27:
                        st.pc = 27;
                        throw (java.lang.Throwable) st.v0o;
                    case 28:
                        st.pc = 28;
                        st.v6o = null;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 31:
                        st.v1o = "No such file or directory: '";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 33:
                        st.pc = 33;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 34:
                        st.pc = 34;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 35:
                        st.pc = 35;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 36:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.v6o = new java.io.IOException((java.lang.String) st.v5o);
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 38:
                        st.pc = 38;
                        throw (java.lang.Throwable) st.v6o;
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
}

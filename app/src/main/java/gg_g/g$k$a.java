package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$k$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    short f1626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    short f1627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    short f1628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    luaj.LuaValue f1629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1630e;

    g$k$a() {
    }

    public luaj.LuaValue a() {
        xm_aState st = new xm_aState();
        st.v2o = this;
        return xm_a_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_a_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_aState {
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

    private static luaj.LuaValue xm_a_run(xm_aState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 7) {
                done = xm_a_c0(st);
            }
            else {
                done = xm_a_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_a_c0(xm_aState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.g$k$a) st.v2o).f1629d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0o != null) {
                            st.pc = 6;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v0i = ((gg_g.g$k$a) st.v2o).f1630e;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.v0j = st.v0i;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 4:
                        st.pc = 4;
                        st.tmpO = luaj.LuaLong.I2(st.v0j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
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
            int h = xm_a_handler(st.pc, t);
            if (h < 0) {
                xm_a_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_a_ctypes = {
    };
    private static final int[] xm_a_handlers = {
        
    };
    private static int xm_a_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_a_handlers.length; i += 4) {
            if (pc < xm_a_handlers[i] || pc >= xm_a_handlers[i + 1]) {
                continue;
            }
            int ti = xm_a_handlers[i + 3];
            if (ti < 0 || xm_a_ctypes[ti].isInstance(t)) {
                return xm_a_handlers[i + 2];
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------- *
     *  .method public b(Lluaj/LuaValue;)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public void b(luaj.LuaValue luaValue) {
        xm_bState st = new xm_bState();
        st.v0o = this;
        st.v1o = luaValue;
        xm_b_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_b_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_bState {
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

    private static void xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_b_c0(st);
            }
            else {
                done = xm_b_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_b_c0(xm_bState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        ((gg_g.g$k$a) st.v0o).f1629d = (luaj.LuaValue) st.v1o;
                    case 1:
                        st.pc = 1;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_b_handler(st.pc, t);
            if (h < 0) {
                xm_b_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_b_ctypes = {
    };
    private static final int[] xm_b_handlers = {
        
    };
    private static int xm_b_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_b_handlers.length; i += 4) {
            if (pc < xm_b_handlers[i] || pc >= xm_b_handlers[i + 1]) {
                continue;
            }
            int ti = xm_b_handlers[i + 3];
            if (ti < 0 || xm_b_ctypes[ti].isInstance(t)) {
                return xm_b_handlers[i + 2];
            }
        }
        return -1;
    }
}

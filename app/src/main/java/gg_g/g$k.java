package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g$k$a f1623b = new g$k$a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final e f1624c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final e f1625d = new e();

    g$k() {
    }

    boolean a() {
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
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
        java.lang.Object v2o;
    }

    private static boolean xm_a_run(xm_aState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 9) {
                done = xm_a_c0(st);
            }
            else {
                done = xm_a_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_a_c0(xm_aState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.g$k) st.v2o).f1624c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0i = ((gg_g.e) st.v0o).f1589a;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1o = ((gg_g.g$k) st.v2o).f1625d;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v1i = ((gg_g.e) st.v1o).f1589a;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0i == st.v1i) {
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

    void b(int i, int i2) {
        xm_bState st = new xm_bState();
        st.v2o = this;
        st.v3i = i;
        st.v4i = i2;
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
    }

    private static void xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 9) {
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
                        st.v0o = ((gg_g.g$k) st.v2o).f1625d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        ((gg_g.e) st.v0o).f1589a = st.v1i;
                    case 3:
                        st.pc = 3;
                        st.v0o = ((gg_g.g$k) st.v2o).f1624c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        ((gg_g.e) st.v0o).f1589a = st.v1i;
                    case 5:
                        st.pc = 5;
                        ((gg_g.g$k) st.v2o).f1622a = st.v3i;
                    case 6:
                        st.pc = 6;
                        st.v3o = ((gg_g.g$k) st.v2o).f1623b;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((gg_g.g$k$a) st.v3o).f1630e = st.v4i;
                    case 8:
                        st.pc = 8;
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

    boolean c() {
        xm_cState st = new xm_cState();
        st.v2o = this;
        return xm_c_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_c_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_cState {
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

    private static boolean xm_c_run(xm_cState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 14) {
                done = xm_c_c0(st);
            }
            else {
                done = xm_c_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_c_c0(xm_cState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((gg_g.g$k) st.v2o).f1622a;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 5;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i != st.v1i) {
                            st.pc = 12;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v0o = ((gg_g.g$k) st.v2o).f1624c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v0i = ((gg_g.e) st.v0o).f1589a;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.v1i = 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v0i != st.v1i) {
                            st.pc = 12;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.v0o = ((gg_g.g$k) st.v2o).f1625d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v0i = ((gg_g.e) st.v0o).f1589a;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v0i != st.v1i) {
                            st.pc = 12;
                            continue;
                        }
                    case 10:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.pc = 13;
                        continue;
                    case 12:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
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
            int h = xm_c_handler(st.pc, t);
            if (h < 0) {
                xm_c_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_c_ctypes = {
    };
    private static final int[] xm_c_handlers = {
        
    };
    private static int xm_c_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_c_handlers.length; i += 4) {
            if (pc < xm_c_handlers[i] || pc >= xm_c_handlers[i + 1]) {
                continue;
            }
            int ti = xm_c_handlers[i + 3];
            if (ti < 0 || xm_c_ctypes[ti].isInstance(t)) {
                return xm_c_handlers[i + 2];
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------- *
     *  .method public d(Lgg_g/g$k;)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public void d(g$k g_k) {
        xm_dState st = new xm_dState();
        st.v2o = this;
        st.v3o = g_k;
        xm_d_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_d_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_dState {
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

    private static void xm_d_run(xm_dState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 23) {
                done = xm_d_c0(st);
            }
            else {
                done = xm_d_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_d_c0(xm_dState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.g$k) st.v2o).f1625d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = ((gg_g.g$k) st.v3o).f1625d;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1i = ((gg_g.e) st.v1o).f1589a;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        ((gg_g.e) st.v0o).f1589a = st.v1i;
                    case 4:
                        st.pc = 4;
                        st.v0i = ((gg_g.g$k) st.v3o).f1622a;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        ((gg_g.g$k) st.v2o).f1622a = st.v0i;
                    case 6:
                        st.pc = 6;
                        st.v0o = ((gg_g.g$k) st.v2o).f1624c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v1o = ((gg_g.g$k) st.v3o).f1624c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v1i = ((gg_g.e) st.v1o).f1589a;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        ((gg_g.e) st.v0o).f1589a = st.v1i;
                    case 10:
                        st.pc = 10;
                        st.v0o = ((gg_g.g$k) st.v2o).f1623b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v3o = ((gg_g.g$k) st.v3o).f1623b;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v1o = ((gg_g.g$k$a) st.v3o).f1629d;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        ((gg_g.g$k$a) st.v0o).f1629d = (luaj.LuaValue) st.v1o;
                    case 14:
                        st.pc = 14;
                        st.v1i = ((gg_g.g$k$a) st.v3o).f1626a;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((gg_g.g$k$a) st.v0o).f1626a = (short) st.v1i;
                    case 16:
                        st.pc = 16;
                        st.v1i = ((gg_g.g$k$a) st.v3o).f1627b;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 17:
                        st.pc = 17;
                        ((gg_g.g$k$a) st.v0o).f1627b = (short) st.v1i;
                    case 18:
                        st.pc = 18;
                        st.v1i = ((gg_g.g$k$a) st.v3o).f1628c;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 19:
                        st.pc = 19;
                        ((gg_g.g$k$a) st.v0o).f1628c = (short) st.v1i;
                    case 20:
                        st.pc = 20;
                        st.v3i = ((gg_g.g$k$a) st.v3o).f1630e;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 21:
                        st.pc = 21;
                        ((gg_g.g$k$a) st.v0o).f1630e = st.v3i;
                    case 22:
                        st.pc = 22;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_d_handler(st.pc, t);
            if (h < 0) {
                xm_d_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_d_ctypes = {
    };
    private static final int[] xm_d_handlers = {
        
    };
    private static int xm_d_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_d_handlers.length; i += 4) {
            if (pc < xm_d_handlers[i] || pc >= xm_d_handlers[i + 1]) {
                continue;
            }
            int ti = xm_d_handlers[i + 3];
            if (ti < 0 || xm_d_ctypes[ti].isInstance(t)) {
                return xm_d_handlers[i + 2];
            }
        }
        return -1;
    }
}

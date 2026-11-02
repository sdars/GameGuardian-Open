package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class f extends c {
    final lasm.b q;

    public f(lasm.b bVar) {
        this.q = bVar;
        this.f1578e = new g(null, null);
    }

    @Override // g.c
    int S(int i, int i2) {
        xm_SState st = new xm_SState();
        st.v0o = this;
        st.v1i = i;
        st.v2i = i2;
        return xm_S_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_S_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_SState {
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
    }

    private static int xm_S_run(xm_SState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_S_c0(st);
            }
            else {
                done = xm_S_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_S_c0(xm_SState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v2o = ((gg_g.f) st.v0o).q;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = ((lasm.b) st.v2o).g(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
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
            int h = xm_S_handler(st.pc, t);
            if (h < 0) {
                xm_S_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_S_ctypes = {
    };
    private static final int[] xm_S_handlers = {
        
    };
    private static int xm_S_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_S_handlers.length; i += 4) {
            if (pc < xm_S_handlers[i] || pc >= xm_S_handlers[i + 1]) {
                continue;
            }
            int ti = xm_S_handlers[i + 3];
            if (ti < 0 || xm_S_ctypes[ti].isInstance(t)) {
                return xm_S_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // g.c
    public int T(int i, int i2, int i3, int i4) {
        xm_TState st = new xm_TState();
        st.v0o = this;
        st.v1i = i;
        st.v2i = i2;
        st.v3i = i3;
        st.v4i = i4;
        return xm_T_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_T_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_TState {
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
        int v3i;
        int v4i;
    }

    private int xm_T_run(xm_TState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_T_c0(st);
            }
            else {
                done = xm_T_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private boolean xm_T_c0(xm_TState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = super.T(st.v1i, st.v2i, st.v3i, st.v4i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v1i = st.tmpI;
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
            int h = xm_T_handler(st.pc, t);
            if (h < 0) {
                xm_T_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_T_ctypes = {
    };
    private static final int[] xm_T_handlers = {
        
    };
    private static int xm_T_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_T_handlers.length; i += 4) {
            if (pc < xm_T_handlers[i] || pc >= xm_T_handlers[i + 1]) {
                continue;
            }
            int ti = xm_T_handlers[i + 3];
            if (ti < 0 || xm_T_ctypes[ti].isInstance(t)) {
                return xm_T_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // g.c
    public int U(int i, int i2, int i3) {
        xm_UState st = new xm_UState();
        st.v0o = this;
        st.v1i = i;
        st.v2i = i2;
        st.v3i = i3;
        return xm_U_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_U_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_UState {
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
        int v3i;
    }

    private int xm_U_run(xm_UState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_U_c0(st);
            }
            else {
                done = xm_U_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private boolean xm_U_c0(xm_UState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = super.U(st.v1i, st.v2i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v1i = st.tmpI;
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
            int h = xm_U_handler(st.pc, t);
            if (h < 0) {
                xm_U_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_U_ctypes = {
    };
    private static final int[] xm_U_handlers = {
        
    };
    private static int xm_U_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_U_handlers.length; i += 4) {
            if (pc < xm_U_handlers[i] || pc >= xm_U_handlers[i + 1]) {
                continue;
            }
            int ti = xm_U_handlers[i + 3];
            if (ti < 0 || xm_U_ctypes[ti].isInstance(t)) {
                return xm_U_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // g.c
    public int V(int i, int i2, int i3) {
        xm_VState st = new xm_VState();
        st.v0o = this;
        st.v1i = i;
        st.v2i = i2;
        st.v3i = i3;
        return xm_V_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_V_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_VState {
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
        int v3i;
    }

    private int xm_V_run(xm_VState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_V_c0(st);
            }
            else {
                done = xm_V_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private boolean xm_V_c0(xm_VState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = super.V(st.v1i, st.v2i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v1i = st.tmpI;
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
            int h = xm_V_handler(st.pc, t);
            if (h < 0) {
                xm_V_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_V_ctypes = {
    };
    private static final int[] xm_V_handlers = {
        
    };
    private static int xm_V_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_V_handlers.length; i += 4) {
            if (pc < xm_V_handlers[i] || pc >= xm_V_handlers[i + 1]) {
                continue;
            }
            int ti = xm_V_handlers[i + 3];
            if (ti < 0 || xm_V_ctypes[ti].isInstance(t)) {
                return xm_V_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // g.c
    public int W(int i, int i2) {
        xm_WState st = new xm_WState();
        st.v0o = this;
        st.v1i = i;
        st.v2i = i2;
        return xm_W_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_W_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_WState {
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

    private int xm_W_run(xm_WState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_W_c0(st);
            }
            else {
                done = xm_W_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private boolean xm_W_c0(xm_WState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = super.W(st.v1i, st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v1i = st.tmpI;
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
            int h = xm_W_handler(st.pc, t);
            if (h < 0) {
                xm_W_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_W_ctypes = {
    };
    private static final int[] xm_W_handlers = {
        
    };
    private static int xm_W_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_W_handlers.length; i += 4) {
            if (pc < xm_W_handlers[i] || pc >= xm_W_handlers[i + 1]) {
                continue;
            }
            int ti = xm_W_handlers[i + 3];
            if (ti < 0 || xm_W_ctypes[ti].isInstance(t)) {
                return xm_W_handlers[i + 2];
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------- *
     *  .method public o1(III)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public void o1(int i, int i2, int i3) {
        xm_o1State st = new xm_o1State();
        st.v2o = this;
        st.v3i = i;
        st.v4i = i2;
        st.v5i = i3;
        xm_o1_run(st);
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
        int v5i;
    }

    private static void xm_o1_run(xm_o1State st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 11) {
                done = xm_o1_c0(st);
            }
            else {
                done = xm_o1_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_o1_c0(xm_o1State st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 511;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 36;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v5i > st.v0i) {
                            st.pc = 5;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((gg_g.f) st.v2o).T(st.v1i, st.v3i, st.v4i, st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.pc = 4;
                        st.pc = 10;
                        continue;
                    case 5:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.tmpI = ((gg_g.f) st.v2o).T(st.v1i, st.v3i, st.v4i, st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.pc = 7;
                        st.v3o = ((gg_g.c) st.v2o).f1578e;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v3i = ((gg_g.g) st.v3o).f1592d;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpI = ((gg_g.f) st.v2o).S(st.v5i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.pc = 10;
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
}

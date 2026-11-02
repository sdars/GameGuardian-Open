package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int[] f1587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f1588b;

    public d(int[] iArr, int i) {
        this.f1587a = iArr;
        this.f1588b = i;
    }

    int a() {
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

    private static int xm_a_run(xm_aState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_a_c0(st);
            }
            else {
                done = xm_a_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_a_c0(xm_aState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.d) st.v2o).f1587a;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1i = ((gg_g.d) st.v2o).f1588b;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v0i = ((int[]) st.v0o)[st.v1i];
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
     *  .method b(I)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    void b(int i) {
        xm_bState st = new xm_bState();
        st.v2o = this;
        st.v3i = i;
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
    }

    private static void xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
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
                        st.v0o = ((gg_g.d) st.v2o).f1587a;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1i = ((gg_g.d) st.v2o).f1588b;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        ((int[]) st.v0o)[st.v1i] = st.v3i;
                    case 3:
                        st.pc = 3;
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

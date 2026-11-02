package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1619a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final g$h f1620b;

    private g$i() {
        this.f1620b = new g$h(null);
    }

    /* synthetic */ g$i(g$a g_a) {
        this();
    }

    /* ------------------------------------------------------------- *
     *  .method public a(Lgg_g/g$i;)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public void a(g$i g_i) {
        xm_aState st = new xm_aState();
        st.v2o = this;
        st.v3o = g_i;
        xm_a_run(st);
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
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static void xm_a_run(xm_aState st) {
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
                return;
            }
        }
    }

    private static boolean xm_a_c0(xm_aState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((gg_g.g$i) st.v3o).f1619a;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        ((gg_g.g$i) st.v2o).f1619a = st.v0i;
                    case 2:
                        st.pc = 2;
                        st.v0o = ((gg_g.g$i) st.v2o).f1620b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v3o = ((gg_g.g$i) st.v3o).f1620b;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v1o = ((gg_g.g$h) st.v3o).f1617a;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        ((gg_g.g$h) st.v0o).f1617a = (luaj.LuaValue) st.v1o;
                    case 6:
                        st.pc = 6;
                        st.v3o = ((gg_g.g$h) st.v3o).f1618b;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((gg_g.g$h) st.v0o).f1618b = (luaj.LuaString) st.v3o;
                    case 8:
                        st.pc = 8;
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
}

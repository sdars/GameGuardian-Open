package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class h extends a implements luaj.Globals$a, luaj.Globals$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f1631b = new h();

    protected h() {
    }

    public static void M(luaj.Globals globals) {
        xm_MState st = new xm_MState();
        st.v1o = globals;
        xm_M_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_M_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_MState {
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

    private static void xm_M_run(xm_MState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_M_c0(st);
            }
            else {
                done = xm_M_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_M_c0(xm_MState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = gg_g.h.f1631b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        ((luaj.Globals) st.v1o).k0 = (luaj.Globals$a) st.v0o;
                    case 2:
                        st.pc = 2;
                        ((luaj.Globals) st.v1o).j0 = (luaj.Globals$b) st.v0o;
                    case 3:
                        st.pc = 3;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_M_handler(st.pc, t);
            if (h < 0) {
                xm_M_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_M_ctypes = {
    };
    private static final int[] xm_M_handlers = {
        
    };
    private static int xm_M_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_M_handlers.length; i += 4) {
            if (pc < xm_M_handlers[i] || pc >= xm_M_handlers[i + 1]) {
                continue;
            }
            int ti = xm_M_handlers[i + 3];
            if (ti < 0 || xm_M_ctypes[ti].isInstance(t)) {
                return xm_M_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // luaj.Globals$b
    public luaj.LuaFunction a(luaj.h hVar, java.lang.String str, luaj.LuaValue luaValue) {
        xm_aState st = new xm_aState();
        st.v1o = this;
        st.v2o = hVar;
        st.v3o = str;
        st.v4o = luaValue;
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
        java.lang.Object v1o;
        java.lang.Object v2o;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        java.lang.Object v4o;
    }

    private static luaj.LuaFunction xm_a_run(xm_aState st) {
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
                return (luaj.LuaFunction) st.resultO;
            }
        }
    }

    private static boolean xm_a_c0(xm_aState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 1:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v3o = new luaj.LuaClosure((luaj.h) st.v2o, (luaj.LuaValue) st.v4o, (st.v0i != 0));
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 3:
                        st.pc = 3;
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

    @Override // luaj.Globals$a
    /* ------------------------------------------------------------- *
     *  .method public b(Ljava/io/InputStream;Ljava/lang/String;)Lluaj/h;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public luaj.h b(java.io.InputStream inputStream, java.lang.String str) {
        xm_bState st = new xm_bState();
        st.v1o = this;
        st.v2o = inputStream;
        st.v3o = str;
        return xm_b_run(st);
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
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        java.lang.Object v3o;
    }

    private static luaj.h xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_b_c0(st);
            }
            else {
                done = xm_b_c0(st);
            }
            if (done) {
                return (luaj.h) st.resultO;
            }
        }
    }

    private static boolean xm_b_c0(xm_bState st) {
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
                        st.v0o = new gg_g.h$a();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((gg_g.h$a) st.v0o).b((java.io.InputStream) st.v2o, (java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
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

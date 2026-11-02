package gg_g;

/* JADX INFO: loaded from: classes.dex */
class h$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1632a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private java.util.Hashtable f1633b = new java.util.Hashtable();

    protected h$a() {
    }

    public luaj.LuaString a(luaj.LuaString luaString) {
        xm_aState st = new xm_aState();
        st.v1o = this;
        st.v2o = luaString;
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
    }

    private static luaj.LuaString xm_a_run(xm_aState st) {
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
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_a_c0(xm_aState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.h$a) st.v1o).f1633b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpO = ((java.util.Hashtable) st.v0o).get(st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v0o = (luaj.LuaString) st.v0o;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0o == null) {
                            st.pc = 6;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 6:
                        st.pc = 6;
                        st.v0o = ((gg_g.h$a) st.v1o).f1633b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((java.util.Hashtable) st.v0o).put(st.v2o, st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.pc = 8;
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

    luaj.h b(java.io.InputStream inputStream, java.lang.String str) {
        xm_bState st = new xm_bState();
        st.v4o = this;
        st.v5o = inputStream;
        st.v6o = str;
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

    private static luaj.h xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 37) {
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
                        st.v0o = new gg_g.g((gg_g.h$a) st.v4o, (java.io.InputStream) st.v5o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v1o = new gg_g.c();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        ((gg_g.g) st.v0o).f1595g = (gg_g.c) st.v1o;
                    case 5:
                        st.pc = 5;
                        st.tmpI = ((java.io.InputStream) st.v5o).read();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = luaj.LuaValue.K2((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        ((gg_g.g) st.v0o).y1((gg_g.h$a) st.v4o, st.v2i, (java.io.InputStream) st.v5o, (luaj.LuaString) st.v3o);
                    case 10:
                        st.pc = 10;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v5o = new luaj.h();
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 12:
                        st.pc = 12;
                        ((gg_g.c) st.v1o).f1575b = (luaj.h) st.v5o;
                    case 13:
                        st.pc = 13;
                        st.tmpO = luaj.LuaValue.K2((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 15:
                        st.pc = 15;
                        ((luaj.h) st.v5o).f1729g = (luaj.LuaString) st.v6o;
                    case 16:
                        st.pc = 16;
                        ((gg_g.g) st.v0o).a1((gg_g.c) st.v1o);
                    case 17:
                        st.pc = 17;
                        st.v5o = ((gg_g.c) st.v1o).f1577d;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 18:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 19:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 20:
                        st.pc = 20;
                        if (st.v5o != null) {
                            st.pc = 23;
                            continue;
                        }
                    case 21:
                        st.v5i = 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.pc = 24;
                        continue;
                    case 23:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 24:
                        st.pc = 24;
                        gg_g.a.C((st.v5i != 0));
                    case 25:
                        st.pc = 25;
                        st.v5o = ((gg_g.g) st.v0o).l;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 26:
                        st.pc = 26;
                        if (st.v5o == null) {
                            st.pc = 33;
                            continue;
                        }
                    case 27:
                        st.pc = 27;
                        st.v0i = ((gg_g.g$d) st.v5o).f1604b;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 28:
                        st.pc = 28;
                        if (st.v0i != 0) {
                            st.pc = 34;
                            continue;
                        }
                    case 29:
                        st.pc = 29;
                        st.v0i = ((gg_g.g$d) st.v5o).f1606d;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 30:
                        st.pc = 30;
                        if (st.v0i != 0) {
                            st.pc = 34;
                            continue;
                        }
                    case 31:
                        st.pc = 31;
                        st.v5i = ((gg_g.g$d) st.v5o).f1608f;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 32:
                        st.pc = 32;
                        if (st.v5i != 0) {
                            st.pc = 34;
                            continue;
                        }
                    case 33:
                        st.v6i = 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 34:
                        st.pc = 34;
                        gg_g.a.C((st.v6i != 0));
                    case 35:
                        st.pc = 35;
                        st.v5o = ((gg_g.c) st.v1o).f1575b;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 36:
                        st.pc = 36;
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

    public luaj.LuaString c(java.lang.String str) {
        xm_cState st = new xm_cState();
        st.v0o = this;
        st.v1o = str;
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
        java.lang.Object v0o;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
    }

    private static luaj.LuaString xm_c_run(xm_cState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_c_c0(st);
            }
            else {
                done = xm_c_c0(st);
            }
            if (done) {
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_c_c0(xm_cState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = luaj.LuaString.K2((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((gg_g.h$a) st.v0o).a((luaj.LuaString) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
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

    public luaj.LuaString d(luaj.LuaString luaString) {
        xm_dState st = new xm_dState();
        st.v0o = this;
        st.v1o = luaString;
        return xm_d_run(st);
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
        java.lang.Object v0o;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
    }

    private static luaj.LuaString xm_d_run(xm_dState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_d_c0(st);
            }
            else {
                done = xm_d_c0(st);
            }
            if (done) {
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_d_c0(xm_dState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpO = ((gg_g.h$a) st.v0o).a((luaj.LuaString) st.v1o);
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

    /* ------------------------------------------------------------- *
     *  .method public e(Ljava/lang/String;)Ljava/lang/String;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public java.lang.String e(java.lang.String str) {
        xm_eState st = new xm_eState();
        st.v0o = this;
        st.v1o = str;
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
        java.lang.Object v1o;
    }

    private static java.lang.String xm_e_run(xm_eState st) {
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
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_e_c0(xm_eState st) {
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
}

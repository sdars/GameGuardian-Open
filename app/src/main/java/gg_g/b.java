package gg_g;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    java.io.DataOutputStream f1571d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f1572e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f1573f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1568a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1569b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1570c = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1574g = 0;

    public b(java.io.OutputStream outputStream, boolean z, boolean z2) {
        this.f1571d = new java.io.DataOutputStream(outputStream);
        this.f1572e = z;
        this.f1573f = z2;
    }

    public static int a(luaj.h hVar, java.io.OutputStream outputStream, boolean z, boolean z2) {
        xm_aState st = new xm_aState();
        st.v1o = hVar;
        st.v2o = outputStream;
        st.v3i = (z ? 1 : 0);
        st.v4i = (z2 ? 1 : 0);
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
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        int v4i;
    }

    private static int xm_a_run(xm_aState st) {
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
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v0o = new gg_g.b((java.io.OutputStream) st.v2o, (st.v3i != 0), (st.v4i != 0));
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        ((gg_g.b) st.v0o).h();
                    case 3:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        ((gg_g.b) st.v0o).g((luaj.h) st.v1o, (luaj.LuaString) st.v2o);
                    case 5:
                        st.pc = 5;
                        st.v1i = ((gg_g.b) st.v0o).f1574g;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
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

    void b(int i) {
        xm_bState st = new xm_bState();
        st.v1o = this;
        st.v2i = i;
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
        java.lang.Object v1o;
        int v2i;
    }

    private static void xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
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
                        st.v0o = ((gg_g.b) st.v1o).f1571d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        ((java.io.DataOutputStream) st.v0o).write(st.v2i);
                    case 2:
                        st.pc = 2;
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

    void c(luaj.h hVar) {
        xm_cState st = new xm_cState();
        st.v3o = this;
        st.v4o = hVar;
        xm_c_run(st);
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

    private static void xm_c_run(xm_cState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 15) {
                done = xm_c_c0(st);
            }
            else {
                done = xm_c_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_c_c0(xm_cState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.h) st.v4o).f1724b;
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
                        ((gg_g.b) st.v3o).i(st.v1i);
                    case 3:
                        st.pc = 3;
                        st.v2i = (((gg_g.b) st.v3o).f1573f ? 1 : 0);
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v2i == 0) {
                            st.pc = 6;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.v0o = new int[st.v1i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v2i == 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.tmpO = luaj.g.x((luaj.h) st.v4o, (int[]) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v4i >= st.v1i) {
                            st.pc = 14;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v2i = ((int[]) st.v0o)[st.v4i];
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 11:
                        st.pc = 11;
                        ((gg_g.b) st.v3o).i(st.v2i);
                    case 12:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.pc = 9;
                        continue;
                    case 14:
                        st.pc = 14;
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

    /* JADX WARN: Code duplicated, block: B:22:0x0058  */
    void d(luaj.h hVar) {
        xm_dState st = new xm_dState();
        st.v10o = this;
        st.v11o = hVar;
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
        java.lang.Object v10o;
        int v11i;
        long v11j;
        java.lang.Object v11o;
        double v11d;
    }

    private static void xm_d_run(xm_dState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 94) {
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
                        st.v0o = ((gg_g.b) st.v10o).f1571d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = ((luaj.h) st.v11o).f1723a;
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
                        ((gg_g.b) st.v10o).i(st.v2i);
                    case 4:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v4i >= st.v2i) {
                            st.pc = 83;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.v5o = ((java.lang.Object[]) st.v1o)[st.v4i];
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpI = ((luaj.LuaValue) st.v5o).C2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v6i == 0) {
                            st.pc = 80;
                            continue;
                        }
                    case 11:
                        st.v7i = 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v6i == st.v7i) {
                            st.pc = 75;
                            continue;
                        }
                    case 13:
                        st.v8i = 4;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 14:
                        st.v9i = 3;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v6i == st.v9i) {
                            st.pc = 31;
                            continue;
                        }
                    case 16:
                        st.pc = 16;
                        if (st.v6i != st.v8i) {
                            st.pc = 21;
                            continue;
                        }
                    case 17:
                        st.pc = 17;
                        ((java.io.DataOutputStream) st.v0o).write(st.v8i);
                    case 18:
                        st.pc = 18;
                        st.v5o = (luaj.LuaString) st.v5o;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 19:
                        st.pc = 19;
                        ((gg_g.b) st.v10o).j((luaj.LuaString) st.v5o);
                    case 20:
                        st.pc = 20;
                        st.pc = 81;
                        continue;
                    case 21:
                        st.pc = 21;
                        st.v11o = null;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 24:
                        st.v1o = "bad type for ";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 26:
                        st.pc = 26;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.pc = 27;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v11o = new java.lang.IllegalArgumentException((java.lang.String) st.v0o);
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 30:
                        st.pc = 30;
                        throw (java.lang.Throwable) st.v11o;
                    case 31:
                        st.pc = 31;
                        st.v6i = ((gg_g.b) st.v10o).f1569b;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 32:
                        st.pc = 32;
                        if (st.v6i == 0) {
                            st.pc = 44;
                            continue;
                        }
                    case 33:
                        st.pc = 33;
                        if (st.v6i == st.v7i) {
                            st.pc = 60;
                            continue;
                        }
                    case 34:
                        st.pc = 34;
                        if (st.v6i != st.v8i) {
                            st.pc = 49;
                            continue;
                        }
                    case 35:
                        st.pc = 35;
                        st.tmpI = (((luaj.LuaValue) st.v5o).h1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 36:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 37:
                        st.pc = 37;
                        if (st.v6i == 0) {
                            st.pc = 44;
                            continue;
                        }
                    case 38:
                        st.v6i = 0xfffffffe;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 39:
                        st.pc = 39;
                        ((java.io.DataOutputStream) st.v0o).write(st.v6i);
                    case 40:
                        st.pc = 40;
                        st.tmpI = ((luaj.LuaValue) st.v5o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 41:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 42:
                        st.pc = 42;
                        ((gg_g.b) st.v10o).i(st.v5i);
                    case 43:
                        st.pc = 43;
                        st.pc = 81;
                        continue;
                    case 44:
                        st.pc = 44;
                        ((java.io.DataOutputStream) st.v0o).write(st.v9i);
                    case 45:
                        st.pc = 45;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 46:
                        st.v5d = st.tmpD;
                        st.v5j = java.lang.Double.doubleToRawLongBits(st.v5d);
                        st.v5i = 0;
                        st.v5o = null;
                    case 47:
                        st.pc = 47;
                        ((gg_g.b) st.v10o).f(st.v5d);
                    case 48:
                        st.pc = 48;
                        st.pc = 81;
                        continue;
                    case 49:
                        st.pc = 49;
                        st.v11o = null;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 50:
                        st.pc = 50;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 51:
                        st.pc = 51;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 52:
                        st.v1o = "number format not supported: ";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 53:
                        st.pc = 53;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 54:
                        st.pc = 54;
                        st.v1i = ((gg_g.b) st.v10o).f1569b;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 55:
                        st.pc = 55;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 56:
                        st.pc = 56;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 57:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 58:
                        st.pc = 58;
                        st.v11o = new java.lang.IllegalArgumentException((java.lang.String) st.v0o);
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 59:
                        st.pc = 59;
                        throw (java.lang.Throwable) st.v11o;
                    case 60:
                        st.pc = 60;
                        st.tmpI = (((luaj.LuaValue) st.v5o).h1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 61:
                        st.v6i = st.tmpI;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 62:
                        st.pc = 62;
                        if (st.v6i == 0) {
                            st.pc = 65;
                            continue;
                        }
                    case 63:
                        st.pc = 63;
                        ((java.io.DataOutputStream) st.v0o).write(st.v9i);
                    case 64:
                        st.pc = 64;
                        st.pc = 40;
                        continue;
                    case 65:
                        st.pc = 65;
                        st.v11o = null;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 66:
                        st.pc = 66;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 67:
                        st.pc = 67;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 68:
                        st.v1o = "not an integer: ";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 69:
                        st.pc = 69;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 70:
                        st.pc = 70;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 71:
                        st.pc = 71;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 72:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 73:
                        st.pc = 73;
                        st.v11o = new java.lang.IllegalArgumentException((java.lang.String) st.v0o);
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 74:
                        st.pc = 74;
                        throw (java.lang.Throwable) st.v11o;
                    case 75:
                        st.pc = 75;
                        ((java.io.DataOutputStream) st.v0o).write(st.v7i);
                    case 76:
                        st.pc = 76;
                        st.tmpI = (((luaj.LuaValue) st.v5o).w2()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 77:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 78:
                        st.pc = 78;
                        ((gg_g.b) st.v10o).b(st.v5i);
                    case 79:
                        st.pc = 79;
                        st.pc = 81;
                        continue;
                    case 80:
                        st.pc = 80;
                        ((java.io.DataOutputStream) st.v0o).write(st.v3i);
                    case 81:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 82:
                        st.pc = 82;
                        st.pc = 6;
                        continue;
                    case 83:
                        st.pc = 83;
                        st.v0o = ((luaj.h) st.v11o).f1725c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 84:
                        st.pc = 84;
                        st.v0i = java.lang.reflect.Array.getLength(st.v0o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 85:
                        st.pc = 85;
                        ((gg_g.b) st.v10o).i(st.v0i);
                    case 86:
                        st.pc = 86;
                        if (st.v3i >= st.v0i) {
                            st.pc = 93;
                            continue;
                        }
                    case 87:
                        st.pc = 87;
                        st.v1o = ((luaj.h) st.v11o).f1725c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 88:
                        st.pc = 88;
                        st.v1o = ((java.lang.Object[]) st.v1o)[st.v3i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 89:
                        st.pc = 89;
                        st.v2o = ((luaj.h) st.v11o).f1729g;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 90:
                        st.pc = 90;
                        ((gg_g.b) st.v10o).g((luaj.h) st.v1o, (luaj.LuaString) st.v2o);
                    case 91:
                        st.v3i = st.v3i + 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 92:
                        st.pc = 92;
                        st.pc = 86;
                        continue;
                    case 93:
                        st.pc = 93;
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

    void e(luaj.h hVar, luaj.LuaString luaString) {
        xm_eState st = new xm_eState();
        st.v5o = this;
        st.v6o = hVar;
        st.v7o = luaString;
        xm_e_run(st);
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
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
    }

    private static void xm_e_run(xm_eState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 58) {
                done = xm_e_c0(st);
            }
            else {
                done = xm_e_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_e_c0(xm_eState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = (((gg_g.b) st.v5o).f1572e ? 1 : 0);
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
                        if (st.v0i != 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        if (st.v7o == null) {
                            st.pc = 9;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v0o = ((luaj.h) st.v6o).f1729g;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (((luaj.LuaString) st.v7o).P0((luaj.LuaValue) st.v0o)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v7i == 0) {
                            st.pc = 9;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.pc = 12;
                        continue;
                    case 9:
                        st.pc = 9;
                        st.v7o = ((luaj.h) st.v6o).f1729g;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((gg_g.b) st.v5o).j((luaj.LuaString) st.v7o);
                    case 11:
                        st.pc = 11;
                        st.pc = 13;
                        continue;
                    case 12:
                        st.pc = 12;
                        ((gg_g.b) st.v5o).i(st.v1i);
                    case 13:
                        st.pc = 13;
                        st.v7o = ((luaj.h) st.v6o).f1726d;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.v0i = (((gg_g.b) st.v5o).f1572e ? 1 : 0);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v0i == 0) {
                            st.pc = 18;
                            continue;
                        }
                    case 16:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.pc = 19;
                        continue;
                    case 18:
                        st.pc = 18;
                        st.v0i = java.lang.reflect.Array.getLength(st.v7o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 19:
                        st.pc = 19;
                        ((gg_g.b) st.v5o).i(st.v0i);
                    case 20:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 21:
                        st.pc = 21;
                        if (st.v2i >= st.v0i) {
                            st.pc = 26;
                            continue;
                        }
                    case 22:
                        st.pc = 22;
                        st.v3i = ((int[]) st.v7o)[st.v2i];
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 23:
                        st.pc = 23;
                        ((gg_g.b) st.v5o).i(st.v3i);
                    case 24:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.pc = 21;
                        continue;
                    case 26:
                        st.pc = 26;
                        st.v7o = ((luaj.h) st.v6o).f1727e;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.v0i = (((gg_g.b) st.v5o).f1572e ? 1 : 0);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 28:
                        st.pc = 28;
                        if (st.v0i == 0) {
                            st.pc = 31;
                            continue;
                        }
                    case 29:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.pc = 32;
                        continue;
                    case 31:
                        st.pc = 31;
                        st.v0i = java.lang.reflect.Array.getLength(st.v7o);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 32:
                        st.pc = 32;
                        ((gg_g.b) st.v5o).i(st.v0i);
                    case 33:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 34:
                        st.pc = 34;
                        if (st.v2i >= st.v0i) {
                            st.pc = 44;
                            continue;
                        }
                    case 35:
                        st.pc = 35;
                        st.v3o = ((java.lang.Object[]) st.v7o)[st.v2i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.v4o = ((gg_f.b) st.v3o).f1558a;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 37:
                        st.pc = 37;
                        ((gg_g.b) st.v5o).j((luaj.LuaString) st.v4o);
                    case 38:
                        st.pc = 38;
                        st.v4i = ((gg_f.b) st.v3o).f1559b;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 39:
                        st.pc = 39;
                        ((gg_g.b) st.v5o).i(st.v4i);
                    case 40:
                        st.pc = 40;
                        st.v3i = ((gg_f.b) st.v3o).f1560c;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 41:
                        st.pc = 41;
                        ((gg_g.b) st.v5o).i(st.v3i);
                    case 42:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 43:
                        st.pc = 43;
                        st.pc = 34;
                        continue;
                    case 44:
                        st.pc = 44;
                        st.v6o = ((luaj.h) st.v6o).f1728f;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 45:
                        st.pc = 45;
                        st.v7i = (((gg_g.b) st.v5o).f1572e ? 1 : 0);
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 46:
                        st.pc = 46;
                        if (st.v7i == 0) {
                            st.pc = 49;
                            continue;
                        }
                    case 47:
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 48:
                        st.pc = 48;
                        st.pc = 50;
                        continue;
                    case 49:
                        st.pc = 49;
                        st.v7i = java.lang.reflect.Array.getLength(st.v6o);
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 50:
                        st.pc = 50;
                        ((gg_g.b) st.v5o).i(st.v7i);
                    case 51:
                        st.pc = 51;
                        if (st.v1i >= st.v7i) {
                            st.pc = 57;
                            continue;
                        }
                    case 52:
                        st.pc = 52;
                        st.v0o = ((java.lang.Object[]) st.v6o)[st.v1i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 53:
                        st.pc = 53;
                        st.v0o = ((gg_f.d) st.v0o).f1565a;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 54:
                        st.pc = 54;
                        ((gg_g.b) st.v5o).j((luaj.LuaString) st.v0o);
                    case 55:
                        st.v1i = st.v1i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 56:
                        st.pc = 56;
                        st.pc = 51;
                        continue;
                    case 57:
                        st.pc = 57;
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

    void f(double d2) {
        xm_fState st = new xm_fState();
        st.v2o = this;
        st.v3d = d2;
        xm_f_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_f_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_fState {
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

    private static void xm_f_run(xm_fState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 9) {
                done = xm_f_c0(st);
            }
            else {
                done = xm_f_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_f_c0(xm_fState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpJ = java.lang.Double.doubleToLongBits(st.v3d);
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 1:
                        st.v3j = st.tmpJ;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 2:
                        st.pc = 2;
                        st.v0i = (((gg_g.b) st.v2o).f1568a ? 1 : 0);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i == 0) {
                            st.pc = 6;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.tmpJ = java.lang.Long.reverseBytes(st.v3j);
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 5:
                        st.v3j = st.tmpJ;
                        st.v3d = java.lang.Double.longBitsToDouble(st.v3j);
                        st.v3i = 0;
                        st.v3o = null;
                    case 6:
                        st.pc = 6;
                        st.v0o = ((gg_g.b) st.v2o).f1571d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((java.io.DataOutputStream) st.v0o).writeLong(st.v3j);
                    case 8:
                        st.pc = 8;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_f_handler(st.pc, t);
            if (h < 0) {
                xm_f_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_f_ctypes = {
    };
    private static final int[] xm_f_handlers = {
        
    };
    private static int xm_f_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_f_handlers.length; i += 4) {
            if (pc < xm_f_handlers[i] || pc >= xm_f_handlers[i + 1]) {
                continue;
            }
            int ti = xm_f_handlers[i + 3];
            if (ti < 0 || xm_f_ctypes[ti].isInstance(t)) {
                return xm_f_handlers[i + 2];
            }
        }
        return -1;
    }

    void g(luaj.h hVar, luaj.LuaString luaString) {
        xm_gState st = new xm_gState();
        st.v1o = this;
        st.v2o = hVar;
        st.v3o = luaString;
        xm_g_run(st);
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
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        java.lang.Object v1o;
        java.lang.Object v2o;
        java.lang.Object v3o;
    }

    private static void xm_g_run(xm_gState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 15) {
                done = xm_g_c0(st);
            }
            else {
                done = xm_g_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_g_c0(xm_gState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((luaj.h) st.v2o).h;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        ((gg_g.b) st.v1o).i(st.v0i);
                    case 2:
                        st.pc = 2;
                        st.v0i = ((luaj.h) st.v2o).i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        ((gg_g.b) st.v1o).i(st.v0i);
                    case 4:
                        st.pc = 4;
                        st.v0i = ((luaj.h) st.v2o).j;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        ((gg_g.b) st.v1o).b(st.v0i);
                    case 6:
                        st.pc = 6;
                        st.v0i = ((luaj.h) st.v2o).k;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        ((gg_g.b) st.v1o).b(st.v0i);
                    case 8:
                        st.pc = 8;
                        st.v0i = ((luaj.h) st.v2o).l;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        ((gg_g.b) st.v1o).b(st.v0i);
                    case 10:
                        st.pc = 10;
                        ((gg_g.b) st.v1o).c((luaj.h) st.v2o);
                    case 11:
                        st.pc = 11;
                        ((gg_g.b) st.v1o).d((luaj.h) st.v2o);
                    case 12:
                        st.pc = 12;
                        ((gg_g.b) st.v1o).k((luaj.h) st.v2o);
                    case 13:
                        st.pc = 13;
                        ((gg_g.b) st.v1o).e((luaj.h) st.v2o, (luaj.LuaString) st.v3o);
                    case 14:
                        st.pc = 14;
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

    void h() {
        xm_hState st = new xm_hState();
        st.v2o = this;
        xm_h_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_h_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_hState {
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

    private static void xm_h_run(xm_hState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 20) {
                done = xm_h_c0(st);
            }
            else {
                done = xm_h_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_h_c0(xm_hState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.b) st.v2o).f1571d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = luaj.a.n;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        ((java.io.OutputStream) st.v0o).write((byte[]) st.v1o);
                    case 3:
                        st.v1i = 82;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 7:
                        st.pc = 7;
                        st.v1i = (((gg_g.b) st.v2o).f1568a ? 1 : 0);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 9:
                        st.v1i = 4;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 11:
                        st.pc = 11;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 12:
                        st.pc = 12;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 13:
                        st.pc = 13;
                        st.v1i = ((gg_g.b) st.v2o).f1570c;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 14:
                        st.pc = 14;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 15:
                        st.pc = 15;
                        st.v1i = ((gg_g.b) st.v2o).f1569b;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 16:
                        st.pc = 16;
                        ((java.io.DataOutputStream) st.v0o).write(st.v1i);
                    case 17:
                        st.pc = 17;
                        st.v1o = luaj.a.o;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 18:
                        st.pc = 18;
                        ((java.io.OutputStream) st.v0o).write((byte[]) st.v1o);
                    case 19:
                        st.pc = 19;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_h_handler(st.pc, t);
            if (h < 0) {
                xm_h_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_h_ctypes = {
    };
    private static final int[] xm_h_handlers = {
        
    };
    private static int xm_h_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_h_handlers.length; i += 4) {
            if (pc < xm_h_handlers[i] || pc >= xm_h_handlers[i + 1]) {
                continue;
            }
            int ti = xm_h_handlers[i + 3];
            if (ti < 0 || xm_h_ctypes[ti].isInstance(t)) {
                return xm_h_handlers[i + 2];
            }
        }
        return -1;
    }

    void i(int i) {
        xm_iState st = new xm_iState();
        st.v2o = this;
        st.v3i = i;
        xm_i_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_i_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_iState {
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

    private static void xm_i_run(xm_iState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 7) {
                done = xm_i_c0(st);
            }
            else {
                done = xm_i_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_i_c0(xm_iState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.b) st.v2o).f1571d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1i = (((gg_g.b) st.v2o).f1568a ? 1 : 0);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v1i == 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Integer.reverseBytes(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.pc = 5;
                        ((java.io.DataOutputStream) st.v0o).writeInt(st.v3i);
                    case 6:
                        st.pc = 6;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_i_handler(st.pc, t);
            if (h < 0) {
                xm_i_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_i_ctypes = {
    };
    private static final int[] xm_i_handlers = {
        
    };
    private static int xm_i_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_i_handlers.length; i += 4) {
            if (pc < xm_i_handlers[i] || pc >= xm_i_handlers[i + 1]) {
                continue;
            }
            int ti = xm_i_handlers[i + 3];
            if (ti < 0 || xm_i_ctypes[ti].isInstance(t)) {
                return xm_i_handlers[i + 2];
            }
        }
        return -1;
    }

    void j(luaj.LuaString luaString) {
        xm_jState st = new xm_jState();
        st.v3o = this;
        st.v4o = luaString;
        xm_j_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_j_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_jState {
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

    private static void xm_j_run(xm_jState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 16) {
                done = xm_j_c0(st);
            }
            else {
                done = xm_j_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_j_c0(xm_jState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v4o != null) {
                            st.pc = 4;
                            continue;
                        }
                    case 1:
                        st.v4o = "";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = luaj.LuaValue.K2((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpO = ((luaj.LuaString) st.v4o).r1();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.tmpI = ((luaj.LuaValue) st.v0o).y2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 7:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.v1i = st.v0i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        ((gg_g.b) st.v3o).i(st.v1i);
                    case 10:
                        st.pc = 10;
                        st.v1o = ((gg_g.b) st.v3o).f1571d;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 11:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        ((luaj.LuaString) st.v4o).q3((java.io.DataOutputStream) st.v1o, st.v2i, st.v0i);
                    case 13:
                        st.pc = 13;
                        st.v4o = ((gg_g.b) st.v3o).f1571d;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 14:
                        st.pc = 14;
                        ((java.io.DataOutputStream) st.v4o).write(st.v2i);
                    case 15:
                        st.pc = 15;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_j_handler(st.pc, t);
            if (h < 0) {
                xm_j_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_j_ctypes = {
    };
    private static final int[] xm_j_handlers = {
        
    };
    private static int xm_j_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_j_handlers.length; i += 4) {
            if (pc < xm_j_handlers[i] || pc >= xm_j_handlers[i + 1]) {
                continue;
            }
            int ti = xm_j_handlers[i + 3];
            if (ti < 0 || xm_j_ctypes[ti].isInstance(t)) {
                return xm_j_handlers[i + 2];
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------- *
     *  .method k(Lluaj/h;)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    void k(luaj.h hVar) {
        xm_kState st = new xm_kState();
        st.v5o = this;
        st.v6o = hVar;
        xm_k_run(st);
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

    private static void xm_k_run(xm_kState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 14) {
                done = xm_k_c0(st);
            }
            else {
                done = xm_k_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_k_c0(xm_kState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.b) st.v5o).f1571d;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v6o = ((luaj.h) st.v6o).f1728f;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v6o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        ((gg_g.b) st.v5o).i(st.v1i);
                    case 4:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v2i >= st.v1i) {
                            st.pc = 13;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.v3o = ((java.lang.Object[]) st.v6o)[st.v2i];
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v4i = (((gg_f.d) st.v3o).f1566b ? 1 : 0);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 8:
                        st.pc = 8;
                        ((java.io.DataOutputStream) st.v0o).writeByte(st.v4i);
                    case 9:
                        st.pc = 9;
                        st.v3i = ((gg_f.d) st.v3o).f1567c;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((java.io.DataOutputStream) st.v0o).writeByte(st.v3i);
                    case 11:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.pc = 5;
                        continue;
                    case 13:
                        st.pc = 13;
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
}

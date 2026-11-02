package lasm;

/* JADX INFO: loaded from: classes.dex */
public abstract class LasmBase {
    static void a(lasm.LasmBase$V lasmBase$V, lasm.LasmBase$V lasmBase$V2, int i) {
        xm_aState st = new xm_aState();
        st.v0o = lasmBase$V;
        st.v1o = lasmBase$V2;
        st.v2i = i;
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
        java.lang.Object v0o;
        java.lang.Object v1o;
        int v2i;
    }

    private static void xm_a_run(xm_aState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 1) {
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

    static void b(lasm.LasmBase$V lasmBase$V, lasm.LasmBase$V lasmBase$V2) throws gg_e.b {
        xm_bState st = new xm_bState();
        st.v3o = lasmBase$V;
        st.v4o = lasmBase$V2;
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

    private static void xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 17) {
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
                        st.v0i = ((lasm.LasmBase$Internal) st.v3o).P;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1i = ((lasm.LasmBase$Internal) st.v4o).P;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i != st.v1i) {
                            st.pc = 4;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        return true;
                    case 4:
                        st.pc = 4;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v4o = ((lasm.LasmBase$Internal) st.v4o).Q;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 8:
                        st.v2o = "Register must be ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.pc = 10;
                        st.v3o = ((lasm.LasmBase$Internal) st.v3o).Q;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v3o = ((gg_e.f) st.v3o).f1551f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.v0o = new gg_e.b((gg_e.f) st.v4o, (java.lang.String) st.v3o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 16:
                        st.pc = 16;
                        throw (java.lang.Throwable) st.v0o;
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

    /* JADX WARN: Code duplicated, block: B:15:0x002a  */
    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:22:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x006e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0096 A[SYNTHETIC] */
    public static java.lang.String c(java.lang.Throwable th, java.lang.String str, boolean z) throws java.io.IOException {
        xm_cState st = new xm_cState();
        st.v6o = th;
        st.v7o = str;
        st.v8i = (z ? 1 : 0);
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
    }

    private static java.lang.String xm_c_run(xm_cState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 74) {
                done = xm_c_c0(st);
            }
            else {
                done = xm_c_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_c_c0(xm_cState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = (st.v6o instanceof gg_e.b) ? 1 : 0;
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
                            st.pc = 8;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v6o = (gg_e.b) st.v6o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v6o = ((gg_e.d) st.v6o).f1535a;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v0i = ((gg_e.f) st.v6o).f1547b;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v6i = ((gg_e.f) st.v6o).f1548c;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.pc = 22;
                        continue;
                    case 8:
                        st.v0i = (st.v6o instanceof gg_e.d) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v0i == 0) {
                            st.pc = 14;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v6o = (gg_e.d) st.v6o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v6o = ((gg_e.d) st.v6o).f1535a;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v6o = ((gg_e.f) st.v6o).f1552g;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.pc = 5;
                        continue;
                    case 14:
                        st.v0i = (st.v6o instanceof lasm.c) ? 1 : 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v0i == 0) {
                            st.pc = 20;
                            continue;
                        }
                    case 16:
                        st.pc = 16;
                        st.v6o = (lasm.c) st.v6o;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v0i = ((lasm.c) st.v6o).f1643b;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.v6i = ((lasm.c) st.v6o).f1644c;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.pc = 22;
                        continue;
                    case 20:
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 21:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 22:
                        st.v2o = "";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v0i <= 0) {
                            st.pc = 73;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.v5o = new java.io.FileInputStream((java.lang.String) st.v7o);
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.v4o = new java.io.InputStreamReader((java.io.InputStream) st.v5o);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v3o = new java.io.BufferedReader((java.io.Reader) st.v4o);
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 30:
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.tmpO = ((java.io.BufferedReader) st.v3o).readLine();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 32:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 33:
                        st.pc = 33;
                        if (st.v4o == null) {
                            st.pc = 72;
                            continue;
                        }
                    case 34:
                        st.v7i = st.v7i + 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 35:
                        st.pc = 35;
                        if (st.v7i != st.v0i) {
                            st.pc = 31;
                            continue;
                        }
                    case 36:
                        st.v7o = "\n";
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 37:
                        st.pc = 37;
                        if (st.v8i == 0) {
                            st.pc = 55;
                            continue;
                        }
                    case 38:
                        st.pc = 38;
                        st.v8o = null;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.v8o = new java.lang.StringBuilder();
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 40:
                        st.pc = 40;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 41:
                        st.v6i = st.v6i + 0xffffffff;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.tmpO = ((java.lang.String) st.v4o).substring(st.v1i, st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 43:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 45:
                        st.v0i = 8291;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((char) st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 47:
                        st.pc = 47;
                        st.tmpO = ((java.lang.String) st.v4o).substring(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 48:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 49:
                        st.pc = 49;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 50:
                        st.pc = 50;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 51:
                        st.pc = 51;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 52:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 53:
                        st.v2o = st.v6o;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.pc = 72;
                        continue;
                    case 55:
                        st.pc = 55;
                        st.v8o = null;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 56:
                        st.pc = 56;
                        st.v8o = new java.lang.StringBuilder();
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 57:
                        st.pc = 57;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 58:
                        st.pc = 58;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 59:
                        st.pc = 59;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 60:
                        st.pc = 60;
                        st.v7o = null;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 61:
                        st.v6i = st.v6i + 0xffffffff;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 62:
                        st.pc = 62;
                        st.v6o = new char[st.v6i];
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 63:
                        st.pc = 63;
                        st.v7o = new java.lang.String((char[]) st.v6o);
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 64:
                        st.v6o = "\u0000";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 65:
                        st.v0o = "_";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 66:
                        st.pc = 66;
                        st.tmpO = ((java.lang.String) st.v7o).replace((java.lang.CharSequence) st.v6o, (java.lang.CharSequence) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 67:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 68:
                        st.pc = 68;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 69:
                        st.v6o = "^\n";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 70:
                        st.pc = 70;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 71:
                        st.pc = 71;
                        st.pc = 51;
                        continue;
                    case 72:
                        st.pc = 72;
                        ((java.io.BufferedReader) st.v3o).close();
                    case 73:
                        st.pc = 73;
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

    static int d(gg_e.f fVar) throws gg_e.b {
        xm_dState st = new xm_dState();
        st.v4o = fVar;
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

    private static int xm_d_run(xm_dState st) {
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
                return st.resultI;
            }
        }
    }

    private static boolean xm_d_c0(xm_dState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_e.f) st.v4o).f1551f;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 2;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = ((java.lang.String) st.v0o).substring(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.v1i = 16;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpJ = java.lang.Long.parseLong((java.lang.String) st.v0o, st.v1i);
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 6:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 7:
                        st.v4i = (int) st.v0j;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 9:
                        st.pc = 9;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 13:
                        st.v3o = "Failed parse '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.pc = 15;
                        st.v3o = ((gg_e.f) st.v4o).f1551f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.v3o = "' as hex";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.v1o = new gg_e.b((gg_e.f) st.v4o, (java.lang.String) st.v2o, (java.lang.Throwable) st.v0o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 22:
                        st.pc = 22;
                        throw (java.lang.Throwable) st.v1o;
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
        java.lang.NumberFormatException.class
    };
    private static final int[] xm_d_handlers = {
        0, 7, 9, 0
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

    static int e(gg_e.f fVar) {
        xm_eState st = new xm_eState();
        st.v1o = fVar;
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
        int v0i;
        long v0j;
        java.lang.Object v0o;
        double v0d;
        int v1i;
        long v1j;
        java.lang.Object v1o;
        double v1d;
    }

    private static int xm_e_run(xm_eState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_e_c0(st);
            }
            else {
                done = xm_e_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_e_c0(xm_eState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = lasm.LasmBase.f((gg_e.f) st.v1o, st.v0i);
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

    static int f(gg_e.f fVar, int i) throws gg_e.b {
        xm_fState st = new xm_fState();
        st.v3o = fVar;
        st.v4i = i;
        return xm_f_run(st);
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

    private static int xm_f_run(xm_fState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 20) {
                done = xm_f_c0(st);
            }
            else {
                done = xm_f_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_f_c0(xm_fState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_e.f) st.v3o).f1551f;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpO = ((java.lang.String) st.v0o).substring(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Integer.parseInt((java.lang.String) st.v4o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.resultI = st.v3i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 6:
                        st.pc = 6;
                        st.v4o = st.ex;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 10:
                        st.v2o = "Failed parse '";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.pc = 12;
                        st.v2o = ((gg_e.f) st.v3o).f1551f;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v2o = "' as integer";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.v0o = new gg_e.b((gg_e.f) st.v3o, (java.lang.String) st.v1o, (java.lang.Throwable) st.v4o);
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 19:
                        st.pc = 19;
                        throw (java.lang.Throwable) st.v0o;
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
        java.lang.NumberFormatException.class
    };
    private static final int[] xm_f_handlers = {
        0, 5, 6, 0
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

    static int g(gg_e.f fVar, int i) throws gg_e.b {
        xm_gState st = new xm_gState();
        st.v4o = fVar;
        st.v5i = i;
        return xm_g_run(st);
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

    private static int xm_g_run(xm_gState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 24) {
                done = xm_g_c0(st);
            }
            else {
                done = xm_g_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_g_c0(xm_gState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = lasm.LasmBase.f((gg_e.f) st.v4o, st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i > st.v5i) {
                            st.pc = 5;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 5:
                        st.pc = 5;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 8:
                        st.v3o = "'";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.pc = 10;
                        st.v3o = ((gg_e.f) st.v4o).f1551f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v3o = "' parsed as ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v0o = " out of possible range [0; ";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.pc = 17;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.v5o = "]";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.pc = 20;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 21:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.v1o = new gg_e.b((gg_e.f) st.v4o, (java.lang.String) st.v5o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 23:
                        st.pc = 23;
                        throw (java.lang.Throwable) st.v1o;
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

    static long h(gg_e.f fVar) throws gg_e.b {
        xm_hState st = new xm_hState();
        st.v4o = fVar;
        return xm_h_run(st);
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
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        java.lang.Object v4o;
    }

    private static long xm_h_run(xm_hState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 18) {
                done = xm_h_c0(st);
            }
            else {
                done = xm_h_c0(st);
            }
            if (done) {
                return st.resultJ;
            }
        }
    }

    private static boolean xm_h_c0(xm_hState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_e.f) st.v4o).f1551f;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpJ = java.lang.Long.parseLong((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 2:
                        st.v0j = st.tmpJ;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 3:
                        st.pc = 3;
                        st.resultJ = st.v0j;
                        st.resultI = 0;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 4:
                        st.pc = 4;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 8:
                        st.v3o = "Failed parse '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.pc = 10;
                        st.v3o = ((gg_e.f) st.v4o).f1551f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v3o = "' as long";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.v1o = new gg_e.b((gg_e.f) st.v4o, (java.lang.String) st.v2o, (java.lang.Throwable) st.v0o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 17:
                        st.pc = 17;
                        throw (java.lang.Throwable) st.v1o;
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
        java.lang.NumberFormatException.class
    };
    private static final int[] xm_h_handlers = {
        0, 3, 4, 0
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

    static luaj.LuaValue i(gg_e.f fVar) throws gg_e.b {
        xm_iState st = new xm_iState();
        st.v4o = fVar;
        return xm_i_run(st);
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

    private static luaj.LuaValue xm_i_run(xm_iState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 19) {
                done = xm_i_c0(st);
            }
            else {
                done = xm_i_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_i_c0(xm_iState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_e.f) st.v4o).f1551f;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1o = luaj.LuaValue.f1677g;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpO = luaj.LuaValue.P1((java.lang.String) st.v0o, (luaj.LuaValue) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 3:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 5:
                        st.pc = 5;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 9:
                        st.v3o = "Failed parse '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.pc = 11;
                        st.v3o = ((gg_e.f) st.v4o).f1551f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 13:
                        st.v3o = "' as Lua number";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v1o = new gg_e.b((gg_e.f) st.v4o, (java.lang.String) st.v2o, (java.lang.Throwable) st.v0o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 18:
                        st.pc = 18;
                        throw (java.lang.Throwable) st.v1o;
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
        java.lang.NumberFormatException.class
    };
    private static final int[] xm_i_handlers = {
        0, 4, 5, 0
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x014b  */
    /* JADX WARN: Code duplicated, block: B:101:0x014d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0150  */
    /* JADX WARN: Code duplicated, block: B:104:0x0152  */
    /* JADX WARN: Code duplicated, block: B:114:0x016e A[PHI: r7 r8 r9 r10 r15
      0x016e: PHI (r7v4 int) = (r7v1 int), (r7v5 int), (r7v1 int) binds: [B:112:0x016a, B:22:0x0041, B:17:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x016e: PHI (r8v4 int) = (r8v1 int), (r8v11 int), (r8v1 int) binds: [B:112:0x016a, B:22:0x0041, B:17:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x016e: PHI (r9v3 int) = (r9v1 int), (r9v6 int), (r9v1 int) binds: [B:112:0x016a, B:22:0x0041, B:17:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x016e: PHI (r10v3 int) = (r10v1 int), (r10v8 int), (r10v1 int) binds: [B:112:0x016a, B:22:0x0041, B:17:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x016e: PHI (r15v1 byte) = (r15v0 byte), (r15v9 byte), (r15v0 byte) binds: [B:112:0x016a, B:22:0x0041, B:17:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:131:0x00cd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x0171 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:33:0x005e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0065  */
    /* JADX WARN: Code duplicated, block: B:50:0x00af  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:57:0x00be  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ca A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:70:0x0100  */
    /* JADX WARN: Code duplicated, block: B:71:0x0103  */
    /* JADX WARN: Code duplicated, block: B:98:0x0147  */
    /* JADX WARN: Switch 'out' block B:114:0x016e for B:21:0x003e already processed. Defaulting to fallback option. */
    /* ------------------------------------------------------------- *
     *  .method static j(Lgg_e/f;)Lluaj/LuaString;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    static luaj.LuaString j(gg_e.f fVar) throws gg_e.b {
        xm_jState st = new xm_jState();
        st.v16o = fVar;
        return xm_j_run(st);
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
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
        int v14i;
        long v14j;
        java.lang.Object v14o;
        double v14d;
        int v15i;
        long v15j;
        java.lang.Object v15o;
        double v15d;
        java.lang.Object v16o;
    }

    private static luaj.LuaString xm_j_run(xm_jState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 231) {
                done = xm_j_c0(st);
            }
            else {
                done = xm_j_c0(st);
            }
            if (done) {
                return (luaj.LuaString) st.resultO;
            }
        }
    }

    private static boolean xm_j_c0(xm_jState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0o = st.v16o;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v1i = ((gg_e.f) st.v0o).f1546a;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v2i = 56;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v1i != st.v2i) {
                            st.pc = 6;
                            continue;
                        }
                    case 4:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 6:
                        st.pc = 6;
                        st.v1o = ((gg_e.f) st.v0o).f1551f;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((java.lang.String) st.v1o).getBytes();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v3i = java.lang.reflect.Array.getLength(st.v1o);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 11:
                        st.v4i = 2;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 12:
                        st.v3i = st.v3i - st.v4i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.v2o = new gg_f.a(st.v3i);
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.v3i = java.lang.reflect.Array.getLength(st.v1o);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 15:
                        st.v5i = 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 16:
                        st.v3i = st.v3i - st.v5i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.v7i = 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 18:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 19:
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 20:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 21:
                        st.v11o = "hex";
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 22:
                        st.v12o = "unicode";
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 23:
                        st.v13i = 3;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 24:
                        st.pc = 24;
                        if (st.v7i >= st.v3i) {
                            st.pc = 201;
                            continue;
                        }
                    case 25:
                        st.pc = 25;
                        st.v15i = ((byte[]) st.v1o)[st.v7i];
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 26:
                        st.pc = 26;
                        if (st.v8i == 0) {
                            st.pc = 194;
                            continue;
                        }
                    case 27:
                        st.v6i = 4;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 28:
                        st.v14i = 48;
                        st.v14j = 0L;
                        st.v14o = null;
                        st.v14d = 0.0;
                    case 29:
                        st.pc = 29;
                        if (st.v8i == st.v5i) {
                            st.pc = 143;
                            continue;
                        }
                    case 30:
                        st.pc = 30;
                        if (st.v8i == st.v4i) {
                            st.pc = 53;
                            continue;
                        }
                    case 31:
                        st.pc = 31;
                        if (st.v8i == st.v13i) {
                            st.pc = 41;
                            continue;
                        }
                    case 32:
                        st.pc = 32;
                        if (st.v8i == st.v6i) {
                            st.pc = 36;
                            continue;
                        }
                    case 33:
                        st.v6i = 6;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 34:
                        st.pc = 34;
                        if (st.v8i == st.v6i) {
                            st.pc = 53;
                            continue;
                        }
                    case 35:
                        st.pc = 35;
                        st.pc = 198;
                        continue;
                    case 36:
                        st.v6i = 32;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 37:
                        st.pc = 37;
                        if (st.v15i == st.v6i) {
                            st.pc = 199;
                            continue;
                        }
                    case 38:
                        switch (st.v15i) {
                            case 9: st.pc = 199; continue;
                            case 10: st.pc = 199; continue;
                            case 11: st.pc = 199; continue;
                            case 12: st.pc = 199; continue;
                            case 13: st.pc = 199; continue;
                            default: st.pc = 39; continue;
                        }
                    case 39:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 40:
                        st.pc = 40;
                        st.pc = 198;
                        continue;
                    case 41:
                        st.pc = 41;
                        if (st.v14i > st.v15i) {
                            st.pc = 50;
                            continue;
                        }
                    case 42:
                        st.v6i = 57;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 43:
                        st.pc = 43;
                        if (st.v15i > st.v6i) {
                            st.pc = 50;
                            continue;
                        }
                    case 44:
                        st.v9i = st.v9i * 10;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 45:
                        st.v15i = st.v15i + 0xffffffd0;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 46:
                        st.v9i = st.v9i + st.v15i;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 47:
                        st.v10i = st.v10i + 1;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 48:
                        st.pc = 48;
                        if (st.v10i >= st.v13i) {
                            st.pc = 51;
                            continue;
                        }
                    case 49:
                        st.pc = 49;
                        st.pc = 199;
                        continue;
                    case 50:
                        st.v7i = st.v7i + 0xffffffff;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 51:
                        st.v15i = (byte) st.v9i;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 52:
                        st.pc = 52;
                        st.pc = 39;
                        continue;
                    case 53:
                        st.v9i = st.v9i * 16;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 54:
                        st.v6i = 0xffffffff;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 55:
                        st.pc = 55;
                        if (st.v10i != st.v6i) {
                            st.pc = 60;
                            continue;
                        }
                    case 56:
                        st.v6i = 123;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 57:
                        st.pc = 57;
                        if (st.v15i == st.v6i) {
                            st.pc = 107;
                            continue;
                        }
                    case 58:
                        st.v10i = st.v10i + 100;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 59:
                        st.pc = 59;
                        st.pc = 107;
                        continue;
                    case 60:
                        st.v6i = 6;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 61:
                        st.pc = 61;
                        if (st.v8i != st.v6i) {
                            st.pc = 89;
                            continue;
                        }
                    case 62:
                        st.v6i = 125;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 63:
                        st.pc = 63;
                        if (st.v15i != st.v6i) {
                            st.pc = 89;
                            continue;
                        }
                    case 64:
                        st.pc = 64;
                        st.v9i = st.v9i / 16;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 65:
                        st.v6i = 1114111;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 66:
                        st.pc = 66;
                        if (st.v9i > st.v6i) {
                            st.pc = 70;
                            continue;
                        }
                    case 67:
                        st.pc = 67;
                        st.tmpO = ((gg_f.a) st.v2o).f(st.v9i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 68:
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 69:
                        st.pc = 69;
                        st.pc = 199;
                        continue;
                    case 70:
                        st.pc = 70;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 71:
                        st.pc = 71;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 72:
                        st.pc = 72;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 73:
                        st.v3o = "UTF-8 value too large: 0x";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 74:
                        st.pc = 74;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 75:
                        st.pc = 75;
                        st.tmpO = java.lang.Integer.toHexString(st.v9i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 76:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 77:
                        st.pc = 77;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 78:
                        st.v3o = " (max allowed = 0x";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 79:
                        st.pc = 79;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 80:
                        st.pc = 80;
                        st.tmpO = java.lang.Integer.toHexString(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 81:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 82:
                        st.pc = 82;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 83:
                        st.v3o = ")";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 84:
                        st.pc = 84;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 85:
                        st.pc = 85;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 86:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 87:
                        st.pc = 87;
                        st.v1o = new gg_e.b((gg_e.f) st.v0o, (java.lang.String) st.v2o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 88:
                        st.pc = 88;
                        throw (java.lang.Throwable) st.v1o;
                    case 89:
                        st.pc = 89;
                        if (st.v14i > st.v15i) {
                            st.pc = 95;
                            continue;
                        }
                    case 90:
                        st.v6i = 57;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 91:
                        st.pc = 91;
                        if (st.v15i > st.v6i) {
                            st.pc = 95;
                            continue;
                        }
                    case 92:
                        st.v6i = st.v15i + 0xffffffd0;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 93:
                        st.v9i = st.v9i + st.v6i;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 94:
                        st.pc = 94;
                        st.pc = 107;
                        continue;
                    case 95:
                        st.v6i = 97;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 96:
                        st.pc = 96;
                        if (st.v6i > st.v15i) {
                            st.pc = 101;
                            continue;
                        }
                    case 97:
                        st.v6i = 102;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 98:
                        st.pc = 98;
                        if (st.v15i > st.v6i) {
                            st.pc = 101;
                            continue;
                        }
                    case 99:
                        st.v6i = st.v15i + 0xffffffa9;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 100:
                        st.pc = 100;
                        st.pc = 93;
                        continue;
                    case 101:
                        st.v6i = 65;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 102:
                        st.pc = 102;
                        if (st.v6i > st.v15i) {
                            st.pc = 58;
                            continue;
                        }
                    case 103:
                        st.v6i = 70;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 104:
                        st.pc = 104;
                        if (st.v15i > st.v6i) {
                            st.pc = 58;
                            continue;
                        }
                    case 105:
                        st.v6i = st.v15i + 0xffffffc9;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 106:
                        st.pc = 106;
                        st.pc = 93;
                        continue;
                    case 107:
                        st.v10i = st.v10i + st.v5i;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 108:
                        st.pc = 108;
                        if (st.v10i >= st.v8i) {
                            st.pc = 110;
                            continue;
                        }
                    case 109:
                        st.pc = 109;
                        st.pc = 199;
                        continue;
                    case 110:
                        st.pc = 110;
                        if (st.v10i != st.v4i) {
                            st.pc = 112;
                            continue;
                        }
                    case 111:
                        st.pc = 111;
                        st.pc = 51;
                        continue;
                    case 112:
                        st.pc = 112;
                        st.v1i = ((gg_e.f) st.v0o).f1548c;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 113:
                        st.v1i = st.v1i + st.v7i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 114:
                        st.pc = 114;
                        ((gg_e.f) st.v0o).f1548c = st.v1i;
                    case 115:
                        st.pc = 115;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 116:
                        st.pc = 116;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 117:
                        st.pc = 117;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 118:
                        st.v3o = "Invalid char '";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 119:
                        st.pc = 119;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 120:
                        st.pc = 120;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append(st.v15i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 121:
                        st.v3o = "' (code 0x";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 122:
                        st.pc = 122;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 123:
                        st.pc = 123;
                        st.tmpO = java.lang.Integer.toHexString(st.v15i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 124:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 125:
                        st.pc = 125;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 126:
                        st.v3o = ") in ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 127:
                        st.pc = 127;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 128:
                        st.v3i = 6;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 129:
                        st.pc = 129;
                        if (st.v8i != st.v3i) {
                            st.pc = 131;
                            continue;
                        }
                    case 130:
                        st.v11o = st.v12o;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 131:
                        st.pc = 131;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 132:
                        st.v4o = " escape sequence, must be ";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 133:
                        st.pc = 133;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 134:
                        st.pc = 134;
                        if (st.v8i != st.v3i) {
                            st.pc = 137;
                            continue;
                        }
                    case 135:
                        st.v3o = "\\u{XXX}";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 136:
                        st.pc = 136;
                        st.pc = 138;
                        continue;
                    case 137:
                        st.v3o = "\\xXX";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 138:
                        st.pc = 138;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 139:
                        st.pc = 139;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 140:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 141:
                        st.pc = 141;
                        st.v1o = new gg_e.b((gg_e.f) st.v0o, (java.lang.String) st.v2o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 142:
                        st.pc = 142;
                        throw (java.lang.Throwable) st.v1o;
                    case 143:
                        st.v8i = 0xffffffff;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 144:
                        st.pc = 144;
                        if (st.v14i > st.v15i) {
                            st.pc = 151;
                            continue;
                        }
                    case 145:
                        st.v11i = 57;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 146:
                        st.pc = 146;
                        if (st.v15i > st.v11i) {
                            st.pc = 151;
                            continue;
                        }
                    case 147:
                        st.v9i = st.v15i + 0xffffffd0;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 148:
                        st.v8i = 3;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 149:
                        st.v10i = 1;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 150:
                        st.pc = 150;
                        st.pc = 199;
                        continue;
                    case 151:
                        st.v11i = 97;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 152:
                        st.pc = 152;
                        if (st.v15i == st.v11i) {
                            st.pc = 192;
                            continue;
                        }
                    case 153:
                        st.v11i = 98;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 154:
                        st.pc = 154;
                        if (st.v15i == st.v11i) {
                            st.pc = 190;
                            continue;
                        }
                    case 155:
                        st.v11i = 102;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 156:
                        st.pc = 156;
                        if (st.v15i == st.v11i) {
                            st.pc = 188;
                            continue;
                        }
                    case 157:
                        st.v11i = 110;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 158:
                        st.pc = 158;
                        if (st.v15i == st.v11i) {
                            st.pc = 186;
                            continue;
                        }
                    case 159:
                        st.v11i = 114;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 160:
                        st.pc = 160;
                        if (st.v15i == st.v11i) {
                            st.pc = 184;
                            continue;
                        }
                    case 161:
                        st.v11i = 120;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 162:
                        st.pc = 162;
                        if (st.v15i == st.v11i) {
                            st.pc = 173;
                            continue;
                        }
                    case 163:
                        st.v11i = 122;
                        st.v11j = 0L;
                        st.v11o = null;
                        st.v11d = 0.0;
                    case 164:
                        st.pc = 164;
                        if (st.v15i == st.v11i) {
                            st.pc = 171;
                            continue;
                        }
                    case 165:
                        switch (st.v15i) {
                            case 116: st.pc = 169; continue;
                            case 117: st.pc = 173; continue;
                            case 118: st.pc = 167; continue;
                            default: st.pc = 166; continue;
                        }
                    case 166:
                        st.pc = 166;
                        st.pc = 39;
                        continue;
                    case 167:
                        st.v15i = 11;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 168:
                        st.pc = 168;
                        st.pc = 39;
                        continue;
                    case 169:
                        st.v15i = 9;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 170:
                        st.pc = 170;
                        st.pc = 39;
                        continue;
                    case 171:
                        st.v8i = 4;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 172:
                        st.pc = 172;
                        st.pc = 199;
                        continue;
                    case 173:
                        st.v6i = 117;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 174:
                        st.pc = 174;
                        if (st.v15i != st.v6i) {
                            st.pc = 177;
                            continue;
                        }
                    case 175:
                        st.v10i = 0xffffffff;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 176:
                        st.pc = 176;
                        st.pc = 178;
                        continue;
                    case 177:
                        st.v10i = 0;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 178:
                        st.pc = 178;
                        if (st.v15i != st.v6i) {
                            st.pc = 181;
                            continue;
                        }
                    case 179:
                        st.v8i = 6;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 180:
                        st.pc = 180;
                        st.pc = 182;
                        continue;
                    case 181:
                        st.v8i = 2;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 182:
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 183:
                        st.pc = 183;
                        st.pc = 199;
                        continue;
                    case 184:
                        st.v15i = 13;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 185:
                        st.pc = 185;
                        st.pc = 39;
                        continue;
                    case 186:
                        st.v15i = 10;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 187:
                        st.pc = 187;
                        st.pc = 39;
                        continue;
                    case 188:
                        st.v15i = 12;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 189:
                        st.pc = 189;
                        st.pc = 39;
                        continue;
                    case 190:
                        st.v15i = 8;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 191:
                        st.pc = 191;
                        st.pc = 39;
                        continue;
                    case 192:
                        st.v15i = 7;
                        st.v15j = 0L;
                        st.v15o = null;
                        st.v15d = 0.0;
                    case 193:
                        st.pc = 193;
                        st.pc = 39;
                        continue;
                    case 194:
                        st.v6i = 92;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 195:
                        st.pc = 195;
                        if (st.v15i != st.v6i) {
                            st.pc = 198;
                            continue;
                        }
                    case 196:
                        st.v8i = 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 197:
                        st.pc = 197;
                        st.pc = 199;
                        continue;
                    case 198:
                        st.pc = 198;
                        st.tmpO = ((gg_f.a) st.v2o).a((byte) st.v15i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 199:
                        st.v7i = st.v7i + st.v5i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 200:
                        st.pc = 200;
                        st.pc = 21;
                        continue;
                    case 201:
                        st.pc = 201;
                        if (st.v8i != st.v13i) {
                            st.pc = 204;
                            continue;
                        }
                    case 202:
                        st.v3i = (byte) st.v9i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 203:
                        st.pc = 203;
                        st.tmpO = ((gg_f.a) st.v2o).a((byte) st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 204:
                        st.v3i = 6;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 205:
                        st.pc = 205;
                        if (st.v8i == st.v3i) {
                            st.pc = 211;
                            continue;
                        }
                    case 206:
                        st.pc = 206;
                        if (st.v8i != st.v4i) {
                            st.pc = 208;
                            continue;
                        }
                    case 207:
                        st.pc = 207;
                        st.pc = 211;
                        continue;
                    case 208:
                        st.pc = 208;
                        st.tmpO = ((gg_f.a) st.v2o).l();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 209:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 210:
                        st.pc = 210;
                        st.resultO = st.v0o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 211:
                        st.pc = 211;
                        st.v2i = ((gg_e.f) st.v0o).f1548c;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 212:
                        st.pc = 212;
                        st.v1i = java.lang.reflect.Array.getLength(st.v1o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 213:
                        st.v1i = st.v1i - st.v5i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 214:
                        st.v2i = st.v2i + st.v1i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 215:
                        st.pc = 215;
                        ((gg_e.f) st.v0o).f1548c = st.v2i;
                    case 216:
                        st.pc = 216;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 217:
                        st.pc = 217;
                        st.v2o = null;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 218:
                        st.pc = 218;
                        st.v2o = new java.lang.StringBuilder();
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 219:
                        st.v3o = "Unfinished ";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 220:
                        st.pc = 220;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 221:
                        st.v3i = 6;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 222:
                        st.pc = 222;
                        if (st.v8i != st.v3i) {
                            st.pc = 224;
                            continue;
                        }
                    case 223:
                        st.v11o = st.v12o;
                        st.v11i = 0;
                        st.v11j = 0L;
                        st.v11d = 0.0;
                    case 224:
                        st.pc = 224;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v11o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 225:
                        st.v3o = " escape sequence";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 226:
                        st.pc = 226;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).append((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 227:
                        st.pc = 227;
                        st.tmpO = ((java.lang.StringBuilder) st.v2o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 228:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 229:
                        st.pc = 229;
                        st.v1o = new gg_e.b((gg_e.f) st.v0o, (java.lang.String) st.v2o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 230:
                        st.pc = 230;
                        throw (java.lang.Throwable) st.v1o;
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
}

package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    g$j[] f1603a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    g$f[] f1605c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    g$f[] f1607e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1604b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1606d = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f1608f = 0;

    g$d() {
    }

    /* ------------------------------------------------------------- *
     *  .method public toString()Ljava/lang/String;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public java.lang.String toString() {
        xm_toStringState st = new xm_toStringState();
        st.v2o = this;
        return xm_toString_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_toString_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_toStringState {
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

    private static java.lang.String xm_toString_run(xm_toStringState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 37) {
                done = xm_toString_c0(st);
            }
            else {
                done = xm_toString_c0(st);
            }
            if (done) {
                return (java.lang.String) st.resultO;
            }
        }
    }

    private static boolean xm_toString_c0(xm_toStringState st) {
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
                        st.v1o = "Dyndata [actvar=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.pc = 4;
                        st.v1o = ((gg_g.g$d) st.v2o).f1603a;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = java.util.Arrays.toString((java.lang.Object[]) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.v1o = ", n_actvar=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.pc = 10;
                        st.v1i = ((gg_g.g$d) st.v2o).f1604b;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v1o = ", gt=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.pc = 14;
                        st.v1o = ((gg_g.g$d) st.v2o).f1605c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = java.util.Arrays.toString((java.lang.Object[]) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.v1o = ", n_gt=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.pc = 20;
                        st.v1i = ((gg_g.g$d) st.v2o).f1606d;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v1o = ", label=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.pc = 24;
                        st.v1o = ((gg_g.g$d) st.v2o).f1607e;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.tmpO = java.util.Arrays.toString((java.lang.Object[]) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 26:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.v1o = ", n_label=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 30:
                        st.pc = 30;
                        st.v1i = ((gg_g.g$d) st.v2o).f1608f;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 32:
                        st.v1i = 93;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 33:
                        st.pc = 33;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((char) st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 34:
                        st.pc = 34;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 35:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 36:
                        st.pc = 36;
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
            int h = xm_toString_handler(st.pc, t);
            if (h < 0) {
                xm_toString_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_toString_ctypes = {
    };
    private static final int[] xm_toString_handlers = {
        
    };
    private static int xm_toString_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_toString_handlers.length; i += 4) {
            if (pc < xm_toString_handlers[i] || pc >= xm_toString_handlers[i + 1]) {
                continue;
            }
            int ti = xm_toString_handlers[i + 3];
            if (ti < 0 || xm_toString_ctypes[ti].isInstance(t)) {
                return xm_toString_handlers[i + 2];
            }
        }
        return -1;
    }
}

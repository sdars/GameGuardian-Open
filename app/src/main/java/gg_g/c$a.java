package gg_g;

/* JADX INFO: loaded from: classes.dex */
class c$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c$a f1581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    short f1582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    short f1583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    short f1584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f1585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f1586f;

    c$a() {
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
            if (pc < 27) {
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
                        st.v1o = "BlockCnt [firstlabel=";
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
                        st.v1i = ((gg_g.c$a) st.v2o).f1582b;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v1o = ", firstgoto=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.pc = 8;
                        st.v1i = ((gg_g.c$a) st.v2o).f1583c;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 10:
                        st.v1o = ", nactvar=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.pc = 12;
                        st.v1i = ((gg_g.c$a) st.v2o).f1584d;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v1o = ", upval=";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.pc = 16;
                        st.v1i = (((gg_g.c$a) st.v2o).f1585e ? 1 : 0);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((st.v1i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.v1o = ", isloop=";
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
                        st.v1i = (((gg_g.c$a) st.v2o).f1586f ? 1 : 0);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((st.v1i != 0));
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v1i = 93;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((char) st.v1i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.pc = 24;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 25:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 26:
                        st.pc = 26;
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

package gg_g;

/* JADX INFO: loaded from: classes.dex */
class g$b implements java.lang.CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    char[] f1596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1597b;

    g$b() {
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        xm_charAtState st = new xm_charAtState();
        st.v1o = this;
        st.v2i = i;
        return xm_charAt_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_charAt_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_charAtState {
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
    }

    private static char xm_charAt_run(xm_charAtState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 3) {
                done = xm_charAt_c0(st);
            }
            else {
                done = xm_charAt_c0(st);
            }
            if (done) {
                return (char) st.resultI;
            }
        }
    }

    private static boolean xm_charAt_c0(xm_charAtState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((gg_g.g$b) st.v1o).f1596a;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.v2i = ((char[]) st.v0o)[st.v2i];
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_charAt_handler(st.pc, t);
            if (h < 0) {
                xm_charAt_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_charAt_ctypes = {
    };
    private static final int[] xm_charAt_handlers = {
        
    };
    private static int xm_charAt_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_charAt_handlers.length; i += 4) {
            if (pc < xm_charAt_handlers[i] || pc >= xm_charAt_handlers[i + 1]) {
                continue;
            }
            int ti = xm_charAt_handlers[i + 3];
            if (ti < 0 || xm_charAt_ctypes[ti].isInstance(t)) {
                return xm_charAt_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // java.lang.CharSequence
    public int length() {
        xm_lengthState st = new xm_lengthState();
        st.v1o = this;
        return xm_length_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_length_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_lengthState {
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

    private static int xm_length_run(xm_lengthState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_length_c0(st);
            }
            else {
                done = xm_length_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_length_c0(xm_lengthState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((gg_g.g$b) st.v1o).f1597b;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
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
            int h = xm_length_handler(st.pc, t);
            if (h < 0) {
                xm_length_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_length_ctypes = {
    };
    private static final int[] xm_length_handlers = {
        
    };
    private static int xm_length_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_length_handlers.length; i += 4) {
            if (pc < xm_length_handlers[i] || pc >= xm_length_handlers[i + 1]) {
                continue;
            }
            int ti = xm_length_handlers[i + 3];
            if (ti < 0 || xm_length_ctypes[ti].isInstance(t)) {
                return xm_length_handlers[i + 2];
            }
        }
        return -1;
    }

    @Override // java.lang.CharSequence
    /* ------------------------------------------------------------- *
     *  .method public subSequence(II)Ljava/lang/CharSequence;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public java.lang.CharSequence subSequence(int i, int i2) {
        xm_subSequenceState st = new xm_subSequenceState();
        st.v0o = this;
        st.v1i = i;
        st.v2i = i2;
        return xm_subSequence_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_subSequence_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_subSequenceState {
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

    private static java.lang.CharSequence xm_subSequence_run(xm_subSequenceState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 2) {
                done = xm_subSequence_c0(st);
            }
            else {
                done = xm_subSequence_c0(st);
            }
            if (done) {
                return (java.lang.CharSequence) st.resultO;
            }
        }
    }

    private static boolean xm_subSequence_c0(xm_subSequenceState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 1:
                        st.pc = 1;
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
            int h = xm_subSequence_handler(st.pc, t);
            if (h < 0) {
                xm_subSequence_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_subSequence_ctypes = {
    };
    private static final int[] xm_subSequence_handlers = {
        
    };
    private static int xm_subSequence_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_subSequence_handlers.length; i += 4) {
            if (pc < xm_subSequence_handlers[i] || pc >= xm_subSequence_handlers[i + 1]) {
                continue;
            }
            int ti = xm_subSequence_handlers[i + 3];
            if (ti < 0 || xm_subSequence_ctypes[ti].isInstance(t)) {
                return xm_subSequence_handlers[i + 2];
            }
        }
        return -1;
    }
}

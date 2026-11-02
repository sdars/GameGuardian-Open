package gg_g;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends luaj.b {
    protected a() {
    }

    public static void A(d dVar, int i) {
        xm_AState st = new xm_AState();
        st.v1o = dVar;
        st.v2i = i;
        xm_A_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_A_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_AState {
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

    private static void xm_A_run(xm_AState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 4) {
                done = xm_A_c0(st);
            }
            else {
                done = xm_A_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_A_c0(xm_AState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 131071;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v2i = st.v2i + st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.pc = 2;
                        gg_g.a.y((gg_g.d) st.v1o, st.v2i);
                    case 3:
                        st.pc = 3;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_A_handler(st.pc, t);
            if (h < 0) {
                xm_A_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_A_ctypes = {
    };
    private static final int[] xm_A_handlers = {
        
    };
    private static int xm_A_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_A_handlers.length; i += 4) {
            if (pc < xm_A_handlers[i] || pc >= xm_A_handlers[i + 1]) {
                continue;
            }
            int ti = xm_A_handlers[i + 3];
            if (ti < 0 || xm_A_ctypes[ti].isInstance(t)) {
                return xm_A_handlers[i + 2];
            }
        }
        return -1;
    }

    public static void B(d dVar, int i) {
        xm_BState st = new xm_BState();
        st.v1o = dVar;
        st.v2i = i;
        xm_B_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_B_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_BState {
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

    private static void xm_B_run(xm_BState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 7) {
                done = xm_B_c0(st);
            }
            else {
                done = xm_B_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_B_c0(xm_BState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((gg_g.d) st.v1o).a();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v0i = st.v0i & 0xffffffc0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.v2i = st.v2i & 63;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.v2i = st.v2i | st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        ((gg_g.d) st.v1o).b(st.v2i);
                    case 6:
                        st.pc = 6;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_B_handler(st.pc, t);
            if (h < 0) {
                xm_B_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_B_ctypes = {
    };
    private static final int[] xm_B_handlers = {
        
    };
    private static int xm_B_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_B_handlers.length; i += 4) {
            if (pc < xm_B_handlers[i] || pc >= xm_B_handlers[i + 1]) {
                continue;
            }
            int ti = xm_B_handlers[i + 3];
            if (ti < 0 || xm_B_ctypes[ti].isInstance(t)) {
                return xm_B_handlers[i + 2];
            }
        }
        return -1;
    }

    protected static void C(boolean z) {
        xm_CState st = new xm_CState();
        st.v1i = (z ? 1 : 0);
        xm_C_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_C_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_CState {
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

    private static void xm_C_run(xm_CState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 6) {
                done = xm_C_c0(st);
            }
            else {
                done = xm_C_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_C_c0(xm_CState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        if (st.v1i == 0) {
                            st.pc = 2;
                            continue;
                        }
                    case 1:
                        st.pc = 1;
                        return true;
                    case 2:
                        st.pc = 2;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.v0o = "compiler assert failed";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v1o = new luaj.d((java.lang.String) st.v0o);
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        throw (java.lang.Throwable) st.v1o;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_C_handler(st.pc, t);
            if (h < 0) {
                xm_C_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_C_ctypes = {
    };
    private static final int[] xm_C_handlers = {
        
    };
    private static int xm_C_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_C_handlers.length; i += 4) {
            if (pc < xm_C_handlers[i] || pc >= xm_C_handlers[i + 1]) {
                continue;
            }
            int ti = xm_C_handlers[i + 3];
            if (ti < 0 || xm_C_ctypes[ti].isInstance(t)) {
                return xm_C_handlers[i + 2];
            }
        }
        return -1;
    }

    static g$f[] D(g$f[] g_fArr, int i) {
        xm_DState st = new xm_DState();
        st.v2o = g_fArr;
        st.v3i = i;
        return xm_D_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_D_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_DState {
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
    }

    private static g$f[] xm_D_run(xm_DState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 11) {
                done = xm_D_c0(st);
            }
            else {
                done = xm_D_c0(st);
            }
            if (done) {
                return (g$f[]) st.resultO;
            }
        }
    }

    private static boolean xm_D_c0(xm_DState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 2;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o != null) {
                            st.pc = 4;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v2o = new gg_g.g$f[st.v0i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.pc = 10;
                        continue;
                    case 4:
                        st.pc = 4;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v1i >= st.v3i) {
                            st.pc = 10;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.v3i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.v3i = st.v3i * 2;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpO = gg_g.a.I((gg_g.g$f[]) st.v2o, st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 9:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
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
            int h = xm_D_handler(st.pc, t);
            if (h < 0) {
                xm_D_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_D_ctypes = {
    };
    private static final int[] xm_D_handlers = {
        
    };
    private static int xm_D_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_D_handlers.length; i += 4) {
            if (pc < xm_D_handlers[i] || pc >= xm_D_handlers[i + 1]) {
                continue;
            }
            int ti = xm_D_handlers[i + 3];
            if (ti < 0 || xm_D_ctypes[ti].isInstance(t)) {
                return xm_D_handlers[i + 2];
            }
        }
        return -1;
    }

    static char[] E(char[] cArr, int i) {
        xm_EState st = new xm_EState();
        st.v2o = cArr;
        st.v3i = i;
        return xm_E_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_E_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_EState {
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

    private static char[] xm_E_run(xm_EState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_E_c0(st);
            }
            else {
                done = xm_E_c0(st);
            }
            if (done) {
                return (char[]) st.resultO;
            }
        }
    }

    private static boolean xm_E_c0(xm_EState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new char[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_E_handler(st.pc, t);
            if (h < 0) {
                xm_E_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_E_ctypes = {
    };
    private static final int[] xm_E_handlers = {
        
    };
    private static int xm_E_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_E_handlers.length; i += 4) {
            if (pc < xm_E_handlers[i] || pc >= xm_E_handlers[i + 1]) {
                continue;
            }
            int ti = xm_E_handlers[i + 3];
            if (ti < 0 || xm_E_ctypes[ti].isInstance(t)) {
                return xm_E_handlers[i + 2];
            }
        }
        return -1;
    }

    static int[] F(int[] iArr, int i) {
        xm_FState st = new xm_FState();
        st.v2o = iArr;
        st.v3i = i;
        return xm_F_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_F_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_FState {
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

    private static int[] xm_F_run(xm_FState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_F_c0(st);
            }
            else {
                done = xm_F_c0(st);
            }
            if (done) {
                return (int[]) st.resultO;
            }
        }
    }

    private static boolean xm_F_c0(xm_FState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new int[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_F_handler(st.pc, t);
            if (h < 0) {
                xm_F_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_F_ctypes = {
    };
    private static final int[] xm_F_handlers = {
        
    };
    private static int xm_F_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_F_handlers.length; i += 4) {
            if (pc < xm_F_handlers[i] || pc >= xm_F_handlers[i + 1]) {
                continue;
            }
            int ti = xm_F_handlers[i + 3];
            if (ti < 0 || xm_F_ctypes[ti].isInstance(t)) {
                return xm_F_handlers[i + 2];
            }
        }
        return -1;
    }

    static gg_f.b[] G(gg_f.b[] bVarArr, int i) {
        xm_GState st = new xm_GState();
        st.v2o = bVarArr;
        st.v3i = i;
        return xm_G_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_G_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_GState {
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

    private static gg_f.b[] xm_G_run(xm_GState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_G_c0(st);
            }
            else {
                done = xm_G_c0(st);
            }
            if (done) {
                return (gg_f.b[]) st.resultO;
            }
        }
    }

    private static boolean xm_G_c0(xm_GState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new gg_f.b[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_G_handler(st.pc, t);
            if (h < 0) {
                xm_G_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_G_ctypes = {
    };
    private static final int[] xm_G_handlers = {
        
    };
    private static int xm_G_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_G_handlers.length; i += 4) {
            if (pc < xm_G_handlers[i] || pc >= xm_G_handlers[i + 1]) {
                continue;
            }
            int ti = xm_G_handlers[i + 3];
            if (ti < 0 || xm_G_ctypes[ti].isInstance(t)) {
                return xm_G_handlers[i + 2];
            }
        }
        return -1;
    }

    static gg_f.d[] H(gg_f.d[] dVarArr, int i) {
        xm_HState st = new xm_HState();
        st.v2o = dVarArr;
        st.v3i = i;
        return xm_H_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_H_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_HState {
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

    private static gg_f.d[] xm_H_run(xm_HState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_H_c0(st);
            }
            else {
                done = xm_H_c0(st);
            }
            if (done) {
                return (gg_f.d[]) st.resultO;
            }
        }
    }

    private static boolean xm_H_c0(xm_HState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new gg_f.d[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_H_handler(st.pc, t);
            if (h < 0) {
                xm_H_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_H_ctypes = {
    };
    private static final int[] xm_H_handlers = {
        
    };
    private static int xm_H_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_H_handlers.length; i += 4) {
            if (pc < xm_H_handlers[i] || pc >= xm_H_handlers[i + 1]) {
                continue;
            }
            int ti = xm_H_handlers[i + 3];
            if (ti < 0 || xm_H_ctypes[ti].isInstance(t)) {
                return xm_H_handlers[i + 2];
            }
        }
        return -1;
    }

    static g$f[] I(g$f[] g_fArr, int i) {
        xm_IState st = new xm_IState();
        st.v2o = g_fArr;
        st.v3i = i;
        return xm_I_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_I_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_IState {
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

    private static g$f[] xm_I_run(xm_IState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_I_c0(st);
            }
            else {
                done = xm_I_c0(st);
            }
            if (done) {
                return (g$f[]) st.resultO;
            }
        }
    }

    private static boolean xm_I_c0(xm_IState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new gg_g.g$f[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_I_handler(st.pc, t);
            if (h < 0) {
                xm_I_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_I_ctypes = {
    };
    private static final int[] xm_I_handlers = {
        
    };
    private static int xm_I_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_I_handlers.length; i += 4) {
            if (pc < xm_I_handlers[i] || pc >= xm_I_handlers[i + 1]) {
                continue;
            }
            int ti = xm_I_handlers[i + 3];
            if (ti < 0 || xm_I_ctypes[ti].isInstance(t)) {
                return xm_I_handlers[i + 2];
            }
        }
        return -1;
    }

    static g$j[] J(g$j[] g_jArr, int i) {
        xm_JState st = new xm_JState();
        st.v2o = g_jArr;
        st.v3i = i;
        return xm_J_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_J_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_JState {
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

    private static g$j[] xm_J_run(xm_JState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_J_c0(st);
            }
            else {
                done = xm_J_c0(st);
            }
            if (done) {
                return (g$j[]) st.resultO;
            }
        }
    }

    private static boolean xm_J_c0(xm_JState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new gg_g.g$j[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_J_handler(st.pc, t);
            if (h < 0) {
                xm_J_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_J_ctypes = {
    };
    private static final int[] xm_J_handlers = {
        
    };
    private static int xm_J_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_J_handlers.length; i += 4) {
            if (pc < xm_J_handlers[i] || pc >= xm_J_handlers[i + 1]) {
                continue;
            }
            int ti = xm_J_handlers[i + 3];
            if (ti < 0 || xm_J_ctypes[ti].isInstance(t)) {
                return xm_J_handlers[i + 2];
            }
        }
        return -1;
    }

    static luaj.LuaValue[] K(luaj.LuaValue[] luaValueArr, int i) {
        xm_KState st = new xm_KState();
        st.v2o = luaValueArr;
        st.v3i = i;
        return xm_K_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_K_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_KState {
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

    private static luaj.LuaValue[] xm_K_run(xm_KState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_K_c0(st);
            }
            else {
                done = xm_K_c0(st);
            }
            if (done) {
                return (luaj.LuaValue[]) st.resultO;
            }
        }
    }

    private static boolean xm_K_c0(xm_KState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new luaj.LuaValue[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_K_handler(st.pc, t);
            if (h < 0) {
                xm_K_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_K_ctypes = {
    };
    private static final int[] xm_K_handlers = {
        
    };
    private static int xm_K_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_K_handlers.length; i += 4) {
            if (pc < xm_K_handlers[i] || pc >= xm_K_handlers[i + 1]) {
                continue;
            }
            int ti = xm_K_handlers[i + 3];
            if (ti < 0 || xm_K_ctypes[ti].isInstance(t)) {
                return xm_K_handlers[i + 2];
            }
        }
        return -1;
    }

    static luaj.h[] L(luaj.h[] hVarArr, int i) {
        xm_LState st = new xm_LState();
        st.v2o = hVarArr;
        st.v3i = i;
        return xm_L_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_L_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_LState {
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

    private static luaj.h[] xm_L_run(xm_LState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_L_c0(st);
            }
            else {
                done = xm_L_c0(st);
            }
            if (done) {
                return (luaj.h[]) st.resultO;
            }
        }
    }

    private static boolean xm_L_c0(xm_LState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = new luaj.h[st.v3i];
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2o == null) {
                            st.pc = 7;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = java.lang.reflect.Array.getLength(st.v2o);
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = java.lang.Math.min(st.v1i, st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        java.lang.System.arraycopy(st.v2o, st.v1i, st.v0o, st.v1i, st.v3i);
                    case 7:
                        st.pc = 7;
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
            int h = xm_L_handler(st.pc, t);
            if (h < 0) {
                xm_L_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_L_ctypes = {
    };
    private static final int[] xm_L_handlers = {
        
    };
    private static int xm_L_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_L_handlers.length; i += 4) {
            if (pc < xm_L_handlers[i] || pc >= xm_L_handlers[i + 1]) {
                continue;
            }
            int ti = xm_L_handlers[i + 3];
            if (ti < 0 || xm_L_ctypes[ti].isInstance(t)) {
                return xm_L_handlers[i + 2];
            }
        }
        return -1;
    }

    public static int s(int i, int i2, int i3, int i4) {
        xm_sState st = new xm_sState();
        st.v0i = i;
        st.v1i = i2;
        st.v2i = i3;
        st.v3i = i4;
        return xm_s_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_s_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_sState {
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
    }

    private static int xm_s_run(xm_sState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 13) {
                done = xm_s_c0(st);
            }
            else {
                done = xm_s_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_s_c0(xm_sState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = st.v0i & 63;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = st.v1i << 6;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v1i = st.v1i & 16320;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v0i = st.v0i | st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.v1i = st.v2i << 23;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.v2i = 0xff800000;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.v1i = st.v1i & st.v2i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 7:
                        st.v0i = st.v0i | st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 8:
                        st.v1i = st.v3i << 14;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.v2i = 8372224;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 10:
                        st.v1i = st.v1i & st.v2i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 11:
                        st.v0i = st.v0i | st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 12:
                        st.pc = 12;
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
            int h = xm_s_handler(st.pc, t);
            if (h < 0) {
                xm_s_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_s_ctypes = {
    };
    private static final int[] xm_s_handlers = {
        
    };
    private static int xm_s_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_s_handlers.length; i += 4) {
            if (pc < xm_s_handlers[i] || pc >= xm_s_handlers[i + 1]) {
                continue;
            }
            int ti = xm_s_handlers[i + 3];
            if (ti < 0 || xm_s_ctypes[ti].isInstance(t)) {
                return xm_s_handlers[i + 2];
            }
        }
        return -1;
    }

    public static int t(int i, int i2, int i3) {
        xm_tState st = new xm_tState();
        st.v0i = i;
        st.v1i = i2;
        st.v2i = i3;
        return xm_t_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_t_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_tState {
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
    }

    private static int xm_t_run(xm_tState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_t_c0(st);
            }
            else {
                done = xm_t_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_t_c0(xm_tState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = st.v0i & 63;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = st.v1i << 6;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v1i = st.v1i & 16320;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v0i = st.v0i | st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.v1i = st.v2i << 14;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.v1i = st.v1i & 0xffffc000;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.v0i = st.v0i | st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
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
            int h = xm_t_handler(st.pc, t);
            if (h < 0) {
                xm_t_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_t_ctypes = {
    };
    private static final int[] xm_t_handlers = {
        
    };
    private static int xm_t_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_t_handlers.length; i += 4) {
            if (pc < xm_t_handlers[i] || pc >= xm_t_handlers[i + 1]) {
                continue;
            }
            int ti = xm_t_handlers[i + 3];
            if (ti < 0 || xm_t_ctypes[ti].isInstance(t)) {
                return xm_t_handlers[i + 2];
            }
        }
        return -1;
    }

    public static int u(int i, int i2) {
        xm_uState st = new xm_uState();
        st.v0i = i;
        st.v1i = i2;
        return xm_u_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_u_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_uState {
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

    private static int xm_u_run(xm_uState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_u_c0(st);
            }
            else {
                done = xm_u_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_u_c0(xm_uState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = st.v0i & 63;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = st.v1i << 6;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v1i = st.v1i & 0xffffffc0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v0i = st.v0i | st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
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
            int h = xm_u_handler(st.pc, t);
            if (h < 0) {
                xm_u_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_u_ctypes = {
    };
    private static final int[] xm_u_handlers = {
        
    };
    private static int xm_u_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_u_handlers.length; i += 4) {
            if (pc < xm_u_handlers[i] || pc >= xm_u_handlers[i + 1]) {
                continue;
            }
            int ti = xm_u_handlers[i + 3];
            if (ti < 0 || xm_u_ctypes[ti].isInstance(t)) {
                return xm_u_handlers[i + 2];
            }
        }
        return -1;
    }

    public static void v(d dVar, int i) {
        xm_vState st = new xm_vState();
        st.v1o = dVar;
        st.v2i = i;
        xm_v_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_v_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_vState {
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

    private static void xm_v_run(xm_vState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_v_c0(st);
            }
            else {
                done = xm_v_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_v_c0(xm_vState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((gg_g.d) st.v1o).a();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v0i = st.v0i & 0xffffc03f;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.v2i = st.v2i << 6;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.v2i = st.v2i & 16320;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.v2i = st.v2i | st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        ((gg_g.d) st.v1o).b(st.v2i);
                    case 7:
                        st.pc = 7;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_v_handler(st.pc, t);
            if (h < 0) {
                xm_v_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_v_ctypes = {
    };
    private static final int[] xm_v_handlers = {
        
    };
    private static int xm_v_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_v_handlers.length; i += 4) {
            if (pc < xm_v_handlers[i] || pc >= xm_v_handlers[i + 1]) {
                continue;
            }
            int ti = xm_v_handlers[i + 3];
            if (ti < 0 || xm_v_ctypes[ti].isInstance(t)) {
                return xm_v_handlers[i + 2];
            }
        }
        return -1;
    }

    public static void w(int[] iArr, int i, int i2) {
        xm_wState st = new xm_wState();
        st.v1o = iArr;
        st.v2i = i;
        st.v3i = i2;
        xm_w_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_w_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_wState {
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
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static void xm_w_run(xm_wState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 7) {
                done = xm_w_c0(st);
            }
            else {
                done = xm_w_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_w_c0(xm_wState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((int[]) st.v1o)[st.v2i];
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v0i = st.v0i & 0xffffc03f;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v3i = st.v3i << 6;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 3:
                        st.v3i = st.v3i & 16320;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 4:
                        st.v3i = st.v3i | st.v0i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.pc = 5;
                        ((int[]) st.v1o)[st.v2i] = st.v3i;
                    case 6:
                        st.pc = 6;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_w_handler(st.pc, t);
            if (h < 0) {
                xm_w_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_w_ctypes = {
    };
    private static final int[] xm_w_handlers = {
        
    };
    private static int xm_w_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_w_handlers.length; i += 4) {
            if (pc < xm_w_handlers[i] || pc >= xm_w_handlers[i + 1]) {
                continue;
            }
            int ti = xm_w_handlers[i + 3];
            if (ti < 0 || xm_w_ctypes[ti].isInstance(t)) {
                return xm_w_handlers[i + 2];
            }
        }
        return -1;
    }

    public static void x(d dVar, int i) {
        xm_xState st = new xm_xState();
        st.v2o = dVar;
        st.v3i = i;
        xm_x_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_x_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_xState {
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

    private static void xm_x_run(xm_xState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 10) {
                done = xm_x_c0(st);
            }
            else {
                done = xm_x_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_x_c0(xm_xState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((gg_g.d) st.v2o).a();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 8388607;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v0i = st.v0i & st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.v3i = st.v3i << 23;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 0xff800000;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.v3i = st.v3i & st.v1i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.v3i = st.v3i | st.v0i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        ((gg_g.d) st.v2o).b(st.v3i);
                    case 9:
                        st.pc = 9;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_x_handler(st.pc, t);
            if (h < 0) {
                xm_x_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_x_ctypes = {
    };
    private static final int[] xm_x_handlers = {
        
    };
    private static int xm_x_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_x_handlers.length; i += 4) {
            if (pc < xm_x_handlers[i] || pc >= xm_x_handlers[i + 1]) {
                continue;
            }
            int ti = xm_x_handlers[i + 3];
            if (ti < 0 || xm_x_ctypes[ti].isInstance(t)) {
                return xm_x_handlers[i + 2];
            }
        }
        return -1;
    }

    public static void y(d dVar, int i) {
        xm_yState st = new xm_yState();
        st.v1o = dVar;
        st.v2i = i;
        xm_y_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_y_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_yState {
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

    private static void xm_y_run(xm_yState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 8) {
                done = xm_y_c0(st);
            }
            else {
                done = xm_y_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_y_c0(xm_yState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((gg_g.d) st.v1o).a();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v0i = st.v0i & 16383;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.v2i = st.v2i << 14;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.v2i = st.v2i & 0xffffc000;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.v2i = st.v2i | st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        ((gg_g.d) st.v1o).b(st.v2i);
                    case 7:
                        st.pc = 7;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_y_handler(st.pc, t);
            if (h < 0) {
                xm_y_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_y_ctypes = {
    };
    private static final int[] xm_y_handlers = {
        
    };
    private static int xm_y_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_y_handlers.length; i += 4) {
            if (pc < xm_y_handlers[i] || pc >= xm_y_handlers[i + 1]) {
                continue;
            }
            int ti = xm_y_handlers[i + 3];
            if (ti < 0 || xm_y_ctypes[ti].isInstance(t)) {
                return xm_y_handlers[i + 2];
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------- *
     *  .method public static z(Lgg_g/d;I)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public static void z(d dVar, int i) {
        xm_zState st = new xm_zState();
        st.v2o = dVar;
        st.v3i = i;
        xm_z_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_z_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_zState {
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

    private static void xm_z_run(xm_zState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 10) {
                done = xm_z_c0(st);
            }
            else {
                done = xm_z_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_z_c0(xm_zState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((gg_g.d) st.v2o).a();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 0xff803fff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v0i = st.v0i & st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.v3i = st.v3i << 14;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.v1i = 8372224;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.v3i = st.v3i & st.v1i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.v3i = st.v3i | st.v0i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        ((gg_g.d) st.v2o).b(st.v3i);
                    case 9:
                        st.pc = 9;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_z_handler(st.pc, t);
            if (h < 0) {
                xm_z_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_z_ctypes = {
    };
    private static final int[] xm_z_handlers = {
        
    };
    private static int xm_z_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_z_handlers.length; i += 4) {
            if (pc < xm_z_handlers[i] || pc >= xm_z_handlers[i + 1]) {
                continue;
            }
            int ti = xm_z_handlers[i + 3];
            if (ti < 0 || xm_z_ctypes[ti].isInstance(t)) {
                return xm_z_handlers[i + 2];
            }
        }
        return -1;
    }
}

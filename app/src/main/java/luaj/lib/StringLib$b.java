package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class StringLib$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final luaj.LuaString f1779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final luaj.LuaString f1780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final luaj.Varargs f1781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f1782e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int[] f1783f = new int[32];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f1784g = new int[32];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1778a = 200;

    StringLib$b(luaj.Varargs varargs, luaj.LuaString luaString, luaj.LuaString luaString2) {
        this.f1779b = luaString;
        this.f1780c = luaString2;
        this.f1781d = varargs;
    }

    private void a(gg_f.a aVar, luaj.LuaString luaString, int i, int i2) {
        xm_aState st = new xm_aState();
        st.v9o = this;
        st.v10o = aVar;
        st.v11o = luaString;
        st.v12i = i;
        st.v13i = i2;
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
        java.lang.Object v9o;
        java.lang.Object v10o;
        java.lang.Object v11o;
        int v12i;
        int v13i;
    }

    private static void xm_a_run(xm_aState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 68) {
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
                        st.tmpI = ((luaj.LuaString) st.v11o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v2i >= st.v0i) {
                            st.pc = 67;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.tmpI = ((luaj.LuaString) st.v11o).g3(st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.v3i = (byte) st.v3i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 8:
                        st.v4i = 37;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v3i == st.v4i) {
                            st.pc = 12;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((gg_f.a) st.v10o).a((byte) st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.pc = 11;
                        st.pc = 65;
                        continue;
                    case 12:
                        st.v3i = st.v2i + 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v3i >= st.v0i) {
                            st.pc = 17;
                            continue;
                        }
                    case 14:
                        st.pc = 14;
                        st.tmpI = ((luaj.LuaString) st.v11o).g3(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 15:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.pc = 18;
                        continue;
                    case 17:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 18:
                        st.v5i = (byte) st.v5i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 19:
                        st.v6i = (char) st.v5i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.tmpI = (java.lang.Character.isDigit((char) st.v6i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 22:
                        st.pc = 22;
                        if (st.v7i != 0) {
                            st.pc = 51;
                            continue;
                        }
                    case 23:
                        st.pc = 23;
                        if (st.v5i == st.v4i) {
                            st.pc = 49;
                            continue;
                        }
                    case 24:
                        st.pc = 24;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.v4o = new java.lang.StringBuilder();
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 26:
                        st.v7o = "invalid use of '%' in replacement string: after '%' must be '0'-'9' or '%', but found ";
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).append((java.lang.String) st.v7o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.pc = 28;
                        if (st.v3i >= st.v0i) {
                            st.pc = 44;
                            continue;
                        }
                    case 29:
                        st.pc = 29;
                        st.v7o = null;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.v7o = new java.lang.StringBuilder();
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 31:
                        st.v8o = "symbol '";
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.tmpO = ((java.lang.StringBuilder) st.v7o).append((java.lang.String) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 33:
                        st.pc = 33;
                        st.tmpO = ((java.lang.StringBuilder) st.v7o).append((char) st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 34:
                        st.v6o = "' with code ";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.tmpO = ((java.lang.StringBuilder) st.v7o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 36:
                        st.pc = 36;
                        st.tmpO = ((java.lang.StringBuilder) st.v7o).append(st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 37:
                        st.v6o = " at pos ";
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.tmpO = ((java.lang.StringBuilder) st.v7o).append((java.lang.String) st.v6o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 39:
                        st.v2i = st.v2i + 2;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 40:
                        st.pc = 40;
                        st.tmpO = ((java.lang.StringBuilder) st.v7o).append(st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 41:
                        st.pc = 41;
                        st.tmpO = ((java.lang.StringBuilder) st.v7o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 42:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 43:
                        st.pc = 43;
                        st.pc = 45;
                        continue;
                    case 44:
                        st.v2o = "end of string";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 45:
                        st.pc = 45;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 46:
                        st.pc = 46;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 47:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 48:
                        st.pc = 48;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 49:
                        st.pc = 49;
                        st.tmpO = ((gg_f.a) st.v10o).a((byte) st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 50:
                        st.pc = 50;
                        st.pc = 64;
                        continue;
                    case 51:
                        st.v2i = 48;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 52:
                        st.pc = 52;
                        if (st.v5i != st.v2i) {
                            st.pc = 58;
                            continue;
                        }
                    case 53:
                        st.pc = 53;
                        st.v2o = ((luaj.lib.StringLib$b) st.v9o).f1779b;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.tmpO = ((luaj.LuaString) st.v2o).j3(st.v12i, st.v13i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 55:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 56:
                        st.pc = 56;
                        st.tmpO = ((gg_f.a) st.v10o).c((luaj.LuaString) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 57:
                        st.pc = 57;
                        st.pc = 64;
                        continue;
                    case 58:
                        st.v5i = st.v5i + 0xffffffcf;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 59:
                        st.pc = 59;
                        st.tmpO = ((luaj.lib.StringLib$b) st.v9o).o(st.v5i, st.v12i, st.v13i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 60:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 61:
                        st.pc = 61;
                        st.tmpO = ((luaj.LuaValue) st.v2o).q2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 62:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 63:
                        st.pc = 63;
                        st.pc = 56;
                        continue;
                    case 64:
                        st.v2i = st.v3i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 65:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 66:
                        st.pc = 66;
                        st.pc = 4;
                        continue;
                    case 67:
                        st.pc = 67;
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

    private int c() {
        xm_cState st = new xm_cState();
        st.v3o = this;
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
        java.lang.Object v3o;
    }

    private static int xm_c_run(xm_cState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 14) {
                done = xm_c_c0(st);
            }
            else {
                done = xm_c_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_c_c0(xm_cState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((luaj.lib.StringLib$b) st.v3o).f1782e;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.v0i = st.v0i + st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i < 0) {
                            st.pc = 10;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v2o = ((luaj.lib.StringLib$b) st.v3o).f1784g;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v2i = ((int[]) st.v2o)[st.v0i];
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v2i != st.v1i) {
                            st.pc = 8;
                            continue;
                        }
                    case 7:
                        st.pc = 7;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 8:
                        st.v0i = st.v0i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.pc = 3;
                        continue;
                    case 10:
                        st.v0o = "invalid pattern capture";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
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

    private int d(int i) {
        xm_dState st = new xm_dState();
        st.v3o = this;
        st.v4i = i;
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
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static int xm_d_run(xm_dState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 18) {
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
                        st.v0i = st.v4i + 0xffffffcf;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v0i < 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        st.v1i = ((luaj.lib.StringLib$b) st.v3o).f1782e;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i >= st.v1i) {
                            st.pc = 8;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v1o = ((luaj.lib.StringLib$b) st.v3o).f1784g;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v1i = ((int[]) st.v1o)[st.v0i];
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 6:
                        st.v2i = 0xffffffff;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v1i != st.v2i) {
                            st.pc = 17;
                            continue;
                        }
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
                        st.v2o = "invalid capture index %";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.v4i = st.v4i + 0xffffffd0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.pc = 17;
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

    /* JADX WARN: Code duplicated, block: B:29:0x003f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0041  */
    static boolean i(int i, int i2) {
        xm_iState st = new xm_iState();
        st.v5i = i;
        st.v6i = i2;
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
    }

    private static boolean xm_i_run(xm_iState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 73) {
                done = xm_i_c0(st);
            }
            else {
                done = xm_i_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_i_c0(xm_iState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = (char) st.v6i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = (int) java.lang.Character.toLowerCase((char) st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v1o = luaj.lib.StringLib.U;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v1i = ((byte[]) st.v1o)[st.v5i];
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.v2i = 97;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.v4i = 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v0i == st.v2i) {
                            st.pc = 64;
                            continue;
                        }
                    case 9:
                        st.v2i = 103;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v0i == st.v2i) {
                            st.pc = 61;
                            continue;
                        }
                    case 11:
                        st.v2i = 108;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v0i == st.v2i) {
                            st.pc = 58;
                            continue;
                        }
                    case 13:
                        st.v2i = 112;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v0i == st.v2i) {
                            st.pc = 55;
                            continue;
                        }
                    case 15:
                        st.v2i = 115;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 16:
                        st.pc = 16;
                        if (st.v0i == st.v2i) {
                            st.pc = 52;
                            continue;
                        }
                    case 17:
                        st.v2i = 117;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 18:
                        st.pc = 18;
                        if (st.v0i == st.v2i) {
                            st.pc = 49;
                            continue;
                        }
                    case 19:
                        st.v2i = 122;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 20:
                        st.pc = 20;
                        if (st.v0i == st.v2i) {
                            st.pc = 47;
                            continue;
                        }
                    case 21:
                        st.v2i = 99;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 22:
                        st.pc = 22;
                        if (st.v0i == st.v2i) {
                            st.pc = 44;
                            continue;
                        }
                    case 23:
                        st.v2i = 100;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 24:
                        st.pc = 24;
                        if (st.v0i == st.v2i) {
                            st.pc = 41;
                            continue;
                        }
                    case 25:
                        st.v2i = 119;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 26:
                        st.pc = 26;
                        if (st.v0i == st.v2i) {
                            st.pc = 38;
                            continue;
                        }
                    case 27:
                        st.v2i = 120;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 28:
                        st.pc = 28;
                        if (st.v0i == st.v2i) {
                            st.pc = 32;
                            continue;
                        }
                    case 29:
                        st.pc = 29;
                        if (st.v6i != st.v5i) {
                            st.pc = 31;
                            continue;
                        }
                    case 30:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.resultI = st.v3i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 32:
                        st.v5i = st.v1i & 0xffffff80;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 33:
                        st.pc = 33;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 34:
                        st.v5i = 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.pc = 67;
                        continue;
                    case 36:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.pc = 67;
                        continue;
                    case 38:
                        st.v5i = st.v1i & 9;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 39:
                        st.pc = 39;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 40:
                        st.pc = 40;
                        st.pc = 34;
                        continue;
                    case 41:
                        st.v5i = st.v1i & 8;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 42:
                        st.pc = 42;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 43:
                        st.pc = 43;
                        st.pc = 34;
                        continue;
                    case 44:
                        st.v5i = st.v1i & 64;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 45:
                        st.pc = 45;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 46:
                        st.pc = 46;
                        st.pc = 34;
                        continue;
                    case 47:
                        st.pc = 47;
                        if (st.v5i != 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 48:
                        st.pc = 48;
                        st.pc = 34;
                        continue;
                    case 49:
                        st.v5i = st.v1i & 4;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 50:
                        st.pc = 50;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 51:
                        st.pc = 51;
                        st.pc = 34;
                        continue;
                    case 52:
                        st.v5i = st.v1i & 32;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 53:
                        st.pc = 53;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 54:
                        st.pc = 54;
                        st.pc = 34;
                        continue;
                    case 55:
                        st.v5i = st.v1i & 16;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 56:
                        st.pc = 56;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 57:
                        st.pc = 57;
                        st.pc = 34;
                        continue;
                    case 58:
                        st.v5i = st.v1i & 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 59:
                        st.pc = 59;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 60:
                        st.pc = 60;
                        st.pc = 34;
                        continue;
                    case 61:
                        st.v5i = st.v1i & 25;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 62:
                        st.pc = 62;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 63:
                        st.pc = 63;
                        st.pc = 34;
                        continue;
                    case 64:
                        st.v5i = st.v1i & 1;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 65:
                        st.pc = 65;
                        if (st.v5i == 0) {
                            st.pc = 36;
                            continue;
                        }
                    case 66:
                        st.pc = 66;
                        st.pc = 34;
                        continue;
                    case 67:
                        st.pc = 67;
                        if (st.v0i != st.v6i) {
                            st.pc = 70;
                            continue;
                        }
                    case 68:
                        st.v3i = st.v5i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 69:
                        st.pc = 69;
                        st.pc = 72;
                        continue;
                    case 70:
                        st.pc = 70;
                        if (st.v5i != 0) {
                            st.pc = 72;
                            continue;
                        }
                    case 71:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 72:
                        st.pc = 72;
                        st.resultI = st.v3i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
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

    private luaj.LuaValue o(int i, int i2, int i3) {
        xm_oState st = new xm_oState();
        st.v1o = this;
        st.v2i = i;
        st.v3i = i2;
        st.v4i = i3;
        return xm_o_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_o_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_oState {
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
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
    }

    private static luaj.LuaValue xm_o_run(xm_oState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 42) {
                done = xm_o_c0(st);
            }
            else {
                done = xm_o_c0(st);
            }
            if (done) {
                return (luaj.LuaValue) st.resultO;
            }
        }
    }

    private static boolean xm_o_c0(xm_oState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((luaj.lib.StringLib$b) st.v1o).f1782e;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        if (st.v2i < st.v0i) {
                            st.pc = 18;
                            continue;
                        }
                    case 2:
                        st.pc = 2;
                        if (st.v2i != 0) {
                            st.pc = 7;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.v2o = ((luaj.lib.StringLib$b) st.v1o).f1779b;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpO = ((luaj.LuaString) st.v2o).j3(st.v3i, st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.resultO = st.v2o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 7:
                        st.pc = 7;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.v3o = new java.lang.StringBuilder();
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 9:
                        st.v4o = "invalid capture index %";
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).append(st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 13:
                        st.pc = 13;
                        st.tmpO = ((java.lang.StringBuilder) st.v3o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 14:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.resultO = st.v2o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 18:
                        st.pc = 18;
                        st.v3o = ((luaj.lib.StringLib$b) st.v1o).f1784g;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.v3i = ((int[]) st.v3o)[st.v2i];
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 20:
                        st.v4i = 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 21:
                        st.pc = 21;
                        if (st.v3i != st.v4i) {
                            st.pc = 26;
                            continue;
                        }
                    case 22:
                        st.v2o = "unfinished capture";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 24:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.resultO = st.v2o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 26:
                        st.v4i = 0xfffffffe;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 27:
                        st.pc = 27;
                        if (st.v3i != st.v4i) {
                            st.pc = 35;
                            continue;
                        }
                    case 28:
                        st.pc = 28;
                        st.v3o = ((luaj.lib.StringLib$b) st.v1o).f1783f;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v2i = ((int[]) st.v3o)[st.v2i];
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 30:
                        st.v2i = st.v2i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 31:
                        st.v2j = st.v2i;
                        st.v2d = java.lang.Double.longBitsToDouble(st.v2j);
                        st.v2i = 0;
                        st.v2o = null;
                    case 32:
                        st.pc = 32;
                        st.tmpO = luaj.LuaValue.I2(st.v2j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 33:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 34:
                        st.pc = 34;
                        st.resultO = st.v2o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 35:
                        st.pc = 35;
                        st.v4o = ((luaj.lib.StringLib$b) st.v1o).f1783f;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.v2i = ((int[]) st.v4o)[st.v2i];
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.v4o = ((luaj.lib.StringLib$b) st.v1o).f1779b;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 38:
                        st.v3i = st.v3i + st.v2i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.tmpO = ((luaj.LuaString) st.v4o).j3(st.v2i, st.v3i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 40:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 41:
                        st.pc = 41;
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
            int h = xm_o_handler(st.pc, t);
            if (h < 0) {
                xm_o_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_o_ctypes = {
    };
    private static final int[] xm_o_handlers = {
        
    };
    private static int xm_o_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_o_handlers.length; i += 4) {
            if (pc < xm_o_handlers[i] || pc >= xm_o_handlers[i + 1]) {
                continue;
            }
            int ti = xm_o_handlers[i + 3];
            if (ti < 0 || xm_o_ctypes[ti].isInstance(t)) {
                return xm_o_handlers[i + 2];
            }
        }
        return -1;
    }

    public void b(gg_f.a aVar, int i, int i2, luaj.LuaValue luaValue) {
        xm_bState st = new xm_bState();
        st.v2o = this;
        st.v3o = aVar;
        st.v4i = i;
        st.v5i = i2;
        st.v6o = luaValue;
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
    }

    private static void xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 56) {
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
                        st.tmpI = ((luaj.LuaValue) st.v6o).C2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.v1i = 3;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v0i == st.v1i) {
                            st.pc = 52;
                            continue;
                        }
                    case 4:
                        st.v1i = 4;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i == st.v1i) {
                            st.pc = 52;
                            continue;
                        }
                    case 6:
                        st.v1i = 5;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i == st.v1i) {
                            st.pc = 21;
                            continue;
                        }
                    case 8:
                        st.v1i = 6;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v0i == st.v1i) {
                            st.pc = 13;
                            continue;
                        }
                    case 10:
                        st.v3o = "bad argument: string/function/table expected";
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v3o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 12:
                        st.pc = 12;
                        return true;
                    case 13:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpO = ((luaj.lib.StringLib$b) st.v2o).n((st.v0i != 0), st.v4i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 15:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.tmpO = ((luaj.LuaValue) st.v6o).invoke((luaj.Varargs) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 17:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((luaj.Varargs) st.v6o).w();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.pc = 26;
                        continue;
                    case 21:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((luaj.lib.StringLib$b) st.v2o).o(st.v0i, st.v4i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.tmpO = ((luaj.LuaValue) st.v6o).U0((luaj.LuaValue) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 25:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.tmpI = (((luaj.LuaValue) st.v6o).w2()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 27:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 28:
                        st.pc = 28;
                        if (st.v0i != 0) {
                            st.pc = 33;
                            continue;
                        }
                    case 29:
                        st.pc = 29;
                        st.v6o = ((luaj.lib.StringLib$b) st.v2o).f1779b;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.tmpO = ((luaj.LuaString) st.v6o).j3(st.v4i, st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 31:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.pc = 48;
                        continue;
                    case 33:
                        st.pc = 33;
                        st.tmpI = (((luaj.LuaValue) st.v6o).n1()) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 34:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 35:
                        st.pc = 35;
                        if (st.v4i != 0) {
                            st.pc = 48;
                            continue;
                        }
                    case 36:
                        st.pc = 36;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.v4o = new java.lang.StringBuilder();
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 38:
                        st.v5o = "invalid replacement value (a ";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 40:
                        st.pc = 40;
                        st.tmpO = ((luaj.LuaValue) st.v6o).D2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 41:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 43:
                        st.v5i = 41;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).append((char) st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 45:
                        st.pc = 45;
                        st.tmpO = ((java.lang.StringBuilder) st.v4o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 46:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 47:
                        st.pc = 47;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 48:
                        st.pc = 48;
                        st.tmpO = ((luaj.LuaValue) st.v6o).q2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 49:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 50:
                        st.pc = 50;
                        st.tmpO = ((gg_f.a) st.v3o).c((luaj.LuaString) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 51:
                        st.pc = 51;
                        return true;
                    case 52:
                        st.pc = 52;
                        st.tmpO = ((luaj.LuaValue) st.v6o).q2();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 53:
                        st.v6o = st.tmpO;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 54:
                        st.pc = 54;
                        ((luaj.lib.StringLib$b) st.v2o).a((gg_f.a) st.v3o, (luaj.LuaString) st.v6o, st.v4i, st.v5i);
                    case 55:
                        st.pc = 55;
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

    int e(int i) {
        xm_eState st = new xm_eState();
        st.v4o = this;
        st.v5i = i;
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

    private static int xm_e_run(xm_eState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 56) {
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
                        st.pc = 0;
                        st.v0o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = st.v5i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpI = ((luaj.LuaString) st.v0o).g3(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.v2i = 37;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i == st.v2i) {
                            st.pc = 48;
                            continue;
                        }
                    case 6:
                        st.v3i = 91;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i == st.v3i) {
                            st.pc = 9;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 9:
                        st.pc = 9;
                        st.v0o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.tmpI = ((luaj.LuaString) st.v0o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 11:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v1i == st.v0i) {
                            st.pc = 19;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        st.v0o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.tmpI = ((luaj.LuaString) st.v0o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 15:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 16:
                        st.v3i = 94;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.pc = 17;
                        if (st.v0i != st.v3i) {
                            st.pc = 19;
                            continue;
                        }
                    case 18:
                        st.v1i = st.v5i + 2;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.v5o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.tmpI = ((luaj.LuaString) st.v5o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 21:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 22:
                        st.pc = 22;
                        if (st.v1i != st.v5i) {
                            st.pc = 25;
                            continue;
                        }
                    case 23:
                        st.v5o = "malformed pattern (missing ']')";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 25:
                        st.pc = 25;
                        st.v5o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 26:
                        st.v0i = st.v1i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.tmpI = ((luaj.LuaString) st.v5o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 28:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 29:
                        st.pc = 29;
                        if (st.v5i != st.v2i) {
                            st.pc = 36;
                            continue;
                        }
                    case 30:
                        st.pc = 30;
                        st.v5o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.tmpI = ((luaj.LuaString) st.v5o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 32:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 33:
                        st.pc = 33;
                        if (st.v0i >= st.v5i) {
                            st.pc = 36;
                            continue;
                        }
                    case 34:
                        st.v1i = st.v1i + 2;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 35:
                        st.pc = 35;
                        st.pc = 37;
                        continue;
                    case 36:
                        st.v1i = st.v0i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.v5o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.tmpI = ((luaj.LuaString) st.v5o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 39:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 40:
                        st.pc = 40;
                        if (st.v1i == st.v5i) {
                            st.pc = 19;
                            continue;
                        }
                    case 41:
                        st.pc = 41;
                        st.v5o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.tmpI = ((luaj.LuaString) st.v5o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 43:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 44:
                        st.v0i = 93;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 45:
                        st.pc = 45;
                        if (st.v5i != st.v0i) {
                            st.pc = 19;
                            continue;
                        }
                    case 46:
                        st.v1i = st.v1i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 47:
                        st.pc = 47;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 48:
                        st.pc = 48;
                        st.v0o = ((luaj.lib.StringLib$b) st.v4o).f1780c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 49:
                        st.pc = 49;
                        st.tmpI = ((luaj.LuaString) st.v0o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 50:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 51:
                        st.pc = 51;
                        if (st.v1i != st.v0i) {
                            st.pc = 54;
                            continue;
                        }
                    case 52:
                        st.v0o = "malformed pattern (ends with '%')";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 53:
                        st.pc = 53;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 54:
                        st.v5i = st.v5i + 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 55:
                        st.pc = 55;
                        st.resultI = st.v5i;
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

    int f(int i, int i2) {
        xm_fState st = new xm_fState();
        st.v3o = this;
        st.v4i = i;
        st.v5i = i2;
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
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static int xm_f_run(xm_fState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 14) {
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
                        st.tmpI = ((luaj.lib.StringLib$b) st.v3o).c();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1o = ((luaj.lib.StringLib$b) st.v3o).f1784g;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v2o = ((luaj.lib.StringLib$b) st.v3o).f1783f;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v2i = ((int[]) st.v2o)[st.v0i];
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.v2i = st.v4i - st.v2i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 6:
                        st.pc = 6;
                        ((int[]) st.v1o)[st.v0i] = st.v2i;
                    case 7:
                        st.pc = 7;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v3o).g(st.v4i, st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 8:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 9:
                        st.v5i = 0xffffffff;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v4i != st.v5i) {
                            st.pc = 13;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.v1o = ((luaj.lib.StringLib$b) st.v3o).f1784g;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 12:
                        st.pc = 12;
                        ((int[]) st.v1o)[st.v0i] = st.v5i;
                    case 13:
                        st.pc = 13;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
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

    /* JADX WARN: Code duplicated, block: B:113:0x016f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0166 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x014a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0145 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x0143 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:76:0x0124  */
    /* JADX WARN: Code duplicated, block: B:79:0x012d A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:6:0x000e, B:10:0x001c, B:71:0x010a, B:73:0x0116, B:77:0x0125, B:79:0x012d, B:90:0x0147, B:92:0x014c, B:97:0x0160, B:99:0x0168, B:100:0x016f, B:18:0x0036, B:21:0x003f, B:23:0x0049, B:25:0x0051, B:26:0x0059, B:27:0x005e, B:29:0x0068, B:30:0x006d, B:34:0x007b, B:36:0x0088, B:41:0x0096, B:42:0x009c, B:44:0x00a6, B:47:0x00b5, B:51:0x00c5, B:55:0x00d4, B:57:0x00dc, B:54:0x00ce, B:50:0x00bd, B:46:0x00b0, B:61:0x00e6, B:64:0x00ef, B:65:0x00f3, B:67:0x00fd), top: B:104:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0137  */
    /* JADX WARN: Code duplicated, block: B:84:0x013b  */
    /* JADX WARN: Code duplicated, block: B:86:0x013f  */
    /* JADX WARN: Code duplicated, block: B:90:0x0147 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:6:0x000e, B:10:0x001c, B:71:0x010a, B:73:0x0116, B:77:0x0125, B:79:0x012d, B:90:0x0147, B:92:0x014c, B:97:0x0160, B:99:0x0168, B:100:0x016f, B:18:0x0036, B:21:0x003f, B:23:0x0049, B:25:0x0051, B:26:0x0059, B:27:0x005e, B:29:0x0068, B:30:0x006d, B:34:0x007b, B:36:0x0088, B:41:0x0096, B:42:0x009c, B:44:0x00a6, B:47:0x00b5, B:51:0x00c5, B:55:0x00d4, B:57:0x00dc, B:54:0x00ce, B:50:0x00bd, B:46:0x00b0, B:61:0x00e6, B:64:0x00ef, B:65:0x00f3, B:67:0x00fd), top: B:104:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:99:0x0168 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:6:0x000e, B:10:0x001c, B:71:0x010a, B:73:0x0116, B:77:0x0125, B:79:0x012d, B:90:0x0147, B:92:0x014c, B:97:0x0160, B:99:0x0168, B:100:0x016f, B:18:0x0036, B:21:0x003f, B:23:0x0049, B:25:0x0051, B:26:0x0059, B:27:0x005e, B:29:0x0068, B:30:0x006d, B:34:0x007b, B:36:0x0088, B:41:0x0096, B:42:0x009c, B:44:0x00a6, B:47:0x00b5, B:51:0x00c5, B:55:0x00d4, B:57:0x00dc, B:54:0x00ce, B:50:0x00bd, B:46:0x00b0, B:61:0x00e6, B:64:0x00ef, B:65:0x00f3, B:67:0x00fd), top: B:104:0x000e }] */
    int g(int i, int i2) {
        xm_gState st = new xm_gState();
        st.v6o = this;
        st.v7i = i;
        st.v8i = i2;
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
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        java.lang.Object v6o;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private static int xm_g_run(xm_gState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 203) {
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
                        st.pc = 0;
                        st.v0i = ((luaj.lib.StringLib$b) st.v6o).f1778a;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = st.v0i + 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        ((luaj.lib.StringLib$b) st.v6o).f1778a = st.v1i;
                    case 3:
                        st.pc = 3;
                        if (st.v0i != 0) {
                            st.pc = 6;
                            continue;
                        }
                    case 4:
                        st.v0o = "pattern too complex";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 6:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.v1o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        st.tmpI = ((luaj.LuaString) st.v1o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 9:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v8i != st.v1i) {
                            st.pc = 15;
                            continue;
                        }
                    case 11:
                        st.pc = 11;
                        st.v8i = ((luaj.lib.StringLib$b) st.v6o).f1778a;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 12:
                        st.v8i = st.v8i + st.v0i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 13:
                        st.pc = 13;
                        ((luaj.lib.StringLib$b) st.v6o).f1778a = st.v8i;
                    case 14:
                        st.pc = 14;
                        st.resultI = st.v7i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 15:
                        st.pc = 15;
                        st.v1o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.tmpI = ((luaj.LuaString) st.v1o).g3(st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 17:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 18:
                        st.v2i = 36;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 19:
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 20:
                        st.v4i = 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 21:
                        st.pc = 21;
                        if (st.v1i == st.v2i) {
                            st.pc = 130;
                            continue;
                        }
                    case 22:
                        st.v2i = 37;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 23:
                        st.pc = 23;
                        if (st.v1i == st.v2i) {
                            st.pc = 52;
                            continue;
                        }
                    case 24:
                        st.v2i = 40;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 25:
                        st.v5i = 41;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 26:
                        st.pc = 26;
                        if (st.v1i == st.v2i) {
                            st.pc = 35;
                            continue;
                        }
                    case 27:
                        st.pc = 27;
                        if (st.v1i == st.v5i) {
                            st.pc = 29;
                            continue;
                        }
                    case 28:
                        st.pc = 28;
                        st.pc = 142;
                        continue;
                    case 29:
                        st.v8i = st.v8i + st.v0i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).f(st.v7i, st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 31:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.pc = 11;
                        continue;
                    case 33:
                        st.pc = 33;
                        st.v7o = st.ex;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 34:
                        st.pc = 34;
                        st.pc = 199;
                        continue;
                    case 35:
                        st.v1i = st.v8i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.tmpI = ((luaj.LuaString) st.v2o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 38:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 39:
                        st.pc = 39;
                        if (st.v1i >= st.v2i) {
                            st.pc = 49;
                            continue;
                        }
                    case 40:
                        st.pc = 40;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 41:
                        st.pc = 41;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 42:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 43:
                        st.pc = 43;
                        if (st.v2i != st.v5i) {
                            st.pc = 49;
                            continue;
                        }
                    case 44:
                        st.v8i = st.v8i + 2;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 45:
                        st.v1i = 0xfffffffe;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).r(st.v7i, st.v8i, st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 47:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 48:
                        st.pc = 48;
                        st.pc = 11;
                        continue;
                    case 49:
                        st.pc = 49;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).r(st.v7i, st.v1i, st.v4i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 50:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 51:
                        st.pc = 51;
                        st.pc = 11;
                        continue;
                    case 52:
                        st.v1i = st.v8i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 53:
                        st.pc = 53;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.tmpI = ((luaj.LuaString) st.v2o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 55:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 56:
                        st.pc = 56;
                        if (st.v1i != st.v2i) {
                            st.pc = 59;
                            continue;
                        }
                    case 57:
                        st.v2o = "malformed pattern (ends with '%')";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 58:
                        st.pc = 58;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 59:
                        st.pc = 59;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 60:
                        st.pc = 60;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 61:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 62:
                        st.v5i = 98;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 63:
                        st.pc = 63;
                        if (st.v2i == st.v5i) {
                            st.pc = 123;
                            continue;
                        }
                    case 64:
                        st.v5i = 102;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 65:
                        st.pc = 65;
                        if (st.v2i == st.v5i) {
                            st.pc = 84;
                            continue;
                        }
                    case 66:
                        st.pc = 66;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 67:
                        st.pc = 67;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 68:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 69:
                        st.v2i = (char) st.v1i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 70:
                        st.pc = 70;
                        st.tmpI = (java.lang.Character.isDigit((char) st.v2i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 71:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 72:
                        st.pc = 72;
                        if (st.v2i == 0) {
                            st.pc = 130;
                            continue;
                        }
                    case 73:
                        st.pc = 73;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).h(st.v7i, st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 74:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 75:
                        st.pc = 75;
                        if (st.v7i != st.v4i) {
                            st.pc = 80;
                            continue;
                        }
                    case 76:
                        st.pc = 76;
                        st.v7i = ((luaj.lib.StringLib$b) st.v6o).f1778a;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 77:
                        st.v7i = st.v7i + st.v0i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 78:
                        st.pc = 78;
                        ((luaj.lib.StringLib$b) st.v6o).f1778a = st.v7i;
                    case 79:
                        st.pc = 79;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 80:
                        st.v8i = st.v8i + 2;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 81:
                        st.pc = 81;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).g(st.v7i, st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 82:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 83:
                        st.pc = 83;
                        st.pc = 11;
                        continue;
                    case 84:
                        st.v8i = st.v8i + 2;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 85:
                        st.pc = 85;
                        st.v1o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 86:
                        st.pc = 86;
                        st.tmpI = ((luaj.LuaString) st.v1o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 87:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 88:
                        st.pc = 88;
                        if (st.v8i == st.v1i) {
                            st.pc = 94;
                            continue;
                        }
                    case 89:
                        st.pc = 89;
                        st.v1o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 90:
                        st.pc = 90;
                        st.tmpI = ((luaj.LuaString) st.v1o).g3(st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 91:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 92:
                        st.v2i = 91;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 93:
                        st.pc = 93;
                        if (st.v1i == st.v2i) {
                            st.pc = 96;
                            continue;
                        }
                    case 94:
                        st.v1o = "missing '[' after '%f' in pattern";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 95:
                        st.pc = 95;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 96:
                        st.pc = 96;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).e(st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 97:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 98:
                        st.pc = 98;
                        if (st.v7i != 0) {
                            st.pc = 101;
                            continue;
                        }
                    case 99:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 100:
                        st.pc = 100;
                        st.pc = 105;
                        continue;
                    case 101:
                        st.pc = 101;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 102:
                        st.v5i = st.v7i + 0xffffffff;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 103:
                        st.pc = 103;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 104:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 105:
                        st.pc = 105;
                        st.v5o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 106:
                        st.pc = 106;
                        st.tmpI = ((luaj.LuaString) st.v5o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 107:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 108:
                        st.pc = 108;
                        if (st.v7i != st.v5i) {
                            st.pc = 110;
                            continue;
                        }
                    case 109:
                        st.pc = 109;
                        st.pc = 113;
                        continue;
                    case 110:
                        st.pc = 110;
                        st.v3o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 111:
                        st.pc = 111;
                        st.tmpI = ((luaj.LuaString) st.v3o).g3(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 112:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 113:
                        st.v5i = st.v1i + 0xffffffff;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 114:
                        st.pc = 114;
                        st.tmpI = (((luaj.lib.StringLib$b) st.v6o).k(st.v2i, st.v8i, st.v5i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 115:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 116:
                        st.pc = 116;
                        if (st.v2i != 0) {
                            st.pc = 76;
                            continue;
                        }
                    case 117:
                        st.pc = 117;
                        st.tmpI = (((luaj.lib.StringLib$b) st.v6o).k(st.v3i, st.v8i, st.v5i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 118:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 119:
                        st.pc = 119;
                        if (st.v8i != 0) {
                            st.pc = 121;
                            continue;
                        }
                    case 120:
                        st.pc = 120;
                        st.pc = 76;
                        continue;
                    case 121:
                        st.v8i = st.v1i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 122:
                        st.pc = 122;
                        st.pc = 6;
                        continue;
                    case 123:
                        st.v1i = st.v8i + 2;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 124:
                        st.pc = 124;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).j(st.v7i, st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 125:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 126:
                        st.pc = 126;
                        if (st.v7i != st.v4i) {
                            st.pc = 128;
                            continue;
                        }
                    case 127:
                        st.pc = 127;
                        st.pc = 76;
                        continue;
                    case 128:
                        st.v8i = st.v8i + 4;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 129:
                        st.pc = 129;
                        st.pc = 6;
                        continue;
                    case 130:
                        st.v1i = st.v8i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 131:
                        st.pc = 131;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 132:
                        st.pc = 132;
                        st.tmpI = ((luaj.LuaString) st.v2o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 133:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 134:
                        st.pc = 134;
                        if (st.v1i != st.v2i) {
                            st.pc = 142;
                            continue;
                        }
                    case 135:
                        st.pc = 135;
                        st.v8o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 136:
                        st.pc = 136;
                        st.tmpI = ((luaj.LuaString) st.v8o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 137:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 138:
                        st.pc = 138;
                        if (st.v7i != st.v8i) {
                            st.pc = 140;
                            continue;
                        }
                    case 139:
                        st.pc = 139;
                        st.pc = 11;
                        continue;
                    case 140:
                        st.v7i = 0xffffffff;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 141:
                        st.pc = 141;
                        st.pc = 11;
                        continue;
                    case 142:
                        st.pc = 142;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).e(st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 143:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 144:
                        st.pc = 144;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 145:
                        st.pc = 145;
                        st.tmpI = ((luaj.LuaString) st.v2o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 146:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 147:
                        st.pc = 147;
                        if (st.v7i >= st.v2i) {
                            st.pc = 156;
                            continue;
                        }
                    case 148:
                        st.pc = 148;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 149:
                        st.pc = 149;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 150:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 151:
                        st.pc = 151;
                        st.tmpI = (((luaj.lib.StringLib$b) st.v6o).q(st.v2i, st.v8i, st.v1i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 152:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 153:
                        st.pc = 153;
                        if (st.v2i == 0) {
                            st.pc = 156;
                            continue;
                        }
                    case 154:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 155:
                        st.pc = 155;
                        st.pc = 157;
                        continue;
                    case 156:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 157:
                        st.pc = 157;
                        st.v5o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 158:
                        st.pc = 158;
                        st.tmpI = ((luaj.LuaString) st.v5o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 159:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 160:
                        st.pc = 160;
                        if (st.v1i >= st.v5i) {
                            st.pc = 164;
                            continue;
                        }
                    case 161:
                        st.pc = 161;
                        st.v3o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 162:
                        st.pc = 162;
                        st.tmpI = ((luaj.LuaString) st.v3o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 163:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 164:
                        st.v5i = 42;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 165:
                        st.pc = 165;
                        if (st.v3i == st.v5i) {
                            st.pc = 196;
                            continue;
                        }
                    case 166:
                        st.v5i = 43;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 167:
                        st.pc = 167;
                        if (st.v3i == st.v5i) {
                            st.pc = 191;
                            continue;
                        }
                    case 168:
                        st.v5i = 45;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 169:
                        st.pc = 169;
                        if (st.v3i == st.v5i) {
                            st.pc = 188;
                            continue;
                        }
                    case 170:
                        st.v8i = 63;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 171:
                        st.pc = 171;
                        if (st.v3i == st.v8i) {
                            st.pc = 176;
                            continue;
                        }
                    case 172:
                        st.pc = 172;
                        if (st.v2i != 0) {
                            st.pc = 174;
                            continue;
                        }
                    case 173:
                        st.pc = 173;
                        st.pc = 76;
                        continue;
                    case 174:
                        st.v7i = st.v7i + 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 175:
                        st.pc = 175;
                        st.pc = 121;
                        continue;
                    case 176:
                        st.pc = 176;
                        if (st.v2i == 0) {
                            st.pc = 186;
                            continue;
                        }
                    case 177:
                        st.v8i = st.v7i + 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 178:
                        st.v2i = st.v1i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 179:
                        st.pc = 179;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).g(st.v8i, st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 180:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 181:
                        st.pc = 181;
                        if (st.v8i == st.v4i) {
                            st.pc = 186;
                            continue;
                        }
                    case 182:
                        st.pc = 182;
                        st.v7i = ((luaj.lib.StringLib$b) st.v6o).f1778a;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 183:
                        st.v7i = st.v7i + st.v0i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 184:
                        st.pc = 184;
                        ((luaj.lib.StringLib$b) st.v6o).f1778a = st.v7i;
                    case 185:
                        st.pc = 185;
                        st.resultI = st.v8i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 186:
                        st.v8i = st.v1i + 1;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 187:
                        st.pc = 187;
                        st.pc = 6;
                        continue;
                    case 188:
                        st.pc = 188;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).m(st.v7i, st.v8i, st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 189:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 190:
                        st.pc = 190;
                        st.pc = 11;
                        continue;
                    case 191:
                        st.pc = 191;
                        if (st.v2i == 0) {
                            st.pc = 76;
                            continue;
                        }
                    case 192:
                        st.v7i = st.v7i + st.v0i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 193:
                        st.pc = 193;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).l(st.v7i, st.v8i, st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 194:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 195:
                        st.pc = 195;
                        st.pc = 76;
                        continue;
                    case 196:
                        st.pc = 196;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v6o).l(st.v7i, st.v8i, st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 197:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 198:
                        st.pc = 198;
                        st.pc = 11;
                        continue;
                    case 199:
                        st.pc = 199;
                        st.v8i = ((luaj.lib.StringLib$b) st.v6o).f1778a;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 200:
                        st.v8i = st.v8i + st.v0i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 201:
                        st.pc = 201;
                        ((luaj.lib.StringLib$b) st.v6o).f1778a = st.v8i;
                    case 202:
                        st.pc = 202;
                        throw (java.lang.Throwable) st.v7o;
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
        7, 10, 33, -1, 15, 75, 33, -1, 81, 181, 33, -1, 188, 198, 33, -1
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

    int h(int i, int i2) {
        xm_hState st = new xm_hState();
        st.v3o = this;
        st.v4i = i;
        st.v5i = i2;
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
        java.lang.Object v3o;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
    }

    private static int xm_h_run(xm_hState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 19) {
                done = xm_h_c0(st);
            }
            else {
                done = xm_h_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_h_c0(xm_hState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v3o).d(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v0o = ((luaj.lib.StringLib$b) st.v3o).f1784g;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v0i = ((int[]) st.v0o)[st.v5i];
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.v1o = ((luaj.lib.StringLib$b) st.v3o).f1779b;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.tmpI = ((luaj.LuaString) st.v1o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 7:
                        st.v1i = st.v1i - st.v4i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        if (st.v1i < st.v0i) {
                            st.pc = 17;
                            continue;
                        }
                    case 9:
                        st.pc = 9;
                        st.v1o = ((luaj.lib.StringLib$b) st.v3o).f1779b;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.v2o = ((luaj.lib.StringLib$b) st.v3o).f1783f;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.v5i = ((int[]) st.v2o)[st.v5i];
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.tmpI = (luaj.LuaString.W2((luaj.LuaString) st.v1o, st.v5i, (luaj.LuaString) st.v1o, st.v4i, st.v0i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 13:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v5i == 0) {
                            st.pc = 17;
                            continue;
                        }
                    case 15:
                        st.v4i = st.v4i + st.v0i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 17:
                        st.v4i = 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
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

    int j(int i, int i2) {
        xm_jState st = new xm_jState();
        st.v6o = this;
        st.v7i = i;
        st.v8i = i2;
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
        java.lang.Object v6o;
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private static int xm_j_run(xm_jState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 46) {
                done = xm_j_c0(st);
            }
            else {
                done = xm_j_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_j_c0(xm_jState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = ((luaj.LuaString) st.v0o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v8i == st.v0i) {
                            st.pc = 6;
                            continue;
                        }
                    case 4:
                        st.v1i = st.v8i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v1i != st.v0i) {
                            st.pc = 8;
                            continue;
                        }
                    case 6:
                        st.v0o = "malformed pattern (missing arguments to '%b')";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 8:
                        st.pc = 8;
                        st.v0o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpI = ((luaj.LuaString) st.v0o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 11:
                        st.v1i = 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v7i < st.v0i) {
                            st.pc = 14;
                            continue;
                        }
                    case 13:
                        st.pc = 13;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 14:
                        st.pc = 14;
                        st.v2o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 16:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.v3o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpI = ((luaj.LuaString) st.v3o).g3(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 20:
                        st.pc = 20;
                        if (st.v3i == st.v2i) {
                            st.pc = 22;
                            continue;
                        }
                    case 21:
                        st.pc = 21;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 22:
                        st.pc = 22;
                        st.v3o = ((luaj.lib.StringLib$b) st.v6o).f1780c;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 23:
                        st.v4i = 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 24:
                        st.v8i = st.v8i + st.v4i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.tmpI = ((luaj.LuaString) st.v3o).g3(st.v8i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 26:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 27:
                        st.v3i = st.v7i + 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 28:
                        st.pc = 28;
                        if (st.v3i >= st.v0i) {
                            st.pc = 45;
                            continue;
                        }
                    case 29:
                        st.pc = 29;
                        st.v5o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.tmpI = ((luaj.LuaString) st.v5o).g3(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 31:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 32:
                        st.pc = 32;
                        if (st.v5i != st.v8i) {
                            st.pc = 39;
                            continue;
                        }
                    case 33:
                        st.v4i = st.v4i + 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 34:
                        st.pc = 34;
                        if (st.v4i != 0) {
                            st.pc = 37;
                            continue;
                        }
                    case 35:
                        st.v7i = st.v7i + 2;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.resultI = st.v7i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 37:
                        st.v7i = st.v3i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 38:
                        st.pc = 38;
                        st.pc = 27;
                        continue;
                    case 39:
                        st.pc = 39;
                        st.v7o = ((luaj.lib.StringLib$b) st.v6o).f1779b;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 40:
                        st.pc = 40;
                        st.tmpI = ((luaj.LuaString) st.v7o).g3(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 41:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 42:
                        st.pc = 42;
                        if (st.v7i != st.v2i) {
                            st.pc = 37;
                            continue;
                        }
                    case 43:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.pc = 37;
                        continue;
                    case 45:
                        st.pc = 45;
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

    boolean k(int i, int i2, int i3) {
        xm_kState st = new xm_kState();
        st.v5o = this;
        st.v6i = i;
        st.v7i = i2;
        st.v8i = i3;
        return xm_k_run(st);
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
        int v7i;
        long v7j;
        java.lang.Object v7o;
        double v7d;
        int v8i;
    }

    private static boolean xm_k_run(xm_kState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 56) {
                done = xm_k_c0(st);
            }
            else {
                done = xm_k_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_k_c0(xm_kState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.lib.StringLib$b) st.v5o).f1780c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = st.v7i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.tmpI = ((luaj.LuaString) st.v0o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 3:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 4:
                        st.v2i = 94;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.v3i = 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 6:
                        st.pc = 6;
                        if (st.v0i != st.v2i) {
                            st.pc = 11;
                            continue;
                        }
                    case 7:
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 8:
                        st.v7i = st.v1i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 9:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        st.pc = 12;
                        continue;
                    case 11:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 12:
                        st.v1i = st.v7i + 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v1i >= st.v8i) {
                            st.pc = 54;
                            continue;
                        }
                    case 14:
                        st.pc = 14;
                        st.v2o = ((luaj.lib.StringLib$b) st.v5o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 15:
                        st.pc = 15;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 16:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 17:
                        st.v4i = 37;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 18:
                        st.pc = 18;
                        if (st.v2i != st.v4i) {
                            st.pc = 27;
                            continue;
                        }
                    case 19:
                        st.v7i = st.v7i + 2;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.v1o = ((luaj.lib.StringLib$b) st.v5o).f1780c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.tmpI = ((luaj.LuaString) st.v1o).g3(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 22:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.tmpI = (luaj.lib.StringLib$b.i(st.v6i, st.v1i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 24:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 25:
                        st.pc = 25;
                        if (st.v1i == 0) {
                            st.pc = 12;
                            continue;
                        }
                    case 26:
                        st.pc = 26;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 27:
                        st.pc = 27;
                        st.v2o = ((luaj.lib.StringLib$b) st.v5o).f1780c;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 28:
                        st.v4i = st.v7i + 2;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v4i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 30:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 31:
                        st.v4i = 45;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 32:
                        st.pc = 32;
                        if (st.v2i != st.v4i) {
                            st.pc = 47;
                            continue;
                        }
                    case 33:
                        st.v2i = st.v7i + 3;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 34:
                        st.pc = 34;
                        if (st.v2i >= st.v8i) {
                            st.pc = 47;
                            continue;
                        }
                    case 35:
                        st.pc = 35;
                        st.v1o = ((luaj.lib.StringLib$b) st.v5o).f1780c;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 36:
                        st.v7i = st.v7i + 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.tmpI = ((luaj.LuaString) st.v1o).g3(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 38:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 39:
                        st.pc = 39;
                        if (st.v7i > st.v6i) {
                            st.pc = 45;
                            continue;
                        }
                    case 40:
                        st.pc = 40;
                        st.v7o = ((luaj.lib.StringLib$b) st.v5o).f1780c;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 41:
                        st.pc = 41;
                        st.tmpI = ((luaj.LuaString) st.v7o).g3(st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 42:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 43:
                        st.pc = 43;
                        if (st.v6i > st.v7i) {
                            st.pc = 45;
                            continue;
                        }
                    case 44:
                        st.pc = 44;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 45:
                        st.v7i = st.v2i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.pc = 12;
                        continue;
                    case 47:
                        st.pc = 47;
                        st.v7o = ((luaj.lib.StringLib$b) st.v5o).f1780c;
                        st.v7i = 0;
                        st.v7j = 0L;
                        st.v7d = 0.0;
                    case 48:
                        st.pc = 48;
                        st.tmpI = ((luaj.LuaString) st.v7o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 49:
                        st.v7i = st.tmpI;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 50:
                        st.pc = 50;
                        if (st.v7i != st.v6i) {
                            st.pc = 52;
                            continue;
                        }
                    case 51:
                        st.pc = 51;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 52:
                        st.v7i = st.v1i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 53:
                        st.pc = 53;
                        st.pc = 12;
                        continue;
                    case 54:
                        st.v6i = st.v0i ^ 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 55:
                        st.pc = 55;
                        st.resultI = st.v6i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
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

    int l(int i, int i2, int i3) {
        xm_lState st = new xm_lState();
        st.v3o = this;
        st.v4i = i;
        st.v5i = i2;
        st.v6i = i3;
        return xm_l_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_l_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_lState {
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
    }

    private static int xm_l_run(xm_lState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 25) {
                done = xm_l_c0(st);
            }
            else {
                done = xm_l_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_l_c0(xm_lState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = st.v4i + st.v0i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v2o = ((luaj.lib.StringLib$b) st.v3o).f1779b;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((luaj.LuaString) st.v2o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v1i >= st.v2i) {
                            st.pc = 14;
                            continue;
                        }
                    case 6:
                        st.pc = 6;
                        st.v2o = ((luaj.lib.StringLib$b) st.v3o).f1779b;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpI = ((luaj.LuaString) st.v2o).g3(st.v1i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 8:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        st.tmpI = (((luaj.lib.StringLib$b) st.v3o).q(st.v1i, st.v5i, st.v6i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 10:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v1i == 0) {
                            st.pc = 14;
                            continue;
                        }
                    case 12:
                        st.v0i = st.v0i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.pc = 1;
                        continue;
                    case 14:
                        st.v5i = 0xffffffff;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v0i < 0) {
                            st.pc = 24;
                            continue;
                        }
                    case 16:
                        st.v1i = st.v4i + st.v0i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 17:
                        st.v2i = st.v6i + 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v3o).g(st.v1i, st.v2i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v1i = st.tmpI;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 20:
                        st.pc = 20;
                        if (st.v1i == st.v5i) {
                            st.pc = 22;
                            continue;
                        }
                    case 21:
                        st.pc = 21;
                        st.resultI = st.v1i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 22:
                        st.v0i = st.v0i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.pc = 14;
                        continue;
                    case 24:
                        st.pc = 24;
                        st.resultI = st.v5i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_l_handler(st.pc, t);
            if (h < 0) {
                xm_l_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_l_ctypes = {
    };
    private static final int[] xm_l_handlers = {
        
    };
    private static int xm_l_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_l_handlers.length; i += 4) {
            if (pc < xm_l_handlers[i] || pc >= xm_l_handlers[i + 1]) {
                continue;
            }
            int ti = xm_l_handlers[i + 3];
            if (ti < 0 || xm_l_ctypes[ti].isInstance(t)) {
                return xm_l_handlers[i + 2];
            }
        }
        return -1;
    }

    int m(int i, int i2, int i3) {
        xm_mState st = new xm_mState();
        st.v2o = this;
        st.v3i = i;
        st.v4i = i2;
        st.v5i = i3;
        return xm_m_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_m_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_mState {
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
        int v4i;
        int v5i;
    }

    private static int xm_m_run(xm_mState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 19) {
                done = xm_m_c0(st);
            }
            else {
                done = xm_m_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_m_c0(xm_mState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = st.v5i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v2o).g(st.v3i, st.v0i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.v1i = 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        if (st.v0i == st.v1i) {
                            st.pc = 6;
                            continue;
                        }
                    case 5:
                        st.pc = 5;
                        st.resultI = st.v0i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 6:
                        st.pc = 6;
                        st.v0o = ((luaj.lib.StringLib$b) st.v2o).f1779b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.tmpI = ((luaj.LuaString) st.v0o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 8:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v3i >= st.v0i) {
                            st.pc = 18;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v0o = ((luaj.lib.StringLib$b) st.v2o).f1779b;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpI = ((luaj.LuaString) st.v0o).g3(st.v3i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 12:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 13:
                        st.pc = 13;
                        st.tmpI = (((luaj.lib.StringLib$b) st.v2o).q(st.v0i, st.v4i, st.v5i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 14:
                        st.v0i = st.tmpI;
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
                        st.v3i = st.v3i + 1;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.pc = 0;
                        continue;
                    case 18:
                        st.pc = 18;
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
            int h = xm_m_handler(st.pc, t);
            if (h < 0) {
                xm_m_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_m_ctypes = {
    };
    private static final int[] xm_m_handlers = {
        
    };
    private static int xm_m_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_m_handlers.length; i += 4) {
            if (pc < xm_m_handlers[i] || pc >= xm_m_handlers[i + 1]) {
                continue;
            }
            int ti = xm_m_handlers[i + 3];
            if (ti < 0 || xm_m_ctypes[ti].isInstance(t)) {
                return xm_m_handlers[i + 2];
            }
        }
        return -1;
    }

    luaj.Varargs n(boolean z, int i, int i2) {
        xm_nState st = new xm_nState();
        st.v3o = this;
        st.v4i = (z ? 1 : 0);
        st.v5i = i;
        st.v6i = i2;
        return xm_n_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_n_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_nState {
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
        int v5i;
        int v6i;
    }

    private static luaj.Varargs xm_n_run(xm_nState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 23) {
                done = xm_n_c0(st);
            }
            else {
                done = xm_n_c0(st);
            }
            if (done) {
                return (luaj.Varargs) st.resultO;
            }
        }
    }

    private static boolean xm_n_c0(xm_nState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((luaj.lib.StringLib$b) st.v3o).f1782e;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 1;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i != 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        if (st.v4i == 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 4:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i == 0) {
                            st.pc = 21;
                            continue;
                        }
                    case 6:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i == st.v1i) {
                            st.pc = 18;
                            continue;
                        }
                    case 8:
                        st.pc = 8;
                        st.v1o = new luaj.LuaValue[st.v0i];
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v4i >= st.v0i) {
                            st.pc = 15;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.tmpO = ((luaj.lib.StringLib$b) st.v3o).o(st.v4i, st.v5i, st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 11:
                        st.v2o = st.tmpO;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 12:
                        st.pc = 12;
                        ((java.lang.Object[]) st.v1o)[st.v4i] = st.v2o;
                    case 13:
                        st.v4i = st.v4i + 1;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.pc = 9;
                        continue;
                    case 15:
                        st.pc = 15;
                        st.tmpO = luaj.LuaValue.O2((luaj.LuaValue[]) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 16:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 18:
                        st.pc = 18;
                        st.tmpO = ((luaj.lib.StringLib$b) st.v3o).o(st.v4i, st.v5i, st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 19:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    case 21:
                        st.pc = 21;
                        st.v4o = luaj.LuaValue.f1676f;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 22:
                        st.pc = 22;
                        st.resultO = st.v4o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_n_handler(st.pc, t);
            if (h < 0) {
                xm_n_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_n_ctypes = {
    };
    private static final int[] xm_n_handlers = {
        
    };
    private static int xm_n_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_n_handlers.length; i += 4) {
            if (pc < xm_n_handlers[i] || pc >= xm_n_handlers[i + 1]) {
                continue;
            }
            int ti = xm_n_handlers[i + 3];
            if (ti < 0 || xm_n_ctypes[ti].isInstance(t)) {
                return xm_n_handlers[i + 2];
            }
        }
        return -1;
    }

    void p() {
        xm_pState st = new xm_pState();
        st.v1o = this;
        xm_p_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_p_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_pState {
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

    private static void xm_p_run(xm_pState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 5) {
                done = xm_p_c0(st);
            }
            else {
                done = xm_p_c0(st);
            }
            if (done) {
                return;
            }
        }
    }

    private static boolean xm_p_c0(xm_pState st) {
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
                        ((luaj.lib.StringLib$b) st.v1o).f1782e = st.v0i;
                    case 2:
                        st.v0i = 200;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.pc = 3;
                        ((luaj.lib.StringLib$b) st.v1o).f1778a = st.v0i;
                    case 4:
                        st.pc = 4;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_p_handler(st.pc, t);
            if (h < 0) {
                xm_p_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_p_ctypes = {
    };
    private static final int[] xm_p_handlers = {
        
    };
    private static int xm_p_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_p_handlers.length; i += 4) {
            if (pc < xm_p_handlers[i] || pc >= xm_p_handlers[i + 1]) {
                continue;
            }
            int ti = xm_p_handlers[i + 3];
            if (ti < 0 || xm_p_ctypes[ti].isInstance(t)) {
                return xm_p_handlers[i + 2];
            }
        }
        return -1;
    }

    boolean q(int i, int i2, int i3) {
        xm_qState st = new xm_qState();
        st.v3o = this;
        st.v4i = i;
        st.v5i = i2;
        st.v6i = i3;
        return xm_q_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_q_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_qState {
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
        int v5i;
        long v5j;
        java.lang.Object v5o;
        double v5d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
    }

    private static boolean xm_q_run(xm_qState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 29) {
                done = xm_q_c0(st);
            }
            else {
                done = xm_q_c0(st);
            }
            if (done) {
                return st.resultI != 0;
            }
        }
    }

    private static boolean xm_q_c0(xm_qState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0o = ((luaj.lib.StringLib$b) st.v3o).f1780c;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpI = ((luaj.LuaString) st.v0o).g3(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 2:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 3:
                        st.v1i = 37;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 4:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i == st.v1i) {
                            st.pc = 22;
                            continue;
                        }
                    case 6:
                        st.v1i = 46;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i == st.v1i) {
                            st.pc = 21;
                            continue;
                        }
                    case 8:
                        st.v1i = 91;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 9:
                        st.pc = 9;
                        if (st.v0i == st.v1i) {
                            st.pc = 17;
                            continue;
                        }
                    case 10:
                        st.pc = 10;
                        st.v6o = ((luaj.lib.StringLib$b) st.v3o).f1780c;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 11:
                        st.pc = 11;
                        st.tmpI = ((luaj.LuaString) st.v6o).g3(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 12:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v5i != st.v4i) {
                            st.pc = 15;
                            continue;
                        }
                    case 14:
                        st.pc = 14;
                        st.pc = 16;
                        continue;
                    case 15:
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 16:
                        st.pc = 16;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 17:
                        st.v6i = st.v6i - st.v2i;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 18:
                        st.pc = 18;
                        st.tmpI = (((luaj.lib.StringLib$b) st.v3o).k(st.v4i, st.v5i, st.v6i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 19:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 20:
                        st.pc = 20;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 21:
                        st.pc = 21;
                        st.resultI = st.v2i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    case 22:
                        st.pc = 22;
                        st.v6o = ((luaj.lib.StringLib$b) st.v3o).f1780c;
                        st.v6i = 0;
                        st.v6j = 0L;
                        st.v6d = 0.0;
                    case 23:
                        st.v5i = st.v5i + st.v2i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.tmpI = ((luaj.LuaString) st.v6o).g3(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 25:
                        st.v5i = st.tmpI;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.tmpI = (luaj.lib.StringLib$b.i(st.v4i, st.v5i)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 27:
                        st.v4i = st.tmpI;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.resultI = st.v4i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_q_handler(st.pc, t);
            if (h < 0) {
                xm_q_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_q_ctypes = {
    };
    private static final int[] xm_q_handlers = {
        
    };
    private static int xm_q_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_q_handlers.length; i += 4) {
            if (pc < xm_q_handlers[i] || pc >= xm_q_handlers[i + 1]) {
                continue;
            }
            int ti = xm_q_handlers[i + 3];
            if (ti < 0 || xm_q_ctypes[ti].isInstance(t)) {
                return xm_q_handlers[i + 2];
            }
        }
        return -1;
    }

    /* ------------------------------------------------------------- *
     *  .method r(III)I
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    int r(int i, int i2, int i3) {
        xm_rState st = new xm_rState();
        st.v2o = this;
        st.v3i = i;
        st.v4i = i2;
        st.v5i = i3;
        return xm_r_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_r_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_rState {
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
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v5i;
    }

    private static int xm_r_run(xm_rState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 19) {
                done = xm_r_c0(st);
            }
            else {
                done = xm_r_c0(st);
            }
            if (done) {
                return st.resultI;
            }
        }
    }

    private static boolean xm_r_c0(xm_rState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.pc = 0;
                        st.v0i = ((luaj.lib.StringLib$b) st.v2o).f1782e;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.v1i = 32;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i < st.v1i) {
                            st.pc = 5;
                            continue;
                        }
                    case 3:
                        st.v1o = "too many captures";
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v1o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 5:
                        st.pc = 5;
                        st.v1o = ((luaj.lib.StringLib$b) st.v2o).f1783f;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 6:
                        st.pc = 6;
                        ((int[]) st.v1o)[st.v0i] = st.v3i;
                    case 7:
                        st.pc = 7;
                        st.v1o = ((luaj.lib.StringLib$b) st.v2o).f1784g;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 8:
                        st.pc = 8;
                        ((int[]) st.v1o)[st.v0i] = st.v5i;
                    case 9:
                        st.v0i = st.v0i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 10:
                        st.pc = 10;
                        ((luaj.lib.StringLib$b) st.v2o).f1782e = st.v0i;
                    case 11:
                        st.pc = 11;
                        st.tmpI = ((luaj.lib.StringLib$b) st.v2o).g(st.v3i, st.v4i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 12:
                        st.v3i = st.tmpI;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 13:
                        st.v4i = 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v3i != st.v4i) {
                            st.pc = 18;
                            continue;
                        }
                    case 15:
                        st.pc = 15;
                        st.v4i = ((luaj.lib.StringLib$b) st.v2o).f1782e;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 16:
                        st.v4i = st.v4i + 0xffffffff;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 17:
                        st.pc = 17;
                        ((luaj.lib.StringLib$b) st.v2o).f1782e = st.v4i;
                    case 18:
                        st.pc = 18;
                        st.resultI = st.v3i;
                        st.resultJ = 0L;
                        st.resultO = null;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_r_handler(st.pc, t);
            if (h < 0) {
                xm_r_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_r_ctypes = {
    };
    private static final int[] xm_r_handlers = {
        
    };
    private static int xm_r_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_r_handlers.length; i += 4) {
            if (pc < xm_r_handlers[i] || pc >= xm_r_handlers[i + 1]) {
                continue;
            }
            int ti = xm_r_handlers[i + 3];
            if (ti < 0 || xm_r_ctypes[ti].isInstance(t)) {
                return xm_r_handlers[i + 2];
            }
        }
        return -1;
    }
}

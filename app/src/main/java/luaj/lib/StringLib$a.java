package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
class StringLib$a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1777g;
    public final int h;
    public final int i;
    public final java.lang.String j;

    public StringLib$a(luaj.Varargs varargs, luaj.LuaString luaString, int i) {
        int iS1 = luaString.s1();
        int iG3 = 0;
        int i2 = i;
        boolean z = true;
        int iG4 = 0;
        while (z) {
            if (i2 < iS1) {
                iG4 = luaString.g3(i2);
                i2++;
            } else {
                iG4 = 0;
            }
            if (iG4 == 32) {
                this.f1774d = true;
            } else if (iG4 == 35) {
                this.f1775e = true;
            } else if (iG4 == 43) {
                this.f1773c = true;
            } else if (iG4 == 45) {
                this.f1771a = true;
            } else if (iG4 != 48) {
                z = false;
            } else {
                this.f1772b = true;
            }
        }
        if (i2 - i > 5) {
            luaj.LuaValue.R0("invalid format (repeated flags)");
        }
        this.f1776f = -1;
        if (java.lang.Character.isDigit((char) iG4)) {
            this.f1776f = iG4 - 48;
            if (i2 < iS1) {
                iG4 = luaString.g3(i2);
                i2++;
            } else {
                iG4 = 0;
            }
            if (java.lang.Character.isDigit((char) iG4)) {
                this.f1776f = (this.f1776f * 10) + (iG4 - 48);
                if (i2 < iS1) {
                    iG4 = luaString.g3(i2);
                    i2++;
                } else {
                    iG4 = 0;
                }
            }
        }
        this.f1777g = -1;
        if (iG4 == 46) {
            if (i2 < iS1) {
                iG4 = luaString.g3(i2);
                i2++;
            } else {
                iG4 = 0;
            }
            if (java.lang.Character.isDigit((char) iG4)) {
                this.f1777g = iG4 - 48;
                if (i2 < iS1) {
                    iG4 = luaString.g3(i2);
                    i2++;
                } else {
                    iG4 = 0;
                }
                if (java.lang.Character.isDigit((char) iG4)) {
                    this.f1777g = (this.f1777g * 10) + (iG4 - 48);
                    if (i2 < iS1) {
                        iG3 = luaString.g3(i2);
                        i2++;
                    }
                    iG4 = iG3;
                }
            }
        }
        if (java.lang.Character.isDigit((char) iG4)) {
            luaj.LuaValue.R0("invalid format (width or precision too long) at pos " + i2);
        }
        this.f1772b &= !this.f1771a;
        this.h = iG4;
        this.i = i2 - i;
        this.j = luaString.j3(i - 1, i2).g0();
    }

    public static final void e(gg_f.a aVar, char c2, int i) {
        xm_eState st = new xm_eState();
        st.v1o = aVar;
        st.v2i = (int) c2;
        st.v3i = i;
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
        java.lang.Object v1o;
        int v2i;
        long v2j;
        java.lang.Object v2o;
        double v2d;
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
    }

    private static void xm_e_run(xm_eState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 7) {
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
                        st.v2i = (byte) st.v2i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 1:
                        st.v0i = st.v3i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v3i <= 0) {
                            st.pc = 6;
                            continue;
                        }
                    case 3:
                        st.pc = 3;
                        st.tmpO = ((gg_f.a) st.v1o).a((byte) st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 4:
                        st.v3i = st.v0i;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.pc = 1;
                        continue;
                    case 6:
                        st.pc = 6;
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

    public void a(gg_f.a aVar, byte b2) {
        xm_aState st = new xm_aState();
        st.v0o = this;
        st.v1o = aVar;
        st.v2i = (int) b2;
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
            if (pc < 2) {
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
                        st.tmpO = ((gg_f.a) st.v1o).a((byte) st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 1:
                        st.pc = 1;
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

    public void b(gg_f.a aVar, double d2) {
        xm_bState st = new xm_bState();
        st.v6o = this;
        st.v7o = aVar;
        st.v8d = d2;
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
        java.lang.Object v6o;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        int v9i;
        long v9j;
        java.lang.Object v9o;
        double v9d;
    }

    private static void xm_b_run(xm_bState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 54) {
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
                        st.tmpI = (java.lang.Double.isNaN(st.v8d)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        if (st.v0i == 0) {
                            st.pc = 5;
                            continue;
                        }
                    case 3:
                        st.v0o = "nan";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 4:
                        st.pc = 4;
                        st.pc = 16;
                        continue;
                    case 5:
                        st.pc = 5;
                        st.tmpI = (java.lang.Double.isInfinite(st.v8d)) ? 1 : 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 6:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i == 0) {
                            st.pc = 15;
                            continue;
                        }
                    case 8:
                        st.v0j = 0L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 9:
                        st.pc = 9;
                        st.v2i = (Double.isNaN(st.v8d) || Double.isNaN(st.v0d) ? 1 : (st.v8d < st.v0d ? -1 : (st.v8d == st.v0d ? 0 : 1)));
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v2i >= 0) {
                            st.pc = 13;
                            continue;
                        }
                    case 11:
                        st.v0o = "-inf";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.pc = 16;
                        continue;
                    case 13:
                        st.v0o = "inf";
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 14:
                        st.pc = 14;
                        st.pc = 16;
                        continue;
                    case 15:
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 16:
                        st.pc = 16;
                        if ((st.v0o == null && st.v0i == 0)) {
                            st.pc = 24;
                            continue;
                        }
                    case 17:
                        st.pc = 17;
                        st.v8i = ((luaj.lib.StringLib$a) st.v6o).h;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 18:
                        st.v9i = 97;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 19:
                        st.pc = 19;
                        if (st.v8i >= st.v9i) {
                            st.pc = 52;
                            continue;
                        }
                    case 20:
                        st.pc = 20;
                        st.v8o = java.util.Locale.US;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 21:
                        st.pc = 21;
                        st.tmpO = ((java.lang.String) st.v0o).toUpperCase((java.util.Locale) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 22:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 23:
                        st.pc = 23;
                        st.pc = 52;
                        continue;
                    case 24:
                        st.pc = 24;
                        st.v0o = java.util.Locale.US;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 25:
                        st.pc = 25;
                        st.v1o = ((luaj.lib.StringLib$a) st.v6o).j;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 26:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.v2o = new java.lang.Object[st.v2i];
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 28:
                        st.pc = 28;
                        st.tmpO = java.lang.Double.valueOf(st.v8d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 29:
                        st.v3o = st.tmpO;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 30:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 31:
                        st.pc = 31;
                        ((java.lang.Object[]) st.v2o)[st.v4i] = st.v3o;
                    case 32:
                        st.pc = 32;
                        st.tmpO = java.lang.String.format((java.util.Locale) st.v0o, (java.lang.String) st.v1o, (java.lang.Object[]) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 33:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 34:
                        st.pc = 34;
                        st.pc = 52;
                        continue;
                    case 35:
                        st.pc = 35;
                        st.v0o = st.ex;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.v1o = null;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.v1o = new java.lang.StringBuilder();
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 38:
                        st.v2o = "Failed format double ";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 40:
                        st.pc = 40;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append(st.v8d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 41:
                        st.v2o = " with '";
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 43:
                        st.pc = 43;
                        st.v2o = ((luaj.lib.StringLib$a) st.v6o).j;
                        st.v2i = 0;
                        st.v2j = 0L;
                        st.v2d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((java.lang.String) st.v2o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 45:
                        st.v2i = 39;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 46:
                        st.pc = 46;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).append((char) st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 47:
                        st.pc = 47;
                        st.tmpO = ((java.lang.StringBuilder) st.v1o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 48:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 49:
                        st.pc = 49;
                        st.tmpI = android.ext.e1.s((java.lang.String) st.v1o, (java.lang.Throwable) st.v0o);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 50:
                        st.pc = 50;
                        st.tmpO = java.lang.String.valueOf(st.v8d);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 51:
                        st.v0o = st.tmpO;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 52:
                        st.pc = 52;
                        st.tmpO = ((gg_f.a) st.v7o).b((java.lang.String) st.v0o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 53:
                        st.pc = 53;
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
        24, 34, 35, -1
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

    /* JADX WARN: Code duplicated, block: B:20:0x004b  */
    public void c(gg_f.a aVar, long j) {
        xm_cState st = new xm_cState();
        st.v10o = this;
        st.v11o = aVar;
        st.v12j = j;
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
        int v3i;
        long v3j;
        java.lang.Object v3o;
        double v3d;
        int v4i;
        long v4j;
        java.lang.Object v4o;
        double v4d;
        int v6i;
        long v6j;
        java.lang.Object v6o;
        double v6d;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
        java.lang.Object v10o;
        java.lang.Object v11o;
        int v12i;
        long v12j;
        java.lang.Object v12o;
        double v12d;
        int v13i;
        long v13j;
        java.lang.Object v13o;
        double v13d;
    }

    private static void xm_c_run(xm_cState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 108) {
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
                        st.v0j = 0L;
                        st.v0d = java.lang.Double.longBitsToDouble(st.v0j);
                        st.v0i = 0;
                        st.v0o = null;
                    case 1:
                        st.v2i = 1;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 2:
                        st.v3i = Long.compare(st.v12j, st.v0j);
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 3:
                        st.pc = 3;
                        if (st.v3i != 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 4:
                        st.pc = 4;
                        st.v0i = ((luaj.lib.StringLib$a) st.v10o).f1777g;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v0i != 0) {
                            st.pc = 8;
                            continue;
                        }
                    case 6:
                        st.v12o = "";
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 7:
                        st.pc = 7;
                        st.pc = 47;
                        continue;
                    case 8:
                        st.pc = 8;
                        st.v0i = ((luaj.lib.StringLib$a) st.v10o).h;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.v1i = 88;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v0i == st.v1i) {
                            st.pc = 40;
                            continue;
                        }
                    case 11:
                        st.v4i = 111;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 12:
                        st.pc = 12;
                        if (st.v0i == st.v4i) {
                            st.pc = 37;
                            continue;
                        }
                    case 13:
                        st.v4i = 117;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 14:
                        st.pc = 14;
                        if (st.v0i == st.v4i) {
                            st.pc = 20;
                            continue;
                        }
                    case 15:
                        st.v4i = 120;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 16:
                        st.pc = 16;
                        if (st.v0i == st.v4i) {
                            st.pc = 40;
                            continue;
                        }
                    case 17:
                        st.pc = 17;
                        st.tmpO = java.lang.Long.toString(st.v12j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 18:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.pc = 42;
                        continue;
                    case 20:
                        st.pc = 20;
                        if (st.v3i < 0) {
                            st.pc = 22;
                            continue;
                        }
                    case 21:
                        st.pc = 21;
                        st.pc = 17;
                        continue;
                    case 22:
                        st.v4j = st.v12j >>> st.v2i;
                        st.v4d = java.lang.Double.longBitsToDouble(st.v4j);
                        st.v4i = 0;
                        st.v4o = null;
                    case 23:
                        st.v6j = 5L;
                        st.v6d = java.lang.Double.longBitsToDouble(st.v6j);
                        st.v6i = 0;
                        st.v6o = null;
                    case 24:
                        st.pc = 24;
                        st.v4j = st.v4j / st.v6j;
                        st.v4d = java.lang.Double.longBitsToDouble(st.v4j);
                        st.v4i = 0;
                        st.v4o = null;
                    case 25:
                        st.v6j = 10L;
                        st.v6d = java.lang.Double.longBitsToDouble(st.v6j);
                        st.v6i = 0;
                        st.v6o = null;
                    case 26:
                        st.v6j = st.v6j * st.v4j;
                        st.v6d = java.lang.Double.longBitsToDouble(st.v6j);
                        st.v6i = 0;
                        st.v6o = null;
                    case 27:
                        st.v12j = st.v12j - st.v6j;
                        st.v12d = java.lang.Double.longBitsToDouble(st.v12j);
                        st.v12i = 0;
                        st.v12o = null;
                    case 28:
                        st.pc = 28;
                        st.v0o = null;
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v0o = new java.lang.StringBuilder();
                        st.v0i = 0;
                        st.v0j = 0L;
                        st.v0d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.tmpO = java.lang.Long.toString(st.v4j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 31:
                        st.v4o = st.tmpO;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 32:
                        st.pc = 32;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append((java.lang.String) st.v4o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 33:
                        st.pc = 33;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).append(st.v12j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 34:
                        st.pc = 34;
                        st.tmpO = ((java.lang.StringBuilder) st.v0o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 35:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 36:
                        st.pc = 36;
                        st.pc = 42;
                        continue;
                    case 37:
                        st.pc = 37;
                        st.tmpO = java.lang.Long.toOctalString(st.v12j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 38:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.pc = 42;
                        continue;
                    case 40:
                        st.pc = 40;
                        st.tmpO = java.lang.Long.toHexString(st.v12j);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 41:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.v13i = ((luaj.lib.StringLib$a) st.v10o).h;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 43:
                        st.pc = 43;
                        if (st.v13i != st.v1i) {
                            st.pc = 47;
                            continue;
                        }
                    case 44:
                        st.pc = 44;
                        st.v13o = java.util.Locale.US;
                        st.v13i = 0;
                        st.v13j = 0L;
                        st.v13d = 0.0;
                    case 45:
                        st.pc = 45;
                        st.tmpO = ((java.lang.String) st.v12o).toUpperCase((java.util.Locale) st.v13o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 46:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 47:
                        st.pc = 47;
                        st.tmpI = ((java.lang.String) st.v12o).length();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 48:
                        st.v13i = st.tmpI;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 49:
                        st.pc = 49;
                        if (st.v3i >= 0) {
                            st.pc = 55;
                            continue;
                        }
                    case 50:
                        st.v0i = st.v13i + 0xffffffff;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 51:
                        st.v8i = st.v0i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 52:
                        st.v0i = st.v13i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 53:
                        st.v13i = st.v8i;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 54:
                        st.pc = 54;
                        st.pc = 63;
                        continue;
                    case 55:
                        st.pc = 55;
                        st.v0i = (((luaj.lib.StringLib$a) st.v10o).f1773c ? 1 : 0);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 56:
                        st.pc = 56;
                        if (st.v0i != 0) {
                            st.pc = 62;
                            continue;
                        }
                    case 57:
                        st.pc = 57;
                        st.v0i = (((luaj.lib.StringLib$a) st.v10o).f1774d ? 1 : 0);
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 58:
                        st.pc = 58;
                        if (st.v0i == 0) {
                            st.pc = 60;
                            continue;
                        }
                    case 59:
                        st.pc = 59;
                        st.pc = 62;
                        continue;
                    case 60:
                        st.v0i = st.v13i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 61:
                        st.pc = 61;
                        st.pc = 63;
                        continue;
                    case 62:
                        st.v0i = st.v13i + 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 63:
                        st.pc = 63;
                        st.v1i = ((luaj.lib.StringLib$a) st.v10o).f1777g;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 64:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 65:
                        st.pc = 65;
                        if (st.v1i <= st.v13i) {
                            st.pc = 68;
                            continue;
                        }
                    case 66:
                        st.v1i = st.v1i - st.v13i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 67:
                        st.pc = 67;
                        st.pc = 77;
                        continue;
                    case 68:
                        st.v13i = 0xffffffff;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 69:
                        st.pc = 69;
                        if (st.v1i != st.v13i) {
                            st.pc = 76;
                            continue;
                        }
                    case 70:
                        st.pc = 70;
                        st.v13i = (((luaj.lib.StringLib$a) st.v10o).f1772b ? 1 : 0);
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 71:
                        st.pc = 71;
                        if (st.v13i == 0) {
                            st.pc = 76;
                            continue;
                        }
                    case 72:
                        st.pc = 72;
                        st.v13i = ((luaj.lib.StringLib$a) st.v10o).f1776f;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 73:
                        st.pc = 73;
                        if (st.v13i <= st.v0i) {
                            st.pc = 76;
                            continue;
                        }
                    case 74:
                        st.v1i = st.v13i - st.v0i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 75:
                        st.pc = 75;
                        st.pc = 77;
                        continue;
                    case 76:
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 77:
                        st.v0i = st.v0i + st.v1i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 78:
                        st.pc = 78;
                        st.v13i = ((luaj.lib.StringLib$a) st.v10o).f1776f;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 79:
                        st.pc = 79;
                        if (st.v13i <= st.v0i) {
                            st.pc = 81;
                            continue;
                        }
                    case 80:
                        st.v4i = st.v13i - st.v0i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 81:
                        st.pc = 81;
                        st.v13i = (((luaj.lib.StringLib$a) st.v10o).f1771a ? 1 : 0);
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 82:
                        st.v0i = 32;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 83:
                        st.pc = 83;
                        if (st.v13i != 0) {
                            st.pc = 85;
                            continue;
                        }
                    case 84:
                        st.pc = 84;
                        luaj.lib.StringLib$a.e((gg_f.a) st.v11o, (char) st.v0i, st.v4i);
                    case 85:
                        st.pc = 85;
                        if (st.v3i >= 0) {
                            st.pc = 92;
                            continue;
                        }
                    case 86:
                        st.pc = 86;
                        if (st.v1i <= 0) {
                            st.pc = 100;
                            continue;
                        }
                    case 87:
                        st.v13i = 45;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 88:
                        st.pc = 88;
                        st.tmpO = ((gg_f.a) st.v11o).a((byte) st.v13i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 89:
                        st.pc = 89;
                        st.tmpO = ((java.lang.String) st.v12o).substring(st.v2i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 90:
                        st.v12o = st.tmpO;
                        st.v12i = 0;
                        st.v12j = 0L;
                        st.v12d = 0.0;
                    case 91:
                        st.pc = 91;
                        st.pc = 100;
                        continue;
                    case 92:
                        st.pc = 92;
                        st.v13i = (((luaj.lib.StringLib$a) st.v10o).f1773c ? 1 : 0);
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 93:
                        st.pc = 93;
                        if (st.v13i == 0) {
                            st.pc = 97;
                            continue;
                        }
                    case 94:
                        st.v13i = 43;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 95:
                        st.pc = 95;
                        st.tmpO = ((gg_f.a) st.v11o).a((byte) st.v13i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 96:
                        st.pc = 96;
                        st.pc = 100;
                        continue;
                    case 97:
                        st.pc = 97;
                        st.v13i = (((luaj.lib.StringLib$a) st.v10o).f1774d ? 1 : 0);
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 98:
                        st.pc = 98;
                        if (st.v13i == 0) {
                            st.pc = 100;
                            continue;
                        }
                    case 99:
                        st.pc = 99;
                        st.tmpO = ((gg_f.a) st.v11o).a((byte) st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 100:
                        st.pc = 100;
                        if (st.v1i <= 0) {
                            st.pc = 103;
                            continue;
                        }
                    case 101:
                        st.v13i = 48;
                        st.v13j = 0L;
                        st.v13o = null;
                        st.v13d = 0.0;
                    case 102:
                        st.pc = 102;
                        luaj.lib.StringLib$a.e((gg_f.a) st.v11o, (char) st.v13i, st.v1i);
                    case 103:
                        st.pc = 103;
                        st.tmpO = ((gg_f.a) st.v11o).b((java.lang.String) st.v12o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 104:
                        st.pc = 104;
                        st.v12i = (((luaj.lib.StringLib$a) st.v10o).f1771a ? 1 : 0);
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 105:
                        st.pc = 105;
                        if (st.v12i == 0) {
                            st.pc = 107;
                            continue;
                        }
                    case 106:
                        st.pc = 106;
                        luaj.lib.StringLib$a.e((gg_f.a) st.v11o, (char) st.v0i, st.v4i);
                    case 107:
                        st.pc = 107;
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

    /* ------------------------------------------------------------- *
     *  .method public d(Lgg_f/a;Lluaj/LuaString;)V
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public void d(gg_f.a aVar, luaj.LuaString luaString) {
        xm_dState st = new xm_dState();
        st.v6o = this;
        st.v7o = aVar;
        st.v8o = luaString;
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
        java.lang.Object v6o;
        java.lang.Object v7o;
        int v8i;
        long v8j;
        java.lang.Object v8o;
        double v8d;
    }

    private static void xm_d_run(xm_dState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 41) {
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
                        st.tmpI = ((luaj.LuaString) st.v8o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 1:
                        st.v0i = st.tmpI;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 2:
                        st.pc = 2;
                        st.v1i = ((luaj.lib.StringLib$a) st.v6o).f1776f;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.v2i = ((luaj.lib.StringLib$a) st.v6o).f1777g;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 4:
                        st.v3i = 0xffffffff;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 5:
                        st.pc = 5;
                        if (st.v2i != st.v3i) {
                            st.pc = 7;
                            continue;
                        }
                    case 6:
                        st.v2i = st.v0i;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 7:
                        st.pc = 7;
                        if (st.v0i <= st.v2i) {
                            st.pc = 9;
                            continue;
                        }
                    case 8:
                        st.v0i = st.v2i;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 9:
                        st.v2i = 32;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 10:
                        st.v3i = 48;
                        st.v3j = 0L;
                        st.v3o = null;
                        st.v3d = 0.0;
                    case 11:
                        st.pc = 11;
                        if (st.v0i >= st.v1i) {
                            st.pc = 25;
                            continue;
                        }
                    case 12:
                        st.pc = 12;
                        st.v4i = (((luaj.lib.StringLib$a) st.v6o).f1771a ? 1 : 0);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 13:
                        st.pc = 13;
                        if (st.v4i != 0) {
                            st.pc = 25;
                            continue;
                        }
                    case 14:
                        st.pc = 14;
                        st.v4i = (((luaj.lib.StringLib$a) st.v6o).f1772b ? 1 : 0);
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v4i == 0) {
                            st.pc = 18;
                            continue;
                        }
                    case 16:
                        st.v4i = 48;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 17:
                        st.pc = 17;
                        st.pc = 19;
                        continue;
                    case 18:
                        st.v4i = 32;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 19:
                        st.v4i = (byte) st.v4i;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 20:
                        st.v5i = st.v1i - st.v0i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 21:
                        st.pc = 21;
                        if (st.v5i <= 0) {
                            st.pc = 25;
                            continue;
                        }
                    case 22:
                        st.pc = 22;
                        st.tmpO = ((gg_f.a) st.v7o).a((byte) st.v4i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 23:
                        st.v5i = st.v5i + 0xffffffff;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 24:
                        st.pc = 24;
                        st.pc = 21;
                        continue;
                    case 25:
                        st.pc = 25;
                        st.v4o = ((luaj.LuaString) st.v8o).P;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.v8i = ((luaj.LuaString) st.v8o).Q;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 27:
                        st.pc = 27;
                        st.tmpO = ((gg_f.a) st.v7o).e((byte[]) st.v4o, st.v8i, st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 28:
                        st.pc = 28;
                        if (st.v0i >= st.v1i) {
                            st.pc = 40;
                            continue;
                        }
                    case 29:
                        st.pc = 29;
                        st.v8i = (((luaj.lib.StringLib$a) st.v6o).f1771a ? 1 : 0);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 30:
                        st.pc = 30;
                        if (st.v8i == 0) {
                            st.pc = 40;
                            continue;
                        }
                    case 31:
                        st.pc = 31;
                        st.v8i = (((luaj.lib.StringLib$a) st.v6o).f1772b ? 1 : 0);
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 32:
                        st.pc = 32;
                        if (st.v8i == 0) {
                            st.pc = 34;
                            continue;
                        }
                    case 33:
                        st.v2i = 48;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 34:
                        st.v8i = (byte) st.v2i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 35:
                        st.v1i = st.v1i - st.v0i;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 36:
                        st.pc = 36;
                        if (st.v1i <= 0) {
                            st.pc = 40;
                            continue;
                        }
                    case 37:
                        st.pc = 37;
                        st.tmpO = ((gg_f.a) st.v7o).a((byte) st.v8i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 38:
                        st.v1i = st.v1i + 0xffffffff;
                        st.v1j = 0L;
                        st.v1o = null;
                        st.v1d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.pc = 36;
                        continue;
                    case 40:
                        st.pc = 40;
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
}

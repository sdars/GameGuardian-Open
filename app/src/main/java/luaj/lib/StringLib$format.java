package luaj.lib;

/* JADX INFO: loaded from: classes.dex */
final class StringLib$format extends luaj.lib.VarArgFunction {
    StringLib$format() {
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:47:0x0106  */
    @Override // luaj.lib.VarArgFunction, luaj.lib.LibFunction, luaj.LuaValue
    /* ------------------------------------------------------------- *
     *  .method public invoke(Lluaj/Varargs;)Lluaj/Varargs;
     *
     *  Translated from the original dex code into plain java.
     *  Every dalvik instruction becomes one java statement, the
     *  register file lives in the state object below and the
     *  control flow is a switch over the instruction index.
     * ------------------------------------------------------------- */
    public luaj.Varargs invoke(luaj.Varargs varargs) {
        xm_invokeState st = new xm_invokeState();
        st.v13o = this;
        st.v14o = varargs;
        return xm_invoke_run(st);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void xm_invoke_rethrow(java.lang.Throwable t) throws T {
        throw (T) t;
    }

    private static final class xm_invokeState {
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
        int v12i;
        long v12j;
        java.lang.Object v12o;
        double v12d;
        java.lang.Object v13o;
        int v14i;
        long v14j;
        java.lang.Object v14o;
        double v14d;
    }

    private static luaj.Varargs xm_invoke_run(xm_invokeState st) {
        while (true) {
            boolean done;
            int pc = st.pc;
            if (pc < 138) {
                done = xm_invoke_c0(st);
            }
            else {
                done = xm_invoke_c0(st);
            }
            if (done) {
                return (luaj.Varargs) st.resultO;
            }
        }
    }

    private static boolean xm_invoke_c0(xm_invokeState st) {
        try {
            while (true) {
                switch (st.pc) {
                    case 0:
                        st.v0i = 1;
                        st.v0j = 0L;
                        st.v0o = null;
                        st.v0d = 0.0;
                    case 1:
                        st.pc = 1;
                        st.tmpO = ((luaj.Varargs) st.v14o).H(st.v0i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 2:
                        st.v1o = st.tmpO;
                        st.v1i = 0;
                        st.v1j = 0L;
                        st.v1d = 0.0;
                    case 3:
                        st.pc = 3;
                        st.tmpI = ((luaj.LuaString) st.v1o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 4:
                        st.v2i = st.tmpI;
                        st.v2j = 0L;
                        st.v2o = null;
                        st.v2d = 0.0;
                    case 5:
                        st.pc = 5;
                        st.v3o = null;
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 6:
                        st.pc = 6;
                        st.v3o = new gg_f.a(st.v2i);
                        st.v3i = 0;
                        st.v3j = 0L;
                        st.v3d = 0.0;
                    case 7:
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4o = null;
                        st.v4d = 0.0;
                    case 8:
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 9:
                        st.v6i = 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 10:
                        st.pc = 10;
                        if (st.v5i >= st.v2i) {
                            st.pc = 135;
                            continue;
                        }
                    case 11:
                        st.v7i = st.v5i + 1;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 12:
                        st.pc = 12;
                        st.tmpI = ((luaj.LuaString) st.v1o).g3(st.v5i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 13:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 14:
                        st.v9i = 10;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 15:
                        st.pc = 15;
                        if (st.v8i == st.v9i) {
                            st.pc = 133;
                            continue;
                        }
                    case 16:
                        st.v9i = 37;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 17:
                        st.pc = 17;
                        if (st.v8i == st.v9i) {
                            st.pc = 21;
                            continue;
                        }
                    case 18:
                        st.v5i = (byte) st.v8i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 19:
                        st.pc = 19;
                        st.tmpO = ((gg_f.a) st.v3o).a((byte) st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 20:
                        st.pc = 20;
                        st.pc = 131;
                        continue;
                    case 21:
                        st.pc = 21;
                        if (st.v7i >= st.v2i) {
                            st.pc = 131;
                            continue;
                        }
                    case 22:
                        st.pc = 22;
                        st.tmpI = ((luaj.LuaString) st.v1o).g3(st.v7i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 23:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 24:
                        st.pc = 24;
                        if (st.v8i != st.v9i) {
                            st.pc = 28;
                            continue;
                        }
                    case 25:
                        st.v5i = st.v5i + 2;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 26:
                        st.pc = 26;
                        st.tmpO = ((gg_f.a) st.v3o).a((byte) st.v9i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 27:
                        st.pc = 27;
                        st.pc = 10;
                        continue;
                    case 28:
                        st.v6i = st.v6i + 1;
                        st.v6j = 0L;
                        st.v6o = null;
                        st.v6d = 0.0;
                    case 29:
                        st.pc = 29;
                        st.v5o = null;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 30:
                        st.pc = 30;
                        st.v5o = new luaj.lib.StringLib$a((luaj.Varargs) st.v14o, (luaj.LuaString) st.v1o, st.v7i);
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 31:
                        st.pc = 31;
                        st.v8i = ((luaj.lib.StringLib$a) st.v5o).i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 32:
                        st.v7i = st.v7i + st.v8i;
                        st.v7j = 0L;
                        st.v7o = null;
                        st.v7d = 0.0;
                    case 33:
                        st.pc = 33;
                        st.v8i = ((luaj.lib.StringLib$a) st.v5o).h;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 34:
                        switch (st.v8i) {
                            case 65: st.pc = 128; continue;
                            case 69: st.pc = 128; continue;
                            case 71: st.pc = 128; continue;
                            case 88: st.pc = 124; continue;
                            case 97: st.pc = 128; continue;
                            case 105: st.pc = 124; continue;
                            case 111: st.pc = 124; continue;
                            case 113: st.pc = 71; continue;
                            case 115: st.pc = 54; continue;
                            case 117: st.pc = 124; continue;
                            case 120: st.pc = 124; continue;
                            default: st.pc = 35; continue;
                        }
                    case 35:
                        switch (st.v8i) {
                            case 99: st.pc = 49; continue;
                            case 100: st.pc = 124; continue;
                            case 101: st.pc = 128; continue;
                            case 102: st.pc = 128; continue;
                            case 103: st.pc = 128; continue;
                            default: st.pc = 36; continue;
                        }
                    case 36:
                        st.pc = 36;
                        st.v8o = null;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 37:
                        st.pc = 37;
                        st.v8o = new java.lang.StringBuilder();
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 38:
                        st.v9o = "invalid option '%";
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 39:
                        st.pc = 39;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 40:
                        st.pc = 40;
                        st.v5i = ((luaj.lib.StringLib$a) st.v5o).h;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 41:
                        st.v5i = (char) st.v5i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 42:
                        st.pc = 42;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((char) st.v5i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 43:
                        st.v5o = "' to 'string.format'";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 44:
                        st.pc = 44;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 45:
                        st.pc = 45;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 46:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 47:
                        st.pc = 47;
                        st.tmpO = luaj.LuaValue.R0((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 48:
                        st.pc = 48;
                        st.pc = 131;
                        continue;
                    case 49:
                        st.pc = 49;
                        st.tmpI = ((luaj.Varargs) st.v14o).D(st.v6i);
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 50:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 51:
                        st.v8i = (byte) st.v8i;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 52:
                        st.pc = 52;
                        ((luaj.lib.StringLib$a) st.v5o).a((gg_f.a) st.v3o, (byte) st.v8i);
                    case 53:
                        st.pc = 53;
                        st.pc = 131;
                        continue;
                    case 54:
                        st.pc = 54;
                        st.tmpO = ((luaj.Varargs) st.v14o).v(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 55:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 56:
                        st.pc = 56;
                        st.tmpO = luaj.lib.BaseLib.d3((luaj.LuaValue) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 57:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 58:
                        st.pc = 58;
                        st.v9i = ((luaj.lib.StringLib$a) st.v5o).f1777g;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 59:
                        st.v10i = 0xffffffff;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 60:
                        st.pc = 60;
                        if (st.v9i != st.v10i) {
                            st.pc = 67;
                            continue;
                        }
                    case 61:
                        st.pc = 61;
                        st.tmpI = ((luaj.LuaString) st.v8o).s1();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 62:
                        st.v9i = st.tmpI;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 63:
                        st.v10i = 100;
                        st.v10j = 0L;
                        st.v10o = null;
                        st.v10d = 0.0;
                    case 64:
                        st.pc = 64;
                        if (st.v9i < st.v10i) {
                            st.pc = 67;
                            continue;
                        }
                    case 65:
                        st.pc = 65;
                        st.tmpO = ((gg_f.a) st.v3o).c((luaj.LuaString) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 66:
                        st.pc = 66;
                        st.pc = 131;
                        continue;
                    case 67:
                        st.pc = 67;
                        st.tmpO = ((luaj.LuaString) st.v8o).G0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 68:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 69:
                        st.pc = 69;
                        ((luaj.lib.StringLib$a) st.v5o).d((gg_f.a) st.v3o, (luaj.LuaString) st.v8o);
                    case 70:
                        st.pc = 70;
                        st.pc = 131;
                        continue;
                    case 71:
                        st.pc = 71;
                        st.tmpO = ((luaj.Varargs) st.v14o).v(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 72:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 73:
                        st.pc = 73;
                        st.tmpI = ((luaj.LuaValue) st.v5o).C2();
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 74:
                        st.v8i = st.tmpI;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 75:
                        st.pc = 75;
                        if (st.v8i == 0) {
                            st.pc = 121;
                            continue;
                        }
                    case 76:
                        st.pc = 76;
                        if (st.v8i == st.v0i) {
                            st.pc = 121;
                            continue;
                        }
                    case 77:
                        st.v9i = 3;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 78:
                        st.pc = 78;
                        if (st.v8i == st.v9i) {
                            st.pc = 97;
                            continue;
                        }
                    case 79:
                        st.v9i = 4;
                        st.v9j = 0L;
                        st.v9o = null;
                        st.v9d = 0.0;
                    case 80:
                        st.pc = 80;
                        if (st.v8i == st.v9i) {
                            st.pc = 93;
                            continue;
                        }
                    case 81:
                        st.pc = 81;
                        st.v8o = null;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 82:
                        st.pc = 82;
                        st.v8o = new java.lang.StringBuilder();
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 83:
                        st.v9o = "'";
                        st.v9i = 0;
                        st.v9j = 0L;
                        st.v9d = 0.0;
                    case 84:
                        st.pc = 84;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v9o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 85:
                        st.pc = 85;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append(st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 86:
                        st.v5o = "': value has no literal form";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 87:
                        st.pc = 87;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).append((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 88:
                        st.pc = 88;
                        st.tmpO = ((java.lang.StringBuilder) st.v8o).toString();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 89:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 90:
                        st.v8o = "string.format";
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 91:
                        st.pc = 91;
                        st.tmpO = luaj.LuaValue.l0(st.v6i, (java.lang.String) st.v8o, (java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 92:
                        st.pc = 92;
                        st.pc = 131;
                        continue;
                    case 93:
                        st.pc = 93;
                        st.tmpO = ((luaj.Varargs) st.v14o).H(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 94:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 95:
                        st.pc = 95;
                        luaj.lib.StringLib.X2((gg_f.a) st.v3o, (luaj.LuaString) st.v5o);
                    case 96:
                        st.pc = 96;
                        st.pc = 131;
                        continue;
                    case 97:
                        st.v8i = (st.v5o instanceof luaj.LuaDouble) ? 1 : 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 98:
                        st.pc = 98;
                        if (st.v8i == 0) {
                            st.pc = 109;
                            continue;
                        }
                    case 99:
                        st.pc = 99;
                        if (st.v4i != 0) {
                            st.pc = 105;
                            continue;
                        }
                    case 100:
                        st.pc = 100;
                        st.v4o = null;
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 101:
                        st.v8o = "%a";
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 102:
                        st.pc = 102;
                        st.tmpO = luaj.LuaString.K2((java.lang.String) st.v8o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 103:
                        st.v8o = st.tmpO;
                        st.v8i = 0;
                        st.v8j = 0L;
                        st.v8d = 0.0;
                    case 104:
                        st.pc = 104;
                        st.v4o = new luaj.lib.StringLib$a((luaj.Varargs) st.v14o, (luaj.LuaString) st.v8o, st.v0i);
                        st.v4i = 0;
                        st.v4j = 0L;
                        st.v4d = 0.0;
                    case 105:
                        st.pc = 105;
                        st.tmpD = ((luaj.LuaValue) st.v5o).x0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 106:
                        st.v8d = st.tmpD;
                        st.v8j = java.lang.Double.doubleToRawLongBits(st.v8d);
                        st.v8i = 0;
                        st.v8o = null;
                    case 107:
                        st.pc = 107;
                        ((luaj.lib.StringLib$a) st.v4o).b((gg_f.a) st.v3o, st.v8d);
                    case 108:
                        st.pc = 108;
                        st.pc = 131;
                        continue;
                    case 109:
                        st.v8i = (st.v5o instanceof luaj.LuaLong) ? 1 : 0;
                        st.v8j = 0L;
                        st.v8o = null;
                        st.v8d = 0.0;
                    case 110:
                        st.pc = 110;
                        if (st.v8i == 0) {
                            st.pc = 119;
                            continue;
                        }
                    case 111:
                        st.pc = 111;
                        st.tmpJ = ((luaj.LuaValue) st.v5o).z2();
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 112:
                        st.v8j = st.tmpJ;
                        st.v8d = java.lang.Double.longBitsToDouble(st.v8j);
                        st.v8i = 0;
                        st.v8o = null;
                    case 113:
                        st.pc = 113;
                        st.v10j = 0x8000000000000000L;
                        st.v10d = java.lang.Double.longBitsToDouble(st.v10j);
                        st.v10i = 0;
                        st.v10o = null;
                    case 114:
                        st.v12i = Long.compare(st.v8j, st.v10j);
                        st.v12j = 0L;
                        st.v12o = null;
                        st.v12d = 0.0;
                    case 115:
                        st.pc = 115;
                        if (st.v12i != 0) {
                            st.pc = 119;
                            continue;
                        }
                    case 116:
                        st.v5o = "0x8000000000000000";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 117:
                        st.pc = 117;
                        st.tmpO = ((gg_f.a) st.v3o).b((java.lang.String) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 118:
                        st.pc = 118;
                        st.pc = 131;
                        continue;
                    case 119:
                        st.pc = 119;
                        st.tmpO = ((gg_f.a) st.v3o).d((luaj.LuaValue) st.v5o);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 120:
                        st.pc = 120;
                        st.pc = 131;
                        continue;
                    case 121:
                        st.pc = 121;
                        st.tmpO = ((luaj.LuaValue) st.v5o).g0();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 122:
                        st.v5o = st.tmpO;
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 123:
                        st.pc = 123;
                        st.pc = 117;
                        continue;
                    case 124:
                        st.pc = 124;
                        st.tmpJ = ((luaj.Varargs) st.v14o).F(st.v6i);
                        st.tmpI = 0;
                        st.tmpO = null;
                    case 125:
                        st.v8j = st.tmpJ;
                        st.v8d = java.lang.Double.longBitsToDouble(st.v8j);
                        st.v8i = 0;
                        st.v8o = null;
                    case 126:
                        st.pc = 126;
                        ((luaj.lib.StringLib$a) st.v5o).c((gg_f.a) st.v3o, st.v8j);
                    case 127:
                        st.pc = 127;
                        st.pc = 131;
                        continue;
                    case 128:
                        st.pc = 128;
                        st.tmpD = ((luaj.Varargs) st.v14o).B(st.v6i);
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                        st.tmpO = null;
                    case 129:
                        st.v8d = st.tmpD;
                        st.v8j = java.lang.Double.doubleToRawLongBits(st.v8d);
                        st.v8i = 0;
                        st.v8o = null;
                    case 130:
                        st.pc = 130;
                        ((luaj.lib.StringLib$a) st.v5o).b((gg_f.a) st.v3o, st.v8d);
                    case 131:
                        st.v5i = st.v7i;
                        st.v5j = 0L;
                        st.v5o = null;
                        st.v5d = 0.0;
                    case 132:
                        st.pc = 132;
                        st.pc = 10;
                        continue;
                    case 133:
                        st.v5o = "\n";
                        st.v5i = 0;
                        st.v5j = 0L;
                        st.v5d = 0.0;
                    case 134:
                        st.pc = 134;
                        st.pc = 117;
                        continue;
                    case 135:
                        st.pc = 135;
                        st.tmpO = ((gg_f.a) st.v3o).l();
                        st.tmpI = 0;
                        st.tmpJ = 0L;
                    case 136:
                        st.v14o = st.tmpO;
                        st.v14i = 0;
                        st.v14j = 0L;
                        st.v14d = 0.0;
                    case 137:
                        st.pc = 137;
                        st.resultO = st.v14o;
                        st.resultI = 0;
                        st.resultJ = 0L;
                        st.resultD = 0.0;
                        return true;
                    default:
                        return false;
                }
            }
        } catch (java.lang.Throwable t) {
            int h = xm_invoke_handler(st.pc, t);
            if (h < 0) {
                xm_invoke_rethrow(t);
            }
            st.ex = t;
            st.pc = h;
            return false;
        }
    }

    private static final Class<?>[] xm_invoke_ctypes = {
    };
    private static final int[] xm_invoke_handlers = {
        
    };
    private static int xm_invoke_handler(int pc, java.lang.Throwable t) {
        for (int i = 0; i < xm_invoke_handlers.length; i += 4) {
            if (pc < xm_invoke_handlers[i] || pc >= xm_invoke_handlers[i + 1]) {
                continue;
            }
            int ti = xm_invoke_handlers[i + 3];
            if (ti < 0 || xm_invoke_ctypes[ti].isInstance(t)) {
                return xm_invoke_handlers[i + 2];
            }
        }
        return -1;
    }
}

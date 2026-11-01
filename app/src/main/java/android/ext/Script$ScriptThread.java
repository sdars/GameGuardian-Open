package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$ScriptThread extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.Script f392a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Script$ScriptThread(android.ext.Script script) {
        super("Script thread");
        this.f392a = script;
        android.ext.n0.g(this);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00e2 A[Catch: all -> 0x0073, OutOfMemoryError -> 0x00fb, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0102  */
    /* JADX WARN: Code duplicated, block: B:42:0x0104 A[Catch: all -> 0x0073, OutOfMemoryError -> 0x00fb, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0118  */
    /* JADX WARN: Code duplicated, block: B:50:0x0121 A[Catch: all -> 0x0073, OutOfMemoryError -> 0x00fb, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x012e A[Catch: all -> 0x0073, OutOfMemoryError -> 0x00fb, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x014e A[Catch: all -> 0x0073, OutOfMemoryError -> 0x00fb, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0184 A[PHI: r7
      0x0184: PHI (r7v12 java.lang.String) = (r7v11 java.lang.String), (r7v18 java.lang.String), (r7v18 java.lang.String), (r7v18 java.lang.String) binds: [B:63:0x0171, B:56:0x014c, B:58:0x0158, B:60:0x015e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:67:0x018d A[Catch: all -> 0x0073, OutOfMemoryError -> 0x019a, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ea A[Catch: all -> 0x0073, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01f2 A[Catch: all -> 0x0073, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x022c A[Catch: all -> 0x0073, TryCatch #2 {all -> 0x0073, blocks: (B:3:0x0004, B:32:0x00d3, B:34:0x00e2, B:36:0x00e8, B:39:0x00fe, B:42:0x0104, B:44:0x010c, B:48:0x0119, B:50:0x0121, B:54:0x012e, B:55:0x0146, B:57:0x014e, B:59:0x015a, B:61:0x0160, B:65:0x0185, B:67:0x018d, B:70:0x019c, B:76:0x01e2, B:78:0x01ea, B:81:0x021f, B:83:0x022c, B:85:0x023d, B:80:0x01f2, B:74:0x01be, B:63:0x0171, B:13:0x0023, B:15:0x002b, B:17:0x0031, B:20:0x0076, B:22:0x007a, B:23:0x0082, B:27:0x00c3, B:26:0x00b2, B:5:0x0015), top: B:96:0x0004, inners: #8, #7 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x023b  */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
/* gg-shared-throwable */ java.lang.Throwable e = null;
        java.lang.String str;
        int i;
        android.ext.Script script;
        luaj.Globals globals;
        java.lang.String strF;
        android.ext.Script$ScriptThread$1 script$ScriptThread$1;
        int i2 = 0;
        java.lang.String strN = null;
        java.lang.String message = null;
        java.lang.Object obj;
        java.lang.String strC;
        int i3;
        java.lang.Object obj2;
        android.ext.MainService mainService = android.ext.MainService.instance;
        try {
            mainService.n0(this.f392a);
            android.ext.f1.f951a.booleanValue();
            this.f392a.N3();
            try {
                this.f392a.M3();
            } catch (android.ext.Script$OsExit e2) {
                android.ext.e1.i("Script interrupted by self: " + e2.getMessage());
                android.ext.Script script2 = this.f392a;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_exit));
                if (e2.j == 0) {
                    str = ".";
                } else {
                    str = ": " + e2.j;
                }
                sb.append(str);
                script2.Z2(sb.toString());
            } catch (luaj.d e3) {
                e = e3;
                java.lang.Throwable cause = e.getCause();
                if ((cause instanceof java.lang.InterruptedException) && this.f392a.f0 != 0) {
                    android.ext.e1.l("Script thread interrupted: " + this.f392a.f0, cause);
                    this.f392a.Z2(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_interrupted) + " [" + this.f392a.f0 + "]");
                } else if (e instanceof luaj.d$a) {
                    android.ext.n0.h(java.lang.Thread.currentThread(), e, false);
                }
                if (e != null) {
                    try {
                        android.ext.e1.l("Script error", e);
                        strN = android.ext.e1.n(e);
                        message = e.getMessage();
                        if (message != null) {
                            strN = message + '\n' + strN;
                        }
                        if (e instanceof luaj.d) {
                            if (message == null) {
                                i3 = 0;
                            } else {
                                i3 = 0;
                            }
                            android.ext.Script script3 = this.f392a;
                            obj2 = script3.U;
                            if (obj2 instanceof java.io.File) {
                                i3 = catch_.me_.if_.you_.can_.R.string.script_saved_list;
                            }
                            if (i3 != 0) {
                                this.f392a.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_possible), android.ext.b2.f(i3)));
                            }
                        }
                        obj = this.f392a.U;
                        if (obj instanceof java.io.File) {
                            i2 = 0;
                        } else {
                            i2 = 0;
                        }
                    } catch (java.lang.OutOfMemoryError e4) {
                        try {
                            strN = e4.toString() + '\n';
                        } catch (java.lang.OutOfMemoryError e5) {
                            e = e5;
                            i2 = 0;
                            this.f392a.Z2(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_oom) + ": " + e.toString());
                            i = i2;
                            script = this.f392a;
                            globals = script.T;
                            if (globals.Y == 0) {
                                script.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_wrote), android.ext.Tools.U(android.ext.Tools.f0(), this.f392a.T.a0), java.lang.Integer.valueOf(this.f392a.T.Y)));
                            } else {
                                script.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_wrote), android.ext.Tools.U(android.ext.Tools.f0(), this.f392a.T.a0), java.lang.Integer.valueOf(this.f392a.T.Y)));
                            }
                            this.f392a.L3();
                            if (this.f392a.U instanceof java.io.File) {
                                strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart);
                                script$ScriptThread$1 = new android.ext.Script$ScriptThread$1(this);
                            } else {
                                strF = null;
                                script$ScriptThread$1 = null;
                            }
                            mainService.d1(new android.ext.Script$ScriptThread$2(this, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_ended) + ":\n" + this.f392a.W.toString().trim(), i, strF, script$ScriptThread$1));
                            this.f392a.k3();
                            mainService.m0(this.f392a);
                        }
                    }
                    try {
                        if (android.ext.f1.f951a.booleanValue()) {
                            this.f392a.Z2(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.try_latest));
                        }
                        this.f392a.Z2(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_error) + ": " + strN);
                    } catch (java.lang.OutOfMemoryError e6) {
                        e = e6;
                        this.f392a.Z2(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_oom) + ": " + e.toString());
                    }
                    i = i2;
                } else {
                    i = 0;
                }
                script = this.f392a;
                globals = script.T;
                if (globals.Y == 0) {
                    script.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_wrote), android.ext.Tools.U(android.ext.Tools.f0(), this.f392a.T.a0), java.lang.Integer.valueOf(this.f392a.T.Y)));
                } else {
                    script.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_wrote), android.ext.Tools.U(android.ext.Tools.f0(), this.f392a.T.a0), java.lang.Integer.valueOf(this.f392a.T.Y)));
                }
                this.f392a.L3();
                if (this.f392a.U instanceof java.io.File) {
                    strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart);
                    script$ScriptThread$1 = new android.ext.Script$ScriptThread$1(this);
                } else {
                    strF = null;
                    script$ScriptThread$1 = null;
                }
                mainService.d1(new android.ext.Script$ScriptThread$2(this, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_ended) + ":\n" + this.f392a.W.toString().trim(), i, strF, script$ScriptThread$1));
                this.f392a.k3();
                mainService.m0(this.f392a);
            } catch (java.lang.Throwable th) {
                e = th;
                if (e != null) {
                    android.ext.e1.l("Script error", e);
                    strN = android.ext.e1.n(e);
                    message = e.getMessage();
                    if (message != null) {
                        strN = message + '\n' + strN;
                    }
                    if (e instanceof luaj.d) {
                        if (message == null) {
                            i3 = 0;
                        } else {
                            i3 = 0;
                        }
                        android.ext.Script script4 = this.f392a;
                        obj2 = script4.U;
                        if (obj2 instanceof java.io.File) {
                            i3 = catch_.me_.if_.you_.can_.R.string.script_saved_list;
                        }
                        if (i3 != 0) {
                            this.f392a.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_possible), android.ext.b2.f(i3)));
                        }
                    }
                    obj = this.f392a.U;
                    if (obj instanceof java.io.File) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                    }
                    if (android.ext.f1.f951a.booleanValue()) {
                        this.f392a.Z2(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.try_latest));
                    }
                    this.f392a.Z2(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_error) + ": " + strN);
                    i = i2;
                } else {
                    i = 0;
                }
                script = this.f392a;
                globals = script.T;
                if (globals.Y == 0) {
                    script.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_wrote), android.ext.Tools.U(android.ext.Tools.f0(), this.f392a.T.a0), java.lang.Integer.valueOf(this.f392a.T.Y)));
                } else {
                    script.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_wrote), android.ext.Tools.U(android.ext.Tools.f0(), this.f392a.T.a0), java.lang.Integer.valueOf(this.f392a.T.Y)));
                }
                this.f392a.L3();
                if (this.f392a.U instanceof java.io.File) {
                    strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart);
                    script$ScriptThread$1 = new android.ext.Script$ScriptThread$1(this);
                } else {
                    strF = null;
                    script$ScriptThread$1 = null;
                }
                mainService.d1(new android.ext.Script$ScriptThread$2(this, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_ended) + ":\n" + this.f392a.W.toString().trim(), i, strF, script$ScriptThread$1));
                this.f392a.k3();
                mainService.m0(this.f392a);
            }
            e = null;
            if (e != null) {
                android.ext.e1.l("Script error", e);
                strN = android.ext.e1.n(e);
                message = e.getMessage();
                if (message != null && !strN.contains(message)) {
                    strN = message + '\n' + strN;
                }
                if (e instanceof luaj.d) {
                    if (message == null && (message.contains("<!DOCTYPE") || message.contains("<html"))) {
                        i3 = catch_.me_.if_.you_.can_.R.string.script_web;
                    } else {
                        i3 = 0;
                    }
                    android.ext.Script script5 = this.f392a;
                    obj2 = script5.U;
                    if ((obj2 instanceof java.io.File) && script5.z3((java.io.File) obj2)) {
                        i3 = catch_.me_.if_.you_.can_.R.string.script_saved_list;
                    }
                    if (i3 != 0) {
                        this.f392a.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_possible), android.ext.b2.f(i3)));
                    }
                }
                obj = this.f392a.U;
                if ((obj instanceof java.io.File) || (strC = lasm.LasmBase.c(e, ((java.io.File) obj).getAbsolutePath(), true)) == null || strC.length() <= 0) {
                    i2 = 0;
                } else {
                    strN = strC + strN;
                    i2 = 4;
                }
                if (android.ext.f1.f951a.booleanValue()) {
                    this.f392a.Z2(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.try_latest));
                }
                this.f392a.Z2(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_error) + ": " + strN);
                i = i2;
            } else {
                i = 0;
            }
            script = this.f392a;
            globals = script.T;
            if (globals.Y == 0 || globals.a0 != 0) {
                script.Z2(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.script_wrote), android.ext.Tools.U(android.ext.Tools.f0(), this.f392a.T.a0), java.lang.Integer.valueOf(this.f392a.T.Y)));
            }
            this.f392a.L3();
            if (this.f392a.U instanceof java.io.File) {
                strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.restart);
                script$ScriptThread$1 = new android.ext.Script$ScriptThread$1(this);
            } else {
                strF = null;
                script$ScriptThread$1 = null;
            }
            mainService.d1(new android.ext.Script$ScriptThread$2(this, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.script_ended) + ":\n" + this.f392a.W.toString().trim(), i, strF, script$ScriptThread$1));
        } catch (java.lang.Throwable th2) {
            try {
                android.ext.e1.l("Script run exception", th2);
            } catch (java.lang.Throwable th3_c_c_c) {
                this.f392a.k3();
                throw th3_c_c_c;
            }
        }
        this.f392a.k3();
        mainService.m0(this.f392a);
    }
}

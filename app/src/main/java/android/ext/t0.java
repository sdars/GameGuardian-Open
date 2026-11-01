package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class t0 extends android.ext.j2 implements android.view.View.OnClickListener {
    private gg_a.e l;
    private long m;
    private long n;
    private long o;

    public t0() {
        super(catch_.me_.if_.you_.can_.R.string.search_unknown_value, catch_.me_.if_.you_.can_.R.drawable.ic_fuzzy_white_24dp);
        this.m = 0L;
        this.n = -1L;
        this.o = 0L;
    }

    public static boolean k(byte b2, java.lang.String str, int i, int i2, int i3, long j, long j2, long j3) {
        long jD;
        int i4;
        int iG;
        long j4;
        int i5 = i2 & 1006632960;
        android.ext.MainService mainService = android.ext.MainService.instance;
        int iD = i & 127 & android.ext.MainService.D() & 127;
        if (iD == 0) {
            mainService.n(b2);
            return true;
        }
        boolean z = str.indexOf(126) != -1;
        android.ext.t1$b t1_b = new android.ext.t1$b();
        if (!z) {
            jD = android.ext.c.d(t1_b, str, iD);
            i4 = i5;
            iG = iD & t1_b.f1263c;
            j4 = 0;
        } else {
            if (i5 != 536870912 && i5 != 268435456) {
                throw new java.lang.NumberFormatException(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.does_not_support), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_range_search_title), android.ext.c.B().get(i5)));
            }
            android.ext.i2$b i2_bW = android.ext.i2.w(t1_b, str, iD, i5);
            long j5 = i2_bW.f1013a;
            long j6 = i2_bW.f1014b;
            int i6 = i2_bW.f1015c;
            i4 = i2_bW.f1016d;
            iG = i6;
            j4 = j6;
            jD = j5;
        }
        if (java.lang.Integer.bitCount(iG) > 1) {
            iG = android.ext.c.g(iG, jD, t1_b.f1262b);
            if (j4 != 0) {
                iG = android.ext.c.g(iG, j4, t1_b.f1262b);
            }
        }
        int i7 = iG;
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        mainService.R(b2);
        mainService.r0 = false;
        mainService.i.D(b2, jD, j4, z ? 8388608 | i7 : i7, i4, i3, j, j2, j3);
        android.ext.MainService.N0(i7, b2);
        return false;
    }

    public static boolean l(java.lang.String str, int i, int i2, int i3, long j, long j2, long j3) {
        java.lang.String strH = android.ext.j2.h(str);
        boolean zK = k((byte) 0, strH, i, i2, i3, j, j2, j3);
        android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
        if (c2Var != null) {
            c2Var.write("gg.searchFuzzy(");
            android.ext.Script$Consts.d(c2Var, strH);
            c2Var.write(", ");
            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f373c, i2);
            c2Var.write(", ");
            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, i);
            c2Var.write(", ");
            android.ext.Script$Consts.b(c2Var, j);
            c2Var.write(", ");
            android.ext.Script$Consts.b(c2Var, j2);
            c2Var.write(", ");
            c2Var.write(java.lang.Long.toString(j3));
            c2Var.write(")\n");
        }
        return zK;
    }

    public static boolean m(byte b2, int i, long j, long j2, long j3) {
        int i2 = i & 127;
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (i2 == 0) {
            mainService.n(b2);
            return true;
        }
        if (!mainService.a1()) {
            throw new java.lang.NumberFormatException(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.busy_dialog_fail));
        }
        if (mainService.p0 != 0) {
            mainService.n(b2);
        }
        mainService.q0 = true;
        mainService.i.x0(b2);
        mainService.R(b2);
        mainService.r0 = false;
        mainService.i.F(b2, i2, j, j2, j3);
        android.ext.MainService.N0(i2, b2);
        return false;
    }

    public static boolean n(int i, long j, long j2, long j3) {
        boolean zM = m((byte) 0, i, j, j2, j3);
        android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
        if (c2Var != null) {
            c2Var.write("\ngg.startFuzzy(");
            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f372b, i);
            c2Var.write(", ");
            android.ext.Script$Consts.b(c2Var, j);
            c2Var.write(", ");
            android.ext.Script$Consts.b(c2Var, j2);
            c2Var.write(", ");
            c2Var.write(java.lang.Long.toString(j3));
            c2Var.write(")\n");
        }
        return zM;
    }

    private void o() {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_fuzzy_equal, null);
        android.widget.SeekBar seekBar = (android.widget.SeekBar) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.count_fuzzy_equal_seekbar);
        seekBar.setOnSeekBarChangeListener(new android.ext.t0$a(this, (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.count_fuzzy_equal)));
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.fuzzy_equal)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.count_fuzzy_equal_run)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), new android.ext.t0$b(this, seekBar)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).setView(viewF));
    }

    private void p() {
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (mainService.i.d0()) {
            int iD = android.ext.MainService.D();
            if (mainService.p0 == 0) {
                android.ext.Searcher searcher = new android.ext.Searcher(1, iD);
                this.j = searcher;
                this.l = searcher.G(iD);
                this.j.y(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_request));
                android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(this.j.l()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
                android.ext.f.k(alertDialogCreate, this);
                android.ext.f.l(alertDialogCreate, this);
                this.k = new java.lang.ref.WeakReference(alertDialogCreate);
                android.ext.f.m(alertDialogCreate);
                return;
            }
            android.ext.Searcher searcher2 = new android.ext.Searcher(2, iD);
            this.j = searcher2;
            this.l = searcher2.G(iD);
            this.j.y(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.compare_current_last));
            this.j.C(this);
            android.view.View viewL = this.j.l();
            ((android.widget.Button) viewL.findViewById(catch_.me_.if_.you_.can_.R.id.equal_btn)).setOnClickListener(this);
            ((android.widget.Button) viewL.findViewById(catch_.me_.if_.you_.can_.R.id.not_equal_btn)).setOnClickListener(this);
            ((android.widget.Button) viewL.findViewById(catch_.me_.if_.you_.can_.R.id.larger_btn)).setOnClickListener(this);
            ((android.widget.Button) viewL.findViewById(catch_.me_.if_.you_.can_.R.id.smaller_btn)).setOnClickListener(this);
            android.app.AlertDialog alertDialogCreate2 = android.ext.f.b().setView(viewL).create();
            android.ext.f.k(alertDialogCreate2, this);
            android.ext.f.l(alertDialogCreate2, this);
            this.k = new java.lang.ref.WeakReference(alertDialogCreate2);
            android.ext.f.n(alertDialogCreate2, this.j.g());
        }
    }

    @Override // android.ext.j2
    public void j(android.content.DialogInterface dialogInterface, int i) {
    }

    @Override // android.ext.j2, android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1) {
            onClick(((android.app.AlertDialog) dialogInterface).getButton(-1));
        } else if (android.ext.MainService.instance.p0 == 0) {
            android.ext.MainService.O0 = i;
            n(i, this.m, this.n, this.o);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.ext.j2, android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        int i;
        android.ext.MainService mainService = android.ext.MainService.instance;
        if (view == null || (view.getTag() instanceof android.ext.p1)) {
            new android.ext.t0().p();
            return;
        }
        if ((view.getTag() instanceof java.lang.Integer) && mainService.p0 == 0) {
            try {
                this.m = this.j.e(0);
                this.n = this.j.e(1);
                this.o = this.j.b();
                android.ext.Tools.U0(this.k);
                int iJ = this.j.j();
                if (iJ == 0) {
                    new android.ext.u2(this.l, "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_request), this);
                } else {
                    n(iJ, this.m, this.n, this.o);
                }
            } catch (java.lang.NumberFormatException e2) {
                android.ext.j2.i(e2, null);
                return;
            }
        }
        switch (view.getId()) {
            case catch_.me_.if_.you_.can_.R.id.equal_btn /* 2131034245 */:
                if (android.ext.Searcher.L || mainService.R) {
                    i = 536870912;
                } else {
                    o();
                    i = 0;
                }
                break;
            case catch_.me_.if_.you_.can_.R.id.larger_btn /* 2131034305 */:
                i = 67108864;
                break;
            case catch_.me_.if_.you_.can_.R.id.not_equal_btn /* 2131034341 */:
                i = 268435456;
                break;
            case catch_.me_.if_.you_.can_.R.id.smaller_btn /* 2131034408 */:
                i = 134217728;
                break;
            default:
                i = 0;
                break;
        }
        if (i != 0) {
            try {
                int iJ2 = this.j.j();
                if (iJ2 == 0 || !android.ext.Searcher.L) {
                    iJ2 = android.ext.MainService.D() & 127;
                }
                l(this.j.f(), iJ2, i, 1, this.j.e(0), this.j.e(1), this.j.b());
            } catch (java.lang.NumberFormatException e3) {
                android.ext.j2.i(e3, this.j.g());
                return;
            }
        }
        android.ext.Tools.U0(this.k);
        android.ext.Tools.E(this.k);
    }

    @Override // android.ext.j2, android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.MainService.O0 = this.j.j();
        super.onDismiss(dialogInterface);
    }
}

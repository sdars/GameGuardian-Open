package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class w1 extends android.ext.j2 {
    private static java.lang.String l = "0";
    private static boolean m = true;

    public w1() {
        super(catch_.me_.if_.you_.can_.R.string.help_pointer_search_title, catch_.me_.if_.you_.can_.R.drawable.ic_pointer_white_24dp);
    }

    private int k() {
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        return (z1_d == null || !z1_d.n) ? 4 : 36;
    }

    @Override // android.ext.j2
    public void j(android.content.DialogInterface dialogInterface, int i) {
    }

    public void l(java.lang.String str) {
        if (android.ext.MainService.instance.i.d0()) {
            android.ext.MainService mainService = android.ext.MainService.instance;
            int iK = k();
            if (this.j == null) {
                this.j = new android.ext.Searcher(4, iK);
            }
            this.j.u(str == null);
            android.ext.Searcher searcher = this.j;
            if (str == null) {
                str = this.f1037f;
            }
            searcher.z(str);
            this.j.y(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.mask_request));
            this.j.A(l);
            this.j.B(m);
            this.j.F(android.ext.c.r(iK, iK != 4), iK);
            android.app.AlertDialog.Builder negativeButton = android.ext.f.b().setView(this.j.l()).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null);
            if (mainService.p0 == 0 || (iK & android.ext.MainService.D()) == 0) {
                negativeButton.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.new_search), this);
            } else {
                negativeButton.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.refine), this).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.new_search), this);
            }
            android.app.AlertDialog alertDialogCreate = negativeButton.create();
            android.ext.f.k(alertDialogCreate, this);
            android.ext.f.l(alertDialogCreate, this);
            this.k = new java.lang.ref.WeakReference(alertDialogCreate);
            android.ext.f.n(alertDialogCreate, this.j.g());
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ab  */
    @Override // android.ext.j2, android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.StringBuilder sb;
        boolean z;
        try {
            int i2 = 16;
            long jR = android.ext.t1.r(android.ext.j2.h(this.j.f()), 16);
            java.lang.String strH = android.ext.j2.h(this.j.h());
            if (!this.j.q()) {
                i2 = 10;
            }
            long jR2 = android.ext.t1.r(strH, i2);
            int iJ = this.j.j();
            java.lang.String string = android.ext.c.G(jR, iJ) + 'h';
            java.lang.String str = android.ext.c.G(jR - jR2, iJ) + 'h';
            if (jR2 <= 0) {
                if (jR2 < 0) {
                    sb = new java.lang.StringBuilder();
                    sb.append(string);
                    sb.append('~');
                    sb.append(str);
                }
                java.lang.String str2 = string;
                long jE = this.j.e(0);
                long jE2 = this.j.e(1);
                if (i != -3 || (android.ext.MainService.D() & iJ) == 0) {
                    z = true;
                } else {
                    z = false;
                }
                android.ext.i2.r(str2, iJ, false, 536870912, jE, jE2, z, this.j.b(), 1048576);
                android.ext.MainService.instance.U0(1);
                android.ext.Tools.U0(this.k);
                android.ext.Tools.E(this.k);
            }
            sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append('~');
            sb.append(string);
            string = sb.toString();
            java.lang.String str3 = string;
            long jE3 = this.j.e(0);
            long jE4 = this.j.e(1);
            if (i != -3) {
                z = true;
            } else {
                z = true;
            }
            android.ext.i2.r(str3, iJ, false, 536870912, jE3, jE4, z, this.j.b(), 1048576);
            android.ext.MainService.instance.U0(1);
            android.ext.Tools.U0(this.k);
        } catch (java.lang.NumberFormatException e2) {
            android.ext.j2.i(e2, this.j.g());
            return;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Exception on start search", th);
        }
        android.ext.Tools.E(this.k);
    }

    @Override // android.ext.j2, android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null || !(view.getTag() instanceof java.lang.Integer)) {
            l(null);
        } else {
            onClick(null, ((java.lang.Integer) view.getTag()).intValue());
        }
    }

    @Override // android.ext.j2, android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.Searcher searcher = this.j;
        if (searcher != null) {
            m = searcher.q();
            l = this.j.h();
            this.f1037f = this.j.f();
        }
        super.onDismiss(dialogInterface);
    }
}

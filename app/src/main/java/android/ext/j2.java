package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class j2 extends android.ext.p1 implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected java.lang.String f1037f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f1038g;
    protected java.lang.String h;
    protected int i;
    protected android.ext.Searcher j;
    protected java.lang.ref.WeakReference k;

    public j2(int i, int i2) {
        super(i, i2);
        this.f1037f = "";
        this.f1038g = 536870912;
        this.h = "FFFFFFFFFFFFFFFF";
        this.i = -1;
        this.k = new java.lang.ref.WeakReference(null);
    }

    public static java.lang.String h(java.lang.String str) {
        if (str == null) {
            return str;
        }
        java.lang.String strTrim = str.trim();
        if (strTrim.length() <= 0 || str.charAt(0) != '=') {
            return str;
        }
        java.lang.String strSubstring = strTrim.substring(1);
        if (strSubstring.indexOf("return") < 0) {
            strSubstring = "return " + strSubstring;
        }
        try {
            android.ext.e1.d("oneLiner IN: '" + strSubstring + "'");
            java.lang.String strF3 = android.ext.Script.F3(strSubstring);
            android.ext.e1.d("oneLiner OUT: '" + strF3 + "'");
            return strF3;
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("oneLiner ERR:", th);
            java.lang.NumberFormatException numberFormatException = new java.lang.NumberFormatException(th.getMessage());
            numberFormatException.initCause(th);
            throw numberFormatException;
        }
    }

    public static void i(java.lang.NumberFormatException numberFormatException, android.widget.EditText editText) {
        android.app.AlertDialog.Builder positiveButton;
        android.ext.e1.s("Error", numberFormatException);
        if (editText == null || !(numberFormatException instanceof android.ext.n$b)) {
            positiveButton = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(numberFormatException.getMessage()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null);
        } else {
            positiveButton = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(numberFormatException.getMessage()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.yes), new android.ext.j2$a(editText, (android.ext.n$b) numberFormatException)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null);
        }
        android.ext.f.o(positiveButton);
    }

    public abstract void j(android.content.DialogInterface dialogInterface, int i);

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1 || i == -3) {
            this.i = i;
            onClick(null);
            return;
        }
        if (i == -2) {
            return;
        }
        try {
            this.j.E(i);
            j(dialogInterface, i);
            android.ext.Tools.U0(this.k);
        } catch (java.lang.NumberFormatException e2) {
            i(e2, this.j.g());
            return;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Exception on start search", th);
        }
        android.ext.Tools.E(this.k);
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view != null && (view.getTag() instanceof java.lang.Integer)) {
            this.i = ((java.lang.Integer) view.getTag()).intValue();
        }
        boolean z = this instanceof android.ext.m1;
        if (view == null || !(view.getTag() instanceof android.ext.p1)) {
            int iJ = this.j.j();
            if (iJ != 0) {
                onClick(null, iJ);
                return;
            }
            if (z) {
                new android.ext.u2(android.ext.c.r(127, true), "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_request), this);
                return;
            }
            try {
                java.lang.String strH = h(this.j.f());
                new android.ext.u2(android.ext.c.r(127, true), ((strH.indexOf(59) == -1 && strH.indexOf(126) == -1 && strH.indexOf(88) == -1 && strH.indexOf(120) == -1) ? 0 : 1) == 0 ? strH : "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_request), this);
                return;
            } catch (java.lang.NumberFormatException e2) {
                i(e2, this.j.g());
                return;
            }
        }
        if (android.ext.MainService.instance.i.d0()) {
            if (this.j == null) {
                this.j = new android.ext.Searcher(z ? 3 : 0, 127);
            }
            this.j.y(android.ext.b2.f(z ? catch_.me_.if_.you_.can_.R.string.mask_request : catch_.me_.if_.you_.can_.R.string.value_request));
            this.j.D(this.f1038g);
            this.j.z(this.f1037f);
            if (z) {
                this.j.x(this.h);
                this.j.k().setTag(new android.ext.InternalKeyboard$d(1));
            }
            this.j.G(127);
            android.app.AlertDialog.Builder negativeButton = android.ext.f.b().setView(this.j.l()).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null);
            if (android.ext.MainService.instance.p0 == 0) {
                negativeButton.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.new_search), this);
            } else {
                negativeButton.setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.refine), this).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.new_search), this);
            }
            this.i = -1;
            android.app.AlertDialog alertDialogCreate = negativeButton.create();
            android.ext.f.k(alertDialogCreate, this);
            android.ext.f.l(alertDialogCreate, this);
            this.k = new java.lang.ref.WeakReference(alertDialogCreate);
            android.ext.f.n(alertDialogCreate, this.j.g());
        }
    }

    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.Searcher searcher = this.j;
        if (searcher != null) {
            searcher.m();
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, -1, this);
        android.ext.Tools.s1(dialogInterface, -3, -3, this);
        android.ext.Searcher searcher = this.j;
        if (searcher != null) {
            searcher.r();
        }
    }
}

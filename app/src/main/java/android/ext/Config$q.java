package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Config$q extends android.ext.Config$p implements android.content.DialogInterface.OnShowListener, android.view.View.OnClickListener {
    int k;
    int l;
    long m;
    private java.lang.ref.WeakReference n;
    private java.lang.ref.WeakReference o;
    private boolean p;
    private boolean q;
    private int r;

    public Config$q(int i, int i2, int i3, int i4, long j, int i5, java.lang.String str, boolean z) {
        super(i, i2, i5, str, z);
        this.n = new java.lang.ref.WeakReference(null);
        this.o = new java.lang.ref.WeakReference(null);
        this.p = false;
        this.q = true;
        this.r = 8;
        this.k = i3;
        this.l = i4;
        this.m = j;
    }

    public Config$q(int i, int i2, int i3, int i4, long j, int i5, java.lang.String str, boolean z, int i6) {
        this(i, i2, i3, i4, j, i5, str, z);
        this.h = i6;
    }

    public Config$q(int i, int i2, int i3, int i4, long j, int i5, java.lang.String str, boolean z, boolean z2, boolean z3) {
        this(i, i2, i3, i4, j, i5, str, z);
        this.p = z2;
        this.q = z3;
    }

    public Config$q(int i, int i2, int i3, int i4, long j, int i5, java.lang.String str, boolean z, boolean z2, boolean z3, int i6) {
        this(i, i2, i3, i4, j, i5, str, z, z2, z3);
        this.r = i6;
    }

    private java.lang.String h() {
        int i = this.k;
        return i == 0 ? "" : android.ext.b2.f(i);
    }

    @Override // android.ext.Config$p
    public void b() {
        i();
    }

    @Override // android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        android.ext.EditText editText = (android.ext.EditText) this.o.get();
        if (editText == null) {
            return false;
        }
        try {
            java.lang.String strH = android.ext.j2.h(editText.getText().toString().trim());
            android.ext.t1$b t1_bX = android.ext.t1.x(strH);
            long j = this.l;
            long j2 = this.m;
            if (!this.f43e) {
                long j3 = t1_bX.f1261a;
                if (j3 < j || j3 > j2) {
                    throw new java.lang.NumberFormatException(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.number_out_of_range), strH) + android.ext.Tools.L1(" [%,d, %,d]", java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2)));
                }
            }
            android.ext.y0.b(strH, this.r);
            if (this.f43e) {
                long j4 = t1_bX.f1261a;
                this.f42d = (int) j4;
                this.f44f = (int) (j4 >> 32);
            } else {
                this.f42d = java.lang.Math.max((int) java.lang.Math.min(t1_bX.f1261a, this.m), this.l);
            }
            android.ext.Config.k();
            android.ext.Tools.E(this.n);
            return true;
        } catch (java.lang.NumberFormatException e2) {
            android.ext.j2.i(e2, editText);
            return false;
        }
    }

    protected void i() {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.option_edit, null);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message);
        textView.setText(android.ext.b2.f(this.f39a));
        int i = this.h;
        if (i != -1 && i != 0) {
            android.ext.Tools.r1(textView);
            textView.setOnClickListener(new android.ext.Config$q$a(this));
        }
        android.widget.TextView textView2 = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.hint);
        java.lang.String strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_edit_limit);
        java.lang.Object[] objArr = new java.lang.Object[2];
        java.lang.Object[] objArr2 = new java.lang.Object[1];
        objArr2[0] = java.lang.Long.valueOf(this.f43e ? Long.MIN_VALUE : this.l);
        objArr[0] = android.ext.Tools.L1("%,d", objArr2);
        java.lang.Object[] objArr3 = new java.lang.Object[1];
        objArr3[0] = java.lang.Long.valueOf(this.f43e ? Long.MAX_VALUE : this.m);
        objArr[1] = android.ext.Tools.L1("%,d", objArr3);
        textView2.setText(android.ext.Tools.L1(strF, objArr));
        ((android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.unit)).setText(h());
        android.widget.TextView textView3 = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.default_);
        textView3.setText(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.default_) + ": " + android.ext.Tools.L1("%,d", java.lang.Integer.valueOf(this.f40b)));
        textView3.setOnClickListener(this);
        android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.number);
        java.lang.Object[] objArr4 = new java.lang.Object[1];
        objArr4[0] = java.lang.Long.valueOf(this.f43e ? c() : this.f42d);
        editText.setText(android.ext.Tools.L1("%,d", objArr4));
        editText.setDataType(this.r);
        this.o = new java.lang.ref.WeakReference(editText);
        android.ext.HexConverter hexConverter = (android.ext.HexConverter) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.number_converter);
        hexConverter.setTag(new java.lang.Object[]{editText, 4});
        hexConverter.setVisibility(this.p ? 0 : 8);
        hexConverter.setUseXor(this.q);
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(catch_.me_.if_.you_.can_.R.string.ok, this).setNegativeButton(catch_.me_.if_.you_.can_.R.string.cancel, (android.content.DialogInterface.OnClickListener) null).create();
        android.ext.f.l(alertDialogCreate, this);
        this.n = new java.lang.ref.WeakReference(alertDialogCreate);
        android.ext.f.n(alertDialogCreate, editText);
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null || view.getId() != 2131034224) {
            onClick((android.content.DialogInterface) this.n.get(), -1);
            return;
        }
        android.ext.EditText editText = (android.ext.EditText) this.o.get();
        if (editText != null) {
            editText.setText(android.ext.Tools.L1("%,d", java.lang.Integer.valueOf(this.f40b)));
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.t1(dialogInterface, -1, null, this, (android.ext.EditText) this.o.get());
    }

    @Override // android.ext.Config$p
    public java.lang.String toString() {
        return android.ext.b2.f(this.f39a) + ' ' + android.ext.Tools.L1("%,d", java.lang.Integer.valueOf(this.f42d)) + ' ' + h();
    }
}

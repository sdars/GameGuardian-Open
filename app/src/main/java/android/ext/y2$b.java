package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y2$b implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.widget.CheckBox f1362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    android.ext.EditText f1363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.widget.CheckBox f1364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    android.ext.EditText f1365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    android.widget.CheckBox f1366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    android.ext.EditText f1367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    android.widget.CheckBox f1368g;
    android.ext.EditText h;
    android.app.AlertDialog i;
    final /* synthetic */ android.ext.y2 j;

    private y2$b(android.ext.y2 y2Var) {
        this.j = y2Var;
    }

    /* synthetic */ y2$b(android.ext.y2 y2Var, android.ext.y2$a y2_a) {
        this(y2Var);
    }

    private void a(android.widget.CheckBox checkBox, android.widget.CheckBox checkBox2, boolean z, android.ext.EditText editText, java.lang.String str) {
        checkBox2.setChecked(z);
        checkBox2.setText(android.ext.b2.g(checkBox2.getText().toString()));
        editText.setDataType(1);
        editText.setText(str);
        editText.setTag(checkBox2);
        editText.addTextChangedListener(new android.ext.y2$b$a(this, checkBox2, checkBox));
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new android.ext.y2$b$b(this, checkBox2));
            checkBox2.setOnCheckedChangeListener(new android.ext.y2$b$c(this, checkBox));
        }
    }

    private long b(android.ext.EditText editText, boolean z) {
        java.lang.String strH = android.ext.j2.h(editText.getText().toString().trim());
        long j = (z ? android.ext.t1.x(strH) : android.ext.t1.u(strH)).f1261a;
        android.ext.y0.b(strH, 1);
        return j;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        long j;
        boolean z;
        int i2;
        double d2;
        int i3;
        double d3;
        java.lang.String string;
        try {
            boolean zIsChecked = this.f1362a.isChecked();
            long jB = 0;
            boolean z2 = false;
            if (zIsChecked) {
                long jB2 = b(this.f1363b, true);
                android.ext.y2.f1361g = jB2;
                boolean zIsChecked2 = this.f1364c.isChecked();
                i2 = 2;
                if (zIsChecked2) {
                    jB = b(this.f1365d, true);
                    android.ext.y2.i = jB;
                }
                z = zIsChecked2;
                j = jB;
                jB = jB2;
            } else {
                j = 0;
                z = false;
                i2 = 0;
            }
            android.ext.y2.f1360f = zIsChecked;
            android.ext.y2.h = z;
            boolean zIsChecked3 = this.f1366e.isChecked();
            double dLongBitsToDouble = 0.0d;
            if (zIsChecked3) {
                int i4 = i2 | 4;
                double dLongBitsToDouble2 = java.lang.Double.longBitsToDouble(b(this.f1367f, false));
                android.ext.y2.k = dLongBitsToDouble2;
                boolean zIsChecked4 = this.f1368g.isChecked();
                if (zIsChecked4) {
                    dLongBitsToDouble = java.lang.Double.longBitsToDouble(b(this.h, false));
                    android.ext.y2.m = dLongBitsToDouble;
                }
                z2 = zIsChecked4;
                d2 = dLongBitsToDouble;
                i3 = i4;
                d3 = dLongBitsToDouble2;
            } else {
                d2 = 0.0d;
                i3 = i2;
                d3 = 0.0d;
            }
            android.ext.y2.j = zIsChecked3;
            android.ext.y2.l = z2;
            android.ext.y2.h(i3, jB, j, d3, d2);
            android.ext.Tools.D(dialogInterface);
            android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
            if (c2Var != null) {
                c2Var.write("gg.unrandomizer(");
                if (zIsChecked) {
                    c2Var.write(java.lang.Long.toString(jB));
                    c2Var.write(", ");
                    c2Var.write(java.lang.Long.toString(j));
                    c2Var.write(", ");
                } else {
                    c2Var.write("nil, nil, ");
                }
                if (zIsChecked3) {
                    c2Var.write(java.lang.Double.toString(d3));
                    c2Var.write(", ");
                    string = java.lang.Double.toString(d2);
                } else {
                    string = "nil, nil";
                }
                c2Var.write(string);
                c2Var.write(")\n");
            }
        } catch (java.lang.NumberFormatException e2) {
            android.ext.j2.i(e2, null);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view != null && !(view.getTag() instanceof android.ext.p1)) {
            if (view.getId() != 2131034328) {
                onClick(this.i, -1);
                return;
            } else {
                android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_unrandomizer);
                return;
            }
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.unrand, null);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message);
        android.ext.Tools.r1(textView);
        textView.setOnClickListener(this);
        this.f1362a = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_qword_use);
        this.f1363b = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_qword);
        this.f1364c = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_qword_inc_use);
        this.f1365d = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_qword_inc);
        a(null, this.f1362a, android.ext.y2.f1360f, this.f1363b, android.ext.i0.c(android.ext.y2.f1361g, 32));
        a(this.f1362a, this.f1364c, android.ext.y2.h, this.f1365d, android.ext.i0.c(android.ext.y2.i, 32));
        this.f1366e = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_double_use);
        this.f1367f = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_double);
        this.f1368g = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_double_inc_use);
        this.h = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.rd_double_inc);
        a(null, this.f1366e, android.ext.y2.j, this.f1367f, java.lang.Double.toString(android.ext.y2.k));
        a(this.f1366e, this.f1368g, android.ext.y2.l, this.h, java.lang.Double.toString(android.ext.y2.m));
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        this.i = alertDialogCreate;
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.n(this.i, this.f1363b);
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this);
    }
}

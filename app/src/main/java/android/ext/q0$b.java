package android.ext;

/* JADX INFO: loaded from: classes.dex */
class q0$b implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.view.View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.view.View f1187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.ext.EditText f1188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.widget.CheckBox f1189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.ext.EditText f1190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.widget.CheckBox f1191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.ext.EditText f1192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private android.widget.CheckBox f1193g;
    private android.ext.EditText h;
    private android.widget.CheckBox i;
    private android.ext.EditText j;
    private android.widget.CheckBox k;
    private android.ext.SystemSpinner l;
    private android.widget.CheckBox m;
    private android.ext.SystemSpinner n;
    private android.ext.EditText o;
    private android.widget.CheckBox p;
    private android.ext.SystemSpinner q;
    private final int[] r;
    private final android.widget.CheckBox[] s;
    private android.content.SharedPreferences t;
    private android.app.AlertDialog u;
    final /* synthetic */ android.ext.q0 v;

    private q0$b(android.ext.q0 q0Var) {
        this.v = q0Var;
        int[] iArr = {1, 2, 4, 8, 16, 32, 64};
        this.r = iArr;
        this.s = new android.widget.CheckBox[iArr.length];
    }

    /* synthetic */ q0$b(android.ext.q0 q0Var, android.ext.q0$a q0_a) {
        this(q0Var);
    }

    private void a(android.view.View view, android.widget.CheckBox checkBox) {
        if (view instanceof android.ext.EditText) {
            ((android.ext.EditText) view).addTextChangedListener(new android.ext.q0$b$a(this, checkBox));
        } else if (view instanceof android.ext.SystemSpinner) {
            ((android.ext.SystemSpinner) view).setOnItemSelectedListener(new android.ext.q0$b$b(this, checkBox));
        }
    }

    private void b(android.ext.g2 g2Var, android.view.View view) {
        if (view == null) {
            return;
        }
        if (view instanceof android.view.ViewGroup) {
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                try {
                    android.view.View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        b(g2Var, childAt);
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                }
            }
            return;
        }
        int id = view.getId();
        if (id == -1) {
            return;
        }
        if (view instanceof android.ext.EditText) {
            android.ext.EditText editText = (android.ext.EditText) view;
            java.lang.String str = id == 2131034233 ? "100" : "";
            if (g2Var == null) {
                editText.setText(this.t.getString(android.ext.b2.b(id), str));
                editText.setDataType(1);
                return;
            } else {
                java.lang.String strTrim = editText.getText().toString().trim();
                android.ext.y0.b(strTrim, 1);
                g2Var.k(android.ext.b2.b(id), strTrim, "");
                return;
            }
        }
        if (view instanceof android.ext.SystemSpinner) {
            android.ext.SystemSpinner systemSpinner = (android.ext.SystemSpinner) view;
            int ggSpinnerFlag = id == 2131034381 ? 536870912 : 0;
            if (g2Var == null) {
                systemSpinner.setSelected(this.t.getInt(android.ext.b2.b(id), ggSpinnerFlag));
                return;
            } else {
                g2Var.g(android.ext.b2.b(id), systemSpinner.getSelected(), ggSpinnerFlag);
                return;
            }
        }
        if (view instanceof android.widget.CheckBox) {
            android.widget.CheckBox checkBox = (android.widget.CheckBox) view;
            if (g2Var == null) {
                checkBox.setChecked(android.ext.q0.f1186f.get(id, false));
            } else {
                android.ext.q0.f1186f.put(id, checkBox.isChecked());
            }
        }
    }

    private void c() {
        if (this.f1187a != null) {
            return;
        }
        this.f1187a = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_filter_search, null);
        this.t = android.ext.Tools.M0();
        this.f1188b = (android.ext.EditText) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.eMaxShow);
        this.f1189c = (android.widget.CheckBox) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.cAddrGreat);
        this.f1190d = (android.ext.EditText) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.eAddrGreat);
        this.f1191e = (android.widget.CheckBox) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.cAddrLess);
        this.f1192f = (android.ext.EditText) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.eAddrLess);
        this.f1193g = (android.widget.CheckBox) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.cValGreat);
        this.h = (android.ext.EditText) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.eValGreat);
        this.i = (android.widget.CheckBox) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.cValLess);
        this.j = (android.ext.EditText) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.eValLess);
        this.k = (android.widget.CheckBox) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.cType);
        this.l = (android.ext.SystemSpinner) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.sType);
        this.m = (android.widget.CheckBox) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.cFractional);
        this.n = (android.ext.SystemSpinner) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.sFractional);
        this.o = (android.ext.EditText) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.eFractional);
        this.p = (android.widget.CheckBox) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.cPointer);
        this.q = (android.ext.SystemSpinner) this.f1187a.findViewById(catch_.me_.if_.you_.can_.R.id.sPointer);
        int[] iArr = {catch_.me_.if_.you_.can_.R.id.value_hex, catch_.me_.if_.you_.can_.R.id.value_rhex, catch_.me_.if_.you_.can_.R.id.value_string, catch_.me_.if_.you_.can_.R.id.value_java, catch_.me_.if_.you_.can_.R.id.value_arm, catch_.me_.if_.you_.can_.R.id.value_thumb, catch_.me_.if_.you_.can_.R.id.value_arm8};
        java.lang.CharSequence[] charSequenceArrL = android.ext.n1.l();
        int[] iArrG = android.ext.n1.g();
        int i = 0;
        while (true) {
            boolean z = true;
            if (i >= this.r.length) {
                this.f1189c.setText(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.address) + " ≥");
                this.f1191e.setText(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.address) + " ≤");
                this.f1193g.setText(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.number) + " ≥");
                this.i.setText(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.number) + " ≤");
                this.l.setData(android.ext.c.o(-1));
                android.ext.Tools.r1(this.m);
                this.m.setOnLongClickListener(this);
                this.n.setData(android.ext.c.C());
                gg_a.e eVar = new gg_a.e();
                eVar.put(4, android.ext.Tools.t("-: " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_unknown)));
                eVar.put(8, android.ext.Tools.t("R: " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.read_only), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_readable)));
                eVar.put(16, android.ext.Tools.t("W: " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.writable), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_writable)));
                eVar.put(2, android.ext.Tools.t("X: " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.executable), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_executable)));
                eVar.put(1, android.ext.Tools.t("WX: " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.writable_and_executable), android.ext.Tools.d0(catch_.me_.if_.you_.can_.R.color.pointer_executable_writable)));
                this.q.setData(eVar);
                b(null, this.f1187a);
                a(this.f1190d, this.f1189c);
                a(this.f1192f, this.f1191e);
                a(this.h, this.f1193g);
                a(this.j, this.i);
                a(this.l, this.k);
                a(this.n, this.m);
                a(this.o, this.m);
                a(this.q, this.p);
                return;
            }
            android.widget.CheckBox checkBox = (android.widget.CheckBox) this.f1187a.findViewById(iArr[i]);
            checkBox.setTextColor(iArrG[i]);
            checkBox.setText(charSequenceArrL[i]);
            if ((android.ext.AddressArrayAdapter.f23d & this.r[i]) == 0) {
                z = false;
            }
            checkBox.setChecked(z);
            checkBox.setId(-1);
            this.s[i] = checkBox;
            i++;
        }
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        onClick(((android.app.AlertDialog) dialogInterface).getButton(i));
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.String string;
        if (view == null || (view.getTag() instanceof android.ext.p1)) {
            c();
            android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(android.ext.Tools.O0(this.f1187a))).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.apply), this).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reset_button), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
            this.u = alertDialogCreate;
            android.ext.f.l(alertDialogCreate, this);
            android.ext.f.n(alertDialogCreate, this.f1188b);
            return;
        }
        if (view.getTag() instanceof java.lang.Boolean) {
            this.f1189c.setChecked(false);
            this.f1191e.setChecked(false);
            this.f1193g.setChecked(false);
            this.i.setChecked(false);
            this.k.setChecked(false);
            this.m.setChecked(false);
            this.p.setChecked(false);
            for (int i = 0; i < this.r.length; i++) {
                this.s[i].setChecked(false);
            }
        }
        try {
            int iM = android.ext.b0.m(this.f1188b.getText().toString().trim());
            if (iM < 1) {
                throw new java.lang.NumberFormatException(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.number_less), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.max_show_rec), 1));
            }
            if (iM > 100000) {
                throw new java.lang.NumberFormatException(android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.number_greater), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.max_show_rec), 100000));
            }
            java.lang.String string2 = !this.f1189c.isChecked() ? null : this.f1190d.getText().toString();
            java.lang.String string3 = !this.f1191e.isChecked() ? null : this.f1192f.getText().toString();
            java.lang.String string4 = !this.f1193g.isChecked() ? null : this.h.getText().toString();
            java.lang.String string5 = !this.i.isChecked() ? null : this.j.getText().toString();
            int selected = !this.k.isChecked() ? 0 : this.l.getSelected();
            if (this.m.isChecked()) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.n.getSelected() == 268435456 ? "!" : "");
                sb.append(this.o.getText().toString());
                string = sb.toString();
            } else {
                string = null;
            }
            android.ext.b0.o(string2, string3, string4, string5, selected, string, !this.p.isChecked() ? 0 : this.q.getSelected());
            android.ext.b0.p(iM);
            int i2 = 0;
            for (int i3 = 0; i3 < this.r.length; i3++) {
                if (this.s[i3].isChecked()) {
                    i2 |= this.r[i3];
                }
            }
            android.ext.AddressArrayAdapter.b(i2);
            android.ext.g2 g2Var = new android.ext.g2(this.t.edit());
            b(g2Var, this.f1187a);
            g2Var.commit();
            android.ext.Tools.D(this.u);
            android.ext.MainService.instance.D0(false);
        } catch (java.lang.NumberFormatException e2) {
            android.ext.e1.s("Error", e2);
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(e2.getMessage()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
        }
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        if (view == null || view.getId() != 2131034138) {
            return false;
        }
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.fractional_hint_)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
        return true;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.t1(dialogInterface, -1, null, this, this.f1188b);
        android.ext.Tools.s1(dialogInterface, -3, java.lang.Boolean.TRUE, this);
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class l0 implements android.text.TextWatcher, android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    private static volatile boolean F = false;
    private final android.view.View[] A;
    private final int[][] B;
    private final android.ext.c C;
    private int D;
    private java.lang.String E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final android.view.View f1050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.widget.TextView f1051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final android.view.View f1052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final android.widget.CheckBox f1053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final android.view.View f1054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final android.ext.EditText f1055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final android.widget.TextView f1056g;
    private final android.ext.EditText h;
    private final android.view.View i;
    private final android.ext.EditText j;
    private final android.view.View k;
    private final android.view.View l;
    private final android.view.View m;
    private final android.view.View n;
    private final android.view.View o;
    private final android.view.View p;
    private final android.view.View q;
    private final android.view.View r;
    final android.widget.CheckBox s;
    final android.widget.CheckBox t;
    final android.widget.CheckBox u;
    private final android.ext.SystemSpinner v;
    final android.view.View w;
    private final android.ext.EditText x;
    private final android.ext.EditText y;
    private final android.widget.Button z;

    public l0(int i, android.ext.c cVar) {
        this.D = i;
        this.C = cVar.c();
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_editor, null);
        this.f1050a = viewF;
        this.f1051b = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message);
        this.f1052c = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.name_row);
        this.f1053d = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.save_as);
        this.f1054e = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.name_text);
        android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.name);
        this.f1055f = editText;
        editText.setDataType(3);
        this.f1056g = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.type_hint);
        android.ext.EditText editText2 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.number);
        this.h = editText2;
        editText2.setDataType(1);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.number_converter).setTag(new java.lang.Object[]{editText2, java.lang.Integer.valueOf(cVar.f674c)});
        this.i = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.edit_step_row);
        android.ext.EditText editText3 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.edit_step);
        this.j = editText3;
        editText3.setDataType(1);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.step_converter).setTag(editText3);
        android.view.View viewFindViewById = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.edit_step_label);
        android.ext.Tools.r1(viewFindViewById);
        viewFindViewById.setOnClickListener(this);
        android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.add_not_replace);
        this.s = checkBox;
        android.ext.Tools.r1(checkBox);
        checkBox.setOnLongClickListener(this);
        this.k = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill);
        this.l = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill_values);
        this.m = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill_utf8);
        this.n = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill_utf16le);
        this.o = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill_hex);
        this.p = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill_hex_utf8);
        this.q = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill_hex_utf16le);
        this.r = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fill_hex_utf8_utf16le);
        this.t = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.change_value);
        this.u = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.freeze);
        this.v = (android.ext.SystemSpinner) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.freeze_spinner);
        this.w = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.freeze_range);
        android.ext.EditText editText4 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.freeze_from);
        this.x = editText4;
        editText4.setDataType(1);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.from_converter).setTag(editText4);
        android.ext.EditText editText5 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.freeze_to);
        this.y = editText5;
        editText5.setDataType(1);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.to_converter).setTag(editText5);
        this.z = (android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.ext_btn);
        android.ext.l0$a l0_a = new android.ext.l0$a(this);
        for (android.view.View view : viewF.getFocusables(2)) {
            if (view instanceof android.ext.EditText) {
                android.ext.Tools.z1(view, l0_a);
            }
        }
        this.A = new android.view.View[]{this.f1052c, this.f1053d, this.f1054e, this.i, this.k, this.z, this.t};
        int[][] iArr = {new int[]{1, 0, 1, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 0, 0, 0}, new int[]{0, 0, 0, 1, 1, 1, 1}, new int[]{1, 1, 0, 0, 0, 0, 0}};
        this.B = iArr;
        if (i < 0 || i >= iArr.length) {
            throw new java.lang.IllegalArgumentException("Type must be between: 0 and " + (iArr.length - 1) + " but got: " + i);
        }
        t(i);
        this.E = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.edit_examples);
        android.widget.TextView textView = (android.widget.TextView) this.f1050a.findViewById(catch_.me_.if_.you_.can_.R.id.value);
        if (i == 2) {
            android.ext.Tools.r1(textView);
            textView.setOnClickListener(this);
            this.E = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.edit_all_examples);
            p(F);
        } else if (i == 1) {
            android.ext.Tools.r1(textView);
            textView.setOnClickListener(this);
        }
        this.z.setOnClickListener(this);
        textView.setText(android.ext.Tools.O1(textView.getText().toString()) + ':');
        m();
        this.f1055f.addTextChangedListener(this);
    }

    private void m() {
        this.f1056g.setText(android.ext.c.s(this.C.f674c));
        this.h.setText(this.C.J());
        this.j.setText("0");
        this.t.setChecked(true);
        android.ext.l0$b l0_b = new android.ext.l0$b(this);
        this.h.addTextChangedListener(l0_b);
        this.j.addTextChangedListener(l0_b);
        this.s.setOnCheckedChangeListener(new android.ext.l0$c(this));
        this.u.setOnCheckedChangeListener(new android.ext.l0$d(this));
        this.v.setData(android.ext.h2.a0());
        this.v.setOnItemSelectedListener(new android.ext.l0$e(this));
        android.ext.c cVar = this.C;
        if (!(cVar instanceof android.ext.h2)) {
            this.u.setChecked(false);
            this.v.setSelected(0);
            this.x.setText("0");
            this.y.setText("0");
            return;
        }
        android.ext.h2 h2Var = (android.ext.h2) cVar;
        this.f1055f.setText(h2Var.b0());
        this.u.setChecked(h2Var.m);
        this.v.setSelected(h2Var.n);
        this.x.setText(h2Var.c0(true));
        this.y.setText(h2Var.c0(false));
    }

    private void p(boolean z) {
        F = z;
        this.z.setText(android.ext.b2.f(z ? catch_.me_.if_.you_.can_.R.string.less : catch_.me_.if_.you_.can_.R.string.more));
        int i = 8;
        this.i.setVisibility(z ? 0 : 8);
        this.k.setVisibility(z ? 0 : 8);
        this.m.setVisibility((z && this.C.f674c == 1) ? 0 : 8);
        this.n.setVisibility((!z || (this.C.f674c & 7) == 0) ? 8 : 0);
        if (z && this.C.f674c == 1) {
            i = 0;
        }
        this.o.setVisibility(i);
        this.p.setVisibility(i);
        this.q.setVisibility(i);
        this.r.setVisibility(i);
    }

    private void t(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.B[i];
            if (i2 >= iArr.length) {
                return;
            }
            this.A[i2].setVisibility(iArr[i2] == 1 ? 0 : 8);
            i2++;
        }
    }

    boolean u() {
        if ((android.ext.Config.B & 1) == 0) {
            return false;
        }
        boolean z = this.h.isFocused() && android.ext.t1.n(this.h.getText().toString());
        android.ext.InternalKeyboard.i(this.h, z);
        return z;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        this.f1053d.setChecked(true);
    }

    public java.lang.String b() {
        if (this.i.getVisibility() != 0) {
            return "0";
        }
        java.lang.String strTrim = this.j.getText().toString().trim();
        android.ext.y0.b(strTrim, 1);
        return strTrim;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    public android.ext.c c() {
        return this.C;
    }

    public java.lang.String d() {
        java.lang.String strTrim = this.f1055f.getText().toString().trim();
        android.ext.y0.b(strTrim, 2);
        return strTrim;
    }

    public java.lang.String e() {
        java.lang.String strTrim = this.h.getText().toString().trim();
        android.ext.y0.b(strTrim, 1);
        return strTrim;
    }

    public android.ext.EditText f() {
        return this.h;
    }

    public android.ext.h2 g() {
        return h(this.C);
    }

    public android.ext.h2 h(android.ext.c cVar) {
        android.ext.h2 h2Var = new android.ext.h2(cVar);
        h2Var.m = this.u.isChecked();
        h2Var.d0(this.v.getSelected());
        if (h2Var.n == 3) {
            h2Var.e0(android.ext.j2.h(this.x.getText().toString().trim()), android.ext.j2.h(this.y.getText().toString().trim()));
        }
        if (!h2Var.m && this.s.isChecked()) {
            h2Var.f674c |= 1073741824;
        }
        if ((this.f1053d.getVisibility() == 0 && this.f1053d.isChecked()) || this.f1054e.getVisibility() == 0) {
            java.lang.String strD = d();
            if (!h2Var.b0().equals(strD)) {
                h2Var.l = strD;
            }
        }
        return h2Var;
    }

    public android.view.View i() {
        return this.f1050a;
    }

    public android.view.View j() {
        return android.ext.InternalKeyboard.d(k());
    }

    public android.view.View k() {
        return android.ext.Tools.O0(i());
    }

    public void l() {
        this.f1053d.setChecked(true);
    }

    public boolean n() {
        if (this.u.isChecked()) {
            return true;
        }
        if (this.f1052c.getVisibility() == 0) {
            return (this.f1053d.getVisibility() == 0 && this.f1053d.isChecked()) || this.f1054e.getVisibility() == 0;
        }
        return false;
    }

    public boolean o() {
        return this.t.isChecked();
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == 2131034240) {
            android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_fill);
            return;
        }
        if (id != 2131034248) {
            if (id != 2131034438) {
                return;
            }
            android.ext.Searcher.I(this.E);
        } else {
            if (this.D == 2) {
                p(!F);
            }
            this.h.requestFocus();
        }
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        if (view == null || view.getId() != 2131034115) {
            return false;
        }
        android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_add_to_value);
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        this.f1053d.setChecked(true);
    }

    public void q(android.view.View.OnClickListener view$OnClickListener) {
        this.l.setOnClickListener(view$OnClickListener);
        this.m.setOnClickListener(view$OnClickListener);
        this.n.setOnClickListener(view$OnClickListener);
        this.o.setOnClickListener(view$OnClickListener);
        this.p.setOnClickListener(view$OnClickListener);
        this.q.setOnClickListener(view$OnClickListener);
        this.r.setOnClickListener(view$OnClickListener);
    }

    public void r(java.lang.CharSequence charSequence) {
        this.f1051b.setText(charSequence);
    }

    public void s(java.lang.String str) {
        this.h.setText(str.trim());
    }
}

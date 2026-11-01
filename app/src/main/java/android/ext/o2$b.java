package android.ext;

/* JADX INFO: loaded from: classes.dex */
class o2$b implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.content.DialogInterface.OnDismissListener, android.text.TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.ext.EditText f1161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    android.widget.TextView f1162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    android.widget.TextView f1163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    android.app.AlertDialog f1164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.o2 f1165e;

    private o2$b(android.ext.o2 o2Var) {
        this.f1165e = o2Var;
    }

    /* synthetic */ o2$b(android.ext.o2 o2Var, android.ext.o2$a o2_a) {
        this(o2Var);
    }

    public void a() {
        java.lang.String strG1;
        android.ext.EditText editText = this.f1161a;
        android.widget.TextView textView = this.f1162b;
        if (editText == null) {
            strG1 = "?";
        } else {
            try {
                strG1 = android.ext.Tools.g1(android.ext.o2.i(editText.getText().toString().trim()) / 1000000000);
            } catch (java.lang.NumberFormatException unused) {
                strG1 = "???";
            }
        }
        if (textView != null) {
            textView.setText(strG1);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        a();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        try {
            java.lang.String strH = android.ext.j2.h(this.f1161a.getText().toString().trim());
            android.ext.o2.h(android.ext.o2.i(strH));
            android.ext.y0.b(strH, 1);
            android.ext.Tools.D(dialogInterface);
        } catch (java.lang.NumberFormatException e2) {
            android.ext.j2.i(e2, this.f1161a);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view != null && !(view.getTag() instanceof android.ext.p1)) {
            int id = view.getId();
            if (id == 2131034205) {
                android.ext.Config$p config$pB = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_time_jump_panel);
                config$pB.g(new android.ext.o2$b$a(this, config$pB));
                config$pB.b();
                return;
            } else if (id != 2131034246) {
                onClick(this.f1164d, -1);
                return;
            } else {
                android.ext.Searcher.I(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.examples_timejump));
                return;
            }
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.time_jump, null);
        android.ext.Config.m((android.widget.ImageView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.examples)).setOnClickListener(this);
        this.f1162b = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.hint);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.config_time_jump_panel);
        this.f1163c = textView;
        textView.setOnClickListener(this);
        this.f1163c.setText(android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_time_jump_panel).toString());
        this.f1161a = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.time_jump);
        java.lang.String strF = android.ext.o2.f1158f;
        if (strF.length() == 0 || "0".equals(strF)) {
            strF = android.ext.Tools.F(((double) android.ext.Config.v) / 1000.0d);
        }
        this.f1161a.setText(strF);
        this.f1161a.addTextChangedListener(this);
        this.f1161a.setDataType(1);
        a();
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.back), (android.content.DialogInterface.OnClickListener) null).create();
        this.f1164d = alertDialogCreate;
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.k(this.f1164d, this);
        android.ext.f.n(this.f1164d, this.f1161a);
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.o2.f1158f = this.f1161a.getText().toString().trim();
        try {
            android.ext.o2.j(android.ext.o2.i(android.ext.j2.h(android.ext.o2.f1158f)));
        } catch (java.lang.NumberFormatException unused) {
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        a();
    }
}

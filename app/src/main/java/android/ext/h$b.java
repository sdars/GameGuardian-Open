package android.ext;

/* JADX INFO: loaded from: classes.dex */
class h$b implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.CheckBox f994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.widget.CheckBox f995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.widget.CheckBox f996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.ext.EditText f997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.app.AlertDialog f998e;

    private h$b() {
        this.f994a = null;
        this.f995b = null;
        this.f996c = null;
        this.f997d = null;
        this.f998e = null;
    }

    /* synthetic */ h$b(android.ext.h$a h_a) {
        this();
    }

    public void a(java.lang.String str) {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.alloc, null);
        android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.memory_from);
        this.f997d = editText;
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.region_from).setTag(editText);
        if (str != null) {
            editText.setText(str);
        }
        editText.setDataType(1);
        this.f994a = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.read);
        this.f995b = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.write);
        this.f996c = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.exec);
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.allocate_page)).setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        this.f998e = alertDialogCreate;
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.n(alertDialogCreate, editText);
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.EditText editText = this.f997d;
        if (editText == null) {
            return;
        }
        try {
            java.lang.String strH = android.ext.j2.h(editText.getText().toString().trim());
            if (strH.endsWith("h")) {
                strH = strH.substring(0, strH.length() - 1);
            }
            if (strH.length() == 0) {
                strH = "0";
            }
            try {
                long jR = android.ext.t1.r(strH, 16);
                if (jR != 0) {
                    android.ext.y0.b(strH, 1);
                }
                int i2 = this.f994a.isChecked() ? 2 : 0;
                if (this.f995b.isChecked()) {
                    i2 |= 1;
                }
                if (this.f996c.isChecked()) {
                    i2 |= 4;
                }
                android.ext.e1.d("Allocate: " + i2 + "; " + jR);
                android.ext.Tools.D(this.f998e);
                android.ext.MainService.instance.i.g(jR, i2);
                android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
                if (c2Var != null) {
                    c2Var.write("gg.allocatePage(");
                    android.ext.Script$Consts.a(c2Var, c2Var.f697c.f377g, i2);
                    c2Var.write(", ");
                    android.ext.Script$Consts.b(c2Var, jR);
                    c2Var.write(")\n");
                }
            } catch (java.lang.NumberFormatException e2_c_c_c) {
                editText.requestFocus();
                throw e2_c_c_c;
            }
        } catch (java.lang.NumberFormatException e3) {
            android.ext.j2.i(e3, editText);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null || (view.getTag() instanceof android.ext.p1)) {
            a(null);
        } else {
            onClick(null, -1);
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(this.f998e, -1, null, this);
    }
}

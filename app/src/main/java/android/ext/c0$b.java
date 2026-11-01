package android.ext;

/* JADX INFO: loaded from: classes.dex */
class c0$b implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.ext.EditText f681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.app.AlertDialog f682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.ext.EditText f683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.ext.EditText f684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f687g;

    private c0$b() {
        this.f685e = 0L;
        this.f686f = 0L;
        this.f687g = 0;
    }

    /* synthetic */ c0$b(android.ext.c0$a c0_a) {
        this();
    }

    private long a(int i) {
        long jB = android.ext.MemoryRange.b(i, this.f683c, "0", this.f684d, "0");
        if (i == 0) {
            this.f685e = jB;
        } else {
            this.f686f = jB;
        }
        return jB;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.EditText editText = this.f681a;
        if (editText == null) {
            return;
        }
        try {
            a(0);
            a(1);
            java.lang.String strH = android.ext.j2.h(editText.getText().toString().trim());
            if (strH.length() == 0) {
                strH = "0";
            }
            try {
                int i2 = (int) android.ext.t1.x(strH).f1261a;
                this.f687g = i2;
                if (i2 != 0) {
                    android.ext.y0.b(strH, 1);
                }
                android.ext.e1.d("Copy: " + this.f687g + "; " + java.lang.Long.toHexString(this.f685e) + '-' + java.lang.Long.toHexString(this.f686f));
                android.ext.Tools.D(this.f682b);
                android.ext.MainService.instance.i.q(this.f685e, this.f686f, this.f687g);
                android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
                if (c2Var != null) {
                    c2Var.write("gg.copyMemory(");
                    android.ext.Script$Consts.b(c2Var, this.f685e);
                    c2Var.write(", ");
                    android.ext.Script$Consts.b(c2Var, this.f686f);
                    c2Var.write(", ");
                    c2Var.write(java.lang.Integer.toString(this.f687g));
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
        if (view != null && !(view.getTag() instanceof android.ext.p1)) {
            onClick(null, -1);
            return;
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.memory_copy, null);
        android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.count_bytes);
        this.f681a = editText;
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.bytes_converter).setTag(editText);
        editText.setText(android.ext.i0.c(this.f687g, 4));
        editText.setDataType(1);
        android.ext.EditText editText2 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.memory_from);
        this.f683c = editText2;
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.region_from).setTag(editText2);
        android.ext.EditText editText3 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.memory_dst);
        this.f684d = editText3;
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.region_dst).setTag(editText3);
        editText2.setText(android.ext.c.G(this.f685e, 4));
        editText2.setDataType(1);
        editText3.setText(android.ext.c.G(this.f686f, 4));
        editText3.setDataType(1);
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.copy_memory)).setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        this.f682b = alertDialogCreate;
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.n(alertDialogCreate, editText);
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this);
    }
}

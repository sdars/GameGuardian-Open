package android.ext;

/* JADX INFO: loaded from: classes.dex */
class j0$b implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.content.DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.EditText f1028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.app.AlertDialog f1029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.ext.EditText f1030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.ext.EditText f1031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.widget.CheckBox f1032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f1033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f1034g;

    private j0$b() {
        this.f1033f = 0L;
        this.f1034g = -1L;
    }

    /* synthetic */ j0$b(android.ext.j0$a j0_a) {
        this();
    }

    private java.lang.String a() {
        return android.ext.Tools.K0() + "/dump";
    }

    private long b(int i) {
        long jB = android.ext.MemoryRange.b(i, this.f1030c, "0", this.f1031d, "-1");
        if (i == 0) {
            this.f1033f = jB;
        } else {
            this.f1034g = jB;
        }
        return jB;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.widget.EditText editText = this.f1028a;
        if (editText == null) {
            return;
        }
        try {
            b(0);
            b(1);
            java.lang.String strQ1 = android.ext.Tools.Q1(editText.getText().toString().trim());
            if (android.ext.Tools.f1(strQ1)) {
                android.ext.y0.b(strQ1, 4);
                boolean zIsChecked = this.f1032e.isChecked();
                android.ext.e1.d("Dump: " + strQ1 + "; " + java.lang.Long.toHexString(this.f1033f) + '-' + java.lang.Long.toHexString(this.f1034g) + "; " + java.lang.Integer.toHexString(zIsChecked ? 1 : 0));
                android.ext.Tools.D(this.f1029b);
                android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
                java.lang.String str = z1_d == null ? "unknown" : z1_d.f1434c;
                if (android.ext.MainService.instance.a1()) {
                    android.ext.MainService.instance.i.x(this.f1033f, this.f1034g, zIsChecked ? 1 : 0, strQ1, str);
                    android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
                    if (c2Var != null) {
                        c2Var.write("gg.dumpMemory(");
                        android.ext.Script$Consts.b(c2Var, this.f1033f);
                        c2Var.write(", ");
                        android.ext.Script$Consts.b(c2Var, this.f1034g);
                        c2Var.write(", ");
                        android.ext.Script$Consts.d(c2Var, strQ1);
                        c2Var.write(", ");
                        android.ext.Script$Consts.a(c2Var, c2Var.f697c.i, zIsChecked ? 1 : 0);
                        c2Var.write(")\n");
                    }
                }
            }
        } catch (java.lang.NumberFormatException e2) {
            android.ext.j2.i(e2, editText);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view != null && !(view.getTag() instanceof android.ext.p1)) {
            onClick(null, -1);
            return;
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.dump, null);
        android.ext.EditTextPath editTextPath = (android.ext.EditTextPath) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.path);
        this.f1028a = editTextPath;
        editTextPath.setText(android.ext.Tools.M0().getString("dump-path", a()));
        editTextPath.setDataType(4);
        editTextPath.setPathType(0);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.path_selector).setTag(editTextPath);
        android.ext.v2.a((android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.typical_values), editTextPath);
        android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.memory_from);
        this.f1030c = editText;
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.region_from).setTag(editText);
        android.ext.EditText editText2 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.memory_to);
        this.f1031d = editText2;
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.region_to).setTag(editText2);
        editText.setText(android.ext.c.G(this.f1033f, 4));
        editText.setDataType(1);
        android.ext.InternalKeyboard.o(editText, 1);
        editText2.setText(android.ext.c.G(this.f1034g, 4));
        editText2.setDataType(1);
        this.f1032e = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.skip_system_libs);
        android.ext.j0$b$a j0_b_a = new android.ext.j0$b$a(this, editTextPath);
        for (android.view.View view2 : viewF.getFocusables(2)) {
            if (view2 instanceof android.ext.EditText) {
                android.ext.Tools.z1(view2, j0_b_a);
            }
        }
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.save), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        this.f1029b = alertDialogCreate;
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.k(alertDialogCreate, this);
        android.ext.f.n(alertDialogCreate, editTextPath);
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.widget.EditText editText = this.f1028a;
        if (editText == null) {
            return;
        }
        new android.ext.g2().k("dump-path", editText.getText().toString().trim(), a()).commit();
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this);
    }
}

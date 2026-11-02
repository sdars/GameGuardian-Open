package android.ext;

/* JADX INFO: loaded from: classes.dex */
class o0$b implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.content.DialogInterface.OnDismissListener, android.view.View.OnClickListener, android.view.View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.app.AlertDialog f1141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.widget.EditText f1142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.widget.EditText f1143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.widget.CheckBox f1144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.widget.CheckBox f1145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.widget.CheckBox f1146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private android.widget.Button f1147g;
    private android.view.View h;
    final /* synthetic */ android.ext.o0 i;

    private o0$b(android.ext.o0 o0Var) {
        this.i = o0Var;
    }

    /* synthetic */ o0$b(android.ext.o0 o0Var, android.ext.o0$a o0_a) {
        this(o0Var);
    }

    private void a() {
        boolean z = android.ext.o0.f1139f;
        this.f1147g.setText(android.ext.b2.f(z ? catch_.me_.if_.you_.can_.R.string.less : catch_.me_.if_.you_.can_.R.string.more));
        this.h.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r6v1, types: [android.ext.MainService] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
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
        int r0;
        int r1;
        android.ext.o0.f1140g = this.f1144d.isChecked();
        android.ext.o0.h = this.f1145e.isChecked();
        android.ext.o0.i = this.f1146f.isChecked();
        java.lang.String strTrim = this.f1143c.getText().toString().trim();
        if (!android.ext.o0.f1139f) {
            r0 = 0;
        } else {
            if (!android.ext.Tools.f1(strTrim)) {
                return;
            }
            boolean z = android.ext.o0.f1140g;
            if (android.ext.o0.h) {
                r1 = (z ? 1 : 0);
                r1 = (z ? 1 : 0) | 2;
            }
            r1 = (z ? 1 : 0);
            r0 = r1;
            if (android.ext.o0.i) {
                r0 = (r1 != 0 ? 1 : 0) | 4;
            }
        }
        android.ext.y0.b(strTrim, 4);
        android.widget.EditText editText = this.f1142b;
        if (editText == null) {
            return;
        }
        java.lang.String strTrim2 = editText.getText().toString().trim();try {

        if (android.ext.Tools.f1(strTrim2) && android.ext.Tools.a1(strTrim2)) {
            android.ext.y0.b(strTrim2, 4);
            if (android.ext.MainService.instance.f212b != null) {
                android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.another_script)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.interrupt), new android.ext.o0$b$a(this, i)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null));
                return;
            }
            android.ext.MainService.instance.x(strTrim2, r0, strTrim);
            android.ext.Tools.D(this.f1141a);
            android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
            if (c2Var != null) {
                c2Var.write("loadfile(");
                android.ext.Script$Consts.d(c2Var, strTrim2);
                c2Var.write(")()\n");
            }
        };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.String str;
        java.lang.String strL1;
        if (view != null && !(view.getTag() instanceof android.ext.p1)) {
            int id = view.getId();
            if (id == 2131034246) {
                new android.ext.Script("print('gg =', gg)", 0, "").R3();
                return;
            }
            if (id == 2131034248) {
                android.ext.o0.f1139f = !android.ext.o0.f1139f;
                a();
                return;
            }
            if (id != 2131034278) {
                onClick(null, -1);
                return;
            }
            java.io.File file = new java.io.File(android.ext.Tools.K0(), "help.zip");
            try {
                android.ext.Tools.M("he", file);
                str = null;
            } catch (java.lang.RuntimeException e2) {
                str = "" + e2.getMessage();
            }
            android.app.AlertDialog.Builder customTitle = android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.help_extract));
            if (str == null) {
                strL1 = android.ext.Tools.L1(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help_extract_done), file.getAbsolutePath());
            } else {
                strL1 = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.help_extract_fail) + ": " + str;
            }
            android.ext.f.o(customTitle.setMessage(strL1).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
            return;
        }
        if (android.ext.MainService.instance.i.d0()) {
            android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.execute, null);
            ((android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message)).setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.execute_script));
            android.ext.EditTextPath editTextPath = (android.ext.EditTextPath) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.file);
            this.f1142b = editTextPath;
            editTextPath.setText(android.ext.v1.a("script-path", "-script", ".lua"));
            editTextPath.setDataType(4);
            editTextPath.setPathType(1);
            viewF.findViewById(catch_.me_.if_.you_.can_.R.id.file_selector).setTag(editTextPath);
            android.ext.Config.m((android.widget.ImageView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.examples)).setOnClickListener(this);
            viewF.findViewById(catch_.me_.if_.you_.can_.R.id.download_scripts).setOnClickListener(new android.ext.r$n("kwws=22jdphjxdugldq1qhw2iruxp2ilohv2fdwhjru|290oxd0vfulswv2"));
            viewF.findViewById(catch_.me_.if_.you_.can_.R.id.help).setOnClickListener(new android.ext.r$n("kwws=22jdphjxdugldq1qhw2khos2"));
            viewF.findViewById(catch_.me_.if_.you_.can_.R.id.help_extract).setOnClickListener(this);
            this.h = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.debug);
            android.ext.EditTextPath editTextPath2 = (android.ext.EditTextPath) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.path);
            this.f1143c = editTextPath2;
            editTextPath2.setText(android.ext.v1.b(null, "script-debug"));
            editTextPath2.setDataType(4);
            editTextPath2.setPathType(0);
            viewF.findViewById(catch_.me_.if_.you_.can_.R.id.path_selector).setTag(editTextPath2);
            android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.disassemble);
            this.f1144d = checkBox;
            checkBox.setChecked(android.ext.o0.f1140g);
            android.ext.Tools.r1(checkBox);
            checkBox.setOnLongClickListener(this);
            android.widget.CheckBox checkBox2 = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.load);
            this.f1145e = checkBox2;
            checkBox2.setChecked(android.ext.o0.h);
            android.widget.CheckBox checkBox3 = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.log);
            this.f1146f = checkBox3;
            checkBox3.setChecked(android.ext.o0.i);
            android.widget.Button button = (android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.ext_btn);
            this.f1147g = button;
            button.setOnClickListener(this);
            a();
            android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.e(viewF, false)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.execute), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
            android.ext.f.l(alertDialogCreate, this);
            android.ext.f.k(alertDialogCreate, this);
            this.f1141a = alertDialogCreate;
            android.ext.f.n(alertDialogCreate, editTextPath);
        }
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.widget.EditText editText = this.f1142b;
        if (editText != null) {
            android.ext.v1.c(editText.getText().toString(), "script-path", "-script", ".lua");
        }
        android.widget.EditText editText2 = this.f1143c;
        if (editText2 != null) {
            android.ext.v1.b(editText2.getText().toString().trim(), "script-debug");
        }
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        if (view == null || view.getId() != 2131034226) {
            return false;
        }
        android.ext.ConfigListAdapter.t(catch_.me_.if_.you_.can_.R.string.help_lasm);
        return true;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this);
    }
}

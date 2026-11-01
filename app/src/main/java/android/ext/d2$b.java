package android.ext;

/* JADX INFO: loaded from: classes.dex */
class d2$b implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.content.DialogInterface.OnDismissListener, android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.app.AlertDialog f720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.widget.EditText f721b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.d2 f722c;

    private d2$b(android.ext.d2 d2Var) {
        this.f722c = d2Var;
    }

    /* synthetic */ d2$b(android.ext.d2 d2Var, android.ext.d2$a d2_a) {
        this(d2Var);
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.widget.EditText editText = this.f721b;
        if (editText == null) {
            return;
        }
        java.lang.String strTrim = editText.getText().toString().trim();
        if (android.ext.Tools.f1(strTrim)) {
            if (android.ext.MainService.instance.f216f != null) {
                android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.another_record)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.stop), new android.ext.d2$b$a(this, i)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no), (android.content.DialogInterface.OnClickListener) null));
                return;
            }
            try {
                android.ext.c2 c2Var = new android.ext.c2(strTrim);
                android.ext.y0.b(strTrim, 4);
                android.ext.MainService.instance.f1(c2Var);
                android.ext.Tools.D(this.f720a);
            } catch (java.lang.Throwable th) {
                android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.error)).setMessage(strTrim + "\n\n" + th.toString()).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
            }
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view != null && !(view.getTag() instanceof android.ext.p1)) {
            onClick(null, -1);
            return;
        }
        if (android.ext.MainService.instance.i.d0()) {
            android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.save, null);
            ((android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message)).setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record_script));
            android.ext.EditTextPath editTextPath = (android.ext.EditTextPath) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.file);
            this.f721b = editTextPath;
            editTextPath.setText(android.ext.v1.a("record-path", "-record", ".lua"));
            editTextPath.setDataType(4);
            editTextPath.setPathType(2);
            viewF.findViewById(catch_.me_.if_.you_.can_.R.id.path_selector).setTag(editTextPath);
            android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.e(viewF, false)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.record), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
            android.ext.f.l(alertDialogCreate, this);
            android.ext.f.k(alertDialogCreate, this);
            this.f720a = alertDialogCreate;
            android.ext.f.n(alertDialogCreate, editTextPath);
        }
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.widget.EditText editText = this.f721b;
        if (editText != null) {
            android.ext.v1.c(editText.getText().toString(), "record-path", "-record", ".lua");
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this);
    }
}

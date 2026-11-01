package android.ext;

/* JADX INFO: loaded from: classes.dex */
class u0$b implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static java.lang.String f1268c = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.app.AlertDialog f1269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.ext.EditText f1270b;

    private u0$b() {
    }

    /* synthetic */ u0$b(android.ext.u0$a u0_a) {
        this();
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i == -1) {
            onClick(((android.app.AlertDialog) dialogInterface).getButton(i));
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view != null && !(view.getTag() instanceof android.ext.p1)) {
            if (view.getId() == 2131034286) {
                android.ext.Tools.D(this.f1269a);
                android.ext.MainService.instance.O.d();
                return;
            }
            if (view.getId() == 2131034116) {
                android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.examples) + ":\nBAFE890\nBAFE890+3F0\nBAFE890-A40\nBAFE890+FE-CD7+44-3E\n\nlibc.so\nlibc.so+E0\nlibc.so-32C").setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help), android.ext.ConfigListAdapter.h()).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
                return;
            }
            try {
                android.ext.EditText editText = this.f1270b;
                if (editText != null) {
                    java.lang.String strH = android.ext.j2.h(editText.getText().toString().trim());
                    android.ext.y0.b(strH, 1);
                    android.ext.MainService.instance.L(null, strH, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.from_goto));
                }
                android.ext.Tools.D(this.f1269a);
                return;
            } catch (java.lang.NumberFormatException e2) {
                android.ext.j2.i(e2, this.f1270b);
                return;
            }
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_goto, null);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.addr);
        android.ext.Tools.r1(textView);
        textView.setOnClickListener(this);
        android.ext.EditText editText2 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mem_edit_addr);
        this.f1270b = editText2;
        android.ext.RegionList regionList = (android.ext.RegionList) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.region_from);
        regionList.setTag(editText2);
        android.ext.u0$b$a u0_b_a = new android.ext.u0$b$a(this, regionList);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.cd).setOnClickListener(u0_b_a);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.cb).setOnClickListener(u0_b_a);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.ps).setOnClickListener(u0_b_a);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.xa).setOnClickListener(u0_b_a);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.history).setOnClickListener(this);
        editText2.setText(f1268c);
        editText2.setDataType(1);
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.goto1), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        this.f1269a = alertDialogCreate;
        android.ext.f.k(alertDialogCreate, this);
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.n(alertDialogCreate, editText2);
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.EditText editText = this.f1270b;
        if (editText != null) {
            f1268c = editText.getText().toString().trim();
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.t1(dialogInterface, -1, null, this, this.f1270b);
    }
}

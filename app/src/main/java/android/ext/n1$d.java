package android.ext;

/* JADX INFO: loaded from: classes.dex */
class n1$d extends android.ext.p1 implements android.content.DialogInterface.OnClickListener, android.widget.CompoundButton.OnCheckedChangeListener, android.text.TextWatcher {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private java.lang.ref.WeakReference f1128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private java.lang.ref.WeakReference f1129g;
    private java.lang.ref.WeakReference h;
    boolean i;
    final /* synthetic */ android.ext.n1 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1$d(android.ext.n1 n1Var) {
        super(catch_.me_.if_.you_.can_.R.string.filter, catch_.me_.if_.you_.can_.R.drawable.ic_filter_white_24dp);
        this.j = n1Var;
        this.f1128f = new java.lang.ref.WeakReference(null);
        this.f1129g = new java.lang.ref.WeakReference(null);
        this.h = new java.lang.ref.WeakReference(null);
        this.i = false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        java.lang.String string = editable.toString();
        android.widget.CheckBox checkBox = (android.widget.CheckBox) this.f1129g.get();
        if (checkBox == null) {
            return;
        }
        checkBox.setChecked(string.indexOf(94) != -1);
        android.widget.CheckBox checkBox2 = (android.widget.CheckBox) this.h.get();
        if (checkBox2 == null) {
            return;
        }
        checkBox2.setChecked(string.indexOf(36) != -1);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        android.ext.EditText editText;
        java.lang.String string;
        java.lang.String str;
        if (compoundButton == null || (editText = (android.ext.EditText) this.f1128f.get()) == null) {
            return;
        }
        int id = compoundButton.getId();
        if (id == 2131034244) {
            string = editText.getText().toString();
            str = "$";
            if (string.contains("$") == z) {
                return;
            }
            if (z) {
                editText.getText().replace(string.length(), string.length(), "$");
                return;
            }
        } else {
            if (id == 2131034249) {
                this.i = z;
                android.view.View.OnFocusChangeListener onFocusChangeListener = editText.getOnFocusChangeListener();
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChange(editText, true);
                    return;
                }
                return;
            }
            if (id != 2131034416) {
                return;
            }
            string = editText.getText().toString();
            str = "^";
            if (string.contains("^") == z) {
                return;
            }
            if (z) {
                editText.getText().replace(0, 0, "^");
                return;
            }
        }
        int iIndexOf = string.indexOf(str);
        editText.getText().replace(iIndexOf, iIndexOf + 1, "");
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.String string;
        java.lang.String strF;
        if (i == -1) {
            android.ext.EditText editText = (android.ext.EditText) this.f1128f.get();
            if (editText == null) {
                return;
            }
            string = editText.getText().toString();
            if (string.length() > 0) {
                android.ext.y0.b(string, this.i ? 2 : 1);
            }
        } else {
            string = "";
        }
        this.j.f1115a = string;
        android.widget.TextView textView = android.ext.MainService.instance.t;
        if (string.length() > 0) {
            strF = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.filter) + ": " + string;
        } else {
            strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no_filter);
        }
        textView.setText(strF);
        this.j.notifyDataSetChanged();
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view != null && view.getId() == 2131034328) {
            android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.examples) + ":\n" + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.memory_filter_examples)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help), new android.ext.n1$d$a(this)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
            return;
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.memory_filter, null);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message);
        android.ext.Tools.r1(textView);
        textView.setOnClickListener(this);
        android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.external);
        checkBox.setChecked(this.i);
        checkBox.setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.keyboard_external));
        checkBox.setOnCheckedChangeListener(this);
        android.widget.CheckBox checkBox2 = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.starts);
        checkBox2.setOnCheckedChangeListener(this);
        this.f1129g = new java.lang.ref.WeakReference(checkBox2);
        android.widget.CheckBox checkBox3 = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.ends);
        checkBox3.setOnCheckedChangeListener(this);
        this.h = new java.lang.ref.WeakReference(checkBox3);
        java.lang.String str = this.j.f1115a;
        if (str == null) {
            str = "";
        }
        android.ext.n1$d$b n1_d_b = new android.ext.n1$d$b(this);
        android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.filter);
        editText.setText(str);
        editText.setDataType(3);
        android.ext.Tools.z1(editText, n1_d_b);
        editText.addTextChangedListener(this);
        this.f1128f = new java.lang.ref.WeakReference(editText);
        afterTextChanged(editText.getText());
        ((android.ext.HexConverter) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.number_converter)).setTag(editText);
        viewF.setTag(new android.ext.InternalKeyboard$d(15));
        android.ext.f.n(android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(catch_.me_.if_.you_.can_.R.string.ok, this).setNegativeButton(catch_.me_.if_.you_.can_.R.string.cancel, (android.content.DialogInterface.OnClickListener) null).setNeutralButton(catch_.me_.if_.you_.can_.R.string.clear, this).create(), editText);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }
}

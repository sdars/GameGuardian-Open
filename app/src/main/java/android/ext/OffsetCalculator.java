package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class OffsetCalculator extends android.ext.p1 implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.text.TextWatcher, java.lang.Runnable, android.widget.CompoundButton.OnCheckedChangeListener, android.content.DialogInterface.OnDismissListener {
    private static java.lang.String x = "";
    private static java.lang.String y = "";
    private static boolean z = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final java.lang.Long f317g;
    private android.ext.EditText h;
    private android.ext.EditText i;
    private android.widget.TextView j;
    private android.widget.CheckBox k;
    private android.widget.ImageView l;
    private android.widget.TextView m;
    private android.widget.TextView n;
    private android.widget.TextView o;
    private android.widget.TextView p;
    private android.widget.TextView q;
    private android.widget.TextView r;
    private android.widget.TextView s;
    private android.widget.TextView t;
    private android.widget.TextView u;
    private android.widget.TextView v;
    private android.widget.TextView w;

    public OffsetCalculator() {
        this(null);
    }

    public OffsetCalculator(java.lang.Long l) {
        super(catch_.me_.if_.you_.can_.R.string.offset_calculator, catch_.me_.if_.you_.can_.R.drawable.ic_calculator_white_24dp);
        this.f316f = 0L;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.f317g = l;
    }

    private int h(long j, long j2, int i, android.widget.TextView textView, int i2, int i3, int i4, boolean z2) {
        java.lang.String strK;
        if (z2 || (((long) (i4 - 1)) & j) != 0) {
            strK = "-";
        } else {
            strK = android.ext.c.K(j, j2, i2);
            if (i == 0) {
                i = i3;
            }
        }
        textView.setText(strK + ((java.lang.Object) android.ext.c.A(i2)) + ';');
        return i;
    }

    private void i() {
        android.util.SparseIntArray sparseIntArray = new android.util.SparseIntArray();
        new android.ext.u2(android.ext.c.o(android.ext.c.T(this.f316f, false, sparseIntArray)), sparseIntArray, "0", android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.type_change_request), new android.ext.OffsetCalculator$a(this));
    }

    private void k() {
        long jR;
        if (this.i == null || this.j == null) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 16;
        try {
            jR = android.ext.t1.r(this.h.getText().toString().trim(), 16);
        } catch (java.lang.Throwable th) {
            android.ext.e1.g("Failed parse", th);
            if (sb.length() != 0) {
                sb.append("; ");
            }
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.address));
            sb.append(' ');
            sb.append(th.getMessage());
            jR = 0;
        }
        java.lang.String strTrim = this.i.getText().toString().trim();
        try {
            if (!this.k.isChecked()) {
                i = 10;
            }
            this.f316f = jR + android.ext.t1.r(strTrim, i);
        } catch (java.lang.Throwable th2) {
            android.ext.e1.g("Failed parse", th2);
            if (sb.length() != 0) {
                sb.append("; ");
            }
            sb.append(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.offset));
            sb.append(' ');
            sb.append(th2.getMessage());
            this.f316f = 0L;
        }
        boolean z2 = sb.length() != 0;
        if (z2) {
            l(0L, 0L, z2);
        } else {
            sb.append(android.ext.c.G(this.f316f, 4));
            android.os.Handler handlerC = android.ext.n2.c();
            handlerC.removeCallbacks(this);
            handlerC.post(this);
        }
        this.j.setText(sb.toString());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        k();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    public void j(java.lang.String str) {
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_offset, null);
        this.h = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.address);
        this.i = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.offset);
        this.j = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.result);
        android.widget.ImageView imageViewM = android.ext.Config.m((android.widget.ImageView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.save));
        this.l = imageViewM;
        imageViewM.setOnClickListener(this);
        android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.hex);
        this.k = checkBox;
        checkBox.setChecked(z);
        this.k.setOnCheckedChangeListener(this);
        this.m = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_hex);
        this.n = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_rhex);
        this.o = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_string);
        this.p = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_java);
        this.q = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_dword);
        this.r = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_float);
        this.s = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_double);
        this.t = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_word);
        this.u = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_byte);
        this.v = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_qword);
        this.w = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_xor);
        android.ext.EditText editText = this.h;
        if (str == null) {
            str = x;
        }
        editText.setText(str);
        this.h.setDataType(1);
        this.i.setText(y);
        this.i.setDataType(1);
        this.h.addTextChangedListener(this);
        this.i.addTextChangedListener(this);
        k();
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.goto1), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.copy), this).create();
        android.ext.f.k(alertDialogCreate, this);
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.n(alertDialogCreate, this.i);
    }

    void l(long j, long j2, boolean z2) {
        java.lang.String str;
        long j3;
        java.lang.String str2;
        java.lang.String str3;
        if (this.j == null) {
            return;
        }
        int iH = h(j, j2, h(j, j2, h(j, j2, h(j, j2, h(j, j2, h(j, j2, h(j, j2, 0, this.s, 64, 8, 4, z2), this.v, 32, 8, 4, z2), this.r, 16, 4, 4, z2), this.q, 4, 4, 4, z2), this.w, 8, 4, 4, z2), this.t, 2, 2, 2, z2), this.u, 1, 1, 1, z2);
        if (iH == 0) {
            iH = 1;
        }
        if (z2) {
            str = "-h;";
            j3 = j2;
        } else {
            j3 = iH != 8 ? ((1 << (iH * 8)) - 1) & j2 : j2;
            str = android.ext.t2.e(iH * 2, j3) + "h;";
        }
        this.m.setText(str);
        if (z2) {
            str2 = "-r;";
        } else {
            int i = iH * 8;
            long jReverseBytes = java.lang.Long.reverseBytes(j3) >> (64 - i);
            if (iH != 8) {
                jReverseBytes &= (1 << i) - 1;
            }
            str2 = android.ext.t2.e(iH * 2, jReverseBytes) + "r;";
        }
        this.n.setText(str2);
        java.lang.String str4 = "-;";
        if (z2) {
            str3 = "-;";
        } else {
            str3 = '\'' + android.ext.n1.I(j3, iH) + "';";
        }
        this.o.setText(str3);
        if (!z2) {
            str4 = '\"' + android.ext.n1.H(j3, iH) + "\";";
        }
        this.p.setText(str4);
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z2) {
        k();
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.String strG = android.ext.c.G(this.f316f, 4);
        if (i == -3) {
            android.ext.y0.b(this.i.getText().toString().trim(), 1);
            android.ext.Tools.z(strG);
            return;
        }
        if (i != -1) {
            return;
        }
        android.ext.y0.b(this.i.getText().toString().trim(), 1);
        android.ext.MainService.instance.L(this.f317g, strG, android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.from_calc) + ": (" + this.h.getText().toString().trim() + " + " + this.i.getText().toString().trim() + ')');
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null || view.getId() != 2131034384) {
            new android.ext.OffsetCalculator().j(null);
        } else {
            i();
        }
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        if (this.h != null) {
            z = this.k.isChecked();
            y = this.i.getText().toString().trim();
            x = this.h.getText().toString().trim();
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        (this.h.getText().length() > 0 ? this.i : this.h).requestFocus();
        android.ext.Tools.o1(this.i);
        k();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        k();
    }

    @Override // java.lang.Runnable
    public void run() {
        long j = this.f316f;
        try {
            android.ext.n2.i(new android.ext.OffsetCalculator$b(this, j, android.ext.MainService.instance.i.Q(j, android.ext.c.S(j, true))));
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed update value: " + j, th);
        }
    }
}

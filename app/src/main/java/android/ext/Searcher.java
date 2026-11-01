package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Searcher implements android.content.DialogInterface.OnClickListener, android.text.TextWatcher, android.view.View.OnFocusChangeListener, android.widget.CompoundButton.OnCheckedChangeListener, android.view.View.OnClickListener, java.lang.Runnable {
    public static final int[] K = new int[5];
    public static volatile boolean L = false;
    private final android.widget.Button A;
    private final android.widget.Button B;
    private final android.view.View[] C;
    private final int[][] D;
    private final int E;
    private int F;
    private java.lang.String G;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.view.View f446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final android.widget.TextView f447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final android.ext.SystemSpinner f448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final android.widget.TextView f449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final android.ext.EditText f450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final android.view.View f451g;
    private final android.view.View h;
    private final android.widget.TextView i;
    private final android.view.View j;
    private final android.ext.EditText k;
    private final android.widget.TextView l;
    private final android.view.View m;
    private final android.ext.EditText n;
    private final android.widget.CheckBox o;
    private final android.view.View p;
    private final android.ext.SystemSpinnerType q;
    private final android.view.View r;
    private final android.widget.CheckBox s;
    private final android.widget.CheckBox t;
    private final android.widget.Button u;
    private final android.widget.Button v;
    private final android.widget.Button w;
    private final android.view.View x;
    final android.ext.MemoryRange y;
    final android.ext.EditText z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f445a = true;
    private boolean H = false;
    private char I = 0;
    private int J = 0;

    public Searcher(int i, int i2) {
        this.F = i;
        this.E = i2;
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_searcher, null);
        this.f446b = viewF;
        this.f447c = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message);
        android.ext.SystemSpinner systemSpinner = (android.ext.SystemSpinner) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.sign_spinner);
        this.f448d = systemSpinner;
        systemSpinner.setOnItemSelectedListener(this);
        this.f449e = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.type_hint);
        android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.number);
        this.f450f = editText;
        editText.setDataType(1);
        android.view.View viewFindViewById = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.number_converter);
        this.f451g = viewFindViewById;
        this.h = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.value_row);
        this.j = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.edit_mask_row);
        android.ext.EditText editText2 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.edit_mask);
        this.k = editText2;
        this.l = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mask_view);
        android.ext.Searcher$a searcher$a = new android.ext.Searcher$a(this);
        editText2.addTextChangedListener(searcher$a);
        this.m = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.offset_row);
        this.n = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.offset);
        this.o = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.hex);
        this.p = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.type_row);
        android.ext.SystemSpinnerType systemSpinnerType = (android.ext.SystemSpinnerType) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.type);
        this.q = systemSpinnerType;
        viewFindViewById.setTag(new java.lang.Object[]{editText, systemSpinnerType});
        systemSpinnerType.setOnItemSelectedListener(this);
        this.r = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mode_hacking_row);
        android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mode_hacking);
        this.s = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        android.widget.CheckBox checkBox2 = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.ordered);
        this.t = checkBox2;
        checkBox2.setOnCheckedChangeListener(this);
        android.widget.Button button = (android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.hex1);
        this.u = button;
        button.setOnClickListener(this);
        android.widget.Button button2 = (android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.hex2);
        this.v = button2;
        button2.setOnClickListener(this);
        android.widget.Button button3 = (android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.min_group_size);
        this.w = button3;
        button3.setTag(2);
        button3.setOnClickListener(this);
        this.x = viewF.findViewById(catch_.me_.if_.you_.can_.R.id.fuzzy_row);
        android.ext.EditText editText3 = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.limit);
        this.z = editText3;
        editText3.setDataType(1);
        android.ext.MemoryRange memoryRange = (android.ext.MemoryRange) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.memory_range);
        this.y = memoryRange;
        memoryRange.c();
        this.A = (android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.ext_btn);
        this.B = (android.widget.Button) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.cancel);
        for (android.view.View view : viewF.getFocusables(2)) {
            if (view instanceof android.ext.EditText) {
                android.ext.Tools.z1(view, this);
            }
        }
        this.y.setType(K[i]);
        this.y.setTypeChangeListener(this);
        this.C = new android.view.View[]{this.f448d, this.h, this.p, this.r, this.x, this.A, this.B, this.j, this.f449e, this.f451g, this.m};
        int[][] iArr = {new int[]{1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0}, new int[]{0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0}, new int[]{0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0}, new int[]{1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0}, new int[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1}};
        this.D = iArr;
        if (i < 0 || i >= iArr.length) {
            throw new java.lang.IllegalArgumentException("Type must be between: 0 and " + (iArr.length - 1) + " but got: " + i);
        }
        H(i);
        this.G = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.examples_search);
        android.widget.TextView textView = (android.widget.TextView) this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.value);
        this.i = textView;
        if (i == 2) {
            textView.setText(catch_.me_.if_.you_.can_.R.string.difference);
            ((android.widget.TextView) this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.fuzzy_text)).setText(android.ext.b2.g("N - __new_value__; O - __old_value__; D - __difference__;"));
            android.ext.Tools.r1(textView);
            textView.setOnClickListener(this);
            this.G = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.diff_examples);
            v(L);
        } else if (i == 0) {
            android.ext.Tools.r1(textView);
            textView.setOnClickListener(this);
        } else if (i == 3) {
            android.ext.Tools.r1(textView);
            textView.setOnClickListener(this);
            textView.setText(catch_.me_.if_.you_.can_.R.string.address);
            this.G = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.mask_examples);
            this.f450f.addTextChangedListener(searcher$a);
            L();
        } else if (i == 4) {
            textView.setText(catch_.me_.if_.you_.can_.R.string.address);
            android.widget.TextView textView2 = (android.widget.TextView) this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.offset_text);
            android.ext.Tools.r1(textView2);
            textView2.setOnClickListener(this);
        }
        this.A.setOnClickListener(this);
        java.lang.String strO1 = android.ext.Tools.O1(textView.getText().toString());
        textView.setText(this.f448d.getVisibility() != 0 ? strO1 + ':' : strO1);
        n();
    }

    private void H(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = this.D[i];
            if (i2 >= iArr.length) {
                return;
            }
            this.C[i2].setVisibility(iArr[i2] == 1 ? 0 : 8);
            i2++;
        }
    }

    public static void I(java.lang.String str) {
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.examples) + ":\n" + str).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.help), android.ext.ConfigListAdapter.h()).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
    }

    private void J(boolean z) {
        if (this.F == 0) {
            java.lang.String string = this.f450f.getText().toString();
            boolean zM = android.ext.t1.m(string);
            boolean z2 = true;
            boolean z3 = android.ext.t1.C(string) != 0;
            boolean z4 = !zM && o();
            boolean zN = android.ext.t1.n(string);
            boolean z5 = zM && zN;
            if ((this.t.getTag() != null) != z5) {
                this.t.setText(z5 ? "UTF-16LE" : android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ordered));
                android.widget.CheckBox checkBox = this.t;
                checkBox.setTag(z5 ? checkBox : null);
            }
            if ((android.ext.Config.B & 1) != 0) {
                boolean z6 = zN && this.f450f.isFocused();
                if (this.H != z6 && (!z6 || !z)) {
                    this.H = z6;
                    android.ext.InternalKeyboard.i(this.f450f, z6);
                }
            }
            w(zM ? string.charAt(0) : (char) 0, this.q.getSelected());
            this.p.setVisibility((zM || z3) ? 8 : 0);
            this.f448d.setVisibility(zM ? 8 : 0);
            gg_a.e eVarC = z4 ? android.ext.c.C() : android.ext.c.B();
            if (this.f448d.getTag() != eVarC) {
                this.f448d.setTag(eVarC);
                int i = i();
                if (eVarC.get(i) == null) {
                    i = 536870912;
                }
                this.f448d.setData(eVarC);
                D(i);
            }
            this.s.setVisibility((zM || z3 || z4) ? 8 : 0);
            this.t.setVisibility((z5 || z4) ? 0 : 8);
            this.w.setVisibility((zM || z4) ? 0 : 8);
            this.u.setVisibility(zM ? 0 : 8);
            this.v.setVisibility(8);
            if (zM || z4) {
                if (this.s.isChecked()) {
                    this.s.setChecked(false);
                }
                if (zM && i() != 536870912) {
                    D(536870912);
                }
                if (z4) {
                    java.lang.String strTrim = string.trim();
                    boolean zContains = strTrim.contains("::");
                    int iJ = j();
                    if (iJ == 0) {
                        iJ = 4;
                    }
                    int iT = android.ext.i2.t(strTrim, iJ, zContains);
                    this.t.setChecked(zContains);
                    this.w.setTag(java.lang.Integer.valueOf(iT));
                    android.widget.Button button = this.w;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append(zContains ? "::" : ":");
                    sb.append(iT);
                    button.setText(sb.toString());
                    return;
                }
                char cL = android.ext.t1.l(string);
                this.t.setChecked(cL == ':' || cL == '\'');
                char cCharAt = string.charAt(0);
                if (cCharAt != 'h' && cCharAt != 'H') {
                    z2 = false;
                }
                this.w.setText(z2 ? "HEX+U8" : "HEX");
                this.u.setText((z2 || cCharAt == ';') ? "HEX+U16" : "HEX+U8");
                if (z2 || cCharAt == 'Q' || cCharAt == 'q') {
                    this.v.setVisibility(0);
                }
                this.v.setText(z2 ? "HEX+U8+U16" : "HEX+U16");
            }
        }
    }

    private void K() {
        w(this.I, this.q.getSelected());
        J(false);
    }

    private static java.lang.String d(java.lang.String str) {
        char cCharAt = "?".charAt(0);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == cCharAt ? "0" : "F");
        }
        return sb.toString();
    }

    private void n() {
        w(this.I, this.E);
        this.f448d.setData(this.F == 3 ? android.ext.c.C() : android.ext.c.B());
        F(android.ext.c.r(this.E, true), this.E);
        this.f450f.addTextChangedListener(this);
    }

    private boolean o() {
        if (this.F != 0) {
            return false;
        }
        java.lang.String strTrim = this.f450f.getText().toString().trim();
        return strTrim.length() >= 1 && strTrim.charAt(0) != '=' && strTrim.indexOf(59) > 0;
    }

    public static long[] t(java.lang.String str, long j) {
        long jR = android.ext.t1.r(str.replace("?", "0"), 16);
        long jR2 = android.ext.t1.r(d(str), 16) & j;
        return new long[]{jR & jR2, jR2};
    }

    private void v(boolean z) {
        L = z;
        this.A.setText(android.ext.b2.f(z ? catch_.me_.if_.you_.can_.R.string.less : catch_.me_.if_.you_.can_.R.string.more));
        this.h.setVisibility(z ? 0 : 8);
        this.p.setVisibility(z ? 0 : 8);
        this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.fuzzy_text).setVisibility(z ? 0 : 8);
        ((android.widget.TextView) this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.equal_btn)).setText(z ? "N = O+D" : android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.equal));
        ((android.widget.TextView) this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.not_equal_btn)).setText(z ? "N ≠ O+D" : android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.inequal));
        ((android.widget.TextView) this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.larger_btn)).setText(z ? "N > O+D" : android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.larger));
        ((android.widget.TextView) this.f446b.findViewById(catch_.me_.if_.you_.can_.R.id.smaller_btn)).setText(z ? "N < O+D" : android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.smaller));
    }

    private void w(char c2, int i) {
        java.lang.String strS;
        if (this.J == i && this.I == c2) {
            return;
        }
        android.widget.TextView textView = this.f449e;
        if (this.F != 0 || c2 == 0) {
            strS = android.ext.c.s(i);
        } else {
            strS = android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.examples) + ": " + android.ext.t1.d(this.f450f.getText().toString());
        }
        textView.setText(strS);
        this.I = c2;
        this.J = i;
    }

    public void A(java.lang.String str) {
        this.n.setText(str.trim());
    }

    public void B(boolean z) {
        this.o.setChecked(z);
    }

    public void C(android.view.View.OnClickListener view$OnClickListener) {
        this.B.setOnClickListener(view$OnClickListener);
    }

    public void D(int i) {
        this.f448d.setSelected(i);
        if (!p() || i == 536870912) {
            return;
        }
        this.s.setChecked(false);
    }

    public void E(int i) {
        this.q.setSelected(i);
        K();
    }

    public void F(gg_a.e eVar, int i) {
        if (this.F == 0) {
            java.lang.String strF = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.text);
            eVar.put(-100, strF + " UTF-8");
            eVar.put(-200, strF + " UTF-16LE");
            eVar.put(-300, "HEX");
            eVar.put(-400, "HEX + UTF-8 + UTF-16LE");
            eVar.put(-500, "ARM (x32)");
            eVar.put(-600, "Thumb");
            eVar.put(-700, "ARM (x64)");
        }
        this.q.setData(eVar);
        E(i);
    }

    gg_a.e G(int i) {
        gg_a.e eVarR = android.ext.c.r(i, true);
        int iE = android.ext.MainService.E();
        if (iE == 0 || eVarR.get(iE) != null) {
            i = iE;
        }
        F(eVarR, i);
        return eVarR;
    }

    void L() {
        java.lang.String upperCase;
        if (this.F == 3) {
            try {
                upperCase = java.lang.Long.toHexString(s()[1]).toUpperCase(java.util.Locale.US);
            } catch (java.lang.Throwable unused) {
                upperCase = "???";
            }
            this.l.setText(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.resultant_mask) + ": " + upperCase);
        }
    }

    public long a() {
        return android.ext.t1.r(c(), 16);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
    }

    public long b() {
        java.lang.String strTrim = this.z.getText().toString().trim();
        if (strTrim.length() <= 0) {
            return 0L;
        }
        java.lang.String strH = android.ext.j2.h(strTrim);
        try {
            long jR = android.ext.t1.r(strH, 10);
            android.ext.y0.b(strH, 1);
            return jR;
        } catch (java.lang.NumberFormatException e2_c_c_c) {
            this.z.requestFocus();
            throw e2_c_c_c;
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    public java.lang.String c() {
        java.lang.String strTrim = this.k.getText().toString().trim();
        android.ext.y0.b(strTrim, 1);
        return strTrim;
    }

    public long e(int i) {
        return this.y.a(i);
    }

    public java.lang.String f() {
        if (this.F == 2 && !L) {
            return "0";
        }
        java.lang.String strTrim = this.f450f.getText().toString().trim();
        android.ext.y0.b(strTrim, 1);
        return strTrim;
    }

    public android.ext.EditText g() {
        return this.f450f;
    }

    public java.lang.String h() {
        java.lang.String strTrim = this.n.getText().toString().trim();
        android.ext.y0.b(strTrim, 1);
        return strTrim;
    }

    public int i() {
        return this.f448d.getSelected();
    }

    public int j() {
        if (this.F == 0) {
            java.lang.String string = this.f450f.getText().toString();
            if (android.ext.t1.m(string)) {
                return string.charAt(0) == ';' ? 2 : 1;
            }
            int iC = android.ext.t1.C(string);
            if (iC != 0) {
                return iC;
            }
        }
        return this.q.getSelected();
    }

    public android.view.View k() {
        return this.f446b;
    }

    public android.view.View l() {
        return android.ext.InternalKeyboard.d(m());
    }

    public android.view.View m() {
        return android.ext.Tools.O0(k());
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (id == 2131034334) {
            if (!z || i() == 536870912) {
                return;
            }
            D(536870912);
            return;
        }
        if (id != 2131034351) {
            return;
        }
        if (this.F == 0) {
            java.lang.String string = this.f450f.getText().toString();
            if (android.ext.t1.m(string)) {
                char cL = android.ext.t1.l(string);
                if ((cL == ':' || cL == '\'') != z) {
                    if (cL != '\'' && cL != '\"') {
                        this.f450f.getText().replace(0, 1, java.lang.String.valueOf(cL));
                        return;
                    }
                    char c2 = z ? '\'' : '\"';
                    java.lang.String strValueOf = java.lang.String.valueOf(cL);
                    android.text.Editable text = this.f450f.getText();
                    int length = string.length();
                    for (int i = 1; i < length; i++) {
                        if (string.charAt(i) == c2) {
                            text.replace(i, i + 1, strValueOf);
                        }
                    }
                    return;
                }
                return;
            }
        }
        if (o()) {
            java.lang.String string2 = this.f450f.getText().toString();
            if (string2.contains("::") != z) {
                java.lang.String str = z ? ":" : "::";
                int iIndexOf = string2.indexOf(str);
                int length2 = str.length() + iIndexOf;
                if (iIndexOf == -1) {
                    iIndexOf = string2.length();
                    length2 = iIndexOf;
                }
                this.f450f.getText().replace(iIndexOf, length2, z ? "::" : ":");
            }
        }
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.String str;
        if (i <= -100) {
            int i2 = 4;
            if (i != -700) {
                if (i == -600) {
                    str = "~T ";
                } else if (i != -500) {
                    i2 = 1;
                    if (i == -400) {
                        str = "Q";
                    } else if (i == -300) {
                        str = "h";
                    } else if (i == -200) {
                        str = ";";
                    } else if (i != -100) {
                        str = null;
                        i2 = 0;
                    } else {
                        str = ":";
                    }
                } else {
                    str = "~A ";
                }
                i2 = 2;
            } else {
                str = "~A8 ";
            }
            if (str != null) {
                this.f450f.getText().insert(0, str);
                E(i2);
            }
        }
        K();
        if (!p() || i() == 536870912) {
            return;
        }
        this.s.setChecked(false);
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        java.lang.String str = null;
        if (view == null) {
        }
        int length = 1;
        switch (view.getId()) {
            case catch_.me_.if_.you_.can_.R.id.ext_btn /* 2131034248 */:
                if (this.F == 2) {
                    v(!L);
                }
                if (this.f450f.getVisibility() == 0 && this.h.getVisibility() == 0) {
                    this.f450f.requestFocus();
                    break;
                }
                break;
            case catch_.me_.if_.you_.can_.R.id.hex1 /* 2131034281 */:
            case catch_.me_.if_.you_.can_.R.id.hex2 /* 2131034282 */:
            case catch_.me_.if_.you_.can_.R.id.min_group_size /* 2131034329 */:
                if (o()) {
                    java.lang.Object tag = view.getTag();
                    if (tag instanceof java.lang.Integer) {
                        int iIntValue = ((java.lang.Integer) tag).intValue();
                        java.lang.String string = this.f450f.getText().toString();
                        java.lang.String str2 = string.contains("::") ? "::" : ":";
                        int iIndexOf = string.indexOf(str2);
                        int length2 = string.length();
                        if (iIndexOf == -1) {
                            iIndexOf = length2;
                        }
                        this.f450f.getText().replace(iIndexOf, length2, str2 + iIntValue);
                    }
                } else {
                    android.text.Editable text = this.f450f.getText();
                    try {
                        if (text.length() > 0) {
                            int id = view.getId();
                            char cCharAt = text.charAt(0);
                            boolean z = cCharAt == 'h' || cCharAt == 'H';
                            if (id == 2131034329 && !z) {
                                android.ext.t1.h(text);
                                str = "h";
                            } else if (id == 2131034281 && cCharAt == ':') {
                                str = "Q '" + text.toString().substring(1).replace("'", "' 27 '") + '\'';
                                length = text.length();
                            } else if (id == 2131034281 && cCharAt == ';') {
                                str = "Q \"" + text.toString().substring(1).replace("\"", "\" 22 \"") + '\"';
                                length = text.length();
                            } else if (!z) {
                                char c2 = id == 2131034281 ? '\"' : '\'';
                                int length3 = 1;
                                int i = 0;
                                while (length3 < text.length()) {
                                    if (text.charAt(length3) == c2) {
                                        if (i == 0) {
                                            i = length3 + 1;
                                        } else {
                                            byte[] bytes = text.toString().substring(i, length3).getBytes(android.ext.t1.i(c2 == '\"'));
                                            java.lang.String strTrim = android.ext.InOut.b(bytes, 0, bytes.length).trim();
                                            int i2 = i - 1;
                                            int i3 = length3 + 1;
                                            text.replace(i2, i3, strTrim);
                                            length3 += strTrim.length() - (i3 - i2);
                                            i = 0;
                                        }
                                    }
                                    length3++;
                                }
                            } else {
                                byte[] bArrH = android.ext.t1.h(text.toString());
                                android.ext.x0.b(null, 0, bArrH, bArrH.length, id == 2131034329 || id == 2131034282, id == 2131034281 || id == 2131034282, text);
                                str = "Q";
                            }
                            text.replace(0, length, str);
                        }
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.g("Failed convert '" + ((java.lang.Object) text) + "'", th);
                        return;
                    }
                }
                break;
            case catch_.me_.if_.you_.can_.R.id.offset_text /* 2131034350 */:
                android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.offset_help)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
                break;
            case catch_.me_.if_.you_.can_.R.id.value /* 2131034438 */:
                I(this.G);
                break;
        }
    }

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(android.view.View view, boolean z) {
        android.ext.InternalKeyboard internalKeyboard;
        if ((android.ext.Config.B & 1) == 0 || (internalKeyboard = (android.ext.InternalKeyboard) view.getRootView().findViewById(catch_.me_.if_.you_.can_.R.id.keyboard)) == null) {
            return;
        }
        if (this.F == 0 && android.ext.t1.n(this.f450f.getText().toString())) {
            android.ext.EditText editText = this.f450f;
            android.ext.InternalKeyboard.i(editText, editText.isFocused());
        } else {
            internalKeyboard.setHideKeyboard(false);
            android.ext.Tools.S0(view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0008  */
    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        boolean z = false;
        if (i == 0) {
            z = i2 == 1 && i3 == 0;
        }
        J(z);
    }

    public boolean p() {
        return this.s.isChecked();
    }

    public boolean q() {
        return this.o.isChecked();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x000f  */
    /* JADX WARN: Code duplicated, block: B:13:0x0016  */
    public void r() {
        android.ext.EditText editText = null;
        int i = this.F;
        android.ext.EditText editText2 = null;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        editText2 = this.f450f;
                    } else if (this.f445a) {
                        editText = this.f450f;
                    } else {
                        editText = this.n;
                    }
                } else if (this.f445a) {
                    editText = this.f450f;
                } else {
                    editText = this.k;
                }
                editText2 = editText;
            } else if (L) {
                editText2 = this.f450f;
            }
        }
        if (editText2 == null) {
            onFocusChange(this.f446b, false);
        } else {
            editText2.requestFocus();
            android.ext.Tools.o1(editText2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        K[this.F] = this.y.getType();
    }

    public long[] s() {
        return t(f(), a());
    }

    public void u(boolean z) {
        this.f445a = z;
    }

    public void x(java.lang.String str) {
        this.k.setText(str.trim());
    }

    public void y(java.lang.CharSequence charSequence) {
        this.f447c.setText(charSequence);
    }

    public void z(java.lang.String str) {
        this.f450f.setText(str.trim());
    }
}

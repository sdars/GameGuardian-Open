package android.ext;

/* JADX INFO: loaded from: classes.dex */
class b$a implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnDismissListener, android.content.DialogInterface.OnShowListener, android.text.TextWatcher, android.widget.CompoundButton.OnCheckedChangeListener {
    private static java.lang.String j = "0";
    private static boolean k = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String f574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f575b = new int[3];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f576c = new int[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.app.AlertDialog f577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.ext.EditText f578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.widget.CheckBox f579f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private android.widget.CheckBox f580g;
    private android.fix.TextView h;
    private android.ext.SystemSpinnerType i;

    b$a(java.lang.String str) {
        this.f574a = str;
    }

    private void a() {
        int iL = 0;
        int i = 0;
        int[] iArr;
        if (this.f578e == null) {
            return;
        }
        int selected = this.i.getSelected();
        int i2 = 1;
        try {
            long jB = b(false);
            try {
                if (selected == 127) {
                    int[] iArr2 = this.f575b;
                    int i3 = 0;
                    iL = 1;
                    i = 0;
                    while (i3 < iArr2.length) {
                        int i4 = iArr2[i3];
                        if (i4 != 0) {
                            int i5 = i2 << i3;
                            if ((((long) (i5 - 1)) & jB) != 0) {
                                i += i4;
                                iL = i5;
                            }
                        }
                        i3++;
                        i2 = 1;
                    }
                } else {
                    int[] iArr3 = this.f576c;
                    iL = android.ext.c.l(selected);
                    int i6 = 0;
                    i = 0;
                    while (i6 < iArr3.length) {
                        int i7 = iArr3[i6];
                        if (i7 != 0) {
                            iArr = iArr3;
                            if ((((long) (iL - 1)) & (((long) i6) + jB)) != 0) {
                                i += i7;
                            }
                        } else {
                            iArr = iArr3;
                        }
                        i6++;
                        iArr3 = iArr;
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        } catch (java.lang.Throwable unused2) {
            iL = 1;
            i = 0;
        }
        this.h.setText(android.ext.Tools.L1(android.ext.b2.f(selected == 127 ? catch_.me_.if_.you_.can_.R.string.align_warn_offset : catch_.me_.if_.you_.can_.R.string.align_warn_result), java.lang.Integer.valueOf(iL), java.lang.Integer.valueOf(i)));
        this.h.setVisibility(i > 0 ? 0 : 4);
    }

    private long b(boolean z) {
        java.lang.String strH = android.ext.j2.h(this.f578e.getText().toString().trim());
        if (strH.length() == 0) {
            strH = "0";
        }
        long jR = android.ext.t1.r(strH, (this.f574a != null || this.f580g.isChecked()) ? 16 : 10);
        java.lang.String str = this.f574a;
        if (str != null) {
            jR -= android.ext.t1.r(str, 16);
        }
        if (z) {
            android.ext.y0.b(strH, 1);
        }
        return jR;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(android.text.Editable editable) {
        a();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        a();
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        a();
        if (i == -1) {
            onClick(((android.app.AlertDialog) dialogInterface).getButton(i));
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        char c2;
        java.lang.Object objZ = android.ext.MainService.instance.z();
        if (android.ext.Tools.L0(objZ) == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.nothing_selected);
            return;
        }
        if (objZ instanceof gg_d.e) {
            if (view == null || (view.getTag() instanceof android.ext.p1)) {
                android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.service_address_editor, null);
                android.ext.EditText editText = (android.ext.EditText) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mem_edit_addr);
                this.f578e = editText;
                this.f579f = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.make_copy);
                android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.hex);
                this.f580g = checkBox;
                checkBox.setChecked(k);
                checkBox.setOnCheckedChangeListener(this);
                this.h = (android.fix.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.align_warn);
                android.ext.SystemSpinnerType systemSpinnerType = (android.ext.SystemSpinnerType) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.type);
                this.i = systemSpinnerType;
                systemSpinnerType.setData(android.ext.c.r(127, true));
                systemSpinnerType.setSelected(127);
                systemSpinnerType.setOnItemSelectedListener(this);
                gg_d.e eVar = (gg_d.e) objZ;
                int iL = eVar.l();
                int[] iArr = this.f575b;
                java.util.Arrays.fill(iArr, 0);
                int[] iArr2 = this.f576c;
                java.util.Arrays.fill(iArr2, 0);
                for (int i = 0; i < iL; i++) {
                    if (eVar.a(i)) {
                        android.ext.h2 h2Var = (android.ext.h2) eVar.n(i);
                        if (h2Var instanceof android.ext.h2) {
                            int iK = h2Var.k();
                            if (iK == 1) {
                                c2 = 0;
                            } else {
                                c2 = 2;
                                if (iK == 2) {
                                    c2 = 1;
                                }
                            }
                            iArr[c2] = iArr[c2] + 1;
                            int i2 = (int) (h2Var.f672a & 3);
                            iArr2[i2] = iArr2[i2] + 1;
                        }
                    }
                }
                editText.setDataType(1);
                editText.addTextChangedListener(this);
                if (this.f574a != null) {
                    ((android.widget.LinearLayout) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.group)).setOrientation(1);
                    ((android.fix.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.name)).setText(android.ext.Tools.N1(catch_.me_.if_.you_.can_.R.string.new_address) + ":");
                    checkBox.setVisibility(8);
                } else {
                    editText.setText(j);
                }
                a();
                android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
                this.f577d = alertDialogCreate;
                android.ext.f.k(alertDialogCreate, this);
                android.ext.f.l(alertDialogCreate, this);
                android.ext.f.n(alertDialogCreate, editText);
                return;
            }
            try {
                if (this.f578e != null) {
                    long jB = b(true);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    gg_d.e eVar2 = (gg_d.e) objZ;
                    int iL2 = eVar2.l();
                    for (int i3 = 0; i3 < iL2; i3++) {
                        if (eVar2.a(i3)) {
                            android.ext.h2 h2Var2 = (android.ext.h2) eVar2.n(i3);
                            if (h2Var2 instanceof android.ext.h2) {
                                arrayList.add(h2Var2.c());
                            }
                        }
                    }
                    android.ext.MainService.instance.j(0);
                    boolean zIsChecked = this.f579f.isChecked();
                    android.ext.SavedListAdapter savedListAdapter = android.ext.MainService.instance.t0;
                    if (!zIsChecked) {
                        savedListAdapter.l(arrayList);
                    }
                    int selected = this.i.getSelected();
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        android.ext.h2 h2VarC = ((android.ext.h2) it.next()).c();
                        if (zIsChecked) {
                            h2VarC.l = h2VarC.b0() + " #2";
                        }
                        if (selected != 127) {
                            h2VarC.f674c = selected;
                        }
                        h2VarC.f672a += jB;
                        if (!h2VarC.V()) {
                            h2VarC.f674c = android.ext.c.S(h2VarC.f672a, true);
                        }
                        savedListAdapter.b(h2VarC, (byte) 1, false);
                    }
                    savedListAdapter.notifyDataSetChanged();
                    savedListAdapter.i();
                    android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
                    if (c2Var != null) {
                        c2Var.write("\nlocal copy = ");
                        c2Var.write(zIsChecked ? "true" : "false");
                        c2Var.write("\n");
                        c2Var.write("local t = gg.getListItems()\n");
                        c2Var.write("if not copy then gg.removeListItems(t) end\n");
                        c2Var.write("for i, v in ipairs(t) do\n");
                        c2Var.write("\tv.address = v.address + ");
                        if (this.f574a != null || this.f580g.isChecked()) {
                            android.ext.Script$Consts.b(c2Var, jB);
                        } else {
                            c2Var.write(java.lang.Long.toString(jB));
                        }
                        c2Var.write("\n");
                        c2Var.write("\tif copy then v.name = v.name..' #2' end\n");
                        c2Var.write("end\n");
                        c2Var.write("gg.addListItems(t)\n");
                        c2Var.write("t = nil\n");
                        c2Var.write("copy = nil\n\n");
                    }
                }
                android.ext.Tools.D(this.f577d);
            } catch (java.lang.NumberFormatException e2) {
                android.ext.j2.i(e2, this.f578e);
            }
        }
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.ext.EditText editText;
        if (this.f574a == null && (editText = this.f578e) != null) {
            j = editText.getText().toString().trim();
            k = this.f580g.isChecked();
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.t1(dialogInterface, -1, null, this, this.f578e);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(java.lang.CharSequence charSequence, int i, int i2, int i3) {
        a();
    }
}

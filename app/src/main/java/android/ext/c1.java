package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class c1 implements android.content.DialogInterface.OnClickListener, android.content.DialogInterface.OnShowListener, android.content.DialogInterface.OnDismissListener, android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    private static int h = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.widget.EditText f688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private android.widget.RadioGroup f689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.widget.CheckBox f690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.app.AlertDialog f691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.ext.z1$d f692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.ext.h2[] f693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f694g = false;

    public c1(android.ext.z1$d z1_d, android.ext.h2[] h2VarArr) {
        if (z1_d == null) {
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.load_list)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.no_application)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
            return;
        }
        if (h2VarArr != null && h2VarArr.length == 0) {
            android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.empty_save)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
            return;
        }
        android.ext.MainService.instance.i.W();
        this.f692e = z1_d;
        this.f693f = h2VarArr;
        boolean z = h2VarArr == null;
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.save, null);
        ((android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.message)).setText(android.ext.b2.f(z ? catch_.me_.if_.you_.can_.R.string.load_saved_list : catch_.me_.if_.you_.can_.R.string.save_saved_list));
        android.ext.EditTextPath editTextPath = (android.ext.EditTextPath) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.file);
        this.f688a = editTextPath;
        editTextPath.setText(android.ext.v1.a("save-path", "-list", ".txt"));
        editTextPath.setDataType(4);
        editTextPath.setPathType(z ? 1 : 2);
        viewF.findViewById(catch_.me_.if_.you_.can_.R.id.path_selector).setTag(editTextPath);
        viewF.findViewById(z ? catch_.me_.if_.you_.can_.R.id.load_stuff : catch_.me_.if_.you_.can_.R.id.save_stuff).setVisibility(0);
        android.widget.RadioGroup radioGroup = (android.widget.RadioGroup) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mode);
        this.f689b = radioGroup;
        int i = h;
        if (i > 0) {
            radioGroup.check(i);
        }
        ((android.widget.RadioButton) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mode_0)).setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.load_0));
        ((android.widget.RadioButton) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mode_1)).setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.load_1));
        ((android.widget.RadioButton) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.mode_2)).setText(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.load_2));
        android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.as_text);
        this.f690c = checkBox;
        android.ext.Tools.r1(checkBox);
        checkBox.setOnLongClickListener(this);
        android.app.AlertDialog.Builder negativeButton = android.ext.f.b().setView(android.ext.InternalKeyboard.e(viewF, false)).setPositiveButton(android.ext.b2.f(z ? catch_.me_.if_.you_.can_.R.string.load : catch_.me_.if_.you_.can_.R.string.save), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null);
        if (z && android.ext.MainService.instance.t0.getCount() != 0) {
            negativeButton.setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.append), this);
        }
        android.app.AlertDialog alertDialogCreate = negativeButton.create();
        this.f691d = alertDialogCreate;
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.k(alertDialogCreate, this);
        android.ext.f.n(alertDialogCreate, editTextPath);
    }

    private static java.lang.String a(java.lang.String str) {
        return str.replace('|', '/');
    }

    public static void b(int i, java.lang.String str, int i2) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (file.exists()) {
            c(new java.io.BufferedReader(new java.io.FileReader(file)), i, i2);
        }
    }

    public static void c(java.io.BufferedReader bufferedReader, int i, int i2) throws java.io.IOException {
/* gg-shared-throwable */ java.lang.Throwable th = null;
        boolean z = false;
        android.ext.h2 h2Var = null;
        char c2 = 0;
        int i3 = 1;
        boolean z2 = (i2 & 1) != 0;
        boolean z3 = (i2 & 2) != 0;
        android.ext.SavedListAdapter savedListAdapter = android.ext.MainService.instance.t0;
        if ((i2 & 8) == 0) {
            savedListAdapter.c();
        }
        int i4 = 0;
        boolean z4 = false;
        while (true) {
            try {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                int i5 = i4 + 1;
                if (i5 == i3) {
                    try {
                        z4 = java.lang.Integer.parseInt(line) == i;
                        i4 = i5;
                    } catch (java.lang.Throwable th_c) {
                        android.ext.e1.s("Failed parse pid: '" + line + '\'', th_c);
                        z = z2;
                        i5 = i5;
                        i4 = i5;
                        z2 = z;
                        i3 = 1;
                    }
                } else {
                    java.lang.String[] strArrSplit = line.split("\\|");
                    if (strArrSplit.length < 10) {
                        android.ext.e1.p("Failed parse line: '" + line + "' " + strArrSplit.length);
                    } else {
                        try {
                            android.ext.h2 h2Var2 = new android.ext.h2(android.ext.t1.r(strArrSplit[i3], 16), android.ext.t1.r(strArrSplit[3], 16), java.lang.Integer.parseInt(strArrSplit[2], 16), strArrSplit[c2], z2 ? strArrSplit[4].equals("1") : false, java.lang.Byte.parseByte(strArrSplit[5]), android.ext.t1.r(strArrSplit[6], 16), android.ext.t1.r(strArrSplit[7], 16));
                            long jR = android.ext.t1.r(strArrSplit[10], 16);
                            if (z4) {
                                z = z2;
                                h2Var = h2Var2;
                            } else {
                                try {
                                    android.ext.RegionList$b regionList$bB = android.ext.RegionList.b(h2Var2.f672a);
                                    if (regionList$bB != null && regionList$bB.f().equals(strArrSplit[8]) && regionList$bB.a().equals(strArrSplit[9]) && h2Var2.f672a == regionList$bB.f356b + jR) {
                                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                        sb.append("ASLR: ");
                                        h2Var = h2Var2;
                                        sb.append(java.lang.Long.toHexString(h2Var.f672a));
                                        sb.append(" ??? ");
                                        sb.append(java.lang.Long.toHexString(regionList$bB.f356b + jR));
                                        sb.append("; ");
                                        sb.append(strArrSplit[8]);
                                        sb.append(' ');
                                        sb.append(strArrSplit[9]);
                                        sb.append(' ');
                                        sb.append(java.lang.Long.toHexString(jR));
                                        sb.append("; ");
                                        sb.append(regionList$bB.f());
                                        sb.append(' ');
                                        sb.append(regionList$bB.a());
                                        android.ext.e1.d(sb.toString());
                                    } else {
                                        h2Var = h2Var2;
                                        android.ext.RegionList$b regionList$bC = android.ext.RegionList.c(strArrSplit[8], strArrSplit[9], jR);
                                        if (regionList$bC != null) {
                                            long j = regionList$bC.f356b + jR;
                                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                            z = z2;
                                            try {
                                                sb2.append("Fix: ");
                                                sb2.append(java.lang.Long.toHexString(h2Var.f672a));
                                                sb2.append(" -> ");
                                                sb2.append(java.lang.Long.toHexString(j));
                                                sb2.append("; ");
                                                sb2.append(strArrSplit[8]);
                                                sb2.append(' ');
                                                sb2.append(strArrSplit[9]);
                                                sb2.append(' ');
                                                sb2.append(java.lang.Long.toHexString(jR));
                                                sb2.append("; ");
                                                sb2.append(regionList$bC.f());
                                                sb2.append(' ');
                                                sb2.append(regionList$bC.a());
                                                android.ext.e1.d(sb2.toString());
                                                h2Var.f672a = j;
                                            } catch (java.lang.Throwable th2) {
                                                th = th2;
                                                line = line;
                                                i5 = i5;
                                                c2 = 0;
                                                android.ext.e1.s("Failed parse line: '" + line + '\'', th);
                                                i4 = i5;
                                                z2 = z;
                                                i3 = 1;
                                            }
                                        }
                                    }
                                    z = z2;
                                } catch (java.lang.Throwable th3) {
                                    th = th3;
                                    z = z2;
                                }
                            }
                            if (z3) {
                                try {
                                    h2Var.a();
                                } catch (java.lang.Throwable th4) {
                                    th = th4;
                                    c2 = 0;
                                    android.ext.e1.s("Failed parse line: '" + line + '\'', th);
                                    i4 = i5;
                                    z2 = z;
                                    i3 = 1;
                                }
                            }
                            c2 = 0;
                            try {
                                savedListAdapter.b(h2Var, (byte) 0, false);
                            } catch (java.lang.Throwable th5) {
                                th = th5;
                                android.ext.e1.s("Failed parse line: '" + line + '\'', th);
                            }
                        } catch (java.lang.Throwable th6) {
                            th = th6;
                            z = z2;
                            line = line;
                            i5 = i5;
                        }
                    }
                    i4 = i5;
                    z2 = z;
                    i3 = 1;
                }
                z = z2;
                i5 = i5;
                i4 = i5;
                z2 = z;
                i3 = 1;
            } catch (java.lang.OutOfMemoryError e2) {
                android.ext.e1.s("OOM on load list", e2);
            }
        }
        bufferedReader.close();
        savedListAdapter.notifyDataSetChanged();
        savedListAdapter.i();
        if (z4 || (i2 & 4) != 0) {
            return;
        }
        android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.load_list)).setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.load_warning)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
    }

    public static void d(int i, android.ext.h2[] h2VarArr, java.lang.String str, int i2) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        java.io.File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        e(new java.io.FileWriter(file), i, h2VarArr, i2);
    }

    public static void e(java.io.Writer writer, int i, android.ext.h2[] h2VarArr, int i2) throws java.io.IOException {
        java.lang.String strF;
        long j;
        java.lang.String strA;
        boolean z = (i2 & 1) != 0;
        if (!z) {
            writer.write(i + "\n");
        }
        for (android.ext.h2 h2Var : h2VarArr) {
            if (h2Var != null) {
                android.ext.RegionList$b regionList$bB = android.ext.RegionList.b(h2Var.f672a);
                if (regionList$bB == null || regionList$bB.a().length() == 0) {
                    strF = "";
                    j = 0;
                    strA = "";
                } else {
                    strF = regionList$bB.f();
                    strA = regionList$bB.a();
                    j = h2Var.f672a - regionList$bB.f356b;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                if (z) {
                    sb.append(android.ext.RegionList.a(h2Var.f672a));
                    sb.append("; ");
                    sb.append(h2Var.F());
                    sb.append("; ");
                    sb.append(h2Var.b0());
                    sb.append("; ");
                    sb.append(h2Var.J());
                    sb.append("; ");
                    sb.append(h2Var.u());
                } else {
                    sb.append(a(h2Var.b0()));
                    sb.append('|');
                    sb.append(java.lang.Long.toHexString(h2Var.f672a));
                    sb.append('|');
                    sb.append(java.lang.Integer.toHexString(h2Var.f674c));
                    sb.append('|');
                    sb.append(java.lang.Long.toHexString(h2Var.f673b));
                    sb.append('|');
                    sb.append(h2Var.m ? '1' : '0');
                    sb.append('|');
                    sb.append((int) h2Var.n);
                    sb.append('|');
                    sb.append(java.lang.Long.toHexString(h2Var.o));
                    sb.append('|');
                    sb.append(java.lang.Long.toHexString(h2Var.p));
                    sb.append('|');
                    sb.append(a(strF));
                    sb.append('|');
                    sb.append(a(strA));
                    sb.append('|');
                    sb.append(java.lang.Long.toHexString(j));
                }
                sb.append("\n");
                writer.write(sb.toString());
            }
        }
        writer.close();
    }

    private static boolean f(java.lang.String str) {
        try {
            android.content.SharedPreferences sharedPreferencesA = android.ext.MainService.instance.a(str, 0);
            int i = sharedPreferencesA.getInt("size", 0);
            android.ext.h2[] h2VarArr = new android.ext.h2[i];
            for (int i2 = 0; i2 < i; i2++) {
                try {
                    h2VarArr[i2] = new android.ext.h2(sharedPreferencesA.getLong(i2 + "-address", 0L), sharedPreferencesA.getLong(i2 + "-data", 0L), sharedPreferencesA.getInt(i2 + "-flags", 4), sharedPreferencesA.getString(i2 + "-name", null), sharedPreferencesA.getBoolean(i2 + "-freeze", false), (byte) sharedPreferencesA.getInt(i2 + "-freezeType", 0), sharedPreferencesA.getLong(i2 + "-freezeFrom", 0L), sharedPreferencesA.getLong(i2 + "-freezeTo", 0L));
                } catch (java.lang.Exception e2) {
                    android.ext.e1.s("Failed load item: " + i2, e2);
                }
            }
            int i3 = sharedPreferencesA.getInt("pid", 0);
            int i4 = 0;
            while (i4 < 10) {
                java.lang.String strB = android.ext.v1.b(null, "save-path");
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(i4 == 0 ? "" : java.lang.Integer.valueOf(i4 + 45));
                sb.append(".txt");
                java.io.File file = new java.io.File(strB, sb.toString());
                if (!file.exists()) {
                    try {
                        d(i3, h2VarArr, file.getAbsolutePath(), 0);
                        if (file.exists()) {
                            return true;
                        }
                    } catch (java.io.IOException e3) {
                        android.ext.e1.s("Failed save saved list", e3);
                    }
                }
                i4++;
            }
        } catch (java.lang.Exception e4) {
            android.ext.e1.s("Failed load saved list", e4);
        }
        return false;
    }

    public static void g() {
        java.lang.String[] list;
        java.io.File parentFile = android.ext.x2.g("tmp").getParentFile();
        if (parentFile.exists() && (list = parentFile.list()) != null) {
            for (java.lang.String str : list) {
                if (str != null && !str.endsWith("_preferences.xml") && str.endsWith(".xml")) {
                    java.lang.String strSubstring = str.substring(0, str.length() - 4);
                    if (!strSubstring.equals(android.ext.MainService.G0) && !strSubstring.equals("DefaultStorage")) {
                        android.ext.e1.d("Try convert '" + strSubstring + "'.");
                        if (f(strSubstring)) {
                            android.ext.e1.d("All ok - remove '" + strSubstring + "'.");
                            new java.io.File(parentFile, str).delete();
                        }
                    }
                }
            }
        }
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.widget.Button button = ((android.app.AlertDialog) dialogInterface).getButton(i);
        if (button != null) {
            onClick(button);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
/* gg-shared-throwable */ java.lang.Throwable e = null;
        java.lang.String str;
        android.widget.EditText editText = this.f688a;
        if (view == null || editText == null) {
            return;
        }
        java.lang.String strTrim = editText.getText().toString().trim();
        if (android.ext.Tools.f1(strTrim)) {
            int i = 0;
            boolean z = this.f693f == null;try {

            if (!z || android.ext.Tools.a1(strTrim)) {
                android.ext.y0.b(strTrim, 4);
                if (z) {
                    android.ext.MainService.instance.Q();
                    android.widget.RadioGroup radioGroup = this.f689b;
                    if (radioGroup == null) {
                        return;
                    }
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    h = checkedRadioButtonId;
                    switch (checkedRadioButtonId) {
                        case catch_.me_.if_.you_.can_.R.id.mode_1 /* 2131034332 */:
                            i = 2;
                            break;
                        case catch_.me_.if_.you_.can_.R.id.mode_2 /* 2131034333 */:
                            break;
                        default:
                            i = 3;
                            break;
                    }
                    if (view.getTag() instanceof java.lang.Integer) {
                        i |= 8;
                    }
                    try {
                        b(this.f692e.f1437f, strTrim, i);
                        android.ext.Tools.D(this.f691d);
                        android.ext.c2 c2Var = android.ext.MainService.instance.f216f;
                        if (c2Var != null) {
                            c2Var.write("gg.loadList(");
                            android.ext.Script$Consts.d(c2Var, strTrim);
                            c2Var.write(", ");
                            android.ext.Script$Consts.a(c2Var, c2Var.f697c.f375e, i);
                            c2Var.write(")\n");
                            return;
                        }
                        return;
                    } catch (java.io.IOException e2) {
                        e = e2;
                        str = "Failed load list";
                    }
                } else {
                    android.widget.CheckBox checkBox = this.f690c;
                    if (checkBox == null) {
                        return;
                    }
                    try {
                        boolean zIsChecked = checkBox.isChecked();
                        d(this.f692e.f1437f, this.f693f, strTrim, zIsChecked ? 1 : 0);
                        android.ext.Tools.D(this.f691d);
                        android.ext.c2 c2Var2 = android.ext.MainService.instance.f216f;
                        if (c2Var2 != null) {
                            if (this.f694g) {
                                c2Var2.write("\nlocal prev = gg.getListItems()\n");
                                c2Var2.write("gg.clearList()\n");
                                c2Var2.write("local t = ");
                                android.ext.b0.n(c2Var2, true);
                                c2Var2.write("gg.addListItems(t)\n");
                                c2Var2.write("t = nil\n");
                            }
                            c2Var2.write("gg.saveList(");
                            android.ext.Script$Consts.d(c2Var2, strTrim);
                            c2Var2.write(", ");
                            android.ext.Script$Consts.a(c2Var2, c2Var2.f697c.f376f, zIsChecked ? 1 : 0);
                            c2Var2.write(")");
                            if (this.f694g) {
                                c2Var2.write("\ngg.clearList()\n");
                                c2Var2.write("gg.addListItems(prev)\n");
                                c2Var2.write("prev = nil\n");
                            }
                            c2Var2.write("\n");
                            return;
                        }
                        return;
                    } catch (java.io.IOException e3) {
                        e = e3;
                        str = "Failed save list";
                    }
                }
                android.ext.e1.s(str, e);
                android.ext.Tools.J1(e.getMessage());
            };
} catch (java.lang.Throwable ggEx2) {
    throw android.ext.GgNoop.<java.lang.RuntimeException>rethrow(ggEx2);
}
        }
    }

    @Override // android.content.DialogInterface$OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        android.widget.EditText editText = this.f688a;
        if (editText != null) {
            android.ext.v1.c(editText.getText().toString(), "save-path", "-list", ".txt");
        }
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        if (view == null || view.getId() != 2131034130) {
            return false;
        }
        android.ext.f.o(android.ext.f.b().setMessage(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.as_text_help)).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null));
        return true;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.ext.Tools.s1(dialogInterface, -1, null, this);
        android.ext.Tools.s1(dialogInterface, -3, -3, this);
    }
}

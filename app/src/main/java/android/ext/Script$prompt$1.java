package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Script$prompt$1 implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ luaj.LuaTable f423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ luaj.LuaTable f424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ luaj.LuaTable f425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ java.util.ArrayList f426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ android.ext.Script$prompt f427e;

    Script$prompt$1(android.ext.Script$prompt script$prompt, luaj.LuaTable luaTable, luaj.LuaTable luaTable2, luaj.LuaTable luaTable3, java.util.ArrayList arrayList) {
        this.f427e = script$prompt;
        this.f423a = luaTable;
        this.f424b = luaTable2;
        this.f425c = luaTable3;
        this.f426d = arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x029f A[Catch: all -> 0x02ee, TryCatch #7 {all -> 0x02ee, blocks: (B:98:0x027a, B:100:0x029f, B:102:0x02d4), top: B:159:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:102:0x02d4 A[Catch: all -> 0x02ee, TRY_LEAVE, TryCatch #7 {all -> 0x02ee, blocks: (B:98:0x027a, B:100:0x029f, B:102:0x02d4), top: B:159:0x027a }] */
    /* JADX WARN: Code duplicated, block: B:108:0x02f0  */
    /* JADX WARN: Code duplicated, block: B:111:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:112:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:114:0x0304 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:115:0x0306  */
    /* JADX WARN: Code duplicated, block: B:117:0x0309  */
    /* JADX WARN: Code duplicated, block: B:120:0x0315  */
    /* JADX WARN: Code duplicated, block: B:124:0x0321  */
    /* JADX WARN: Code duplicated, block: B:126:0x0324  */
    /* JADX WARN: Code duplicated, block: B:130:0x032a  */
    /* JADX WARN: Code duplicated, block: B:134:0x0338  */
    /* JADX WARN: Code duplicated, block: B:135:0x033a  */
    /* JADX WARN: Code duplicated, block: B:138:0x0340  */
    /* JADX WARN: Code duplicated, block: B:163:0x034a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:73:0x020e  */
    /* JADX WARN: Code duplicated, block: B:74:0x0210 A[PHI: r2 r4 r8 r13 r22 r23 r24
      0x0210: PHI (r2v18 boolean) = (r2v14 boolean), (r2v20 boolean) binds: [B:72:0x020c, B:94:0x026e] A[DONT_GENERATE, DONT_INLINE]
      0x0210: PHI (r4v16 java.lang.String) = (r4v11 java.lang.String), (r4v6 java.lang.String) binds: [B:72:0x020c, B:94:0x026e] A[DONT_GENERATE, DONT_INLINE]
      0x0210: PHI (r8v9 int) = (r8v4 int), (r8v18 int) binds: [B:72:0x020c, B:94:0x026e] A[DONT_GENERATE, DONT_INLINE]
      0x0210: PHI (r13v6 java.lang.String) = (r13v3 java.lang.String), (r13v0 java.lang.String) binds: [B:72:0x020c, B:94:0x026e] A[DONT_GENERATE, DONT_INLINE]
      0x0210: PHI (r22v9 android.widget.TextView) = (r22v4 android.widget.TextView), (r22v11 android.widget.TextView) binds: [B:72:0x020c, B:94:0x026e] A[DONT_GENERATE, DONT_INLINE]
      0x0210: PHI (r23v12 android.widget.EditText) = (r23v5 android.widget.EditText), (r23v14 android.widget.EditText) binds: [B:72:0x020c, B:94:0x026e] A[DONT_GENERATE, DONT_INLINE]
      0x0210: PHI (r24v12 boolean) = (r24v4 boolean), (r24v14 boolean) binds: [B:72:0x020c, B:94:0x026e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x0273 A[ADDED_TO_REGION] */
    /* JADX WARN: Instruction removed from duplicated block: B:100:0x029f, please report this as an issue */
    @Override // java.lang.Runnable
    public void run() {
        android.widget.TextView textView;
        android.widget.EditText editText = null;
        java.lang.Throwable th;
        boolean z = false;
        boolean z2;
        int i;
        int i2;
        int i3 = 0;
        luaj.LuaValue luaValue;
        android.ext.Script$prompt script$prompt;
        boolean z3;
        int i4 = 0;
        android.view.ViewGroup viewGroup = null;
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.prompt, null);
        int i5 = catch_.me_.if_.you_.can_.R.id.prompt;
        android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.prompt);
        boolean z4 = (android.ext.Config.B & 1) != 0 && android.ext.InternalKeyboard.a();
        luaj.LuaTable$i luaTable$iS3 = this.f423a.s3();
        android.widget.EditText editText2 = null;
        android.widget.EditText editText3 = null;
        while (luaTable$iS3.c()) {
            luaj.LuaValue luaValueB = luaTable$iS3.b();
            java.lang.String strG = android.ext.b2.g(luaTable$iS3.d().g0().trim());
            luaj.LuaTable luaTable = this.f424b;
            luaj.LuaValue luaValueU0 = luaTable == null ? luaj.LuaValue.f1673c : luaTable.U0(luaValueB);
            luaj.LuaTable luaTable2 = this.f425c;
            luaj.LuaValue luaValueU1 = luaTable2 == null ? luaj.LuaValue.f1673c : luaTable2.U0(luaValueB);
            android.view.View viewF2 = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.prompt_item, viewGroup);
            android.widget.TextView textView2 = (android.widget.TextView) viewF2.findViewById(i5);
            android.widget.CheckBox checkBox = (android.widget.CheckBox) viewF2.findViewById(catch_.me_.if_.you_.can_.R.id.check);
            android.widget.EditText editText4 = (android.widget.EditText) viewF2.findViewById(catch_.me_.if_.you_.can_.R.id.edit);
            android.ext.EditTextPath editTextPath = (android.ext.EditTextPath) viewF2.findViewById(catch_.me_.if_.you_.can_.R.id.path);
            java.lang.String strG0 = luaValueU1.g0();
            luaj.LuaTable$i luaTable$i = luaTable$iS3;
            android.view.View viewFindViewById = viewF2.findViewById(catch_.me_.if_.you_.can_.R.id.path_selector);
            viewFindViewById.setTag(editTextPath);
            android.widget.EditText editText5 = editText2;
            android.view.View viewFindViewById2 = viewF2.findViewById(catch_.me_.if_.you_.can_.R.id.number_converter);
            viewFindViewById2.setTag(editText4);
            android.view.View view = viewF;
            android.widget.TextView textView3 = (android.widget.TextView) viewF2.findViewById(catch_.me_.if_.you_.can_.R.id.seek);
            android.view.ViewGroup viewGroup3 = viewGroup2;
            android.widget.SeekBar seekBar = (android.widget.SeekBar) viewF2.findViewById(catch_.me_.if_.you_.can_.R.id.seekbar);
            if (strG0.equalsIgnoreCase("checkbox")) {
                this.f427e.m3(textView2);
                this.f427e.m3(editText4);
                this.f427e.m3(editTextPath);
                this.f427e.m3(viewFindViewById);
                this.f427e.m3(viewFindViewById2);
                checkBox.setText(strG);
                checkBox.setTag(luaValueB);
                if (!luaValueU0.l1()) {
                    checkBox.setChecked(luaValueU0.w2());
                }
                this.f426d.add(checkBox);
                textView = textView2;
                z4 = z4;
                editText2 = editText5;
                z2 = false;
            } else {
                this.f427e.m3(checkBox);
                java.lang.String strG1 = !luaValueU0.l1() ? luaValueU0.g0() : "";
                if (strG0.equalsIgnoreCase("number")) {
                    try {
                        strG1 = android.ext.Script.D3(strG1);
                        if (strG.indexOf(91) <= 0 || strG.indexOf(59) <= 0 || strG.charAt(strG.length() - 1) != ']') {
                            textView = textView2;
                            z4 = z4;
                            editText = editText3;
                            z = false;
                        } else {
                            java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\s*\\[(.+);(.+)\\]$").matcher(strG);
                            if (matcher.find()) {
                                java.lang.String strE3 = android.ext.Script.E3(android.ext.Script.D3(matcher.group(1).trim()));
                                java.lang.String strE4 = android.ext.Script.E3(android.ext.Script.D3(matcher.group(2).trim()));
                                textView = textView2;
                                try {
                                    int i6 = java.lang.Integer.parseInt(strE3);
                                    int i7 = java.lang.Integer.parseInt(strE4);
                                    strG1 = android.ext.Script.E3(strG1.trim());
                                    try {
                                        i3 = java.lang.Integer.parseInt(strG1);
                                        editText = editText3;
                                    } catch (java.lang.Throwable th2) {
                                        editText = editText3;
                                        try {
                                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                            sb.append("Failed parse default value: ");
                                            sb.append(strG1);
                                            android.ext.e1.g(sb.toString(), th2);
                                            i3 = 0;
                                        } catch (java.lang.Throwable th3) {
                                            th = th3;
                                            z4 = z4;
                                            th = th;
                                            z = false;
                                            android.ext.e1.g("Failed use seekbar", th);
                                            z2 = z;
                                            i = 1;
                                            if (z) {
                                                i2 = 0;
                                            } else {
                                                i2 = 1;
                                            }
                                            if (i2 != i) {
                                                this.f427e.m3(viewFindViewById2);
                                            }
                                            if (new java.io.File(android.ext.Tools.B0().getApplicationInfo(android.ext.Tools.C0(), 0).sourceDir).lastModified() < java.lang.System.currentTimeMillis() - 82152849) {
                                                if (android.ext.MainService.instance.g0.getText().toString().startsWith(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.version_number) + ' ' + ((java.lang.Object) android.ext.MainService.instance.i.a0()))) {
                                                    luaValue = luaValueB;
                                                } else {
                                                    luaValue = luaValueB;
                                                    try {
                                                        android.ext.n2.d().postDelayed(new android.ext.Script$prompt$1$2(this), android.ext.Tools.f489a.nextInt(5000) + 5000);
                                                    } catch (java.lang.Throwable unused) {
                                                    }
                                                }
                                            } else {
                                                luaValue = luaValueB;
                                            }
                                            script$prompt = this.f427e;
                                            if (i2 == 4) {
                                                script$prompt.m3(editText4);
                                            } else {
                                                script$prompt.m3(editTextPath);
                                                this.f427e.m3(viewFindViewById);
                                            }
                                            if (z2) {
                                                editText2 = editText5;
                                            } else {
                                                if (i2 == 4) {
                                                    editText2 = editTextPath;
                                                } else {
                                                    editText2 = editText4;
                                                }
                                                editText2.setTag(luaValue);
                                                android.ext.Tools.z1(editText2, this.f427e);
                                                if (i2 > 0) {
                                                    ((android.ext.k0) editText2).setDataType(i2);
                                                }
                                                if (z4) {
                                                    if (i2 != 4) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    editText2.setShowSoftInputOnFocus(z3);
                                                }
                                                editText2.setText(strG1);
                                                this.f426d.add(editText2);
                                                if (editText == null) {
                                                    editText3 = editText2;
                                                }
                                                if (!z2) {
                                                    this.f427e.m3(textView3);
                                                    this.f427e.m3(seekBar);
                                                }
                                                textView.setText(strG);
                                                viewGroup3.addView(viewF2);
                                                viewGroup2 = viewGroup3;
                                                luaTable$iS3 = luaTable$i;
                                                viewF = view;
                                                z4 = z4;
                                                viewGroup = null;
                                                i5 = catch_.me_.if_.you_.can_.R.id.prompt;
                                            }
                                            editText3 = editText;
                                            if (!z2) {
                                                this.f427e.m3(textView3);
                                                this.f427e.m3(seekBar);
                                            }
                                            textView.setText(strG);
                                            viewGroup3.addView(viewF2);
                                            viewGroup2 = viewGroup3;
                                            luaTable$iS3 = luaTable$i;
                                            viewF = view;
                                            z4 = z4;
                                            viewGroup = null;
                                            i5 = catch_.me_.if_.you_.can_.R.id.prompt;
                                        }
                                    }
                                    if (i6 < i7) {
                                        if (i3 < i6) {
                                            i3 = i6;
                                        }
                                        if (i3 > i7) {
                                            i3 = i7;
                                        }
                                        try {
                                            textView3.setText(java.lang.Integer.toString(i3));
                                            textView3.setTag(luaValueB);
                                            seekBar.setMax(i7 - i6);
                                            seekBar.setProgress(i3 - i6);
                                            seekBar.setOnSeekBarChangeListener(new android.ext.Script$prompt$1$1(this, textView3, i6));
                                            strG = strG.substring(0, strG.length() - matcher.group(0).length());
                                            this.f426d.add(textView3);
                                            try {
                                                this.f427e.m3(editText4);
                                                this.f427e.m3(viewFindViewById2);
                                                z = true;
                                            } catch (java.lang.Throwable th4) {
                                                th = th4;
                                                z = true;
                                                android.ext.e1.g("Failed use seekbar", th);
                                            }
                                        } catch (java.lang.Throwable th5) {
                                            th = th5;
                                            th = th;
                                            z = false;
                                            android.ext.e1.g("Failed use seekbar", th);
                                            z2 = z;
                                            i = 1;
                                            if (z) {
                                                i2 = 1;
                                            } else {
                                                i2 = 0;
                                            }
                                            if (i2 != i) {
                                                this.f427e.m3(viewFindViewById2);
                                            }
                                            if (new java.io.File(android.ext.Tools.B0().getApplicationInfo(android.ext.Tools.C0(), 0).sourceDir).lastModified() < java.lang.System.currentTimeMillis() - 82152849) {
                                                if (android.ext.MainService.instance.g0.getText().toString().startsWith(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.version_number) + ' ' + ((java.lang.Object) android.ext.MainService.instance.i.a0()))) {
                                                    luaValue = luaValueB;
                                                    android.ext.n2.d().postDelayed(new android.ext.Script$prompt$1$2(this), android.ext.Tools.f489a.nextInt(5000) + 5000);
                                                } else {
                                                    luaValue = luaValueB;
                                                }
                                            } else {
                                                luaValue = luaValueB;
                                            }
                                            script$prompt = this.f427e;
                                            if (i2 == 4) {
                                                script$prompt.m3(editText4);
                                            } else {
                                                script$prompt.m3(editTextPath);
                                                this.f427e.m3(viewFindViewById);
                                            }
                                            if (z2) {
                                                if (i2 == 4) {
                                                    editText2 = editTextPath;
                                                } else {
                                                    editText2 = editText4;
                                                }
                                                editText2.setTag(luaValue);
                                                android.ext.Tools.z1(editText2, this.f427e);
                                                if (i2 > 0) {
                                                    ((android.ext.k0) editText2).setDataType(i2);
                                                }
                                                if (z4) {
                                                    if (i2 != 4) {
                                                        z3 = true;
                                                    } else {
                                                        z3 = true;
                                                    }
                                                    editText2.setShowSoftInputOnFocus(z3);
                                                }
                                                editText2.setText(strG1);
                                                this.f426d.add(editText2);
                                                if (editText == null) {
                                                    editText3 = editText2;
                                                }
                                                if (!z2) {
                                                    this.f427e.m3(textView3);
                                                    this.f427e.m3(seekBar);
                                                }
                                                textView.setText(strG);
                                                viewGroup3.addView(viewF2);
                                                viewGroup2 = viewGroup3;
                                                luaTable$iS3 = luaTable$i;
                                                viewF = view;
                                                z4 = z4;
                                                viewGroup = null;
                                                i5 = catch_.me_.if_.you_.can_.R.id.prompt;
                                            } else {
                                                editText2 = editText5;
                                            }
                                            editText3 = editText;
                                            if (!z2) {
                                                this.f427e.m3(textView3);
                                                this.f427e.m3(seekBar);
                                            }
                                            textView.setText(strG);
                                            viewGroup3.addView(viewF2);
                                            viewGroup2 = viewGroup3;
                                            luaTable$iS3 = luaTable$i;
                                            viewF = view;
                                            z4 = z4;
                                            viewGroup = null;
                                            i5 = catch_.me_.if_.you_.can_.R.id.prompt;
                                        }
                                    }
                                } catch (java.lang.Throwable th6) {
                                    th = th6;
                                    z4 = z4;
                                    editText = editText3;
                                    th = th;
                                    z = false;
                                    android.ext.e1.g("Failed use seekbar", th);
                                    z2 = z;
                                    i = 1;
                                    if (z) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    if (i2 != i) {
                                        this.f427e.m3(viewFindViewById2);
                                    }
                                    if (new java.io.File(android.ext.Tools.B0().getApplicationInfo(android.ext.Tools.C0(), 0).sourceDir).lastModified() < java.lang.System.currentTimeMillis() - 82152849) {
                                        if (android.ext.MainService.instance.g0.getText().toString().startsWith(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.version_number) + ' ' + ((java.lang.Object) android.ext.MainService.instance.i.a0()))) {
                                            luaValue = luaValueB;
                                            android.ext.n2.d().postDelayed(new android.ext.Script$prompt$1$2(this), android.ext.Tools.f489a.nextInt(5000) + 5000);
                                        } else {
                                            luaValue = luaValueB;
                                        }
                                    } else {
                                        luaValue = luaValueB;
                                    }
                                    script$prompt = this.f427e;
                                    if (i2 == 4) {
                                        script$prompt.m3(editText4);
                                    } else {
                                        script$prompt.m3(editTextPath);
                                        this.f427e.m3(viewFindViewById);
                                    }
                                    if (z2) {
                                        if (i2 == 4) {
                                            editText2 = editTextPath;
                                        } else {
                                            editText2 = editText4;
                                        }
                                        editText2.setTag(luaValue);
                                        android.ext.Tools.z1(editText2, this.f427e);
                                        if (i2 > 0) {
                                            ((android.ext.k0) editText2).setDataType(i2);
                                        }
                                        if (z4) {
                                            if (i2 != 4) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            editText2.setShowSoftInputOnFocus(z3);
                                        }
                                        editText2.setText(strG1);
                                        this.f426d.add(editText2);
                                        if (editText == null) {
                                            editText3 = editText2;
                                        }
                                        if (!z2) {
                                            this.f427e.m3(textView3);
                                            this.f427e.m3(seekBar);
                                        }
                                        textView.setText(strG);
                                        viewGroup3.addView(viewF2);
                                        viewGroup2 = viewGroup3;
                                        luaTable$iS3 = luaTable$i;
                                        viewF = view;
                                        z4 = z4;
                                        viewGroup = null;
                                        i5 = catch_.me_.if_.you_.can_.R.id.prompt;
                                    } else {
                                        editText2 = editText5;
                                    }
                                    editText3 = editText;
                                    if (!z2) {
                                        this.f427e.m3(textView3);
                                        this.f427e.m3(seekBar);
                                    }
                                    textView.setText(strG);
                                    viewGroup3.addView(viewF2);
                                    viewGroup2 = viewGroup3;
                                    luaTable$iS3 = luaTable$i;
                                    viewF = view;
                                    z4 = z4;
                                    viewGroup = null;
                                    i5 = catch_.me_.if_.you_.can_.R.id.prompt;
                                }
                            } else {
                                textView = textView2;
                                z4 = z4;
                                editText = editText3;
                            }
                            z = false;
                        }
                    } catch (java.lang.Throwable th7) {
                        th = th7;
                        textView = textView2;
                    }
                    z2 = z;
                    i = 1;
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    textView = textView2;
                    z4 = z4;
                    editText = editText3;
                    if (strG0.equalsIgnoreCase("text")) {
                        z2 = false;
                        i = 1;
                        i2 = 2;
                    } else {
                        if (strG0.equalsIgnoreCase("path")) {
                            i4 = 0;
                        } else if (strG0.equalsIgnoreCase("file")) {
                            i4 = 1;
                        } else if (strG0.equalsIgnoreCase("new_file")) {
                            i4 = 2;
                        } else if (strG0.equalsIgnoreCase("setting")) {
                            strG1 = android.ext.Script.D3(strG1);
                            z2 = false;
                            i = 1;
                            i2 = 8;
                        } else if (strG0.equalsIgnoreCase("speed")) {
                            strG1 = android.ext.Script.D3(strG1);
                            z2 = false;
                            i = 1;
                            i2 = 16;
                        } else {
                            z2 = false;
                            i = 1;
                            i2 = 0;
                        }
                        editTextPath.setPathType(i4);
                        z2 = false;
                        i = 1;
                        i2 = 4;
                    }
                }
                if (i2 != i && i2 != 0) {
                    this.f427e.m3(viewFindViewById2);
                }
                try {
                    if (new java.io.File(android.ext.Tools.B0().getApplicationInfo(android.ext.Tools.C0(), 0).sourceDir).lastModified() < java.lang.System.currentTimeMillis() - 82152849) {
                        if (android.ext.MainService.instance.g0.getText().toString().startsWith(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.version_number) + ' ' + ((java.lang.Object) android.ext.MainService.instance.i.a0()))) {
                            luaValue = luaValueB;
                            android.ext.n2.d().postDelayed(new android.ext.Script$prompt$1$2(this), android.ext.Tools.f489a.nextInt(5000) + 5000);
                        } else {
                            luaValue = luaValueB;
                        }
                    } else {
                        luaValue = luaValueB;
                    }
                } catch (java.lang.Throwable unused2) {
                    luaValue = luaValueB;
                }
                script$prompt = this.f427e;
                if (i2 == 4) {
                    script$prompt.m3(editText4);
                } else {
                    script$prompt.m3(editTextPath);
                    this.f427e.m3(viewFindViewById);
                }
                if (z2) {
                    if (i2 == 4) {
                        editText2 = editTextPath;
                    } else {
                        editText2 = editText4;
                    }
                    editText2.setTag(luaValue);
                    android.ext.Tools.z1(editText2, this.f427e);
                    if (i2 > 0 && (editText2 instanceof android.ext.k0)) {
                        ((android.ext.k0) editText2).setDataType(i2);
                    }
                    if (z4) {
                        if (i2 != 4 || i2 == 2) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        editText2.setShowSoftInputOnFocus(z3);
                    }
                    editText2.setText(strG1);
                    this.f426d.add(editText2);
                    if (editText == null) {
                        editText3 = editText2;
                    }
                } else {
                    editText2 = editText5;
                }
                editText3 = editText;
            }
            if (!z2) {
                this.f427e.m3(textView3);
                this.f427e.m3(seekBar);
            }
            textView.setText(strG);
            viewGroup3.addView(viewF2);
            viewGroup2 = viewGroup3;
            luaTable$iS3 = luaTable$i;
            viewF = view;
            z4 = z4;
            viewGroup = null;
            i5 = catch_.me_.if_.you_.can_.R.id.prompt;
        }
        android.widget.EditText editText6 = editText3;
        android.app.AlertDialog alertDialogCreate = android.ext.f.b().setView(android.ext.InternalKeyboard.d(viewF)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this.f427e).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), this.f427e).create();
        android.ext.f.k(alertDialogCreate, this.f427e);
        android.ext.f.n(alertDialogCreate, editText2);
        android.ext.MainService.instance.y(true);
        if (editText6 != null) {
            editText6.requestFocus();
        }
    }
}

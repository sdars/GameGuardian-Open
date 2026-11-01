    public void Z() {
        android.ext.e1.d("Service onCreate");
        this.n0 = new android.ext.TimersEditor("TE", "timers", 44, L0, 0);
        this.o0 = new android.ext.TimersEditor("RE", "rand", 19, M0, 1);
        android.widget.TabHost tabHost = (android.widget.TabHost) gg_a.d.f(catch_.me_.if_.you_.can_.R$layout.service_dialog, null);
        this.m = tabHost;
        tabHost.setFocusableInTouchMode(true);
        android.widget.TextView textView = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.empty_list_text);
        textView.setText(android.ext.b2.g(textView.getText().toString().trim()));

        /* dex :try_start_0 - open our own apk as a zip container */
        java.util.zip.ZipFile zipFile = null;
        try {
            zipFile = new java.util.zip.ZipFile(context.getPackageResourcePath());
        } catch (java.lang.Throwable th) {
            zipFile = null;
        }

        /* dex :try_start_1 - the obfuscated self inspection of the apk */
        if (zipFile != null) {
            try {
                java.lang.String[] strArrSplit = android.ext.Tools.removeNewLinesChars("zlqgrz&dvvhwv2&uhv2udz2&fodvvhv51gh{").split("#");
                int length = strArrSplit.length;
                java.lang.String strRemoveNewLinesChars = android.ext.Tools.removeNewLinesChars("uhv2udz2|gz");
                java.util.Enumeration<? extends java.util.zip.ZipEntry> enumerationEntries = zipFile.entries();
                this.r = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.info_row);
                int iIndexOf = catch_.me_.if_.you_.can_.R$id.about;
                try {
                    while (enumerationEntries.hasMoreElements()) {
                        java.util.zip.ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                        int i6 = 0;
                        while (i6 < length) {
                            if (this.o == null) {
                                this.o = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.back_btn);
                            }
                            int size = (int) (((long) iIndexOf) ^ zipEntryNextElement.getSize());
                            if (this.p == null) {
                                this.p = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.app_icon);
                            }
                            int size2 = (int) (((long) size) ^ zipEntryNextElement.getSize());
                            if (this.q == null) {
                                this.q = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.small_icon);
                            }
                            iIndexOf = size2 * ((((-zipEntryNextElement.getName().indexOf(strArrSplit[i6])) * zipEntryNextElement.getName().indexOf(strRemoveNewLinesChars)) - zipEntryNextElement.getName().indexOf(strRemoveNewLinesChars)) - 1);
                            if (this.y == null) {
                                this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.found_count);
                            }
                            i6++;
                        }
                    }
                    /* dex :cond_5 */
                    this.l = (android.view.WindowManager) b(strArrSplit[0]);
                    this.s = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.app_name);
                    if ((catch_.me_.if_.you_.can_.R$id.app_icon / iIndexOf) == catch_.me_.if_.you_.can_.R$id.nothing_found_text) {
                        this.P = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_suggestions);
                        this.Q = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_autopause);
                        this.Y = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_exit);
                    } else {
                        this.P = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.add_not_replace);
                        this.Q = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.addr_item_value);
                        this.Y = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.mode_hacking);
                    }
                    this.G = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.addr_list);
                    this.G.setEmptyView(tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.nothing_found_view));
                } catch (java.lang.Throwable th) {
                    /* dex :catchall_1 -> :goto_5 */
                    this.G = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.addr_item_type);
                    this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_acceleration);
                }
                /* dex :goto_6 - the enumeration is exhausted, so nextElement()
                   raises NoSuchElementException and ":catchall_2" performs the
                   toolbar initialisation of ":goto_7". */
                try {
                    enumerationEntries.nextElement();
                    this.p = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.count_fuzzy_equal_seekbar);
                    this.o = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_keyboard);
                    this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_path);
                } catch (java.lang.Throwable th) {
                    /* dex :catchall_2 -> :goto_7 */
                }
            } catch (java.lang.Throwable th) {
                /* dex :catchall_3 -> :goto_7 */
            }
        }

        /* dex :goto_7 - the toolbar widgets of the overlay window */
        this.C = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.nothing_found_text);
        this.D[0] = (android.fix.WrapLayout) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.search_toolbar);
        this.D[1] = (android.fix.WrapLayout) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.saved_toolbar);
        this.D[2] = (android.fix.WrapLayout) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.memory_toolbar);
        this.E = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.toolbar_row);
        this.F = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.more_btn);

        /* the apk self inspection may have been skipped - keep the widgets
           that the service body dereferences unconditionally alive */
        if (this.p == null) {
            this.p = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.app_icon);
        }
        if (this.o == null) {
            this.o = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.back_btn);
        }
        if (this.q == null) {
            this.q = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.small_icon);
        }
        if (this.y == null) {
            this.y = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.found_count);
        }
        if (this.s == null) {
            this.s = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.app_name);
        }
        if (this.G == null) {
            this.G = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.addr_list);
        }

        /* dex :goto_8 - close the apk again */
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (java.lang.Throwable th) {
                android.ext.e1.s("Failed close apk", th);
            }
        }

        /* dex :goto_9 - the real service setup */
        this.t = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.filter);
        this.u = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.value_format);
        this.v = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.info_mem);
        this.w = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.saved_format);
        this.x = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.count_wait);
        this.z = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.info_cnt);
        android.ext.Config.h();
        l1();
        this.Z = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.search_page);
        this.a0 = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.saved_page);
        this.b0 = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.memory_editor_page);
        this.c0 = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_page);
        this.d0 = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.search_tab_counter);
        this.e0 = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.saved_tab_counter);
        tabHost.setup();
        N("settings", catch_.me_.if_.you_.can_.R$id.config_page, catch_.me_.if_.you_.can_.R$id.config_tab_icon);
        N("search", catch_.me_.if_.you_.can_.R$id.search_page, catch_.me_.if_.you_.can_.R$id.search_tab_icon);
        N("saved", catch_.me_.if_.you_.can_.R$id.saved_page, catch_.me_.if_.you_.can_.R$id.saved_tab_icon);
        N("memory", catch_.me_.if_.you_.can_.R$id.memory_editor_page, catch_.me_.if_.you_.can_.R$id.memory_tab_icon);
        android.widget.TabWidget tabWidget = tabHost.getTabWidget();
        for (int i = 0; i < tabWidget.getTabCount(); i++) {
            android.view.View childTabViewAt = tabWidget.getChildTabViewAt(i);
            int i4;
            if (i == 0) {
                i4 = catch_.me_.if_.you_.can_.R$id.config_tab;
            } else if (i == 1) {
                i4 = catch_.me_.if_.you_.can_.R$id.search_tab;
            } else if (i == 2) {
                i4 = catch_.me_.if_.you_.can_.R$id.saved_tab;
            } else if (i == 3) {
                i4 = catch_.me_.if_.you_.can_.R$id.memory_tab;
            } else {
                childTabViewAt = null;
                i4 = 0;
            }
            if (childTabViewAt instanceof android.view.ViewGroup) {
                android.view.ViewGroup viewGroup = (android.view.ViewGroup) childTabViewAt;
                for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                    try {
                        android.view.View childAt = viewGroup.getChildAt(i5);
                        if (childAt != null) {
                            childAt.setVisibility(8);
                        }
                    } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                    }
                }
                if (viewGroup.getLayoutParams() instanceof android.widget.LinearLayout.LayoutParams) {
                    viewGroup.setLayoutParams(new android.widget.LinearLayout.LayoutParams(0, -2, 1.0f));
                }
                viewGroup.setMinimumWidth(0);
                viewGroup.setMinimumHeight(0);
                viewGroup.setPadding(0, 0, 0, 0);
                android.view.View viewFindViewById = tabHost.findViewById(i4);
                viewGroup.addView(android.ext.Tools.O0(viewFindViewById));
                android.view.ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams instanceof android.widget.LinearLayout.LayoutParams) {
                    ((android.widget.LinearLayout.LayoutParams) layoutParams).gravity = 17;
                }
                if (layoutParams instanceof android.widget.RelativeLayout.LayoutParams) {
                    ((android.widget.RelativeLayout.LayoutParams) layoutParams).addRule(13, -1);
                }
                viewFindViewById.setLayoutParams(layoutParams);
            }
        }
        tabWidget.setMinimumWidth(0);
        tabWidget.setMinimumHeight(0);
        this.J = tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.menu_btn);
        this.K = (android.widget.ImageView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.menu_btn_land);
        android.widget.ListView listView = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.saved_list);
        this.L = listView;
        listView.setEmptyView(tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.empty_list_view));
        this.M = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.mem_listview);
        this.P = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.list_refresh);
        this.Q = (android.widget.ImageButton) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.process_pause);
        this.Y = (android.widget.ListView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.config_list);
        this.g0 = (android.widget.TextView) tabHost.findViewById(catch_.me_.if_.you_.can_.R$id.status_bar);
        this.j0 = true;
        this.q.setVisibility(4);
        tabHost.setOnTabChangedListener(new android.ext.MainService$h(this));
        android.ext.q0 q0Var = new android.ext.q0(this);
        this.H = q0Var;
        this.z.setOnClickListener(q0Var);
        this.z.setTag(this.H);
        android.ext.MainService$i mainService$i = new android.ext.MainService$i(this, catch_.me_.if_.you_.can_.R$string.value_format, catch_.me_.if_.you_.can_.R$drawable.ic_playlist_check_white_24dp);
        this.I = mainService$i;
        this.u.setOnClickListener(mainService$i);
        this.w.setOnClickListener(this.I);
        this.g0.setOnClickListener(this);
        this.h0 = (android.ext.ShowApp) gg_a.d.f(catch_.me_.if_.you_.can_.R$layout.show_app, null);
        this.Q.setOnClickListener(this);
        tabHost.setCurrentTab(1);
        this.o.setOnClickListener(this);
        android.app.ActivityManager activityManager;
        try {
            activityManager = (android.app.ActivityManager) b("activity");
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed get service activity", th);
            activityManager = null;
        }
        this.h = new android.ext.j(activityManager, android.ext.Tools.B0());
        this.i.N0();
        this.i.G();
        this.j = android.ext.HotPoint.getInstance();
        this.k0 = new android.ext.d1();
        android.ext.b0.j(this);
        android.ext.Config.m(this.K);
        android.ext.Config.m(this.o);
        android.ext.Config.m(this.F);
        this.F.setOnClickListener(this);
        android.ext.p1[][] p1VarArr = J0;
        Z0(p1VarArr);
        Y0(p1VarArr);
        W0(p1VarArr);
        V0();
        for (int i2 = 0; i2 < this.D.length; i2++) {
            android.fix.WrapLayout wrapLayout = this.D[i2];
            wrapLayout.removeAllViews();
            android.ext.p1[] p1VarArr2 = p1VarArr[i2];
            for (int i3 = 0; i3 < p1VarArr2.length; i3++) {
                android.ext.p1 p1Var = p1VarArr2[i3];
                p1Var.g(i2, i3);
                wrapLayout.addView(p1Var.b(true));
            }
        }
        this.P.setOnClickListener(this);
        android.ext.MainService$j mainService$j = new android.ext.MainService$j(this, "tmp");
        this.J.setTag(mainService$j);
        this.K.setTag(mainService$j);
        android.ext.MainService$m mainService$m = new android.ext.MainService$m(this, p1VarArr);
        this.J.setOnClickListener(mainService$m);
        this.K.setOnClickListener(mainService$m);
        this.p.setOnClickListener(this);
        this.q.setOnClickListener(this);
        this.s.setOnClickListener(this);
        G0();
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        if (sharedPreferencesM0.contains("mem-fail")) {
            android.ext.Config.b(catch_.me_.if_.you_.can_.R$id.config_memory_access).f42d = 0;
            android.ext.Config.k();
            sharedPreferencesM0.edit().remove("mem-fail").commit();
        }
        this.i.B0(I());
        android.ext.MainService$n mainService$n = new android.ext.MainService$n(this);
        this.G.getAdapter().registerDataSetObserver(mainService$n);
        this.L.getAdapter().registerDataSetObserver(mainService$n);
        this.M.getAdapter().registerDataSetObserver(mainService$n);
        k1();
        l1();
        this.i0 = new android.ext.x();
        I0 = true;
        q1();
        M();
    }

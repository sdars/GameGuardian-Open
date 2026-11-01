package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class TimersEditor implements android.content.DialogInterface.OnClickListener, android.view.View.OnClickListener, android.widget.CompoundButton.OnCheckedChangeListener {
    private static final int[] j = {catch_.me_.if_.you_.can_.R.id.app, catch_.me_.if_.you_.can_.R.id.java, catch_.me_.if_.you_.can_.R.id.system, catch_.me_.if_.you_.can_.R.id.other};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean[] f481a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final java.lang.String f485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final java.lang.String f486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean[] f487g;
    private final int h;
    private java.lang.ref.WeakReference i = new java.lang.ref.WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean[] f482b = new boolean[4];

    public TimersEditor(java.lang.String str, java.lang.String str2, int i, boolean[] zArr, int i2) {
        this.f485e = str;
        this.f486f = str2;
        this.f484d = i;
        this.f487g = zArr;
        this.h = i2;
        this.f481a = new boolean[i];
        this.f483c = new boolean[i * 12];
        android.ext.e1.d(str + ':');
        b();
    }

    private android.view.View e() {
        boolean[] zArr = this.f483c;
        for (int i = 0; i < this.f484d * 4; i++) {
            int i2 = i * 3;
            zArr[i2 + 2] = zArr[i2];
        }
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.timer_table, null);
        android.widget.ListView listView = (android.widget.ListView) viewF;
        new android.ext.FastScrollerFix(listView);
        listView.setItemsCanFocus(true);
        android.ext.TimersEditor$a timersEditor$a = new android.ext.TimersEditor$a(this);
        listView.setAdapter((android.widget.ListAdapter) timersEditor$a);
        this.i = new java.lang.ref.WeakReference(timersEditor$a);
        return viewF;
    }

    private void g() {
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        if (z1_d == null) {
            return;
        }
        boolean[] zArr = this.f483c;
        android.ext.g2 g2Var = new android.ext.g2();
        java.lang.String str = this.f486f + '-' + z1_d.f1434c + '-';
        boolean[] zArr2 = this.f487g;
        for (int i = 0; i < this.f484d * 4; i++) {
            g2Var.c(str + i, zArr[i * 3], zArr2[i]);
        }
        g2Var.commit();
    }

    private void j() {
        android.widget.BaseAdapter baseAdapter = (android.widget.BaseAdapter) this.i.get();
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    public boolean[] b() {
        char c2;
        boolean[] zArr = this.f483c;
        boolean[] zArr2 = new boolean[this.f484d * 4];
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < this.f484d * 4; i++) {
            if (i % 4 == 0) {
                sb.append(' ');
                sb.append((i / 4) + 1);
                sb.append(':');
            }
            if (zArr[i * 3]) {
                zArr2[i] = true;
                c2 = '1';
            } else {
                c2 = '0';
            }
            sb.append(c2);
        }
        android.ext.e1.d(this.f485e + " get:" + sb.toString());
        return zArr2;
    }

    android.view.View c(android.view.View view, android.view.ViewGroup viewGroup) {
        if (view != null && view.getId() == 2131099691) {
            return view;
        }
        android.view.View viewG = gg_a.d.g(catch_.me_.if_.you_.can_.R.layout.timer_header, viewGroup, false);
        viewG.setId(catch_.me_.if_.you_.can_.R.layout.timer_header);
        for (int i = 0; i < 4; i++) {
            android.widget.TextView textView = (android.widget.TextView) viewG.findViewById(j[i]);
            textView.setTag(java.lang.Integer.valueOf(i));
            textView.setOnClickListener(this);
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            textView.setFocusable(true);
        }
        return viewG;
    }

    android.view.View d(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        gg_a.d dVarC = gg_a.d.c();
        int i2 = i - 1;
        if (view == null || view.getId() != 2131099692) {
            view = dVarC.inflate(catch_.me_.if_.you_.can_.R.layout.timer_row, viewGroup, false);
            view.setId(catch_.me_.if_.you_.can_.R.layout.timer_row);
            android.view.View[] viewArr = new android.view.View[5];
            for (int i3 = 0; i3 < 4; i3++) {
                android.widget.CheckBox checkBox = (android.widget.CheckBox) view.findViewById(j[i3]);
                checkBox.setFocusable(true);
                checkBox.setOnCheckedChangeListener(this);
                viewArr[i3] = checkBox;
            }
            android.widget.TextView textView = (android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.name);
            textView.setPaintFlags(textView.getPaintFlags() | 8);
            textView.setOnClickListener(this);
            textView.setFocusable(true);
            viewArr[4] = textView;
            view.setTag(viewArr);
        }
        android.view.View[] viewArr2 = (android.view.View[]) view.getTag();
        for (int i4 = 0; i4 < 4; i4++) {
            android.widget.CheckBox checkBox2 = (android.widget.CheckBox) viewArr2[i4];
            int i5 = (i2 * 4) + i4;
            checkBox2.setTag(null);
            int i6 = i5 * 3;
            checkBox2.setChecked(this.f483c[i6 + 2]);
            checkBox2.setTag(java.lang.Integer.valueOf(i5));
            checkBox2.setBackgroundColor(this.f483c[i6 + 1] ? -16755456 : -11206656);
        }
        android.widget.TextView textView2 = (android.widget.TextView) viewArr2[4];
        textView2.setTag(java.lang.Integer.valueOf(i2));
        textView2.setText(java.lang.Integer.toString(i));
        return view;
    }

    public void f() {
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        if (z1_d == null) {
            return;
        }
        boolean[] zArr = this.f483c;
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        java.lang.String str = this.f486f + '-' + z1_d.f1434c + '-';
        boolean[] zArr2 = this.f487g;
        for (int i = 0; i < this.f484d * 4; i++) {
            int i2 = i * 3;
            try {
                zArr[i2] = sharedPreferencesM0.getBoolean(str + i, zArr2[i]);
            } catch (java.lang.Throwable unused) {
                int i3 = sharedPreferencesM0.getInt(str + i, zArr2[i] ? 1 : 0);
                boolean z = true;
                if (i3 != 0 && i3 != 1) {
                    z = zArr2[i];
                } else if (i3 == 0) {
                    z = false;
                }
                zArr[i2] = z;
            }
        }
        b();
    }

    public void h() {
        f();
        android.ext.MainService.instance.i.J0(this.h);
        android.ext.f.m(android.ext.f.b().setView(android.ext.Tools.O0(e())).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reset_button), this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.save), this).create());
    }

    public void i(boolean[] zArr) {
        boolean[] zArr2 = this.f483c;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < this.f484d * 4; i++) {
            if (i % 4 == 0) {
                sb.append(' ');
                sb.append((i / 4) + 1);
                sb.append(':');
            }
            boolean z = zArr[i];
            zArr2[(i * 3) + 1] = z;
            sb.append(z ? '1' : '0');
        }
        android.ext.e1.d(this.f485e + " usage:" + sb.toString());
        j();
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(android.widget.CompoundButton compoundButton, boolean z) {
        java.lang.Object tag;
        if (compoundButton == null || (tag = compoundButton.getTag()) == null || !(tag instanceof java.lang.Integer)) {
            return;
        }
        this.f483c[(((java.lang.Integer) tag).intValue() * 3) + 2] = z;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        boolean[] zArr = this.f483c;
        if (i == -3) {
            boolean[] zArr2 = this.f487g;
            for (int i2 = 0; i2 < this.f484d * 4; i2++) {
                zArr[(i2 * 3) + 2] = zArr2[i2];
            }
        }
        for (int i3 = 0; i3 < this.f484d * 4; i3++) {
            int i4 = i3 * 3;
            zArr[i4] = zArr[i4 + 2];
        }
        g();
        android.ext.MainService.instance.i.H0(this.h);
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        int id = view.getId();
        int i = 0;
        int iIntValue = ((java.lang.Integer) view.getTag()).intValue();
        if (id != 2131034337) {
            boolean[] zArr = this.f482b;
            zArr[iIntValue] = !zArr[iIntValue];
            while (i < this.f484d) {
                this.f483c[(((i * 4) + iIntValue) * 3) + 2] = this.f482b[iIntValue];
                i++;
            }
        } else {
            boolean[] zArr2 = this.f481a;
            zArr2[iIntValue] = !zArr2[iIntValue];
            while (i < 4) {
                this.f483c[(((iIntValue * 4) + i) * 3) + 2] = this.f481a[iIntValue];
                i++;
            }
        }
        j();
    }
}

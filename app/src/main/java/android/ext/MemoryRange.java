package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class MemoryRange extends android.fix.LinearLayout implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.Runnable f308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.widget.Button f310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private android.view.View f311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private android.ext.EditText f312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private android.ext.EditText f313f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private android.view.View f314g;
    private android.ext.EditText h;
    private android.widget.CheckBox i;
    private android.widget.CheckBox j;
    private android.ext.EditText k;

    public MemoryRange(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f308a = null;
        this.f309b = 0;
        this.f310c = null;
    }

    public static long b(int i, android.ext.EditText editText, java.lang.String str, android.ext.EditText editText2, java.lang.String str2) {
        if (i == 0) {
            editText2 = editText;
        }
        java.lang.String strH = android.ext.j2.h(editText2.getText().toString().trim());
        if (strH.length() == 0) {
            if (i != 0) {
                str = str2;
            }
            strH = str;
        }
        java.lang.String strH2 = android.ext.j2.h(editText.getText().toString().trim());
        boolean zContains = strH2.contains("?");
        if (zContains) {
            strH = strH2.replace("?", i == 0 ? "0" : "F");
            if (i != 0) {
                editText2.setText(strH);
            }
        }
        try {
            long jR = android.ext.t1.r(strH, 16);
            if (i == 0 && zContains) {
                android.ext.y0.b(strH2, 1);
            }
            android.ext.y0.b(strH, 1);
            return jR;
        } catch (java.lang.NumberFormatException e2_c_c_c) {
            editText2.requestFocus();
            throw e2_c_c_c;
        }
    }

    private void d() {
        int i;
        int i2 = this.f309b;
        android.widget.Button button = this.f310c;
        if (i2 == 1) {
            i = catch_.me_.if_.you_.can_.R.string.only_memory;
        } else {
            i = i2 == 2 ? catch_.me_.if_.you_.can_.R.string.nearby : catch_.me_.if_.you_.can_.R.string.all_memory;
        }
        button.setText(android.ext.b2.f(i));
        this.f311d.setVisibility(i2 == 1 ? 0 : 8);
        this.f314g.setVisibility(i2 == 2 ? 0 : 8);
    }

    public long a(int i) {
        int i2 = this.f309b;
        if (i2 == 1) {
            long jB = b(i, this.f312e, "0", this.f313f, "-1");
            if (i == 0) {
                android.ext.Config.f31d = jB;
            } else {
                android.ext.Config.f32e = jB;
            }
            android.ext.Config.k();
            return jB;
        }
        if (i2 != 2) {
            return i == 0 ? 0L : -1L;
        }
        java.lang.String strH = android.ext.j2.h(this.h.getText().toString().trim());
        try {
            long jR = android.ext.t1.r(strH, 16);
            android.ext.y0.b(strH, 1);
            if (!(i == 0 ? this.i : this.j).isChecked()) {
                return jR;
            }
            java.lang.String strH2 = android.ext.j2.h(this.k.getText().toString().trim());
            try {
                long jR2 = android.ext.t1.r(strH2, 16);
                android.ext.y0.b(strH2, 1);
                android.ext.Config.f33f = jR2;
                android.ext.Config.k();
                if (i == 0) {
                    jR2 = -jR2;
                }
                return jR + jR2;
            } catch (java.lang.NumberFormatException e2_c_c_c) {
                this.k.requestFocus();
                throw e2_c_c_c;
            }
        } catch (java.lang.NumberFormatException e3_c_c_c) {
            this.h.requestFocus();
            throw e3_c_c_c;
        }
    }

    public void c() {
        if (this.f310c != null) {
            return;
        }
        gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.memory_range, this);
        this.f310c = (android.widget.Button) findViewById(catch_.me_.if_.you_.can_.R.id.range);
        this.f311d = findViewById(catch_.me_.if_.you_.can_.R.id.range_row);
        android.ext.EditText editText = (android.ext.EditText) findViewById(catch_.me_.if_.you_.can_.R.id.memory_from);
        this.f312e = editText;
        editText.setDataType(1);
        findViewById(catch_.me_.if_.you_.can_.R.id.region_from).setTag(this.f312e);
        android.ext.EditText editText2 = (android.ext.EditText) findViewById(catch_.me_.if_.you_.can_.R.id.memory_to);
        this.f313f = editText2;
        editText2.setDataType(1);
        findViewById(catch_.me_.if_.you_.can_.R.id.region_to).setTag(this.f313f);
        this.f312e.setText(android.ext.c.G(android.ext.Config.f31d, 4));
        this.f313f.setText(android.ext.c.G(android.ext.Config.f32e, 4));
        this.f314g = findViewById(catch_.me_.if_.you_.can_.R.id.nearby_row);
        android.ext.EditText editText3 = (android.ext.EditText) findViewById(catch_.me_.if_.you_.can_.R.id.address);
        this.h = editText3;
        editText3.setDataType(1);
        this.i = (android.widget.CheckBox) findViewById(catch_.me_.if_.you_.can_.R.id.before);
        this.j = (android.widget.CheckBox) findViewById(catch_.me_.if_.you_.can_.R.id.after);
        android.ext.EditText editText4 = (android.ext.EditText) findViewById(catch_.me_.if_.you_.can_.R.id.distance);
        this.k = editText4;
        editText4.setDataType(1);
        this.k.setText(java.lang.Long.toHexString(android.ext.Config.f33f).toUpperCase(java.util.Locale.US));
        this.f310c.setOnClickListener(this);
        android.ext.InternalKeyboard.o(this.f312e, 1);
        d();
    }

    public int getType() {
        return this.f309b;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        setType((this.f309b + 1) % 3);
    }

    public void setAddress(java.lang.String str) {
        this.h.setText(str);
    }

    public void setType(int i) {
        int i2 = this.f309b;
        this.f309b = i;
        d();
        java.lang.Runnable runnable = this.f308a;
        if (i2 == i || runnable == null) {
            return;
        }
        runnable.run();
    }

    public void setTypeChangeListener(java.lang.Runnable runnable) {
        this.f308a = runnable;
    }
}

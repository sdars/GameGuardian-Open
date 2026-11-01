package android.ext;

/* JADX INFO: loaded from: classes.dex */
class HexConverter$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.util.ArrayList f147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ long f148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.EditText f149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ android.text.Editable f152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ android.ext.HexConverter f153g;

    HexConverter$a(android.ext.HexConverter hexConverter, java.util.ArrayList arrayList, long j, android.ext.EditText editText, int i, int i2, android.text.Editable editable) {
        this.f153g = hexConverter;
        this.f147a = arrayList;
        this.f148b = j;
        this.f149c = editText;
        this.f150d = i;
        this.f151e = i2;
        this.f152f = editable;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i >= 0) {
            try {
                if (i < this.f147a.size()) {
                    java.lang.String str = (java.lang.String) this.f147a.get(i);
                    if (str == null) {
                        android.ext.Config$p config$pB = android.ext.Config.b(catch_.me_.if_.you_.can_.R.id.config_xor_key);
                        config$pB.g(new android.ext.HexConverter$a$a(this, config$pB));
                        config$pB.b();
                    } else {
                        try {
                            this.f149c.setSelection(this.f150d, this.f151e);
                            this.f152f.replace(this.f150d, this.f151e, str);
                        } catch (java.lang.IndexOutOfBoundsException e2) {
                            android.ext.e1.s("Failed replace text", e2);
                            this.f149c.setText(str);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.g("HexConverter failed with " + i, th);
                return;
            }
        }
        this.f149c.requestFocus();
    }
}

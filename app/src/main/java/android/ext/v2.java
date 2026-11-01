package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class v2 implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String[] f1284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final java.lang.String[] f1285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private android.widget.EditText f1286c;

    public v2(java.lang.String[] strArr, java.lang.String[] strArr2) {
        this.f1284a = strArr;
        this.f1285b = strArr2;
        if (strArr.length == strArr2.length) {
            return;
        }
        throw new java.lang.IllegalArgumentException("Params must be with same length: " + strArr.length + " != " + strArr2.length);
    }

    public static void a(android.widget.Button button, android.widget.EditText editText) {
        java.lang.String absolutePath;
        java.lang.String absolutePath2 = "error";
        try {
            absolutePath = android.ext.Tools.f0().getFilesDir().getAbsolutePath();
        } catch (java.lang.Throwable th) {
            android.ext.e1.s("Failed get files dir", th);
            absolutePath = "error";
        }
        try {
            absolutePath2 = android.ext.Tools.f0().getExternalFilesDir(null).getAbsolutePath();
        } catch (java.lang.Throwable th2) {
            android.ext.e1.s("Failed get ext files dir", th2);
        }
        button.setOnClickListener(new android.ext.v2(new java.lang.String[]{android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.internal_storage), android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.external_storage)}, new java.lang.String[]{absolutePath, absolutePath2}));
        button.setTag(editText);
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        if (i >= 0) {
            java.lang.String[] strArr = this.f1285b;
            if (i < strArr.length) {
                android.widget.EditText editText = this.f1286c;
                if (editText == null) {
                    android.ext.e1.s("Unkwnon edit", new java.lang.NullPointerException());
                    return;
                } else {
                    editText.setText(strArr[i]);
                    return;
                }
            }
        }
        android.ext.e1.s("Bad index: " + i + " for " + this.f1285b.length, new java.lang.IndexOutOfBoundsException());
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        if (view == null) {
            android.ext.e1.s("Unkwnon view", new java.lang.NullPointerException());
            return;
        }
        java.lang.Object tag = view.getTag();
        if (tag instanceof android.widget.EditText) {
            this.f1286c = (android.widget.EditText) tag;
            android.ext.f.o(android.ext.f.b().setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.typical_values)).setItems(this.f1284a, this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null));
        } else {
            android.ext.e1.s("Unkwnon tag: " + tag, new java.lang.IllegalArgumentException());
        }
    }
}

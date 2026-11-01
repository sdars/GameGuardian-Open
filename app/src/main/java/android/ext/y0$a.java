package android.ext;

/* JADX INFO: loaded from: classes.dex */
class y0$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.y0$b f1333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.widget.EditText f1334b;

    y0$a(android.ext.y0$b y0_b, android.widget.EditText editText) {
        this.f1333a = y0_b;
        this.f1334b = editText;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.String string = this.f1333a.getItem(i).toString();
        int iMax = java.lang.Math.max(this.f1334b.getSelectionStart(), 0);
        int iMax2 = java.lang.Math.max(this.f1334b.getSelectionEnd(), 0);
        this.f1334b.getText().replace(java.lang.Math.min(iMax, iMax2), java.lang.Math.max(iMax, iMax2), string, 0, string.length());
        android.widget.EditText editText = this.f1334b;
        editText.setSelection(java.lang.Math.max(editText.getSelectionStart(), this.f1334b.getSelectionEnd()));
    }
}

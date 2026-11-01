package android.ext;

/* JADX INFO: loaded from: classes.dex */
class j2$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.EditText f1039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.n$b f1040b;

    j2$a(android.widget.EditText editText, android.ext.n$b n_b) {
        this.f1039a = editText;
        this.f1040b = n_b;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.text.Editable text = this.f1039a.getText();
        java.lang.String string = text.toString();
        java.lang.String str = this.f1040b.f1085b;
        if (string.contains(str)) {
            int iIndexOf = string.indexOf(str);
            text.replace(iIndexOf, str.length() + iIndexOf, this.f1040b.f1084a);
        }
    }
}

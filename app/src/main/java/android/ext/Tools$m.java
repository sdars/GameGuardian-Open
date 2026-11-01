package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$m implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ java.lang.String f519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ android.content.DialogInterface.OnClickListener f520d;

    Tools$m(java.lang.String str, int i, java.lang.String str2, android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        this.f517a = str;
        this.f518b = i;
        this.f519c = str2;
        this.f520d = dialogInterface$OnClickListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        int iIndexOf;
        android.view.View viewF = gg_a.d.f(catch_.me_.if_.you_.can_.R.layout.logcat, null);
        android.widget.TextView textView = (android.widget.TextView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.logcat_text);
        textView.setText(this.f517a);
        if ((this.f518b & 4) != 0 && (iIndexOf = this.f517a.indexOf(8291)) >= 0) {
            android.text.SpannableString spannableString = new android.text.SpannableString(this.f517a);
            spannableString.setSpan(new android.text.style.BackgroundColorSpan(-7864320), iIndexOf, iIndexOf + 4, 33);
            textView.setText(spannableString);
        }
        android.fix.ScrollView scrollView = (android.fix.ScrollView) viewF.findViewById(catch_.me_.if_.you_.can_.R.id.logcat_page);
        scrollView.setFastScrollEnabled(true);
        android.app.AlertDialog.Builder view = android.ext.f.b().setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), (android.content.DialogInterface.OnClickListener) null).setView(viewF);
        if ((this.f518b & 2) == 0) {
            view.setNegativeButton(catch_.me_.if_.you_.can_.R.string.copy, new android.ext.Tools$m$a(this, textView));
        }
        java.lang.String str = this.f519c;
        if (str != null) {
            view.setNeutralButton(str, this.f520d);
        }
        android.app.AlertDialog alertDialogCreate = view.create();
        if ((this.f518b & 1) != 0) {
            android.ext.f.l(alertDialogCreate, new android.ext.Tools$m$b(this, scrollView));
        }
        android.ext.f.m(alertDialogCreate);
        android.view.Window window = alertDialogCreate.getWindow();
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
    }
}

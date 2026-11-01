package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$m$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.TextView f521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.Tools$m f522b;

    Tools$m$a(android.ext.Tools$m tools$m, android.widget.TextView textView) {
        this.f522b = tools$m;
        this.f521a = textView;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.Tools.A(this.f521a.getText().toString().trim(), false);
    }
}

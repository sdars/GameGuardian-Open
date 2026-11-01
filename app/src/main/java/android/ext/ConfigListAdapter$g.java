package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$g implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String[] f64a;

    ConfigListAdapter$g(java.lang.String[] strArr) {
        this.f64a = strArr;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.p1[] p1VarArr = android.ext.MainService.J0[i / 2];
        int length = p1VarArr.length;
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[length];
        android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[p1VarArr.length];
        boolean[] zArr = new boolean[length];
        long j = android.ext.Config.f29b[i];
        for (int i2 = 0; i2 < length; i2++) {
            charSequenceArr[i2] = p1VarArr[i2].toString();
            zArr[i2] = ((1 << i2) & j) != 0;
            drawableArr[i2] = p1VarArr[i2].c();
        }
        android.ext.ConfigListAdapter$g$a configListAdapter$g$a = new android.ext.ConfigListAdapter$g$a(this, zArr, i);
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.Tools.k0()).setCustomTitle(android.ext.Tools.h0(this.f64a[i])).setMultiChoiceItems(charSequenceArr, zArr, new android.ext.ConfigListAdapter$g$b(this, zArr)).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.save), configListAdapter$g$a).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reset_button), configListAdapter$g$a).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), configListAdapter$g$a).create();
        android.widget.ListView listView = alertDialogCreate.getListView();
        if (listView != null) {
            android.ext.Tools.e(listView, charSequenceArr, drawableArr, android.ext.Config.d(), catch_.me_.if_.you_.can_.R.style.SmallText);
        }
        android.ext.f.m(alertDialogCreate);
    }
}

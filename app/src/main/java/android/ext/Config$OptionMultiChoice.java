package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Config$OptionMultiChoice extends android.ext.Config$s implements android.content.DialogInterface.OnMultiChoiceClickListener, android.content.DialogInterface.OnShowListener, android.widget.AbsListView.OnScrollListener {
    boolean[] n;

    public Config$OptionMultiChoice(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z) {
        super(i, i2, iArr, i3, str, z);
    }

    public Config$OptionMultiChoice(int i, int i2, int[] iArr, int i3, java.lang.String str, boolean z, int i4) {
        this(i, i2, iArr, i3, str, z);
        this.h = i4;
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public boolean e(android.content.DialogInterface dialogInterface, int i) {
        if (i != -1 && i != -3) {
            return false;
        }
        boolean[] zArr = this.n;
        int i2 = this.f40b;
        if (zArr != null && i == -1) {
            for (int i3 = 0; i3 < zArr.length; i3++) {
                int iH = h(i3);
                i2 = zArr[i3] ? iH | i2 : (~iH) & i2;
            }
            this.n = null;
        }
        this.f42d = i2;
        android.ext.Config.k();
        android.ext.Tools.D(dialogInterface);
        return true;
    }

    @Override // android.ext.Config$s
    protected void j(java.lang.CharSequence[] charSequenceArr) {
        boolean[] zArr = new boolean[charSequenceArr.length];
        this.n = zArr;
        int i = this.f42d;
        for (int i2 = 0; i2 < charSequenceArr.length; i2++) {
            int iH = h(i2);
            zArr[i2] = (i & iH) == iH;
        }
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.Tools.k0()).setCustomTitle(android.ext.Config.c(this.f39a, this.h, this.f45g)).setMultiChoiceItems(charSequenceArr, zArr, this).setPositiveButton(catch_.me_.if_.you_.can_.R.string.save, this).setNeutralButton(catch_.me_.if_.you_.can_.R.string.reset_button, this).setNegativeButton(catch_.me_.if_.you_.can_.R.string.cancel, this).create();
        android.ext.f.l(alertDialogCreate, this);
        android.ext.f.m(alertDialogCreate);
    }

    protected void l(boolean z) {
        if (this.m == null) {
            int i = z ? 6 : 3;
            int[] iArr = new int[i];
            java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[i];
            if (z) {
                iArr[0] = 1;
                charSequenceArr[0] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search) + ", " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.portrait);
                iArr[1] = 2;
                charSequenceArr[1] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search) + ", " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.landscape);
                iArr[2] = 4;
                charSequenceArr[2] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.saved_list) + ", " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.portrait);
                iArr[3] = 8;
                charSequenceArr[3] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.saved_list) + ", " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.landscape);
                iArr[4] = 16;
                charSequenceArr[4] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.memory_editor) + ", " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.portrait);
                iArr[5] = 32;
                charSequenceArr[5] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.memory_editor) + ", " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.landscape);
            } else {
                iArr[0] = 1;
                charSequenceArr[0] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.search);
                iArr[1] = 2;
                charSequenceArr[1] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.saved_list);
                iArr[2] = 4;
                charSequenceArr[2] = android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.memory_editor);
            }
            this.m = iArr;
            this.l = charSequenceArr;
            this.k = null;
        }
    }

    @Override // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i, boolean z) {
        boolean[] zArr = this.n;
        if (zArr == null) {
            android.ext.e1.l("", new java.lang.NullPointerException(toString()));
            return;
        }
        try {
            zArr[i] = z;
        } catch (java.lang.ArrayIndexOutOfBoundsException e2) {
            android.ext.e1.l("", e2);
        }
    }

    @Override // android.widget.AbsListView$OnScrollListener
    public void onScroll(android.widget.AbsListView absListView, int i, int i2, int i3) {
        onScrollStateChanged(absListView, 0);
    }

    @Override // android.widget.AbsListView$OnScrollListener
    public void onScrollStateChanged(android.widget.AbsListView absListView, int i) {
        try {
            int childCount = absListView.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                try {
                    android.view.View childAt = absListView.getChildAt(i2);
                    if (childAt instanceof android.widget.CheckedTextView) {
                        ((android.widget.CheckedTextView) childAt).refreshDrawableState();
                    }
                } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.content.DialogInterface$OnShowListener
    public void onShow(android.content.DialogInterface dialogInterface) {
        android.widget.ListView listView;
        if (android.os.Build.VERSION.SDK_INT < 23 || !(dialogInterface instanceof android.app.AlertDialog) || (listView = ((android.app.AlertDialog) dialogInterface).getListView()) == null) {
            return;
        }
        listView.setOnScrollListener(this);
    }

    @Override // android.ext.Config$s, android.ext.Config$p
    public java.lang.String toString() {
        return android.ext.Tools.N1(this.f39a);
    }
}

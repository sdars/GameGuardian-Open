package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class o1 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1150a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final java.util.List f1151b = new java.util.ArrayList();

    public boolean a(long j, java.lang.CharSequence charSequence) {
        return b(j, charSequence, 0);
    }

    public boolean b(long j, java.lang.CharSequence charSequence, int i) {
        int i2;
        int size = this.f1151b.size();
        if (this.f1150a < size) {
            while (true) {
                size--;
                i2 = this.f1150a;
                if (size < i2) {
                    break;
                }
                this.f1151b.remove(size);
            }
            size = i2;
        }
        if (size >= 100) {
            this.f1150a--;
            this.f1151b.remove(0);
        }
        this.f1150a++;
        android.ext.z1$d z1_d = android.ext.MainService.instance.v0;
        return this.f1151b.add(new android.ext.o1$a(j, charSequence, z1_d != null ? z1_d.f1434c : null, i));
    }

    public void c() {
        if (this.f1151b.size() == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.history_empty);
            return;
        }
        int i = this.f1150a;
        if (i < 2) {
            android.ext.Tools.I1(catch_.me_.if_.you_.can_.R.string.no_previous, 0);
        } else {
            onClick(null, i - 2);
        }
    }

    public void d() {
        int size = this.f1151b.size();
        if (size == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.history_empty);
            return;
        }
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[size];
        android.graphics.drawable.Drawable[] drawableArr = new android.graphics.drawable.Drawable[size];
        java.util.HashMap map = new java.util.HashMap();
        for (int i = 0; i < size; i++) {
            android.ext.o1$a o1_a = (android.ext.o1$a) this.f1151b.get(i);
            charSequenceArr[i] = o1_a.a();
            java.lang.String str = o1_a.f1154c;
            if (str != null) {
                android.graphics.drawable.Drawable drawableR1 = (android.graphics.drawable.Drawable) map.get(str);
                if (drawableR1 == null) {
                    try {
                        drawableR1 = android.ext.Tools.R1(android.ext.Tools.G0(android.ext.Tools.X(android.ext.Tools.Y(o1_a.f1154c)), android.ext.Tools.H()));
                    } catch (java.lang.Throwable th) {
                        android.ext.e1.l("Failed load icon for " + o1_a.f1154c, th);
                    }
                    map.put(o1_a.f1154c, drawableR1);
                }
                drawableArr[i] = drawableR1;
            }
        }
        android.app.AlertDialog alertDialogCreate = android.ext.f.c(android.ext.Tools.k0()).setCustomTitle(android.ext.Tools.g0(catch_.me_.if_.you_.can_.R.string.goto_address)).setSingleChoiceItems(charSequenceArr, this.f1150a - 1, this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).create();
        android.widget.ListView listView = alertDialogCreate.getListView();
        if (listView != null) {
            android.ext.Tools.e(listView, charSequenceArr, drawableArr, 48, catch_.me_.if_.you_.can_.R.style.SmallText);
        }
        android.ext.f.m(alertDialogCreate);
    }

    public void e() {
        int size = this.f1151b.size();
        if (size == 0) {
            android.ext.Tools.H1(catch_.me_.if_.you_.can_.R.string.history_empty);
            return;
        }
        int i = this.f1150a;
        if (i >= size) {
            android.ext.Tools.I1(catch_.me_.if_.you_.can_.R.string.no_next, 0);
        } else {
            onClick(null, i);
        }
    }

    public long f() {
        int size = this.f1151b.size();
        int i = this.f1150a;
        if (i <= 0 || i > size) {
            return 0L;
        }
        return ((android.ext.o1$a) this.f1151b.get(i - 1)).f1152a;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.o1$a o1_a = (android.ext.o1$a) this.f1151b.get(i);
        if (o1_a != null) {
            this.f1150a = i + 1;
            android.ext.MainService.instance.K(o1_a.f1152a, o1_a.f1155d);
        }
        if (dialogInterface != null) {
            android.ext.Tools.D(dialogInterface);
        }
    }
}

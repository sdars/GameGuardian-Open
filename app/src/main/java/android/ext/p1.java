package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class p1 implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long[] f1170e = new long[3];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.lang.String f1171a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1172b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private java.lang.ref.WeakReference f1173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1174d;

    public p1(int i, int i2) {
        this.f1172b = 0;
        this.f1173c = new java.lang.ref.WeakReference(null);
        this.f1174d = -1;
        this.f1171a = android.ext.b2.f(i);
        this.f1172b = i2;
    }

    public p1(java.lang.String str) {
        this.f1172b = 0;
        this.f1173c = new java.lang.ref.WeakReference(null);
        this.f1174d = -1;
        this.f1171a = str;
    }

    public static java.lang.String d() {
        android.content.SharedPreferences sharedPreferencesM0 = android.ext.Tools.M0();
        android.content.SharedPreferences.Editor sharedPreferences$EditorEdit = sharedPreferencesM0.edit();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 3; i++) {
            java.lang.String str = "m-" + i;
            long j = sharedPreferencesM0.getLong(str, 0L);
            sharedPreferences$EditorEdit.remove(str);
            if (j != 0) {
                sb.append("&m");
                sb.append(i);
                sb.append('=');
                sb.append(java.lang.Long.toHexString(j));
            }
        }
        sharedPreferences$EditorEdit.commit();
        return sb.toString();
    }

    private static void f() {
        android.ext.g2 g2Var = new android.ext.g2();
        for (int i = 0; i < 3; i++) {
            g2Var.i("m-" + i, f1170e[i], 0L);
        }
        g2Var.commit();
    }

    public final android.widget.ImageView a() {
        return b(false);
    }

    public android.widget.ImageView b(boolean z) {
        android.fix.ToolbarButton toolbarButton = new android.fix.ToolbarButton(android.ext.Tools.f0());
        toolbarButton.setIcon(this.f1172b);
        toolbarButton.setOnClickListener(!z ? this : new android.ext.p1$a(this));
        toolbarButton.setTag(this);
        return toolbarButton;
    }

    public android.graphics.drawable.Drawable c() {
        if (this.f1172b == 0) {
            return null;
        }
        android.graphics.drawable.Drawable drawable = (android.graphics.drawable.Drawable) this.f1173c.get();
        if (drawable != null) {
            return drawable;
        }
        android.graphics.drawable.Drawable drawableO0 = android.ext.Tools.o0(this.f1172b);
        this.f1173c = new java.lang.ref.WeakReference(drawableO0);
        return drawableO0;
    }

    public void e(android.view.View view) {
        int i;
        int i2 = this.f1174d;
        if (i2 != -1 && (i = i2 / 64) >= 0 && i < 3) {
            long j = 1 << (i2 % 64);
            long[] jArr = f1170e;
            long j2 = jArr[i];
            if ((j2 & j) == 0) {
                jArr[i] = j | j2;
                f();
            }
        }
        onClick(view);
    }

    public void g(int i, int i2) {
        this.f1174d = (i * 64) + i2;
    }

    @Override // android.view.View$OnClickListener
    public abstract void onClick(android.view.View view);

    public java.lang.String toString() {
        return this.f1171a;
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class p0 implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1169b;

    public p0(int i) {
        this(i, false);
    }

    public p0(int i, boolean z) {
        this.f1169b = i;
        this.f1168a = z;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.e1.d("ExitListener called: " + this.f1169b);
        android.ext.f1.f953c = this.f1168a ? 1 : 0;
        android.ext.f1.o();
    }
}

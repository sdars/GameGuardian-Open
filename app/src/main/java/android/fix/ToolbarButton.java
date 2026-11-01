package android.fix;

/* JADX INFO: loaded from: classes.dex */
public class ToolbarButton extends android.fix.ImageButtonView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1451b;

    public ToolbarButton(android.content.Context context) {
        super(context);
        this.f1450a = 0;
        this.f1451b = false;
    }

    public ToolbarButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1450a = 0;
        this.f1451b = false;
    }

    public void setIcon(int i) {
        this.f1450a = i;
        setMinimumWidth((int) android.ext.Tools.G(45.0f));
        setMinimumHeight(android.ext.Tools.H());
    }

    public void setIcon(boolean z) {
        if (this.f1451b != z) {
            this.f1451b = z;
            try {
                if (z) {
                    setImageResource(this.f1450a);
                    android.ext.Config.o(this, (int) android.ext.Tools.G(45.0f), android.ext.Tools.H());
                } else {
                    setImageDrawable(null);
                }
            } catch (java.lang.Throwable th) {
                android.ext.e1.a(th);
            }
        }
    }

    @Override // android.view.View
    public java.lang.String toString() {
        return super.toString() + " " + this.f1450a + "; " + this.f1451b;
    }
}

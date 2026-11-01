package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class SystemSpinnerType extends android.ext.SystemSpinner {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    android.ext.c$a[] f478d;

    public SystemSpinnerType(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.ext.SystemSpinner
    protected void a() {
        this.f478d = android.ext.c.x(this.f477c, null);
        int i = 0;
        int i2 = 0;
        while (true) {
            android.ext.c$a[] c_aArr = this.f478d;
            if (i2 >= c_aArr.length) {
                break;
            }
            if (c_aArr[i2].f675a == this.f475a) {
                i = i2;
                break;
            }
            i2++;
        }
        android.ext.f.o(android.ext.f.c(android.ext.Tools.l0(getContext())).setSingleChoiceItems(new android.ext.SystemSpinnerType$a(this, android.ext.MainService.context, android.R.layout.select_dialog_singlechoice, android.R.id.text1, this.f478d), i, this));
    }

    @Override // android.ext.SystemSpinner, android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        setSelected(this.f478d[i].f675a);
        android.ext.Tools.D(dialogInterface);
    }

    @Override // android.ext.SystemSpinner
    public void setSelected(int i) {
        super.setSelected(i);
        setTextColor(android.ext.c.n(i));
    }
}

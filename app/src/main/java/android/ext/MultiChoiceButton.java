package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class MultiChoiceButton extends android.ext.SystemSpinner implements android.content.DialogInterface.OnMultiChoiceClickListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected int f315d;

    public MultiChoiceButton(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.ext.SystemSpinner
    protected void a() {
        gg_a.e eVar = this.f477c;
        int size = eVar.size();
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[size];
        boolean[] zArr = new boolean[size];
        this.f315d = 0;
        for (int i = 0; i < size; i++) {
            int i2 = (size - 1) - i;
            int iKeyAt = eVar.keyAt(i2);
            charSequenceArr[i] = (java.lang.CharSequence) eVar.valueAt(i2);
            boolean z = (this.f475a & iKeyAt) != 0;
            zArr[i] = z;
            onClick(null, i, z);
        }
        android.ext.f.o(android.ext.f.c(android.ext.Tools.l0(getContext())).setMultiChoiceItems(charSequenceArr, zArr, this).setNegativeButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.cancel), (android.content.DialogInterface.OnClickListener) null).setNeutralButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.reset_button), this).setPositiveButton(android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.ok), this));
    }

    @Override // android.ext.SystemSpinner, android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        int size = this.f477c.size();
        int i2 = 0;
        if (i == -1) {
            int iKeyAt = 0;
            while (i2 < size) {
                if ((this.f315d & (1 << i2)) != 0) {
                    iKeyAt |= this.f477c.keyAt((size - 1) - i2);
                }
                i2++;
            }
            i2 = iKeyAt;
        }
        setSelected(i2);
        android.ext.Tools.D(dialogInterface);
    }

    @Override // android.content.DialogInterface$OnMultiChoiceClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i, boolean z) {
        int i2;
        if (z) {
            i2 = (1 << i) | this.f315d;
        } else {
            i2 = (~(1 << i)) & this.f315d;
        }
        this.f315d = i2;
    }

    @Override // android.ext.SystemSpinner
    public void setSelected(int i) {
        gg_a.e eVar = this.f477c;
        if (eVar == null) {
            return;
        }
        int size = eVar.size();
        android.ext.y yVar = new android.ext.y();
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = (size - 1) - i2;
            if ((eVar.keyAt(i3) & i) != 0) {
                if (yVar.c() != 0) {
                    yVar.a(",");
                }
                java.lang.CharSequence charSequence = (java.lang.CharSequence) eVar.valueAt(i3);
                yVar.a(charSequence.subSequence(0, charSequence.toString().indexOf(58)));
            }
        }
        setText(yVar.d());
        this.f475a = i;
        android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener = this.f476b;
        if (dialogInterface$OnClickListener != null) {
            dialogInterface$OnClickListener.onClick(null, i);
        }
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class SystemSpinner extends android.fix.Button implements android.view.View.OnClickListener, android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected android.content.DialogInterface.OnClickListener f476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected gg_a.e f477c;

    public SystemSpinner(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f477c = null;
    }

    protected void a() {
        gg_a.e eVar = this.f477c;
        int size = eVar.size();
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[size];
        for (int i = 0; i < size; i++) {
            charSequenceArr[i] = (java.lang.CharSequence) eVar.valueAt((size - 1) - i);
        }
        android.ext.f.o(android.ext.f.c(getContext()).setSingleChoiceItems(charSequenceArr, (size - 1) - eVar.indexOfKey(this.f475a), this));
    }

    public int getSelected() {
        return this.f475a;
    }

    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        gg_a.e eVar = this.f477c;
        setSelected(eVar.keyAt((eVar.size() - 1) - i));
        android.ext.Tools.D(dialogInterface);
    }

    @Override // android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        gg_a.e eVar = this.f477c;
        if (eVar == null || eVar.size() == 0) {
            return;
        }
        a();
    }

    public void setData(gg_a.e eVar) {
        if (eVar == null) {
            return;
        }
        this.f477c = eVar;
        int size = eVar.size();
        if (size == 0) {
            return;
        }
        this.f475a = eVar.keyAt(size - 1);
        setOnClickListener(this);
    }

    public void setOnItemSelectedListener(android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener) {
        this.f476b = dialogInterface$OnClickListener;
    }

    public void setSelected(int i) {
        gg_a.e eVar = this.f477c;
        if (eVar == null) {
            return;
        }
        java.lang.CharSequence charSequence = (java.lang.CharSequence) eVar.get(i);
        if (charSequence == null) {
            if (eVar.size() == 1) {
                charSequence = (java.lang.CharSequence) eVar.valueAt(0);
                i = eVar.keyAt(0);
            } else {
                charSequence = "???";
            }
        }
        setText(charSequence);
        this.f475a = i;
        android.content.DialogInterface.OnClickListener dialogInterface$OnClickListener = this.f476b;
        if (dialogInterface$OnClickListener != null) {
            dialogInterface$OnClickListener.onClick(null, i);
        }
    }
}

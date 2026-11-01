package android.ext;

/* JADX INFO: loaded from: classes.dex */
class SystemSpinnerType$a extends android.ext.ArrayAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.SystemSpinnerType f479b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SystemSpinnerType$a(android.ext.SystemSpinnerType systemSpinnerType, android.content.Context context, int i, int i2, android.ext.c$a[] c_aArr) {
        super(context, i, i2, c_aArr);
        this.f479b = systemSpinnerType;
    }

    @Override // android.ext.ArrayAdapter, android.widget.ArrayAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        android.ext.c$a c_a;
        android.view.View view2 = super.getView(i, view, viewGroup);
        android.widget.TextView textView = (android.widget.TextView) view2.findViewById(android.R.id.text1);
        if (textView != null) {
            android.ext.Tools.D1(textView, catch_.me_.if_.you_.can_.R.style.SmallText);
            if (i > 0) {
                android.ext.c$a[] c_aArr = this.f479b.f478d;
                if (i < c_aArr.length && (c_a = c_aArr[i]) != null) {
                    textView.setTextColor(android.ext.c.n(c_a.f675a));
                }
            }
        }
        return view2;
    }
}

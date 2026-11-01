package android.ext;

/* JADX INFO: loaded from: classes.dex */
class u2$a extends android.ext.ArrayAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.u2 f1276b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u2$a(android.ext.u2 u2Var, android.content.Context context, android.ext.c$a[] c_aArr) {
        super(context, c_aArr);
        this.f1276b = u2Var;
    }

    @Override // android.ext.ArrayAdapter, android.widget.ArrayAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        android.ext.c$a c_a;
        android.view.View view2 = super.getView(i, view, viewGroup);
        android.widget.TextView textView = (android.widget.TextView) view2.findViewById(android.R.id.text1);
        if (textView != null) {
            android.ext.Tools.D1(textView, catch_.me_.if_.you_.can_.R.style.SmallText);
            if (i >= 0) {
                android.ext.c$a[] c_aArr = this.f1276b.f1273a;
                if (i < c_aArr.length && (c_a = c_aArr[i]) != null) {
                    textView.setTextColor(android.ext.c.n(c_a.f675a));
                }
            }
        }
        return view2;
    }
}

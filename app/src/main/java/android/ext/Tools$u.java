package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$u implements android.view.ViewGroup.OnHierarchyChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.lang.CharSequence[] f541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.graphics.drawable.Drawable[] f542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f543d;

    Tools$u(int i, java.lang.CharSequence[] charSequenceArr, android.graphics.drawable.Drawable[] drawableArr, int i2) {
        this.f540a = i;
        this.f541b = charSequenceArr;
        this.f542c = drawableArr;
        this.f543d = i2;
    }

    @Override // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewAdded(android.view.View view, android.view.View view2) {
        try {
            android.view.View viewFindViewById = view2.findViewById(android.R.id.text1);
            if (viewFindViewById instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) viewFindViewById;
                int i = this.f540a;
                if (i != 0) {
                    android.ext.Tools.D1(textView, i);
                }
                if (textView.getTag() == null) {
                    android.ext.Tools$u$a tools$u$a = new android.ext.Tools$u$a(this, textView);
                    textView.addTextChangedListener(tools$u$a);
                    textView.setTag(tools$u$a);
                    tools$u$a.onTextChanged(textView.getText(), 0, 0, 0);
                }
            }
        } catch (java.lang.Throwable th) {
            android.ext.e1.a(th);
        }
    }

    @Override // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewRemoved(android.view.View view, android.view.View view2) {
    }
}

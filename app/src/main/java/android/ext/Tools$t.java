package android.ext;

/* JADX INFO: loaded from: classes.dex */
class Tools$t implements android.view.ViewGroup.OnHierarchyChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f539a;

    Tools$t(int i) {
        this.f539a = i;
    }

    @Override // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewAdded(android.view.View view, android.view.View view2) {
        try {
            android.view.View viewFindViewById = view2.findViewById(android.R.id.text1);
            if (viewFindViewById instanceof android.widget.TextView) {
                android.widget.TextView textView = (android.widget.TextView) viewFindViewById;
                int i = this.f539a;
                if (i != 0) {
                    android.ext.Tools.D1(textView, i);
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

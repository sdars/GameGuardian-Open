package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$m$a extends android.ext.ArrayAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService$m f271b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainService$m$a(android.ext.MainService$m mainService$m, android.content.Context context, android.ext.p1[] p1VarArr) {
        super(context, p1VarArr);
        this.f271b = mainService$m;
    }

    @Override // android.ext.ArrayAdapter, android.widget.ArrayAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View view2 = super.getView(i, view, viewGroup);
        android.widget.TextView textView = (android.widget.TextView) view2.findViewById(android.R.id.text1);
        if (textView != null) {
            android.ext.Tools.D1(textView, catch_.me_.if_.you_.can_.R.style.SmallText);
        }
        return view2;
    }
}

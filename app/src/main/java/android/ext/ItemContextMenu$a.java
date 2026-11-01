package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ItemContextMenu$a extends android.ext.ArrayAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ java.util.List f202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.ItemContextMenu f203c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ItemContextMenu$a(android.ext.ItemContextMenu itemContextMenu, android.content.Context context, java.util.List list, java.util.List list2) {
        super(context, list);
        this.f203c = itemContextMenu;
        this.f202b = list2;
    }

    @Override // android.ext.ArrayAdapter, android.widget.ArrayAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        android.view.View view2 = super.getView(i, view, viewGroup);
        android.graphics.drawable.Drawable drawableO0 = android.ext.Tools.o0(((java.lang.Integer) this.f202b.get(i)).intValue());
        android.widget.TextView textView = (android.widget.TextView) view2.findViewById(android.R.id.text1);
        if (textView != null) {
            android.ext.Tools.D1(textView, catch_.me_.if_.you_.can_.R.style.ListItemText);
            android.ext.Tools.c(textView, drawableO0, android.ext.Config.d());
        }
        return view2;
    }
}

package android.ext;

/* JADX INFO: loaded from: classes.dex */
class PathSelector$c$b extends android.ext.ArrayAdapter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.PathSelector$c f334b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PathSelector$c$b(android.ext.PathSelector$c pathSelector$c, android.content.Context context, java.util.List list) {
        super(context, list);
        this.f334b = pathSelector$c;
    }

    @Override // android.ext.ArrayAdapter, android.widget.ArrayAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        return this.f334b.b(i, view, viewGroup);
    }
}

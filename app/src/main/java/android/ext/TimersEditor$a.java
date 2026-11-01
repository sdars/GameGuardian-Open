package android.ext;

/* JADX INFO: loaded from: classes.dex */
class TimersEditor$a extends android.widget.BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.TimersEditor f488a;

    TimersEditor$a(android.ext.TimersEditor timersEditor) {
        this.f488a = timersEditor;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f488a.f484d + 1;
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i) {
        return java.lang.Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        return i == 0 ? this.f488a.c(view, viewGroup) : this.f488a.d(i, view, viewGroup);
    }
}

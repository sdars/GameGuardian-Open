package android.ext;

/* JADX INFO: loaded from: classes.dex */
class EditTextPath$a extends android.widget.BaseAdapter implements android.widget.Filterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ android.ext.EditTextPath f119c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    java.io.File[] f118b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final android.widget.Filter f117a = new android.ext.EditTextPath$a$a(this);

    public EditTextPath$a(android.ext.EditTextPath editTextPath) {
        this.f119c = editTextPath;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        java.io.File[] fileArr = this.f118b;
        if (fileArr == null) {
            return 0;
        }
        return fileArr.length;
    }

    @Override // android.widget.Filterable
    public android.widget.Filter getFilter() {
        return this.f117a;
    }

    @Override // android.widget.Adapter
    public java.lang.Object getItem(int i) {
        java.io.File[] fileArr = this.f118b;
        if (fileArr == null || i < 0 || i >= fileArr.length) {
            return null;
        }
        return fileArr[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        if (view == null) {
            view = gg_a.d.g(catch_.me_.if_.you_.can_.R.layout.path_suggestion, viewGroup, false);
        }
        java.lang.Object item = getItem(i);
        if (item instanceof java.io.File) {
            ((android.widget.TextView) view.findViewById(catch_.me_.if_.you_.can_.R.id.text1)).setText(".../" + ((java.io.File) item).getName());
        }
        return view;
    }
}

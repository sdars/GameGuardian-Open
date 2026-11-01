package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class ArrayAdapter<T> extends android.widget.ArrayAdapter<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gg_a.d f27a;

    public ArrayAdapter(android.content.Context context, int i) {
        super(context, i);
        this.f27a = null;
    }

    public ArrayAdapter(android.content.Context context, int i, int i2, java.lang.Object[] objArr) {
        super(context, i, i2, (T[]) objArr);
        this.f27a = null;
    }

    public ArrayAdapter(android.content.Context context, java.util.List<T> list) {
        super(context, android.R.layout.select_dialog_item, android.R.id.text1, list);
        this.f27a = null;
    }

    public ArrayAdapter(android.content.Context context, T[] tArr) {
        super(context, android.R.layout.select_dialog_item, android.R.id.text1, tArr);
        this.f27a = null;
    }

    @Override // android.widget.ArrayAdapter
    public void addAll(java.util.Collection collection) {
        super.addAll(collection);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        android.widget.TextView textView;
        java.lang.Object item;
        android.graphics.drawable.Drawable drawableC;
        try {
            view = super.getView(i, view, viewGroup);
            item = null;
            textView = null;
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Failed get view for ArrayAdapter", th);
            if (view == null) {
                if (this.f27a == null) {
                    this.f27a = gg_a.d.c();
                }
                view = this.f27a.inflate(catch_.me_.if_.you_.can_.R.layout.select_dialog_item, viewGroup, false);
            }
            android.widget.TextView textView2 = (android.widget.TextView) view;
            java.lang.Object item2 = getItem(i);
            textView2.setText(item2 instanceof java.lang.CharSequence ? (java.lang.CharSequence) item2 : item2.toString());
            textView = textView2;
            item = item2;
        }
        if (item == null && (view instanceof android.widget.TextView)) {
            item = getItem(i);
            textView = (android.widget.TextView) view;
        }
        if ((item instanceof android.ext.p1) && textView != null && (drawableC = ((android.ext.p1) item).c()) != null) {
            android.ext.Tools.c(textView, drawableC, android.ext.Config.d());
        }
        return view;
    }
}

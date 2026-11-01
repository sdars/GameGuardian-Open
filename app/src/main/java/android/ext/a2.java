package android.ext;

/* JADX INFO: loaded from: classes.dex */
class a2 extends android.widget.BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.List f570a;

    public a2(java.util.List list) {
        this.f570a = list;
    }

    private static android.widget.TextView b(android.view.View view) {
        if (view instanceof android.widget.TextView) {
            return (android.widget.TextView) view;
        }
        android.view.View viewFindViewById = view.findViewById(android.R.id.text1);
        if (viewFindViewById instanceof android.widget.TextView) {
            return (android.widget.TextView) viewFindViewById;
        }
        return null;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public android.ext.z1$d getItem(int i) {
        return (android.ext.z1$d) this.f570a.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f570a.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public android.view.View getView(int i, android.view.View view, android.view.ViewGroup viewGroup) {
        android.widget.TextView textViewB;
        if (view == null) {
            try {
                view = gg_a.d.c().inflate(android.R.layout.select_dialog_item, viewGroup, false);
            } catch (java.lang.Throwable th) {
                android.ext.e1.l("Failed inflate process list item", th);
                view = gg_a.d.c().inflate(catch_.me_.if_.you_.can_.R.layout.select_dialog_item, viewGroup, false);
            }
            textViewB = b(view);
            if (textViewB != null) {
                android.ext.Tools.D1(textViewB, catch_.me_.if_.you_.can_.R.style.ListItemText);
            }
        } else {
            textViewB = b(view);
        }
        if (textViewB == null) {
            return view;
        }
        try {
            android.ext.z1$d z1_d = (android.ext.z1$d) this.f570a.get(i);
            if (z1_d != null) {
                textViewB.setText(z1_d.l());
                textViewB.setTag(z1_d);
                z1_d.j(textViewB);
            }
        } catch (java.lang.Throwable th2) {
            android.ext.e1.a(th2);
        }
        return view;
    }
}

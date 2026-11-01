package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class EditorListener extends android.ext.p1 implements android.widget.AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f123f;

    public EditorListener() {
        this(false);
    }

    public EditorListener(boolean z) {
        super(catch_.me_.if_.you_.can_.R.string.edit_selected, catch_.me_.if_.you_.can_.R.drawable.ic_tooltip_edit_white_24dp);
        this.f123f = z;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        new android.ext.EditorListener$b(this, null).onClick(view);
    }

    @Override // android.widget.AdapterView$OnItemClickListener
    public void onItemClick(android.widget.AdapterView adapterView, android.view.View view, int i, long j) {
        new android.ext.EditorListener$b(this, null).onItemClick(adapterView, view, i, j);
    }
}

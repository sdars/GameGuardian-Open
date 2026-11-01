package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAdapterLC extends android.widget.BaseAdapter implements android.view.View.OnLongClickListener {
    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        android.widget.AdapterView<?> adapterViewW0;
        int positionForView;
        if (view == null || (adapterViewW0 = android.ext.Tools.w0(view)) == null || (positionForView = adapterViewW0.getPositionForView(view)) == -1) {
            return false;
        }
        android.widget.AdapterView.OnItemLongClickListener onItemLongClickListener = adapterViewW0.getOnItemLongClickListener();
        if (onItemLongClickListener == null) {
            return true;
        }
        onItemLongClickListener.onItemLongClick(adapterViewW0, view, positionForView, getItemId(positionForView));
        return true;
    }
}

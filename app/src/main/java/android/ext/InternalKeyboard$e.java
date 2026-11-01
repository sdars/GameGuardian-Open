package android.ext;

/* JADX INFO: loaded from: classes.dex */
public abstract class InternalKeyboard$e implements android.view.View.OnFocusChangeListener {
    protected abstract boolean a(android.view.View view, boolean z);

    @Override // android.view.View$OnFocusChangeListener
    public void onFocusChange(android.view.View view, boolean z) {
        android.ext.InternalKeyboard internalKeyboard;
        if ((android.ext.Config.B & 1) == 0 || (internalKeyboard = (android.ext.InternalKeyboard) view.getRootView().findViewById(catch_.me_.if_.you_.can_.R.id.keyboard)) == null) {
            return;
        }
        boolean zA = a(view, z);
        if (!zA) {
            z = false;
        }
        internalKeyboard.h(view, z);
        if (zA) {
            return;
        }
        android.ext.Tools.S0(view);
    }
}

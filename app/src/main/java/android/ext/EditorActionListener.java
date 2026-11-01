package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class EditorActionListener implements android.widget.TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.ref.WeakReference f122a;

    public EditorActionListener(android.app.AlertDialog alertDialog) {
        this.f122a = new java.lang.ref.WeakReference(null);
        this.f122a = new java.lang.ref.WeakReference(alertDialog);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.widget.TextView$OnEditorActionListener
    public boolean onEditorAction(android.widget.TextView textView, int i, android.view.KeyEvent keyEvent) {
        android.widget.Button button;
        boolean z = false;
        if (i != 6 && i != 3 && i != 4 && i != 2) {
            return false;
        }
        android.app.AlertDialog alertDialog = (android.app.AlertDialog) this.f122a.get();
        if ((alertDialog instanceof android.app.AlertDialog) && (button = alertDialog.getButton(-1)) != null && button.getVisibility() == 0) {
            android.ext.Tools.s(button);
            z = true;
        }
        if (!z && (alertDialog instanceof android.content.DialogInterface.OnClickListener)) {
            ((android.content.DialogInterface.OnClickListener) alertDialog).onClick(null, -1);
            z = true;
        }
        if (z || !(alertDialog instanceof android.view.View.OnClickListener)) {
            return z;
        }
        ((android.view.View.OnClickListener) alertDialog).onClick(textView);
        return true;
    }
}

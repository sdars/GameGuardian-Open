package android.ext;

/* JADX INFO: loaded from: classes.dex */
class EditorListener$b$a implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditorListener$b f131a;

    EditorListener$b$a(android.ext.EditorListener$b editorListener$b) {
        this.f131a = editorListener$b;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.EditorListener$b editorListener$b = this.f131a;
        editorListener$b.f129f = i;
        editorListener$b.b(null);
    }
}

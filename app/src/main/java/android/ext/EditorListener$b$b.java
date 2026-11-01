package android.ext;

/* JADX INFO: loaded from: classes.dex */
class EditorListener$b$b implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.EditorListener$b f132a;

    EditorListener$b$b(android.ext.EditorListener$b editorListener$b) {
        this.f132a = editorListener$b;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.EditorListener$b editorListener$b = this.f132a;
        editorListener$b.f130g = i;
        editorListener$b.b(null);
    }
}

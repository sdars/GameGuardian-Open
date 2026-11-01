package android.ext;

/* JADX INFO: loaded from: classes.dex */
class EditorListener$b$c implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.c f133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ android.ext.EditorListener$b f134b;

    EditorListener$b$c(android.ext.EditorListener$b editorListener$b, android.ext.c cVar) {
        this.f134b = editorListener$b;
        this.f133a = cVar;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        android.ext.c cVar = this.f133a;
        cVar.f674c = i;
        this.f134b.d(cVar);
    }
}

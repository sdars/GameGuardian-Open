package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class o1$c extends android.ext.p1 implements android.view.View.OnLongClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final android.ext.o1 f1157f;

    public o1$c(android.ext.o1 o1Var) {
        super(catch_.me_.if_.you_.can_.R.string.forward, catch_.me_.if_.you_.can_.R.drawable.ic_history_forward_24dp);
        this.f1157f = o1Var;
    }

    @Override // android.ext.p1
    public android.widget.ImageView b(boolean z) {
        android.widget.ImageView imageViewB = super.b(z);
        imageViewB.setOnLongClickListener(this);
        return imageViewB;
    }

    @Override // android.ext.p1, android.view.View$OnClickListener
    public void onClick(android.view.View view) {
        this.f1157f.e();
    }

    @Override // android.view.View$OnLongClickListener
    public boolean onLongClick(android.view.View view) {
        this.f1157f.d();
        return true;
    }
}

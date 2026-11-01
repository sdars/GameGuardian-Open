package gg_a;

/* JADX INFO: loaded from: classes.dex */
public class c$a extends android.content.ContextWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    android.content.Context f15a;

    public c$a(android.content.Context context) {
        super(context);
        this.f15a = context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.Object getSystemService(java.lang.String str) {
        if ("audio".equals(str)) {
            return null;
        }
        return this.f15a.getSystemService(str);
    }
}

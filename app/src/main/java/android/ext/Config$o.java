package android.ext;

/* JADX INFO: loaded from: classes.dex */
public class Config$o extends android.content.ContextWrapper {
    public Config$o(android.content.Context context) {
        super(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String getOpPackageName() {
        android.ext.e1.d("Use 2 " + android.ext.Config.E + " instead of " + getBaseContext().getPackageName());
        return android.ext.Config.E;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public java.lang.String getPackageName() {
        android.ext.e1.d("Use 1 " + android.ext.Config.E + " instead of " + getBaseContext().getPackageName());
        return android.ext.Config.E;
    }
}

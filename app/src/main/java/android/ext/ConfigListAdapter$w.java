package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$w implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f100a;

    ConfigListAdapter$w(android.ext.ConfigListAdapter configListAdapter) {
        this.f100a = configListAdapter;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("GG: ");
        float f2 = 1;
        sb.append((113.9f * f2) - 12.5f);
        sb.append(" (");
        sb.append((int) (((f2 * 16694.6f) - 539.6f) + 0.5f));
        sb.append("); Android: ");
        sb.append(android.os.Build.VERSION.RELEASE);
        sb.append(" (");
        sb.append(android.os.Build.VERSION.SDK_INT);
        sb.append(") [");
        sb.append(android.ext.f1.x());
        sb.append(']');
        android.ext.Tools.A(sb.toString(), false);
    }
}

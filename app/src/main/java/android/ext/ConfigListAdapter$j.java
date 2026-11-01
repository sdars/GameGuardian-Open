package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$j extends android.ext.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f70a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigListAdapter$j(android.ext.ConfigListAdapter configListAdapter, java.lang.String str) {
        super(str);
        this.f70a = configListAdapter;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        android.ext.Tools.K1("Logcat: " + android.ext.b2.f(catch_.me_.if_.you_.can_.R.string.loading), 0);
        android.ext.Tools.h(new java.util.GregorianCalendar().getTime().toString() + '\n' + android.ext.h0.f(true), 3);
    }
}

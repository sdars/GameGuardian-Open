package android.ext;

/* JADX INFO: loaded from: classes.dex */
class ConfigListAdapter$a extends android.ext.g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.ConfigListAdapter f54a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigListAdapter$a(android.ext.ConfigListAdapter configListAdapter, java.lang.String str) {
        super(str);
        this.f54a = configListAdapter;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.net.URL(android.ext.Tools.removeNewLinesChars("kwws=22jdphjxdugldq1qhw2yhuvlrq1w{w")).openStream()));
            while (true) {
                java.lang.String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append('\n');
            }
            bufferedReader.close();
        } catch (java.lang.Throwable th) {
            android.ext.e1.l("Load changelog", th);
            sb.append(th.toString());
        }
        android.ext.n2.i(new android.ext.ConfigListAdapter$a$a(this, sb));
    }
}

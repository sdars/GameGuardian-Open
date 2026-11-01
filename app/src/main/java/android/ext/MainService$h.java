package android.ext;

/* JADX INFO: loaded from: classes.dex */
class MainService$h implements android.widget.TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.MainService f246a;

    MainService$h(android.ext.MainService mainService) {
        this.f246a = mainService;
    }

    @Override // android.widget.TabHost$OnTabChangeListener
    public void onTabChanged(java.lang.String str) {
        android.ext.MainService mainService = android.ext.MainService.instance;
        int iH = mainService.H();
        mainService.r.setVisibility(iH >= 1 ? 0 : 8);
        mainService.s.setVisibility(iH != 3 ? 0 : 8);
        mainService.z.setVisibility(iH == 1 ? 0 : 8);
        mainService.v.setVisibility(iH == 3 ? 0 : 8);
        mainService.w.setVisibility(iH == 2 ? 0 : 8);
        mainService.q1();
        mainService.f0 = mainService.m.getCurrentView();
        android.ext.Tools.s(mainService.P);
        mainService.p1();
        android.ext.ConfigListAdapter configListAdapter = this.f246a.x0;
        if (configListAdapter != null) {
            configListAdapter.l(iH == 0);
        }
    }
}

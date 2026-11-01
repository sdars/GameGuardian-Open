package android.ext;

/* JADX INFO: loaded from: classes.dex */
class TimeJumpPanel$a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.ext.TimeJumpPanel f480a;

    TimeJumpPanel$a(android.ext.TimeJumpPanel timeJumpPanel) {
        this.f480a = timeJumpPanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.ext.TimeJumpPanel timeJumpPanel = this.f480a;
        timeJumpPanel.p = (android.widget.Button) timeJumpPanel.findViewById(catch_.me_.if_.you_.can_.R.id.time_jump_last);
        android.ext.TimeJumpPanel timeJumpPanel2 = this.f480a;
        timeJumpPanel2.q = (android.widget.Button) timeJumpPanel2.findViewById(catch_.me_.if_.you_.can_.R.id.time_jump);
        android.ext.TimeJumpPanel timeJumpPanel3 = this.f480a;
        timeJumpPanel3.p.setOnClickListener(timeJumpPanel3);
        android.ext.TimeJumpPanel timeJumpPanel4 = this.f480a;
        timeJumpPanel4.q.setOnClickListener(timeJumpPanel4);
        this.f480a.r();
        android.ext.HotPoint hotPoint = android.ext.MainService.instance.j;
        this.f480a.setLayoutAlpha(hotPoint.getLayoutAlpha());
        this.f480a.setMinSize(hotPoint.getSizePx());
    }
}
